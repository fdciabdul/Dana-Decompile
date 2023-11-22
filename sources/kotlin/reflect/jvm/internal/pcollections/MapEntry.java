package kotlin.reflect.jvm.internal.pcollections;

import java.io.Serializable;

/* loaded from: classes.dex */
final class MapEntry<K, V> implements Serializable {
    public final K key;
    public final V value;

    public MapEntry(K k, V v) {
        this.key = k;
        this.value = v;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof MapEntry) {
            MapEntry mapEntry = (MapEntry) obj;
            K k = this.key;
            if (k == null) {
                if (mapEntry.key != null) {
                    return false;
                }
            } else if (!k.equals(mapEntry.key)) {
                return false;
            }
            V v = this.value;
            V v2 = mapEntry.value;
            if (v == null) {
                if (v2 != null) {
                    return false;
                }
            } else if (!v.equals(v2)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        K k = this.key;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.value;
        return hashCode ^ (v != null ? v.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.key);
        sb.append("=");
        sb.append(this.value);
        return sb.toString();
    }
}
