package kotlin.collections.jdk8;

import com.alibaba.griver.image.photo.utils.DiskFormatter;
import j$.util.Map;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001aE\u0010\u0006\u001a\u00028\u0001\"\u000b\b\u0000\u0010\u0001\u0018\u0001¢\u0006\u0002\b\u0000\"\u0004\b\u0001\u0010\u0002*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0001H\u0086\b¢\u0006\u0004\b\u0006\u0010\u0007\u001aN\u0010\u000b\u001a\u00020\n\"\u000b\b\u0000\u0010\u0001\u0018\u0001¢\u0006\u0002\b\u0000\"\u000b\b\u0001\u0010\u0002\u0018\u0001¢\u0006\u0002\b\u0000*\u0012\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00028\u00010\b2\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0001H\u0086\b¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lkotlin/internal/OnlyInputTypes;", DiskFormatter.KB, "V", "", "key", "defaultValue", "getOrDefault", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "", "value", "", "remove", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Z"}, k = 2, mv = {1, 6, 0}, pn = "", xi = 48)
/* loaded from: classes9.dex */
public final class CollectionsJDK8Kt {
    private static final <K, V> V getOrDefault(Map<? extends K, ? extends V> map, K k, V v) {
        Intrinsics.checkNotNullParameter(map, "");
        return (V) Map.EL.KClassImpl$Data$declaredNonStaticMembers$2(map, k, v);
    }

    private static final <K, V> boolean remove(java.util.Map<? extends K, ? extends V> map, K k, V v) {
        Intrinsics.checkNotNullParameter(map, "");
        return Map.EL.BuiltInFictitiousFunctionClassFactory(TypeIntrinsics.asMutableMap(map), k, v);
    }
}
