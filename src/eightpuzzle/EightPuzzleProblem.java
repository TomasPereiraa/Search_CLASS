package eightpuzzle;

import agent.Action;
import agent.Problem;

import java.util.*;

public class EightPuzzleProblem extends Problem<EightPuzzleState> {
    private final EightPuzzleState goalState;

    //TODO


    public EightPuzzleProblem(EightPuzzleState initialState) {
        super(initialState);
        possibleActions = new LinkedList<Action<EightPuzzleState>>() {{
            add(new ActionDown());
            add(new ActionUp());
            add(new ActionRight());
            add(new ActionLeft());
        }};

        /*this.initialState = initialState;
        this.possibleActions = new HashSet<>();
        possibleActions.add(new ActionDown());
        possibleActions.add(new ActionUp());
        possibleActions.add(new ActionLeft());
        possibleActions.add(new ActionRight());*/

        //e preferivel usar uma lista para nao criar confusao
        // List<Action> at = new ArrayList();
        //at.add(new ActionDown);

        goalState = new EightPuzzleState(EightPuzzleState.GOAL_MATRIX);
    }

    @Override
    public List<EightPuzzleState> executeActions(EightPuzzleState state) {
        List<EightPuzzleState> successors = new LinkedList<>();

        for (Action<EightPuzzleState> action: possibleActions)
            if(action.isValid(state))
             {
                 EightPuzzleState successor =  (EightPuzzleState) state.clone();
                   //sucessor.executeAction(act);
                    action.execute(successor);
                    successors.add(successor);
             }

        return successors;
    }

    @Override
    public boolean isGoal(EightPuzzleState state) {
        return state.equals(goalState);
    }


    /**
     * Cost is the path size, so it is redundant to compute.
     * This way computePathCost computes faster.
     * @param path
     * @return
     */
    @Override
    public double computePathCost(List<Action<EightPuzzleState>> path) {
        return path.size();
    }

    public EightPuzzleState getGoalState() {
        return goalState;
    }
}
