package com.alipay.iap.android.common.task.threadpool;

import android.os.SystemClock;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.google.common.base.Ascii;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public class TaskPoolRunnable implements Runnable {
    private static final String CLASS_NAME = "TaskPoolRunnable";
    private long mEndElapsed;
    private long mEndUptime;
    private String mMethodName;
    private Runnable mRunnable;
    private long mSpendTime;
    private long mStartElapsed;
    private long mStartUptime;
    private long mSubmitElapsed;
    private long mSubmitUptime;
    private TaskType mTaskType;
    private int mThreadPriority;
    private long mWaitTime;
    public static final byte[] PlaceComponentResult = {83, -75, 7, 97, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int BuiltInFictitiousFunctionClassFactory = 246;
    private static final long WAIT_TIME_TO_PRINT = TimeUnit.SECONDS.toMillis(20);
    private static final long WAIT_TIME_TO_DIAGNOSE = TimeUnit.SECONDS.toMillis(60);
    private static final long SPEND_TIME_TO_PRINT = TimeUnit.SECONDS.toMillis(10);
    private static final long SPEND_TIME_TO_DIAGNOSE = TimeUnit.SECONDS.toMillis(30);

    /* loaded from: classes6.dex */
    public enum TaskType {
        UNKNOWN,
        URGENT_DISPLAY,
        URGENT,
        NORMAL,
        IO,
        RPC,
        MMS_HTTP,
        MMS_DJANGO,
        ORDERED,
        SCHEDULED
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.alipay.iap.android.common.task.threadpool.TaskPoolRunnable.PlaceComponentResult
            int r8 = r8 * 7
            int r8 = r8 + 99
            int r7 = r7 * 3
            int r7 = 16 - r7
            int r6 = r6 * 12
            int r6 = r6 + 4
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r8 = r7
            r4 = r8
            r3 = 0
            r7 = r6
            goto L30
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            r4 = r0[r6]
            int r3 = r3 + 1
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L30:
            int r4 = -r4
            int r6 = r6 + r4
            int r7 = r7 + 1
            int r6 = r6 + 2
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.common.task.threadpool.TaskPoolRunnable.a(int, short, byte, java.lang.Object[]):void");
    }

    public TaskPoolRunnable(Runnable runnable, TaskType taskType, int i) {
        if (runnable == null) {
            throw new IllegalArgumentException("runnable is null");
        }
        this.mRunnable = runnable;
        this.mTaskType = taskType;
        this.mThreadPriority = i;
        this.mMethodName = runnable.getClass().getName();
        this.mSubmitElapsed = System.currentTimeMillis();
        this.mSubmitUptime = SystemClock.uptimeMillis();
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = this.mThreadPriority;
        if (i > 0 && i <= 10) {
            try {
                byte b = (byte) (-PlaceComponentResult[15]);
                Object[] objArr = new Object[1];
                a(b, (byte) (b - 1), (byte) (-PlaceComponentResult[15]), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b2 = (byte) (PlaceComponentResult[15] + 1);
                byte b3 = (byte) (-PlaceComponentResult[15]);
                Object[] objArr2 = new Object[1];
                a(b2, b3, (byte) (b3 - 1), objArr2);
                ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).setPriority(this.mThreadPriority);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        this.mStartUptime = SystemClock.uptimeMillis();
        this.mStartElapsed = System.currentTimeMillis();
        long j = this.mStartUptime - this.mSubmitUptime;
        this.mWaitTime = j;
        if (j > WAIT_TIME_TO_PRINT) {
            printOnWaitOrSpendLongTime(false);
            if (this.mWaitTime > WAIT_TIME_TO_DIAGNOSE) {
                diagnoseOnWaitOrSpendLongTime(false);
            }
        }
        try {
            this.mRunnable.run();
        } finally {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.mEndUptime = uptimeMillis;
            long j2 = uptimeMillis - this.mStartUptime;
            this.mSpendTime = j2;
            if (j2 > SPEND_TIME_TO_PRINT) {
                printOnWaitOrSpendLongTime(true);
                if (this.mSpendTime > SPEND_TIME_TO_DIAGNOSE) {
                    diagnoseOnWaitOrSpendLongTime(true);
                }
            }
        }
    }

    private void printOnWaitOrSpendLongTime(boolean z) {
        String str;
        if (z) {
            this.mEndElapsed = System.currentTimeMillis();
            str = "spendLongTime ";
        } else if (this.mTaskType == TaskType.SCHEDULED) {
            return;
        } else {
            str = "waitLongTime ";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(this.mMethodName);
        sb.append(", scheduleType: ");
        sb.append(this.mTaskType);
        sb.append(", spendTime: ");
        sb.append(this.mSpendTime);
        sb.append(", waitTime: ");
        sb.append(this.mWaitTime);
        sb.append(", submitTime: ");
        sb.append(this.mSubmitElapsed);
        sb.append(", startTime: ");
        sb.append(this.mStartElapsed);
        sb.append(", endTime: ");
        sb.append(this.mEndElapsed);
        LoggerWrapper.w("TaskScheduleService", sb.toString());
    }

    private void diagnoseOnWaitOrSpendLongTime(boolean z) {
        if (z || this.mTaskType != TaskType.SCHEDULED) {
            TaskPoolDiagnose.waitOrSpendLongTime(z, this.mTaskType, "TaskPoolRunnable", this.mMethodName, this.mWaitTime, this.mSpendTime);
        }
    }
}
