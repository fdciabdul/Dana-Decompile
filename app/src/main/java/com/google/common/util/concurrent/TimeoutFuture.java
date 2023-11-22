package com.google.common.util.concurrent;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FluentFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public final class TimeoutFuture<V> extends FluentFuture.TrustedFuture<V> {
    @CheckForNull
    private ListenableFuture<V> delegateRef;
    @CheckForNull
    private ScheduledFuture<?> timer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> ListenableFuture<V> create(ListenableFuture<V> listenableFuture, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        TimeoutFuture timeoutFuture = new TimeoutFuture(listenableFuture);
        Fire fire = new Fire(timeoutFuture);
        timeoutFuture.timer = scheduledExecutorService.schedule(fire, j, timeUnit);
        listenableFuture.addListener(fire, MoreExecutors.directExecutor());
        return timeoutFuture;
    }

    private TimeoutFuture(ListenableFuture<V> listenableFuture) {
        this.delegateRef = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class Fire<V> implements Runnable {
        @CheckForNull
        TimeoutFuture<V> timeoutFutureRef;

        Fire(TimeoutFuture<V> timeoutFuture) {
            this.timeoutFutureRef = timeoutFuture;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ListenableFuture<? extends V> listenableFuture;
            TimeoutFuture<V> timeoutFuture = this.timeoutFutureRef;
            if (timeoutFuture == null || (listenableFuture = ((TimeoutFuture) timeoutFuture).delegateRef) == null) {
                return;
            }
            this.timeoutFutureRef = null;
            if (!listenableFuture.isDone()) {
                try {
                    ScheduledFuture scheduledFuture = ((TimeoutFuture) timeoutFuture).timer;
                    ((TimeoutFuture) timeoutFuture).timer = null;
                    String str = "Timed out";
                    if (scheduledFuture != null) {
                        try {
                            long abs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                            if (abs > 10) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Timed out");
                                sb.append(" (timeout delayed by ");
                                sb.append(abs);
                                sb.append(" ms after scheduled time)");
                                str = sb.toString();
                            }
                        } catch (Throwable th) {
                            timeoutFuture.setException(new TimeoutFutureException(str));
                            throw th;
                        }
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(": ");
                    sb2.append(listenableFuture);
                    timeoutFuture.setException(new TimeoutFutureException(sb2.toString()));
                    return;
                } finally {
                    listenableFuture.cancel(true);
                }
            }
            timeoutFuture.setFuture(listenableFuture);
        }
    }

    /* loaded from: classes7.dex */
    static final class TimeoutFutureException extends TimeoutException {
        public static final byte[] PlaceComponentResult = {121, 107, -47, -24, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -31, Ascii.NAK, 0, -6, Ascii.EM, -28, 19, 0, 0, 34, -37, 9, -6, 10, -7, -4};
        public static final int getAuthRequestContext = 10;

        private TimeoutFutureException(String str) {
            super(str);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0033 A[Catch: all -> 0x0062, TRY_LEAVE, TryCatch #0 {all -> 0x0062, blocks: (B:9:0x002d, B:11:0x0033, B:15:0x0049), top: B:26:0x002d }] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004b -> B:17:0x0055). Please submit an issue!!! */
        @Override // java.lang.Throwable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Throwable fillInStackTrace() {
            /*
                r11 = this;
                monitor-enter(r11)
                byte[] r0 = com.google.common.util.concurrent.TimeoutFuture.TimeoutFutureException.PlaceComponentResult     // Catch: java.lang.Throwable -> L64
                r1 = 16
                r0 = r0[r1]     // Catch: java.lang.Throwable -> L64
                byte r0 = (byte) r0     // Catch: java.lang.Throwable -> L64
                int r2 = r0 + (-1)
                byte r2 = (byte) r2     // Catch: java.lang.Throwable -> L64
                byte[] r3 = com.google.common.util.concurrent.TimeoutFuture.TimeoutFutureException.PlaceComponentResult     // Catch: java.lang.Throwable -> L64
                r1 = r3[r1]     // Catch: java.lang.Throwable -> L64
                byte r1 = (byte) r1     // Catch: java.lang.Throwable -> L64
                int r0 = r0 * 3
                int r0 = 106 - r0
                byte[] r3 = com.google.common.util.concurrent.TimeoutFuture.TimeoutFutureException.PlaceComponentResult     // Catch: java.lang.Throwable -> L64
                int r2 = r2 + 4
                int r1 = r1 * 3
                int r1 = r1 + 27
                byte[] r4 = new byte[r1]     // Catch: java.lang.Throwable -> L64
                int r1 = r1 + (-1)
                r5 = 0
                if (r3 != 0) goto L2a
                r8 = r11
                r0 = r1
                r6 = r4
                r7 = 0
                r4 = r3
                r3 = r2
                goto L55
            L2a:
                r7 = r11
                r6 = 0
            L2c:
                byte r8 = (byte) r0
                r4[r6] = r8     // Catch: java.lang.Throwable -> L62
                int r2 = r2 + 1
                if (r6 != r1) goto L47
                java.lang.String r0 = new java.lang.String     // Catch: java.lang.Throwable -> L62
                r0.<init>(r4, r5)     // Catch: java.lang.Throwable -> L62
                java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Throwable -> L62
                java.lang.Object r0 = java.lang.reflect.Array.newInstance(r0, r5)     // Catch: java.lang.Throwable -> L62
                java.lang.StackTraceElement[] r0 = (java.lang.StackTraceElement[]) r0     // Catch: java.lang.Throwable -> L62
                r7.setStackTrace(r0)     // Catch: java.lang.Throwable -> L62
                monitor-exit(r7)
                return r7
            L47:
                int r6 = r6 + 1
                r8 = r3[r2]     // Catch: java.lang.Throwable -> L62
                r9 = r1
                r1 = r0
                r0 = r9
                r10 = r3
                r3 = r2
                r2 = r8
                r8 = r7
                r7 = r6
                r6 = r4
                r4 = r10
            L55:
                int r2 = -r2
                int r1 = r1 + r2
                int r1 = r1 + 2
                r2 = r3
                r3 = r4
                r4 = r6
                r6 = r7
                r7 = r8
                r9 = r1
                r1 = r0
                r0 = r9
                goto L2c
            L62:
                r0 = move-exception
                goto L66
            L64:
                r0 = move-exception
                r7 = r11
            L66:
                monitor-exit(r7)
                goto L69
            L68:
                throw r0
            L69:
                goto L68
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.TimeoutFuture.TimeoutFutureException.fillInStackTrace():java.lang.Throwable");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    @CheckForNull
    public final String pendingToString() {
        ListenableFuture<V> listenableFuture = this.delegateRef;
        ScheduledFuture<?> scheduledFuture = this.timer;
        if (listenableFuture != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("inputFuture=[");
            sb.append(listenableFuture);
            sb.append("]");
            String obj = sb.toString();
            if (scheduledFuture != null) {
                long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
                if (delay > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(obj);
                    sb2.append(", remaining delay=[");
                    sb2.append(delay);
                    sb2.append(" ms]");
                    return sb2.toString();
                }
                return obj;
            }
            return obj;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        maybePropagateCancellationTo(this.delegateRef);
        ScheduledFuture<?> scheduledFuture = this.timer;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.delegateRef = null;
        this.timer = null;
    }
}
