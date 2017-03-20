package com.jeffpeng.jmod.rotarycraft.actions;

import java.util.List;

import net.minecraft.item.ItemStack;
import Reika.RotaryCraft.API.RecipeInterface;

import com.jeffpeng.jmod.JMODRepresentation;
import com.jeffpeng.jmod.descriptors.ItemStackDescriptor;
import com.jeffpeng.jmod.primitives.BasicAction;

import cpw.mods.fml.common.event.FMLLoadCompleteEvent;

public class AddCompactorRecipe extends BasicAction {
	private ItemStackDescriptor inDesc;
	private ItemStackDescriptor outDesc;
	private int pressure = 0;
	private int temperature = 0;
	
	public AddCompactorRecipe(JMODRepresentation owner, ItemStackDescriptor out, ItemStackDescriptor in, int pressure, int temperature){
		super(owner);
		this.inDesc = in;
		this.outDesc = out;
		this.temperature = temperature;
		this.pressure = pressure;
	}
	
	@Override
	public boolean on(FMLLoadCompleteEvent event){
		valid = false;
		ItemStack outIs = outDesc.toItemStack();
		if(pressure > 0 && outIs != null){
			inDesc.getItemStackList().forEach((v) -> RecipeInterface.compactor.addAPIRecipe(v, outIs, pressure, temperature));
			valid = true;
		}
		return valid;
	}
}
