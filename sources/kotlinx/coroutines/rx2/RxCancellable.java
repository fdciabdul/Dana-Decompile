package kotlinx.coroutines.rx2;

import io.reactivex.functions.Cancellable;
import kotlin.Metadata;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlinx/coroutines/rx2/RxCancellable;", "Lio/reactivex/functions/Cancellable;", "", "cancel", "()V", "Lkotlinx/coroutines/Job;", "job", "Lkotlinx/coroutines/Job;", "<init>", "(Lkotlinx/coroutines/Job;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RxCancellable implements Cancellable {
    private final Job job;

    public RxCancellable(Job job) {
        this.job = job;
    }

    @Override // io.reactivex.functions.Cancellable
    public final void cancel() {
        Job.DefaultImpls.cancel$default(this.job, null, 1, null);
    }
}
