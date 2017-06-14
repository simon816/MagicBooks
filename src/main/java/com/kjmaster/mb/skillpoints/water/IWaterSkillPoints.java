package com.kjmaster.mb.skillpoints.water;

/**
 * Created by pbill_000 on 07/06/2017.
 */
public interface IWaterSkillPoints {
    public void consumeWater(float points);
    public void addWater(float points);
    public void setWater(float points);

    public float getWaterSkillPoints();
}