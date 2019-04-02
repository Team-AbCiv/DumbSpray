package info.tritusk.modpack.dumbspray;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.server.permission.PermissionAPI;

public final class DumbCommand extends CommandBase {
    @Override
    public String getName() {
        return "dumb";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "commands.dumb_spray.dumb.usage";
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        Entity executor = sender.getCommandSenderEntity();
        if (executor instanceof EntityPlayer) {
            return PermissionAPI.hasPermission((EntityPlayer)executor, "dumb_spray.command.dumb");
        }
        return super.checkPermission(server, sender);
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args.length > 0) {
            RegularDumbPotion.makeTargetDumb(CommandBase.getEntity(server, sender, args[0], EntityLiving.class));
        }
    }
}
