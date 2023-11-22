package id.dana.data.userconfig.model;

import id.dana.domain.userconfig.model.StoreConfig;
import o.getCallingPid;

/* loaded from: classes4.dex */
public class RecentRecipientStoreConfig extends StoreConfig<UserConfigRecentRecipientEntity[]> {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char[] KClassImpl$Data$declaredNonStaticMembers$2 = {42068, 42071, 37264, 37286, 37280, 37292, 37302, 42070, 37294, 37306, 37307, 37290, 37289, 37281, 37308, 37309};
    private static char getAuthRequestContext = 42065;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public RecentRecipientStoreConfig(id.dana.data.userconfig.model.UserConfigRecentRecipientEntity[] r9) {
        /*
            r8 = this;
            r0 = 31
            char[] r0 = new char[r0]
            r0 = {x0032: FILL_ARRAY_DATA , data: [15, 8, 9, 11, 11, 13, 10, 3, 2, 10, 1, 9, 3, 14, 9, 7, 9, 15, 14, 6, 11, 14, 9, 12, 12, 10, 6, 9, 0, 7, 13821} // fill-array
            long r1 = android.os.SystemClock.currentThreadTimeMillis()
            r3 = -1
            java.lang.String r5 = "config_recent_transaction"
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            int r1 = 10 - r6
            byte r1 = (byte) r1
            long r2 = android.os.SystemClock.uptimeMillis()
            r6 = 0
            int r4 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            int r2 = 32 - r4
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            a(r0, r1, r2, r3)
            r0 = 0
            r0 = r3[r0]
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            r8.<init>(r5, r0, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.userconfig.model.RecentRecipientStoreConfig.<init>(id.dana.data.userconfig.model.UserConfigRecentRecipientEntity[]):void");
    }

    private static void a(char[] cArr, byte b, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = KClassImpl$Data$declaredNonStaticMembers$2;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i3 = 0;
            while (true) {
                if (!(i3 < length)) {
                    break;
                }
                cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
                i3++;
            }
            int i4 = $11 + 29;
            $10 = i4 % 128;
            int i5 = i4 % 2;
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ getAuthRequestContext);
        char[] cArr4 = new char[i];
        if (i % 2 != 0) {
            i2 = i - 1;
            cArr4[i2] = (char) (cArr[i2] - b);
        } else {
            i2 = i;
        }
        if (i2 > 1) {
            int i6 = $11 + 45;
            $10 = i6 % 128;
            if (i6 % 2 != 0) {
                getcallingpid.getAuthRequestContext = 1;
            } else {
                getcallingpid.getAuthRequestContext = 0;
            }
            while (getcallingpid.getAuthRequestContext < i2) {
                getcallingpid.MyBillsEntityDataFactory = cArr[getcallingpid.getAuthRequestContext];
                getcallingpid.PlaceComponentResult = cArr[getcallingpid.getAuthRequestContext + 1];
                if (getcallingpid.MyBillsEntityDataFactory == getcallingpid.PlaceComponentResult) {
                    cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory - b);
                    cArr4[getcallingpid.getAuthRequestContext + 1] = (char) (getcallingpid.PlaceComponentResult - b);
                } else {
                    getcallingpid.BuiltInFictitiousFunctionClassFactory = getcallingpid.MyBillsEntityDataFactory / c;
                    getcallingpid.scheduleImpl = getcallingpid.MyBillsEntityDataFactory % c;
                    getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = getcallingpid.PlaceComponentResult / c;
                    getcallingpid.lookAheadTest = getcallingpid.PlaceComponentResult % c;
                    if ((getcallingpid.scheduleImpl == getcallingpid.lookAheadTest ? 'M' : '\f') != '\f') {
                        try {
                            getcallingpid.BuiltInFictitiousFunctionClassFactory = ((getcallingpid.BuiltInFictitiousFunctionClassFactory + c) - 1) % c;
                            getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = ((getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 + c) - 1) % c;
                            int i7 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                            int i8 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                            cArr4[getcallingpid.getAuthRequestContext] = cArr2[i7];
                            cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i8];
                        } catch (Exception e) {
                            throw e;
                        }
                    } else if ((getcallingpid.BuiltInFictitiousFunctionClassFactory == getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 ? ';' : '=') == ';') {
                        getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                        getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                        int i9 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i10 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i9];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i10];
                    } else {
                        int i11 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                        int i12 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i11];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i12];
                    }
                }
                getcallingpid.getAuthRequestContext += 2;
            }
        }
        int i13 = $10 + 75;
        $11 = i13 % 128;
        int i14 = i13 % 2;
        for (int i15 = 0; i15 < i; i15++) {
            int i16 = $11 + 91;
            $10 = i16 % 128;
            int i17 = i16 % 2;
            cArr4[i15] = (char) (cArr4[i15] ^ 13722);
        }
        objArr[0] = new String(cArr4);
    }
}
