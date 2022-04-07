package searchmethods;

import agent.State;
import java.util.List;

public class AStarSearch extends InformedSearch {

    /**
     * f = g + h <p/>
     * Set a node's f value equal to the cost of the path from the initial state to the node plus the heuristic value of the node's state.
     */
    @Override
    public void addSuccessorsToFrontier(List<State> successors, Node parent) {

        //TODO
        for(State s : successors){
            double g = parent.getG() + s.getAction().getCost();
            double h = heuristic.compute(s);
            double f = g + h;

            if(!frontier.containsState(s)){
                if(!explored.contains(s)){
                    frontier.add(new Node(s, parent, g, f));
                }
            }
        }
    }

    @Override
    public String toString() {
        return "A* search";
    }
}
