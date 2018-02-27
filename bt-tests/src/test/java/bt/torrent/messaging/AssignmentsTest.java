package bt.torrent.messaging;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.Test;

import bt.data.Bitfield;
import bt.net.Peer;
import bt.net.PeerId;
import bt.peer.PeerOptions;
import bt.runtime.Config;
import bt.torrent.BitfieldBasedStatistics;
import bt.torrent.PieceStatistics;
import bt.torrent.selector.PieceSelector;

public class AssignmentsTest {
	
	@Test
	public void testAssign() {
		
	}
	
	@Test
	public void testUpdate_RemovePeerTooManyPieces() {
		//Contract: If a peer in ready would be assigned more than 51 pieces then it will stop assigning more to it.
		Bitfield bfLocal = new Bitfield(70);
		Bitfield bfP = new Bitfield(70);
		for(int i = 0; i < 70; i++) {
			bfP.markVerified(i);
		}
		BitfieldBasedStatistics bbs = new BitfieldBasedStatistics(bfLocal);
		PieceSelector ps = new PieceSelectorFake();
		Set<Peer> ready = new HashSet<Peer>();
		
		Peer p = new PeerFake();
		
		ready.add(p);
		
		bbs.addBitfield(p, bfP);
		
		Assignments as = new Assignments(bfLocal,ps,bbs,new Config());
		
		as.update(ready, new HashSet<Peer>());
		
		HashSet<Integer> count = new HashSet<Integer>(); //Count that the assigned pieces number no more than 51 which should be the limit.
		
		for(int i = 0; i < bfP.getPiecesComplete(); i++){
			Optional<Assignment> temp = as.assign(p);
			if(temp.isPresent()){
			 count.add(temp.get().getPiece());
			}
		}
		
		assertEquals(count.size(),51);
	}
	
	@Test
	public void testUpdate_RemovePeerMissingBitfield() {
		//Contract: If a peer in ready does not have a linked Bitfield in BitfieldBasedStatistics then it will not be in the set returned.
		Bitfield bfLocal = new Bitfield(1);
		BitfieldBasedStatistics bbs = new BitfieldBasedStatistics(bfLocal);
		PieceSelector ps = new PieceSelectorFake();
		Set<Peer> ready = new HashSet<Peer>();
		
		Peer p = new PeerFake();
		
		ready.add(p);
		
		Assignments as = new Assignments(bfLocal,ps,bbs,null);
		
		assertEquals(as.update(ready, new HashSet<Peer>()).size(),0);
	}
	
	@Test
	public void testUpdate_HasInterestingPieces() {
		//Contract: If a peer in choking has more verified pieces than the local bitfield has then it will be added to the returned set.
		Bitfield bfLocal = new Bitfield(20);
		Bitfield bfP = new Bitfield(20);
		for(int i = 0; i < 10; i++) {
			bfLocal.markVerified(i);
		}
		for(int i = 0; i < 20; i++) {
			bfP.markVerified(i);
		}
		BitfieldBasedStatistics bbs = new BitfieldBasedStatistics(bfLocal);
		PieceSelector ps = new PieceSelectorFake();
		Set<Peer> choking = new HashSet<Peer>();
		
		Peer p = new PeerFake();
		
		choking.add(p);
		
		bbs.addBitfield(p, bfP);
		
		Assignments as = new Assignments(bfLocal,ps,bbs,null);
		
		assertEquals(as.update(new HashSet<Peer>(), choking).size(),1);
		
		
	}
	
	@Test
	public void testUpdate_RemoveOldPeer() {
		//Contract: If there is a peer in the private set peers in Assignments that is not in ready then that peer in peers will be removed.
		Bitfield bfLocal = new Bitfield(1);
		Bitfield bfP = new Bitfield(1);
		bfLocal.markVerified(0);
		bfP.markVerified(0);
		BitfieldBasedStatistics bbs = new BitfieldBasedStatistics(bfLocal);
		PieceSelector ps = new PieceSelectorFake();
		
		Set<Peer> ready = new HashSet<Peer>();
		
		Peer p = new PeerFake();
		
		ready.add(p);
		
		Bitfield bfp2 = new Bitfield(1);
		Peer p2 = new PeerFake();
		
		bbs.addBitfield(p, bfP);
		
		bbs.addBitfield(p2, bfp2);
		
		Assignments as = new Assignments(bfLocal,ps,bbs,null);
		
		as.update(ready, new HashSet<Peer>());
		
		assertEquals(as.workersCount(),1);
		
		ready = new HashSet<Peer>();
		ready.add(p2);
		
		as.update(ready, new HashSet<Peer>());
		
		assertEquals(as.workersCount(),0);
	}
	
	//Just returns all the pieces in the Bitfields.
	private static class PieceSelectorFake implements PieceSelector {

		@Override
		public Stream<Integer> getNextPieces(PieceStatistics pieceStatistics) {
			ArrayList<Integer> tem = new ArrayList<Integer>();
			for(int i = 0; i < pieceStatistics.getPiecesTotal(); i++) {
				tem.add(i);
			}
			return tem.parallelStream();
		}
		
	}
	
	//Just used as a key in sets.
	private static class PeerFake implements Peer {

		@Override
		public InetSocketAddress getInetSocketAddress() {
			return null;
		}

		@Override
		public InetAddress getInetAddress() {
			return null;
		}

		@Override
		public int getPort() {
			return 0;
		}

		@Override
		public Optional<PeerId> getPeerId() {
			return null;
		}

		@Override
		public PeerOptions getOptions() {
			return null;
		}
		
	}
}
