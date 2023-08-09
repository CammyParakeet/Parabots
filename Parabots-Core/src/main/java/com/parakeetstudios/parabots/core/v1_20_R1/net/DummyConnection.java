package com.parakeetstudios.parabots.core.v1_20_R1.net;

import net.minecraft.network.Connection;
import net.minecraft.network.PacketSendListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.PacketFlow;
import org.jetbrains.annotations.NotNull;

public class DummyConnection extends Connection {

    public DummyConnection(PacketFlow side) {
        super(side);
    }

    @Override
    public boolean isConnected() {
        return true;
    }

    @Override
    public void send(@NotNull Packet packet, PacketSendListener listener) {
    }
}
