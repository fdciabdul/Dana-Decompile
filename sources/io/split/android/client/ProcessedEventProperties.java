package io.split.android.client;

import java.util.Map;

/* loaded from: classes9.dex */
public class ProcessedEventProperties {
    private final boolean isValid;
    private final Map<String, Object> properties;
    private final int sizeInBytes;

    public static ProcessedEventProperties InvalidProperties() {
        return new ProcessedEventProperties(false, null, 0);
    }

    public ProcessedEventProperties(boolean z, Map<String, Object> map, int i) {
        this.isValid = z;
        this.properties = map;
        this.sizeInBytes = i;
    }

    public boolean isValid() {
        return this.isValid;
    }

    public Map<String, Object> getProperties() {
        return this.properties;
    }

    public int getSizeInBytes() {
        return this.sizeInBytes;
    }
}
