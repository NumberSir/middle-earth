package net.jukoz.me.world.features.trunks;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.jukoz.me.world.gen.ModTreeGeneration;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class ArcTrunkPlacer extends TrunkPlacer {

    protected final int baseHeight;
    protected final int randomHeight;
    protected final float acceleration;
    protected final float velocity;

    public static final Codec<ArcTrunkPlacer> CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(
                Codec.intRange(0,90).fieldOf("base_height").forGetter((trunkPlacer) -> {
                    return trunkPlacer.baseHeight;
                }), Codec.intRange(0,16).fieldOf("random_height").forGetter((trunkPlacer) -> {
                    return trunkPlacer.randomHeight;
                }), Codec.floatRange(0.0f,0.2f).fieldOf("acceleration").forGetter((trunkPlacer) -> {
                    return trunkPlacer.acceleration;
                }), Codec.floatRange(0.0f,0.2f).fieldOf("velocity").forGetter((trunkPlacer) -> {
                    return trunkPlacer.velocity;
                })).apply(instance, ArcTrunkPlacer::new);
    });

    public ArcTrunkPlacer(int baseHeight, int randomHeight, float acceleration, float velocity) {
        super(baseHeight, randomHeight, 0);
        this.baseHeight = baseHeight;
        this.randomHeight = randomHeight;
        this.acceleration = acceleration;
        this.velocity = velocity;
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return ModTreeGeneration.ARC_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random,
                                                 int height, BlockPos startPos, TreeFeatureConfig config) {
        BlockPos blockPos = startPos.down();
        setToDirt(world, replacer, random, blockPos, config);
        setToDirt(world, replacer, random, blockPos.east(), config);
        setToDirt(world, replacer, random, blockPos.south(), config);
        setToDirt(world, replacer, random, blockPos.south().east(), config);
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        double angle = Math.random() * 180;
        List<FoliagePlacer.TreeNode> treeNodes = createArcBranch(world, replacer, random, mutable, config, startPos, getHeight(random), angle, this.acceleration, this.velocity);

        return ImmutableList.copyOf(treeNodes);
    }

    protected List<FoliagePlacer.TreeNode> createArcBranch(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, BlockPos.Mutable mutable,
                                          TreeFeatureConfig config, BlockPos startPos, int height, double angle, float acceleration, float velocity) {
        if(height < 0) {
            height *= -1;
        }
        Vec3d dir = new Vec3d(Math.cos(angle), 1, Math.sin(angle)).normalize();
        Vec3d currentPos = new Vec3d(startPos.getX(), startPos.getY() - 1, startPos.getZ());
        float currentVel = velocity;

        int topHeight = (int) (currentPos.y + height);
        while (currentPos.getY() < topHeight) {
            currentPos = currentPos.add(new Vec3d(dir.x * currentVel, dir.y, dir.z * currentVel));
            this.setLog(world, replacer, random, mutable, config, new BlockPos((int) currentPos.x, (int) currentPos.y, (int) currentPos.z),
                    0, 0, 0);
            currentVel += acceleration;
        }
        List<FoliagePlacer.TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(new FoliagePlacer.TreeNode(new BlockPos((int) currentPos.x, (int) currentPos.y, (int) currentPos.z), 0, false));
        return treeNodes;
    }

    protected void setLog(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, BlockPos.Mutable tmpPos,
                          TreeFeatureConfig config, BlockPos startPos, int dx, int dy, int dz) {
        tmpPos.set(startPos, dx, dy, dz);
        this.trySetState(world, replacer, random, tmpPos, config);
    }
}
