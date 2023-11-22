package com.iap.ac.android.common.task.pipeline;

import android.text.TextUtils;
import com.iap.ac.android.common.a.a;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.task.pipeline.Pool;
import com.iap.ac.android.common.task.pipeline.StandardPipeline;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes8.dex */
public class NamedRunnable implements Runnable, Pool.Poolable {
    public static final String TAG = "AsyncTaskExecutor";
    public StandardPipeline.IScheduleNext mScheduleNext;
    public Runnable mTask;
    public String mThreadName;
    public int mWeight;
    public static final byte[] getAuthRequestContext = {111, 16, 84, -34, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 112;
    public static final NamedRunnablePool TASK_POOL = new NamedRunnablePool(8, 16);

    /* loaded from: classes8.dex */
    public static final class NamedRunnablePool extends Pool<NamedRunnable> {
        public final AtomicInteger mIndex;

        public NamedRunnablePool(int i, int i2) {
            super(i, i2);
            this.mIndex = new AtomicInteger(1);
        }

        @Override // com.iap.ac.android.common.task.pipeline.Pool
        public final void clear() {
            synchronized (this) {
                super.clear();
            }
        }

        @Override // com.iap.ac.android.common.task.pipeline.Pool
        public final void freeAll(List<NamedRunnable> list) {
            synchronized (this) {
                super.freeAll(list);
            }
        }

        @Override // com.iap.ac.android.common.task.pipeline.Pool
        public final void free(NamedRunnable namedRunnable) {
            synchronized (this) {
                super.free((NamedRunnablePool) namedRunnable);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.iap.ac.android.common.task.pipeline.Pool
        @Deprecated
        public final NamedRunnable newObject() {
            ACLog.w("AsyncTaskExecutor", "method is deprecated, call newObject(Runnable, String) method instead.");
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.iap.ac.android.common.task.pipeline.Pool
        @Deprecated
        public final NamedRunnable obtain() {
            ACLog.w("AsyncTaskExecutor", "method is deprecated, call obtain(Runnable, String) method instead.");
            return null;
        }

        public final NamedRunnable newObject(Runnable runnable, String str, int i) {
            String obj;
            if (TextUtils.isEmpty(str)) {
                StringBuilder a2 = a.a("NamedRunable_");
                a2.append(this.mIndex.getAndIncrement());
                obj = a2.toString();
            } else {
                StringBuilder a3 = a.a("NamedRunable_");
                a3.append(this.mIndex.getAndIncrement());
                a3.append("_");
                a3.append(str);
                obj = a3.toString();
            }
            return new NamedRunnable(runnable, obj, i);
        }

        public final NamedRunnable obtain(Runnable runnable, String str) {
            NamedRunnable obtain;
            synchronized (this) {
                obtain = obtain(runnable, str, 0);
            }
            return obtain;
        }

        public final NamedRunnable obtain(Runnable runnable, String str, int i) {
            NamedRunnable namedRunnable;
            synchronized (this) {
                if (this.freeObjects.size() == 0) {
                    ACLog.i("AsyncTaskExecutor", "NamedRunnablePool.obtain(): create a new NamedRunnable obj.");
                    namedRunnable = newObject(runnable, str, i);
                } else {
                    ACLog.i("AsyncTaskExecutor", "NamedRunnablePool.obtain(): hit a cache NamedRunnable obj.");
                    NamedRunnable namedRunnable2 = (NamedRunnable) this.freeObjects.pop();
                    namedRunnable2.setTask(runnable);
                    namedRunnable2.setThreadName(str);
                    namedRunnable2.setWeight(i);
                    namedRunnable = namedRunnable2;
                }
            }
            return namedRunnable;
        }
    }

    public NamedRunnable(Runnable runnable, String str, int i) {
        this.mTask = runnable;
        this.mThreadName = str;
        this.mWeight = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 + 4
            int r7 = r7 * 3
            int r7 = r7 + 13
            int r8 = r8 * 7
            int r8 = r8 + 99
            byte[] r0 = com.iap.ac.android.common.task.pipeline.NamedRunnable.getAuthRequestContext
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r8 = r7
            r3 = r1
            r4 = 0
            r7 = r6
            r1 = r0
            r0 = r9
            r9 = r8
            goto L36
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            int r6 = r6 + 1
            r3 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L36:
            int r8 = r8 + r6
            int r8 = r8 + 2
            r6 = r7
            r7 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.common.task.pipeline.NamedRunnable.a(byte, int, int, java.lang.Object[]):void");
    }

    @Override // com.iap.ac.android.common.task.pipeline.Pool.Poolable
    public void reset() {
        this.mTask = null;
        this.mThreadName = null;
        this.mScheduleNext = null;
        this.mWeight = 0;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        if (TextUtils.isEmpty(this.mThreadName)) {
            str = null;
        } else {
            try {
                byte b = getAuthRequestContext[22];
                byte b2 = getAuthRequestContext[15];
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (-getAuthRequestContext[15]);
                byte b4 = (byte) (b3 + 1);
                Object[] objArr2 = new Object[1];
                a(b3, b4, b4, objArr2);
                String name = ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName();
                StringBuilder a2 = a.a("NamedRunable.run(set ThreadName to:");
                a2.append(this.mThreadName);
                a2.append(")");
                ACLog.i("AsyncTaskExecutor", a2.toString());
                try {
                    byte b5 = getAuthRequestContext[22];
                    byte b6 = getAuthRequestContext[15];
                    Object[] objArr3 = new Object[1];
                    a(b5, b6, b6, objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    byte b7 = (byte) (-getAuthRequestContext[15]);
                    byte b8 = (byte) (b7 + 1);
                    Object[] objArr4 = new Object[1];
                    a(b7, b8, b8, objArr4);
                    Thread thread = (Thread) cls2.getMethod((String) objArr4[0], null).invoke(null, null);
                    StringBuilder sb = new StringBuilder();
                    sb.append(name);
                    sb.append("_");
                    sb.append(this.mThreadName);
                    thread.setName(sb.toString());
                    str = name;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("start at ");
        sb2.append(currentTimeMillis);
        ACLog.v("AsyncTaskExecutor", sb2.toString());
        try {
            this.mTask.run();
            long currentTimeMillis2 = System.currentTimeMillis();
            StringBuilder a3 = a.a("cost ");
            a3.append(currentTimeMillis2 - currentTimeMillis);
            a3.append(" ms");
            ACLog.i("AsyncTaskExecutor", a3.toString());
            if (!TextUtils.isEmpty(this.mThreadName)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("NamedRunable.run(set ThreadName back to:");
                sb3.append(str);
                sb3.append(")");
                ACLog.i("AsyncTaskExecutor", sb3.toString());
                if (str != null) {
                    try {
                        byte b9 = getAuthRequestContext[22];
                        byte b10 = getAuthRequestContext[15];
                        Object[] objArr5 = new Object[1];
                        a(b9, b10, b10, objArr5);
                        Class<?> cls3 = Class.forName((String) objArr5[0]);
                        byte b11 = (byte) (-getAuthRequestContext[15]);
                        byte b12 = (byte) (b11 + 1);
                        Object[] objArr6 = new Object[1];
                        a(b11, b12, b12, objArr6);
                        ((Thread) cls3.getMethod((String) objArr6[0], null).invoke(null, null)).setName(str);
                    } catch (Throwable th3) {
                        Throwable cause3 = th3.getCause();
                        if (cause3 == null) {
                            throw th3;
                        }
                        throw cause3;
                    }
                }
            }
            if (this.mScheduleNext != null) {
                ACLog.v("AsyncTaskExecutor", "NamedRunnable.run()->finish(finally:mScheduleNext.scheduleNext())");
                this.mScheduleNext.scheduleNext();
            } else {
                ACLog.v("AsyncTaskExecutor", "NamedRunnable.run()->finish(finally:null == mScheduleNext)");
            }
            NamedRunnablePool namedRunnablePool = TASK_POOL;
            namedRunnablePool.free(this);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("NamedRunnable.run()->finish(TASK_POOL.free(this)): pool.size=");
            sb4.append(namedRunnablePool.freeObjects.size());
            ACLog.d("AsyncTaskExecutor", sb4.toString());
        } catch (Throwable th4) {
            long currentTimeMillis3 = System.currentTimeMillis();
            StringBuilder a4 = a.a("cost ");
            a4.append(currentTimeMillis3 - currentTimeMillis);
            a4.append(" ms");
            ACLog.i("AsyncTaskExecutor", a4.toString());
            if (!TextUtils.isEmpty(this.mThreadName)) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("NamedRunable.run(set ThreadName back to:");
                sb5.append(str);
                sb5.append(")");
                ACLog.i("AsyncTaskExecutor", sb5.toString());
                if (str != null) {
                    try {
                        byte b13 = getAuthRequestContext[22];
                        byte b14 = getAuthRequestContext[15];
                        Object[] objArr7 = new Object[1];
                        a(b13, b14, b14, objArr7);
                        Class<?> cls4 = Class.forName((String) objArr7[0]);
                        byte b15 = (byte) (-getAuthRequestContext[15]);
                        byte b16 = (byte) (b15 + 1);
                        Object[] objArr8 = new Object[1];
                        a(b15, b16, b16, objArr8);
                        ((Thread) cls4.getMethod((String) objArr8[0], null).invoke(null, null)).setName(str);
                    } catch (Throwable th5) {
                        Throwable cause4 = th5.getCause();
                        if (cause4 == null) {
                            throw th5;
                        }
                        throw cause4;
                    }
                }
            }
            if (this.mScheduleNext != null) {
                ACLog.v("AsyncTaskExecutor", "NamedRunnable.run()->finish(finally:mScheduleNext.scheduleNext())");
                this.mScheduleNext.scheduleNext();
            } else {
                ACLog.v("AsyncTaskExecutor", "NamedRunnable.run()->finish(finally:null == mScheduleNext)");
            }
            NamedRunnablePool namedRunnablePool2 = TASK_POOL;
            namedRunnablePool2.free(this);
            StringBuilder sb6 = new StringBuilder();
            sb6.append("NamedRunnable.run()->finish(TASK_POOL.free(this)): pool.size=");
            sb6.append(namedRunnablePool2.freeObjects.size());
            ACLog.d("AsyncTaskExecutor", sb6.toString());
            throw th4;
        }
    }

    public NamedRunnable setScheduleNext(StandardPipeline.IScheduleNext iScheduleNext) {
        this.mScheduleNext = iScheduleNext;
        return this;
    }

    public void setTask(Runnable runnable) {
        this.mTask = runnable;
    }

    public void setThreadName(String str) {
        this.mThreadName = str;
    }

    public void setWeight(int i) {
        this.mWeight = i;
    }
}
