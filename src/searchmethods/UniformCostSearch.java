package searchmethods;

import agent.State;
import java.util.List;


import utils.NodePriorityQueue;

public class UniformCostSearch extends GraphSearch<NodePriorityQueue> {

    public UniformCostSearch(){
        frontier = new NodePriorityQueue();
    }

    /**
     * f = g <p/>
     * Set a node's f value equal to the cost of the path from the initial state to the node.
     */
    @Override
    public void addSuccessorsToFrontier(List<State> successors, Node parent) {
        for (State s: successors) {
            double g = parent.getG() + s.getAction().getCost();

            //new Node(s, parent, g, g);
            if(!frontier.containsState(s)){
                if(!explored.contains(s))
                    frontier.add(new Node(s, parent, g, g));
            }
            else if(frontier.getNode(s).getG() > g){
                frontier.removeNode(s);
                frontier.add(new Node(s, parent, g,g));
            }

        }
    }

    @Override
    public String toString() {
        return "Uniform cost search";
    }
}
