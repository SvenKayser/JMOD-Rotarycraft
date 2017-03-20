package com.jeffpeng.jmod.rotarycraft;

import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;

import com.jeffpeng.jmod.JMODPlugin;
import com.jeffpeng.jmod.JMODPluginContainer;
import com.jeffpeng.jmod.API.forgeevents.JMODPatchToolEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class Plugin extends JMODPlugin {

	public Plugin(JMODPluginContainer container) {
		super(container);
		// TODO Auto-generated constructor stub
	}
	
	@SubscribeEvent
	public void patchTool(JMODPatchToolEvent e){
		Item item = e.item;
		
		if (item instanceof ItemTool || item instanceof ItemHoe || item instanceof ItemSword) {
			if (item.getClass().getCanonicalName().contains("Reika.RotaryCraft")) {
				//Nope, we don't patch RotaryCraft tools, so we just pretend we did.
				e.setCanceled(true); 
			}
		}
	}

}
