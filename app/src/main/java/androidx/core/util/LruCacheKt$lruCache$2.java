package androidx.core.util;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [V, K] */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u0005\u0010\u0004\u001a\u0004\u0018\u00018\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0003\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", DiskFormatter.KB, "V", "it", BridgeDSL.INVOKE, "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 176)
/* loaded from: classes6.dex */
public final class LruCacheKt$lruCache$2<K, V> extends Lambda implements Function1<K, V> {
    public static final LruCacheKt$lruCache$2 INSTANCE = new LruCacheKt$lruCache$2();

    public LruCacheKt$lruCache$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final V invoke(K k) {
        Intrinsics.checkNotNullParameter(k, "");
        return null;
    }
}
