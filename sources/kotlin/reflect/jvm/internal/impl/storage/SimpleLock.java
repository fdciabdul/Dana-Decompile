package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
public interface SimpleLock {
    public static final Companion Companion = Companion.$$INSTANCE;

    void lock();

    void unlock();

    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        /* JADX WARN: Type inference failed for: r3v1, types: [java.util.concurrent.locks.Lock, kotlin.jvm.internal.DefaultConstructorMarker] */
        public final DefaultSimpleLock simpleLock(Runnable runnable, Function1<? super InterruptedException, Unit> function1) {
            if (runnable != null && function1 != null) {
                return new CancellableSimpleLock(runnable, function1);
            }
            ?? r3 = 0;
            return new DefaultSimpleLock(r3, 1, r3);
        }
    }
}
