package kotlin.coroutines;

import com.ap.zoloz.hummer.biz.HummerConstants;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u000b\u001aC\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001aB\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001a\b\u0004\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00020\u00050\u0003H\u0086Hø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u000b\u0010\f\u001aD\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u001a]\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\"\u0004\b\u0000\u0010\u0011\"\u0004\b\u0001\u0010\u0000*#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0012¢\u0006\u0002\b\u00132\u0006\u0010\u0014\u001a\u00028\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0015\u001a(\u0010\u0017\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u0016\u001a\u00028\u0000H\u0086\b¢\u0006\u0004\b\u0017\u0010\u0018\u001a(\u0010\u001b\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u001a\u001a\u00020\u0019H\u0086\b¢\u0006\u0004\b\u001b\u0010\u001c\u001a>\u0010\u001d\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001aW\u0010\u001d\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0011\"\u0004\b\u0001\u0010\u0000*#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0012¢\u0006\u0002\b\u00132\u0006\u0010\u0014\u001a\u00028\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001f\"\u0018\u0010$\u001a\u00020\u00018Ç\u0002¢\u0006\f\u0012\u0004\b\"\u0010#\u001a\u0004\b \u0010!\u0082\u0002\u000b\n\u0005\b\u009920\u0001\n\u0002\b\u0019"}, d2 = {"T", "Lkotlin/coroutines/CoroutineContext;", HummerConstants.CONTEXT, "Lkotlin/Function1;", "Lkotlin/Result;", "", "resumeWith", "Lkotlin/coroutines/Continuation;", "Continuation", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function1;)Lkotlin/coroutines/Continuation;", "block", "suspendCoroutine", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "completion", "createCoroutine", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "value", "resume", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "", "exception", "resumeWithException", "(Lkotlin/coroutines/Continuation;Ljava/lang/Throwable;)V", "startCoroutine", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext$annotations", "()V", "coroutineContext"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ContinuationKt {
    public static /* synthetic */ void getCoroutineContext$annotations() {
    }

    private static final <T> void resume(Continuation<? super T> continuation, T t) {
        Intrinsics.checkNotNullParameter(continuation, "");
        Result.Companion companion = Result.INSTANCE;
        continuation.resumeWith(Result.m3179constructorimpl(t));
    }

    private static final <T> void resumeWithException(Continuation<? super T> continuation, Throwable th) {
        Intrinsics.checkNotNullParameter(continuation, "");
        Intrinsics.checkNotNullParameter(th, "");
        Result.Companion companion = Result.INSTANCE;
        continuation.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(th)));
    }

    private static final <T> Continuation<T> Continuation(final CoroutineContext coroutineContext, final Function1<? super Result<? extends T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(coroutineContext, "");
        Intrinsics.checkNotNullParameter(function1, "");
        return new Continuation<T>() { // from class: kotlin.coroutines.ContinuationKt$Continuation$1
            @Override // kotlin.coroutines.Continuation
            @JvmName(name = "getContext")
            /* renamed from: getContext  reason: from getter */
            public final CoroutineContext get$context() {
                return CoroutineContext.this;
            }

            @Override // kotlin.coroutines.Continuation
            public final void resumeWith(Object result) {
                function1.invoke(Result.m3178boximpl(result));
            }
        };
    }

    public static final <T> Continuation<Unit> createCoroutine(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(continuation, "");
        return new SafeContinuation(IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(function1, continuation)), IntrinsicsKt.getCOROUTINE_SUSPENDED());
    }

    public static final <R, T> Continuation<Unit> createCoroutine(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(function2, "");
        Intrinsics.checkNotNullParameter(continuation, "");
        return new SafeContinuation(IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(function2, r, continuation)), IntrinsicsKt.getCOROUTINE_SUSPENDED());
    }

    public static final <T> void startCoroutine(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(continuation, "");
        Continuation intercepted = IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(function1, continuation));
        Result.Companion companion = Result.INSTANCE;
        intercepted.resumeWith(Result.m3179constructorimpl(Unit.INSTANCE));
    }

    public static final <R, T> void startCoroutine(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(function2, "");
        Intrinsics.checkNotNullParameter(continuation, "");
        Continuation intercepted = IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(function2, r, continuation));
        Result.Companion companion = Result.INSTANCE;
        intercepted.resumeWith(Result.m3179constructorimpl(Unit.INSTANCE));
    }

    private static final <T> Object suspendCoroutine(Function1<? super Continuation<? super T>, Unit> function1, Continuation<? super T> continuation) {
        InlineMarker.mark(0);
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        function1.invoke(safeContinuation);
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return orThrow;
    }

    @JvmName(name = "getCoroutineContext")
    private static final CoroutineContext getCoroutineContext() {
        throw new NotImplementedError("Implemented as intrinsic");
    }
}
