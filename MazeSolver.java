import java.util.*;
import java.io.File;
public abstract class MazeSolver
{
    // instance variables - replace the example below with your own
    private Maze maze;
    private boolean solved = false;

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public MazeSolver(Maze maze)
    {
        this.maze = maze;
        makeEmpty();
        add(maze.getStart());
    }
    
    abstract void makeEmpty();
    
    abstract boolean isEmpty();
    
    abstract void add(Square s);

    abstract Square next();
    
    public boolean isSolved(){
        return solved || isEmpty();
    }
    
    public void step(){
        if (isEmpty() == true) {
        }
        Square now = next();
        if (now == maze.getExit()) {
            solved = true;
        }
        for (Square neighbor : maze.getNeighbors(now)) {
            if (neighbor.getType() != Square.WALL && neighbor.getStatus() != Square.EXPLORED) {
                add(neighbor);
                neighbor.setStatus(Square.WORKING);
            }
        }

        now.setStatus(Square.EXPLORED);
    }
    
    public String getPath(){
        if(solved){
           return "Maze is solved"; 
        }
        else if(isEmpty()){
            return "Maze is Unsolvable";
        }
        else{
            return "Maze is not yet solved";
        }

    }
    
    public void solve(){
        while(!isSolved()){
            step();
        }
    }
}
