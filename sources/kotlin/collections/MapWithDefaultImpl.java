package kotlin.collections;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B6\u0012\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010#\u0012\u0019\u0010\u001a\u001a\u0015\u0012\u000b\u0012\t\u0018\u00018\u0000¢\u0006\u0002\b\u0019\u0012\u0004\u0012\u00028\u00010\u0018¢\u0006\u0004\b.\u0010/J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u001a\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002¢\u0006\u0004\b\f\u0010\u0007J\u001a\u0010\r\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0004\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R'\u0010\u001a\u001a\u0015\u0012\u000b\u0012\t\u0018\u00018\u0000¢\u0006\u0002\b\u0019\u0012\u0004\u0012\u00028\u00010\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR&\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001d0\u001c8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001fR&\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010#8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020\u00108WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0012R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00010*8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,"}, d2 = {"Lkotlin/collections/MapWithDefaultImpl;", DiskFormatter.KB, "V", "Lkotlin/collections/MapWithDefault;", "key", "", "containsKey", "(Ljava/lang/Object;)Z", "value", "containsValue", "", "other", "equals", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrImplicitDefault", "", "hashCode", "()I", "isEmpty", "()Z", "", "toString", "()Ljava/lang/String;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "default", "Lkotlin/jvm/functions/Function1;", "", "", "getEntries", "()Ljava/util/Set;", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "getKeys", UserMetadata.KEYDATA_FILENAME, "", "map", "Ljava/util/Map;", "getMap", "()Ljava/util/Map;", "getSize", GriverMonitorConstants.KEY_SIZE, "", "getValues", "()Ljava/util/Collection;", "values", "<init>", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
final class MapWithDefaultImpl<K, V> implements MapWithDefault<K, V> {
    private final Function1<K, V> default;
    private final Map<K, V> map;

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final V put(K k, V v) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final V remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MapWithDefaultImpl(Map<K, ? extends V> map, Function1<? super K, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.map = map;
        this.default = function1;
    }

    @Override // java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // kotlin.collections.MapWithDefault
    @JvmName(name = "getMap")
    public final Map<K, V> getMap() {
        return this.map;
    }

    @Override // java.util.Map
    public final Set<K> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public final int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final Collection<V> values() {
        return getValues();
    }

    @Override // java.util.Map
    public final boolean equals(Object other) {
        return getMap().equals(other);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return getMap().hashCode();
    }

    public final String toString() {
        return getMap().toString();
    }

    @JvmName(name = "getSize")
    public final int getSize() {
        return getMap().size();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return getMap().isEmpty();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object key) {
        return getMap().containsKey(key);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object value) {
        return getMap().containsValue(value);
    }

    @Override // java.util.Map
    public final V get(Object key) {
        return getMap().get(key);
    }

    @JvmName(name = "getKeys")
    public final Set<K> getKeys() {
        return getMap().keySet();
    }

    @JvmName(name = "getValues")
    public final Collection<V> getValues() {
        return getMap().values();
    }

    @JvmName(name = "getEntries")
    public final Set<Map.Entry<K, V>> getEntries() {
        return getMap().entrySet();
    }

    @Override // kotlin.collections.MapWithDefault
    public final V getOrImplicitDefault(K key) {
        Map<K, V> map = getMap();
        V v = map.get(key);
        return (v != null || map.containsKey(key)) ? v : this.default.invoke(key);
    }
}
