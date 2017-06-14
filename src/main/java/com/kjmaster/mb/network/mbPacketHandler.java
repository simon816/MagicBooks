package com.kjmaster.mb.network;

import com.kjmaster.mb.Ref;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

/**
 * Created by pbill_000 on 07/06/2017.
 */
public class mbPacketHandler {
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Ref.MODID);

}
