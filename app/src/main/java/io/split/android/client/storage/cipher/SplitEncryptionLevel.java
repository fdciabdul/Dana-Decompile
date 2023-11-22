package io.split.android.client.storage.cipher;

/* loaded from: classes6.dex */
public enum SplitEncryptionLevel {
    AES_128_CBC("AES_128_CBC"),
    NONE("NONE");

    private final String mDescription;

    SplitEncryptionLevel(String str) {
        this.mDescription = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.mDescription;
    }

    public static SplitEncryptionLevel fromString(String str) {
        for (SplitEncryptionLevel splitEncryptionLevel : values()) {
            if (splitEncryptionLevel.mDescription.equalsIgnoreCase(str)) {
                return splitEncryptionLevel;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid string value for SplitEncryptionLevel: ");
        sb.append(str);
        throw new IllegalArgumentException(sb.toString());
    }
}
