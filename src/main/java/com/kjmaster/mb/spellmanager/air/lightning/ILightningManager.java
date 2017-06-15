package com.kjmaster.mb.spellmanager.air.lightning;

/**
 * Created by pbill_000 on 10/06/2017.
 */
public interface ILightningManager {
    public void consumeLightning(float points);
    public void addLightning(float points);
    public void setLightning(float points);

    public float getLightning();
}
