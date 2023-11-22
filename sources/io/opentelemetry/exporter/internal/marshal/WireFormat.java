package io.opentelemetry.exporter.internal.marshal;

/* loaded from: classes9.dex */
final class WireFormat {
    static final int FIXED32_SIZE = 4;
    static final int FIXED64_SIZE = 8;
    static final int MAX_VARINT32_SIZE = 5;
    static final int MAX_VARINT64_SIZE = 10;
    static final int MAX_VARINT_SIZE = 10;
    static final int TAG_TYPE_BITS = 3;
    static final int TAG_TYPE_MASK = 7;
    static final int WIRETYPE_FIXED32 = 5;
    static final int WIRETYPE_FIXED64 = 1;
    static final int WIRETYPE_LENGTH_DELIMITED = 2;
    static final int WIRETYPE_VARINT = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getTagFieldNumber(int i) {
        return i >>> 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getTagWireType(int i) {
        return i & 7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int makeTag(int i, int i2) {
        return (i << 3) | i2;
    }

    private WireFormat() {
    }
}
