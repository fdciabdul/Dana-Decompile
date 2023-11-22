package com.journeyapps.barcodescanner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Bundle;
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
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.google.zxing.client.android.Intents;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.B;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes3.dex */
public class CaptureActivity extends Activity {
    private static short[] scheduleImpl;
    private DecoratedBarcodeView KClassImpl$Data$declaredNonStaticMembers$2;
    private CaptureManager MyBillsEntityDataFactory;
    public static final byte[] $$a = {62, -79, -77, -78, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 214;
    public static final byte[] getAuthRequestContext = {116, -27, -60, 115, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int PlaceComponentResult = 180;
    private static int getErrorConfigVersion = 1257195680;
    private static int lookAheadTest = -156848809;
    private static byte[] moveToNextValue = {76, -52, -2, -54, -40, -49, -22, -22, -111, -56, 11, -126, -47, -46, -49, -2, -42, -1, 89, 63, 38, Ascii.RS, 46, 68, -67, -124, -115, -74, -84, 101, -69, -75, -115, -77, -117, -81, -34, -83, 66, Byte.MIN_VALUE, -79, -51, 118, -123, -122, -125, -78, -118, -77, 76, 107, 100, 117, -105, 108, 112, 109, 110, 106, -69, 93, 100, 97, 119, 106, 109, -104, 110, -6, -90, -104, -3, -89, -101, -6, -94, -79, -86, -106, -4, -94, -83, -84, -107, -91, -84, -9, -101, -3, -92, -102, -5, -106, -87, -86, -90, -2, -92, -87, -82, -92, -86, -100, -86, -90, -85, -5, -86, -86, -108, -11, -79, -89, -106, -3, -98, -92, 7, -20, -92, -12, 1, -14, -12, -14, -6, -11, -13, -15, -17, -13, -9, -19, -7, -33, 1, -89, 62, -8, -15, -16, -90, -13, 8, -17, -93, -14, 2, -13, -91, 7, -96, 7, -36, 7, -16, -10, -18, -90, 0, -88, 63, -13, -11, -16, -13, -90, 4, -9, -35, -12, 7, -21, -4, -96, -15, 5, -14, -33, -98, 87, 91, 12, 107, 94, 87, 93, 89, 12, 102, 92, 14, 89, 113, 8, 87, 90, 106, 35, 87, 88, 16, 109, 91, 89, 92, 6, 113, 85, 13, 110, 7, 111, 10, 91, 109, 92, 8, 108, 87, 9, 92, 107, 13, 107, 12, 87, 113, 84, 94, 89, 91, 34, 91, 91, 87, 89, 32, 93, 4, 94, 103, 92, 98, -109, -116, -119, 99, -127, -36, -107, 86, -53, 87, -111, -124, -108, -103, -115, -40, 76, -103, -125, -96, 80, -108, -122, -35, 73, -97, -127, 102, -114, -108, -125, 96, -127, 102, -124, -39, 88, -111, Byte.MIN_VALUE, -108, 99, -65, -106, -97, -120, -98, -52, 69, -97, -123, -107, -35, -110, -99, 75, -113, -106, -110, -122, 88, -24, -29, -19, -31, -14};
    private static int BuiltInFictitiousFunctionClassFactory = 703118235;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r7, short r8, short r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 + 97
            int r8 = r8 + 4
            byte[] r0 = com.journeyapps.barcodescanner.CaptureActivity.getAuthRequestContext
            int r9 = r9 + 16
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L14
            r7 = r8
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L2e
        L14:
            r3 = 0
        L15:
            byte r4 = (byte) r7
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r9) goto L24
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L24:
            r3 = r0[r8]
            r6 = r9
            r9 = r7
            r7 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L2e:
            int r8 = -r8
            int r9 = r9 + r8
            int r8 = r9 + (-4)
            int r7 = r7 + 1
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
        throw new UnsupportedOperationException("Method not decompiled: com.journeyapps.barcodescanner.CaptureActivity.a(int, short, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 3
            int r8 = r8 + 21
            int r7 = r7 + 4
            byte[] r0 = com.journeyapps.barcodescanner.CaptureActivity.$$a
            int r6 = r6 * 2
            int r6 = r6 + 75
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L32
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            r3 = r0[r7]
            r5 = r8
            r8 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L32:
            int r7 = r7 + 1
            int r8 = r8 + r6
            int r6 = r8 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.journeyapps.barcodescanner.CaptureActivity.c(short, short, int, java.lang.Object[]):void");
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        b((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 1136007832, (-64) - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (byte) (ExpandableListView.getPackedPositionChild(0L) + 1), (short) (ExpandableListView.getPackedPositionChild(0L) - 82), (-1661465348) - ((Process.getThreadPriority(0) + 20) >> 6), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(1136007845 - ExpandableListView.getPackedPositionType(0L), Color.rgb(0, 0, 0) + 16777152, (byte) KeyEvent.normalizeMetaState(0), (short) (91 - KeyEvent.getDeadChar(0, 0)), (KeyEvent.getMaxKeyCode() >> 16) - 1661465330, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getCapsMode("", 0, 0), ImageFormat.getBitsPerPixel(0) + 36, (char) ((-16777216) - Color.rgb(0, 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b(1136007791 - (ViewConfiguration.getScrollBarSize() >> 8), ((byte) KeyEvent.getModifierMetaStateMask()) - 63, (byte) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (short) ((-54) - (KeyEvent.getMaxKeyCode() >> 16)), (ViewConfiguration.getMinimumFlingVelocity() >> 16) - 1661465281, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(1136007833 - Gravity.getAbsoluteGravity(0, 0), (-64) - View.MeasureSpec.getMode(0), (byte) View.combineMeasuredStates(0, 0), (short) (((Process.getThreadPriority(0) + 20) >> 6) - 108), (-1661465233) - View.resolveSizeAndState(0, 0, 0), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 1136007785, (-64) - View.combineMeasuredStates(0, 0), (byte) View.getDefaultSize(0, 0), (short) ((ViewConfiguration.getLongPressTimeout() >> 16) + 60), View.MeasureSpec.makeMeasureSpec(0, 0) - 1661465169, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(AndroidCharacter.getMirror('0') + 6768, TextUtils.lastIndexOf("", '0') - 63, (byte) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), (short) ((-13) - KeyEvent.getDeadChar(0, 0)), (-1661465106) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b((KeyEvent.getMaxKeyCode() >> 16) + 1136007793, (-64) - TextUtils.indexOf("", "", 0, 0), (byte) (ExpandableListView.getPackedPositionChild(0L) + 1), (short) ((-120) - TextUtils.getCapsMode("", 0, 0)), (-1661465045) - (ViewConfiguration.getMaximumFlingVelocity() >> 16), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + 912, 19 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                a((byte) (-getAuthRequestContext[32]), (short) 37, getAuthRequestContext[25], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                a((byte) (getAuthRequestContext[30] + 1), (byte) (-getAuthRequestContext[35]), getAuthRequestContext[25], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 54, Process.getGidForName("") + 4, (char) Gravity.getAbsoluteGravity(0, 0));
                        byte b = $$a[78];
                        Object[] objArr16 = new Object[1];
                        c(b, (byte) (b - 1), $$a[78], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + 800, 15 - View.combineMeasuredStates(0, 0), (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - ((Process.getThreadPriority(0) + 20) >> 6), (ViewConfiguration.getTouchSlop() >> 8) + 15, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(816 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 29 - KeyEvent.normalizeMetaState(0), (char) ((ViewConfiguration.getEdgeSlop() >> 16) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (Process.myPid() >> 22), 15 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) (ViewConfiguration.getJumpTapTimeout() >> 16)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.blue(0), 35 - (Process.myPid() >> 22), (char) TextUtils.getTrimmedLength(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {218957315, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getTrimmedLength("") + 911, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 18, (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((byte) (-getAuthRequestContext[32]), (short) 37, getAuthRequestContext[25], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                a((byte) (getAuthRequestContext[30] + 1), (byte) (-getAuthRequestContext[35]), getAuthRequestContext[25], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - View.resolveSizeAndState(0, 0, 0), (ViewConfiguration.getEdgeSlop() >> 16) + 46, (char) Drawable.resolveOpacity(0, 0));
                        Object[] objArr22 = new Object[1];
                        c($$a[9], (byte) ($$a[23] - 1), (byte) ($$a[78] - 1), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), Gravity.getAbsoluteGravity(0, 0) + 35, (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {218957315, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + 911, (ViewConfiguration.getScrollBarSize() >> 8) + 18, (char) View.MeasureSpec.getMode(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((byte) (-getAuthRequestContext[32]), (short) 37, getAuthRequestContext[25], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                a((byte) (getAuthRequestContext[30] + 1), (byte) (-getAuthRequestContext[35]), getAuthRequestContext[25], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(119 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 3 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (Process.getGidForName("") + 38969));
                        Object[] objArr28 = new Object[1];
                        c($$a[9], (byte) ($$a[23] - 1), (byte) ($$a[78] - 1), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (Process.myTid() >> 22), (char) View.resolveSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {218957315, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + 911, 18 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((byte) (-getAuthRequestContext[32]), (short) 37, getAuthRequestContext[25], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                a((byte) (getAuthRequestContext[30] + 1), (byte) (-getAuthRequestContext[35]), getAuthRequestContext[25], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(106 - TextUtils.indexOf((CharSequence) "", '0'), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 2, (char) View.getDefaultSize(0, 0));
                        Object[] objArr34 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[53], $$a[8], objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 34, (char) Color.red(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {218957315, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", "", 0, 0), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
    protected void onCreate(Bundle bundle) {
        Object[] objArr;
        int i;
        int i2;
        Object[] objArr2;
        int normalizeMetaState = 1136007833 - KeyEvent.normalizeMetaState(0);
        try {
            byte b = getAuthRequestContext[25];
            Object[] objArr3 = new Object[1];
            a(b, b, getAuthRequestContext[30], objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            a(getAuthRequestContext[5], (byte) (PlaceComponentResult & 127), getAuthRequestContext[8], new Object[1]);
            Object[] objArr4 = new Object[1];
            b(normalizeMetaState, ((ApplicationInfo) cls.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 97, (byte) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1), (short) (super.getResources().getString(R.string.add_new_mandiri_card).substring(1, 2).codePointAt(0) - 180), super.getResources().getString(R.string.edit_savings_title).substring(2, 3).length() - 1661465349, objArr4);
            Class<?> cls2 = Class.forName((String) objArr4[0]);
            Object[] objArr5 = new Object[1];
            b(1136007845 - Color.red(0), super.getResources().getString(R.string.danapoly_banner_got_a_point_title).substring(5, 6).length() - 65, (byte) (super.getResources().getString(R.string.paylater_loan_personal_button_active).substring(1, 2).length() - 1), (short) (getPackageName().codePointAt(3) - 9), getPackageName().length() - 1661465337, objArr5);
            int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    int length = super.getResources().getString(R.string.mission_expired).substring(0, 3).length() + 1136007830;
                    int codePointAt = super.getResources().getString(R.string.near_expired).substring(4, 5).codePointAt(0) - 178;
                    try {
                        byte b2 = getAuthRequestContext[25];
                        Object[] objArr6 = new Object[1];
                        a(b2, b2, getAuthRequestContext[30], objArr6);
                        Class<?> cls3 = Class.forName((String) objArr6[0]);
                        a(getAuthRequestContext[5], (byte) (PlaceComponentResult & 127), getAuthRequestContext[8], new Object[1]);
                        Object[] objArr7 = new Object[1];
                        b(length, codePointAt, (byte) (((ApplicationInfo) cls3.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 33), (short) (getPackageName().length() - 38), getPackageName().length() - 1661465332, objArr7);
                        Class<?> cls4 = Class.forName((String) objArr7[0]);
                        try {
                            byte b3 = getAuthRequestContext[25];
                            Object[] objArr8 = new Object[1];
                            a(b3, b3, getAuthRequestContext[30], objArr8);
                            Class<?> cls5 = Class.forName((String) objArr8[0]);
                            Object[] objArr9 = new Object[1];
                            a(getAuthRequestContext[5], (byte) (PlaceComponentResult & 127), getAuthRequestContext[8], objArr9);
                            int i3 = ((ApplicationInfo) cls5.getMethod((String) objArr9[0], null).invoke(this, null)).targetSdkVersion + 1136007802;
                            try {
                                byte b4 = getAuthRequestContext[25];
                                Object[] objArr10 = new Object[1];
                                a(b4, b4, getAuthRequestContext[30], objArr10);
                                Class<?> cls6 = Class.forName((String) objArr10[0]);
                                Object[] objArr11 = new Object[1];
                                a(getAuthRequestContext[5], (byte) (PlaceComponentResult & 127), getAuthRequestContext[8], objArr11);
                                int i4 = ((ApplicationInfo) cls6.getMethod((String) objArr11[0], null).invoke(this, null)).targetSdkVersion - 97;
                                byte resolveSize = (byte) View.resolveSize(0, 0);
                                try {
                                    byte b5 = getAuthRequestContext[25];
                                    Object[] objArr12 = new Object[1];
                                    a(b5, b5, getAuthRequestContext[30], objArr12);
                                    Class<?> cls7 = Class.forName((String) objArr12[0]);
                                    a(getAuthRequestContext[5], (byte) (PlaceComponentResult & 127), getAuthRequestContext[8], new Object[1]);
                                    Object[] objArr13 = new Object[1];
                                    b(i3, i4, resolveSize, (short) (((ApplicationInfo) cls7.getMethod((String) r10[0], null).invoke(this, null)).targetSdkVersion - 22), (-1661465300) - MotionEvent.axisFromString(""), objArr13);
                                    baseContext = (Context) cls4.getMethod((String) objArr13[0], new Class[0]).invoke(null, null);
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
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.indexOf((CharSequence) "", '0') + 36, (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(objArr, objArr);
                        Object[] objArr14 = new Object[1];
                        b(getPackageName().length() + 1136007784, (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) - 64, (byte) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), (short) (super.getResources().getString(R.string.pushverify_dana_protection_recommendation).substring(5, 6).length() - 55), getPackageName().codePointAt(4) - 1661465378, objArr14);
                        String str = (String) objArr14[0];
                        int indexOf = 1136007832 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                        int normalizeMetaState2 = (-64) - KeyEvent.normalizeMetaState(0);
                        try {
                            byte b6 = getAuthRequestContext[25];
                            Object[] objArr15 = new Object[1];
                            a(b6, b6, getAuthRequestContext[30], objArr15);
                            Class<?> cls8 = Class.forName((String) objArr15[0]);
                            a(getAuthRequestContext[5], (byte) (PlaceComponentResult & 127), getAuthRequestContext[8], new Object[1]);
                            Object[] objArr16 = new Object[1];
                            b(indexOf, normalizeMetaState2, (byte) (((ApplicationInfo) cls8.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 33), (short) (super.getResources().getString(R.string.carrier_identification_verify_content_desc_2).substring(1, 2).length() - 109), Gravity.getAbsoluteGravity(0, 0) - 1661465233, objArr16);
                            String str2 = (String) objArr16[0];
                            try {
                                byte b7 = getAuthRequestContext[25];
                                Object[] objArr17 = new Object[1];
                                a(b7, b7, getAuthRequestContext[30], objArr17);
                                Class<?> cls9 = Class.forName((String) objArr17[0]);
                                Object[] objArr18 = new Object[1];
                                a(getAuthRequestContext[5], (byte) (PlaceComponentResult & 127), getAuthRequestContext[8], objArr18);
                                Object[] objArr19 = new Object[1];
                                b(((ApplicationInfo) cls9.getMethod((String) objArr18[0], null).invoke(this, null)).targetSdkVersion + 1136007753, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 65, (byte) (ViewConfiguration.getScrollBarSize() >> 8), (short) (60 - View.getDefaultSize(0, 0)), (-1661465169) - View.resolveSize(0, 0), objArr19);
                                String str3 = (String) objArr19[0];
                                int length2 = super.getResources().getString(R.string.promo_use_limit_shop_id).substring(0, 4).length() + 1136007836;
                                try {
                                    byte b8 = getAuthRequestContext[25];
                                    Object[] objArr20 = new Object[1];
                                    a(b8, b8, getAuthRequestContext[30], objArr20);
                                    Class<?> cls10 = Class.forName((String) objArr20[0]);
                                    Object[] objArr21 = new Object[1];
                                    a(getAuthRequestContext[5], (byte) (PlaceComponentResult & 127), getAuthRequestContext[8], objArr21);
                                    int i5 = ((ApplicationInfo) cls10.getMethod((String) objArr21[0], null).invoke(this, null)).targetSdkVersion - 97;
                                    byte fadingEdgeLength = (byte) (ViewConfiguration.getFadingEdgeLength() >> 16);
                                    short minimumFlingVelocity = (short) ((ViewConfiguration.getMinimumFlingVelocity() >> 16) - 13);
                                    try {
                                        byte b9 = getAuthRequestContext[25];
                                        Object[] objArr22 = new Object[1];
                                        a(b9, b9, getAuthRequestContext[30], objArr22);
                                        Class<?> cls11 = Class.forName((String) objArr22[0]);
                                        Object[] objArr23 = new Object[1];
                                        a(getAuthRequestContext[5], (byte) (PlaceComponentResult & 127), getAuthRequestContext[8], objArr23);
                                        int i6 = ((ApplicationInfo) cls11.getMethod((String) objArr23[0], null).invoke(this, null)).targetSdkVersion - 1661465138;
                                        Object[] objArr24 = new Object[1];
                                        b(length2, i5, fadingEdgeLength, minimumFlingVelocity, i6, objArr24);
                                        String str4 = (String) objArr24[0];
                                        Object[] objArr25 = new Object[1];
                                        b(getPackageName().codePointAt(5) + 1136007683, super.getResources().getString(R.string.social_feeds_syncing_state_desc).substring(0, 2).codePointAt(1) - 169, (byte) (super.getResources().getString(R.string.bottom_on_boarding_send_money_fourth_subtitle).substring(0, 15).codePointAt(8) - 116), (short) ((-121) - TextUtils.indexOf((CharSequence) "", '0')), (-1661465045) - View.combineMeasuredStates(0, 0), objArr25);
                                        try {
                                            Object[] objArr26 = {baseContext, str, str2, str3, str4, true, (String) objArr25[0], 995651014};
                                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                            if (obj2 == null) {
                                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + 911, ExpandableListView.getPackedPositionType(0L) + 18, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                            }
                                            ((Method) obj2).invoke(invoke, objArr26);
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
                    } catch (Throwable th10) {
                        Throwable cause10 = th10.getCause();
                        if (cause10 == null) {
                            throw th10;
                        }
                        throw cause10;
                    }
                }
            }
            try {
                Object[] objArr27 = new Object[1];
                a((byte) (-getAuthRequestContext[32]), (short) 37, getAuthRequestContext[25], objArr27);
                Class<?> cls12 = Class.forName((String) objArr27[0]);
                Object[] objArr28 = new Object[1];
                a((byte) (getAuthRequestContext[30] + 1), (byte) (-getAuthRequestContext[35]), getAuthRequestContext[25], objArr28);
                try {
                    Object[] objArr29 = {Integer.valueOf(((Integer) cls12.getMethod((String) objArr28[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls13 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getTouchSlop() >> 8), ((byte) KeyEvent.getModifierMetaStateMask()) + 5, (char) Drawable.resolveOpacity(0, 0));
                        Object[] objArr30 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[53], $$a[8], objArr30);
                        obj3 = cls13.getMethod((String) objArr30[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr31 = (Object[]) ((Method) obj3).invoke(null, objArr29);
                    int i7 = ((int[]) objArr31[1])[0];
                    if (((int[]) objArr31[0])[0] != i7) {
                        long j = ((r2 ^ i7) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - KeyEvent.keyCodeFromString(""), (char) TextUtils.indexOf("", "", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr32 = {171005400, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 911, 19 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr32);
                            } catch (Throwable th11) {
                                Throwable cause11 = th11.getCause();
                                if (cause11 == null) {
                                    throw th11;
                                }
                                throw cause11;
                            }
                        } catch (Throwable th12) {
                            Throwable cause12 = th12.getCause();
                            if (cause12 == null) {
                                throw th12;
                            }
                            throw cause12;
                        }
                    }
                    super.onCreate(bundle);
                    DecoratedBarcodeView initializeContent = initializeContent();
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = initializeContent;
                    final CaptureManager captureManager = new CaptureManager(this, initializeContent);
                    this.MyBillsEntityDataFactory = captureManager;
                    Intent intent = getIntent();
                    captureManager.getAuthRequestContext.getWindow().addFlags(128);
                    if (bundle != null) {
                        i = -1;
                        captureManager.NetworkUserEntityData$$ExternalSyntheticLambda1 = bundle.getInt("SAVED_ORIENTATION_LOCK", -1);
                    } else {
                        i = -1;
                    }
                    if (intent != null) {
                        if (intent.getBooleanExtra(Intents.Scan.ORIENTATION_LOCKED, true)) {
                            if (captureManager.NetworkUserEntityData$$ExternalSyntheticLambda1 == i) {
                                int rotation = captureManager.getAuthRequestContext.getWindowManager().getDefaultDisplay().getRotation();
                                int i8 = captureManager.getAuthRequestContext.getResources().getConfiguration().orientation;
                                if (i8 == 2) {
                                    if (rotation != 0 && rotation != 1) {
                                        i2 = 8;
                                        captureManager.NetworkUserEntityData$$ExternalSyntheticLambda1 = i2;
                                    }
                                    i2 = 0;
                                    captureManager.NetworkUserEntityData$$ExternalSyntheticLambda1 = i2;
                                } else {
                                    if (i8 == 1) {
                                        i2 = (rotation == 0 || rotation == 3) ? 1 : 9;
                                        captureManager.NetworkUserEntityData$$ExternalSyntheticLambda1 = i2;
                                    }
                                    i2 = 0;
                                    captureManager.NetworkUserEntityData$$ExternalSyntheticLambda1 = i2;
                                }
                            }
                            captureManager.getAuthRequestContext.setRequestedOrientation(captureManager.NetworkUserEntityData$$ExternalSyntheticLambda1);
                        }
                        if (Intents.Scan.ACTION.equals(intent.getAction())) {
                            captureManager.BuiltInFictitiousFunctionClassFactory.initializeFromIntent(intent);
                        }
                        if (!intent.getBooleanExtra(Intents.Scan.BEEP_ENABLED, true)) {
                            captureManager.NetworkUserEntityData$$ExternalSyntheticLambda0.setBeepEnabled(false);
                        }
                        if (intent.hasExtra(Intents.Scan.SHOW_MISSING_CAMERA_PERMISSION_DIALOG)) {
                            boolean booleanExtra = intent.getBooleanExtra(Intents.Scan.SHOW_MISSING_CAMERA_PERMISSION_DIALOG, true);
                            String stringExtra = intent.getStringExtra(Intents.Scan.MISSING_CAMERA_PERMISSION_DIALOG_MESSAGE);
                            captureManager.GetContactSyncConfig = booleanExtra;
                            captureManager.initRecordTimeStamp = stringExtra != null ? stringExtra : "";
                        }
                        if (intent.hasExtra("TIMEOUT")) {
                            captureManager.lookAheadTest.postDelayed(new Runnable() { // from class: com.journeyapps.barcodescanner.CaptureManager$$ExternalSyntheticLambda3
                                @Override // java.lang.Runnable
                                public final void run() {
                                    CaptureManager captureManager2 = CaptureManager.this;
                                    Intent intent2 = new Intent(Intents.Scan.ACTION);
                                    intent2.putExtra("TIMEOUT", true);
                                    captureManager2.getAuthRequestContext.setResult(0, intent2);
                                    captureManager2.BuiltInFictitiousFunctionClassFactory();
                                }
                            }, intent.getLongExtra("TIMEOUT", 0L));
                        }
                        if (intent.getBooleanExtra(Intents.Scan.BARCODE_IMAGE_ENABLED, false)) {
                            captureManager.DatabaseTableConfigUtil = true;
                        }
                    }
                    CaptureManager captureManager2 = this.MyBillsEntityDataFactory;
                    captureManager2.BuiltInFictitiousFunctionClassFactory.decodeSingle(captureManager2.moveToNextValue);
                } catch (Throwable th13) {
                    Throwable cause13 = th13.getCause();
                    if (cause13 == null) {
                        throw th13;
                    }
                    throw cause13;
                }
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

    protected DecoratedBarcodeView initializeContent() {
        setContentView(com.google.zxing.client.android.R.layout.zxing_capture);
        return (DecoratedBarcodeView) findViewById(com.google.zxing.client.android.R.id.zxing_barcode_scanner);
    }

    @Override // android.app.Activity
    protected void onResume() {
        Object[] objArr;
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                byte b = getAuthRequestContext[25];
                Object[] objArr2 = new Object[1];
                a(b, b, getAuthRequestContext[30], objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                a(getAuthRequestContext[5], (byte) (PlaceComponentResult & 127), getAuthRequestContext[8], objArr3);
                int i = ((ApplicationInfo) cls.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 1136007800;
                int codePointAt = super.getResources().getString(R.string.remarks_message).substring(1, 2).codePointAt(0) - 161;
                try {
                    byte b2 = getAuthRequestContext[25];
                    Object[] objArr4 = new Object[1];
                    a(b2, b2, getAuthRequestContext[30], objArr4);
                    Class<?> cls2 = Class.forName((String) objArr4[0]);
                    a(getAuthRequestContext[5], (byte) (PlaceComponentResult & 127), getAuthRequestContext[8], new Object[1]);
                    Object[] objArr5 = new Object[1];
                    b(i, codePointAt, (byte) (((ApplicationInfo) cls2.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 33), (short) (super.getResources().getString(R.string.info_subtitle_1).substring(7, 11).codePointAt(3) - 147), super.getResources().getString(R.string.feed_widget_content_grouping_text).substring(0, 5).length() - 1661465330, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    int codePointAt2 = super.getResources().getString(R.string.keyword_empty_nearby_search_desc).substring(6, 7).codePointAt(0) + 1136007738;
                    int codePointAt3 = super.getResources().getString(R.string.platform_service_fee).substring(2, 3).codePointAt(0) - 161;
                    byte edgeSlop = (byte) (ViewConfiguration.getEdgeSlop() >> 16);
                    try {
                        byte b3 = getAuthRequestContext[25];
                        Object[] objArr6 = new Object[1];
                        a(b3, b3, getAuthRequestContext[30], objArr6);
                        Class<?> cls4 = Class.forName((String) objArr6[0]);
                        a(getAuthRequestContext[5], (byte) (PlaceComponentResult & 127), getAuthRequestContext[8], new Object[1]);
                        Object[] objArr7 = new Object[1];
                        b(codePointAt2, codePointAt3, edgeSlop, (short) (((ApplicationInfo) cls4.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 22), (-1661465298) - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), objArr7);
                        baseContext = (Context) cls3.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
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
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj != null) {
                    objArr = null;
                } else {
                    objArr = null;
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ExpandableListView.getPackedPositionGroup(0L), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 35, (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(objArr, objArr);
                try {
                    Object[] objArr8 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 912, 17 - ImageFormat.getBitsPerPixel(0), (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr8);
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
        super.onResume();
        CaptureManager captureManager = this.MyBillsEntityDataFactory;
        if (Build.VERSION.SDK_INT < 23) {
            captureManager.BuiltInFictitiousFunctionClassFactory.resume();
        } else if (ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(captureManager.getAuthRequestContext, "android.permission.CAMERA") == 0) {
            captureManager.BuiltInFictitiousFunctionClassFactory.resume();
        } else if (!captureManager.MyBillsEntityDataFactory) {
            ActivityCompat.BuiltInFictitiousFunctionClassFactory(captureManager.getAuthRequestContext, new String[]{"android.permission.CAMERA"}, CaptureManager.PlaceComponentResult);
            captureManager.MyBillsEntityDataFactory = true;
        }
        captureManager.scheduleImpl.start();
    }

    @Override // android.app.Activity
    protected void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(super.getResources().getString(R.string.family_account_text_resend_invitation_error).substring(1, 2).length() + 1136007832, super.getResources().getString(R.string.tnc_confirm_button).substring(2, 3).codePointAt(0) - 174, (byte) (ViewConfiguration.getScrollDefaultDelay() >> 16), (short) (super.getResources().getString(R.string.family_account_text_available_service_section).substring(5, 6).length() - 32), (-1661465325) - TextUtils.getOffsetAfter("", 0), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b(super.getResources().getString(R.string.widget_login_view_desc).substring(9, 10).codePointAt(0) + 1136007770, getPackageName().codePointAt(1) - 164, (byte) ('0' - AndroidCharacter.getMirror('0')), (short) (getPackageName().length() + 4), super.getResources().getString(R.string.res_0x7f130739_kclassimpl_data_declarednonstaticmembers_2).substring(0, 9).codePointAt(4) - 1661465409, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 34 - ImageFormat.getBitsPerPixel(0), (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), 18 - View.resolveSize(0, 0), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("MyBillsEntityDataFactory", Context.class);
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
        CaptureManager captureManager = this.MyBillsEntityDataFactory;
        captureManager.scheduleImpl.cancel();
        captureManager.BuiltInFictitiousFunctionClassFactory.pauseAndWait();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        CaptureManager captureManager = this.MyBillsEntityDataFactory;
        captureManager.getErrorConfigVersion = true;
        captureManager.scheduleImpl.cancel();
        captureManager.lookAheadTest.removeCallbacksAndMessages(null);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("SAVED_ORIENTATION_LOCK", this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(i, iArr);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.onKeyDown(i, keyEvent) || super.onKeyDown(i, keyEvent);
    }

    private static void b(int i, int i2, byte b, short s, int i3, Object[] objArr) {
        B b2 = new B();
        StringBuilder sb = new StringBuilder();
        int i4 = i2 + ((int) (getErrorConfigVersion ^ 3097486228508854431L));
        int i5 = i4 == -1 ? 1 : 0;
        if (i5 != 0) {
            byte[] bArr = moveToNextValue;
            if (bArr != null) {
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                for (int i6 = 0; i6 < length; i6++) {
                    bArr2[i6] = (byte) (bArr[i6] ^ 3097486228508854431L);
                }
                bArr = bArr2;
            }
            if (bArr != null) {
                i4 = (byte) (((byte) (moveToNextValue[i3 + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (getErrorConfigVersion ^ 3097486228508854431L)));
            } else {
                i4 = (short) (((short) (scheduleImpl[i3 + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (getErrorConfigVersion ^ 3097486228508854431L)));
            }
        }
        if (i4 > 0) {
            b2.getAuthRequestContext = ((i3 + i4) - 2) + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L)) + i5;
            b2.MyBillsEntityDataFactory = (char) (i + ((int) (lookAheadTest ^ 3097486228508854431L)));
            sb.append(b2.MyBillsEntityDataFactory);
            b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
            byte[] bArr3 = moveToNextValue;
            if (bArr3 != null) {
                int length2 = bArr3.length;
                byte[] bArr4 = new byte[length2];
                for (int i7 = 0; i7 < length2; i7++) {
                    bArr4[i7] = (byte) (bArr3[i7] ^ 3097486228508854431L);
                }
                bArr3 = bArr4;
            }
            boolean z = bArr3 != null;
            b2.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
            while (b2.KClassImpl$Data$declaredNonStaticMembers$2 < i4) {
                if (z) {
                    byte[] bArr5 = moveToNextValue;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr5[r9] ^ 3097486228508854431L)) + s)) ^ b));
                } else {
                    short[] sArr = scheduleImpl;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((short) (((short) (sArr[r9] ^ 3097486228508854431L)) + s)) ^ b));
                }
                sb.append(b2.MyBillsEntityDataFactory);
                b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
                b2.KClassImpl$Data$declaredNonStaticMembers$2++;
            }
        }
        objArr[0] = sb.toString();
    }
}
