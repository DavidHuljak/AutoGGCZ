package me.attex.autoggcz;

import net.minecraftforge.fml.common.event.*;
import net.minecraft.client.*;
import net.minecraftforge.common.*;
import net.minecraftforge.fml.common.*;

@Mod(name = "AutoGGCZ", modid = "autoggcz", version = "1.0", acceptedMinecraftVersions = "[1.8.9]")
public class AutoGGCZ {
	public static final String NAME = "AutoGGCZ";
    public static final String MODID = "autogg";
    public static final String VERSION = "1.0";
    public String name;
    
    public AutoGGCZ() {
        this.name = "";
    }
    
    @Mod.EventHandler
    public void init(final FMLInitializationEvent event) {
        this.name = Minecraft.getMinecraft().getSession().getUsername();
        this.register(new Handler());
        System.out.println("AutoGGCZ Loaded!");
    }
    
    public void register(final Object o) {
        MinecraftForge.EVENT_BUS.register(o);
        FMLCommonHandler.instance().bus().register(o);
    }
}

    
