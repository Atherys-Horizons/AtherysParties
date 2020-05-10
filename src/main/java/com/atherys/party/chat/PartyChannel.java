package com.atherys.party.chat;

import com.atherys.chat.model.AtherysChannel;
import com.atherys.party.AtherysParties;
import com.atherys.party.entity.Party;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.channel.MessageReceiver;
import org.spongepowered.api.text.format.TextColors;

import java.util.*;

public class PartyChannel extends AtherysChannel {
    public static final String PERMISSION = "atherysparties.chat";

    public PartyChannel() {
        super("party");
        this.setPermission(PERMISSION);
        this.setBroadcast(false);
        this.setPrefix(Text.of(TextColors.WHITE, "[", TextColors.DARK_AQUA, TextColors.WHITE, "]"));
        this.setColor(TextColors.DARK_AQUA);
    }

    @Override
    public Collection<MessageReceiver> getMembers(Object sender) {
        if (sender instanceof Player) {
            Optional<Party> party = AtherysParties.getInstance().getPartyFacade().getPlayerParty((Player) sender);

            if (party.isPresent()) {
                return new HashSet<>(AtherysParties.getInstance().getPartyFacade().getOnlinePartyMembers(party.get()));
            }
        }

        return Collections.emptySet();
    }
}
