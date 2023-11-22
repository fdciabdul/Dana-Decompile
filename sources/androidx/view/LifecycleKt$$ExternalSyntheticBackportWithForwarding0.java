package androidx.view;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final /* synthetic */ class LifecycleKt$$ExternalSyntheticBackportWithForwarding0 {
    public static /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(AtomicReference atomicReference, Object obj, Object obj2) {
        while (!atomicReference.compareAndSet(obj, obj2)) {
            if (atomicReference.get() != obj) {
                return false;
            }
        }
        return true;
    }
}
