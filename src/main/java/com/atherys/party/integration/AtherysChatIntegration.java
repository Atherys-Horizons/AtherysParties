package com.atherys.party.integration;

import com.atherys.chat.AtherysChat;
import com.atherys.party.chat.PartyChannel;

public final class AtherysChatIntegration {
    public static void registerPartyChat() {
        AtherysChat.getInstance().getChatService().registerChannel(new PartyChannel());
    }
}
