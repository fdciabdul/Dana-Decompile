package kotlin.jdk7;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0004\u001a\u00020\u0003*\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001aJ\u0010\n\u001a\u00028\u0001\"\n\b\u0000\u0010\u0006*\u0004\u0018\u00010\u0000\"\u0004\b\u0001\u0010\u0007*\u00028\u00002\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001"}, d2 = {"Ljava/lang/AutoCloseable;", "", "cause", "", "closeFinally", "(Ljava/lang/AutoCloseable;Ljava/lang/Throwable;)V", "T", "R", "Lkotlin/Function1;", "block", "use", "(Ljava/lang/AutoCloseable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;"}, k = 2, mv = {1, 6, 0}, pn = "", xi = 48)
/* loaded from: classes9.dex */
public final class AutoCloseableKt {
    private static final <T extends AutoCloseable, R> R use(T t, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        try {
            R invoke = function1.invoke(t);
            InlineMarker.finallyStart(1);
            closeFinally(t, null);
            InlineMarker.finallyEnd(1);
            return invoke;
        } finally {
        }
    }

    public static final void closeFinally(AutoCloseable autoCloseable, Throwable th) {
        if (autoCloseable != null) {
            if (th == null) {
                autoCloseable.close();
                return;
            }
            try {
                autoCloseable.close();
            } catch (Throwable th2) {
                ExceptionsKt.addSuppressed(th, th2);
            }
        }
    }
}
