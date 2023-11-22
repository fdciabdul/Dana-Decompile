package com.alibaba.griver.lottie.okio;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public class Timeout {
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;
    public static final byte[] getAuthRequestContext = {114, -124, TarHeader.LF_CONTIG, 72, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int BuiltInFictitiousFunctionClassFactory = 34;
    public static final Timeout NONE = new Timeout() { // from class: com.alibaba.griver.lottie.okio.Timeout.1
        @Override // com.alibaba.griver.lottie.okio.Timeout
        public final Timeout deadlineNanoTime(long j) {
            return this;
        }

        @Override // com.alibaba.griver.lottie.okio.Timeout
        public final void throwIfReached() throws IOException {
        }

        @Override // com.alibaba.griver.lottie.okio.Timeout
        public final Timeout timeout(long j, TimeUnit timeUnit) {
            return this;
        }
    };

    private static void a(int i, short s, byte b, Object[] objArr) {
        int i2 = 106 - (i * 7);
        byte[] bArr = getAuthRequestContext;
        int i3 = s + 4;
        int i4 = (b * 3) + 13;
        byte[] bArr2 = new byte[i4];
        int i5 = -1;
        int i6 = i4 - 1;
        if (bArr == null) {
            i2 = i3 + i2 + 2;
            i3 = i3;
            i6 = i6;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
        }
        while (true) {
            int i7 = i5 + 1;
            bArr2[i7] = (byte) i2;
            if (i7 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i8 = i3 + 1;
            i2 = i2 + bArr[i8] + 2;
            i3 = i8;
            i6 = i6;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = i7;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long minTimeout(long j, long j2) {
        return j == 0 ? j2 : (j2 != 0 && j >= j2) ? j2 : j;
    }

    public Timeout timeout(long j, TimeUnit timeUnit) {
        if (j >= 0) {
            if (timeUnit == null) {
                throw new IllegalArgumentException("unit == null");
            }
            this.timeoutNanos = timeUnit.toNanos(j);
            return this;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("timeout < 0: ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public long deadlineNanoTime() {
        if (!this.hasDeadline) {
            throw new IllegalStateException("No deadline");
        }
        return this.deadlineNanoTime;
    }

    public Timeout deadlineNanoTime(long j) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j;
        return this;
    }

    public final Timeout deadline(long j, TimeUnit timeUnit) {
        if (j > 0) {
            if (timeUnit == null) {
                throw new IllegalArgumentException("unit == null");
            }
            return deadlineNanoTime(System.nanoTime() + timeUnit.toNanos(j));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("duration <= 0: ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    public Timeout clearTimeout() {
        this.timeoutNanos = 0L;
        return this;
    }

    public Timeout clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public void throwIfReached() throws IOException {
        if (Thread.interrupted()) {
            try {
                Object[] objArr = new Object[1];
                a((byte) (getAuthRequestContext[15] - 1), getAuthRequestContext[22], getAuthRequestContext[15], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b = getAuthRequestContext[15];
                byte b2 = (byte) (-b);
                Object[] objArr2 = new Object[1];
                a(b, b2, (byte) (b2 + 1), objArr2);
                ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
                throw new InterruptedIOException("interrupted");
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        } else if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public final void waitUntilNotified(Object obj) throws InterruptedIOException {
        try {
            try {
                boolean hasDeadline = hasDeadline();
                long timeoutNanos = timeoutNanos();
                long j = 0;
                if (!hasDeadline && timeoutNanos == 0) {
                    obj.wait();
                    return;
                }
                long nanoTime = System.nanoTime();
                if (hasDeadline && timeoutNanos != 0) {
                    timeoutNanos = Math.min(timeoutNanos, deadlineNanoTime() - nanoTime);
                } else if (hasDeadline) {
                    timeoutNanos = deadlineNanoTime() - nanoTime;
                }
                if (timeoutNanos > 0) {
                    long j2 = timeoutNanos / 1000000;
                    Long.signum(j2);
                    obj.wait(j2, (int) (timeoutNanos - (1000000 * j2)));
                    j = System.nanoTime() - nanoTime;
                }
                if (j >= timeoutNanos) {
                    throw new InterruptedIOException(TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT);
                }
            } catch (InterruptedException unused) {
                Object[] objArr = new Object[1];
                a((byte) (getAuthRequestContext[15] - 1), getAuthRequestContext[22], getAuthRequestContext[15], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b = getAuthRequestContext[15];
                byte b2 = (byte) (-b);
                Object[] objArr2 = new Object[1];
                a(b, b2, (byte) (b2 + 1), objArr2);
                ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
                throw new InterruptedIOException("interrupted");
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }
}
