package com.atherys.party.commands;

import com.atherys.core.command.PlayerCommand;
import com.atherys.core.command.annotation.Aliases;
import com.atherys.core.command.annotation.Children;
import com.atherys.core.command.annotation.Permission;
import com.atherys.party.AtherysParties;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.entity.living.player.Player;

import javax.annotation.Nonnull;

@Aliases("party")
@Children({
        PartyInviteCommand.class,
        PartyKickCommand.class,
        PartyLeaderCommand.class,
        PartyLeaveCommand.class,
        PartyDisbandCommand.class,
        PartyPvpCommand.class
})
@Permission("atherysparties.party")
public class PartyCommand implements PlayerCommand {

    @Nonnull
    @Override
    public CommandResult execute(@Nonnull Player source, @Nonnull CommandContext args) throws CommandException {
        AtherysParties.getInstance().getPartyFacade().printPlayerParty(source);
        return CommandResult.success();
    }
}
