package androidx.arch.core.internal;

import androidx.arch.core.internal.SafeIterableMap;
import java.util.HashMap;

/* loaded from: classes.dex */
public class FastSafeIterableMap<K, V> extends SafeIterableMap<K, V> {
    public HashMap<K, SafeIterableMap.Entry<K, V>> PlaceComponentResult = new HashMap<>();

    @Override // androidx.arch.core.internal.SafeIterableMap
    protected final SafeIterableMap.Entry<K, V> PlaceComponentResult(K k) {
        return this.PlaceComponentResult.get(k);
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public final V KClassImpl$Data$declaredNonStaticMembers$2(K k) {
        V v = (V) super.KClassImpl$Data$declaredNonStaticMembers$2(k);
        this.PlaceComponentResult.remove(k);
        return v;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(K k) {
        return this.PlaceComponentResult.containsKey(k);
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public final V BuiltInFictitiousFunctionClassFactory(K k, V v) {
        SafeIterableMap.Entry<K, V> entry = this.PlaceComponentResult.get(k);
        if (entry != null) {
            return entry.BuiltInFictitiousFunctionClassFactory;
        }
        this.PlaceComponentResult.put(k, MyBillsEntityDataFactory(k, v));
        return null;
    }
}
