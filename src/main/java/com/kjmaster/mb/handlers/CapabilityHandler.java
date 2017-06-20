package com.kjmaster.mb.handlers;

import com.kjmaster.mb.Ref;
import com.kjmaster.mb.skillpoints.air.AirSkillPointsProvider;
import com.kjmaster.mb.skillpoints.earth.EarthSkillPointsProvider;
import com.kjmaster.mb.skillpoints.fire.FireSkillPointsProvider;
import com.kjmaster.mb.skillpoints.water.WaterSkillPointsProvider;
import com.kjmaster.mb.spellmanager.air.Invisibility.InvisibilityManagerProvider;
import com.kjmaster.mb.spellmanager.earth.bone.BoneMealManagerProvider;
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
    }
}
