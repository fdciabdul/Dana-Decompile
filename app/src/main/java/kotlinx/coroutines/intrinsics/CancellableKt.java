package kotlinx.coroutines.intrinsics;

import com.huawei.hms.push.e;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.DispatchedContinuationKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0005\u001a\u00020\u00042\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\b\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00040\u00002\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0000¢\u0006\u0004\b\b\u0010\t\u001a>\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\n*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000ø\u0001\u0000¢\u0006\u0004\b\b\u0010\r\u001as\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\n*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u001d\b\u0002\u0010\u0012\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\u0002¢\u0006\u0002\b\u0011\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bH\u0000ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lkotlin/coroutines/Continuation;", "completion", "", e.PlaceComponentResult, "", "dispatcherFailure", "(Lkotlin/coroutines/Continuation;Ljava/lang/Throwable;)V", "fatalCompletion", "startCoroutineCancellable", "(Lkotlin/coroutines/Continuation;Lkotlin/coroutines/Continuation;)V", "T", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "Lkotlin/ParameterName;", "onCancellation", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;Lkotlin/jvm/functions/Function1;)V"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CancellableKt {
    public static final <T> void startCoroutineCancellable(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        try {
            Continuation intercepted = IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(function1, continuation));
            Result.Companion companion = Result.INSTANCE;
            DispatchedContinuationKt.resumeCancellableWith$default(intercepted, Result.m3179constructorimpl(Unit.INSTANCE), null, 2, null);
        } catch (Throwable th) {
            dispatcherFailure(continuation, th);
        }
    }

    public static /* synthetic */ void startCoroutineCancellable$default(Function2 function2, Object obj, Continuation continuation, Function1 function1, int i, Object obj2) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        startCoroutineCancellable(function2, obj, continuation, function1);
    }

    public static final <R, T> void startCoroutineCancellable(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation, Function1<? super Throwable, Unit> function1) {
        try {
            Continuation intercepted = IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(function2, r, continuation));
            Result.Companion companion = Result.INSTANCE;
            DispatchedContinuationKt.resumeCancellableWith(intercepted, Result.m3179constructorimpl(Unit.INSTANCE), function1);
        } catch (Throwable th) {
            dispatcherFailure(continuation, th);
        }
    }

    public static final void startCoroutineCancellable(Continuation<? super Unit> continuation, Continuation<?> continuation2) {
        try {
            Continuation intercepted = IntrinsicsKt.intercepted(continuation);
            Result.Companion companion = Result.INSTANCE;
            DispatchedContinuationKt.resumeCancellableWith$default(intercepted, Result.m3179constructorimpl(Unit.INSTANCE), null, 2, null);
        } catch (Throwable th) {
            dispatcherFailure(continuation2, th);
        }
    }

    private static final void dispatcherFailure(Continuation<?> continuation, Throwable th) {
        Result.Companion companion = Result.INSTANCE;
        continuation.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(th)));
        throw th;
    }
}
