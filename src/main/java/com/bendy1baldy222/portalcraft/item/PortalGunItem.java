package com.bendy1baldy222.portalcraft.item;

import com.bendy1baldy222.portalcraft.entity.PortalProjectileEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PortalGunItem extends Item {
    private final boolean isOrange;

    public PortalGunItem(Properties properties, boolean isOrange) {
        super(properties);
        this.isOrange = isOrange;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide) {
            PortalProjectileEntity projectile = new PortalProjectileEntity(level, player, isOrange);
            projectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
            level.addFreshEntity(projectile);
        }
        player.getCooldowns().addCooldown(this, 10);
        return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), level.isClientSide());
    }
}
