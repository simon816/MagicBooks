package com.kjmaster.mb.chosenspells.chosenspell8;

import com.kjmaster.mb.chosenspells.chosenspell2.IChosenSpell2;

/**
 * Created by pbill_000 on 26/07/2017.
 */
public class ChosenSpell8 implements IChosenSpell8 {
    private String chosenSpell8 = "nothing";

    @Override
    public void setChosenSpell8(String chosenSpell8) {
        this.chosenSpell8 = chosenSpell8;
    }

    @Override
    public String getChosenSpell8() {
        return this.chosenSpell8;
    }
}
