package com.lambton.magicalCardGame;

import java.util.Scanner;

public class MagicMain {

    private static String[][] cardList;
    private static Scanner sc;

    public static void main(String args[]){
        MagicalCardGameModel magicalCardGameModel= new MagicalCardGameModel();
        MagicalCardGameCalculator magicalCardGameCalculator= new MagicalCardGameCalculator();

//        String[][] cardList={{ "1", "A", "5" }, { "2", "7", "3" }, { "3", "6", "K" }};
        cardList = new String[3][3];
        sc = new Scanner(System.in);
        System.out.println("Enter the 3*3 matrix values");
        enterMatrixData(sc, cardList);
        magicalCardGameModel.setCardList(cardList);
        displayMatrix(magicalCardGameModel.getCardList());

        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the column Number which contains your card");
        int num = sc.nextInt();
        String columnNumber= String.valueOf(num);
        magicalCardGameModel.setFirstShuffleColPos(columnNumber);
        magicalCardGameModel.setFirstShuffle(magicalCardGameCalculator.getFirstShuffleResult(magicalCardGameModel));
        displayMatrix(magicalCardGameModel.getFirstShuffle());

        System.out.println("Enter the column Number which contains your card");
        num = sc.nextInt();
        columnNumber= String.valueOf(num);
        magicalCardGameModel.setSecShuffleColPos(columnNumber);
        magicalCardGameModel.setSecShuffle(magicalCardGameCalculator.getSecShuffleResult(magicalCardGameModel));
        displayMatrix(magicalCardGameModel.getSecShuffle());

        magicalCardGameModel.setGuessedCard(magicalCardGameCalculator.getFinalResult(magicalCardGameModel));
        System.out.println("Your Gueesed Card is: "+magicalCardGameModel.getGuessedCard());



    }

    public static void enterMatrixData(Scanner scan, String[][] matrix){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = scan.nextLine();
            }
        }
    }

    private static void column1(String[][] cardList) {
        String transpose[][] = new String[3][3];
        for (int i = 0; i < cardList.length; i++) {
            for (int j = 0; j < cardList[i].length; j++) {
                transpose[i][j] = cardList[j][i];
            }
        }
        displayMatrix(transpose);
        interchangeColumns(transpose);
    }

    private static void interchangeColumns(String[][] transpose) {
        
        //x for 1 y for 2
        int x=1;
        int y=2;
        String temp;
        String[][] tranposedMatrix= transpose;
        for(int i = 0; i < 3; i++)
        {
            temp = tranposedMatrix[(x-1)][i];
            tranposedMatrix[x-1][i] = tranposedMatrix[y-1][i];
            tranposedMatrix[y-1][i] = temp;
        }
        displayMatrix(tranposedMatrix);
    }

    private static void displayMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
