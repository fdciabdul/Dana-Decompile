package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public class ForwardingTimeout extends Timeout {
    public Timeout getAuthRequestContext;

    public ForwardingTimeout(Timeout timeout) {
        if (timeout == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.getAuthRequestContext = timeout;
    }

    @Override // okio.Timeout
    public Timeout timeout(long j, TimeUnit timeUnit) {
        return this.getAuthRequestContext.timeout(j, timeUnit);
    }

    @Override // okio.Timeout
    public long timeoutNanos() {
        return this.getAuthRequestContext.timeoutNanos();
    }

    @Override // okio.Timeout
    public boolean hasDeadline() {
        return this.getAuthRequestContext.hasDeadline();
    }

    @Override // okio.Timeout
    public long deadlineNanoTime() {
        return this.getAuthRequestContext.deadlineNanoTime();
    }

    @Override // okio.Timeout
    public Timeout deadlineNanoTime(long j) {
        return this.getAuthRequestContext.deadlineNanoTime(j);
    }

    @Override // okio.Timeout
    public Timeout clearTimeout() {
        return this.getAuthRequestContext.clearTimeout();
    }

    @Override // okio.Timeout
    public Timeout clearDeadline() {
        return this.getAuthRequestContext.clearDeadline();
    }

    @Override // okio.Timeout
    public void throwIfReached() throws IOException {
        this.getAuthRequestContext.throwIfReached();
    }
}
