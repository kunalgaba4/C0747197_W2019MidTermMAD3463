package com.lambton.magicalCardGame;

public interface MagicalCardGameInterface {
    public String[][] getFirstShuffleResult(MagicalCardGameModel magicalCardGameModel);

    public String[][] getSecShuffleResult(MagicalCardGameModel magicalCardGameModel);

    public String getFinalResult(MagicalCardGameModel magicalCardGameModel);
}
