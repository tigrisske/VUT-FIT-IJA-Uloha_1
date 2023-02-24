package ija.ija2022.homework1.game;
import ija.ija2022.homework1.common.Field;
import ija.ija2022.homework1.common.Maze;
import ija.ija2022.homework1.common.MazeObject;

public class WallField extends Object implements Field{
    public WallField(int row, int col){}
    static enum Direction{

    }

    @Override
    public void setMaze(Maze maze){

    }


    @Override
    public Field nextField(Field.Direction dirs){return null;}

    @Override
    public boolean put(MazeObject object) {return false;}

    @Override
    public boolean remove(MazeObject object){return false;}

    @Override
    public boolean isEmpty(){return false;}

    @Override
    public MazeObject get(){return null;}

    @Override
    public boolean canMove(){return false;}


    @Override
    public boolean equals(Object obj){return false;}
}
