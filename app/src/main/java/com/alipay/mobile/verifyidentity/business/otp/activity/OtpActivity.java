package com.alipay.mobile.verifyidentity.business.otp.activity;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.androidinter.app.safepaybase.widget.CenterTextView;
import com.alipay.iap.android.common.errorcode.IAPError;
import com.alipay.iap.android.common.task.async.IAPAsyncTask;
import com.alipay.mobile.verifyidentity.RpcSettings;
import com.alipay.mobile.verifyidentity.base.message.Message;
import com.alipay.mobile.verifyidentity.base.message.RequestConstants;
import com.alipay.mobile.verifyidentity.base.message.VIRespone;
import com.alipay.mobile.verifyidentity.base.product.IProduct;
import com.alipay.mobile.verifyidentity.business.activity.ActivityInterface;
import com.alipay.mobile.verifyidentity.business.activity.ActivityInterfaceManager;
import com.alipay.mobile.verifyidentity.business.activity.ClientLogKitManager;
import com.alipay.mobile.verifyidentity.business.activity.ProductActivity;
import com.alipay.mobile.verifyidentity.business.otp.product.OtpModule;
import com.alipay.mobile.verifyidentity.framework.engine.VIEngine;
import com.alipay.mobile.verifyidentity.framework.engine.VerifyResponseCallBack;
import com.alipay.mobile.verifyidentity.uitools.ColorUtils;
import com.alipay.mobile.verifyidentity.uitools.CustomUi;
import com.alipay.mobile.verifyidentity.uitools.JsonUtils;
import com.alipay.mobile.verifyidentity.uitools.count.CountTime;
import com.alipay.mobile.verifyidentity.uitools.dialog.ModalInterface;
import com.alipay.mobile.verifyidentity.uitools.verification.VerificationAction;
import com.alipay.mobile.verifyidentity.uitools.verification.VerificationCodeEditText;
import com.alipay.mobileiclib.common.service.facade.solution.dto.MICRpcRequest;
import com.alipay.mobileiclib.common.service.facade.solution.dto.MICRpcResponse;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getOnBoardingScenario;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class OtpActivity extends ProductActivity implements View.OnClickListener {
    private static final long DESTROY_DURATION = 500;
    public static final String TAG = "OtpActivity";
    private static IProduct.ICallback iCallback;
    private static OtpModule otpProduct;
    private static long sLastDestroyTime;
    private static long sLastResendTime;
    private boolean HAS_OTHERS;
    private String footTips;
    String form_input_tip_low;
    private String form_input_tip_low_counting;
    private String form_input_tip_low_front;
    String form_title;
    private String form_title_2;
    String head_title;
    String inputType;
    private boolean isOtpClickSubmit;
    Message message;
    String mobile_no;
    String nextStep;
    private String otp;
    private TextView resend;
    private CountTime resendCount;
    private View rl_title;
    private TextView tvEmail;
    private CenterTextView tvMiddleDescribe;
    private CenterTextView tvSendTip;
    private VerificationCodeEditText tvVer;
    private TextView tvVerification;
    private TextView tv_changeMethod;
    private TextView tv_resend_front;
    private TextView tv_submit;
    String verifyId;
    public static final byte[] $$g = {Ascii.EM, -104, -116, 103, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$h = 137;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {97, -108, 86, -98, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int NetworkUserEntityData$$ExternalSyntheticLambda0 = 237;
    private static long moveToNextValue = 8487878278321029697L;
    private final int DEFAULT_CHAR_COUNT = 6;
    private int retryCount = 0;
    int inputCharCount = 6;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void h(byte r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 + 16
            int r6 = r6 + 4
            byte[] r0 = com.alipay.mobile.verifyidentity.business.otp.activity.OtpActivity.BuiltInFictitiousFunctionClassFactory
            int r7 = 106 - r7
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L2f
        L15:
            r3 = 0
        L16:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r8) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L23:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L2f:
            int r8 = r8 + r7
            int r7 = r8 + (-4)
            int r6 = r6 + 1
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.verifyidentity.business.otp.activity.OtpActivity.h(byte, short, short, java.lang.Object[]):void");
    }

    private static void i(short s, short s2, short s3, Object[] objArr) {
        byte[] bArr = $$g;
        int i = (s3 * 3) + 21;
        int i2 = 47 - s2;
        int i3 = (s * 2) + 75;
        byte[] bArr2 = new byte[i];
        int i4 = -1;
        int i5 = i - 1;
        if (bArr == null) {
            int i6 = (i5 + (-i2)) - 7;
            i5 = i5;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = -1;
            i2++;
            i3 = i6;
        }
        while (true) {
            int i7 = i4 + 1;
            bArr2[i7] = (byte) i3;
            if (i7 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i8 = i5;
            int i9 = i3;
            int i10 = i2;
            int i11 = (i9 + (-bArr[i2])) - 7;
            i5 = i8;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = i7;
            i2 = i10 + 1;
            i3 = i11;
        }
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.ProductActivity, com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        g((Process.myPid() >> 22) + 57283, new char[]{37731, 19631, 11488, 3129, 60513, 52644, 44532, 36217, 28021, 20138, 11954, 3635, 61012, 53130, 45003, 36618, 28481, 18562}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        g((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 54360, new char[]{37743, 18210, 15333, 61024, 49666}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 930, 35 - (ViewConfiguration.getTouchSlop() >> 8), (char) TextUtils.getCapsMode("", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    g((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 31469, new char[]{37685, 59788, 26350, 58365, 30854, 62919, 29365, 53057, 17501, 49458, 24099, 56139, 20603, 44345, 11205, 41175, 15843, 47758, 14238, 36084, 2530, 34320, 831, 39039, 5470, 37396, 61224, 26009, 58076, 32703, 62629, 29140, 52891, 19385, 49226, 23900, 55856, 22394, 44052, 10537, 42557, 15505, 47572, 14075, 46044, 2200, 34210, 740}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    g(34913 - (Process.myPid() >> 22), new char[]{37731, 6998, 33782, 2629, 45792, 15070, 41332, 10653, 53358, 22536, 49393, 20252, 63466, 32734, 59005, 28313, 5408, 40257, 1462, 35840, 13554, 48326, 11106, 54150, 23084, 49689, 19169, 61788, 31142, 57755, 26734, 4239, 40769, 2023, 36820, 13945, 48837, 9572, 44372, 22006, 56351, 17595, 52365, 31608, 58317, 27192, 4701, 39674, 257, 35232, 12743, 47208, 8335, 44832, 22340, 57316, 17930, 52906, 30363, 64827, 25999, 60455, 37912, 7406}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    g(46141 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), new char[]{37680, 9998, 64285, 36823, 17359, 5636, 43614, 32413, 13010, 50463, 39256, 11692, 57839, 46120, 18532, 7334, 53427, 27498, 16252, 62433, 34804, 23137, 61021, 41546, 30349, 2705, 56585, 37205, 9672, 63885, 35859, 16386, 5269, 43195, 25386, 14189, 52212, 40932, 21050, 58993, 47794, 20129, 305, 54537, 26950, 15755, 61845, 33875, 22548, 60566, 41099, 31552, 3924, 50066, 38842, 10796, 65133, 45730, 18153, 6459, 44328, 25022, 13809, 51256}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    g(Process.getGidForName("") + 32234, new char[]{37738, 61087, 26788, 60105, 25813, 59061, 24667, 57970, 31790, 65106, 30838, 64096, 30144, 63395, 29140, 62423, 19959, 53018, 18708, 52010, 17751, 51052, 16752, 56515, 24253, 55478, 23241, 54499, 22042, 53268, 21053, 44096, 11843, 43129, 11157, 42487, 10149, 41408, 9209, 48466, 16139, 47395, 15185, 46350, 14183, 45721, 3259, 36512, 2241, 35567, 1199, 34335, 'd', 33296, 7233, 40571, 6559, 39821, 5564, 38850}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    g(5077 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), new char[]{37691, 33017, 46236, 43091, 56420, 61466}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), 18 - (Process.myPid() >> 22), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr12);
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
        Context applicationContext2 = context != null ? context.getApplicationContext() : context;
        if (applicationContext2 != null) {
            try {
                byte b = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0 & 55);
                byte b2 = BuiltInFictitiousFunctionClassFactory[25];
                Object[] objArr13 = new Object[1];
                h(b, b2, b2, objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                h(BuiltInFictitiousFunctionClassFactory[35], BuiltInFictitiousFunctionClassFactory[7], BuiltInFictitiousFunctionClassFactory[25], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - Color.green(0), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 3, (char) Color.argb(0, 0, 0, 0));
                        Object[] objArr16 = new Object[1];
                        i($$g[47], (byte) (-$$g[53]), $$g[47], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, View.combineMeasuredStates(0, 0) + 15, (char) (Process.myTid() >> 22))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (Process.myTid() >> 22) + 15, (char) (Process.myTid() >> 22))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - TextUtils.indexOf("", "", 0, 0), 29 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (57994 - (ViewConfiguration.getScrollDefaultDelay() >> 16)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myTid() >> 22) + 800, (ViewConfiguration.getEdgeSlop() >> 16) + 15, (char) (ViewConfiguration.getScrollBarSize() >> 8)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r6 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (Process.myTid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {880680369, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 911, 18 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) TextUtils.getOffsetBefore("", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj8);
                                            }
                                            ((Method) obj8).invoke(invoke3, objArr18);
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
                                } catch (Throwable th5) {
                                    Throwable cause5 = th5.getCause();
                                    if (cause5 == null) {
                                        throw th5;
                                    }
                                    throw cause5;
                                }
                            }
                        } catch (Throwable th6) {
                            Throwable cause6 = th6.getCause();
                            if (cause6 == null) {
                                throw th6;
                            }
                            throw cause6;
                        }
                    } catch (Throwable th7) {
                        Throwable cause7 = th7.getCause();
                        if (cause7 == null) {
                            throw th7;
                        }
                        throw cause7;
                    }
                } catch (Throwable th8) {
                    Throwable cause8 = th8.getCause();
                    if (cause8 == null) {
                        throw th8;
                    }
                    throw cause8;
                }
            } catch (Throwable th9) {
                Throwable cause9 = th9.getCause();
                if (cause9 == null) {
                    throw th9;
                }
                throw cause9;
            }
        }
        Context applicationContext3 = context != null ? context.getApplicationContext() : context;
        if (applicationContext3 != null) {
            try {
                byte b3 = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0 & 55);
                byte b4 = BuiltInFictitiousFunctionClassFactory[25];
                Object[] objArr19 = new Object[1];
                h(b3, b4, b4, objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                h(BuiltInFictitiousFunctionClassFactory[35], BuiltInFictitiousFunctionClassFactory[7], BuiltInFictitiousFunctionClassFactory[25], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(60 - ((byte) KeyEvent.getModifierMetaStateMask()), 46 - (Process.myPid() >> 22), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16));
                        Object[] objArr22 = new Object[1];
                        i((byte) (-$$g[9]), $$g[20], (byte) ($$g[47] - 1), objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r2 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.getSize(0), 35 - KeyEvent.normalizeMetaState(0), (char) (ExpandableListView.getPackedPositionChild(0L) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {880680369, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myTid() >> 22) + 911, 18 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) TextUtils.indexOf("", "", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr24);
                            } catch (Throwable th10) {
                                Throwable cause10 = th10.getCause();
                                if (cause10 == null) {
                                    throw th10;
                                }
                                throw cause10;
                            }
                        } catch (Throwable th11) {
                            Throwable cause11 = th11.getCause();
                            if (cause11 == null) {
                                throw th11;
                            }
                            throw cause11;
                        }
                    }
                } catch (Throwable th12) {
                    Throwable cause12 = th12.getCause();
                    if (cause12 == null) {
                        throw th12;
                    }
                    throw cause12;
                }
            } catch (Throwable th13) {
                Throwable cause13 = th13.getCause();
                if (cause13 == null) {
                    throw th13;
                }
                throw cause13;
            }
        }
        Context applicationContext4 = context != null ? context.getApplicationContext() : context;
        if (applicationContext4 != null) {
            try {
                byte b5 = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0 & 55);
                byte b6 = BuiltInFictitiousFunctionClassFactory[25];
                Object[] objArr25 = new Object[1];
                h(b5, b6, b6, objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                h(BuiltInFictitiousFunctionClassFactory[35], BuiltInFictitiousFunctionClassFactory[7], BuiltInFictitiousFunctionClassFactory[25], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + 119, 3 - Color.blue(0), (char) (38968 - ExpandableListView.getPackedPositionType(0L)));
                        Object[] objArr28 = new Object[1];
                        i((byte) (-$$g[9]), $$g[20], (byte) ($$g[47] - 1), objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r2 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 35 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) Color.argb(0, 0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {880680369, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + 911, View.resolveSizeAndState(0, 0, 0) + 18, (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr30);
                            } catch (Throwable th14) {
                                Throwable cause14 = th14.getCause();
                                if (cause14 == null) {
                                    throw th14;
                                }
                                throw cause14;
                            }
                        } catch (Throwable th15) {
                            Throwable cause15 = th15.getCause();
                            if (cause15 == null) {
                                throw th15;
                            }
                            throw cause15;
                        }
                    }
                } catch (Throwable th16) {
                    Throwable cause16 = th16.getCause();
                    if (cause16 == null) {
                        throw th16;
                    }
                    throw cause16;
                }
            } catch (Throwable th17) {
                Throwable cause17 = th17.getCause();
                if (cause17 == null) {
                    throw th17;
                }
                throw cause17;
            }
        }
        Context applicationContext5 = context != null ? context.getApplicationContext() : context;
        if (applicationContext5 != null) {
            try {
                byte b7 = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0 & 55);
                byte b8 = BuiltInFictitiousFunctionClassFactory[25];
                Object[] objArr31 = new Object[1];
                h(b7, b8, b8, objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                h(BuiltInFictitiousFunctionClassFactory[35], BuiltInFictitiousFunctionClassFactory[7], BuiltInFictitiousFunctionClassFactory[25], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 106, 3 - Drawable.resolveOpacity(0, 0), (char) Color.green(0));
                        byte b9 = (byte) ($$g[47] - 1);
                        Object[] objArr34 = new Object[1];
                        i(b9, b9, (byte) (-$$g[8]), objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r2 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 35, (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {880680369, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getOffsetAfter("", 0), Color.blue(0) + 18, (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr36);
                            } catch (Throwable th18) {
                                Throwable cause18 = th18.getCause();
                                if (cause18 == null) {
                                    throw th18;
                                }
                                throw cause18;
                            }
                        } catch (Throwable th19) {
                            Throwable cause19 = th19.getCause();
                            if (cause19 == null) {
                                throw th19;
                            }
                            throw cause19;
                        }
                    }
                } catch (Throwable th20) {
                    Throwable cause20 = th20.getCause();
                    if (cause20 == null) {
                        throw th20;
                    }
                    throw cause20;
                }
            } catch (Throwable th21) {
                Throwable cause21 = th21.getCause();
                if (cause21 == null) {
                    throw th21;
                }
                throw cause21;
            }
        }
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.ProductActivity, com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.ProductActivity, com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.ProductActivity, com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    static /* synthetic */ int access$908(OtpActivity otpActivity) {
        int i = otpActivity.retryCount;
        otpActivity.retryCount = i + 1;
        return i;
    }

    public static IProduct.ICallback getCallback() {
        return iCallback;
    }

    public static void setCallback(IProduct.ICallback iCallback2) {
        iCallback = iCallback2;
    }

    public static void setOtpProduct(OtpModule otpModule) {
        otpProduct = otpModule;
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.ProductActivity, com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        g(getPackageName().length() + 57276, new char[]{37731, 19631, 11488, 3129, 60513, 52644, 44532, 36217, 28021, 20138, 11954, 3635, 61012, 53130, 45003, 36618, 28481, 18562}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        g(KeyEvent.normalizeMetaState(0) + 54361, new char[]{37743, 18210, 15333, 61024, 49666}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                g(getPackageName().length() + 41484, new char[]{37731, 12671, 55104, 30025, 6945, 47412, 24340, 64937, 33787, 8665, 51148, 26109, 2983, 43414, 20092, 60534, 45636, 20520, 63008, 37906, 14890, 55525, 32466, 7378, 41643, 16573}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                g(30253 - (ViewConfiguration.getFadingEdgeLength() >> 16), new char[]{37729, 58714, 32554, 61943, 19411, 56717, 22136, 43128, 8730, 46311, 3756, 32900, 6525, 37674, 58624, 32712, 61885, 19345}, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) ((-16777216) - Color.rgb(0, 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    g(super.getResources().getString(R.string.family_account_text_invite_members).substring(1, 2).length() + 31468, new char[]{37685, 59788, 26350, 58365, 30854, 62919, 29365, 53057, 17501, 49458, 24099, 56139, 20603, 44345, 11205, 41175, 15843, 47758, 14238, 36084, 2530, 34320, 831, 39039, 5470, 37396, 61224, 26009, 58076, 32703, 62629, 29140, 52891, 19385, 49226, 23900, 55856, 22394, 44052, 10537, 42557, 15505, 47572, 14075, 46044, 2200, 34210, 740}, objArr6);
                    String str = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    g((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 34913, new char[]{37731, 6998, 33782, 2629, 45792, 15070, 41332, 10653, 53358, 22536, 49393, 20252, 63466, 32734, 59005, 28313, 5408, 40257, 1462, 35840, 13554, 48326, 11106, 54150, 23084, 49689, 19169, 61788, 31142, 57755, 26734, 4239, 40769, 2023, 36820, 13945, 48837, 9572, 44372, 22006, 56351, 17595, 52365, 31608, 58317, 27192, 4701, 39674, 257, 35232, 12743, 47208, 8335, 44832, 22340, 57316, 17930, 52906, 30363, 64827, 25999, 60455, 37912, 7406}, objArr7);
                    String str2 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    g((ViewConfiguration.getKeyRepeatDelay() >> 16) + 46141, new char[]{37680, 9998, 64285, 36823, 17359, 5636, 43614, 32413, 13010, 50463, 39256, 11692, 57839, 46120, 18532, 7334, 53427, 27498, 16252, 62433, 34804, 23137, 61021, 41546, 30349, 2705, 56585, 37205, 9672, 63885, 35859, 16386, 5269, 43195, 25386, 14189, 52212, 40932, 21050, 58993, 47794, 20129, 305, 54537, 26950, 15755, 61845, 33875, 22548, 60566, 41099, 31552, 3924, 50066, 38842, 10796, 65133, 45730, 18153, 6459, 44328, 25022, 13809, 51256}, objArr8);
                    String str3 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    g(super.getResources().getString(R.string.merchant_detail_qris_pay).substring(1, 3).length() + 32231, new char[]{37738, 61087, 26788, 60105, 25813, 59061, 24667, 57970, 31790, 65106, 30838, 64096, 30144, 63395, 29140, 62423, 19959, 53018, 18708, 52010, 17751, 51052, 16752, 56515, 24253, 55478, 23241, 54499, 22042, 53268, 21053, 44096, 11843, 43129, 11157, 42487, 10149, 41408, 9209, 48466, 16139, 47395, 15185, 46350, 14183, 45721, 3259, 36512, 2241, 35567, 1199, 34335, 'd', 33296, 7233, 40571, 6559, 39821, 5564, 38850}, objArr9);
                    String str4 = (String) objArr9[0];
                    try {
                        Object[] objArr10 = new Object[1];
                        h(BuiltInFictitiousFunctionClassFactory[25], BuiltInFictitiousFunctionClassFactory[32], (byte) (-BuiltInFictitiousFunctionClassFactory[30]), objArr10);
                        Class<?> cls3 = Class.forName((String) objArr10[0]);
                        Object[] objArr11 = new Object[1];
                        h((byte) (BuiltInFictitiousFunctionClassFactory[59] + 1), BuiltInFictitiousFunctionClassFactory[13], BuiltInFictitiousFunctionClassFactory[56], objArr11);
                        Object[] objArr12 = new Object[1];
                        g(((ApplicationInfo) cls3.getMethod((String) objArr11[0], null).invoke(this, null)).targetSdkVersion + 5044, new char[]{37691, 33017, 46236, 43091, 56420, 61466}, objArr12);
                        try {
                            Object[] objArr13 = {baseContext, str, str2, str3, str4, true, (String) objArr12[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getWindowTouchSlop() >> 8) + 911, 18 - View.MeasureSpec.getSize(0), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                            }
                            ((Method) obj2).invoke(invoke, objArr13);
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
                } catch (Throwable th3) {
                    Throwable cause3 = th3.getCause();
                    if (cause3 == null) {
                        throw th3;
                    }
                    throw cause3;
                }
            }
        }
        try {
            byte b = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0 & 55);
            byte b2 = BuiltInFictitiousFunctionClassFactory[25];
            Object[] objArr14 = new Object[1];
            h(b, b2, b2, objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            h(BuiltInFictitiousFunctionClassFactory[35], BuiltInFictitiousFunctionClassFactory[7], BuiltInFictitiousFunctionClassFactory[25], objArr15);
            try {
                Object[] objArr16 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + 494, 4 - Color.blue(0), (char) TextUtils.getOffsetAfter("", 0));
                    byte b3 = (byte) ($$g[47] - 1);
                    Object[] objArr17 = new Object[1];
                    i(b3, b3, (byte) (-$$g[8]), objArr17);
                    obj3 = cls5.getMethod((String) objArr17[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr18 = (Object[]) ((Method) obj3).invoke(null, objArr16);
                int i = ((int[]) objArr18[1])[0];
                if (((int[]) objArr18[0])[0] != i) {
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.getSize(0), 36 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) TextUtils.indexOf("", "", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr19 = {2029308766, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0', 0, 0), (ViewConfiguration.getLongPressTimeout() >> 16) + 18, (char) (TextUtils.lastIndexOf("", '0') + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr19);
                        } catch (Throwable th4) {
                            Throwable cause4 = th4.getCause();
                            if (cause4 == null) {
                                throw th4;
                            }
                            throw cause4;
                        }
                    } catch (Throwable th5) {
                        Throwable cause5 = th5.getCause();
                        if (cause5 == null) {
                            throw th5;
                        }
                        throw cause5;
                    }
                }
                super.onCreate(bundle);
                setContentView(com.alipay.mobile.verifyidentity.business.otp.R.layout.activity_otp);
                findViewById(com.alipay.mobile.verifyidentity.business.otp.R.id.ll_back).setOnClickListener(this);
                this.tvVerification = (TextView) findViewById(com.alipay.mobile.verifyidentity.business.otp.R.id.tv_verification);
                this.tvSendTip = (CenterTextView) findViewById(com.alipay.mobile.verifyidentity.business.otp.R.id.tv_send_tip);
                this.rl_title = findViewById(com.alipay.mobile.verifyidentity.business.otp.R.id.rl_title);
                findViewById(com.alipay.mobile.verifyidentity.business.otp.R.id.tv_middle_describe);
                this.tvEmail = (TextView) findViewById(com.alipay.mobile.verifyidentity.business.otp.R.id.tv_account);
                this.resend = (TextView) findViewById(com.alipay.mobile.verifyidentity.business.otp.R.id.tv_resend);
                this.tv_changeMethod = (TextView) findViewById(com.alipay.mobile.verifyidentity.business.otp.R.id.tv_remember);
                this.tvMiddleDescribe = (CenterTextView) findViewById(com.alipay.mobile.verifyidentity.business.otp.R.id.tv_middle_describe);
                this.tv_changeMethod.setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.verifyidentity.business.otp.activity.OtpActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        OtpActivity otpActivity = OtpActivity.this;
                        VIEngine.changeVerifyMethod(otpActivity, otpActivity.verifyId);
                    }
                });
                this.resend.setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.verifyidentity.business.otp.activity.OtpActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        OtpActivity.this.createResend();
                        OtpActivity.this.doView(true);
                    }
                });
                TextView textView = (TextView) findViewById(com.alipay.mobile.verifyidentity.business.otp.R.id.tv_confirm);
                this.tv_submit = textView;
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.verifyidentity.business.otp.activity.OtpActivity.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        OtpActivity otpActivity = OtpActivity.this;
                        otpActivity.conformOtp(otpActivity.otp);
                    }
                });
                this.tv_resend_front = (TextView) findViewById(com.alipay.mobile.verifyidentity.business.otp.R.id.tv_resent_front);
            } catch (Throwable th6) {
                Throwable cause6 = th6.getCause();
                if (cause6 == null) {
                    throw th6;
                }
                throw cause6;
            }
        } catch (Throwable th7) {
            Throwable cause7 = th7.getCause();
            if (cause7 == null) {
                throw th7;
            }
            throw cause7;
        }
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.BaseActivity
    public void initData() {
        Message message = (Message) getIntent().getSerializableExtra("message");
        this.message = message;
        if (message != null) {
            this.verifyId = message.getVerifyId();
            this.nextStep = this.message.getNextStep();
            try {
                JSONObject jSONObject = new JSONObject(this.message.getData());
                this.head_title = JsonUtils.getString(jSONObject, "head_title");
                String string = JsonUtils.getString(jSONObject, RequestConstants.Pin.INPUTCHARCOUNT);
                String string2 = JsonUtils.getString(jSONObject, "ackCodeLength");
                this.HAS_OTHERS = jSONObject.optBoolean("HAS_OTHERS", false);
                this.footTips = JsonUtils.getString(jSONObject, "foot_tip");
                if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
                    this.inputCharCount = 6;
                } else if (TextUtils.isEmpty(string)) {
                    this.inputCharCount = Integer.parseInt(string2);
                } else {
                    this.inputCharCount = Integer.parseInt(string);
                }
                this.inputType = JsonUtils.getString(jSONObject, RequestConstants.Pin.INPUTTYPE);
                this.form_title = JsonUtils.getString(jSONObject, "form_title");
                this.mobile_no = JsonUtils.getString(jSONObject, "mobile_no");
                this.form_input_tip_low = JsonUtils.getString(jSONObject, RequestConstants.Pin.FORM_INPUT_TIP_LOW);
                this.form_input_tip_low_front = JsonUtils.getString(jSONObject, "form_input_tip_low_front");
                this.form_title_2 = JsonUtils.getString(jSONObject, "form_title_2");
                this.form_input_tip_low_counting = JsonUtils.getString(jSONObject, "form_input_tip_low_counting");
            } catch (JSONException unused) {
            }
        }
        initViewFromData();
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.BaseActivity
    public void modifyViewFromOutside() {
        TextView textView;
        TextView textView2;
        ViewGroup.LayoutParams layoutParams;
        ActivityInterface commonActivityInterface = ActivityInterfaceManager.getCommonActivityInterface();
        if (!TextUtils.isEmpty(commonActivityInterface.navBigColor())) {
            int parseColor = ColorUtils.parseColor(commonActivityInterface.navBigColor());
            if (!ColorUtils.isColorInvalid(parseColor)) {
                this.rl_title.setBackgroundColor(parseColor);
            }
        }
        if (commonActivityInterface.navTitleHeight() > 0 && (layoutParams = this.rl_title.getLayoutParams()) != null) {
            layoutParams.height = (int) ((commonActivityInterface.navTitleHeight() * getResources().getDisplayMetrics().density) + 0.5f);
            this.rl_title.setLayoutParams(layoutParams);
        }
        ActivityInterface otpActivityInterface = ActivityInterfaceManager.getOtpActivityInterface();
        if (!TextUtils.isEmpty(otpActivityInterface.navTitleColor())) {
            int parseColor2 = ColorUtils.parseColor(otpActivityInterface.navTitleColor());
            if (!ColorUtils.isColorInvalid(parseColor2)) {
                this.tvVerification.setTextColor(parseColor2);
            }
        }
        if (otpActivityInterface.navTitleFont() > 0) {
            this.tvVerification.setTextSize(1, otpActivityInterface.navTitleFont());
        }
        if (!TextUtils.isEmpty(otpActivityInterface.formSubTitleColor())) {
            int parseColor3 = ColorUtils.parseColor(otpActivityInterface.formSubTitleColor());
            if (!ColorUtils.isColorInvalid(parseColor3)) {
                this.tvSendTip.setTextColor(parseColor3);
            }
        }
        if (otpActivityInterface.formSubTitleFont() > 0) {
            this.tvSendTip.setTextSize(1, otpActivityInterface.formSubTitleFont());
        }
        if (otpActivityInterface.formSubTitleAlign() > 0) {
            this.tvSendTip.setGravity(otpActivityInterface.formSubTitleAlign());
        }
        if (!TextUtils.isEmpty(otpActivityInterface.formTitleColor())) {
            int parseColor4 = ColorUtils.parseColor(otpActivityInterface.formTitleColor());
            if (!ColorUtils.isColorInvalid(parseColor4)) {
                this.tvEmail.setTextColor(parseColor4);
            }
        }
        if (otpActivityInterface.formTitleFont() > 0) {
            this.tvEmail.setTextSize(1, otpActivityInterface.formTitleFont());
        }
        if (otpActivityInterface.formTitleAlign() > 0) {
            this.tvEmail.setGravity(otpActivityInterface.formTitleAlign());
        }
        if (!TextUtils.isEmpty(otpActivityInterface.vcodeColor())) {
            int parseColor5 = ColorUtils.parseColor(otpActivityInterface.vcodeColor());
            if (!ColorUtils.isColorInvalid(parseColor5)) {
                this.tvVer.setTextColor(parseColor5);
            }
        }
        if (!TextUtils.isEmpty(otpActivityInterface.vcodeFocusColor())) {
            int parseColor6 = ColorUtils.parseColor(otpActivityInterface.vcodeFocusColor());
            if (!ColorUtils.isColorInvalid(parseColor6)) {
                this.tvVer.setBottomLineCursorColor(parseColor6);
            }
        }
        if (otpActivityInterface.vcodeFont() > 0) {
            this.tvVer.setTextSize(1, otpActivityInterface.vcodeFont());
        }
        if (!TextUtils.isEmpty(otpActivityInterface.footLinkButtonColor())) {
            int parseColor7 = ColorUtils.parseColor(otpActivityInterface.footLinkButtonColor());
            if (this.resendCount != null && !ColorUtils.isColorInvalid(parseColor7)) {
                this.resendCount.setColorActive(parseColor7);
            }
        }
        if (!TextUtils.isEmpty(otpActivityInterface.footLinkButtonDisableColor())) {
            int parseColor8 = ColorUtils.parseColor(otpActivityInterface.footLinkButtonDisableColor());
            if (this.resendCount != null && !ColorUtils.isColorInvalid(parseColor8)) {
                this.resendCount.setColorDisable(parseColor8);
            }
        }
        if (otpActivityInterface.footLinkButtonFont() > 0 && (textView2 = this.resend) != null) {
            textView2.setTextSize(1, otpActivityInterface.footLinkButtonFont());
        }
        if (otpActivityInterface.footLinkButtonAlign() > 0 && (textView = this.resend) != null) {
            textView.setGravity(otpActivityInterface.footLinkButtonAlign());
        }
        if (this.HAS_OTHERS && !TextUtils.isEmpty(this.footTips)) {
            this.tv_changeMethod.setVisibility(0);
            this.tv_changeMethod.setText(this.footTips);
        }
        if (otpActivityInterface.otpClickSubmit()) {
            this.isOtpClickSubmit = true;
            this.tv_submit.setVisibility(0);
            setSubmitState(false);
        }
        if (otpActivityInterface.otpResendStyle() == 1011) {
            this.tv_resend_front.setVisibility(0);
            this.tv_resend_front.setTextSize(12.0f);
            this.tv_resend_front.setTextColor(getResources().getColor(com.alipay.mobile.verifyidentity.business.otp.R.color.text_color));
            this.resend.setVisibility(0);
            this.resend.setTextSize(12.0f);
            this.resend.setTextColor(getResources().getColor(com.alipay.mobile.verifyidentity.business.otp.R.color.text_selected_color));
            this.resendCount.setColorDisable(getResources().getColor(com.alipay.mobile.verifyidentity.business.otp.R.color.high_light));
            this.tv_resend_front.setText(this.form_input_tip_low_front);
            this.resend.setText(this.form_input_tip_low);
            this.tvSendTip.setText(this.form_title);
            this.tvMiddleDescribe.setText(this.form_title_2);
            this.tvEmail.setTextColor(getResources().getColor(com.alipay.mobile.verifyidentity.business.otp.R.color.black));
            this.tvEmail.setTypeface(Typeface.defaultFromStyle(1));
            this.tvMiddleDescribe.setTextColor(getResources().getColor(com.alipay.mobile.verifyidentity.business.otp.R.color.content_color));
            this.tvSendTip.setTextColor(getResources().getColor(com.alipay.mobile.verifyidentity.business.otp.R.color.content_color));
            this.tv_resend_front.setTextColor(getResources().getColor(com.alipay.mobile.verifyidentity.business.otp.R.color.content_color));
        }
        if (otpActivityInterface.otpInputStyle() == 1021) {
            this.tvVer.setInputStyle(otpActivityInterface.otpInputStyle());
        }
        if (otpActivityInterface.otpHaveMiddleText()) {
            this.tvMiddleDescribe.setVisibility(0);
            this.tvMiddleDescribe.setTextSize(otpActivityInterface.otpMiddleTextSize());
        }
        if (otpActivityInterface.otpTopTitleTextSize() > 0) {
            this.tvSendTip.setTextSize(otpActivityInterface.otpTopTitleTextSize());
        }
        if (otpActivityInterface.otpCountTextSize() > 0) {
            this.tvEmail.setTextSize(otpActivityInterface.otpCountTextSize());
        }
        setFontStyle();
    }

    private void setFontStyle() {
        if (CustomUi.getTitleTypeface() != null) {
            this.tvVerification.setTypeface(CustomUi.getTitleTypeface());
        }
        if (CustomUi.getContentTypeface() != null) {
            this.tvEmail.setTypeface(CustomUi.getContentTypeface());
            this.tv_resend_front.setTypeface(CustomUi.getContentTypeface());
            this.resend.setTypeface(CustomUi.getContentTypeface());
            this.tv_changeMethod.setTypeface(CustomUi.getContentTypeface());
            this.tv_submit.setTypeface(CustomUi.getContentTypeface());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSubmitState(boolean z) {
        this.tv_submit.setClickable(z);
        if (z) {
            this.tv_submit.setBackgroundResource(com.alipay.mobile.verifyidentity.business.otp.R.drawable.otp_submit_selected);
        } else {
            this.tv_submit.setBackgroundResource(com.alipay.mobile.verifyidentity.business.otp.R.drawable.otp_submit_unselected);
        }
    }

    private void initViewFromData() {
        this.tvVerification.setText(this.head_title);
        this.tvSendTip.setText(this.form_title);
        this.tvEmail.setText(this.mobile_no);
        initVerificationCodeEditText(this.inputCharCount);
        createResend();
        this.tvSendTip.setText(this.form_title);
        Message message = this.message;
        if (message != null && message.getVerifyType() == 2) {
            doView(false);
        }
        Message message2 = this.message;
        if (message2 == null || "SUCCESS".equalsIgnoreCase(message2.getVerifyCode())) {
            return;
        }
        CustomUi.showCommonDialog(this, "", this.message.getVerifyMessage(), 1001, false, new ModalInterface() { // from class: com.alipay.mobile.verifyidentity.business.otp.activity.OtpActivity.4
            @Override // com.alipay.mobile.verifyidentity.uitools.dialog.ModalInterface
            public void onCancel() {
            }

            @Override // com.alipay.mobile.verifyidentity.uitools.dialog.ModalInterface
            public void onOk() {
                VIRespone vIRespone = new VIRespone(1004);
                vIRespone.setMessage(OtpActivity.this.message);
                vIRespone.setResponseMessage(OtpActivity.this.message);
                vIRespone.setVerifyId(OtpActivity.this.message.getVerifyId());
                if (OtpActivity.getCallback() != null) {
                    OtpActivity.getCallback().onResult(OtpActivity.otpProduct, vIRespone);
                }
                OtpActivity.this.finish();
            }
        });
    }

    private void initVerificationCodeEditText(final int i) {
        VerificationCodeEditText verificationCodeEditText = (VerificationCodeEditText) findViewById(com.alipay.mobile.verifyidentity.business.otp.R.id.tv_ver);
        this.tvVer = verificationCodeEditText;
        verificationCodeEditText.setFigures(6);
        this.tvVer.setOnVerificationCodeChangedListener(new VerificationAction.OnVerificationCodeChangedListener() { // from class: com.alipay.mobile.verifyidentity.business.otp.activity.OtpActivity.5
            @Override // com.alipay.mobile.verifyidentity.uitools.verification.VerificationAction.OnVerificationCodeChangedListener
            public void onVerCodeChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!OtpActivity.this.isOtpClickSubmit || i4 == i) {
                    return;
                }
                OtpActivity.this.setSubmitState(false);
            }

            @Override // com.alipay.mobile.verifyidentity.uitools.verification.VerificationAction.OnVerificationCodeChangedListener
            public void onInputCompleted(CharSequence charSequence) {
                if (!OtpActivity.this.isOtpClickSubmit) {
                    OtpActivity.this.conformOtp(charSequence.toString());
                    return;
                }
                OtpActivity.this.otp = charSequence.toString();
                OtpActivity.this.setSubmitState(true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void conformOtp(String str) {
        showSubmittingDialog();
        ClientLogKitManager.getClientLogKit().log("event", new String[]{"a3.b2.c1", "0", ""}, null, "", "", "", this.verifyId, false);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", str);
        } catch (JSONException unused) {
        }
        VIEngine.verifyRequest(this, this.verifyId, this.nextStep, jSONObject.toString(), new VerifyResponseCallBack() { // from class: com.alipay.mobile.verifyidentity.business.otp.activity.OtpActivity.6
            @Override // com.alipay.mobile.verifyidentity.framework.engine.VerifyResponseCallBack
            public void verifyRequestSuccess(final MICRpcResponse mICRpcResponse) {
                if (mICRpcResponse == null) {
                    ClientLogKitManager.getClientLogKit().log("event", new String[]{"a3.b2.c2", "1", ""}, null, "", "", "", OtpActivity.this.verifyId, false);
                    return;
                }
                ClientLogKitManager.getClientLogKit().log("event", new String[]{"a3.b2.c2", "0", ""}, null, "", "", "", OtpActivity.this.verifyId, false);
                if (!mICRpcResponse.verifySuccess) {
                    OtpActivity.this.clearInput();
                    if (TextUtils.isEmpty(OtpActivity.this.nextStep) || !OtpActivity.this.nextStep.equalsIgnoreCase(mICRpcResponse.nextStep)) {
                        OtpActivity.this.clearInputFocus();
                        CustomUi.showCommonDialog(OtpActivity.this, "", mICRpcResponse.verifyMessage, 1001, false, new ModalInterface() { // from class: com.alipay.mobile.verifyidentity.business.otp.activity.OtpActivity.6.1
                            @Override // com.alipay.mobile.verifyidentity.uitools.dialog.ModalInterface
                            public void onCancel() {
                            }

                            @Override // com.alipay.mobile.verifyidentity.uitools.dialog.ModalInterface
                            public void onOk() {
                                VIRespone vIRespone = new VIRespone(1001);
                                vIRespone.setMessage(OtpActivity.this.message);
                                vIRespone.setResponseMessage(mICRpcResponse.convertToMessage());
                                vIRespone.setVerifyId(mICRpcResponse.verifyId);
                                if (OtpActivity.getCallback() != null) {
                                    OtpActivity.getCallback().onResult(OtpActivity.otpProduct, vIRespone);
                                }
                                OtpActivity.this.finish();
                            }
                        });
                        return;
                    }
                    CustomUi.showCenterToast(OtpActivity.this, mICRpcResponse.verifyMessage);
                    return;
                }
                VIRespone vIRespone = new VIRespone(1000);
                vIRespone.setMessage(OtpActivity.this.message);
                vIRespone.setVerifyId(mICRpcResponse.verifyId);
                vIRespone.setResponseMessage(mICRpcResponse.convertToMessage());
                if (OtpActivity.getCallback() != null) {
                    OtpActivity.getCallback().onResult(OtpActivity.otpProduct, vIRespone);
                }
                OtpActivity.this.finish();
            }

            @Override // com.alipay.mobile.verifyidentity.framework.engine.VerifyResponseCallBack
            public void verifyRequestFail() {
                OtpActivity.access$908(OtpActivity.this);
                OtpActivity.this.clearInput();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createResend() {
        long j = System.currentTimeMillis() - sLastDestroyTime <= 500 ? sLastResendTime : 60000L;
        if (!TextUtils.isEmpty(this.form_input_tip_low)) {
            this.resendCount = new CountTime(this, j, 1000L, this.resend, this.form_input_tip_low);
        } else {
            this.resendCount = new CountTime(this, j, 1000L, this.resend, getResources().getString(com.alipay.mobile.verifyidentity.business.otp.R.string.resend));
        }
        this.resendCount.start();
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.ProductActivity, com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            g(getPackageName().length() + 41484, new char[]{37731, 12671, 55104, 30025, 6945, 47412, 24340, 64937, 33787, 8665, 51148, 26109, 2983, 43414, 20092, 60534, 45636, 20520, 63008, 37906, 14890, 55525, 32466, 7378, 41643, 16573}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            g(View.getDefaultSize(0, 0) + 30253, new char[]{37729, 58714, 32554, 61943, 19411, 56717, 22136, 43128, 8730, 46311, 3756, 32900, 6525, 37674, 58624, 32712, 61885, 19345}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getTrimmedLength("") + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 912, 18 - View.resolveSize(0, 0), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr3);
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
        this.tvVer.post(new Runnable() { // from class: com.alipay.mobile.verifyidentity.business.otp.activity.OtpActivity.7
            @Override // java.lang.Runnable
            public void run() {
                OtpActivity.this.tvVer.setFocusable(true);
                OtpActivity.this.tvVer.setFocusableInTouchMode(true);
                OtpActivity.this.tvVer.requestFocus();
                OtpActivity.this.tvVer.showKeyBoard(OtpActivity.this);
            }
        });
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.ProductActivity, com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            g(super.getResources().getString(R.string.error_message_form_email).substring(20, 22).length() + 41489, new char[]{37731, 12671, 55104, 30025, 6945, 47412, 24340, 64937, 33787, 8665, 51148, 26109, 2983, 43414, 20092, 60534, 45636, 20520, 63008, 37906, 14890, 55525, 32466, 7378, 41643, 16573}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            g(super.getResources().getString(R.string.feed_onboarding_desc_1).substring(11, 12).length() + 30252, new char[]{37729, 58714, 32554, 61943, 19411, 56717, 22136, 43128, 8730, 46311, 3756, 32900, 6525, 37674, 58624, 32712, 61885, 19345}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getOffsetBefore("", 0), View.MeasureSpec.makeMeasureSpec(0, 0) + 35, (char) TextUtils.indexOf("", ""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + 911, 17 - ImageFormat.getBitsPerPixel(0), (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr3);
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
        super.onPause();
        VerificationCodeEditText verificationCodeEditText = this.tvVer;
        if (verificationCodeEditText != null) {
            verificationCodeEditText.hideKeyBoard(this);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        VerificationCodeEditText verificationCodeEditText = this.tvVer;
        if (verificationCodeEditText != null) {
            verificationCodeEditText.hideKeyBoard(this);
        }
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.ProductActivity, com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        sLastDestroyTime = System.currentTimeMillis();
        sLastResendTime = this.resendCount.getLastTime();
        CountTime countTime = this.resendCount;
        if (countTime != null) {
            countTime.cancel();
        }
        setCallback(null);
        setOtpProduct(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        doCancel();
        finish();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == keyEvent.getKeyCode()) {
            doCancel();
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInput() {
        this.tvVer.setText("");
    }

    private void doCancel() {
        VIRespone vIRespone = new VIRespone(1003);
        vIRespone.setVerifyId(this.message.getVerifyId());
        vIRespone.setMessage(this.message);
        if (getCallback() != null) {
            getCallback().onResult(otpProduct, vIRespone);
        }
        ClientLogKitManager.getClientLogKit().log("event", new String[]{"a3.b3.c2", "0", ""}, null, "", "", "", this.verifyId, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInputFocus() {
        VerificationCodeEditText verificationCodeEditText = this.tvVer;
        if (verificationCodeEditText != null) {
            verificationCodeEditText.post(new Runnable() { // from class: com.alipay.mobile.verifyidentity.business.otp.activity.OtpActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    OtpActivity.this.tvVer.clearFocus();
                    OtpActivity.this.tvVer.hideKeyBoard(OtpActivity.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doView(final boolean z) {
        if (z) {
            showSubmittingDialog();
            ClientLogKitManager.getClientLogKit().log("event", new String[]{"a3.b3.c1", "0", ""}, null, "", "", "", this.verifyId, false);
        }
        IAPAsyncTask.asyncTask(new IAPAsyncTask.Runner<MICRpcResponse>() { // from class: com.alipay.mobile.verifyidentity.business.otp.activity.OtpActivity.9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alipay.iap.android.common.task.async.IAPAsyncTask.Runner
            public MICRpcResponse execute() throws Exception {
                MICRpcRequest mICRpcRequest = new MICRpcRequest();
                mICRpcRequest.action = RequestConstants.VIEW;
                mICRpcRequest.module = OtpActivity.this.nextStep;
                mICRpcRequest.verifyId = OtpActivity.this.verifyId;
                mICRpcRequest.data = new JSONObject().toString();
                mICRpcRequest.version = "1.0.0";
                try {
                    return RpcSettings.retrieveRpcService().dispatch(mICRpcRequest);
                } catch (Throwable unused) {
                    return null;
                }
            }

            @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
            public void onSuccess(MICRpcResponse mICRpcResponse) {
                if (z) {
                    OtpActivity.this.hideSubmittingDialog();
                }
                if (mICRpcResponse == null) {
                    return;
                }
                if (!"SUCCESS".equalsIgnoreCase(mICRpcResponse.verifyCode)) {
                    CustomUi.showCenterToast(OtpActivity.this, mICRpcResponse.verifyMessage);
                }
                OtpActivity.this.clearInput();
            }

            @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
            public void onFailure(IAPError iAPError) {
                OtpActivity.this.clearInput();
                if (z) {
                    OtpActivity.this.hideSubmittingDialog();
                }
                CustomUi.showCenterToast(OtpActivity.this, iAPError.errorMessage);
            }
        });
    }

    private static void g(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (moveToNextValue ^ 4796183387843776835L);
            getonboardingscenario.getAuthRequestContext++;
        }
        char[] cArr2 = new char[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
            getonboardingscenario.getAuthRequestContext++;
        }
        objArr[0] = new String(cArr2);
    }
}
