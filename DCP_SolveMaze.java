import java.util.LinkedList;
import java.util.Queue;

public class DCP_SolveMaze {

    static class Position{
        int x;
        int y;
        Position parent = null;

        Position(int y, int x){
            this.x = x;
            this.y = y;
        }
        
        Position(int y, int x, Position parent){
            this.x = x;
            this.y = y;
            this.parent = parent;
        }
        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof Position)) return false;
            Position object = (Position) obj;

            return object.x==this.x && object.y==this.y;
        }
    }



    public static boolean isValidPosition(Position pos, boolean[][] maze){
        int rows = maze.length;
        int cols = maze[0].length;
        if(pos.x<0 || pos.y<0 || pos.x>=cols || pos.y>=rows || maze[pos.y][pos.x]) return false;
        return true;
    }


    public static Integer solveMaze(boolean[][] maze, Position start, Position end){
        if(maze.length==0 || maze[0].length==0 || start==null || end == null) return null;

        if(!isValidPosition(start, maze) || !isValidPosition(end, maze)) return null;

        if(start.equals(end)) return 0;

        Queue<Position> fringe = new LinkedList<>();

        fringe.add(start);
        boolean foundSolution = false;
        Position temp;
        Position current = null;
        while(!fringe.isEmpty()){
            current =  fringe.poll();
            maze[current.y][current.x] = true;
            if(current.equals(end)) {
                foundSolution = true;
                break;
            }
            temp = new Position(current.y, current.x+1, current);
            if(isValidPosition(temp, maze)) fringe.add(temp);

            temp = new Position(current.y, current.x-1, current);
            if(isValidPosition(temp, maze)) fringe.add(temp);

            temp = new Position(current.y+1, current.x, current);
            if(isValidPosition(temp, maze)) fringe.add(temp);

            temp = new Position(current.y-1, current.x, current);
            if(isValidPosition(temp, maze)) fringe.add(temp);
        }


        if(foundSolution){
            int count = 0;

            while(current.parent!=null){
                count++;
                current = current.parent;
            }

            return count;
        }


        return null;
    }


    public static void main(String[] args) {
        Position start = new Position(3, 0);
        Position end = new Position(0, 0);

        boolean [][] maze = {
            {false, false, false, false},
            {true, true, true, true},
            {false, false, false, false},
            {false, false, false, false}
        };


        System.out.println(solveMaze(maze, start, end));
    }
}