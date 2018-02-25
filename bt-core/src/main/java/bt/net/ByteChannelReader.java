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

package bt.net;

import bt.net.buffer.Buffers;
import core.CodeCoverage;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.time.Duration;
import java.util.Objects;
import java.util.Optional;

public class ByteChannelReader {

    private final ReadableByteChannel channel;
    private final Optional<Duration> timeout;
    private final Optional<Duration> waitBetweenReads;
    private final int min;
    private final int limit;

    public static ByteChannelReader forChannel(ReadableByteChannel channel) {
        return new ByteChannelReader(channel, Optional.empty(), Optional.empty(), 0, Integer.MAX_VALUE);
    }

    public ByteChannelReader withTimeout(Duration timeout) {
        return new ByteChannelReader(channel, Optional.of(timeout), waitBetweenReads, min, limit);
    }

    public ByteChannelReader waitBetweenReads(Duration waitBetweenReads) {
        return new ByteChannelReader(channel, timeout, Optional.of(waitBetweenReads), min, limit);
    }

    public ByteChannelReader readExactly(int bytes) {
        return new ByteChannelReader(channel, timeout, waitBetweenReads, bytes, bytes);
    }

    public ByteChannelReader readAtLeast(int minBytes) {
        return new ByteChannelReader(channel, timeout, waitBetweenReads, minBytes, limit);
    }

    public ByteChannelReader readNoMoreThan(int maxBytes) {
        return new ByteChannelReader(channel, timeout, waitBetweenReads, min, maxBytes);
    }

    public ByteChannelReader readBetween(int minBytes, int maxBytes) {
        return new ByteChannelReader(channel, timeout, waitBetweenReads, minBytes, maxBytes);
    }

    private ByteChannelReader(ReadableByteChannel channel,
                              Optional<Duration> timeout,
                              Optional<Duration> waitBetweenReads,
                              int min,
                              int limit) {
        if (min < 0 || limit < 0 || limit < min) {
            throw new IllegalArgumentException("Illegal arguments: min (" + min + "), limit (" + limit + ")");
        }
        this.channel = Objects.requireNonNull(channel);
        this.timeout = timeout;
        this.waitBetweenReads = waitBetweenReads;
        this.min = min;
        this.limit = limit;
    }

    public int sync(ByteBuffer buf, byte[] syncToken) throws IOException {
    	CodeCoverage cc = new CodeCoverage("ByteChannelReader_sync");
        ensureSufficientSpace(buf);
        if (syncToken.length == 0) {
        	//TODO Add logging
        	System.out.println("#CC# Sync ID:1");
        	cc.writeToFile("callFinished");
            throw new IllegalArgumentException("Empty synchronization token");
        } else {
        	//TODO Add logging
        	System.out.println("#CC# Sync ID:2");
        }
        
        int searchpos = buf.position(), origlim = buf.limit();
        boolean found = false;
        int matchpos = -1;
        long t1 = System.currentTimeMillis();
        int readTotal = 0;
        int read;
        long timeoutMillis = getTimeoutMillis();
        long waitBetweenReadsMillis = getWaitBetweenReadsMillis();
        boolean visited = false;
        do {
        	if(visited) {
        		System.out.println("#CC# Sync ID:3");
        	}
        	visited = true;
            read = channel.read(buf);
            if (read < 0) {
            	//TODO Add logging
            	System.out.println("#CC# Sync ID:4");
            	cc.writeToFile("callFinished");
                throw new RuntimeException("Received EOF, total bytes read: " + readTotal + ", expected: " + min + ".." + limit);
            } else if (read > 0) {
            	//TODO Add logging
            	System.out.println("#CC# Sync ID:5");
                readTotal += read;
                if (readTotal > limit) {
                	//TODO Add logging
                	System.out.println("#CC# Sync ID:6");
                	cc.writeToFile("callFinished");
                    throw new IllegalStateException("More than " + limit + " bytes received: " + readTotal);
                } else {
                	//TODO Add logging
                	System.out.println("#CC# Sync ID:7");
                }
                if (!found) {
                	//TODO Add logging
                	System.out.println("#CC# Sync ID:8");
                    int pos = buf.position();
                    buf.flip();
                    buf.position(searchpos);
                    if (buf.remaining() >= syncToken.length) {
                    	//TODO Add logging
                    	System.out.println("#CC# Sync ID:9");
                        if (Buffers.searchPattern(buf, syncToken)) {
                        	//TODO Add logging
                        	System.out.println("#CC# Sync ID:10");
                            found = true;
                            matchpos = buf.position();
                        } else {
                        	//TODO Add logging
                        	System.out.println("#CC# Sync ID:11");
                            searchpos = pos - syncToken.length + 1;
                        }
                    } else {
                    	//TODO Add logging
                    	System.out.println("#CC# Sync ID:12");
                    }
                    buf.limit(origlim);
                    buf.position(pos);
                } else {
                	//TODO Add logging
                	System.out.println("#CC# Sync ID:13");
                }
            }
            if (found && min > 0 && readTotal >= min) {
            	//TODO Add logging
            	System.out.println("#CC# Sync ID:14");
                break;
            }
            if (waitBetweenReadsMillis > 0) {
            	//TODO Add logging
            	System.out.println("#CC# Sync ID:15");
                try {
                	//TODO Add logging
                	System.out.println("#CC# Sync ID:16");
                    Thread.sleep(waitBetweenReadsMillis);
                } catch (InterruptedException e) {
                	//TODO Add logging
                	System.out.println("#CC# Sync ID:17");
                	cc.writeToFile("callFinished");
                    throw new RuntimeException("Interrupted while waiting for data", e);
                }
            }
        } while (timeoutMillis == 0 || (System.currentTimeMillis() - t1 <= timeoutMillis));
        System.out.println("#CC# Sync ID:18");
        if (readTotal < min) {
        	//TODO Add logging
        	System.out.println("#CC# Sync ID:19");
        	cc.writeToFile("callFinished");
            throw new IllegalStateException("Less than " + min + " bytes received: " + readTotal);
        } else if (!found) {
        	//TODO Add logging
        	System.out.println("#CC# Sync ID:20");
        	cc.writeToFile("callFinished");
            throw new IllegalStateException("Failed to synchronize: expected " + min + ".." + limit + ", received " + readTotal);
        }

        buf.position(matchpos);
        cc.writeToFile("callFinished");
        return readTotal;
    }

    public int read(ByteBuffer buf) throws IOException {
        ensureSufficientSpace(buf);

        long t1 = System.currentTimeMillis();
        int readTotal = 0;
        int read;
        long timeoutMillis = getTimeoutMillis();
        long waitBetweenReadsMillis = getWaitBetweenReadsMillis();
        do {
            read = channel.read(buf);
            if (read < 0) {
                throw new RuntimeException("Received EOF, total bytes read: " + readTotal + ", expected: " + min + ".." + limit);
            } else {
                readTotal += read;
            }
            if (readTotal > limit) {
                throw new IllegalStateException("More than " + limit + " bytes received: " + readTotal);
            } else if (min > 0 && readTotal >= min) {
                break;
            }
            if (waitBetweenReadsMillis > 0) {
                try {
                    Thread.sleep(waitBetweenReadsMillis);
                } catch (InterruptedException e) {
                    throw new RuntimeException("Interrupted while waiting for data", e);
                }
            }
        } while ((min > 0 && timeoutMillis == 0) || (System.currentTimeMillis() - t1 <= timeoutMillis));

        if (readTotal < min) {
            throw new IllegalStateException("Less than " + min + " bytes received: " + readTotal);
        }

        return readTotal;
    }

    private long getTimeoutMillis() {
        return timeout.isPresent()? timeout.get().toMillis() : 0;
    }

    private long getWaitBetweenReadsMillis() {
        return waitBetweenReads.isPresent()? waitBetweenReads.get().toMillis() : 0;
    }

    private void ensureSufficientSpace(ByteBuffer buf) {
        if (buf.remaining() < min) {
            throw new IllegalArgumentException("Insufficient space in buffer: " + buf.remaining() + ", required at least: " + min);
        }
    }
}
