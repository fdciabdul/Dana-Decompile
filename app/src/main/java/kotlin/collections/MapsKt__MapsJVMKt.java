package kotlin.collections;

import com.alibaba.griver.image.photo.utils.DiskFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u001a;\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001aZ\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\b\u001a\u00020\u00072%\u0010\f\u001a!\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\b\u000bH\u0080\bø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001aR\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012%\u0010\f\u001a!\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\b\u000bH\u0080\bø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000f\u001a'\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a/\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0010\u0010\u0012\u001a\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a9\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019\u001aa\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001e\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u000e\u0010\u001b\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u001a2*\u0010\u001d\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00160\u001c\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0016¢\u0006\u0004\b\u001f\u0010 \u001a[\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001e\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000!\"\u0004\b\u0001\u0010\u00012*\u0010\u001d\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00160\u001c\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0016¢\u0006\u0004\b\u001f\u0010\"\u001aE\u0010'\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010#2\u0006\u0010$\u001a\u00028\u00002\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00010%H\u0086\bø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a \u0010+\u001a\u00020**\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)0\u0004H\u0086\b¢\u0006\u0004\b+\u0010,\u001a9\u0010-\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0000¢\u0006\u0004\b-\u0010\u0006\u001a8\u0010.\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0080\b¢\u0006\u0004\b.\u0010\u0006\u001aA\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001e\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000!\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b/\u00100\u001aG\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001e\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u000e\u0010\u001b\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u001a¢\u0006\u0004\b/\u00101\"\u0014\u00102\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u00103\u0082\u0002\u0007\n\u0005\b\u009920\u0001"}, d2 = {DiskFormatter.KB, "V", "", "builder", "", "build", "(Ljava/util/Map;)Ljava/util/Map;", "", "capacity", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "builderAction", "buildMapInternal", "(ILkotlin/jvm/functions/Function1;)Ljava/util/Map;", "(Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "createMapBuilder", "()Ljava/util/Map;", "(I)Ljava/util/Map;", "expectedSize", "mapCapacity", "(I)I", "Lkotlin/Pair;", "pair", "mapOf", "(Lkotlin/Pair;)Ljava/util/Map;", "Ljava/util/Comparator;", "comparator", "", "pairs", "Ljava/util/SortedMap;", "sortedMapOf", "(Ljava/util/Comparator;[Lkotlin/Pair;)Ljava/util/SortedMap;", "", "([Lkotlin/Pair;)Ljava/util/SortedMap;", "Ljava/util/concurrent/ConcurrentMap;", "key", "Lkotlin/Function0;", "defaultValue", "getOrPut", "(Ljava/util/concurrent/ConcurrentMap;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "", "Ljava/util/Properties;", "toProperties", "(Ljava/util/Map;)Ljava/util/Properties;", "toSingletonMap", "toSingletonMapOrSelf", "toSortedMap", "(Ljava/util/Map;)Ljava/util/SortedMap;", "(Ljava/util/Map;Ljava/util/Comparator;)Ljava/util/SortedMap;", "INT_MAX_POWER_OF_TWO", "I"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/collections/MapsKt")
/* loaded from: classes.dex */
public class MapsKt__MapsJVMKt extends MapsKt__MapWithDefaultKt {
    private static final int INT_MAX_POWER_OF_TWO = 1073741824;

    public static final int mapCapacity(int i) {
        if (i >= 0) {
            if (i < 3) {
                return i + 1;
            }
            if (i < 1073741824) {
                return (int) ((i / 0.75f) + 1.0f);
            }
            return Integer.MAX_VALUE;
        }
        return i;
    }

    public static final <K, V> Map<K, V> mapOf(Pair<? extends K, ? extends V> pair) {
        Intrinsics.checkNotNullParameter(pair, "");
        Map<K, V> singletonMap = Collections.singletonMap(pair.getFirst(), pair.getSecond());
        Intrinsics.checkNotNullExpressionValue(singletonMap, "");
        return singletonMap;
    }

    private static final <K, V> Map<K, V> buildMapInternal(Function1<? super Map<K, V>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        Map createMapBuilder = MapsKt.createMapBuilder();
        function1.invoke(createMapBuilder);
        return MapsKt.build(createMapBuilder);
    }

    private static final <K, V> Map<K, V> buildMapInternal(int i, Function1<? super Map<K, V>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        Map createMapBuilder = MapsKt.createMapBuilder(i);
        function1.invoke(createMapBuilder);
        return MapsKt.build(createMapBuilder);
    }

    public static final <K, V> Map<K, V> createMapBuilder() {
        return new MapBuilder();
    }

    public static final <K, V> Map<K, V> createMapBuilder(int i) {
        return new MapBuilder(i);
    }

    public static final <K, V> Map<K, V> build(Map<K, V> map) {
        Intrinsics.checkNotNullParameter(map, "");
        return ((MapBuilder) map).build();
    }

    public static final <K, V> V getOrPut(ConcurrentMap<K, V> concurrentMap, K k, Function0<? extends V> function0) {
        Intrinsics.checkNotNullParameter(concurrentMap, "");
        Intrinsics.checkNotNullParameter(function0, "");
        V v = concurrentMap.get(k);
        if (v == null) {
            V invoke = function0.invoke();
            V putIfAbsent = concurrentMap.putIfAbsent(k, invoke);
            return putIfAbsent != null ? putIfAbsent : invoke;
        }
        return v;
    }

    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> toSortedMap(Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "");
        return new TreeMap(map);
    }

    public static final <K, V> SortedMap<K, V> toSortedMap(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(comparator, "");
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        return treeMap;
    }

    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> sortedMapOf(Pair<? extends K, ? extends V>... pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "");
        TreeMap treeMap = new TreeMap();
        MapsKt.putAll(treeMap, pairArr);
        return treeMap;
    }

    public static final <K, V> SortedMap<K, V> sortedMapOf(Comparator<? super K> comparator, Pair<? extends K, ? extends V>... pairArr) {
        Intrinsics.checkNotNullParameter(comparator, "");
        Intrinsics.checkNotNullParameter(pairArr, "");
        TreeMap treeMap = new TreeMap(comparator);
        MapsKt.putAll(treeMap, pairArr);
        return treeMap;
    }

    private static final Properties toProperties(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "");
        Properties properties = new Properties();
        properties.putAll(map);
        return properties;
    }

    private static final <K, V> Map<K, V> toSingletonMapOrSelf(Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "");
        return MapsKt.toSingletonMap(map);
    }

    public static final <K, V> Map<K, V> toSingletonMap(Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        Intrinsics.checkNotNullExpressionValue(singletonMap, "");
        return singletonMap;
    }
}
