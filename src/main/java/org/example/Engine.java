package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Engine {

    static char[][] matrix = {{' ', ' ', ' '},
                              {' ', ' ', ' '},
                              {' ', ' ', ' '}};

    public static boolean run = true;
    public static int winPlayerId;

    public static void init(){
        game();
        System.out.println();
        System.out.println("Player " + winPlayerId + " win!");
        getAllChar(matrix);
    }

    public static int game(){
        while (run){

            getAllChar(matrix);

            System.out.println();

            playerInput(1);
            if(winCheck('X')){
                break;
            }
            getAllChar(matrix);

            playerInput(2);
            if(winCheck('O')){
                break;
            }
        }
        return 0;
    }

    public static void playerInput(int player){

        System.out.println("Player " + player + ":");

        Scanner sc = new Scanner(System.in);
        int x, y;

        try {

            System.out.print("КордыX: ");
            x = sc.nextInt();

            System.out.print("КордыY: ");
            y = sc.nextInt();

        } catch (InputMismatchException e) {
            invalidInput();
            return;
        }

        //проверки
        if(x > matrix.length){
            invalidInput();
            return;
        }
        if(y > matrix.length){
            invalidInput();
            return;
        }

        if(getChar(x, y) != ' '){
            invalidInput();
            return;
        }

        if(player == 1)
            setChar(x, y, 'X');
        else
            setChar(x, y, 'O');

    }

    public static boolean winCheck(char n){
        if((getChar(1, 1) == n && getChar(2, 1) == n && getChar(3, 1) == n) ||      //1
                (getChar(1, 2) == n && getChar(2, 2) == n && getChar(3, 2) == n) || //2
                (getChar(1, 3) == n && getChar(2, 3) == n && getChar(3, 3) == n) || //3
                (getChar(1, 1) == n && getChar(1, 2) == n && getChar(1, 3) == n) || //4
                (getChar(2, 1) == n && getChar(2, 2) == n && getChar(2, 3) == n) || //5
                (getChar(3, 1) == n && getChar(3, 2) == n && getChar(3, 3) == n) || //6
                (getChar(1, 1) == n && getChar(2, 2) == n && getChar(3, 3) == n) || //7
                (getChar(1, 3) == n && getChar(2, 2) == n && getChar(3, 1) == n)) { //8
            if(n == 'X')
                winPlayerId=1;
            else
                winPlayerId=2;
            return true;
        }
        return false;
    }

    public static void invalidInput(){
        System.out.println("Invalid input. The player misses his turn.");
    }

    //getters && setters

    public static void getAllChar(char[][] matrix){
        System.out.println(" -------------");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(" | " +  matrix[i][j]);
            }
            System.out.println(" |");
            System.out.println(" -------------");
        }
    }
    public static char getChar(int x, int y){
        return matrix[y-1][x-1];
    }
    public static void setChar(int x, int y, char sign){
        matrix[y-1][x-1] = sign;
    }
}
