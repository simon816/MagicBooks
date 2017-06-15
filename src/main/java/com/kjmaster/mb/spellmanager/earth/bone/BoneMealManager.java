package com.kjmaster.mb.spellmanager.earth.bone;

/**
 * Created by pbill_000 on 08/06/2017.
 */
public class BoneMealManager implements IBoneMealManager {
    private float bonemealpoints = 0F;


    @Override
    public void consumeBonemeal(float points) {
        this.bonemealpoints -= points;
        if (this.bonemealpoints < 0F) this.bonemealpoints = 0F;
    }

    @Override
    public void addBonemeal(float points) {
        this.bonemealpoints += points;

    }

    @Override
    public void setBonemeal(float points) {
        this.bonemealpoints = points;
    }

    @Override
    public float getBonemeal() { return this.bonemealpoints;}

}

