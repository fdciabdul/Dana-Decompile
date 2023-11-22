package com.mixpanel.android.mpmetrics;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.net.Uri;
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
import android.webkit.URLUtil;
import android.widget.ExpandableListView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import com.iap.ac.android.acs.plugin.downgrade.constant.ApiDowngradeConstant;
import com.mixpanel.android.mpmetrics.MixpanelNotificationData;
import com.mixpanel.android.util.MPLog;
import id.dana.R;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.Typography;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getCallingPid;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MixpanelNotificationRouteActivity extends Activity {
    protected final String LOGTAG = "MixpanelAPI.MixpanelNotificationRouteActivity";
    public static final byte[] $$a = {83, 16, 71, 115, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 187;
    public static final byte[] MyBillsEntityDataFactory = {112, -20, -94, -81, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int getAuthRequestContext = 56;
    private static char PlaceComponentResult = 42066;
    private static char[] BuiltInFictitiousFunctionClassFactory = {37368, 37350, 37291, 37374, 37367, 37358, 37306, 37371, 37370, 37311, 37282, 37286, 37309, 37349, 37262, 37292, 37356, 37302, 37375, 37290, 37373, 37279, 37369, 37365, 37293, 37346, 37287, 37357, 37289, 37283, 37351, 37344, 37274, 37281, 37348, 37310, 37345, 37308, 37372, 37275, 37353, 37307, 37288, 37294, 37366, 37347, 37280, 37305, 37359};

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = 55 - r7
            byte[] r0 = com.mixpanel.android.mpmetrics.MixpanelNotificationRouteActivity.MyBillsEntityDataFactory
            int r8 = 23 - r8
            int r6 = r6 + 97
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
            int r8 = -r8
            int r6 = r6 + r8
            int r6 = r6 + (-4)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.MixpanelNotificationRouteActivity.b(byte, short, byte, java.lang.Object[]):void");
    }

    private static void c(short s, short s2, short s3, Object[] objArr) {
        int i = 42 - (s2 * 3);
        int i2 = 103 - (s * 2);
        byte[] bArr = $$a;
        int i3 = s3 + 4;
        byte[] bArr2 = new byte[i];
        int i4 = -1;
        int i5 = i - 1;
        if (bArr == null) {
            i3++;
            i2 = (i3 + (-i2)) - 7;
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
            Object[] objArr2 = objArr;
            byte[] bArr3 = bArr2;
            byte[] bArr4 = bArr;
            i3++;
            i2 = (i2 + (-bArr[i3])) - 7;
            objArr = objArr2;
            bArr = bArr4;
            bArr2 = bArr3;
            i4 = i6;
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
        a((byte) (88 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), new char[]{'/', 29, 5, '\t', 4, 18, 1, '%', ',', '\'', '#', 22, 11, '/', 16, 20, 13888, 13888}, 17 - ExpandableListView.getPackedPositionChild(0L), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a((byte) (ExpandableListView.getPackedPositionType(0L) + 60), new char[]{17, 24, '\'', 18, 13882}, (KeyEvent.getMaxKeyCode() >> 16) + 5, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.getMode(0), 34 - TextUtils.lastIndexOf("", '0'), (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a((byte) (25 - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), new char[]{1, 14, 25, 1, 16, 4, '.', 2, 5, 14, 14, 29, 20, 14, 1, 24, 13765, 13765, 29, 1, 1, 16, 22, 29, 3, '%', 5, 3, 16, 6, '/', 15, '+', 23, 16, '0', 30, '*', 11, 25, 7, '#', '\b', 21, 31, '-', JSONLexer.EOI, 15}, 48 - (ViewConfiguration.getTouchSlop() >> 8), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a((byte) ((-16777122) - Color.rgb(0, 0, 0)), new char[]{1, 15, 23, 1, 30, '*', 25, 11, 1, 16, '+', '\t', 3, 4, 0, '\n', 13830, 13830, 31, 0, 3, 4, 24, Typography.dollar, 23, 25, '/', 16, 5, 3, 13830, 13830, 16, 1, 11, 0, 13911, 13911, 17, '\'', 11, 15, 17, 5, 14, 1, 4, 1, 13831, 13831, 2, '*', '*', 2, 17, 4, 17, 4, 17, 22, 4, 5, 3, '%'}, View.MeasureSpec.getMode(0) + 64, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a((byte) (32 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), new char[]{17, 6, 17, JSONLexer.EOI, '*', 2, 14, '\r', 13762, 13762, 5, 4, '\n', '-', 14, 4, '/', 15, '\t', 0, 17, 27, '-', Typography.dollar, 7, '#', '.', 2, 13852, 13852, 1, 14, 1, 3, 18, 6, 21, 3, 25, 1, 0, InputCardNumberView.DIVIDER, 0, '\n', 11, 25, '-', 22, 30, '*', 16, 20, 17, 6, 29, 7, 1, 7, '+', 23, 29, 7, '\t', '+'}, 64 - KeyEvent.keyCodeFromString(""), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a((byte) (116 - ExpandableListView.getPackedPositionGroup(0L)), new char[]{27, '(', '%', '\r', ',', 30, 13865, 13865, 1, ',', 29, '/', '%', '#', '!', 19, 15, '/', Typography.dollar, 20, ',', Typography.dollar, '#', '%', '0', 0, '/', '\b', '\t', ',', ')', 0, '/', '\b', 15, '(', 18, '+', 17, Typography.amp, ',', '\b', '\n', InputCardNumberView.DIVIDER, '\f', InputCardNumberView.DIVIDER, '/', 14, Typography.amp, '#', '!', '-', 17, Typography.quote, JSONLexer.EOI, 5, JSONLexer.EOI, '(', '#', Typography.amp}, 60 - ExpandableListView.getPackedPositionGroup(0L), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a((byte) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 113), new char[]{'+', '%', '\b', '#', 17, 6}, 5 - ImageFormat.getBitsPerPixel(0), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18, (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b((byte) (-MyBillsEntityDataFactory[32]), (byte) (-MyBillsEntityDataFactory[31]), MyBillsEntityDataFactory[30], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = (byte) (getAuthRequestContext & 14);
                Object[] objArr14 = new Object[1];
                b(b, (byte) (b | 22), MyBillsEntityDataFactory[30], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.argb(0, 0, 0, 0) + 55, AndroidCharacter.getMirror('0') - '-', (char) View.MeasureSpec.getSize(0));
                        Object[] objArr16 = new Object[1];
                        c((byte) (-$$a[12]), $$a[68], (byte) ($$a[47] - 1), objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 800, 15 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) (ExpandableListView.getPackedPositionChild(0L) + 1))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getLongPressTimeout() >> 16), 15 - Gravity.getAbsoluteGravity(0, 0), (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + 815, (-16777187) - Color.rgb(0, 0, 0), (char) ((-16719222) - Color.rgb(0, 0, 0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (ViewConfiguration.getEdgeSlop() >> 16) + 15, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, Color.argb(0, 0, 0, 0) + 35, (char) Color.argb(0, 0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-587264853, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (KeyEvent.getMaxKeyCode() >> 16), 19 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-MyBillsEntityDataFactory[32]), (byte) (-MyBillsEntityDataFactory[31]), MyBillsEntityDataFactory[30], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b2 = (byte) (getAuthRequestContext & 14);
                Object[] objArr20 = new Object[1];
                b(b2, (byte) (b2 | 22), MyBillsEntityDataFactory[30], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(62 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 46 - (Process.myPid() >> 22), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)));
                        byte b3 = (byte) ($$a[47] - 1);
                        byte b4 = (byte) (-$$a[8]);
                        Object[] objArr22 = new Object[1];
                        c(b3, b4, (byte) (b4 | 16), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getLongPressTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - ExpandableListView.getPackedPositionChild(0L), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-587264853, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getWindowTouchSlop() >> 8), 18 - (Process.myTid() >> 22), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-MyBillsEntityDataFactory[32]), (byte) (-MyBillsEntityDataFactory[31]), MyBillsEntityDataFactory[30], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b5 = (byte) (getAuthRequestContext & 14);
                Object[] objArr26 = new Object[1];
                b(b5, (byte) (b5 | 22), MyBillsEntityDataFactory[30], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myTid() >> 22) + 118, (Process.myTid() >> 22) + 3, (char) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 38968));
                        byte b6 = (byte) ($$a[47] - 1);
                        byte b7 = (byte) (-$$a[8]);
                        Object[] objArr28 = new Object[1];
                        c(b6, b7, (byte) (b7 | 16), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myPid() >> 22) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) ExpandableListView.getPackedPositionType(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-587264853, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0', 0, 0), 18 - TextUtils.getOffsetBefore("", 0), (char) TextUtils.getOffsetBefore("", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-MyBillsEntityDataFactory[32]), (byte) (-MyBillsEntityDataFactory[31]), MyBillsEntityDataFactory[30], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b8 = (byte) (getAuthRequestContext & 14);
                Object[] objArr32 = new Object[1];
                b(b8, (byte) (b8 | 22), MyBillsEntityDataFactory[30], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (ViewConfiguration.getJumpTapTimeout() >> 16) + 3, (char) Gravity.getAbsoluteGravity(0, 0));
                        Object[] objArr34 = new Object[1];
                        c((byte) (-$$a[9]), (byte) ($$a[47] - 1), (byte) (-$$a[53]), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 35 - ExpandableListView.getPackedPositionType(0L), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-587264853, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 911, 18 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
            Object[] objArr = new Object[1];
            a((byte) ('U' - AndroidCharacter.getMirror('0')), new char[]{'/', 29, 5, '\t', 4, 18, 1, '%', ',', '\b', '\b', '%', 15, 16, '\'', '\r', '.', '\f', Typography.amp, 20, '(', 25, 19, JSONLexer.EOI, ',', 1}, (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 25, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                byte b = MyBillsEntityDataFactory[25];
                Object[] objArr2 = new Object[1];
                b(b, (byte) (b | TarHeader.LF_BLK), MyBillsEntityDataFactory[25], objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b(MyBillsEntityDataFactory[5], MyBillsEntityDataFactory[25], MyBillsEntityDataFactory[41], objArr3);
                Object[] objArr4 = new Object[1];
                a((byte) (((ApplicationInfo) cls2.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 69), new char[]{20, 1, 13902, 13902, JSONLexer.EOI, '(', '#', 20, 13904, 13904, InputCardNumberView.DIVIDER, '\b', 22, 1, '\'', '\r', '/', InputCardNumberView.DIVIDER}, super.getResources().getString(R.string.my_bills_leave_edit_bills_dialog_confirmation_title_description).substring(7, 8).codePointAt(0) - 79, objArr4);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Drawable.resolveOpacity(0, 0), 34 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 910, 18 - TextUtils.indexOf("", "", 0), (char) Color.red(0))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.app.Activity
    protected void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a((byte) (36 - TextUtils.indexOf((CharSequence) "", '0')), new char[]{'/', 29, 5, '\t', 4, 18, 1, '%', ',', '\b', '\b', '%', 15, 16, '\'', '\r', '.', '\f', Typography.amp, 20, '(', 25, 19, JSONLexer.EOI, ',', 1}, 26 - Color.blue(0), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a((byte) (getPackageName().codePointAt(2) + 56), new char[]{20, 1, 13902, 13902, JSONLexer.EOI, '(', '#', 20, 13904, 13904, InputCardNumberView.DIVIDER, '\b', 22, 1, '\'', '\r', '/', InputCardNumberView.DIVIDER}, super.getResources().getString(R.string.payment_processing).substring(0, 1).length() + 17, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - TextUtils.indexOf((CharSequence) "", '0'), (char) (Process.myTid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 911, 18 - Color.argb(0, 0, 0, 0), (char) (Process.myPid() >> 22))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        Object[] objArr = new Object[1];
        a((byte) (88 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), new char[]{'/', 29, 5, '\t', 4, 18, 1, '%', ',', '\'', '#', 22, 11, '/', 16, 20, 13888, 13888}, super.getResources().getString(R.string.app_update_fail_subtitle).substring(16, 17).length() + 17, objArr);
        Class<?> cls = Class.forName((String) objArr[0]);
        try {
            byte b = MyBillsEntityDataFactory[25];
            Object[] objArr2 = new Object[1];
            b(b, (byte) (b | TarHeader.LF_BLK), MyBillsEntityDataFactory[25], objArr2);
            Class<?> cls2 = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            b(MyBillsEntityDataFactory[5], MyBillsEntityDataFactory[25], MyBillsEntityDataFactory[41], objArr3);
            Object[] objArr4 = new Object[1];
            a((byte) (((ApplicationInfo) cls2.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 27), new char[]{17, 24, '\'', 18, 13882}, AndroidCharacter.getMirror('0') - '+', objArr4);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr5 = new Object[1];
                    a((byte) (TextUtils.getOffsetAfter("", 0) + 37), new char[]{'/', 29, 5, '\t', 4, 18, 1, '%', ',', '\b', '\b', '%', 15, 16, '\'', '\r', '.', '\f', Typography.amp, 20, '(', 25, 19, JSONLexer.EOI, ',', 1}, (Process.myPid() >> 22) + 26, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    a((byte) (getPackageName().codePointAt(3) + 2), new char[]{20, 1, 13902, 13902, JSONLexer.EOI, '(', '#', 20, 13904, 13904, InputCardNumberView.DIVIDER, '\b', 22, 1, '\'', '\r', '/', InputCardNumberView.DIVIDER}, super.getResources().getString(R.string.error_description_failed_inquiry_balance).substring(19, 21).codePointAt(1) - 14, objArr6);
                    baseContext = (Context) cls3.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - TextUtils.indexOf("", "", 0), (char) (Process.getGidForName("") + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        a((byte) (super.getResources().getString(R.string.copy_ktp_data_msg).substring(0, 3).codePointAt(1) - 89), new char[]{1, 14, 25, 1, 16, 4, '.', 2, 5, 14, 14, 29, 20, 14, 1, 24, 13765, 13765, 29, 1, 1, 16, 22, 29, 3, '%', 5, 3, 16, 6, '/', 15, '+', 23, 16, '0', 30, '*', 11, 25, 7, '#', '\b', 21, 31, '-', JSONLexer.EOI, 15}, super.getResources().getString(R.string.transfer_account_status_subtitle_success).substring(3, 4).codePointAt(0) - 49, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        a((byte) (super.getResources().getString(R.string.mybills_detail_label_participant_name).substring(1, 2).length() + 93), new char[]{1, 15, 23, 1, 30, '*', 25, 11, 1, 16, '+', '\t', 3, 4, 0, '\n', 13830, 13830, 31, 0, 3, 4, 24, Typography.dollar, 23, 25, '/', 16, 5, 3, 13830, 13830, 16, 1, 11, 0, 13911, 13911, 17, '\'', 11, 15, 17, 5, 14, 1, 4, 1, 13831, 13831, 2, '*', '*', 2, 17, 4, 17, 4, 17, 22, 4, 5, 3, '%'}, super.getResources().getString(R.string.invest).substring(0, 6).length() + 58, objArr8);
                        String str2 = (String) objArr8[0];
                        try {
                            byte b2 = MyBillsEntityDataFactory[25];
                            Object[] objArr9 = new Object[1];
                            b(b2, (byte) (b2 | TarHeader.LF_BLK), MyBillsEntityDataFactory[25], objArr9);
                            Class<?> cls4 = Class.forName((String) objArr9[0]);
                            b(MyBillsEntityDataFactory[5], MyBillsEntityDataFactory[25], MyBillsEntityDataFactory[41], new Object[1]);
                            Object[] objArr10 = new Object[1];
                            a((byte) (((ApplicationInfo) cls4.getMethod((String) r5[0], null).invoke(this, null)).targetSdkVersion - 1), new char[]{17, 6, 17, JSONLexer.EOI, '*', 2, 14, '\r', 13762, 13762, 5, 4, '\n', '-', 14, 4, '/', 15, '\t', 0, 17, 27, '-', Typography.dollar, 7, '#', '.', 2, 13852, 13852, 1, 14, 1, 3, 18, 6, 21, 3, 25, 1, 0, InputCardNumberView.DIVIDER, 0, '\n', 11, 25, '-', 22, 30, '*', 16, 20, 17, 6, 29, 7, 1, 7, '+', 23, 29, 7, '\t', '+'}, 64 - View.MeasureSpec.getSize(0), objArr10);
                            String str3 = (String) objArr10[0];
                            Object[] objArr11 = new Object[1];
                            a((byte) ((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 116), new char[]{27, '(', '%', '\r', ',', 30, 13865, 13865, 1, ',', 29, '/', '%', '#', '!', 19, 15, '/', Typography.dollar, 20, ',', Typography.dollar, '#', '%', '0', 0, '/', '\b', '\t', ',', ')', 0, '/', '\b', 15, '(', 18, '+', 17, Typography.amp, ',', '\b', '\n', InputCardNumberView.DIVIDER, '\f', InputCardNumberView.DIVIDER, '/', 14, Typography.amp, '#', '!', '-', 17, Typography.quote, JSONLexer.EOI, 5, JSONLexer.EOI, '(', '#', Typography.amp}, super.getResources().getString(R.string.mybills_tooltip_description_gn_merchant).substring(34, 36).codePointAt(1) - 41, objArr11);
                            String str4 = (String) objArr11[0];
                            Object[] objArr12 = new Object[1];
                            a((byte) (super.getResources().getString(R.string.merchant_info_twenty_four_hour_value).substring(0, 3).length() + 110), new char[]{'+', '%', '\b', '#', 17, 6}, Color.blue(0) + 6, objArr12);
                            try {
                                Object[] objArr13 = {baseContext, str, str2, str3, str4, true, (String) objArr12[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.green(0), View.combineMeasuredStates(0, 0) + 18, (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                Object[] objArr14 = new Object[1];
                b((byte) (-MyBillsEntityDataFactory[32]), (byte) (-MyBillsEntityDataFactory[31]), MyBillsEntityDataFactory[30], objArr14);
                Class<?> cls5 = Class.forName((String) objArr14[0]);
                byte b3 = (byte) (getAuthRequestContext & 14);
                Object[] objArr15 = new Object[1];
                b(b3, (byte) (b3 | 22), MyBillsEntityDataFactory[30], objArr15);
                try {
                    Object[] objArr16 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - Color.alpha(0), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 4, (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1));
                        Object[] objArr17 = new Object[1];
                        c((byte) (-$$a[9]), (byte) ($$a[47] - 1), (byte) (-$$a[53]), objArr17);
                        obj3 = cls6.getMethod((String) objArr17[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr18 = (Object[]) ((Method) obj3).invoke(null, objArr16);
                    int i = ((int[]) objArr18[1])[0];
                    if (((int[]) objArr18[0])[0] != i) {
                        long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - KeyEvent.normalizeMetaState(0), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 35, (char) ExpandableListView.getPackedPositionType(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(null, null);
                            try {
                                Object[] objArr19 = {1712589184, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + 911, Color.green(0) + 18, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    Intent intent = getIntent();
                    Bundle extras = intent.getExtras();
                    if (intent == null) {
                        MPLog.PlaceComponentResult("MixpanelAPI.MixpanelNotificationRouteActivity", "Notification route activity given null intent.");
                        return;
                    }
                    trackTapAction(intent);
                    Intent handleRouteIntent = handleRouteIntent(intent);
                    if (!extras.getBoolean("mp_is_sticky")) {
                        MixpanelFCMMessagingService mixpanelFCMMessagingService = new MixpanelFCMMessagingService();
                        Context applicationContext = getApplicationContext();
                        getApplicationContext();
                        mixpanelFCMMessagingService.cancelNotification(extras, (NotificationManager) applicationContext.getSystemService("notification"));
                    }
                    finish();
                    startActivity(handleRouteIntent);
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
    }

    protected Intent handleRouteIntent(Intent intent) {
        MixpanelNotificationData.PushTapActionType fromString;
        CharSequence charSequence = intent.getExtras().getCharSequence("mp_tap_action_type");
        if (charSequence == null) {
            MPLog.PlaceComponentResult("MixpanelAPI.MixpanelNotificationRouteActivity", "Notification action click logged with no action type");
            fromString = MixpanelNotificationData.PushTapActionType.HOMESCREEN;
        } else {
            fromString = MixpanelNotificationData.PushTapActionType.fromString(charSequence.toString());
        }
        CharSequence charSequence2 = intent.getExtras().getCharSequence("mp_tap_action_uri");
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
        int i = AnonymousClass1.PlaceComponentResult[fromString.ordinal()];
        if (i != 2) {
            return i != 3 ? launchIntentForPackage : new Intent("android.intent.action.VIEW", Uri.parse(charSequence2.toString()));
        } else if (URLUtil.isValidUrl(charSequence2.toString())) {
            return new Intent("android.intent.action.VIEW", Uri.parse(charSequence2.toString())).addCategory("android.intent.category.BROWSABLE");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Wanted to open url in browser but url is invalid: ");
            sb.append(charSequence2.toString());
            sb.append(". Starting default intent");
            MPLog.PlaceComponentResult("MixpanelAPI.MixpanelNotificationRouteActivity", sb.toString());
            return launchIntentForPackage;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mixpanel.android.mpmetrics.MixpanelNotificationRouteActivity$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[MixpanelNotificationData.PushTapActionType.values().length];
            PlaceComponentResult = iArr;
            try {
                iArr[MixpanelNotificationData.PushTapActionType.HOMESCREEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                PlaceComponentResult[MixpanelNotificationData.PushTapActionType.URL_IN_BROWSER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                PlaceComponentResult[MixpanelNotificationData.PushTapActionType.DEEP_LINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    protected void trackTapAction(Intent intent) {
        String str;
        String stringExtra = intent.getStringExtra("mp_tap_target");
        String stringExtra2 = intent.getStringExtra("mp_tap_action_type");
        String stringExtra3 = intent.getStringExtra("mp_tap_action_uri");
        boolean booleanExtra = intent.getBooleanExtra("mp_is_sticky", false);
        String str2 = null;
        if (stringExtra == null || !stringExtra.equals(ApiDowngradeConstant.JsonKeys.BUTTON)) {
            str = null;
        } else {
            str2 = intent.getStringExtra("mp_button_id");
            str = intent.getStringExtra("mp_button_label");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("$tap_target", stringExtra);
            jSONObject.putOpt("$tap_action_type", stringExtra2);
            jSONObject.putOpt("$tap_action_uri", stringExtra3);
            jSONObject.putOpt("$is_sticky", Boolean.valueOf(booleanExtra));
            jSONObject.putOpt("$button_id", str2);
            jSONObject.putOpt("$button_label", str);
        } catch (JSONException e) {
            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.MixpanelNotificationRouteActivity", "Error adding tracking JSON properties.", e);
        }
        MixpanelAPI.KClassImpl$Data$declaredNonStaticMembers$2(getApplicationContext(), intent, "$push_notification_tap", jSONObject);
    }

    private static void a(byte b, char[] cArr, int i, Object[] objArr) {
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
        char c = (char) ((-1549216646985767851L) ^ PlaceComponentResult);
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
