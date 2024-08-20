package net.jukoz.me.block.special;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;

public class LargeDoor2x2 extends LargeDoorBlock{
    public static final IntProperty PART = IntProperty.of("part", 0, 3);

    public LargeDoor2x2(int height, int width, Settings settings) {
        super(height, width, settings);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(PART, HORIZONTAL_FACING, OPEN, HINGE);
    }
}