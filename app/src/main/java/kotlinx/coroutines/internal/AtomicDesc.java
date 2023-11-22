package kotlinx.coroutines.internal;

import com.iap.ac.android.biz.common.utils.log.LogConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0006\u001a\u00020\u00052\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\u0004\u0018\u00010\u00012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H&¢\u0006\u0004\b\b\u0010\tR&\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u00028\u0007@\u0007X\u0086.¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f"}, d2 = {"Lkotlinx/coroutines/internal/AtomicDesc;", "", "Lkotlinx/coroutines/internal/AtomicOp;", "op", "failure", "", "complete", "(Lkotlinx/coroutines/internal/AtomicOp;Ljava/lang/Object;)V", LogConstants.Mpm.EndNodeType.PREPARE, "(Lkotlinx/coroutines/internal/AtomicOp;)Ljava/lang/Object;", "atomicOp", "Lkotlinx/coroutines/internal/AtomicOp;", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "setAtomicOp", "(Lkotlinx/coroutines/internal/AtomicOp;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class AtomicDesc {
    public AtomicOp<?> atomicOp;

    public abstract void complete(AtomicOp<?> op, Object failure);

    public abstract Object prepare(AtomicOp<?> op);

    @JvmName(name = "getAtomicOp")
    public final AtomicOp<?> getAtomicOp() {
        AtomicOp<?> atomicOp = this.atomicOp;
        if (atomicOp != null) {
            return atomicOp;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setAtomicOp")
    public final void setAtomicOp(AtomicOp<?> atomicOp) {
        this.atomicOp = atomicOp;
    }
}
