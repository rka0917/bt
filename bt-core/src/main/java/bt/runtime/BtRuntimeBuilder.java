/*
 * Copyright (c) 2016—2017 Andrei Tomashpolskiy and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package bt.runtime;

import bt.BtException;
import bt.module.BtModuleProvider;
import bt.module.ProtocolModule;
import bt.module.ServiceModule;
import bt.peer.lan.LocalServiceDiscoveryModule;
import bt.peerexchange.PeerExchangeModule;
import core.CodeCoverage;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

/**
 * Runtime builder.
 *
 * @since 1.0
 */
public class BtRuntimeBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(BtRuntimeBuilder.class);

    private Config config;
    private Collection<BtModuleProvider> customProviders;

    private boolean shouldDisableAutomaticShutdown;
    private boolean shouldAutoLoadModules;
    private boolean shouldDisableStandardExtensions;

    /**
     * Create runtime builder with default config.
     *
     * @since 1.4
     */
    public BtRuntimeBuilder() {
        this.config = new Config();
    }

    /**
     * Create runtime builder with provided config.
     *
     * @param config Runtime config
     * @since 1.0
     */
    public BtRuntimeBuilder(Config config) {
        this.config = Objects.requireNonNull(config, "Missing runtime config");
    }

    /**
     * Set runtime config.
     *
     * @since 1.4
     */
    public BtRuntimeBuilder config(Config config) {
        this.config = Objects.requireNonNull(config, "Missing runtime config");
        return this;
    }

    /**
     * Get this builder's config.
     *
     * @return Runtime config
     * @since 1.0
     */
    public Config getConfig() {
        return config;
    }

    /**
     * Contribute an extra module into the runtime.
     *
     * @since 1.0
     */
    public BtRuntimeBuilder module(Module adapter) {
        Objects.requireNonNull(adapter);
        if (customProviders == null) {
            customProviders = new ArrayList<>();
        }
        customProviders.add(() -> adapter);
        return this;
    }

    /**
     * Contribute an extra module into the runtime.
     *
     * @since 1.1
     */
    public BtRuntimeBuilder module(Class<? extends Module> adapterType) {
        Objects.requireNonNull(adapterType);
        if (customProviders == null) {
            customProviders = new ArrayList<>();
        }
        customProviders.add(() -> {
            try {
                return adapterType.newInstance();
            } catch (Exception e) {
                throw new BtException("Failed to instantiate custom module: " + adapterType.getName(), e);
            }
        });
        return this;
    }

    /**
     * Disable automatic runtime shutdown, when all clients have been stopped.
     *
     * @since 1.0
     */
    public BtRuntimeBuilder disableAutomaticShutdown() {
        this.shouldDisableAutomaticShutdown = true;
        return this;
    }

    /**
     * If this option is set, Bt will use the service loading mechanism
     * to load any modules that are available on application's classpath.
     *
     * To support auto-loading a module should expose {@link BtModuleProvider} provider.
     * Auto-loaded modules will be used in default configuration.
     *
     * @since 1.1
     */
    public BtRuntimeBuilder autoLoadModules() {
        this.shouldAutoLoadModules = true;
        return this;
    }

    /**
     * If this options is set, Bt will not automatically load standard extensions, such as PEX or LSD.
     * May be used to selectively enable only a subset of standard extensions.
     *
     * @since 1.6
     */
    public BtRuntimeBuilder disableStandardExtensions() {
        this.shouldDisableStandardExtensions = true;
        return this;
    }

    /**
     * @since 1.0
     */
    public BtRuntime build() {
        Injector injector = createInjector();
        Config config = Objects.requireNonNull(injector.getInstance(Config.class), "Missing config binding");
        BtRuntime runtime = new BtRuntime(injector, config);
        if (shouldDisableAutomaticShutdown) {
            runtime.disableAutomaticShutdown();
        }
        return runtime;
    }

    @SuppressWarnings("unchecked")
    private Injector createInjector() {
    	CodeCoverage cc = new CodeCoverage("BtRuntimeBuilder_createInjector.txt");
        Map<Class<? extends Module>, Module> standardModules = mapByClass(collectModules(standardProviders()));

        Map<Class<? extends Module>, Module> standardExtensions;
        if (shouldDisableStandardExtensions) {
            standardExtensions = new HashMap<>();
            System.out.println("#CC# 1");
        } else {
            standardExtensions = mapByClass(collectModules(standardExtensionProviders()));
            System.out.println("#CC# 2");
        }

        Map<Class<? extends Module>, Module> autoLoadedModules;
        if (shouldAutoLoadModules) {
            autoLoadedModules = mapByClass(collectModules(autoLoadedProviders()));
            System.out.println("#CC# 3");
        } else {
            autoLoadedModules = new HashMap<>();
            System.out.println("#CC# 4");
        }

        Map<Class<? extends Module>, Module> customModules = mapByClass(collectModules(customProviders()));

        standardExtensions.forEach((k, v) -> {
            if (!autoLoadedModules.containsKey(k) && !customModules.containsKey(k)) {
                LOGGER.info("Loading standard extension module {}", k.getName());
                System.out.println("#CC# 5");
            }
            else System.out.println("#CC# 6");
        });

        customModules.forEach((k, v) -> {
            boolean overridesStandardModule = standardModules.containsKey(k);
            boolean overridesStandardExtension = standardExtensions.containsKey(k);
            if (autoLoadedModules.containsKey(k)) {
                LOGGER.info("Overriding auto-loaded module {}", k.getName());
                System.out.println("#CC# 7");
            } else if (overridesStandardModule || overridesStandardExtension) {
                LOGGER.info("Overriding standard " + (overridesStandardModule ? "module" : "extension") + " {}", k.getName());
                System.out.println("#CC# 8");
            } else {
                LOGGER.info("Loading module {}", k.getName());
                System.out.println("#CC# 9");
            }
        });

        autoLoadedModules.forEach((k, v) -> {
            boolean overridesStandardModule = standardModules.containsKey(k);
            boolean overridesStandardExtension = standardExtensions.containsKey(k);
            boolean overridenByCustomModule = customModules.containsKey(k);
            if (!overridenByCustomModule) {
            	System.out.println("#CC# 10");
                if (overridesStandardModule || overridesStandardExtension) {
                    // don't log if there is a custom module, that will override the auto-loaded version
                    LOGGER.info("Overriding standard " + (overridesStandardModule ? "module" : "extension") +
                            " {} with auto-loaded version", k.getName());
                    System.out.println("#CC# 11");
                } else {
                    LOGGER.info("Auto-loading module {} with default configuration", k.getName());
                    System.out.println("#CC# 12");
                }
            }
            else System.out.println("#CC# 13");
        });
        
        cc.writeToFile("createInjector");

        return createInjector(
                standardModules,
                standardExtensions,
                autoLoadedModules,
                customModules);
    }

    private Injector createInjector(
            Map<Class<? extends Module>, Module> standardModules,
            Map<Class<? extends Module>, Module> standardExtensions,
            Map<Class<? extends Module>, Module> autoLoadedModules,
            Map<Class<? extends Module>, Module> customModules) {

        Module combinedModule = Arrays.asList(standardModules, standardExtensions, autoLoadedModules, customModules)
                .stream().sequential()
                .filter(map -> !map.isEmpty())
                .map(map -> Modules.combine(map.values()))
                .reduce(null, (m1, m2) -> (m1 == null) ? m2 : Modules.override(m1).with(m2));

        return Guice.createInjector(combinedModule);
    }

    @SuppressWarnings("unchecked")
    private Collection<Module> collectModules(Collection<BtModuleProvider>... providers) {
        return Arrays.asList(providers).stream()
                .flatMap(Collection::stream)
                .map(BtModuleProvider::module)
                .collect(Collectors.toList());
    }

    @SuppressWarnings("unchecked")
    private <T> Map<Class<? extends T>, T> mapByClass(Collection<T> collection) {
        return collection.stream().collect(HashMap::new, (m, o) -> {
            Class<T> moduleType = (Class<T>) o.getClass();
            if (m.containsKey(moduleType)) {
                throw new IllegalStateException("Duplicate module: " + moduleType.getName());
            }
            m.put(moduleType, o);
        }, Map::putAll);
    }

    private Collection<BtModuleProvider> standardProviders() {
        Collection<BtModuleProvider> standardProviders = new ArrayList<>();
        standardProviders.add(() -> new ServiceModule(config));
        standardProviders.add(ProtocolModule::new);
        return standardProviders;
    }

    private Collection<BtModuleProvider> standardExtensionProviders() {
        Collection<BtModuleProvider> standardExtensionProviders = new ArrayList<>();
        standardExtensionProviders.add(PeerExchangeModule::new);
        standardExtensionProviders.add(LocalServiceDiscoveryModule::new);
        return standardExtensionProviders;
    }

    private Collection<BtModuleProvider> customProviders() {
        if (customProviders == null) {
            return Collections.emptyList();
        } else {
            return customProviders.stream()
                    .map(BtRuntimeBuilder::nullCheckingProvider)
                    .collect(Collectors.toList());
        }
    }

    private Collection<BtModuleProvider> autoLoadedProviders() {
        Collection<BtModuleProvider> autoLoadedProviders = new ArrayList<>();
        ServiceLoader.load(BtModuleProvider.class).forEach(p -> {
            autoLoadedProviders.add(nullCheckingProvider(p));
        });
        return autoLoadedProviders;
    }

    private static BtModuleProvider nullCheckingProvider(BtModuleProvider provider) {
        return () -> Objects.requireNonNull(provider.module(), "Missing module in provider:" + provider.getClass().getName());
    }
}
