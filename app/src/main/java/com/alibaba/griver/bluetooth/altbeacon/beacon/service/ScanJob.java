package com.alibaba.griver.bluetooth.altbeacon.beacon.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
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
import com.alibaba.griver.bluetooth.altbeacon.beacon.Beacon;
import com.alibaba.griver.bluetooth.altbeacon.beacon.BeaconManager;
import com.alibaba.griver.bluetooth.altbeacon.beacon.Region;
import com.alibaba.griver.bluetooth.altbeacon.beacon.distance.ModelSpecificDistanceCalculator;
import com.alibaba.griver.bluetooth.altbeacon.beacon.logging.LogManager;
import com.alibaba.griver.bluetooth.altbeacon.beacon.utils.ProcessUtils;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getOnBoardingScenario;

/* loaded from: classes6.dex */
public class ScanJob extends JobService {
    public static final int IMMMEDIATE_SCAN_JOB_ID = 2;
    private static long MyBillsEntityDataFactory = 0;
    public static final int PERIODIC_SCAN_JOB_ID = 1;
    private static final String TAG = "ScanJob";
    private ScanHelper mScanHelper;
    private ScanState mScanState;
    public static final byte[] $$a = {38, -105, 32, Ascii.RS, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 149;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {11, Ascii.GS, 107, 8, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int PlaceComponentResult = 92;
    private Handler mStopHandler = new Handler();
    private boolean mInitialized = false;

    static {
        BuiltInFictitiousFunctionClassFactory();
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        MyBillsEntityDataFactory = 865071644374042573L;
    }

    private static void b(short s, int i, int i2, Object[] objArr) {
        int i3 = 106 - s;
        byte[] bArr = KClassImpl$Data$declaredNonStaticMembers$2;
        int i4 = (i2 * 4) + 16;
        int i5 = (i * 15) + 4;
        byte[] bArr2 = new byte[i4];
        int i6 = -1;
        int i7 = i4 - 1;
        if (bArr == null) {
            i3 = i5 + (-i3) + 2;
            i5++;
            i7 = i7;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i6 = -1;
        }
        while (true) {
            int i8 = i6 + 1;
            bArr2[i8] = (byte) i3;
            if (i8 == i7) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i3 = i3 + (-bArr[i5]) + 2;
            i5++;
            i7 = i7;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i6 = i8;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0029 -> B:23:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 2
            int r8 = r8 + 75
            int r7 = r7 * 3
            int r7 = 42 - r7
            int r6 = 47 - r6
            byte[] r0 = com.alibaba.griver.bluetooth.altbeacon.beacon.service.ScanJob.$$a
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L19
            r8 = r7
            r3 = r1
            r4 = 0
            r7 = r6
            r1 = r0
            r0 = r9
            r9 = r8
            goto L33
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
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L33:
            int r6 = -r6
            int r8 = r8 + r6
            int r6 = r7 + 1
            int r8 = r8 + (-7)
            r7 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.bluetooth.altbeacon.beacon.service.ScanJob.c(byte, short, byte, java.lang.Object[]):void");
    }

    @Override // android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a((ViewConfiguration.getEdgeSlop() >> 16) + 541, new char[]{22255, 21757, 21200, 20651, 24213, 23670, 23108, 22635, 17929, 17912, 17282, 16865, 20384, 19864, 19323, 18776, 30509, 29968}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a((ViewConfiguration.getTapTimeout() >> 16) + 17137, new char[]{22243, 5126, 54073, 40500, 23854}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.alpha(0), KeyEvent.getDeadChar(0, 0) + 35, (char) TextUtils.getCapsMode("", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(TextUtils.getOffsetAfter("", 0) + 55163, new char[]{22201, 33174, 63566, 53447, 2898, 25485, 23125, 45803, 60769, 50616, 15395, 5281, 20271, 42883, 40453, 63117, 8463, 6548, 28702, 43214, 33654, 64506, 53887, 2741, 25954, 23998, 46280, 61203, 51144, 15877, 5765, 16654, 47575, 36963, 51434, 9062, 7076, 29296, 43764, 34051, 64897, 54363, 3220, 26385, 24520, 46626, 61090, 55678}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(1427 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), new char[]{22255, 21288, 23966, 18003, 16548, 19816, 30668, 29107, 31346, 25798, 24841, 27626, 5134, 7880, 6325, 1319, 3980, 2175, 12990, 16214, 14742, 9136, 11290, 54920, 54128, 56759, 50777, 49258, 51874, 63309, 61830, 64113, 58509, 57625, 60220, 38319, 40513, 39122, 34156, 36824, 34883, 45621, 48373, 47374, 41897, 44142, 22229, 21316, 23853, 18334, 16399, 19198, 30571, 29142, 31676, 25642, 28310, 27396, 5539, 7693, 6347, 689, 3952, 2448}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(KeyEvent.keyCodeFromString("") + 19681, new char[]{22204, 6750, 53033, 45135, 25907, 55004, 39930, 19613, 12734, 58719, 22140, 6932, 52275, 45520, 25328, 55190, 39167, 19482, 12648, 57945, 22312, 6297, 52665, 48778, 25505, 55057, 39021, 19725, 15988, 58261, 21735, 6610, 51865, 49131, 25438, 54389, 39240, 19004, 16350, 57585, 21918, 1761, 51797, 49009, 24602, 54579, 34433, 19363, 15576, 57766, 21791, 1592, 51976, 48170, 24990, 53996, 34689, 18594, 15437, 57699, 21076, 1830, 51397, 48616}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(MotionEvent.axisFromString("") + 63180, new char[]{22246, 41009, 47980, 45727, 36305, 34627, 40547, 59692, 57522, 64460, 62734, 52310, 50980, 57013, 10748, 8985, 14939, 13716, 3260, 2044, 4403, 26714, 25480, 31389, 30177, 20264, 18033, 20885, 43230, 41474, 48437, 46190, 36751, 34519, 36893, 60257, 57953, 64950, 62657, 52812, 55639, 53373, 11177, 8888, 15363, 14159, 3731, 6574, 4333, 27169, 25863, 31881, 30592, 20134, 22585, 21349, 43651, 42451, 48900, 46644}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a((ViewConfiguration.getFadingEdgeLength() >> 16) + 45659, new char[]{22199, 58619, 12812, 16817, 40912, 11640}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 911, 18 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) Color.green(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = KClassImpl$Data$declaredNonStaticMembers$2[5];
                Object[] objArr13 = new Object[1];
                b((byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1), b, (byte) (b - 1), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b2 = KClassImpl$Data$declaredNonStaticMembers$2[5];
                byte b3 = (byte) (b2 - 1);
                Object[] objArr14 = new Object[1];
                b(b2, b3, b3, objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(56 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), Drawable.resolveOpacity(0, 0) + 3, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)));
                        Object[] objArr16 = new Object[1];
                        c((byte) (-$$a[53]), $$a[68], $$a[47], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - ExpandableListView.getPackedPositionType(0L), '?' - AndroidCharacter.getMirror('0'), (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - Drawable.resolveOpacity(0, 0), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 15, (char) TextUtils.indexOf("", ""))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 815, 29 - (ViewConfiguration.getTouchSlop() >> 8), (char) (KeyEvent.keyCodeFromString("") + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 15 - View.MeasureSpec.getSize(0), (char) Color.red(0)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetAfter("", 0) + PDF417Common.NUMBER_OF_CODEWORDS, Color.red(0) + 35, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-1987573449, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", "", 0), 18 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) TextUtils.getTrimmedLength(""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b4 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
                byte b5 = KClassImpl$Data$declaredNonStaticMembers$2[5];
                Object[] objArr19 = new Object[1];
                b(b4, b5, (byte) (b5 - 1), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b6 = KClassImpl$Data$declaredNonStaticMembers$2[5];
                byte b7 = (byte) (b6 - 1);
                Object[] objArr20 = new Object[1];
                b(b6, b7, b7, objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 45, (char) (ViewConfiguration.getTouchSlop() >> 8));
                        Object[] objArr22 = new Object[1];
                        c($$a[20], (byte) (-$$a[8]), (byte) (-$$a[9]), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + 930, (Process.myTid() >> 22) + 35, (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {-1987573449, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0'), 'B' - AndroidCharacter.getMirror('0'), (char) Drawable.resolveOpacity(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b8 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
                byte b9 = KClassImpl$Data$declaredNonStaticMembers$2[5];
                Object[] objArr25 = new Object[1];
                b(b8, b9, (byte) (b9 - 1), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b10 = KClassImpl$Data$declaredNonStaticMembers$2[5];
                byte b11 = (byte) (b10 - 1);
                Object[] objArr26 = new Object[1];
                b(b10, b11, b11, objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 3, (char) (38968 - (ViewConfiguration.getJumpTapTimeout() >> 16)));
                        Object[] objArr28 = new Object[1];
                        c($$a[20], (byte) (-$$a[8]), (byte) (-$$a[9]), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), 35 - Drawable.resolveOpacity(0, 0), (char) KeyEvent.keyCodeFromString(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-1987573449, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getOffsetBefore("", 0), View.combineMeasuredStates(0, 0) + 18, (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b12 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
                byte b13 = KClassImpl$Data$declaredNonStaticMembers$2[5];
                Object[] objArr31 = new Object[1];
                b(b12, b13, (byte) (b13 - 1), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b14 = KClassImpl$Data$declaredNonStaticMembers$2[5];
                byte b15 = (byte) (b14 - 1);
                Object[] objArr32 = new Object[1];
                b(b14, b15, b15, objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - View.MeasureSpec.getMode(0), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 2, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16));
                        byte b16 = (byte) ($$a[47] - 1);
                        byte b17 = b16;
                        Object[] objArr34 = new Object[1];
                        c(b16, b17, b17, objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 930, 34 - Process.getGidForName(""), (char) Drawable.resolveOpacity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {-1987573449, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + 911, 17 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) TextUtils.getCapsMode("", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // android.app.Service
    public void onCreate() {
        try {
            byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
            byte b2 = KClassImpl$Data$declaredNonStaticMembers$2[5];
            Object[] objArr = new Object[1];
            b(b, b2, (byte) (b2 - 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = KClassImpl$Data$declaredNonStaticMembers$2[5];
            byte b4 = (byte) (b3 - 1);
            Object[] objArr2 = new Object[1];
            b(b3, b4, b4, objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(495 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), View.getDefaultSize(0, 0) + 4, (char) (ViewConfiguration.getWindowTouchSlop() >> 8));
                    byte b5 = (byte) ($$a[47] - 1);
                    byte b6 = b5;
                    Object[] objArr4 = new Object[1];
                    c(b5, b6, b6, objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.getTrimmedLength("") + 35, (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-400311230, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + 911, 19 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (TextUtils.lastIndexOf("", '0') + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // android.app.job.JobService
    public boolean onStartJob(final JobParameters jobParameters) {
        boolean startScanning;
        this.mScanHelper = new ScanHelper(this);
        if (jobParameters.getJobId() == 2) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Running immdiate scan job: instance is ");
            sb.append(this);
            LogManager.i(str, sb.toString(), new Object[0]);
        } else {
            String str2 = TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Running periodic scan job: instance is ");
            sb2.append(this);
            LogManager.i(str2, sb2.toString(), new Object[0]);
        }
        List<ScanResult> dumpBackgroundScanResultQueue = ScanJobScheduler.getInstance().dumpBackgroundScanResultQueue();
        LogManager.d(TAG, "Processing %d queued scan resuilts", Integer.valueOf(dumpBackgroundScanResultQueue.size()));
        for (ScanResult scanResult : dumpBackgroundScanResultQueue) {
            ScanRecord scanRecord = scanResult.getScanRecord();
            if (scanRecord != null) {
                this.mScanHelper.processScanResult(scanResult.getDevice(), scanResult.getRssi(), scanRecord.getBytes());
            }
        }
        String str3 = TAG;
        LogManager.d(str3, "Done processing queued scan resuilts", new Object[0]);
        if (this.mInitialized) {
            LogManager.d(str3, "Scanning already started.  Resetting for current parameters", new Object[0]);
            startScanning = restartScanning();
        } else {
            startScanning = startScanning();
        }
        this.mStopHandler.removeCallbacksAndMessages(null);
        if (startScanning) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Scan job running for ");
            sb3.append(this.mScanState.getScanJobRuntimeMillis());
            sb3.append(" millis");
            LogManager.i(str3, sb3.toString(), new Object[0]);
            this.mStopHandler.postDelayed(new Runnable() { // from class: com.alibaba.griver.bluetooth.altbeacon.beacon.service.ScanJob.1
                {
                    ScanJob.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    LogManager.i(ScanJob.TAG, "Scan job runtime expired", new Object[0]);
                    ScanJob.this.stopScanning();
                    ScanJob.this.mScanState.save();
                    ScanJob.this.startPassiveScanIfNeeded();
                    ScanJob.this.jobFinished(jobParameters, false);
                }
            }, this.mScanState.getScanJobRuntimeMillis());
        } else {
            LogManager.i(str3, "Scanning not started so Scan job is complete.", new Object[0]);
            jobFinished(jobParameters, false);
        }
        return true;
    }

    public void startPassiveScanIfNeeded() {
        LogManager.d(TAG, "Checking to see if we need to start a passive scan", new Object[0]);
        Iterator<Region> it = this.mScanState.getMonitoringStatus().regions().iterator();
        boolean z = false;
        while (it.hasNext()) {
            RegionMonitoringState stateOf = this.mScanState.getMonitoringStatus().stateOf(it.next());
            if (stateOf != null && stateOf.getInside()) {
                z = true;
            }
        }
        if (z) {
            LogManager.i(TAG, "We are inside a beacon region.  We will not scan between cycles.", new Object[0]);
        } else if (Build.VERSION.SDK_INT >= 26) {
            this.mScanHelper.startAndroidOBackgroundScan(this.mScanState.getBeaconParsers());
        } else {
            LogManager.d(TAG, "This is not Android O.  No scanning between cycles when using ScanJob", new Object[0]);
        }
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        if (jobParameters.getJobId() == 1) {
            LogManager.i(TAG, "onStopJob called for periodic scan", new Object[0]);
        } else {
            LogManager.i(TAG, "onStopJob called for immediate scan", new Object[0]);
        }
        this.mStopHandler.removeCallbacksAndMessages(null);
        stopScanning();
        startPassiveScanIfNeeded();
        return false;
    }

    public void stopScanning() {
        this.mInitialized = false;
        this.mScanHelper.getCycledScanner().stop();
        this.mScanHelper.getCycledScanner().destroy();
        LogManager.d(TAG, "Scanning stopped", new Object[0]);
    }

    private boolean restartScanning() {
        ScanState restore = ScanState.restore(this);
        this.mScanState = restore;
        restore.setLastScanStartTimeMillis(System.currentTimeMillis());
        this.mScanHelper.setMonitoringStatus(this.mScanState.getMonitoringStatus());
        this.mScanHelper.setRangedRegionState(this.mScanState.getRangedRegionState());
        this.mScanHelper.setBeaconParsers(this.mScanState.getBeaconParsers());
        this.mScanHelper.setExtraDataBeaconTracker(this.mScanState.getExtraBeaconDataTracker());
        if (this.mScanHelper.getCycledScanner() == null) {
            this.mScanHelper.createCycledLeScanner(this.mScanState.getBackgroundMode().booleanValue(), null);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.mScanHelper.stopAndroidOBackgroundScan();
        }
        long longValue = (this.mScanState.getBackgroundMode().booleanValue() ? this.mScanState.getBackgroundScanPeriod() : this.mScanState.getForegroundScanPeriod()).longValue();
        this.mScanHelper.getCycledScanner().setScanPeriods(longValue, (this.mScanState.getBackgroundMode().booleanValue() ? this.mScanState.getBackgroundBetweenScanPeriod() : this.mScanState.getForegroundBetweenScanPeriod()).longValue(), this.mScanState.getBackgroundMode().booleanValue());
        this.mInitialized = true;
        if (longValue <= 0) {
            LogManager.w(TAG, "Starting scan with scan period of zero.  Exiting ScanJob.", new Object[0]);
            this.mScanHelper.getCycledScanner().stop();
            return false;
        } else if (this.mScanHelper.getRangedRegionState().size() > 0 || this.mScanHelper.getMonitoringStatus().regions().size() > 0) {
            this.mScanHelper.getCycledScanner().start();
            return true;
        } else {
            this.mScanHelper.getCycledScanner().stop();
            return false;
        }
    }

    private boolean startScanning() {
        BeaconManager instanceForApplication = BeaconManager.getInstanceForApplication(getApplicationContext());
        instanceForApplication.setScannerInSameProcess(false);
        if (instanceForApplication.isMainProcess()) {
            LogManager.i(TAG, "scanJob version %s is starting up on the main process", "1.0");
        } else {
            String str = TAG;
            LogManager.i(str, "beaconScanJob library version %s is starting up on a separate process", "1.0");
            ProcessUtils processUtils = new ProcessUtils(this);
            StringBuilder sb = new StringBuilder();
            sb.append("beaconScanJob PID is ");
            sb.append(processUtils.getPid());
            sb.append(" with process name ");
            sb.append(processUtils.getProcessName());
            LogManager.i(str, sb.toString(), new Object[0]);
        }
        Beacon.setDistanceCalculator(new ModelSpecificDistanceCalculator(this, BeaconManager.getDistanceModelUpdateUrl()));
        return restartScanning();
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (MyBillsEntityDataFactory ^ 4796183387843776835L);
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
