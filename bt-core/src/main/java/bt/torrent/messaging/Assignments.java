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

package bt.torrent.messaging;

import bt.data.Bitfield;
import bt.net.Peer;
import bt.runtime.Config;
import bt.torrent.BitfieldBasedStatistics;
import bt.torrent.selector.PieceSelector;
import core.CodeCoverage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

public class Assignments {

    private static final Logger LOGGER = LoggerFactory.getLogger(Assignments.class);

    private static final int MAX_ASSIGNED_PIECES_PER_PEER = 50;

    private Config config;

    private Bitfield bitfield;
    private PieceSelector selector;
    private BitfieldBasedStatistics pieceStatistics;

    private Set<Integer> assignedPieces;
    private Map<Peer, Assignment> assignments;
    private Map<Peer, LinkedList<Integer>> peers;

    private Random random;

    public Assignments(Bitfield bitfield, PieceSelector selector, BitfieldBasedStatistics pieceStatistics, Config config) {
        this.bitfield = bitfield;
        this.selector = selector;
        this.pieceStatistics = pieceStatistics;
        this.config = config;

        this.assignedPieces = new HashSet<>();
        this.assignments = new HashMap<>();
        this.peers = new HashMap<>();

        this.random = new Random(System.currentTimeMillis());
    }

    public Assignment get(Peer peer) {
        return assignments.get(peer);
    }

    public void remove(Assignment assignment) {
        assignment.abort();
        assignments.remove(assignment.getPeer());
        assignedPieces.remove(assignment.getPiece());
    }

    public int count() {
        return assignments.size();
    }

    public int workersCount() {
        return peers.size();
    }

    public Optional<Assignment> assign(Peer peer) {
    	CodeCoverage cc = new CodeCoverage("Assignments_assign.txt");
        LinkedList<Integer> pieces = peers.get(peer);
        if (pieces == null || pieces.isEmpty()) {
        	System.out.println("#CC# 1");
        	cc.writeToFile("assign");
            return Optional.empty();
        }
        else System.out.println("#CC# 2");

        boolean endgame = isEndgame();

        StringBuilder buf = LOGGER.isTraceEnabled() ? new StringBuilder() : null;
        if (LOGGER.isTraceEnabled()) {
        	System.out.println("#CC# 3");
            buf.append("Trying to claim next assignment for peer ");
            buf.append(peer);
            buf.append(". Number of remaining pieces: ");
            buf.append(bitfield.getPiecesRemaining());
            buf.append(", number of pieces in progress: ");
            buf.append(assignedPieces.size());
            buf.append(", endgame: " + endgame);
            buf.append(". ");
        }
        else System.out.println("#CC# 4");

        Optional<Integer> selectedPiece;
        if (endgame) {
        	System.out.println("#CC# 5");
            // take random piece to minimize number of pieces
            // requested from different peers at the same time
            Integer pieceIndex = pieces.remove(random.nextInt(pieces.size()));
            selectedPiece = Optional.of(pieceIndex);
        } else {
        	System.out.println("#CC# 6");

            Integer piece;
            boolean assigned = true;
            Iterator<Integer> iter = pieces.iterator();
            int runMoreThanOnce = 0; //Added by us in group23.
            do {
            	runMoreThanOnce++; //Added by us in group23.
                piece = iter.next();
                if (bitfield.isComplete(piece)) {
                	System.out.println("#CC# 10");
                    iter.remove();
                    if (LOGGER.isTraceEnabled()) {
                        buf.append("Checking next piece in queue: {" + piece + "}; piece is completed. ");
                        System.out.println("#CC# 11");
                    }
                    else System.out.println("#CC# 12");
                    continue;
                }
                else System.out.println("#CC# 13");
                assigned = assignedPieces.contains(piece);
                if (assigned && LOGGER.isTraceEnabled()) {
                    buf.append("Checking next piece in queue: {" + piece + "}; piece is assigned. ");
                    System.out.println("#CC# 14");
                }
                else System.out.println("#CC# 15");
            } while (assigned && iter.hasNext());
            if(runMoreThanOnce > 1) System.out.println("#CC# 8");//Added by us in group23.
            else System.out.println("#CC# 7");
            System.out.println("#CC# 9");
            
            if (!assigned) {
            	System.out.println("#CC# 16");
                iter.remove();
            }
            else System.out.println("#CC# 17");
            selectedPiece = assigned ? Optional.empty() : Optional.of(piece);
            
            if(assigned) System.out.println("#CC# 18");//Added by us in group23.
            else System.out.println("#CC# 19");
        }

        if (LOGGER.isTraceEnabled()) {
        	System.out.println("#CC# 20");
            if (selectedPiece.isPresent()) {
            	System.out.println("#CC# 21");
                buf.append(" => Assigning piece #");
                buf.append(selectedPiece.get());
                buf.append(" to current peer");
            } else {
            	System.out.println("#CC# 22");
                buf.append(" => No pieces to assign.");
            }
            LOGGER.trace(buf.toString());
        }
        else System.out.println("#CC# 23");
        
        cc.writeToFile("assign");
        return selectedPiece.isPresent() ? Optional.of(assign(peer, selectedPiece.get())) : Optional.empty();
    }

    private boolean isEndgame() {
        // if all remaining pieces are requested,
        // that would mean that we have entered the "endgame" mode
        return bitfield.getPiecesRemaining() <= assignedPieces.size();
    }

    private Assignment assign(Peer peer, Integer piece) {
        Assignment assignment = new Assignment(peer, piece, config.getMaxPieceReceivingTime());
        assignments.put(peer, assignment);
        assignedPieces.add(piece);
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("Assigning piece #{} to peer: {}", piece, peer);
        }
        return assignment;
    }

    /**
     * Updates the lists of interesting pieces for the provided peers.
     *
     * @return Collection of peers that have interesting pieces and can be given an assignment
     */
    // TODO: select from seeders first
    /**
     * 
     * Called by TorrentWorker. CreateSessionStage creates an instance of TorrentWorker. TorrentProcessFactory creates two instances of CreateSessionStage.
     * ServiceModule "binds" a TorrentProcessFactory to ProcessFactory. BtRuntimeBuilder has an instance of ServiceModule and which is tested by BtRuntimeBuilderTest.
     */
    public Set<Peer> update(Set<Peer> ready, Set<Peer> choking) {
    	CodeCoverage cc = new CodeCoverage("Assignments_update.txt");
    	
    	Iterator<Integer> suggested = selector.getNextPieces(pieceStatistics).iterator();
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("Updating assignments. Piece selector has more pieces: {}, number of ready peers: {}, number of assigned peers: {}",
                    suggested.hasNext(), ready.size(), assignments.size());
            System.out.println("#CC# update 2");
        }
        else System.out.println("#CC# update 3");
        final Set<Peer> readyPeers = new HashSet<>(ready);
        while (suggested.hasNext() && readyPeers.size() > 0) {
            Integer piece = suggested.next();
            System.out.println("#CC# update 4");
            final Iterator<Peer> iter = readyPeers.iterator();
            while (iter.hasNext()) {
            	System.out.println("#CC# update 5");
                Peer peer = iter.next();
                Optional<Bitfield> peerBitfield = pieceStatistics.getPeerBitfield(peer);
                if (!peerBitfield.isPresent()) {
                    iter.remove();
                    System.out.println("#CC# update 6");
                    continue;
                }
                else System.out.println("#CC# update 7");
                LinkedList<Integer> queue = peers.get(peer);
                if (queue != null && queue.size() > MAX_ASSIGNED_PIECES_PER_PEER) {
                    iter.remove();
                    System.out.println("#CC# update 8");
                    continue;
                }
                else System.out.println("#CC# update 9");
                boolean hasPiece = peerBitfield.get().isVerified(piece);
                if (hasPiece) {
                	System.out.println("#CC# update 10");
                    if (queue == null) {
                    	System.out.println("#CC# update 11");
                        queue = new LinkedList<>();
                        peers.put(peer, queue);
                    }
                    else System.out.println("#CC# update 12");
                    if (!queue.contains(piece)) {
                    	System.out.println("#CC# update 13");
                        queue.add(piece);
                        if (queue.size() > MAX_ASSIGNED_PIECES_PER_PEER) {
                            iter.remove();
                            System.out.println("#CC# update 14");
                        }
                        else System.out.println("#CC# update 15");
                        if (LOGGER.isTraceEnabled()) {
                            LOGGER.trace("Adding piece #{} to peer's queue: {}. Number of pieces in peer's queue: {}",
                                    piece, peer, queue.size());
                            System.out.println("#CC# update 16");
                        }
                        else System.out.println("#CC# update 17");
                    }
                    else System.out.println("#CC# update 18");
                }
                else System.out.println("#CC# update 19");
            }
            System.out.println("#CC# update 28");
        }
        System.out.println("#CC# update 1");

        Iterator<Map.Entry<Peer, LinkedList<Integer>>> iter = peers.entrySet().iterator();
        while (iter.hasNext()) {
        	System.out.println("#CC# update 20");
            Map.Entry<Peer, LinkedList<Integer>> e = iter.next();
            Peer peer = e.getKey();
            LinkedList<Integer> pieces = e.getValue();

            if (!ready.contains(peer) || pieces.isEmpty()) {
                iter.remove();
                System.out.println("#CC# update 21");
            }
            else System.out.println("#CC# update 22");
        }
        System.out.println("#CC# update 27");

        Set<Peer> result = new HashSet<>(peers.keySet());
        for (Peer peer : choking) {
        	System.out.println("#CC# update 23");
            if (hasInterestingPieces(peer)) {
                result.add(peer);
                System.out.println("#CC# update 24");
            }
            else System.out.println("#CC# update 25");
        }
        System.out.println("#CC# update 26");
        cc.writeToFile("update");
        return result;
    }

    private boolean hasInterestingPieces(Peer peer) {
        Optional<Bitfield> peerBitfieldOptional = pieceStatistics.getPeerBitfield(peer);
        if (!peerBitfieldOptional.isPresent()) {
            return false;
        }
        BitSet peerBitfield = peerBitfieldOptional.get().getBitmask();
        BitSet localBitfield = bitfield.getBitmask();
        peerBitfield.andNot(localBitfield);
        return peerBitfield.cardinality() > 0;
    }
}
