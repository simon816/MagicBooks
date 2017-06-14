package com.kjmaster.mb.skillpoints.fire;

/**
 * Created by pbill_000 on 07/06/2017.
 */
public class FireSkillPoints implements IFireSkillPoints {
    private float fireskillpoints = 0F;

    public void consumeFire(float points) {
        this.fireskillpoints -= points;
        if (this.fireskillpoints < 0F) this.fireskillpoints = 0F;
    }
    public void addFire(float points) {
        this.fireskillpoints += points;
    }

    public void setFire(float points) {
        this.fireskillpoints = points;
    }

    public float getFireSkillPoints() {
        return this.fireskillpoints;
    }
}
