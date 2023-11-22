package androidx.collection;

/* loaded from: classes6.dex */
public final class CircularArray<E> {
    private int PlaceComponentResult;
    private E[] getAuthRequestContext;

    public CircularArray() {
        this((byte) 0);
    }

    private CircularArray(byte b) {
        int highestOneBit = Integer.bitCount(8) != 1 ? Integer.highestOneBit(7) << 1 : 8;
        this.PlaceComponentResult = highestOneBit - 1;
        this.getAuthRequestContext = (E[]) new Object[highestOneBit];
    }
}
