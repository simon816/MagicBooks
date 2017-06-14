package com.kjmaster.mb.skillpoints.air;

/**
 * Created by pbill_000 on 06/06/2017.
 */
public class AirSkillPoints implements IAirSkillPoints {
    private float airskillpoints = 0F;

    public void consumeAir(float points) {
        this.airskillpoints -= points;
        if (this.airskillpoints < 0F) this.airskillpoints = 0F;
    }
    public void addAir(float points) {
        this.airskillpoints += points;
    }

    public void setAir(float points) {
        this.airskillpoints = points;
    }

    public float getAirSkillPoints() {
        return this.airskillpoints;
    }
}
