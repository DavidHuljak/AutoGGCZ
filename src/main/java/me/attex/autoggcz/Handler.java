package me.attex.autoggcz;

import net.minecraft.client.settings.*;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import net.minecraft.client.*;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraftforge.client.event.*;

public class Handler
{
	    public boolean isOn;
	    private final Minecraft mc;
	    
	    public Handler() {
	        this.isOn = true;
	        this.mc = Minecraft.getMinecraft();
	    }
	    
	    @SubscribeEvent
	    public void playerLoggedIn(final FMLNetworkEvent.ClientConnectedToServerEvent event) {
	        if (!this.mc.isSingleplayer() && event.manager.getRemoteAddress().toString().toLowerCase().contains("qplay.cz") || 
	        		event.manager.getRemoteAddress().toString().toLowerCase().contains("survival-games.cz")) {
	        	this.isOn = true;
	        } else {
	        	this.isOn = false;
	        }
	    }
	    				
	    @SubscribeEvent
	    public void sendGG(final ClientChatReceivedEvent e) {
	        if (this.isOn) {
	            final AutoGGCZ l = new AutoGGCZ();
	            //QPlay
	            if (e.message.getUnformattedText().contains("Winner:") || 
	            		e.message.getUnformattedText().contains("Winners:") || 
				e.message.getUnformattedText().contains("Server is restarting in 20 seconds") ||
	            //Survival Games
	            		e.message.getUnformattedText().contains("Game is still in progress...") ||
	            		e.message.getUnformattedText().contains("Rank Bonus")) {
	                Minecraft.getMinecraft().thePlayer.sendChatMessage("gg");
	            }
	        }
	    }
	    
	    
	    
	   
	}
