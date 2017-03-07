package com.jeffpeng.jmod.rotarycraft;

import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;

import com.jeffpeng.jmod.JMODPlugin;
import com.jeffpeng.jmod.JMODPluginContainer;

public class Plugin extends JMODPlugin {

	public Plugin(JMODPluginContainer container) {
		super(container);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean patchTool(Item item, String itemname){
		
		if (item instanceof ItemTool || item instanceof ItemHoe || item instanceof ItemSword) {
			if (item.getClass().getCanonicalName().contains("Reika.RotaryCraft")) {
				//Nope, we don't patch RotaryCraft tools, so we just pretend we did.
				return true;
			}
		}
		return false;
	}

}
