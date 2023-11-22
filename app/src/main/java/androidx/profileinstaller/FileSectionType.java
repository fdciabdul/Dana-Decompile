package androidx.profileinstaller;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public enum FileSectionType {
    DEX_FILES(0),
    EXTRA_DESCRIPTORS(1),
    CLASSES(2),
    METHODS(3),
    AGGREGATION_COUNT(4);

    private final long mValue;

    FileSectionType(long j) {
        this.mValue = j;
    }

    public final long getValue() {
        return this.mValue;
    }

    static FileSectionType fromValue(long j) {
        FileSectionType[] values = values();
        for (int i = 0; i < values.length; i++) {
            if (values[i].getValue() == j) {
                return values[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unsupported FileSection Type ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }
}
