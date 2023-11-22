package com.akamai.botman;

import android.app.Application;
import android.os.SystemClock;
import android.util.Pair;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
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
public final class j implements Observer {
    public static final byte[] NetworkUserEntityData$$ExternalSyntheticLambda0 = {18, 119, 36, -59, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int getErrorConfigVersion = 35;
    Future<ai<Pair<String, String>, Long, Long>> BuiltInFictitiousFunctionClassFactory;
    i KClassImpl$Data$declaredNonStaticMembers$2;
    boolean PlaceComponentResult;
    long getAuthRequestContext;
    public ArrayList<k> MyBillsEntityDataFactory = new ArrayList<>();
    AtomicBoolean scheduleImpl = new AtomicBoolean(false);

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r7, short r8, byte r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = com.akamai.botman.j.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r8 = r8 * 7
            int r8 = r8 + 99
            int r7 = r7 * 12
            int r7 = 15 - r7
            int r9 = r9 * 3
            int r9 = r9 + 13
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L1a
            r8 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L36
        L1a:
            r3 = 0
        L1b:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            int r7 = r7 + 1
            if (r4 != r9) goto L2c
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2c:
            r3 = r0[r7]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L36:
            int r7 = -r7
            int r9 = r9 + r7
            int r7 = r9 + 2
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r8
            r8 = r7
            r7 = r6
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.akamai.botman.j.a(byte, short, byte, java.lang.Object[]):void");
    }

    public j(Application application) {
        ah.PlaceComponentResult("MotionManager", "Initializing motion manager", new Throwable[0]);
        this.getAuthRequestContext = SystemClock.uptimeMillis();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new i(application);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() throws Exception {
        try {
            byte b = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[15] + 1);
            byte b2 = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[15]);
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[15]);
            byte b4 = (byte) (b3 - 1);
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            Objects.toString(cls.getMethod((String) objArr2[0], null).invoke(null, null));
            this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult();
            this.KClassImpl$Data$declaredNonStaticMembers$2.deleteObservers();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.akamai.botman.ai<android.util.Pair<java.lang.String, java.lang.String>, java.lang.Long, java.lang.Long> BuiltInFictitiousFunctionClassFactory() throws java.lang.Exception {
        /*
            r6 = this;
            java.util.concurrent.Future<com.akamai.botman.ai<android.util.Pair<java.lang.String, java.lang.String>, java.lang.Long, java.lang.Long>> r0 = r6.BuiltInFictitiousFunctionClassFactory
            r1 = 0
            java.lang.String r2 = "MotionManager"
            java.lang.String r3 = "Failed to get motion data: "
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
            if (r0 != 0) goto L82
            r6.KClassImpl$Data$declaredNonStaticMembers$2()
            com.akamai.botman.ai r0 = r6.MyBillsEntityDataFactory()
            if (r0 != 0) goto L82
            java.util.concurrent.Future<com.akamai.botman.ai<android.util.Pair<java.lang.String, java.lang.String>, java.lang.Long, java.lang.Long>> r4 = r6.BuiltInFictitiousFunctionClassFactory
            if (r4 == 0) goto L82
            java.lang.Object r4 = r4.get()     // Catch: java.util.concurrent.ExecutionException -> L55 java.lang.InterruptedException -> L6c
            com.akamai.botman.ai r4 = (com.akamai.botman.ai) r4     // Catch: java.util.concurrent.ExecutionException -> L55 java.lang.InterruptedException -> L6c
            r0 = r4
            goto L82
        L55:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r3)
            java.lang.String r3 = r4.getMessage()
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            java.lang.Throwable[] r1 = new java.lang.Throwable[r1]
            com.akamai.botman.ah.MyBillsEntityDataFactory(r2, r3, r1)
            goto L82
        L6c:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r3)
            java.lang.String r3 = r4.getMessage()
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            java.lang.Throwable[] r1 = new java.lang.Throwable[r1]
            com.akamai.botman.ah.MyBillsEntityDataFactory(r2, r3, r1)
        L82:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.akamai.botman.j.BuiltInFictitiousFunctionClassFactory():com.akamai.botman.ai");
    }

    @Override // java.util.Observer
    public final void update(Observable observable, Object obj) {
        if (obj == null) {
            return;
        }
        try {
            if (this.MyBillsEntityDataFactory.size() >= 128) {
                KClassImpl$Data$declaredNonStaticMembers$2();
                Future<ai<Pair<String, String>, Long, Long>> future = this.BuiltInFictitiousFunctionClassFactory;
                if (future == null || future.isCancelled() || this.BuiltInFictitiousFunctionClassFactory.isDone()) {
                    ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(1);
                    this.BuiltInFictitiousFunctionClassFactory = newFixedThreadPool.submit(new a());
                    newFixedThreadPool.shutdown();
                    return;
                }
                return;
            }
            this.MyBillsEntityDataFactory.add((k) obj);
        } catch (Exception e) {
            ah.MyBillsEntityDataFactory("MotionManager", "Exception in processing motion event", e);
            f.KClassImpl$Data$declaredNonStaticMembers$2(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ai<Pair<String, String>, Long, Long> MyBillsEntityDataFactory() {
        Long l;
        Object obj;
        String str;
        long uptimeMillis;
        int PlaceComponentResult;
        float[] fArr;
        float[] fArr2;
        float[] fArr3;
        float[] fArr4;
        float[] fArr5;
        float[] fArr6;
        float[] fArr7;
        float[] fArr8;
        String str2;
        float[] fArr9;
        float[] fArr10;
        j jVar = this;
        String str3 = "MotionManager";
        try {
            byte b = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[15] + 1);
            byte b2 = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[15]);
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[15]);
            byte b4 = (byte) (b3 - 1);
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            Objects.toString(cls.getMethod((String) objArr2[0], null).invoke(null, null));
            if (jVar.MyBillsEntityDataFactory.size() <= 1) {
                return new ai<>(new Pair("", ""), 0L, 0L);
            }
            try {
                if (jVar.scheduleImpl.compareAndSet(false, true)) {
                    try {
                        uptimeMillis = SystemClock.uptimeMillis();
                        PlaceComponentResult = (int) ag.PlaceComponentResult(jVar.MyBillsEntityDataFactory.size());
                        fArr = new float[PlaceComponentResult];
                        fArr2 = new float[PlaceComponentResult];
                        fArr3 = new float[PlaceComponentResult];
                        fArr4 = new float[PlaceComponentResult];
                        fArr5 = new float[PlaceComponentResult];
                        fArr6 = new float[PlaceComponentResult];
                        fArr7 = new float[PlaceComponentResult];
                        fArr8 = new float[PlaceComponentResult];
                        l = 0L;
                    } catch (Exception e) {
                        e = e;
                        l = 0L;
                    }
                    try {
                        float[] fArr11 = new float[PlaceComponentResult];
                        obj = "";
                        try {
                            float[] fArr12 = new float[PlaceComponentResult];
                            long j = jVar.getAuthRequestContext;
                            Iterator<k> it = jVar.MyBillsEntityDataFactory.iterator();
                            int i = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    str2 = str3;
                                    fArr9 = fArr7;
                                    fArr10 = fArr8;
                                    break;
                                }
                                try {
                                    try {
                                        Iterator<k> it2 = it;
                                        k next = it.next();
                                        str2 = str3;
                                        try {
                                            fArr[i] = next.MyBillsEntityDataFactory;
                                            fArr2[i] = next.KClassImpl$Data$declaredNonStaticMembers$2;
                                            fArr3[i] = next.moveToNextValue;
                                            fArr4[i] = next.getAuthRequestContext;
                                            fArr5[i] = next.PlaceComponentResult;
                                            fArr6[i] = next.BuiltInFictitiousFunctionClassFactory;
                                            fArr7[i] = next.NetworkUserEntityData$$ExternalSyntheticLambda0;
                                            fArr8[i] = next.lookAheadTest;
                                            fArr11[i] = next.getErrorConfigVersion;
                                            long j2 = next.scheduleImpl - j;
                                            fArr9 = fArr7;
                                            fArr10 = fArr8;
                                            fArr12[i] = (float) Math.max(0L, j2);
                                            SystemClock.uptimeMillis();
                                            long j3 = next.scheduleImpl;
                                            float f = fArr[i];
                                            float f2 = fArr2[i];
                                            float f3 = fArr3[i];
                                            float f4 = fArr4[i];
                                            float f5 = fArr5[i];
                                            float f6 = fArr6[i];
                                            float f7 = fArr9[i];
                                            float f8 = fArr10[i];
                                            float f9 = fArr11[i];
                                            long j4 = next.scheduleImpl;
                                            i++;
                                            if (i >= PlaceComponentResult) {
                                                break;
                                            }
                                            fArr7 = fArr9;
                                            fArr8 = fArr10;
                                            it = it2;
                                            j = j4;
                                            str3 = str2;
                                            jVar = this;
                                        } catch (Exception e2) {
                                            e = e2;
                                            jVar = this;
                                            str = str2;
                                            ah.MyBillsEntityDataFactory(str, "Exception in getting motion events", e);
                                            f.KClassImpl$Data$declaredNonStaticMembers$2(e);
                                            jVar.scheduleImpl.set(false);
                                            Object obj2 = obj;
                                            Pair pair = new Pair(obj2, obj2);
                                            Long l2 = l;
                                            return new ai<>(pair, l2, l2);
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        jVar = this;
                                        jVar.scheduleImpl.set(false);
                                        throw th;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    str2 = str3;
                                    jVar = this;
                                    str = str2;
                                    ah.MyBillsEntityDataFactory(str, "Exception in getting motion events", e);
                                    f.KClassImpl$Data$declaredNonStaticMembers$2(e);
                                    jVar.scheduleImpl.set(false);
                                    Object obj22 = obj;
                                    Pair pair2 = new Pair(obj22, obj22);
                                    Long l22 = l;
                                    return new ai<>(pair2, l22, l22);
                                }
                            }
                            Pair<String, Long> authRequestContext = ad.getAuthRequestContext(fArr, 0.6f);
                            Pair<String, Long> authRequestContext2 = ad.getAuthRequestContext(fArr2, 0.6f);
                            Pair<String, Long> authRequestContext3 = ad.getAuthRequestContext(fArr3, 0.6f);
                            Pair<String, Long> authRequestContext4 = ad.getAuthRequestContext(fArr4, 0.6f);
                            Pair<String, Long> authRequestContext5 = ad.getAuthRequestContext(fArr5, 0.6f);
                            Pair<String, Long> authRequestContext6 = ad.getAuthRequestContext(fArr6, 0.6f);
                            Pair<String, Long> authRequestContext7 = ad.getAuthRequestContext(fArr9, 0.6f);
                            Pair<String, Long> authRequestContext8 = ad.getAuthRequestContext(fArr10, 0.6f);
                            Pair<String, Long> authRequestContext9 = ad.getAuthRequestContext(fArr11, 0.6f);
                            Pair<String, Long> authRequestContext10 = ad.getAuthRequestContext(fArr12, 0.0f);
                            StringBuilder sb = new StringBuilder();
                            sb.append((String) authRequestContext.first);
                            sb.append(":");
                            sb.append((String) authRequestContext2.first);
                            sb.append(":");
                            sb.append((String) authRequestContext3.first);
                            sb.append(":");
                            sb.append((String) authRequestContext4.first);
                            sb.append(":");
                            sb.append((String) authRequestContext5.first);
                            sb.append(":");
                            sb.append((String) authRequestContext6.first);
                            sb.append(":");
                            sb.append((String) authRequestContext7.first);
                            sb.append(":");
                            sb.append((String) authRequestContext8.first);
                            sb.append(":");
                            sb.append((String) authRequestContext9.first);
                            Pair pair3 = new Pair(sb.toString(), authRequestContext10.first);
                            long longValue = ((Long) authRequestContext.second).longValue();
                            long longValue2 = ((Long) authRequestContext2.second).longValue();
                            long longValue3 = ((Long) authRequestContext3.second).longValue();
                            long longValue4 = ((Long) authRequestContext4.second).longValue();
                            long longValue5 = ((Long) authRequestContext5.second).longValue();
                            long longValue6 = ((Long) authRequestContext6.second).longValue();
                            long longValue7 = ((Long) authRequestContext7.second).longValue();
                            long longValue8 = ((Long) authRequestContext8.second).longValue();
                            long longValue9 = ((Long) authRequestContext9.second).longValue();
                            long uptimeMillis2 = SystemClock.uptimeMillis();
                            StringBuilder sb2 = new StringBuilder("Motion Event Count: ");
                            sb2.append(PlaceComponentResult);
                            sb2.append("/");
                            try {
                                sb2.append(this.MyBillsEntityDataFactory.size());
                                str = str2;
                            } catch (Exception e4) {
                                e = e4;
                                jVar = this;
                                str = str2;
                                ah.MyBillsEntityDataFactory(str, "Exception in getting motion events", e);
                                f.KClassImpl$Data$declaredNonStaticMembers$2(e);
                                jVar.scheduleImpl.set(false);
                                Object obj222 = obj;
                                Pair pair22 = new Pair(obj222, obj222);
                                Long l222 = l;
                                return new ai<>(pair22, l222, l222);
                            } catch (Throwable th2) {
                                th = th2;
                                jVar = this;
                                jVar.scheduleImpl.set(false);
                                throw th;
                            }
                            try {
                                ah.PlaceComponentResult(str, sb2.toString(), new Throwable[0]);
                                StringBuilder sb3 = new StringBuilder("Motion SDCalc-Time: ");
                                sb3.append(uptimeMillis2 - uptimeMillis);
                                sb3.append("ms");
                                ah.PlaceComponentResult(str, sb3.toString(), new Throwable[0]);
                                ai<Pair<String, String>, Long, Long> aiVar = new ai<>(pair3, Long.valueOf(longValue + longValue2 + longValue3 + longValue4 + longValue5 + longValue6 + longValue7 + longValue8 + longValue9), Long.valueOf(PlaceComponentResult));
                                this.scheduleImpl.set(false);
                                return aiVar;
                            } catch (Exception e5) {
                                e = e5;
                                jVar = this;
                                ah.MyBillsEntityDataFactory(str, "Exception in getting motion events", e);
                                f.KClassImpl$Data$declaredNonStaticMembers$2(e);
                                jVar.scheduleImpl.set(false);
                                Object obj2222 = obj;
                                Pair pair222 = new Pair(obj2222, obj2222);
                                Long l2222 = l;
                                return new ai<>(pair222, l2222, l2222);
                            }
                        } catch (Exception e6) {
                            e = e6;
                            str = str3;
                            ah.MyBillsEntityDataFactory(str, "Exception in getting motion events", e);
                            f.KClassImpl$Data$declaredNonStaticMembers$2(e);
                            jVar.scheduleImpl.set(false);
                            Object obj22222 = obj;
                            Pair pair2222 = new Pair(obj22222, obj22222);
                            Long l22222 = l;
                            return new ai<>(pair2222, l22222, l22222);
                        }
                    } catch (Exception e7) {
                        e = e7;
                        obj = "";
                        str = str3;
                        ah.MyBillsEntityDataFactory(str, "Exception in getting motion events", e);
                        f.KClassImpl$Data$declaredNonStaticMembers$2(e);
                        jVar.scheduleImpl.set(false);
                        Object obj222222 = obj;
                        Pair pair22222 = new Pair(obj222222, obj222222);
                        Long l222222 = l;
                        return new ai<>(pair22222, l222222, l222222);
                    }
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            Throwable cause = th4.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th4;
        }
    }

    /* loaded from: classes3.dex */
    final class a implements Callable<ai<Pair<String, String>, Long, Long>> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        public final /* synthetic */ ai<Pair<String, String>, Long, Long> call() throws Exception {
            return j.this.MyBillsEntityDataFactory();
        }
    }
}
