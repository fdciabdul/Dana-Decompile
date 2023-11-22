package com.xiaomi.channel.commonutils.logger;

import android.content.Context;
import android.os.Process;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.xiaomi.channel.commonutils.android.f;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes8.dex */
public abstract class b {
    private static LoggerInterface BuiltInFictitiousFunctionClassFactory = null;
    private static Context MyBillsEntityDataFactory = null;
    private static final HashMap<Integer, Long> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private static final HashMap<Integer, String> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private static int PlaceComponentResult = 2;
    private static AtomicInteger getErrorConfigVersion;
    private static boolean initRecordTimeStamp;
    private static final Integer lookAheadTest;
    private static boolean moveToNextValue;
    private static String scheduleImpl;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {42, -75, 2, Ascii.US, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int getAuthRequestContext = 156;

    /* loaded from: classes8.dex */
    static class a implements LoggerInterface {
        private String PlaceComponentResult = b.scheduleImpl;

        a() {
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public final void BuiltInFictitiousFunctionClassFactory(String str) {
            InstrumentInjector.log_v(this.PlaceComponentResult, str);
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public final void PlaceComponentResult(String str, Throwable th) {
            InstrumentInjector.log_v(this.PlaceComponentResult, str, th);
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("XMPush-");
        sb.append(Process.myPid());
        scheduleImpl = sb.toString();
        BuiltInFictitiousFunctionClassFactory = new a();
        NetworkUserEntityData$$ExternalSyntheticLambda0 = new HashMap<>();
        NetworkUserEntityData$$ExternalSyntheticLambda1 = new HashMap<>();
        lookAheadTest = -1;
        getErrorConfigVersion = new AtomicInteger(1);
    }

    public static void BuiltInFictitiousFunctionClassFactory(Integer num) {
        if (PlaceComponentResult <= 1) {
            HashMap<Integer, Long> hashMap = NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (hashMap.containsKey(num)) {
                long longValue = hashMap.remove(num).longValue();
                String remove = NetworkUserEntityData$$ExternalSyntheticLambda1.remove(num);
                long currentTimeMillis = System.currentTimeMillis();
                LoggerInterface loggerInterface = BuiltInFictitiousFunctionClassFactory;
                StringBuilder sb = new StringBuilder();
                sb.append(remove);
                sb.append(" ends in ");
                sb.append(currentTimeMillis - longValue);
                sb.append(" ms");
                loggerInterface.BuiltInFictitiousFunctionClassFactory(sb.toString());
            }
        }
    }

    private static String MyBillsEntityDataFactory() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Tid:");
        try {
            Object[] objArr = new Object[1];
            a((byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] + 1), KClassImpl$Data$declaredNonStaticMembers$2[16], (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] + 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
            byte b2 = KClassImpl$Data$declaredNonStaticMembers$2[15];
            Object[] objArr2 = new Object[1];
            a(b, b2, (byte) (-b2), objArr2);
            sb.append(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getId());
            sb.append("] ");
            return sb.toString();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static void MyBillsEntityDataFactory(Context context) {
        MyBillsEntityDataFactory = context;
        if (f.PlaceComponentResult(context)) {
            moveToNextValue = true;
        }
        if (f.BuiltInFictitiousFunctionClassFactory()) {
            initRecordTimeStamp = true;
        }
    }

    public static Integer PlaceComponentResult(String str) {
        if (PlaceComponentResult <= 1) {
            Integer valueOf = Integer.valueOf(getErrorConfigVersion.incrementAndGet());
            NetworkUserEntityData$$ExternalSyntheticLambda0.put(valueOf, Long.valueOf(System.currentTimeMillis()));
            NetworkUserEntityData$$ExternalSyntheticLambda1.put(valueOf, str);
            LoggerInterface loggerInterface = BuiltInFictitiousFunctionClassFactory;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" starts");
            loggerInterface.BuiltInFictitiousFunctionClassFactory(sb.toString());
            return valueOf;
        }
        return lookAheadTest;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2
            int r8 = r8 * 7
            int r8 = 106 - r8
            int r7 = r7 + 4
            int r6 = r6 * 3
            int r6 = 16 - r6
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L15
            r4 = r8
            r3 = 0
            r8 = r7
            goto L2c
        L15:
            r3 = 0
        L16:
            int r7 = r7 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r6) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r5
        L2c:
            int r4 = -r4
            int r7 = r7 + r4
            int r7 = r7 + 2
            r5 = r8
            r8 = r7
            r7 = r5
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.logger.b.a(short, short, int, java.lang.Object[]):void");
    }

    public static void getAuthRequestContext() {
        PlaceComponentResult = 2;
    }

    public static void getAuthRequestContext(LoggerInterface loggerInterface) {
        BuiltInFictitiousFunctionClassFactory = loggerInterface;
    }

    public static void getAuthRequestContext(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(MyBillsEntityDataFactory());
        sb.append(str);
        String obj = sb.toString();
        if (2 >= PlaceComponentResult) {
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(obj);
        }
    }

    public static void MyBillsEntityDataFactory(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(MyBillsEntityDataFactory());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        sb2.append(str);
        sb2.append("] ");
        sb2.append(str2);
        sb.append(sb2.toString());
        String obj = sb.toString();
        if (2 >= PlaceComponentResult) {
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(obj);
        }
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(MyBillsEntityDataFactory());
        sb.append(str);
        String obj = sb.toString();
        if (4 >= PlaceComponentResult) {
            BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(obj, th);
        }
    }

    public static void getAuthRequestContext(Throwable th) {
        if (4 >= PlaceComponentResult) {
            BuiltInFictitiousFunctionClassFactory.PlaceComponentResult("", th);
        }
    }

    public static void MyBillsEntityDataFactory(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(MyBillsEntityDataFactory());
        sb.append(str);
        String obj = sb.toString();
        if (PlaceComponentResult <= 0) {
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(obj);
        }
    }

    public static void BuiltInFictitiousFunctionClassFactory(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(MyBillsEntityDataFactory());
        sb.append(str);
        String obj = sb.toString();
        if (1 >= PlaceComponentResult) {
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(obj);
        }
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(MyBillsEntityDataFactory());
        sb.append(str);
        String obj = sb.toString();
        if (4 >= PlaceComponentResult) {
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(obj);
        }
    }

    public static void moveToNextValue(String str) {
        if (!moveToNextValue) {
            String str2 = scheduleImpl;
            StringBuilder sb = new StringBuilder();
            sb.append(MyBillsEntityDataFactory());
            sb.append(str);
            InstrumentInjector.log_w(str2, sb.toString());
            if (initRecordTimeStamp) {
                return;
            }
        }
        getAuthRequestContext(str);
    }
}
