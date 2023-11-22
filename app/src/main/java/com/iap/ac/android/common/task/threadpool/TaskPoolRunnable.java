package com.iap.ac.android.common.task.threadpool;

import android.os.SystemClock;
import com.iap.ac.android.common.log.ACLog;
import java.util.concurrent.TimeUnit;

/* loaded from: classes8.dex */
public class TaskPoolRunnable implements Runnable {
    public static final String CLASS_NAME = "TaskPoolRunnable";
    public long mEndElapsed;
    public long mEndUptime;
    public String mMethodName;
    public Runnable mRunnable;
    public long mSpendTime;
    public long mStartElapsed;
    public long mStartUptime;
    public long mSubmitElapsed;
    public long mSubmitUptime;
    public TaskType mTaskType;
    public int mThreadPriority;
    public long mWaitTime;
    public static final byte[] MyBillsEntityDataFactory = {112, 91, -28, 61, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int PlaceComponentResult = 92;
    public static final long WAIT_TIME_TO_PRINT = TimeUnit.SECONDS.toMillis(20);
    public static final long WAIT_TIME_TO_DIAGNOSE = TimeUnit.SECONDS.toMillis(60);
    public static final long SPEND_TIME_TO_PRINT = TimeUnit.SECONDS.toMillis(10);
    public static final long SPEND_TIME_TO_DIAGNOSE = TimeUnit.SECONDS.toMillis(30);

    /* loaded from: classes8.dex */
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

    public TaskPoolRunnable(Runnable runnable, TaskType taskType, int i) {
        if (runnable != null) {
            this.mRunnable = runnable;
            this.mTaskType = taskType;
            this.mThreadPriority = i;
            this.mMethodName = runnable.getClass().getName();
            this.mSubmitElapsed = System.currentTimeMillis();
            this.mSubmitUptime = SystemClock.uptimeMillis();
            return;
        }
        throw new IllegalArgumentException("runnable is null");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 12
            int r8 = r8 + 4
            byte[] r0 = com.iap.ac.android.common.task.threadpool.TaskPoolRunnable.MyBillsEntityDataFactory
            int r7 = r7 * 3
            int r7 = 16 - r7
            int r6 = r6 * 7
            int r6 = r6 + 99
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1c
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L36
        L1c:
            r3 = 0
        L1d:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r7) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L36:
            int r9 = r9 + 1
            int r6 = r6 + r7
            int r6 = r6 + 2
            r7 = r8
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.common.task.threadpool.TaskPoolRunnable.a(int, byte, int, java.lang.Object[]):void");
    }

    private void diagnoseOnWaitOrSpendLongTime(boolean z) {
        if (z || this.mTaskType != TaskType.SCHEDULED) {
            TaskPoolDiagnose.waitOrSpendLongTime(z, this.mTaskType, CLASS_NAME, this.mMethodName, this.mWaitTime, this.mSpendTime);
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
        ACLog.w("TaskScheduleService", sb.toString());
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = this.mThreadPriority;
        if (i > 0 && i <= 10) {
            try {
                byte b = MyBillsEntityDataFactory[15];
                Object[] objArr = new Object[1];
                a(b, (byte) (b - 1), MyBillsEntityDataFactory[15], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b2 = (byte) (MyBillsEntityDataFactory[15] - 1);
                byte b3 = MyBillsEntityDataFactory[15];
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
}
