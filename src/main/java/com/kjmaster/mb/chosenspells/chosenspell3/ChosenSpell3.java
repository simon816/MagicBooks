package com.kjmaster.mb.chosenspells.chosenspell3;

import com.kjmaster.mb.chosenspells.chosenspell2.IChosenSpell2;

/**
 * Created by pbill_000 on 26/07/2017.
 */
public class ChosenSpell3 implements IChosenSpell3 {
    private String chosenSpell3 = "nothing";

    @Override
    public void setChosenSpell3(String chosenSpell3) {
        this.chosenSpell3 = chosenSpell3;
    }

    @Override
    public String getChosenSpell3() {
        return this.chosenSpell3;
    }
}
