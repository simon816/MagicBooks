package com.kjmaster.mb.spellmanager.air.Invisibility;

/**
 * Created by pbill_000 on 10/06/2017.
 */
public class InvisibilityManager implements IInvisibilityManager {
    private float invisibilitypoints = 0F;


    @Override
    public void consumeInvisibility(float points) {
        this.invisibilitypoints -= points;
        if (this.invisibilitypoints < 0F) this.invisibilitypoints = 0F;
    }

    @Override
    public void addInvisibility(float points) {
        this.invisibilitypoints += points;

    }

    @Override
    public void setInvisibility(float points) {
        this.invisibilitypoints = points;
    }

    @Override
    public float getInvisibility() { return this.invisibilitypoints;}

}
