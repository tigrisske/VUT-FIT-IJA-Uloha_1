package ija.ija2022.homework1.common;

public interface Maze {

//    Vrací počet řádků desky hry.

    int numRows();
    //    Metoda vrací pole Field podle zadané pozice.
//            Parameters:
//    row - Řádek, na kterém se pole nachází
//    col - Sloupec, na kterém se pole nachází
    Field getField(int row,
                   int col);

    //returns : pocet riadkov stlpcov
    int numCols();

}
