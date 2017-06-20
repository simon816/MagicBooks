package com.kjmaster.mb.events;


import com.kjmaster.mb.skillpoints.air.AirSkillPointsProvider;
import com.kjmaster.mb.skillpoints.air.IAirSkillPoints;
import com.kjmaster.mb.skillpoints.earth.EarthSkillPointsProvider;
import com.kjmaster.mb.skillpoints.earth.IEarthSkillPoints;
import com.kjmaster.mb.skillpoints.fire.FireSkillPointsProvider;
import com.kjmaster.mb.skillpoints.fire.IFireSkillPoints;
import com.kjmaster.mb.skillpoints.water.IWaterSkillPoints;
import com.kjmaster.mb.skillpoints.water.WaterSkillPointsProvider;
import com.kjmaster.mb.spellmanager.air.Invisibility.IInvisibilityManager;
import com.kjmaster.mb.spellmanager.air.Invisibility.InvisibilityManagerProvider;
import com.kjmaster.mb.spellmanager.earth.bone.BoneMealManagerProvider;
import com.kjmaster.mb.spellmanager.earth.bone.IBoneMealManager;
import com.kjmaster.mb.spellmanager.air.lightning.ILightningManager;
import com.kjmaster.mb.spellmanager.air.lightning.LightningManagerProvider;
import com.kjmaster.mb.spellmanager.fire.fireblast.FireBlastManagerProvider;
import com.kjmaster.mb.spellmanager.fire.fireblast.IFireBlastManager;
import com.kjmaster.mb.spellmanager.water.waterwolf.IWaterWolfManager;
import com.kjmaster.mb.spellmanager.water.waterwolf.WaterWolfManagerProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by pbill_000 on 11/06/2017.
 */
public class CloneEvent {
    @SubscribeEvent
    public final void onClone(PlayerEvent.Clone event) {
        EntityPlayer player = event.getEntityPlayer();
        //Clone Skillpoints
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
        //Clone Earth Spells
        IBoneMealManager bonePoints = player.getCapability(BoneMealManagerProvider.SPELL_MANAGER_CAP, null);
        IBoneMealManager oldBonePoints = event.getOriginal().getCapability(BoneMealManagerProvider.SPELL_MANAGER_CAP, null);
        bonePoints.setBonemeal(oldBonePoints.getBonemeal());
        //Clone Air Spells
        IInvisibilityManager invisPoints = player.getCapability(InvisibilityManagerProvider.INVISIBILITY_MANAGER_CAP, null);
        IInvisibilityManager oldInvisPoints = event.getOriginal().getCapability(InvisibilityManagerProvider.INVISIBILITY_MANAGER_CAP, null);
        invisPoints.setInvisibility(oldInvisPoints.getInvisibility());
        ILightningManager lightPoints = player.getCapability(LightningManagerProvider.LIGHTNING_MANAGER_CAPABILITY, null);
        ILightningManager oldLightPoints = event.getOriginal().getCapability(LightningManagerProvider.LIGHTNING_MANAGER_CAPABILITY, null);
        lightPoints.setLightning(oldLightPoints.getLightning());
        //Clone Fire Spells
        IFireBlastManager firePoints = player.getCapability(FireBlastManagerProvider.FIREBLAST_MANAGER_CAP, null);
        IFireBlastManager oldFirePoints = event.getOriginal().getCapability(FireBlastManagerProvider.FIREBLAST_MANAGER_CAP, null);
        firePoints.setFireBlast(oldFirePoints.getFireBlast());
        //Clone Water Spells
        IWaterWolfManager waterWolfPoints = player.getCapability(WaterWolfManagerProvider.WATERWOLF_MANAGER_CAP, null);
        IWaterWolfManager oldWaterWolfPoints = event.getOriginal().getCapability(WaterWolfManagerProvider.WATERWOLF_MANAGER_CAP, null);
        waterWolfPoints.setWaterWolf(oldWaterWolfPoints.getWaterWolf());
    }
}
