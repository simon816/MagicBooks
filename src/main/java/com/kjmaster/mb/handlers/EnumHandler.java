package com.kjmaster.mb.handlers;

import net.minecraft.util.IStringSerializable;

/**
 * Created by pbill_000 on 25/07/2017.
 */
public class EnumHandler {
    public static enum MagicBookTypes implements IStringSerializable {
        NOSPELL("nospell", 0),
        SPELL1("spell1", 1),
        SPELL2("spell2", 2),
        SPELL3("spell3", 3),
        SPELL4("spell4", 4),
        SPELL5("spell5", 5),
        SPELL6("spell6", 6),
        SPELL7("spell7", 7),
        SPELL8("spell8", 8)
        ;


        private int ID;
        private String name;

        private MagicBookTypes(String name, int ID) {
            this.ID = ID;
            this.name = name;
        }

        @Override
        public String toString() {
            return getName();
        }

        @Override
        public String getName() {
            return this.name;
        }

        public int getID() {
            return ID;
        }

    }
}
