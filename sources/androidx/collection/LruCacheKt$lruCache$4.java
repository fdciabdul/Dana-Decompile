package androidx.collection;

import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [V, K] */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u0019\u0010\u0003\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J1\u0010\n\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u00012\b\u0010\b\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0001H\u0014¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Landroidx/collection/LruCacheKt$lruCache$4;", "Landroidx/collection/LruCache;", "p0", ARiverTrackWatchDogEventConstant.FLAG_START_UP_CREATE, "(Ljava/lang/Object;)Ljava/lang/Object;", "", "p1", "p2", "p3", "", "entryRemoved", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "", "sizeOf", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class LruCacheKt$lruCache$4<K, V> extends LruCache<K, V> {
    final /* synthetic */ Function4 KClassImpl$Data$declaredNonStaticMembers$2;
    final /* synthetic */ Function1 MyBillsEntityDataFactory;
    final /* synthetic */ Function2 PlaceComponentResult;

    @Override // androidx.collection.LruCache
    protected final int sizeOf(K p0, V p1) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        return ((Number) this.PlaceComponentResult.invoke(p0, p1)).intValue();
    }

    @Override // androidx.collection.LruCache
    protected final V create(K p0) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        return (V) this.MyBillsEntityDataFactory.invoke(p0);
    }

    @Override // androidx.collection.LruCache
    protected final void entryRemoved(boolean p0, K p1, V p2, V p3) {
        Intrinsics.checkParameterIsNotNull(p1, "");
        Intrinsics.checkParameterIsNotNull(p2, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.invoke(Boolean.valueOf(p0), p1, p2, p3);
    }
}
