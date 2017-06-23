package com.kjmaster.mb.spellmanager.earth.clearwall;

/**
 * Created by pbill_000 on 23/06/2017.
 */
public interface IClearWallManager {
    public void consumeClearWall(float points);
    public void addClearWall(float points);
    public void setClearWall(float points);

    public float getClearWall();
}
