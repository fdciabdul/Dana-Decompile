package io.reactivex.internal.util;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class ExceptionHelper {
    public static final Throwable KClassImpl$Data$declaredNonStaticMembers$2 = new Termination();

    private ExceptionHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static RuntimeException MyBillsEntityDataFactory(Throwable th) {
        if (th instanceof Error) {
            throw ((Error) th);
        }
        if (th instanceof RuntimeException) {
            return (RuntimeException) th;
        }
        return new RuntimeException(th);
    }

    public static <T> boolean getAuthRequestContext(AtomicReference<Throwable> atomicReference, Throwable th) {
        Throwable th2;
        do {
            th2 = atomicReference.get();
            if (th2 == KClassImpl$Data$declaredNonStaticMembers$2) {
                return false;
            }
        } while (!LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(atomicReference, th2, th2 == null ? th : new CompositeException(th2, th)));
        return true;
    }

    public static <T> Throwable getAuthRequestContext(AtomicReference<Throwable> atomicReference) {
        Throwable th = atomicReference.get();
        Throwable th2 = KClassImpl$Data$declaredNonStaticMembers$2;
        return th != th2 ? atomicReference.getAndSet(th2) : th;
    }

    public static <E extends Throwable> Exception PlaceComponentResult(Throwable th) throws Throwable {
        if (th instanceof Exception) {
            return (Exception) th;
        }
        throw th;
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2(long j, TimeUnit timeUnit) {
        StringBuilder sb = new StringBuilder();
        sb.append("The source did not signal an event for ");
        sb.append(j);
        sb.append(" ");
        sb.append(timeUnit.toString().toLowerCase());
        sb.append(" and has been terminated.");
        return sb.toString();
    }

    /* loaded from: classes.dex */
    static final class Termination extends Throwable {
        private static final long serialVersionUID = -4649703670690200604L;

        @Override // java.lang.Throwable
        public final Throwable fillInStackTrace() {
            return this;
        }

        Termination() {
            super("No further exceptions");
        }
    }
}
