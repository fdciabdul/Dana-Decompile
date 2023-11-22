package kotlin.collections;

import com.alibaba.griver.image.photo.utils.DiskFormatter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.markers.KMutableMap;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\bb\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00038'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlin/collections/MutableMapWithDefault;", DiskFormatter.KB, "V", "", "Lkotlin/collections/MapWithDefault;", "getMap", "()Ljava/util/Map;", "map"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
interface MutableMapWithDefault<K, V> extends Map<K, V>, MapWithDefault<K, V>, KMutableMap {
    @Override // kotlin.collections.MapWithDefault
    @JvmName(name = "getMap")
    Map<K, V> getMap();
}
