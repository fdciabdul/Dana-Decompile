package com.iap.ac.android.acs.plugin.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
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
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import com.iap.ac.android.acs.plugin.utils.MonitorUtil;
import id.dana.R;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.whenAvailable;

/* loaded from: classes8.dex */
public class ThirdPartyBackActivity extends Activity {
    public static final byte[] $$a = {107, 78, -84, 46, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 245;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {TarHeader.LF_LINK, 16, -25, 45, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int getAuthRequestContext = 2;
    private static char[] PlaceComponentResult = {62255, 53515, 46972, 38333, 31629, 23024, 15912, 7245, 57977, 49342, 42702, 33991, 26936, 20238, 11639, 62382, 53645, 47078, 55812, 63547, 40554, 48257, 21153, 62255, 53515, 46972, 38333, 31629, 23024, 15912, 7245, 57975, 49341, 42640, 33977, 26891, 20226, 11616, 62370, 53640, 47100, 37948, 31238, 22598, 16033, 7310, 58102, 50983, 42265, 62253, 53520, 46954, 38333, 31623, 23031, 15928, 7202, 57958, 49341, 42636, 34046, 26921, 20224, 11616, 62370, 53649, 47099, 62329, 53510, 46894, 38391, 31698, 23037, 15989, 7259, 57889, 49320, 42627, 34033, 26927, 20307, 11557, 62461, 53711, 47012, 38014, 31262, 22646, 16042, 7327, 58021, 50978, 42318, 35624, 27043, 20424, 11765, 61989, 53278, 46615, 38131, 31434, 22678, 15652, 832, 57620, 51187, 42433, 35787, 26740, 20033, 11336, 62194, 53442, 46798, 62255, 53584, 46894, 38315, 31620, 22944, 15996, 7259, 57970, 49326, 42713, 33954, 26926, 20304, 11557, 62463, 53708, 47015, 37934, 31310, 22646, 16120, 7370, 58016, 51056, 42271, 35625, 27042, 20418, 11765, 62070, 53321, 46669, 38049, 31436, 22679, 15649, 794, 57628, 51184, 42435, 35741, 26661, 20038, 11337, 62198, 53445, 46748, 39789, 31046, 24351, 15846, 971, 57758, 50796, 42050, 35350, 26860, 20115, 11461, 61803, 55113, 46400, 39912, 62332, 53588, 46973, 38317, 31707, 22958, 15998, 7255, 57902, 49397, 42712, 33958, 27003, 20306, 11556, 62460, 53663, 47088, 38012, 31259, 22560, 16043, 7325, 58016, 51057, 42267, 35625, 27135, 20380, 11767, 62067, 53272, 46617, 38049, 31434, 22679, 15648, 846, 57626, 51195, 42446, 35787, 26737, 20035, 11282, 62193, 53397, 46793, 39736, 31052, 24395, 15802, 960, 57752, 50746, 42054, 35345, 26856, 20169, 11409, 61756, 55108, 46353, 39906, 18170, 25805, 688, 8291, 52813, 60543, 35775, 43408, 22446, 30064, 4946, 12586, 56504, 64201, 39072, 18021, 25671, 552, 8672, 53184, 60847, 35686, 43348, 22369, 29437, 4308, 16045, 56425, 64066, 38974, 18409, 26066, 915, 8555, 53057, 60765, 35069, 46794, 21661, 29232, 4171, 15873, 56821, 64388, 39327, 18291, 25935, 786, 12017, 52445, 60123, 34933, 46620, 21594, 29669, 4569, 16287, 56687, 64344, 39176, 64461, 55793, 49046, 40283, 29546, 20754};
    private static long KClassImpl$Data$declaredNonStaticMembers$2 = -4913828202774408859L;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = 23 - r7
            int r6 = r6 + 97
            int r8 = r8 + 4
            byte[] r0 = com.iap.ac.android.acs.plugin.ui.activity.ThirdPartyBackActivity.BuiltInFictitiousFunctionClassFactory
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
        L16:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r4 = r3 + 1
            int r8 = r8 + 1
            if (r3 != r7) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            r3 = r0[r8]
            r5 = r8
            r8 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L30:
            int r8 = r8 + r6
            int r6 = r8 + (-4)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.acs.plugin.ui.activity.ThirdPartyBackActivity.b(int, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r7, byte r8, byte r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 2
            int r8 = r8 + 75
            int r7 = r7 * 3
            int r7 = r7 + 21
            byte[] r0 = com.iap.ac.android.acs.plugin.ui.activity.ThirdPartyBackActivity.$$a
            int r9 = r9 + 4
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L32
        L17:
            r3 = 0
        L18:
            int r9 = r9 + 1
            byte r4 = (byte) r8
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r7) goto L29
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L29:
            r3 = r0[r9]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L32:
            int r9 = r9 + r8
            int r8 = r9 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.acs.plugin.ui.activity.ThirdPartyBackActivity.c(byte, byte, byte, java.lang.Object[]):void");
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a(18 - (ViewConfiguration.getWindowTouchSlop() >> 8), Color.alpha(0), (char) TextUtils.getCapsMode("", 0, 0), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a((Process.myTid() >> 22) + 5, 18 - View.MeasureSpec.getMode(0), (char) (10535 - (ViewConfiguration.getScrollBarSize() >> 8)), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0', 0), TextUtils.indexOf((CharSequence) "", '0', 0) + 36, (char) KeyEvent.keyCodeFromString(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(TextUtils.indexOf("", "") + 48, KeyEvent.getDeadChar(0, 0) + 67, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(64 - Gravity.getAbsoluteGravity(0, 0), ((Process.getThreadPriority(0) + 20) >> 6) + 115, (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a((KeyEvent.getMaxKeyCode() >> 16) + 64, TextUtils.indexOf((CharSequence) "", '0') + 180, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a((KeyEvent.getMaxKeyCode() >> 16) + 60, TextUtils.indexOf("", "", 0, 0) + 243, (char) (Color.argb(0, 0, 0, 0) + 46556), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(KeyEvent.normalizeMetaState(0) + 6, AndroidCharacter.getMirror('0') + 255, (char) (2234 - View.MeasureSpec.getMode(0)), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - MotionEvent.axisFromString(""), 18 - Drawable.resolveOpacity(0, 0), (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b(BuiltInFictitiousFunctionClassFactory[32], (byte) (-BuiltInFictitiousFunctionClassFactory[30]), 36, objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b((byte) (getAuthRequestContext << 2), (byte) (-BuiltInFictitiousFunctionClassFactory[30]), (byte) (BuiltInFictitiousFunctionClassFactory[35] - 1), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - Gravity.getAbsoluteGravity(0, 0), 3 - TextUtils.getOffsetBefore("", 0), (char) TextUtils.getTrimmedLength(""));
                        byte b = $$a[78];
                        Object[] objArr16 = new Object[1];
                        c(b, b, $$a[47], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - MotionEvent.axisFromString(""), 15 - (ViewConfiguration.getScrollBarSize() >> 8), (char) (Process.myPid() >> 22))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getPressedStateDuration() >> 16), 15 - View.combineMeasuredStates(0, 0), (char) (AndroidCharacter.getMirror('0') - '0'))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(816 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 29 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) (57993 - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 800, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 16, (char) Color.alpha(0)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - KeyEvent.keyCodeFromString(""), 35 - TextUtils.getTrimmedLength(""), (char) TextUtils.getTrimmedLength(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {133917370, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Drawable.resolveOpacity(0, 0), KeyEvent.getDeadChar(0, 0) + 18, (char) (ExpandableListView.getPackedPositionChild(0L) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(BuiltInFictitiousFunctionClassFactory[32], (byte) (-BuiltInFictitiousFunctionClassFactory[30]), 36, objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                b((byte) (getAuthRequestContext << 2), (byte) (-BuiltInFictitiousFunctionClassFactory[30]), (byte) (BuiltInFictitiousFunctionClassFactory[35] - 1), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 60, 46 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1));
                        Object[] objArr22 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[9], $$a[28], objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getWindowTouchSlop() >> 8), (ViewConfiguration.getLongPressTimeout() >> 16) + 35, (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {133917370, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + 911, Color.green(0) + 18, (char) TextUtils.getCapsMode("", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(BuiltInFictitiousFunctionClassFactory[32], (byte) (-BuiltInFictitiousFunctionClassFactory[30]), 36, objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                b((byte) (getAuthRequestContext << 2), (byte) (-BuiltInFictitiousFunctionClassFactory[30]), (byte) (BuiltInFictitiousFunctionClassFactory[35] - 1), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + 119, 3 - ExpandableListView.getPackedPositionGroup(0L), (char) (Gravity.getAbsoluteGravity(0, 0) + 38968));
                        Object[] objArr28 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[9], $$a[28], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - ImageFormat.getBitsPerPixel(0), 35 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) View.combineMeasuredStates(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {133917370, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollDefaultDelay() >> 16) + 911, 17 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) Color.red(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(BuiltInFictitiousFunctionClassFactory[32], (byte) (-BuiltInFictitiousFunctionClassFactory[30]), 36, objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                b((byte) (getAuthRequestContext << 2), (byte) (-BuiltInFictitiousFunctionClassFactory[30]), (byte) (BuiltInFictitiousFunctionClassFactory[35] - 1), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(106 - ImageFormat.getBitsPerPixel(0), View.getDefaultSize(0, 0) + 3, (char) Color.green(0));
                        Object[] objArr34 = new Object[1];
                        c($$a[8], (byte) ($$a[78] - 1), (byte) (-$$a[40]), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), TextUtils.getOffsetBefore("", 0) + 35, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {133917370, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + 911, 18 - View.resolveSize(0, 0), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(KeyEvent.getDeadChar(0, 0) + 18, View.resolveSize(0, 0), (char) (super.getResources().getString(R.string.passkey_activate).substring(8, 16).length() - 8), objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        int gidForName = 4 - Process.getGidForName("");
        try {
            byte b = BuiltInFictitiousFunctionClassFactory[25];
            Object[] objArr3 = new Object[1];
            b(b, b, BuiltInFictitiousFunctionClassFactory[9], objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            b((byte) (-BuiltInFictitiousFunctionClassFactory[5]), BuiltInFictitiousFunctionClassFactory[27], BuiltInFictitiousFunctionClassFactory[59], new Object[1]);
            Object[] objArr4 = new Object[1];
            a(gidForName, ((ApplicationInfo) cls2.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 15, (char) (10535 - View.resolveSize(0, 0)), objArr4);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    try {
                        byte b2 = BuiltInFictitiousFunctionClassFactory[25];
                        Object[] objArr5 = new Object[1];
                        b(b2, b2, BuiltInFictitiousFunctionClassFactory[9], objArr5);
                        Class<?> cls3 = Class.forName((String) objArr5[0]);
                        b((byte) (-BuiltInFictitiousFunctionClassFactory[5]), BuiltInFictitiousFunctionClassFactory[27], BuiltInFictitiousFunctionClassFactory[59], new Object[1]);
                        Object[] objArr6 = new Object[1];
                        a(((ApplicationInfo) cls3.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 7, 22 - MotionEvent.axisFromString(""), (char) (getPackageName().codePointAt(3) - 100), objArr6);
                        Class<?> cls4 = Class.forName((String) objArr6[0]);
                        Object[] objArr7 = new Object[1];
                        a(super.getResources().getString(R.string.global_search_system_busy_desc).substring(7, 8).codePointAt(0) - 82, getPackageName().length() + 42, (char) (getPackageName().length() - 7), objArr7);
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
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776287) - Color.rgb(0, 0, 0), TextUtils.indexOf((CharSequence) "", '0') + 36, (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr8 = new Object[1];
                        a(super.getResources().getString(R.string.promo_code_discovery_subtitle).substring(13, 14).codePointAt(0) - 63, super.getResources().getString(R.string.zface_not_in_center).substring(8, 9).codePointAt(0) - 33, (char) (getPackageName().codePointAt(1) - 100), objArr8);
                        String str = (String) objArr8[0];
                        try {
                            byte b3 = BuiltInFictitiousFunctionClassFactory[25];
                            Object[] objArr9 = new Object[1];
                            b(b3, b3, BuiltInFictitiousFunctionClassFactory[9], objArr9);
                            Class<?> cls5 = Class.forName((String) objArr9[0]);
                            Object[] objArr10 = new Object[1];
                            b((byte) (-BuiltInFictitiousFunctionClassFactory[5]), BuiltInFictitiousFunctionClassFactory[27], BuiltInFictitiousFunctionClassFactory[59], objArr10);
                            Object[] objArr11 = new Object[1];
                            a(((ApplicationInfo) cls5.getMethod((String) objArr10[0], null).invoke(this, null)).targetSdkVersion + 31, super.getResources().getString(R.string.top_up).substring(0, 6).codePointAt(3) + 83, (char) (super.getResources().getString(R.string.mybills_error_toast).substring(17, 18).length() - 1), objArr11);
                            String str2 = (String) objArr11[0];
                            Object[] objArr12 = new Object[1];
                            a(super.getResources().getString(R.string.user_review_anonymous_label).substring(0, 4).length() + 60, getPackageName().codePointAt(2) + 133, (char) (super.getResources().getString(R.string.pin_regular_changes_dialog_desc).substring(10, 11).length() - 1), objArr12);
                            String str3 = (String) objArr12[0];
                            Object[] objArr13 = new Object[1];
                            a(super.getResources().getString(R.string.family_account_text_desc_resend).substring(0, 3).codePointAt(2) + 28, super.getResources().getString(R.string.activate_nfc).substring(8, 12).codePointAt(2) + 173, (char) (getPackageName().length() + 46549), objArr13);
                            String str4 = (String) objArr13[0];
                            try {
                                byte b4 = BuiltInFictitiousFunctionClassFactory[25];
                                Object[] objArr14 = new Object[1];
                                b(b4, b4, BuiltInFictitiousFunctionClassFactory[9], objArr14);
                                Class<?> cls6 = Class.forName((String) objArr14[0]);
                                b((byte) (-BuiltInFictitiousFunctionClassFactory[5]), BuiltInFictitiousFunctionClassFactory[27], BuiltInFictitiousFunctionClassFactory[59], new Object[1]);
                                Object[] objArr15 = new Object[1];
                                a(((ApplicationInfo) cls6.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 27, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 303, (char) (getPackageName().length() + 2227), objArr15);
                                try {
                                    Object[] objArr16 = {baseContext, str, str2, str3, str4, true, (String) objArr15[0], 995651014};
                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                    if (obj2 == null) {
                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getWindowTouchSlop() >> 8), 18 - Color.alpha(0), (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                    }
                                    ((Method) obj2).invoke(invoke, objArr16);
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
                Object[] objArr17 = new Object[1];
                b(BuiltInFictitiousFunctionClassFactory[32], (byte) (-BuiltInFictitiousFunctionClassFactory[30]), 36, objArr17);
                Class<?> cls7 = Class.forName((String) objArr17[0]);
                Object[] objArr18 = new Object[1];
                b((byte) (getAuthRequestContext << 2), (byte) (-BuiltInFictitiousFunctionClassFactory[30]), (byte) (BuiltInFictitiousFunctionClassFactory[35] - 1), objArr18);
                try {
                    Object[] objArr19 = {Integer.valueOf(((Integer) cls7.getMethod((String) objArr18[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls8 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 493, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 3, (char) ((-1) - Process.getGidForName("")));
                        Object[] objArr20 = new Object[1];
                        c($$a[8], (byte) ($$a[78] - 1), (byte) (-$$a[40]), objArr20);
                        obj3 = cls8.getMethod((String) objArr20[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr21 = (Object[]) ((Method) obj3).invoke(null, objArr19);
                    int i = ((int[]) objArr21[1])[0];
                    if (((int[]) objArr21[0])[0] != i) {
                        long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getLongPressTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - ExpandableListView.getPackedPositionType(0L), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr22 = {-686424141, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 17, (char) (Process.myPid() >> 22))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr22);
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
                    MonitorUtil.monitorOpenSchemeBack();
                    finish();
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

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.app.Activity
    protected void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            int length = super.getResources().getString(R.string.card_binding_onboarding_title).substring(1, 2).length() + 25;
            try {
                byte b = BuiltInFictitiousFunctionClassFactory[25];
                Object[] objArr = new Object[1];
                b(b, b, BuiltInFictitiousFunctionClassFactory[9], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                b((byte) (-BuiltInFictitiousFunctionClassFactory[5]), BuiltInFictitiousFunctionClassFactory[27], BuiltInFictitiousFunctionClassFactory[59], new Object[1]);
                Object[] objArr2 = new Object[1];
                a(length, ((ApplicationInfo) cls.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 10, (char) (super.getResources().getString(R.string.action_direction).substring(3, 4).length() - 1), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                a(19 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), getPackageName().codePointAt(6) - 48, (char) (getPackageName().codePointAt(5) - 110), objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - Color.green(0), (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), View.resolveSize(0, 0) + 18, (char) (ExpandableListView.getPackedPositionChild(0L) + 1))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.app.Activity
    protected void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            int i = 26 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1));
            int length = getPackageName().length() + 16;
            try {
                byte b = BuiltInFictitiousFunctionClassFactory[25];
                Object[] objArr = new Object[1];
                b(b, b, BuiltInFictitiousFunctionClassFactory[9], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                b((byte) (-BuiltInFictitiousFunctionClassFactory[5]), BuiltInFictitiousFunctionClassFactory[27], BuiltInFictitiousFunctionClassFactory[59], new Object[1]);
                Object[] objArr2 = new Object[1];
                a(i, length, (char) (((ApplicationInfo) cls.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 33), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                int length2 = super.getResources().getString(R.string.onboarding_permission_location_subtitle).substring(11, 17).length() + 12;
                int codePointAt = getPackageName().codePointAt(2) + 3;
                try {
                    byte b2 = BuiltInFictitiousFunctionClassFactory[25];
                    Object[] objArr3 = new Object[1];
                    b(b2, b2, BuiltInFictitiousFunctionClassFactory[9], objArr3);
                    Class<?> cls3 = Class.forName((String) objArr3[0]);
                    b((byte) (-BuiltInFictitiousFunctionClassFactory[5]), BuiltInFictitiousFunctionClassFactory[27], BuiltInFictitiousFunctionClassFactory[59], new Object[1]);
                    Object[] objArr4 = new Object[1];
                    a(length2, codePointAt, (char) (((ApplicationInfo) cls3.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 33), objArr4);
                    baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 930, 35 - ExpandableListView.getPackedPositionType(0L), (char) (ExpandableListView.getPackedPositionChild(0L) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + 912, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 17, (char) Color.red(0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr5);
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

    private static void a(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i) {
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (PlaceComponentResult[whenavailable.BuiltInFictitiousFunctionClassFactory + i2] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ KClassImpl$Data$declaredNonStaticMembers$2))) ^ c;
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
