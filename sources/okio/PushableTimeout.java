package okio;

import java.util.concurrent.TimeUnit;

/* loaded from: classes9.dex */
final class PushableTimeout extends Timeout {
    private long MyBillsEntityDataFactory;
    private long PlaceComponentResult;
    private boolean getAuthRequestContext;
    private Timeout scheduleImpl;

    PushableTimeout() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void BuiltInFictitiousFunctionClassFactory(Timeout timeout) {
        this.scheduleImpl = timeout;
        boolean hasDeadline = timeout.hasDeadline();
        this.getAuthRequestContext = hasDeadline;
        this.MyBillsEntityDataFactory = hasDeadline ? timeout.deadlineNanoTime() : -1L;
        long timeoutNanos = timeout.timeoutNanos();
        this.PlaceComponentResult = timeoutNanos;
        timeout.timeout(minTimeout(timeoutNanos, timeoutNanos()), TimeUnit.NANOSECONDS);
        if (this.getAuthRequestContext && hasDeadline()) {
            timeout.deadlineNanoTime(Math.min(deadlineNanoTime(), this.MyBillsEntityDataFactory));
        } else if (hasDeadline()) {
            timeout.deadlineNanoTime(deadlineNanoTime());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.scheduleImpl.timeout(this.PlaceComponentResult, TimeUnit.NANOSECONDS);
        if (this.getAuthRequestContext) {
            this.scheduleImpl.deadlineNanoTime(this.MyBillsEntityDataFactory);
        } else {
            this.scheduleImpl.clearDeadline();
        }
    }
}
