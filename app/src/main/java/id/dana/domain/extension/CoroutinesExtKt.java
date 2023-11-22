package id.dana.domain.extension;

import id.dana.domain.common.ScopeBackedScheduler;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001f\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b*\u0004\u0018\u00018\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lkotlinx/coroutines/Job;", "Lio/reactivex/disposables/Disposable;", "asDisposable", "(Lkotlinx/coroutines/Job;)Lio/reactivex/disposables/Disposable;", "Lkotlinx/coroutines/CoroutineScope;", "Lio/reactivex/Scheduler;", "asScheduler", "(Lkotlinx/coroutines/CoroutineScope;)Lio/reactivex/Scheduler;", "T", "await", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CoroutinesExtKt {
    public static final Scheduler asScheduler(CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "");
        return new ScopeBackedScheduler(coroutineScope);
    }

    public static final Disposable asDisposable(final Job job) {
        Intrinsics.checkNotNullParameter(job, "");
        return new Disposable() { // from class: id.dana.domain.extension.CoroutinesExtKt$asDisposable$1
            @Override // io.reactivex.disposables.Disposable
            public final boolean isDisposed() {
                return !Job.this.isActive();
            }

            @Override // io.reactivex.disposables.Disposable
            public final void dispose() {
                Job.DefaultImpls.cancel$default(Job.this, null, 1, null);
            }
        };
    }

    public static final <T> Object await(T t, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        if (t != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl2.resumeWith(Result.m3179constructorimpl(t));
        } else {
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuationImpl2.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(new NullPointerException("Null return value"))));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
