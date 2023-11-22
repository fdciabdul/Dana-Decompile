package androidx.collection;

/* loaded from: classes6.dex */
public final class CircularIntArray {
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private int[] getAuthRequestContext;

    public CircularIntArray() {
        this((byte) 0);
    }

    private CircularIntArray(byte b) {
        int highestOneBit = Integer.bitCount(8) != 1 ? Integer.highestOneBit(7) << 1 : 8;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = highestOneBit - 1;
        this.getAuthRequestContext = new int[highestOneBit];
    }
}
