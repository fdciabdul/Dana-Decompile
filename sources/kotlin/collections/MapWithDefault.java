package kotlin.collections;

import com.alibaba.griver.image.photo.utils.DiskFormatter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\bb\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003J\u0017\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00038'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlin/collections/MapWithDefault;", DiskFormatter.KB, "V", "", "key", "getOrImplicitDefault", "(Ljava/lang/Object;)Ljava/lang/Object;", "getMap", "()Ljava/util/Map;", "map"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
interface MapWithDefault<K, V> extends Map<K, V>, KMappedMarker {
    @JvmName(name = "getMap")
    Map<K, V> getMap();

    V getOrImplicitDefault(K key);
}
