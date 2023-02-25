package ija.ija2022.homework1.game;

import ija.ija2022.homework1.common.Field;
import ija.ija2022.homework1.common.Maze;
import ija.ija2022.homework1.common.MazeObject;

import java.util.ArrayList;

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

    private ArrayList<Integer> getCords(Field.Direction dir){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int col = this.cols;
        int row = this.rows;
        if (dir == Field.Direction.L){
            col -= 1;
        }
        if (dir == Field.Direction.R){
            col += 1;
        }
        if (dir == Field.Direction.U){
            row-= 1;
        }
        if (dir == Field.Direction.D){
            row += 1;
        }
        arr.add(row);
        arr.add(col);
       return arr;
    }

    @Override
    public boolean move(Field.Direction dir){
        //saving the current Field in case we have to remove an object
        Field currField  = this.maze.getField(rows,cols);
        Field newField = this.maze.getField(getCords(dir).get(0),getCords(dir).get(1));
        if (newField.canMove()){
            this.rows = getCords(dir).get(0);
            this.cols = getCords(dir).get(1);
            newField.put(this);
            currField.remove(this);
            return true;
        }
        return (newField.canMove());
    }

    public void setMaze(Maze maze){
        this.maze = maze;
    }
}
