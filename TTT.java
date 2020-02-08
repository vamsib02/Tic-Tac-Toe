package com.example.TTT;
import java.util.Scanner;
public class TTT {
    //Creates variable for turn
    public static char turn = 'X';
    //Creates integer variables for the rows and columns of the game board
    public static int row, column;
    //Allows for user input for box chosen
    public static Scanner scan = new Scanner(System.in);
    public static char[][] Board;

    public static void main(String[] args) {
        //Specifies the size of the game board
        Board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //Adds the _ marks to the game board
                Board[i][j] = '_';
            }
        }
        Play();
    }

    public static void Play() {
        boolean playing = true;
        PrintBoard();
        while (playing) {
            System.out.println("Please enter a row and column: ");
            //Sets rows and columns on a 1-3 scale
            row = scan.nextInt() - 1;
            column = scan.nextInt() - 1;
            Board[row][column] = turn;

            if (GameOver(row, column)) {
                playing = false;
                System.out.println("Game over! Player " + turn + " " + "wins!");
            }
            PrintBoard();
            if (turn == 'X')
                turn = 'O';
            else
                turn = 'X';
        }
    }
    public static void PrintBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println();
            for (int j = 0; j < 3; j++) {
                if (j == 0)
                    //Adds the Side and Middles lines for the game board
                    System.out.print("| ");
                System.out.print(Board[i][j] + " | ");
            }
        }
     System.out.println();
    }

    public static boolean GameOver(int rMove, int cMove) {
        //Checks Vertical or Horizontal Wins
        if (Board[0][cMove] == Board[1][cMove]
                && Board[0][cMove] == Board[2][cMove])
            return true;
        if (Board[rMove][0] == Board[rMove][1]
                && Board[rMove][0] == Board[rMove][2])
            return true;
        //Check Diagonal Wins
        if (Board[0][0]  == Board[1][1] && Board[0][0] == Board[2][2]
                && Board[1][1] != '_')
            return true;
        if (Board[0][2] == Board[1][1] && Board[0][2] == Board[2][0]
                && Board[1][1] != '_')
            return true;
        return false;
        }
    }

