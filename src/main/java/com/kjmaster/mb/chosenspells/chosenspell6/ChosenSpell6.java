package com.kjmaster.mb.chosenspells.chosenspell6;

/**
 * Created by pbill_000 on 26/07/2017.
 */
public class ChosenSpell6 implements IChosenSpell6 {
    private String chosenSpell6 = "nothing";

    @Override
    public void setChosenSpell6(String chosenSpell6) {
        this.chosenSpell6 = chosenSpell6;
    }

    @Override
    public String getChosenSpell6() {
        return this.chosenSpell6;
    }
}
