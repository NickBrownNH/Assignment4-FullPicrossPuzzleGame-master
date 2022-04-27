package com.example.assignment4picrosspuzzlegame;

import javafx.scene.control.Alert;

import java.util.Random;

/**
 * Assignment 3 CS115
 * Class holds an array of 0s and 1s representing a Picross puzzle
 * @author basmalahasad, edited by Dylan Gomez
 * @version 03/30/2022
 */
public class PicrossPuzzle {
    private int[][] solution;
    int [][] entered = new int[5][5];

    /**
     * Constructor for PicrossPuzzle with a default size of 5x5
     */
    public PicrossPuzzle()
    {
        this(5);
    }

    /**
     * Constructor for PicrossPuzzle with arguments, fills array with random 0s and 1s
     * @param size the size of the 2-D array
     */
    public PicrossPuzzle(int size)
    {
        Random rand = new Random();
        solution = new int[size][size];
        for (int i = 0; i < solution.length; i++)
            for (int j = 0; j < solution[i].length; j++)
                solution[i][j] = rand.nextInt(2);
    }

    /**
     * Constructor for PicrossPuzzle to initialize solution with the array passed
     * @param solution solution array
     */
    public PicrossPuzzle(int[][] solution)
    {
        this.solution = new int[solution.length][solution.length];
        for (int i = 0; i < solution.length; i++)
            for (int j = 0; j < solution[i].length; j++)
                this.solution[i][j] = solution[i][j];
    }

    /**
     * Returns the string representation of the data array
     * @return the string representation of the data array
     */
    public String toString()
    {
        String result = "";
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[i].length; j++) {
                result += solution[i][j] + "\t";
            }
            result += "\n";
        }
        return result;
    }

    /**
     * Gets the value at a specified row and column
     * @param indrow the row index
     * @param indcol the column index
     * @return the array's value at the specified row and column
     */
    public int getValue(int indrow, int indcol)
    {
        return solution[indrow][indcol];
    }

    /**
     * Returns the row clues of the puzzle solution
     * @return the row clues of the puzzle solution
     */
    public String[] getRowClues() {
        int rows = solution.length;
        String[] clues = new String[rows];
        return getRowClues(clues,0);
    }

    /**
     * Returns the row clues of the puzzle solution
     * @return the row clues of the puzzle solution
     */
    private String[] getRowClues(String[] clues, int row) {
        int rows = solution.length;
        int cols = solution[0].length;
        int count;
        int col;

        if (row<rows) {
            clues[row] = "";
            col = 0;
            count = 0;
            while (col < cols) {
                while (col < cols && solution[row][col] == 0) {
                    col++;
                }
                while (col < cols && solution[row][col] == 1) {
                    col++;
                    count++;
                }
                clues[row] += (count > 0) ? count + " " : "";
                count = 0;
            }
            return getRowClues(clues,row+1);
        }
        return clues;

    }



    /**
     * Returns the column clues of the puzzle solution
     * @return the column clues of the puzzle solution
     */
    public String[] getColumnClues() {
        int cols = solution[0].length;
        String[] clues = new String[cols];
        return getColumnClues(clues,0);
    }


    /**
     * Returns the column clues of the puzzle solution
     * @return the column clues of the puzzle solution
     */
    public String[] getColumnClues(String[] clues, int col) {
        int rows = solution.length;
        int cols = solution[0].length;
        int count;
        int row;


        if (col<cols) {
            clues[col] = "";
            row = 0;
            count = 0;
            while (row < rows) {
                while (row < rows && solution[row][col] == 0) {
                    row++;
                }
                while (row < rows && solution[row][col] == 1) {
                    row++;
                    count++;
                }
                clues[col] += (count > 0) ? count + " " : "";
                count = 0;
            }
            return getColumnClues(clues,col+1);
        }
        return clues;
    }

    public void resetEntered() {
        for (int i = 0; i < entered.length; i++)
            for (int j = 0; j < entered[i].length; j++)
                entered[i][j] = 0;
    }


    public void toggleCell(int inputRow, int inputCol) {
        inputCol = inputCol-1;
        inputRow = inputRow-1;

        for (int i = 0; i < entered.length; i++) {
            for (int j = 0; j < entered[i].length; j++) {
                if (i == inputRow && j == inputCol)
                    if (entered[i][j] == 0)
                        entered[i][j] = 1;
                    else if (entered[i][j] == 1)
                        entered[i][j] = 0;
                System.out.print(entered[i][j]);
            }
            System.out.println();
        }

    }


    boolean puzzleSolved() {

        int counter = 0;
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[i].length; j++) {
                if (solution[i][j] == entered[i][j]) {
                    System.out.println(solution[i][j] + " " + entered[i][j]);

                    counter++;
                    System.out.println(counter + " " + solution.length*solution.length);
                }
            }
        }

        if(counter==solution.length*solution.length) {
            return true;
        } else
            return false;

    }

    public int[][] getSolution() {
        return solution;
    }


}
