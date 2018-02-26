package bt.torrent.messaging;

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
import bt.torrent.BitfieldBasedStatistics;
import bt.torrent.PieceStatistics;
import bt.torrent.selector.PieceSelector;

public class AssignmentsTest {
	
	@Test
	public void testAssign() {
		
	}
	
	@Test
	public void testUpdate_RemovePeer() {
		Bitfield bf = new Bitfield(51);
		Bitfield bfP = new Bitfield(51);
		for(int i = 0; i < 51; i++) {
			bf.markVerified(i);
			bfP.markVerified(i);
		}
		BitfieldBasedStatistics bbs = new BitfieldBasedStatistics(bf);
		PieceSelector ps = new PieceSelectorBS();
		Set<Peer> Peers = new HashSet<Peer>();
		
		Peer p = new PeerBS();
		
		Peers.add(p);
		
		bbs.addBitfield(p, bfP);
		
		Assignments as = new Assignments(bf,ps,bbs,null);
		
		System.out.println(as.update(Peers, new HashSet<Peer>(Peers)).size());
		
		
	}
	
	@Test
	public void testUpdate_RemoveMissingBitfield() {
		Bitfield bf = new Bitfield(51);
		Bitfield bfP = new Bitfield(51);
		for(int i = 0; i < 51; i++) {
			bf.markVerified(i);
			bfP.markVerified(i);
		}
		BitfieldBasedStatistics bbs = new BitfieldBasedStatistics(bf);
		PieceSelector ps = new PieceSelectorBS();
		Set<Peer> Peers = new HashSet<Peer>();
		
		Peer p = new PeerBS();
		
		Peers.add(p);
		
		//bbs.addBitfield(p, bfP);
		
		Assignments as = new Assignments(bf,ps,bbs,null);
		
		System.out.println(as.update(Peers, new HashSet<Peer>(Peers)).size());
		
		
	}
	
	@Test
	public void testUpdate_InterestingPieces() {
		Bitfield bf = new Bitfield(51);
		Bitfield bfP = new Bitfield(51);
		for(int i = 0; i < 21; i++) {
			bf.markVerified(i);
		}
		for(int i = 0; i < 51; i++) {
			bfP.markVerified(i);
		}
		BitfieldBasedStatistics bbs = new BitfieldBasedStatistics(bf);
		PieceSelector ps = new PieceSelectorBS();
		Set<Peer> Peers = new HashSet<Peer>();
		
		Peer p = new PeerBS();
		
		Peers.add(p);
		
		bbs.addBitfield(p, bfP);
		
		Assignments as = new Assignments(bf,ps,bbs,null);
		
		System.out.println(as.update(Peers, new HashSet<Peer>(Peers)).size());
		
		
	}
	
	@Test
	public void testUpdate_RemoveNewUnkown() {
		Bitfield bf = new Bitfield(51);
		Bitfield bfP = new Bitfield(51);
		for(int i = 0; i < 21; i++) {
			bf.markVerified(i);
		}
		for(int i = 0; i < 51; i++) {
			bfP.markVerified(i);
		}
		BitfieldBasedStatistics bbs = new BitfieldBasedStatistics(bf);
		PieceSelector ps = new PieceSelectorBS();
		Set<Peer> peers = new HashSet<Peer>();
		
		Peer p = new PeerBS();
		
		peers.add(p);
		
		Bitfield bfp2 = new Bitfield(51);
		Peer p2 = new PeerBS();
		
		bbs.addBitfield(p, bfP);
		
		bbs.addBitfield(p2, bfp2);
		
		Assignments as = new Assignments(bf,ps,bbs,null);
		
		as.update(peers, new HashSet<Peer>(peers)).size();
		
		peers = new HashSet<Peer>();
		peers.add(p2);
		
		as.update(peers, new HashSet<Peer>());
		
		
		
		
	}
	
	
	private static class PieceSelectorBS implements PieceSelector {

		@Override
		public Stream<Integer> getNextPieces(PieceStatistics pieceStatistics) {
			ArrayList<Integer> tem = new ArrayList<Integer>();
			for(int i = 0; i < pieceStatistics.getPiecesTotal(); i++) {
				tem.add(i);
			}
			return tem.parallelStream();
		}
		
	}
	
	private static class PeerBS implements Peer {

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
