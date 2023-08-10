package com.parakeetstudios.parabots.api.utils;

// This might need to be changed to an interface at some point for compatibility?
public class SkinUtils {

    /**
     * Represents the various parts of a player's skin that can be customized.
     * <p>
     * Each skin part is associated with a unique flag that indicates its presence or status. These flags
     * can be combined to represent a set of visible skin parts.
     * </p>
     */
    public enum SkinPart {
        CAPE(0x01),
        JACKET(0x02),
        LEFT_SLEEVE(0x04),
        RIGHT_SLEEVE(0x08),
        LEFT_PANT_LEG(0x10),
        RIGHT_PANT_LEG(0x20),
        HAT(0x40);

        private final byte flag;

        /**
         * Initializes a {@code SkinPart} with the associated flag value.
         *
         * @param flag The flag value associated with the skin part.
         */
        SkinPart(int flag) {
            this.flag = (byte) flag;
        }

        /**
         * Retrieves the flag value associated with this skin part.
         *
         * @return The flag value.
         */
        public byte getFlag() {
            return flag;
        }
    }

}
