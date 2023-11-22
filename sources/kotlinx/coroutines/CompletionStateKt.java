package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a6\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001aC\u0010\r\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00052\u001d\b\u0002\u0010\f\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\t¢\u0006\u0002\b\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bH\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a0\u0010\r\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00052\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"T", "", "state", "Lkotlin/coroutines/Continuation;", "uCont", "Lkotlin/Result;", "recoverResult", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "", "onCancellation", "toState", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lkotlinx/coroutines/CancellableContinuation;", "caller", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Object;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CompletionStateKt {
    public static /* synthetic */ Object toState$default(Object obj, Function1 function1, int i, Object obj2) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        return toState(obj, function1);
    }

    public static final <T> Object toState(Object obj, Function1<? super Throwable, Unit> function1) {
        Throwable m3182exceptionOrNullimpl = Result.m3182exceptionOrNullimpl(obj);
        if (m3182exceptionOrNullimpl == null) {
            return function1 != null ? new CompletedWithCancellation(obj, function1) : obj;
        }
        return new CompletedExceptionally(m3182exceptionOrNullimpl, false, 2, null);
    }

    public static final <T> Object toState(Object obj, CancellableContinuation<?> cancellableContinuation) {
        Throwable m3182exceptionOrNullimpl = Result.m3182exceptionOrNullimpl(obj);
        if (m3182exceptionOrNullimpl != null) {
            if (DebugKt.getRECOVER_STACK_TRACES()) {
                CancellableContinuation<?> cancellableContinuation2 = cancellableContinuation;
                if (cancellableContinuation2 instanceof CoroutineStackFrame) {
                    m3182exceptionOrNullimpl = StackTraceRecoveryKt.recoverFromStackFrame(m3182exceptionOrNullimpl, (CoroutineStackFrame) cancellableContinuation2);
                }
            }
            return new CompletedExceptionally(m3182exceptionOrNullimpl, false, 2, null);
        }
        return obj;
    }

    public static final <T> Object recoverResult(Object obj, Continuation<? super T> continuation) {
        if (obj instanceof CompletedExceptionally) {
            Result.Companion companion = Result.INSTANCE;
            Throwable th = ((CompletedExceptionally) obj).cause;
            if (DebugKt.getRECOVER_STACK_TRACES() && (continuation instanceof CoroutineStackFrame)) {
                th = StackTraceRecoveryKt.recoverFromStackFrame(th, (CoroutineStackFrame) continuation);
            }
            return Result.m3179constructorimpl(ResultKt.createFailure(th));
        }
        Result.Companion companion2 = Result.INSTANCE;
        return Result.m3179constructorimpl(obj);
    }
}
