package com.akamai.botman;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.view.Window;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.zoloz.toyger.blob.BlobStatic;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class h {
    public static final byte[] scheduleImpl = {16, -117, -56, -112, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int getErrorConfigVersion = BlobStatic.MONITOR_IMAGE_WIDTH;
    private static final ArrayList<Integer> lookAheadTest = new ArrayList<>();
    public static boolean getAuthRequestContext = false;
    public t BuiltInFictitiousFunctionClassFactory = null;
    public j MyBillsEntityDataFactory = null;
    public n KClassImpl$Data$declaredNonStaticMembers$2 = null;
    public v PlaceComponentResult = null;
    public c moveToNextValue = null;
    private AtomicBoolean GetContactSyncConfig = new AtomicBoolean(false);
    public boolean NetworkUserEntityData$$ExternalSyntheticLambda0 = false;

    /* JADX WARN: Removed duplicated region for block: B:32:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x002e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x002e -> B:35:0x0039). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r5, byte r6, int r7, java.lang.Object[] r8) {
        /*
            int r7 = r7 * 12
            int r7 = 16 - r7
            byte[] r0 = com.akamai.botman.h.scheduleImpl
            int r6 = r6 * 3
            int r6 = r6 + 13
            int r5 = r5 * 7
            int r5 = r5 + 99
            byte[] r1 = new byte[r6]
            r2 = -1
            int r6 = r6 + r2
            if (r0 != 0) goto L1b
            r5 = r6
            r2 = r1
            r3 = -1
            r1 = r0
            r0 = r8
            r8 = r7
            goto L39
        L1b:
            r4 = r7
            r7 = r5
            r5 = r4
        L1e:
            int r2 = r2 + 1
            byte r3 = (byte) r7
            r1[r2] = r3
            if (r2 != r6) goto L2e
            java.lang.String r5 = new java.lang.String
            r6 = 0
            r5.<init>(r1, r6)
            r8[r6] = r5
            return
        L2e:
            r3 = r0[r5]
            r4 = r7
            r7 = r5
            r5 = r6
            r6 = r3
            r3 = r2
            r2 = r1
            r1 = r0
            r0 = r8
            r8 = r4
        L39:
            int r6 = -r6
            int r7 = r7 + 1
            int r8 = r8 + r6
            int r6 = r8 + 2
            r8 = r0
            r0 = r1
            r1 = r2
            r2 = r3
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.akamai.botman.h.a(int, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(39:14|15|16|(1:18)|19|(1:21)|22|(1:24)|25|(3:29|(1:31)(1:41)|(6:33|(1:35)|36|37|38|39))|42|(4:44|(2:47|45)|48|49)(1:118)|50|(1:52)(2:114|(1:116)(1:117))|53|(1:55)(2:110|(1:112)(1:113))|56|(1:58)(1:109)|59|(1:61)(1:108)|62|(1:64)(1:107)|65|(1:106)|69|70|71|(3:73|(1:77)|78)|79|(3:81|(1:85)|86)|87|(2:89|(3:91|(1:95)|96))|97|(1:99)|100|101|37|38|39) */
    /* JADX WARN: Code restructure failed: missing block: B:390:0x0587, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:392:0x0589, code lost:
    
        r0.getMessage();
        com.akamai.botman.f.KClassImpl$Data$declaredNonStaticMembers$2(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String PlaceComponentResult() {
        /*
            Method dump skipped, instructions count: 1496
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.akamai.botman.h.PlaceComponentResult():java.lang.String");
    }

    private void lookAheadTest() {
        try {
            byte b = (byte) (-scheduleImpl[15]);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, (byte) (b2 - 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (scheduleImpl[15] + 1);
            Object[] objArr2 = new Object[1];
            a(b3, b3, (byte) (-scheduleImpl[15]), objArr2);
            Objects.toString(cls.getMethod((String) objArr2[0], null).invoke(null, null));
            if (com.cyberfend.cyfsecurity.CYFMonitor.BuiltInFictitiousFunctionClassFactory()) {
                BuiltInFictitiousFunctionClassFactory();
                getAuthRequestContext();
                MyBillsEntityDataFactory();
                KClassImpl$Data$declaredNonStaticMembers$2();
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(Window window) throws Exception {
        synchronized (h.class) {
            int hashCode = window.hashCode();
            int i = 0;
            while (true) {
                ArrayList<Integer> arrayList = lookAheadTest;
                if (i < arrayList.size()) {
                    if (hashCode == arrayList.get(i).intValue()) {
                        return true;
                    }
                    i++;
                } else {
                    arrayList.add(Integer.valueOf(hashCode));
                    return false;
                }
            }
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        try {
            byte b = (byte) (-scheduleImpl[15]);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, (byte) (b2 - 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (scheduleImpl[15] + 1);
            Object[] objArr2 = new Object[1];
            a(b3, b3, (byte) (-scheduleImpl[15]), objArr2);
            Objects.toString(cls.getMethod((String) objArr2[0], null).invoke(null, null));
            try {
                this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
            } catch (Exception e) {
                ah.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(6, "Exception in starting orientation manager", e);
                f.KClassImpl$Data$declaredNonStaticMembers$2(e);
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    public final void getAuthRequestContext() {
        synchronized (this) {
            try {
                byte b = (byte) (-scheduleImpl[15]);
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, (byte) (b2 - 1), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (scheduleImpl[15] + 1);
                Object[] objArr2 = new Object[1];
                a(b3, b3, (byte) (-scheduleImpl[15]), objArr2);
                Objects.toString(cls.getMethod((String) objArr2[0], null).invoke(null, null));
                try {
                    n nVar = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    nVar.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult();
                    nVar.KClassImpl$Data$declaredNonStaticMembers$2.deleteObservers();
                } catch (Exception e) {
                    ah.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(6, "Exception in stopping orientation manager", e);
                    f.KClassImpl$Data$declaredNonStaticMembers$2(e);
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
    }

    public final void MyBillsEntityDataFactory() {
        boolean z;
        synchronized (this) {
            try {
                byte b = (byte) (-scheduleImpl[15]);
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, (byte) (b2 - 1), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (scheduleImpl[15] + 1);
                Object[] objArr2 = new Object[1];
                a(b3, b3, (byte) (-scheduleImpl[15]), objArr2);
                Objects.toString(cls.getMethod((String) objArr2[0], null).invoke(null, null));
                try {
                    j jVar = this.MyBillsEntityDataFactory;
                    if (jVar.MyBillsEntityDataFactory.size() >= 128) {
                        return;
                    }
                    if (jVar.scheduleImpl.get()) {
                        return;
                    }
                    i iVar = jVar.KClassImpl$Data$declaredNonStaticMembers$2;
                    iVar.PlaceComponentResult = iVar.MyBillsEntityDataFactory.getDefaultSensor(1);
                    iVar.KClassImpl$Data$declaredNonStaticMembers$2 = iVar.MyBillsEntityDataFactory.getDefaultSensor(4);
                    iVar.BuiltInFictitiousFunctionClassFactory = new HandlerThread("CYFMotionListener");
                    iVar.BuiltInFictitiousFunctionClassFactory.start();
                    Handler handler = new Handler(iVar.BuiltInFictitiousFunctionClassFactory.getLooper());
                    iVar.moveToNextValue = iVar.MyBillsEntityDataFactory.registerListener(iVar, iVar.PlaceComponentResult, 3, handler);
                    iVar.NetworkUserEntityData$$ExternalSyntheticLambda0 = iVar.MyBillsEntityDataFactory.registerListener(iVar, iVar.KClassImpl$Data$declaredNonStaticMembers$2, 3, handler);
                    StringBuilder sb = new StringBuilder("GyroScope status ");
                    sb.append(iVar.NetworkUserEntityData$$ExternalSyntheticLambda0);
                    sb.append(" and Accelerometer status ");
                    sb.append(iVar.moveToNextValue);
                    ah.PlaceComponentResult("MotionListener", sb.toString(), new Throwable[0]);
                    if (!iVar.moveToNextValue && !iVar.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                        ah.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(6, "Failed to register motion listener", new Throwable[0]);
                        iVar.PlaceComponentResult();
                        z = false;
                    } else {
                        iVar.lookAheadTest = !iVar.moveToNextValue;
                        iVar.getErrorConfigVersion = !iVar.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        iVar.getAuthRequestContext = SystemClock.uptimeMillis();
                        iVar.DatabaseTableConfigUtil = (float) System.nanoTime();
                        iVar.NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
                        z = true;
                    }
                    if (!z) {
                        ah.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(6, "Motion listener registration failed", new Throwable[0]);
                        return;
                    }
                    jVar.PlaceComponentResult = true;
                    jVar.KClassImpl$Data$declaredNonStaticMembers$2.addObserver(jVar);
                } catch (Exception e) {
                    ah.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(6, "Exception in starting motion manager", e);
                    f.KClassImpl$Data$declaredNonStaticMembers$2(e);
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        synchronized (this) {
            try {
                byte b = (byte) (-scheduleImpl[15]);
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, (byte) (b2 - 1), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (scheduleImpl[15] + 1);
                Object[] objArr2 = new Object[1];
                a(b3, b3, (byte) (-scheduleImpl[15]), objArr2);
                Objects.toString(cls.getMethod((String) objArr2[0], null).invoke(null, null));
                try {
                    this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
                } catch (Exception e) {
                    ah.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(6, "Exception in stopping motion manager", e);
                    f.KClassImpl$Data$declaredNonStaticMembers$2(e);
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
    }
}
