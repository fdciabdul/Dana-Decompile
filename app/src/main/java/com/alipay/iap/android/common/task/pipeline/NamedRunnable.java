package com.alipay.iap.android.common.task.pipeline;

import android.text.TextUtils;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.task.pipeline.Pool;
import com.alipay.iap.android.common.task.pipeline.StandardPipeline;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class NamedRunnable implements Runnable, Pool.Poolable {
    static final String TAG = "AsyncTaskExecutor";
    StandardPipeline.IScheduleNext mScheduleNext;
    Runnable mTask;
    String mThreadName;
    int mWeight;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {TarHeader.LF_DIR, 18, -76, 65, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int MyBillsEntityDataFactory = 239;
    public static final NamedRunnablePool TASK_POOL = new NamedRunnablePool(8, 16);

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 7
            int r7 = r7 + 99
            int r6 = r6 * 3
            int r6 = r6 + 13
            byte[] r0 = com.alipay.iap.android.common.task.pipeline.NamedRunnable.BuiltInFictitiousFunctionClassFactory
            int r8 = r8 + 4
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r4 = r7
            r3 = 0
            r7 = r6
            goto L2e
        L17:
            r3 = 0
        L18:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r8 = r8 + 1
            if (r3 != r6) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r5
        L2e:
            int r6 = r6 + r4
            int r6 = r6 + 2
            r5 = r7
            r7 = r6
            r6 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.common.task.pipeline.NamedRunnable.a(short, short, int, java.lang.Object[]):void");
    }

    /* loaded from: classes3.dex */
    public static final class NamedRunnablePool extends Pool<NamedRunnable> {
        private final AtomicInteger mIndex;

        public NamedRunnablePool(int i, int i2) {
            super(i, i2);
            this.mIndex = new AtomicInteger(1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.alipay.iap.android.common.task.pipeline.Pool
        @Deprecated
        public final NamedRunnable obtain() {
            LoggerWrapper.w("AsyncTaskExecutor", "method is deprecated, call obtain(Runnable, String) method instead.");
            return null;
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
                    LoggerWrapper.i("AsyncTaskExecutor", "NamedRunnablePool.obtain(): create a new NamedRunnable obj.");
                    namedRunnable = newObject(runnable, str, i);
                } else {
                    LoggerWrapper.i("AsyncTaskExecutor", "NamedRunnablePool.obtain(): hit a cache NamedRunnable obj.");
                    NamedRunnable namedRunnable2 = (NamedRunnable) this.freeObjects.pop();
                    namedRunnable2.setTask(runnable);
                    namedRunnable2.setThreadName(str);
                    namedRunnable2.setWeight(i);
                    namedRunnable = namedRunnable2;
                }
            }
            return namedRunnable;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.alipay.iap.android.common.task.pipeline.Pool
        @Deprecated
        public final NamedRunnable newObject() {
            LoggerWrapper.w("AsyncTaskExecutor", "method is deprecated, call newObject(Runnable, String) method instead.");
            return null;
        }

        final NamedRunnable newObject(Runnable runnable, String str, int i) {
            String obj;
            if (TextUtils.isEmpty(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append("NamedRunable_");
                sb.append(this.mIndex.getAndIncrement());
                obj = sb.toString();
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("NamedRunable_");
                sb2.append(this.mIndex.getAndIncrement());
                sb2.append("_");
                sb2.append(str);
                obj = sb2.toString();
            }
            return new NamedRunnable(runnable, obj, i);
        }

        @Override // com.alipay.iap.android.common.task.pipeline.Pool
        public final void free(NamedRunnable namedRunnable) {
            synchronized (this) {
                super.free((NamedRunnablePool) namedRunnable);
            }
        }

        @Override // com.alipay.iap.android.common.task.pipeline.Pool
        public final void freeAll(List<NamedRunnable> list) {
            synchronized (this) {
                super.freeAll(list);
            }
        }

        @Override // com.alipay.iap.android.common.task.pipeline.Pool
        public final void clear() {
            synchronized (this) {
                super.clear();
            }
        }
    }

    NamedRunnable(Runnable runnable, String str, int i) {
        this.mTask = runnable;
        this.mThreadName = str;
        this.mWeight = i;
    }

    void setThreadName(String str) {
        this.mThreadName = str;
    }

    void setTask(Runnable runnable) {
        this.mTask = runnable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NamedRunnable setScheduleNext(StandardPipeline.IScheduleNext iScheduleNext) {
        this.mScheduleNext = iScheduleNext;
        return this;
    }

    void setWeight(int i) {
        this.mWeight = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        if (TextUtils.isEmpty(this.mThreadName)) {
            str = null;
        } else {
            try {
                byte b = BuiltInFictitiousFunctionClassFactory[15];
                Object[] objArr = new Object[1];
                a(b, b, BuiltInFictitiousFunctionClassFactory[22], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b2 = (byte) (BuiltInFictitiousFunctionClassFactory[15] - 1);
                Object[] objArr2 = new Object[1];
                a(b2, b2, (byte) (-BuiltInFictitiousFunctionClassFactory[15]), objArr2);
                String name = ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName();
                StringBuilder sb = new StringBuilder();
                sb.append("NamedRunable.run(set ThreadName to:");
                sb.append(this.mThreadName);
                sb.append(")");
                LoggerWrapper.i("AsyncTaskExecutor", sb.toString());
                try {
                    byte b3 = BuiltInFictitiousFunctionClassFactory[15];
                    Object[] objArr3 = new Object[1];
                    a(b3, b3, BuiltInFictitiousFunctionClassFactory[22], objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    byte b4 = (byte) (BuiltInFictitiousFunctionClassFactory[15] - 1);
                    Object[] objArr4 = new Object[1];
                    a(b4, b4, (byte) (-BuiltInFictitiousFunctionClassFactory[15]), objArr4);
                    Thread thread = (Thread) cls2.getMethod((String) objArr4[0], null).invoke(null, null);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(name);
                    sb2.append("_");
                    sb2.append(this.mThreadName);
                    thread.setName(sb2.toString());
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
        StringBuilder sb3 = new StringBuilder();
        sb3.append("start at ");
        sb3.append(currentTimeMillis);
        LoggerWrapper.v("AsyncTaskExecutor", sb3.toString());
        try {
            this.mTask.run();
            long currentTimeMillis2 = System.currentTimeMillis();
            StringBuilder sb4 = new StringBuilder();
            sb4.append("cost ");
            sb4.append(currentTimeMillis2 - currentTimeMillis);
            sb4.append(" ms");
            LoggerWrapper.i("AsyncTaskExecutor", sb4.toString());
            if (!TextUtils.isEmpty(this.mThreadName)) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("NamedRunable.run(set ThreadName back to:");
                sb5.append(str);
                sb5.append(")");
                LoggerWrapper.i("AsyncTaskExecutor", sb5.toString());
                if (str != null) {
                    try {
                        byte b5 = BuiltInFictitiousFunctionClassFactory[15];
                        Object[] objArr5 = new Object[1];
                        a(b5, b5, BuiltInFictitiousFunctionClassFactory[22], objArr5);
                        Class<?> cls3 = Class.forName((String) objArr5[0]);
                        byte b6 = (byte) (BuiltInFictitiousFunctionClassFactory[15] - 1);
                        Object[] objArr6 = new Object[1];
                        a(b6, b6, (byte) (-BuiltInFictitiousFunctionClassFactory[15]), objArr6);
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
                LoggerWrapper.v("AsyncTaskExecutor", "NamedRunnable.run()->finish(finally:mScheduleNext.scheduleNext())");
                this.mScheduleNext.scheduleNext();
            } else {
                LoggerWrapper.v("AsyncTaskExecutor", "NamedRunnable.run()->finish(finally:null == mScheduleNext)");
            }
            NamedRunnablePool namedRunnablePool = TASK_POOL;
            namedRunnablePool.free(this);
            StringBuilder sb6 = new StringBuilder();
            sb6.append("NamedRunnable.run()->finish(TASK_POOL.free(this)): pool.size=");
            sb6.append(namedRunnablePool.freeObjects.size());
            LoggerWrapper.d("AsyncTaskExecutor", sb6.toString());
        } catch (Throwable th4) {
            long currentTimeMillis3 = System.currentTimeMillis();
            StringBuilder sb7 = new StringBuilder();
            sb7.append("cost ");
            sb7.append(currentTimeMillis3 - currentTimeMillis);
            sb7.append(" ms");
            LoggerWrapper.i("AsyncTaskExecutor", sb7.toString());
            if (!TextUtils.isEmpty(this.mThreadName)) {
                StringBuilder sb8 = new StringBuilder();
                sb8.append("NamedRunable.run(set ThreadName back to:");
                sb8.append(str);
                sb8.append(")");
                LoggerWrapper.i("AsyncTaskExecutor", sb8.toString());
                if (str != null) {
                    try {
                        byte b7 = BuiltInFictitiousFunctionClassFactory[15];
                        Object[] objArr7 = new Object[1];
                        a(b7, b7, BuiltInFictitiousFunctionClassFactory[22], objArr7);
                        Class<?> cls4 = Class.forName((String) objArr7[0]);
                        byte b8 = (byte) (BuiltInFictitiousFunctionClassFactory[15] - 1);
                        Object[] objArr8 = new Object[1];
                        a(b8, b8, (byte) (-BuiltInFictitiousFunctionClassFactory[15]), objArr8);
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
                LoggerWrapper.v("AsyncTaskExecutor", "NamedRunnable.run()->finish(finally:mScheduleNext.scheduleNext())");
                this.mScheduleNext.scheduleNext();
            } else {
                LoggerWrapper.v("AsyncTaskExecutor", "NamedRunnable.run()->finish(finally:null == mScheduleNext)");
            }
            NamedRunnablePool namedRunnablePool2 = TASK_POOL;
            namedRunnablePool2.free(this);
            StringBuilder sb9 = new StringBuilder();
            sb9.append("NamedRunnable.run()->finish(TASK_POOL.free(this)): pool.size=");
            sb9.append(namedRunnablePool2.freeObjects.size());
            LoggerWrapper.d("AsyncTaskExecutor", sb9.toString());
            throw th4;
        }
    }

    @Override // com.alipay.iap.android.common.task.pipeline.Pool.Poolable
    public void reset() {
        this.mTask = null;
        this.mThreadName = null;
        this.mScheduleNext = null;
        this.mWeight = 0;
    }
}
