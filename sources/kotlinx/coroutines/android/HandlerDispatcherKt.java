package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001d\u0010\b\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u001b\u0010\u000e\u001a\u00020\r*\u00020\n2\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u000e\u0010\u000f\"\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0000X\u0080\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\"\u0018\u0010\u0001\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0001\u0010\u0013"}, d2 = {"Landroid/view/Choreographer;", "choreographer", "Lkotlinx/coroutines/CancellableContinuation;", "", "cont", "", "postFrameCallback", "(Landroid/view/Choreographer;Lkotlinx/coroutines/CancellableContinuation;)V", "updateChoreographerAndPostFrameCallback", "(Lkotlinx/coroutines/CancellableContinuation;)V", "Landroid/os/Looper;", "", "async", "Landroid/os/Handler;", "asHandler", "(Landroid/os/Looper;Z)Landroid/os/Handler;", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Main", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Landroid/view/Choreographer;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class HandlerDispatcherKt {
    public static final HandlerDispatcher Main;
    private static volatile Choreographer choreographer;

    public static final Handler asHandler(Looper looper, boolean z) {
        if (!z || Build.VERSION.SDK_INT < 16) {
            return new Handler(looper);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            Object invoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
            if (invoke != null) {
                return (Handler) invoke;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.os.Handler");
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (NoSuchMethodException unused) {
            return new Handler(looper);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v3 */
    static {
        Object m3179constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            m3179constructorimpl = Result.m3179constructorimpl(new HandlerContext(asHandler(Looper.getMainLooper(), true), r0, 2, r0));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m3179constructorimpl = Result.m3179constructorimpl(ResultKt.createFailure(th));
        }
        Main = (HandlerDispatcher) (Result.m3185isFailureimpl(m3179constructorimpl) ? 0 : m3179constructorimpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateChoreographerAndPostFrameCallback(CancellableContinuation<? super Long> cancellableContinuation) {
        Choreographer choreographer2 = choreographer;
        if (choreographer2 == null) {
            choreographer2 = Choreographer.getInstance();
            Intrinsics.checkNotNull(choreographer2);
            choreographer = choreographer2;
        }
        postFrameCallback(choreographer2, cancellableContinuation);
    }

    private static final void postFrameCallback(Choreographer choreographer2, final CancellableContinuation<? super Long> cancellableContinuation) {
        choreographer2.postFrameCallback(new Choreographer.FrameCallback() { // from class: kotlinx.coroutines.android.HandlerDispatcherKt$$ExternalSyntheticLambda0
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                HandlerDispatcherKt.m4630postFrameCallback$lambda6(CancellableContinuation.this, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: postFrameCallback$lambda-6  reason: not valid java name */
    public static final void m4630postFrameCallback$lambda6(CancellableContinuation cancellableContinuation, long j) {
        cancellableContinuation.resumeUndispatched(Dispatchers.getMain(), Long.valueOf(j));
    }
}
