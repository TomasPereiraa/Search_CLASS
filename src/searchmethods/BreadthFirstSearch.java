package searchmethods;

import agent.State;
import java.util.List;
import utils.NodeLinkedList;

public class BreadthFirstSearch extends GraphSearch<NodeLinkedList> {

    public BreadthFirstSearch() {
        frontier = new NodeLinkedList();
    }

    @Override
    public void addSuccessorsToFrontier(List<State> successors, Node parent) {
        for (State successor: successors)
            if (!frontier.containsState(successor) && !explored.contains(successor))
                frontier.addLast( new Node(successor, parent));
    }

    @Override
    public String toString() {
        return "Breadth first search";
    }
}