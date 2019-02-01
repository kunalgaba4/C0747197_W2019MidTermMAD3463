package com.lambton.magicalCardGame;

public class MagicalCardGameCalculator implements MagicalCardGameInterface {
    @Override
    public String[][] getFirstShuffleResult(MagicalCardGameModel magicalCardGameModel) {
        String[][] finalMatrix = tranposeMatrix(magicalCardGameModel.getCardList());
        if (magicalCardGameModel.getFirstShuffleColPos().equalsIgnoreCase("1")){
            finalMatrix=interchangeRows(finalMatrix,1,2);
        }else if (magicalCardGameModel.getFirstShuffleColPos().equalsIgnoreCase("2")){
            finalMatrix=interchangeRows(finalMatrix,1,2);
        }else if (magicalCardGameModel.getFirstShuffleColPos().equalsIgnoreCase("3")){
            finalMatrix=interchangeRows(finalMatrix,1,2);
            finalMatrix=interchangeRows(finalMatrix,2,3);
        }
        return finalMatrix;
    }

    @Override
    public String[][] getSecShuffleResult(MagicalCardGameModel magicalCardGameModel) {
        String[][] finalMatrix = tranposeMatrix(magicalCardGameModel.getFirstShuffle());
        if (magicalCardGameModel.getSecShuffleColPos().equalsIgnoreCase("1")){
            finalMatrix=interchangeRows(finalMatrix,1,2);
        }else if (magicalCardGameModel.getSecShuffleColPos().equalsIgnoreCase("2")){
            finalMatrix=interchangeRows(finalMatrix,1,2);
        }else if (magicalCardGameModel.getSecShuffleColPos().equalsIgnoreCase("3")){
            finalMatrix=interchangeRows(finalMatrix,1,2);
            finalMatrix=interchangeRows(finalMatrix,2,3);
        }
        return finalMatrix;
    }

    @Override
    public String getFinalResult(MagicalCardGameModel magicalCardGameModel) {
        return null;
    }

    private String[][] tranposeMatrix(String[][] cardList) {
        String transpose[][] = new String[3][3];
        for (int i = 0; i < cardList.length; i++) {
            for (int j = 0; j < cardList[i].length; j++) {
                transpose[i][j] = cardList[j][i];
            }
        }
        return transpose;
    }
    private  String[][] interchangeRows(String[][] transpose, int x, int y) {

        //x for 1 y for 2
        String temp;
        String[][] tranposedMatrix= transpose;
        for(int i = 0; i < 3; i++)
        {
            temp = tranposedMatrix[(x-1)][i];
            tranposedMatrix[x-1][i] = tranposedMatrix[y-1][i];
            tranposedMatrix[y-1][i] = temp;
        }
        return tranposedMatrix;
    }
}
