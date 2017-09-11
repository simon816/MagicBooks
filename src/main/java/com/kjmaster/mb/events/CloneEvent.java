package com.kjmaster.mb.events;


import com.kjmaster.mb.chosenspells.chosenspell.ChosenSpellProvider;
import com.kjmaster.mb.chosenspells.chosenspell.IChosenSpell;
import com.kjmaster.mb.chosenspells.chosenspell2.ChosenSpell2Provider;
import com.kjmaster.mb.chosenspells.chosenspell2.IChosenSpell2;
import com.kjmaster.mb.chosenspells.chosenspell3.ChosenSpell3Provider;
import com.kjmaster.mb.chosenspells.chosenspell3.IChosenSpell3;
import com.kjmaster.mb.chosenspells.chosenspell4.ChosenSpell4Provider;
import com.kjmaster.mb.chosenspells.chosenspell4.IChosenSpell4;
import com.kjmaster.mb.chosenspells.chosenspell5.ChosenSpell5Provider;
import com.kjmaster.mb.chosenspells.chosenspell5.IChosenSpell5;
import com.kjmaster.mb.chosenspells.chosenspell6.ChosenSpell6Provider;
import com.kjmaster.mb.chosenspells.chosenspell6.IChosenSpell6;
import com.kjmaster.mb.chosenspells.chosenspell7.ChosenSpell7Provider;
import com.kjmaster.mb.chosenspells.chosenspell7.IChosenSpell7;
import com.kjmaster.mb.chosenspells.chosenspell8.ChosenSpell8Provider;
import com.kjmaster.mb.chosenspells.chosenspell8.IChosenSpell8;
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
        if(event.isWasDeath()) {
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
            //Clone Chosen Spells
            //1
            IChosenSpell chosenSpell = player.getCapability(ChosenSpellProvider.CHOSENSPELL_CAP, null);
            IChosenSpell oldChosenSpell = event.getOriginal().getCapability(ChosenSpellProvider.CHOSENSPELL_CAP, null);
            chosenSpell.setChosenSpell(oldChosenSpell.getChosenSpell());
            //2
            IChosenSpell2 chosenSpell2 = player.getCapability(ChosenSpell2Provider.CHOSENSPELL2_CAP, null);
            IChosenSpell2 oldChosenSpell2 = event.getOriginal().getCapability(ChosenSpell2Provider.CHOSENSPELL2_CAP, null);
            chosenSpell2.setChosenSpell2(oldChosenSpell2.getChosenSpell2());
            //3
            IChosenSpell3 chosenSpell3 = player.getCapability(ChosenSpell3Provider.CHOSENSPELL3_CAP, null);
            IChosenSpell3 oldChosenSpell3 = event.getOriginal().getCapability(ChosenSpell3Provider.CHOSENSPELL3_CAP, null);
            chosenSpell3.setChosenSpell3(oldChosenSpell3.getChosenSpell3());
            //4
            IChosenSpell4 chosenSpell4 = player.getCapability(ChosenSpell4Provider.CHOSENSPELL4_CAP, null);
            IChosenSpell4 oldChosenSpell4 = event.getOriginal().getCapability(ChosenSpell4Provider.CHOSENSPELL4_CAP, null);
            chosenSpell4.setChosenSpell4(oldChosenSpell4.getChosenSpell4());
            //5
            IChosenSpell5 chosenSpell5 = player.getCapability(ChosenSpell5Provider.CHOSENSPELL5_CAP, null);
            IChosenSpell5 oldChosenSpell5 = event.getOriginal().getCapability(ChosenSpell5Provider.CHOSENSPELL5_CAP, null);
            chosenSpell5.setChosenSpell5(oldChosenSpell5.getChosenSpell5());
            //6
            IChosenSpell6 chosenSpell6 = player.getCapability(ChosenSpell6Provider.CHOSENSPELL6_CAP, null);
            IChosenSpell6 oldChosenSpell6 = event.getOriginal().getCapability(ChosenSpell6Provider.CHOSENSPELL6_CAP, null);
            chosenSpell6.setChosenSpell6(oldChosenSpell6.getChosenSpell6());
            //7
            IChosenSpell7 chosenSpell7 = player.getCapability(ChosenSpell7Provider.CHOSENSPELL7_CAP, null);
            IChosenSpell7 oldChosenSpell7 = event.getOriginal().getCapability(ChosenSpell7Provider.CHOSENSPELL7_CAP, null);
            chosenSpell7.setChosenSpell7(oldChosenSpell7.getChosenSpell7());
            //8
            IChosenSpell8 chosenSpell8 = player.getCapability(ChosenSpell8Provider.CHOSENSPELL8_CAP, null);
            IChosenSpell8 oldChosenSpell8 = event.getOriginal().getCapability(ChosenSpell8Provider.CHOSENSPELL8_CAP, null);
            chosenSpell8.setChosenSpell8(oldChosenSpell8.getChosenSpell8());
        }
    }
}
