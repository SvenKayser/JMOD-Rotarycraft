package com.jeffpeng.jmod.rotarycraft.actions;

import net.minecraft.item.ItemStack;
import Reika.DragonAPI.Interfaces.Registry.OreType.OreRarity;
import Reika.RotaryCraft.API.ExtractAPI;
import Reika.RotaryCraft.Registry.ItemRegistry;

import com.jeffpeng.jmod.JMODRepresentation;
import com.jeffpeng.jmod.Lib;
import com.jeffpeng.jmod.primitives.BasicAction;

import cpw.mods.fml.common.event.FMLLoadCompleteEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class AddExtract extends BasicAction {
	String name;
	OreRarity rarity;
	String productType;
	String productOreName;
	int c1;
	int c2;
	String[] oreDict;
	String result;
	int resultAmount;
	

	public AddExtract(JMODRepresentation owner, String name, String result, String[] inputs) {
		super(owner);
		this.name = name;
		this.rarity = OreRarity.AVERAGE;
		this.productType = "Item";
		this.c1 = 0x808080;
		this.c2 = 0x808080;
		this.oreDict = inputs;
		this.result = result;
		
		
		// TODO Auto-generated constructor stub
	}
	
	public AddExtract rarity(String rarity){
		if(OreRarity.valueOf(rarity) != null)
		this.rarity = OreRarity.valueOf(rarity);
		
		return this;
	}
	
	public AddExtract color(int color){
		this.c1 = color;
		this.c2 = color;
		return this;
	}
	
	public AddExtract color2(int color){
		this.c2 = color;
		return this;
	}
	
	@Override
	public boolean on(FMLLoadCompleteEvent event){
		
		ItemStack resultstack = lib.stringToItemStackOrFirstOreDict(result);

		ItemStack extractorOutput = ExtractAPI.addCustomExtractEntry(name, rarity, productType, null, resultstack.stackSize, c1, c2, null, oreDict);
		int flakeItemIndex = extractorOutput.getItemDamage()*4+3;
		ItemStack flake = new ItemStack(ItemRegistry.CUSTOMEXTRACT.getItemInstance(),1,flakeItemIndex);
		GameRegistry.addSmelting(flake,resultstack, 1);
		Lib.hideItemStack(extractorOutput);
		return valid;
	}

}
