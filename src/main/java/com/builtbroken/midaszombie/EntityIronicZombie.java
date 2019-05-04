package com.builtbroken.midaszombie;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

import javax.annotation.Nullable;

import static com.builtbroken.midaszombie.MaterialRegistry.uniqueTypes;
import static com.builtbroken.midaszombie.MaterialRegistry.uniqueTypesList;
import static com.builtbroken.midaszombie.ModConfig.MAX_TRANSFERS;
import static com.builtbroken.midaszombie.ModConfig.TIME_LIMIT;
import static java.lang.Math.floor;

public class EntityIronicZombie extends EntityZombie
{

    public EntityIronicZombie(World worldIn)
    {
        super(worldIn);
    }

    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
    {
        String type = uniqueTypesList.get((int) floor(Math.random() * uniqueTypes));
        this.getEntityData().setInteger("transfers", MAX_TRANSFERS);
        this.getEntityData().setString("type", type);
        this.addPotionEffect(new PotionEffect(MobEffects.GLOWING, TIME_LIMIT * 20, 1));
        this.setCustomNameTag(this.getEntityData().getString("type"));
        this.setAlwaysRenderNameTag(true);
        return livingdata;
    }
}
