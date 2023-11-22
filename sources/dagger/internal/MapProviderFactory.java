package dagger.internal;

import dagger.Lazy;
import dagger.internal.AbstractMapFactory;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class MapProviderFactory<K, V> extends AbstractMapFactory<K, V, Provider<V>> implements Lazy<Map<K, Provider<V>>> {

    /* loaded from: classes8.dex */
    public static final class Builder<K, V> extends AbstractMapFactory.Builder<K, V, Provider<V>> {
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return MyBillsEntityDataFactory();
    }
}
