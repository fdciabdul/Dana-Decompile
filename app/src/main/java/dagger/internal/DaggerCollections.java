package dagger.internal;

import java.util.HashSet;
import java.util.LinkedHashMap;

/* loaded from: classes8.dex */
public final class DaggerCollections {
    private DaggerCollections() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> HashSet<T> MyBillsEntityDataFactory(int i) {
        return new HashSet<>(i < 3 ? i + 1 : i < 1073741824 ? (int) ((i / 0.75f) + 1.0f) : Integer.MAX_VALUE);
    }

    public static <K, V> LinkedHashMap<K, V> getAuthRequestContext(int i) {
        return new LinkedHashMap<>(i < 3 ? i + 1 : i < 1073741824 ? (int) ((i / 0.75f) + 1.0f) : Integer.MAX_VALUE);
    }
}
