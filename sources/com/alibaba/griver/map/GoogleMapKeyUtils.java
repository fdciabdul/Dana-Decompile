package com.alibaba.griver.map;

import android.text.TextUtils;
import android.util.Base64;
import android.view.ViewConfiguration;
import com.alibaba.griver.base.common.logger.GriverLogger;
import kotlin.text.Typography;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;

/* loaded from: classes6.dex */
public class GoogleMapKeyUtils {
    private static int $10 = 0;
    private static int $11 = 1;
    public static final String G_API_KEY = "gAPIKey";
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
    private static char[] BuiltInFictitiousFunctionClassFactory = {39486, 39873, 39887, 39910, 39901};
    private static boolean getAuthRequestContext = true;
    private static boolean PlaceComponentResult = true;
    private static int MyBillsEntityDataFactory = 909155221;

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
    
        if ((!android.text.TextUtils.isEmpty(r7) ? com.alibaba.fastjson.parser.JSONLexer.EOI : '\f') != '\f') goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
    
        if ((android.text.TextUtils.isEmpty(r7)) != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0033, code lost:
    
        r7 = (com.alibaba.griver.map.GriverMapCustomAPIKeyExtension) com.alibaba.ariver.kernel.common.RVProxy.get(com.alibaba.griver.map.GriverMapCustomAPIKeyExtension.class, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0039, code lost:
    
        if (r7 == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003f, code lost:
    
        if (r7.canUseGoogleAPIKey(r6) != false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0041, code lost:
    
        return "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0044, code lost:
    
        r6 = com.alibaba.griver.base.common.config.GriverConfig.getConfig("HK_TA_GOOGLE_MAP_API_KEY");
        r7 = new java.lang.StringBuilder();
        r7.append("googleMapApiKey:");
        r7.append(r6);
        com.alibaba.ariver.kernel.common.utils.RVLogger.d("GoogleMapKeyUtils", r7.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0062, code lost:
    
        if (android.text.TextUtils.isEmpty(r6) != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
    
        r7 = com.alibaba.griver.map.GoogleMapKeyUtils.KClassImpl$Data$declaredNonStaticMembers$2 + 67;
        com.alibaba.griver.map.GoogleMapKeyUtils.NetworkUserEntityData$$ExternalSyntheticLambda0 = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006e, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0073, code lost:
    
        return com.alibaba.griver.base.common.utils.MetaDataUtils.getMetaData(com.alipay.android.mapassist.util.Constants.GOOGLE_MAP_KEY);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0074, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0075, code lost:
    
        com.alibaba.ariver.kernel.common.utils.RVLogger.e("GoogleMapKeyUtils", r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007c, code lost:
    
        return com.alibaba.griver.base.common.utils.MetaDataUtils.getMetaData(com.alipay.android.mapassist.util.Constants.GOOGLE_MAP_KEY);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007d, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007e, code lost:
    
        throw r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007f, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0081, code lost:
    
        r6 = com.alibaba.griver.map.GoogleMapKeyUtils.KClassImpl$Data$declaredNonStaticMembers$2 + 37;
        com.alibaba.griver.map.GoogleMapKeyUtils.NetworkUserEntityData$$ExternalSyntheticLambda0 = r6 % 128;
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008f, code lost:
    
        return decodeApiKey(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0090, code lost:
    
        throw r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getGoogleMapApiKey(java.lang.String r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "com.google.android.geo.API_KEY"
            java.lang.String r1 = "GoogleMapKeyUtils"
            int r2 = com.alibaba.griver.map.GoogleMapKeyUtils.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r2 = r2 + 77
            int r3 = r2 % 128
            com.alibaba.griver.map.GoogleMapKeyUtils.KClassImpl$Data$declaredNonStaticMembers$2 = r3
            int r2 = r2 % 2
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L27
            boolean r2 = android.text.TextUtils.isEmpty(r7)
            r5 = 58
            int r5 = r5 / r4
            r4 = 12
            if (r2 != 0) goto L20
            r2 = 26
            goto L22
        L20:
            r2 = 12
        L22:
            if (r2 == r4) goto L31
            goto L81
        L25:
            r6 = move-exception
            throw r6
        L27:
            boolean r2 = android.text.TextUtils.isEmpty(r7)
            if (r2 != 0) goto L2e
            goto L2f
        L2e:
            r4 = 1
        L2f:
            if (r4 == 0) goto L81
        L31:
            java.lang.Class<com.alibaba.griver.map.GriverMapCustomAPIKeyExtension> r7 = com.alibaba.griver.map.GriverMapCustomAPIKeyExtension.class
            java.lang.Object r7 = com.alibaba.ariver.kernel.common.RVProxy.get(r7, r3)     // Catch: java.lang.Exception -> L7d
            com.alibaba.griver.map.GriverMapCustomAPIKeyExtension r7 = (com.alibaba.griver.map.GriverMapCustomAPIKeyExtension) r7     // Catch: java.lang.Exception -> L7d
            if (r7 == 0) goto L44
            boolean r6 = r7.canUseGoogleAPIKey(r6)
            if (r6 != 0) goto L44
            java.lang.String r6 = ""
            return r6
        L44:
            java.lang.String r6 = "HK_TA_GOOGLE_MAP_API_KEY"
            java.lang.String r6 = com.alibaba.griver.base.common.config.GriverConfig.getConfig(r6)     // Catch: java.lang.Throwable -> L74
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L74
            r7.<init>()     // Catch: java.lang.Throwable -> L74
            java.lang.String r2 = "googleMapApiKey:"
            r7.append(r2)     // Catch: java.lang.Throwable -> L74
            r7.append(r6)     // Catch: java.lang.Throwable -> L74
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L74
            com.alibaba.ariver.kernel.common.utils.RVLogger.d(r1, r7)     // Catch: java.lang.Throwable -> L74
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L74
            if (r7 != 0) goto L6f
            int r7 = com.alibaba.griver.map.GoogleMapKeyUtils.KClassImpl$Data$declaredNonStaticMembers$2
            int r7 = r7 + 67
            int r0 = r7 % 128
            com.alibaba.griver.map.GoogleMapKeyUtils.NetworkUserEntityData$$ExternalSyntheticLambda0 = r0
            int r7 = r7 % 2
            return r6
        L6f:
            java.lang.String r6 = com.alibaba.griver.base.common.utils.MetaDataUtils.getMetaData(r0)     // Catch: java.lang.Throwable -> L74
            return r6
        L74:
            r6 = move-exception
            com.alibaba.ariver.kernel.common.utils.RVLogger.e(r1, r6)
            java.lang.String r6 = com.alibaba.griver.base.common.utils.MetaDataUtils.getMetaData(r0)
            return r6
        L7d:
            r6 = move-exception
            throw r6
        L7f:
            r6 = move-exception
            goto L90
        L81:
            int r6 = com.alibaba.griver.map.GoogleMapKeyUtils.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L7f
            int r6 = r6 + 37
            int r0 = r6 % 128
            com.alibaba.griver.map.GoogleMapKeyUtils.NetworkUserEntityData$$ExternalSyntheticLambda0 = r0     // Catch: java.lang.Exception -> L7f
            int r6 = r6 % 2
            java.lang.String r6 = decodeApiKey(r7)
            return r6
        L90:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.map.GoogleMapKeyUtils.getGoogleMapApiKey(java.lang.String, java.lang.String):java.lang.String");
    }

    public static String decodeApiKey(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                int i = 4;
                Object[] objArr = new Object[1];
                a(126 - TextUtils.lastIndexOf("", '0', 0, 0), new byte[]{-123, -124, -125, -126, -127}, null, null, objArr);
                byte[] decode = Base64.decode(str.getBytes(((String) objArr[0]).intern()), 0);
                if ((decode.length < 4 ? 'Y' : 'F') != 'F') {
                    int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 69;
                    NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
                    if ((i2 % 2 == 0 ? '7' : (char) 25) != 25) {
                        int i3 = 18 / 0;
                        return "";
                    }
                    return "";
                }
                int length = decode.length - 1;
                byte[] bArr = new byte[length];
                int i4 = 0;
                byte b = 0;
                while (i4 < decode.length) {
                    if ((i4 < i ? (char) 5 : Typography.amp) == 5) {
                        bArr[i4] = decode[i4];
                    }
                    if (i4 == i) {
                        b = decode[i4];
                    }
                    if (i4 > i) {
                        int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 69;
                        NetworkUserEntityData$$ExternalSyntheticLambda0 = i5 % 128;
                        if (i5 % 2 == 0) {
                            bArr[i4 * 1] = decode[i4];
                        } else {
                            bArr[i4 - 1] = decode[i4];
                        }
                    }
                    i4++;
                    int i6 = KClassImpl$Data$declaredNonStaticMembers$2 + 7;
                    NetworkUserEntityData$$ExternalSyntheticLambda0 = i6 % 128;
                    int i7 = i6 % 2;
                    i = 4;
                }
                if (b == 0) {
                    return "";
                }
                int i8 = 0;
                while (true) {
                    if ((i8 < length ? 'N' : '!') != '!') {
                        bArr[i8] = (byte) (bArr[i8] ^ b);
                        i8++;
                    } else {
                        Object[] objArr2 = new Object[1];
                        a((ViewConfiguration.getLongPressTimeout() >> 16) + 127, new byte[]{-123, -124, -125, -126, -127}, null, null, objArr2);
                        return new String(bArr, ((String) objArr2[0]).intern());
                    }
                }
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("GoogleMapKeyUtils#decodeApiKey error");
                sb.append(th);
                GriverLogger.e("GoogleMapKeyUtils", sb.toString());
                return "";
            }
        } else {
            int i9 = KClassImpl$Data$declaredNonStaticMembers$2 + 121;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i9 % 128;
            int i10 = i9 % 2;
            return "";
        }
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) {
        int i2;
        int length;
        char[] cArr2;
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr3 = BuiltInFictitiousFunctionClassFactory;
        if (cArr3 != null) {
            int i3 = $10 + 93;
            $11 = i3 % 128;
            if ((i3 % 2 == 0 ? '5' : '/') != '/') {
                length = cArr3.length;
                cArr2 = new char[length];
            } else {
                length = cArr3.length;
                cArr2 = new char[length];
            }
            int i4 = 0;
            while (true) {
                if (!(i4 < length)) {
                    break;
                }
                cArr2[i4] = (char) (cArr3[i4] ^ 4571606982258105150L);
                i4++;
            }
            cArr3 = cArr2;
        }
        int i5 = (int) (4571606982258105150L ^ MyBillsEntityDataFactory);
        if (!(!PlaceComponentResult)) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
            char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            int i6 = $11 + 51;
            $10 = i6 % 128;
            int i7 = i6 % 2;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                int i8 = $11 + 37;
                $10 = i8 % 128;
                if ((i8 % 2 != 0 ? 'I' : (char) 24) != 'I') {
                    cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i5);
                    i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory + 1;
                } else {
                    cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult * 0) + bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] % i] >> i5);
                    i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory << 0;
                }
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = i2;
            }
            objArr[0] = new String(cArr4);
        } else if (getAuthRequestContext) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
            char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            int i9 = $11 + 93;
            $10 = i9 % 128;
            int i10 = i9 % 2;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                int i11 = $11 + 43;
                $10 = i11 % 128;
                if (i11 % 2 != 0) {
                    cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult >>> 0) * bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] / i] * i5);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory %= 0;
                } else {
                    try {
                        cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i5);
                        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                    } catch (Exception e) {
                        throw e;
                    }
                }
            }
            objArr[0] = new String(cArr5);
        } else {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
            char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (true) {
                if ((bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult ? 'H' : '1') == '1') {
                    objArr[0] = new String(cArr6);
                    return;
                } else {
                    cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i5);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                }
            }
        }
    }
}
