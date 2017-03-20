package com.jeffpeng.jmod.rotarycraft.actions;

import java.util.List;

import net.minecraft.item.ItemStack;
import Reika.RotaryCraft.API.RecipeInterface;

import com.jeffpeng.jmod.JMODRepresentation;
import com.jeffpeng.jmod.descriptors.ItemStackDescriptor;
import com.jeffpeng.jmod.primitives.BasicAction;

import cpw.mods.fml.common.event.FMLLoadCompleteEvent;

public class AddGrinderRecipe extends BasicAction {
	
	private ItemStackDescriptor inIsd;
	private ItemStackDescriptor outIsd;
	
	public AddGrinderRecipe(JMODRepresentation owner, ItemStackDescriptor out, ItemStackDescriptor in){
		super(owner);
		this.inIsd = in;
		this.outIsd = out;
	}
	
	@Override
	public boolean on(FMLLoadCompleteEvent event){
		valid = false;
		List<ItemStack> inIsl = inIsd.getItemStackList();
		ItemStack outIs = outIsd.toItemStack();
		
		if(outIs != null){
			inIsl.forEach((v) -> {
				RecipeInterface.grinder.addAPIRecipe(v, outIs);
			});
		}
		return valid;
	}
}
