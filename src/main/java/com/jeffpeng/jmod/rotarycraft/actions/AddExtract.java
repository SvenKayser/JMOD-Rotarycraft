package com.jeffpeng.jmod.rotarycraft.actions;

import Reika.DragonAPI.Interfaces.Registry.OreType;
import Reika.DragonAPI.Interfaces.Registry.OreType.OreRarity;
import Reika.RotaryCraft.API.ExtractAPI;

import com.jeffpeng.jmod.JMODRepresentation;
import com.jeffpeng.jmod.primitives.BasicAction;

import cpw.mods.fml.common.event.FMLLoadCompleteEvent;

public class AddExtract extends BasicAction {
	String name;
	String rarity;
	String productType;
	String productOreName;
	int number;
	int c1;
	int c2;
	String[] oreDict;
	

	public AddExtract(JMODRepresentation owner, String name, String rarity, String productType, String productOreName, int number, int c1, int c2, String[] oreDict) {
		super(owner);
		this.name = name;
		this.rarity = rarity;
		this.productType = productType;
		this.productOreName = productOreName;
		this.number = number;
		this.c1 = c1;
		this.c2 = c2;
		this.oreDict = oreDict;
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean on(FMLLoadCompleteEvent event){
		ExtractAPI.addCustomExtractEntry(name, OreRarity.valueOf(rarity), productType, productOreName, number, c1, c2, null, oreDict);
		return valid;
	}

}
