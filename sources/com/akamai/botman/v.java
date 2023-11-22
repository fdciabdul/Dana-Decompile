package com.akamai.botman;

import android.os.SystemClock;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class v implements Observer {
    public int MyBillsEntityDataFactory;
    public int PlaceComponentResult;
    long lookAheadTest;
    Future<Pair<String, Long>> moveToNextValue;
    public static final byte[] scheduleImpl = {83, 16, 71, 115, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int getErrorConfigVersion = 38;
    public long KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    public long getAuthRequestContext = 0;
    String BuiltInFictitiousFunctionClassFactory = "";
    ArrayList<aa> NetworkUserEntityData$$ExternalSyntheticLambda0 = new ArrayList<>();
    private AtomicBoolean NetworkUserEntityData$$ExternalSyntheticLambda2 = new AtomicBoolean(false);

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 3
            int r6 = 16 - r6
            int r8 = r8 * 7
            int r8 = r8 + 99
            int r7 = r7 * 12
            int r7 = 16 - r7
            byte[] r0 = com.akamai.botman.v.scheduleImpl
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r4 = r8
            r3 = 0
            r8 = r7
            r7 = r6
            goto L30
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L30:
            int r8 = r8 + 1
            int r6 = r6 + r4
            int r6 = r6 + 2
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.akamai.botman.v.a(int, byte, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.util.Pair<java.lang.String, java.lang.Long> getAuthRequestContext() {
        /*
            r6 = this;
            java.util.concurrent.Future<android.util.Pair<java.lang.String, java.lang.Long>> r0 = r6.moveToNextValue
            r1 = 0
            java.lang.String r2 = "TouchManager"
            java.lang.String r3 = "Failed to get touch data: "
            if (r0 == 0) goto L3d
            java.lang.Object r0 = r0.get()     // Catch: java.util.concurrent.ExecutionException -> L10 java.lang.InterruptedException -> L27
            android.util.Pair r0 = (android.util.Pair) r0     // Catch: java.util.concurrent.ExecutionException -> L10 java.lang.InterruptedException -> L27
            goto L3e
        L10:
            r0 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r0 = r0.getMessage()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            java.lang.Throwable[] r4 = new java.lang.Throwable[r1]
            com.akamai.botman.ah.MyBillsEntityDataFactory(r2, r0, r4)
            goto L3d
        L27:
            r0 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r0 = r0.getMessage()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            java.lang.Throwable[] r4 = new java.lang.Throwable[r1]
            com.akamai.botman.ah.MyBillsEntityDataFactory(r2, r0, r4)
        L3d:
            r0 = 0
        L3e:
            if (r0 != 0) goto L7f
            android.util.Pair r0 = r6.KClassImpl$Data$declaredNonStaticMembers$2()
            if (r0 != 0) goto L7f
            java.util.concurrent.Future<android.util.Pair<java.lang.String, java.lang.Long>> r4 = r6.moveToNextValue
            if (r4 == 0) goto L7f
            java.lang.Object r4 = r4.get()     // Catch: java.util.concurrent.ExecutionException -> L52 java.lang.InterruptedException -> L69
            android.util.Pair r4 = (android.util.Pair) r4     // Catch: java.util.concurrent.ExecutionException -> L52 java.lang.InterruptedException -> L69
            r0 = r4
            goto L7f
        L52:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r3)
            java.lang.String r3 = r4.getMessage()
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            java.lang.Throwable[] r1 = new java.lang.Throwable[r1]
            com.akamai.botman.ah.MyBillsEntityDataFactory(r2, r3, r1)
            goto L7f
        L69:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r3)
            java.lang.String r3 = r4.getMessage()
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            java.lang.Throwable[] r1 = new java.lang.Throwable[r1]
            com.akamai.botman.ah.MyBillsEntityDataFactory(r2, r3, r1)
        L7f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.akamai.botman.v.getAuthRequestContext():android.util.Pair");
    }

    @Override // java.util.Observer
    public final void update(Observable observable, Object obj) {
        Future<Pair<String, Long>> future;
        try {
            try {
                byte b = (byte) (scheduleImpl[15] - 1);
                Object[] objArr = new Object[1];
                a(b, b, scheduleImpl[15], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b2 = scheduleImpl[15];
                byte b3 = b2;
                Object[] objArr2 = new Object[1];
                a(b2, b3, (byte) (b3 - 1), objArr2);
                Objects.toString(cls.getMethod((String) objArr2[0], null).invoke(null, null));
                if (obj == null || this.NetworkUserEntityData$$ExternalSyntheticLambda2.get()) {
                    return;
                }
                this.getAuthRequestContext++;
                w wVar = (w) obj;
                int pointerCount = wVar.KClassImpl$Data$declaredNonStaticMembers$2.getPointerCount();
                if ((wVar.BuiltInFictitiousFunctionClassFactory != 1 || this.MyBillsEntityDataFactory >= 50) && (wVar.BuiltInFictitiousFunctionClassFactory == 1 || this.PlaceComponentResult >= 50)) {
                    return;
                }
                if (wVar.BuiltInFictitiousFunctionClassFactory == 1) {
                    for (int i = 0; i < pointerCount; i++) {
                        if (this.MyBillsEntityDataFactory < 50) {
                            this.NetworkUserEntityData$$ExternalSyntheticLambda0.add(new aa(wVar.MyBillsEntityDataFactory, wVar.KClassImpl$Data$declaredNonStaticMembers$2.getEventTime() - this.KClassImpl$Data$declaredNonStaticMembers$2, wVar.BuiltInFictitiousFunctionClassFactory, pointerCount, wVar.KClassImpl$Data$declaredNonStaticMembers$2.getY(i), wVar.KClassImpl$Data$declaredNonStaticMembers$2.getX(i), wVar.KClassImpl$Data$declaredNonStaticMembers$2.getToolType(i)));
                            this.MyBillsEntityDataFactory++;
                        }
                    }
                }
                if (wVar.BuiltInFictitiousFunctionClassFactory != 1) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.add(new aa(wVar.MyBillsEntityDataFactory, wVar.KClassImpl$Data$declaredNonStaticMembers$2.getEventTime() - this.KClassImpl$Data$declaredNonStaticMembers$2, wVar.BuiltInFictitiousFunctionClassFactory, pointerCount, wVar.KClassImpl$Data$declaredNonStaticMembers$2.getY(wVar.KClassImpl$Data$declaredNonStaticMembers$2.getActionIndex()), wVar.KClassImpl$Data$declaredNonStaticMembers$2.getX(wVar.KClassImpl$Data$declaredNonStaticMembers$2.getActionIndex()), wVar.KClassImpl$Data$declaredNonStaticMembers$2.getToolType(wVar.KClassImpl$Data$declaredNonStaticMembers$2.getActionIndex())));
                    this.PlaceComponentResult++;
                }
                if (this.MyBillsEntityDataFactory >= 50 && this.PlaceComponentResult >= 50 && ((future = this.moveToNextValue) == null || future.isCancelled() || this.moveToNextValue.isDone())) {
                    ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(1);
                    this.moveToNextValue = newFixedThreadPool.submit(new a());
                    newFixedThreadPool.shutdown();
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2 = wVar.KClassImpl$Data$declaredNonStaticMembers$2.getEventTime();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        } catch (Exception e) {
            ah.MyBillsEntityDataFactory("TouchManager", "Exception in processing touch event", e);
            f.KClassImpl$Data$declaredNonStaticMembers$2(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Pair<String, Long> KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0.size() == 0) {
            return new Pair<>("", 0L);
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.compareAndSet(false, true)) {
            try {
                try {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    Iterator<aa> it = this.NetworkUserEntityData$$ExternalSyntheticLambda0.iterator();
                    while (it.hasNext()) {
                        aa next = it.next();
                        StringBuilder sb = new StringBuilder();
                        sb.append(next.BuiltInFictitiousFunctionClassFactory);
                        sb.append(",");
                        sb.append(next.MyBillsEntityDataFactory);
                        sb.append(",0,0,");
                        sb.append(next.getAuthRequestContext);
                        sb.append(",1,");
                        sb.append(next.KClassImpl$Data$declaredNonStaticMembers$2);
                        sb.append(",-1;");
                        String obj = sb.toString();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(this.BuiltInFictitiousFunctionClassFactory);
                        sb2.append(obj);
                        this.BuiltInFictitiousFunctionClassFactory = sb2.toString();
                        this.lookAheadTest += next.MyBillsEntityDataFactory + next.BuiltInFictitiousFunctionClassFactory;
                    }
                    long uptimeMillis2 = SystemClock.uptimeMillis();
                    StringBuilder sb3 = new StringBuilder("Touch Event Count: ");
                    sb3.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0.size());
                    sb3.append(" (move: ");
                    sb3.append(this.MyBillsEntityDataFactory);
                    sb3.append(", updown: ");
                    sb3.append(this.PlaceComponentResult);
                    sb3.append(")");
                    ah.PlaceComponentResult("TouchManager", sb3.toString(), new Throwable[0]);
                    StringBuilder sb4 = new StringBuilder("Touch SDCalc-Time: ");
                    sb4.append(uptimeMillis2 - uptimeMillis);
                    sb4.append("ms");
                    ah.PlaceComponentResult("TouchManager", sb4.toString(), new Throwable[0]);
                    return new Pair<>(this.BuiltInFictitiousFunctionClassFactory, Long.valueOf(this.lookAheadTest));
                } catch (Exception e) {
                    ah.MyBillsEntityDataFactory("TouchManager", "Exception in getting touch events", e);
                    f.KClassImpl$Data$declaredNonStaticMembers$2(e);
                    this.NetworkUserEntityData$$ExternalSyntheticLambda2.set(false);
                    return new Pair<>("", 0L);
                }
            } finally {
                this.NetworkUserEntityData$$ExternalSyntheticLambda2.set(false);
            }
        }
        return null;
    }

    /* loaded from: classes3.dex */
    final class a implements Callable<Pair<String, Long>> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        public final /* synthetic */ Pair<String, Long> call() throws Exception {
            return v.this.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }
}
