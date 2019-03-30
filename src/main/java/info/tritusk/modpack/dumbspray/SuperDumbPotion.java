package info.tritusk.modpack.dumbspray;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;

import javax.annotation.Nullable;

public final class SuperDumbPotion extends Potion {

    SuperDumbPotion() {
        super(true, 0x0055FF52);
    }

    @Override
    public final boolean isInstant() {
        return true;
    }

    @Override
    public final boolean isReady(int duration, int amplifier) {
        return duration > 0;
    }

    @Override
    public final void affectEntity(@Nullable Entity source, @Nullable Entity indirectSource, EntityLivingBase affectedEntity, int amplifier, double health) {
        if (affectedEntity instanceof EntityLiving) {
            ((EntityLiving) affectedEntity).setNoAI(true);
        }
    }
}
