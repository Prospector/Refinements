package prospector.refinements;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.gui.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.block.ItemBlock;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.config.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.SwampTreeFeature;
import prospector.silk.block.SilkBlockLeaves;
import prospector.silk.block.SilkBlockSapling;
import prospector.silk.util.SilkSaplingGenerator;

public class Refinements implements ModInitializer {
	public static final String MOD_ID = "refinements";

	public static final Block SWAMP_LEAVES;
	public static final Block SWAMP_SAPLING;

	static {
		SWAMP_LEAVES = register("swamp_leaves", new SilkBlockLeaves(null), ItemGroup.DECORATIONS);
		SWAMP_SAPLING = register("swamp_sapling", new SilkBlockSapling(new SilkSaplingGenerator(new SwampTreeFeature(DefaultFeatureConfig::make))), ItemGroup.DECORATIONS);
	}

	private static Block register(String name, Block block, ItemGroup tab) {
		Registry.register(Registry.BLOCKS, MOD_ID + ":" + name, block);
		ItemBlock item = new ItemBlock(block, new Item.Builder().creativeTab(tab));
		item.registerBlockItemMap(Item.BLOCK_ITEM_MAP, item);
		register(name, item);
		return block;
	}

	private static Item register(String name, Item item) {
		Registry.register(Registry.ITEMS, MOD_ID + ":" + name, item);
		return item;
	}

	@Override
	public void onInitialize() {

	}
}