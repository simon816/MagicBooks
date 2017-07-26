package com.kjmaster.mb.chosenspells.chosenspell7;

/**
 * Created by pbill_000 on 26/07/2017.
 */
public class ChosenSpell7 implements IChosenSpell7 {
    private String chosenSpell7 = "nothing";

    @Override
    public void setChosenSpell7(String chosenSpell7) {
        this.chosenSpell7 = chosenSpell7;
    }

    @Override
    public String getChosenSpell7() {
        return this.chosenSpell7;
    }
}
