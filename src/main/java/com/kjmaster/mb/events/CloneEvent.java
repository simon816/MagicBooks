package com.kjmaster.mb.events;


import com.kjmaster.mb.skillpoints.air.AirSkillPointsProvider;
import com.kjmaster.mb.skillpoints.air.IAirSkillPoints;
import com.kjmaster.mb.skillpoints.earth.EarthSkillPointsProvider;
import com.kjmaster.mb.skillpoints.earth.IEarthSkillPoints;
import com.kjmaster.mb.skillpoints.fire.FireSkillPointsProvider;
import com.kjmaster.mb.skillpoints.fire.IFireSkillPoints;
import com.kjmaster.mb.skillpoints.water.IWaterSkillPoints;
import com.kjmaster.mb.skillpoints.water.WaterSkillPoints;
import com.kjmaster.mb.skillpoints.water.WaterSkillPointsProvider;
import com.kjmaster.mb.spellmanager.Invisibility.IInvisibilityManager;
import com.kjmaster.mb.spellmanager.Invisibility.InvisibilityManagerProvider;
import com.kjmaster.mb.spellmanager.bone.BoneMealManagerProvider;
import com.kjmaster.mb.spellmanager.bone.IBoneMealManager;
import com.kjmaster.mb.spellmanager.lightning.ILightningManager;
import com.kjmaster.mb.spellmanager.lightning.LightningManagerProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

/**
 * Created by pbill_000 on 11/06/2017.
 */
public class CloneEvent {
    @SubscribeEvent
    public final void onClone(PlayerEvent.Clone event) {
        EntityPlayer player = event.getEntityPlayer();
        IAirSkillPoints airSkillPoints = player.getCapability(AirSkillPointsProvider.AIRSKILLPOINTS_CAP, null);
        IAirSkillPoints oldAirSkillPoints = event.getOriginal().getCapability(AirSkillPointsProvider.AIRSKILLPOINTS_CAP, null);
        airSkillPoints.setAir(oldAirSkillPoints.getAirSkillPoints());
        IEarthSkillPoints earthSkillPoints = player.getCapability(EarthSkillPointsProvider.EARTHSKILLPOINTS_CAP, null);
        IEarthSkillPoints oldEarthSkillPoints = event.getOriginal().getCapability(EarthSkillPointsProvider.EARTHSKILLPOINTS_CAP, null);
        earthSkillPoints.setEarth(oldEarthSkillPoints.getEarthSkillPoints());
        IFireSkillPoints fireSkillPoints = player.getCapability(FireSkillPointsProvider.FIRESKILLPOINTS_CAP, null);
        IFireSkillPoints oldFireSkillPoints = event.getOriginal().getCapability(FireSkillPointsProvider.FIRESKILLPOINTS_CAP, null);
        fireSkillPoints.setFire(oldFireSkillPoints.getFireSkillPoints());
        IWaterSkillPoints waterSkillPoints = player.getCapability(WaterSkillPointsProvider.WATERSKILLPOINTS_CAP, null);
        IWaterSkillPoints oldWaterSkillPoints = event.getOriginal().getCapability(WaterSkillPointsProvider.WATERSKILLPOINTS_CAP, null);
        waterSkillPoints.setWater(oldWaterSkillPoints.getWaterSkillPoints());
        IBoneMealManager bonePoints = player.getCapability(BoneMealManagerProvider.SPELL_MANAGER_CAP, null);
        IBoneMealManager oldBonePoints = event.getOriginal().getCapability(BoneMealManagerProvider.SPELL_MANAGER_CAP, null);
        bonePoints.setBonemeal(oldBonePoints.getBonemeal());
        IInvisibilityManager invisPoints = player.getCapability(InvisibilityManagerProvider.INVISIBILITY_MANAGER_CAP, null);
        IInvisibilityManager oldInvisPoints = event.getOriginal().getCapability(InvisibilityManagerProvider.INVISIBILITY_MANAGER_CAP, null);
        invisPoints.setInvisibility(oldInvisPoints.getInvisibility());
        ILightningManager lightPoints = player.getCapability(LightningManagerProvider.LIGHTNING_MANAGER_CAPABILITY, null);
        ILightningManager oldLightPoints = event.getOriginal().getCapability(LightningManagerProvider.LIGHTNING_MANAGER_CAPABILITY, null);
        lightPoints.setLightning(oldLightPoints.getLightning());
    }
}
