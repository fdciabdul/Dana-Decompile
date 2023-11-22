package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0004\u001a\u00020\u00038\u0011X\u0090\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00038QX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/JobImpl;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/CompletableJob;", "", "handlesException", "()Z", "Z", "getHandlesException$kotlinx_coroutines_core", "getOnCancelComplete$kotlinx_coroutines_core", "onCancelComplete", "Lkotlinx/coroutines/Job;", "parent", "<init>", "(Lkotlinx/coroutines/Job;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public class JobImpl extends JobSupport implements CompletableJob {
    private final boolean handlesException;

    @Override // kotlinx.coroutines.JobSupport
    @JvmName(name = "getOnCancelComplete$kotlinx_coroutines_core")
    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return true;
    }

    public JobImpl(Job job) {
        super(true);
        initParentJob(job);
        this.handlesException = handlesException();
    }

    @Override // kotlinx.coroutines.JobSupport
    @JvmName(name = "getHandlesException$kotlinx_coroutines_core")
    /* renamed from: getHandlesException$kotlinx_coroutines_core  reason: from getter */
    public boolean getHandlesException() {
        return this.handlesException;
    }

    private final boolean handlesException() {
        JobSupport job;
        ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        ChildHandleNode childHandleNode = parentHandle$kotlinx_coroutines_core instanceof ChildHandleNode ? (ChildHandleNode) parentHandle$kotlinx_coroutines_core : null;
        if (childHandleNode == null || (job = childHandleNode.getJob()) == null) {
            return false;
        }
        while (!job.getHandlesException()) {
            ChildHandle parentHandle$kotlinx_coroutines_core2 = job.getParentHandle$kotlinx_coroutines_core();
            ChildHandleNode childHandleNode2 = parentHandle$kotlinx_coroutines_core2 instanceof ChildHandleNode ? (ChildHandleNode) parentHandle$kotlinx_coroutines_core2 : null;
            if (childHandleNode2 == null || (job = childHandleNode2.getJob()) == null) {
                return false;
            }
        }
        return true;
    }
}
