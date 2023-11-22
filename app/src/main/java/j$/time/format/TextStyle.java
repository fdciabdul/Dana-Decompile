package j$.time.format;

/* loaded from: classes6.dex */
public enum TextStyle {
    FULL(0),
    FULL_STANDALONE(0),
    SHORT(1),
    SHORT_STANDALONE(1),
    NARROW(1),
    NARROW_STANDALONE(1);

    private final int zoneNameStyleIndex;

    TextStyle(int i) {
        this.zoneNameStyleIndex = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zoneNameStyleIndex() {
        return this.zoneNameStyleIndex;
    }
}
