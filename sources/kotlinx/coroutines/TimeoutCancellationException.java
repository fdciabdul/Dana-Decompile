package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B\u0011\b\u0010\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fB\u001b\b\u0000\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000b\u0010\rJ\u0011\u0010\u0004\u001a\u0004\u0018\u00010\u0000H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0000X\u0080\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlinx/coroutines/TimeoutCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Lkotlinx/coroutines/CopyableThrowable;", "createCopy", "()Lkotlinx/coroutines/TimeoutCancellationException;", "Lkotlinx/coroutines/Job;", "coroutine", "Lkotlinx/coroutines/Job;", "", "message", "<init>", "(Ljava/lang/String;)V", "(Ljava/lang/String;Lkotlinx/coroutines/Job;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TimeoutCancellationException extends CancellationException implements CopyableThrowable<TimeoutCancellationException> {
    public final Job coroutine;

    public TimeoutCancellationException(String str, Job job) {
        super(str);
        this.coroutine = job;
    }

    public TimeoutCancellationException(String str) {
        this(str, null);
    }

    @Override // kotlinx.coroutines.CopyableThrowable
    public final TimeoutCancellationException createCopy() {
        String message = getMessage();
        if (message == null) {
            message = "";
        }
        TimeoutCancellationException timeoutCancellationException = new TimeoutCancellationException(message, this.coroutine);
        timeoutCancellationException.initCause(this);
        return timeoutCancellationException;
    }
}
