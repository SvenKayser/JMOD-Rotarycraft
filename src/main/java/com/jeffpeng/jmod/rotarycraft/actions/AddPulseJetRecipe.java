package com.jeffpeng.jmod.rotarycraft.actions;

import net.minecraft.item.ItemStack;
import Reika.RotaryCraft.API.RecipeInterface;

import com.jeffpeng.jmod.JMODRepresentation;
import com.jeffpeng.jmod.descriptors.ItemStackDescriptor;
import com.jeffpeng.jmod.primitives.BasicAction;

import cpw.mods.fml.common.event.FMLLoadCompleteEvent;

public class AddPulseJetRecipe  extends BasicAction {
	
	private ItemStackDescriptor inDesc;
	private ItemStackDescriptor outDesc;

	public AddPulseJetRecipe(JMODRepresentation owner,  ItemStackDescriptor out, ItemStackDescriptor in){
		super(owner);
		this.inDesc = in;
		this.outDesc = out;
	}
	
	@Override
	public boolean on(FMLLoadCompleteEvent event){
		valid = false;
		ItemStack outIs = outDesc.toItemStack();
		if(outIs != null){
			inDesc.getItemStackList().forEach((v) -> RecipeInterface.pulsefurn.addAPISmelting(v, outIs));
			valid = true;
		}
		return valid;
	}

}
