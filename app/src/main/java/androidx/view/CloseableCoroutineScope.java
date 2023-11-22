package androidx.view;

import java.io.Closeable;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt__JobKt;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0007\u001a\u00020\u00068\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n"}, d2 = {"Landroidx/lifecycle/CloseableCoroutineScope;", "Ljava/io/Closeable;", "Lkotlinx/coroutines/CoroutineScope;", "", "close", "()V", "Lkotlin/coroutines/CoroutineContext;", "PlaceComponentResult", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "p0", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CloseableCoroutineScope implements Closeable, CoroutineScope {
    private final CoroutineContext PlaceComponentResult;

    public CloseableCoroutineScope(CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(coroutineContext, "");
        this.PlaceComponentResult = coroutineContext;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @JvmName(name = "getCoroutineContext")
    /* renamed from: getCoroutineContext  reason: from getter */
    public final CoroutineContext getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        JobKt__JobKt.cancel$default(getPlaceComponentResult(), null, 1, null);
    }
}
