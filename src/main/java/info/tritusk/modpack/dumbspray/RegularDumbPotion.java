package info.tritusk.modpack.dumbspray;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.potion.Potion;

import javax.annotation.Nullable;

public final class RegularDumbPotion extends Potion {

    RegularDumbPotion() {
        super(true, 0x00FF72);
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
            makeTargetDumb((EntityLiving) affectedEntity);
        }
    }

    static void makeTargetDumb(EntityLiving target) {
        target.tasks.taskEntries.clear();
        target.targetTasks.taskEntries.clear();
        target.tasks.addTask(233, new EntityAILookIdle(target));
    }
}
