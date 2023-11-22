package androidx.view;

import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0007J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\tR\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\tR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Landroidx/lifecycle/DispatchQueue;", "", "", "MyBillsEntityDataFactory", "()Z", "", "PlaceComponentResult", "()V", "getAuthRequestContext", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/Queue;", "Ljava/lang/Runnable;", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/Queue;", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DispatchQueue {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    boolean PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    boolean getAuthRequestContext = true;
    final Queue<Runnable> BuiltInFictitiousFunctionClassFactory = new ArrayDeque();

    public final void PlaceComponentResult() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            return;
        }
        try {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            while ((!this.BuiltInFictitiousFunctionClassFactory.isEmpty()) != false && MyBillsEntityDataFactory()) {
                Runnable poll = this.BuiltInFictitiousFunctionClassFactory.poll();
                if (poll != null) {
                    poll.run();
                }
            }
        } finally {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        }
    }

    public final boolean MyBillsEntityDataFactory() {
        return this.PlaceComponentResult || !this.getAuthRequestContext;
    }

    public static /* synthetic */ void getAuthRequestContext(DispatchQueue dispatchQueue, Runnable runnable) {
        Intrinsics.checkNotNullParameter(dispatchQueue, "");
        Intrinsics.checkNotNullParameter(runnable, "");
        if (!dispatchQueue.BuiltInFictitiousFunctionClassFactory.offer(runnable)) {
            throw new IllegalStateException("cannot enqueue any more runnables".toString());
        }
        dispatchQueue.PlaceComponentResult();
    }
}
