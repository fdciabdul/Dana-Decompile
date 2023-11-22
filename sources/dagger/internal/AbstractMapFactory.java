package dagger.internal;

import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes8.dex */
abstract class AbstractMapFactory<K, V, V2> implements Factory<Map<K, V2>> {
    private final Map<K, Provider<V>> MyBillsEntityDataFactory;

    /* loaded from: classes8.dex */
    public static abstract class Builder<K, V, V2> {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<K, Provider<V>> MyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }
}
