package com.lambton.magicalCardGame;

import java.util.Scanner;

public class MagicMain {

    public static void main(String args[]){
        MagicalCardGameModel magicalCardGameModel= new MagicalCardGameModel();
        String[][] cardList={{ "1", "2", "3" }, { "4", "5", "6" }, { "7", "8", "9" }};
        magicalCardGameModel.setCardList(cardList);
        displayMatrix(magicalCardGameModel.getCardList());
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the column which contains your card");
        magicalCardGameModel.setFirstShuffleColPos(sc.next());

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
