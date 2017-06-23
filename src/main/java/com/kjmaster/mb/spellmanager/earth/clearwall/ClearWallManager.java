package com.kjmaster.mb.spellmanager.earth.clearwall;

/**
 * Created by pbill_000 on 23/06/2017.
 */
public class ClearWallManager implements IClearWallManager {
    private float clearwallpoints = 0F;


    @Override
    public void consumeClearWall(float points) {
        this.clearwallpoints -= points;
        if (this.clearwallpoints < 0F) this.clearwallpoints = 0F;
    }

    @Override
    public void addClearWall(float points) {
        this.clearwallpoints += points;

    }

    @Override
    public void setClearWall(float points) {
        this.clearwallpoints = points;
    }

    @Override
    public float getClearWall() { return this.clearwallpoints;}

}
