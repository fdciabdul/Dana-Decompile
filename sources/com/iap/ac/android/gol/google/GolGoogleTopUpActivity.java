package com.iap.ac.android.gol.google;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import com.iap.ac.android.biz.common.callback.InitCallback;
import com.iap.ac.android.biz.common.model.InitErrorCode;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.task.async.IAPAsyncTask;
import com.iap.ac.android.gol.AlipayPlusClientAutoDebit;
import com.iap.ac.android.gol.R;
import com.iap.ac.android.gol.callback.Callback;
import com.iap.ac.android.gol.google.model.DecryptRequest;
import com.iap.ac.android.gol.google.model.DecryptResult;
import com.iap.ac.android.gol.google.model.EncryptRequest;
import com.iap.ac.android.gol.google.model.EncryptResult;
import com.iap.ac.android.gol.google.model.TopUpParams;
import com.iap.ac.android.gol.google.model.TopUpResult;
import com.iap.ac.android.gol.google.model.TopUpStatus;
import com.iap.ac.android.gol.google.network.GolGoogleDecryptProcessor;
import com.iap.ac.android.gol.google.network.GolGoogleEncryptProcessor;
import com.iap.ac.android.gol.google.service.TopUpService;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.Typography;
import o.D;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

/* loaded from: classes8.dex */
public class GolGoogleTopUpActivity extends Activity {
    private static int $10 = 0;
    private static int $11 = 1;
    private static final String ACTION_TOP_UP = "com.google.android.payments.standard.TOPUP_V1";
    public static final byte[] BuiltInFictitiousFunctionClassFactory;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static final String KEY_ASSOCIATIONID = "gspAssociationId";
    private static final String KEY_REQUEST = "gspTopUpRequest";
    private static final String KEY_REQUESTID = "redirectRequestId";
    private static final String KEY_RESPONSE = "gspTopUpResponse";
    private static final String KEY_URL = "redirectUrl";
    private static char[] MyBillsEntityDataFactory = null;
    private static long PlaceComponentResult = 0;
    private static final String TAG = "GolGoogleTopUpActivity";
    public static final int getAuthRequestContext;
    public static final byte[] $$a = {44, -51, -23, -10, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 22;
    private static int moveToNextValue = 1;
    private String redirectUrl = null;
    private String gspTopUpRequest = null;
    private String requestId = null;
    private String gspToUpResponse = null;
    private String gspAssociationId = null;

    static {
        KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        MyBillsEntityDataFactory();
        BuiltInFictitiousFunctionClassFactory = new byte[]{44, 104, -53, -66, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
        getAuthRequestContext = 210;
        BuiltInFictitiousFunctionClassFactory();
        int i = moveToNextValue + 107;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 75;
        moveToNextValue = i % 128;
        int i2 = i % 2;
        MyBillsEntityDataFactory = new char[]{35489, 35358, 35350, 35345, 35352, 35357, 35355, 35353, 35346, 35350, 35356, 35579, 35572, 35347, 35570, 35525, 35555, 35346, 35341, 35766, 35775, 35767, 35755, 35552, 35741, 35733, 35444, 35404, 35443, 35736, 35735, 35732, 35732, 35735, 35727, 35743, 35431, 35734, 35736, 35424, 35427, 35427, 35740, 35738, 35736, 35733, 35737, 35743, 35450, 35500, 35575, 35567, 35524, 35526, 35566, 35568, 35572, 35576, 35580, 35572, 35568, 35570, 35568, 35574, 35570, 35565, 35564, 35503, 35558, 35561, 35580, 35521, 35563, 35559, 35581, 35580, 35559, 35345, 35345, 35342, 35560, 35522, 35520, 35520, 35522, 35520, 35560, 35347, 35344, 35344, 35561, 35558, 35560, 35582, 35559, 35560, 35560, 35347, 35344, 35556, 35580, 35521, 35582, 35556, 35556, 35581, 35521, 35520, 35559, 35558, 35582, 35561, 35563, 35521, 35558, 35542, 35383, 35420, 35381, 35339, 35378, 35420, 35382, 35342, 35341, 35343, 35383, 35380, 35383, 35378, 35341, 35341, 35338, 35340, 35338, 35337, 35334, 35337, 35340, 35345, 35345, 35345, 35383, 35423, 35382, 35341, 35379, 35380, 35383, 35380, 35338, 35378, 35418, 35376, 35341, 35341, 35379, 35420, 35379, 35336, 35381, 35383, 35342, 35343, 35340, 35343, 35381, 35380, 35383, 35383, 35340, 35341, 35341, 35381, 35378, 35376, 35379, 35379, 35380, 35548, 35355, 35330, 35333, 35356, 35337, 35376, 35337, 35334, 35335, 35335, 35374, 35335, 35358, 35552, 35553, 35552, 35359, 35355, 35355, 35357, 35358, 35359, 35355, 35332, 35374, 35334, 35552, 35356, 35354, 35356, 35332, 35333, 35354, 35354, 35357, 35357, 35332, 35334, 35552, 35334, 35375, 35333, 35330, 35375, 35376, 35339, 35359, 35357, 35553, 35334, 35330, 35355, 35354, 35357, 35335, 35332, 35356, 35334, 35332, 35332, 35332, 35333, 35373, 35495, 35565, 35567, 35575, 35571, 35571, 35540, 35502, 35530, 35532, 35535, 35565, 35570, 35576, 35572, 35573, 35538, 35538, 35570, 35574, 35542, 35536, 35568, 35575, 35542, 35543, 35573, 35575, 35573, 35565, 35564, 35573, 35573, 35575, 35573, 35568, 35540, 35535, 35565, 35572, 35580, 35573, 35572, 35581, 35573, 35571, 35568, 35535, 35545, 35577, 35577, 35580, 35543, 35505, 35498, 35528, 35567, 35564, 35562, 35568, 35462, 35503, 35502, 35503, 35503, 35501};
        int i3 = moveToNextValue + 39;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if (i3 % 2 != 0) {
            int i4 = 92 / 0;
        }
    }

    static void MyBillsEntityDataFactory() {
        PlaceComponentResult = -3221870454631969380L;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x004f -> B:18:0x0053). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r9, short r10, int r11, java.lang.Object[] r12) {
        /*
            int r0 = com.iap.ac.android.gol.google.GolGoogleTopUpActivity.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 53
            int r1 = r0 % 128
            com.iap.ac.android.gol.google.GolGoogleTopUpActivity.moveToNextValue = r1
            int r0 = r0 % 2
            byte[] r0 = com.iap.ac.android.gol.google.GolGoogleTopUpActivity.BuiltInFictitiousFunctionClassFactory
            int r11 = r11 + 105
            int r10 = r10 * 4
            int r10 = 16 - r10
            int r9 = r9 * 15
            int r9 = 18 - r9
            byte[] r1 = new byte[r10]
            int r10 = r10 + (-1)
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L20
            r4 = 0
            goto L21
        L20:
            r4 = 1
        L21:
            if (r4 == r2) goto L32
            int r11 = com.iap.ac.android.gol.google.GolGoogleTopUpActivity.moveToNextValue
            int r11 = r11 + 125
            int r4 = r11 % 128
            com.iap.ac.android.gol.google.GolGoogleTopUpActivity.KClassImpl$Data$declaredNonStaticMembers$2 = r4
            int r11 = r11 % 2
            r11 = r10
            r5 = r11
            r4 = 0
            r10 = r9
            goto L53
        L32:
            r4 = 0
        L33:
            int r9 = r9 + r2
            byte r5 = (byte) r11
            r1[r4] = r5
            if (r4 != r10) goto L41
            java.lang.String r9 = new java.lang.String
            r9.<init>(r1, r3)
            r12[r3] = r9
            return
        L41:
            int r4 = r4 + 1
            r5 = r0[r9]
            int r6 = com.iap.ac.android.gol.google.GolGoogleTopUpActivity.moveToNextValue     // Catch: java.lang.Exception -> L5c
            int r6 = r6 + 13
            int r7 = r6 % 128
            com.iap.ac.android.gol.google.GolGoogleTopUpActivity.KClassImpl$Data$declaredNonStaticMembers$2 = r7     // Catch: java.lang.Exception -> L5c
            int r6 = r6 % 2
            r8 = r10
            r10 = r9
            r9 = r11
            r11 = r8
        L53:
            int r5 = -r5
            int r9 = r9 + r5
            int r9 = r9 + 2
            r8 = r11
            r11 = r9
            r9 = r10
            r10 = r8
            goto L33
        L5c:
            r9 = move-exception
            goto L5f
        L5e:
            throw r9
        L5f:
            goto L5e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.gol.google.GolGoogleTopUpActivity.c(int, short, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(byte r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 3
            int r6 = r6 + 21
            byte[] r0 = com.iap.ac.android.gol.google.GolGoogleTopUpActivity.$$a
            int r8 = r8 * 2
            int r8 = r8 + 75
            int r7 = 47 - r7
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L34
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r6) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L34:
            int r8 = r8 + 1
            int r9 = r9 + r6
            int r6 = r9 + (-7)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.gol.google.GolGoogleTopUpActivity.d(byte, int, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0071, code lost:
    
        if ((r2 > 99999 ? kotlin.text.Typography.greater : '%') != '>') goto L40;
     */
    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void attachBaseContext(android.content.Context r24) {
        /*
            Method dump skipped, instructions count: 2939
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.gol.google.GolGoogleTopUpActivity.attachBaseContext(android.content.Context):void");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 75;
        moveToNextValue = i % 128;
        int i2 = i % 2;
        Context applicationContext = super.getApplicationContext();
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 75;
        moveToNextValue = i3 % 128;
        int i4 = i3 % 2;
        return applicationContext;
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        try {
            int i = moveToNextValue + 123;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if ((i % 2 != 0 ? 'O' : '?') != '?') {
                int i2 = 74 / 0;
                return super.getBaseContext();
            }
            return super.getBaseContext();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        int i = moveToNextValue + 47;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (!(i % 2 != 0)) {
            return super.getResources();
        }
        Resources resources = super.getResources();
        Object obj = null;
        obj.hashCode();
        return resources;
    }

    @Override // android.app.Activity
    public void onPause() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 59;
        moveToNextValue = i % 128;
        int i2 = i % 2;
        Context baseContext = getBaseContext();
        Object obj = null;
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(false, new int[]{23, 26, TarHeader.USTAR_FILENAME_PREFIX, 18}, new byte[]{0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b(false, new int[]{49, 18, 0, 14}, new byte[]{1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
            int i3 = moveToNextValue + 11;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
        }
        if ((baseContext != null ? 'C' : (char) 20) != 20) {
            int i5 = moveToNextValue + 49;
            KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
            if (i5 % 2 != 0) {
                try {
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, View.combineMeasuredStates(0, 0) + 35, (char) ((-1) - TextUtils.lastIndexOf("", '0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                    }
                    Object invoke = ((Method) obj2).invoke(null, null);
                    try {
                        Object[] objArr3 = {baseContext};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                        if (obj3 == null) {
                            obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 912, 18 - TextUtils.indexOf("", ""), (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("MyBillsEntityDataFactory", Context.class);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj3);
                        }
                        ((Method) obj3).invoke(invoke, objArr3);
                        obj.hashCode();
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            } else {
                try {
                    Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj4 == null) {
                        obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, TextUtils.indexOf((CharSequence) "", '0', 0) + 36, (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                    }
                    Object invoke2 = ((Method) obj4).invoke(null, null);
                    try {
                        Object[] objArr4 = {baseContext};
                        Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                        if (obj5 == null) {
                            obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - ExpandableListView.getPackedPositionType(0L), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 18, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Context.class);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj5);
                        }
                        ((Method) obj5).invoke(invoke2, objArr4);
                    } catch (Throwable th3) {
                        Throwable cause3 = th3.getCause();
                        if (cause3 == null) {
                            throw th3;
                        }
                        throw cause3;
                    }
                } catch (Throwable th4) {
                    Throwable cause4 = th4.getCause();
                    if (cause4 == null) {
                        throw th4;
                    }
                    throw cause4;
                }
            }
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        Object[] objArr = null;
        if (baseContext == null) {
            int i = moveToNextValue + 125;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            Object[] objArr2 = new Object[1];
            b(false, new int[]{23, 26, TarHeader.USTAR_FILENAME_PREFIX, 18}, new byte[]{0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0}, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            b(false, new int[]{49, 18, 0, 14}, new byte[]{1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0}, objArr3);
            baseContext = (Context) cls.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 117;
            moveToNextValue = i3 % 128;
            int i4 = i3 % 2;
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776287) - Color.rgb(0, 0, 0), Drawable.resolveOpacity(0, 0) + 35, (char) Color.argb(0, 0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 911, (ViewConfiguration.getFadingEdgeLength() >> 16) + 18, (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr4);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        super.onResume();
        int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 27;
        moveToNextValue = i5 % 128;
        if ((i5 % 2 == 0 ? '6' : 'A') != 'A') {
            int length = objArr.length;
        }
    }

    static /* synthetic */ void access$000(GolGoogleTopUpActivity golGoogleTopUpActivity, boolean z) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 31;
        moveToNextValue = i % 128;
        if ((i % 2 == 0 ? Typography.less : '\'') == '\'') {
            golGoogleTopUpActivity.startTopUpFlow(z);
            return;
        }
        golGoogleTopUpActivity.startTopUpFlow(z);
        int i2 = 85 / 0;
    }

    static /* synthetic */ void access$100(GolGoogleTopUpActivity golGoogleTopUpActivity) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 49;
        moveToNextValue = i % 128;
        char c = i % 2 == 0 ? 'F' : 'N';
        golGoogleTopUpActivity.onTopUpFailed();
        if (c != 'F') {
            return;
        }
        int i2 = 22 / 0;
    }

    static /* synthetic */ String access$200(GolGoogleTopUpActivity golGoogleTopUpActivity) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 31;
            moveToNextValue = i % 128;
            int i2 = i % 2;
            String str = golGoogleTopUpActivity.gspTopUpRequest;
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 93;
            moveToNextValue = i3 % 128;
            if (!(i3 % 2 == 0)) {
                return str;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ String access$300(GolGoogleTopUpActivity golGoogleTopUpActivity) {
        try {
            int i = moveToNextValue + 57;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            String str = golGoogleTopUpActivity.gspAssociationId;
            int i3 = moveToNextValue + 19;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ String access$400(GolGoogleTopUpActivity golGoogleTopUpActivity) {
        try {
            int i = moveToNextValue + 85;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if (i % 2 != 0) {
                int i2 = 41 / 0;
                return golGoogleTopUpActivity.requestId;
            }
            return golGoogleTopUpActivity.requestId;
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ String access$402(GolGoogleTopUpActivity golGoogleTopUpActivity, String str) {
        int i = moveToNextValue + 95;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        golGoogleTopUpActivity.requestId = str;
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 65;
        moveToNextValue = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return str;
        }
        Object obj = null;
        obj.hashCode();
        return str;
    }

    static /* synthetic */ void access$500(GolGoogleTopUpActivity golGoogleTopUpActivity, EncryptRequest encryptRequest, String str) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 69;
        moveToNextValue = i % 128;
        int i2 = i % 2;
        golGoogleTopUpActivity.onTopUpFinishToGoogle(encryptRequest, str);
        int i3 = moveToNextValue + 89;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
    }

    static /* synthetic */ void access$600(GolGoogleTopUpActivity golGoogleTopUpActivity, String str) {
        try {
            int i = moveToNextValue + 37;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            char c = i % 2 != 0 ? '\\' : '7';
            Object[] objArr = null;
            golGoogleTopUpActivity.onTopUpFinishToBrowser(str);
            if (c == '\\') {
                objArr.hashCode();
            }
            int i2 = moveToNextValue + 41;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            if (!(i2 % 2 == 0)) {
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ String access$702(GolGoogleTopUpActivity golGoogleTopUpActivity, String str) {
        try {
            int i = moveToNextValue + 59;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            golGoogleTopUpActivity.gspToUpResponse = str;
            try {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 25;
                moveToNextValue = i3 % 128;
                int i4 = i3 % 2;
                return str;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    static /* synthetic */ void access$800(GolGoogleTopUpActivity golGoogleTopUpActivity) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 125;
            moveToNextValue = i % 128;
            int i2 = i % 2;
            golGoogleTopUpActivity.onTopUpAbandon();
            int i3 = moveToNextValue + 119;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ void access$900(GolGoogleTopUpActivity golGoogleTopUpActivity) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 113;
            try {
                moveToNextValue = i % 128;
                int i2 = i % 2;
                golGoogleTopUpActivity.onTopUpSuccess();
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 49;
                moveToNextValue = i3 % 128;
                if ((i3 % 2 == 0 ? ';' : '_') != '_') {
                    Object[] objArr = null;
                    int length = objArr.length;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        b(false, new int[]{0, 18, 28, 4}, new byte[]{1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        b(true, new int[]{18, 5, 194, 0}, new byte[]{0, 1, 0, 0, 0}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (!(intValue >= 99000) || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                b(false, new int[]{23, 26, TarHeader.USTAR_FILENAME_PREFIX, 18}, new byte[]{0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                b(false, new int[]{49, 18, 0, 14}, new byte[]{1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0}, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
                int i = moveToNextValue + 25;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 115;
                moveToNextValue = i3 % 128;
                int i4 = i3 % 2;
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - ((byte) KeyEvent.getModifierMetaStateMask()), 35 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    b(false, new int[]{67, 48, 43, 0}, new byte[]{0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1}, objArr6);
                    String str = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    b(false, new int[]{115, 64, 95, 33}, new byte[]{1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0}, objArr7);
                    String str2 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(true, new int[]{179, 64, 77, 28}, new byte[]{1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0}, objArr8);
                    String str3 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b(true, new int[]{243, 60, 0, 0}, new byte[]{1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0}, objArr9);
                    String str4 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(true, new int[]{303, 6, 0, 0}, new byte[]{1, 1, 0, 0, 0, 1}, objArr10);
                    try {
                        Object[] objArr11 = {baseContext, str, str2, str3, str4, true, (String) objArr10[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 911, 17 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) KeyEvent.keyCodeFromString(""))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr11);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            }
        }
        try {
            byte b = (byte) (BuiltInFictitiousFunctionClassFactory[5] - 1);
            Object[] objArr12 = new Object[1];
            c(b, b, BuiltInFictitiousFunctionClassFactory[5], objArr12);
            Class<?> cls3 = Class.forName((String) objArr12[0]);
            byte b2 = BuiltInFictitiousFunctionClassFactory[5];
            byte b3 = (byte) (b2 - 1);
            Object[] objArr13 = new Object[1];
            c(b2, b3, b3, objArr13);
            try {
                Object[] objArr14 = {Integer.valueOf(((Integer) cls3.getMethod((String) objArr13[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls4 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + 494, 5 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16));
                    byte b4 = $$a[8];
                    byte b5 = (byte) ($$a[78] - 1);
                    Object[] objArr15 = new Object[1];
                    d(b4, b5, b5, objArr15);
                    obj3 = cls4.getMethod((String) objArr15[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr16 = (Object[]) ((Method) obj3).invoke(null, objArr14);
                int i5 = ((int[]) objArr16[1])[0];
                if (((int[]) objArr16[0])[0] != i5) {
                    long j = ((r0 ^ i5) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - KeyEvent.getDeadChar(0, 0), View.resolveSizeAndState(0, 0, 0) + 35, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr17 = {-1453013070, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 17, (char) TextUtils.indexOf("", "", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr17);
                            int i6 = moveToNextValue + 51;
                            KClassImpl$Data$declaredNonStaticMembers$2 = i6 % 128;
                            int i7 = i6 % 2;
                        } catch (Throwable th3) {
                            Throwable cause3 = th3.getCause();
                            if (cause3 == null) {
                                throw th3;
                            }
                            throw cause3;
                        }
                    } catch (Throwable th4) {
                        Throwable cause4 = th4.getCause();
                        if (cause4 == null) {
                            throw th4;
                        }
                        throw cause4;
                    }
                }
                super.onCreate(bundle);
                setContentView(R.layout.acsdk_activity_gol_google_topup);
                Intent intent = getIntent();
                if (!(intent != null)) {
                    int i8 = moveToNextValue + 23;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i8 % 128;
                    if ((i8 % 2 != 0 ? (char) 19 : 'K') == 'K') {
                        onTopUpFailed();
                        return;
                    }
                    onTopUpFailed();
                    Object obj6 = null;
                    obj6.hashCode();
                    return;
                }
                Uri data = intent.getData();
                if (ACTION_TOP_UP.equals(intent.getAction())) {
                    prepareTopUpRequest();
                    if (TextUtils.isEmpty(this.gspTopUpRequest)) {
                        onTopUpFailed();
                        return;
                    } else {
                        initSDK(new InitCallback() { // from class: com.iap.ac.android.gol.google.GolGoogleTopUpActivity.1
                            @Override // com.iap.ac.android.biz.common.callback.InitCallback
                            public void onSuccess() {
                                GolGoogleTopUpActivity.access$000(GolGoogleTopUpActivity.this, true);
                            }

                            @Override // com.iap.ac.android.biz.common.callback.InitCallback
                            public void onFailure(InitErrorCode initErrorCode, String str5) {
                                GolGoogleTopUpActivity.access$100(GolGoogleTopUpActivity.this);
                            }
                        });
                        return;
                    }
                }
                if ((data != null ? (char) 20 : (char) 25) == 25) {
                    finish();
                    return;
                }
                this.redirectUrl = data.getQueryParameter("redirectUrl");
                startTopUpFlow(false);
            } catch (Throwable th5) {
                Throwable cause5 = th5.getCause();
                if (cause5 == null) {
                    throw th5;
                }
                throw cause5;
            }
        } catch (Throwable th6) {
            Throwable cause6 = th6.getCause();
            if (cause6 == null) {
                throw th6;
            }
            throw cause6;
        }
    }

    public void initSDK(InitCallback initCallback) {
        int i = moveToNextValue + 17;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        ACLog.e(TAG, "initSDK");
        initCallback.onSuccess();
        int i3 = moveToNextValue + 55;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if (i3 % 2 == 0) {
            return;
        }
        int i4 = 9 / 0;
    }

    private void startTopUpFlow(boolean z) {
        String intern;
        TopUpService topUpService = AlipayPlusClientAutoDebit.getInstance().getTopUpService();
        TopUpParams topUpParams = new TopUpParams();
        if (z) {
            int i = moveToNextValue + 95;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            intern = "Google";
        } else {
            Object[] objArr = new Object[1];
            a(getApplicationInfo().targetSdkVersion - 33, new char[]{18226, 13612, 18289, 13993, 46391, 13868, 59984, 27489, 18061, 46854}, objArr);
            intern = ((String) objArr[0]).intern();
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 111;
            moveToNextValue = i3 % 128;
            int i4 = i3 % 2;
        }
        topUpParams.callbackType = intern;
        if ((z ? '0' : 'I') != 'I') {
            int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 61;
            moveToNextValue = i5 % 128;
            int i6 = i5 % 2;
            topUpFromGoogle(topUpParams, topUpService);
            return;
        }
        topUpFromOther(topUpParams, topUpService);
    }

    private void topUpFromGoogle(final TopUpParams topUpParams, final TopUpService topUpService) {
        if (topUpService == null) {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 101;
            moveToNextValue = i % 128;
            int i2 = i % 2;
            onTopUpFailed();
            ACLog.e(TAG, "topUpFromGoogle service is null");
            return;
        }
        try {
            IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.gol.google.GolGoogleTopUpActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    GolGoogleDecryptProcessor golGoogleDecryptProcessor = new GolGoogleDecryptProcessor(GolGoogleTopUpActivity.this);
                    DecryptRequest decryptRequest = new DecryptRequest();
                    decryptRequest.messageToBeDecrypted = GolGoogleTopUpActivity.access$200(GolGoogleTopUpActivity.this);
                    if (!TextUtils.isEmpty(GolGoogleTopUpActivity.access$300(GolGoogleTopUpActivity.this))) {
                        decryptRequest.gspAssociationId = GolGoogleTopUpActivity.access$300(GolGoogleTopUpActivity.this);
                    }
                    DecryptResult execute = golGoogleDecryptProcessor.execute(decryptRequest, DecryptResult.class);
                    if (execute == null || !execute.isSuccess()) {
                        GolGoogleTopUpActivity.access$100(GolGoogleTopUpActivity.this);
                        return;
                    }
                    GolGoogleTopUpActivity.access$402(GolGoogleTopUpActivity.this, execute.getRequestId());
                    final EncryptRequest encryptRequest = new EncryptRequest();
                    encryptRequest.redirectRequestId = GolGoogleTopUpActivity.access$400(GolGoogleTopUpActivity.this);
                    topUpService.topUp(topUpParams, new Callback<TopUpResult>() { // from class: com.iap.ac.android.gol.google.GolGoogleTopUpActivity.2.1
                        @Override // com.iap.ac.android.gol.callback.Callback
                        public void onSuccess(TopUpResult topUpResult) {
                            encryptRequest.success = new EncryptRequest.Success();
                            GolGoogleTopUpActivity.access$500(GolGoogleTopUpActivity.this, encryptRequest, "Success");
                        }

                        @Override // com.iap.ac.android.gol.callback.Callback
                        public void onFailure(String str, String str2) {
                            if (TextUtils.equals(TopUpStatus.ABANDON, str)) {
                                encryptRequest.abandoned = new EncryptRequest.Abandoned();
                                GolGoogleTopUpActivity.access$500(GolGoogleTopUpActivity.this, encryptRequest, TopUpStatus.ABANDON);
                                return;
                            }
                            GolGoogleTopUpActivity.access$100(GolGoogleTopUpActivity.this);
                        }
                    });
                }
            });
            try {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 119;
                moveToNextValue = i3 % 128;
                if ((i3 % 2 == 0 ? '.' : Typography.less) != '.') {
                    return;
                }
                int i4 = 86 / 0;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void topUpFromOther(TopUpParams topUpParams, TopUpService topUpService) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 21;
        moveToNextValue = i % 128;
        int i2 = i % 2;
        if ((topUpService == null ? 'O' : '5') == 'O') {
            int i3 = moveToNextValue + 105;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            finish();
            int i5 = moveToNextValue + 117;
            KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
            int i6 = i5 % 2;
        }
        topUpService.topUp(topUpParams, new Callback<TopUpResult>() { // from class: com.iap.ac.android.gol.google.GolGoogleTopUpActivity.3
            @Override // com.iap.ac.android.gol.callback.Callback
            public void onSuccess(TopUpResult topUpResult) {
                GolGoogleTopUpActivity.access$600(GolGoogleTopUpActivity.this, "");
            }

            @Override // com.iap.ac.android.gol.callback.Callback
            public void onFailure(String str, String str2) {
                GolGoogleTopUpActivity.access$600(GolGoogleTopUpActivity.this, str);
            }
        });
    }

    private void onTopUpFinishToGoogle(final EncryptRequest encryptRequest, final String str) {
        try {
            IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.gol.google.GolGoogleTopUpActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    EncryptResult execute = new GolGoogleEncryptProcessor(GolGoogleTopUpActivity.this).execute(encryptRequest, EncryptResult.class);
                    if (execute == null || !execute.isSuccess()) {
                        GolGoogleTopUpActivity.access$100(GolGoogleTopUpActivity.this);
                        return;
                    }
                    GolGoogleTopUpActivity.access$702(GolGoogleTopUpActivity.this, execute.encryptedMessage);
                    if (TextUtils.equals(TopUpStatus.ABANDON, str)) {
                        GolGoogleTopUpActivity.access$800(GolGoogleTopUpActivity.this);
                    } else {
                        GolGoogleTopUpActivity.access$900(GolGoogleTopUpActivity.this);
                    }
                }
            });
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 33;
            moveToNextValue = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private void prepareTopUpRequest() {
        int i = moveToNextValue + 31;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        Intent intent = getIntent();
        if (!(intent != null)) {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 121;
            moveToNextValue = i3 % 128;
            int i4 = i3 % 2;
            ACLog.e(TAG, "intent is null, return directly");
            return;
        }
        this.gspTopUpRequest = intent.getStringExtra(KEY_REQUEST);
        this.gspAssociationId = intent.getStringExtra("gspAssociationId");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002b, code lost:
    
        if ((!android.text.TextUtils.isEmpty(r5.redirectUrl)) != true) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
    
        r6 = com.iap.ac.android.gol.google.GolGoogleTopUpActivity.KClassImpl$Data$declaredNonStaticMembers$2 + 81;
        com.iap.ac.android.gol.google.GolGoogleTopUpActivity.moveToNextValue = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
    
        if ((r6 % 2) != 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003b, code lost:
    
        finish();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003e, code lost:
    
        if (r2 == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0041, code lost:
    
        r1.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0044, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0047, code lost:
    
        r0 = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(r5.redirectUrl).buildUpon().appendQueryParameter("topupState", r6).build());
        r0.setFlags(net.sqlcipher.database.SQLiteDatabase.CREATE_IF_NECESSARY);
        startActivity(r0);
        finish();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        if ((!r0) != false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void onTopUpFinishToBrowser(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = com.iap.ac.android.gol.google.GolGoogleTopUpActivity.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 103
            int r1 = r0 % 128
            com.iap.ac.android.gol.google.GolGoogleTopUpActivity.moveToNextValue = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L20
            java.lang.String r0 = r5.redirectUrl
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            int r4 = r1.length     // Catch: java.lang.Throwable -> L1e
            if (r0 == 0) goto L1a
            r0 = 0
            goto L1b
        L1a:
            r0 = 1
        L1b:
            if (r0 == 0) goto L2d
            goto L47
        L1e:
            r6 = move-exception
            throw r6
        L20:
            java.lang.String r0 = r5.redirectUrl
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L2a
            r0 = 0
            goto L2b
        L2a:
            r0 = 1
        L2b:
            if (r0 == r3) goto L47
        L2d:
            int r6 = com.iap.ac.android.gol.google.GolGoogleTopUpActivity.KClassImpl$Data$declaredNonStaticMembers$2
            int r6 = r6 + 81
            int r0 = r6 % 128
            com.iap.ac.android.gol.google.GolGoogleTopUpActivity.moveToNextValue = r0
            int r6 = r6 % 2
            if (r6 != 0) goto L3a
            goto L3b
        L3a:
            r2 = 1
        L3b:
            r5.finish()
            if (r2 == 0) goto L41
            goto L44
        L41:
            r1.hashCode()     // Catch: java.lang.Throwable -> L45
        L44:
            return
        L45:
            r6 = move-exception
            throw r6
        L47:
            java.lang.String r0 = r5.redirectUrl
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.net.Uri$Builder r0 = r0.buildUpon()
            java.lang.String r1 = "topupState"
            android.net.Uri$Builder r6 = r0.appendQueryParameter(r1, r6)
            android.net.Uri r6 = r6.build()
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "android.intent.action.VIEW"
            r0.<init>(r1, r6)
            r6 = 268435456(0x10000000, float:2.5243549E-29)
            r0.setFlags(r6)
            r5.startActivity(r0)
            r5.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.gol.google.GolGoogleTopUpActivity.onTopUpFinishToBrowser(java.lang.String):void");
    }

    private void onTopUpFailed() {
        Intent intent = new Intent();
        try {
            String str = this.gspToUpResponse;
            if ((str != null ? '2' : '(') != '(') {
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 119;
                moveToNextValue = i % 128;
                int i2 = i % 2;
                try {
                    intent.putExtra(KEY_RESPONSE, str);
                } catch (Exception e) {
                    throw e;
                }
            }
            String str2 = this.requestId;
            if ((str2 != null ? (char) 31 : (char) 27) == 31) {
                intent.putExtra(KEY_REQUESTID, str2);
                int i3 = moveToNextValue + 25;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
            }
            setResult(1, intent);
            finish();
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void onTopUpAbandon() {
        Intent intent = new Intent();
        String str = this.gspToUpResponse;
        if (str != null) {
            try {
                intent.putExtra(KEY_RESPONSE, str);
                int i = moveToNextValue + 53;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
            } catch (Exception e) {
                throw e;
            }
        }
        String str2 = this.requestId;
        if (!(str2 == null)) {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 93;
            moveToNextValue = i3 % 128;
            int i4 = i3 % 2;
            intent.putExtra(KEY_REQUESTID, str2);
        }
        setResult(0, intent);
        finish();
    }

    private void onTopUpSuccess() {
        Intent intent = new Intent();
        intent.putExtra(KEY_RESPONSE, this.gspToUpResponse);
        intent.putExtra(KEY_REQUESTID, this.requestId);
        setResult(-1, intent);
        finish();
        try {
            int i = moveToNextValue + 57;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private static void b(boolean z, int[] iArr, byte[] bArr, Object[] objArr) {
        int i;
        int length;
        char[] cArr;
        int i2;
        int i3;
        VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
        int i4 = iArr[0];
        int i5 = iArr[1];
        int i6 = 2;
        int i7 = iArr[2];
        int i8 = iArr[3];
        char[] cArr2 = MyBillsEntityDataFactory;
        if (cArr2 != null) {
            int i9 = $11 + 111;
            $10 = i9 % 128;
            if (i9 % 2 != 0) {
                length = cArr2.length;
                cArr = new char[length];
                i2 = 1;
            } else {
                length = cArr2.length;
                cArr = new char[length];
                i2 = 0;
            }
            while (i2 < length) {
                int i10 = $10 + 65;
                $11 = i10 % 128;
                if (i10 % i6 == 0) {
                    i3 = i7;
                    cArr[i2] = (char) (cArr2[i2] - 5097613533456403102L);
                    i2 += 0;
                } else {
                    i3 = i7;
                    cArr[i2] = (char) (cArr2[i2] ^ 5097613533456403102L);
                    i2++;
                }
                i7 = i3;
                i6 = 2;
            }
            i = i7;
            cArr2 = cArr;
        } else {
            i = i7;
        }
        char[] cArr3 = new char[i5];
        System.arraycopy(cArr2, i4, cArr3, 0, i5);
        if (bArr != null) {
            char[] cArr4 = new char[i5];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            char c = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i5) {
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
        if ((i8 > 0 ? '%' : InputCardNumberView.DIVIDER) != ' ') {
            char[] cArr5 = new char[i5];
            System.arraycopy(cArr3, 0, cArr5, 0, i5);
            int i11 = i5 - i8;
            System.arraycopy(cArr5, 0, cArr3, i11, i8);
            System.arraycopy(cArr5, i8, cArr3, 0, i11);
        }
        if (z) {
            char[] cArr6 = new char[i5];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i5) {
                int i12 = $11 + 11;
                $10 = i12 % 128;
                if ((i12 % 2 != 0 ? '?' : '+') != '+') {
                    try {
                        cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i5 >>> verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) >>> 0];
                        verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory >>= 0;
                    } catch (Exception e) {
                        throw e;
                    }
                } else {
                    cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i5 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
            }
            cArr3 = cArr6;
        }
        if (i > 0) {
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i5) {
                cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
        }
        String str = new String(cArr3);
        try {
            int i13 = $11 + 89;
            $10 = i13 % 128;
            int i14 = i13 % 2;
            objArr[0] = str;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$22 = D.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        int i2 = $11 + 49;
        $10 = i2 % 128;
        int i3 = i2 % 2;
        while (true) {
            if ((d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$22.length ? '\\' : ']') != '\\') {
                String str = new String(KClassImpl$Data$declaredNonStaticMembers$22, 4, KClassImpl$Data$declaredNonStaticMembers$22.length - 4);
                int i4 = $11 + 99;
                $10 = i4 % 128;
                int i5 = i4 % 2;
                objArr[0] = str;
                return;
            }
            int i6 = $10 + 113;
            $11 = i6 % 128;
            int i7 = i6 % 2;
            d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
            KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (PlaceComponentResult ^ 3919452569568103912L)));
            d.MyBillsEntityDataFactory++;
        }
    }
}
