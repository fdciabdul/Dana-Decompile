package com.mixpanel.android.takeoverinapp;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
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
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import com.mixpanel.android.mpmetrics.InAppButton;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.mixpanel.android.mpmetrics.TakeoverInAppNotification;
import com.mixpanel.android.mpmetrics.UpdateDisplayState;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.util.ViewUtils;
import id.dana.R;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

/* loaded from: classes.dex */
public class TakeoverInAppActivity extends Activity {
    public static final String INTENT_ID_KEY = "com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.INTENT_ID_KEY";
    private int BuiltInFictitiousFunctionClassFactory = -1;
    private UpdateDisplayState KClassImpl$Data$declaredNonStaticMembers$2;
    private MixpanelAPI getAuthRequestContext;
    public static final byte[] $$a = {104, -34, -42, -1, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 68;
    public static final byte[] MyBillsEntityDataFactory = {Ascii.GS, SignedBytes.MAX_POWER_OF_TWO, 35, 67, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int PlaceComponentResult = 241;
    private static int[] moveToNextValue = {618889621, 83063980, -171915185, 1032932213, -278666118, 310906922, -12973247, -777630459, -575959611, -807384966, 1375731877, 1521206049, 366614663, 1043097397, -984783070, 1029755462, -954349370, 793845501};

    /* JADX WARN: Removed duplicated region for block: B:20:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0026 -> B:23:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r7, short r8, int r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 + 97
            int r9 = 56 - r9
            byte[] r0 = com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.MyBillsEntityDataFactory
            int r8 = 23 - r8
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L16
            r7 = r8
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L31
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L26
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L26:
            r3 = r0[r9]
            r5 = r8
            r8 = r7
            r7 = r5
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L31:
            int r8 = r8 + r9
            int r9 = r10 + 1
            int r8 = r8 + (-4)
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.b(byte, short, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0027 -> B:23:0x002f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r7, int r8, byte r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.$$a
            int r7 = r7 * 2
            int r7 = r7 + 75
            int r9 = r9 + 4
            int r8 = r8 * 3
            int r8 = 42 - r8
            byte[] r1 = new byte[r8]
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
            if (r4 != r8) goto L27
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L27:
            r3 = r0[r9]
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L2f:
            int r7 = r7 + r9
            int r9 = r10 + 1
            int r7 = r7 + (-7)
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.c(int, int, byte, java.lang.Object[]):void");
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 17, new int[]{-856832911, -505868054, 1527510533, 840774101, 778733218, -983064553, -1783744868, 691534367, -1397026397, -1415388222}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(KeyEvent.keyCodeFromString("") + 5, new int[]{48758759, 339937845, 1063099549, 1715580658}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, TextUtils.lastIndexOf("", '0') + 36, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(48 - View.combineMeasuredStates(0, 0), new int[]{-322589646, -313163695, -1858865950, -33504727, 1116595226, 1020614687, -116411965, -787158842, -156773340, -1116151740, -583768361, -1120160515, -2077052772, -587295970, -2006526404, 1417818539, 982346315, -294139968, 1237881866, 1540140094, 1207972506, 1349529294, 881375846, 236403222}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(65 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), new int[]{-1978192624, 1143628079, 582771314, 1882786453, 1746190025, 736764976, -1762844594, 2103832445, 1823898439, -1617109777, -1312214473, -899387732, 148632318, -891699353, 490191121, -1830601514, 1520121701, -1596146252, -832753879, 162281193, 2143160898, 397871221, 1699991937, 333792342, -1946599642, -1625588022, 1535818191, 1187970312, 29755591, 1965835076, -1731600239, -1339141956}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(63 - TextUtils.lastIndexOf("", '0', 0), new int[]{470267267, -1775390428, 511507617, 129290225, 1105400309, 832925074, -2090326420, -1732873044, 720012452, -128003123, 1769763939, 165591552, -1799126503, -2011490351, -1683475525, -517691150, 1131012158, 134025432, 472511739, 629902093, -290022473, -1341932393, 1194803561, -1549567712, -414006056, 137380121, -685979074, 59411054, 390616379, -1884849600, 1374494490, 859094182}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(TextUtils.getTrimmedLength("") + 60, new int[]{-1958441744, 1674360838, 1893615597, -819466055, -3860768, -175217742, 49055060, 1543745809, -2020635001, 449523152, -6339093, 1836531405, 1008315593, -1871352183, -2039308275, -533003541, -1948242380, -12601075, -1582191922, -170538664, -636452830, -88983283, -870375806, 1574468569, 894893683, -1973085184, 1650713053, -261906313, -590444161, 383624239}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(5 - TextUtils.indexOf((CharSequence) "", '0', 0), new int[]{1429070626, 1188320592, 1154116660, 2011033080}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ImageFormat.getBitsPerPixel(0), 18 - (ViewConfiguration.getTouchSlop() >> 8), (char) View.MeasureSpec.getMode(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b(MyBillsEntityDataFactory[32], (byte) (-MyBillsEntityDataFactory[30]), MyBillsEntityDataFactory[31], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b((byte) (MyBillsEntityDataFactory[32] - 1), (byte) (-MyBillsEntityDataFactory[30]), (byte) (MyBillsEntityDataFactory[0] + 1), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - TextUtils.indexOf("", "", 0, 0), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 4, (char) (ViewConfiguration.getWindowTouchSlop() >> 8));
                        Object[] objArr16 = new Object[1];
                        c($$a[78], $$a[31], (byte) ($$a[78] - 1), objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 15 - KeyEvent.normalizeMetaState(0), (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - TextUtils.getOffsetAfter("", 0), 15 - TextUtils.getOffsetBefore("", 0), (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + 815, 29 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (57994 - View.MeasureSpec.getSize(0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getScrollBarSize() >> 8), 15 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (ViewConfiguration.getJumpTapTimeout() >> 16)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - KeyEvent.normalizeMetaState(0), (char) ((-1) - TextUtils.lastIndexOf("", '0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {449281845, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 911, TextUtils.indexOf((CharSequence) "", '0', 0) + 19, (char) ((-16777216) - Color.rgb(0, 0, 0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(MyBillsEntityDataFactory[32], (byte) (-MyBillsEntityDataFactory[30]), MyBillsEntityDataFactory[31], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                b((byte) (MyBillsEntityDataFactory[32] - 1), (byte) (-MyBillsEntityDataFactory[30]), (byte) (MyBillsEntityDataFactory[0] + 1), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 61, ImageFormat.getBitsPerPixel(0) + 47, (char) TextUtils.indexOf("", "", 0));
                        byte b = $$a[9];
                        byte b2 = $$a[8];
                        Object[] objArr22 = new Object[1];
                        c(b, b2, (byte) (b2 | 16), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 34, (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {449281845, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", "", 0), KeyEvent.getDeadChar(0, 0) + 18, (char) Color.red(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(MyBillsEntityDataFactory[32], (byte) (-MyBillsEntityDataFactory[30]), MyBillsEntityDataFactory[31], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                b((byte) (MyBillsEntityDataFactory[32] - 1), (byte) (-MyBillsEntityDataFactory[30]), (byte) (MyBillsEntityDataFactory[0] + 1), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + 118, 3 - TextUtils.getOffsetAfter("", 0), (char) (38968 - View.resolveSizeAndState(0, 0, 0)));
                        byte b3 = $$a[9];
                        byte b4 = $$a[8];
                        Object[] objArr28 = new Object[1];
                        c(b3, b4, (byte) (b4 | 16), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {449281845, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.blue(0), 17 - ImageFormat.getBitsPerPixel(0), (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(MyBillsEntityDataFactory[32], (byte) (-MyBillsEntityDataFactory[30]), MyBillsEntityDataFactory[31], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                b((byte) (MyBillsEntityDataFactory[32] - 1), (byte) (-MyBillsEntityDataFactory[30]), (byte) (MyBillsEntityDataFactory[0] + 1), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 108, 3 - Drawable.resolveOpacity(0, 0), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)));
                        byte b5 = (byte) ($$a[78] - 1);
                        Object[] objArr34 = new Object[1];
                        c(b5, b5, $$a[53], objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.indexOf("", "") + 35, (char) (Color.rgb(0, 0, 0) + 16777216))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {449281845, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), View.MeasureSpec.getSize(0) + 18, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
    protected void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(getPackageName().length() + 19, new int[]{-856832911, -505868054, 1527510533, 840774101, 1023156608, 208903518, -317692519, -1053774284, 1219189519, -1262228705, 1999237808, 62783863, -1665086896, 1083833383}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(super.getResources().getString(R.string.error_brizzi_balance_reached_limit).substring(17, 18).length() + 17, new int[]{-805366391, -1519250095, 84167544, 399446780, -787959963, 248443641, -1380172919, -1305898064, -1623175329, 971674240}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - KeyEvent.getDeadChar(0, 0), 35 - View.resolveSizeAndState(0, 0, 0), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getWindowTouchSlop() >> 8), 17 - TextUtils.lastIndexOf("", '0', 0), (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // android.app.Activity
    protected void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a((-16777190) - Color.rgb(0, 0, 0), new int[]{-856832911, -505868054, 1527510533, 840774101, 1023156608, 208903518, -317692519, -1053774284, 1219189519, -1262228705, 1999237808, 62783863, -1665086896, 1083833383}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(19 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), new int[]{-805366391, -1519250095, 84167544, 399446780, -787959963, 248443641, -1380172919, -1305898064, -1623175329, 971674240}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 930, 35 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) TextUtils.indexOf("", "", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776305) - Color.rgb(0, 0, 0), 18 - Color.red(0), (char) (Process.myPid() >> 22))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        MixpanelAPI PlaceComponentResult2;
        int i;
        int i2;
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(super.getResources().getString(R.string.promo_discovery_error_network_description).substring(0, 1).codePointAt(0) - 49, new int[]{-856832911, -505868054, 1527510533, 840774101, 778733218, -983064553, -1783744868, 691534367, -1397026397, -1415388222}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(getPackageName().codePointAt(5) + BranchLinkConstant.DeepLinkErrorCode.SAME_ALIAS, new int[]{48758759, 339937845, 1063099549, 1715580658}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                a(super.getResources().getString(R.string.passkey_faq_two_title).substring(2, 3).length() + 25, new int[]{-856832911, -505868054, 1527510533, 840774101, 1023156608, 208903518, -317692519, -1053774284, 1219189519, -1262228705, 1999237808, 62783863, -1665086896, 1083833383}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                a(getPackageName().codePointAt(5) - 92, new int[]{-805366391, -1519250095, 84167544, 399446780, -787959963, 248443641, -1380172919, -1305898064, -1623175329, 971674240}, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getFadingEdgeLength() >> 16) + 35, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    a(47 - TextUtils.indexOf((CharSequence) "", '0'), new int[]{-322589646, -313163695, -1858865950, -33504727, 1116595226, 1020614687, -116411965, -787158842, -156773340, -1116151740, -583768361, -1120160515, -2077052772, -587295970, -2006526404, 1417818539, 982346315, -294139968, 1237881866, 1540140094, 1207972506, 1349529294, 881375846, 236403222}, objArr6);
                    String str = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    a(super.getResources().getString(R.string.card_binding_showcase_help_supported_card_content).substring(12, 14).codePointAt(1) + 32, new int[]{-1978192624, 1143628079, 582771314, 1882786453, 1746190025, 736764976, -1762844594, 2103832445, 1823898439, -1617109777, -1312214473, -899387732, 148632318, -891699353, 490191121, -1830601514, 1520121701, -1596146252, -832753879, 162281193, 2143160898, 397871221, 1699991937, 333792342, -1946599642, -1625588022, 1535818191, 1187970312, 29755591, 1965835076, -1731600239, -1339141956}, objArr7);
                    String str2 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 63, new int[]{470267267, -1775390428, 511507617, 129290225, 1105400309, 832925074, -2090326420, -1732873044, 720012452, -128003123, 1769763939, 165591552, -1799126503, -2011490351, -1683475525, -517691150, 1131012158, 134025432, 472511739, 629902093, -290022473, -1341932393, 1194803561, -1549567712, -414006056, 137380121, -685979074, 59411054, 390616379, -1884849600, 1374494490, 859094182}, objArr8);
                    String str3 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(getPackageName().codePointAt(0) - 45, new int[]{-1958441744, 1674360838, 1893615597, -819466055, -3860768, -175217742, 49055060, 1543745809, -2020635001, 449523152, -6339093, 1836531405, 1008315593, -1871352183, -2039308275, -533003541, -1948242380, -12601075, -1582191922, -170538664, -636452830, -88983283, -870375806, 1574468569, 894893683, -1973085184, 1650713053, -261906313, -590444161, 383624239}, objArr9);
                    String str4 = (String) objArr9[0];
                    try {
                        byte b = MyBillsEntityDataFactory[25];
                        byte b2 = b;
                        Object[] objArr10 = new Object[1];
                        b(b, b2, (byte) (b2 | TarHeader.LF_BLK), objArr10);
                        Class<?> cls3 = Class.forName((String) objArr10[0]);
                        b((byte) (-MyBillsEntityDataFactory[5]), MyBillsEntityDataFactory[27], MyBillsEntityDataFactory[25], new Object[1]);
                        Object[] objArr11 = new Object[1];
                        a(((ApplicationInfo) cls3.getMethod((String) r3[0], null).invoke(this, null)).targetSdkVersion - 27, new int[]{1429070626, 1188320592, 1154116660, 2011033080}, objArr11);
                        try {
                            Object[] objArr12 = {baseContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(959 - AndroidCharacter.getMirror('0'), 18 - Color.green(0), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
            Object[] objArr13 = new Object[1];
            b(MyBillsEntityDataFactory[32], (byte) (-MyBillsEntityDataFactory[30]), MyBillsEntityDataFactory[31], objArr13);
            Class<?> cls4 = Class.forName((String) objArr13[0]);
            Object[] objArr14 = new Object[1];
            b((byte) (MyBillsEntityDataFactory[32] - 1), (byte) (-MyBillsEntityDataFactory[30]), (byte) (MyBillsEntityDataFactory[0] + 1), objArr14);
            try {
                Object[] objArr15 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 494, (ViewConfiguration.getFadingEdgeLength() >> 16) + 4, (char) TextUtils.getOffsetBefore("", 0));
                    byte b3 = (byte) ($$a[78] - 1);
                    Object[] objArr16 = new Object[1];
                    c(b3, b3, $$a[53], objArr16);
                    obj3 = cls5.getMethod((String) objArr16[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr17 = (Object[]) ((Method) obj3).invoke(null, objArr15);
                int i3 = ((int[]) objArr17[1])[0];
                if (((int[]) objArr17[0])[0] != i3) {
                    long j = ((r0 ^ i3) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 930, (Process.myTid() >> 22) + 35, (char) TextUtils.indexOf("", "", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr18 = {-2120377246, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getLongPressTimeout() >> 16), View.MeasureSpec.getMode(0) + 18, (char) TextUtils.indexOf("", "", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr18);
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
                int intExtra = getIntent().getIntExtra(INTENT_ID_KEY, Integer.MAX_VALUE);
                this.BuiltInFictitiousFunctionClassFactory = intExtra;
                UpdateDisplayState MyBillsEntityDataFactory2 = UpdateDisplayState.MyBillsEntityDataFactory(intExtra);
                this.KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory2;
                if (MyBillsEntityDataFactory2 == null) {
                    MPLog.getAuthRequestContext("MixpanelAPI.TakeoverInAppActivity", "TakeoverInAppActivity intent received, but nothing was found to show.");
                    finish();
                    return;
                }
                PlaceComponentResult2 = MixpanelAPI.PlaceComponentResult(this, MyBillsEntityDataFactory2.PlaceComponentResult);
                this.getAuthRequestContext = PlaceComponentResult2;
                setContentView(com.mixpanel.android.R.layout.com_mixpanel_android_activity_notification_full);
                ImageView imageView = (ImageView) findViewById(com.mixpanel.android.R.id.com_mixpanel_android_notification_gradient);
                FadingImageView fadingImageView = (FadingImageView) findViewById(com.mixpanel.android.R.id.com_mixpanel_android_notification_image);
                TextView textView = (TextView) findViewById(com.mixpanel.android.R.id.res_0x7f0a04f6_networkuserentitydata_externalsyntheticlambda0);
                TextView textView2 = (TextView) findViewById(com.mixpanel.android.R.id.com_mixpanel_android_notification_subtext);
                ArrayList arrayList = new ArrayList();
                Button button = (Button) findViewById(com.mixpanel.android.R.id.com_mixpanel_android_notification_button);
                arrayList.add(button);
                arrayList.add((Button) findViewById(com.mixpanel.android.R.id.com_mixpanel_android_notification_second_button));
                LinearLayout linearLayout = (LinearLayout) findViewById(com.mixpanel.android.R.id.com_mixpanel_android_button_exit_wrapper);
                ImageView imageView2 = (ImageView) findViewById(com.mixpanel.android.R.id.com_mixpanel_android_image_close);
                final TakeoverInAppNotification takeoverInAppNotification = (TakeoverInAppNotification) ((UpdateDisplayState.DisplayState.InAppNotificationState) this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2).BuiltInFictitiousFunctionClassFactory;
                getWindowManager().getDefaultDisplay().getSize(new Point());
                if (getResources().getConfiguration().orientation == 1) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                    i = 0;
                    layoutParams.setMargins(0, 0, 0, (int) (r12.y * 0.06f));
                    linearLayout.setLayoutParams(layoutParams);
                } else {
                    i = 0;
                }
                fadingImageView.showShadow(takeoverInAppNotification.lookAheadTest());
                imageView.setBackgroundColor(takeoverInAppNotification.PlaceComponentResult);
                if (takeoverInAppNotification.scheduleImpl()) {
                    textView.setVisibility(i);
                    textView.setText(takeoverInAppNotification.NetworkUserEntityData$$ExternalSyntheticLambda1);
                    textView.setTextColor(takeoverInAppNotification.NetworkUserEntityData$$ExternalSyntheticLambda2);
                    i2 = 8;
                } else {
                    i2 = 8;
                    textView.setVisibility(8);
                }
                if (takeoverInAppNotification.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    textView2.setVisibility(i);
                    textView2.setText(takeoverInAppNotification.BuiltInFictitiousFunctionClassFactory);
                    textView2.setTextColor(takeoverInAppNotification.getAuthRequestContext);
                } else {
                    textView2.setVisibility(i2);
                }
                fadingImageView.setImageBitmap(takeoverInAppNotification.getErrorConfigVersion);
                final int i4 = 0;
                while (i4 < arrayList.size()) {
                    final InAppButton inAppButton = takeoverInAppNotification.moveToNextValue.size() > i4 ? takeoverInAppNotification.moveToNextValue.get(i4) : null;
                    Button button2 = (Button) arrayList.get(i4);
                    if (inAppButton != null) {
                        button2.setVisibility(0);
                        button2.setText(inAppButton.PlaceComponentResult);
                        button2.setTextColor(inAppButton.MyBillsEntityDataFactory);
                        button2.setTransformationMethod(null);
                        final GradientDrawable gradientDrawable = new GradientDrawable();
                        final int authRequestContext = inAppButton.BuiltInFictitiousFunctionClassFactory != 0 ? ViewUtils.getAuthRequestContext(inAppButton.BuiltInFictitiousFunctionClassFactory) : 864454278;
                        button2.setOnTouchListener(new View.OnTouchListener() { // from class: com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.2
                            {
                                TakeoverInAppActivity.this = this;
                            }

                            @Override // android.view.View.OnTouchListener
                            public boolean onTouch(View view, MotionEvent motionEvent) {
                                if (motionEvent.getAction() == 0) {
                                    gradientDrawable.setColor(authRequestContext);
                                    return false;
                                }
                                gradientDrawable.setColor(inAppButton.BuiltInFictitiousFunctionClassFactory);
                                return false;
                            }
                        });
                        gradientDrawable.setColor(inAppButton.BuiltInFictitiousFunctionClassFactory);
                        gradientDrawable.setStroke((int) ViewUtils.KClassImpl$Data$declaredNonStaticMembers$2(2.0f, this), inAppButton.getAuthRequestContext);
                        gradientDrawable.setCornerRadius((int) ViewUtils.KClassImpl$Data$declaredNonStaticMembers$2(5.0f, this));
                        if (Build.VERSION.SDK_INT < 16) {
                            button2.setBackgroundDrawable(gradientDrawable);
                        } else {
                            button2.setBackground(gradientDrawable);
                        }
                        button2.setOnClickListener(new View.OnClickListener() { // from class: com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.3
                            {
                                TakeoverInAppActivity.this = this;
                            }

                            /* JADX WARN: Removed duplicated region for block: B:78:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                            @Override // android.view.View.OnClickListener
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct code enable 'Show inconsistent code' option in preferences
                            */
                            public void onClick(android.view.View r6) {
                                /*
                                    r5 = this;
                                    com.mixpanel.android.mpmetrics.InAppButton r6 = r2
                                    java.lang.String r6 = r6.KClassImpl$Data$declaredNonStaticMembers$2
                                    r0 = 0
                                    java.lang.String r1 = "MixpanelAPI.TakeoverInAppActivity"
                                    if (r6 == 0) goto L3f
                                    int r2 = r6.length()
                                    if (r2 <= 0) goto L3f
                                    android.net.Uri r2 = android.net.Uri.parse(r6)     // Catch: java.lang.IllegalArgumentException -> L38
                                    android.content.Intent r3 = new android.content.Intent     // Catch: android.content.ActivityNotFoundException -> L20
                                    java.lang.String r4 = "android.intent.action.VIEW"
                                    r3.<init>(r4, r2)     // Catch: android.content.ActivityNotFoundException -> L20
                                    com.mixpanel.android.takeoverinapp.TakeoverInAppActivity r2 = com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.this     // Catch: android.content.ActivityNotFoundException -> L20
                                    r2.startActivity(r3)     // Catch: android.content.ActivityNotFoundException -> L20
                                    goto L25
                                L20:
                                    java.lang.String r2 = "User doesn't have an activity for notification URI"
                                    com.mixpanel.android.util.MPLog.MyBillsEntityDataFactory(r1, r2)
                                L25:
                                    org.json.JSONObject r2 = new org.json.JSONObject     // Catch: org.json.JSONException -> L32
                                    r2.<init>()     // Catch: org.json.JSONException -> L32
                                    java.lang.String r0 = "url"
                                    r2.put(r0, r6)     // Catch: org.json.JSONException -> L31
                                    r0 = r2
                                    goto L3f
                                L31:
                                    r0 = r2
                                L32:
                                    java.lang.String r6 = "Can't put url into json properties"
                                    com.mixpanel.android.util.MPLog.getAuthRequestContext(r1, r6)
                                    goto L3f
                                L38:
                                    r6 = move-exception
                                    java.lang.String r0 = "Can't parse notification URI, will not take any action"
                                    com.mixpanel.android.util.MPLog.PlaceComponentResult(r1, r0, r6)
                                    return
                                L3f:
                                    com.mixpanel.android.mpmetrics.InAppNotification r6 = r3
                                    com.mixpanel.android.mpmetrics.TakeoverInAppNotification r6 = (com.mixpanel.android.mpmetrics.TakeoverInAppNotification) r6
                                    java.util.ArrayList<com.mixpanel.android.mpmetrics.InAppButton> r6 = r6.moveToNextValue
                                    int r6 = r6.size()
                                    r2 = 2
                                    if (r6 != r2) goto L53
                                    int r6 = r4
                                    if (r6 != 0) goto L53
                                    java.lang.String r6 = "secondary"
                                    goto L55
                                L53:
                                    java.lang.String r6 = "primary"
                                L55:
                                    if (r0 != 0) goto L5d
                                    org.json.JSONObject r2 = new org.json.JSONObject     // Catch: org.json.JSONException -> L63
                                    r2.<init>()     // Catch: org.json.JSONException -> L63
                                    r0 = r2
                                L5d:
                                    java.lang.String r2 = "button"
                                    r0.put(r2, r6)     // Catch: org.json.JSONException -> L63
                                    goto L68
                                L63:
                                    java.lang.String r6 = "Can't put button type into json properties"
                                    com.mixpanel.android.util.MPLog.getAuthRequestContext(r1, r6)
                                L68:
                                    com.mixpanel.android.takeoverinapp.TakeoverInAppActivity r6 = com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.this
                                    com.mixpanel.android.mpmetrics.MixpanelAPI r6 = com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.access$100(r6)
                                    com.mixpanel.android.mpmetrics.MixpanelAPI$PeopleImpl r6 = r6.scheduleImpl
                                    com.mixpanel.android.mpmetrics.InAppNotification r1 = r3
                                    java.lang.String r2 = "$campaign_open"
                                    r6.KClassImpl$Data$declaredNonStaticMembers$2(r2, r1, r0)
                                    com.mixpanel.android.takeoverinapp.TakeoverInAppActivity r6 = com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.this
                                    r6.finish()
                                    com.mixpanel.android.takeoverinapp.TakeoverInAppActivity r6 = com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.this
                                    int r6 = com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.access$000(r6)
                                    com.mixpanel.android.mpmetrics.UpdateDisplayState.BuiltInFictitiousFunctionClassFactory(r6)
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.AnonymousClass3.onClick(android.view.View):void");
                            }
                        });
                    } else {
                        button2.setVisibility(8);
                    }
                    i4++;
                }
                if (takeoverInAppNotification.moveToNextValue.size() == 1) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    button.setLayoutParams(layoutParams2);
                }
                imageView2.setColorFilter(takeoverInAppNotification.DatabaseTableConfigUtil);
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.1
                    {
                        TakeoverInAppActivity.this = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TakeoverInAppActivity.this.finish();
                        UpdateDisplayState.BuiltInFictitiousFunctionClassFactory(TakeoverInAppActivity.this.BuiltInFictitiousFunctionClassFactory);
                    }
                });
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.95f, 1.0f, 0.95f, 1.0f, 1, 0.5f, 1, 1.0f);
                scaleAnimation.setDuration(200L);
                fadingImageView.startAnimation(scaleAnimation);
                TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.5f, 1, 0.0f);
                translateAnimation.setInterpolator(new DecelerateInterpolator());
                translateAnimation.setDuration(200L);
                textView.startAnimation(translateAnimation);
                textView2.startAnimation(translateAnimation);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((Button) it.next()).startAnimation(translateAnimation);
                }
                linearLayout.startAnimation(AnimationUtils.loadAnimation(this, com.mixpanel.android.R.anim.res_0x7f010024_kclassimpl_data_declarednonstaticmembers_2));
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
    public void onBackPressed() {
        UpdateDisplayState.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory);
        super.onBackPressed();
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = moveToNextValue;
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
        int[] iArr5 = moveToNextValue;
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
