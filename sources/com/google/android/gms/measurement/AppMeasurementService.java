package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.android.gms.measurement.internal.zzjy;
import com.google.android.gms.measurement.internal.zzjz;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.whenAvailable;

/* loaded from: classes7.dex */
public final class AppMeasurementService extends Service implements zzjy {
    private zzjz zza;
    public static final byte[] $$a = {107, 3, 14, 112, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 179;
    public static final byte[] PlaceComponentResult = {10, -99, -17, -84, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int MyBillsEntityDataFactory = 73;
    private static char[] KClassImpl$Data$declaredNonStaticMembers$2 = {14251, 11572, 654, 30728, 24037, 45939, 43214, 36372, 58149, 55465, 15940, 5034, 2424, 28405, 17481, 47583, 40633, 62505, 62243, 59815, 50747, 48279, 39274, 62329, 59837, 50776, 48326, 39230, 30714, 27671, 19078, 10233, 7227, 64141, 55064, 52715, 43564, 32927, 32008, 23167, 12527, 11608, 2975, 57450, 57085, 47949, 37256, 36522, 27501, 16854, 15898, 5308, 61818, 61391, 50267, 41335, 40936, 29788, 21191, 20328, 9639, 534, 63630, 54777, 45624, 43226, 34120, 25580, 22573, 13976, 4955, 11430, 13922, 6609, 25363, 18145, 43054, 45975, 38159, 63523, 50100, 9566, 2242, 4707, 30118, 24342, 41603, 34293, 61285, 62081, 54342, 16355, 294, 25745, 19972, 20849, 46261, 40542, 57746, 52031, 12019, 12309, 7045, 32420, 16435, 43987, 36175, 37092, 64116, 56727, 9988, 2674, 28135, 30466, 23238, 48228, 34720, 59670, 52352, 55284, 14692, 7376, 26190, 18878, 21280, 46743, 38918, 58231, 50918, 10244, 13205, 5430, 30895, 16963, 42372, 62332, 59887, 50699, 48284, 39223, 30633, 27676, 19082, 10230, 7270, 64214, 55119, 52671, 43565, 32926, 32009, 23087, 12475, 11610, 2970, 57404, 57084, 47951, 37261, 36601, 27448, 16855, 15942, 5352, 61816, 61337, 50269, 41337, 40890, 29788, 21190, 20332, 9641, 536, 63622, 54774, 45624, 43231, 34122, 25526, 22574, 14031, 4956, 2088, 59111, 49933, 47515, 38460, 36015, 26952, 18315, 15609, 6507, 63447, 60488, 51944, 42795, 40347, 31239, 62246, 59818, 50714, 48270, 39293, 30628, 27649, 19089, 10154, 7231, 64128, 55071, 52640, 43626, 32966, 32076, 23083, 12479, 11546, 2973, 57455, 57069, 47962, 37264, 36521, 27435, 16783, 15884, 5354, 61805, 61407, 50251, 41263, 40876, 29707, 21200, 20333, 9713, 579, 63633, 54703, 45614, 43143, 34129, 25575, 22640, 14025, 4955, 2109, 59050, 49985, 47496, 38460, 36017, 26955, 18376, 15531, 6448, 63386, 60429, 61241, 62910, 55828, 41118, 34162, 27617};
    private static long BuiltInFictitiousFunctionClassFactory = 5765513557010147806L;

    private static void a(byte b, int i, byte b2, Object[] objArr) {
        int i2 = 18 - (b * 15);
        int i3 = 106 - b2;
        byte[] bArr = PlaceComponentResult;
        int i4 = (i * 4) + 16;
        byte[] bArr2 = new byte[i4];
        int i5 = -1;
        int i6 = i4 - 1;
        if (bArr == null) {
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
            i3 = i3 + i6 + 2;
            i6 = i6;
        }
        while (true) {
            int i7 = i5 + 1;
            i2++;
            bArr2[i7] = (byte) i3;
            if (i7 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b3 = bArr[i2];
            int i8 = i3;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = i7;
            i3 = i8 + b3 + 2;
            i6 = i6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r7, int r8, short r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = com.google.android.gms.measurement.AppMeasurementService.$$a
            int r7 = r7 * 2
            int r7 = r7 + 75
            int r8 = 47 - r8
            int r9 = r9 * 3
            int r9 = r9 + 21
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L2f
        L17:
            r3 = 0
        L18:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r9) goto L27
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L27:
            r3 = r0[r8]
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L2f:
            int r8 = r8 + 1
            int r7 = r7 + r9
            int r7 = r7 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.AppMeasurementService.b(byte, int, short, java.lang.Object[]):void");
    }

    private final zzjz zzd() {
        if (this.zza == null) {
            this.zza = new zzjz(this);
        }
        return this.zza;
    }

    @Override // android.app.Service, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        c(KeyEvent.getDeadChar(0, 0) + 18, ViewConfiguration.getJumpTapTimeout() >> 16, (char) (50309 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        c((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 4, (-16777198) - Color.rgb(0, 0, 0), (char) Color.red(0), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - ExpandableListView.getPackedPositionType(0L), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    c((ViewConfiguration.getWindowTouchSlop() >> 8) + 48, ExpandableListView.getPackedPositionGroup(0L) + 23, (char) (ViewConfiguration.getWindowTouchSlop() >> 8), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    c((Process.myTid() >> 22) + 64, KeyEvent.keyCodeFromString("") + 71, (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 57225), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    c(64 - Color.argb(0, 0, 0, 0), TextUtils.getOffsetBefore("", 0) + 135, (char) (ViewConfiguration.getEdgeSlop() >> 16), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    c(60 - TextUtils.getOffsetBefore("", 0), TextUtils.getOffsetBefore("", 0) + SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR, (char) (ViewConfiguration.getScrollBarSize() >> 8), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    c((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 6, Drawable.resolveOpacity(0, 0) + DeepRecoverARiverProxy.TYPE_ENTITY_PLUGIN, (char) (7247 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 910, 18 - (ViewConfiguration.getTapTimeout() >> 16), (char) ExpandableListView.getPackedPositionType(0L))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = (byte) (PlaceComponentResult[5] + 1);
                byte b2 = b;
                Object[] objArr13 = new Object[1];
                a(b, b2, b2, objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b3 = (byte) (-PlaceComponentResult[5]);
                Object[] objArr14 = new Object[1];
                a(b3, (byte) (b3 - 1), (byte) (-PlaceComponentResult[5]), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - View.resolveSizeAndState(0, 0, 0), 3 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16));
                        Object[] objArr16 = new Object[1];
                        b($$a[78], $$a[53], $$a[78], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - TextUtils.getOffsetAfter("", 0), (Process.myTid() >> 22) + 15, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + 800, TextUtils.lastIndexOf("", '0', 0) + 16, (char) View.resolveSizeAndState(0, 0, 0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 815, 28 - TextUtils.indexOf((CharSequence) "", '0'), (char) (57994 - View.resolveSize(0, 0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, 16 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) ExpandableListView.getPackedPositionGroup(0L)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r7 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 34, (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {836098489, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + 911, TextUtils.getCapsMode("", 0, 0) + 18, (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b4 = (byte) (PlaceComponentResult[5] + 1);
                byte b5 = b4;
                Object[] objArr19 = new Object[1];
                a(b4, b5, b5, objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b6 = (byte) (-PlaceComponentResult[5]);
                Object[] objArr20 = new Object[1];
                a(b6, (byte) (b6 - 1), (byte) (-PlaceComponentResult[5]), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 46 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getLongPressTimeout() >> 16));
                        Object[] objArr22 = new Object[1];
                        b($$a[2], $$a[84], (byte) ($$a[78] - 1), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 35 - (ViewConfiguration.getEdgeSlop() >> 16), (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {836098489, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + 911, TextUtils.indexOf((CharSequence) "", '0', 0) + 19, (char) View.resolveSize(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b7 = (byte) (PlaceComponentResult[5] + 1);
                byte b8 = b7;
                Object[] objArr25 = new Object[1];
                a(b7, b8, b8, objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b9 = (byte) (-PlaceComponentResult[5]);
                Object[] objArr26 = new Object[1];
                a(b9, (byte) (b9 - 1), (byte) (-PlaceComponentResult[5]), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetAfter("", 0) + 118, 3 - ExpandableListView.getPackedPositionGroup(0L), (char) (TextUtils.lastIndexOf("", '0', 0) + 38969));
                        Object[] objArr28 = new Object[1];
                        b($$a[2], $$a[84], (byte) ($$a[78] - 1), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 930, 35 - (ViewConfiguration.getTouchSlop() >> 8), (char) View.resolveSizeAndState(0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {836098489, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 18, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b10 = (byte) (PlaceComponentResult[5] + 1);
                byte b11 = b10;
                Object[] objArr31 = new Object[1];
                a(b10, b11, b11, objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b12 = (byte) (-PlaceComponentResult[5]);
                Object[] objArr32 = new Object[1];
                a(b12, (byte) (b12 - 1), (byte) (-PlaceComponentResult[5]), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + 107, 4 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) Color.green(0));
                        byte b13 = (byte) ($$a[78] - 1);
                        Object[] objArr34 = new Object[1];
                        b(b13, b13, $$a[8], objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 34, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {836098489, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 911, (ViewConfiguration.getLongPressTimeout() >> 16) + 18, (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return zzd().zzb(intent);
    }

    @Override // android.app.Service
    public final void onCreate() {
        try {
            byte b = (byte) (PlaceComponentResult[5] + 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (-PlaceComponentResult[5]);
            Object[] objArr2 = new Object[1];
            a(b3, (byte) (b3 - 1), (byte) (-PlaceComponentResult[5]), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 494, TextUtils.getTrimmedLength("") + 4, (char) TextUtils.indexOf("", "", 0, 0));
                    byte b4 = (byte) ($$a[78] - 1);
                    Object[] objArr4 = new Object[1];
                    b(b4, b4, $$a[8], objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - MotionEvent.axisFromString(""), Color.rgb(0, 0, 0) + 16777251, (char) TextUtils.getOffsetBefore("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {204618136, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Drawable.resolveOpacity(0, 0), 18 - (Process.myPid() >> 22), (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                zzd().zze();
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

    @Override // android.app.Service
    public final void onDestroy() {
        zzd().zzf();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onRebind(Intent intent) {
        zzd().zzg(intent);
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        zzd().zza(intent, i, i2);
        return 2;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        zzd().zzj(intent);
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.zzjy
    public final void zza(Intent intent) {
        AppMeasurementReceiver.completeWakefulIntent(intent);
    }

    @Override // com.google.android.gms.measurement.internal.zzjy
    public final void zzb(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.measurement.internal.zzjy
    public final boolean zzc(int i) {
        return stopSelfResult(i);
    }

    private static void c(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i) {
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (KClassImpl$Data$declaredNonStaticMembers$2[whenavailable.BuiltInFictitiousFunctionClassFactory + i2] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ BuiltInFictitiousFunctionClassFactory))) ^ c;
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
