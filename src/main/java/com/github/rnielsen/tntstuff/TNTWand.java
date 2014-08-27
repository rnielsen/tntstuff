package com.github.rnielsen.tntstuff;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TNTWand extends Item {

    public TNTWand() {
        // Constructor Configuration
        setUnlocalizedName(TntStuff.MODID + "_" + "tntWand");
        setTextureName(TntStuff.MODID + ":" + "tntWand");
        setCreativeTab(CreativeTabs.tabMisc);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float px, float py, float pz) {
        Block block = world.getBlock(x,y,z);
        System.out.println("side = " + side);

        int dx = 0;
        int dy = 0;
        int dz = 0;
        switch (side) {
            case 0: dy = 1; break; // up
            case 1: dy = -1; break; // down
            case 2: dz = 1; break;
            case 3: dz = -1; break;
            case 4: dx = 1; break;
            case 5: dx = -1; break;
        }
        // Remove any snow or plants on top
        if (!block.isOpaqueCube()) {
            world.setBlock(x,y,z, Blocks.air);
            world.notifyBlockChange(x, y, z, Blocks.air);
            y--;
        }
        // Place TNT all the way to bedrock or air or 300 blocks
        System.out.println("y = " + y);
        for(int i=0;i<300;i++) {
            block = world.getBlock(x,y,z);
            if (y < 0 || block == Blocks.bedrock || !block.isOpaqueCube()) {
                break;
            }
            world.setBlock(x, y, z, Blocks.tnt);
            world.notifyBlockChange(x, y, z, Blocks.tnt);
            x+=dx;
            y+=dy;
            z+=dz;
        }
        return true;
    }
}
