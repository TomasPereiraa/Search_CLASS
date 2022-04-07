package searchmethods;

import agent.State;
import java.util.List;
import utils.NodePriorityQueue;

public class BeamSearch extends AStarSearch {

    private int beamSize;

    public BeamSearch() {
        this(100);
    }

    public BeamSearch(int beamSize) {
        this.beamSize = beamSize;
    }

    /** Behaves similarly to A* but limits the frontier size to the beamSize */
    @Override
    public void addSuccessorsToFrontier(List<State> successors, Node parent) {

        //TODO
        super.addSuccessorsToFrontier(successors, parent);

        if(frontier.size() > beamSize){

            NodePriorityQueue aux = new NodePriorityQueue();

            do{
                aux.add(frontier.poll());
            }while (aux.size() < beamSize);

            frontier = aux;
        }

    }

    public void setBeamSize(int beamSize) {
        this.beamSize = beamSize;
    }

    public int getBeamSize() {
        return beamSize;
    }

    @Override
    public String toString() {
        return "Beam search";
    }
}
