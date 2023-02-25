package ija.ija2022.homework1.game;
import ija.ija2022.homework1.common.*;

import java.util.ArrayList;

public class MazeConfigure extends Object {
    private int rows;
    private int cols;
    private boolean isReading = false;
    private Field fields[][];

    private boolean canCreate;

    private int currRow;

    private ArrayList<String> PathFieldsList = new ArrayList<>();

    private ArrayList<String> WallFieldsList = new ArrayList<>();

    //constructor
    public MazeConfigure() {
        this.WallFieldsList.add("X");
        this.PathFieldsList.add(".");
        this.PathFieldsList.add("S");
        currRow = 1;
        canCreate = true;
    }


    //getters
    int getRows() {
        return rows;
    }

    int getCols() {
        return cols;
    }

    //setters
    private void setRows(int rows) {
        //data validation
        if (!(rows > 0)) throw new IllegalArgumentException("number of rows must be positive number");
        this.rows = rows;
    }

    private void setCols(int cols) {
        if (!(cols > 0)) throw new IllegalArgumentException("number of columns must be positive number");
        this.cols = cols;
    }

    public Maze createMaze() {
        if (canCreate) {
            return new MazeInstance(this.rows, this.cols, this.fields);
        }
        return null;
    }
    public boolean processLine(String line) {
        //first check whether we can process line
        if (!(isReading)) {
            return false;
        }

        //next check whether the length of line matches num of rows
        if (line.length() != cols) return false;

        //validate fields
        for (int col = 0; col < line.length(); col++) {
            if(line.charAt(col) == '.'){// || line.charAt(col) == 'S' ) {
                this.fields[currRow][col + 1] = new PathField(this.currRow, col+1);
            }
            else if(line.charAt(col) == 'S'){
                this.fields[currRow][col + 1] = new PathField(this.currRow, col+1);

            }
            else if(line.charAt(col) == 'X' ){
                this.fields[currRow][col+1] = new WallField(this.currRow, col+1);
            }
            else{
                this.canCreate = false;
                return false;
            }
        }
        this.currRow++;
        return true;
    }

    public void startReading(int rows, int cols){
        setRows(rows);
        setCols(cols);
        this.fields = new Field[rows+2][cols+2];
        for (int i = 0; i < cols+2 ; i++){
            this.fields[0][i] = new WallField(0,i);
            this.fields[i][0] = new WallField(i,0);
            this.fields[rows][i] = new WallField(rows, i);
            this.fields[i][cols] = new WallField(i, cols);
        }
        this.isReading = true;
    }

   public boolean stopReading(){
       if (!(this.isReading)) return false;
       return true;
   }
}
