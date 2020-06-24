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
public class ColorAlgorithm {

    public ColorAlgorithm(int colomn, int row) {
        this.colomn = colomn;
        this.row = row;

        this.visitedValues = new String[colomn][row];
        this.selectedColor = "";

        this.result = new String[colomn][row];

    }

    //init varibles
    public int colomn;
    public int row;

    String[][] visitedValues = new String[colomn][row];
    String selectedColor = "";

    String result[][] = new String[colomn][row];

    int checkingCount;

    //check values on visited array and result array
    boolean checkValue(int x, int y,
            String key,
            String input[][]) {
        if (x < colomn && y < row
                && x >= 0 && y >= 0) {
            if ("0".equals(visitedValues[x][y])
                    && input[x][y].equals(key)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

// Breadth First Search function
    void fnBreadthFirstSearch(String x, String y, int i,
            int j, String input[][]) {
        // terminating case for BFS 
        if (!x.equals(y)) {
            return;
        }

        visitedValues[i][j] = x + "";
        checkingCount++;

        // checking  neighbor blocks
        int[] xMove = {0, 0, 1, -1};
        int[] yMove = {1, -1, 0, 0};

        // checks all neighbor blocks up to 5
      
        for (int u = 0; u < 4; u++) {
            if ((checkValue(i + yMove[u],
                    j + xMove[u], x, input)) == true) {
                fnBreadthFirstSearch(x, y, i + yMove[u],
                        j + xMove[u], input);
            }
        }
    }

//reset visited values
    void resetVisitedValue() {
        for (int i = 0; i < colomn; i++) {
            for (int j = 0; j < row; j++) {
                visitedValues[i][j] = "0";
            }
        }
    }

//reset searched result
    void resetSearchResult(String key,
            String input[][]) {
        for (int i = 0; i < colomn; i++) {
            for (int j = 0; j < row; j++) {
                if (!"0".equals(visitedValues[i][j])
                        && input[i][j].equals(key)) {
                    result[i][j] = visitedValues[i][j] + "";
                    selectedColor = result[i][j] + "";

                } else {
                    result[i][j] = "0";
                }
            }
        }
    }

// function to print the result 
    void printSearchedResult(int res) {
        System.out.println("");
        System.out.println("");
        System.out.println("Largest Continuous Color block -> Color is " + selectedColor + " and color area is " + res);

        System.out.println("");
        System.out.println("-------- Preview of Searched Result --------");
        System.out.println("");

        // prints the largest component 
        for (int i = 0; i < colomn; i++) {
            for (int j = 0; j < row; j++) {
                if (!result[i][j].equals("0")) {
                    System.out.print(result[i][j] + " ");
                } else {
                    System.out.print(" *  ");
                }
            }
            System.out.println();
        }
    }

//main method -- find largest Continuous Color and Area  
    void findLgtContinuousColorArea(String[][] colors) {

        //set columns and rows from parameters
        //int from min value
        int currentMaxValue = Integer.MIN_VALUE;

        for (int i = 0; i < colomn; i++) {
            for (int j = 0; j < row; j++) {
                resetVisitedValue();
                checkingCount = 0;

                // checking left to right
                if (j + 1 < row) {
                    fnBreadthFirstSearch(colors[i][j], colors[i][j + 1],
                            i, j, colors);
                }

                // updating result 
                if (checkingCount >= currentMaxValue) {
                    currentMaxValue = checkingCount;
                    resetSearchResult(colors[i][j], colors);
                }
                resetVisitedValue();
                checkingCount = 0;

                // checking up to bottom
                if (i + 1 < colomn) {
                    fnBreadthFirstSearch(colors[i][j],
                            colors[i + 1][j], i, j, colors);
                }

                // updating result 
                if (checkingCount >= currentMaxValue) {
                    currentMaxValue = checkingCount;
                    resetSearchResult(colors[i][j], colors);
                }
            }
        }
        
        //print results
        printSearchedResult(currentMaxValue);
    }
    
    
    // function to print the result 
    void printColorGrid(String [][] colorGrid) {   

        System.out.println("");
        System.out.println("-------- Original Color Grid --------");
        System.out.println("");

        // prints the grid
        for (int i = 0; i < colomn; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print(colorGrid[i][j] + " ");
            }
            System.out.println();
        }
    }


}
