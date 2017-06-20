package com.kjmaster.mb.spellmanager.water.waterwolf;

/**
 * Created by pbill_000 on 18/06/2017.
 */
public class WaterWolfManager implements IWaterWolfManager {
    private float waterwolfpoints = 0F;


    @Override
    public void consumeWaterWolf(float points) {
        this.waterwolfpoints -= points;
        if (this.waterwolfpoints < 0F) this.waterwolfpoints = 0F;
    }

    @Override
    public void addWaterWolf(float points) {
        this.waterwolfpoints += points;

    }

    @Override
    public void setWaterWolf(float points) {
        this.waterwolfpoints = points;
    }

    @Override
    public float getWaterWolf() { return this.waterwolfpoints;}
}
