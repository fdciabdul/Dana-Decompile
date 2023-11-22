package dagger.internal;

import dagger.internal.AbstractMapFactory;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class MapFactory<K, V> extends AbstractMapFactory<K, V, V> {
    private static final Provider<Map<Object, Object>> PlaceComponentResult = InstanceFactory.MyBillsEntityDataFactory(Collections.emptyMap());

    /* loaded from: classes8.dex */
    public static final class Builder<K, V> extends AbstractMapFactory.Builder<K, V, V> {
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        LinkedHashMap authRequestContext = DaggerCollections.getAuthRequestContext(MyBillsEntityDataFactory().size());
        for (Map.Entry<K, Provider<V>> entry : MyBillsEntityDataFactory().entrySet()) {
            authRequestContext.put(entry.getKey(), entry.getValue().get());
        }
        return Collections.unmodifiableMap(authRequestContext);
    }
}
