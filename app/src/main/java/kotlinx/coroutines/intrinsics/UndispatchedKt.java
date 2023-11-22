package kotlinx.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a@\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001aT\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0000*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t2\u0006\u0010\n\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u000b\u001a@\u0010\f\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0007\u001aT\u0010\f\u001a\u00020\u0005\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0000*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t2\u0006\u0010\n\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000b\u001a]\u0010\u0010\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\n\u001a\u00028\u00012)\u0010\u000f\u001a%\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t¢\u0006\u0002\b\u000eH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a]\u0010\u0012\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\n\u001a\u00028\u00012)\u0010\u000f\u001a%\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t¢\u0006\u0002\b\u000eH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"T", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "completion", "", "startCoroutineUndispatched", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "startCoroutineUnintercepted", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "Lkotlin/ExtensionFunctionType;", "block", "startUndispatchedOrReturn", "(Lkotlinx/coroutines/internal/ScopeCoroutine;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "startUndispatchedOrReturnIgnoreTimeout"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UndispatchedKt {
    public static final <T, R> Object startUndispatchedOrReturn(ScopeCoroutine<? super T> scopeCoroutine, R r, Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Object completedExceptionally;
        Object makeCompletingOnce$kotlinx_coroutines_core;
        Throwable recoverFromStackFrame;
        int i = 2;
        try {
            completedExceptionally = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, scopeCoroutine);
        } catch (Throwable th) {
            completedExceptionally = new CompletedExceptionally(th, false, i, null);
        }
        if (completedExceptionally != IntrinsicsKt.getCOROUTINE_SUSPENDED() && (makeCompletingOnce$kotlinx_coroutines_core = scopeCoroutine.makeCompletingOnce$kotlinx_coroutines_core(completedExceptionally)) != JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            if (makeCompletingOnce$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                CompletedExceptionally completedExceptionally2 = (CompletedExceptionally) makeCompletingOnce$kotlinx_coroutines_core;
                Throwable th2 = completedExceptionally2.cause;
                Throwable th3 = completedExceptionally2.cause;
                Continuation<? super T> continuation = scopeCoroutine.uCont;
                if (DebugKt.getRECOVER_STACK_TRACES() && (continuation instanceof CoroutineStackFrame)) {
                    recoverFromStackFrame = StackTraceRecoveryKt.recoverFromStackFrame(th3, (CoroutineStackFrame) continuation);
                    throw recoverFromStackFrame;
                }
                throw th3;
            }
            return JobSupportKt.unboxState(makeCompletingOnce$kotlinx_coroutines_core);
        }
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    public static final <T, R> Object startUndispatchedOrReturnIgnoreTimeout(ScopeCoroutine<? super T> scopeCoroutine, R r, Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Object completedExceptionally;
        Object makeCompletingOnce$kotlinx_coroutines_core;
        Throwable recoverFromStackFrame;
        Throwable recoverFromStackFrame2;
        int i = 2;
        try {
            completedExceptionally = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, scopeCoroutine);
        } catch (Throwable th) {
            completedExceptionally = new CompletedExceptionally(th, r1, i, null);
        }
        if (completedExceptionally != IntrinsicsKt.getCOROUTINE_SUSPENDED() && (makeCompletingOnce$kotlinx_coroutines_core = scopeCoroutine.makeCompletingOnce$kotlinx_coroutines_core(completedExceptionally)) != JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            if (makeCompletingOnce$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                CompletedExceptionally completedExceptionally2 = (CompletedExceptionally) makeCompletingOnce$kotlinx_coroutines_core;
                Throwable th2 = completedExceptionally2.cause;
                if (((th2 instanceof TimeoutCancellationException) && ((TimeoutCancellationException) th2).coroutine == scopeCoroutine) ? false : true) {
                    Throwable th3 = completedExceptionally2.cause;
                    Continuation<? super T> continuation = scopeCoroutine.uCont;
                    if (DebugKt.getRECOVER_STACK_TRACES() && (continuation instanceof CoroutineStackFrame)) {
                        recoverFromStackFrame2 = StackTraceRecoveryKt.recoverFromStackFrame(th3, (CoroutineStackFrame) continuation);
                        throw recoverFromStackFrame2;
                    }
                    throw th3;
                } else if (completedExceptionally instanceof CompletedExceptionally) {
                    Throwable th4 = ((CompletedExceptionally) completedExceptionally).cause;
                    Continuation<? super T> continuation2 = scopeCoroutine.uCont;
                    if (DebugKt.getRECOVER_STACK_TRACES() && (continuation2 instanceof CoroutineStackFrame)) {
                        recoverFromStackFrame = StackTraceRecoveryKt.recoverFromStackFrame(th4, (CoroutineStackFrame) continuation2);
                        throw recoverFromStackFrame;
                    }
                    throw th4;
                }
            } else {
                completedExceptionally = JobSupportKt.unboxState(makeCompletingOnce$kotlinx_coroutines_core);
            }
            return completedExceptionally;
        }
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    public static final <T> void startCoroutineUnintercepted(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        Continuation probeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(continuation);
        try {
            Object invoke = ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke(probeCoroutineCreated);
            if (invoke != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                Result.Companion companion = Result.INSTANCE;
                probeCoroutineCreated.resumeWith(Result.m3179constructorimpl(invoke));
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            probeCoroutineCreated.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(th)));
        }
    }

    public static final <R, T> void startCoroutineUnintercepted(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        Continuation probeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(continuation);
        try {
            Object invoke = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, probeCoroutineCreated);
            if (invoke != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                Result.Companion companion = Result.INSTANCE;
                probeCoroutineCreated.resumeWith(Result.m3179constructorimpl(invoke));
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            probeCoroutineCreated.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(th)));
        }
    }

    public static final <T> void startCoroutineUndispatched(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        Continuation probeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(continuation);
        try {
            CoroutineContext context = continuation.getContext();
            Object updateThreadContext = ThreadContextKt.updateThreadContext(context, null);
            try {
                Object invoke = ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke(probeCoroutineCreated);
                if (invoke != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    Result.Companion companion = Result.INSTANCE;
                    probeCoroutineCreated.resumeWith(Result.m3179constructorimpl(invoke));
                }
            } finally {
                ThreadContextKt.restoreThreadContext(context, updateThreadContext);
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            probeCoroutineCreated.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(th)));
        }
    }

    public static final <R, T> void startCoroutineUndispatched(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        Continuation probeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(continuation);
        try {
            CoroutineContext context = continuation.getContext();
            Object updateThreadContext = ThreadContextKt.updateThreadContext(context, null);
            try {
                Object invoke = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, probeCoroutineCreated);
                if (invoke != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    Result.Companion companion = Result.INSTANCE;
                    probeCoroutineCreated.resumeWith(Result.m3179constructorimpl(invoke));
                }
            } finally {
                ThreadContextKt.restoreThreadContext(context, updateThreadContext);
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            probeCoroutineCreated.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(th)));
        }
    }
}
