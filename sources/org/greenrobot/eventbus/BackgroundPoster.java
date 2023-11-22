package org.greenrobot.eventbus;

import java.util.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class BackgroundPoster implements Runnable, Poster {
    private final EventBus eventBus;
    private volatile boolean executorRunning;
    private final PendingPostQueue queue = new PendingPostQueue();
    public static final byte[] PlaceComponentResult = {15, -40, -114, -21, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int MyBillsEntityDataFactory = 6;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r7, byte r8, int r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 * 12
            int r9 = r9 + 4
            int r8 = r8 * 3
            int r8 = r8 + 13
            int r7 = r7 * 7
            int r7 = r7 + 99
            byte[] r0 = org.greenrobot.eventbus.BackgroundPoster.PlaceComponentResult
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L34
        L19:
            r3 = 0
            r6 = r9
            r9 = r7
            r7 = r6
        L1d:
            byte r4 = (byte) r9
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r8) goto L2c
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2c:
            r3 = r0[r7]
            r6 = r10
            r10 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L34:
            int r9 = r9 + r7
            int r9 = r9 + 2
            int r7 = r10 + 1
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.eventbus.BackgroundPoster.a(byte, byte, int, java.lang.Object[]):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BackgroundPoster(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override // org.greenrobot.eventbus.Poster
    public final void enqueue(Subscription subscription, Object obj) {
        PendingPost obtainPendingPost = PendingPost.obtainPendingPost(subscription, obj);
        synchronized (this) {
            this.queue.enqueue(obtainPendingPost);
            if (!this.executorRunning) {
                this.executorRunning = true;
                this.eventBus.getExecutorService().execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        while (true) {
            try {
                try {
                    PendingPost poll = this.queue.poll(1000);
                    if (poll == null) {
                        synchronized (this) {
                            poll = this.queue.poll();
                            if (poll == null) {
                                this.executorRunning = false;
                                this.executorRunning = false;
                                return;
                            }
                        }
                    }
                    this.eventBus.invokeSubscriber(poll);
                } catch (InterruptedException e) {
                    Logger logger = this.eventBus.getLogger();
                    Level level = Level.WARNING;
                    StringBuilder sb = new StringBuilder();
                    try {
                        byte b = PlaceComponentResult[15];
                        byte b2 = b;
                        Object[] objArr = new Object[1];
                        a(b, b2, b2, objArr);
                        Class<?> cls = Class.forName((String) objArr[0]);
                        byte b3 = (byte) (PlaceComponentResult[15] - 1);
                        byte b4 = b3;
                        Object[] objArr2 = new Object[1];
                        a(b3, b4, b4, objArr2);
                        sb.append(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName());
                        sb.append(" was interruppted");
                        logger.log(level, sb.toString(), e);
                        this.executorRunning = false;
                        return;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
            } catch (Throwable th2) {
                this.executorRunning = false;
                throw th2;
            }
        }
    }
}
