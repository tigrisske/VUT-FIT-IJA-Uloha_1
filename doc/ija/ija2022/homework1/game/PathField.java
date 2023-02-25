package ija.ija2022.homework1.game;
import ija.ija2022.homework1.common.*;

import java.nio.file.Path;

public class PathField extends Object implements Field{

    public int col;
    public int row;
    private MazeObject panacik;
    boolean empty;
    Maze maze;

    public PathField(int row, int col){
        this.empty = true;
        this.col = col;
        this.row = row;
    }
    static enum Direction{
        L,R,U,D

    }

    @Override
    public void setMaze(Maze maze){
        if (maze != null){
            this.maze = maze;
        }
    }


    @Override
    public Field nextField(Field.Direction dirs){
        int row = this.row;
        int col = this.col;
        if (dirs == Field.Direction.L){
            col -= 1;
        }
        if (dirs == Field.Direction.R){
            col += 1;
        }
        if (dirs == Field.Direction.U){
            row -= 1;
        }
        if (dirs == Field.Direction.D){
            row += 1;
        }
        //if(this.maze.getField(row,col) instanceof PathField) return this.maze.getField(row,col);
        //else throw  new UnsupportedOperationException();
        return this.maze.getField(row,col);
    }

    @Override
    public boolean put(MazeObject object) {
        if(object == null) return false;
        this.panacik = object;
        empty = false;
        return true;
    }



    @Override
    public boolean remove(MazeObject object){
        if(this.panacik == null) return false;
        this.panacik = null;
        this.empty = true;
        return true;
    }

    @Override
    public boolean isEmpty(){
        return empty;
    }

    @Override
    public MazeObject get(){
        return this.panacik;
    }

    @Override
    public boolean canMove(){return true;}

    @Override
    public int getRow(){
        return this.row;
    }

    @Override
    public int getCol(){
        return this.col;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) { // if the objects are the same, return true
            return true;
        }
        if (!(obj instanceof PathField)) { // if the object is not a WallField, return false
            return false;
        }
        PathField other = (PathField) obj;
        return this.getRow() == other.getRow() && this.getCol() == other.getCol();
    }
}
