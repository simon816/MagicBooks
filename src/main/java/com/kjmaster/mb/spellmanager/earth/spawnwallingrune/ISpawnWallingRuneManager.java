package com.kjmaster.mb.spellmanager.earth.spawnwallingrune;

/**
 * Created by pbill_000 on 21/06/2017.
 */
public interface ISpawnWallingRuneManager {
    public void consumeWallingRune(float points);
    public void addWallingRune(float points);
    public void setWallingRune(float points);

    public float getWallingRune();
}

