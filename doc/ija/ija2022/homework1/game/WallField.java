package ija.ija2022.homework1.game;
import ija.ija2022.homework1.common.Field;
import ija.ija2022.homework1.common.Maze;
import ija.ija2022.homework1.common.MazeObject;

public class WallField extends Object implements Field{
    public int col;
    public int row;

    private boolean empty;

    public WallField(int row, int col){
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

        this.empty = true;
        return false;
    }



    @Override
    public boolean remove(MazeObject object){
        empty = false;
        return false;
    }

    @Override
    public boolean isEmpty(){
        return true;
    }

    @Override
    public MazeObject get(){return null;}

    @Override
    public boolean canMove(){return false;}

    @Override
    public int getCol(){
        return this.col;
    }

    @Override
    public int getRow(){
        return this.col;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) { // if the objects are the same, return true
            return true;
        }
        if (!(obj instanceof WallField)) { // if the object is not a WallField, return false
            return false;
        }
        WallField other = (WallField) obj;
        return this.getRow() == other.getRow() && this.getCol() == other.getCol();
    }


}
