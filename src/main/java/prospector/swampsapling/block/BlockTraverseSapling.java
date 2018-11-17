package prospector.swampsapling.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.Material;
import prospector.swampsapling.TreeGenerator;

public class BlockTraverseSapling extends BlockSapling {
	public BlockTraverseSapling(TreeGenerator treeGenerator) {
		super(treeGenerator, Block.Builder.create(Material.field_15935).method_9634());
	}
}