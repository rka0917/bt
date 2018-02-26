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
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.util.Collection;
import java.util.Optional;

import org.junit.Test;

import bt.protocol.DecodingContext;
import bt.protocol.EncodingContext;
import bt.protocol.Handshake;
import bt.protocol.Message;
import bt.protocol.crypto.MSECipher;
import bt.protocol.handler.MessageHandler;
import bt.runtime.Config;

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
}
