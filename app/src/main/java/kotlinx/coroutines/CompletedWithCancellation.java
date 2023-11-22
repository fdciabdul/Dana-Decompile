package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0080\b\u0018\u00002\u00020\u0001B,\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001\u0012\u0019\u0010\u0010\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\r¢\u0006\u0002\b\u000e\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR$\u0010\u0010\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\r¢\u0006\u0002\b\u000e\u0012\u0004\u0012\u00020\u000f0\f8\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lkotlinx/coroutines/CompletedWithCancellation;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "", "onCancellation", "Lkotlin/jvm/functions/Function1;", "result", "Ljava/lang/Object;", "<init>", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class CompletedWithCancellation {
    public final Function1<Throwable, Unit> onCancellation;
    public final Object result;

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CompletedWithCancellation) {
            CompletedWithCancellation completedWithCancellation = (CompletedWithCancellation) other;
            return Intrinsics.areEqual(this.result, completedWithCancellation.result) && Intrinsics.areEqual(this.onCancellation, completedWithCancellation.onCancellation);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.result;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.onCancellation.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CompletedWithCancellation(result=");
        sb.append(this.result);
        sb.append(", onCancellation=");
        sb.append(this.onCancellation);
        sb.append(')');
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CompletedWithCancellation(Object obj, Function1<? super Throwable, Unit> function1) {
        this.result = obj;
        this.onCancellation = function1;
    }
}
