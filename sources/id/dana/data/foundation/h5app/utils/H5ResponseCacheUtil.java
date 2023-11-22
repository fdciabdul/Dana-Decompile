package id.dana.data.foundation.h5app.utils;

import android.graphics.Color;
import android.text.TextUtils;
import com.iap.ac.config.lite.ConfigCenter;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Singleton;
import o.getCallingPid;
import org.json.JSONArray;
import org.json.JSONException;

@Singleton
/* loaded from: classes8.dex */
public class H5ResponseCacheUtil {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char[] BuiltInFictitiousFunctionClassFactory = {37292, 37281, 37309, 37283, 37294, 37304, 37308, 37295, 37290, 37286, 37287, 37311, 37285, 37289, 37307, 37264};
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static char PlaceComponentResult = 42065;
    private static int getAuthRequestContext = 1;

    private static String getAuthRequestContext(String str) {
        int indexOf;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 23;
        getAuthRequestContext = i % 128;
        if (i % 2 == 0) {
            indexOf = str.indexOf(49);
            if (indexOf <= 0) {
                return null;
            }
        } else {
            indexOf = str.indexOf(63);
            if (indexOf <= 0) {
                return null;
            }
        }
        try {
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 93;
            try {
                getAuthRequestContext = i2 % 128;
                String substring = !(i2 % 2 != 0) ? str.substring(1, indexOf) : str.substring(0, indexOf);
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 103;
                getAuthRequestContext = i3 % 128;
                int i4 = i3 % 2;
                return substring;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
    
        if ((android.text.TextUtils.isEmpty(r3) ? 17 : 30) != 30) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
    
        r0 = MyBillsEntityDataFactory();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0034, code lost:
    
        if (r0 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
    
        if (r0.contains(r3) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        r3 = id.dana.data.foundation.h5app.utils.H5ResponseCacheUtil.getAuthRequestContext + 81;
        id.dana.data.foundation.h5app.utils.H5ResponseCacheUtil.KClassImpl$Data$declaredNonStaticMembers$2 = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0048, code lost:
    
        if ((r3 % 2) == 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004f, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0017, code lost:
    
        if (r0 != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean PlaceComponentResult(java.lang.String r3) {
        /*
            int r0 = id.dana.data.foundation.h5app.utils.H5ResponseCacheUtil.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 59
            int r1 = r0 % 128
            id.dana.data.foundation.h5app.utils.H5ResponseCacheUtil.getAuthRequestContext = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 != 0) goto L1c
            java.lang.String r3 = getAuthRequestContext(r3)
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            r2 = 0
            int r2 = r2.length     // Catch: java.lang.Throwable -> L1a
            if (r0 == 0) goto L30
            goto L2f
        L1a:
            r3 = move-exception
            throw r3
        L1c:
            java.lang.String r3 = getAuthRequestContext(r3)
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            r2 = 30
            if (r0 == 0) goto L2b
            r0 = 17
            goto L2d
        L2b:
            r0 = 30
        L2d:
            if (r0 == r2) goto L30
        L2f:
            return r1
        L30:
            java.util.List r0 = MyBillsEntityDataFactory()
            if (r0 == 0) goto L50
            boolean r3 = r0.contains(r3)
            if (r3 == 0) goto L50
            int r3 = id.dana.data.foundation.h5app.utils.H5ResponseCacheUtil.getAuthRequestContext
            int r3 = r3 + 81
            int r0 = r3 % 128
            id.dana.data.foundation.h5app.utils.H5ResponseCacheUtil.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            int r3 = r3 % 2
            r0 = 35
            if (r3 == 0) goto L4d
            r3 = 70
            goto L4f
        L4d:
            r3 = 35
        L4f:
            r1 = 1
        L50:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.foundation.h5app.utils.H5ResponseCacheUtil.PlaceComponentResult(java.lang.String):boolean");
    }

    private static List<String> MyBillsEntityDataFactory() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 21;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        ConfigCenter configCenter = ConfigCenter.getInstance();
        Object[] objArr = new Object[1];
        a(new char[]{14, 4, 7, '\b', 11, '\r', '\r', 5, '\f', '\n', 1, 14, '\b', 4, 11, '\f', 4, '\b', 2, '\b', 11, '\f', 6, '\t', '\n', '\r', 11, 0, '\n', 5, 13868}, (byte) (62 - TextUtils.indexOf("", "")), Color.argb(0, 0, 0, 0) + 31, objArr);
        JSONArray jSONArrayConfig = configCenter.getJSONArrayConfig(((String) objArr[0]).intern());
        if (jSONArrayConfig != null) {
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            while (true) {
                try {
                    if ((i3 < jSONArrayConfig.length() ? '\f' : '.') != '\f') {
                        return arrayList;
                    }
                    int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 87;
                    getAuthRequestContext = i4 % 128;
                    if (i4 % 2 == 0) {
                        arrayList.add(jSONArrayConfig.getString(i3));
                        i3 += 127;
                    } else {
                        arrayList.add(jSONArrayConfig.getString(i3));
                        i3++;
                    }
                } catch (JSONException unused) {
                    return new ArrayList();
                }
            }
        } else {
            int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 99;
            getAuthRequestContext = i5 % 128;
            if (i5 % 2 != 0) {
                return null;
            }
            int i6 = 92 / 0;
            return null;
        }
    }

    private static void a(char[] cArr, byte b, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        try {
            char[] cArr2 = BuiltInFictitiousFunctionClassFactory;
            if (cArr2 != null) {
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                int i3 = 0;
                while (true) {
                    if (!(i3 < length)) {
                        break;
                    }
                    int i4 = $10 + 87;
                    $11 = i4 % 128;
                    if (i4 % 2 == 0) {
                        cArr3[i3] = (char) (cArr2[i3] / (-1549216646985767851L));
                    } else {
                        cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
                    }
                    i3++;
                }
                cArr2 = cArr3;
            }
            char c = (char) ((-1549216646985767851L) ^ PlaceComponentResult);
            char[] cArr4 = new char[i];
            if (i % 2 != 0) {
                i2 = i - 1;
                cArr4[i2] = (char) (cArr[i2] - b);
            } else {
                i2 = i;
            }
            if ((i2 > 1 ? (char) 15 : 'M') == 15) {
                getcallingpid.getAuthRequestContext = 0;
                while (getcallingpid.getAuthRequestContext < i2) {
                    getcallingpid.MyBillsEntityDataFactory = cArr[getcallingpid.getAuthRequestContext];
                    getcallingpid.PlaceComponentResult = cArr[getcallingpid.getAuthRequestContext + 1];
                    if (getcallingpid.MyBillsEntityDataFactory == getcallingpid.PlaceComponentResult) {
                        int i5 = $11 + 31;
                        $10 = i5 % 128;
                        int i6 = i5 % 2;
                        cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory - b);
                        cArr4[getcallingpid.getAuthRequestContext + 1] = (char) (getcallingpid.PlaceComponentResult - b);
                    } else {
                        getcallingpid.BuiltInFictitiousFunctionClassFactory = getcallingpid.MyBillsEntityDataFactory / c;
                        getcallingpid.scheduleImpl = getcallingpid.MyBillsEntityDataFactory % c;
                        getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = getcallingpid.PlaceComponentResult / c;
                        getcallingpid.lookAheadTest = getcallingpid.PlaceComponentResult % c;
                        if (getcallingpid.scheduleImpl == getcallingpid.lookAheadTest) {
                            int i7 = $11 + 43;
                            $10 = i7 % 128;
                            int i8 = i7 % 2;
                            getcallingpid.BuiltInFictitiousFunctionClassFactory = ((getcallingpid.BuiltInFictitiousFunctionClassFactory + c) - 1) % c;
                            getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = ((getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 + c) - 1) % c;
                            int i9 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                            int i10 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                            cArr4[getcallingpid.getAuthRequestContext] = cArr2[i9];
                            cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i10];
                        } else {
                            if ((getcallingpid.BuiltInFictitiousFunctionClassFactory == getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 ? '?' : '6') != '?') {
                                int i11 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                                int i12 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                                cArr4[getcallingpid.getAuthRequestContext] = cArr2[i11];
                                cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i12];
                            } else {
                                getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                                getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                                int i13 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                                int i14 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                                cArr4[getcallingpid.getAuthRequestContext] = cArr2[i13];
                                cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i14];
                            }
                        }
                    }
                    getcallingpid.getAuthRequestContext += 2;
                }
            }
            int i15 = 0;
            while (i15 < i) {
                int i16 = $10 + 27;
                $11 = i16 % 128;
                if (i16 % 2 == 0) {
                    cArr4[i15] = (char) (cArr4[i15] | 11200);
                    i15 += 76;
                } else {
                    cArr4[i15] = (char) (cArr4[i15] ^ 13722);
                    i15++;
                }
            }
            objArr[0] = new String(cArr4);
        } catch (Exception e) {
            throw e;
        }
    }
}
