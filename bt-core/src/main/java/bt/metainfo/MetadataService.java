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

package bt.metainfo;

import bt.BtException;
import bt.bencoding.BEParser;
import bt.bencoding.BEType;
import bt.bencoding.model.BEList;
import bt.bencoding.model.BEMap;
import bt.bencoding.model.BEObject;
import bt.bencoding.model.BEObjectModel;
import bt.bencoding.model.BEString;
import bt.bencoding.model.ValidationResult;
import bt.bencoding.model.YamlBEObjectModelLoader;
import bt.service.CryptoUtil;
import bt.tracker.AnnounceKey;
import core.CodeCoverage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.URL;
import java.nio.charset.Charset;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *<p><b>Note that this class implements a service.
 * Hence, is not a part of the public API and is a subject to change.</b></p>
 */
public class MetadataService implements IMetadataService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MetadataService.class);

    private static final String ANNOUNCE_KEY = "announce";
    private static final String ANNOUNCE_LIST_KEY = "announce-list";
    private static final String INFOMAP_KEY = "info";
    private static final String TORRENT_NAME_KEY = "name";
    private static final String CHUNK_SIZE_KEY = "piece length";
    private static final String CHUNK_HASHES_KEY = "pieces";
    private static final String TORRENT_SIZE_KEY = "length";
    private static final String FILES_KEY = "files";
    private static final String FILE_SIZE_KEY = "length";
    private static final String FILE_PATH_ELEMENTS_KEY = "path";
    private static final String PRIVATE_KEY = "private";
    private static final String CREATION_DATE_KEY = "creation date";
    private static final String CREATED_BY_KEY = "created by";

    private BEObjectModel torrentModel;
    private BEObjectModel infodictModel;
    private Charset defaultCharset;

    public MetadataService() {
        this.defaultCharset = Charset.forName("UTF-8");

        try {
            try (InputStream in = MetadataService.class.getResourceAsStream("/metainfo.yml")) {
                this.torrentModel = new YamlBEObjectModelLoader().load(in);
            }
            try (InputStream in = MetadataService.class.getResourceAsStream("/infodict.yml")) {
                this.infodictModel = new YamlBEObjectModelLoader().load(in);
            }
        } catch (IOException e) {
            throw new BtException("Failed to create metadata service", e);
        }
    }

    @Override
    public Torrent fromUrl(URL url) {
        try (BEParser parser = new BEParser(url)) {
            return buildTorrent(parser);
        }
    }

    @Override
    public Torrent fromInputStream(InputStream in) {
        try (BEParser parser = new BEParser(in)) {
            return buildTorrent(parser);
        }
    }

    @Override
    public Torrent fromByteArray(byte[] bs) {
        try (BEParser parser = new BEParser(bs)) {
            return buildTorrent(parser);
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private Torrent buildTorrent(BEParser parser) {
    	CodeCoverage cc = new CodeCoverage("MetadataService_buildTorrent");
        if (parser.readType() != BEType.MAP) {
        	System.out.println("#CC# buildTorrent ID:1");
        	cc.writeToFile("callFinished");
            throw new BtException("Invalid metainfo format -- expected a map, got: "
                    + parser.readType().name().toLowerCase());
        } else {
        	System.out.println("#CC# buildTorrent ID:2");
        }

        BEMap metadata = parser.readMap();

        ValidationResult validationResult = torrentModel.validate(metadata);;
        if (!validationResult.isSuccess()) {
        	System.out.println("#CC# buildTorrent ID:3");
            ValidationResult infodictValidationResult = infodictModel.validate(metadata);
            if (!infodictValidationResult.isSuccess()) {
            	System.out.println("#CC# buildTorrent ID:4");
            	cc.writeToFile("callFinished");
                throw new BtException("Validation failed for torrent metainfo:\n1. Standard torrent model: "
                    + Arrays.toString(validationResult.getMessages().toArray())
                        + "\n2. Standalone info dictionary model: " + Arrays.toString(infodictValidationResult.getMessages().toArray()));
            } else {
            	System.out.println("#CC# buildTorrent ID:5");
            }
        } else {
        	System.out.println("#CC# buildTorrent ID:6");
        }

        BEMap infoDictionary;
        TorrentSource source;

        Map<String, BEObject<?>> root = metadata.getValue();
        if (root.containsKey(INFOMAP_KEY)) {
        	System.out.println("#CC# buildTorrent ID:7");
            // standard BEP-3 format
            infoDictionary = (BEMap) root.get(INFOMAP_KEY);
            source = new TorrentSource() {
                @Override
                public Optional<byte[]> getMetadata() {
                    return Optional.of(metadata.getContent());
                }

                @Override
                public byte[] getExchangedMetadata() {
                    return infoDictionary.getContent();
                }
            };
        } else {
        	System.out.println("#CC# buildTorrent ID:8");
            // BEP-9 exchanged metadata (just the info dictionary)
            infoDictionary = metadata;
            source = new TorrentSource() {
                @Override
                public Optional<byte[]> getMetadata() {
                    return Optional.empty();
                }

                @Override
                public byte[] getExchangedMetadata() {
                    return infoDictionary.getContent();
                }
            };
        }

        DefaultTorrent torrent = new DefaultTorrent(source);

        try {
        	System.out.println("#CC# buildTorrent ID:9");
            torrent.setTorrentId(TorrentId.fromBytes(CryptoUtil.getSha1Digest(infoDictionary.getContent())));

            Map<String, BEObject<?>> infoMap = infoDictionary.getValue();

            if (infoMap.get(TORRENT_NAME_KEY) != null) {
            	System.out.println("#CC# buildTorrent ID:10");
                byte[] name = (byte[]) infoMap.get(TORRENT_NAME_KEY).getValue();
                torrent.setName(new String(name, defaultCharset));
            } else {
            	System.out.println("#CC# buildTorrent ID:11");
            }

            BigInteger chunkSize = (BigInteger) infoMap.get(CHUNK_SIZE_KEY).getValue();
            torrent.setChunkSize(chunkSize.longValueExact());

            byte[] chunkHashes = (byte[]) infoMap.get(CHUNK_HASHES_KEY).getValue();
            torrent.setChunkHashes(chunkHashes);

            if (infoMap.get(TORRENT_SIZE_KEY) != null) {
            	System.out.println("#CC# buildTorrent ID:12");
                BigInteger torrentSize = (BigInteger) infoMap.get(TORRENT_SIZE_KEY).getValue();
                torrent.setSize(torrentSize.longValueExact());

            } else {
            	System.out.println("#CC# buildTorrent ID:13");
                List<BEMap> files = (List<BEMap>) infoMap.get(FILES_KEY).getValue();
                List<TorrentFile> torrentFiles = new ArrayList<>(files.size() + 1);
                BigInteger torrentSize = BigInteger.ZERO;
                for (BEMap file : files) {
                	System.out.println("#CC# buildTorrent ID:14");
                    Map<String, BEObject<?>> fileMap = file.getValue();
                    DefaultTorrentFile torrentFile = new DefaultTorrentFile();

                    BigInteger fileSize = (BigInteger) fileMap.get(FILE_SIZE_KEY).getValue();
                    torrentFile.setSize(fileSize.longValueExact());
                    torrentSize = torrentSize.add(fileSize);

                    List<BEString> pathElements = (List<BEString>) fileMap.get(FILE_PATH_ELEMENTS_KEY).getValue();

                    torrentFile.setPathElements(pathElements.stream()
                            .map(bytes -> bytes.getValue(defaultCharset))
                            .collect(Collectors.toList()));

                    torrentFiles.add(torrentFile);
                }
                torrent.setFiles(torrentFiles);
                torrent.setSize(torrentSize.longValueExact());
            }

            boolean isPrivate = false;
            if (infoMap.get(PRIVATE_KEY) != null) {
            	System.out.println("#CC# buildTorrent ID:15");
                if (BigInteger.ONE.equals(infoMap.get(PRIVATE_KEY).getValue())) {
                	System.out.println("#CC# buildTorrent ID:16");
                    torrent.setPrivate(true);
                    isPrivate = true;
                } else {
                	System.out.println("#CC# buildTorrent ID:17");
                }
            } else {
            	System.out.println("#CC# buildTorrent ID:18");
            }

            if (root.get(CREATION_DATE_KEY) != null) {
            	System.out.println("#CC# buildTorrent ID:19");
                BigInteger epochMilli = (BigInteger) root.get(CREATION_DATE_KEY).getValue();
                // TODO: some torrents contain bogus values here (like 101010101010), which causes an exception
                torrent.setCreationDate(Instant.ofEpochMilli(epochMilli.intValueExact() * 1000L));
            } else {
            	System.out.println("#CC# buildTorrent ID:20");
            }

            if (root.get(CREATED_BY_KEY) != null) {
            	System.out.println("#CC# buildTorrent ID:21");
                byte[] createdBy = (byte[]) root.get(CREATED_BY_KEY).getValue();
                torrent.setCreatedBy(new String(createdBy, defaultCharset));
            } else {
            	System.out.println("#CC# buildTorrent ID:22");
            }

            AnnounceKey announceKey = null;
            // TODO: support for private torrents with multiple trackers
            if (!isPrivate && root.containsKey(ANNOUNCE_LIST_KEY)) {
            	System.out.println("#CC# buildTorrent ID:23");
                List<List<String>> trackerUrls;

                BEList announceList = (BEList) root.get(ANNOUNCE_LIST_KEY);
                List<BEList> tierList = (List<BEList>) announceList.getValue();
                trackerUrls = new ArrayList<>(tierList.size() + 1);
                for (BEList tierElement : tierList) {
                	System.out.println("#CC# buildTorrent ID:24");
                    List<String> tierTackerUrls;

                    List<BEString> trackerUrlList = (List<BEString>) tierElement.getValue();
                    tierTackerUrls = new ArrayList<>(trackerUrlList.size() + 1);
                    for (BEString trackerUrlElement : trackerUrlList) {
                        tierTackerUrls.add(trackerUrlElement.getValue(defaultCharset));
                    }
                    trackerUrls.add(tierTackerUrls);
                }
                announceKey = new AnnounceKey(trackerUrls);

            } else if (root.containsKey(ANNOUNCE_KEY)) {
            	System.out.println("#CC# buildTorrent ID:25");
                byte[] trackerUrl = (byte[]) root.get(ANNOUNCE_KEY).getValue();
                announceKey = new AnnounceKey(new String(trackerUrl, defaultCharset));
            }

            if (announceKey != null) {
            	System.out.println("#CC# buildTorrent ID:26");
                torrent.setAnnounceKey(announceKey);
            } else {
            	System.out.println("#CC# buildTorrent ID:27");
            }

        } catch (Exception e) {
        	System.out.println("#CC# buildTorrent ID:28");
            throw new BtException("Invalid metainfo format", e);
        }

        cc.writeToFile("callFinished");
        return torrent;
    }
}
