package eightpuzzle;

import agent.Heuristic;

/**
 * Computes the sum of the manhattan distances of the tiles out of place to their correct slots,
 *  ignoring the blank (0) tile. <p/>
 * Consistent, and therefore also admissible, heuristic.
 */
public class HeuristicTileDistance extends Heuristic<EightPuzzleProblem, EightPuzzleState>{

    @Override
    public double compute(EightPuzzleState state){
        return state.computeTileDistances(problem.getGoalState());
    }
    
    @Override
    public String toString(){
        return "Tiles distance to final position";
    }
}