package net.aurora_spirit.oceans_evolved.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GiantConchBlock extends Block {

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    /*//east-facing models if i wanna do a precise hitbox
    private static final VoxelShape EAST_SEG1 = Block.box(4.0D, 4.0D, 3.0D, 12.0D, 5.0D, 13.0D);
    private static final VoxelShape EAST_SEG2 = Block.box(6.0D, 5.0D, 4.0D, 10.0D, 10.0D, 12.0D);
    private static final VoxelShape EAST_SEG3 = Block.box(3.0D, 10.0D, 0.0D, 13.0D, 16.0D, 16.0D);
    private static final VoxelShape EAST_SEG4 = Block.box(3.0D, 10.0D, 0.0D, 13.0D, 16.0D, 16.0D);
    private static final VoxelShape EAST_SEG5 = Block.box(3.0D, 10.0D, 0.0D, 13.0D, 16.0D, 16.0D);
    private static final VoxelShape EAST_AABB = Shapes.or(EAST_SEG1,EAST_SEG2,EAST_SEG3,EAST_SEG4,EAST_SEG5);*/

    private static final VoxelShape AABB = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);


    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        /*//again, if i want precise hitboxes
        Direction direction = pState.getValue(FACING);
        switch (direction) {
            case EAST:
            default:
                return EAST_AABB;
            case SOUTH:
                return SOUTH_AABB;
            case WEST:
                return WEST_AABB;
            case NORTH:
                return NORTH_AABB;
        }*/
        return AABB;
    }


    public GiantConchBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getClockWise());
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRot) {
        return pState.setValue(FACING, pRot.rotate(pState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    @Override
    public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
        return false;
    }

}
