package com.kjmaster.mb.chosenspells.chosenspell5;

/**
 * Created by pbill_000 on 26/07/2017.
 */
public class ChosenSpell5 implements IChosenSpell5 {
    private String chosenSpell5 = "nothing";

    @Override
    public void setChosenSpell5(String chosenSpell5) {
        this.chosenSpell5 = chosenSpell5;
    }

    @Override
    public String getChosenSpell5() {
        return this.chosenSpell5;
    }
}
