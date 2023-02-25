package ija.ija2022.homework1.game;
import ija.ija2022.homework1.common.*;


public class MazeInstance implements Maze {
    private int cols;
    private int rows;
    private Field[][] fields;
   public MazeInstance(int rows, int cols, Field[][] fields){
       this.fields = fields;
       this.rows = rows;
       this.cols = cols;
   }

    @Override
    public int numRows(){
       return rows+2;
   }


    @Override
    public Field getField(int row, int col) {
        return fields[row][col];
    }

    @Override
    public int numCols(){
        return cols+2;
   }
}
