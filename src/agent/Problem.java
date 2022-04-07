package agent;

import eightpuzzle.EightPuzzleState;

import java.util.List;
import java.util.Set;

public abstract class Problem <S extends State>{

    //TODO
    protected S initialState;
    protected List<Action<S>> possibleActions;
    protected Heuristic<Problem<S>,S> heuristic;

    public Problem(S initialState) {
        this.initialState = initialState;
    }

    /**
     * Applies all possible actions to a source state and returns the resulting states
     * @param state source state
     * @return all possible source state followup states
     */
    public abstract List<S> executeActions(S state);

    /**
     * Check whether a given state is a goal state
     * @param state source state
     * @return true if the source state is a goal state
     */
    public abstract boolean isGoal(S state);

    /**
     * Computes the total cost of a sequence of actions
     * @param actions path
     * @return total cost
     */
    public double computePathCost(List<Action<S>> actions){
        double cost = 0;
        for (Action<S> act :
                actions) {
            cost += act.getCost();
        }
        return cost;
    }

    public State getInitialState() {
        return initialState;
    }

    private void setInitialState(S initialState) {
        this.initialState = initialState;
    }

    public void setHeuristic(Heuristic heuristic) {
        this.heuristic = heuristic;
    }

    public Heuristic getHeuristic() {
        return heuristic;
    }
}
