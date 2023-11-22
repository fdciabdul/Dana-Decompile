package kotlinx.coroutines.flow.internal;

import com.iap.ac.android.biz.common.utils.log.LogConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\u00072\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", LogConstants.RESULT_FALSE, "", "flow", "", "allocateLocked", "(Ljava/lang/Object;)Z", "", "Lkotlin/coroutines/Continuation;", "", "freeLocked", "(Ljava/lang/Object;)[Lkotlin/coroutines/Continuation;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class AbstractSharedFlowSlot<F> {
    public abstract boolean allocateLocked(F flow);

    public abstract Continuation<Unit>[] freeLocked(F flow);
}
