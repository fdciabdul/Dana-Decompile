package com.alipay.mobile.verifyidentity.business.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.mobile.verifyidentity.base.LocalBroadcastCompt;
import com.alipay.mobile.verifyidentity.base.message.ProductConstants;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.Typography;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getCallingPid;

/* loaded from: classes7.dex */
public abstract class ProductActivity extends BaseActivity {
    private CreateProductReceiver createReceiver;
    public static final byte[] $$d = {Ascii.EM, 16, -94, Ascii.FS, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$e = 112;
    public static final byte[] getAuthRequestContext = {84, -107, -124, 66, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int PlaceComponentResult = 209;
    private static char getErrorConfigVersion = 42066;
    private static char[] BuiltInFictitiousFunctionClassFactory = {37275, 37366, 37252, 37308, 37306, 37286, 37311, 37249, 37367, 37279, 37307, 37291, 37255, 37368, 37302, 37260, 37292, 37293, 37365, 37370, 37248, 37372, 37274, 37371, 37369, 37263, 37290, 37310, 37294, 37288, 37262, 37287, 37261, 37283, 37254, 37309, 37375, 37280, 37251, 37281, 37305, 37373, 37345, 37374, 37250, 37289, 37282, 37253, 37344};

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void e(byte r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 + 97
            byte[] r0 = com.alipay.mobile.verifyidentity.business.activity.ProductActivity.getAuthRequestContext
            int r6 = r6 + 4
            int r8 = 23 - r8
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
            int r6 = r6 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r8) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            r4 = r0[r6]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L2e:
            int r8 = -r8
            int r7 = r7 + r8
            int r7 = r7 + (-4)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.verifyidentity.business.activity.ProductActivity.e(byte, int, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void f(short r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.alipay.mobile.verifyidentity.business.activity.ProductActivity.$$d
            int r8 = r8 * 2
            int r8 = 103 - r8
            int r7 = r7 + 4
            int r6 = r6 * 3
            int r6 = 42 - r6
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
            goto L37
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r7 = r7 + 1
            int r4 = r3 + 1
            if (r3 != r6) goto L2d
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2d:
            r3 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L37:
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
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.verifyidentity.business.activity.ProductActivity.f(short, byte, short, java.lang.Object[]):void");
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        d((byte) (98 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), new char[]{InputCardNumberView.DIVIDER, '#', 7, '\'', '(', 2, 7, '.', Typography.amp, 2, ',', 7, Typography.dollar, Typography.amp, 19, 23, 13898, 13898}, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 19, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        d((byte) (49 - TextUtils.getOffsetBefore("", 0)), new char[]{'*', 18, JSONLexer.EOI, 1, 13871}, (ViewConfiguration.getTouchSlop() >> 8) + 5, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0'), (KeyEvent.getMaxKeyCode() >> 16) + 35, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    d((byte) (57 - KeyEvent.keyCodeFromString("")), new char[]{'\t', 20, 22, '\n', '\'', '\b', '\b', 15, '\f', 27, 17, ',', 27, '(', '-', 22, 13796, 13796, 21, 31, '\t', 18, 17, 23, 7, 25, '\t', '\f', '\'', '\r', '!', 21, 3, 22, Typography.dollar, 6, '+', 3, 15, '+', '\n', '0', 24, 25, 14, 24, 25, 27}, 47 - MotionEvent.axisFromString(""), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    d((byte) (1 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), new char[]{'!', 14, 25, '\n', '+', 3, '+', 15, '\t', 18, 5, 15, '\b', '.', ',', 22, 13737, 13737, '.', ',', '\b', '.', 25, 22, 31, 24, 5, 22, '\t', '\f', 13737, 13737, 18, '\t', 22, '\t', 13818, 13818, '#', 22, 15, '(', 22, '/', 20, '\t', '0', '\b', 13738, 13738, '\b', 6, 6, '\b', '+', 1, '+', 1, 17, 18, 1, 15, 7, 25}, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 64, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    d((byte) (81 - Gravity.getAbsoluteGravity(0, 0)), new char[]{Typography.dollar, '0', 24, 19, 6, '\b', '%', 27, 13811, 13811, 15, 1, '*', 22, ')', '\b', '!', 21, 25, '\t', Typography.amp, 20, '#', 28, '\n', '0', '\b', 15, 13901, 13901, '\t', 20, 7, '\f', Typography.dollar, '\r', 20, '\n', 22, '\n', '\n', '+', ',', 22, 15, '+', 31, 14, '+', 3, 19, 23, Typography.dollar, '0', '/', 17, '\f', 20, 3, 22, '/', 17, 15, 5}, TextUtils.indexOf("", "", 0, 0) + 64, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    d((byte) (82 - TextUtils.indexOf((CharSequence) "", '0', 0)), new char[]{Typography.amp, 17, '\r', 3, 4, 17, 13832, 13832, 7, InputCardNumberView.DIVIDER, '#', InputCardNumberView.DIVIDER, '-', 7, 28, Typography.amp, 21, '!', '\t', 17, 31, 0, 7, '-', InputCardNumberView.DIVIDER, 1, '#', '*', '\n', 4, 25, 6, '#', '*', 21, '/', 23, ',', '/', '*', Typography.quote, 0, 6, '/', 4, '(', '!', 22, '\n', 17, '/', ')', '0', 6, '!', '/', 25, '(', 17, '\n'}, 59 - MotionEvent.axisFromString(""), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    d((byte) (124 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))), new char[]{0, '+', 21, ',', Typography.dollar, '0'}, 7 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getPressedStateDuration() >> 16), 18 - View.MeasureSpec.getSize(0), (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                e((byte) 36, (byte) (-getAuthRequestContext[32]), getAuthRequestContext[30], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                e(Ascii.NAK, (byte) (getAuthRequestContext[30] + 1), getAuthRequestContext[30], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 56, 3 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16));
                        Object[] objArr16 = new Object[1];
                        f($$d[31], $$d[47], $$d[12], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 800, Color.argb(0, 0, 0, 0) + 15, (char) Color.red(0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, 14 - TextUtils.lastIndexOf("", '0', 0, 0), (char) Color.red(0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - Drawable.resolveOpacity(0, 0), 30 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) ((Process.myTid() >> 22) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, 15 - TextUtils.indexOf("", "", 0), (char) (ViewConfiguration.getEdgeSlop() >> 16)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 34, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {709847069, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + 911, 18 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) Color.argb(0, 0, 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                e((byte) 36, (byte) (-getAuthRequestContext[32]), getAuthRequestContext[30], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                e(Ascii.NAK, (byte) (getAuthRequestContext[30] + 1), getAuthRequestContext[30], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.makeMeasureSpec(0, 0) + 61, TextUtils.lastIndexOf("", '0', 0, 0) + 47, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)));
                        Object[] objArr22 = new Object[1];
                        f($$d[8], $$d[28], (byte) ($$d[78] - 1), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollDefaultDelay() >> 16), TextUtils.getOffsetAfter("", 0) + 35, (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {709847069, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getTrimmedLength("") + 911, (ViewConfiguration.getTouchSlop() >> 8) + 18, (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                e((byte) 36, (byte) (-getAuthRequestContext[32]), getAuthRequestContext[30], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                e(Ascii.NAK, (byte) (getAuthRequestContext[30] + 1), getAuthRequestContext[30], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (ViewConfiguration.getLongPressTimeout() >> 16), AndroidCharacter.getMirror('0') - '-', (char) (38968 - (ViewConfiguration.getScrollDefaultDelay() >> 16)));
                        Object[] objArr28 = new Object[1];
                        f($$d[8], $$d[28], (byte) ($$d[78] - 1), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getOffsetAfter("", 0), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 35, (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {709847069, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + 911, 18 - TextUtils.getTrimmedLength(""), (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                e((byte) 36, (byte) (-getAuthRequestContext[32]), getAuthRequestContext[30], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                e(Ascii.NAK, (byte) (getAuthRequestContext[30] + 1), getAuthRequestContext[30], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 106, 3 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) KeyEvent.keyCodeFromString(""));
                        Object[] objArr34 = new Object[1];
                        f((byte) ($$d[78] - 1), (byte) (-$$d[40]), $$d[9], objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - TextUtils.indexOf("", ""), (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {709847069, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarSize() >> 8), 18 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            d((byte) (super.getResources().getString(R.string.title_scan_card_time_out).substring(7, 8).length() + 111), new char[]{InputCardNumberView.DIVIDER, '#', 7, '\'', '(', 2, 7, '.', Typography.quote, 0, 0, '0', '%', 23, '\f', 3, '/', '\f', 7, 17, 3, 28, '(', 21, InputCardNumberView.DIVIDER, 7}, View.combineMeasuredStates(0, 0) + 26, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            d((byte) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 98), new char[]{18, 2, 13898, 13898, 25, '(', '\t', 31, 13900, 13900, '(', '\f', 14, 30, '\f', 3, Typography.amp, '('}, super.getResources().getString(R.string.powered_by).substring(0, 10).length() + 8, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 35 - TextUtils.getTrimmedLength(""), (char) ExpandableListView.getPackedPositionType(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (Process.myPid() >> 22) + 18, (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            d((byte) (112 - TextUtils.getOffsetAfter("", 0)), new char[]{InputCardNumberView.DIVIDER, '#', 7, '\'', '(', 2, 7, '.', Typography.quote, 0, 0, '0', '%', 23, '\f', 3, '/', '\f', 7, 17, 3, 28, '(', 21, InputCardNumberView.DIVIDER, 7}, super.getResources().getString(R.string.all_friends_section_header).substring(6, 7).length() + 25, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            d((byte) (super.getResources().getString(R.string.installment_simulation_period).substring(0, 8).codePointAt(1) - 6), new char[]{18, 2, 13898, 13898, 25, '(', '\t', 31, 13900, 13900, '(', '\f', 14, 30, '\f', 3, Typography.amp, '('}, super.getResources().getString(R.string.general_maybe_later).substring(1, 2).length() + 17, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.alpha(0), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 35, (char) ((-1) - Process.getGidForName("")))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 911, 18 - TextUtils.getCapsMode("", 0, 0), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @Override // com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        d((byte) (super.getResources().getString(R.string.pushverify_invalid_session_message).substring(3, 4).length() + 96), new char[]{InputCardNumberView.DIVIDER, '#', 7, '\'', '(', 2, 7, '.', Typography.amp, 2, ',', 7, Typography.dollar, Typography.amp, 19, 23, 13898, 13898}, Color.green(0) + 18, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        d((byte) ((ViewConfiguration.getKeyRepeatDelay() >> 16) + 49), new char[]{'*', 18, JSONLexer.EOI, 1, 13871}, getPackageName().length() - 2, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                d((byte) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 111), new char[]{InputCardNumberView.DIVIDER, '#', 7, '\'', '(', 2, 7, '.', Typography.quote, 0, 0, '0', '%', 23, '\f', 3, '/', '\f', 7, 17, 3, 28, '(', 21, InputCardNumberView.DIVIDER, 7}, 26 - Color.blue(0), objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                byte codePointAt = (byte) (super.getResources().getString(R.string.how_to_error).substring(14, 16).codePointAt(1) + 66);
                char[] cArr = {18, 2, 13898, 13898, 25, '(', '\t', 31, 13900, 13900, '(', '\f', 14, 30, '\f', 3, Typography.amp, '('};
                try {
                    byte b = getAuthRequestContext[7];
                    byte b2 = getAuthRequestContext[25];
                    Object[] objArr5 = new Object[1];
                    e(b, b2, b2, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    e((byte) (-getAuthRequestContext[59]), getAuthRequestContext[5], getAuthRequestContext[41], new Object[1]);
                    Object[] objArr6 = new Object[1];
                    d(codePointAt, cArr, ((ApplicationInfo) cls3.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 15, objArr6);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), TextUtils.lastIndexOf("", '0') + 36, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    byte packedPositionChild = (byte) (56 - ExpandableListView.getPackedPositionChild(0L));
                    char[] cArr2 = {'\t', 20, 22, '\n', '\'', '\b', '\b', 15, '\f', 27, 17, ',', 27, '(', '-', 22, 13796, 13796, 21, 31, '\t', 18, 17, 23, 7, 25, '\t', '\f', '\'', '\r', '!', 21, 3, 22, Typography.dollar, 6, '+', 3, 15, '+', '\n', '0', 24, 25, 14, 24, 25, 27};
                    try {
                        byte b3 = getAuthRequestContext[7];
                        byte b4 = getAuthRequestContext[25];
                        Object[] objArr7 = new Object[1];
                        e(b3, b4, b4, objArr7);
                        Class<?> cls4 = Class.forName((String) objArr7[0]);
                        Object[] objArr8 = new Object[1];
                        e((byte) (-getAuthRequestContext[59]), getAuthRequestContext[5], getAuthRequestContext[41], objArr8);
                        Object[] objArr9 = new Object[1];
                        d(packedPositionChild, cArr2, ((ApplicationInfo) cls4.getMethod((String) objArr8[0], null).invoke(this, null)).targetSdkVersion + 15, objArr9);
                        String str = (String) objArr9[0];
                        try {
                            byte b5 = getAuthRequestContext[7];
                            byte b6 = getAuthRequestContext[25];
                            Object[] objArr10 = new Object[1];
                            e(b5, b6, b6, objArr10);
                            Class<?> cls5 = Class.forName((String) objArr10[0]);
                            e((byte) (-getAuthRequestContext[59]), getAuthRequestContext[5], getAuthRequestContext[41], new Object[1]);
                            Object[] objArr11 = new Object[1];
                            d((byte) (((ApplicationInfo) cls5.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 32), new char[]{'!', 14, 25, '\n', '+', 3, '+', 15, '\t', 18, 5, 15, '\b', '.', ',', 22, 13737, 13737, '.', ',', '\b', '.', 25, 22, 31, 24, 5, 22, '\t', '\f', 13737, 13737, 18, '\t', 22, '\t', 13818, 13818, '#', 22, 15, '(', 22, '/', 20, '\t', '0', '\b', 13738, 13738, '\b', 6, 6, '\b', '+', 1, '+', 1, 17, 18, 1, 15, 7, 25}, 64 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), objArr11);
                            String str2 = (String) objArr11[0];
                            Object[] objArr12 = new Object[1];
                            d((byte) (super.getResources().getString(R.string.unsafe_device_tamper_footer).substring(25, 30).length() + 76), new char[]{Typography.dollar, '0', 24, 19, 6, '\b', '%', 27, 13811, 13811, 15, 1, '*', 22, ')', '\b', '!', 21, 25, '\t', Typography.amp, 20, '#', 28, '\n', '0', '\b', 15, 13901, 13901, '\t', 20, 7, '\f', Typography.dollar, '\r', 20, '\n', 22, '\n', '\n', '+', ',', 22, 15, '+', 31, 14, '+', 3, 19, 23, Typography.dollar, '0', '/', 17, '\f', 20, 3, 22, '/', 17, 15, 5}, getPackageName().length() + 57, objArr12);
                            String str3 = (String) objArr12[0];
                            Object[] objArr13 = new Object[1];
                            d((byte) (getPackageName().codePointAt(5) - 27), new char[]{Typography.amp, 17, '\r', 3, 4, 17, 13832, 13832, 7, InputCardNumberView.DIVIDER, '#', InputCardNumberView.DIVIDER, '-', 7, 28, Typography.amp, 21, '!', '\t', 17, 31, 0, 7, '-', InputCardNumberView.DIVIDER, 1, '#', '*', '\n', 4, 25, 6, '#', '*', 21, '/', 23, ',', '/', '*', Typography.quote, 0, 6, '/', 4, '(', '!', 22, '\n', 17, '/', ')', '0', 6, '!', '/', 25, '(', 17, '\n'}, 60 - Gravity.getAbsoluteGravity(0, 0), objArr13);
                            String str4 = (String) objArr13[0];
                            Object[] objArr14 = new Object[1];
                            d((byte) (super.getResources().getString(R.string.toast_account_deactivation_success).substring(2, 3).length() + 123), new char[]{0, '+', 21, ',', Typography.dollar, '0'}, getPackageName().codePointAt(1) - 94, objArr14);
                            try {
                                Object[] objArr15 = {baseContext, str, str2, str3, str4, true, (String) objArr14[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 911, TextUtils.lastIndexOf("", '0') + 19, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
            e((byte) 36, (byte) (-getAuthRequestContext[32]), getAuthRequestContext[30], objArr16);
            Class<?> cls6 = Class.forName((String) objArr16[0]);
            Object[] objArr17 = new Object[1];
            e(Ascii.NAK, (byte) (getAuthRequestContext[30] + 1), getAuthRequestContext[30], objArr17);
            try {
                Object[] objArr18 = {Integer.valueOf(((Integer) cls6.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0, 0) + 495, ExpandableListView.getPackedPositionChild(0L) + 5, (char) View.resolveSize(0, 0));
                    Object[] objArr19 = new Object[1];
                    f((byte) ($$d[78] - 1), (byte) (-$$d[40]), $$d[9], objArr19);
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
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.alpha(0), 35 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) KeyEvent.getDeadChar(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr21 = {1162168810, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 863, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 17, (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                registerReceiver();
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

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ProductConstants.KEY_CREATE_PRODUCT);
        CreateProductReceiver createProductReceiver = new CreateProductReceiver();
        this.createReceiver = createProductReceiver;
        LocalBroadcastCompt.registerBroadcast(this, createProductReceiver, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class CreateProductReceiver extends BroadcastReceiver {
        private CreateProductReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(ProductConstants.KEY_CREATE_PRODUCT)) {
                ProductActivity.this.finish();
            }
        }
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        LocalBroadcastCompt.unregisterBroadcast(this, this.createReceiver);
        super.onDestroy();
    }

    private static void d(byte b, char[] cArr, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = BuiltInFictitiousFunctionClassFactory;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i3 = 0; i3 < length; i3++) {
                cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
            }
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ getErrorConfigVersion);
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
