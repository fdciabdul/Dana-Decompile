package id.dana.domain.extension;

import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.google.gson.Gson;
import id.dana.utils.extension.JSONExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a7\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001ae\u0010\n\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022&\u0010\b\u001a\"\u0012\u000b\u0012\t\u0018\u00018\u0000¢\u0006\u0002\b\u0006\u0012\u000b\u0012\t\u0018\u00018\u0001¢\u0006\u0002\b\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0086\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a8\u0010\u0010\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\f\u0018\u0001*\u0012\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0086\b¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0007\n\u0005\b\u009920\u0001"}, d2 = {DiskFormatter.KB, "V", "", "filterNotNullValues", "(Ljava/util/Map;)Ljava/util/Map;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "", "predicate", "Lkotlin/Pair;", "find", "(Ljava/util/Map;Lkotlin/jvm/functions/Function2;)Lkotlin/Pair;", "T", "", "", "key", "mapToObject", "(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/Object;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MapExtKt {
    public static final <K, V> Map<K, V> filterNotNullValues(Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<K, ? extends V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            if (value != null) {
                linkedHashMap.put(key, value);
            }
        }
        return linkedHashMap;
    }

    public static final /* synthetic */ <T> T mapToObject(Map<String, ? extends Object> map, String str) {
        String json;
        if (map == null) {
            return null;
        }
        if (str == null || (json = JSONExtKt.PlaceComponentResult().toJson(map.get(str))) == null) {
            json = JSONExtKt.PlaceComponentResult().toJson(map);
        }
        Gson PlaceComponentResult = JSONExtKt.PlaceComponentResult();
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) PlaceComponentResult.fromJson(json, (Class) Object.class);
    }

    public static final <K, V> Pair<K, V> find(Map<K, ? extends V> map, Function2<? super K, ? super V, Boolean> function2) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(function2, "");
        for (Map.Entry<K, ? extends V> entry : map.entrySet()) {
            Object key = entry.getKey();
            Object obj = (V) entry.getValue();
            if (function2.invoke(key, obj).booleanValue()) {
                return new Pair<>(key, obj);
            }
        }
        return null;
    }
}
