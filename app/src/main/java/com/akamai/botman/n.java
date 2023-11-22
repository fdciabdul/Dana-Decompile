package com.akamai.botman;

import android.app.Application;
import android.hardware.SensorManager;
import android.os.SystemClock;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class n implements Observer {
    long BuiltInFictitiousFunctionClassFactory;
    m KClassImpl$Data$declaredNonStaticMembers$2;
    Future<ai<Pair<String, String>, Long, Long>> MyBillsEntityDataFactory;
    boolean getAuthRequestContext;
    public ArrayList<l> PlaceComponentResult = new ArrayList<>();
    private AtomicBoolean scheduleImpl = new AtomicBoolean(false);

    public n(Application application) {
        ah.PlaceComponentResult("OrientationManager", "Initializing orientation manager", new Throwable[0]);
        this.BuiltInFictitiousFunctionClassFactory = SystemClock.uptimeMillis();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new m(application);
    }

    public final void BuiltInFictitiousFunctionClassFactory() throws Exception {
        if (this.PlaceComponentResult.size() < 128 && !this.scheduleImpl.get()) {
            if (!this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext()) {
                ah.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(6, "Orientation listener registration failed", new Throwable[0]);
                return;
            }
            this.getAuthRequestContext = true;
            this.KClassImpl$Data$declaredNonStaticMembers$2.addObserver(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.akamai.botman.ai<android.util.Pair<java.lang.String, java.lang.String>, java.lang.Long, java.lang.Long> getAuthRequestContext() throws java.lang.Exception {
        /*
            r6 = this;
            java.util.concurrent.Future<com.akamai.botman.ai<android.util.Pair<java.lang.String, java.lang.String>, java.lang.Long, java.lang.Long>> r0 = r6.MyBillsEntityDataFactory
            r1 = 0
            java.lang.String r2 = "OrientationManager"
            java.lang.String r3 = "Failed to get orientation data: "
            if (r0 == 0) goto L3d
            java.lang.Object r0 = r0.get()     // Catch: java.util.concurrent.ExecutionException -> L10 java.lang.InterruptedException -> L27
            com.akamai.botman.ai r0 = (com.akamai.botman.ai) r0     // Catch: java.util.concurrent.ExecutionException -> L10 java.lang.InterruptedException -> L27
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
            if (r0 != 0) goto L89
            com.akamai.botman.m r0 = r6.KClassImpl$Data$declaredNonStaticMembers$2
            r0.PlaceComponentResult()
            com.akamai.botman.m r0 = r6.KClassImpl$Data$declaredNonStaticMembers$2
            r0.deleteObservers()
            com.akamai.botman.ai r0 = r6.MyBillsEntityDataFactory()
            if (r0 != 0) goto L89
            java.util.concurrent.Future<com.akamai.botman.ai<android.util.Pair<java.lang.String, java.lang.String>, java.lang.Long, java.lang.Long>> r4 = r6.MyBillsEntityDataFactory
            if (r4 == 0) goto L89
            java.lang.Object r4 = r4.get()     // Catch: java.util.concurrent.ExecutionException -> L5c java.lang.InterruptedException -> L73
            com.akamai.botman.ai r4 = (com.akamai.botman.ai) r4     // Catch: java.util.concurrent.ExecutionException -> L5c java.lang.InterruptedException -> L73
            r0 = r4
            goto L89
        L5c:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r3)
            java.lang.String r3 = r4.getMessage()
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            java.lang.Throwable[] r1 = new java.lang.Throwable[r1]
            com.akamai.botman.ah.MyBillsEntityDataFactory(r2, r3, r1)
            goto L89
        L73:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r3)
            java.lang.String r3 = r4.getMessage()
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            java.lang.Throwable[] r1 = new java.lang.Throwable[r1]
            com.akamai.botman.ah.MyBillsEntityDataFactory(r2, r3, r1)
        L89:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.akamai.botman.n.getAuthRequestContext():com.akamai.botman.ai");
    }

    @Override // java.util.Observer
    public final void update(Observable observable, Object obj) {
        if (obj == null) {
            return;
        }
        try {
            if (this.PlaceComponentResult.size() < 128) {
                this.PlaceComponentResult.add((l) obj);
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult();
            this.KClassImpl$Data$declaredNonStaticMembers$2.deleteObservers();
            Future<ai<Pair<String, String>, Long, Long>> future = this.MyBillsEntityDataFactory;
            if (future == null || future.isCancelled() || this.MyBillsEntityDataFactory.isDone()) {
                ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(1);
                this.MyBillsEntityDataFactory = newFixedThreadPool.submit(new a());
                newFixedThreadPool.shutdown();
            }
        } catch (Exception e) {
            ah.MyBillsEntityDataFactory("OrientationManager", "Exception in processing orientation event", e);
            f.KClassImpl$Data$declaredNonStaticMembers$2(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ai<Pair<String, String>, Long, Long> MyBillsEntityDataFactory() {
        Long l;
        String str;
        long j;
        float[] fArr;
        Long l2 = 0L;
        String str2 = "";
        if (this.PlaceComponentResult.size() <= 1) {
            return new ai<>(new Pair("", ""), l2, l2);
        }
        if (!this.scheduleImpl.compareAndSet(false, true)) {
            return null;
        }
        try {
            try {
                long uptimeMillis = SystemClock.uptimeMillis();
                int PlaceComponentResult = (int) ag.PlaceComponentResult(this.PlaceComponentResult.size());
                float[] fArr2 = new float[PlaceComponentResult];
                float[] fArr3 = new float[PlaceComponentResult];
                float[] fArr4 = new float[PlaceComponentResult];
                float[] fArr5 = new float[PlaceComponentResult];
                long j2 = this.BuiltInFictitiousFunctionClassFactory;
                Iterator<l> it = this.PlaceComponentResult.iterator();
                int i = 0;
                while (true) {
                    if (!it.hasNext()) {
                        l = l2;
                        str = str2;
                        j = uptimeMillis;
                        break;
                    }
                    l next = it.next();
                    Iterator<l> it2 = it;
                    l = l2;
                    try {
                        fArr = new float[9];
                        str = str2;
                    } catch (Exception e) {
                        e = e;
                        str = str2;
                        ah.MyBillsEntityDataFactory("OrientationManager", "Exception in getting orientation events", e);
                        f.KClassImpl$Data$declaredNonStaticMembers$2(e);
                        this.scheduleImpl.set(false);
                        String str3 = str;
                        Pair pair = new Pair(str3, str3);
                        Long l3 = l;
                        return new ai<>(pair, l3, l3);
                    }
                    try {
                        j = uptimeMillis;
                        if (SensorManager.getRotationMatrix(fArr, new float[9], next.PlaceComponentResult, next.BuiltInFictitiousFunctionClassFactory)) {
                            SensorManager.getOrientation(fArr, new float[3]);
                            float degrees = (float) Math.toDegrees(r7[0]);
                            float degrees2 = (float) Math.toDegrees(r7[1]);
                            float degrees3 = (float) Math.toDegrees(r7[2]);
                            float f = degrees * (-1.0f);
                            if (f < 0.0f) {
                                f += 360.0f;
                            }
                            fArr2[i] = f;
                            fArr3[i] = degrees2 * (-1.0f);
                            fArr4[i] = degrees3;
                            fArr5[i] = (float) Math.max(0L, next.getAuthRequestContext - j2);
                            SystemClock.uptimeMillis();
                            long j3 = next.getAuthRequestContext;
                            float f2 = fArr2[i];
                            float f3 = fArr3[i];
                            float f4 = fArr4[i];
                        } else {
                            fArr2[i] = 0.0f;
                            fArr3[i] = 0.0f;
                            fArr4[i] = 0.0f;
                            ah.MyBillsEntityDataFactory("OrientationManager", "Failed to get rotation matrix", new Throwable[0]);
                        }
                        long j4 = next.getAuthRequestContext;
                        int i2 = i + 1;
                        if (i2 >= PlaceComponentResult) {
                            break;
                        }
                        j2 = j4;
                        i = i2;
                        it = it2;
                        l2 = l;
                        str2 = str;
                        uptimeMillis = j;
                    } catch (Exception e2) {
                        e = e2;
                        ah.MyBillsEntityDataFactory("OrientationManager", "Exception in getting orientation events", e);
                        f.KClassImpl$Data$declaredNonStaticMembers$2(e);
                        this.scheduleImpl.set(false);
                        String str32 = str;
                        Pair pair2 = new Pair(str32, str32);
                        Long l32 = l;
                        return new ai<>(pair2, l32, l32);
                    }
                }
                Pair<String, Long> authRequestContext = ad.getAuthRequestContext(fArr2, 0.6f);
                Pair<String, Long> authRequestContext2 = ad.getAuthRequestContext(fArr3, 0.6f);
                Pair<String, Long> authRequestContext3 = ad.getAuthRequestContext(fArr4, 0.6f);
                Pair<String, Long> authRequestContext4 = ad.getAuthRequestContext(fArr5, 0.0f);
                StringBuilder sb = new StringBuilder();
                sb.append((String) authRequestContext.first);
                sb.append(":");
                sb.append((String) authRequestContext2.first);
                sb.append(":");
                sb.append((String) authRequestContext3.first);
                Pair pair3 = new Pair(sb.toString(), authRequestContext4.first);
                long longValue = ((Long) authRequestContext.second).longValue();
                long longValue2 = ((Long) authRequestContext2.second).longValue();
                long longValue3 = ((Long) authRequestContext3.second).longValue();
                long uptimeMillis2 = SystemClock.uptimeMillis();
                StringBuilder sb2 = new StringBuilder("Orientation Event Count: ");
                sb2.append(PlaceComponentResult);
                sb2.append("/");
                sb2.append(this.PlaceComponentResult.size());
                ah.PlaceComponentResult("OrientationManager", sb2.toString(), new Throwable[0]);
                StringBuilder sb3 = new StringBuilder("Orientation SDCalc-Time: ");
                sb3.append(uptimeMillis2 - j);
                sb3.append("ms");
                ah.PlaceComponentResult("OrientationManager", sb3.toString(), new Throwable[0]);
                ai<Pair<String, String>, Long, Long> aiVar = new ai<>(pair3, Long.valueOf(longValue + longValue2 + longValue3), Long.valueOf(PlaceComponentResult));
                this.scheduleImpl.set(false);
                return aiVar;
            } catch (Throwable th) {
                this.scheduleImpl.set(false);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            l = l2;
        }
    }

    /* loaded from: classes3.dex */
    final class a implements Callable<ai<Pair<String, String>, Long, Long>> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        public final /* synthetic */ ai<Pair<String, String>, Long, Long> call() throws Exception {
            return n.this.MyBillsEntityDataFactory();
        }
    }
}
