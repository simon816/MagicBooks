package com.kjmaster.mb.spellmanager.lightning;

/**
 * Created by pbill_000 on 10/06/2017.
 */
public class LightningManager implements ILightningManager {
    private float lightningpoints = 0F;


    @Override
    public void consumeLightning(float points) {
        this.lightningpoints -= points;
        if (this.lightningpoints < 0F) this.lightningpoints = 0F;
    }

    @Override
    public void addLightning(float points) {
        this.lightningpoints += points;

    }

    @Override
    public void setLightning(float points) {
        this.lightningpoints = points;
    }

    @Override
    public float getLightning() { return this.lightningpoints;}
}
