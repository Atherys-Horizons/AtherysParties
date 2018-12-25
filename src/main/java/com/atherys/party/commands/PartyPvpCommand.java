package com.atherys.party.commands;

import com.atherys.core.command.ParameterizedCommand;
import com.atherys.core.command.UserCommand;
import com.atherys.core.command.annotation.Aliases;
import com.atherys.core.command.annotation.Permission;
import com.atherys.party.AtherysParties;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.args.CommandElement;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.text.Text;

import javax.annotation.Nonnull;

@Aliases("pvp")
@Permission("atherysparties.party.pvp")
public class PartyPvpCommand extends UserCommand implements ParameterizedCommand {

    @Nonnull
    @Override
    public CommandResult execute(@Nonnull User source, @Nonnull CommandContext args) throws CommandException {

        args.<Boolean>getOne("toggle").ifPresent(state -> AtherysParties.getPartyService().setPartyPvp(source, state));

        return CommandResult.success();
    }

    @Override
    public CommandElement[] getArguments() {
        return new CommandElement[] {
                GenericArguments.bool(Text.of("toggle"))
        };
    }
}
