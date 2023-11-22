package com.otaliastudios.cameraview.internal.utils;

import android.os.Handler;
import android.os.HandlerThread;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.common.base.Ascii;
import com.otaliastudios.cameraview.CameraLogger;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* loaded from: classes8.dex */
public class WorkerHandler {
    private static WorkerHandler moveToNextValue;
    public Handler BuiltInFictitiousFunctionClassFactory;
    public HandlerThread MyBillsEntityDataFactory;
    public Executor getAuthRequestContext;
    private String lookAheadTest;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {84, -107, -124, 66, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int PlaceComponentResult = 72;
    private static final CameraLogger NetworkUserEntityData$$ExternalSyntheticLambda0 = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("WorkerHandler");
    private static final ConcurrentHashMap<String, WeakReference<WorkerHandler>> scheduleImpl = new ConcurrentHashMap<>(4);

    /* JADX WARN: Removed duplicated region for block: B:20:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002c -> B:23:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.otaliastudios.cameraview.internal.utils.WorkerHandler.KClassImpl$Data$declaredNonStaticMembers$2
            int r7 = r7 * 3
            int r7 = r7 + 13
            int r6 = r6 * 7
            int r6 = 106 - r6
            int r8 = r8 * 12
            int r8 = 16 - r8
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
            int r4 = r3 + 1
            if (r3 != r7) goto L2c
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2c:
            r3 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L36:
            int r6 = -r6
            int r7 = r7 + r6
            int r6 = r9 + 1
            int r7 = r7 + 2
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.internal.utils.WorkerHandler.a(byte, byte, short, java.lang.Object[]):void");
    }

    public static WorkerHandler BuiltInFictitiousFunctionClassFactory(String str) {
        ConcurrentHashMap<String, WeakReference<WorkerHandler>> concurrentHashMap = scheduleImpl;
        if (concurrentHashMap.containsKey(str)) {
            WorkerHandler workerHandler = concurrentHashMap.get(str).get();
            if (workerHandler != null) {
                if (!workerHandler.MyBillsEntityDataFactory.isAlive() || workerHandler.MyBillsEntityDataFactory.isInterrupted()) {
                    workerHandler.MyBillsEntityDataFactory();
                    NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2(2, "get:", "Thread reference found, but not alive or interrupted.", "Removing.", str);
                    concurrentHashMap.remove(str);
                } else {
                    NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2(2, "get:", "Reusing cached worker handler.", str);
                    return workerHandler;
                }
            } else {
                NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2(2, "get:", "Thread reference died. Removing.", str);
                concurrentHashMap.remove(str);
            }
        }
        NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2(1, "get:", "Creating new handler.", str);
        WorkerHandler workerHandler2 = new WorkerHandler(str);
        concurrentHashMap.put(str, new WeakReference<>(workerHandler2));
        return workerHandler2;
    }

    public static WorkerHandler PlaceComponentResult() {
        WorkerHandler BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory("FallbackCameraThread");
        moveToNextValue = BuiltInFictitiousFunctionClassFactory;
        return BuiltInFictitiousFunctionClassFactory;
    }

    private WorkerHandler(String str) {
        this.lookAheadTest = str;
        HandlerThread handlerThread = new HandlerThread(str) { // from class: com.otaliastudios.cameraview.internal.utils.WorkerHandler.1
            {
                WorkerHandler.this = this;
            }

            @Override // java.lang.Thread
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append(super.toString());
                sb.append("[");
                sb.append(getThreadId());
                sb.append("]");
                return sb.toString();
            }
        };
        this.MyBillsEntityDataFactory = handlerThread;
        handlerThread.setDaemon(true);
        this.MyBillsEntityDataFactory.start();
        this.BuiltInFictitiousFunctionClassFactory = new Handler(this.MyBillsEntityDataFactory.getLooper());
        this.getAuthRequestContext = new Executor() { // from class: com.otaliastudios.cameraview.internal.utils.WorkerHandler.2
            {
                WorkerHandler.this = this;
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                WorkerHandler.this.MyBillsEntityDataFactory(runnable);
            }
        };
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.BuiltInFictitiousFunctionClassFactory.post(new Runnable() { // from class: com.otaliastudios.cameraview.internal.utils.WorkerHandler.3
            {
                WorkerHandler.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
    }

    public final void MyBillsEntityDataFactory(Runnable runnable) {
        try {
            byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] + 1);
            byte b2 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
            Object[] objArr = new Object[1];
            a(b, b2, (byte) (b2 - 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
            Object[] objArr2 = new Object[1];
            a(b3, (byte) (b3 - 1), (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]), objArr2);
            if (cls.getMethod((String) objArr2[0], null).invoke(null, null) == this.MyBillsEntityDataFactory) {
                runnable.run();
            } else {
                this.BuiltInFictitiousFunctionClassFactory.post(runnable);
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    /* renamed from: com.otaliastudios.cameraview.internal.utils.WorkerHandler$4 */
    /* loaded from: classes8.dex */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ TaskCompletionSource KClassImpl$Data$declaredNonStaticMembers$2;
        final /* synthetic */ Callable MyBillsEntityDataFactory;

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.KClassImpl$Data$declaredNonStaticMembers$2.trySetResult(this.MyBillsEntityDataFactory.call());
            } catch (Exception e) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.trySetException(e);
            }
        }
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Runnable runnable) {
        WorkerHandler BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory("FallbackCameraThread");
        moveToNextValue = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.post(runnable);
    }

    public final void MyBillsEntityDataFactory() {
        HandlerThread handlerThread = this.MyBillsEntityDataFactory;
        if (handlerThread.isAlive()) {
            handlerThread.interrupt();
            handlerThread.quit();
        }
        scheduleImpl.remove(this.lookAheadTest);
    }
}
