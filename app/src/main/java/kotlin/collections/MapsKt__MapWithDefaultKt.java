package kotlin.collections;

import com.alibaba.griver.image.photo.utils.DiskFormatter;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\u001a3\u0010\u0004\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001aP\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0019\u0010\b\u001a\u0015\u0012\u000b\u0012\t\u0018\u00018\u0000¢\u0006\u0002\b\u0007\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\t\u0010\n\u001aZ\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b2#\u0010\b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00018\u0000¢\u0006\f\b\u0007\u0012\b\b\f\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\r\u0010\n"}, d2 = {DiskFormatter.KB, "V", "", "key", "getOrImplicitDefaultNullable", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "defaultValue", "withDefault", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "", "name", "withDefaultMutable"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/collections/MapsKt")
/* loaded from: classes.dex */
public class MapsKt__MapWithDefaultKt {
    public static final <K, V> V getOrImplicitDefaultNullable(Map<K, ? extends V> map, K k) {
        Intrinsics.checkNotNullParameter(map, "");
        if (map instanceof MapWithDefault) {
            return (V) ((MapWithDefault) map).getOrImplicitDefault(k);
        }
        V v = map.get(k);
        if (v != null || map.containsKey(k)) {
            return v;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Key ");
        sb.append(k);
        sb.append(" is missing in the map.");
        throw new NoSuchElementException(sb.toString());
    }

    public static final <K, V> Map<K, V> withDefault(Map<K, ? extends V> map, Function1<? super K, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(function1, "");
        return map instanceof MapWithDefault ? MapsKt.withDefault(((MapWithDefault) map).getMap(), function1) : new MapWithDefaultImpl(map, function1);
    }

    public static final <K, V> Map<K, V> withDefaultMutable(Map<K, V> map, Function1<? super K, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(function1, "");
        return map instanceof MutableMapWithDefault ? MapsKt.withDefaultMutable(((MutableMapWithDefault) map).getMap(), function1) : new MutableMapWithDefaultImpl(map, function1);
    }
}
