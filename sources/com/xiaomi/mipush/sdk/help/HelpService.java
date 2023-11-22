package com.xiaomi.mipush.sdk.help;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.E;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes8.dex */
public class HelpService extends IntentService {
    public static final byte[] $$a = {TarHeader.LF_DIR, 18, -76, 65, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 46;
    public static final byte[] getAuthRequestContext = {Ascii.US, -80, -88, -103, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int MyBillsEntityDataFactory = 50;
    private static char KClassImpl$Data$declaredNonStaticMembers$2 = 403;
    private static long PlaceComponentResult = 4360990799332652212L;
    private static int BuiltInFictitiousFunctionClassFactory = -956812108;

    public HelpService() {
        super("intentService");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 15
            int r7 = r7 + 4
            byte[] r0 = com.xiaomi.mipush.sdk.help.HelpService.getAuthRequestContext
            int r6 = r6 * 3
            int r6 = r6 + 16
            int r8 = 106 - r8
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L36
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            int r3 = r3 + 1
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
            int r9 = r9 + r6
            int r6 = r8 + 1
            int r8 = r9 + 2
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.help.HelpService.b(int, byte, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002e -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = com.xiaomi.mipush.sdk.help.HelpService.$$a
            int r7 = r7 * 3
            int r7 = 42 - r7
            int r8 = r8 + 4
            int r9 = r9 * 2
            int r9 = r9 + 75
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L18
            r9 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r8
            goto L37
        L18:
            r3 = 0
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r6
        L1d:
            int r9 = r9 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r8) goto L2e
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2e:
            r3 = r0[r9]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L37:
            int r8 = -r8
            int r7 = r7 + r8
            int r7 = r7 + (-7)
            r8 = r9
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.help.HelpService.c(byte, byte, short, java.lang.Object[]):void");
    }

    @Override // android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a(new char[]{0, 0, 0, 0}, new char[]{11380, 17473, 50390, 29766}, TextUtils.getCapsMode("", 0, 0), (char) (Color.green(0) + 18116), new char[]{27557, 45604, 4351, 31817, 34783, 54835, 5607, 16264, 37615, 15417, 56471, 4118, 34813, 4657, 32552, 56384, 50671, 49172}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(new char[]{0, 0, 0, 0}, new char[]{1923, 4734, 41844, 9470}, 1947368967 - TextUtils.getCapsMode("", 0, 0), (char) (65186 - ImageFormat.getBitsPerPixel(0)), new char[]{26477, 19017, 54307, 37870, 3020}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + PDF417Common.NUMBER_OF_CODEWORDS, 35 - TextUtils.getOffsetAfter("", 0), (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(new char[]{0, 0, 0, 0}, new char[]{27528, 56988, 21567, 981}, (-1) - MotionEvent.axisFromString(""), (char) Color.red(0), new char[]{15, 50135, 24161, 40069, 51557, 24843, 39599, 20600, 15776, 12399, 15314, 40173, 34601, 1863, 1700, 12900, 44230, 28424, 4847, 28351, 41881, 42081, 53505, 56739, 43109, 37592, 31937, 15292, 14095, 12473, 55349, 35227, 60093, 41520, 52213, 36165, 36872, 4667, 4264, 15509, 32587, 45787, 2549, 1852, 63768, 27534, 15076, 12038}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(new char[]{0, 0, 0, 0}, new char[]{62625, 60015, 64336, 46504}, TextUtils.getOffsetBefore("", 0), (char) TextUtils.indexOf("", "", 0), new char[]{2025, 45854, 54505, 7529, 42826, 21168, 19410, 34444, 12951, 28925, 53165, 36568, 27415, 16141, 58893, 2762, 56467, 59427, 6600, 29912, 27783, 27929, 32799, 36816, 44275, 7997, 15346, 44113, 4637, 24429, 52988, 18845, 61749, 59641, 5517, 13531, 27598, 9787, 8795, 64915, 36572, 39148, 63035, 36401, 2742, 9384, 37819, 12624, 50499, 20557, 871, 28459, 56395, 23264, 29791, 18434, 48412, 57362, 15656, 26393, 15124, 38424, 18492, 31706}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(new char[]{0, 0, 0, 0}, new char[]{36585, 11829, 20676, 35277}, Process.getGidForName("") + 1, (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), new char[]{59587, 57492, 39969, 1856, 60059, 6379, 2946, 43325, 33272, 57415, 55022, 37223, 14429, 61982, 11165, 27353, 57541, 11180, 26877, 29442, 466, 29764, 52375, 20299, 9285, 31102, 50147, 38874, 52123, 62410, 6601, 1714, 22572, 26237, 25105, 49707, 13345, 22049, 27072, 54149, 63554, 47991, 44935, 52641, 50828, 13943, 1314, 33099, 57433, 11045, 1427, 54936, 13411, 19921, 13572, 58626, 41535, 18033, 13330, 29055, 44389, 8890, 52058, 41068}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(new char[]{0, 0, 0, 0}, new char[]{6293, 42513, 51973, 58180}, KeyEvent.getMaxKeyCode() >> 16, (char) View.resolveSize(0, 0), new char[]{35428, 57439, 32756, 61093, 1588, 17674, 55279, 803, 29701, 35977, 3027, 59255, 39017, 12432, 3438, 44122, 65275, 51559, 57096, 732, 16030, 41403, 34978, 8115, 64045, 65272, 12829, 63053, 34445, 20000, 39218, 2662, 46886, 12568, 12362, 5486, 65517, 32065, 2942, 26534, 38695, 27460, 4623, 3109, 19910, 3249, 38392, 61559, 53855, 7466, 19971, 5665, 14866, 7593, 3908, 57566, 33733, 64002, 32171, 25837}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(new char[]{0, 0, 0, 0}, new char[]{39690, 54736, 8063, 58649}, ViewConfiguration.getEdgeSlop() >> 16, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 6430), new char[]{28105, 12150, 40143, 34835, 17712, 24889}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.resolveSizeAndState(0, 0, 0), 18 - View.combineMeasuredStates(0, 0), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = (byte) (getAuthRequestContext[5] + 1);
                byte b2 = (byte) (-getAuthRequestContext[5]);
                Object[] objArr13 = new Object[1];
                b(b, b2, (byte) (b2 - 1), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b3 = (byte) (getAuthRequestContext[5] + 1);
                Object[] objArr14 = new Object[1];
                b(b3, b3, (byte) (-getAuthRequestContext[5]), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(56 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 3, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)));
                        Object[] objArr16 = new Object[1];
                        c($$a[68], $$a[78], $$a[47], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 801, 14 - Process.getGidForName(""), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getLongPressTimeout() >> 16), 15 - View.combineMeasuredStates(0, 0), (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - (KeyEvent.getMaxKeyCode() >> 16), 29 - TextUtils.getOffsetBefore("", 0), (char) (57994 - (ViewConfiguration.getEdgeSlop() >> 16)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getEdgeSlop() >> 16), 15 - (ViewConfiguration.getScrollBarSize() >> 8), (char) TextUtils.getOffsetBefore("", 0)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.resolveSizeAndState(0, 0, 0), View.resolveSize(0, 0) + 35, (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {597469104, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ImageFormat.getBitsPerPixel(0), 18 - TextUtils.getOffsetBefore("", 0), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b4 = (byte) (getAuthRequestContext[5] + 1);
                byte b5 = (byte) (-getAuthRequestContext[5]);
                Object[] objArr20 = new Object[1];
                b(b4, b5, (byte) (b5 - 1), objArr20);
                Class<?> cls4 = Class.forName((String) objArr20[0]);
                byte b6 = (byte) (getAuthRequestContext[5] + 1);
                Object[] objArr21 = new Object[1];
                b(b6, b6, (byte) (-getAuthRequestContext[5]), objArr21);
                try {
                    Object[] objArr22 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr21[0], Object.class).invoke(null, objArr19)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + 61, 47 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))));
                        Object[] objArr23 = new Object[1];
                        c((byte) (-$$a[8]), (byte) (-$$a[28]), (byte) (-$$a[9]), objArr23);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.getDefaultSize(0, 0), TextUtils.indexOf("", "") + 35, (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr25 = {597469104, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", ""), Color.rgb(0, 0, 0) + 16777234, (char) (Process.getGidForName("") + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b7 = (byte) (getAuthRequestContext[5] + 1);
                byte b8 = (byte) (-getAuthRequestContext[5]);
                Object[] objArr27 = new Object[1];
                b(b7, b8, (byte) (b8 - 1), objArr27);
                Class<?> cls6 = Class.forName((String) objArr27[0]);
                byte b9 = (byte) (getAuthRequestContext[5] + 1);
                Object[] objArr28 = new Object[1];
                b(b9, b9, (byte) (-getAuthRequestContext[5]), objArr28);
                try {
                    Object[] objArr29 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr28[0], Object.class).invoke(null, objArr26)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(119 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), TextUtils.getOffsetBefore("", 0) + 3, (char) (View.combineMeasuredStates(0, 0) + 38968));
                        Object[] objArr30 = new Object[1];
                        c((byte) (-$$a[8]), (byte) (-$$a[28]), (byte) (-$$a[9]), objArr30);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 35 - (KeyEvent.getMaxKeyCode() >> 16), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr32 = {597469104, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + 911, 19 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b10 = (byte) (getAuthRequestContext[5] + 1);
                byte b11 = (byte) (-getAuthRequestContext[5]);
                Object[] objArr34 = new Object[1];
                b(b10, b11, (byte) (b11 - 1), objArr34);
                Class<?> cls8 = Class.forName((String) objArr34[0]);
                byte b12 = (byte) (getAuthRequestContext[5] + 1);
                Object[] objArr35 = new Object[1];
                b(b12, b12, (byte) (-getAuthRequestContext[5]), objArr35);
                try {
                    Object[] objArr36 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr35[0], Object.class).invoke(null, objArr33)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 107, TextUtils.lastIndexOf("", '0') + 4, (char) Color.green(0));
                        Object[] objArr37 = new Object[1];
                        c((byte) ($$a[47] - 1), $$a[40], (byte) ($$a[47] - 1), objArr37);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getTapTimeout() >> 16), 34 - ImageFormat.getBitsPerPixel(0), (char) Drawable.resolveOpacity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr39 = {597469104, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + 911, 17 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        try {
            byte b = (byte) (getAuthRequestContext[5] + 1);
            byte b2 = (byte) (-getAuthRequestContext[5]);
            Object[] objArr = new Object[1];
            b(b, b2, (byte) (b2 - 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (getAuthRequestContext[5] + 1);
            Object[] objArr2 = new Object[1];
            b(b3, b3, (byte) (-getAuthRequestContext[5]), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - Drawable.resolveOpacity(0, 0), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 4, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)));
                    Object[] objArr4 = new Object[1];
                    c((byte) ($$a[47] - 1), $$a[40], (byte) ($$a[47] - 1), objArr4);
                    obj = cls2.getMethod((String) objArr4[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj);
                }
                Object[] objArr5 = (Object[]) ((Method) obj).invoke(null, objArr3);
                int i = ((int[]) objArr5[1])[0];
                if (((int[]) objArr5[0])[0] != i) {
                    long j = ((r1 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (Process.myTid() >> 22), View.resolveSizeAndState(0, 0, 0) + 35, (char) (Color.rgb(0, 0, 0) + 16777216))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {907142113, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0) + 911, 17 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj3);
                            }
                            ((Method) obj3).invoke(invoke, objArr6);
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
                super.onCreate();
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

    @Override // android.app.IntentService
    @Deprecated
    protected void onHandleIntent(Intent intent) {
    }

    private static void a(char[] cArr, char[] cArr2, int i, char c, char[] cArr3, Object[] objArr) {
        E e = new E();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr3.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        while (e.KClassImpl$Data$declaredNonStaticMembers$2 < length3) {
            int i2 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
            int i3 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
            e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i2]) % 65535);
            cArr5[i3] = (char) (((cArr4[i3] * 32718) + cArr5[i2]) / 65535);
            cArr4[i3] = e.MyBillsEntityDataFactory;
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i3] ^ cArr3[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (PlaceComponentResult ^ 4360990799332652212L)) ^ ((int) (BuiltInFictitiousFunctionClassFactory ^ 4360990799332652212L))) ^ ((char) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
        objArr[0] = new String(cArr6);
    }
}
