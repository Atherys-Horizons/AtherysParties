package com.atherys.party.commands;

import com.atherys.core.command.ParameterizedCommand;
import com.atherys.core.command.UserCommand;
import com.atherys.core.command.annotation.Aliases;
import com.atherys.core.command.annotation.Permission;
import com.atherys.party.PartyService;
import com.atherys.party.PartyMsg;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.args.CommandElement;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.text.Text;

import javax.annotation.Nonnull;
import java.util.Optional;

@Aliases("leader")
@Permission("atherysparties.party.leader")
public class PartyLeaderCommand extends UserCommand implements ParameterizedCommand {

    @Nonnull
    @Override
    public CommandResult execute(@Nonnull User source, @Nonnull CommandContext args) throws CommandException {

        args.<User>getOne("newLeader").ifPresent(newLeader -> PartyService.getInstance().setPartyLeader(source, newLeader));

        return CommandResult.success();
    }

    @Override
    public CommandElement[] getArguments() {
        return new CommandElement[]{
                GenericArguments.user(Text.of("newLeader"))
        };
    }
}
