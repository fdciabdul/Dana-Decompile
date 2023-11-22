package com.alipay.zoloz.zface.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.mobile.security.bio.config.Constant;
import com.alipay.mobile.security.bio.constants.CodeConstants;
import com.alipay.mobile.security.bio.constants.ZcodeConstants;
import com.alipay.mobile.security.bio.service.BioAppDescription;
import com.alipay.mobile.security.bio.service.BioAppManager;
import com.alipay.mobile.security.bio.service.BioServiceManager;
import com.alipay.mobile.security.bio.utils.ScreenUtil;
import com.alipay.zoloz.config.ConfigCenter;
import com.alipay.zoloz.hardware.camera.widget.AbsSurfaceView;
import com.alipay.zoloz.zface.beans.AlertData;
import com.alipay.zoloz.zface.presenter.ZFaceBasePresenter;
import com.alipay.zoloz.zface.presenter.ZFaceCallback;
import com.alipay.zoloz.zface.presenter.ZFacePresenter;
import com.alipay.zoloz.zface.services.TimeRecord;
import com.alipay.zoloz.zface.services.ZFaceRecordService;
import com.alipay.zoloz.zface.ui.activity.BaseCameraPermissionActivity;
import com.alipay.zoloz.zface.ui.util.AlertUtil;
import com.alipay.zoloz.zface.ui.util.EnvCheck;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.whenAvailable;
import zoloz.ap.com.toolkit.R2;

/* loaded from: classes7.dex */
public abstract class BaseFaceActivity extends BaseCameraPermissionActivity implements AlertUtil.AlertClickEvents {
    protected AlertUtil mAlertUtil;
    protected String mAppTag;
    protected ZFacePresenter mZFacePresenter;
    public static final byte[] $$d = {82, -89, -124, -60, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$e = 62;
    public static final byte[] getAuthRequestContext = {Ascii.RS, 119, -63, 113, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int NetworkUserEntityData$$ExternalSyntheticLambda0 = 206;
    private static char[] getErrorConfigVersion = {62255, 42674, 22542, 62346, 42345, 22781, 62022, 42398, 24497, 61727, 42196, 24152, 61924, 43851, 24273, 61605, 43549, 23951, 22903, 3313, 62059, 22981, 3894, 26463, 12994, 52350, 26618, 12569, 52365, 26166, 12782, 52175, 25964, 12538, 51798, 26023, 16183, 51894, 25817, 15976, 51685, 25358, 16017, 51202, 25516, 15808, 55109, 25327, 15384, 62253, 42665, 22552, 62346, 42339, 22778, 62038, 42481, 24494, 61724, 42134, 24161, 61941, 43845, 24262, 61609, 43521, 23954, 62329, 42687, 22620, 62400, 42294, 22768, 61979, 42376, 24553, 61705, 42137, 24174, 61939, 43798, 24195, 61686, 43615, 24013, 63292, 43769, 23618, 63447, 43425, 17254, 63130, 43071, 17314, 62796, 43140, 17056, 62515, 44933, 16695, 62634, 44568, 16769, 64416, 44397, 16602, 64064, 44457, 18250, 64142, 44286, 17972, 63959, 37700, 18149, 40664, 51998, 13739, 40555, 51351, 13658, 40933, 51327, 12877, 40184, 51508, 13258, 39941, 50914, 13172, 40195, 51115, 12345, 39579, 51038, 12725, 39538, 50179, 11924, 39743, 50585, 11860, 39098, 50553, 12119, 39319, 49701, 11418, 39183, 50153, 11383, 38482, 49344, 11557, 38836, 49244, 10987, 38696, 49422, 11202, 37924, 65204, 11072, 38378, 65144, 10250, 37526, 65320, 10676, 37445, 64726, 10617, 37642, 64974, 9853, 37040, 64843, 10113, 36964, 62332, 42733, 22543, 62362, 42303, 22691, 61968, 42372, 24550, 61780, 42178, 24121, 61863, 43799, 24194, 61687, 43535, 23961, 63294, 43772, 23572, 63446, 43427, 17251, 63177, 43114, 17315, 62736, 43216, 17058, 62565, 44931, 16697, 62712, 44568, 16768, 64420, 44387, 16596, 64072, 44454, 18250, 64139, 44284, 18030, 63956, 37651, 18146, 63560, 37765, 17833, 65341, 37588, 17477, 65508, 37157, 17545, 65273, 36963, 19422, 64784, 37041, 18983, 64921, 62246, 42664, 22558, 62344, 42357, 22702, 61965, 42399, 24506, 61709, 42132, 24169, 61880, 43856, 24282, 61618, 43531, 23965, 63358, 43771, 23623, 63431, 43446, 17278, 63129, 43129, 17403, 62810, 43218, 17079, 62499, 44949, 16751, 62702, 44623, 16790, 64421, 44347, 16527, 64095, 44543, 18268, 64211, 44263, 17983, 63882, 37653, 18149, 63581, 37832, 17893, 65326, 37588, 17499, 65511, 37222, 17627, 65186, 36910, 19355, 62327, 42738, 22622, 62422, 42292, 22693};
    private static long scheduleImpl = 8555748482576983772L;
    private boolean mIsFirstResume = true;
    private boolean isPause = false;
    private boolean mLastHasPermission = false;
    protected boolean mIsUploading = false;

    /* JADX WARN: Removed duplicated region for block: B:20:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0026 -> B:23:0x002f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(short r7, short r8, int r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 + 16
            int r9 = r9 + 4
            int r7 = r7 + 97
            byte[] r0 = com.alipay.zoloz.zface.ui.BaseFaceActivity.getAuthRequestContext
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            goto L2f
        L14:
            r3 = 0
        L15:
            int r9 = r9 + 1
            byte r4 = (byte) r7
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r8) goto L26
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L26:
            r3 = r0[r9]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L2f:
            int r7 = r7 + r8
            int r7 = r7 + (-4)
            r8 = r9
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.zoloz.zface.ui.BaseFaceActivity.d(short, short, int, java.lang.Object[]):void");
    }

    private static void f(short s, byte b, short s2, Object[] objArr) {
        int i = (s * 3) + 21;
        int i2 = s2 + 4;
        int i3 = (b * 2) + 75;
        byte[] bArr = $$d;
        byte[] bArr2 = new byte[i];
        int i4 = -1;
        int i5 = i - 1;
        if (bArr == null) {
            i2++;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = -1;
            i3 = (i3 + i5) - 7;
            i5 = i5;
        }
        while (true) {
            int i6 = i4 + 1;
            bArr2[i6] = (byte) i3;
            if (i6 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b2 = bArr[i2];
            int i7 = i3;
            i2++;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = i6;
            i3 = (i7 + b2) - 7;
            i5 = i5;
        }
    }

    @Override // com.alipay.zoloz.zface.ui.activity.BaseCameraPermissionActivity, com.alipay.mobile.security.bio.workspace.BioFragmentContainer, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        e((ViewConfiguration.getWindowTouchSlop() >> 8) + 18, View.getDefaultSize(0, 0), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        e(6 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 19 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (View.getDefaultSize(0, 0) + 43604), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.argb(0, 0, 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - TextUtils.indexOf((CharSequence) "", '0'), (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    e(Color.green(0) + 48, 67 - TextUtils.getOffsetAfter("", 0), (char) Color.blue(0), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    e((-16777152) - Color.rgb(0, 0, 0), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 115, (char) (AndroidCharacter.getMirror('0') + 28103), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    e(TextUtils.lastIndexOf("", '0', 0) + 65, 178 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) Color.blue(0), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    e(59 - ExpandableListView.getPackedPositionChild(0L), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 244, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    e((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 6, View.MeasureSpec.getSize(0) + 303, (char) ((Process.getThreadPriority(0) + 20) >> 6), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", ""), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18, (char) KeyEvent.getDeadChar(0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = getAuthRequestContext[32];
                byte b2 = getAuthRequestContext[25];
                Object[] objArr13 = new Object[1];
                d(b, b2, (byte) (b2 | 36), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b3 = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0 & 56);
                byte b4 = getAuthRequestContext[25];
                Object[] objArr14 = new Object[1];
                d(b3, b4, (byte) (b4 | Ascii.NAK), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (Process.myTid() >> 22), (ViewConfiguration.getTouchSlop() >> 8) + 3, (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))));
                        byte b5 = $$d[78];
                        byte b6 = b5;
                        Object[] objArr16 = new Object[1];
                        f(b5, b6, (byte) (b6 - 1), objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 15 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) (Color.rgb(0, 0, 0) + 16777216))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, ImageFormat.getBitsPerPixel(0) + 16, (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - (ViewConfiguration.getScrollBarSize() >> 8), 30 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (View.resolveSize(0, 0) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - View.resolveSize(0, 0), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 15, (char) (Process.getGidForName("") + 1)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r8 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (ViewConfiguration.getPressedStateDuration() >> 16) + 35, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-1981545082, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 17, (char) ((-1) - ImageFormat.getBitsPerPixel(0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b7 = getAuthRequestContext[32];
                byte b8 = getAuthRequestContext[25];
                Object[] objArr19 = new Object[1];
                d(b7, b8, (byte) (b8 | 36), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b9 = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0 & 56);
                byte b10 = getAuthRequestContext[25];
                Object[] objArr20 = new Object[1];
                d(b9, b10, (byte) (b10 | Ascii.NAK), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(62 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 46 - (Process.myTid() >> 22), (char) View.MeasureSpec.getMode(0));
                        Object[] objArr22 = new Object[1];
                        f((byte) ($$d[78] - 1), $$d[9], (byte) ($$d[23] - 1), objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollDefaultDelay() >> 16), View.MeasureSpec.getSize(0) + 35, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-1981545082, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + 912, (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 18, (char) (TextUtils.indexOf((CharSequence) "", '0') + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b11 = getAuthRequestContext[32];
                byte b12 = getAuthRequestContext[25];
                Object[] objArr25 = new Object[1];
                d(b11, b12, (byte) (b12 | 36), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b13 = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0 & 56);
                byte b14 = getAuthRequestContext[25];
                Object[] objArr26 = new Object[1];
                d(b13, b14, (byte) (b14 | Ascii.NAK), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - Color.alpha(0), 4 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) (38967 - ImageFormat.getBitsPerPixel(0)));
                        Object[] objArr28 = new Object[1];
                        f((byte) ($$d[78] - 1), $$d[9], (byte) ($$d[23] - 1), objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.lastIndexOf("", '0', 0, 0) + 36, (char) View.combineMeasuredStates(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-1981545082, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 911, 18 - TextUtils.getOffsetBefore("", 0), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b15 = getAuthRequestContext[32];
                byte b16 = getAuthRequestContext[25];
                Object[] objArr31 = new Object[1];
                d(b15, b16, (byte) (b16 | 36), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b17 = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0 & 56);
                byte b18 = getAuthRequestContext[25];
                Object[] objArr32 = new Object[1];
                d(b17, b18, (byte) (b18 | Ascii.NAK), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(108 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), View.MeasureSpec.getMode(0) + 3, (char) (ViewConfiguration.getScrollBarSize() >> 8));
                        Object[] objArr34 = new Object[1];
                        f($$d[8], (byte) ($$d[78] - 1), $$d[53], objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.resolveSizeAndState(0, 0, 0), ImageFormat.getBitsPerPixel(0) + 36, (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-1981545082, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 17, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    protected abstract AlertUtil createAlertUtils(int i);

    @Override // com.alipay.zoloz.zface.ui.activity.BaseCameraPermissionActivity, com.alipay.mobile.security.bio.workspace.BioFragmentContainer, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // com.alipay.zoloz.zface.ui.activity.BaseCameraPermissionActivity, com.alipay.mobile.security.bio.workspace.BioFragmentContainer, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // com.alipay.zoloz.zface.ui.activity.BaseCameraPermissionActivity, com.alipay.mobile.security.bio.workspace.BioFragmentContainer, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    protected boolean isCanUseBack() {
        return true;
    }

    public void onHasPermissionResume() {
    }

    @Override // com.alipay.zoloz.zface.ui.activity.BaseCameraPermissionActivity, com.alipay.mobile.security.bio.workspace.BioFragmentContainer, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            Object[] objArr = new Object[1];
            d(getAuthRequestContext[25], (byte) (-getAuthRequestContext[30]), getAuthRequestContext[9], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            d((byte) (-getAuthRequestContext[5]), getAuthRequestContext[56], getAuthRequestContext[59], objArr2);
            int i = ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion - 15;
            int length = getPackageName().length() - 7;
            try {
                Object[] objArr3 = new Object[1];
                d(getAuthRequestContext[25], (byte) (-getAuthRequestContext[30]), getAuthRequestContext[9], objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                d((byte) (-getAuthRequestContext[5]), getAuthRequestContext[56], getAuthRequestContext[59], new Object[1]);
                Object[] objArr4 = new Object[1];
                e(i, length, (char) (((ApplicationInfo) cls2.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 33), objArr4);
                Class<?> cls3 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                e(super.getResources().getString(R.string.feed_detail_title).substring(2, 7).length() + 0, 18 - (Process.myPid() >> 22), (char) (getPackageName().length() + 43597), objArr5);
                int intValue = ((Integer) cls3.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                if (intValue < 99000 || intValue > 99999) {
                    Context baseContext = getBaseContext();
                    if (baseContext == null) {
                        Object[] objArr6 = new Object[1];
                        e(super.getResources().getString(R.string.warning_insufficient_balance).substring(28, 29).length() + 25, (ViewConfiguration.getPressedStateDuration() >> 16) + 23, (char) (super.getResources().getString(R.string.news_update).substring(4, 5).length() + 37999), objArr6);
                        Class<?> cls4 = Class.forName((String) objArr6[0]);
                        Object[] objArr7 = new Object[1];
                        e((ViewConfiguration.getFadingEdgeLength() >> 16) + 18, getPackageName().length() + 42, (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)), objArr7);
                        baseContext = (Context) cls4.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext != null) {
                        baseContext = baseContext.getApplicationContext();
                    }
                    if (baseContext != null) {
                        try {
                            Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj == null) {
                                obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 'S' - AndroidCharacter.getMirror('0'), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                            }
                            Object invoke = ((Method) obj).invoke(null, null);
                            Object[] objArr8 = new Object[1];
                            e(super.getResources().getString(R.string.buy_text).substring(0, 1).length() + 47, 66 - TextUtils.lastIndexOf("", '0'), (char) (super.getResources().getString(R.string.sendmoney_empty_recent_transaction).substring(30, 31).codePointAt(0) - 32), objArr8);
                            String str = (String) objArr8[0];
                            int codePointAt = super.getResources().getString(R.string.goal_not_set).substring(0, 7).codePointAt(2) - 52;
                            try {
                                Object[] objArr9 = new Object[1];
                                d(getAuthRequestContext[25], (byte) (-getAuthRequestContext[30]), getAuthRequestContext[9], objArr9);
                                Class<?> cls5 = Class.forName((String) objArr9[0]);
                                Object[] objArr10 = new Object[1];
                                d((byte) (-getAuthRequestContext[5]), getAuthRequestContext[56], getAuthRequestContext[59], objArr10);
                                Object[] objArr11 = new Object[1];
                                e(codePointAt, ((ApplicationInfo) cls5.getMethod((String) objArr10[0], null).invoke(this, null)).targetSdkVersion + 82, (char) (super.getResources().getString(R.string.btn_view_other_locations).substring(1, 2).length() + 28150), objArr11);
                                String str2 = (String) objArr11[0];
                                int length2 = getPackageName().length() + 57;
                                int codePointAt2 = super.getResources().getString(R.string.referral_invite_msg).substring(14, 15).codePointAt(0) + 78;
                                try {
                                    Object[] objArr12 = new Object[1];
                                    d(getAuthRequestContext[25], (byte) (-getAuthRequestContext[30]), getAuthRequestContext[9], objArr12);
                                    Class<?> cls6 = Class.forName((String) objArr12[0]);
                                    d((byte) (-getAuthRequestContext[5]), getAuthRequestContext[56], getAuthRequestContext[59], new Object[1]);
                                    Object[] objArr13 = new Object[1];
                                    e(length2, codePointAt2, (char) (((ApplicationInfo) cls6.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 33), objArr13);
                                    String str3 = (String) objArr13[0];
                                    Object[] objArr14 = new Object[1];
                                    e((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 60, super.getResources().getString(R.string.add_new_bills_third_onboarding_subtitle).substring(1, 3).length() + 241, (char) (super.getResources().getString(R.string.desc_empty_search_country).substring(18, 20).codePointAt(0) - 97), objArr14);
                                    String str4 = (String) objArr14[0];
                                    Object[] objArr15 = new Object[1];
                                    e((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 5, 303 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (ExpandableListView.getPackedPositionChild(0L) + 1), objArr15);
                                    try {
                                        Object[] objArr16 = {baseContext, str, str2, str3, str4, true, (String) objArr15[0], 995651014};
                                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                        if (obj2 == null) {
                                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 911, TextUtils.getCapsMode("", 0, 0) + 18, (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                        }
                                        ((Method) obj2).invoke(invoke, objArr16);
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
                        } catch (Throwable th4) {
                            Throwable cause4 = th4.getCause();
                            if (cause4 == null) {
                                throw th4;
                            }
                            throw cause4;
                        }
                    }
                }
                try {
                    byte b = getAuthRequestContext[32];
                    byte b2 = getAuthRequestContext[25];
                    Object[] objArr17 = new Object[1];
                    d(b, b2, (byte) (b2 | 36), objArr17);
                    Class<?> cls7 = Class.forName((String) objArr17[0]);
                    byte b3 = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0 & 56);
                    byte b4 = getAuthRequestContext[25];
                    Object[] objArr18 = new Object[1];
                    d(b3, b4, (byte) (b4 | Ascii.NAK), objArr18);
                    try {
                        Object[] objArr19 = {Integer.valueOf(((Integer) cls7.getMethod((String) objArr18[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                        if (obj3 == null) {
                            Class cls8 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - View.combineMeasuredStates(0, 0), 4 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) ((Process.getThreadPriority(0) + 20) >> 6));
                            Object[] objArr20 = new Object[1];
                            f($$d[8], (byte) ($$d[78] - 1), $$d[53], objArr20);
                            obj3 = cls8.getMethod((String) objArr20[0], Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                        }
                        Object[] objArr21 = (Object[]) ((Method) obj3).invoke(null, objArr19);
                        int i2 = ((int[]) objArr21[1])[0];
                        if (((int[]) objArr21[0])[0] != i2) {
                            long j = ((r2 ^ i2) & 4294967295L) | 42949672960L;
                            try {
                                Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj4 == null) {
                                    obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getPressedStateDuration() >> 16), TextUtils.indexOf("", "", 0, 0) + 35, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                }
                                Object invoke2 = ((Method) obj4).invoke(null, null);
                                try {
                                    Object[] objArr22 = {1612302463, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj5 == null) {
                                        obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 911, ExpandableListView.getPackedPositionType(0L) + 18, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                    }
                                    ((Method) obj5).invoke(invoke2, objArr22);
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
                        super.onCreate(bundle);
                        ConfigCenter.getInstance().setApplicationContext(getApplicationContext());
                        EnvCheck.EnvErrorType check = new EnvCheck().check(false);
                        if (check == EnvCheck.EnvErrorType.ENV_ERROR_LOW_OS) {
                            this.mAlertUtil.alertSystemNotSupport(ZcodeConstants.ZCODE_OS_VERSION_LOW);
                        } else if (check == EnvCheck.EnvErrorType.ENV_ERROR_NO_FRONT_CAMERA) {
                            this.mAlertUtil.alertSystemNotSupport(ZcodeConstants.ZCODE_ERROR_CAMERA_NO_DEVICE);
                        } else if (check == EnvCheck.EnvErrorType.ENV_ERROR_UNSUPPORTED_CPU) {
                            this.mAlertUtil.alertSystemNotSupport(ZcodeConstants.ZCODE_UNSUPPORTED_CPU);
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
        } catch (Throwable th10) {
            Throwable cause10 = th10.getCause();
            if (cause10 == null) {
                throw th10;
            }
            throw cause10;
        }
    }

    @Override // com.alipay.zoloz.zface.ui.activity.BaseCameraPermissionActivity
    public boolean preCheck() {
        BioServiceManager currentInstance = BioServiceManager.getCurrentInstance();
        if (currentInstance == null) {
            new IllegalStateException("null == BioServiceManager.getCurrentInstance()");
            return false;
        }
        this.mAppTag = getIntent().getStringExtra(Constant.BIOLOGY_INTENT_ACTION_INFO);
        updateLanguage(((BioAppManager) currentInstance.getBioService(BioAppManager.class)).getBioAppDescription(this.mAppTag));
        return true;
    }

    private void updateLanguage(BioAppDescription bioAppDescription) {
        updateLocale(bioAppDescription.getExtProperty().get("locale"));
    }

    private void updateLocale(String str) {
        Locale locale;
        if (str != null) {
            try {
                Configuration configuration = getResources().getConfiguration();
                if (str.contains("-")) {
                    String[] split = str.split("-");
                    if (split.length == 2) {
                        locale = new Locale(split[0], split[1]);
                    } else if (split.length == 1) {
                        locale = new Locale(split[0]);
                    } else if (Build.VERSION.SDK_INT >= 24) {
                        locale = getResources().getConfiguration().getLocales().get(0);
                    } else {
                        locale = getResources().getConfiguration().locale;
                    }
                } else {
                    locale = new Locale(str);
                }
                if (Build.VERSION.SDK_INT >= 17) {
                    configuration.setLocale(locale);
                } else {
                    configuration.locale = new Locale(str);
                }
                getBaseContext().getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.alipay.zoloz.zface.ui.activity.BaseCameraPermissionActivity
    public ZFaceBasePresenter createPresenter(ZFaceCallback zFaceCallback, AbsSurfaceView absSurfaceView) {
        String stringExtra = getIntent().getStringExtra(Constant.BIOLOGY_INTENT_ACTION_INFO);
        this.mAppTag = stringExtra;
        ZFacePresenter zFacePresenter = new ZFacePresenter(zFaceCallback, stringExtra, absSurfaceView);
        this.mZFacePresenter = zFacePresenter;
        return zFacePresenter;
    }

    @Override // com.alipay.zoloz.zface.ui.activity.BaseCameraPermissionActivity, com.alipay.mobile.security.bio.workspace.BioFragmentContainer, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            e(getPackageName().length() + 19, getPackageName().length() + 16, (char) (super.getResources().getString(R.string.title_list_linked_accounts).substring(7, 8).length() + 37999), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            e(super.getResources().getString(R.string.card_binding_camera_helper).substring(0, 5).codePointAt(1) - 81, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 50, (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Gravity.getAbsoluteGravity(0, 0), 36 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) ('0' - AndroidCharacter.getMirror('0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), TextUtils.indexOf((CharSequence) "", '0') + 19, (char) Color.argb(0, 0, 0, 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        int screenBrightness = ScreenUtil.getScreenBrightness(this);
        try {
            int light = this.mZFacePresenter.getRemoteConfig().getColl().getLight();
            if (light > screenBrightness) {
                ScreenUtil.setScreenBrightness(this, light);
            }
        } catch (Exception unused) {
        }
        if (this.mIsFirstResume) {
            this.mIsFirstResume = false;
            long timeInterval = TimeRecord.getInstance().getTimeInterval(ZFaceRecordService.ENTER_DETECTION_START);
            HashMap hashMap = new HashMap();
            hashMap.put("timecost", String.valueOf(timeInterval));
            StringBuilder sb = new StringBuilder();
            sb.append(ScreenUtil.getScreenBrightness(this));
            hashMap.put("brightness", sb.toString());
            record(ZFaceRecordService.ENTER_DETECTION_END, hashMap);
        }
        if (this.isPause && !this.mIsUploading && hasPermission()) {
            if (!this.mLastHasPermission) {
                onHasPermissionResume();
                retry(0);
            } else {
                this.mAlertUtil.alertInterruptResume();
            }
        }
        this.isPause = false;
    }

    @Override // com.alipay.zoloz.zface.ui.activity.BaseCameraPermissionActivity, com.alipay.mobile.security.bio.workspace.BioFragmentContainer, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                Object[] objArr = new Object[1];
                d(getAuthRequestContext[25], (byte) (-getAuthRequestContext[30]), getAuthRequestContext[9], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                d((byte) (-getAuthRequestContext[5]), getAuthRequestContext[56], getAuthRequestContext[59], objArr2);
                int i = ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion - 7;
                int codePointAt = super.getResources().getString(R.string.option_done).substring(3, 4).codePointAt(0) - 78;
                try {
                    Object[] objArr3 = new Object[1];
                    d(getAuthRequestContext[25], (byte) (-getAuthRequestContext[30]), getAuthRequestContext[9], objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    Object[] objArr4 = new Object[1];
                    d((byte) (-getAuthRequestContext[5]), getAuthRequestContext[56], getAuthRequestContext[59], objArr4);
                    Object[] objArr5 = new Object[1];
                    e(i, codePointAt, (char) (((ApplicationInfo) cls2.getMethod((String) objArr4[0], null).invoke(this, null)).targetSdkVersion + 37967), objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    e(KeyEvent.keyCodeFromString("") + 18, 49 - Color.green(0), (char) (super.getResources().getString(R.string.dana_viz_prompt_button_skip_dana_viz).substring(1, 2).codePointAt(0) - 65), objArr6);
                    baseContext = (Context) cls3.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
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
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 35, (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr7 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.makeMeasureSpec(0, 0) + 911, View.MeasureSpec.getSize(0) + 18, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr7);
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
        super.onPause();
        this.isPause = true;
        this.mLastHasPermission = hasPermission();
        ZFacePresenter zFacePresenter = this.mZFacePresenter;
        if (zFacePresenter != null) {
            zFacePresenter.stopProcess();
        }
    }

    @Override // com.alipay.mobile.security.bio.workspace.BioFragmentContainer, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        record(ZFaceRecordService.NOTICE_EXIT_SDK, null);
        ZFacePresenter zFacePresenter = this.mZFacePresenter;
        if (zFacePresenter != null) {
            zFacePresenter.release();
        }
        super.onDestroy();
    }

    @Override // com.alipay.zoloz.zface.ui.util.AlertUtil.AlertClickEvents
    public void sendResponse(int i, String str) {
        ZFacePresenter zFacePresenter = this.mZFacePresenter;
        if (zFacePresenter != null) {
            zFacePresenter.sendResponseWithSubcode(i, str, CodeConstants.getMessage(str));
        }
        finish();
    }

    @Override // com.alipay.zoloz.zface.ui.util.AlertUtil.AlertClickEvents
    public void retryUpload() {
        ZFacePresenter zFacePresenter = this.mZFacePresenter;
        if (zFacePresenter != null) {
            zFacePresenter.retryUpload();
        }
    }

    @Override // com.alipay.zoloz.zface.ui.util.AlertUtil.AlertClickEvents
    public void stopProcess() {
        ZFacePresenter zFacePresenter = this.mZFacePresenter;
        if (zFacePresenter != null) {
            zFacePresenter.stopProcess();
        }
    }

    @Override // com.alipay.zoloz.zface.presenter.ZFaceCallback
    public void onFrameComplete() {
        this.mIsUploading = true;
    }

    @Override // com.alipay.zoloz.zface.ui.activity.BaseCameraPermissionActivity, com.alipay.zoloz.zface.presenter.ZFaceCallback
    public void onErrorEvent(AlertData alertData) {
        this.mIsUploading = false;
        super.onErrorEvent(alertData);
    }

    @Override // com.alipay.zoloz.zface.ui.activity.BaseCameraPermissionActivity
    public boolean handleErrorEvnet(AlertData alertData) {
        if (super.handleErrorEvnet(alertData)) {
            return true;
        }
        if (alertData.type == 11) {
            finish();
            return true;
        }
        ZFacePresenter zFacePresenter = this.mZFacePresenter;
        if (zFacePresenter != null) {
            zFacePresenter.stopProcess();
        }
        if (!ZcodeConstants.ZCODE_INIT_TOYGER_ERROR.equals(alertData.subCode) && !ZcodeConstants.ZCODE_ZIM_IS_BUSY.equals(alertData.subCode)) {
            if (ZcodeConstants.NETWORK_TIMEOUT.equals(alertData.subCode) || ZcodeConstants.ZCODE_NETWORK_ERROR.equals(alertData.subCode)) {
                this.mAlertUtil.alertNetworkError();
            } else if (ZcodeConstants.ZCODE_ERROR_CAMERA_OPEN_FAILED.equals(alertData.subCode)) {
                alertCameraOpenFailed();
            } else if (ZcodeConstants.ZCODE_OS_VERSION_LOW.equals(alertData.subCode) || ZcodeConstants.ZCODE_UNSUPPORTED_CPU.equals(alertData.subCode) || ZcodeConstants.ZCODE_NO_FRANT_CAMERA.equals(alertData.subCode) || ZcodeConstants.ZCODE_ERROR_CAMERA_NO_DEVICE.equals(alertData.subCode)) {
                this.mAlertUtil.alertSystemNotSupport(alertData.subCode);
            } else if (ZcodeConstants.ZCODE_OVER_TIME.equals(alertData.subCode)) {
                this.mAlertUtil.alertTimeOut();
            } else if (ZcodeConstants.ZCODE_OUT_TIME.equals(alertData.subCode)) {
                this.mAlertUtil.alertRetryOutTime();
            } else if (ZcodeConstants.ZCODE_USER_BACK.equals(alertData.subCode)) {
                onBackPressed();
            } else if (ZcodeConstants.ZCODE_INTERUPT_RESUME.equals(alertData.subCode)) {
                this.mAlertUtil.alertInterruptResume();
            } else if (!ZcodeConstants.ZCODE_SYSTEM_EXC.equals(alertData.subCode)) {
                if (ZcodeConstants.ZCODE_RETRY_ALERT.equals(alertData.subCode)) {
                    this.mAlertUtil.alertFailRetry();
                } else if (ZcodeConstants.ZCODE_FIRST_LOGIN.equals(alertData.subCode)) {
                    this.mAlertUtil.alertFirstLogin();
                } else if (ZcodeConstants.ZCODE_LIVENESS_ERROR.equals(alertData.subCode)) {
                    this.mAlertUtil.alertLivelessFail();
                } else {
                    this.mAlertUtil.alertSystemError();
                }
            }
            return true;
        }
        this.mAlertUtil.alertSystemError();
        return true;
    }

    @Override // com.alipay.zoloz.zface.presenter.ZFaceCallback
    public int getRetryTimes() {
        AlertUtil alertUtil = this.mAlertUtil;
        if (alertUtil == null) {
            return 1;
        }
        return alertUtil.getRetryTimes();
    }

    @Override // com.alipay.zoloz.zface.ui.activity.BaseCameraPermissionActivity
    public void alertCameraPermissionFailed(DialogInterface.OnClickListener onClickListener) {
        this.mAlertUtil.alertCameraPermissionFailed(onClickListener);
    }

    @Override // com.alipay.zoloz.zface.ui.activity.BaseCameraPermissionActivity
    public void alertCameraOpenFailed() {
        this.mAlertUtil.alertCameraOpenFailed();
    }

    @Override // com.alipay.zoloz.zface.ui.activity.BaseCameraPermissionActivity
    public void onInitView() {
        ZFacePresenter zFacePresenter = this.mZFacePresenter;
        this.mAlertUtil = createAlertUtils(zFacePresenter != null ? zFacePresenter.getRemoteConfig().getColl().getRetry() : 2);
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (isCanUseBack()) {
            dealBackPress();
        }
    }

    private void dealBackPress() {
        boolean z;
        if (this.mIsUploading) {
            return;
        }
        try {
            z = R2.bool.show_exit_dialog();
        } catch (Exception unused) {
            z = true;
        }
        if (z) {
            this.mZFacePresenter.stopProcess();
            this.mAlertUtil.alertBack();
            return;
        }
        ZFacePresenter zFacePresenter = this.mZFacePresenter;
        if (zFacePresenter != null) {
            zFacePresenter.sendResponseWithSubcode(202, CodeConstants.USER_QUITE, CodeConstants.getMessage(CodeConstants.USER_QUITE));
        }
        finish();
    }

    public void record(String str) {
        record(str, null);
    }

    public void record(String str, Map<String, String> map) {
        ZFaceRecordService zFaceRecordService;
        BioServiceManager currentInstance = BioServiceManager.getCurrentInstance();
        if (currentInstance == null || (zFaceRecordService = (ZFaceRecordService) currentInstance.getBioService(ZFaceRecordService.class)) == null) {
            return;
        }
        if (map == null) {
            zFaceRecordService.write(str);
        } else {
            zFaceRecordService.write(str, map);
        }
    }

    private static void e(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i) {
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (getErrorConfigVersion[whenavailable.BuiltInFictitiousFunctionClassFactory + i2] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ scheduleImpl))) ^ c;
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        char[] cArr = new char[i];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i) {
            cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        objArr[0] = new String(cArr);
    }
}
