package okio;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class Timeout {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {1, -107, Ascii.ESC, -41, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 193;
    public static final Timeout NONE = new Timeout() { // from class: okio.Timeout.1
        @Override // okio.Timeout
        public final Timeout deadlineNanoTime(long j) {
            return this;
        }

        @Override // okio.Timeout
        public final void throwIfReached() throws IOException {
        }

        @Override // okio.Timeout
        public final Timeout timeout(long j, TimeUnit timeUnit) {
            return this;
        }
    };
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r5, int r6, short r7, java.lang.Object[] r8) {
        /*
            int r5 = r5 * 3
            int r5 = 16 - r5
            int r7 = r7 * 7
            int r7 = r7 + 99
            int r6 = r6 * 12
            int r6 = r6 + 4
            byte[] r0 = okio.Timeout.BuiltInFictitiousFunctionClassFactory
            byte[] r1 = new byte[r5]
            int r5 = r5 + (-1)
            r2 = 0
            if (r0 != 0) goto L18
            r4 = r6
            r3 = 0
            goto L2a
        L18:
            r3 = 0
        L19:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r5) goto L26
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L26:
            int r3 = r3 + 1
            r4 = r0[r6]
        L2a:
            int r6 = r6 + 1
            int r4 = -r4
            int r7 = r7 + r4
            int r7 = r7 + 2
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Timeout.a(int, int, short, java.lang.Object[]):void");
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
                byte b = (byte) (BuiltInFictitiousFunctionClassFactory[0] - 1);
                byte b2 = BuiltInFictitiousFunctionClassFactory[0];
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = BuiltInFictitiousFunctionClassFactory[0];
                byte b4 = (byte) (b3 - 1);
                Object[] objArr2 = new Object[1];
                a(b3, b4, b4, objArr2);
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
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        } catch (InterruptedException unused) {
            byte b = (byte) (BuiltInFictitiousFunctionClassFactory[0] - 1);
            byte b2 = BuiltInFictitiousFunctionClassFactory[0];
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = BuiltInFictitiousFunctionClassFactory[0];
            byte b4 = (byte) (b3 - 1);
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }
}
