package com.kjmaster.mb.handlers;

import com.kjmaster.mb.Ref;
import com.kjmaster.mb.chosenspells.chosenspell.ChosenSpellProvider;
import com.kjmaster.mb.chosenspells.chosenspell2.ChosenSpell2Provider;
import com.kjmaster.mb.chosenspells.chosenspell3.ChosenSpell3Provider;
import com.kjmaster.mb.chosenspells.chosenspell4.ChosenSpell4Provider;
import com.kjmaster.mb.chosenspells.chosenspell5.ChosenSpell5Provider;
import com.kjmaster.mb.chosenspells.chosenspell6.ChosenSpell6Provider;
import com.kjmaster.mb.chosenspells.chosenspell7.ChosenSpell7Provider;
import com.kjmaster.mb.chosenspells.chosenspell8.ChosenSpell8Provider;
import com.kjmaster.mb.skillpoints.air.AirSkillPointsProvider;
import com.kjmaster.mb.skillpoints.earth.EarthSkillPointsProvider;
import com.kjmaster.mb.skillpoints.fire.FireSkillPointsProvider;
import com.kjmaster.mb.skillpoints.water.WaterSkillPointsProvider;
import com.kjmaster.mb.spellmanager.air.Invisibility.InvisibilityManagerProvider;
import com.kjmaster.mb.spellmanager.earth.bone.BoneMealManagerProvider;
import com.kjmaster.mb.spellmanager.earth.clearwall.ClearWallManagerProvider;
import com.kjmaster.mb.spellmanager.fire.fireblast.FireBlastManagerProvider;
import com.kjmaster.mb.spellmanager.air.lightning.LightningManagerProvider;
import com.kjmaster.mb.spellmanager.water.waterwolf.WaterWolfManagerProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


/**
 * Created by pbill_000 on 14/06/2017.
 */
public class CapabilityHandler {
    public static final ResourceLocation AIRSKILLPOINTS_CAP = new ResourceLocation(Ref.MODID, "AirSkillPoints");
    public static final ResourceLocation EARTHSKILLPOINTS_CAP = new ResourceLocation(Ref.MODID, "EarthSkillPoints" );
    public static final ResourceLocation FIRESKILLPOINTS_CAP = new ResourceLocation(Ref.MODID, "FireSkillPoints" );
    public static final ResourceLocation WATERSKILLPOINTS_CAP = new ResourceLocation(Ref.MODID, "WaterSkillPoints" );
    public static final ResourceLocation SPELL_MANAGER_CAP = new ResourceLocation(Ref.MODID, "BonemealUnlocked" );
    public static final ResourceLocation INVISIBILITY_MANAGER_CAP = new ResourceLocation(Ref.MODID, "InvisibilityUnlocked");
    public static final ResourceLocation LIGHTNING_MANAGER_CAP = new ResourceLocation(Ref.MODID, "LightningUnlocked");
    public static final ResourceLocation FIREBLAST_MANAGER_CAP = new ResourceLocation(Ref.MODID, "FireBlastUnlocked");
    public static final ResourceLocation WATERWOLF_MANAGER_CAP = new ResourceLocation(Ref.MODID, "WaterWolfUnlocked");
    public static final ResourceLocation CLEARWALL_MANAGER_CAP = new ResourceLocation(Ref.MODID, "ClearWallUnlocked");
    public static final ResourceLocation CHOSENSPELL_MANAGER_CAP = new ResourceLocation(Ref.MODID, "ChosenSpell");
    public static final ResourceLocation CHOSENSPELL2_MANAGER_CAP = new ResourceLocation(Ref.MODID, "ChosenSpell2");
    public static final ResourceLocation CHOSENSPELL3_MANAGER_CAP = new ResourceLocation(Ref.MODID, "ChosenSpell3");
    public static final ResourceLocation CHOSENSPELL4_MANAGER_CAP = new ResourceLocation(Ref.MODID, "ChosenSpell4");
    public static final ResourceLocation CHOSENSPELL5_MANAGER_CAP = new ResourceLocation(Ref.MODID, "ChosenSpell5");
    public static final ResourceLocation CHOSENSPELL6_MANAGER_CAP = new ResourceLocation(Ref.MODID, "ChosenSpell6");
    public static final ResourceLocation CHOSENSPELL7_MANAGER_CAP = new ResourceLocation(Ref.MODID, "ChosenSpell7");
    public static final ResourceLocation CHOSENSPELL8_MANAGER_CAP = new ResourceLocation(Ref.MODID, "ChosenSpell8");
    @SubscribeEvent
    public void  attachCapability(AttachCapabilitiesEvent<Entity> event) {
        if (!(event.getObject() instanceof EntityPlayer)) return;
            event.addCapability(AIRSKILLPOINTS_CAP, new AirSkillPointsProvider());
            event.addCapability(EARTHSKILLPOINTS_CAP, new EarthSkillPointsProvider());
            event.addCapability(FIRESKILLPOINTS_CAP, new FireSkillPointsProvider());
            event.addCapability(WATERSKILLPOINTS_CAP, new WaterSkillPointsProvider());
            event.addCapability(SPELL_MANAGER_CAP, new BoneMealManagerProvider());
            event.addCapability(INVISIBILITY_MANAGER_CAP, new InvisibilityManagerProvider());
            event.addCapability(LIGHTNING_MANAGER_CAP, new LightningManagerProvider());
            event.addCapability(FIREBLAST_MANAGER_CAP, new FireBlastManagerProvider());
            event.addCapability(WATERWOLF_MANAGER_CAP, new WaterWolfManagerProvider());
            event.addCapability(CLEARWALL_MANAGER_CAP, new ClearWallManagerProvider());
            event.addCapability(CHOSENSPELL_MANAGER_CAP, new ChosenSpellProvider());
            event.addCapability(CHOSENSPELL2_MANAGER_CAP, new ChosenSpell2Provider());
            event.addCapability(CHOSENSPELL3_MANAGER_CAP, new ChosenSpell3Provider());
            event.addCapability(CHOSENSPELL4_MANAGER_CAP, new ChosenSpell4Provider());
            event.addCapability(CHOSENSPELL5_MANAGER_CAP, new ChosenSpell5Provider());
            event.addCapability(CHOSENSPELL6_MANAGER_CAP, new ChosenSpell6Provider());
            event.addCapability(CHOSENSPELL7_MANAGER_CAP, new ChosenSpell7Provider());
            event.addCapability(CHOSENSPELL8_MANAGER_CAP, new ChosenSpell8Provider());
    }
}
