package eightpuzzle;

import agent.Heuristic;

/**
 * Computes the number of tiles out of place, ignoring the blank (0) tile. <p/>
 * Consistent, and therefore also admissible, heuristic.
 */
public class HeuristicTilesOutOfPlace extends Heuristic<EightPuzzleProblem, EightPuzzleState> {

    @Override
    public double compute(EightPuzzleState state) {
        return state.computeTilesOutOfPlace(problem.getGoalState());
    }
    
    @Override
    public String toString(){
        return "Tiles out of place";
    }    
}