package com.cyberfend.cyfsecurity;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.akamai.botman.CYFMonitor;
import com.akamai.botman.a;
import com.akamai.botman.x;
import com.akamai.botman.y;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import kotlin.text.Typography;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getCallingPid;

/* loaded from: classes3.dex */
public class CCADialogActivity extends AppCompatActivity {
    private static char[] GetContactSyncConfig = null;
    private static final String KClassImpl$Data$declaredNonStaticMembers$2 = "CCADialogActivity";
    private static char NetworkUserEntityData$$ExternalSyntheticLambda1;
    private CircleProgressBar NetworkUserEntityData$$ExternalSyntheticLambda0;
    private a.InterfaceC0012a getErrorConfigVersion = new a.InterfaceC0012a() { // from class: com.cyberfend.cyfsecurity.CCADialogActivity.1
        @Override // com.akamai.botman.a.InterfaceC0012a
        public final void MyBillsEntityDataFactory() {
            String unused = CCADialogActivity.KClassImpl$Data$declaredNonStaticMembers$2;
            CCADialogActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda0.f7423a.removeCallbacksAndMessages(null);
            CCADialogActivity.this.finish();
        }

        @Override // com.akamai.botman.a.InterfaceC0012a
        public final void KClassImpl$Data$declaredNonStaticMembers$2(final float f) {
            String unused = CCADialogActivity.KClassImpl$Data$declaredNonStaticMembers$2;
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cyberfend.cyfsecurity.CCADialogActivity.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    CCADialogActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda0.setProgress(f);
                }
            });
        }
    };
    private TextView lookAheadTest;
    private Button moveToNextValue;
    private TextView scheduleImpl;
    public static final byte[] $$a = {1, 78, 11, -6, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 65;
    public static final byte[] getAuthRequestContext = {42, -75, 2, Ascii.US, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int PlaceComponentResult = 252;

    static {
        BuiltInFictitiousFunctionClassFactory();
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        NetworkUserEntityData$$ExternalSyntheticLambda1 = (char) 42066;
        GetContactSyncConfig = new char[]{37282, 37371, 37366, 37375, 37459, 37344, 37468, 37293, 37279, 37294, 37281, 37369, 37290, 37365, 37274, 37367, 37286, 37292, 37373, 37287, 37306, 37368, 37460, 37463, 37291, 37457, 37289, 37295, 37374, 37302, 37283, 37288, 37458, 37345, 37307, 37280, 37309, 37275, 37372, 37311, 37456, 37370, 37469, 37461, 37262, 37310, 37462, 37308, 37305};
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 + 97
            byte[] r0 = com.cyberfend.cyfsecurity.CCADialogActivity.getAuthRequestContext
            int r7 = 56 - r7
            int r9 = r9 + 16
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L14
            r8 = r7
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L2e
        L14:
            r3 = 0
        L15:
            byte r4 = (byte) r8
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r9) goto L24
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L24:
            r3 = r0[r7]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L2e:
            int r9 = r9 + r7
            int r7 = r9 + (-4)
            int r8 = r8 + 1
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            r6 = r8
            r8 = r7
            r7 = r6
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberfend.cyfsecurity.CCADialogActivity.c(byte, byte, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(int r7, short r8, byte r9, java.lang.Object[] r10) {
        /*
            int r8 = 46 - r8
            int r7 = r7 * 2
            int r7 = r7 + 75
            byte[] r0 = com.cyberfend.cyfsecurity.CCADialogActivity.$$a
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
            goto L31
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
            int r8 = r8 + 1
            r3 = r0[r8]
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L31:
            int r9 = -r9
            int r7 = r7 + r9
            int r7 = r7 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberfend.cyfsecurity.CCADialogActivity.d(int, short, byte, java.lang.Object[]):void");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        b((byte) (94 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), new char[]{'\n', 11, 22, Typography.amp, '%', 14, JSONLexer.EOI, 31, '(', '*', 29, '\f', '%', Typography.dollar, 19, '\n', 13894, 13894}, 18 - (ViewConfiguration.getScrollBarSize() >> 8), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b((byte) (Gravity.getAbsoluteGravity(0, 0) + 31), new char[]{1, 28, 15, 17, 13853}, KeyEvent.getDeadChar(0, 0) + 5, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0', 0), 36 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b((byte) (15 - (ViewConfiguration.getScrollBarFadeDuration() >> 16)), new char[]{24, 14, '\b', 18, '\n', 31, 1, 16, JSONLexer.EOI, 7, 19, 24, 11, 19, InputCardNumberView.DIVIDER, 7, 13754, 13754, '\f', '\n', 31, 24, 18, '\n', 31, '-', 17, 22, 17, 25, '\n', '\r', 4, '\t', 16, 4, 23, 5, 17, 1, 22, 27, 4, '\b', '\n', '#', '\f', '\r'}, (ViewConfiguration.getWindowTouchSlop() >> 8) + 48, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b((byte) (KeyEvent.keyCodeFromString("") + 38), new char[]{'\r', '%', '\n', 25, 23, 5, 1, 17, 31, 24, 6, '%', 21, 31, 29, 0, 13774, 13774, 21, '!', 21, 31, '\n', '\'', '\f', '\b', 5, '\t', 17, 22, 13774, 13774, 24, 31, '\b', 22, 13855, 13855, '\n', '-', Typography.amp, 6, 7, '!', 14, 24, '#', 28, 13775, 13775, 23, 0, 0, 23, 0, 31, 0, 31, 14, '\n', 29, 14, 31, '-'}, TextUtils.indexOf("", "", 0) + 64, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b((byte) (Color.rgb(0, 0, 0) + 16777332), new char[]{14, InputCardNumberView.DIVIDER, '\r', '\b', 0, 23, 15, 4, 13846, 13846, 14, 29, 31, '#', 0, 24, '\n', '\r', 3, 22, 14, 11, '\n', '%', 22, 27, 1, 16, 13936, 13936, 24, 14, 22, 25, 19, 16, 14, 28, '\b', 18, 19, 22, 29, 0, 17, 1, '\n', '\b', 23, 5, 19, '\n', 14, InputCardNumberView.DIVIDER, 27, '(', 27, '#', 4, '\t', 27, '(', '%', 6}, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 63, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b((byte) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 15), new char[]{20, '!', InputCardNumberView.DIVIDER, ')', '0', '\f', 13764, 13764, 23, '\n', 11, '\n', Typography.quote, 28, 15, '(', '\r', '\n', 31, 20, '\f', ',', 28, Typography.quote, Typography.quote, 17, '\b', '%', JSONLexer.EOI, '-', '0', 17, '\b', '%', 19, '(', 14, Typography.amp, 1, 6, 11, '%', 19, 2, 17, '\t', '!', '\n', '0', '!', 6, '/', 19, 4, '\r', '/', '\r', 11, '!', '0'}, (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 60, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b((byte) (TextUtils.indexOf("", "") + 57), new char[]{5, 30, 5, 29, 14, InputCardNumberView.DIVIDER}, KeyEvent.getDeadChar(0, 0) + 6, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0', 0), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 18, (char) Color.blue(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                c(getAuthRequestContext[31], getAuthRequestContext[32], getAuthRequestContext[25], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = (byte) (getAuthRequestContext[3] - 1);
                Object[] objArr14 = new Object[1];
                c(b, (byte) (b & 40), getAuthRequestContext[25], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + 55, AndroidCharacter.getMirror('0') - '-', (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16));
                        Object[] objArr16 = new Object[1];
                        d($$a[0], (byte) (-$$a[53]), $$a[0], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 15, (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, (-16777201) - Color.rgb(0, 0, 0), (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - ((Process.getThreadPriority(0) + 20) >> 6), 'M' - AndroidCharacter.getMirror('0'), (char) (TextUtils.indexOf("", "") + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + 800, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 15, (char) (ViewConfiguration.getEdgeSlop() >> 16)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, View.resolveSizeAndState(0, 0, 0) + 35, (char) TextUtils.getOffsetBefore("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {705520498, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 18 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                c(getAuthRequestContext[31], getAuthRequestContext[32], getAuthRequestContext[25], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b2 = (byte) (getAuthRequestContext[3] - 1);
                Object[] objArr20 = new Object[1];
                c(b2, (byte) (b2 & 40), getAuthRequestContext[25], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(62 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 46 - View.MeasureSpec.getMode(0), (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())));
                        Object[] objArr22 = new Object[1];
                        d((byte) (-$$a[9]), $$a[20], (byte) ($$a[0] - 1), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - KeyEvent.keyCodeFromString(""), 35 - Gravity.getAbsoluteGravity(0, 0), (char) TextUtils.indexOf("", "", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {705520498, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollDefaultDelay() >> 16) + 911, 19 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) Color.alpha(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                c(getAuthRequestContext[31], getAuthRequestContext[32], getAuthRequestContext[25], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b3 = (byte) (getAuthRequestContext[3] - 1);
                Object[] objArr26 = new Object[1];
                c(b3, (byte) (b3 & 40), getAuthRequestContext[25], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (Process.myTid() >> 22), (KeyEvent.getMaxKeyCode() >> 16) + 3, (char) (38968 - ((Process.getThreadPriority(0) + 20) >> 6)));
                        Object[] objArr28 = new Object[1];
                        d((byte) (-$$a[9]), $$a[20], (byte) ($$a[0] - 1), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.getDefaultSize(0, 0), 36 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {705520498, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 912, 17 - Process.getGidForName(""), (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                c(getAuthRequestContext[31], getAuthRequestContext[32], getAuthRequestContext[25], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b4 = (byte) (getAuthRequestContext[3] - 1);
                Object[] objArr32 = new Object[1];
                c(b4, (byte) (b4 & 40), getAuthRequestContext[25], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 3, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16));
                        byte b5 = (byte) ($$a[0] - 1);
                        Object[] objArr34 = new Object[1];
                        d(b5, b5, (byte) (-$$a[8]), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, Color.blue(0) + 35, (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {705520498, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), KeyEvent.keyCodeFromString("") + 18, (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b((byte) (getPackageName().length() + 5), new char[]{'\n', 11, 22, Typography.amp, '%', 14, JSONLexer.EOI, 31, 11, '%', '(', InputCardNumberView.DIVIDER, '-', 16, 30, 20, ',', 20, 28, 30, '(', 16, '(', '\b', '\n', 23}, getPackageName().codePointAt(2) - 20, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                Object[] objArr2 = new Object[1];
                c((byte) (PlaceComponentResult & 55), getAuthRequestContext[25], (byte) (-getAuthRequestContext[30]), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                c(getAuthRequestContext[25], (byte) (-getAuthRequestContext[5]), getAuthRequestContext[2], objArr3);
                Object[] objArr4 = new Object[1];
                b((byte) (((ApplicationInfo) cls2.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 3), new char[]{18, 14, 13836, 13836, '\r', 11, 30, '0', 13838, 13838, '%', 23, 16, '\n', 30, 20, Typography.amp, 7}, super.getResources().getString(id.dana.R.string.redeem).substring(1, 5).length() + 14, objArr4);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getJumpTapTimeout() >> 16), (Process.myTid() >> 22) + 35, (char) Color.argb(0, 0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + 912, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 17, (char) ExpandableListView.getPackedPositionType(0L))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b((byte) (super.getResources().getString(id.dana.R.string.kyc_renewal_dialog_message).substring(62, 64).codePointAt(0) - 89), new char[]{'\n', 11, 22, Typography.amp, '%', 14, JSONLexer.EOI, 31, 11, '%', '(', InputCardNumberView.DIVIDER, '-', 16, 30, 20, ',', 20, 28, 30, '(', 16, '(', '\b', '\n', 23}, super.getResources().getString(id.dana.R.string.bottom_on_boarding_send_money_second_body_text).substring(10, 11).codePointAt(0) - 6, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b((byte) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 35), new char[]{18, 14, 13836, 13836, '\r', 11, 30, '0', 13838, 13838, '%', 23, 16, '\n', 30, 20, Typography.amp, 7}, TextUtils.getCapsMode("", 0, 0) + 18, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ExpandableListView.getPackedPositionType(0L), TextUtils.getOffsetAfter("", 0) + 35, (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 18 - ExpandableListView.getPackedPositionGroup(0L), (char) View.combineMeasuredStates(0, 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        b((byte) (super.getResources().getString(id.dana.R.string.error_message_form_city).substring(9, 10).codePointAt(0) - 22), new char[]{'\n', 11, 22, Typography.amp, '%', 14, JSONLexer.EOI, 31, '(', '*', 29, '\f', '%', Typography.dollar, 19, '\n', 13894, 13894}, KeyEvent.normalizeMetaState(0) + 18, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        b((byte) (TextUtils.indexOf("", "", 0) + 31), new char[]{1, 28, 15, 17, 13853}, getPackageName().codePointAt(6) - 92, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                byte codePointAt = (byte) (getPackageName().codePointAt(4) - 85);
                char[] cArr = {'\n', 11, 22, Typography.amp, '%', 14, JSONLexer.EOI, 31, 11, '%', '(', InputCardNumberView.DIVIDER, '-', 16, 30, 20, ',', 20, 28, 30, '(', 16, '(', '\b', '\n', 23};
                try {
                    Object[] objArr4 = new Object[1];
                    c((byte) (PlaceComponentResult & 55), getAuthRequestContext[25], (byte) (-getAuthRequestContext[30]), objArr4);
                    Class<?> cls2 = Class.forName((String) objArr4[0]);
                    c(getAuthRequestContext[25], (byte) (-getAuthRequestContext[5]), getAuthRequestContext[2], new Object[1]);
                    Object[] objArr5 = new Object[1];
                    b(codePointAt, cArr, ((ApplicationInfo) cls2.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 7, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    b((byte) (TextUtils.getOffsetAfter("", 0) + 36), new char[]{18, 14, 13836, 13836, '\r', 11, 30, '0', 13838, 13838, '%', 23, 16, '\n', 30, 20, Typography.amp, 7}, View.getDefaultSize(0, 0) + 18, objArr6);
                    baseContext = (Context) cls3.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), Color.argb(0, 0, 0, 0) + 35, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b((byte) (TextUtils.indexOf("", "", 0) + 15), new char[]{24, 14, '\b', 18, '\n', 31, 1, 16, JSONLexer.EOI, 7, 19, 24, 11, 19, InputCardNumberView.DIVIDER, 7, 13754, 13754, '\f', '\n', 31, 24, 18, '\n', 31, '-', 17, 22, 17, 25, '\n', '\r', 4, '\t', 16, 4, 23, 5, 17, 1, 22, 27, 4, '\b', '\n', '#', '\f', '\r'}, super.getResources().getString(id.dana.R.string.deals_express_voucher_context_offline_fnb).substring(6, 7).length() + 47, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b((byte) (super.getResources().getString(id.dana.R.string.request_consent_dialog_desc).substring(38, 40).codePointAt(1) + 6), new char[]{'\r', '%', '\n', 25, 23, 5, 1, 17, 31, 24, 6, '%', 21, 31, 29, 0, 13774, 13774, 21, '!', 21, 31, '\n', '\'', '\f', '\b', 5, '\t', 17, 22, 13774, 13774, 24, 31, '\b', 22, 13855, 13855, '\n', '-', Typography.amp, 6, 7, '!', 14, 24, '#', 28, 13775, 13775, 23, 0, 0, 23, 0, 31, 0, 31, 14, '\n', 29, 14, 31, '-'}, getPackageName().codePointAt(1) - 36, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b((byte) (super.getResources().getString(id.dana.R.string.feed_empty_state_title).substring(16, 17).length() + 115), new char[]{14, InputCardNumberView.DIVIDER, '\r', '\b', 0, 23, 15, 4, 13846, 13846, 14, 29, 31, '#', 0, 24, '\n', '\r', 3, 22, 14, 11, '\n', '%', 22, 27, 1, 16, 13936, 13936, 24, 14, 22, 25, 19, 16, 14, 28, '\b', 18, 19, 22, 29, 0, 17, 1, '\n', '\b', 23, 5, 19, '\n', 14, InputCardNumberView.DIVIDER, 27, '(', 27, '#', 4, '\t', 27, '(', '%', 6}, 64 - View.resolveSizeAndState(0, 0, 0), objArr9);
                    String str3 = (String) objArr9[0];
                    byte size = (byte) (View.MeasureSpec.getSize(0) + 15);
                    char[] cArr2 = {20, '!', InputCardNumberView.DIVIDER, ')', '0', '\f', 13764, 13764, 23, '\n', 11, '\n', Typography.quote, 28, 15, '(', '\r', '\n', 31, 20, '\f', ',', 28, Typography.quote, Typography.quote, 17, '\b', '%', JSONLexer.EOI, '-', '0', 17, '\b', '%', 19, '(', 14, Typography.amp, 1, 6, 11, '%', 19, 2, 17, '\t', '!', '\n', '0', '!', 6, '/', 19, 4, '\r', '/', '\r', 11, '!', '0'};
                    try {
                        Object[] objArr10 = new Object[1];
                        c((byte) (PlaceComponentResult & 55), getAuthRequestContext[25], (byte) (-getAuthRequestContext[30]), objArr10);
                        Class<?> cls4 = Class.forName((String) objArr10[0]);
                        Object[] objArr11 = new Object[1];
                        c(getAuthRequestContext[25], (byte) (-getAuthRequestContext[5]), getAuthRequestContext[2], objArr11);
                        Object[] objArr12 = new Object[1];
                        b(size, cArr2, ((ApplicationInfo) cls4.getMethod((String) objArr11[0], null).invoke(this, null)).targetSdkVersion + 27, objArr12);
                        String str4 = (String) objArr12[0];
                        Object[] objArr13 = new Object[1];
                        b((byte) (super.getResources().getString(id.dana.R.string.failed_query_prefix).substring(36, 38).codePointAt(1) + 25), new char[]{5, 30, 5, 29, 14, InputCardNumberView.DIVIDER}, super.getResources().getString(id.dana.R.string.enter_receiver_date_of_birth).substring(28, 29).length() + 5, objArr13);
                        try {
                            Object[] objArr14 = {baseContext, str, str2, str3, str4, true, (String) objArr13[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0'), 17 - MotionEvent.axisFromString(""), (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                            }
                            ((Method) obj2).invoke(invoke, objArr14);
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
            Object[] objArr15 = new Object[1];
            c(getAuthRequestContext[31], getAuthRequestContext[32], getAuthRequestContext[25], objArr15);
            Class<?> cls5 = Class.forName((String) objArr15[0]);
            byte b = (byte) (getAuthRequestContext[3] - 1);
            Object[] objArr16 = new Object[1];
            c(b, (byte) (b & 40), getAuthRequestContext[25], objArr16);
            try {
                Object[] objArr17 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(495 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), View.MeasureSpec.getSize(0) + 4, (char) KeyEvent.keyCodeFromString(""));
                    byte b2 = (byte) ($$a[0] - 1);
                    Object[] objArr18 = new Object[1];
                    d(b2, b2, (byte) (-$$a[8]), objArr18);
                    obj3 = cls6.getMethod((String) objArr18[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr19 = (Object[]) ((Method) obj3).invoke(null, objArr17);
                int i = ((int[]) objArr19[1])[0];
                if (((int[]) objArr19[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (Process.myTid() >> 22) + 35, (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr20 = {705123307, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getOffsetBefore("", 0), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 18, (char) View.MeasureSpec.getSize(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr20);
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
                setContentView(R.layout.activity_ccadialog);
                setFinishOnTouchOutside(false);
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = (CircleProgressBar) findViewById(R.id.dialogActivity_dialog_progressBar);
                String stringExtra = getIntent().getStringExtra("CCA Title");
                String stringExtra2 = getIntent().getStringExtra("CCA Message");
                String stringExtra3 = getIntent().getStringExtra("CCA Cancel Button");
                TextView textView = (TextView) findViewById(R.id.dialogActivity_dialog_title);
                this.scheduleImpl = textView;
                textView.setText(stringExtra);
                TextView textView2 = (TextView) findViewById(R.id.dialogActivity_dialog_message);
                this.lookAheadTest = textView2;
                textView2.setText(stringExtra2);
                Button button = (Button) findViewById(R.id.dialogActivity_dialog_button);
                this.moveToNextValue = button;
                button.setText(stringExtra3);
                this.moveToNextValue.setOnClickListener(new View.OnClickListener() { // from class: com.cyberfend.cyfsecurity.CCADialogActivity.2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        a.getAuthRequestContext();
                        a.KClassImpl$Data$declaredNonStaticMembers$2();
                    }
                });
                int intExtra = getIntent().getIntExtra("Theme Color", getResources().getColor(R.color.MyBillsEntityDataFactory_res_0x7f060024));
                this.moveToNextValue.setTextColor(intExtra);
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.setProgressBarColor(intExtra);
                final a authRequestContext = a.getAuthRequestContext();
                authRequestContext.MyBillsEntityDataFactory = this.getErrorConfigVersion;
                x.a aVar = new x.a() { // from class: com.akamai.botman.a.1
                    @Override // com.akamai.botman.x.a
                    public final void PlaceComponentResult() {
                        if (authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0 == 0) {
                            return;
                        }
                        authRequestContext.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
                        String unused = a.getAuthRequestContext;
                        synchronized (this) {
                            a.PlaceComponentResult(authRequestContext);
                            authRequestContext.PlaceComponentResult = 0.0f;
                        }
                    }

                    @Override // com.akamai.botman.x.a
                    public final void MyBillsEntityDataFactory() {
                        authRequestContext.lookAheadTest.MyBillsEntityDataFactory();
                    }

                    @Override // com.akamai.botman.x.a
                    public final void BuiltInFictitiousFunctionClassFactory(float f) {
                        authRequestContext.PlaceComponentResult = f;
                        authRequestContext.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.PlaceComponentResult);
                    }

                    @Override // com.akamai.botman.x.a
                    public final void getAuthRequestContext(String str5) {
                        authRequestContext.lookAheadTest.BuiltInFictitiousFunctionClassFactory(str5);
                    }

                    @Override // com.akamai.botman.x.a
                    public final void getAuthRequestContext() {
                        CYFMonitor.ChallengeActionCallback unused = authRequestContext.lookAheadTest;
                    }
                };
                x KClassImpl$Data$declaredNonStaticMembers$22 = x.KClassImpl$Data$declaredNonStaticMembers$2();
                String str5 = authRequestContext.BuiltInFictitiousFunctionClassFactory;
                int i2 = KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult;
                KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = aVar;
                if (KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult != 1 && KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult != 3) {
                    KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory = str5;
                    new Timer().schedule(new y.AnonymousClass1(1), 100L);
                }
                authRequestContext.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.PlaceComponentResult);
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

    private static void b(byte b, char[] cArr, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = GetContactSyncConfig;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i3 = 0; i3 < length; i3++) {
                cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
            }
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ NetworkUserEntityData$$ExternalSyntheticLambda1);
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
