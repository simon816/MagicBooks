package com.kjmaster.mb.chosenspells.chosenspell;

/**
 * Created by pbill_000 on 25/07/2017.
 */
public class ChosenSpell implements IChosenSpell {
    private String chosenSpell = "nothing";

    @Override
    public void setChosenSpell(String chosenSpell) {
        this.chosenSpell = chosenSpell;
    }

    @Override
    public String getChosenSpell() {
        return this.chosenSpell;
    }
}
