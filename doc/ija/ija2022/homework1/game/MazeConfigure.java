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

    private ArrayList<String>  field = new ArrayList<String>();



    //constructor
    public MazeConfigure() {
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
            Maze maze = new MazeInstance(this.rows, this.cols);

            //here we create all the fields
            for (int i = 0; i <this.rows; i++) {
                for (int j = 0; j < this.cols; j++) {
                    char ch = this.field.get(i).charAt(j);
                    //wall
                    if(ch == 'X'){
                        Field newField = new WallField(i+1,j+1 );
                        newField.setMaze(maze);
                        this.fields[i+1][j+1] = newField;
                    }
                    //path
                    else if(ch == '.'){
                        Field newField = new PathField(i+1,j+1 );
                        newField.setMaze(maze);
                        this.fields[i+1][j+1] = newField;
                    }
                    //path where pacman stands from beginning of the game
                    else if(ch == 'S'){
                        MazeObject pacMan = new PacmanObject(i+1, j+1);
                        Field newField = new PathField(i+1,j+1 );
                        this.fields[i+1][j+1] = newField;
                        pacMan.setMaze(maze);
                        newField.setMaze(maze);
                        newField.put(pacMan);

                    }
                }
            }
            maze.putFields(this.fields);
            return maze;
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

        //now we check whether processed line contains only valid elements
        String regex = "[S.X]*";
        if(!(line.matches(regex))) {
            canCreate = false;
            return false;
        }
        this.field.add(line);


        //validate fields
//        for (int col = 0; col < line.length(); col++) {
//            if(line.charAt(col) == '.'){// || line.charAt(col) == 'S' ) {
//                Field newField = new PathField(this.currRow, col+1)
//                this.fields[currRow][col + 1] = newField;
//                //newField.setMaze();
//            }
//            //when the S symbol occurs - we must put the MazeObject on the field
//            else if(line.charAt(col) == 'S'){
//                Field newField = new PathField(this.currRow, col+1);
//                this.fields[currRow][col + 1] = newField;
//                MazeObject pacMan = new PacmanObject();
//                newField.put(pacMan);
//
//            }
//            else if(line.charAt(col) == 'X' ){
//                this.fields[currRow][col+1] = new WallField(this.currRow, col+1);
//            }
//            else{
//                this.canCreate = false;
//                return false;
//            }
//        }
        this.currRow++;
        return true;
    }

    public void startReading(int rows, int cols){
        setRows(rows);
        setCols(cols);
        this.fields = new Field[rows+2][cols+2];
        for (int i = 0; i < cols+2 ; i++){
            this.fields[0][i] = new WallField(0,i);
            this.fields[rows+1][i] = new WallField(rows+1, i);
        }
        for (int i = 0; i < rows+2; i++){
            this.fields[i][0]= new WallField(i, 0);
            this.fields[i][cols+1]= new WallField(i, cols+1);
        }
        this.isReading = true;
    }


   public boolean stopReading(){
       if (!(this.isReading)) return false;
       return true;
   }
}
