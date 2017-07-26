package com.kjmaster.mb.chosenspells.chosenspell2;

/**
 * Created by pbill_000 on 25/07/2017.
 */
public class ChosenSpell2 implements IChosenSpell2 {
    private String chosenSpell2 = "nothing";

    @Override
    public void setChosenSpell2(String chosenSpell2) {
        this.chosenSpell2 = chosenSpell2;
    }

    @Override
    public String getChosenSpell2() {
        return this.chosenSpell2;
    }
}
