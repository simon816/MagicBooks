package com.kjmaster.mb.spellmanager.air.Invisibility;

/**
 * Created by pbill_000 on 10/06/2017.
 */
public interface IInvisibilityManager {
    public void consumeInvisibility(float points);
    public void addInvisibility(float points);
    public void setInvisibility(float points);

    public float getInvisibility();
}
