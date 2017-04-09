package reborncore.common.advanced;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by Gigabit101 on 08/04/2017.
 */
public class AdvancedBlock extends BlockContainer
{
    @Nonnull AdvancedTileEntity advancedTileEntity;

    public AdvancedBlock(AdvancedTileEntity advancedTileEntity)
    {
        super(Material.IRON);
        this.advancedTileEntity = advancedTileEntity;
        this.setUnlocalizedName(advancedTileEntity.getName());
        this.advancedTileEntity.initBlock(this);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        if(advancedTileEntity != null)
        {
            return advancedTileEntity.createNewTileEntity(worldIn, meta);
        }
        return null;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        return advancedTileEntity.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced)
    {
        super.addInformation(stack, player, tooltip, advanced);
        advancedTileEntity.addInformation(stack, player, tooltip, advanced);
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        if(advancedTileEntity != null)
        {
            advancedTileEntity.getRenderType(state);
        }
        return super.getRenderType(state);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        if(advancedTileEntity != null)
        {
            return advancedTileEntity.getBoundingBox(state, source, pos);
        }
        return super.getBoundingBox(state, source, pos);
    }
}