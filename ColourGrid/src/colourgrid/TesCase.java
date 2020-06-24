/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colourgrid;

/**
 *
 * @author kasun_n
 */
public class TesCase {

    public static void main(String args[]) {   

        //sample colors
        String colors[][] = {{"Red", "Black", "Black", "Black", "Black", "Blue", "Blue", "Red"},
        {"Green", "Red", "Red", "Black", "Blue", "Blue", "Red", "Red"},
        {"Blue", "Green", "Red", "Red", "Green", "Blue", "Green", "Red"},
        {"Blue", "Blue", "Green", "Red", "Green", "Green", "Green", "Green"},
        {"Blue", "Red", "Blue", "Red", "Red", "Black", "Black", "Black"},
        {"Red", "Red", "Blue", "Red", "Red", "Black", "Black", "Black"}};

        //size of the colr grid
        int colums = 6;
        int rows = 8;

        //create object using ColorAlgorithm and pass colums and rows
        ColorAlgorithm algorithm = new ColorAlgorithm(colums, rows);
        
        algorithm.printColorGrid(colors);

        //call argest Continuous Color and Area  function
        algorithm.findLgtContinuousColorArea(colors);
    }

}
