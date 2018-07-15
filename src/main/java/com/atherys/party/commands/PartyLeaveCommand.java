package com.atherys.party.commands;

import com.atherys.core.command.UserCommand;
import com.atherys.core.command.annotation.Aliases;
import com.atherys.core.command.annotation.Permission;
import com.atherys.party.database.PartyManager;
import com.atherys.party.PartyMsg;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.entity.living.player.User;

@Aliases("leave")
@Permission("atherysparties.party.leave")
public class PartyLeaveCommand extends UserCommand {

    @Override
    public CommandResult execute(User source, CommandContext args) throws CommandException {

        if (!PartyManager.getInstance().hasUserParty(source)) {
            PartyMsg.error(source, "You are not in a party!");
            return CommandResult.success();
        }

        PartyManager.getInstance().getUserParty(source).ifPresent(party -> {
            party.removeMember(source);
            PartyMsg.info(party, source.getName(), " has left the party.");
            PartyMsg.info(source, "You have left the party.");
        });

        return CommandResult.success();
    }

}
