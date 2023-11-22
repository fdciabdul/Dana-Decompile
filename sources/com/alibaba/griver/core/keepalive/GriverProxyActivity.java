package com.alibaba.griver.core.keepalive;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
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
import android.widget.LinearLayout;
import androidx.core.app.ActivityOptionsCompat;
import com.alibaba.ariver.integration.RVMain;
import com.alibaba.ariver.integration.ipc.server.RVAppRecord;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.Typography;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getCallingPid;

/* loaded from: classes3.dex */
public class GriverProxyActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private long f6425a;
    private boolean b;
    public static final byte[] $$a = {113, 46, 115, -60, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 244;
    public static final byte[] MyBillsEntityDataFactory = {37, 81, 122, 15, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int PlaceComponentResult = 7;
    private static char KClassImpl$Data$declaredNonStaticMembers$2 = 42066;
    private static char[] getAuthRequestContext = {37373, 37346, 37294, 37359, 37288, 37344, 37279, 37305, 37349, 37371, 37310, 37311, 37293, 37347, 37348, 37353, 37274, 37287, 37282, 37368, 37309, 37375, 37369, 37357, 37275, 37280, 37283, 37370, 37286, 37351, 37356, 37302, 37374, 37262, 37345, 37290, 37366, 37350, 37306, 37367, 37372, 37365, 37307, 37281, 37308, 37289, 37291, 37358, 37292};

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(int r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 + 97
            byte[] r0 = com.alibaba.griver.core.keepalive.GriverProxyActivity.MyBillsEntityDataFactory
            int r7 = r7 + 4
            int r8 = r8 + 16
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L14
            r9 = r7
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r8
            goto L2c
        L14:
            r3 = 0
        L15:
            byte r4 = (byte) r9
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r8) goto L24
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L24:
            r3 = r0[r7]
            r6 = r10
            r10 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L2c:
            int r7 = r7 + 1
            int r8 = -r8
            int r9 = r9 + r8
            int r9 = r9 + (-4)
            r8 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.keepalive.GriverProxyActivity.d(int, byte, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void e(short r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.alibaba.griver.core.keepalive.GriverProxyActivity.$$a
            int r6 = r6 * 2
            int r6 = 103 - r6
            int r8 = 46 - r8
            int r7 = r7 * 3
            int r7 = 42 - r7
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L36
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            int r8 = r8 + 1
            r3 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L36:
            int r7 = r7 + r6
            int r6 = r7 + (-7)
            r7 = r8
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.keepalive.GriverProxyActivity.e(short, byte, int, java.lang.Object[]):void");
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        c((byte) (68 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))), new char[]{1, ',', '0', 18, 21, InputCardNumberView.DIVIDER, '0', InputCardNumberView.DIVIDER, 23, '.', ')', '\r', 18, 27, '*', ')', 13869, 13869}, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 18, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        c((byte) (KeyEvent.keyCodeFromString("") + 117), new char[]{17, InputCardNumberView.DIVIDER, 14, 30, 13939}, 5 - (ViewConfiguration.getScrollBarSize() >> 8), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    c((byte) (99 - (ViewConfiguration.getScrollBarFadeDuration() >> 16)), new char[]{20, '/', 25, Typography.dollar, 25, '*', '%', '(', 14, '(', '*', '.', '*', 7, 29, 25, 13838, 13838, 23, 1, '/', '*', '+', 27, '/', '\'', '.', 4, 4, '*', 0, '%', '+', 29, 1, '#', '+', Typography.amp, '#', 25, 17, '/', '\b', 23, 19, '/', 21, Typography.dollar}, ExpandableListView.getPackedPositionGroup(0L) + 48, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    c((byte) (100 - Color.argb(0, 0, 0, 0)), new char[]{6, 23, 25, '+', '+', Typography.amp, 25, '#', '/', '*', ')', 22, 4, '\'', 30, 11, 13836, 13836, '.', 31, 4, '\'', JSONLexer.EOI, Typography.dollar, JSONLexer.EOI, '\b', '%', Typography.dollar, '.', 4, 13836, 13836, '*', '/', 11, '%', 13917, 13917, JSONLexer.EOI, '#', 21, 22, '\'', 28, '/', 20, '!', 18, 13837, 13837, 15, '(', '(', 15, 25, 28, 25, 28, '/', '\r', '\'', '.', '/', '\''}, 64 - Color.green(0), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    c((byte) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 96), new char[]{4, 28, '(', 7, '(', 15, 2, 7, 13826, 13826, '.', '\'', '!', '\'', JSONLexer.EOI, 14, 0, '%', 11, ',', 5, 7, 5, '%', 17, '/', '%', '(', 13916, 13916, 20, '/', 18, '/', 4, '#', 19, JSONLexer.EOI, 25, Typography.dollar, Typography.amp, '.', 30, 11, '#', 25, 5, '\t', '+', Typography.amp, '*', ')', 4, 28, '0', 24, 20, JSONLexer.EOI, '+', 29, '0', 24, 22, ')'}, KeyEvent.normalizeMetaState(0) + 64, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    c((byte) (Process.getGidForName("") + 80), new char[]{14, '-', '.', 7, '0', '%', 13828, 13828, ',', 4, ',', 1, 28, '0', 18, 14, '%', 0, '+', '*', '\t', 2, '0', 28, 3, '\'', 6, 16, '/', '-', 17, '-', 6, 16, ')', 28, '.', 27, 19, 4, 4, '\t', '!', 0, 29, '*', 0, '\'', '-', '+', 0, '\f', 1, 6, '*', 14, Typography.dollar, '*', '+', '-'}, KeyEvent.getDeadChar(0, 0) + 60, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    c((byte) (10 - ((Process.getThreadPriority(0) + 20) >> 6)), new char[]{')', 29, '\r', 30, 4, 28}, MotionEvent.axisFromString("") + 7, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getKeyRepeatDelay() >> 16), 18 - Color.alpha(0), (char) (AndroidCharacter.getMirror('0') - '0'))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                d(MyBillsEntityDataFactory[0], MyBillsEntityDataFactory[25], (byte) (-MyBillsEntityDataFactory[32]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = (byte) (-MyBillsEntityDataFactory[35]);
                byte b2 = MyBillsEntityDataFactory[25];
                Object[] objArr14 = new Object[1];
                d(b, b2, (byte) (b2 | 8), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - View.resolveSize(0, 0), 3 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) ((-1) - TextUtils.lastIndexOf("", '0')));
                        Object[] objArr16 = new Object[1];
                        e($$a[12], $$a[31], $$a[53], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, 15 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, 15 - (Process.myPid() >> 22), (char) Color.green(0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + 815, 28 - TextUtils.lastIndexOf("", '0'), (char) (57994 - TextUtils.getTrimmedLength("")))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + 800, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 16, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 36 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {120315730, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + 911, 18 - Gravity.getAbsoluteGravity(0, 0), (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                d(MyBillsEntityDataFactory[0], MyBillsEntityDataFactory[25], (byte) (-MyBillsEntityDataFactory[32]), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b3 = (byte) (-MyBillsEntityDataFactory[35]);
                byte b4 = MyBillsEntityDataFactory[25];
                Object[] objArr20 = new Object[1];
                d(b3, b4, (byte) (b4 | 8), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - Color.blue(0), (Process.myPid() >> 22) + 46, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)));
                        Object[] objArr22 = new Object[1];
                        e((byte) ($$a[78] - 1), $$a[8], $$a[84], objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.makeMeasureSpec(0, 0), 34 - TextUtils.lastIndexOf("", '0', 0), (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {120315730, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 912, (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 18, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                d(MyBillsEntityDataFactory[0], MyBillsEntityDataFactory[25], (byte) (-MyBillsEntityDataFactory[32]), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b5 = (byte) (-MyBillsEntityDataFactory[35]);
                byte b6 = MyBillsEntityDataFactory[25];
                Object[] objArr26 = new Object[1];
                d(b5, b6, (byte) (b6 | 8), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 118, 3 - Color.green(0), (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 38968));
                        Object[] objArr28 = new Object[1];
                        e((byte) ($$a[78] - 1), $$a[8], $$a[84], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0'), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 34, (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {120315730, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 18 - Color.red(0), (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                d(MyBillsEntityDataFactory[0], MyBillsEntityDataFactory[25], (byte) (-MyBillsEntityDataFactory[32]), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b7 = (byte) (-MyBillsEntityDataFactory[35]);
                byte b8 = MyBillsEntityDataFactory[25];
                Object[] objArr32 = new Object[1];
                d(b7, b8, (byte) (b8 | 8), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(155 - AndroidCharacter.getMirror('0'), 3 - KeyEvent.normalizeMetaState(0), (char) (ViewConfiguration.getWindowTouchSlop() >> 8));
                        byte b9 = $$a[9];
                        byte b10 = (byte) ($$a[78] - 1);
                        Object[] objArr34 = new Object[1];
                        e(b9, b10, b10, objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + PDF417Common.NUMBER_OF_CODEWORDS, Color.blue(0) + 35, (char) Color.blue(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {120315730, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 911, 19 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) (Color.rgb(0, 0, 0) + 16777216))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.app.Activity
    protected void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                Object[] objArr = new Object[1];
                d(MyBillsEntityDataFactory[25], (byte) PlaceComponentResult, MyBillsEntityDataFactory[25], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                d((byte) (MyBillsEntityDataFactory[49] - 1), MyBillsEntityDataFactory[8], MyBillsEntityDataFactory[5], objArr2);
                Object[] objArr3 = new Object[1];
                c((byte) (((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion + 33), new char[]{1, ',', '0', 18, 21, InputCardNumberView.DIVIDER, '0', InputCardNumberView.DIVIDER, 4, '\t', '\r', InputCardNumberView.DIVIDER, Typography.quote, '/', 0, '#', 14, '#', '-', 28, 31, 24, 14, ')', 4, ','}, 27 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                c((byte) (TextUtils.getTrimmedLength("") + 97), new char[]{'-', ')', 13897, 13897, Typography.dollar, '*', '/', 28, 13899, 13899, 21, '!', ',', 6, 0, '#', 22, '.'}, getPackageName().codePointAt(4) - 79, objArr4);
                baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.red(0), (ViewConfiguration.getTapTimeout() >> 16) + 35, (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 910, (ViewConfiguration.getLongPressTimeout() >> 16) + 18, (char) ('0' - AndroidCharacter.getMirror('0')))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
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
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        c((byte) (super.getResources().getString(R.string.wallet_search_empty_state_description).substring(13, 14).length() + 67), new char[]{1, ',', '0', 18, 21, InputCardNumberView.DIVIDER, '0', InputCardNumberView.DIVIDER, 23, '.', ')', '\r', 18, 27, '*', ')', 13869, 13869}, super.getResources().getString(R.string.qcb_title_th).substring(0, 19).codePointAt(9) - 14, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        try {
            Object[] objArr3 = new Object[1];
            d(MyBillsEntityDataFactory[25], (byte) PlaceComponentResult, MyBillsEntityDataFactory[25], objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            d((byte) (MyBillsEntityDataFactory[49] - 1), MyBillsEntityDataFactory[8], MyBillsEntityDataFactory[5], objArr4);
            Object[] objArr5 = new Object[1];
            c((byte) (((ApplicationInfo) cls2.getMethod((String) objArr4[0], null).invoke(this, null)).targetSdkVersion + 84), new char[]{17, InputCardNumberView.DIVIDER, 14, 30, 13939}, super.getResources().getString(R.string.error_visa_card_only).substring(25, 26).length() + 4, objArr5);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr6 = new Object[1];
                    c((byte) (super.getResources().getString(R.string.feed_introduction_third_description).substring(0, 1).codePointAt(0) - 3), new char[]{1, ',', '0', 18, 21, InputCardNumberView.DIVIDER, '0', InputCardNumberView.DIVIDER, 4, '\t', '\r', InputCardNumberView.DIVIDER, Typography.quote, '/', 0, '#', 14, '#', '-', 28, 31, 24, 14, ')', 4, ','}, 26 - KeyEvent.normalizeMetaState(0), objArr6);
                    Class<?> cls3 = Class.forName((String) objArr6[0]);
                    Object[] objArr7 = new Object[1];
                    c((byte) (getPackageName().length() + 90), new char[]{'-', ')', 13897, 13897, Typography.dollar, '*', '/', 28, 13899, 13899, 21, '!', ',', 6, 0, '#', 22, '.'}, getPackageName().codePointAt(2) - 28, objArr7);
                    baseContext = (Context) cls3.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, Color.blue(0) + 35, (char) TextUtils.indexOf("", "", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        byte scrollDefaultDelay = (byte) (99 - (ViewConfiguration.getScrollDefaultDelay() >> 16));
                        char[] cArr = {20, '/', 25, Typography.dollar, 25, '*', '%', '(', 14, '(', '*', '.', '*', 7, 29, 25, 13838, 13838, 23, 1, '/', '*', '+', 27, '/', '\'', '.', 4, 4, '*', 0, '%', '+', 29, 1, '#', '+', Typography.amp, '#', 25, 17, '/', '\b', 23, 19, '/', 21, Typography.dollar};
                        try {
                            Object[] objArr8 = new Object[1];
                            d(MyBillsEntityDataFactory[25], (byte) PlaceComponentResult, MyBillsEntityDataFactory[25], objArr8);
                            Class<?> cls4 = Class.forName((String) objArr8[0]);
                            Object[] objArr9 = new Object[1];
                            d((byte) (MyBillsEntityDataFactory[49] - 1), MyBillsEntityDataFactory[8], MyBillsEntityDataFactory[5], objArr9);
                            Object[] objArr10 = new Object[1];
                            c(scrollDefaultDelay, cArr, ((ApplicationInfo) cls4.getMethod((String) objArr9[0], null).invoke(this, null)).targetSdkVersion + 15, objArr10);
                            String str = (String) objArr10[0];
                            try {
                                Object[] objArr11 = new Object[1];
                                d(MyBillsEntityDataFactory[25], (byte) PlaceComponentResult, MyBillsEntityDataFactory[25], objArr11);
                                Class<?> cls5 = Class.forName((String) objArr11[0]);
                                Object[] objArr12 = new Object[1];
                                d((byte) (MyBillsEntityDataFactory[49] - 1), MyBillsEntityDataFactory[8], MyBillsEntityDataFactory[5], objArr12);
                                Object[] objArr13 = new Object[1];
                                c((byte) (((ApplicationInfo) cls5.getMethod((String) objArr12[0], null).invoke(this, null)).targetSdkVersion + 67), new char[]{6, 23, 25, '+', '+', Typography.amp, 25, '#', '/', '*', ')', 22, 4, '\'', 30, 11, 13836, 13836, '.', 31, 4, '\'', JSONLexer.EOI, Typography.dollar, JSONLexer.EOI, '\b', '%', Typography.dollar, '.', 4, 13836, 13836, '*', '/', 11, '%', 13917, 13917, JSONLexer.EOI, '#', 21, 22, '\'', 28, '/', 20, '!', 18, 13837, 13837, 15, '(', '(', 15, 25, 28, 25, 28, '/', '\r', '\'', '.', '/', '\''}, super.getResources().getString(R.string.lbl_face_auth_registration_info_footer).substring(9, 11).codePointAt(1) - 41, objArr13);
                                String str2 = (String) objArr13[0];
                                Object[] objArr14 = new Object[1];
                                c((byte) (super.getResources().getString(R.string.unstable_internet_network_title).substring(18, 21).length() + 93), new char[]{4, 28, '(', 7, '(', 15, 2, 7, 13826, 13826, '.', '\'', '!', '\'', JSONLexer.EOI, 14, 0, '%', 11, ',', 5, 7, 5, '%', 17, '/', '%', '(', 13916, 13916, 20, '/', 18, '/', 4, '#', 19, JSONLexer.EOI, 25, Typography.dollar, Typography.amp, '.', 30, 11, '#', 25, 5, '\t', '+', Typography.amp, '*', ')', 4, 28, '0', 24, 20, JSONLexer.EOI, '+', 29, '0', 24, 22, ')'}, getPackageName().length() + 57, objArr14);
                                String str3 = (String) objArr14[0];
                                Object[] objArr15 = new Object[1];
                                c((byte) (79 - Gravity.getAbsoluteGravity(0, 0)), new char[]{14, '-', '.', 7, '0', '%', 13828, 13828, ',', 4, ',', 1, 28, '0', 18, 14, '%', 0, '+', '*', '\t', 2, '0', 28, 3, '\'', 6, 16, '/', '-', 17, '-', 6, 16, ')', 28, '.', 27, 19, 4, 4, '\t', '!', 0, 29, '*', 0, '\'', '-', '+', 0, '\f', 1, 6, '*', 14, Typography.dollar, '*', '+', '-'}, super.getResources().getString(R.string.hint_form_bank_account_no).substring(19, 20).codePointAt(0) - 50, objArr15);
                                String str4 = (String) objArr15[0];
                                Object[] objArr16 = new Object[1];
                                c((byte) (getPackageName().codePointAt(0) - 95), new char[]{')', 29, '\r', 30, 4, 28}, super.getResources().getString(R.string.pocket_voucher_expired_in_date).substring(10, 15).codePointAt(2) - 43, objArr16);
                                try {
                                    Object[] objArr17 = {baseContext, str, str2, str3, str4, true, (String) objArr16[0], 995651014};
                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                    if (obj2 == null) {
                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + 911, TextUtils.indexOf((CharSequence) "", '0') + 19, (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                    }
                                    ((Method) obj2).invoke(invoke, objArr17);
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
                Object[] objArr18 = new Object[1];
                d(MyBillsEntityDataFactory[0], MyBillsEntityDataFactory[25], (byte) (-MyBillsEntityDataFactory[32]), objArr18);
                Class<?> cls6 = Class.forName((String) objArr18[0]);
                byte b = (byte) (-MyBillsEntityDataFactory[35]);
                byte b2 = MyBillsEntityDataFactory[25];
                Object[] objArr19 = new Object[1];
                d(b, b2, (byte) (b2 | 8), objArr19);
                try {
                    Object[] objArr20 = {Integer.valueOf(((Integer) cls6.getMethod((String) objArr19[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (Process.myPid() >> 22), 4 - TextUtils.getTrimmedLength(""), (char) (ViewConfiguration.getTapTimeout() >> 16));
                        byte b3 = $$a[9];
                        byte b4 = (byte) ($$a[78] - 1);
                        Object[] objArr21 = new Object[1];
                        e(b3, b4, b4, objArr21);
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
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + PDF417Common.NUMBER_OF_CODEWORDS, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 35, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr23 = {-1851556597, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myTid() >> 22) + 911, 18 - View.resolveSizeAndState(0, 0, 0), (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr23);
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
                    try {
                        Intent intent = getIntent();
                        if (intent == null) {
                            finish();
                            return;
                        }
                        Intent intent2 = (Intent) intent.getParcelableExtra("targetIntent");
                        if (intent2 != null) {
                            startActivity(intent2);
                            overridePendingTransition(com.alibaba.griver.core.R.anim.griver_core_app_enter_up_in, com.alibaba.griver.core.R.anim.griver_core_app_enter_scale);
                            long longExtra = intent.getLongExtra(KeepAliveConstants.KEY_CONTAINER_TOKEN, -1L);
                            this.f6425a = longExtra;
                            if (longExtra == -1) {
                                RVLogger.e("GriverProxyActivity", "proxyActivity onCreate fail no appId");
                                finish();
                                return;
                            }
                            KeepAliveAppManager.getInstance().addContainerToken(this.f6425a, this);
                            this.b = true;
                            LinearLayout linearLayout = new LinearLayout(this);
                            setContentView(linearLayout);
                            linearLayout.setOnTouchListener(new View.OnTouchListener() { // from class: com.alibaba.griver.core.keepalive.GriverProxyActivity.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    RVLogger.e("GriverProxyActivity", "proxyActivity onTouch to finish");
                                    GriverProxyActivity.this.finish();
                                    return false;
                                }
                            });
                            return;
                        }
                        RVLogger.e("GriverProxyActivity", "proxyActivity onCreate fail no targetIntent");
                        finish();
                    } catch (Exception unused) {
                        finish();
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

    @Override // android.app.Activity
    protected void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            c((byte) (super.getResources().getString(R.string.gn_title_jp).substring(0, 18).length() + 48), new char[]{1, ',', '0', 18, 21, InputCardNumberView.DIVIDER, '0', InputCardNumberView.DIVIDER, 4, '\t', '\r', InputCardNumberView.DIVIDER, Typography.quote, '/', 0, '#', 14, '#', '-', 28, 31, 24, 14, ')', 4, ','}, getPackageName().length() + 19, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            c((byte) (TextUtils.indexOf((CharSequence) "", '0', 0) + 98), new char[]{'-', ')', 13897, 13897, Typography.dollar, '*', '/', 28, 13899, 13899, 21, '!', ',', 6, 0, '#', 22, '.'}, super.getResources().getString(R.string.feed_sub_comment_sending).substring(0, 8).length() + 10, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.lastIndexOf("", '0') + 36, (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + 911, 18 - TextUtils.getOffsetAfter("", 0), (char) View.resolveSize(0, 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        try {
            if (!this.b) {
                long startTokenByToken = KeepAliveAppManager.getInstance().getStartTokenByToken(this.f6425a);
                if (startTokenByToken > 0) {
                    RVAppRecord appRecord = RVMain.getAppRecord(startTokenByToken);
                    if (appRecord == null) {
                        finish();
                        return;
                    } else if (!a(this, appRecord)) {
                        finish();
                        return;
                    } else {
                        RVLogger.d("GriverProxyActivity", "use proxyActivity to reShow app:");
                        return;
                    }
                }
                return;
            }
            this.b = false;
        } catch (Exception unused) {
            finish();
        }
    }

    private boolean a(Context context, RVAppRecord rVAppRecord) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(AkuEventParamsKey.KEY_ACTIVITY);
        if (activityManager == null) {
            return false;
        }
        activityManager.moveTaskToFront(rVAppRecord.getRunningTaskInfo().id, 0, ActivityOptionsCompat.PlaceComponentResult(context, 0, 0).MyBillsEntityDataFactory());
        return true;
    }

    private static void c(byte b, char[] cArr, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = getAuthRequestContext;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i3 = 0; i3 < length; i3++) {
                cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
            }
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ KClassImpl$Data$declaredNonStaticMembers$2);
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
