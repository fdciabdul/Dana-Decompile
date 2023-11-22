package io.split.android.client.service.executor;

import android.os.Handler;
import android.os.Looper;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import io.split.android.client.utils.logger.Logger;
import io.split.android.engine.scheduler.PausableScheduledThreadPoolExecutor;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public abstract class SplitBaseTaskExecutor implements SplitTaskExecutor {
    private static final int SHUTDOWN_WAIT_TIME = 15;
    private Handler mMainHandler;
    public static final byte[] getAuthRequestContext = {Ascii.EM, 108, 7, 61, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int PlaceComponentResult = 28;
    private final PausableScheduledThreadPoolExecutor mScheduler = buildScheduler();
    private final Map<String, ScheduledFuture> mScheduledTasks = new ConcurrentHashMap();

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x003b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r7, short r8, short r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 * 3
            int r9 = r9 + 13
            int r8 = r8 * 12
            int r8 = r8 + 4
            byte[] r0 = io.split.android.client.service.executor.SplitBaseTaskExecutor.getAuthRequestContext
            int r7 = r7 * 7
            int r7 = 106 - r7
            byte[] r1 = new byte[r9]
            int r9 = r9 + (-1)
            r2 = 0
            if (r0 != 0) goto L1c
            r7 = r8
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L3b
        L1c:
            r3 = 0
        L1d:
            r5 = r8
            r8 = r7
            r7 = r5
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r9) goto L2d
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2d:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r5
            r6 = r10
            r10 = r9
            r9 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L3b:
            int r8 = r8 + 1
            int r7 = r7 + r9
            int r7 = r7 + 2
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: io.split.android.client.service.executor.SplitBaseTaskExecutor.a(int, short, short, java.lang.Object[]):void");
    }

    protected abstract PausableScheduledThreadPoolExecutor buildScheduler();

    @Override // io.split.android.client.service.executor.SplitTaskExecutor
    public String schedule(SplitTask splitTask, long j, long j2, SplitTaskExecutionListener splitTaskExecutionListener) {
        Preconditions.checkNotNull(splitTask);
        Preconditions.checkArgument(j2 > 0);
        if (this.mScheduler.isShutdown()) {
            return null;
        }
        ScheduledFuture<?> scheduleAtFixedRate = this.mScheduler.scheduleAtFixedRate(new TaskWrapper(splitTask, splitTaskExecutionListener), j, j2, TimeUnit.SECONDS);
        String obj = UUID.randomUUID().toString();
        this.mScheduledTasks.put(obj, scheduleAtFixedRate);
        return obj;
    }

    @Override // io.split.android.client.service.executor.SplitTaskExecutor
    public String schedule(SplitTask splitTask, long j, SplitTaskExecutionListener splitTaskExecutionListener) {
        Preconditions.checkNotNull(splitTask);
        if (this.mScheduler.isShutdown()) {
            return null;
        }
        ScheduledFuture<?> schedule = this.mScheduler.schedule(new TaskWrapper(splitTask, splitTaskExecutionListener), j, TimeUnit.SECONDS);
        String obj = UUID.randomUUID().toString();
        this.mScheduledTasks.put(obj, schedule);
        return obj;
    }

    @Override // io.split.android.client.service.executor.SplitTaskExecutor
    public void submit(SplitTask splitTask, SplitTaskExecutionListener splitTaskExecutionListener) {
        Preconditions.checkNotNull(splitTask);
        if (this.mScheduler.isShutdown()) {
            return;
        }
        this.mScheduler.submit(new TaskWrapper(splitTask, splitTaskExecutionListener));
    }

    @Override // io.split.android.client.service.executor.SplitTaskExecutor
    public void stopTask(String str) {
        if (str == null) {
            return;
        }
        ScheduledFuture scheduledFuture = this.mScheduledTasks.get(str);
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.mScheduledTasks.remove(str);
    }

    @Override // io.split.android.client.service.executor.SplitTaskExecutor
    public void executeSerially(List<SplitTaskBatchItem> list) {
        if (this.mScheduler.isShutdown()) {
            return;
        }
        this.mScheduler.submit(new SplitTaskBatchWrapper(list));
    }

    public void submitOnMainThread(Handler handler, final SplitTask splitTask) {
        if (this.mScheduler.isShutdown()) {
            return;
        }
        handler.post(new Runnable() { // from class: io.split.android.client.service.executor.SplitBaseTaskExecutor.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    splitTask.execute();
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Error executing task on main thread: ");
                    sb.append(e.getLocalizedMessage());
                    Logger.e(sb.toString());
                }
            }
        });
    }

    @Override // io.split.android.client.service.executor.SplitTaskExecutor
    public void submitOnMainThread(SplitTask splitTask) {
        submitOnMainThread(getMainHandler(), splitTask);
    }

    @Override // io.split.android.client.service.executor.SplitTaskExecutor
    public void pause() {
        this.mScheduler.PlaceComponentResult();
    }

    @Override // io.split.android.client.service.executor.SplitTaskExecutor
    public void resume() {
        this.mScheduler.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // io.split.android.client.service.executor.SplitTaskExecutor
    public void stop() {
        if (this.mScheduler.isShutdown()) {
            return;
        }
        this.mScheduler.shutdown();
        try {
            if (this.mScheduler.awaitTermination(15L, TimeUnit.SECONDS)) {
                return;
            }
            this.mScheduler.shutdownNow();
            if (this.mScheduler.awaitTermination(15L, TimeUnit.SECONDS)) {
                return;
            }
            Logger.e("Split task executor did not terminate");
        } catch (InterruptedException unused) {
            this.mScheduler.shutdownNow();
            try {
                byte b = (byte) (getAuthRequestContext[15] - 1);
                byte b2 = getAuthRequestContext[15];
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = getAuthRequestContext[15];
                byte b4 = (byte) (b3 - 1);
                Object[] objArr2 = new Object[1];
                a(b3, b4, b4, objArr2);
                ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
    }

    private Handler getMainHandler() {
        if (this.mMainHandler == null) {
            this.mMainHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainHandler;
    }
}
