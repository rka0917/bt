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

package bt.net.crypto;

import static org.junit.Assert.*;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.junit.Test;

import bt.data.Storage;
import bt.metainfo.Torrent;
import bt.metainfo.TorrentId;
import bt.net.BigIntegers;
import bt.protocol.DecodingContext;
import bt.protocol.EncodingContext;
import bt.protocol.Handshake;
import bt.protocol.Message;
import bt.protocol.crypto.EncryptionPolicy;
import bt.protocol.crypto.MSECipher;
import bt.protocol.handler.MessageHandler;
import bt.runtime.Config;
import bt.torrent.TorrentDescriptor;
import bt.torrent.TorrentRegistry;

import java.security.MessageDigest;

public class MSEHandshakeProcessorTest {

	@Test
	public void test_negotiateIncoming_consumed_greater_than_zero() {
		// CONTRACT: negotiateIncoming should return an empty optional if decoding was successful and it can use plaintext (if supported)

		// Fake class for testing
		class MsgHandler implements MessageHandler<Message> {
			@Override public Collection<Class<? extends Message>> getSupportedTypes() { return null; }
			@Override public Class<? extends Message> readMessageType(ByteBuffer buffer) { return null; }
			@Override public boolean encode(EncodingContext context, Message message, ByteBuffer buffer) { return false; }
			@Override
			public int decode(DecodingContext context, ByteBuffer buffer) {
				// The message should be of type Handshake
				context.setMessage(new Handshake(null, null, null));
				// Consumed should be of greater than 0
				return 1;
			}
		}

		// Fake class for testing
		class FakeChannel implements ByteChannel {
			@Override public int read(ByteBuffer dst) throws IOException {
				// Must read at least 20 bytes
				return 20;
			}
			@Override public void close() throws IOException { }
			@Override public boolean isOpen() { return false; }
			@Override public int write(ByteBuffer arg0) throws IOException { return 0; }
		}

		// Key must be at lease 16 byte
		Config config = new Config();
		config.setMsePrivateKeySize(16);

		// Instantiate a new processor with the correct values to bypas checks
		MSEHandshakeProcessor processor = new MSEHandshakeProcessor(null, new MsgHandler(), config);

		try {
			// Buffer must have at least 20 bytes of space
			ByteBuffer in = ByteBuffer.allocate(20);

			// Should return Optional.empty()
			Optional<MSECipher> result = processor.negotiateIncoming(null, new FakeChannel(), in, null);
			assertEquals(Optional.empty(), result);
		} catch (IOException e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
	
	// Fake class for testing
			class MsgHandler implements MessageHandler<Message> {
			@Override public Collection<Class<? extends Message>> getSupportedTypes() { return null; }
			@Override public Class<? extends Message> readMessageType(ByteBuffer buffer) { return null; }
			@Override public boolean encode(EncodingContext context, Message message, ByteBuffer buffer) { return false; }
			@Override
			public int decode(DecodingContext context, ByteBuffer buffer) {
				// The message should be of type Handshake
				context.setMessage(new Handshake(null, null, null));
				// Consumed should be of greater than 0
				return 0;
				}
			}

			// Fake class for testing
			class FakeChannel implements ByteChannel {
				boolean response = false;
			@Override public int read(ByteBuffer dst) throws IOException {
				if(response) {
					try {
						MessageDigest digest = MessageDigest.getInstance("SHA-1");
						 digest.update("req1".getBytes("ASCII"));
					     digest.update(BigIntegers.encodeUnsigned(new BigInteger("0"), 96));
					     dst.put(digest.digest());
					     digest.update("req3".getBytes("ASCII"));
					     digest.update(BigIntegers.encodeUnsigned(new BigInteger("0"), 96));
					     byte[] b2 = digest.digest();
					     digest.update("req2".getBytes("ASCII"));
					     byte[] bytes = new byte[20];
							for(int i = 0; i < 20; i++) {
								bytes[i] = 0;
							}
				         digest.update(bytes);
				         byte[] b1 = digest.digest();
				         dst.put(xor(b1, b2));
				         byte[] vc = new byte[8];
				         vc[0] = -31;
				         vc[1] = 118;
				         vc[2] = -93;
				         vc[3] = 13;
				         vc[4] = -110;
				         vc[5] = -114;
				         vc[6] = -11;
				         vc[7] = -37;
				         dst.put(vc);
				         //crypto provide
				         dst.put((byte)0);
				         dst.put((byte)0);
				         dst.put((byte)1);
				         dst.put((byte)1);
				         //padding
				         dst.put((byte)(0xd1));
				         dst.put((byte)(0x93));


					}catch(Exception e) {
						 throw new RuntimeException(e);
					}
				}
				// Must read at least 20 bytes
				return 96;
				}
			@Override public void close() throws IOException { }
			@Override public boolean isOpen() { return false; }
			@Override public int write(ByteBuffer arg0) throws IOException { 
				response = true;
				arg0.position(arg0.limit());
				return 1; 
			}
			private byte[] xor(byte[] b1, byte[] b2) {
		        if (b1.length != b2.length) {
		            throw new IllegalStateException("Lengths do not match: " + b1.length + ", " + b2.length);
		        }
		        byte[] result = new byte[b1.length];
		        for (int i = 0; i < b1.length; i++) {
		            result[i] = (byte) (b1[i] ^ b2[i]);
		        }
		        return result;
		    }
			}
			// Fake class for testing
			class FakeTorrent implements TorrentRegistry {
				
				@Override
				public TorrentDescriptor register(TorrentId torrentId) {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public TorrentDescriptor register(Torrent torrent, Storage storage) {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public boolean isSupportedAndActive(TorrentId torrentId) {
					// TODO Auto-generated method stub
					return false;
				}
				
				@Override
				public Collection<Torrent> getTorrents() {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public Collection<TorrentId> getTorrentIds() {
					byte[] bytes = new byte[20];
					for(int i = 0; i < 20; i++) {
						bytes[i] = 0;
					}
					TorrentId id = TorrentId.fromBytes(bytes);
					ArrayList<TorrentId> list = new ArrayList<TorrentId>();
					list.add(id);
					return list ;
				}
				
				@Override
				public Optional<Torrent> getTorrent(TorrentId torrentId) {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public TorrentDescriptor getOrCreateDescriptor(Torrent torrent, Storage storage) {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public Optional<TorrentDescriptor> getDescriptor(TorrentId torrentId) {
					// TODO Auto-generated method stub
					return Optional.empty();
				}
				
				@Override
				public Optional<TorrentDescriptor> getDescriptor(Torrent torrent) {
					// TODO Auto-generated method stub
					return null;
				}
			};
			
	@Test 
	public void test_negotiateIncoming_EncryptionPolicy_PREFER_PLAINTEXT() {
		//Contract: if the encryption policy is PREFER_PLAINTEXTE it should return Optional.empty
		
		// Key must be at lease 16 byte
		Config config = new Config();
		config.setMsePrivateKeySize(16);
		config.setEncryptionPolicy(EncryptionPolicy.PREFER_PLAINTEXT);

		// Instantiate a new processor with the correct values to bypas checks
		MSEHandshakeProcessor processor = new MSEHandshakeProcessor(new FakeTorrent(), new MsgHandler(), config);

		try {
			// Buffer must have at least 96 bytes of space
			ByteBuffer in = ByteBuffer.allocate(100);
			ByteBuffer out = ByteBuffer.allocate(1000);
			// Should return Optional.empty()
			Optional<MSECipher> result = processor.negotiateIncoming(null, new FakeChannel(), in, out);
			assertEquals(Optional.empty(), result);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
	}
}
