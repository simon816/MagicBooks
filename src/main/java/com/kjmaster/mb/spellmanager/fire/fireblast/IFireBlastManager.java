package com.kjmaster.mb.spellmanager.fire.fireblast;

/**
 * Created by pbill_000 on 12/06/2017.
 */

public interface IFireBlastManager {
    public void consumeFireBlast(float points);
    public void addFireBlast(float points);
    public void setFireBlast(float points);

    public float getFireBlast();
}