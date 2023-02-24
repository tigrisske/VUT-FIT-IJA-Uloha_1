package ija.ija2022.homework1.game;
import ija.ija2022.homework1.common.*;

import java.nio.file.Path;

public class PathField extends Object implements Field{

    public int col;
    public int row;
    private MazeObject panacik;
    boolean empty;

    public PathField(int row, int col){
        this.empty = true;
        this.col = col;
        this.row = row;
    }
    static enum Direction{

    }

    @Override
    public void setMaze(Maze maze){

    }


    @Override
    public Field nextField(Field.Direction dirs){return null;}

    @Override
    public boolean put(MazeObject object) {
        if(object == null) return false;
        this.panacik = object;
        return true;
    }


    @Override
    public boolean remove(MazeObject object){
        this.panacik = null;
        this.empty = true;
        return false;
    }

    @Override
    public boolean isEmpty(){
        return empty;
    }

    @Override
    public MazeObject get(){return null;}

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
