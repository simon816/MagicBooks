package com.kjmaster.mb.spellmanager.fireblast;

/**
 * Created by pbill_000 on 12/06/2017.
 */
public class FireBlastManager implements IFireBlastManager {
    private float fireblastpoints = 0F;


    @Override
    public void consumeFireBlast(float points) {
        this.fireblastpoints -= points;
        if (this.fireblastpoints < 0F) this.fireblastpoints = 0F;
    }

    @Override
    public void addFireBlast(float points) {
        this.fireblastpoints += points;

    }

    @Override
    public void setFireBlast(float points) {
        this.fireblastpoints = points;
    }

    @Override
    public float getFireBlast() { return this.fireblastpoints;}

}
