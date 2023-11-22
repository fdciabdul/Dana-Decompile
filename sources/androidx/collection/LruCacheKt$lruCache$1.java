package androidx.collection;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [V, K] */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", DiskFormatter.KB, "V", "<anonymous parameter 0>", "<anonymous parameter 1>", "", BridgeDSL.INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class LruCacheKt$lruCache$1<K, V> extends Lambda implements Function2<K, V, Integer> {
    public static final LruCacheKt$lruCache$1 INSTANCE = new LruCacheKt$lruCache$1();

    public LruCacheKt$lruCache$1() {
        super(2);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final int invoke2(K k, V v) {
        Intrinsics.checkParameterIsNotNull(k, "");
        Intrinsics.checkParameterIsNotNull(v, "");
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    public final /* synthetic */ Integer invoke(Object obj, Object obj2) {
        return Integer.valueOf(invoke2((LruCacheKt$lruCache$1<K, V>) obj, obj2));
    }
}
