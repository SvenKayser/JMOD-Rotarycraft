package com.jeffpeng.jmod.rotarycraft.actions;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import Reika.RotaryCraft.API.RecipeInterface;

import com.jeffpeng.jmod.JMODRepresentation;
import com.jeffpeng.jmod.descriptors.ItemStackDescriptor;
import com.jeffpeng.jmod.primitives.BasicAction;

import cpw.mods.fml.common.event.FMLLoadCompleteEvent;

public class AddDryingBedRecipe extends BasicAction {
	private String inString;
	private ItemStackDescriptor outDesc;
	
	private Fluid in;
	private int amount;

	public AddDryingBedRecipe(JMODRepresentation owner, ItemStackDescriptor out, String in){
		super(owner);
		this.inString = in;
		this.outDesc = out;
	}
	
	@Override
	public boolean on(FMLLoadCompleteEvent event){
		valid = false;
		Object inFs = lib.stringToFluidStack(inString);
		if(inFs instanceof FluidStack){
			ItemStack outIs = outDesc.toItemStack();
			if(outIs != null){
				valid = true;
				in = ((FluidStack)inFs).getFluid();
				amount = ((FluidStack)inFs).amount;
				RecipeInterface.dryingbed.addAPIRecipe(in, amount, outIs);
			} 
		} 
		return valid;
	}
}
