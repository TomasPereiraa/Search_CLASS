package searchmethods;

import agent.State;

public class Node implements Comparable<Node> {


    private State state;
    /** The cost of the path from the initial state to the node. Also denoted as g. */
    private double cost;
    /** When using frontier.add(...) the added nodes are ordered with respect to f, ascending (from lower to higher). */
    private double f;
    /** The node from which the current node was obtained. Null on initial states. */
    private Node parent;
    /** Node's depth on the search tree. */
    private int depth;

    public Node(State state) {
        this.state = state;
    }

    public Node(State state, Node parent) {
        this(state, parent, 0, 0);
    }    
    
    public Node(State state, Node parent, double cost, double f) {
        this.state = state;
        this.cost = cost;
        this.f = f;
        this.parent = parent;
        this.depth = parent.depth + 1;
    }


    /** @return the node's state. */
    public State getState() {
        return state;
    }


    public double getG() {
        return cost;
    }


    public double getF() {
        return f;
    }


    public Node getParent() {
        return parent;
    }


    public int getDepth() {
        return depth;
    }


    @Override
    public int compareTo(Node other) {
        return (f < other.f) ? -1 : (f == other.f) ? 0 : 1;
    }


    /**
     * Checks whether a given state already exists within the path from the initial state to the node.
     * <p/>
     * If the state is found, then, adding a new node with the state following this node will create a cycle
     * which may cause the search algorithm to loop indefinitely. A problem to account for when not using memory.
     * @param state State to check.
     * @return true if the state is found, false otherwise.
     */
    public boolean isCycle(State state) {
        Node aux = this;
        do{
            if (state.equals(aux.getState())) {
                return true;
            }
            aux = aux.getParent();
        }while (aux != null);

        return false;
    }


    @Override
    public String toString(){
        return "" + f;
    }
}