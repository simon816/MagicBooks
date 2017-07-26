package com.kjmaster.mb.chosenspells.chosenspell4;

import com.kjmaster.mb.chosenspells.chosenspell2.IChosenSpell2;

/**
 * Created by pbill_000 on 26/07/2017.
 */
public class ChosenSpell4 implements IChosenSpell4 {
    private String chosenSpell4 = "nothing";

    @Override
    public void setChosenSpell4(String chosenSpell4) {
        this.chosenSpell4 = chosenSpell4;
    }

    @Override
    public String getChosenSpell4() {
        return this.chosenSpell4;
    }
}
