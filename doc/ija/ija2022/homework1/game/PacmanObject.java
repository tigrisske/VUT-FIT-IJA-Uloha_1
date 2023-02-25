package ija.ija2022.homework1.game;

import ija.ija2022.homework1.common.Field;
import ija.ija2022.homework1.common.Maze;
import ija.ija2022.homework1.common.MazeObject;

public class PacmanObject implements MazeObject {
    private int rows;
    private int cols;


    public PacmanObject(int rows, int cols){
        this.rows = rows;
        this.cols = cols;

    }
    Maze maze;
    @Override
    public boolean canMove(Field.Direction dir){
        int row = this.rows;
        int col = this.cols;
        if (dir == Field.Direction.L){
            col -= 1;
        }
        if (dir == Field.Direction.R){
            col += 1;
        }
        if (dir == Field.Direction.U){
            row -= 1;
        }
        if (dir == Field.Direction.D){
            row += 1;
        }
        //if(this.maze.getField(row,col) instanceof PathField) return this.maze.getField(row,col);
        //else throw  new UnsupportedOperationException();
        return this.maze.getField(row,col).canMove();
    }

    @Override
    public boolean move(Field.Direction dir){
       if(this.maze.getField(rows,cols).canMove()){


        }
        return true;
    }

    public void setMaze(Maze maze){
        this.maze = maze;
    }
}
