package org.greenrobot.eventbus;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes6.dex */
public class HandlerPoster extends Handler implements Poster {
    private final EventBus eventBus;
    private boolean handlerActive;
    private final int maxMillisInsideHandleMessage;
    private final PendingPostQueue queue;

    public HandlerPoster(EventBus eventBus, Looper looper, int i) {
        super(looper);
        this.eventBus = eventBus;
        this.maxMillisInsideHandleMessage = i;
        this.queue = new PendingPostQueue();
    }

    @Override // org.greenrobot.eventbus.Poster
    public void enqueue(Subscription subscription, Object obj) {
        PendingPost obtainPendingPost = PendingPost.obtainPendingPost(subscription, obj);
        synchronized (this) {
            this.queue.enqueue(obtainPendingPost);
            if (!this.handlerActive) {
                this.handlerActive = true;
                if (!sendMessage(obtainMessage())) {
                    throw new EventBusException("Could not send handler message");
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0019, code lost:
    
        return;
     */
    @Override // android.os.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handleMessage(android.os.Message r8) {
        /*
            r7 = this;
            r8 = 0
            long r0 = android.os.SystemClock.uptimeMillis()     // Catch: java.lang.Throwable -> L44
        L5:
            org.greenrobot.eventbus.PendingPostQueue r2 = r7.queue     // Catch: java.lang.Throwable -> L44
            org.greenrobot.eventbus.PendingPost r2 = r2.poll()     // Catch: java.lang.Throwable -> L44
            if (r2 != 0) goto L1f
            monitor-enter(r7)     // Catch: java.lang.Throwable -> L44
            org.greenrobot.eventbus.PendingPostQueue r2 = r7.queue     // Catch: java.lang.Throwable -> L1c
            org.greenrobot.eventbus.PendingPost r2 = r2.poll()     // Catch: java.lang.Throwable -> L1c
            if (r2 != 0) goto L1a
            monitor-exit(r7)
        L17:
            r7.handlerActive = r8
            return
        L1a:
            monitor-exit(r7)
            goto L1f
        L1c:
            r0 = move-exception
            monitor-exit(r7)
            throw r0     // Catch: java.lang.Throwable -> L44
        L1f:
            org.greenrobot.eventbus.EventBus r3 = r7.eventBus     // Catch: java.lang.Throwable -> L44
            r3.invokeSubscriber(r2)     // Catch: java.lang.Throwable -> L44
            long r2 = android.os.SystemClock.uptimeMillis()     // Catch: java.lang.Throwable -> L44
            long r2 = r2 - r0
            int r4 = r7.maxMillisInsideHandleMessage     // Catch: java.lang.Throwable -> L44
            long r4 = (long) r4     // Catch: java.lang.Throwable -> L44
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 < 0) goto L5
            android.os.Message r0 = r7.obtainMessage()     // Catch: java.lang.Throwable -> L44
            boolean r0 = r7.sendMessage(r0)     // Catch: java.lang.Throwable -> L44
            if (r0 == 0) goto L3c
            r8 = 1
            goto L17
        L3c:
            org.greenrobot.eventbus.EventBusException r0 = new org.greenrobot.eventbus.EventBusException     // Catch: java.lang.Throwable -> L44
            java.lang.String r1 = "Could not send handler message"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L44
            throw r0     // Catch: java.lang.Throwable -> L44
        L44:
            r0 = move-exception
            r7.handlerActive = r8
            goto L49
        L48:
            throw r0
        L49:
            goto L48
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.eventbus.HandlerPoster.handleMessage(android.os.Message):void");
    }
}
