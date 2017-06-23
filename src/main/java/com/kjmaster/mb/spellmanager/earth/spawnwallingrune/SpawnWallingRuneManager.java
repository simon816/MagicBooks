package com.kjmaster.mb.spellmanager.earth.spawnwallingrune;

/**
 * Created by pbill_000 on 21/06/2017.
 */
public class SpawnWallingRuneManager implements ISpawnWallingRuneManager {
    private float wallingrunepoints = 0F;


    @Override
    public void consumeWallingRune(float points) {
        this.wallingrunepoints -= points;
        if (this.wallingrunepoints < 0F) this.wallingrunepoints = 0F;
    }

    @Override
    public void addWallingRune(float points) {
        this.wallingrunepoints += points;

    }

    @Override
    public void setWallingRune(float points) {
        this.wallingrunepoints = points;
    }

    @Override
    public float getWallingRune() { return this.wallingrunepoints;}

}
