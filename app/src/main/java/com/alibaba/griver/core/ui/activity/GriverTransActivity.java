package com.alibaba.griver.core.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
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
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.griver.core.keepalive.KeepAliveAppManager;
import com.alibaba.griver.core.ui.activity.GriverBaseActivity;
import com.alibaba.griver.core.utils.H5StatusBarUtils;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.plus.security.lite.SecLiteException;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.firebase.FirebaseError;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.Typography;
import o.A;
import o.B;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;
import o.C;
import o.D;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;
import o.getCallingPid;
import o.getOnBoardingScenario;

/* loaded from: classes3.dex */
public class GriverTransActivity extends GriverBaseActivity {
    public static Class[] ACTIVITY_BACK_CLASSES = null;
    public static Class[] ACTIVITY_CLASSES = null;
    private static char NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
    public static final String TAG = "Griver:NebulaTransActivity";
    private static char lookAheadTest;
    private static char moveToNextValue;
    private static char scheduleImpl;
    public static final byte[] $$d = {99, 56, -99, 122, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$e = 86;
    public static final byte[] PlaceComponentResult = {111, 84, 114, 59, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int getErrorConfigVersion = 9;

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        scheduleImpl = (char) 37159;
        lookAheadTest = (char) 21409;
        moveToNextValue = (char) 10841;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = (char) 2508;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void f(byte r8, short r9, short r10, java.lang.Object[] r11) {
        /*
            int r10 = r10 + 16
            int r8 = r8 + 97
            byte[] r0 = com.alibaba.griver.core.ui.activity.GriverTransActivity.PlaceComponentResult
            int r9 = 56 - r9
            byte[] r1 = new byte[r10]
            r2 = 0
            if (r0 != 0) goto L14
            r8 = r9
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r11
            r11 = r10
            goto L2f
        L14:
            r3 = 0
        L15:
            byte r4 = (byte) r8
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r10) goto L24
            java.lang.String r8 = new java.lang.String
            r8.<init>(r1, r2)
            r11[r2] = r8
            return
        L24:
            r3 = r0[r9]
            r6 = r9
            r9 = r8
            r8 = r6
            r7 = r11
            r11 = r10
            r10 = r3
            r3 = r1
            r1 = r0
            r0 = r7
        L2f:
            int r9 = r9 + r10
            int r9 = r9 + (-4)
            int r8 = r8 + 1
            r10 = r11
            r11 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            r6 = r9
            r9 = r8
            r8 = r6
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverTransActivity.f(byte, short, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void g(byte r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = 47 - r7
            int r8 = r8 * 3
            int r8 = 42 - r8
            int r6 = r6 * 2
            int r6 = 103 - r6
            byte[] r0 = com.alibaba.griver.core.ui.activity.GriverTransActivity.$$d
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L32
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L32:
            int r7 = r7 + 1
            int r8 = -r8
            int r6 = r6 + r8
            int r6 = r6 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverTransActivity.g(byte, byte, short, java.lang.Object[]):void");
    }

    @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        e(TextUtils.lastIndexOf("", '0', 0) + 19, new char[]{15674, 55942, 28019, 11151, 58038, 22281, 59115, 65459, 56482, 65274, 6622, 49160, 48754, 28365, 54207, 35996, 47265, 60640}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        e(5 - (ViewConfiguration.getScrollBarSize() >> 8), new char[]{23303, 15627, 19139, 40740, 42490, 9873}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, View.MeasureSpec.getSize(0) + 35, (char) ((-1) - TextUtils.lastIndexOf("", '0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    e((ViewConfiguration.getWindowTouchSlop() >> 8) + 48, new char[]{17182, 49582, 57305, 10497, 8039, 47575, 11628, 46890, 49150, 47961, 2445, 13098, 15794, 12984, 58690, 12393, 56987, 246, 5445, 35246, 19092, 4600, 56984, 24250, 9531, 3971, 28575, 29105, 3261, 10284, 16059, 37601, 11179, 42545, 37654, 11801, 30739, 3748, 19950, 37648, 60452, 37071, 32716, 20333, 56829, 3632, 14765, 25351}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    e((Process.myTid() >> 22) + 64, new char[]{43393, 41595, 57410, 19606, 30739, 3748, 45089, 8053, 19092, 4600, 42047, 4583, 61785, 59077, 21635, 62389, 16085, 46269, 46717, 9860, 61785, 59077, 33067, 1558, 25274, 7196, 22392, 4621, 28575, 29105, 16085, 46269, 19661, 31158, 48951, 38817, 57513, 54239, 57334, 8891, 59128, 61574, 11894, 1149, 20751, 40494, 60649, 7361, 17900, 4162, 27604, 53467, 54779, 63044, 19030, 34450, 19030, 34450, 1120, 19412, 34817, 29528, 9531, 3971}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    e((ViewConfiguration.getEdgeSlop() >> 16) + 64, new char[]{31473, 4586, 20713, 53857, 54779, 63044, 42696, 42871, 30997, 59897, 37360, 44026, 18517, 33907, 36310, 11504, 16059, 37601, 59148, 36398, 40684, 38720, 3346, 38354, 60452, 37071, 11628, 46890, 48629, 31161, 17182, 49582, 57324, 45536, 23981, 23334, 14732, 33055, 57305, 10497, 62777, 17184, 21635, 62389, 19950, 37648, 16224, 47418, 30739, 3748, 54207, 35996, 31473, 4586, 51755, 23390, 50739, 28516, 11179, 42545, 51755, 23390, 42833, 20651}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    e((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 59, new char[]{54352, 60805, 6669, 32595, 6123, 4695, 30575, 20589, 15314, 21937, 49745, 12245, 56805, 42732, 11860, 54682, 11725, 33340, 7438, 29123, 8300, 10901, 58984, 8630, 28191, 15058, 55745, 61077, 24751, 60393, 37542, 21673, 55745, 61077, Typography.doubleDagger, 15899, 21784, 48574, 20735, 1464, 26120, 55736, 9123, 35038, 5843, 63756, 34007, 264, 39661, 9109, 46848, 29916, 25275, 2128, 2973, 33161, 57049, 6797, 26985, 51015}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    e(TextUtils.lastIndexOf("", '0', 0, 0) + 7, new char[]{49708, 14297, 16626, 62753, 31473, 4586}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + 911, ExpandableListView.getPackedPositionChild(0L) + 19, (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                Object[] objArr13 = {this};
                Object[] objArr14 = new Object[1];
                f((byte) getErrorConfigVersion, PlaceComponentResult[31], PlaceComponentResult[25], objArr14);
                Class<?> cls2 = Class.forName((String) objArr14[0]);
                byte b = (byte) (getErrorConfigVersion - 1);
                Object[] objArr15 = new Object[1];
                f(b, (byte) (b | 22), PlaceComponentResult[25], objArr15);
                try {
                    Object[] objArr16 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr15[0], Object.class).invoke(null, objArr13)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + 55, ExpandableListView.getPackedPositionChild(0L) + 4, (char) (ViewConfiguration.getPressedStateDuration() >> 16));
                        Object[] objArr17 = new Object[1];
                        g((byte) (-$$d[12]), (byte) (-$$d[53]), $$d[68], objArr17);
                        obj3 = cls3.getMethod((String) objArr17[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr16);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + 800, (ViewConfiguration.getFadingEdgeLength() >> 16) + 15, (char) Color.alpha(0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, 16 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) (TextUtils.indexOf((CharSequence) "", '0') + 1))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr18 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getWindowTouchSlop() >> 8) + 815, 29 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 15, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr18));
                                    long j = ((r9 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), 35 - TextUtils.getOffsetBefore("", 0), (char) Color.blue(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr19 = {-141908500, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.blue(0), (-16777198) - Color.rgb(0, 0, 0), (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj8);
                                            }
                                            ((Method) obj8).invoke(invoke3, objArr19);
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
                Object[] objArr20 = {this};
                Object[] objArr21 = new Object[1];
                f((byte) getErrorConfigVersion, PlaceComponentResult[31], PlaceComponentResult[25], objArr21);
                Class<?> cls4 = Class.forName((String) objArr21[0]);
                byte b2 = (byte) (getErrorConfigVersion - 1);
                Object[] objArr22 = new Object[1];
                f(b2, (byte) (b2 | 22), PlaceComponentResult[25], objArr22);
                try {
                    Object[] objArr23 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr22[0], Object.class).invoke(null, objArr20)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + 61, (Process.myPid() >> 22) + 46, (char) (TextUtils.lastIndexOf("", '0', 0) + 1));
                        Object[] objArr24 = new Object[1];
                        g((byte) ($$d[47] - 1), $$d[20], (byte) (-$$d[8]), objArr24);
                        obj9 = cls5.getMethod((String) objArr24[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr25 = (Object[]) ((Method) obj9).invoke(null, objArr23);
                    int i = ((int[]) objArr25[1])[0];
                    if (((int[]) objArr25[0])[0] != i) {
                        long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 34, (char) KeyEvent.keyCodeFromString(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr26 = {-141908500, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + 911, 18 - (ViewConfiguration.getTapTimeout() >> 16), (char) TextUtils.getTrimmedLength(""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr26);
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
                Object[] objArr27 = {this};
                Object[] objArr28 = new Object[1];
                f((byte) getErrorConfigVersion, PlaceComponentResult[31], PlaceComponentResult[25], objArr28);
                Class<?> cls6 = Class.forName((String) objArr28[0]);
                byte b3 = (byte) (getErrorConfigVersion - 1);
                Object[] objArr29 = new Object[1];
                f(b3, (byte) (b3 | 22), PlaceComponentResult[25], objArr29);
                try {
                    Object[] objArr30 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr29[0], Object.class).invoke(null, objArr27)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 4, (char) (38969 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))));
                        Object[] objArr31 = new Object[1];
                        g((byte) ($$d[47] - 1), $$d[20], (byte) (-$$d[8]), objArr31);
                        obj12 = cls7.getMethod((String) objArr31[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr32 = (Object[]) ((Method) obj12).invoke(null, objArr30);
                    int i2 = ((int[]) objArr32[1])[0];
                    if (((int[]) objArr32[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.blue(0), View.MeasureSpec.makeMeasureSpec(0, 0) + 35, (char) (Process.myPid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr33 = {-141908500, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 912, MotionEvent.axisFromString("") + 19, (char) View.getDefaultSize(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr33);
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
                Object[] objArr34 = {this};
                Object[] objArr35 = new Object[1];
                f((byte) getErrorConfigVersion, PlaceComponentResult[31], PlaceComponentResult[25], objArr35);
                Class<?> cls8 = Class.forName((String) objArr35[0]);
                byte b4 = (byte) (getErrorConfigVersion - 1);
                Object[] objArr36 = new Object[1];
                f(b4, (byte) (b4 | 22), PlaceComponentResult[25], objArr36);
                try {
                    Object[] objArr37 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr36[0], Object.class).invoke(null, objArr34)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + 107, View.resolveSize(0, 0) + 3, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16));
                        byte b5 = (byte) (-$$d[9]);
                        byte b6 = (byte) ($$d[47] - 1);
                        Object[] objArr38 = new Object[1];
                        g(b5, b6, b6, objArr38);
                        obj15 = cls9.getMethod((String) objArr38[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr39 = (Object[]) ((Method) obj15).invoke(null, objArr37);
                    int i3 = ((int[]) objArr39[1])[0];
                    if (((int[]) objArr39[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.green(0), ExpandableListView.getPackedPositionGroup(0L) + 35, (char) View.getDefaultSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr40 = {-141908500, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.resolveSizeAndState(0, 0, 0), 18 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) TextUtils.indexOf("", ""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr40);
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

    @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        try {
            byte b = PlaceComponentResult[25];
            Object[] objArr2 = new Object[1];
            f(b, (byte) (b | TarHeader.LF_BLK), (byte) (-PlaceComponentResult[30]), objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            f((byte) (-PlaceComponentResult[5]), PlaceComponentResult[25], PlaceComponentResult[56], new Object[1]);
            Object[] objArr3 = new Object[1];
            e(((ApplicationInfo) cls.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 15, new char[]{15674, 55942, 28019, 11151, 58038, 22281, 59115, 65459, 56482, 65274, 6622, 49160, 48754, 28365, 54207, 35996, 47265, 60640}, objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            e(5 - (KeyEvent.getMaxKeyCode() >> 16), new char[]{23303, 15627, 19139, 40740, 42490, 9873}, objArr4);
            int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr5 = new Object[1];
                    e(super.getResources().getString(R.string.passkey_maybe_later).substring(1, 2).codePointAt(0) - 71, new char[]{15674, 55942, 28019, 11151, 58038, 22281, 59115, 65459, 26120, 55736, 39751, 46907, 49853, 61969, 8821, 38760, 58800, 40889, 53523, 38335, 11286, 16750, 5376, 11374, 4212, 20166}, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    e(super.getResources().getString(R.string.note_title).substring(2, 3).codePointAt(0) - 98, new char[]{48759, 46581, 53771, 16358, 57049, 6797, 60048, 26898, 58206, 32444, 40513, 10524, 900, 18343, 8821, 38760, 40690, 30857}, objArr6);
                    baseContext = (Context) cls3.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), 35 - (KeyEvent.getMaxKeyCode() >> 16), (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        e((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 48, new char[]{17182, 49582, 57305, 10497, 8039, 47575, 11628, 46890, 49150, 47961, 2445, 13098, 15794, 12984, 58690, 12393, 56987, 246, 5445, 35246, 19092, 4600, 56984, 24250, 9531, 3971, 28575, 29105, 3261, 10284, 16059, 37601, 11179, 42545, 37654, 11801, 30739, 3748, 19950, 37648, 60452, 37071, 32716, 20333, 56829, 3632, 14765, 25351}, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        e(super.getResources().getString(R.string.merchant_label_discount).substring(0, 13).length() + 51, new char[]{43393, 41595, 57410, 19606, 30739, 3748, 45089, 8053, 19092, 4600, 42047, 4583, 61785, 59077, 21635, 62389, 16085, 46269, 46717, 9860, 61785, 59077, 33067, 1558, 25274, 7196, 22392, 4621, 28575, 29105, 16085, 46269, 19661, 31158, 48951, 38817, 57513, 54239, 57334, 8891, 59128, 61574, 11894, 1149, 20751, 40494, 60649, 7361, 17900, 4162, 27604, 53467, 54779, 63044, 19030, 34450, 19030, 34450, 1120, 19412, 34817, 29528, 9531, 3971}, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        e(super.getResources().getString(R.string.option_yes).substring(0, 1).length() + 63, new char[]{31473, 4586, 20713, 53857, 54779, 63044, 42696, 42871, 30997, 59897, 37360, 44026, 18517, 33907, 36310, 11504, 16059, 37601, 59148, 36398, 40684, 38720, 3346, 38354, 60452, 37071, 11628, 46890, 48629, 31161, 17182, 49582, 57324, 45536, 23981, 23334, 14732, 33055, 57305, 10497, 62777, 17184, 21635, 62389, 19950, 37648, 16224, 47418, 30739, 3748, 54207, 35996, 31473, 4586, 51755, 23390, 50739, 28516, 11179, 42545, 51755, 23390, 42833, 20651}, objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        e(super.getResources().getString(R.string.error_merchant_list_description).substring(4, 5).length() + 59, new char[]{54352, 60805, 6669, 32595, 6123, 4695, 30575, 20589, 15314, 21937, 49745, 12245, 56805, 42732, 11860, 54682, 11725, 33340, 7438, 29123, 8300, 10901, 58984, 8630, 28191, 15058, 55745, 61077, 24751, 60393, 37542, 21673, 55745, 61077, Typography.doubleDagger, 15899, 21784, 48574, 20735, 1464, 26120, 55736, 9123, 35038, 5843, 63756, 34007, 264, 39661, 9109, 46848, 29916, 25275, 2128, 2973, 33161, 57049, 6797, 26985, 51015}, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        e((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 5, new char[]{49708, 14297, 16626, 62753, 31473, 4586}, objArr11);
                        try {
                            Object[] objArr12 = {baseContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getTrimmedLength("") + 911, TextUtils.getCapsMode("", 0, 0) + 18, (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
            try {
                Object[] objArr13 = new Object[1];
                f((byte) getErrorConfigVersion, PlaceComponentResult[31], PlaceComponentResult[25], objArr13);
                Class<?> cls4 = Class.forName((String) objArr13[0]);
                byte b2 = (byte) (getErrorConfigVersion - 1);
                Object[] objArr14 = new Object[1];
                f(b2, (byte) (b2 | 22), PlaceComponentResult[25], objArr14);
                try {
                    Object[] objArr15 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionGroup(0L) + 494, 4 - TextUtils.indexOf("", "", 0), (char) (Process.getGidForName("") + 1));
                        byte b3 = (byte) (-$$d[9]);
                        byte b4 = (byte) ($$d[47] - 1);
                        Object[] objArr16 = new Object[1];
                        g(b3, b4, b4, objArr16);
                        obj3 = cls5.getMethod((String) objArr16[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr17 = (Object[]) ((Method) obj3).invoke(null, objArr15);
                    int i = ((int[]) objArr17[1])[0];
                    if (((int[]) objArr17[0])[0] != i) {
                        long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (ViewConfiguration.getFadingEdgeLength() >> 16) + 35, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr18 = {1190410077, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + 912, (ViewConfiguration.getWindowTouchSlop() >> 8) + 18, (char) Drawable.resolveOpacity(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr18);
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
        } catch (Throwable th7) {
            Throwable cause7 = th7.getCause();
            if (cause7 == null) {
                throw th7;
            }
            throw cause7;
        }
    }

    @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            e(super.getResources().getString(R.string.profile_completion_task_description_security_question).substring(1, 2).length() + 25, new char[]{15674, 55942, 28019, 11151, 58038, 22281, 59115, 65459, 26120, 55736, 39751, 46907, 49853, 61969, 8821, 38760, 58800, 40889, 53523, 38335, 11286, 16750, 5376, 11374, 4212, 20166}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            e(super.getResources().getString(R.string.device_limit_error_title_page).substring(7, 8).codePointAt(0) - 14, new char[]{48759, 46581, 53771, 16358, 57049, 6797, 60048, 26898, 58206, 32444, 40513, 10524, 900, 18343, 8821, 38760, 40690, 30857}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getOffsetAfter("", 0), 35 - TextUtils.getOffsetBefore("", 0), (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 910, 17 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) TextUtils.getOffsetBefore("", 0))).getMethod("MyBillsEntityDataFactory", Context.class);
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
    }

    @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            e(25 - TextUtils.lastIndexOf("", '0', 0, 0), new char[]{15674, 55942, 28019, 11151, 58038, 22281, 59115, 65459, 26120, 55736, 39751, 46907, 49853, 61969, 8821, 38760, 58800, 40889, 53523, 38335, 11286, 16750, 5376, 11374, 4212, 20166}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                byte b = PlaceComponentResult[25];
                Object[] objArr2 = new Object[1];
                f(b, (byte) (b | TarHeader.LF_BLK), (byte) (-PlaceComponentResult[30]), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                f((byte) (-PlaceComponentResult[5]), PlaceComponentResult[25], PlaceComponentResult[56], new Object[1]);
                Object[] objArr3 = new Object[1];
                e(((ApplicationInfo) cls2.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 15, new char[]{48759, 46581, 53771, 16358, 57049, 6797, 60048, 26898, 58206, 32444, 40513, 10524, 900, 18343, 8821, 38760, 40690, 30857}, objArr3);
                baseContext = (Context) cls.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getEdgeSlop() >> 16), (char) TextUtils.indexOf("", ""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + 911, 19 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr4);
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
        super.onResume();
    }

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        ACTIVITY_CLASSES = new Class[]{Lite1.class, Lite2.class, Lite3.class};
        ACTIVITY_BACK_CLASSES = new Class[]{Back1.class, Back2.class, Back3.class, Back4.class, Back5.class, Back6.class};
    }

    private static void a(Activity activity, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        try {
            if (BundleUtils.getBoolean(extras, RVParams.TRANS_ANIMATE, false)) {
                H5StatusBarUtils.setTransparentColor(activity, 855638016);
            }
            H5StatusBarUtils.setTransparentColor(activity, -16777216);
        } catch (Exception e) {
            RVLogger.e(TAG, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Activity activity) {
        if (activity.isFinishing()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 26) {
            activity.setRequestedOrientation(1);
        }
        a(activity, activity.getIntent());
    }

    /* loaded from: classes6.dex */
    public static class Main extends GriverBaseActivity.Main {
        public static final byte[] $$g = {TarHeader.LF_DIR, -98, 98, -100, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
        public static final int $$h = 74;
        public static final byte[] NetworkUserEntityData$$ExternalSyntheticLambda0 = {11, 41, -68, -59, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
        public static final int lookAheadTest = 71;
        private static char[] scheduleImpl = {39898, 39887, 39897, 39883, 39884, 39890, 39823, 39880, 39917, 39896, 39894, 39886, 39874, 39910, 39885, 39930, 39881, 39879, 39913, 39893, 39878, 39889, 39812, 39815, 39813, 39821, 39810, 39895, 39819, 39818, 39816, 39817, 39899, 39814, 39811, 39820, 39892, 39882};
        private static boolean DatabaseTableConfigUtil = true;
        private static boolean GetContactSyncConfig = true;
        private static int getErrorConfigVersion = 909155261;

        /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0028). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void j(short r6, int r7, byte r8, java.lang.Object[] r9) {
            /*
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverTransActivity.Main.NetworkUserEntityData$$ExternalSyntheticLambda0
                int r6 = 23 - r6
                int r7 = 55 - r7
                int r8 = r8 + 97
                byte[] r1 = new byte[r6]
                r2 = 0
                if (r0 != 0) goto L11
                r4 = r8
                r3 = 0
                r8 = r7
                goto L28
            L11:
                r3 = 0
            L12:
                int r7 = r7 + 1
                byte r4 = (byte) r8
                r1[r3] = r4
                int r3 = r3 + 1
                if (r3 != r6) goto L23
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L23:
                r4 = r0[r7]
                r5 = r8
                r8 = r7
                r7 = r5
            L28:
                int r7 = r7 + r4
                int r7 = r7 + (-4)
                r5 = r8
                r8 = r7
                r7 = r5
                goto L12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverTransActivity.Main.j(short, int, byte, java.lang.Object[]):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0028). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void k(int r5, short r6, byte r7, java.lang.Object[] r8) {
            /*
                int r5 = r5 * 2
                int r5 = r5 + 75
                int r6 = r6 + 4
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverTransActivity.Main.$$g
                int r7 = r7 * 3
                int r7 = 42 - r7
                byte[] r1 = new byte[r7]
                int r7 = r7 + (-1)
                r2 = 0
                if (r0 != 0) goto L16
                r4 = r6
                r3 = 0
                goto L28
            L16:
                r3 = 0
            L17:
                byte r4 = (byte) r5
                r1[r3] = r4
                if (r3 != r7) goto L24
                java.lang.String r5 = new java.lang.String
                r5.<init>(r1, r2)
                r8[r2] = r5
                return
            L24:
                int r3 = r3 + 1
                r4 = r0[r6]
            L28:
                int r6 = r6 + 1
                int r5 = r5 + r4
                int r5 = r5 + (-7)
                goto L17
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverTransActivity.Main.k(int, short, byte, java.lang.Object[]):void");
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Main, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            Object[] objArr;
            Object[] objArr2;
            Object[] objArr3;
            Object[] objArr4;
            super.attachBaseContext(context);
            Object[] objArr5 = new Object[1];
            h(null, 128 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), new byte[]{-120, -120, -117, -118, -123, -124, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr5);
            Class<?> cls = Class.forName((String) objArr5[0]);
            Object[] objArr6 = new Object[1];
            h(null, 127 - Color.alpha(0), new byte[]{-125, -122, -114, -115, -116}, null, objArr6);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context applicationContext = context != null ? context.getApplicationContext() : context;
                if (applicationContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 35 - Color.argb(0, 0, 0, 0), (char) View.MeasureSpec.getMode(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        h(null, 127 - View.resolveSize(0, 0), new byte[]{-117, -104, -97, -95, -104, -96, -100, -105, -102, -103, -101, -100, -101, -99, -104, -101, -117, -127, -125, -99, -125, -103, -97, -125, -104, -118, -118, -125, -127, -104, -98, -98, -104, -98, -99, -117, -100, -118, -117, -105, -103, -101, -125, -102, -103, -104, -118, -105}, null, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        h(null, Color.rgb(0, 0, 0) + 16777343, new byte[]{-97, -125, -103, -98, -95, -118, -98, -102, -98, -102, -105, -101, -101, -105, -97, -97, -105, -98, -105, -118, -98, -117, -102, -94, -97, -102, -118, -118, -103, -96, -125, -118, -99, -99, -125, -103, -117, -101, -95, -104, -97, -104, -98, -125, -98, -100, -99, -99, -96, -98, -98, -125, -94, -101, -118, -125, -103, -102, -101, -100, -125, -104, -94, -127}, null, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        h(null, ((byte) KeyEvent.getModifierMetaStateMask()) + 128, new byte[]{-101, -94, -94, -100, -104, -101, -94, -105, -94, -100, -98, -99, -117, -118, -101, -100, -95, -127, -102, -103, -96, -98, -100, -103, -103, -104, -105, -95, -103, -99, -125, -105, -118, -105, -100, -100, -103, -101, -100, -105, -97, -127, -95, -99, -125, -96, -117, -127, -105, -102, -97, -98, -98, -103, -103, -103, -96, -99, -105, -101, -95, -117, -98, -99}, null, objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        h(null, 127 - TextUtils.getTrimmedLength(""), new byte[]{-120, -111, -126, -117, -110, -117, -92, -99, -110, -92, -111, -120, -117, -91, -126, -122, -92, -122, -113, -127, -92, -116, -123, -118, -121, -117, -124, -127, -107, -90, -120, -125, -124, -127, -107, -91, -121, -111, -120, -127, -118, -111, -127, -117, -124, -108, -111, -121, -127, -126, -127, -125, -92, -92, -93, -120, -113, -111, -111, -108}, null, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        h(null, 128 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), new byte[]{-98, -99, -121, -96, -121, -101}, null, objArr11);
                        try {
                            Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 912, 17 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                    Object[] objArr13 = new Object[1];
                    j((byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), NetworkUserEntityData$$ExternalSyntheticLambda0[31], NetworkUserEntityData$$ExternalSyntheticLambda0[32], objArr13);
                    Class<?> cls2 = Class.forName((String) objArr13[0]);
                    byte b = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]);
                    byte b2 = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[34] + 1);
                    Object[] objArr14 = new Object[1];
                    j(b, b2, (byte) (b2 & 40), objArr14);
                    try {
                        Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                        if (obj3 == null) {
                            Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + 55, TextUtils.getTrimmedLength("") + 3, (char) (ViewConfiguration.getPressedStateDuration() >> 16));
                            byte b3 = $$g[78];
                            Object[] objArr16 = new Object[1];
                            k(b3, (byte) (b3 - 1), $$g[31], objArr16);
                            obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                        }
                        Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, 16 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("getAuthRequestContext", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                            }
                            int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                            try {
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 800, KeyEvent.keyCodeFromString("") + 15, (char) (Process.myPid() >> 22))).getMethod("PlaceComponentResult", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                                }
                                if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                    ArrayList arrayList = new ArrayList();
                                    try {
                                        Object[] objArr17 = {invoke2};
                                        Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                        if (obj6 == null) {
                                            obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + 815, 28 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) (57994 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getTouchSlop() >> 8), 16 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1)));
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                        }
                                        arrayList.add(((Method) obj6).invoke(null, objArr17));
                                        long j = ((r4 ^ intValue2) & 4294967295L) | 60129542144L;
                                        try {
                                            Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                            if (obj7 != null) {
                                                objArr = null;
                                            } else {
                                                objArr = null;
                                                obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0', 0), Color.blue(0) + 35, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                            }
                                            Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                            try {
                                                Object[] objArr18 = {-1595656427, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                                Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                                if (obj8 == null) {
                                                    obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778127, View.combineMeasuredStates(0, 0) + 18, (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    Object[] objArr19 = new Object[1];
                    j((byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), NetworkUserEntityData$$ExternalSyntheticLambda0[31], NetworkUserEntityData$$ExternalSyntheticLambda0[32], objArr19);
                    Class<?> cls4 = Class.forName((String) objArr19[0]);
                    byte b4 = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]);
                    byte b5 = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[34] + 1);
                    Object[] objArr20 = new Object[1];
                    j(b4, b5, (byte) (b5 & 40), objArr20);
                    try {
                        Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                        Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                        if (obj9 == null) {
                            Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myPid() >> 22) + 61, 45 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (Process.myTid() >> 22));
                            Object[] objArr22 = new Object[1];
                            k($$g[9], (byte) ($$g[23] - 1), $$g[8], objArr22);
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
                                    obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, TextUtils.getTrimmedLength("") + 35, (char) KeyEvent.keyCodeFromString(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                                }
                                Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                                try {
                                    Object[] objArr24 = {-1595656427, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj11 == null) {
                                        obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.combineMeasuredStates(0, 0), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 18, (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    Object[] objArr25 = new Object[1];
                    j((byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), NetworkUserEntityData$$ExternalSyntheticLambda0[31], NetworkUserEntityData$$ExternalSyntheticLambda0[32], objArr25);
                    Class<?> cls6 = Class.forName((String) objArr25[0]);
                    byte b6 = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]);
                    byte b7 = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[34] + 1);
                    Object[] objArr26 = new Object[1];
                    j(b6, b7, (byte) (b7 & 40), objArr26);
                    try {
                        Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                        Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                        if (obj12 == null) {
                            Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + 118, KeyEvent.getDeadChar(0, 0) + 3, (char) (38968 - (ViewConfiguration.getTapTimeout() >> 16)));
                            Object[] objArr28 = new Object[1];
                            k($$g[9], (byte) ($$g[23] - 1), $$g[8], objArr28);
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
                                    obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 881, 34 - TextUtils.indexOf((CharSequence) "", '0'), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                                }
                                Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                                try {
                                    Object[] objArr30 = {-1595656427, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj14 == null) {
                                        obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 18 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) ('0' - AndroidCharacter.getMirror('0')))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    Object[] objArr31 = new Object[1];
                    j((byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), NetworkUserEntityData$$ExternalSyntheticLambda0[31], NetworkUserEntityData$$ExternalSyntheticLambda0[32], objArr31);
                    Class<?> cls8 = Class.forName((String) objArr31[0]);
                    byte b8 = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]);
                    byte b9 = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[34] + 1);
                    Object[] objArr32 = new Object[1];
                    j(b8, b9, (byte) (b9 & 40), objArr32);
                    try {
                        Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                        Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                        if (obj15 == null) {
                            Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(106 - ((byte) KeyEvent.getModifierMetaStateMask()), 3 - TextUtils.getCapsMode("", 0, 0), (char) Color.blue(0));
                            Object[] objArr34 = new Object[1];
                            k((byte) ($$g[78] - 1), $$g[53], (byte) ($$g[78] - 1), objArr34);
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
                                    obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - ((byte) KeyEvent.getModifierMetaStateMask()), TextUtils.indexOf((CharSequence) "", '0') + 36, (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                                }
                                Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                                try {
                                    Object[] objArr36 = {-1595656427, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj17 == null) {
                                        obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0'), 18 - Color.blue(0), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Main, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return super.getApplicationContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Main, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
        public Context getBaseContext() {
            return super.getBaseContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Main, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
        public Resources getResources() {
            return super.getResources();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Main, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onPause() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr = new Object[1];
                h(null, getPackageName().codePointAt(4) + 30, new byte[]{-125, -127, -117, -124, -108, -109, -115, -111, -122, -110, -122, -111, -118, -112, -121, -113, -113, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                h(null, getPackageName().length() + 120, new byte[]{-126, -123, -122, -111, -127, -118, -122, -106, -113, -113, -112, -111, -126, -117, -124, -124, -107, -118}, null, objArr2);
                baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.indexOf("", "") + 35, (char) Drawable.resolveOpacity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr3 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 910, 19 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("MyBillsEntityDataFactory", Context.class);
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
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Main, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onResume() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr = new Object[1];
                h(null, (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 127, new byte[]{-125, -127, -117, -124, -108, -109, -115, -111, -122, -110, -122, -111, -118, -112, -121, -113, -113, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                h(null, 127 - TextUtils.indexOf("", "", 0, 0), new byte[]{-126, -123, -122, -111, -127, -118, -122, -106, -113, -113, -112, -111, -126, -117, -124, -124, -107, -118}, null, objArr2);
                baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ExpandableListView.getPackedPositionGroup(0L), TextUtils.getCapsMode("", 0, 0) + 35, (char) (Process.myTid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr3 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getJumpTapTimeout() >> 16), 18 - KeyEvent.keyCodeFromString(""), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Main, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle bundle) {
            Object[] objArr;
            Object[] objArr2 = new Object[1];
            h(null, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 128, new byte[]{-120, -120, -117, -118, -123, -124, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            h(null, 128 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), new byte[]{-125, -122, -114, -115, -116}, null, objArr3);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    try {
                        byte b = NetworkUserEntityData$$ExternalSyntheticLambda0[25];
                        Object[] objArr4 = new Object[1];
                        j(b, (byte) (b | TarHeader.LF_BLK), NetworkUserEntityData$$ExternalSyntheticLambda0[25], objArr4);
                        Class<?> cls2 = Class.forName((String) objArr4[0]);
                        Object[] objArr5 = new Object[1];
                        j(NetworkUserEntityData$$ExternalSyntheticLambda0[27], NetworkUserEntityData$$ExternalSyntheticLambda0[25], (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[5]), objArr5);
                        Object[] objArr6 = new Object[1];
                        h(null, ((ApplicationInfo) cls2.getMethod((String) objArr5[0], null).invoke(this, null)).targetSdkVersion + 94, new byte[]{-125, -127, -117, -124, -108, -109, -115, -111, -122, -110, -122, -111, -118, -112, -121, -113, -113, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr6);
                        Class<?> cls3 = Class.forName((String) objArr6[0]);
                        Object[] objArr7 = new Object[1];
                        h(null, super.getResources().getString(R.string.tooltip_home_scan_desc).substring(0, 4).length() + 123, new byte[]{-126, -123, -122, -111, -127, -118, -122, -106, -113, -113, -112, -111, -126, -117, -124, -124, -107, -118}, null, objArr7);
                        baseContext = (Context) cls3.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.blue(0), (ViewConfiguration.getTouchSlop() >> 8) + 35, (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr8 = new Object[1];
                        h(null, (Process.myPid() >> 22) + 127, new byte[]{-117, -104, -97, -95, -104, -96, -100, -105, -102, -103, -101, -100, -101, -99, -104, -101, -117, -127, -125, -99, -125, -103, -97, -125, -104, -118, -118, -125, -127, -104, -98, -98, -104, -98, -99, -117, -100, -118, -117, -105, -103, -101, -125, -102, -103, -104, -118, -105}, null, objArr8);
                        String str = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        h(null, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 127, new byte[]{-97, -125, -103, -98, -95, -118, -98, -102, -98, -102, -105, -101, -101, -105, -97, -97, -105, -98, -105, -118, -98, -117, -102, -94, -97, -102, -118, -118, -103, -96, -125, -118, -99, -99, -125, -103, -117, -101, -95, -104, -97, -104, -98, -125, -98, -100, -99, -99, -96, -98, -98, -125, -94, -101, -118, -125, -103, -102, -101, -100, -125, -104, -94, -127}, null, objArr9);
                        String str2 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        h(null, 127 - (ViewConfiguration.getScrollDefaultDelay() >> 16), new byte[]{-101, -94, -94, -100, -104, -101, -94, -105, -94, -100, -98, -99, -117, -118, -101, -100, -95, -127, -102, -103, -96, -98, -100, -103, -103, -104, -105, -95, -103, -99, -125, -105, -118, -105, -100, -100, -103, -101, -100, -105, -97, -127, -95, -99, -125, -96, -117, -127, -105, -102, -97, -98, -98, -103, -103, -103, -96, -99, -105, -101, -95, -117, -98, -99}, null, objArr10);
                        String str3 = (String) objArr10[0];
                        try {
                            byte b2 = NetworkUserEntityData$$ExternalSyntheticLambda0[25];
                            Object[] objArr11 = new Object[1];
                            j(b2, (byte) (b2 | TarHeader.LF_BLK), NetworkUserEntityData$$ExternalSyntheticLambda0[25], objArr11);
                            Class<?> cls4 = Class.forName((String) objArr11[0]);
                            Object[] objArr12 = new Object[1];
                            j(NetworkUserEntityData$$ExternalSyntheticLambda0[27], NetworkUserEntityData$$ExternalSyntheticLambda0[25], (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[5]), objArr12);
                            Object[] objArr13 = new Object[1];
                            h(null, ((ApplicationInfo) cls4.getMethod((String) objArr12[0], null).invoke(this, null)).targetSdkVersion + 94, new byte[]{-120, -111, -126, -117, -110, -117, -92, -99, -110, -92, -111, -120, -117, -91, -126, -122, -92, -122, -113, -127, -92, -116, -123, -118, -121, -117, -124, -127, -107, -90, -120, -125, -124, -127, -107, -91, -121, -111, -120, -127, -118, -111, -127, -117, -124, -108, -111, -121, -127, -126, -127, -125, -92, -92, -93, -120, -113, -111, -111, -108}, null, objArr13);
                            String str4 = (String) objArr13[0];
                            try {
                                byte b3 = NetworkUserEntityData$$ExternalSyntheticLambda0[25];
                                Object[] objArr14 = new Object[1];
                                j(b3, (byte) (b3 | TarHeader.LF_BLK), NetworkUserEntityData$$ExternalSyntheticLambda0[25], objArr14);
                                Class<?> cls5 = Class.forName((String) objArr14[0]);
                                Object[] objArr15 = new Object[1];
                                j(NetworkUserEntityData$$ExternalSyntheticLambda0[27], NetworkUserEntityData$$ExternalSyntheticLambda0[25], (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[5]), objArr15);
                                Object[] objArr16 = new Object[1];
                                h(null, ((ApplicationInfo) cls5.getMethod((String) objArr15[0], null).invoke(this, null)).targetSdkVersion + 94, new byte[]{-98, -99, -121, -96, -121, -101}, null, objArr16);
                                try {
                                    Object[] objArr17 = {baseContext, str, str2, str3, str4, true, (String) objArr16[0], 995651014};
                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                    if (obj2 == null) {
                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), 17 - ExpandableListView.getPackedPositionChild(0L), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                    }
                                    ((Method) obj2).invoke(invoke, objArr17);
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
                    } catch (Throwable th5) {
                        Throwable cause5 = th5.getCause();
                        if (cause5 == null) {
                            throw th5;
                        }
                        throw cause5;
                    }
                }
            }
            try {
                Object[] objArr18 = new Object[1];
                j((byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), NetworkUserEntityData$$ExternalSyntheticLambda0[31], NetworkUserEntityData$$ExternalSyntheticLambda0[32], objArr18);
                Class<?> cls6 = Class.forName((String) objArr18[0]);
                byte b4 = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]);
                byte b5 = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[34] + 1);
                Object[] objArr19 = new Object[1];
                j(b4, b5, (byte) (b5 & 40), objArr19);
                try {
                    Object[] objArr20 = {Integer.valueOf(((Integer) cls6.getMethod((String) objArr19[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 493, 5 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) KeyEvent.keyCodeFromString(""));
                        Object[] objArr21 = new Object[1];
                        k((byte) ($$g[78] - 1), $$g[53], (byte) ($$g[78] - 1), objArr21);
                        obj3 = cls7.getMethod((String) objArr21[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr22 = (Object[]) ((Method) obj3).invoke(null, objArr20);
                    int i = ((int[]) objArr22[1])[0];
                    if (((int[]) objArr22[0])[0] != i) {
                        long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getTapTimeout() >> 16), 35 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr23 = {694537730, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.makeMeasureSpec(0, 0), 18 - ((Process.getThreadPriority(0) + 20) >> 6), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr23);
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
                    super.onCreate(bundle);
                    GriverTransActivity.a((Activity) this);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Main, com.alibaba.griver.core.ui.activity.GriverBaseActivity, android.app.Activity
        public void finish() {
            super.finish();
            overridePendingTransition(com.alibaba.griver.core.R.anim.griver_core_app_enter_left_in, com.alibaba.griver.core.R.anim.griver_core_app_exit_right_out);
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Main, com.alibaba.griver.core.ui.activity.GriverBaseActivity, android.app.Activity
        public void finishAndRemoveTask() {
            super.finishAndRemoveTask();
            overridePendingTransition(com.alibaba.griver.core.R.anim.griver_core_app_enter_left_in, com.alibaba.griver.core.R.anim.griver_core_app_exit_right_out);
        }

        private static void h(int[] iArr, int i, byte[] bArr, char[] cArr, Object[] objArr) {
            BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
            char[] cArr2 = scheduleImpl;
            if (cArr2 != null) {
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                for (int i2 = 0; i2 < length; i2++) {
                    cArr3[i2] = (char) (cArr2[i2] ^ 4571606982258105150L);
                }
                cArr2 = cArr3;
            }
            int i3 = (int) (4571606982258105150L ^ getErrorConfigVersion);
            if (GetContactSyncConfig) {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
                char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                    cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i3);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                }
                objArr[0] = new String(cArr4);
            } else if (DatabaseTableConfigUtil) {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
                char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                    cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                }
                objArr[0] = new String(cArr5);
            } else {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
                char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                    cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                }
                objArr[0] = new String(cArr6);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class LiteBase extends GriverBaseActivity.Lite {
        public static final byte[] $$j = {111, 16, 84, -34, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
        public static final int $$k = 107;
        public static final byte[] DatabaseTableConfigUtil = {112, Ascii.US, -51, -82, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
        public static final int NetworkUserEntityData$$ExternalSyntheticLambda2 = 250;
        private static long NetworkUserEntityData$$ExternalSyntheticLambda0 = 5231079088855185428L;

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002f). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void l(byte r6, short r7, int r8, java.lang.Object[] r9) {
            /*
                int r8 = 106 - r8
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverTransActivity.LiteBase.DatabaseTableConfigUtil
                int r6 = r6 + 4
                int r7 = 23 - r7
                byte[] r1 = new byte[r7]
                int r7 = r7 + (-1)
                r2 = 0
                if (r0 != 0) goto L16
                r8 = r6
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r9
                r9 = r7
                goto L2f
            L16:
                r3 = 0
            L17:
                byte r4 = (byte) r8
                r1[r3] = r4
                if (r3 != r7) goto L24
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L24:
                int r3 = r3 + 1
                r4 = r0[r6]
                r5 = r9
                r9 = r7
                r7 = r4
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r5
            L2f:
                int r6 = r6 + 1
                int r8 = r8 + r7
                int r8 = r8 + (-4)
                r7 = r9
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L17
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverTransActivity.LiteBase.l(byte, short, int, java.lang.Object[]):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002e -> B:11:0x0037). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void n(byte r6, int r7, byte r8, java.lang.Object[] r9) {
            /*
                int r6 = r6 * 3
                int r6 = r6 + 21
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverTransActivity.LiteBase.$$j
                int r7 = r7 + 4
                int r8 = r8 * 2
                int r8 = 103 - r8
                byte[] r1 = new byte[r6]
                int r6 = r6 + (-1)
                r2 = 0
                if (r0 != 0) goto L1b
                r8 = r7
                r3 = r1
                r4 = 0
                r7 = r6
                r1 = r0
                r0 = r9
                r9 = r8
                goto L37
            L1b:
                r3 = 0
                r5 = r8
                r8 = r7
                r7 = r5
            L1f:
                byte r4 = (byte) r7
                r1[r3] = r4
                int r4 = r3 + 1
                if (r3 != r6) goto L2e
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L2e:
                r3 = r0[r8]
                r5 = r7
                r7 = r6
                r6 = r3
                r3 = r1
                r1 = r0
                r0 = r9
                r9 = r5
            L37:
                int r8 = r8 + 1
                int r9 = r9 + r6
                int r6 = r9 + (-7)
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                r5 = r7
                r7 = r6
                r6 = r5
                goto L1f
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverTransActivity.LiteBase.n(byte, int, byte, java.lang.Object[]):void");
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            Object[] objArr;
            Object[] objArr2;
            Object[] objArr3;
            Object[] objArr4;
            super.attachBaseContext(context);
            Object[] objArr5 = new Object[1];
            m(ViewConfiguration.getDoubleTapTimeout() >> 16, new char[]{22814, 46679, 22911, 965, 48608, 31452, 36481, 15314, 38384, 54908, 41616, 23386, 63121, 54264, 52618, 35550, 57020, 35828, 9687, 62203, 1709, 41880}, objArr5);
            Class<?> cls = Class.forName((String) objArr5[0]);
            Object[] objArr6 = new Object[1];
            m(ViewConfiguration.getEdgeSlop() >> 16, new char[]{1253, 54592, 1160, 24773, 5847, 12028, 54129, 32122, 3937}, objArr6);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context applicationContext = context != null ? context.getApplicationContext() : context;
                if (applicationContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), 35 - ExpandableListView.getPackedPositionType(0L), (char) KeyEvent.getDeadChar(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        m((Process.getThreadPriority(0) + 20) >> 6, new char[]{34407, 4057, 34384, 47686, 23724, 1867, 20903, 33361, 29875, 14178, 57179, 9863, 10672, 27232, 11481, 63285, 466, 12839, 50331, 36725, 55702, 6740, 64748, 42834, 45491, 57878, 38057, 32533, 35235, 51830, 19650, 6007, 25029, 37425, 25739, 12134, 14814, 31379, 7208, 51146, 4465, 17036, 13362, 40915, 59696, 10979, 60430, 47077, 49493, 62118, 33820, 20390}, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        m((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1, new char[]{27659, 49282, 27754, 30027, 40107, 2024, 48029, 19799, 46269, 63333, 57252, 9848, 50063, 42301, 60548, 63385, 60351, 64895, 1180, 36744, 13305, 54540, 15547, 43005, 23519, 11551, 21755, 32751, 25501, 1404, 36036, 6025, 35747, 23914, 42207, 12238, 54248, 46490, 56361, 50996, 64280, 36237, 62525, 40751, 862, 58862, 11352, 46877, 11064, 15865, 17436, 20235, 29560, 5517, 31850, 26485, 39682, 28057, 38013, 16237, 41755, 17839, 52254, 55054, 52010, 40374, 58377, 61263}, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        m(ViewConfiguration.getEdgeSlop() >> 16, new char[]{2591, 54831, 2605, 25570, 27819, 38785, 56790, 23540, 17644, 1846, 20423, 46615, 42439, 46027, 7382, 26610, 36350, 60368, 62670, 8164, 21950, 50166, 52410, 14279, 15773, 15329, 42239, 61312, 1416, 5077, 31895, 34747, 60905, 19397, 21641, 49136, 46504, 41783, 11388, 22363, 40205, 39796, 1128, 3915, 25927, 62229, 56415, 10103, 19831, 11091, 46111, 57137, 5433, 810, 35949, 63302, 64797, 31538, 25720, 44806, 50440, 21254, 15383, 18229, 44393, 35606, 5131, 32554}, objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        m((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), new char[]{2406, 11846, 2318, 39886, 4918, 53292, 57061, 41872, 15229, 30906, 2147, 61864, 42722, 19451, 25356, Typography.rightDoubleQuote, 36504, 5118, 35610, 22558, 22211, 15259, 45942, 28799, 16055, 50073, 56166, 43042, 1697, 60335, 835, 49230, 61074, 46009, 11075, 63577, 46727, 23368, 21415, 4338, 40565, 25413, 31679, 18659, 26215, 2922, 41867, 24787, 20063, 54116, 52117, 39049, 5717, 64270, 62381, 45290, 65124, 33605, 7159, 59642, 50723, 43828, 17366, 207}, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        m(ViewConfiguration.getMaximumDrawingCacheSize() >> 24, new char[]{12664, 14493, 12609, 36175, 49574, 29080, 59066, 46400, 43626, 20546}, objArr11);
                        try {
                            Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 912, (ViewConfiguration.getJumpTapTimeout() >> 16) + 18, (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                    Object[] objArr13 = new Object[1];
                    l((byte) 37, (byte) (-DatabaseTableConfigUtil[30]), DatabaseTableConfigUtil[25], objArr13);
                    Class<?> cls2 = Class.forName((String) objArr13[0]);
                    Object[] objArr14 = new Object[1];
                    l(DatabaseTableConfigUtil[35], (byte) (-DatabaseTableConfigUtil[30]), DatabaseTableConfigUtil[7], objArr14);
                    try {
                        Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                        if (obj3 == null) {
                            Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 55, ((byte) KeyEvent.getModifierMetaStateMask()) + 4, (char) View.resolveSize(0, 0));
                            byte b = $$j[78];
                            Object[] objArr16 = new Object[1];
                            n(b, (byte) (b - 1), $$j[12], objArr16);
                            obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                        }
                        Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getKeyRepeatDelay() >> 16), TextUtils.getCapsMode("", 0, 0) + 15, (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("getAuthRequestContext", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                            }
                            int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                            try {
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, TextUtils.getOffsetAfter("", 0) + 15, (char) Color.alpha(0))).getMethod("PlaceComponentResult", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                                }
                                if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                    ArrayList arrayList = new ArrayList();
                                    try {
                                        Object[] objArr17 = {invoke2};
                                        Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                        if (obj6 == null) {
                                            obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 28 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) (TextUtils.indexOf("", "") + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - View.MeasureSpec.getMode(0), 15 - (Process.myPid() >> 22), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16)));
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                        }
                                        arrayList.add(((Method) obj6).invoke(null, objArr17));
                                        long j = ((r5 ^ intValue2) & 4294967295L) | 60129542144L;
                                        try {
                                            Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                            if (obj7 != null) {
                                                objArr = null;
                                            } else {
                                                objArr = null;
                                                obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.indexOf("", "") + 35, (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                            }
                                            Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                            try {
                                                Object[] objArr18 = {604538925, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                                Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                                if (obj8 == null) {
                                                    obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), 18 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) Color.argb(0, 0, 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    Object[] objArr19 = new Object[1];
                    l((byte) 37, (byte) (-DatabaseTableConfigUtil[30]), DatabaseTableConfigUtil[25], objArr19);
                    Class<?> cls4 = Class.forName((String) objArr19[0]);
                    Object[] objArr20 = new Object[1];
                    l(DatabaseTableConfigUtil[35], (byte) (-DatabaseTableConfigUtil[30]), DatabaseTableConfigUtil[7], objArr20);
                    try {
                        Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                        Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                        if (obj9 == null) {
                            Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + 61, ImageFormat.getBitsPerPixel(0) + 47, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)));
                            byte b2 = (byte) ($$j[78] - 1);
                            Object[] objArr22 = new Object[1];
                            n(b2, (byte) (b2 | Ascii.ETB), (byte) ($$j[78] - 1), objArr22);
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
                                    objArr2 = null;
                                } else {
                                    objArr2 = null;
                                    obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.getOffsetBefore("", 0) + 35, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                                }
                                Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                                try {
                                    Object[] objArr24 = {604538925, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj11 == null) {
                                        obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + 911, TextUtils.getOffsetAfter("", 0) + 18, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    Object[] objArr25 = new Object[1];
                    l((byte) 37, (byte) (-DatabaseTableConfigUtil[30]), DatabaseTableConfigUtil[25], objArr25);
                    Class<?> cls6 = Class.forName((String) objArr25[0]);
                    Object[] objArr26 = new Object[1];
                    l(DatabaseTableConfigUtil[35], (byte) (-DatabaseTableConfigUtil[30]), DatabaseTableConfigUtil[7], objArr26);
                    try {
                        Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                        Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                        if (obj12 == null) {
                            Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (ViewConfiguration.getKeyRepeatDelay() >> 16), 3 - (ViewConfiguration.getEdgeSlop() >> 16), (char) (38967 - TextUtils.lastIndexOf("", '0')));
                            byte b3 = (byte) ($$j[78] - 1);
                            Object[] objArr28 = new Object[1];
                            n(b3, (byte) (b3 | Ascii.ETB), (byte) ($$j[78] - 1), objArr28);
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
                                    obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 35, (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                                }
                                Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                                try {
                                    Object[] objArr30 = {604538925, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj14 == null) {
                                        obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), 17 - TextUtils.lastIndexOf("", '0', 0), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    Object[] objArr31 = new Object[1];
                    l((byte) 37, (byte) (-DatabaseTableConfigUtil[30]), DatabaseTableConfigUtil[25], objArr31);
                    Class<?> cls8 = Class.forName((String) objArr31[0]);
                    Object[] objArr32 = new Object[1];
                    l(DatabaseTableConfigUtil[35], (byte) (-DatabaseTableConfigUtil[30]), DatabaseTableConfigUtil[7], objArr32);
                    try {
                        Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                        Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                        if (obj15 == null) {
                            Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 106, 3 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                            Object[] objArr34 = new Object[1];
                            n($$j[8], $$j[53], $$j[9], objArr34);
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
                                    objArr4 = null;
                                } else {
                                    objArr4 = null;
                                    obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (ViewConfiguration.getJumpTapTimeout() >> 16) + 35, (char) ('0' - AndroidCharacter.getMirror('0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                                }
                                Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                                try {
                                    Object[] objArr36 = {604538925, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj17 == null) {
                                        obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + 911, 19 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) KeyEvent.getDeadChar(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return super.getApplicationContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
        public Context getBaseContext() {
            return super.getBaseContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
        public Resources getResources() {
            return super.getResources();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onPause() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr = new Object[1];
                m(super.getResources().getString(R.string.scan_cpm_to_sendmoney_dialog_dont_show).substring(2, 3).codePointAt(0) - 110, new char[]{522, 61744, 619, 17570, 61511, 53192, 54677, 31925, 55383, 39899, 6020, 61006, 44427, 38044, 32883, 16308, 34203, 52383, 26727, 18403, 23996, 58597, 20503, 28547, 13806, 7412, 14337, 46991, 3531, 13512}, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                m(super.getResources().getString(R.string.card_pay_view_height_ratio).substring(0, 2).codePointAt(0) - 49, new char[]{31047, 58360, 31012, 22129, 46108, 36047, 44754, 28282, 39946, 57238, 21740, 44361, 54999, 34388, 50210, 31988, 65268, 56917, 11306, 1252, 9960, 63018}, objArr2);
                baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", ""), Process.getGidForName("") + 36, (char) Drawable.resolveOpacity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr3 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.getSize(0), 17 - Process.getGidForName(""), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("MyBillsEntityDataFactory", Context.class);
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
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onResume() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr = new Object[1];
                m(TextUtils.getCapsMode("", 0, 0), new char[]{522, 61744, 619, 17570, 61511, 53192, 54677, 31925, 55383, 39899, 6020, 61006, 44427, 38044, 32883, 16308, 34203, 52383, 26727, 18403, 23996, 58597, 20503, 28547, 13806, 7412, 14337, 46991, 3531, 13512}, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                m(TextUtils.indexOf("", ""), new char[]{31047, 58360, 31012, 22129, 46108, 36047, 44754, 28282, 39946, 57238, 21740, 44361, 54999, 34388, 50210, 31988, 65268, 56917, 11306, 1252, 9960, 63018}, objArr2);
                baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", ""), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 35, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr3 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + 912, 18 - TextUtils.getTrimmedLength(""), (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle bundle) {
            try {
                byte b = DatabaseTableConfigUtil[25];
                Object[] objArr = new Object[1];
                l(b, b, DatabaseTableConfigUtil[32], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                l((byte) (DatabaseTableConfigUtil[59] + 1), DatabaseTableConfigUtil[27], DatabaseTableConfigUtil[13], new Object[1]);
                Object[] objArr2 = new Object[1];
                m(((ApplicationInfo) cls.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{22814, 46679, 22911, 965, 48608, 31452, 36481, 15314, 38384, 54908, 41616, 23386, 63121, 54264, 52618, 35550, 57020, 35828, 9687, 62203, 1709, 41880}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                m(getPackageName().codePointAt(1) - 100, new char[]{1253, 54592, 1160, 24773, 5847, 12028, 54129, 32122, 3937}, objArr3);
                int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                if (intValue < 99000 || intValue > 99999) {
                    Context baseContext = getBaseContext();
                    if (baseContext == null) {
                        Object[] objArr4 = new Object[1];
                        m(super.getResources().getString(R.string.share_activity_cancel_dialog_description).substring(22, 23).length() - 1, new char[]{522, 61744, 619, 17570, 61511, 53192, 54677, 31925, 55383, 39899, 6020, 61006, 44427, 38044, 32883, 16308, 34203, 52383, 26727, 18403, 23996, 58597, 20503, 28547, 13806, 7412, 14337, 46991, 3531, 13512}, objArr4);
                        Class<?> cls3 = Class.forName((String) objArr4[0]);
                        Object[] objArr5 = new Object[1];
                        m(ViewConfiguration.getFadingEdgeLength() >> 16, new char[]{31047, 58360, 31012, 22129, 46108, 36047, 44754, 28282, 39946, 57238, 21740, 44361, 54999, 34388, 50210, 31988, 65268, 56917, 11306, 1252, 9960, 63018}, objArr5);
                        baseContext = (Context) cls3.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext != null) {
                        baseContext = baseContext.getApplicationContext();
                    }
                    if (baseContext != null) {
                        try {
                            Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj == null) {
                                obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getTouchSlop() >> 8), 35 - TextUtils.indexOf("", "", 0), (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                            }
                            Object invoke = ((Method) obj).invoke(null, null);
                            Object[] objArr6 = new Object[1];
                            m(super.getResources().getString(R.string.tap_here_to_see_your_own_vouchers).substring(0, 4).length() - 4, new char[]{34407, 4057, 34384, 47686, 23724, 1867, 20903, 33361, 29875, 14178, 57179, 9863, 10672, 27232, 11481, 63285, 466, 12839, 50331, 36725, 55702, 6740, 64748, 42834, 45491, 57878, 38057, 32533, 35235, 51830, 19650, 6007, 25029, 37425, 25739, 12134, 14814, 31379, 7208, 51146, 4465, 17036, 13362, 40915, 59696, 10979, 60430, 47077, 49493, 62118, 33820, 20390}, objArr6);
                            String str = (String) objArr6[0];
                            Object[] objArr7 = new Object[1];
                            m(super.getResources().getString(R.string.onboarding_permission_location_third).substring(18, 20).length() - 2, new char[]{27659, 49282, 27754, 30027, 40107, 2024, 48029, 19799, 46269, 63333, 57252, 9848, 50063, 42301, 60548, 63385, 60351, 64895, 1180, 36744, 13305, 54540, 15547, 43005, 23519, 11551, 21755, 32751, 25501, 1404, 36036, 6025, 35747, 23914, 42207, 12238, 54248, 46490, 56361, 50996, 64280, 36237, 62525, 40751, 862, 58862, 11352, 46877, 11064, 15865, 17436, 20235, 29560, 5517, 31850, 26485, 39682, 28057, 38013, 16237, 41755, 17839, 52254, 55054, 52010, 40374, 58377, 61263}, objArr7);
                            String str2 = (String) objArr7[0];
                            Object[] objArr8 = new Object[1];
                            m(getPackageName().codePointAt(6) - 97, new char[]{2591, 54831, 2605, 25570, 27819, 38785, 56790, 23540, 17644, 1846, 20423, 46615, 42439, 46027, 7382, 26610, 36350, 60368, 62670, 8164, 21950, 50166, 52410, 14279, 15773, 15329, 42239, 61312, 1416, 5077, 31895, 34747, 60905, 19397, 21641, 49136, 46504, 41783, 11388, 22363, 40205, 39796, 1128, 3915, 25927, 62229, 56415, 10103, 19831, 11091, 46111, 57137, 5433, 810, 35949, 63302, 64797, 31538, 25720, 44806, 50440, 21254, 15383, 18229, 44393, 35606, 5131, 32554}, objArr8);
                            String str3 = (String) objArr8[0];
                            try {
                                byte b2 = DatabaseTableConfigUtil[25];
                                Object[] objArr9 = new Object[1];
                                l(b2, b2, DatabaseTableConfigUtil[32], objArr9);
                                Class<?> cls4 = Class.forName((String) objArr9[0]);
                                l((byte) (DatabaseTableConfigUtil[59] + 1), DatabaseTableConfigUtil[27], DatabaseTableConfigUtil[13], new Object[1]);
                                Object[] objArr10 = new Object[1];
                                m(((ApplicationInfo) cls4.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{2406, 11846, 2318, 39886, 4918, 53292, 57061, 41872, 15229, 30906, 2147, 61864, 42722, 19451, 25356, Typography.rightDoubleQuote, 36504, 5118, 35610, 22558, 22211, 15259, 45942, 28799, 16055, 50073, 56166, 43042, 1697, 60335, 835, 49230, 61074, 46009, 11075, 63577, 46727, 23368, 21415, 4338, 40565, 25413, 31679, 18659, 26215, 2922, 41867, 24787, 20063, 54116, 52117, 39049, 5717, 64270, 62381, 45290, 65124, 33605, 7159, 59642, 50723, 43828, 17366, 207}, objArr10);
                                String str4 = (String) objArr10[0];
                                try {
                                    byte b3 = DatabaseTableConfigUtil[25];
                                    Object[] objArr11 = new Object[1];
                                    l(b3, b3, DatabaseTableConfigUtil[32], objArr11);
                                    Class<?> cls5 = Class.forName((String) objArr11[0]);
                                    l((byte) (DatabaseTableConfigUtil[59] + 1), DatabaseTableConfigUtil[27], DatabaseTableConfigUtil[13], new Object[1]);
                                    Object[] objArr12 = new Object[1];
                                    m(((ApplicationInfo) cls5.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{12664, 14493, 12609, 36175, 49574, 29080, 59066, 46400, 43626, 20546}, objArr12);
                                    try {
                                        Object[] objArr13 = {baseContext, str, str2, str3, str4, true, (String) objArr12[0], 995651014};
                                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                        if (obj2 == null) {
                                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (Process.myPid() >> 22), 17 - ImageFormat.getBitsPerPixel(0), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                    Object[] objArr14 = new Object[1];
                    l((byte) 37, (byte) (-DatabaseTableConfigUtil[30]), DatabaseTableConfigUtil[25], objArr14);
                    Class<?> cls6 = Class.forName((String) objArr14[0]);
                    Object[] objArr15 = new Object[1];
                    l(DatabaseTableConfigUtil[35], (byte) (-DatabaseTableConfigUtil[30]), DatabaseTableConfigUtil[7], objArr15);
                    try {
                        Object[] objArr16 = {Integer.valueOf(((Integer) cls6.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                        if (obj3 == null) {
                            Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 4, (char) (Process.myPid() >> 22));
                            Object[] objArr17 = new Object[1];
                            n($$j[8], $$j[53], $$j[9], objArr17);
                            obj3 = cls7.getMethod((String) objArr17[0], Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                        }
                        Object[] objArr18 = (Object[]) ((Method) obj3).invoke(null, objArr16);
                        int i = ((int[]) objArr18[1])[0];
                        if (((int[]) objArr18[0])[0] != i) {
                            long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                            try {
                                Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj4 == null) {
                                    obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 35, (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                }
                                Object invoke2 = ((Method) obj4).invoke(null, null);
                                try {
                                    Object[] objArr19 = {696903546, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj5 == null) {
                                        obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778127, (Process.myTid() >> 22) + 18, (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                    }
                                    ((Method) obj5).invoke(invoke2, objArr19);
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
                        GriverTransActivity.a((Activity) this);
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

        private static void m(int i, char[] cArr, Object[] objArr) {
            D d = new D();
            char[] KClassImpl$Data$declaredNonStaticMembers$2 = D.KClassImpl$Data$declaredNonStaticMembers$2(NetworkUserEntityData$$ExternalSyntheticLambda0 ^ 3919452569568103912L, cArr, i);
            d.MyBillsEntityDataFactory = 4;
            while (d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$2.length) {
                d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
                KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (NetworkUserEntityData$$ExternalSyntheticLambda0 ^ 3919452569568103912L)));
                d.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$2, 4, KClassImpl$Data$declaredNonStaticMembers$2.length - 4);
        }
    }

    /* loaded from: classes3.dex */
    public static class Lite1 extends LiteBase {
        private static short[] initRecordTimeStamp;
        public static final byte[] $$g = {117, -10, 119, -11, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
        public static final int $$h = 215;
        public static final byte[] getErrorConfigVersion = {119, -93, -18, -42, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
        public static final int NetworkUserEntityData$$ExternalSyntheticLambda0 = 41;
        private static int lookAheadTest = 1257195656;
        private static int GetContactSyncConfig = -1252306297;
        private static byte[] NetworkUserEntityData$$ExternalSyntheticLambda1 = {-97, -111, -99, 107, 98, -67, -67, 36, -101, -34, 85, 100, 101, 98, -111, 105, -110, 100, -117, 67, -109, -100, 99, 108, -107, -117, 68, -102, -108, 108, -110, 106, -114, -67, -116, 33, -97, -112, -84, 85, 100, 101, 98, -111, 105, -110, 96, -103, 106, -116, 97, 101, 98, 99, -97, -80, 82, -103, -106, 108, -97, 98, -115, -80, -100, 78, -77, -99, 81, -80, -104, 103, 96, 76, -78, -104, 99, 98, 75, -101, 98, -83, 81, -77, -102, 80, -79, 76, -97, 96, -100, -76, -102, -97, 100, -102, 96, 82, 96, -100, 97, -79, 96, 96, 74, -85, 103, -99, 76, -77, 80, -77, -104, 80, 96, -83, -98, 96, -98, 102, 97, -97, -99, -101, -97, 99, -103, 101, 75, -83, 83, -86, 100, -99, -100, 82, -97, -76, -101, 79, -98, -82, -97, 81, -77, 76, -77, 72, -77, -100, 98, -102, 82, -84, 84, -85, -97, 97, -100, -97, 82, -80, 99, 73, 96, -77, -105, 104, 76, -99, -79, -98, 75, -101, -97, 80, -81, 98, -101, 97, -99, 80, -86, 96, 82, -99, -75, 76, -101, -98, -82, 103, -101, -100, 84, -79, -97, -99, 96, 74, -75, -103, 81, -78, 75, -77, 78, -97, -79, 96, 76, -80, -101, 77, 96, -81, 81, -81, 80, -101, -75, -104, 98, -99, -97, 102, -97, -97, -101, -99, 100, 97, 72, 98, -85, 96, 96, -103, -106, 112, -114, -87, 98, 35, -40, 36, -98, -111, 97, 102, -102, -91, 89, 102, -112, -83, 93, 97, -109, -86, 86, 108, -114, 115, -101, 97, -112, 109, -114, 115, -111, -90, 37, -98, -115, 97, 112, -116, 99, 108, -107, 107, -39, 82, 108, -110, 98, -86, -97, 106, 88, -100, 99, -97, -109, 96, -101, 101, -103, 106, -97, -97, -97, -97, -97, -97, -97, -97, -97};
        private static int scheduleImpl = 1996205249;

        private static void h(short s, short s2, byte b, Object[] objArr) {
            int i = s + 97;
            byte[] bArr = getErrorConfigVersion;
            int i2 = s2 + 4;
            int i3 = b + 16;
            byte[] bArr2 = new byte[i3];
            int i4 = -1;
            int i5 = i3 - 1;
            if (bArr == null) {
                int i6 = (i2 + i5) - 4;
                i5 = i5;
                objArr = objArr;
                bArr = bArr;
                bArr2 = bArr2;
                i4 = -1;
                i2 = i2;
                i = i6;
            }
            while (true) {
                int i7 = i4 + 1;
                bArr2[i7] = (byte) i;
                int i8 = i2 + 1;
                if (i7 == i5) {
                    objArr[0] = new String(bArr2, 0);
                    return;
                }
                i5 = i5;
                objArr = objArr;
                bArr = bArr;
                bArr2 = bArr2;
                i4 = i7;
                i2 = i8;
                i = (i + bArr[i8]) - 4;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002e). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void k(int r6, byte r7, byte r8, java.lang.Object[] r9) {
            /*
                int r8 = r8 * 2
                int r8 = r8 + 75
                int r7 = r7 * 3
                int r7 = 42 - r7
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverTransActivity.Lite1.$$g
                int r6 = r6 + 4
                byte[] r1 = new byte[r7]
                int r7 = r7 + (-1)
                r2 = 0
                if (r0 != 0) goto L18
                r4 = r8
                r3 = 0
                r8 = r7
                r7 = r6
                goto L2e
            L18:
                r3 = 0
            L19:
                byte r4 = (byte) r8
                r1[r3] = r4
                if (r3 != r7) goto L26
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L26:
                int r3 = r3 + 1
                r4 = r0[r6]
                r5 = r7
                r7 = r6
                r6 = r8
                r8 = r5
            L2e:
                int r4 = -r4
                int r6 = r6 + r4
                int r6 = r6 + (-7)
                int r7 = r7 + 1
                r5 = r8
                r8 = r6
                r6 = r7
                r7 = r5
                goto L19
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverTransActivity.Lite1.k(int, byte, byte, java.lang.Object[]):void");
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.LiteBase, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            Object[] objArr;
            Object[] objArr2;
            Object[] objArr3;
            Object[] objArr4;
            super.attachBaseContext(context);
            Object[] objArr5 = new Object[1];
            j(4974152 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (-1008002142) - (ViewConfiguration.getScrollDefaultDelay() >> 16), (short) (ViewConfiguration.getTapTimeout() >> 16), (byte) Color.green(0), (ViewConfiguration.getWindowTouchSlop() >> 8) - 5, objArr5);
            Class<?> cls = Class.forName((String) objArr5[0]);
            Object[] objArr6 = new Object[1];
            j(TextUtils.getOffsetAfter("", 0) + 4974165, ExpandableListView.getPackedPositionChild(0L) - 1008002124, (short) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1), (byte) (ViewConfiguration.getKeyRepeatDelay() >> 16), TextUtils.getTrimmedLength("") - 18, objArr6);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context applicationContext = context != null ? context.getApplicationContext() : context;
                if (applicationContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 34, (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        j(4974111 - (ViewConfiguration.getPressedStateDuration() >> 16), (ViewConfiguration.getWindowTouchSlop() >> 8) - 1008002079, (short) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)), (byte) KeyEvent.getDeadChar(0, 0), 25 - TextUtils.getTrimmedLength(""), objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        j((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 4974153, TextUtils.indexOf((CharSequence) "", '0', 0) - 1008002031, (short) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1), (byte) View.resolveSize(0, 0), 41 - (Process.myPid() >> 22), objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        j(4974105 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (ViewConfiguration.getTouchSlop() >> 8) - 1008001969, (short) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1), (byte) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), 41 - View.MeasureSpec.getSize(0), objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        j(View.resolveSize(0, 0) + 4974160, (-1008001906) - KeyEvent.normalizeMetaState(0), (short) View.MeasureSpec.getMode(0), (byte) TextUtils.getOffsetBefore("", 0), ExpandableListView.getPackedPositionType(0L) + 37, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        j(4974113 - (ViewConfiguration.getPressedStateDuration() >> 16), (ViewConfiguration.getScrollBarSize() >> 8) - 1008001847, (short) KeyEvent.getDeadChar(0, 0), (byte) (ViewConfiguration.getEdgeSlop() >> 16), (ViewConfiguration.getKeyRepeatTimeout() >> 16) - 17, objArr11);
                        try {
                            Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + 911, 'B' - AndroidCharacter.getMirror('0'), (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                    byte b = getErrorConfigVersion[32];
                    Object[] objArr13 = new Object[1];
                    h(b, (byte) (b << 2), getErrorConfigVersion[25], objArr13);
                    Class<?> cls2 = Class.forName((String) objArr13[0]);
                    Object[] objArr14 = new Object[1];
                    h((byte) (NetworkUserEntityData$$ExternalSyntheticLambda0 & 30), (byte) (getErrorConfigVersion[35] - 1), getErrorConfigVersion[25], objArr14);
                    try {
                        Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                        if (obj3 == null) {
                            Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), Process.getGidForName("") + 4, (char) (Color.rgb(0, 0, 0) + 16777216));
                            Object[] objArr16 = new Object[1];
                            k((byte) ($$g[47] - 1), $$g[68], $$g[47], objArr16);
                            obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                        }
                        Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (ViewConfiguration.getWindowTouchSlop() >> 8) + 15, (char) TextUtils.getOffsetBefore("", 0))).getMethod("getAuthRequestContext", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                            }
                            int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                            try {
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 800, 14 - TextUtils.indexOf((CharSequence) "", '0'), (char) (ExpandableListView.getPackedPositionChild(0L) + 1))).getMethod("PlaceComponentResult", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                                }
                                if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                    ArrayList arrayList = new ArrayList();
                                    try {
                                        Object[] objArr17 = {invoke2};
                                        Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                        if (obj6 == null) {
                                            obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + 815, 29 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (KeyEvent.normalizeMetaState(0) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 15 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0))));
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                        }
                                        arrayList.add(((Method) obj6).invoke(null, objArr17));
                                        long j = ((r10 ^ intValue2) & 4294967295L) | 60129542144L;
                                        try {
                                            Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                            if (obj7 != null) {
                                                objArr = null;
                                            } else {
                                                objArr = null;
                                                obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + 930, 35 - View.resolveSize(0, 0), (char) TextUtils.getOffsetBefore("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                            }
                                            Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                            try {
                                                Object[] objArr18 = {1418265541, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                                Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                                if (obj8 == null) {
                                                    obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 911, TextUtils.lastIndexOf("", '0', 0, 0) + 19, (char) KeyEvent.normalizeMetaState(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    byte b2 = getErrorConfigVersion[32];
                    Object[] objArr19 = new Object[1];
                    h(b2, (byte) (b2 << 2), getErrorConfigVersion[25], objArr19);
                    Class<?> cls4 = Class.forName((String) objArr19[0]);
                    Object[] objArr20 = new Object[1];
                    h((byte) (NetworkUserEntityData$$ExternalSyntheticLambda0 & 30), (byte) (getErrorConfigVersion[35] - 1), getErrorConfigVersion[25], objArr20);
                    try {
                        Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                        Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                        if (obj9 == null) {
                            Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (Process.myPid() >> 22), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 46, (char) Color.blue(0));
                            Object[] objArr22 = new Object[1];
                            k((byte) ($$h & 63), (byte) (-$$g[8]), (byte) (-$$g[9]), objArr22);
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
                                    obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 930, 35 - ((Process.getThreadPriority(0) + 20) >> 6), (char) View.combineMeasuredStates(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                                }
                                Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                                try {
                                    Object[] objArr24 = {1418265541, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj11 == null) {
                                        obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + 912, (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 18, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    byte b3 = getErrorConfigVersion[32];
                    Object[] objArr25 = new Object[1];
                    h(b3, (byte) (b3 << 2), getErrorConfigVersion[25], objArr25);
                    Class<?> cls6 = Class.forName((String) objArr25[0]);
                    Object[] objArr26 = new Object[1];
                    h((byte) (NetworkUserEntityData$$ExternalSyntheticLambda0 & 30), (byte) (getErrorConfigVersion[35] - 1), getErrorConfigVersion[25], objArr26);
                    try {
                        Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                        Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                        if (obj12 == null) {
                            Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 118, 4 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 38968));
                            Object[] objArr28 = new Object[1];
                            k((byte) ($$h & 63), (byte) (-$$g[8]), (byte) (-$$g[9]), objArr28);
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
                                    obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) ((-16777216) - Color.rgb(0, 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                                }
                                Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                                try {
                                    Object[] objArr30 = {1418265541, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj14 == null) {
                                        obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + 911, 18 - (KeyEvent.getMaxKeyCode() >> 16), (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    byte b4 = getErrorConfigVersion[32];
                    Object[] objArr31 = new Object[1];
                    h(b4, (byte) (b4 << 2), getErrorConfigVersion[25], objArr31);
                    Class<?> cls8 = Class.forName((String) objArr31[0]);
                    Object[] objArr32 = new Object[1];
                    h((byte) (NetworkUserEntityData$$ExternalSyntheticLambda0 & 30), (byte) (getErrorConfigVersion[35] - 1), getErrorConfigVersion[25], objArr32);
                    try {
                        Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                        Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                        if (obj15 == null) {
                            Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - Color.blue(0), 3 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) Color.argb(0, 0, 0, 0));
                            byte b5 = (byte) (-$$g[53]);
                            byte b6 = (byte) ($$g[47] - 1);
                            Object[] objArr34 = new Object[1];
                            k(b5, b6, b6, objArr34);
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
                                    obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) TextUtils.getTrimmedLength(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                                }
                                Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                                try {
                                    Object[] objArr36 = {1418265541, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj17 == null) {
                                        obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getOffsetBefore("", 0), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 18, (char) (Color.rgb(0, 0, 0) + 16777216))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.LiteBase, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return super.getApplicationContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.LiteBase, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
        public Context getBaseContext() {
            return super.getBaseContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.LiteBase, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
        public Resources getResources() {
            return super.getResources();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.LiteBase, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onPause() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                int length = super.getResources().getString(R.string.bank_empty_desc).substring(26, 27).length() + 4974152;
                int length2 = getPackageName().length() - 1008002128;
                short length3 = (short) (getPackageName().length() - 7);
                byte fadingEdgeLength = (byte) (ViewConfiguration.getFadingEdgeLength() >> 16);
                try {
                    Object[] objArr = new Object[1];
                    h(getErrorConfigVersion[25], getErrorConfigVersion[9], (byte) (-getErrorConfigVersion[30]), objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    Object[] objArr2 = new Object[1];
                    h((byte) (-getErrorConfigVersion[5]), getErrorConfigVersion[59], getErrorConfigVersion[56], objArr2);
                    int i = ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion - 30;
                    Object[] objArr3 = new Object[1];
                    j(length, length2, length3, fadingEdgeLength, i, objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    int codePointAt = super.getResources().getString(R.string.voucher_tooltip_text).substring(18, 19).codePointAt(0) + 4974123;
                    int codePointAt2 = getPackageName().codePointAt(3) - 1008002196;
                    try {
                        Object[] objArr4 = new Object[1];
                        h(getErrorConfigVersion[25], getErrorConfigVersion[9], (byte) (-getErrorConfigVersion[30]), objArr4);
                        Class<?> cls3 = Class.forName((String) objArr4[0]);
                        h((byte) (-getErrorConfigVersion[5]), getErrorConfigVersion[59], getErrorConfigVersion[56], new Object[1]);
                        Object[] objArr5 = new Object[1];
                        j(codePointAt, codePointAt2, (short) (((ApplicationInfo) cls3.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 33), (byte) (super.getResources().getString(R.string.header_edit_recipient).substring(0, 5).length() - 5), (-4) - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), objArr5);
                        baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", "", 0), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 35, (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr6 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", "", 0), 18 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("MyBillsEntityDataFactory", Context.class);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr6);
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
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.LiteBase, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onResume() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                int length = super.getResources().getString(R.string.bottom_on_boarding_subtitle_dana_kaget_second).substring(1, 2).length() + 4974152;
                int bitsPerPixel = (-1008002122) - ImageFormat.getBitsPerPixel(0);
                short resolveSize = (short) View.resolveSize(0, 0);
                byte myPid = (byte) (Process.myPid() >> 22);
                try {
                    Object[] objArr = new Object[1];
                    h(getErrorConfigVersion[25], getErrorConfigVersion[9], (byte) (-getErrorConfigVersion[30]), objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    Object[] objArr2 = new Object[1];
                    h((byte) (-getErrorConfigVersion[5]), getErrorConfigVersion[59], getErrorConfigVersion[56], objArr2);
                    int i = ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion - 30;
                    Object[] objArr3 = new Object[1];
                    j(length, bitsPerPixel, resolveSize, myPid, i, objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    int capsMode = 4974155 - TextUtils.getCapsMode("", 0, 0);
                    int packedPositionType = (-1008002096) - ExpandableListView.getPackedPositionType(0L);
                    short codePointAt = (short) (super.getResources().getString(R.string.tap_here_to_see_your_profile_account).substring(0, 4).codePointAt(2) - 112);
                    try {
                        Object[] objArr4 = new Object[1];
                        h(getErrorConfigVersion[25], getErrorConfigVersion[9], (byte) (-getErrorConfigVersion[30]), objArr4);
                        Class<?> cls3 = Class.forName((String) objArr4[0]);
                        h((byte) (-getErrorConfigVersion[5]), getErrorConfigVersion[59], getErrorConfigVersion[56], new Object[1]);
                        byte b = (byte) (((ApplicationInfo) cls3.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 33);
                        try {
                            Object[] objArr5 = new Object[1];
                            h(getErrorConfigVersion[25], getErrorConfigVersion[9], (byte) (-getErrorConfigVersion[30]), objArr5);
                            Class<?> cls4 = Class.forName((String) objArr5[0]);
                            Object[] objArr6 = new Object[1];
                            h((byte) (-getErrorConfigVersion[5]), getErrorConfigVersion[59], getErrorConfigVersion[56], objArr6);
                            int i2 = ((ApplicationInfo) cls4.getMethod((String) objArr6[0], null).invoke(this, null)).targetSdkVersion - 38;
                            Object[] objArr7 = new Object[1];
                            j(capsMode, packedPositionType, codePointAt, b, i2, objArr7);
                            baseContext = (Context) cls2.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
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
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - KeyEvent.normalizeMetaState(0), 35 - ExpandableListView.getPackedPositionGroup(0L), (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr8 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + 911, TextUtils.lastIndexOf("", '0', 0, 0) + 19, (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr8);
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
            super.onResume();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.LiteBase, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle bundle) {
            Object[] objArr;
            Object[] objArr2;
            try {
                Object[] objArr3 = new Object[1];
                h(getErrorConfigVersion[25], getErrorConfigVersion[9], (byte) (-getErrorConfigVersion[30]), objArr3);
                Class<?> cls = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                h((byte) (-getErrorConfigVersion[5]), getErrorConfigVersion[59], getErrorConfigVersion[56], objArr4);
                Object[] objArr5 = new Object[1];
                j(((ApplicationInfo) cls.getMethod((String) objArr4[0], null).invoke(this, null)).targetSdkVersion + 4974120, super.getResources().getString(R.string.api_limit_error_message).substring(0, 1).codePointAt(0) - 1008002218, (short) (super.getResources().getString(R.string.family_member_deleted_title).substring(36, 37).codePointAt(0) + SecLiteException.ERROR_API_KEY_OR_SIGN), (byte) View.MeasureSpec.getMode(0), super.getResources().getString(R.string.voucher_description_default_value).substring(36, 43).codePointAt(4) - 115, objArr5);
                Class<?> cls2 = Class.forName((String) objArr5[0]);
                try {
                    Object[] objArr6 = new Object[1];
                    h(getErrorConfigVersion[25], getErrorConfigVersion[9], (byte) (-getErrorConfigVersion[30]), objArr6);
                    Class<?> cls3 = Class.forName((String) objArr6[0]);
                    Object[] objArr7 = new Object[1];
                    h((byte) (-getErrorConfigVersion[5]), getErrorConfigVersion[59], getErrorConfigVersion[56], objArr7);
                    int i = ((ApplicationInfo) cls3.getMethod((String) objArr7[0], null).invoke(this, null)).targetSdkVersion + 4974132;
                    int codePointAt = getPackageName().codePointAt(2) - 1008002171;
                    try {
                        Object[] objArr8 = new Object[1];
                        h(getErrorConfigVersion[25], getErrorConfigVersion[9], (byte) (-getErrorConfigVersion[30]), objArr8);
                        Class<?> cls4 = Class.forName((String) objArr8[0]);
                        h((byte) (-getErrorConfigVersion[5]), getErrorConfigVersion[59], getErrorConfigVersion[56], new Object[1]);
                        Object[] objArr9 = new Object[1];
                        j(i, codePointAt, (short) (((ApplicationInfo) cls4.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 33), (byte) (getPackageName().length() - 7), super.getResources().getString(R.string.expiring_soon).substring(4, 5).length() - 19, objArr9);
                        int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr9[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                        if (intValue < 99000 || intValue > 99999) {
                            Context baseContext = getBaseContext();
                            if (baseContext == null) {
                                try {
                                    Object[] objArr10 = new Object[1];
                                    h(getErrorConfigVersion[25], getErrorConfigVersion[9], (byte) (-getErrorConfigVersion[30]), objArr10);
                                    Class<?> cls5 = Class.forName((String) objArr10[0]);
                                    Object[] objArr11 = new Object[1];
                                    h((byte) (-getErrorConfigVersion[5]), getErrorConfigVersion[59], getErrorConfigVersion[56], objArr11);
                                    int i2 = ((ApplicationInfo) cls5.getMethod((String) objArr11[0], null).invoke(this, null)).targetSdkVersion + 4974120;
                                    try {
                                        Object[] objArr12 = new Object[1];
                                        h(getErrorConfigVersion[25], getErrorConfigVersion[9], (byte) (-getErrorConfigVersion[30]), objArr12);
                                        Class<?> cls6 = Class.forName((String) objArr12[0]);
                                        h((byte) (-getErrorConfigVersion[5]), getErrorConfigVersion[59], getErrorConfigVersion[56], new Object[1]);
                                        Object[] objArr13 = new Object[1];
                                        j(i2, ((ApplicationInfo) cls6.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 1008002154, (short) (getPackageName().codePointAt(6) - 97), (byte) (getPackageName().codePointAt(6) - 97), getPackageName().codePointAt(3) - 97, objArr13);
                                        Class<?> cls7 = Class.forName((String) objArr13[0]);
                                        int size = 4974155 - View.MeasureSpec.getSize(0);
                                        int length = getPackageName().length() - 1008002103;
                                        try {
                                            Object[] objArr14 = new Object[1];
                                            h(getErrorConfigVersion[25], getErrorConfigVersion[9], (byte) (-getErrorConfigVersion[30]), objArr14);
                                            Class<?> cls8 = Class.forName((String) objArr14[0]);
                                            h((byte) (-getErrorConfigVersion[5]), getErrorConfigVersion[59], getErrorConfigVersion[56], new Object[1]);
                                            Object[] objArr15 = new Object[1];
                                            j(size, length, (short) (((ApplicationInfo) cls8.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 33), (byte) View.MeasureSpec.getSize(0), getPackageName().length() - 12, objArr15);
                                            baseContext = (Context) cls7.getMethod((String) objArr15[0], new Class[0]).invoke(null, null);
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
                            if (baseContext != null) {
                                baseContext = baseContext.getApplicationContext();
                            }
                            if (baseContext != null) {
                                try {
                                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                    if (obj != null) {
                                        objArr = null;
                                    } else {
                                        objArr = null;
                                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, TextUtils.lastIndexOf("", '0', 0) + 36, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                                    }
                                    Object invoke = ((Method) obj).invoke(objArr, objArr);
                                    try {
                                        Object[] objArr16 = new Object[1];
                                        h(getErrorConfigVersion[25], getErrorConfigVersion[9], (byte) (-getErrorConfigVersion[30]), objArr16);
                                        Class<?> cls9 = Class.forName((String) objArr16[0]);
                                        Object[] objArr17 = new Object[1];
                                        h((byte) (-getErrorConfigVersion[5]), getErrorConfigVersion[59], getErrorConfigVersion[56], objArr17);
                                        int i3 = ((ApplicationInfo) cls9.getMethod((String) objArr17[0], null).invoke(this, null)).targetSdkVersion + 4974078;
                                        try {
                                            Object[] objArr18 = new Object[1];
                                            h(getErrorConfigVersion[25], getErrorConfigVersion[9], (byte) (-getErrorConfigVersion[30]), objArr18);
                                            Class<?> cls10 = Class.forName((String) objArr18[0]);
                                            h((byte) (-getErrorConfigVersion[5]), getErrorConfigVersion[59], getErrorConfigVersion[56], new Object[1]);
                                            Object[] objArr19 = new Object[1];
                                            j(i3, ((ApplicationInfo) cls10.getMethod((String) r10[0], null).invoke(this, null)).targetSdkVersion - 1008002112, (short) TextUtils.getOffsetBefore("", 0), (byte) (super.getResources().getString(R.string.kyc_review_description).substring(0, 42).codePointAt(18) + BranchLinkConstant.DeepLinkErrorCode.SAME_ALIAS), super.getResources().getString(R.string.error_promo_description).substring(4, 5).length() + 24, objArr19);
                                            String str = (String) objArr19[0];
                                            int codePointAt2 = getPackageName().codePointAt(1) + 4974053;
                                            int length2 = getPackageName().length() - 1008002039;
                                            short codePointAt3 = (short) (super.getResources().getString(R.string.split_bill_qr_desc_message).substring(17, 18).codePointAt(0) - 32);
                                            try {
                                                Object[] objArr20 = new Object[1];
                                                h(getErrorConfigVersion[25], getErrorConfigVersion[9], (byte) (-getErrorConfigVersion[30]), objArr20);
                                                Class<?> cls11 = Class.forName((String) objArr20[0]);
                                                h((byte) (-getErrorConfigVersion[5]), getErrorConfigVersion[59], getErrorConfigVersion[56], new Object[1]);
                                                Object[] objArr21 = new Object[1];
                                                j(codePointAt2, length2, codePointAt3, (byte) (((ApplicationInfo) cls11.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 33), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 40, objArr21);
                                                String str2 = (String) objArr21[0];
                                                int length3 = super.getResources().getString(R.string.transfer_account_status_toolbar_title).substring(0, 1).length() + 4974105;
                                                int codePointAt4 = super.getResources().getString(R.string.daily_limit_description_helper).substring(3, 4).codePointAt(0) - 1008002066;
                                                short codePointAt5 = (short) (super.getResources().getString(R.string.twilio_error_check_pending_message).substring(29, 31).codePointAt(1) - 32);
                                                try {
                                                    Object[] objArr22 = new Object[1];
                                                    h(getErrorConfigVersion[25], getErrorConfigVersion[9], (byte) (-getErrorConfigVersion[30]), objArr22);
                                                    Class<?> cls12 = Class.forName((String) objArr22[0]);
                                                    h((byte) (-getErrorConfigVersion[5]), getErrorConfigVersion[59], getErrorConfigVersion[56], new Object[1]);
                                                    byte b = (byte) (((ApplicationInfo) cls12.getMethod((String) r6[0], null).invoke(this, null)).targetSdkVersion - 33);
                                                    try {
                                                        Object[] objArr23 = new Object[1];
                                                        h(getErrorConfigVersion[25], getErrorConfigVersion[9], (byte) (-getErrorConfigVersion[30]), objArr23);
                                                        Class<?> cls13 = Class.forName((String) objArr23[0]);
                                                        Object[] objArr24 = new Object[1];
                                                        h((byte) (-getErrorConfigVersion[5]), getErrorConfigVersion[59], getErrorConfigVersion[56], objArr24);
                                                        int i4 = ((ApplicationInfo) cls13.getMethod((String) objArr24[0], null).invoke(this, null)).targetSdkVersion + 8;
                                                        Object[] objArr25 = new Object[1];
                                                        j(length3, codePointAt4, codePointAt5, b, i4, objArr25);
                                                        String str3 = (String) objArr25[0];
                                                        int codePointAt6 = super.getResources().getString(R.string.otp_sms_subtitle).substring(1, 5).codePointAt(1) + 4974060;
                                                        try {
                                                            Object[] objArr26 = new Object[1];
                                                            h(getErrorConfigVersion[25], getErrorConfigVersion[9], (byte) (-getErrorConfigVersion[30]), objArr26);
                                                            Class<?> cls14 = Class.forName((String) objArr26[0]);
                                                            h((byte) (-getErrorConfigVersion[5]), getErrorConfigVersion[59], getErrorConfigVersion[56], new Object[1]);
                                                            Object[] objArr27 = new Object[1];
                                                            j(codePointAt6, ((ApplicationInfo) cls14.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 1008001939, (short) (super.getResources().getString(R.string.near_expired).substring(4, 5).codePointAt(0) - 114), (byte) (super.getResources().getString(R.string.family_relation_question_text).substring(7, 8).length() - 1), 37 - (ViewConfiguration.getPressedStateDuration() >> 16), objArr27);
                                                            String str4 = (String) objArr27[0];
                                                            int length4 = getPackageName().length() + 4974106;
                                                            int length5 = super.getResources().getString(R.string.request_money_expiry_refresh_time).substring(7, 8).length() - 1008001848;
                                                            short length6 = (short) (super.getResources().getString(R.string.my_card_def_subtitle).substring(0, 2).length() - 2);
                                                            try {
                                                                Object[] objArr28 = new Object[1];
                                                                h(getErrorConfigVersion[25], getErrorConfigVersion[9], (byte) (-getErrorConfigVersion[30]), objArr28);
                                                                Class<?> cls15 = Class.forName((String) objArr28[0]);
                                                                h((byte) (-getErrorConfigVersion[5]), getErrorConfigVersion[59], getErrorConfigVersion[56], new Object[1]);
                                                                Object[] objArr29 = new Object[1];
                                                                j(length4, length5, length6, (byte) (((ApplicationInfo) cls15.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 33), (ViewConfiguration.getJumpTapTimeout() >> 16) - 17, objArr29);
                                                                try {
                                                                    Object[] objArr30 = {baseContext, str, str2, str3, str4, true, (String) objArr29[0], 995651014};
                                                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                                                    if (obj2 == null) {
                                                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myTid() >> 22) + 911, View.MeasureSpec.makeMeasureSpec(0, 0) + 18, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                                                    }
                                                                    ((Method) obj2).invoke(invoke, objArr30);
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
                                } catch (Throwable th12) {
                                    Throwable cause12 = th12.getCause();
                                    if (cause12 == null) {
                                        throw th12;
                                    }
                                    throw cause12;
                                }
                            }
                        }
                        try {
                            byte b2 = getErrorConfigVersion[32];
                            Object[] objArr31 = new Object[1];
                            h(b2, (byte) (b2 << 2), getErrorConfigVersion[25], objArr31);
                            Class<?> cls16 = Class.forName((String) objArr31[0]);
                            Object[] objArr32 = new Object[1];
                            h((byte) (NetworkUserEntityData$$ExternalSyntheticLambda0 & 30), (byte) (getErrorConfigVersion[35] - 1), getErrorConfigVersion[25], objArr32);
                            try {
                                Object[] objArr33 = {Integer.valueOf(((Integer) cls16.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                                if (obj3 == null) {
                                    Class cls17 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 494, 3 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) TextUtils.indexOf("", ""));
                                    byte b3 = (byte) (-$$g[53]);
                                    byte b4 = (byte) ($$g[47] - 1);
                                    Object[] objArr34 = new Object[1];
                                    k(b3, b4, b4, objArr34);
                                    obj3 = cls17.getMethod((String) objArr34[0], Integer.TYPE);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                                }
                                Object[] objArr35 = (Object[]) ((Method) obj3).invoke(null, objArr33);
                                int i5 = ((int[]) objArr35[1])[0];
                                if (((int[]) objArr35[0])[0] != i5) {
                                    long j = ((r2 ^ i5) & 4294967295L) | 42949672960L;
                                    try {
                                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj4 != null) {
                                            objArr2 = null;
                                        } else {
                                            objArr2 = null;
                                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 34, (char) KeyEvent.normalizeMetaState(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                        }
                                        Object invoke2 = ((Method) obj4).invoke(objArr2, objArr2);
                                        try {
                                            Object[] objArr36 = {443694002, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj5 == null) {
                                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 19 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                            }
                                            ((Method) obj5).invoke(invoke2, objArr36);
                                        } catch (Throwable th13) {
                                            Throwable cause13 = th13.getCause();
                                            if (cause13 == null) {
                                                throw th13;
                                            }
                                            throw cause13;
                                        }
                                    } catch (Throwable th14) {
                                        Throwable cause14 = th14.getCause();
                                        if (cause14 == null) {
                                            throw th14;
                                        }
                                        throw cause14;
                                    }
                                }
                                super.onCreate(bundle);
                                RVLogger.d(GriverTransActivity.TAG, "onCreate NebulaTransActivity$Lite1");
                            } catch (Throwable th15) {
                                Throwable cause15 = th15.getCause();
                                if (cause15 == null) {
                                    throw th15;
                                }
                                throw cause15;
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

        private static void j(int i, int i2, short s, byte b, int i3, Object[] objArr) {
            B b2 = new B();
            StringBuilder sb = new StringBuilder();
            int i4 = i3 + ((int) (lookAheadTest ^ 3097486228508854431L));
            int i5 = i4 == -1 ? 1 : 0;
            if (i5 != 0) {
                byte[] bArr = NetworkUserEntityData$$ExternalSyntheticLambda1;
                if (bArr != null) {
                    int length = bArr.length;
                    byte[] bArr2 = new byte[length];
                    for (int i6 = 0; i6 < length; i6++) {
                        bArr2[i6] = (byte) (bArr[i6] ^ 3097486228508854431L);
                    }
                    bArr = bArr2;
                }
                if (bArr != null) {
                    i4 = (byte) (((byte) (NetworkUserEntityData$$ExternalSyntheticLambda1[i2 + ((int) (scheduleImpl ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (lookAheadTest ^ 3097486228508854431L)));
                } else {
                    i4 = (short) (((short) (initRecordTimeStamp[i2 + ((int) (scheduleImpl ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (lookAheadTest ^ 3097486228508854431L)));
                }
            }
            if (i4 > 0) {
                b2.getAuthRequestContext = ((i2 + i4) - 2) + ((int) (scheduleImpl ^ 3097486228508854431L)) + i5;
                b2.MyBillsEntityDataFactory = (char) (i + ((int) (GetContactSyncConfig ^ 3097486228508854431L)));
                sb.append(b2.MyBillsEntityDataFactory);
                b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
                byte[] bArr3 = NetworkUserEntityData$$ExternalSyntheticLambda1;
                if (bArr3 != null) {
                    int length2 = bArr3.length;
                    byte[] bArr4 = new byte[length2];
                    for (int i7 = 0; i7 < length2; i7++) {
                        bArr4[i7] = (byte) (bArr3[i7] ^ 3097486228508854431L);
                    }
                    bArr3 = bArr4;
                }
                boolean z = bArr3 != null;
                b2.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
                while (b2.KClassImpl$Data$declaredNonStaticMembers$2 < i4) {
                    if (z) {
                        byte[] bArr5 = NetworkUserEntityData$$ExternalSyntheticLambda1;
                        b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                        b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr5[r9] ^ 3097486228508854431L)) + s)) ^ b));
                    } else {
                        short[] sArr = initRecordTimeStamp;
                        b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                        b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((short) (((short) (sArr[r9] ^ 3097486228508854431L)) + s)) ^ b));
                    }
                    sb.append(b2.MyBillsEntityDataFactory);
                    b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
                    b2.KClassImpl$Data$declaredNonStaticMembers$2++;
                }
            }
            objArr[0] = sb.toString();
        }
    }

    /* loaded from: classes3.dex */
    public static class Lite2 extends LiteBase {
        private static short[] initRecordTimeStamp;
        public static final byte[] $$g = {75, -23, 102, -23, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
        public static final int $$h = 127;
        public static final byte[] lookAheadTest = {TarHeader.LF_CHR, 112, -114, 9, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
        public static final int NetworkUserEntityData$$ExternalSyntheticLambda0 = 35;
        private static int scheduleImpl = 1257195671;
        private static int GetContactSyncConfig = -1295094362;
        private static byte[] NetworkUserEntityData$$ExternalSyntheticLambda1 = {-66, -80, -68, -118, -127, -36, -36, 67, -70, -3, 116, -125, -124, -127, -80, -120, -79, 100, -117, 67, -109, -103, 96, 105, -110, -120, 65, -105, -111, 105, -113, 103, -117, -70, -119, 94, -100, -115, -87, 82, 97, 98, -97, -114, 102, -113, 14, 7, Ascii.CAN, 58, 15, 19, 16, 17, 13, 94, -64, 7, 4, Ascii.SUB, 13, 16, 59, -57, -77, 101, -54, -76, 104, -57, -81, -66, -73, 99, -55, -81, -70, -71, 98, -78, -71, -60, 104, -54, -79, 103, -56, 99, -74, -73, -77, -53, -79, -74, -69, -79, -73, 105, -73, -77, -72, -56, -73, -73, 97, -62, -66, -76, 99, -54, TarHeader.LF_DIR, -104, 125, TarHeader.LF_DIR, 69, -110, 67, 69, 67, 75, 70, 68, 66, SignedBytes.MAX_POWER_OF_TWO, 68, 72, 126, 74, TarHeader.LF_NORMAL, -110, 56, -113, 73, 66, 65, TarHeader.LF_CONTIG, 68, -103, SignedBytes.MAX_POWER_OF_TWO, TarHeader.LF_BLK, 67, -109, 68, TarHeader.LF_FIFO, -104, TarHeader.LF_LINK, -104, 45, -104, 65, 71, Byte.MAX_VALUE, TarHeader.LF_CONTIG, -111, 57, -112, 68, 70, 65, 68, TarHeader.LF_CONTIG, -107, 72, 46, 69, -104, 124, 77, TarHeader.LF_LINK, 66, -106, 67, TarHeader.LF_NORMAL, Ascii.EM, Ascii.GS, -50, 45, -32, Ascii.EM, Ascii.US, Ascii.ESC, -50, 40, Ascii.RS, -48, Ascii.ESC, TarHeader.LF_CHR, -54, Ascii.EM, Ascii.FS, 44, -27, Ascii.EM, Ascii.SUB, -46, 47, Ascii.GS, Ascii.ESC, Ascii.RS, -56, TarHeader.LF_CHR, Ascii.ETB, -49, TarHeader.LF_NORMAL, -55, TarHeader.LF_LINK, -52, Ascii.GS, 47, Ascii.RS, -54, 46, Ascii.EM, -53, Ascii.RS, 45, -49, 45, -50, Ascii.EM, TarHeader.LF_CHR, 22, -32, Ascii.ESC, Ascii.GS, -28, Ascii.GS, Ascii.GS, Ascii.EM, Ascii.ESC, -30, Ascii.US, -58, -32, 41, Ascii.RS, 8, 1, 62, Ascii.CAN, TarHeader.LF_FIFO, 81, 10, -53, SignedBytes.MAX_POWER_OF_TWO, -52, 6, 57, 9, 14, 2, 77, -63, 14, 56, 85, -59, 9, 59, 82, -2, Ascii.DC4, TarHeader.LF_FIFO, Ascii.ESC, 3, 9, 56, Ascii.NAK, TarHeader.LF_FIFO, Ascii.ESC, 57, 78, -51, 6, TarHeader.LF_DIR, 9, Ascii.CAN, TarHeader.LF_BLK, 11, Ascii.DC4, 61, 19, 65, -6, Ascii.DC4, 58, 10, 82, 7, 18, -64, 4, 11, 7, 59, Ascii.RS, Ascii.EM, -29, Ascii.ETB, -24, -97, -97, -97, -97, -97, -97, -97, -97, -97};
        private static int getErrorConfigVersion = 1878580981;

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002f). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void j(byte r6, short r7, short r8, java.lang.Object[] r9) {
            /*
                int r6 = r6 + 97
                int r7 = 56 - r7
                int r8 = 23 - r8
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverTransActivity.Lite2.lookAheadTest
                byte[] r1 = new byte[r8]
                int r8 = r8 + (-1)
                r2 = 0
                if (r0 != 0) goto L16
                r6 = r7
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r9
                r9 = r8
                goto L2f
            L16:
                r3 = 0
            L17:
                byte r4 = (byte) r6
                r1[r3] = r4
                if (r3 != r8) goto L24
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L24:
                int r3 = r3 + 1
                r4 = r0[r7]
                r5 = r9
                r9 = r8
                r8 = r4
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r5
            L2f:
                int r8 = -r8
                int r7 = r7 + 1
                int r6 = r6 + r8
                int r6 = r6 + (-4)
                r8 = r9
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L17
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverTransActivity.Lite2.j(byte, short, short, java.lang.Object[]):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0033). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void k(short r6, byte r7, short r8, java.lang.Object[] r9) {
            /*
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverTransActivity.Lite2.$$g
                int r6 = r6 * 3
                int r6 = r6 + 21
                int r7 = r7 * 2
                int r7 = 103 - r7
                int r8 = 47 - r8
                byte[] r1 = new byte[r6]
                int r6 = r6 + (-1)
                r2 = 0
                if (r0 != 0) goto L19
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r9
                r9 = r8
                goto L33
            L19:
                r3 = 0
            L1a:
                byte r4 = (byte) r7
                r1[r3] = r4
                if (r3 != r6) goto L27
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L27:
                int r3 = r3 + 1
                r4 = r0[r8]
                r5 = r8
                r8 = r7
                r7 = r4
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r9
                r9 = r5
            L33:
                int r8 = r8 + r7
                int r7 = r9 + 1
                int r8 = r8 + (-7)
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                r5 = r8
                r8 = r7
                r7 = r5
                goto L1a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverTransActivity.Lite2.k(short, byte, short, java.lang.Object[]):void");
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.LiteBase, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            Object[] objArr;
            Object[] objArr2;
            Object[] objArr3;
            Object[] objArr4;
            super.attachBaseContext(context);
            Object[] objArr5 = new Object[1];
            h(132045608 - (ViewConfiguration.getWindowTouchSlop() >> 8), ExpandableListView.getPackedPositionType(0L) - 622302826, (short) ((-33) - View.MeasureSpec.getMode(0)), (byte) (TextUtils.lastIndexOf("", '0') + 1), TextUtils.indexOf("", "", 0) + 10, objArr5);
            Class<?> cls = Class.forName((String) objArr5[0]);
            Object[] objArr6 = new Object[1];
            h(132045620 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (ViewConfiguration.getScrollBarFadeDuration() >> 16) - 622302809, (short) (TextUtils.indexOf((CharSequence) "", '0') + 1), (byte) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (-3) - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), objArr6);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context applicationContext = context != null ? context.getApplicationContext() : context;
                if (applicationContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getWindowTouchSlop() >> 8), 35 - TextUtils.indexOf("", "", 0), (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        h(115268350 - Color.rgb(0, 0, 0), TextUtils.indexOf("", "") - 622302763, (short) (TextUtils.lastIndexOf("", '0', 0, 0) - 40), (byte) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1), (ViewConfiguration.getPressedStateDuration() >> 16) + 40, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        h(132045608 - ((Process.getThreadPriority(0) + 20) >> 6), (-622302716) - (ViewConfiguration.getScrollBarSize() >> 8), (short) (37 - Gravity.getAbsoluteGravity(0, 0)), (byte) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 56, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        h(132045562 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), View.resolveSizeAndState(0, 0, 0) - 622302653, (short) (126 - TextUtils.getOffsetAfter("", 0)), (byte) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1), 56 - View.resolveSizeAndState(0, 0, 0), objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        h(132045615 - View.resolveSizeAndState(0, 0, 0), (-622302590) - (Process.myTid() >> 22), (short) (((byte) KeyEvent.getModifierMetaStateMask()) + 105), (byte) ExpandableListView.getPackedPositionType(0L), Color.rgb(0, 0, 0) + 16777268, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        h(132045568 - ExpandableListView.getPackedPositionGroup(0L), (-622302531) - (KeyEvent.getMaxKeyCode() >> 16), (short) (View.MeasureSpec.makeMeasureSpec(0, 0) + 126), (byte) (ViewConfiguration.getKeyRepeatDelay() >> 16), (ViewConfiguration.getKeyRepeatTimeout() >> 16) - 2, objArr11);
                        try {
                            Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + 911, ((byte) KeyEvent.getModifierMetaStateMask()) + 19, (char) (MotionEvent.axisFromString("") + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                    Object[] objArr13 = new Object[1];
                    j(lookAheadTest[3], (byte) (-lookAheadTest[31]), lookAheadTest[30], objArr13);
                    Class<?> cls2 = Class.forName((String) objArr13[0]);
                    byte b = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0 >>> 2);
                    Object[] objArr14 = new Object[1];
                    j(b, (byte) (b | 22), lookAheadTest[30], objArr14);
                    try {
                        Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                        if (obj3 == null) {
                            Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 54, (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 2, (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))));
                            Object[] objArr16 = new Object[1];
                            k($$g[78], $$g[12], $$g[53], objArr16);
                            obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                        }
                        Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - Color.alpha(0), 15 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("getAuthRequestContext", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                            }
                            int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                            try {
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, (Process.myTid() >> 22) + 15, (char) (TextUtils.lastIndexOf("", '0') + 1))).getMethod("PlaceComponentResult", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                                }
                                if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                    ArrayList arrayList = new ArrayList();
                                    try {
                                        Object[] objArr17 = {invoke2};
                                        Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                        if (obj6 == null) {
                                            obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776401) - Color.rgb(0, 0, 0), View.MeasureSpec.getMode(0) + 29, (char) (57994 - KeyEvent.normalizeMetaState(0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getPressedStateDuration() >> 16), 15 - ((Process.getThreadPriority(0) + 20) >> 6), (char) Color.blue(0)));
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                        }
                                        arrayList.add(((Method) obj6).invoke(null, objArr17));
                                        long j = ((r9 ^ intValue2) & 4294967295L) | 60129542144L;
                                        try {
                                            Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                            if (obj7 != null) {
                                                objArr = null;
                                            } else {
                                                objArr = null;
                                                obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getScrollBarSize() >> 8) + 35, (char) View.resolveSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                            }
                                            Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                            try {
                                                Object[] objArr18 = {1419832950, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                                Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                                if (obj8 == null) {
                                                    obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + 912, 18 - TextUtils.indexOf("", "", 0), (char) (MotionEvent.axisFromString("") + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    Object[] objArr19 = new Object[1];
                    j(lookAheadTest[3], (byte) (-lookAheadTest[31]), lookAheadTest[30], objArr19);
                    Class<?> cls4 = Class.forName((String) objArr19[0]);
                    byte b2 = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0 >>> 2);
                    Object[] objArr20 = new Object[1];
                    j(b2, (byte) (b2 | 22), lookAheadTest[30], objArr20);
                    try {
                        Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                        Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                        if (obj9 == null) {
                            Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), ((Process.getThreadPriority(0) + 20) >> 6) + 46, (char) (AndroidCharacter.getMirror('0') - '0'));
                            byte b3 = (byte) ($$g[78] - 1);
                            Object[] objArr22 = new Object[1];
                            k(b3, b3, $$g[84], objArr22);
                            obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                        }
                        Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                        int i = ((int[]) objArr23[1])[0];
                        if (((int[]) objArr23[0])[0] != i) {
                            long j2 = ((r3 ^ i) & 4294967295L) | 17179869184L;
                            try {
                                Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj10 != null) {
                                    objArr4 = null;
                                } else {
                                    objArr4 = null;
                                    obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getOffsetBefore("", 0), (ViewConfiguration.getFadingEdgeLength() >> 16) + 35, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                                }
                                Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                                try {
                                    Object[] objArr24 = {1419832950, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj11 == null) {
                                        obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + 911, 18 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (Color.rgb(0, 0, 0) + 16777216))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    Object[] objArr25 = new Object[1];
                    j(lookAheadTest[3], (byte) (-lookAheadTest[31]), lookAheadTest[30], objArr25);
                    Class<?> cls6 = Class.forName((String) objArr25[0]);
                    byte b4 = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0 >>> 2);
                    Object[] objArr26 = new Object[1];
                    j(b4, (byte) (b4 | 22), lookAheadTest[30], objArr26);
                    try {
                        Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                        Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                        if (obj12 == null) {
                            Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + 118, Drawable.resolveOpacity(0, 0) + 3, (char) ((ViewConfiguration.getTapTimeout() >> 16) + 38968));
                            byte b5 = (byte) ($$g[78] - 1);
                            Object[] objArr28 = new Object[1];
                            k(b5, b5, $$g[84], objArr28);
                            obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                        }
                        Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                        int i2 = ((int[]) objArr29[1])[0];
                        if (((int[]) objArr29[0])[0] != i2) {
                            long j3 = ((r3 ^ i2) & 4294967295L) | 8589934592L;
                            try {
                                Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj13 != null) {
                                    objArr3 = null;
                                } else {
                                    objArr3 = null;
                                    obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 881, 35 - KeyEvent.keyCodeFromString(""), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                                }
                                Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                                try {
                                    Object[] objArr30 = {1419832950, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj14 == null) {
                                        obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.getMode(0), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 18, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    Object[] objArr31 = new Object[1];
                    j(lookAheadTest[3], (byte) (-lookAheadTest[31]), lookAheadTest[30], objArr31);
                    Class<?> cls8 = Class.forName((String) objArr31[0]);
                    byte b6 = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0 >>> 2);
                    Object[] objArr32 = new Object[1];
                    j(b6, (byte) (b6 | 22), lookAheadTest[30], objArr32);
                    try {
                        Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                        Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                        if (obj15 == null) {
                            Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + 108, 2 - MotionEvent.axisFromString(""), (char) ('0' - AndroidCharacter.getMirror('0')));
                            Object[] objArr34 = new Object[1];
                            k($$g[8], $$g[9], (byte) ($$g[78] - 1), objArr34);
                            obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                        }
                        Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                        int i3 = ((int[]) objArr35[1])[0];
                        if (((int[]) objArr35[0])[0] != i3) {
                            long j4 = ((r3 ^ i3) & 4294967295L) | 4294967296L;
                            try {
                                Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj16 != null) {
                                    objArr2 = null;
                                } else {
                                    objArr2 = null;
                                    obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0', 0, 0), TextUtils.lastIndexOf("", '0', 0, 0) + 36, (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                                }
                                Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                                try {
                                    Object[] objArr36 = {1419832950, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj17 == null) {
                                        obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarSize() >> 8), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 18, (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.LiteBase, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return super.getApplicationContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.LiteBase, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
        public Context getBaseContext() {
            return super.getBaseContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.LiteBase, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
        public Resources getResources() {
            return super.getResources();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.LiteBase, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onPause() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                int length = super.getResources().getString(R.string.modify_group_photo_success_message).substring(5, 6).length() + 132045607;
                int length2 = super.getResources().getString(R.string.paylater_loan_personal_button_overdue).substring(1, 3).length() - 622302807;
                short codePointAt = (short) (getPackageName().codePointAt(2) - 49);
                byte length3 = (byte) (super.getResources().getString(R.string.mybills_edit_bill_name_label).substring(4, 5).length() - 1);
                try {
                    byte b = lookAheadTest[25];
                    Object[] objArr = new Object[1];
                    j(b, (byte) (b | TarHeader.LF_BLK), lookAheadTest[25], objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    Object[] objArr2 = new Object[1];
                    j(lookAheadTest[5], lookAheadTest[25], lookAheadTest[41], objArr2);
                    int i = ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion - 15;
                    Object[] objArr3 = new Object[1];
                    h(length, length2, codePointAt, length3, i, objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    try {
                        byte b2 = lookAheadTest[25];
                        Object[] objArr4 = new Object[1];
                        j(b2, (byte) (b2 | TarHeader.LF_BLK), lookAheadTest[25], objArr4);
                        Class<?> cls3 = Class.forName((String) objArr4[0]);
                        Object[] objArr5 = new Object[1];
                        j(lookAheadTest[5], lookAheadTest[25], lookAheadTest[41], objArr5);
                        int i2 = ((ApplicationInfo) cls3.getMethod((String) objArr5[0], null).invoke(this, null)).targetSdkVersion + 132045577;
                        int maxKeyCode = (-622302780) - (KeyEvent.getMaxKeyCode() >> 16);
                        short argb = (short) (110 - Color.argb(0, 0, 0, 0));
                        try {
                            byte b3 = lookAheadTest[25];
                            Object[] objArr6 = new Object[1];
                            j(b3, (byte) (b3 | TarHeader.LF_BLK), lookAheadTest[25], objArr6);
                            Class<?> cls4 = Class.forName((String) objArr6[0]);
                            j(lookAheadTest[5], lookAheadTest[25], lookAheadTest[41], new Object[1]);
                            Object[] objArr7 = new Object[1];
                            h(i2, maxKeyCode, argb, (byte) (((ApplicationInfo) cls4.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 33), getPackageName().codePointAt(4) - 87, objArr7);
                            baseContext = (Context) cls2.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
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
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0'), 34 - ImageFormat.getBitsPerPixel(0), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr8 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.keyCodeFromString(""), TextUtils.lastIndexOf("", '0', 0, 0) + 19, (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Context.class);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr8);
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
            super.onPause();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.LiteBase, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onResume() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr = new Object[1];
                h((KeyEvent.getMaxKeyCode() >> 16) + 132045608, (-622302905) + getPackageName().codePointAt(3), (short) ((-3) - KeyEvent.getDeadChar(0, 0)), (byte) (getPackageName().codePointAt(4) - 97), super.getResources().getString(R.string.insurance_benefit).substring(5, 6).codePointAt(0) - 79, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                h(132045610 - View.combineMeasuredStates(0, 0), super.getResources().getString(R.string.empty_state_investment_desc).substring(5, 6).codePointAt(0) - 622302877, (short) (getPackageName().codePointAt(3) + 10), (byte) ((-1) - ImageFormat.getBitsPerPixel(0)), super.getResources().getString(R.string.unsafe_device_tamper_title).substring(15, 16).length() + 9, objArr2);
                baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - KeyEvent.normalizeMetaState(0), 35 - TextUtils.indexOf("", "", 0), (char) TextUtils.indexOf("", ""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr3 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.resolveSizeAndState(0, 0, 0), KeyEvent.keyCodeFromString("") + 18, (char) TextUtils.getTrimmedLength(""))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.LiteBase, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle bundle) {
            Object[] objArr;
            Object[] objArr2 = new Object[1];
            h(super.getResources().getString(R.string.share_Feed_activities_title).substring(19, 20).codePointAt(0) + 132045507, (-622302826) - KeyEvent.keyCodeFromString(""), (short) (getPackageName().length() - 40), (byte) (super.getResources().getString(R.string.pop_up_title_cancel_edit_saving_goal).substring(7, 8).codePointAt(0) + BranchLinkConstant.DeepLinkErrorCode.SAME_ALIAS), getPackageName().length() + 3, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            int length = super.getResources().getString(R.string.error_empty_last_name).substring(12, 13).length() + 132045619;
            try {
                byte b = lookAheadTest[25];
                Object[] objArr3 = new Object[1];
                j(b, (byte) (b | TarHeader.LF_BLK), lookAheadTest[25], objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                j(lookAheadTest[5], lookAheadTest[25], lookAheadTest[41], objArr4);
                int i = ((ApplicationInfo) cls2.getMethod((String) objArr4[0], null).invoke(this, null)).targetSdkVersion - 622302842;
                short codePointAt = (short) (getPackageName().codePointAt(2) - 46);
                try {
                    byte b2 = lookAheadTest[25];
                    Object[] objArr5 = new Object[1];
                    j(b2, (byte) (b2 | TarHeader.LF_BLK), lookAheadTest[25], objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    j(lookAheadTest[5], lookAheadTest[25], lookAheadTest[41], new Object[1]);
                    Object[] objArr6 = new Object[1];
                    h(length, i, codePointAt, (byte) (((ApplicationInfo) cls3.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 33), getPackageName().codePointAt(3) - 103, objArr6);
                    int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                    if (intValue < 99000 || intValue > 99999) {
                        Context baseContext = getBaseContext();
                        if (baseContext == null) {
                            Object[] objArr7 = new Object[1];
                            h(getPackageName().length() + 132045601, getPackageName().length() - 622302812, (short) (super.getResources().getString(R.string.desc_home_feed_onboarding_3).substring(28, 29).codePointAt(0) - 117), (byte) (super.getResources().getString(R.string.caption_popular_merchant).substring(1, 2).length() - 1), getPackageName().codePointAt(3) - 82, objArr7);
                            Class<?> cls4 = Class.forName((String) objArr7[0]);
                            Object[] objArr8 = new Object[1];
                            h(super.getResources().getString(R.string.general_error_desc).substring(3, 4).length() + 132045609, super.getResources().getString(R.string.share_feed_consent_dialog_title).substring(2, 3).codePointAt(0) - 622302877, (short) (TextUtils.indexOf("", "", 0, 0) + 110), (byte) (super.getResources().getString(R.string.chat_diana).substring(0, 10).codePointAt(8) - 78), super.getResources().getString(R.string.unbind_lazada_dialog_confirmation_ineligible_message).substring(16, 18).length() + 8, objArr8);
                            baseContext = (Context) cls4.getMethod((String) objArr8[0], new Class[0]).invoke(null, null);
                        }
                        if (baseContext != null) {
                            baseContext = baseContext.getApplicationContext();
                        }
                        if (baseContext != null) {
                            try {
                                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj == null) {
                                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + 930, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 34, (char) KeyEvent.normalizeMetaState(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                                }
                                Object invoke = ((Method) obj).invoke(null, null);
                                Object[] objArr9 = new Object[1];
                                h(super.getResources().getString(R.string.bottom_on_boarding_body_text_dana_kaget_fourth).substring(35, 37).length() + 132045564, super.getResources().getString(R.string.referral_see_more).substring(7, 8).codePointAt(0) - 622302832, (short) (super.getResources().getString(R.string.payment_result_additional_fee_content).substring(2, 3).codePointAt(0) - 138), (byte) (super.getResources().getString(R.string.dana_viz_prompt_monitored_by_description).substring(0, 5).length() - 5), (Process.myTid() >> 22) + 40, objArr9);
                                String str = (String) objArr9[0];
                                int codePointAt2 = super.getResources().getString(R.string.family_account_text_tnc).substring(42, 43).codePointAt(0) + 132045491;
                                int codePointAt3 = super.getResources().getString(R.string.risk_reject_retry_7_day_message).substring(20, 22).codePointAt(1) - 622302748;
                                try {
                                    byte b3 = lookAheadTest[25];
                                    Object[] objArr10 = new Object[1];
                                    j(b3, (byte) (b3 | TarHeader.LF_BLK), lookAheadTest[25], objArr10);
                                    Class<?> cls5 = Class.forName((String) objArr10[0]);
                                    Object[] objArr11 = new Object[1];
                                    j(lookAheadTest[5], lookAheadTest[25], lookAheadTest[41], objArr11);
                                    short s = (short) (((ApplicationInfo) cls5.getMethod((String) objArr11[0], null).invoke(this, null)).targetSdkVersion + 4);
                                    try {
                                        byte b4 = lookAheadTest[25];
                                        Object[] objArr12 = new Object[1];
                                        j(b4, (byte) (b4 | TarHeader.LF_BLK), lookAheadTest[25], objArr12);
                                        Class<?> cls6 = Class.forName((String) objArr12[0]);
                                        j(lookAheadTest[5], lookAheadTest[25], lookAheadTest[41], new Object[1]);
                                        Object[] objArr13 = new Object[1];
                                        h(codePointAt2, codePointAt3, s, (byte) (((ApplicationInfo) cls6.getMethod((String) r7[0], null).invoke(this, null)).targetSdkVersion - 33), getPackageName().length() + 49, objArr13);
                                        String str2 = (String) objArr13[0];
                                        int codePointAt4 = getPackageName().codePointAt(1) + 132045461;
                                        int tapTimeout = (ViewConfiguration.getTapTimeout() >> 16) - 622302653;
                                        try {
                                            byte b5 = lookAheadTest[25];
                                            Object[] objArr14 = new Object[1];
                                            j(b5, (byte) (b5 | TarHeader.LF_BLK), lookAheadTest[25], objArr14);
                                            Class<?> cls7 = Class.forName((String) objArr14[0]);
                                            Object[] objArr15 = new Object[1];
                                            j(lookAheadTest[5], lookAheadTest[25], lookAheadTest[41], objArr15);
                                            Object[] objArr16 = new Object[1];
                                            h(codePointAt4, tapTimeout, (short) (((ApplicationInfo) cls7.getMethod((String) objArr15[0], null).invoke(this, null)).targetSdkVersion + 93), (byte) (super.getResources().getString(R.string.image_capture_toolbar_title).substring(0, 11).length() - 11), super.getResources().getString(R.string.label_direction).substring(0, 9).codePointAt(8) - 54, objArr16);
                                            String str3 = (String) objArr16[0];
                                            Object[] objArr17 = new Object[1];
                                            h(getPackageName().codePointAt(3) + 132045515, (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) - 622302590, (short) ((ViewConfiguration.getEdgeSlop() >> 16) + 104), (byte) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), getPackageName().length() + 45, objArr17);
                                            String str4 = (String) objArr17[0];
                                            Object[] objArr18 = new Object[1];
                                            h(getPackageName().length() + 132045561, super.getResources().getString(R.string.lbl_account_deactivation_error_message).substring(3, 4).codePointAt(0) - 622302628, (short) (126 - (ViewConfiguration.getFadingEdgeLength() >> 16)), (byte) (getPackageName().length() - 7), getPackageName().length() - 9, objArr18);
                                            try {
                                                Object[] objArr19 = {baseContext, str, str2, str3, str4, true, (String) objArr18[0], 995651014};
                                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                                if (obj2 == null) {
                                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + 911, ExpandableListView.getPackedPositionType(0L) + 18, (char) View.getDefaultSize(0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                                }
                                                ((Method) obj2).invoke(invoke, objArr19);
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
                            } catch (Throwable th5) {
                                Throwable cause5 = th5.getCause();
                                if (cause5 == null) {
                                    throw th5;
                                }
                                throw cause5;
                            }
                        }
                    }
                    try {
                        Object[] objArr20 = new Object[1];
                        j(lookAheadTest[3], (byte) (-lookAheadTest[31]), lookAheadTest[30], objArr20);
                        Class<?> cls8 = Class.forName((String) objArr20[0]);
                        byte b6 = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0 >>> 2);
                        Object[] objArr21 = new Object[1];
                        j(b6, (byte) (b6 | 22), lookAheadTest[30], objArr21);
                        try {
                            Object[] objArr22 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr21[0], Object.class).invoke(null, this)).intValue())};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                            if (obj3 == null) {
                                Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myTid() >> 22) + 494, (ViewConfiguration.getWindowTouchSlop() >> 8) + 4, (char) View.combineMeasuredStates(0, 0));
                                Object[] objArr23 = new Object[1];
                                k($$g[8], $$g[9], (byte) ($$g[78] - 1), objArr23);
                                obj3 = cls9.getMethod((String) objArr23[0], Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                            }
                            Object[] objArr24 = (Object[]) ((Method) obj3).invoke(null, objArr22);
                            int i2 = ((int[]) objArr24[1])[0];
                            if (((int[]) objArr24[0])[0] != i2) {
                                long j = ((r2 ^ i2) & 4294967295L) | 42949672960L;
                                try {
                                    Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                    if (obj4 != null) {
                                        objArr = null;
                                    } else {
                                        objArr = null;
                                        obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0', 0), 35 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) TextUtils.indexOf("", "", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                    }
                                    Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                                    try {
                                        Object[] objArr25 = {1323689711, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                        Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                        if (obj5 == null) {
                                            obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 910, TextUtils.lastIndexOf("", '0', 0) + 19, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                        }
                                        ((Method) obj5).invoke(invoke2, objArr25);
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
                            super.onCreate(bundle);
                            RVLogger.d(GriverTransActivity.TAG, "onCreate NebulaTransActivity$Lite2");
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
            } catch (Throwable th11) {
                Throwable cause11 = th11.getCause();
                if (cause11 == null) {
                    throw th11;
                }
                throw cause11;
            }
        }

        private static void h(int i, int i2, short s, byte b, int i3, Object[] objArr) {
            B b2 = new B();
            StringBuilder sb = new StringBuilder();
            int i4 = i3 + ((int) (scheduleImpl ^ 3097486228508854431L));
            int i5 = i4 == -1 ? 1 : 0;
            if (i5 != 0) {
                byte[] bArr = NetworkUserEntityData$$ExternalSyntheticLambda1;
                if (bArr != null) {
                    int length = bArr.length;
                    byte[] bArr2 = new byte[length];
                    for (int i6 = 0; i6 < length; i6++) {
                        bArr2[i6] = (byte) (bArr[i6] ^ 3097486228508854431L);
                    }
                    bArr = bArr2;
                }
                if (bArr != null) {
                    i4 = (byte) (((byte) (NetworkUserEntityData$$ExternalSyntheticLambda1[i2 + ((int) (getErrorConfigVersion ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (scheduleImpl ^ 3097486228508854431L)));
                } else {
                    i4 = (short) (((short) (initRecordTimeStamp[i2 + ((int) (getErrorConfigVersion ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (scheduleImpl ^ 3097486228508854431L)));
                }
            }
            if (i4 > 0) {
                b2.getAuthRequestContext = ((i2 + i4) - 2) + ((int) (getErrorConfigVersion ^ 3097486228508854431L)) + i5;
                b2.MyBillsEntityDataFactory = (char) (i + ((int) (GetContactSyncConfig ^ 3097486228508854431L)));
                sb.append(b2.MyBillsEntityDataFactory);
                b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
                byte[] bArr3 = NetworkUserEntityData$$ExternalSyntheticLambda1;
                if (bArr3 != null) {
                    int length2 = bArr3.length;
                    byte[] bArr4 = new byte[length2];
                    for (int i7 = 0; i7 < length2; i7++) {
                        bArr4[i7] = (byte) (bArr3[i7] ^ 3097486228508854431L);
                    }
                    bArr3 = bArr4;
                }
                boolean z = bArr3 != null;
                b2.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
                while (b2.KClassImpl$Data$declaredNonStaticMembers$2 < i4) {
                    if (z) {
                        byte[] bArr5 = NetworkUserEntityData$$ExternalSyntheticLambda1;
                        b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                        b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr5[r9] ^ 3097486228508854431L)) + s)) ^ b));
                    } else {
                        short[] sArr = initRecordTimeStamp;
                        b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                        b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((short) (((short) (sArr[r9] ^ 3097486228508854431L)) + s)) ^ b));
                    }
                    sb.append(b2.MyBillsEntityDataFactory);
                    b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
                    b2.KClassImpl$Data$declaredNonStaticMembers$2++;
                }
            }
            objArr[0] = sb.toString();
        }
    }

    /* loaded from: classes3.dex */
    public static class Lite3 extends LiteBase {
        public static final byte[] $$g = {75, -120, 119, 39, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
        public static final int $$h = 242;
        public static final byte[] lookAheadTest = {75, -120, 119, 39, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
        public static final int scheduleImpl = 23;
        private static char[] getErrorConfigVersion = {39463, 39448, 39458, 39444, 39449, 39455, 39896, 39445, 39478, 39461, 39459, 39451, 39439, 39475, 39446, 39879, 39442, 39440, 39474, 39454, 39443, 39450, 39889, 39888, 39886, 39894, 39887, 39456, 39892, 39895, 39893, 39890, 39460, 39891, 39884, 39897, 39457, 39447};
        private static boolean NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
        private static boolean GetContactSyncConfig = true;
        private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 909155206;

        /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0031). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void h(short r6, short r7, short r8, java.lang.Object[] r9) {
            /*
                int r7 = r7 + 16
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverTransActivity.Lite3.lookAheadTest
                int r8 = r8 + 97
                int r6 = 55 - r6
                byte[] r1 = new byte[r7]
                r2 = 0
                if (r0 != 0) goto L13
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r9
                r9 = r7
                goto L31
            L13:
                r3 = 0
                r5 = r8
                r8 = r7
                r7 = r5
            L17:
                int r6 = r6 + 1
                byte r4 = (byte) r7
                r1[r3] = r4
                int r3 = r3 + 1
                if (r3 != r8) goto L28
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L28:
                r4 = r0[r6]
                r5 = r9
                r9 = r8
                r8 = r4
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r5
            L31:
                int r7 = r7 + r8
                int r7 = r7 + (-4)
                r8 = r9
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L17
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverTransActivity.Lite3.h(short, short, short, java.lang.Object[]):void");
        }

        private static void k(byte b, byte b2, short s, Object[] objArr) {
            int i = 46 - s;
            byte[] bArr = $$g;
            int i2 = (b * 2) + 75;
            int i3 = 42 - (b2 * 3);
            byte[] bArr2 = new byte[i3];
            int i4 = -1;
            int i5 = i3 - 1;
            if (bArr == null) {
                i2 = (i2 + (-i5)) - 7;
                i5 = i5;
                i = i;
                objArr = objArr;
                bArr = bArr;
                bArr2 = bArr2;
                i4 = -1;
            }
            while (true) {
                int i6 = i4 + 1;
                bArr2[i6] = (byte) i2;
                if (i6 == i5) {
                    objArr[0] = new String(bArr2, 0);
                    return;
                }
                int i7 = i + 1;
                i2 = (i2 + (-bArr[i7])) - 7;
                i5 = i5;
                i = i7;
                objArr = objArr;
                bArr = bArr;
                bArr2 = bArr2;
                i4 = i6;
            }
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.LiteBase, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            Object[] objArr;
            Object[] objArr2;
            Object[] objArr3;
            Object[] objArr4;
            super.attachBaseContext(context);
            Object[] objArr5 = new Object[1];
            j(null, 128 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), new byte[]{-120, -120, -117, -118, -123, -124, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr5);
            Class<?> cls = Class.forName((String) objArr5[0]);
            Object[] objArr6 = new Object[1];
            j(null, 127 - (Process.myTid() >> 22), new byte[]{-125, -122, -114, -115, -116}, null, objArr6);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context applicationContext = context != null ? context.getApplicationContext() : context;
                if (applicationContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 35, (char) TextUtils.getOffsetAfter("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        j(null, 127 - View.combineMeasuredStates(0, 0), new byte[]{-117, -104, -97, -95, -104, -96, -100, -105, -102, -103, -101, -100, -101, -99, -104, -101, -117, -127, -125, -99, -125, -103, -97, -125, -104, -118, -118, -125, -127, -104, -98, -98, -104, -98, -99, -117, -100, -118, -117, -105, -103, -101, -125, -102, -103, -104, -118, -105}, null, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        j(null, 127 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), new byte[]{-97, -125, -103, -98, -95, -118, -98, -102, -98, -102, -105, -101, -101, -105, -97, -97, -105, -98, -105, -118, -98, -117, -102, -94, -97, -102, -118, -118, -103, -96, -125, -118, -99, -99, -125, -103, -117, -101, -95, -104, -97, -104, -98, -125, -98, -100, -99, -99, -96, -98, -98, -125, -94, -101, -118, -125, -103, -102, -101, -100, -125, -104, -94, -127}, null, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        j(null, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 127, new byte[]{-101, -94, -94, -100, -104, -101, -94, -105, -94, -100, -98, -99, -117, -118, -101, -100, -95, -127, -102, -103, -96, -98, -100, -103, -103, -104, -105, -95, -103, -99, -125, -105, -118, -105, -100, -100, -103, -101, -100, -105, -97, -127, -95, -99, -125, -96, -117, -127, -105, -102, -97, -98, -98, -103, -103, -103, -96, -99, -105, -101, -95, -117, -98, -99}, null, objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        j(null, 127 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), new byte[]{-120, -111, -126, -117, -110, -117, -92, -99, -110, -92, -111, -120, -117, -91, -126, -122, -92, -122, -113, -127, -92, -116, -123, -118, -121, -117, -124, -127, -107, -90, -120, -125, -124, -127, -107, -91, -121, -111, -120, -127, -118, -111, -127, -117, -124, -108, -111, -121, -127, -126, -127, -125, -92, -92, -93, -120, -113, -111, -111, -108}, null, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        j(null, 127 - ExpandableListView.getPackedPositionGroup(0L), new byte[]{-98, -99, -121, -96, -121, -101}, null, objArr11);
                        try {
                            Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - ((Process.getThreadPriority(0) + 20) >> 6), TextUtils.getTrimmedLength("") + 18, (char) TextUtils.indexOf("", "", 0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                    Object[] objArr13 = new Object[1];
                    h(lookAheadTest[31], lookAheadTest[25], lookAheadTest[32], objArr13);
                    Class<?> cls2 = Class.forName((String) objArr13[0]);
                    byte b = (byte) (lookAheadTest[34] + 1);
                    byte b2 = lookAheadTest[25];
                    Object[] objArr14 = new Object[1];
                    h(b, b2, (byte) (b2 | 8), objArr14);
                    try {
                        Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                        if (obj3 == null) {
                            Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + 55, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 2, (char) Gravity.getAbsoluteGravity(0, 0));
                            Object[] objArr16 = new Object[1];
                            k($$g[47], $$g[68], (byte) (-$$g[53]), objArr16);
                            obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                        }
                        Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - Color.blue(0), Color.blue(0) + 15, (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("getAuthRequestContext", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                            }
                            int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                            try {
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, 15 - TextUtils.indexOf("", "", 0), (char) Color.argb(0, 0, 0, 0))).getMethod("PlaceComponentResult", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                                }
                                if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                    ArrayList arrayList = new ArrayList();
                                    try {
                                        Object[] objArr17 = {invoke2};
                                        Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                        if (obj6 == null) {
                                            obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0, 0) + 816, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 28, (char) (ImageFormat.getBitsPerPixel(0) + 57995))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, Gravity.getAbsoluteGravity(0, 0) + 15, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)));
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                        }
                                        arrayList.add(((Method) obj6).invoke(null, objArr17));
                                        long j = ((r5 ^ intValue2) & 4294967295L) | 60129542144L;
                                        try {
                                            Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                            if (obj7 != null) {
                                                objArr = null;
                                            } else {
                                                objArr = null;
                                                obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + 930, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 36, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                            }
                                            Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                            try {
                                                Object[] objArr18 = {-398446473, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                                Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                                if (obj8 == null) {
                                                    obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollDefaultDelay() >> 16) + 911, 17 - ImageFormat.getBitsPerPixel(0), (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    Object[] objArr19 = new Object[1];
                    h(lookAheadTest[31], lookAheadTest[25], lookAheadTest[32], objArr19);
                    Class<?> cls4 = Class.forName((String) objArr19[0]);
                    byte b3 = (byte) (lookAheadTest[34] + 1);
                    byte b4 = lookAheadTest[25];
                    Object[] objArr20 = new Object[1];
                    h(b3, b4, (byte) (b4 | 8), objArr20);
                    try {
                        Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                        Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                        if (obj9 == null) {
                            Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - KeyEvent.getDeadChar(0, 0), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 46, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                            Object[] objArr22 = new Object[1];
                            k((byte) (-$$g[9]), (byte) (-$$g[8]), $$g[20], objArr22);
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
                                    obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - ImageFormat.getBitsPerPixel(0), (char) View.MeasureSpec.getSize(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                                }
                                Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                                try {
                                    Object[] objArr24 = {-398446473, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj11 == null) {
                                        obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 17 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    Object[] objArr25 = new Object[1];
                    h(lookAheadTest[31], lookAheadTest[25], lookAheadTest[32], objArr25);
                    Class<?> cls6 = Class.forName((String) objArr25[0]);
                    byte b5 = (byte) (lookAheadTest[34] + 1);
                    byte b6 = lookAheadTest[25];
                    Object[] objArr26 = new Object[1];
                    h(b5, b6, (byte) (b6 | 8), objArr26);
                    try {
                        Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                        Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                        if (obj12 == null) {
                            Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (ViewConfiguration.getTouchSlop() >> 8), 2 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) (TextUtils.getOffsetAfter("", 0) + 38968));
                            Object[] objArr28 = new Object[1];
                            k((byte) (-$$g[9]), (byte) (-$$g[8]), $$g[20], objArr28);
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
                                    obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + 930, 35 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                                }
                                Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                                try {
                                    Object[] objArr30 = {-398446473, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj14 == null) {
                                        obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + 911, (Process.myPid() >> 22) + 18, (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    Object[] objArr31 = new Object[1];
                    h(lookAheadTest[31], lookAheadTest[25], lookAheadTest[32], objArr31);
                    Class<?> cls8 = Class.forName((String) objArr31[0]);
                    byte b7 = (byte) (lookAheadTest[34] + 1);
                    byte b8 = lookAheadTest[25];
                    Object[] objArr32 = new Object[1];
                    h(b7, b8, (byte) (b8 | 8), objArr32);
                    try {
                        Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                        Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                        if (obj15 == null) {
                            Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(106 - TextUtils.lastIndexOf("", '0', 0), Process.getGidForName("") + 4, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16));
                            byte b9 = (byte) ($$g[47] - 1);
                            byte b10 = b9;
                            Object[] objArr34 = new Object[1];
                            k(b9, b10, b10, objArr34);
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
                                    obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - Process.getGidForName(""), Color.argb(0, 0, 0, 0) + 35, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                                }
                                Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                                try {
                                    Object[] objArr36 = {-398446473, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj17 == null) {
                                        obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 911, 19 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.LiteBase, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return super.getApplicationContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.LiteBase, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
        public Context getBaseContext() {
            return super.getBaseContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.LiteBase, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
        public Resources getResources() {
            return super.getResources();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.LiteBase, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onPause() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr = new Object[1];
                j(null, Process.getGidForName("") + 128, new byte[]{-125, -127, -117, -124, -108, -109, -115, -111, -122, -110, -122, -111, -118, -112, -121, -113, -113, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                j(null, ExpandableListView.getPackedPositionGroup(0L) + 127, new byte[]{-126, -123, -122, -111, -127, -118, -122, -106, -113, -113, -112, -111, -126, -117, -124, -124, -107, -118}, null, objArr2);
                baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + 930, 35 - ExpandableListView.getPackedPositionType(0L), (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr3 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 911, 18 - KeyEvent.normalizeMetaState(0), (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Context.class);
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
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.LiteBase, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onResume() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr = new Object[1];
                j(null, super.getResources().getString(R.string.max_send_amount_error_message_idr).substring(12, 13).length() + 126, new byte[]{-125, -127, -117, -124, -108, -109, -115, -111, -122, -110, -122, -111, -118, -112, -121, -113, -113, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                j(null, 127 - (ViewConfiguration.getPressedStateDuration() >> 16), new byte[]{-126, -123, -122, -111, -127, -118, -122, -106, -113, -113, -112, -111, -126, -117, -124, -124, -107, -118}, null, objArr2);
                baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, View.combineMeasuredStates(0, 0) + 35, (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr3 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getJumpTapTimeout() >> 16), (ViewConfiguration.getFadingEdgeLength() >> 16) + 18, (char) KeyEvent.normalizeMetaState(0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.LiteBase, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle bundle) {
            try {
                Object[] objArr = new Object[1];
                h((byte) (lookAheadTest[59] + 1), (byte) (-lookAheadTest[30]), lookAheadTest[25], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                h(lookAheadTest[25], lookAheadTest[56], (byte) (-lookAheadTest[5]), objArr2);
                Object[] objArr3 = new Object[1];
                j(null, ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion + 94, new byte[]{-120, -120, -117, -118, -123, -124, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                j(null, super.getResources().getString(R.string.dana_plus_description).substring(9, 10).codePointAt(0) + 17, new byte[]{-125, -122, -114, -115, -116}, null, objArr4);
                int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                if (intValue < 99000 || intValue > 99999) {
                    Context baseContext = getBaseContext();
                    if (baseContext == null) {
                        Object[] objArr5 = new Object[1];
                        j(null, super.getResources().getString(R.string.redirect_not_found).substring(0, 2).codePointAt(0) + 62, new byte[]{-125, -127, -117, -124, -108, -109, -115, -111, -122, -110, -122, -111, -118, -112, -121, -113, -113, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr5);
                        Class<?> cls3 = Class.forName((String) objArr5[0]);
                        Object[] objArr6 = new Object[1];
                        j(null, 126 - MotionEvent.axisFromString(""), new byte[]{-126, -123, -122, -111, -127, -118, -122, -106, -113, -113, -112, -111, -126, -117, -124, -124, -107, -118}, null, objArr6);
                        baseContext = (Context) cls3.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext != null) {
                        baseContext = baseContext.getApplicationContext();
                    }
                    if (baseContext != null) {
                        try {
                            Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj == null) {
                                obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - View.MeasureSpec.getSize(0), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                            }
                            Object invoke = ((Method) obj).invoke(null, null);
                            Object[] objArr7 = new Object[1];
                            j(null, 127 - ((Process.getThreadPriority(0) + 20) >> 6), new byte[]{-117, -104, -97, -95, -104, -96, -100, -105, -102, -103, -101, -100, -101, -99, -104, -101, -117, -127, -125, -99, -125, -103, -97, -125, -104, -118, -118, -125, -127, -104, -98, -98, -104, -98, -99, -117, -100, -118, -117, -105, -103, -101, -125, -102, -103, -104, -118, -105}, null, objArr7);
                            String str = (String) objArr7[0];
                            Object[] objArr8 = new Object[1];
                            j(null, super.getResources().getString(R.string.daily_check_in_point_desc).substring(0, 4).codePointAt(2) + 22, new byte[]{-97, -125, -103, -98, -95, -118, -98, -102, -98, -102, -105, -101, -101, -105, -97, -97, -105, -98, -105, -118, -98, -117, -102, -94, -97, -102, -118, -118, -103, -96, -125, -118, -99, -99, -125, -103, -117, -101, -95, -104, -97, -104, -98, -125, -98, -100, -99, -99, -96, -98, -98, -125, -94, -101, -118, -125, -103, -102, -101, -100, -125, -104, -94, -127}, null, objArr8);
                            String str2 = (String) objArr8[0];
                            Object[] objArr9 = new Object[1];
                            j(null, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 128, new byte[]{-101, -94, -94, -100, -104, -101, -94, -105, -94, -100, -98, -99, -117, -118, -101, -100, -95, -127, -102, -103, -96, -98, -100, -103, -103, -104, -105, -95, -103, -99, -125, -105, -118, -105, -100, -100, -103, -101, -100, -105, -97, -127, -95, -99, -125, -96, -117, -127, -105, -102, -97, -98, -98, -103, -103, -103, -96, -99, -105, -101, -95, -117, -98, -99}, null, objArr9);
                            String str3 = (String) objArr9[0];
                            Object[] objArr10 = new Object[1];
                            j(null, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 126, new byte[]{-120, -111, -126, -117, -110, -117, -92, -99, -110, -92, -111, -120, -117, -91, -126, -122, -92, -122, -113, -127, -92, -116, -123, -118, -121, -117, -124, -127, -107, -90, -120, -125, -124, -127, -107, -91, -121, -111, -120, -127, -118, -111, -127, -117, -124, -108, -111, -121, -127, -126, -127, -125, -92, -92, -93, -120, -113, -111, -111, -108}, null, objArr10);
                            String str4 = (String) objArr10[0];
                            Object[] objArr11 = new Object[1];
                            j(null, 128 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), new byte[]{-98, -99, -121, -96, -121, -101}, null, objArr11);
                            try {
                                Object[] objArr12 = {baseContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + 912, (ViewConfiguration.getFadingEdgeLength() >> 16) + 18, (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                try {
                    Object[] objArr13 = new Object[1];
                    h(lookAheadTest[31], lookAheadTest[25], lookAheadTest[32], objArr13);
                    Class<?> cls4 = Class.forName((String) objArr13[0]);
                    byte b = (byte) (lookAheadTest[34] + 1);
                    byte b2 = lookAheadTest[25];
                    Object[] objArr14 = new Object[1];
                    h(b, b2, (byte) (b2 | 8), objArr14);
                    try {
                        Object[] objArr15 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                        if (obj3 == null) {
                            Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 4 - (Process.myPid() >> 22), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)));
                            byte b3 = (byte) ($$g[47] - 1);
                            byte b4 = b3;
                            Object[] objArr16 = new Object[1];
                            k(b3, b4, b4, objArr16);
                            obj3 = cls5.getMethod((String) objArr16[0], Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                        }
                        Object[] objArr17 = (Object[]) ((Method) obj3).invoke(null, objArr15);
                        int i = ((int[]) objArr17[1])[0];
                        if (((int[]) objArr17[0])[0] != i) {
                            long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                            try {
                                Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj4 == null) {
                                    obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 36 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                }
                                Object invoke2 = ((Method) obj4).invoke(null, null);
                                try {
                                    Object[] objArr18 = {-760992164, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj5 == null) {
                                        obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.resolveSize(0, 0), Color.red(0) + 18, (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                    }
                                    ((Method) obj5).invoke(invoke2, objArr18);
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
                        RVLogger.d(GriverTransActivity.TAG, "onCreate NebulaTransActivity$Lite3");
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
            } catch (Throwable th7) {
                Throwable cause7 = th7.getCause();
                if (cause7 == null) {
                    throw th7;
                }
                throw cause7;
            }
        }

        private static void j(int[] iArr, int i, byte[] bArr, char[] cArr, Object[] objArr) {
            BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
            char[] cArr2 = getErrorConfigVersion;
            if (cArr2 != null) {
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                for (int i2 = 0; i2 < length; i2++) {
                    cArr3[i2] = (char) (cArr2[i2] ^ 4571606982258105150L);
                }
                cArr2 = cArr3;
            }
            int i3 = (int) (4571606982258105150L ^ NetworkUserEntityData$$ExternalSyntheticLambda0);
            if (GetContactSyncConfig) {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
                char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                    cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i3);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                }
                objArr[0] = new String(cArr4);
            } else if (NetworkUserEntityData$$ExternalSyntheticLambda1) {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
                char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                    cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                }
                objArr[0] = new String(cArr5);
            } else {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
                char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                    cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                }
                objArr[0] = new String(cArr6);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class Back extends GriverBaseActivity.Back {
        public static final byte[] $$g = {95, 98, 60, -42, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
        public static final int $$h = 44;
        public static final byte[] lookAheadTest = {88, 72, 91, 85, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
        public static final int getErrorConfigVersion = 204;
        private static char NetworkUserEntityData$$ExternalSyntheticLambda0 = 42066;
        private static char[] moveToNextValue = {37369, 37375, 37372, 37365, 37370, 37311, 37279, 37344, 37287, 37347, 37291, 37348, 37275, 37351, 37292, 37357, 37374, 37294, 37308, 37293, 37359, 37373, 37274, 37306, 37288, 37356, 37367, 37289, 37280, 37281, 37368, 37290, 37353, 37371, 37310, 37346, 37358, 37283, 37286, 37350, 37309, 37302, 37349, 37307, 37262, 37282, 37305, 37366, 37345};

        private static void j(short s, short s2, int i, Object[] objArr) {
            int i2 = s2 + 4;
            byte[] bArr = lookAheadTest;
            int i3 = 23 - s;
            int i4 = i + 97;
            byte[] bArr2 = new byte[i3];
            int i5 = -1;
            int i6 = i3 - 1;
            if (bArr == null) {
                i4 = (i6 + i4) - 4;
                i6 = i6;
                i2 = i2;
            }
            while (true) {
                i5++;
                bArr2[i5] = (byte) i4;
                if (i5 == i6) {
                    objArr[0] = new String(bArr2, 0);
                    return;
                }
                int i7 = i2 + 1;
                i4 = (i4 + bArr[i7]) - 4;
                i6 = i6;
                i2 = i7;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0036). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void k(int r6, byte r7, byte r8, java.lang.Object[] r9) {
            /*
                int r7 = 46 - r7
                int r6 = r6 * 3
                int r6 = r6 + 21
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverTransActivity.Back.$$g
                int r8 = r8 * 2
                int r8 = 103 - r8
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
                goto L36
            L19:
                r3 = 0
            L1a:
                byte r4 = (byte) r8
                r1[r3] = r4
                int r3 = r3 + 1
                int r7 = r7 + 1
                if (r3 != r6) goto L2b
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L2b:
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
            L36:
                int r6 = -r6
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
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverTransActivity.Back.k(int, byte, byte, java.lang.Object[]):void");
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            Object[] objArr;
            Object[] objArr2;
            Object[] objArr3;
            Object[] objArr4;
            super.attachBaseContext(context);
            Object[] objArr5 = new Object[1];
            h(new char[]{15, 31, '\f', Typography.amp, 31, '#', '\r', '-', InputCardNumberView.DIVIDER, 14, 6, '\r', '#', '!', 17, 28, 13856, 13856}, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 19, (byte) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 55), objArr5);
            Class<?> cls = Class.forName((String) objArr5[0]);
            Object[] objArr6 = new Object[1];
            h(new char[]{'0', Typography.amp, 24, Typography.dollar, 13848}, View.getDefaultSize(0, 0) + 5, (byte) (27 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), objArr6);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context applicationContext = context != null ? context.getApplicationContext() : context;
                if (applicationContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(977 - AndroidCharacter.getMirror('0'), 34 - TextUtils.lastIndexOf("", '0', 0, 0), (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        h(new char[]{28, 16, 5, 21, 3, '\b', 5, '!', 31, InputCardNumberView.DIVIDER, 20, 21, 28, 24, 14, 2, 13850, 13850, 3, 14, 7, 17, 21, 7, '\t', 3, 24, '\f', 24, 7, 24, Typography.amp, '*', 5, JSONLexer.EOI, '*', JSONLexer.EOI, '0', 22, 5, Typography.quote, 23, 28, 5, 16, 5, 3, 28}, (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 48, (byte) (KeyEvent.keyCodeFromString("") + 111), objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        h(new char[]{18, 3, 3, 7, JSONLexer.EOI, '0', 5, 22, 7, 17, '.', 5, '\t', 17, 19, 30, 13750, 13750, 23, 20, '\t', 17, 1, 3, 5, 14, '-', '!', 24, '\f', 13750, 13750, 17, 7, '(', '!', 13831, 13831, 2, 3, 5, 2, 30, 17, 16, 28, 23, '%', 13751, 13751, '!', ',', ',', '!', 2, 15, 2, 15, 15, 20, 19, 23, '\t', 3}, AndroidCharacter.getMirror('0') + 16, (byte) (15 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        h(new char[]{23, 14, '!', 17, ',', '!', JSONLexer.EOI, 28, 13763, 13763, 23, 19, 23, '\t', 2, 29, 24, Typography.amp, 31, '\f', JSONLexer.EOI, 14, 16, 3, Typography.quote, 23, 5, '!', 13853, 13853, 28, 16, 31, '\t', 22, 27, 16, '!', 5, 21, 27, 21, 19, 30, 22, 5, 18, 20, JSONLexer.EOI, '0', 17, 28, 23, 14, 25, 6, InputCardNumberView.DIVIDER, 2, '*', 5, 25, 6, 5, '.'}, 64 - View.resolveSizeAndState(0, 0, 0), (byte) (33 - (ViewConfiguration.getWindowTouchSlop() >> 8)), objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        h(new char[]{15, 1, '/', 1, 17, 4, 13852, 13852, 17, 24, 31, 15, '*', ',', '\f', Typography.dollar, Typography.amp, 24, '*', 15, 18, 19, ',', '*', 25, 24, 19, Typography.amp, 11, 17, 30, 27, 19, Typography.amp, Typography.quote, '-', 21, '#', '*', '\n', 19, 3, '#', '\n', Typography.dollar, 31, 31, Typography.amp, 15, '.', 11, '*', 28, 14, InputCardNumberView.DIVIDER, '-', InputCardNumberView.DIVIDER, 30, '.', 15}, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 61, (byte) (TextUtils.getCapsMode("", 0, 0) + 103), objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        h(new char[]{'0', '*', Typography.quote, '/', 23, 14}, 6 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (byte) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 10), objArr11);
                        try {
                            Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18, (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                    Object[] objArr13 = new Object[1];
                    j((byte) (-lookAheadTest[30]), (short) 36, lookAheadTest[32], objArr13);
                    Class<?> cls2 = Class.forName((String) objArr13[0]);
                    Object[] objArr14 = new Object[1];
                    j((byte) (-lookAheadTest[30]), (byte) (lookAheadTest[35] - 1), (byte) (getErrorConfigVersion & 58), objArr14);
                    try {
                        Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                        if (obj3 == null) {
                            Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 55, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 3, (char) View.resolveSize(0, 0));
                            Object[] objArr16 = new Object[1];
                            k($$g[47], (byte) (-$$g[53]), (byte) (-$$g[12]), objArr16);
                            obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                        }
                        Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - View.resolveSize(0, 0), 14 - ImageFormat.getBitsPerPixel(0), (char) View.resolveSizeAndState(0, 0, 0))).getMethod("getAuthRequestContext", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                            }
                            int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                            try {
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - View.getDefaultSize(0, 0), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 15, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("PlaceComponentResult", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                                }
                                if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                    ArrayList arrayList = new ArrayList();
                                    try {
                                        Object[] objArr17 = {invoke2};
                                        Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                        if (obj6 == null) {
                                            obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 816, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 29, (char) (57994 - View.MeasureSpec.getSize(0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776416) - Color.rgb(0, 0, 0), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 14, (char) ExpandableListView.getPackedPositionGroup(0L)));
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                        }
                                        arrayList.add(((Method) obj6).invoke(null, objArr17));
                                        long j = ((r5 ^ intValue2) & 4294967295L) | 60129542144L;
                                        try {
                                            Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                            if (obj7 != null) {
                                                objArr = null;
                                            } else {
                                                objArr = null;
                                                obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                            }
                                            Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                            try {
                                                Object[] objArr18 = {-89449321, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                                Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                                if (obj8 == null) {
                                                    obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 910, KeyEvent.normalizeMetaState(0) + 18, (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    Object[] objArr19 = new Object[1];
                    j((byte) (-lookAheadTest[30]), (short) 36, lookAheadTest[32], objArr19);
                    Class<?> cls4 = Class.forName((String) objArr19[0]);
                    Object[] objArr20 = new Object[1];
                    j((byte) (-lookAheadTest[30]), (byte) (lookAheadTest[35] - 1), (byte) (getErrorConfigVersion & 58), objArr20);
                    try {
                        Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                        Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                        if (obj9 == null) {
                            Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(62 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), View.MeasureSpec.getMode(0) + 46, (char) View.resolveSizeAndState(0, 0, 0));
                            Object[] objArr22 = new Object[1];
                            k((byte) ($$g[47] - 1), $$g[20], (byte) ($$g[47] - 1), objArr22);
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
                                    objArr4 = null;
                                } else {
                                    objArr4 = null;
                                    obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Drawable.resolveOpacity(0, 0), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 35, (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                                }
                                Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                                try {
                                    Object[] objArr24 = {-89449321, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj11 == null) {
                                        obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getOffsetAfter("", 0), Gravity.getAbsoluteGravity(0, 0) + 18, (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    Object[] objArr25 = new Object[1];
                    j((byte) (-lookAheadTest[30]), (short) 36, lookAheadTest[32], objArr25);
                    Class<?> cls6 = Class.forName((String) objArr25[0]);
                    Object[] objArr26 = new Object[1];
                    j((byte) (-lookAheadTest[30]), (byte) (lookAheadTest[35] - 1), (byte) (getErrorConfigVersion & 58), objArr26);
                    try {
                        Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                        Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                        if (obj12 == null) {
                            Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(117 - TextUtils.lastIndexOf("", '0', 0, 0), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 3, (char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 38968));
                            Object[] objArr28 = new Object[1];
                            k((byte) ($$g[47] - 1), $$g[20], (byte) ($$g[47] - 1), objArr28);
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
                                    obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + PDF417Common.NUMBER_OF_CODEWORDS, Process.getGidForName("") + 36, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                                }
                                Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                                try {
                                    Object[] objArr30 = {-89449321, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj14 == null) {
                                        obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 911, (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18, (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    Object[] objArr31 = new Object[1];
                    j((byte) (-lookAheadTest[30]), (short) 36, lookAheadTest[32], objArr31);
                    Class<?> cls8 = Class.forName((String) objArr31[0]);
                    Object[] objArr32 = new Object[1];
                    j((byte) (-lookAheadTest[30]), (byte) (lookAheadTest[35] - 1), (byte) (getErrorConfigVersion & 58), objArr32);
                    try {
                        Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                        Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                        if (obj15 == null) {
                            Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(155 - AndroidCharacter.getMirror('0'), ExpandableListView.getPackedPositionType(0L) + 3, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16));
                            Object[] objArr34 = new Object[1];
                            k((byte) (-$$g[8]), (byte) ($$g[47] - 1), (byte) (-$$g[9]), objArr34);
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
                                    objArr2 = null;
                                } else {
                                    objArr2 = null;
                                    obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - KeyEvent.keyCodeFromString(""), (KeyEvent.getMaxKeyCode() >> 16) + 35, (char) TextUtils.getOffsetAfter("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                                }
                                Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                                try {
                                    Object[] objArr36 = {-89449321, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj17 == null) {
                                        obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 911, 18 - TextUtils.getTrimmedLength(""), (char) ((-16777216) - Color.rgb(0, 0, 0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return super.getApplicationContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
        public Context getBaseContext() {
            return super.getBaseContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
        public Resources getResources() {
            return super.getResources();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onPause() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr = new Object[1];
                h(new char[]{15, 31, '\f', Typography.amp, 31, '#', '\r', '-', 19, 3, 6, '/', '*', 16, '-', Typography.dollar, '-', '\'', '0', Typography.dollar, '\r', '\t', Typography.amp, '!', 24, 17}, Color.alpha(0) + 26, (byte) (TextUtils.indexOf((CharSequence) "", '0') + 42), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                h(new char[]{16, 21, 13898, 13898, InputCardNumberView.DIVIDER, 30, ',', '-', 13900, 13900, Typography.amp, '\'', 15, 18, '-', Typography.dollar, 29, 30}, 19 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (byte) (97 - ExpandableListView.getPackedPositionChild(0L)), objArr2);
                baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) Color.argb(0, 0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr3 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 911, 19 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("MyBillsEntityDataFactory", Context.class);
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
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onResume() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                char[] cArr = {15, 31, '\f', Typography.amp, 31, '#', '\r', '-', 19, 3, 6, '/', '*', 16, '-', Typography.dollar, '-', '\'', '0', Typography.dollar, '\r', '\t', Typography.amp, '!', 24, 17};
                try {
                    Object[] objArr = new Object[1];
                    j(lookAheadTest[25], lookAheadTest[9], lookAheadTest[25], objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    j(lookAheadTest[27], lookAheadTest[59], (byte) (-lookAheadTest[5]), new Object[1]);
                    Object[] objArr2 = new Object[1];
                    h(cArr, ((ApplicationInfo) cls.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 7, (byte) (super.getResources().getString(R.string.family_text_member_transaction_history).substring(5, 6).length() + 40), objArr2);
                    Class<?> cls2 = Class.forName((String) objArr2[0]);
                    Object[] objArr3 = new Object[1];
                    h(new char[]{16, 21, 13898, 13898, InputCardNumberView.DIVIDER, 30, ',', '-', 13900, 13900, Typography.amp, '\'', 15, 18, '-', Typography.dollar, 29, 30}, 19 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (byte) (super.getResources().getString(R.string.tooltip_ok).substring(0, 2).codePointAt(1) - 9), objArr3);
                    baseContext = (Context) cls2.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776287) - Color.rgb(0, 0, 0), 34 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr4 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0', 0), (ViewConfiguration.getTapTimeout() >> 16) + 18, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr4);
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
            super.onResume();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle bundle) {
            Object[] objArr;
            Object[] objArr2 = new Object[1];
            h(new char[]{15, 31, '\f', Typography.amp, 31, '#', '\r', '-', InputCardNumberView.DIVIDER, 14, 6, '\r', '#', '!', 17, 28, 13856, 13856}, getPackageName().length() + 11, (byte) (super.getResources().getString(R.string.msg_tap_to_copy).substring(1, 2).codePointAt(0) - 42), objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            char[] cArr = {'0', Typography.amp, 24, Typography.dollar, 13848};
            try {
                Object[] objArr3 = new Object[1];
                j(lookAheadTest[25], lookAheadTest[9], lookAheadTest[25], objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                j(lookAheadTest[27], lookAheadTest[59], (byte) (-lookAheadTest[5]), new Object[1]);
                Object[] objArr4 = new Object[1];
                h(cArr, ((ApplicationInfo) cls2.getMethod((String) r4[0], null).invoke(this, null)).targetSdkVersion - 28, (byte) (26 - (ViewConfiguration.getScrollBarFadeDuration() >> 16)), objArr4);
                int intValue = ((Integer) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                if (intValue < 99000 || intValue > 99999) {
                    Context baseContext = getBaseContext();
                    if (baseContext == null) {
                        char[] cArr2 = {15, 31, '\f', Typography.amp, 31, '#', '\r', '-', 19, 3, 6, '/', '*', 16, '-', Typography.dollar, '-', '\'', '0', Typography.dollar, '\r', '\t', Typography.amp, '!', 24, 17};
                        try {
                            Object[] objArr5 = new Object[1];
                            j(lookAheadTest[25], lookAheadTest[9], lookAheadTest[25], objArr5);
                            Class<?> cls3 = Class.forName((String) objArr5[0]);
                            j(lookAheadTest[27], lookAheadTest[59], (byte) (-lookAheadTest[5]), new Object[1]);
                            Object[] objArr6 = new Object[1];
                            h(cArr2, ((ApplicationInfo) cls3.getMethod((String) r3[0], null).invoke(this, null)).targetSdkVersion - 7, (byte) (getPackageName().length() + 34), objArr6);
                            Class<?> cls4 = Class.forName((String) objArr6[0]);
                            Object[] objArr7 = new Object[1];
                            h(new char[]{16, 21, 13898, 13898, InputCardNumberView.DIVIDER, 30, ',', '-', 13900, 13900, Typography.amp, '\'', 15, 18, '-', Typography.dollar, 29, 30}, super.getResources().getString(R.string.sendmoney_sortby).substring(7, 11).length() + 14, (byte) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 98), objArr7);
                            baseContext = (Context) cls4.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    }
                    if (baseContext != null) {
                        baseContext = baseContext.getApplicationContext();
                    }
                    if (baseContext != null) {
                        try {
                            Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj == null) {
                                obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) KeyEvent.normalizeMetaState(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                            }
                            Object invoke = ((Method) obj).invoke(null, null);
                            char[] cArr3 = {28, 16, 5, 21, 3, '\b', 5, '!', 31, InputCardNumberView.DIVIDER, 20, 21, 28, 24, 14, 2, 13850, 13850, 3, 14, 7, 17, 21, 7, '\t', 3, 24, '\f', 24, 7, 24, Typography.amp, '*', 5, JSONLexer.EOI, '*', JSONLexer.EOI, '0', 22, 5, Typography.quote, 23, 28, 5, 16, 5, 3, 28};
                            int indexOf = TextUtils.indexOf((CharSequence) "", '0') + 49;
                            try {
                                Object[] objArr8 = new Object[1];
                                j(lookAheadTest[25], lookAheadTest[9], lookAheadTest[25], objArr8);
                                Class<?> cls5 = Class.forName((String) objArr8[0]);
                                Object[] objArr9 = new Object[1];
                                j(lookAheadTest[27], lookAheadTest[59], (byte) (-lookAheadTest[5]), objArr9);
                                Object[] objArr10 = new Object[1];
                                h(cArr3, indexOf, (byte) (((ApplicationInfo) cls5.getMethod((String) objArr9[0], null).invoke(this, null)).targetSdkVersion + 78), objArr10);
                                String str = (String) objArr10[0];
                                Object[] objArr11 = new Object[1];
                                h(new char[]{18, 3, 3, 7, JSONLexer.EOI, '0', 5, 22, 7, 17, '.', 5, '\t', 17, 19, 30, 13750, 13750, 23, 20, '\t', 17, 1, 3, 5, 14, '-', '!', 24, '\f', 13750, 13750, 17, 7, '(', '!', 13831, 13831, 2, 3, 5, 2, 30, 17, 16, 28, 23, '%', 13751, 13751, '!', ',', ',', '!', 2, 15, 2, 15, 15, 20, 19, 23, '\t', 3}, View.resolveSizeAndState(0, 0, 0) + 64, (byte) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 14), objArr11);
                                String str2 = (String) objArr11[0];
                                Object[] objArr12 = new Object[1];
                                h(new char[]{23, 14, '!', 17, ',', '!', JSONLexer.EOI, 28, 13763, 13763, 23, 19, 23, '\t', 2, 29, 24, Typography.amp, 31, '\f', JSONLexer.EOI, 14, 16, 3, Typography.quote, 23, 5, '!', 13853, 13853, 28, 16, 31, '\t', 22, 27, 16, '!', 5, 21, 27, 21, 19, 30, 22, 5, 18, 20, JSONLexer.EOI, '0', 17, 28, 23, 14, 25, 6, InputCardNumberView.DIVIDER, 2, '*', 5, 25, 6, 5, '.'}, super.getResources().getString(R.string.request_money_AE15112158147539).substring(13, 14).length() + 63, (byte) (getPackageName().codePointAt(3) - 67), objArr12);
                                String str3 = (String) objArr12[0];
                                Object[] objArr13 = new Object[1];
                                h(new char[]{15, 1, '/', 1, 17, 4, 13852, 13852, 17, 24, 31, 15, '*', ',', '\f', Typography.dollar, Typography.amp, 24, '*', 15, 18, 19, ',', '*', 25, 24, 19, Typography.amp, 11, 17, 30, 27, 19, Typography.amp, Typography.quote, '-', 21, '#', '*', '\n', 19, 3, '#', '\n', Typography.dollar, 31, 31, Typography.amp, 15, '.', 11, '*', 28, 14, InputCardNumberView.DIVIDER, '-', InputCardNumberView.DIVIDER, 30, '.', 15}, 59 - MotionEvent.axisFromString(""), (byte) (getPackageName().codePointAt(0) - 2), objArr13);
                                String str4 = (String) objArr13[0];
                                Object[] objArr14 = new Object[1];
                                h(new char[]{'0', '*', Typography.quote, '/', 23, 14}, super.getResources().getString(R.string.error_message_max_limit).substring(12, 13).length() + 5, (byte) (super.getResources().getString(R.string.desc_dest_ewallet).substring(24, 27).length() + 7), objArr14);
                                try {
                                    Object[] objArr15 = {baseContext, str, str2, str3, str4, true, (String) objArr14[0], 995651014};
                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                    if (obj2 == null) {
                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + 911, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 18, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                    }
                                    ((Method) obj2).invoke(invoke, objArr15);
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
                    Object[] objArr16 = new Object[1];
                    j((byte) (-lookAheadTest[30]), (short) 36, lookAheadTest[32], objArr16);
                    Class<?> cls6 = Class.forName((String) objArr16[0]);
                    Object[] objArr17 = new Object[1];
                    j((byte) (-lookAheadTest[30]), (byte) (lookAheadTest[35] - 1), (byte) (getErrorConfigVersion & 58), objArr17);
                    try {
                        Object[] objArr18 = {Integer.valueOf(((Integer) cls6.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                        if (obj3 == null) {
                            Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - ExpandableListView.getPackedPositionType(0L), TextUtils.getOffsetBefore("", 0) + 4, (char) Color.green(0));
                            Object[] objArr19 = new Object[1];
                            k((byte) (-$$g[8]), (byte) ($$g[47] - 1), (byte) (-$$g[9]), objArr19);
                            obj3 = cls7.getMethod((String) objArr19[0], Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                        }
                        Object[] objArr20 = (Object[]) ((Method) obj3).invoke(null, objArr18);
                        int i = ((int[]) objArr20[1])[0];
                        if (((int[]) objArr20[0])[0] != i) {
                            long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                            try {
                                Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj4 != null) {
                                    objArr = null;
                                } else {
                                    objArr = null;
                                    obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (-16777181) - Color.rgb(0, 0, 0), (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                }
                                Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                                try {
                                    Object[] objArr21 = {1319296828, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj5 == null) {
                                        obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - Process.getGidForName(""), 17 - ImageFormat.getBitsPerPixel(0), (char) Color.green(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                    }
                                    ((Method) obj5).invoke(invoke2, objArr21);
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
                        GriverTransActivity.a((Activity) this);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, android.app.Activity
        public void finish() {
            App app;
            boolean z = true;
            if (this.mActivityHelper != null && (app = this.mActivityHelper.getApp()) != null) {
                z = BundleUtils.getBoolean(app.getSceneParams(), KeepAliveAppManager.SHOW_FINISH_ANIM, true);
            }
            super.finish();
            if (z) {
                overridePendingTransition(com.alibaba.griver.core.R.anim.griver_core_app_enter_left_in, com.alibaba.griver.core.R.anim.griver_core_app_exit_right_out);
            }
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, android.app.Activity
        public void finishAndRemoveTask() {
            App app;
            boolean z = true;
            if (this.mActivityHelper != null && (app = this.mActivityHelper.getApp()) != null) {
                z = BundleUtils.getBoolean(app.getSceneParams(), KeepAliveAppManager.SHOW_FINISH_ANIM, true);
            }
            super.finishAndRemoveTask();
            if (z) {
                overridePendingTransition(com.alibaba.griver.core.R.anim.griver_core_app_enter_left_in, com.alibaba.griver.core.R.anim.griver_core_app_exit_right_out);
            }
        }

        private static void h(char[] cArr, int i, byte b, Object[] objArr) {
            int i2;
            getCallingPid getcallingpid = new getCallingPid();
            char[] cArr2 = moveToNextValue;
            if (cArr2 != null) {
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                for (int i3 = 0; i3 < length; i3++) {
                    cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
                }
                cArr2 = cArr3;
            }
            char c = (char) ((-1549216646985767851L) ^ NetworkUserEntityData$$ExternalSyntheticLambda0);
            char[] cArr4 = new char[i];
            if (i % 2 != 0) {
                i2 = i - 1;
                cArr4[i2] = (char) (cArr[i2] - b);
            } else {
                i2 = i;
            }
            if (i2 > 1) {
                getcallingpid.getAuthRequestContext = 0;
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
                        if (getcallingpid.scheduleImpl == getcallingpid.lookAheadTest) {
                            getcallingpid.BuiltInFictitiousFunctionClassFactory = ((getcallingpid.BuiltInFictitiousFunctionClassFactory + c) - 1) % c;
                            getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = ((getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 + c) - 1) % c;
                            int i4 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                            int i5 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                            cArr4[getcallingpid.getAuthRequestContext] = cArr2[i4];
                            cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i5];
                        } else if (getcallingpid.BuiltInFictitiousFunctionClassFactory == getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2) {
                            getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                            getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                            int i6 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                            int i7 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                            cArr4[getcallingpid.getAuthRequestContext] = cArr2[i6];
                            cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i7];
                        } else {
                            int i8 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                            int i9 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                            cArr4[getcallingpid.getAuthRequestContext] = cArr2[i8];
                            cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i9];
                        }
                    }
                    getcallingpid.getAuthRequestContext += 2;
                }
            }
            for (int i10 = 0; i10 < i; i10++) {
                cArr4[i10] = (char) (cArr4[i10] ^ 13722);
            }
            objArr[0] = new String(cArr4);
        }
    }

    /* loaded from: classes3.dex */
    public static class Back5 extends Back {
        public static final byte[] $$j = {38, -105, 32, Ascii.RS, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
        public static final int $$k = 187;
        public static final byte[] moveToNextValue = {56, -119, 46, TarHeader.LF_CONTIG, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
        public static final int NetworkUserEntityData$$ExternalSyntheticLambda0 = 43;
        private static long NetworkUserEntityData$$ExternalSyntheticLambda2 = -9211939624884366969L;

        /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0034). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void m(int r6, byte r7, int r8, java.lang.Object[] r9) {
            /*
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverTransActivity.Back5.moveToNextValue
                int r7 = 55 - r7
                int r8 = r8 + 16
                int r6 = 106 - r6
                byte[] r1 = new byte[r8]
                r2 = 0
                if (r0 != 0) goto L14
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r9
                r9 = r8
                r8 = r7
                goto L34
            L14:
                r3 = 0
            L15:
                r5 = r7
                r7 = r6
                r6 = r5
                byte r4 = (byte) r7
                r1[r3] = r4
                int r3 = r3 + 1
                int r6 = r6 + 1
                if (r3 != r8) goto L29
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L29:
                r4 = r0[r6]
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
                int r8 = r8 + r6
                int r6 = r8 + (-4)
                r8 = r9
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L15
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverTransActivity.Back5.m(int, byte, int, java.lang.Object[]):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0038). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void n(byte r7, short r8, short r9, java.lang.Object[] r10) {
            /*
                int r7 = r7 * 2
                int r7 = r7 + 75
                int r9 = r9 * 3
                int r9 = r9 + 21
                int r8 = r8 + 4
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverTransActivity.Back5.$$j
                byte[] r1 = new byte[r9]
                int r9 = r9 + (-1)
                r2 = 0
                if (r0 != 0) goto L1a
                r7 = r8
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r10
                r10 = r9
                goto L38
            L1a:
                r3 = 0
            L1b:
                int r8 = r8 + 1
                byte r4 = (byte) r7
                r1[r3] = r4
                if (r3 != r9) goto L2a
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L2a:
                int r3 = r3 + 1
                r4 = r0[r8]
                r5 = r8
                r8 = r7
                r7 = r5
                r6 = r10
                r10 = r9
                r9 = r4
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r6
            L38:
                int r8 = r8 + r9
                int r8 = r8 + (-7)
                r9 = r10
                r10 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                r5 = r8
                r8 = r7
                r7 = r5
                goto L1b
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverTransActivity.Back5.n(byte, short, short, java.lang.Object[]):void");
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            Object[] objArr;
            Object[] objArr2;
            Object[] objArr3;
            Object[] objArr4;
            super.attachBaseContext(context);
            Object[] objArr5 = new Object[1];
            l(56179 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), new char[]{49317, 7129, 30278, 21231, 44391, 35218, 58386, 49359, 6963, 30652, 21140, 44389, 35282, 58492, 49389, 6940, 30599, 21012}, objArr5);
            Class<?> cls = Class.forName((String) objArr5[0]);
            Object[] objArr6 = new Object[1];
            l((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 17027, new char[]{49321, 33342, 17815, 1828, 51884}, objArr6);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context applicationContext = context != null ? context.getApplicationContext() : context;
                if (applicationContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + 930, TextUtils.getOffsetBefore("", 0) + 35, (char) View.combineMeasuredStates(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        l((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 11924, new char[]{49395, 60980, 40404, 19269, 31416, 10367, 55183, 34553, 46187, 25482, 4377, 49395, 60997, 40321, 19711, 31343, 10693, 55094, 34468, 46156, 25564, 4776, 49157, 61383, 40296, 19628, 31250, 10529, 55522, 34311, 46495, 25452, 4765, 49153, 61296, 40676, 19470, 31682, 10542, 55441, 34315, 46377, 25838, 4675, 49634, 61216, 40600, 19548}, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        l(54251 - ExpandableListView.getPackedPositionGroup(0L), new char[]{49317, 4890, 26404, 47969, 36622, 58218, 14198, 2961, 24568, 46052, 34771, 56296, 12196, 538, 22063, 43573, 65094, 53869, 9764, 31364, 20220, 41650, 63168, 51946, 7930, 29013, 17699, 39272, 60744, 49471, 5500, 27011, 48583, 37355, 58822, 14813, 3499, 24656, 46102, 34874, 56393, 12375, 1071, 22668, 44227, 32956, 54479, 10454, 31975, 20236, 41749, 63276, 52033, 8020, 29542, 18312, 39836, 61350, 50073, 6031, 27617, 48643, 37450, 58914}, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        l(27487 - (ViewConfiguration.getDoubleTapTimeout() >> 16), new char[]{49398, 43946, 5663, 33467, 28033, 55336, 17612, 12137, 39428, 1707, 61770, 24032, 51329, 45860, 8134, 35426, 30037, 57838, 19550, 14509, 41882, 3693, 64143, 25982, 53275, 48357, 10075, 37881, 32454, 59745, 21969, 49190, 43795, 6047, 33384, 27905, 55802, 17480, 12520, 39813, 1572, 62101, 23907, 51205, 46248, 8007, 35767, 30423, 57714, 19922, 14377, 41804, 4026, 64094, 26280, 53656, 48187, 10454, 37755, 32279, 60134, 21842, 49651, 44188}, objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        l(27238 - ExpandableListView.getPackedPositionChild(0L), new char[]{49324, 43735, 5246, 65409, 26923, 54525, 48769, 10298, 37784, 32058, 59564, 21192, 15422, 42891, 4366, 64703, 26321, 53362, 48014, 9474, 37033, 31428, 58474, 20395, 14603, 42174, 3795, 63595, 25572, 52508, 47271, 8904, 35909, 30705, 57615, 19711, 14043, 41032, 3043, 62810, 24765, 51915, 46155, 8102, 35097, 29873, 56865, 18504, 13287, 40199, 2293, 62007, 23578, 51128, 45339, 7315, 34345, 28741, 56294, 17674}, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        l(((byte) KeyEvent.getModifierMetaStateMask()) + 39120, new char[]{49405, 22565, 61806, 2695, 41930, 15614}, objArr11);
                        try {
                            Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), Color.argb(0, 0, 0, 0) + 18, (char) View.resolveSizeAndState(0, 0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                    Object[] objArr13 = new Object[1];
                    m(moveToNextValue[25], moveToNextValue[31], moveToNextValue[25], objArr13);
                    Class<?> cls2 = Class.forName((String) objArr13[0]);
                    Object[] objArr14 = new Object[1];
                    m(moveToNextValue[7], (byte) (moveToNextValue[34] + 1), moveToNextValue[25], objArr14);
                    try {
                        Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                        if (obj3 == null) {
                            Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + 56, (ViewConfiguration.getTapTimeout() >> 16) + 3, (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))));
                            Object[] objArr16 = new Object[1];
                            n($$j[78], $$j[47], $$j[78], objArr16);
                            obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                        }
                        Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myPid() >> 22) + 800, 15 - TextUtils.indexOf("", "", 0), (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("getAuthRequestContext", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                            }
                            int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                            try {
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 15 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))))).getMethod("PlaceComponentResult", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                                }
                                if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                    ArrayList arrayList = new ArrayList();
                                    try {
                                        Object[] objArr17 = {invoke2};
                                        Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                        if (obj6 == null) {
                                            obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(816 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), 29 - TextUtils.getOffsetBefore("", 0), (char) (ExpandableListView.getPackedPositionChild(0L) + 57995))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - TextUtils.indexOf("", "", 0, 0), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 15, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16)));
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                        }
                                        arrayList.add(((Method) obj6).invoke(null, objArr17));
                                        long j = ((r4 ^ intValue2) & 4294967295L) | 60129542144L;
                                        try {
                                            Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                            if (obj7 != null) {
                                                objArr = null;
                                            } else {
                                                objArr = null;
                                                obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Drawable.resolveOpacity(0, 0), TextUtils.lastIndexOf("", '0', 0) + 36, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                            }
                                            Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                            try {
                                                Object[] objArr18 = {-1495800454, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                                Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                                if (obj8 == null) {
                                                    obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 17, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    Object[] objArr19 = new Object[1];
                    m(moveToNextValue[25], moveToNextValue[31], moveToNextValue[25], objArr19);
                    Class<?> cls4 = Class.forName((String) objArr19[0]);
                    Object[] objArr20 = new Object[1];
                    m(moveToNextValue[7], (byte) (moveToNextValue[34] + 1), moveToNextValue[25], objArr20);
                    try {
                        Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                        Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                        if (obj9 == null) {
                            Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + 61, 46 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) ExpandableListView.getPackedPositionGroup(0L));
                            Object[] objArr22 = new Object[1];
                            n($$j[9], $$j[28], (byte) ($$j[78] - 1), objArr22);
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
                                    objArr2 = null;
                                } else {
                                    objArr2 = null;
                                    obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - Color.blue(0), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                                }
                                Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                                try {
                                    Object[] objArr24 = {-1495800454, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj11 == null) {
                                        obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 910, 17 - TextUtils.lastIndexOf("", '0', 0), (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    Object[] objArr25 = new Object[1];
                    m(moveToNextValue[25], moveToNextValue[31], moveToNextValue[25], objArr25);
                    Class<?> cls6 = Class.forName((String) objArr25[0]);
                    Object[] objArr26 = new Object[1];
                    m(moveToNextValue[7], (byte) (moveToNextValue[34] + 1), moveToNextValue[25], objArr26);
                    try {
                        Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                        Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                        if (obj12 == null) {
                            Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (ViewConfiguration.getKeyRepeatDelay() >> 16), 4 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 38968));
                            Object[] objArr28 = new Object[1];
                            n($$j[9], $$j[28], (byte) ($$j[78] - 1), objArr28);
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
                                    obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (Process.myTid() >> 22), 35 - Gravity.getAbsoluteGravity(0, 0), (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                                }
                                Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                                try {
                                    Object[] objArr30 = {-1495800454, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj14 == null) {
                                        obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 18 - (ViewConfiguration.getTouchSlop() >> 8), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    Object[] objArr31 = new Object[1];
                    m(moveToNextValue[25], moveToNextValue[31], moveToNextValue[25], objArr31);
                    Class<?> cls8 = Class.forName((String) objArr31[0]);
                    Object[] objArr32 = new Object[1];
                    m(moveToNextValue[7], (byte) (moveToNextValue[34] + 1), moveToNextValue[25], objArr32);
                    try {
                        Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                        Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                        if (obj15 == null) {
                            Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 106, 3 - TextUtils.getCapsMode("", 0, 0), (char) (ViewConfiguration.getTapTimeout() >> 16));
                            Object[] objArr34 = new Object[1];
                            n((byte) ($$j[78] - 1), (byte) (-$$j[40]), $$j[8], objArr34);
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
                                    objArr4 = null;
                                } else {
                                    objArr4 = null;
                                    obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 35, (char) TextUtils.indexOf("", "", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                                }
                                Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                                try {
                                    Object[] objArr36 = {-1495800454, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj17 == null) {
                                        obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 911, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 17, (char) ((-1) - ImageFormat.getBitsPerPixel(0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return super.getApplicationContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
        public Context getBaseContext() {
            return super.getBaseContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
        public Resources getResources() {
            return super.getResources();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle bundle) {
            Object[] objArr;
            Object[] objArr2 = new Object[1];
            l(getPackageName().codePointAt(2) + 56133, new char[]{49317, 7129, 30278, 21231, 44391, 35218, 58386, 49359, 6963, 30652, 21140, 44389, 35282, 58492, 49389, 6940, 30599, 21012}, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            l(getPackageName().length() + FirebaseError.ERROR_NETWORK_REQUEST_FAILED, new char[]{49321, 33342, 17815, 1828, 51884}, objArr3);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr4 = new Object[1];
                    l(super.getResources().getString(R.string.title_card_unsupported).substring(20, 21).codePointAt(0) + 31024, new char[]{49317, 47419, 13186, 44037, 9967, 40824, 6598, 37405, 3117, 34477, 32542, 63953, 29257, 60666, 25950, 57298, 22946, 53772, 19586, 50558, 49092, 14409, 45760, 11430, 42301, 8073}, objArr4);
                    Class<?> cls2 = Class.forName((String) objArr4[0]);
                    try {
                        Object[] objArr5 = new Object[1];
                        m(moveToNextValue[32], (byte) (moveToNextValue[59] + 1), (byte) (-moveToNextValue[30]), objArr5);
                        Class<?> cls3 = Class.forName((String) objArr5[0]);
                        Object[] objArr6 = new Object[1];
                        m(moveToNextValue[13], moveToNextValue[25], moveToNextValue[56], objArr6);
                        Object[] objArr7 = new Object[1];
                        l(((ApplicationInfo) cls3.getMethod((String) objArr6[0], null).invoke(this, null)).targetSdkVersion + 12038, new char[]{49319, 61334, 40696, 19907, 31805, 11113, 55898, 35476, 47500, 26859, 5934, 50688, 62835, 42078, 21650, 996, 13019, 57661}, objArr7);
                        baseContext = (Context) cls2.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 35 - Color.alpha(0), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr8 = new Object[1];
                        l(getPackageName().length() + 11916, new char[]{49395, 60980, 40404, 19269, 31416, 10367, 55183, 34553, 46187, 25482, 4377, 49395, 60997, 40321, 19711, 31343, 10693, 55094, 34468, 46156, 25564, 4776, 49157, 61383, 40296, 19628, 31250, 10529, 55522, 34311, 46495, 25452, 4765, 49153, 61296, 40676, 19470, 31682, 10542, 55441, 34315, 46377, 25838, 4675, 49634, 61216, 40600, 19548}, objArr8);
                        String str = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        l(super.getResources().getString(R.string.unsafe_device_tamper_image_title).substring(5, 6).length() + 54250, new char[]{49317, 4890, 26404, 47969, 36622, 58218, 14198, 2961, 24568, 46052, 34771, 56296, 12196, 538, 22063, 43573, 65094, 53869, 9764, 31364, 20220, 41650, 63168, 51946, 7930, 29013, 17699, 39272, 60744, 49471, 5500, 27011, 48583, 37355, 58822, 14813, 3499, 24656, 46102, 34874, 56393, 12375, 1071, 22668, 44227, 32956, 54479, 10454, 31975, 20236, 41749, 63276, 52033, 8020, 29542, 18312, 39836, 61350, 50073, 6031, 27617, 48643, 37450, 58914}, objArr9);
                        String str2 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        l(27487 - View.resolveSizeAndState(0, 0, 0), new char[]{49398, 43946, 5663, 33467, 28033, 55336, 17612, 12137, 39428, 1707, 61770, 24032, 51329, 45860, 8134, 35426, 30037, 57838, 19550, 14509, 41882, 3693, 64143, 25982, 53275, 48357, 10075, 37881, 32454, 59745, 21969, 49190, 43795, 6047, 33384, 27905, 55802, 17480, 12520, 39813, 1572, 62101, 23907, 51205, 46248, 8007, 35767, 30423, 57714, 19922, 14377, 41804, 4026, 64094, 26280, 53656, 48187, 10454, 37755, 32279, 60134, 21842, 49651, 44188}, objArr10);
                        String str3 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        l(27239 - TextUtils.getOffsetAfter("", 0), new char[]{49324, 43735, 5246, 65409, 26923, 54525, 48769, 10298, 37784, 32058, 59564, 21192, 15422, 42891, 4366, 64703, 26321, 53362, 48014, 9474, 37033, 31428, 58474, 20395, 14603, 42174, 3795, 63595, 25572, 52508, 47271, 8904, 35909, 30705, 57615, 19711, 14043, 41032, 3043, 62810, 24765, 51915, 46155, 8102, 35097, 29873, 56865, 18504, 13287, 40199, 2293, 62007, 23578, 51128, 45339, 7315, 34345, 28741, 56294, 17674}, objArr11);
                        String str4 = (String) objArr11[0];
                        try {
                            Object[] objArr12 = new Object[1];
                            m(moveToNextValue[32], (byte) (moveToNextValue[59] + 1), (byte) (-moveToNextValue[30]), objArr12);
                            Class<?> cls4 = Class.forName((String) objArr12[0]);
                            Object[] objArr13 = new Object[1];
                            m(moveToNextValue[13], moveToNextValue[25], moveToNextValue[56], objArr13);
                            Object[] objArr14 = new Object[1];
                            l(((ApplicationInfo) cls4.getMethod((String) objArr13[0], null).invoke(this, null)).targetSdkVersion + 39086, new char[]{49405, 22565, 61806, 2695, 41930, 15614}, objArr14);
                            try {
                                Object[] objArr15 = {baseContext, str, str2, str3, str4, true, (String) objArr14[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + 911, (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18, (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                }
                                ((Method) obj2).invoke(invoke, objArr15);
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
                Object[] objArr16 = new Object[1];
                m(moveToNextValue[25], moveToNextValue[31], moveToNextValue[25], objArr16);
                Class<?> cls5 = Class.forName((String) objArr16[0]);
                Object[] objArr17 = new Object[1];
                m(moveToNextValue[7], (byte) (moveToNextValue[34] + 1), moveToNextValue[25], objArr17);
                try {
                    Object[] objArr18 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), View.MeasureSpec.getMode(0) + 4, (char) ((Process.getThreadPriority(0) + 20) >> 6));
                        Object[] objArr19 = new Object[1];
                        n((byte) ($$j[78] - 1), (byte) (-$$j[40]), $$j[8], objArr19);
                        obj3 = cls6.getMethod((String) objArr19[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr20 = (Object[]) ((Method) obj3).invoke(null, objArr18);
                    int i = ((int[]) objArr20[1])[0];
                    if (((int[]) objArr20[0])[0] != i) {
                        long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + 930, TextUtils.indexOf("", "", 0) + 35, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr21 = {-1968389773, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.resolveSize(0, 0), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 18, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr21);
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
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onPause() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr = new Object[1];
                l(super.getResources().getString(R.string.share_feed_cancel_dialog_msg).substring(22, 23).length() + 31120, new char[]{49317, 47419, 13186, 44037, 9967, 40824, 6598, 37405, 3117, 34477, 32542, 63953, 29257, 60666, 25950, 57298, 22946, 53772, 19586, 50558, 49092, 14409, 45760, 11430, 42301, 8073}, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                l(getPackageName().codePointAt(4) + 11974, new char[]{49319, 61334, 40696, 19907, 31805, 11113, 55898, 35476, 47500, 26859, 5934, 50688, 62835, 42078, 21650, 996, 13019, 57661}, objArr2);
                baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0'), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 34, (char) Color.red(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr3 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + 911, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 18, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Context.class);
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
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onResume() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr = new Object[1];
                l(getPackageName().codePointAt(3) + 31021, new char[]{49317, 47419, 13186, 44037, 9967, 40824, 6598, 37405, 3117, 34477, 32542, 63953, 29257, 60666, 25950, 57298, 22946, 53772, 19586, 50558, 49092, 14409, 45760, 11430, 42301, 8073}, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                l(12119 - AndroidCharacter.getMirror('0'), new char[]{49319, 61334, 40696, 19907, 31805, 11113, 55898, 35476, 47500, 26859, 5934, 50688, 62835, 42078, 21650, 996, 13019, 57661}, objArr2);
                baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 35, (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr3 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getCapsMode("", 0, 0), Color.blue(0) + 18, (char) View.MeasureSpec.getMode(0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        }

        private static void l(int i, char[] cArr, Object[] objArr) {
            getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
            getonboardingscenario.MyBillsEntityDataFactory = i;
            int length = cArr.length;
            long[] jArr = new long[length];
            getonboardingscenario.getAuthRequestContext = 0;
            while (getonboardingscenario.getAuthRequestContext < cArr.length) {
                jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (NetworkUserEntityData$$ExternalSyntheticLambda2 ^ 4796183387843776835L);
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

    private static void e(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        while (c.BuiltInFictitiousFunctionClassFactory < cArr.length) {
            cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
            cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
            int i2 = 58224;
            for (int i3 = 0; i3 < 16; i3++) {
                cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i2) ^ ((cArr3[0] << 4) + ((char) (NetworkUserEntityData$$ExternalSyntheticLambda0 ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (moveToNextValue ^ 6353485791441662354L)))));
                cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i2) ^ ((cArr3[1] << 4) + ((char) (lookAheadTest ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (scheduleImpl ^ 6353485791441662354L)))));
                i2 -= 40503;
            }
            cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
            cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
            c.BuiltInFictitiousFunctionClassFactory += 2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }

    /* loaded from: classes3.dex */
    public static class Back1 extends Back {
        public static final byte[] $$j = {Ascii.ETB, -59, 18, 83, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
        public static final int $$k = SecExceptionCode.SEC_ERROR_STA_STORE_LOW_VERSION_DATA_FILE;
        public static final byte[] NetworkUserEntityData$$ExternalSyntheticLambda0 = {113, -101, 105, Ascii.SUB, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
        public static final int moveToNextValue = 47;
        private static int NetworkUserEntityData$$ExternalSyntheticLambda2 = 269894697;

        /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0031). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void l(byte r6, int r7, byte r8, java.lang.Object[] r9) {
            /*
                int r6 = 56 - r6
                int r8 = r8 + 16
                int r7 = 106 - r7
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverTransActivity.Back1.NetworkUserEntityData$$ExternalSyntheticLambda0
                byte[] r1 = new byte[r8]
                int r8 = r8 + (-1)
                r2 = 0
                if (r0 != 0) goto L16
                r7 = r6
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r9
                r9 = r8
                goto L31
            L16:
                r3 = 0
                r5 = r7
                r7 = r6
                r6 = r5
            L1a:
                byte r4 = (byte) r6
                r1[r3] = r4
                int r4 = r3 + 1
                if (r3 != r8) goto L29
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L29:
                r3 = r0[r7]
                r5 = r9
                r9 = r8
                r8 = r3
                r3 = r1
                r1 = r0
                r0 = r5
            L31:
                int r8 = -r8
                int r6 = r6 + r8
                int r6 = r6 + (-4)
                int r7 = r7 + 1
                r8 = r9
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L1a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverTransActivity.Back1.l(byte, int, byte, java.lang.Object[]):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0032). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void n(byte r7, int r8, short r9, java.lang.Object[] r10) {
            /*
                int r7 = r7 + 4
                int r8 = r8 * 2
                int r8 = 103 - r8
                int r9 = r9 * 3
                int r9 = 42 - r9
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverTransActivity.Back1.$$j
                byte[] r1 = new byte[r9]
                r2 = 0
                if (r0 != 0) goto L18
                r8 = r7
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r10
                r10 = r9
                goto L32
            L18:
                r3 = 0
            L19:
                int r4 = r3 + 1
                byte r5 = (byte) r8
                r1[r3] = r5
                if (r4 != r9) goto L28
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L28:
                r3 = r0[r7]
                r6 = r8
                r8 = r7
                r7 = r3
                r3 = r1
                r1 = r0
                r0 = r10
                r10 = r9
                r9 = r6
            L32:
                int r7 = -r7
                int r9 = r9 + r7
                int r7 = r9 + (-7)
                int r8 = r8 + 1
                r9 = r10
                r10 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                r6 = r8
                r8 = r7
                r7 = r6
                goto L19
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverTransActivity.Back1.n(byte, int, short, java.lang.Object[]):void");
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            Object[] objArr;
            Object[] objArr2;
            Object[] objArr3;
            Object[] objArr4;
            super.attachBaseContext(context);
            Object[] objArr5 = new Object[1];
            m(true, new char[]{65483, 16, '\f', 65483, 1, 6, '\f', 15, 1, 11, 65534, 16, 16, 2, 0, '\f', 15, 65517}, ExpandableListView.getPackedPositionType(0L) + 18, 111 - TextUtils.getCapsMode("", 0, 0), 11 - (KeyEvent.getMaxKeyCode() >> 16), objArr5);
            Class<?> cls = Class.forName((String) objArr5[0]);
            Object[] objArr6 = new Object[1];
            m(true, new char[]{1, 65517, 17, 5, 65532}, MotionEvent.axisFromString("") + 6, 116 - Drawable.resolveOpacity(0, 0), 4 - TextUtils.indexOf("", "", 0), objArr6);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context applicationContext = context != null ? context.getApplicationContext() : context;
                if (applicationContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 930, (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 35, (char) ExpandableListView.getPackedPositionType(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        m(false, new char[]{65515, 29, JSONLexer.EOI, 30, 65522, 65519, 65515, 65522, 31, 65522, 65521, 65513, 65520, 31, 65517, 65519, 27, 65516, 65519, 30, 65520, 28, 65519, 65521, 65513, 29, 65522, 65521, 65520, 30, 28, 31, 30, 65515, 65514, 65519, 65514, 65514, 65519, JSONLexer.EOI, 29, 28, 28, 65519, 29, 65516, 65521, 29}, 48 - View.resolveSize(0, 0), 83 - (ViewConfiguration.getFadingEdgeLength() >> 16), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 20, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        m(false, new char[]{65519, 65522, 65520, 65520, Typography.dollar, 65519, Typography.quote, 65519, 65524, 65521, 65524, InputCardNumberView.DIVIDER, 65527, '#', 65526, Typography.quote, 65520, 65520, '!', Typography.quote, 65522, 65526, '!', '!', 65518, 65521, 65523, 65518, '#', 65519, '!', 65525, 65519, 65525, 65521, 65521, 65525, 65527, 65527, 65525, 65518, 65519, 65518, 65519, '!', InputCardNumberView.DIVIDER, 65519, 65526, Typography.quote, 65521, 31, 65523, 65524, Typography.quote, Typography.dollar, 65527, 65518, 65526, Typography.quote, '!', 65527, 65523, Typography.quote, 65519}, 64 - (ViewConfiguration.getTapTimeout() >> 16), KeyEvent.getDeadChar(0, 0) + 78, 50 - (ViewConfiguration.getPressedStateDuration() >> 16), objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        m(true, new char[]{30, 29, 65516, 65524, 65520, 65517, Typography.quote, 65524, 65524, 65522, 65523, 30, 65524, 65518, InputCardNumberView.DIVIDER, 65523, 31, 65523, Typography.quote, Typography.quote, 65524, 65525, Typography.quote, 65523, 65519, 29, 30, 65518, InputCardNumberView.DIVIDER, 65520, '!', 29, 65523, 65516, 65519, 65517, 65517, 65524, 65524, 65524, 65520, 65518, 65523, 65525, 30, '!', 65517, 65518, 65525, 65521, 65521, Typography.quote, 65522, 65525, 65521, 65523, 65521, Typography.quote, 65517, 65518, '!', 31, 65525, Typography.quote}, Color.green(0) + 64, KeyEvent.normalizeMetaState(0) + 80, TextUtils.getOffsetAfter("", 0) + 48, objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        m(false, new char[]{65485, 19, 7, 17, 4, 0, 19, 2, 0, 18, 19, 65485, 6, 20, 0, 17, 3, 18, 16, 20, 0, 17, 4, 65485, 2, 14, '\f', 65486, 0, 15, '\b', 65486, '\b', '\r', 6, 4, 18, 19, 65486, 21, 65489, 65486, 4, 21, 4, '\r', 19, 18, 7, 19, 19, 15, 18, 65497, 65486, 65486, 3, 0, '\r', 0}, 60 - (ViewConfiguration.getFadingEdgeLength() >> 16), 109 - Color.green(0), KeyEvent.getDeadChar(0, 0) + 48, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        m(true, new char[]{65532, 7, 65535, 0, 65532, 2}, 6 - ExpandableListView.getPackedPositionGroup(0L), TextUtils.indexOf("", "", 0) + 62, 2 - TextUtils.getTrimmedLength(""), objArr11);
                        try {
                            Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (Process.myPid() >> 22), (-16777198) - Color.rgb(0, 0, 0), (char) ('0' - AndroidCharacter.getMirror('0')))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                    byte b = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[31]);
                    byte b2 = NetworkUserEntityData$$ExternalSyntheticLambda0[25];
                    Object[] objArr13 = new Object[1];
                    l(b, b2, b2, objArr13);
                    Class<?> cls2 = Class.forName((String) objArr13[0]);
                    Object[] objArr14 = new Object[1];
                    l(Ascii.RS, NetworkUserEntityData$$ExternalSyntheticLambda0[9], NetworkUserEntityData$$ExternalSyntheticLambda0[25], objArr14);
                    try {
                        Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                        if (obj3 == null) {
                            Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 56, 3 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) View.combineMeasuredStates(0, 0));
                            Object[] objArr16 = new Object[1];
                            n((byte) ($$j[47] - 1), (byte) (-$$j[12]), $$j[68], objArr16);
                            obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                        }
                        Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 15 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("getAuthRequestContext", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                            }
                            int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                            try {
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - Drawable.resolveOpacity(0, 0), 15 - ExpandableListView.getPackedPositionType(0L), (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("PlaceComponentResult", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                                }
                                if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                    ArrayList arrayList = new ArrayList();
                                    try {
                                        Object[] objArr17 = {invoke2};
                                        Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                        if (obj6 == null) {
                                            obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 815, TextUtils.lastIndexOf("", '0', 0) + 30, (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 57993))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionGroup(0L) + 800, TextUtils.getOffsetAfter("", 0) + 15, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))));
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                        }
                                        arrayList.add(((Method) obj6).invoke(null, objArr17));
                                        long j = ((r4 ^ intValue2) & 4294967295L) | 60129542144L;
                                        try {
                                            Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                            if (obj7 != null) {
                                                objArr = null;
                                            } else {
                                                objArr = null;
                                                obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Gravity.getAbsoluteGravity(0, 0), AndroidCharacter.getMirror('0') - '\r', (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                            }
                                            Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                            try {
                                                Object[] objArr18 = {-1764558010, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                                Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                                if (obj8 == null) {
                                                    obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getWindowTouchSlop() >> 8) + 911, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 19, (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    Object[] objArr19 = {this};
                    byte b3 = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[31]);
                    byte b4 = NetworkUserEntityData$$ExternalSyntheticLambda0[25];
                    Object[] objArr20 = new Object[1];
                    l(b3, b4, b4, objArr20);
                    Class<?> cls4 = Class.forName((String) objArr20[0]);
                    Object[] objArr21 = new Object[1];
                    l(Ascii.RS, NetworkUserEntityData$$ExternalSyntheticLambda0[9], NetworkUserEntityData$$ExternalSyntheticLambda0[25], objArr21);
                    try {
                        Object[] objArr22 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr21[0], Object.class).invoke(null, objArr19)).intValue())};
                        Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                        if (obj9 == null) {
                            Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 46 - TextUtils.getOffsetAfter("", 0), (char) TextUtils.getTrimmedLength(""));
                            Object[] objArr23 = new Object[1];
                            n($$j[0], (byte) ($$j[47] - 1), (byte) (-$$j[8]), objArr23);
                            obj9 = cls5.getMethod((String) objArr23[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                        }
                        Object[] objArr24 = (Object[]) ((Method) obj9).invoke(null, objArr22);
                        int i = ((int[]) objArr24[1])[0];
                        if (((int[]) objArr24[0])[0] != i) {
                            long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                            try {
                                Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj10 != null) {
                                    objArr4 = null;
                                } else {
                                    objArr4 = null;
                                    obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 35, (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                                }
                                Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                                try {
                                    Object[] objArr25 = {-1764558010, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj11 == null) {
                                        obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + 911, 17 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                    }
                                    ((Method) obj11).invoke(invoke4, objArr25);
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
                    Object[] objArr26 = {this};
                    byte b5 = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[31]);
                    byte b6 = NetworkUserEntityData$$ExternalSyntheticLambda0[25];
                    Object[] objArr27 = new Object[1];
                    l(b5, b6, b6, objArr27);
                    Class<?> cls6 = Class.forName((String) objArr27[0]);
                    Object[] objArr28 = new Object[1];
                    l(Ascii.RS, NetworkUserEntityData$$ExternalSyntheticLambda0[9], NetworkUserEntityData$$ExternalSyntheticLambda0[25], objArr28);
                    try {
                        Object[] objArr29 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr28[0], Object.class).invoke(null, objArr26)).intValue())};
                        Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                        if (obj12 == null) {
                            Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 3 - Color.argb(0, 0, 0, 0), (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 38968));
                            Object[] objArr30 = new Object[1];
                            n($$j[0], (byte) ($$j[47] - 1), (byte) (-$$j[8]), objArr30);
                            obj12 = cls7.getMethod((String) objArr30[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                        }
                        Object[] objArr31 = (Object[]) ((Method) obj12).invoke(null, objArr29);
                        int i2 = ((int[]) objArr31[1])[0];
                        if (((int[]) objArr31[0])[0] != i2) {
                            long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                            try {
                                Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj13 != null) {
                                    objArr3 = null;
                                } else {
                                    objArr3 = null;
                                    obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0', 0, 0), View.resolveSize(0, 0) + 35, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                                }
                                Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                                try {
                                    Object[] objArr32 = {-1764558010, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj14 == null) {
                                        obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), 18 - Color.green(0), (char) TextUtils.indexOf("", "", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                    }
                                    ((Method) obj14).invoke(invoke5, objArr32);
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
                    Object[] objArr33 = {this};
                    byte b7 = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[31]);
                    byte b8 = NetworkUserEntityData$$ExternalSyntheticLambda0[25];
                    Object[] objArr34 = new Object[1];
                    l(b7, b8, b8, objArr34);
                    Class<?> cls8 = Class.forName((String) objArr34[0]);
                    Object[] objArr35 = new Object[1];
                    l(Ascii.RS, NetworkUserEntityData$$ExternalSyntheticLambda0[9], NetworkUserEntityData$$ExternalSyntheticLambda0[25], objArr35);
                    try {
                        Object[] objArr36 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr35[0], Object.class).invoke(null, objArr33)).intValue())};
                        Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                        if (obj15 == null) {
                            Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + 108, 3 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)));
                            Object[] objArr37 = new Object[1];
                            n((byte) (-$$j[53]), (byte) (-$$j[9]), (byte) ($$j[47] - 1), objArr37);
                            obj15 = cls9.getMethod((String) objArr37[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                        }
                        Object[] objArr38 = (Object[]) ((Method) obj15).invoke(null, objArr36);
                        int i3 = ((int[]) objArr38[1])[0];
                        if (((int[]) objArr38[0])[0] != i3) {
                            long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                            try {
                                Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj16 != null) {
                                    objArr2 = null;
                                } else {
                                    objArr2 = null;
                                    obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getLongPressTimeout() >> 16) + 35, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                                }
                                Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                                try {
                                    Object[] objArr39 = {-1764558010, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj17 == null) {
                                        obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + 911, View.MeasureSpec.makeMeasureSpec(0, 0) + 18, (char) KeyEvent.normalizeMetaState(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                    }
                                    ((Method) obj17).invoke(invoke6, objArr39);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return super.getApplicationContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
        public Context getBaseContext() {
            return super.getBaseContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
        public Resources getResources() {
            return super.getResources();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle bundle) {
            Object[] objArr;
            Object[] objArr2 = new Object[1];
            m(true, new char[]{65483, 16, '\f', 65483, 1, 6, '\f', 15, 1, 11, 65534, 16, 16, 2, 0, '\f', 15, 65517}, KeyEvent.normalizeMetaState(0) + 18, 110 - ((byte) KeyEvent.getModifierMetaStateMask()), getPackageName().length() + 4, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            m(true, new char[]{1, 65517, 17, 5, 65532}, super.getResources().getString(R.string.phone_number).substring(5, 6).codePointAt(0) - 27, super.getResources().getString(R.string.connection_connected).substring(0, 3).codePointAt(1) + 19, 3 - ImageFormat.getBitsPerPixel(0), objArr3);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    char[] cArr = {5, 65521, 22, 17, 6, 19, 6, 17, 0, 65502, 65483, '\r', '\r', 65534, 65483, 1, 6, '\f', 15, 1, 11, 65534, 1, 65534, 2, 15};
                    int deadChar = KeyEvent.getDeadChar(0, 0) + 26;
                    try {
                        Object[] objArr4 = new Object[1];
                        l((byte) (moveToNextValue + 5), (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[32]), NetworkUserEntityData$$ExternalSyntheticLambda0[30], objArr4);
                        Class<?> cls2 = Class.forName((String) objArr4[0]);
                        Object[] objArr5 = new Object[1];
                        l(NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[48], NetworkUserEntityData$$ExternalSyntheticLambda0[8], objArr5);
                        Object[] objArr6 = new Object[1];
                        m(true, cArr, deadChar, ((ApplicationInfo) cls2.getMethod((String) objArr5[0], null).invoke(this, null)).targetSdkVersion + 78, 22 - Color.alpha(0), objArr6);
                        Class<?> cls3 = Class.forName((String) objArr6[0]);
                        char[] cArr2 = {65535, 5, 4, 65529, 11, '\b', '\b', 65531, 4, '\n', 65495, 6, 6, 2, 65535, 65529, 65527, '\n'};
                        int maximumDrawingCacheSize = (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 18;
                        try {
                            Object[] objArr7 = new Object[1];
                            l((byte) (moveToNextValue + 5), (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[32]), NetworkUserEntityData$$ExternalSyntheticLambda0[30], objArr7);
                            Class<?> cls4 = Class.forName((String) objArr7[0]);
                            Object[] objArr8 = new Object[1];
                            l(NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[48], NetworkUserEntityData$$ExternalSyntheticLambda0[8], objArr8);
                            Object[] objArr9 = new Object[1];
                            m(false, cArr2, maximumDrawingCacheSize, ((ApplicationInfo) cls4.getMethod((String) objArr8[0], null).invoke(this, null)).targetSdkVersion + 85, 2 - ImageFormat.getBitsPerPixel(0), objArr9);
                            baseContext = (Context) cls3.getMethod((String) objArr9[0], new Class[0]).invoke(null, null);
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
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 35, (char) (Process.myPid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        char[] cArr3 = {65515, 29, JSONLexer.EOI, 30, 65522, 65519, 65515, 65522, 31, 65522, 65521, 65513, 65520, 31, 65517, 65519, 27, 65516, 65519, 30, 65520, 28, 65519, 65521, 65513, 29, 65522, 65521, 65520, 30, 28, 31, 30, 65515, 65514, 65519, 65514, 65514, 65519, JSONLexer.EOI, 29, 28, 28, 65519, 29, 65516, 65521, 29};
                        int offsetAfter = 48 - TextUtils.getOffsetAfter("", 0);
                        try {
                            Object[] objArr10 = new Object[1];
                            l((byte) (moveToNextValue + 5), (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[32]), NetworkUserEntityData$$ExternalSyntheticLambda0[30], objArr10);
                            Class<?> cls5 = Class.forName((String) objArr10[0]);
                            Object[] objArr11 = new Object[1];
                            l(NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[48], NetworkUserEntityData$$ExternalSyntheticLambda0[8], objArr11);
                            Object[] objArr12 = new Object[1];
                            m(false, cArr3, offsetAfter, ((ApplicationInfo) cls5.getMethod((String) objArr11[0], null).invoke(this, null)).targetSdkVersion + 50, getPackageName().length() + 13, objArr12);
                            String str = (String) objArr12[0];
                            char[] cArr4 = {65519, 65522, 65520, 65520, Typography.dollar, 65519, Typography.quote, 65519, 65524, 65521, 65524, InputCardNumberView.DIVIDER, 65527, '#', 65526, Typography.quote, 65520, 65520, '!', Typography.quote, 65522, 65526, '!', '!', 65518, 65521, 65523, 65518, '#', 65519, '!', 65525, 65519, 65525, 65521, 65521, 65525, 65527, 65527, 65525, 65518, 65519, 65518, 65519, '!', InputCardNumberView.DIVIDER, 65519, 65526, Typography.quote, 65521, 31, 65523, 65524, Typography.quote, Typography.dollar, 65527, 65518, 65526, Typography.quote, '!', 65527, 65523, Typography.quote, 65519};
                            try {
                                Object[] objArr13 = new Object[1];
                                l((byte) (moveToNextValue + 5), (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[32]), NetworkUserEntityData$$ExternalSyntheticLambda0[30], objArr13);
                                Class<?> cls6 = Class.forName((String) objArr13[0]);
                                Object[] objArr14 = new Object[1];
                                l(NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[48], NetworkUserEntityData$$ExternalSyntheticLambda0[8], objArr14);
                                Object[] objArr15 = new Object[1];
                                m(false, cArr4, ((ApplicationInfo) cls6.getMethod((String) objArr14[0], null).invoke(this, null)).targetSdkVersion + 31, super.getResources().getString(R.string.bottom_on_boarding_body_text_send_money_first).substring(5, 6).length() + 77, super.getResources().getString(R.string.danaviz_only_confirmation_title).substring(9, 10).length() + 49, objArr15);
                                String str2 = (String) objArr15[0];
                                Object[] objArr16 = new Object[1];
                                m(true, new char[]{30, 29, 65516, 65524, 65520, 65517, Typography.quote, 65524, 65524, 65522, 65523, 30, 65524, 65518, InputCardNumberView.DIVIDER, 65523, 31, 65523, Typography.quote, Typography.quote, 65524, 65525, Typography.quote, 65523, 65519, 29, 30, 65518, InputCardNumberView.DIVIDER, 65520, '!', 29, 65523, 65516, 65519, 65517, 65517, 65524, 65524, 65524, 65520, 65518, 65523, 65525, 30, '!', 65517, 65518, 65525, 65521, 65521, Typography.quote, 65522, 65525, 65521, 65523, 65521, Typography.quote, 65517, 65518, '!', 31, 65525, Typography.quote}, View.MeasureSpec.makeMeasureSpec(0, 0) + 64, super.getResources().getString(R.string.category_voucher_code).substring(1, 2).length() + 79, getPackageName().codePointAt(4) - 49, objArr16);
                                String str3 = (String) objArr16[0];
                                Object[] objArr17 = new Object[1];
                                m(false, new char[]{65485, 19, 7, 17, 4, 0, 19, 2, 0, 18, 19, 65485, 6, 20, 0, 17, 3, 18, 16, 20, 0, 17, 4, 65485, 2, 14, '\f', 65486, 0, 15, '\b', 65486, '\b', '\r', 6, 4, 18, 19, 65486, 21, 65489, 65486, 4, 21, 4, '\r', 19, 18, 7, 19, 19, 15, 18, 65497, 65486, 65486, 3, 0, '\r', 0}, getPackageName().length() + 53, 109 - Color.argb(0, 0, 0, 0), TextUtils.indexOf("", "", 0, 0) + 48, objArr17);
                                String str4 = (String) objArr17[0];
                                char[] cArr5 = {65532, 7, 65535, 0, 65532, 2};
                                int i = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 6;
                                int i2 = (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 61;
                                try {
                                    Object[] objArr18 = new Object[1];
                                    l((byte) (moveToNextValue + 5), (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[32]), NetworkUserEntityData$$ExternalSyntheticLambda0[30], objArr18);
                                    Class<?> cls7 = Class.forName((String) objArr18[0]);
                                    Object[] objArr19 = new Object[1];
                                    l(NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[48], NetworkUserEntityData$$ExternalSyntheticLambda0[8], objArr19);
                                    int i3 = ((ApplicationInfo) cls7.getMethod((String) objArr19[0], null).invoke(this, null)).targetSdkVersion - 31;
                                    Object[] objArr20 = new Object[1];
                                    m(true, cArr5, i, i2, i3, objArr20);
                                    try {
                                        Object[] objArr21 = {baseContext, str, str2, str3, str4, true, (String) objArr20[0], 995651014};
                                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                        if (obj2 == null) {
                                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getTrimmedLength(""), 18 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                        }
                                        ((Method) obj2).invoke(invoke, objArr21);
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
            }
            try {
                byte b = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[31]);
                byte b2 = NetworkUserEntityData$$ExternalSyntheticLambda0[25];
                Object[] objArr22 = new Object[1];
                l(b, b2, b2, objArr22);
                Class<?> cls8 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                l(Ascii.RS, NetworkUserEntityData$$ExternalSyntheticLambda0[9], NetworkUserEntityData$$ExternalSyntheticLambda0[25], objArr23);
                try {
                    Object[] objArr24 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr23[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 446, 4 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16));
                        Object[] objArr25 = new Object[1];
                        n((byte) (-$$j[53]), (byte) (-$$j[9]), (byte) ($$j[47] - 1), objArr25);
                        obj3 = cls9.getMethod((String) objArr25[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr26 = (Object[]) ((Method) obj3).invoke(null, objArr24);
                    int i4 = ((int[]) objArr26[1])[0];
                    if (((int[]) objArr26[0])[0] != i4) {
                        long j = ((r0 ^ i4) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ExpandableListView.getPackedPositionGroup(0L), 36 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) ((-1) - ImageFormat.getBitsPerPixel(0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr27 = {-744533697, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + 912, 18 - Color.blue(0), (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr27);
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
                    super.onCreate(bundle);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onPause() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                char[] cArr = {5, 65521, 22, 17, 6, 19, 6, 17, 0, 65502, 65483, '\r', '\r', 65534, 65483, 1, 6, '\f', 15, 1, 11, 65534, 1, 65534, 2, 15};
                try {
                    Object[] objArr = new Object[1];
                    l((byte) (moveToNextValue + 5), (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[32]), NetworkUserEntityData$$ExternalSyntheticLambda0[30], objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    Object[] objArr2 = new Object[1];
                    l(NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[48], NetworkUserEntityData$$ExternalSyntheticLambda0[8], objArr2);
                    int i = ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion - 7;
                    int length = super.getResources().getString(R.string.auto_routing_success_activation).substring(8, 9).length() + 110;
                    try {
                        Object[] objArr3 = new Object[1];
                        l((byte) (moveToNextValue + 5), (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[32]), NetworkUserEntityData$$ExternalSyntheticLambda0[30], objArr3);
                        Class<?> cls2 = Class.forName((String) objArr3[0]);
                        Object[] objArr4 = new Object[1];
                        l(NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[48], NetworkUserEntityData$$ExternalSyntheticLambda0[8], objArr4);
                        int i2 = ((ApplicationInfo) cls2.getMethod((String) objArr4[0], null).invoke(this, null)).targetSdkVersion - 11;
                        Object[] objArr5 = new Object[1];
                        m(true, cArr, i, length, i2, objArr5);
                        Class<?> cls3 = Class.forName((String) objArr5[0]);
                        char[] cArr2 = {65535, 5, 4, 65529, 11, '\b', '\b', 65531, 4, '\n', 65495, 6, 6, 2, 65535, 65529, 65527, '\n'};
                        try {
                            Object[] objArr6 = new Object[1];
                            l((byte) (moveToNextValue + 5), (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[32]), NetworkUserEntityData$$ExternalSyntheticLambda0[30], objArr6);
                            Class<?> cls4 = Class.forName((String) objArr6[0]);
                            l(NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[48], NetworkUserEntityData$$ExternalSyntheticLambda0[8], new Object[1]);
                            Object[] objArr7 = new Object[1];
                            m(false, cArr2, ((ApplicationInfo) cls4.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 15, 8 + getPackageName().codePointAt(5), super.getResources().getString(R.string.card_binding_showcase_help_supported_card_title).substring(0, 1).length() + 2, objArr7);
                            baseContext = (Context) cls3.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
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
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (-16777181) - Color.rgb(0, 0, 0), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr8 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - Process.getGidForName(""), 18 - KeyEvent.normalizeMetaState(0), (char) KeyEvent.normalizeMetaState(0))).getMethod("MyBillsEntityDataFactory", Context.class);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr8);
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
            super.onPause();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onResume() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr = new Object[1];
                m(true, new char[]{5, 65521, 22, 17, 6, 19, 6, 17, 0, 65502, 65483, '\r', '\r', 65534, 65483, 1, 6, '\f', 15, 1, 11, 65534, 1, 65534, 2, 15}, 26 - Color.green(0), super.getResources().getString(R.string.sendmoney_share_to_feed_disclaimer).substring(11, 12).length() + 110, 22 - (Process.myPid() >> 22), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                char[] cArr = {65535, 5, 4, 65529, 11, '\b', '\b', 65531, 4, '\n', 65495, 6, 6, 2, 65535, 65529, 65527, '\n'};
                int length = super.getResources().getString(R.string.all_friend).substring(7, 8).length() + 17;
                try {
                    Object[] objArr2 = new Object[1];
                    l((byte) (moveToNextValue + 5), (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[32]), NetworkUserEntityData$$ExternalSyntheticLambda0[30], objArr2);
                    Class<?> cls2 = Class.forName((String) objArr2[0]);
                    Object[] objArr3 = new Object[1];
                    l(NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[48], NetworkUserEntityData$$ExternalSyntheticLambda0[8], objArr3);
                    Object[] objArr4 = new Object[1];
                    m(false, cArr, length, ((ApplicationInfo) cls2.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 85, (-16777213) - Color.rgb(0, 0, 0), objArr4);
                    baseContext = (Context) cls.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), TextUtils.indexOf((CharSequence) "", '0') + 36, (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr5 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", ""), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 18, (char) Color.green(0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr5);
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
            super.onResume();
        }

        private static void m(boolean z, char[] cArr, int i, int i2, int i3, Object[] objArr) {
            A a2 = new A();
            char[] cArr2 = new char[i];
            a2.MyBillsEntityDataFactory = 0;
            while (a2.MyBillsEntityDataFactory < i) {
                a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
                cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i2);
                int i4 = a2.MyBillsEntityDataFactory;
                cArr2[i4] = (char) (cArr2[i4] - ((int) (NetworkUserEntityData$$ExternalSyntheticLambda2 ^ (-5694784870793460699L))));
                a2.MyBillsEntityDataFactory++;
            }
            if (i3 > 0) {
                a2.BuiltInFictitiousFunctionClassFactory = i3;
                char[] cArr3 = new char[i];
                System.arraycopy(cArr2, 0, cArr3, 0, i);
                System.arraycopy(cArr3, 0, cArr2, i - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
                System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i - a2.BuiltInFictitiousFunctionClassFactory);
            }
            if (z) {
                char[] cArr4 = new char[i];
                a2.MyBillsEntityDataFactory = 0;
                while (a2.MyBillsEntityDataFactory < i) {
                    cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i - a2.MyBillsEntityDataFactory) - 1];
                    a2.MyBillsEntityDataFactory++;
                }
                cArr2 = cArr4;
            }
            objArr[0] = new String(cArr2);
        }
    }

    /* loaded from: classes3.dex */
    public static class Back3 extends Back {
        public static final byte[] $$j = {116, 58, -28, -63, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
        public static final int $$k = 125;
        public static final byte[] NetworkUserEntityData$$ExternalSyntheticLambda0 = {62, -79, -77, -78, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
        public static final int moveToNextValue = 254;
        private static int NetworkUserEntityData$$ExternalSyntheticLambda2 = 269894752;

        /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0030). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void m(int r6, byte r7, int r8, java.lang.Object[] r9) {
            /*
                int r7 = r7 + 16
                int r8 = 56 - r8
                int r6 = r6 + 97
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverTransActivity.Back3.NetworkUserEntityData$$ExternalSyntheticLambda0
                byte[] r1 = new byte[r7]
                int r7 = r7 + (-1)
                r2 = 0
                if (r0 != 0) goto L15
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r9
                r9 = r8
                goto L30
            L15:
                r3 = 0
                r5 = r8
                r8 = r6
                r6 = r5
            L19:
                byte r4 = (byte) r8
                r1[r3] = r4
                int r4 = r3 + 1
                if (r3 != r7) goto L28
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L28:
                r3 = r0[r6]
                r5 = r9
                r9 = r6
                r6 = r3
                r3 = r1
                r1 = r0
                r0 = r5
            L30:
                int r6 = -r6
                int r8 = r8 + r6
                int r8 = r8 + (-4)
                int r6 = r9 + 1
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L19
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverTransActivity.Back3.m(int, byte, int, java.lang.Object[]):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002c). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void n(short r6, int r7, short r8, java.lang.Object[] r9) {
            /*
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverTransActivity.Back3.$$j
                int r8 = r8 * 2
                int r8 = r8 + 75
                int r6 = r6 + 4
                int r7 = r7 * 3
                int r7 = 42 - r7
                byte[] r1 = new byte[r7]
                int r7 = r7 + (-1)
                r2 = 0
                if (r0 != 0) goto L17
                r3 = r8
                r4 = 0
                r8 = r7
                goto L2c
            L17:
                r3 = 0
            L18:
                byte r4 = (byte) r8
                r1[r3] = r4
                int r4 = r3 + 1
                if (r3 != r7) goto L27
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L27:
                r3 = r0[r6]
                r5 = r8
                r8 = r7
                r7 = r5
            L2c:
                int r6 = r6 + 1
                int r3 = -r3
                int r7 = r7 + r3
                int r7 = r7 + (-7)
                r3 = r4
                r5 = r8
                r8 = r7
                r7 = r5
                goto L18
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverTransActivity.Back3.n(short, int, short, java.lang.Object[]):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:111:0x0552  */
        /* JADX WARN: Removed duplicated region for block: B:112:0x0557  */
        /* JADX WARN: Removed duplicated region for block: B:114:0x055b  */
        /* JADX WARN: Removed duplicated region for block: B:158:0x0728  */
        /* JADX WARN: Removed duplicated region for block: B:159:0x072d  */
        /* JADX WARN: Removed duplicated region for block: B:161:0x0731  */
        /* JADX WARN: Removed duplicated region for block: B:205:0x0900  */
        /* JADX WARN: Removed duplicated region for block: B:206:0x0905  */
        /* JADX WARN: Removed duplicated region for block: B:208:0x0909  */
        /* JADX WARN: Removed duplicated region for block: B:251:0x0ad9 A[ORIG_RETURN, RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:256:0x0276 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0262  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0267  */
        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void attachBaseContext(android.content.Context r29) {
            /*
                Method dump skipped, instructions count: 3072
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverTransActivity.Back3.attachBaseContext(android.content.Context):void");
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return super.getApplicationContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
        public Context getBaseContext() {
            return super.getBaseContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
        public Resources getResources() {
            return super.getResources();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle bundle) {
            Object[] objArr;
            Object[] objArr2 = new Object[1];
            l(false, new char[]{0, 2, 16, 16, 65534, 11, 1, 15, '\f', 6, 1, 65483, '\f', 16, 65483, 65517, 15, '\f'}, (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 18, (ViewConfiguration.getTouchSlop() >> 8) + 168, super.getResources().getString(R.string.paylater_loan_personal_button_active).substring(1, 2).codePointAt(0) + SecLiteException.ERROR_API_KEY_OR_SIGN, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            char[] cArr = {65517, 17, 5, 65532, 1};
            try {
                Object[] objArr3 = new Object[1];
                m(NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[30], (byte) (moveToNextValue & 53), objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                m(NetworkUserEntityData$$ExternalSyntheticLambda0[5], NetworkUserEntityData$$ExternalSyntheticLambda0[8], NetworkUserEntityData$$ExternalSyntheticLambda0[25], new Object[1]);
                Object[] objArr4 = new Object[1];
                l(true, cArr, ((ApplicationInfo) cls2.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 28, getPackageName().codePointAt(2) + 127, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 3, objArr4);
                int intValue = ((Integer) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                if (intValue < 99000 || intValue > 99999) {
                    Context baseContext = getBaseContext();
                    if (baseContext == null) {
                        char[] cArr2 = {6, 1, 65483, 65534, '\r', '\r', 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15, '\f'};
                        try {
                            Object[] objArr5 = new Object[1];
                            m(NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[30], (byte) (moveToNextValue & 53), objArr5);
                            Class<?> cls3 = Class.forName((String) objArr5[0]);
                            m(NetworkUserEntityData$$ExternalSyntheticLambda0[5], NetworkUserEntityData$$ExternalSyntheticLambda0[8], NetworkUserEntityData$$ExternalSyntheticLambda0[25], new Object[1]);
                            Object[] objArr6 = new Object[1];
                            l(false, cArr2, ((ApplicationInfo) cls3.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 7, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 168, TextUtils.lastIndexOf("", '0', 0, 0) + 22, objArr6);
                            Class<?> cls4 = Class.forName((String) objArr6[0]);
                            Object[] objArr7 = new Object[1];
                            l(false, new char[]{6, 6, 2, 65535, 65529, 65527, '\n', 65535, 5, 4, 65529, 11, '\b', '\b', 65531, 4, '\n', 65495}, 18 - View.MeasureSpec.getMode(0), getPackageName().length() + 168, super.getResources().getString(R.string.registered_phone_number_in_bank).substring(24, 25).length() + 9, objArr7);
                            baseContext = (Context) cls4.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    }
                    if (baseContext != null) {
                        baseContext = baseContext.getApplicationContext();
                    }
                    if (baseContext != null) {
                        try {
                            Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj == null) {
                                obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776287) - Color.rgb(0, 0, 0), (Process.myTid() >> 22) + 35, (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                            }
                            Object invoke = ((Method) obj).invoke(null, null);
                            char[] cArr3 = {30, 28, 31, 30, 65515, 65514, 65519, 65514, 65514, 65519, JSONLexer.EOI, 29, 28, 28, 65519, 29, 65516, 65521, 29, 65515, 29, JSONLexer.EOI, 30, 65522, 65519, 65515, 65522, 31, 65522, 65521, 65513, 65520, 31, 65517, 65519, 27, 65516, 65519, 30, 65520, 28, 65519, 65521, 65513, 29, 65522, 65521, 65520};
                            int codePointAt = super.getResources().getString(R.string.upgrade_express_pay_desc).substring(4, 5).codePointAt(0) - 49;
                            try {
                                Object[] objArr8 = new Object[1];
                                m(NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[30], (byte) (moveToNextValue & 53), objArr8);
                                Class<?> cls5 = Class.forName((String) objArr8[0]);
                                Object[] objArr9 = new Object[1];
                                m(NetworkUserEntityData$$ExternalSyntheticLambda0[5], NetworkUserEntityData$$ExternalSyntheticLambda0[8], NetworkUserEntityData$$ExternalSyntheticLambda0[25], objArr9);
                                Object[] objArr10 = new Object[1];
                                l(false, cArr3, codePointAt, ((ApplicationInfo) cls5.getMethod((String) objArr9[0], null).invoke(this, null)).targetSdkVersion + 107, super.getResources().getString(R.string.card_binding_showcase_help_content).substring(1, 2).codePointAt(0) - 58, objArr10);
                                String str = (String) objArr10[0];
                                Object[] objArr11 = new Object[1];
                                l(true, new char[]{65518, '!', '!', 65526, 65522, Typography.quote, '!', 65520, 65520, Typography.quote, 65526, '#', 65527, InputCardNumberView.DIVIDER, 65524, 65521, 65524, 65519, Typography.quote, 65519, Typography.dollar, 65520, 65520, 65522, 65519, 65519, Typography.quote, 65523, 65527, '!', Typography.quote, 65526, 65518, 65527, Typography.dollar, Typography.quote, 65524, 65523, 31, 65521, Typography.quote, 65526, 65519, InputCardNumberView.DIVIDER, '!', 65519, 65518, 65519, 65518, 65525, 65527, 65527, 65525, 65521, 65521, 65525, 65519, 65525, '!', 65519, '#', 65518, 65523, 65521}, getPackageName().codePointAt(4) - 33, (ViewConfiguration.getTapTimeout() >> 16) + 135, 38 - TextUtils.lastIndexOf("", '0'), objArr11);
                                String str2 = (String) objArr11[0];
                                Object[] objArr12 = new Object[1];
                                l(false, new char[]{65524, 65517, 65517, 65519, 65516, 65523, 29, '!', 65520, InputCardNumberView.DIVIDER, 65518, 30, 29, 65519, 65523, Typography.quote, 65525, 65524, Typography.quote, Typography.quote, 65523, 31, 65523, InputCardNumberView.DIVIDER, 65518, 65524, 30, 65523, 65522, 65524, 65524, Typography.quote, 65517, 65520, 65524, 65516, 29, 30, Typography.quote, 65525, 31, '!', 65518, 65517, Typography.quote, 65521, 65523, 65521, 65525, 65522, Typography.quote, 65521, 65521, 65525, 65518, 65517, '!', 30, 65525, 65523, 65518, 65520, 65524, 65524}, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 63, super.getResources().getString(R.string.all_friend_list_section_title).substring(7, 8).length() + 136, 53 - TextUtils.indexOf((CharSequence) "", '0'), objArr12);
                                String str3 = (String) objArr12[0];
                                char[] cArr4 = {65485, 19, 7, 17, 4, 0, 19, 2, 0, 18, 19, 65485, 6, 20, 0, 17, 3, 18, 16, 20, 0, 17, 4, 65485, 2, 14, '\f', 65486, 0, 15, '\b', 65486, '\b', '\r', 6, 4, 18, 19, 65486, 21, 65489, 65486, 4, 21, 4, '\r', 19, 18, 7, 19, 19, 15, 18, 65497, 65486, 65486, 3, 0, '\r', 0};
                                try {
                                    Object[] objArr13 = new Object[1];
                                    m(NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[30], (byte) (moveToNextValue & 53), objArr13);
                                    Class<?> cls6 = Class.forName((String) objArr13[0]);
                                    Object[] objArr14 = new Object[1];
                                    m(NetworkUserEntityData$$ExternalSyntheticLambda0[5], NetworkUserEntityData$$ExternalSyntheticLambda0[8], NetworkUserEntityData$$ExternalSyntheticLambda0[25], objArr14);
                                    Object[] objArr15 = new Object[1];
                                    l(false, cArr4, ((ApplicationInfo) cls6.getMethod((String) objArr14[0], null).invoke(this, null)).targetSdkVersion + 27, 166 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (ViewConfiguration.getScrollBarSize() >> 8) + 48, objArr15);
                                    String str4 = (String) objArr15[0];
                                    Object[] objArr16 = new Object[1];
                                    l(true, new char[]{65532, 2, 65532, 7, 65535, 0}, (ViewConfiguration.getEdgeSlop() >> 16) + 6, super.getResources().getString(R.string.create_savings).substring(9, 10).codePointAt(0) + 22, getPackageName().length() - 3, objArr16);
                                    try {
                                        Object[] objArr17 = {baseContext, str, str2, str3, str4, true, (String) objArr16[0], 995651014};
                                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                        if (obj2 == null) {
                                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + 911, 18 - (KeyEvent.getMaxKeyCode() >> 16), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                        }
                                        ((Method) obj2).invoke(invoke, objArr17);
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
                        } catch (Throwable th5) {
                            Throwable cause5 = th5.getCause();
                            if (cause5 == null) {
                                throw th5;
                            }
                            throw cause5;
                        }
                    }
                }
                try {
                    Object[] objArr18 = new Object[1];
                    m((byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[32]), NetworkUserEntityData$$ExternalSyntheticLambda0[25], (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[31]), objArr18);
                    Class<?> cls7 = Class.forName((String) objArr18[0]);
                    byte b = (byte) (moveToNextValue & 8);
                    byte b2 = NetworkUserEntityData$$ExternalSyntheticLambda0[25];
                    Object[] objArr19 = new Object[1];
                    m(b, b2, (byte) (b2 | Ascii.RS), objArr19);
                    try {
                        Object[] objArr20 = {Integer.valueOf(((Integer) cls7.getMethod((String) objArr19[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                        if (obj3 == null) {
                            Class cls8 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - Gravity.getAbsoluteGravity(0, 0), 4 - Color.green(0), (char) View.combineMeasuredStates(0, 0));
                            byte b3 = (byte) (-$$j[53]);
                            byte b4 = (byte) ($$j[47] - 1);
                            Object[] objArr21 = new Object[1];
                            n(b3, b4, b4, objArr21);
                            obj3 = cls8.getMethod((String) objArr21[0], Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                        }
                        Object[] objArr22 = (Object[]) ((Method) obj3).invoke(null, objArr20);
                        int i = ((int[]) objArr22[1])[0];
                        if (((int[]) objArr22[0])[0] != i) {
                            long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                            try {
                                Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj4 != null) {
                                    objArr = null;
                                } else {
                                    objArr = null;
                                    obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778145, 35 - (Process.myTid() >> 22), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                }
                                Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                                try {
                                    Object[] objArr23 = {1616908317, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj5 == null) {
                                        obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 911, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 17, (char) Color.alpha(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                    }
                                    ((Method) obj5).invoke(invoke2, objArr23);
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
                        super.onCreate(bundle);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onPause() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr = new Object[1];
                l(false, new char[]{6, 1, 65483, 65534, '\r', '\r', 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15, '\f'}, getPackageName().length() + 19, super.getResources().getString(R.string.dana_protection_security_suggestion_title).substring(1, 2).codePointAt(0) + 67, getPackageName().codePointAt(2) - 25, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                char[] cArr = {6, 6, 2, 65535, 65529, 65527, '\n', 65535, 5, 4, 65529, 11, '\b', '\b', 65531, 4, '\n', 65495};
                try {
                    Object[] objArr2 = new Object[1];
                    m(NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[30], (byte) (moveToNextValue & 53), objArr2);
                    Class<?> cls2 = Class.forName((String) objArr2[0]);
                    m(NetworkUserEntityData$$ExternalSyntheticLambda0[5], NetworkUserEntityData$$ExternalSyntheticLambda0[8], NetworkUserEntityData$$ExternalSyntheticLambda0[25], new Object[1]);
                    Object[] objArr3 = new Object[1];
                    l(false, cArr, ((ApplicationInfo) cls2.getMethod((String) r10[0], null).invoke(this, null)).targetSdkVersion - 15, super.getResources().getString(R.string.view_photos).substring(7, 10).length() + 172, KeyEvent.keyCodeFromString("") + 10, objArr3);
                    baseContext = (Context) cls.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 35, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr4 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ImageFormat.getBitsPerPixel(0), 19 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Context.class);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr4);
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
            super.onPause();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onResume() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                char[] cArr = {6, 1, 65483, 65534, '\r', '\r', 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15, '\f'};
                int red = 26 - Color.red(0);
                try {
                    Object[] objArr = new Object[1];
                    m(NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[30], (byte) (moveToNextValue & 53), objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    Object[] objArr2 = new Object[1];
                    m(NetworkUserEntityData$$ExternalSyntheticLambda0[5], NetworkUserEntityData$$ExternalSyntheticLambda0[8], NetworkUserEntityData$$ExternalSyntheticLambda0[25], objArr2);
                    Object[] objArr3 = new Object[1];
                    l(false, cArr, red, ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion + 135, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 20, objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    char[] cArr2 = {6, 6, 2, 65535, 65529, 65527, '\n', 65535, 5, 4, 65529, 11, '\b', '\b', 65531, 4, '\n', 65495};
                    int codePointAt = super.getResources().getString(R.string.pushverify_payment).substring(0, 1).codePointAt(0) - 62;
                    try {
                        Object[] objArr4 = new Object[1];
                        m(NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[30], (byte) (moveToNextValue & 53), objArr4);
                        Class<?> cls3 = Class.forName((String) objArr4[0]);
                        Object[] objArr5 = new Object[1];
                        m(NetworkUserEntityData$$ExternalSyntheticLambda0[5], NetworkUserEntityData$$ExternalSyntheticLambda0[8], NetworkUserEntityData$$ExternalSyntheticLambda0[25], objArr5);
                        Object[] objArr6 = new Object[1];
                        l(false, cArr2, codePointAt, ((ApplicationInfo) cls3.getMethod((String) objArr5[0], null).invoke(this, null)).targetSdkVersion + 142, getPackageName().codePointAt(5) - 100, objArr6);
                        baseContext = (Context) cls2.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollBarSize() >> 8), 35 - TextUtils.getCapsMode("", 0, 0), (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr7 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + 911, 19 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) Color.red(0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
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
            super.onResume();
        }

        private static void l(boolean z, char[] cArr, int i, int i2, int i3, Object[] objArr) {
            A a2 = new A();
            char[] cArr2 = new char[i];
            a2.MyBillsEntityDataFactory = 0;
            while (a2.MyBillsEntityDataFactory < i) {
                a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
                cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i2);
                int i4 = a2.MyBillsEntityDataFactory;
                cArr2[i4] = (char) (cArr2[i4] - ((int) (NetworkUserEntityData$$ExternalSyntheticLambda2 ^ (-5694784870793460699L))));
                a2.MyBillsEntityDataFactory++;
            }
            if (i3 > 0) {
                a2.BuiltInFictitiousFunctionClassFactory = i3;
                char[] cArr3 = new char[i];
                System.arraycopy(cArr2, 0, cArr3, 0, i);
                System.arraycopy(cArr3, 0, cArr2, i - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
                System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i - a2.BuiltInFictitiousFunctionClassFactory);
            }
            if (z) {
                char[] cArr4 = new char[i];
                a2.MyBillsEntityDataFactory = 0;
                while (a2.MyBillsEntityDataFactory < i) {
                    cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i - a2.MyBillsEntityDataFactory) - 1];
                    a2.MyBillsEntityDataFactory++;
                }
                cArr2 = cArr4;
            }
            objArr[0] = new String(cArr2);
        }
    }

    /* loaded from: classes3.dex */
    public static class Back4 extends Back {
        public static final byte[] $$j = {45, -61, Ascii.ETB, 105, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
        public static final int $$k = 200;
        public static final byte[] moveToNextValue = {109, -87, 105, -77, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
        public static final int NetworkUserEntityData$$ExternalSyntheticLambda0 = 57;
        private static int GetContactSyncConfig = 269894817;

        /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0030). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void m(int r7, byte r8, int r9, java.lang.Object[] r10) {
            /*
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverTransActivity.Back4.moveToNextValue
                int r8 = 23 - r8
                int r9 = 106 - r9
                int r7 = 55 - r7
                byte[] r1 = new byte[r8]
                r2 = 0
                if (r0 != 0) goto L13
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r10
                r10 = r8
                goto L30
            L13:
                r3 = 0
                r6 = r9
                r9 = r8
                r8 = r6
            L17:
                int r4 = r3 + 1
                byte r5 = (byte) r8
                r1[r3] = r5
                int r7 = r7 + 1
                if (r4 != r9) goto L28
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L28:
                r3 = r0[r7]
                r6 = r10
                r10 = r9
                r9 = r3
                r3 = r1
                r1 = r0
                r0 = r6
            L30:
                int r9 = -r9
                int r8 = r8 + r9
                int r8 = r8 + (-4)
                r9 = r10
                r10 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L17
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverTransActivity.Back4.m(int, byte, int, java.lang.Object[]):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0033). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void n(int r6, int r7, byte r8, java.lang.Object[] r9) {
            /*
                int r8 = r8 * 3
                int r8 = r8 + 21
                int r7 = r7 + 4
                int r6 = r6 * 2
                int r6 = 103 - r6
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverTransActivity.Back4.$$j
                byte[] r1 = new byte[r8]
                int r8 = r8 + (-1)
                r2 = 0
                if (r0 != 0) goto L19
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r9
                r9 = r8
                goto L33
            L19:
                r3 = 0
            L1a:
                byte r4 = (byte) r6
                r1[r3] = r4
                if (r3 != r8) goto L27
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L27:
                r4 = r0[r7]
                int r3 = r3 + 1
                r5 = r8
                r8 = r6
                r6 = r4
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r9
                r9 = r5
            L33:
                int r7 = r7 + 1
                int r8 = r8 + r6
                int r6 = r8 + (-7)
                r8 = r9
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L1a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverTransActivity.Back4.n(int, int, byte, java.lang.Object[]):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:111:0x053e  */
        /* JADX WARN: Removed duplicated region for block: B:112:0x0543  */
        /* JADX WARN: Removed duplicated region for block: B:157:0x0707  */
        /* JADX WARN: Removed duplicated region for block: B:158:0x070c  */
        /* JADX WARN: Removed duplicated region for block: B:203:0x08d3  */
        /* JADX WARN: Removed duplicated region for block: B:204:0x08d8  */
        /* JADX WARN: Removed duplicated region for block: B:248:0x0a9a A[ORIG_RETURN, RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:253:0x0710 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:265:0x08dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:271:0x0272 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:281:0x0547 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0261  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0266  */
        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void attachBaseContext(android.content.Context r29) {
            /*
                Method dump skipped, instructions count: 3010
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverTransActivity.Back4.attachBaseContext(android.content.Context):void");
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return super.getApplicationContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
        public Context getBaseContext() {
            return super.getBaseContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
        public Resources getResources() {
            return super.getResources();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle bundle) {
            Object[] objArr;
            Object[] objArr2;
            Object[] objArr3 = new Object[1];
            l(false, new char[]{2, 16, 16, 65534, 11, 1, 15, '\f', 6, 1, 65483, '\f', 16, 65483, 65517, 15, '\f', 0}, super.getResources().getString(R.string.send_money_onboarding_favorite_description).substring(6, 7).length() + 17, super.getResources().getString(R.string.empty_state_desc_first_comment).substring(14, 15).length() + 230, super.getResources().getString(R.string.group_send_empty_state_description).substring(0, 2).codePointAt(0) - 68, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            l(true, new char[]{65532, 1, 65517, 17, 5}, super.getResources().getString(R.string.family_account_text_invite_by_phone_numbers).substring(1, 2).length() + 4, getPackageName().length() + 229, (Process.myTid() >> 22) + 5, objArr4);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr5 = new Object[1];
                    l(true, new char[]{17, 6, 19, 6, 17, 0, 65502, 65483, '\r', '\r', 65534, 65483, 1, 6, '\f', 15, 1, 11, 65534, 1, 65534, 2, 15, 5, 65521, 22}, super.getResources().getString(R.string.add_new_panin_card).substring(1, 2).codePointAt(0) - 71, super.getResources().getString(R.string.processing).substring(6, 7).length() + 230, 19 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), objArr5);
                    Class<?> cls2 = Class.forName((String) objArr5[0]);
                    char[] cArr = {65529, 4, 5, 65535, '\n', 65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531, '\b', '\b', 11};
                    int codePointAt = super.getResources().getString(R.string.res_0x7f130f2f_networkuserentitydata_externalsyntheticlambda4).substring(13, 14).codePointAt(0) - 97;
                    int codePointAt2 = getPackageName().codePointAt(1) + 138;
                    try {
                        Object[] objArr6 = new Object[1];
                        m((byte) (NetworkUserEntityData$$ExternalSyntheticLambda0 - 5), moveToNextValue[25], (byte) (-moveToNextValue[32]), objArr6);
                        Class<?> cls3 = Class.forName((String) objArr6[0]);
                        Object[] objArr7 = new Object[1];
                        m(moveToNextValue[25], moveToNextValue[41], moveToNextValue[48], objArr7);
                        int i = ((ApplicationInfo) cls3.getMethod((String) objArr7[0], null).invoke(this, null)).targetSdkVersion - 32;
                        Object[] objArr8 = new Object[1];
                        l(true, cArr, codePointAt, codePointAt2, i, objArr8);
                        baseContext = (Context) cls2.getMethod((String) objArr8[0], new Class[0]).invoke(null, null);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getCapsMode("", 0, 0), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 35, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(objArr, objArr);
                        char[] cArr2 = {29, 65519, 28, 28, 29, JSONLexer.EOI, 65519, 65514, 65514, 65519, 65514, 65515, 30, 31, 28, 30, 65520, 65521, 65522, 29, 65513, 65521, 65519, 28, 65520, 30, 65519, 65516, 27, 65519, 65517, 31, 65520, 65513, 65521, 65522, 31, 65522, 65515, 65519, 65522, 30, JSONLexer.EOI, 29, 65515, 29, 65521, 65516};
                        try {
                            Object[] objArr9 = new Object[1];
                            m((byte) (NetworkUserEntityData$$ExternalSyntheticLambda0 - 5), moveToNextValue[25], (byte) (-moveToNextValue[32]), objArr9);
                            Class<?> cls4 = Class.forName((String) objArr9[0]);
                            Object[] objArr10 = new Object[1];
                            m(moveToNextValue[25], moveToNextValue[41], moveToNextValue[48], objArr10);
                            Object[] objArr11 = new Object[1];
                            l(true, cArr2, ((ApplicationInfo) cls4.getMethod((String) objArr10[0], null).invoke(this, null)).targetSdkVersion + 15, (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 203, 25 - Drawable.resolveOpacity(0, 0), objArr11);
                            String str = (String) objArr11[0];
                            char[] cArr3 = {65527, 65527, 65525, 65521, 65521, 65525, 65519, 65525, '!', 65519, '#', 65518, 65523, 65521, 65518, '!', '!', 65526, 65522, Typography.quote, '!', 65520, 65520, Typography.quote, 65526, '#', 65527, InputCardNumberView.DIVIDER, 65524, 65521, 65524, 65519, Typography.quote, 65519, Typography.dollar, 65520, 65520, 65522, 65519, 65519, Typography.quote, 65523, 65527, '!', Typography.quote, 65526, 65518, 65527, Typography.dollar, Typography.quote, 65524, 65523, 31, 65521, Typography.quote, 65526, 65519, InputCardNumberView.DIVIDER, '!', 65519, 65518, 65519, 65518, 65525};
                            int length = getPackageName().length() + 57;
                            int codePointAt3 = getPackageName().codePointAt(2) + 152;
                            try {
                                Object[] objArr12 = new Object[1];
                                m((byte) (NetworkUserEntityData$$ExternalSyntheticLambda0 - 5), moveToNextValue[25], (byte) (-moveToNextValue[32]), objArr12);
                                Class<?> cls5 = Class.forName((String) objArr12[0]);
                                Object[] objArr13 = new Object[1];
                                m(moveToNextValue[25], moveToNextValue[41], moveToNextValue[48], objArr13);
                                int i2 = ((ApplicationInfo) cls5.getMethod((String) objArr13[0], null).invoke(this, null)).targetSdkVersion + 20;
                                Object[] objArr14 = new Object[1];
                                l(true, cArr3, length, codePointAt3, i2, objArr14);
                                String str2 = (String) objArr14[0];
                                char[] cArr4 = {65520, 65517, Typography.quote, 65524, 65524, 65522, 65523, 30, 65524, 65518, InputCardNumberView.DIVIDER, 65523, 31, 65523, Typography.quote, Typography.quote, 65524, 65525, Typography.quote, 65523, 65519, 29, 30, 65518, InputCardNumberView.DIVIDER, 65520, '!', 29, 65523, 65516, 65519, 65517, 65517, 65524, 65524, 65524, 65520, 65518, 65523, 65525, 30, '!', 65517, 65518, 65525, 65521, 65521, Typography.quote, 65522, 65525, 65521, 65523, 65521, Typography.quote, 65517, 65518, '!', 31, 65525, Typography.quote, 30, 29, 65516, 65524};
                                int codePointAt4 = super.getResources().getString(R.string.social_feeds_entry_point_description).substring(4, 5).codePointAt(0) + 32;
                                int codePointAt5 = super.getResources().getString(R.string.link_not_found_toolbar_title).substring(0, 5).codePointAt(0) + 124;
                                try {
                                    Object[] objArr15 = new Object[1];
                                    m((byte) (NetworkUserEntityData$$ExternalSyntheticLambda0 - 5), moveToNextValue[25], (byte) (-moveToNextValue[32]), objArr15);
                                    Class<?> cls6 = Class.forName((String) objArr15[0]);
                                    Object[] objArr16 = new Object[1];
                                    m(moveToNextValue[25], moveToNextValue[41], moveToNextValue[48], objArr16);
                                    int i3 = ((ApplicationInfo) cls6.getMethod((String) objArr16[0], null).invoke(this, null)).targetSdkVersion + 11;
                                    Object[] objArr17 = new Object[1];
                                    l(true, cArr4, codePointAt4, codePointAt5, i3, objArr17);
                                    String str3 = (String) objArr17[0];
                                    char[] cArr5 = {21, 65486, 19, 18, 4, 6, '\r', '\b', 65486, '\b', 15, 0, 65486, '\f', 14, 2, 65485, 4, 17, 0, 20, 16, 18, 3, 17, 0, 20, 6, 65485, 19, 18, 0, 2, 19, 0, 4, 17, 7, 19, 65485, 0, '\r', 0, 3, 65486, 65486, 65497, 18, 15, 19, 19, 7, 18, 19, '\r', 4, 21, 4, 65486, 65489};
                                    try {
                                        Object[] objArr18 = new Object[1];
                                        m((byte) (NetworkUserEntityData$$ExternalSyntheticLambda0 - 5), moveToNextValue[25], (byte) (-moveToNextValue[32]), objArr18);
                                        Class<?> cls7 = Class.forName((String) objArr18[0]);
                                        Object[] objArr19 = new Object[1];
                                        m(moveToNextValue[25], moveToNextValue[41], moveToNextValue[48], objArr19);
                                        Object[] objArr20 = new Object[1];
                                        l(true, cArr5, ((ApplicationInfo) cls7.getMethod((String) objArr19[0], null).invoke(this, null)).targetSdkVersion + 27, super.getResources().getString(R.string.warning_insufficient_paylater_limit).substring(48, 50).length() + 227, getPackageName().length() + 45, objArr20);
                                        String str4 = (String) objArr20[0];
                                        Object[] objArr21 = new Object[1];
                                        l(true, new char[]{0, 65532, 2, 65532, 7, 65535}, super.getResources().getString(R.string.twilio_ipg_success_title).substring(0, 1).length() + 5, super.getResources().getString(R.string.bottom_on_boarding_subtitle_my_bills_third).substring(6, 7).codePointAt(0) + 85, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 4, objArr21);
                                        try {
                                            Object[] objArr22 = {baseContext, str, str2, str3, str4, true, (String) objArr21[0], 995651014};
                                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                            if (obj2 == null) {
                                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 18 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                            }
                                            ((Method) obj2).invoke(invoke, objArr22);
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
                    } catch (Throwable th7) {
                        Throwable cause7 = th7.getCause();
                        if (cause7 == null) {
                            throw th7;
                        }
                        throw cause7;
                    }
                }
            }
            try {
                Object[] objArr23 = new Object[1];
                m((byte) (-moveToNextValue[31]), moveToNextValue[30], moveToNextValue[25], objArr23);
                Class<?> cls8 = Class.forName((String) objArr23[0]);
                Object[] objArr24 = new Object[1];
                m(30, moveToNextValue[30], moveToNextValue[9], objArr24);
                try {
                    Object[] objArr25 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr24[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + 494, 4 - TextUtils.indexOf("", "", 0, 0), (char) (ViewConfiguration.getPressedStateDuration() >> 16));
                        Object[] objArr26 = new Object[1];
                        n($$j[9], $$j[53], $$j[8], objArr26);
                        obj3 = cls9.getMethod((String) objArr26[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr27 = (Object[]) ((Method) obj3).invoke(null, objArr25);
                    int i4 = ((int[]) objArr27[1])[0];
                    if (((int[]) objArr27[0])[0] != i4) {
                        long j = ((r0 ^ i4) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(977 - AndroidCharacter.getMirror('0'), 35 - ((Process.getThreadPriority(0) + 20) >> 6), (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr28 = {-1169584656, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + 911, 18 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr28);
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
                    super.onCreate(bundle);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onPause() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr = new Object[1];
                l(true, new char[]{17, 6, 19, 6, 17, 0, 65502, 65483, '\r', '\r', 65534, 65483, 1, 6, '\f', 15, 1, 11, 65534, 1, 65534, 2, 15, 5, 65521, 22}, TextUtils.indexOf("", "") + 26, 231 - (ViewConfiguration.getEdgeSlop() >> 16), 19 - TextUtils.indexOf("", "", 0), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                l(true, new char[]{65529, 4, 5, 65535, '\n', 65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531, '\b', '\b', 11}, getPackageName().codePointAt(6) - 79, getPackageName().codePointAt(4) + 141, getPackageName().length() - 6, objArr2);
                baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - TextUtils.getOffsetBefore("", 0), (char) TextUtils.indexOf("", "", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr3 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), Color.green(0) + 18, (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Context.class);
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
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onResume() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr = new Object[1];
                l(true, new char[]{17, 6, 19, 6, 17, 0, 65502, 65483, '\r', '\r', 65534, 65483, 1, 6, '\f', 15, 1, 11, 65534, 1, 65534, 2, 15, 5, 65521, 22}, 26 - (ViewConfiguration.getScrollDefaultDelay() >> 16), super.getResources().getString(R.string.verify_limit_amount_daily_title1).substring(3, 4).length() + 230, ExpandableListView.getPackedPositionGroup(0L) + 19, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                char[] cArr = {65529, 4, 5, 65535, '\n', 65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531, '\b', '\b', 11};
                int i = (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 17;
                try {
                    Object[] objArr2 = new Object[1];
                    m((byte) (NetworkUserEntityData$$ExternalSyntheticLambda0 - 5), moveToNextValue[25], (byte) (-moveToNextValue[32]), objArr2);
                    Class<?> cls2 = Class.forName((String) objArr2[0]);
                    Object[] objArr3 = new Object[1];
                    m(moveToNextValue[25], moveToNextValue[41], moveToNextValue[48], objArr3);
                    int i2 = ((ApplicationInfo) cls2.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 205;
                    try {
                        Object[] objArr4 = new Object[1];
                        m((byte) (NetworkUserEntityData$$ExternalSyntheticLambda0 - 5), moveToNextValue[25], (byte) (-moveToNextValue[32]), objArr4);
                        Class<?> cls3 = Class.forName((String) objArr4[0]);
                        m(moveToNextValue[25], moveToNextValue[41], moveToNextValue[48], new Object[1]);
                        Object[] objArr5 = new Object[1];
                        l(true, cArr, i, i2, ((ApplicationInfo) cls3.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 32, objArr5);
                        baseContext = (Context) cls.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0', 0), 35 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr6 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 911, 17 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) KeyEvent.normalizeMetaState(0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr6);
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
            super.onResume();
        }

        private static void l(boolean z, char[] cArr, int i, int i2, int i3, Object[] objArr) {
            A a2 = new A();
            char[] cArr2 = new char[i];
            a2.MyBillsEntityDataFactory = 0;
            while (a2.MyBillsEntityDataFactory < i) {
                a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
                cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i2);
                int i4 = a2.MyBillsEntityDataFactory;
                cArr2[i4] = (char) (cArr2[i4] - ((int) (GetContactSyncConfig ^ (-5694784870793460699L))));
                a2.MyBillsEntityDataFactory++;
            }
            if (i3 > 0) {
                a2.BuiltInFictitiousFunctionClassFactory = i3;
                char[] cArr3 = new char[i];
                System.arraycopy(cArr2, 0, cArr3, 0, i);
                System.arraycopy(cArr3, 0, cArr2, i - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
                System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i - a2.BuiltInFictitiousFunctionClassFactory);
            }
            if (z) {
                char[] cArr4 = new char[i];
                a2.MyBillsEntityDataFactory = 0;
                while (a2.MyBillsEntityDataFactory < i) {
                    cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i - a2.MyBillsEntityDataFactory) - 1];
                    a2.MyBillsEntityDataFactory++;
                }
                cArr2 = cArr4;
            }
            objArr[0] = new String(cArr2);
        }
    }

    /* loaded from: classes3.dex */
    public static class Back2 extends Back {
        public static final byte[] $$j = {116, 44, -28, -115, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
        public static final int $$k = 49;
        public static final byte[] NetworkUserEntityData$$ExternalSyntheticLambda0 = {Ascii.ESC, -74, -29, -66, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
        public static final int moveToNextValue = 194;
        private static int[] NetworkUserEntityData$$ExternalSyntheticLambda1 = {-2041677820, 1767391492, 372804603, 1757864053, -99272889, 695652189, -1069535886, -636662042, 1270457927, 1127531369, -780743385, 98254428, 1255690756, -1404997878, 197020554, -1823004252, 1367331646, -1579874054};

        /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002f). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void l(byte r7, byte r8, short r9, java.lang.Object[] r10) {
            /*
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverTransActivity.Back2.NetworkUserEntityData$$ExternalSyntheticLambda0
                int r9 = 106 - r9
                int r7 = 23 - r7
                int r8 = r8 + 4
                byte[] r1 = new byte[r7]
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
                int r8 = r8 + 1
                byte r4 = (byte) r9
                int r5 = r3 + 1
                r1[r3] = r4
                if (r5 != r7) goto L26
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L26:
                r3 = r0[r8]
                r6 = r9
                r9 = r8
                r8 = r3
                r3 = r1
                r1 = r0
                r0 = r10
                r10 = r6
            L2f:
                int r10 = r10 + r8
                int r8 = r10 + (-4)
                r10 = r0
                r0 = r1
                r1 = r3
                r3 = r5
                r6 = r9
                r9 = r8
                r8 = r6
                goto L15
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverTransActivity.Back2.l(byte, byte, short, java.lang.Object[]):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x002d). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void n(int r6, int r7, short r8, java.lang.Object[] r9) {
            /*
                int r8 = r8 * 3
                int r8 = r8 + 21
                int r6 = 47 - r6
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverTransActivity.Back2.$$j
                int r7 = r7 * 2
                int r7 = r7 + 75
                byte[] r1 = new byte[r8]
                r2 = 0
                if (r0 != 0) goto L15
                r4 = r7
                r3 = 0
                r7 = r6
                goto L2d
            L15:
                r3 = 0
            L16:
                r5 = r7
                r7 = r6
                r6 = r5
                byte r4 = (byte) r6
                r1[r3] = r4
                int r3 = r3 + 1
                if (r3 != r8) goto L28
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L28:
                r4 = r0[r7]
                r5 = r7
                r7 = r6
                r6 = r5
            L2d:
                int r4 = -r4
                int r6 = r6 + 1
                int r7 = r7 + r4
                int r7 = r7 + (-7)
                goto L16
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverTransActivity.Back2.n(int, int, short, java.lang.Object[]):void");
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            Object[] objArr;
            Object[] objArr2;
            Object[] objArr3;
            Object[] objArr4;
            super.attachBaseContext(context);
            Object[] objArr5 = new Object[1];
            m((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 18, new int[]{-267457282, -1100651419, -1876447277, 771000981, 39029595, 2084772047, 1185972300, 1016685829, -1247889265, 868912520}, objArr5);
            Class<?> cls = Class.forName((String) objArr5[0]);
            Object[] objArr6 = new Object[1];
            m(Color.green(0) + 5, new int[]{-455931229, -1454414747, 872169769, 1667877976}, objArr6);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context applicationContext = context != null ? context.getApplicationContext() : context;
                if (applicationContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getTapTimeout() >> 16), 35 - (ViewConfiguration.getTapTimeout() >> 16), (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        m((KeyEvent.getMaxKeyCode() >> 16) + 48, new int[]{380884422, 1706853146, -1178834246, 2104709728, 1945029348, -1717760312, -1059144390, 583425110, 942565758, 2030039591, 1801562021, 1304003631, -1351524925, 2055076596, -1388343551, -892952902, -1921196757, -86516484, -1377241235, -209598258, 114228745, 1851345953, 926599875, 691327627}, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        m(64 - TextUtils.getOffsetBefore("", 0), new int[]{-1293896981, 2081790943, 2060001176, 452122584, 422439176, -2052504992, 1465451936, -1150841934, -162040998, -1913810461, -1449308768, 328642954, -172783275, -2088473052, -767335767, -1069012375, -784299343, 417493346, 1663655469, 1510303504, -1867303888, -125998205, -337704461, -1737008931, 1730670536, 1445649414, 965775417, 2139577532, -328082658, 215365423, -181614138, -1266010365}, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        m((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 63, new int[]{1279693236, -675421492, -449587564, 1906998119, -939615963, -2111964524, 1880318264, -513797652, -2085688720, 840896144, -596580114, -1758171656, -1151521925, -458006171, 1942113752, -345036431, -654397219, -1972379899, -1916449245, -1846095735, -2007239847, 90107677, -1611408478, -2018295242, -1320596345, 1043414603, 1955557209, 766776214, 2007357671, -1472131487, 1346893908, -840269373}, objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        m((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 59, new int[]{-264990632, 1173742920, -512697062, -473036969, 442382961, -940184896, -276642633, 201993803, -713912798, -1952073112, 1781832817, -1832563942, 1849785819, 553774837, 937626594, 1605234469, -167283767, 1066665657, -1772853238, -1207499018, -158105996, -1332626009, 1227785731, -268130175, 2100427729, 465131826, -343371846, -1288610334, -954393500, -1982586868}, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        m((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 6, new int[]{-1023114220, -379450580, -1207930031, -1761254871}, objArr11);
                        try {
                            Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0', 0), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 19, (char) View.MeasureSpec.getSize(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                    Object[] objArr13 = new Object[1];
                    l((byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), (byte) 36, NetworkUserEntityData$$ExternalSyntheticLambda0[25], objArr13);
                    Class<?> cls2 = Class.forName((String) objArr13[0]);
                    Object[] objArr14 = new Object[1];
                    l((byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[35] - 1), NetworkUserEntityData$$ExternalSyntheticLambda0[7], objArr14);
                    try {
                        Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                        if (obj3 == null) {
                            Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (Process.myTid() >> 22), (ViewConfiguration.getTouchSlop() >> 8) + 3, (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))));
                            byte b = (byte) (-$$j[53]);
                            byte b2 = $$j[47];
                            Object[] objArr16 = new Object[1];
                            n(b, b2, b2, objArr16);
                            obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                        }
                        Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - ImageFormat.getBitsPerPixel(0), 14 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) View.getDefaultSize(0, 0))).getMethod("getAuthRequestContext", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                            }
                            int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                            try {
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 16 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) KeyEvent.normalizeMetaState(0))).getMethod("PlaceComponentResult", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                                }
                                if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                    ArrayList arrayList = new ArrayList();
                                    try {
                                        Object[] objArr17 = {invoke2};
                                        Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                        if (obj6 == null) {
                                            obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollDefaultDelay() >> 16) + 815, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 28, (char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 15, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16)));
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
                                                obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0, 0) + 930, 35 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (MotionEvent.axisFromString("") + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                            }
                                            Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                            try {
                                                Object[] objArr18 = {-425548843, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                                Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                                if (obj8 == null) {
                                                    obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (KeyEvent.getMaxKeyCode() >> 16), View.combineMeasuredStates(0, 0) + 18, (char) TextUtils.getOffsetBefore("", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    Object[] objArr19 = new Object[1];
                    l((byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), (byte) 36, NetworkUserEntityData$$ExternalSyntheticLambda0[25], objArr19);
                    Class<?> cls4 = Class.forName((String) objArr19[0]);
                    Object[] objArr20 = new Object[1];
                    l((byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[35] - 1), NetworkUserEntityData$$ExternalSyntheticLambda0[7], objArr20);
                    try {
                        Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                        Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                        if (obj9 == null) {
                            Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + 61, 46 - TextUtils.indexOf("", "", 0, 0), (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1));
                            Object[] objArr22 = new Object[1];
                            n($$j[20], (byte) (-$$j[9]), (byte) ($$j[47] - 1), objArr22);
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
                                    obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + 930, 35 - (ViewConfiguration.getScrollBarSize() >> 8), (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                                }
                                Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                                try {
                                    Object[] objArr24 = {-425548843, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj11 == null) {
                                        obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0'), 18 - Color.argb(0, 0, 0, 0), (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    Object[] objArr25 = new Object[1];
                    l((byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), (byte) 36, NetworkUserEntityData$$ExternalSyntheticLambda0[25], objArr25);
                    Class<?> cls6 = Class.forName((String) objArr25[0]);
                    Object[] objArr26 = new Object[1];
                    l((byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[35] - 1), NetworkUserEntityData$$ExternalSyntheticLambda0[7], objArr26);
                    try {
                        Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                        Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                        if (obj12 == null) {
                            Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.makeMeasureSpec(0, 0) + 118, TextUtils.indexOf("", "", 0) + 3, (char) (Color.alpha(0) + 38968));
                            Object[] objArr28 = new Object[1];
                            n($$j[20], (byte) (-$$j[9]), (byte) ($$j[47] - 1), objArr28);
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
                                    obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - KeyEvent.normalizeMetaState(0), 36 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                                }
                                Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                                try {
                                    Object[] objArr30 = {-425548843, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj14 == null) {
                                        obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.argb(0, 0, 0, 0), TextUtils.indexOf((CharSequence) "", '0', 0) + 19, (char) Color.alpha(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    Object[] objArr31 = new Object[1];
                    l((byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), (byte) 36, NetworkUserEntityData$$ExternalSyntheticLambda0[25], objArr31);
                    Class<?> cls8 = Class.forName((String) objArr31[0]);
                    Object[] objArr32 = new Object[1];
                    l((byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[35] - 1), NetworkUserEntityData$$ExternalSyntheticLambda0[7], objArr32);
                    try {
                        Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                        Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                        if (obj15 == null) {
                            Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + 107, View.getDefaultSize(0, 0) + 3, (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1));
                            byte b3 = (byte) ($$j[47] - 1);
                            Object[] objArr34 = new Object[1];
                            n(b3, b3, (byte) (-$$j[8]), objArr34);
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
                                    obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 930, (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 35, (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                                }
                                Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                                try {
                                    Object[] objArr36 = {-425548843, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj17 == null) {
                                        obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.argb(0, 0, 0, 0) + 911, 18 - (ViewConfiguration.getEdgeSlop() >> 16), (char) ((-1) - Process.getGidForName("")))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return super.getApplicationContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
        public Context getBaseContext() {
            return super.getBaseContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
        public Resources getResources() {
            return super.getResources();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle bundle) {
            Object[] objArr;
            Object[] objArr2 = new Object[1];
            m(getPackageName().length() + 11, new int[]{-267457282, -1100651419, -1876447277, 771000981, 39029595, 2084772047, 1185972300, 1016685829, -1247889265, 868912520}, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            m(getPackageName().length() - 2, new int[]{-455931229, -1454414747, 872169769, 1667877976}, objArr3);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr4 = new Object[1];
                    m(TextUtils.getCapsMode("", 0, 0) + 26, new int[]{-267457282, -1100651419, -1876447277, 771000981, -790803384, 1816027064, 1211219237, -164742404, -324984616, -149284534, -823716726, 1081137303, -1769157630, -1560926853}, objArr4);
                    Class<?> cls2 = Class.forName((String) objArr4[0]);
                    try {
                        Object[] objArr5 = new Object[1];
                        l(NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[9], NetworkUserEntityData$$ExternalSyntheticLambda0[32], objArr5);
                        Class<?> cls3 = Class.forName((String) objArr5[0]);
                        l(NetworkUserEntityData$$ExternalSyntheticLambda0[27], NetworkUserEntityData$$ExternalSyntheticLambda0[59], NetworkUserEntityData$$ExternalSyntheticLambda0[13], new Object[1]);
                        Object[] objArr6 = new Object[1];
                        m(((ApplicationInfo) cls3.getMethod((String) r4[0], null).invoke(this, null)).targetSdkVersion - 15, new int[]{1591011380, -2027921134, 37159281, -1043342254, -1539756288, -584969030, -2145376040, 633816637, -1955950733, 1896962831}, objArr6);
                        baseContext = (Context) cls2.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 35, (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        try {
                            Object[] objArr7 = new Object[1];
                            l(NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[9], NetworkUserEntityData$$ExternalSyntheticLambda0[32], objArr7);
                            Class<?> cls4 = Class.forName((String) objArr7[0]);
                            Object[] objArr8 = new Object[1];
                            l(NetworkUserEntityData$$ExternalSyntheticLambda0[27], NetworkUserEntityData$$ExternalSyntheticLambda0[59], NetworkUserEntityData$$ExternalSyntheticLambda0[13], objArr8);
                            Object[] objArr9 = new Object[1];
                            m(((ApplicationInfo) cls4.getMethod((String) objArr8[0], null).invoke(this, null)).targetSdkVersion + 15, new int[]{380884422, 1706853146, -1178834246, 2104709728, 1945029348, -1717760312, -1059144390, 583425110, 942565758, 2030039591, 1801562021, 1304003631, -1351524925, 2055076596, -1388343551, -892952902, -1921196757, -86516484, -1377241235, -209598258, 114228745, 1851345953, 926599875, 691327627}, objArr9);
                            String str = (String) objArr9[0];
                            Object[] objArr10 = new Object[1];
                            m(super.getResources().getString(R.string.intro_tnc).substring(5, 6).length() + 63, new int[]{-1293896981, 2081790943, 2060001176, 452122584, 422439176, -2052504992, 1465451936, -1150841934, -162040998, -1913810461, -1449308768, 328642954, -172783275, -2088473052, -767335767, -1069012375, -784299343, 417493346, 1663655469, 1510303504, -1867303888, -125998205, -337704461, -1737008931, 1730670536, 1445649414, 965775417, 2139577532, -328082658, 215365423, -181614138, -1266010365}, objArr10);
                            String str2 = (String) objArr10[0];
                            Object[] objArr11 = new Object[1];
                            m((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 64, new int[]{1279693236, -675421492, -449587564, 1906998119, -939615963, -2111964524, 1880318264, -513797652, -2085688720, 840896144, -596580114, -1758171656, -1151521925, -458006171, 1942113752, -345036431, -654397219, -1972379899, -1916449245, -1846095735, -2007239847, 90107677, -1611408478, -2018295242, -1320596345, 1043414603, 1955557209, 766776214, 2007357671, -1472131487, 1346893908, -840269373}, objArr11);
                            String str3 = (String) objArr11[0];
                            Object[] objArr12 = new Object[1];
                            m((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 60, new int[]{-264990632, 1173742920, -512697062, -473036969, 442382961, -940184896, -276642633, 201993803, -713912798, -1952073112, 1781832817, -1832563942, 1849785819, 553774837, 937626594, 1605234469, -167283767, 1066665657, -1772853238, -1207499018, -158105996, -1332626009, 1227785731, -268130175, 2100427729, 465131826, -343371846, -1288610334, -954393500, -1982586868}, objArr12);
                            String str4 = (String) objArr12[0];
                            try {
                                Object[] objArr13 = new Object[1];
                                l(NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[9], NetworkUserEntityData$$ExternalSyntheticLambda0[32], objArr13);
                                Class<?> cls5 = Class.forName((String) objArr13[0]);
                                l(NetworkUserEntityData$$ExternalSyntheticLambda0[27], NetworkUserEntityData$$ExternalSyntheticLambda0[59], NetworkUserEntityData$$ExternalSyntheticLambda0[13], new Object[1]);
                                Object[] objArr14 = new Object[1];
                                m(((ApplicationInfo) cls5.getMethod((String) r6[0], null).invoke(this, null)).targetSdkVersion - 27, new int[]{-1023114220, -379450580, -1207930031, -1761254871}, objArr14);
                                try {
                                    Object[] objArr15 = {baseContext, str, str2, str3, str4, true, (String) objArr14[0], 995651014};
                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                    if (obj2 == null) {
                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getTouchSlop() >> 8), 18 - KeyEvent.keyCodeFromString(""), (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                    }
                                    ((Method) obj2).invoke(invoke, objArr15);
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
                    } catch (Throwable th5) {
                        Throwable cause5 = th5.getCause();
                        if (cause5 == null) {
                            throw th5;
                        }
                        throw cause5;
                    }
                }
            }
            try {
                Object[] objArr16 = new Object[1];
                l((byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), (byte) 36, NetworkUserEntityData$$ExternalSyntheticLambda0[25], objArr16);
                Class<?> cls6 = Class.forName((String) objArr16[0]);
                Object[] objArr17 = new Object[1];
                l((byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[35] - 1), NetworkUserEntityData$$ExternalSyntheticLambda0[7], objArr17);
                try {
                    Object[] objArr18 = {Integer.valueOf(((Integer) cls6.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - Color.blue(0), 5 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) ExpandableListView.getPackedPositionType(0L));
                        byte b = (byte) ($$j[47] - 1);
                        Object[] objArr19 = new Object[1];
                        n(b, b, (byte) (-$$j[8]), objArr19);
                        obj3 = cls7.getMethod((String) objArr19[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr20 = (Object[]) ((Method) obj3).invoke(null, objArr18);
                    int i = ((int[]) objArr20[1])[0];
                    if (((int[]) objArr20[0])[0] != i) {
                        long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getTapTimeout() >> 16), 35 - TextUtils.indexOf("", ""), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr21 = {-746560318, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + 911, (ViewConfiguration.getJumpTapTimeout() >> 16) + 18, (char) (MotionEvent.axisFromString("") + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr21);
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
                    super.onCreate(bundle);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onPause() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                try {
                    Object[] objArr = new Object[1];
                    l(NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[9], NetworkUserEntityData$$ExternalSyntheticLambda0[32], objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    l(NetworkUserEntityData$$ExternalSyntheticLambda0[27], NetworkUserEntityData$$ExternalSyntheticLambda0[59], NetworkUserEntityData$$ExternalSyntheticLambda0[13], new Object[1]);
                    Object[] objArr2 = new Object[1];
                    m(((ApplicationInfo) cls.getMethod((String) r7[0], null).invoke(this, null)).targetSdkVersion - 7, new int[]{-267457282, -1100651419, -1876447277, 771000981, -790803384, 1816027064, 1211219237, -164742404, -324984616, -149284534, -823716726, 1081137303, -1769157630, -1560926853}, objArr2);
                    Class<?> cls2 = Class.forName((String) objArr2[0]);
                    Object[] objArr3 = new Object[1];
                    m(super.getResources().getString(R.string.cancel_item_manage_bills).substring(1, 2).codePointAt(0) - 79, new int[]{1591011380, -2027921134, 37159281, -1043342254, -1539756288, -584969030, -2145376040, 633816637, -1955950733, 1896962831}, objArr3);
                    baseContext = (Context) cls2.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), Color.blue(0) + 35, (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr4 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + 911, Color.argb(0, 0, 0, 0) + 18, (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Context.class);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr4);
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
            super.onPause();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onResume() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr = new Object[1];
                m(getPackageName().length() + 19, new int[]{-267457282, -1100651419, -1876447277, 771000981, -790803384, 1816027064, 1211219237, -164742404, -324984616, -149284534, -823716726, 1081137303, -1769157630, -1560926853}, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                m(getPackageName().length() + 11, new int[]{1591011380, -2027921134, 37159281, -1043342254, -1539756288, -584969030, -2145376040, 633816637, -1955950733, 1896962831}, objArr2);
                baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.makeMeasureSpec(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - Color.green(0), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr3 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (Process.myPid() >> 22), (Process.myTid() >> 22) + 18, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        }

        private static void m(int i, int[] iArr, Object[] objArr) {
            VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
            char[] cArr = new char[4];
            char[] cArr2 = new char[iArr.length * 2];
            int[] iArr2 = NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (iArr2 != null) {
                int length = iArr2.length;
                int[] iArr3 = new int[length];
                for (int i2 = 0; i2 < length; i2++) {
                    iArr3[i2] = (int) (iArr2[i2] ^ (-3152031022165484798L));
                }
                iArr2 = iArr3;
            }
            int length2 = iArr2.length;
            int[] iArr4 = new int[length2];
            int[] iArr5 = NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (iArr5 != null) {
                int length3 = iArr5.length;
                int[] iArr6 = new int[length3];
                for (int i3 = 0; i3 < length3; i3++) {
                    iArr6[i3] = (int) (iArr5[i3] ^ (-3152031022165484798L));
                }
                iArr5 = iArr6;
            }
            System.arraycopy(iArr5, 0, iArr4, 0, length2);
            verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
                cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
                cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
                cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
                cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
                VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
                for (int i4 = 0; i4 < 16; i4++) {
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i4];
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    int i5 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i5;
                }
                int i6 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i6;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
                int i7 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                int i8 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
                cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
                cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
                cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
                verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
            }
            objArr[0] = new String(cArr2, 0, i);
        }
    }

    /* loaded from: classes3.dex */
    public static class Back6 extends Back {
        public static final byte[] $$j = {16, -72, -107, 15, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
        public static final int $$k = 176;
        public static final byte[] moveToNextValue = {TarHeader.LF_CHR, 112, -114, 9, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
        public static final int NetworkUserEntityData$$ExternalSyntheticLambda0 = 116;
        private static int[] NetworkUserEntityData$$ExternalSyntheticLambda1 = {-2038273886, 885523832, 1152191687, 1688460216, -245317056, 1296738656, -1534208374, -1467353567, -937177904, -2054459707, 758538406, 1467035102, -1194693542, 2004312657, 1018640941, 523032301, -1084524844, 1506345166};

        /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0019  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0028). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void l(int r6, byte r7, short r8, java.lang.Object[] r9) {
            /*
                int r6 = r6 + 97
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverTransActivity.Back6.moveToNextValue
                int r7 = 56 - r7
                int r8 = 23 - r8
                byte[] r1 = new byte[r8]
                int r8 = r8 + (-1)
                r2 = 0
                if (r0 != 0) goto L13
                r4 = r7
                r6 = r8
                r3 = 0
                goto L28
            L13:
                r3 = 0
            L14:
                byte r4 = (byte) r6
                r1[r3] = r4
                if (r3 != r8) goto L21
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L21:
                int r3 = r3 + 1
                r4 = r0[r7]
                r5 = r8
                r8 = r6
                r6 = r5
            L28:
                int r7 = r7 + 1
                int r8 = r8 + r4
                int r8 = r8 + (-4)
                r5 = r8
                r8 = r6
                r6 = r5
                goto L14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverTransActivity.Back6.l(int, byte, short, java.lang.Object[]):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0036). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void n(short r6, int r7, byte r8, java.lang.Object[] r9) {
            /*
                int r6 = 46 - r6
                int r7 = r7 * 3
                int r7 = r7 + 21
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverTransActivity.Back6.$$j
                int r8 = r8 * 2
                int r8 = 103 - r8
                byte[] r1 = new byte[r7]
                r2 = 0
                if (r0 != 0) goto L19
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r9
                r9 = r8
                r8 = r7
                r7 = r6
                goto L36
            L19:
                r3 = 0
            L1a:
                byte r4 = (byte) r8
                r1[r3] = r4
                int r3 = r3 + 1
                if (r3 != r7) goto L29
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L29:
                int r6 = r6 + 1
                r4 = r0[r6]
                r5 = r7
                r7 = r6
                r6 = r4
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r9
                r9 = r8
                r8 = r5
            L36:
                int r6 = -r6
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
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverTransActivity.Back6.n(short, int, byte, java.lang.Object[]):void");
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            Object[] objArr;
            Object[] objArr2;
            Object[] objArr3;
            Object[] objArr4;
            super.attachBaseContext(context);
            Object[] objArr5 = new Object[1];
            m(18 - (ViewConfiguration.getFadingEdgeLength() >> 16), new int[]{-268355348, -332848395, 877891490, 231159773, 1484005646, -2125342507, -1299629593, -541856273, -627521818, 2111397280}, objArr5);
            Class<?> cls = Class.forName((String) objArr5[0]);
            Object[] objArr6 = new Object[1];
            m(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 6, new int[]{-32370695, 453580688, -2052373080, 60386463}, objArr6);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context applicationContext = context != null ? context.getApplicationContext() : context;
                if (applicationContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 34, (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        m(48 - View.resolveSize(0, 0), new int[]{-547601669, -1218845576, 879932824, -418958458, -475606308, 1109645314, -309843052, 888298136, -423697435, -98088513, 660121768, 433493030, 818627270, -1445981232, -653417165, 525900707, 1595727312, 2142367716, -1500235989, 1165126528, 357456713, 352846981, -610597545, -1680707006}, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        m(64 - (ViewConfiguration.getFadingEdgeLength() >> 16), new int[]{1706027224, -689896148, 2141528056, -2134424416, -349781659, -804910009, -1189661535, 734356465, 45332708, 1712240594, 80183975, -1218636462, 421286, -2016589002, 663091129, 1737288801, 1702258823, -140134409, -1092191305, -734054004, -2103381482, -1564112017, -248880608, -785922206, -1275465834, -1511810094, 295962334, 1467911460, -558169328, -984033486, 1816689503, 1643738104}, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        m(ExpandableListView.getPackedPositionChild(0L) + 65, new int[]{-2039823974, -1949952798, 1049032041, -1332445725, -565570789, 1077544872, -2017561027, -676424696, 832260865, -2095760281, 564065319, 401700294, 193825040, -1758399174, 178532978, 741738967, -1662349072, 291777321, 1604194756, 2121638305, -166846198, -2031448018, -1667557551, -1987309695, 634165255, 1759357086, -1075902955, -1104386563, 1626369788, 79610739, 2100944266, 202999160}, objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        m((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 61, new int[]{1325962362, 1726251292, 1430077973, 949416254, -70873461, -2144815909, -233465219, -335351176, -1890407381, 1355689861, -830178516, 1029069456, 67840988, -124982825, -1096281793, -1199352135, 1224678105, -2106470730, -898534734, 1930316140, -1881880886, -1310474671, 170945423, 994158742, -1679949037, 901461027, -474671069, 267390457, -1637869956, -253305425}, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        m((ViewConfiguration.getLongPressTimeout() >> 16) + 6, new int[]{1930569345, -186775395, -1342958689, -1281948946}, objArr11);
                        try {
                            Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", "", 0, 0), (ViewConfiguration.getLongPressTimeout() >> 16) + 18, (char) Color.red(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                    Object[] objArr13 = new Object[1];
                    l(moveToNextValue[3], moveToNextValue[31], (byte) (-moveToNextValue[30]), objArr13);
                    Class<?> cls2 = Class.forName((String) objArr13[0]);
                    byte b = (byte) (moveToNextValue[3] - 1);
                    Object[] objArr14 = new Object[1];
                    l(b, (byte) (b | 22), (byte) (-moveToNextValue[30]), objArr14);
                    try {
                        Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                        if (obj3 == null) {
                            Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 54, 3 - KeyEvent.keyCodeFromString(""), (char) (ViewConfiguration.getScrollBarSize() >> 8));
                            Object[] objArr16 = new Object[1];
                            n((byte) (-$$j[53]), $$j[47], (byte) (-$$j[12]), objArr16);
                            obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                        }
                        Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (ViewConfiguration.getFadingEdgeLength() >> 16) + 15, (char) View.resolveSize(0, 0))).getMethod("getAuthRequestContext", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                            }
                            int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                            try {
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - ((Process.getThreadPriority(0) + 20) >> 6), 14 - ImageFormat.getBitsPerPixel(0), (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))))).getMethod("PlaceComponentResult", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                                }
                                if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                    ArrayList arrayList = new ArrayList();
                                    try {
                                        Object[] objArr17 = {invoke2};
                                        Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                        if (obj6 == null) {
                                            obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 815, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 28, (char) (57994 - (ViewConfiguration.getScrollBarSize() >> 8)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - View.MeasureSpec.getSize(0), 15 - (ViewConfiguration.getTouchSlop() >> 8), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0'))));
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                        }
                                        arrayList.add(((Method) obj6).invoke(null, objArr17));
                                        long j = ((r10 ^ intValue2) & 4294967295L) | 60129542144L;
                                        try {
                                            Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                            if (obj7 != null) {
                                                objArr = null;
                                            } else {
                                                objArr = null;
                                                obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 35 - (Process.myPid() >> 22), (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                            }
                                            Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                            try {
                                                Object[] objArr18 = {-540957255, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                                Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                                if (obj8 == null) {
                                                    obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - MotionEvent.axisFromString(""), 18 - ((Process.getThreadPriority(0) + 20) >> 6), (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    Object[] objArr19 = new Object[1];
                    l(moveToNextValue[3], moveToNextValue[31], (byte) (-moveToNextValue[30]), objArr19);
                    Class<?> cls4 = Class.forName((String) objArr19[0]);
                    byte b2 = (byte) (moveToNextValue[3] - 1);
                    Object[] objArr20 = new Object[1];
                    l(b2, (byte) (b2 | 22), (byte) (-moveToNextValue[30]), objArr20);
                    try {
                        Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                        Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                        if (obj9 == null) {
                            Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + 61, (ViewConfiguration.getTapTimeout() >> 16) + 46, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)));
                            byte b3 = $$j[20];
                            byte b4 = (byte) ($$j[47] - 1);
                            Object[] objArr22 = new Object[1];
                            n(b3, b4, b4, objArr22);
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
                                    obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + 930, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 34, (char) Color.blue(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                                }
                                Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                                try {
                                    Object[] objArr24 = {-540957255, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj11 == null) {
                                        obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarSize() >> 8), 18 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    Object[] objArr25 = new Object[1];
                    l(moveToNextValue[3], moveToNextValue[31], (byte) (-moveToNextValue[30]), objArr25);
                    Class<?> cls6 = Class.forName((String) objArr25[0]);
                    byte b5 = (byte) (moveToNextValue[3] - 1);
                    Object[] objArr26 = new Object[1];
                    l(b5, (byte) (b5 | 22), (byte) (-moveToNextValue[30]), objArr26);
                    try {
                        Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                        Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                        if (obj12 == null) {
                            Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - ExpandableListView.getPackedPositionType(0L), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 2, (char) (38969 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))));
                            byte b6 = $$j[20];
                            byte b7 = (byte) ($$j[47] - 1);
                            Object[] objArr28 = new Object[1];
                            n(b6, b7, b7, objArr28);
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
                                    obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getTapTimeout() >> 16), TextUtils.indexOf((CharSequence) "", '0', 0) + 36, (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                                }
                                Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                                try {
                                    Object[] objArr30 = {-540957255, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj14 == null) {
                                        obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ExpandableListView.getPackedPositionChild(0L), View.resolveSize(0, 0) + 18, (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    Object[] objArr31 = new Object[1];
                    l(moveToNextValue[3], moveToNextValue[31], (byte) (-moveToNextValue[30]), objArr31);
                    Class<?> cls8 = Class.forName((String) objArr31[0]);
                    byte b8 = (byte) (moveToNextValue[3] - 1);
                    Object[] objArr32 = new Object[1];
                    l(b8, (byte) (b8 | 22), (byte) (-moveToNextValue[30]), objArr32);
                    try {
                        Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                        Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                        if (obj15 == null) {
                            Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + 108, (ViewConfiguration.getEdgeSlop() >> 16) + 3, (char) View.resolveSizeAndState(0, 0, 0));
                            Object[] objArr34 = new Object[1];
                            n((byte) ($$j[47] - 1), (byte) (-$$j[8]), (byte) (-$$j[9]), objArr34);
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
                                    obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getFadingEdgeLength() >> 16), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 34, (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                                }
                                Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                                try {
                                    Object[] objArr36 = {-540957255, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj17 == null) {
                                        obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 17 - TextUtils.lastIndexOf("", '0', 0), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return super.getApplicationContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
        public Context getBaseContext() {
            return super.getBaseContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
        public Resources getResources() {
            return super.getResources();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle bundle) {
            Object[] objArr;
            Object[] objArr2 = new Object[1];
            m((Process.myTid() >> 22) + 18, new int[]{-268355348, -332848395, 877891490, 231159773, 1484005646, -2125342507, -1299629593, -541856273, -627521818, 2111397280}, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            m((ViewConfiguration.getScrollBarSize() >> 8) + 5, new int[]{-32370695, 453580688, -2052373080, 60386463}, objArr3);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr4 = new Object[1];
                    m(getPackageName().length() + 19, new int[]{-268355348, -332848395, 877891490, 231159773, 159811275, -1947895250, -2059868132, 625278406, -2123562705, 1402162761, -1103578074, 1777655696, 1692360660, 1338695668}, objArr4);
                    Class<?> cls2 = Class.forName((String) objArr4[0]);
                    Object[] objArr5 = new Object[1];
                    m((ViewConfiguration.getFadingEdgeLength() >> 16) + 18, new int[]{492521392, 149220074, -70400872, 407795021, -1675915984, 508653492, 1544946220, 1171985173, -312734825, 290206051}, objArr5);
                    baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.getDefaultSize(0, 0), 34 - MotionEvent.axisFromString(""), (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr6 = new Object[1];
                        m(getPackageName().length() + 41, new int[]{-547601669, -1218845576, 879932824, -418958458, -475606308, 1109645314, -309843052, 888298136, -423697435, -98088513, 660121768, 433493030, 818627270, -1445981232, -653417165, 525900707, 1595727312, 2142367716, -1500235989, 1165126528, 357456713, 352846981, -610597545, -1680707006}, objArr6);
                        String str = (String) objArr6[0];
                        Object[] objArr7 = new Object[1];
                        m(getPackageName().codePointAt(5) - 46, new int[]{1706027224, -689896148, 2141528056, -2134424416, -349781659, -804910009, -1189661535, 734356465, 45332708, 1712240594, 80183975, -1218636462, 421286, -2016589002, 663091129, 1737288801, 1702258823, -140134409, -1092191305, -734054004, -2103381482, -1564112017, -248880608, -785922206, -1275465834, -1511810094, 295962334, 1467911460, -558169328, -984033486, 1816689503, 1643738104}, objArr7);
                        String str2 = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        m(super.getResources().getString(R.string.res_0x7f130f43_verifypinstatemanager_executeriskchallenge_2_1).substring(27, 37).codePointAt(4) - 2, new int[]{-2039823974, -1949952798, 1049032041, -1332445725, -565570789, 1077544872, -2017561027, -676424696, 832260865, -2095760281, 564065319, 401700294, 193825040, -1758399174, 178532978, 741738967, -1662349072, 291777321, 1604194756, 2121638305, -166846198, -2031448018, -1667557551, -1987309695, 634165255, 1759357086, -1075902955, -1104386563, 1626369788, 79610739, 2100944266, 202999160}, objArr8);
                        String str3 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        m(super.getResources().getString(R.string.bottom_sheet_description_remove_savings).substring(15, 17).codePointAt(1) - 48, new int[]{1325962362, 1726251292, 1430077973, 949416254, -70873461, -2144815909, -233465219, -335351176, -1890407381, 1355689861, -830178516, 1029069456, 67840988, -124982825, -1096281793, -1199352135, 1224678105, -2106470730, -898534734, 1930316140, -1881880886, -1310474671, 170945423, 994158742, -1679949037, 901461027, -474671069, 267390457, -1637869956, -253305425}, objArr9);
                        String str4 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        m(Color.green(0) + 6, new int[]{1930569345, -186775395, -1342958689, -1281948946}, objArr10);
                        try {
                            Object[] objArr11 = {baseContext, str, str2, str3, str4, true, (String) objArr10[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getOffsetAfter("", 0), 18 - TextUtils.indexOf("", "", 0), (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                Object[] objArr12 = new Object[1];
                l(moveToNextValue[3], moveToNextValue[31], (byte) (-moveToNextValue[30]), objArr12);
                Class<?> cls3 = Class.forName((String) objArr12[0]);
                byte b = (byte) (moveToNextValue[3] - 1);
                Object[] objArr13 = new Object[1];
                l(b, (byte) (b | 22), (byte) (-moveToNextValue[30]), objArr13);
                try {
                    Object[] objArr14 = {Integer.valueOf(((Integer) cls3.getMethod((String) objArr13[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls4 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + 494, 4 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)));
                        Object[] objArr15 = new Object[1];
                        n((byte) ($$j[47] - 1), (byte) (-$$j[8]), (byte) (-$$j[9]), objArr15);
                        obj3 = cls4.getMethod((String) objArr15[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr16 = (Object[]) ((Method) obj3).invoke(null, objArr14);
                    int i = ((int[]) objArr16[1])[0];
                    if (((int[]) objArr16[0])[0] != i) {
                        long j = ((r1 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + 930, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 34, (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr17 = {-1076070650, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0'), 18 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr17);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onPause() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                try {
                    byte b = moveToNextValue[25];
                    Object[] objArr = new Object[1];
                    l(b, (byte) (b | TarHeader.LF_BLK), moveToNextValue[25], objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    l((byte) (-moveToNextValue[5]), moveToNextValue[25], moveToNextValue[27], new Object[1]);
                    Object[] objArr2 = new Object[1];
                    m(((ApplicationInfo) cls.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 7, new int[]{-268355348, -332848395, 877891490, 231159773, 159811275, -1947895250, -2059868132, 625278406, -2123562705, 1402162761, -1103578074, 1777655696, 1692360660, 1338695668}, objArr2);
                    Class<?> cls2 = Class.forName((String) objArr2[0]);
                    Object[] objArr3 = new Object[1];
                    m(18 - TextUtils.indexOf("", ""), new int[]{492521392, 149220074, -70400872, 407795021, -1675915984, 508653492, 1544946220, 1171985173, -312734825, 290206051}, objArr3);
                    baseContext = (Context) cls2.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 34, (char) KeyEvent.keyCodeFromString(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr4 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 911, View.MeasureSpec.getMode(0) + 18, (char) Drawable.resolveOpacity(0, 0))).getMethod("MyBillsEntityDataFactory", Context.class);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr4);
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
            super.onPause();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverTransActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onResume() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr = new Object[1];
                m(super.getResources().getString(R.string.image_capture_upload_photo_btn_label).substring(0, 6).length() + 20, new int[]{-268355348, -332848395, 877891490, 231159773, 159811275, -1947895250, -2059868132, 625278406, -2123562705, 1402162761, -1103578074, 1777655696, 1692360660, 1338695668}, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                m(getPackageName().length() + 11, new int[]{492521392, 149220074, -70400872, 407795021, -1675915984, 508653492, 1544946220, 1171985173, -312734825, 290206051}, objArr2);
                baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - TextUtils.getTrimmedLength(""), (char) View.resolveSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr3 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), View.resolveSize(0, 0) + 18, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        }

        private static void m(int i, int[] iArr, Object[] objArr) {
            VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
            char[] cArr = new char[4];
            char[] cArr2 = new char[iArr.length * 2];
            int[] iArr2 = NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (iArr2 != null) {
                int length = iArr2.length;
                int[] iArr3 = new int[length];
                for (int i2 = 0; i2 < length; i2++) {
                    iArr3[i2] = (int) (iArr2[i2] ^ (-3152031022165484798L));
                }
                iArr2 = iArr3;
            }
            int length2 = iArr2.length;
            int[] iArr4 = new int[length2];
            int[] iArr5 = NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (iArr5 != null) {
                int length3 = iArr5.length;
                int[] iArr6 = new int[length3];
                for (int i3 = 0; i3 < length3; i3++) {
                    iArr6[i3] = (int) (iArr5[i3] ^ (-3152031022165484798L));
                }
                iArr5 = iArr6;
            }
            System.arraycopy(iArr5, 0, iArr4, 0, length2);
            verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
                cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
                cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
                cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
                cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
                VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
                for (int i4 = 0; i4 < 16; i4++) {
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i4];
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    int i5 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i5;
                }
                int i6 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i6;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
                int i7 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                int i8 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
                cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
                cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
                cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
                verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
            }
            objArr[0] = new String(cArr2, 0, i);
        }
    }
}
