package com.alipay.mobile.verifyidentity.business.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.StatusBarUtil;
import com.alipay.mobile.verifyidentity.uitools.CustomUi;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getOnBoardingScenario;

/* loaded from: classes7.dex */
public abstract class BaseActivity extends Activity {
    protected static final int MSG_SHOW_SUBMITTING = 1000;
    protected static final long SHOW_SUBMITTING_DELAY = 50;
    protected HandlerCallback handlerCallback;
    private long initSubmittingTime;
    protected Dialog submittingDialog;
    protected WeakHandler weakHandler;
    public static final byte[] $$a = {42, -75, 2, Ascii.US, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 37;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {112, 117, 112, -122, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int MyBillsEntityDataFactory = 96;
    private static long BuiltInFictitiousFunctionClassFactory = 5441171547416982900L;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 + 4
            int r8 = r8 + 16
            byte[] r0 = com.alipay.mobile.verifyidentity.business.activity.BaseActivity.KClassImpl$Data$declaredNonStaticMembers$2
            int r6 = 106 - r6
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L13
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L2e
        L13:
            r3 = 0
        L14:
            byte r4 = (byte) r6
            int r7 = r7 + 1
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r8) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            r4 = r0[r7]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L2e:
            int r6 = r6 + r8
            int r6 = r6 + (-4)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.verifyidentity.business.activity.BaseActivity.b(int, byte, short, java.lang.Object[]):void");
    }

    private static void c(short s, short s2, int i, Object[] objArr) {
        int i2 = (s2 * 2) + 75;
        byte[] bArr = $$a;
        int i3 = s + 4;
        int i4 = (i * 3) + 21;
        byte[] bArr2 = new byte[i4];
        int i5 = 0;
        if (bArr == null) {
            i3++;
            i2 = (i2 + i3) - 7;
        }
        while (true) {
            bArr2[i5] = (byte) i2;
            i5++;
            if (i5 == i4) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b = bArr[i3];
            i3++;
            i2 = (i2 + b) - 7;
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a(25391 - KeyEvent.normalizeMetaState(0), new char[]{42070, 51062, 25101, 36296, 10468, 19381, 63305, 4688, 48416, 55523, 31695, 59234, 625, 44347, 51398, 27539, 38580, 12891}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(29983 - Color.argb(0, 0, 0, 0), new char[]{42074, 53585, 20060, 64259, 28719}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), 35 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) View.MeasureSpec.getSize(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(21576 - TextUtils.indexOf((CharSequence) "", '0'), new char[]{41984, 61469, 3219, 22740, 62755, 318, 23992, 59888, 1608, 21187, 61070, 15218, 22334, 58288, 16376, 21574, 57494, 15583, 18723, 58685, 12775, 19881, 39442, 13966, 17035, 40741, 11109, 18400, 37881, 10262, 17624, 36997, 11566, 31080, 38327, 8693, 32277, 35459, 9945, 29464, 36712, 56288, 30713, 35906, 55513, 29905, 33055, 56629}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(TextUtils.getOffsetBefore("", 0) + 20051, new char[]{42070, 59985, 14503, 20138, 40221, 9105, 29173, 32842, 54987, 25791, 43824, 63891, 4023, 24113, 60556, 13022, 16693, 38790, 9607, 29743, 47663, 51401, 7971, 44401, 62409, 590, 20576, 59027, 13595, 31540, 35263, 55304, 28212, 48352, 49925, 4438, 43000, 62891, 1109, 19105, 39162, 12108, 32204, 33783, 53776, 24727, 46828, 50493, 2964, 23015, 59446, 16007, 19666, 37679, 8581, 30675, 34351, 54397, 6810, 43380, 65394, 3528, 23625, 57961}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 6689, new char[]{41989, 48679, 36880, 59958, 52362, 9893, 14531, 4836, 29959, 20262, 41285, 47981, 40330, 63401, 51657, 9199, 1606, 6243, 29265, 21536, 44689, 32992, 39552, 64755, 55064, 10600, 852, 25972, 32717, 20972, 43998, 36267, 57376, 64018, 56423, 13964, 2289, 25285, 17639, 24328, 45351, 35608, 60780, 51080, 55715, 13258, 5560, 26714, 16993, 42079, 48678, 37057, 60081, 52435, 9895, 14613, 4920, 30043, 20340, 41370, 48109, 40415, 63484, 51729}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a((ViewConfiguration.getKeyRepeatDelay() >> 16) + 51817, new char[]{42079, 28202, 12433, 64380, 36320, 20480, 6766, 11463, 63259, 47591, 19523, 5845, 55541, 58134, 46561, 30818, 706, 54447, 40737, 41375, 29794, 16089, 49477, 35702, 23944, 24579, 11004, 64854, 34607, 18849, 7176, 9973, 59766, 46028, 17824, 2114, 53904, 58741, 45004, 29159, 1086, 52886, 37220, 23483, 28242, 12332, 64142, 36117, 22516, 6746, 11418, 63146, 47441, 17317, 5748, 55502, 58026, 46392, 32649, 631}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(KeyEvent.getDeadChar(0, 0) + 6491, new char[]{41998, 48450, 38581, 59400, 49513, 56001}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getWindowTouchSlop() >> 8) + 911, 18 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) Color.argb(0, 0, 0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = KClassImpl$Data$declaredNonStaticMembers$2[25];
                Object[] objArr13 = new Object[1];
                b(b, (byte) (b | 36), KClassImpl$Data$declaredNonStaticMembers$2[25], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b2 = KClassImpl$Data$declaredNonStaticMembers$2[7];
                Object[] objArr14 = new Object[1];
                b(b2, (byte) (b2 | Ascii.DC4), KClassImpl$Data$declaredNonStaticMembers$2[25], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (Process.myPid() >> 22), 2 - Process.getGidForName(""), (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1));
                        byte b3 = (byte) ($$a[78] - 1);
                        byte b4 = $$a[78];
                        Object[] objArr16 = new Object[1];
                        c(b3, b4, b4, objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 15 - ((Process.getThreadPriority(0) + 20) >> 6), (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, KeyEvent.getDeadChar(0, 0) + 15, (char) KeyEvent.keyCodeFromString(""))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - (KeyEvent.getMaxKeyCode() >> 16), ImageFormat.getBitsPerPixel(0) + 30, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 57995))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - Color.green(0), 15 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1))));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - KeyEvent.keyCodeFromString(""), 34 - TextUtils.lastIndexOf("", '0'), (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-629263445, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 912, 18 - KeyEvent.getDeadChar(0, 0), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b5 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                Object[] objArr19 = new Object[1];
                b(b5, (byte) (b5 | 36), KClassImpl$Data$declaredNonStaticMembers$2[25], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b6 = KClassImpl$Data$declaredNonStaticMembers$2[7];
                Object[] objArr20 = new Object[1];
                b(b6, (byte) (b6 | Ascii.DC4), KClassImpl$Data$declaredNonStaticMembers$2[25], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - ExpandableListView.getPackedPositionType(0L), 46 - KeyEvent.normalizeMetaState(0), (char) (ViewConfiguration.getJumpTapTimeout() >> 16));
                        Object[] objArr22 = new Object[1];
                        c((byte) ($$a[23] - 1), $$a[9], (byte) ($$a[78] - 1), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 35 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-629263445, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getJumpTapTimeout() >> 16), Color.argb(0, 0, 0, 0) + 18, (char) View.MeasureSpec.getSize(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b7 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                Object[] objArr25 = new Object[1];
                b(b7, (byte) (b7 | 36), KClassImpl$Data$declaredNonStaticMembers$2[25], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b8 = KClassImpl$Data$declaredNonStaticMembers$2[7];
                Object[] objArr26 = new Object[1];
                b(b8, (byte) (b8 | Ascii.DC4), KClassImpl$Data$declaredNonStaticMembers$2[25], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.combineMeasuredStates(0, 0) + 118, TextUtils.indexOf("", "", 0, 0) + 3, (char) ((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 38968));
                        Object[] objArr28 = new Object[1];
                        c((byte) ($$a[23] - 1), $$a[9], (byte) ($$a[78] - 1), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0', 0), 35 - (ViewConfiguration.getEdgeSlop() >> 16), (char) TextUtils.getOffsetBefore("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-629263445, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.getMode(0), 18 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) ((-1) - Process.getGidForName("")))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b9 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                Object[] objArr31 = new Object[1];
                b(b9, (byte) (b9 | 36), KClassImpl$Data$declaredNonStaticMembers$2[25], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b10 = KClassImpl$Data$declaredNonStaticMembers$2[7];
                Object[] objArr32 = new Object[1];
                b(b10, (byte) (b10 | Ascii.DC4), KClassImpl$Data$declaredNonStaticMembers$2[25], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(106 - TextUtils.indexOf((CharSequence) "", '0', 0), TextUtils.getCapsMode("", 0, 0) + 3, (char) KeyEvent.keyCodeFromString(""));
                        Object[] objArr34 = new Object[1];
                        c($$a[53], (byte) ($$a[78] - 1), $$a[8], objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - KeyEvent.keyCodeFromString(""), Process.getGidForName("") + 36, (char) Color.red(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-629263445, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.combineMeasuredStates(0, 0), (ViewConfiguration.getLongPressTimeout() >> 16) + 18, (char) TextUtils.getCapsMode("", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    protected abstract void initData();

    protected abstract void modifyViewFromOutside();

    @Override // android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(17327 - Color.blue(0), new char[]{42070, 59382, 8973, 28488, 43748, 63029, 12873, 32208, 47406, 50528, 145, 19612, 34882, 52151, 6097, 21279, 40625, 56001, 26125, 41395, 60879, 10500, 30031, 45291, 64574, 14404}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(getPackageName().length() + 48724, new char[]{42068, 6681, 55539, 40788, 23870, 5022, 53857, 36875, 22175, 5492, 52181, 35255, 18448, 3785, 52409, 33547, 16872, 'R'}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 930, 35 - View.combineMeasuredStates(0, 0), (char) (ExpandableListView.getPackedPositionChild(0L) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), TextUtils.getCapsMode("", 0, 0) + 18, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    public void showSubmittingDialog() {
        this.initSubmittingTime = System.currentTimeMillis();
        this.weakHandler.sendEmptyMessageDelayed(1000, SHOW_SUBMITTING_DELAY);
    }

    protected void cancelSubmittingDialog() {
        this.weakHandler.removeMessages(1000);
    }

    public void hideSubmittingDialog() {
        if (System.currentTimeMillis() - this.initSubmittingTime <= SHOW_SUBMITTING_DELAY) {
            cancelSubmittingDialog();
        }
        Dialog dialog = this.submittingDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(super.getResources().getString(R.string.promo_discovery_error_network_description).substring(0, 1).codePointAt(0) + 25324, new char[]{42070, 51062, 25101, 36296, 10468, 19381, 63305, 4688, 48416, 55523, 31695, 59234, 625, 44347, 51398, 27539, 38580, 12891}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 29983, new char[]{42074, 53585, 20060, 64259, 28719}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                a(super.getResources().getString(R.string.dana_viz_prompt_monitored_by_description).substring(0, 5).codePointAt(3) + 17262, new char[]{42070, 59382, 8973, 28488, 43748, 63029, 12873, 32208, 47406, 50528, 145, 19612, 34882, 52151, 6097, 21279, 40625, 56001, 26125, 41395, 60879, 10500, 30031, 45291, 64574, 14404}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                a(48730 - TextUtils.indexOf((CharSequence) "", '0', 0), new char[]{42068, 6681, 55539, 40788, 23870, 5022, 53857, 36875, 22175, 5492, 52181, 35255, 18448, 3785, 52409, 33547, 16872, 'R'}, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 930, 35 - TextUtils.getOffsetBefore("", 0), (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr6 = new Object[1];
                        b(KClassImpl$Data$declaredNonStaticMembers$2[32], KClassImpl$Data$declaredNonStaticMembers$2[9], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), objArr6);
                        Class<?> cls3 = Class.forName((String) objArr6[0]);
                        Object[] objArr7 = new Object[1];
                        b(KClassImpl$Data$declaredNonStaticMembers$2[13], KClassImpl$Data$declaredNonStaticMembers$2[59], KClassImpl$Data$declaredNonStaticMembers$2[56], objArr7);
                        Object[] objArr8 = new Object[1];
                        a(((ApplicationInfo) cls3.getMethod((String) objArr7[0], null).invoke(this, null)).targetSdkVersion + 21544, new char[]{41984, 61469, 3219, 22740, 62755, 318, 23992, 59888, 1608, 21187, 61070, 15218, 22334, 58288, 16376, 21574, 57494, 15583, 18723, 58685, 12775, 19881, 39442, 13966, 17035, 40741, 11109, 18400, 37881, 10262, 17624, 36997, 11566, 31080, 38327, 8693, 32277, 35459, 9945, 29464, 36712, 56288, 30713, 35906, 55513, 29905, 33055, 56629}, objArr8);
                        String str = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        a(getPackageName().codePointAt(4) + 19954, new char[]{42070, 59985, 14503, 20138, 40221, 9105, 29173, 32842, 54987, 25791, 43824, 63891, 4023, 24113, 60556, 13022, 16693, 38790, 9607, 29743, 47663, 51401, 7971, 44401, 62409, 590, 20576, 59027, 13595, 31540, 35263, 55304, 28212, 48352, 49925, 4438, 43000, 62891, 1109, 19105, 39162, 12108, 32204, 33783, 53776, 24727, 46828, 50493, 2964, 23015, 59446, 16007, 19666, 37679, 8581, 30675, 34351, 54397, 6810, 43380, 65394, 3528, 23625, 57961}, objArr9);
                        String str2 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        a(super.getResources().getString(R.string.family_account_general_declined_security_reason).substring(11, 12).length() + 6688, new char[]{41989, 48679, 36880, 59958, 52362, 9893, 14531, 4836, 29959, 20262, 41285, 47981, 40330, 63401, 51657, 9199, 1606, 6243, 29265, 21536, 44689, 32992, 39552, 64755, 55064, 10600, 852, 25972, 32717, 20972, 43998, 36267, 57376, 64018, 56423, 13964, 2289, 25285, 17639, 24328, 45351, 35608, 60780, 51080, 55715, 13258, 5560, 26714, 16993, 42079, 48678, 37057, 60081, 52435, 9895, 14613, 4920, 30043, 20340, 41370, 48109, 40415, 63484, 51729}, objArr10);
                        String str3 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        a((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 51817, new char[]{42079, 28202, 12433, 64380, 36320, 20480, 6766, 11463, 63259, 47591, 19523, 5845, 55541, 58134, 46561, 30818, 706, 54447, 40737, 41375, 29794, 16089, 49477, 35702, 23944, 24579, 11004, 64854, 34607, 18849, 7176, 9973, 59766, 46028, 17824, 2114, 53904, 58741, 45004, 29159, 1086, 52886, 37220, 23483, 28242, 12332, 64142, 36117, 22516, 6746, 11418, 63146, 47441, 17317, 5748, 55502, 58026, 46392, 32649, 631}, objArr11);
                        String str4 = (String) objArr11[0];
                        Object[] objArr12 = new Object[1];
                        a(super.getResources().getString(R.string.tnc_dialog_fail_load).substring(1, 2).length() + 6490, new char[]{41998, 48450, 38581, 59400, 49513, 56001}, objArr12);
                        try {
                            Object[] objArr13 = {baseContext, str, str2, str3, str4, true, (String) objArr12[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + 911, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 19, (char) TextUtils.indexOf("", "", 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
            byte b = KClassImpl$Data$declaredNonStaticMembers$2[25];
            Object[] objArr14 = new Object[1];
            b(b, (byte) (b | 36), KClassImpl$Data$declaredNonStaticMembers$2[25], objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            byte b2 = KClassImpl$Data$declaredNonStaticMembers$2[7];
            Object[] objArr15 = new Object[1];
            b(b2, (byte) (b2 | Ascii.DC4), KClassImpl$Data$declaredNonStaticMembers$2[25], objArr15);
            try {
                Object[] objArr16 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetAfter("", 0) + 494, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 4, (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))));
                    Object[] objArr17 = new Object[1];
                    c($$a[53], (byte) ($$a[78] - 1), $$a[8], objArr17);
                    obj3 = cls5.getMethod((String) objArr17[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr18 = (Object[]) ((Method) obj3).invoke(null, objArr16);
                int i = ((int[]) objArr18[1])[0];
                if (((int[]) objArr18[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr19 = {665529984, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + 911, 18 - (ViewConfiguration.getTouchSlop() >> 8), (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                this.weakHandler = new WeakHandler(this);
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

    @Override // android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(getPackageName().length() + 17320, new char[]{42070, 59382, 8973, 28488, 43748, 63029, 12873, 32208, 47406, 50528, 145, 19612, 34882, 52151, 6097, 21279, 40625, 56001, 26125, 41395, 60879, 10500, 30031, 45291, 64574, 14404}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a((ViewConfiguration.getKeyRepeatDelay() >> 16) + 48731, new char[]{42068, 6681, 55539, 40788, 23870, 5022, 53857, 36875, 22175, 5492, 52181, 35255, 18448, 3785, 52409, 33547, 16872, 'R'}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.getDeadChar(0, 0), Color.blue(0) + 18, (char) View.resolveSize(0, 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        modifyStatusBg();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        SecTouchInterface secTouchInterface;
        if (motionEvent.getActionMasked() == 0 && (secTouchInterface = SecVIVerify.secTouchInterface) != null) {
            secTouchInterface.touchListener(this, motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public WeakHandler getWeakHandler() {
        return this.weakHandler;
    }

    public void registerHandlerCallback(HandlerCallback handlerCallback) {
        this.handlerCallback = handlerCallback;
    }

    /* loaded from: classes7.dex */
    public static class WeakHandler<T extends BaseActivity> extends Handler {
        WeakReference<T> mActivityReference;

        WeakHandler(T t) {
            this.mActivityReference = new WeakReference<>(t);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference<T> weakReference = this.mActivityReference;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            if (message.what == 1000) {
                if (this.mActivityReference.get().isFinishing()) {
                    return;
                }
                if (this.mActivityReference.get().submittingDialog == null) {
                    this.mActivityReference.get().submittingDialog = CustomUi.createLoadingDialog(this.mActivityReference.get());
                }
                this.mActivityReference.get().submittingDialog.show();
            } else if (this.mActivityReference.get().handlerCallback != null) {
                this.mActivityReference.get().handlerCallback.handleMessage(message);
            }
        }
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        initData();
        modifyViewFromOutside();
    }

    protected void modifyStatusBg() {
        String statusBarBgStrColor = ActivityInterfaceManager.getCommonActivityInterface().statusBarBgStrColor();
        if (TextUtils.isEmpty(statusBarBgStrColor)) {
            return;
        }
        StatusBarUtil.setColor(this, Color.parseColor(statusBarBgStrColor));
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.weakHandler.removeCallbacksAndMessages(null);
        hideSubmittingDialog();
    }

    private boolean isNavigationBarShow() {
        if (Build.VERSION.SDK_INT < 17) {
            return (ViewConfiguration.get(this).hasPermanentMenuKey() || KeyCharacterMap.deviceHasKey(4)) ? false : true;
        }
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        Point point2 = new Point();
        defaultDisplay.getSize(point);
        defaultDisplay.getRealSize(point2);
        return point2.y != point.y;
    }

    public int getNavigationBarHeight() {
        if (isNavigationBarShow()) {
            try {
                Resources resources = getResources();
                return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
            } catch (Throwable unused) {
                return 0;
            }
        }
        return 0;
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (BuiltInFictitiousFunctionClassFactory ^ 4796183387843776835L);
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
