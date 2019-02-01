package com.lambton.magicalCardGame;

import java.util.Scanner;

public class MagicMain {

    private static String[][] cardList;
    private static Scanner sc;

    public static void main(String args[]) {
        MagicalCardGameModel magicalCardGameModel = new MagicalCardGameModel();
        MagicalCardGameCalculator magicalCardGameCalculator = new MagicalCardGameCalculator();

        cardList = new String[3][3];
        sc = new Scanner(System.in);
        System.out.println("Enter the 3*3 matrix values");
        enterMatrixData(sc, cardList);
        magicalCardGameModel.setCardList(cardList);
        displayMatrix(magicalCardGameModel.getCardList());

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the column which contains your card");
        String columnNumber = sc.nextLine();
        if ((columnNumber.equalsIgnoreCase("c1"))
                || (columnNumber.equalsIgnoreCase("c2"))
                || (columnNumber.equalsIgnoreCase("c3"))) {

        } else {
            throw new IllegalArgumentException("You can only enter columns like c1, c2, c3");
        }
        magicalCardGameModel.setFirstShuffleColPos(columnNumber);
        magicalCardGameModel.setFirstShuffle(magicalCardGameCalculator.getFirstShuffleResult(magicalCardGameModel));
        displayMatrix(magicalCardGameModel.getFirstShuffle());

        System.out.println("Enter the column which contains your card");
        columnNumber = sc.nextLine();
        if ((columnNumber.equalsIgnoreCase("c1"))
                || (columnNumber.equalsIgnoreCase("c2"))
                || (columnNumber.equalsIgnoreCase("c3"))) {

        } else {
            throw new IllegalArgumentException("You can only enter columns like c1, c2, c3");
        }
        magicalCardGameModel.setSecShuffleColPos(columnNumber);
        magicalCardGameModel.setSecShuffle(magicalCardGameCalculator.getSecShuffleResult(magicalCardGameModel));
        displayMatrix(magicalCardGameModel.getSecShuffle());

        magicalCardGameModel.setGuessedCard(magicalCardGameCalculator.getFinalResult(magicalCardGameModel));
        System.out.println("Your Gueesed Card is: " + magicalCardGameModel.getGuessedCard());


    }

    public static void enterMatrixData(Scanner scan, String[][] matrix) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = scan.nextLine();
            }
        }
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
