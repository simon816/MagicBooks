package com.kjmaster.mb.skillpoints.earth;

/**
 * Created by pbill_000 on 06/06/2017.
 */
public class EarthSkillPoints implements IEarthSkillPoints {
    private float earthskillpoints = 0F;

    public void consumeEarth(float points) {
        this.earthskillpoints -= points;
        if (this.earthskillpoints < 0F) this.earthskillpoints = 0F;
    }
    public void addEarth(float points) {
        this. earthskillpoints += points;
    }

    public void setEarth(float points) {
        this.earthskillpoints = points;
    }

    public float getEarthSkillPoints() {
        return this.earthskillpoints;
    }
}