package com.squareup.wire;

import java.io.IOException;

/* loaded from: classes3.dex */
public enum WireType {
    VARINT(0),
    FIXED64(1),
    LENGTH_DELIMITED(2),
    START_GROUP(3),
    END_GROUP(4),
    FIXED32(5);

    public static final int FIXED_32_SIZE = 4;
    public static final int FIXED_64_SIZE = 8;
    public static final int TAG_TYPE_BITS = 3;
    private static final int TAG_TYPE_MASK = 7;
    private final int value;

    public static WireType valueOf(int i) throws IOException {
        int i2 = i & 7;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 == 5) {
                                return FIXED32;
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append("No WireType for type ");
                            sb.append(i2);
                            throw new IOException(sb.toString());
                        }
                        return END_GROUP;
                    }
                    return START_GROUP;
                }
                return LENGTH_DELIMITED;
            }
            return FIXED64;
        }
        return VARINT;
    }

    WireType(int i) {
        this.value = i;
    }

    public final int value() {
        return this.value;
    }
}
