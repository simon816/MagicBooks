package com.kjmaster.mb.skillpoints.water;

/**
 * Created by pbill_000 on 07/06/2017.
 */
public class WaterSkillPoints implements IWaterSkillPoints {
    private float waterskillpoints = 0F;

    public void consumeWater(float points) {
        this.waterskillpoints -= points;
        if (this.waterskillpoints < 0F) this.waterskillpoints = 0F;
    }
    public void addWater(float points) {
        this.waterskillpoints += points;
    }

    public void setWater(float points) {
        this.waterskillpoints = points;
    }

    public float getWaterSkillPoints() {
        return this.waterskillpoints;
    }
}
