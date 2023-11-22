package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0082\b\u0018\u00002\u00020\u0001BT\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u001d\b\u0002\u0010\t\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\u0006¢\u0006\u0002\b\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b$\u0010%J_\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u001d\b\u0002\u0010\t\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\u0006¢\u0006\u0002\b\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0018\u001a\u00020\b2\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u0017\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\u001dR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u001eR\u0011\u0010!\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\"R)\u0010\t\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\u0006¢\u0006\u0002\b\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010#R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\""}, d2 = {"Lkotlinx/coroutines/CompletedContinuation;", "", "result", "Lkotlinx/coroutines/CancelHandler;", "cancelHandler", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "", "onCancellation", "idempotentResume", "cancelCause", "copy", "(Ljava/lang/Object;Lkotlinx/coroutines/CancelHandler;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Ljava/lang/Throwable;)Lkotlinx/coroutines/CompletedContinuation;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lkotlinx/coroutines/CancellableContinuationImpl;", "cont", "cause", "invokeHandlers", "(Lkotlinx/coroutines/CancellableContinuationImpl;Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Throwable;", "Lkotlinx/coroutines/CancelHandler;", "getCancelled", "()Z", "cancelled", "Ljava/lang/Object;", "Lkotlin/jvm/functions/Function1;", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/CancelHandler;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Ljava/lang/Throwable;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
final /* data */ class CompletedContinuation {
    public final Throwable cancelCause;
    public final CancelHandler cancelHandler;
    public final Object idempotentResume;
    public final Function1<Throwable, Unit> onCancellation;
    public final Object result;

    public static /* synthetic */ CompletedContinuation copy$default(CompletedContinuation completedContinuation, Object obj, CancelHandler cancelHandler, Function1 function1, Object obj2, Throwable th, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = completedContinuation.result;
        }
        if ((i & 2) != 0) {
            cancelHandler = completedContinuation.cancelHandler;
        }
        CancelHandler cancelHandler2 = cancelHandler;
        Function1<Throwable, Unit> function12 = function1;
        if ((i & 4) != 0) {
            function12 = completedContinuation.onCancellation;
        }
        Function1 function13 = function12;
        if ((i & 8) != 0) {
            obj2 = completedContinuation.idempotentResume;
        }
        Object obj4 = obj2;
        if ((i & 16) != 0) {
            th = completedContinuation.cancelCause;
        }
        return completedContinuation.copy(obj, cancelHandler2, function13, obj4, th);
    }

    public final CompletedContinuation copy(Object result, CancelHandler cancelHandler, Function1<? super Throwable, Unit> onCancellation, Object idempotentResume, Throwable cancelCause) {
        return new CompletedContinuation(result, cancelHandler, onCancellation, idempotentResume, cancelCause);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CompletedContinuation) {
            CompletedContinuation completedContinuation = (CompletedContinuation) other;
            return Intrinsics.areEqual(this.result, completedContinuation.result) && Intrinsics.areEqual(this.cancelHandler, completedContinuation.cancelHandler) && Intrinsics.areEqual(this.onCancellation, completedContinuation.onCancellation) && Intrinsics.areEqual(this.idempotentResume, completedContinuation.idempotentResume) && Intrinsics.areEqual(this.cancelCause, completedContinuation.cancelCause);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.result;
        int hashCode = obj == null ? 0 : obj.hashCode();
        CancelHandler cancelHandler = this.cancelHandler;
        int hashCode2 = cancelHandler == null ? 0 : cancelHandler.hashCode();
        Function1<Throwable, Unit> function1 = this.onCancellation;
        int hashCode3 = function1 == null ? 0 : function1.hashCode();
        Object obj2 = this.idempotentResume;
        int hashCode4 = obj2 == null ? 0 : obj2.hashCode();
        Throwable th = this.cancelCause;
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CompletedContinuation(result=");
        sb.append(this.result);
        sb.append(", cancelHandler=");
        sb.append(this.cancelHandler);
        sb.append(", onCancellation=");
        sb.append(this.onCancellation);
        sb.append(", idempotentResume=");
        sb.append(this.idempotentResume);
        sb.append(", cancelCause=");
        sb.append(this.cancelCause);
        sb.append(')');
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CompletedContinuation(Object obj, CancelHandler cancelHandler, Function1<? super Throwable, Unit> function1, Object obj2, Throwable th) {
        this.result = obj;
        this.cancelHandler = cancelHandler;
        this.onCancellation = function1;
        this.idempotentResume = obj2;
        this.cancelCause = th;
    }

    public /* synthetic */ CompletedContinuation(Object obj, CancelHandler cancelHandler, Function1 function1, Object obj2, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? null : cancelHandler, (i & 4) != 0 ? null : function1, (i & 8) != 0 ? null : obj2, (i & 16) != 0 ? null : th);
    }

    @JvmName(name = "getCancelled")
    public final boolean getCancelled() {
        return this.cancelCause != null;
    }

    public final void invokeHandlers(CancellableContinuationImpl<?> cont, Throwable cause) {
        CancelHandler cancelHandler = this.cancelHandler;
        if (cancelHandler != null) {
            cont.callCancelHandler(cancelHandler, cause);
        }
        Function1<Throwable, Unit> function1 = this.onCancellation;
        if (function1 != null) {
            cont.callOnCancellation(function1, cause);
        }
    }
}
