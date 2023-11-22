package com.xiaomi.channel.commonutils.android;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import com.alipay.multimedia.adjuster.utils.PathUtils;
import java.lang.reflect.Method;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

/* loaded from: classes8.dex */
public class MIPushProvider extends ContentProvider {
    private static char[] KClassImpl$Data$declaredNonStaticMembers$2 = {35497, 35567, 35534, 35489, 35583, 35566, 35575, 35578, 35570, 35565, 35572, 35577, 35575, 35573, 35566, 35570, 35576, 35543, 35496, 35565, 35577, 35521, 35576, 35502, 35577, 35575, 35573, 35566, 35570, 35576, 35543, 35545, 35574, 35566, 35537, 35497, 35532, 35573, 35568, 35569, 35569, 35568, 35560, 35576, 35520, 35571, 35573, 35581, 35580, 35491, 35556, 35558, 35556, 35560, 35568, 35564, 35560, 35556, 35554, 35578, 35576, 35555, 35563, 35561, 35552, 35553, 35558, 35461, 35539, 35538, 35497, 35498, 35540, 35536, 35494, 35497, 35536, 35578, 35578, 35579, 35541, 35503, 35501, 35501, 35503, 35501, 35541, 35580, 35581, 35581, 35538, 35539, 35541, 35499, 35536, 35541, 35541, 35580, 35581, 35537, 35497, 35498, 35499, 35537, 35537, 35494, 35498, 35501, 35536, 35539, 35499, 35538, 35540, 35498, 35539, 35549, 35571, 35528, 35529, 35529, 35569, 35566, 35564, 35567, 35567, 35568, 35531, 35571, 35352, 35569, 35527, 35566, 35352, 35570, 35530, 35529, 35531, 35571, 35568, 35571, 35566, 35529, 35529, 35526, 35528, 35526, 35525, 35522, 35525, 35528, 35533, 35533, 35533, 35571, 35355, 35570, 35529, 35567, 35568, 35571, 35568, 35526, 35566, 35350, 35564, 35529, 35529, 35567, 35352, 35567, 35524, 35569, 35571, 35530, 35531, 35528, 35531, 35569, 35568, 35503, 35583, 35540, 35499, 35536, 35537, 35494, 35537, 35576, 35536, 35539, 35539, 35539, 35541, 35499, 35539, 35538, 35496, 35497, 35494, 35537, 35541, 35500, 35496, 35498, 35542, 35583, 35578, 35537, 35536, 35578, 35541, 35503, 35541, 35539, 35496, 35496, 35497, 35497, 35536, 35539, 35499, 35497, 35499, 35503, 35541, 35581, 35539, 35494, 35498, 35501, 35496, 35494, 35494, 35498, 35503, 35500, 35503, 35501, 35538, 35581, 35538, 35538, 35541, 35459, 35492, 35489, 35583, 35554, 35555, 35553, 35559, 35558, 35552, 35554, 35562, 35558, 35558, 35531, 35493, 35521, 35523, 35522, 35552, 35561, 35567, 35563, 35560, 35529, 35529, 35561, 35565, 35533, 35527, 35559, 35562, 35533, 35530, 35560, 35562, 35560, 35552, 35555, 35560, 35560, 35562, 35560, 35559, 35531, 35522, 35552, 35563, 35571, 35560, 35563, 35568, 35560, 35558, 35559, 35522, 35532, 35564, 35564, 35571, 35538, 35341, 35343, 35343, 35342, 35343};

    public static Uri a(Context context) {
        String packageName = context.getPackageName();
        StringBuilder sb = new StringBuilder();
        sb.append(PathUtils.CONTENT_SCHEMA);
        sb.append(packageName);
        sb.append(".mipush.sdk.data");
        return Uri.parse(sb.toString());
    }

    private void a() {
        getContext().getSharedPreferences("mipush_region", 0).edit().putBoolean("req_hosts", false).apply();
    }

    private void a(Bundle bundle) {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("mipush_region", 0);
        String string = sharedPreferences.getString("user_region", "");
        boolean z = sharedPreferences.getBoolean("req_hosts", false);
        bundle.putString("user_region", string);
        bundle.putBoolean("req_hosts", z);
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if ("getUserRegion".equals(str)) {
            a(bundle2);
        } else if ("reset_req_hosts".equals(str)) {
            a();
        }
        return bundle2;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Object[] objArr = new Object[1];
        b(false, new int[]{0, 18, 0, 10}, new byte[]{1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0}, objArr);
        Class<?> cls = Class.forName((String) objArr[0]);
        Object[] objArr2 = new Object[1];
        b(false, new int[]{18, 5, 0, 0}, new byte[]{1, 0, 0, 0, 1}, objArr2);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr2[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Object[] objArr3 = new Object[1];
            b(false, new int[]{23, 26, 0, 0}, new byte[]{1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1}, objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            b(true, new int[]{49, 18, 12, 0}, new byte[]{0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0}, objArr4);
            Context context = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
            if (context != null) {
                context = context.getApplicationContext();
            }
            if (context != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + 930, 36 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr5 = new Object[1];
                    b(false, new int[]{67, 48, 0, 0}, new byte[]{1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1}, objArr5);
                    String str = (String) objArr5[0];
                    Object[] objArr6 = new Object[1];
                    b(false, new int[]{115, 64, 35, 44}, new byte[]{1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1}, objArr6);
                    String str2 = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    b(false, new int[]{179, 64, 0, 43}, new byte[]{0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0}, objArr7);
                    String str3 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(true, new int[]{243, 60, 11, 8}, new byte[]{0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1}, objArr8);
                    String str4 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b(false, new int[]{303, 6, 96, 0}, new byte[]{1, 1, 0, 0, 0, 1}, objArr9);
                    try {
                        Object[] objArr10 = {context, str, str2, str3, str4, true, (String) objArr9[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + 911, (-16777198) - Color.rgb(0, 0, 0), (char) TextUtils.indexOf("", "", 0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr10);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 != null) {
                        throw cause2;
                    }
                    throw th2;
                }
            }
        }
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private static void b(boolean z, int[] iArr, byte[] bArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        char[] cArr = KClassImpl$Data$declaredNonStaticMembers$2;
        if (cArr != null) {
            int length = cArr.length;
            char[] cArr2 = new char[length];
            for (int i5 = 0; i5 < length; i5++) {
                cArr2[i5] = (char) (cArr[i5] ^ 5097613533456403102L);
            }
            cArr = cArr2;
        }
        char[] cArr3 = new char[i2];
        System.arraycopy(cArr, i, cArr3, 0, i2);
        if (bArr != null) {
            char[] cArr4 = new char[i2];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            char c = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                if (bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1) {
                    cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                } else {
                    cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                }
                c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
            cArr3 = cArr4;
        }
        if (i4 > 0) {
            char[] cArr5 = new char[i2];
            System.arraycopy(cArr3, 0, cArr5, 0, i2);
            int i6 = i2 - i4;
            System.arraycopy(cArr5, 0, cArr3, i6, i4);
            System.arraycopy(cArr5, i4, cArr3, 0, i6);
        }
        if (z) {
            char[] cArr6 = new char[i2];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i2 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
            cArr3 = cArr6;
        }
        if (i3 > 0) {
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
        }
        objArr[0] = new String(cArr3);
    }
}
