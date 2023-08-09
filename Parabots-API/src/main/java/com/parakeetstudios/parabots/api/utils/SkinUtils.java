package com.parakeetstudios.parabots.api.utils;

// This might need to be changed to an interface at some point for compatibility?
public class SkinUtils {

    public enum SkinPart {
        CAPE(0x01),
        JACKET(0x02),
        LEFT_SLEEVE(0x04),
        RIGHT_SLEEVE(0x08),
        LEFT_PANT_LEG(0x10),
        RIGHT_PANT_LEG(0x20),
        HAT(0x40);

        private final byte flag;

        SkinPart(int flag) {
            this.flag = (byte) flag;
        }

        public byte getFlag() {
            return flag;
        }
    }

}
