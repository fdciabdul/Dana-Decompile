package androidx.view;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0000X\u0080\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Landroidx/lifecycle/PausingDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlin/coroutines/CoroutineContext;", "p0", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "p1", "", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "", "isDispatchNeeded", "(Lkotlin/coroutines/CoroutineContext;)Z", "Landroidx/lifecycle/DispatchQueue;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/lifecycle/DispatchQueue;", "getAuthRequestContext", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PausingDispatcher extends CoroutineDispatcher {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final DispatchQueue getAuthRequestContext = new DispatchQueue();

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final boolean isDispatchNeeded(CoroutineContext p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (Dispatchers.getMain().getImmediate().isDispatchNeeded(p0)) {
            return true;
        }
        return !this.getAuthRequestContext.MyBillsEntityDataFactory();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* renamed from: dispatch */
    public final void mo4661dispatch(CoroutineContext p0, final Runnable p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        final DispatchQueue dispatchQueue = this.getAuthRequestContext;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
        if (immediate.isDispatchNeeded(p0) || dispatchQueue.MyBillsEntityDataFactory()) {
            immediate.mo4661dispatch(p0, new Runnable() { // from class: androidx.lifecycle.DispatchQueue$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DispatchQueue.getAuthRequestContext(DispatchQueue.this, p1);
                }
            });
        } else if (!dispatchQueue.BuiltInFictitiousFunctionClassFactory.offer(p1)) {
            throw new IllegalStateException("cannot enqueue any more runnables".toString());
        } else {
            dispatchQueue.PlaceComponentResult();
        }
    }
}
