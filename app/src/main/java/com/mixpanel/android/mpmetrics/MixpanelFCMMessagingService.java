package com.mixpanel.android.mpmetrics;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
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
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.common.base.Ascii;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.zxing.pdf417.PDF417Common;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.mixpanel.android.util.MPLog;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.B;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes.dex */
public class MixpanelFCMMessagingService extends FirebaseMessagingService {
    private static short[] DatabaseTableConfigUtil = null;
    protected static final int NOTIFICATION_ID = 1;
    public static final byte[] $$a = {Ascii.EM, 108, 7, 61, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 36;
    public static final byte[] PlaceComponentResult = {116, 58, -28, -63, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int MyBillsEntityDataFactory = 17;
    private static int moveToNextValue = 1257195749;
    private static int getErrorConfigVersion = 498220074;
    private static byte[] scheduleImpl = {13, 63, 11, Ascii.EM, 16, 43, 43, -46, 9, 76, -61, 18, 19, 16, 63, Ascii.ETB, 0, 106, -111, 73, -103, 74, TarHeader.LF_FIFO, -24, 77, TarHeader.LF_CONTIG, -21, 74, TarHeader.LF_SYMLINK, 1, 58, -26, 76, TarHeader.LF_SYMLINK, 61, 60, -27, TarHeader.LF_DIR, 60, 71, -21, 77, TarHeader.LF_BLK, -22, 75, -26, 57, 58, TarHeader.LF_FIFO, 78, TarHeader.LF_BLK, 57, 62, TarHeader.LF_BLK, 58, -20, 58, TarHeader.LF_FIFO, 59, 75, 58, 58, -28, 69, 1, TarHeader.LF_CONTIG, -26, 77, -114, -15, -42, -114, -34, -21, -36, -34, -36, -92, -33, -35, -37, -39, -35, -95, -41, -93, -119, -21, -111, -24, -94, -37, -38, -112, -35, -14, -39, -115, -36, -20, -35, -113, -15, -118, -15, -122, -15, -38, -96, -40, -112, -22, -110, -23, -35, -33, -38, -35, -112, -18, -95, -121, -34, -15, -43, -90, -118, -37, -17, -36, -119, -1, -61, -76, 19, -58, -1, -59, -63, -76, 14, -60, -74, -63, Ascii.EM, -80, -1, -62, 18, -53, -1, -64, -72, Ascii.NAK, -61, -63, -60, -82, Ascii.EM, -3, -75, 22, -81, Ascii.ETB, -78, -61, Ascii.NAK, -60, -80, Ascii.DC4, -1, -79, -60, 19, -75, 19, -76, -1, Ascii.EM, -4, -58, -63, -61, -54, -61, -61, -1, -63, -56, -59, -84, -58, 15, -60, -56, -63, -2, -40, -10, 17, -54, -117, 0, -116, -58, -7, -55, -50, -62, 13, -127, -50, -8, Ascii.NAK, -123, -55, -5, 18, -66, -44, -10, -37, -61, -55, -8, -43, -10, -37, -7, 14, -115, -58, -11, -55, -40, -12, -53, -44, -3, -45, 1, -70, -44, -6, -54, 18, -57, -46, Byte.MIN_VALUE, -60, -53, -57, -5, -115, -120, -110, -122, -105, -97, -97, -97, -97, -97, -97, -97};
    private static int getAuthRequestContext = 1729600981;

    /* JADX WARN: Removed duplicated region for block: B:20:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0028 -> B:23:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r7, short r8, byte r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 + 4
            byte[] r0 = com.mixpanel.android.mpmetrics.MixpanelFCMMessagingService.PlaceComponentResult
            int r7 = r7 + 105
            int r9 = r9 * 2
            int r9 = 16 - r9
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L16
            r7 = r8
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L32
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r7
            int r5 = r3 + 1
            r1[r3] = r4
            int r8 = r8 + 1
            if (r5 != r9) goto L28
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L28:
            r3 = r0[r8]
            r6 = r9
            r9 = r7
            r7 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L32:
            int r9 = r9 + r8
            int r8 = r9 + 2
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            r6 = r8
            r8 = r7
            r7 = r6
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.MixpanelFCMMessagingService.b(int, short, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0027 -> B:23:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.mixpanel.android.mpmetrics.MixpanelFCMMessagingService.$$a
            int r8 = r8 * 2
            int r8 = 103 - r8
            int r6 = r6 * 3
            int r6 = 42 - r6
            int r7 = r7 + 4
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r4 = r8
            r3 = 0
            r8 = r7
            goto L2e
        L17:
            r3 = 0
        L18:
            int r7 = r7 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r5
        L2e:
            int r4 = -r4
            int r7 = r7 + r4
            int r7 = r7 + (-7)
            r5 = r8
            r8 = r7
            r7 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.MixpanelFCMMessagingService.c(short, int, int, java.lang.Object[]):void");
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService, com.google.firebase.messaging.EnhancedIntentService, android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        Object[] objArr5;
        super.attachBaseContext(context);
        Object[] objArr6 = new Object[1];
        a((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1465742421, (-103) - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (byte) (ViewConfiguration.getFadingEdgeLength() >> 16), (short) (109 - TextUtils.lastIndexOf("", '0')), (ViewConfiguration.getLongPressTimeout() >> 16) - 771282250, objArr6);
        Class<?> cls = Class.forName((String) objArr6[0]);
        Object[] objArr7 = new Object[1];
        a(KeyEvent.getDeadChar(0, 0) - 1465742408, (-116) - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (byte) (ViewConfiguration.getWindowTouchSlop() >> 8), (short) (6 - KeyEvent.keyCodeFromString("")), Color.alpha(0) - 771282233, objArr7);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr7[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj != null) {
                        objArr = null;
                    } else {
                        objArr = null;
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), 35 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) Color.red(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(objArr, objArr);
                    Object[] objArr8 = new Object[1];
                    a((ViewConfiguration.getMinimumFlingVelocity() >> 16) - 1465742462, (-74) - (ViewConfiguration.getLongPressTimeout() >> 16), (byte) Color.blue(0), (short) (89 - MotionEvent.axisFromString("")), (-771282229) - TextUtils.indexOf("", "", 0, 0), objArr8);
                    String str = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a((-1465742420) - Color.alpha(0), (-59) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (byte) Color.argb(0, 0, 0, 0), (short) ((-67) - Process.getGidForName("")), AndroidCharacter.getMirror('0') - 54582, objArr9);
                    String str2 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(ExpandableListView.getPackedPositionGroup(0L) - 1465742467, (-58) - Gravity.getAbsoluteGravity(0, 0), (byte) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())), (short) ((-91) - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), (-771282118) - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), objArr10);
                    String str3 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a((-1465742412) - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (-62) - (ViewConfiguration.getLongPressTimeout() >> 16), (byte) Color.argb(0, 0, 0, 0), (short) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 89), (KeyEvent.getMaxKeyCode() >> 16) - 771282056, objArr11);
                    String str4 = (String) objArr11[0];
                    Object[] objArr12 = new Object[1];
                    a((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1465742461, (-116) - Color.alpha(0), (byte) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), (short) ((-18) - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), (-771281997) - (ViewConfiguration.getWindowTouchSlop() >> 8), objArr12);
                    try {
                        Object[] objArr13 = {applicationContext, str, str2, str3, str4, true, (String) objArr12[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Drawable.resolveOpacity(0, 0), 18 - TextUtils.getOffsetBefore("", 0), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
            }
        }
        Context applicationContext2 = context != null ? context.getApplicationContext() : context;
        if (applicationContext2 != null) {
            try {
                Object[] objArr14 = new Object[1];
                b((byte) (-PlaceComponentResult[5]), (byte) (MyBillsEntityDataFactory - 3), (byte) (PlaceComponentResult[5] + 1), objArr14);
                Class<?> cls2 = Class.forName((String) objArr14[0]);
                byte b = (byte) (PlaceComponentResult[5] + 1);
                byte b2 = PlaceComponentResult[5];
                Object[] objArr15 = new Object[1];
                b(b, b2, (byte) (b2 + 1), objArr15);
                try {
                    Object[] objArr16 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), ((Process.getThreadPriority(0) + 20) >> 6) + 3, (char) (KeyEvent.getMaxKeyCode() >> 16));
                        Object[] objArr17 = new Object[1];
                        c($$a[68], $$a[78], (byte) (-$$a[12]), objArr17);
                        obj3 = cls3.getMethod((String) objArr17[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr16);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + 800, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 15, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + 800, 14 - ImageFormat.getBitsPerPixel(0), (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr18 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + 816, (Process.myPid() >> 22) + 29, (char) (57995 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0, 0) + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, 15 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (ViewConfiguration.getPressedStateDuration() >> 16)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr18));
                                    long j = ((r7 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr2 = null;
                                        } else {
                                            objArr2 = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, Drawable.resolveOpacity(0, 0) + 35, (char) (Process.myTid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr2, objArr2);
                                        try {
                                            Object[] objArr19 = {-299651049, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getJumpTapTimeout() >> 16), KeyEvent.getDeadChar(0, 0) + 18, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj8);
                                            }
                                            ((Method) obj8).invoke(invoke3, objArr19);
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
                Object[] objArr20 = new Object[1];
                b((byte) (-PlaceComponentResult[5]), (byte) (MyBillsEntityDataFactory - 3), (byte) (PlaceComponentResult[5] + 1), objArr20);
                Class<?> cls4 = Class.forName((String) objArr20[0]);
                byte b3 = (byte) (PlaceComponentResult[5] + 1);
                byte b4 = PlaceComponentResult[5];
                Object[] objArr21 = new Object[1];
                b(b3, b4, (byte) (b4 + 1), objArr21);
                try {
                    Object[] objArr22 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr21[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - View.MeasureSpec.getSize(0), Color.rgb(0, 0, 0) + 16777262, (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))));
                        Object[] objArr23 = new Object[1];
                        c($$a[2], (byte) (-$$a[28]), (byte) ($$a[47] - 1), objArr23);
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
                                objArr5 = null;
                            } else {
                                objArr5 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getWindowTouchSlop() >> 8), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 34, (char) Color.green(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr5, objArr5);
                            try {
                                Object[] objArr25 = {-299651049, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.green(0), TextUtils.indexOf("", "") + 18, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                Object[] objArr26 = new Object[1];
                b((byte) (-PlaceComponentResult[5]), (byte) (MyBillsEntityDataFactory - 3), (byte) (PlaceComponentResult[5] + 1), objArr26);
                Class<?> cls6 = Class.forName((String) objArr26[0]);
                byte b5 = (byte) (PlaceComponentResult[5] + 1);
                byte b6 = PlaceComponentResult[5];
                Object[] objArr27 = new Object[1];
                b(b5, b6, (byte) (b6 + 1), objArr27);
                try {
                    Object[] objArr28 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr27[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - TextUtils.indexOf("", ""), 3 - TextUtils.indexOf("", "", 0), (char) (View.resolveSize(0, 0) + 38968));
                        Object[] objArr29 = new Object[1];
                        c($$a[2], (byte) (-$$a[28]), (byte) ($$a[47] - 1), objArr29);
                        obj12 = cls7.getMethod((String) objArr29[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr30 = (Object[]) ((Method) obj12).invoke(null, objArr28);
                    int i2 = ((int[]) objArr30[1])[0];
                    if (((int[]) objArr30[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), TextUtils.lastIndexOf("", '0') + 36, (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr31 = {-299651049, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.blue(0), AndroidCharacter.getMirror('0') - 30, (char) Color.alpha(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr31);
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
                Object[] objArr32 = new Object[1];
                b((byte) (-PlaceComponentResult[5]), (byte) (MyBillsEntityDataFactory - 3), (byte) (PlaceComponentResult[5] + 1), objArr32);
                Class<?> cls8 = Class.forName((String) objArr32[0]);
                byte b7 = (byte) (PlaceComponentResult[5] + 1);
                byte b8 = PlaceComponentResult[5];
                Object[] objArr33 = new Object[1];
                b(b7, b8, (byte) (b8 + 1), objArr33);
                try {
                    Object[] objArr34 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr33[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 3 - Gravity.getAbsoluteGravity(0, 0), (char) KeyEvent.keyCodeFromString(""));
                        Object[] objArr35 = new Object[1];
                        c((byte) ($$a[47] - 1), $$a[40], (byte) (-$$a[9]), objArr35);
                        obj15 = cls9.getMethod((String) objArr35[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr36 = (Object[]) ((Method) obj15).invoke(null, objArr34);
                    int i3 = ((int[]) objArr36[1])[0];
                    if (((int[]) objArr36[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ExpandableListView.getPackedPositionGroup(0L), 35 - View.MeasureSpec.getSize(0), (char) TextUtils.getOffsetAfter("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr37 = {-299651049, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), 18 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr37);
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

    @Override // com.google.firebase.messaging.FirebaseMessagingService, com.google.firebase.messaging.EnhancedIntentService, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService, com.google.firebase.messaging.EnhancedIntentService, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService, com.google.firebase.messaging.EnhancedIntentService, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService, com.google.firebase.messaging.EnhancedIntentService, android.app.Service
    public void onCreate() {
        try {
            Object[] objArr = new Object[1];
            b((byte) (-PlaceComponentResult[5]), (byte) (MyBillsEntityDataFactory - 3), (byte) (PlaceComponentResult[5] + 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b = (byte) (PlaceComponentResult[5] + 1);
            byte b2 = PlaceComponentResult[5];
            Object[] objArr2 = new Object[1];
            b(b, b2, (byte) (b2 + 1), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(493 - TextUtils.indexOf((CharSequence) "", '0', 0), ExpandableListView.getPackedPositionGroup(0L) + 4, (char) View.getDefaultSize(0, 0));
                    Object[] objArr4 = new Object[1];
                    c((byte) ($$a[47] - 1), $$a[40], (byte) (-$$a[9]), objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + 930, View.resolveSize(0, 0) + 35, (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-1296453662, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ExpandableListView.getPackedPositionChild(0L), Color.argb(0, 0, 0, 0) + 18, (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    public static void init() {
        FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() { // from class: com.mixpanel.android.mpmetrics.MixpanelFCMMessagingService.1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public void onComplete(Task<InstanceIdResult> task) {
                if (task.isSuccessful()) {
                    MixpanelFCMMessagingService.addToken(task.getResult().getToken());
                }
            }
        });
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        MPLog.PlaceComponentResult("MixpanelAPI.MixpanelFCMMessagingService", "MP FCM on new message received");
        onMessageReceived(getApplicationContext(), remoteMessage.toIntent());
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String str) {
        super.onNewToken(str);
        StringBuilder sb = new StringBuilder();
        sb.append("MP FCM on new push token: ");
        sb.append(str);
        MPLog.PlaceComponentResult("MixpanelAPI.MixpanelFCMMessagingService", sb.toString());
        addToken(str);
    }

    protected void onMessageReceived(Context context, Intent intent) {
        showPushNotification(context, intent);
    }

    public static void addToken(final String str) {
        MixpanelAPI.getAuthRequestContext(new MixpanelAPI.InstanceProcessor() { // from class: com.mixpanel.android.mpmetrics.MixpanelFCMMessagingService.2
            @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.InstanceProcessor
            public final void getAuthRequestContext(MixpanelAPI mixpanelAPI) {
                mixpanelAPI.scheduleImpl.MyBillsEntityDataFactory(str);
            }
        });
    }

    public static void showPushNotification(Context context, Intent intent) {
        showPushNotification(context, intent, new MixpanelPushNotification(context.getApplicationContext()));
    }

    public static void showPushNotification(Context context, Intent intent, MixpanelPushNotification mixpanelPushNotification) {
        Notification PlaceComponentResult2 = mixpanelPushNotification.PlaceComponentResult(intent);
        MixpanelNotificationData mixpanelNotificationData = mixpanelPushNotification.KClassImpl$Data$declaredNonStaticMembers$2;
        String str = mixpanelNotificationData == null ? "null" : mixpanelNotificationData.NetworkUserEntityData$$ExternalSyntheticLambda2;
        StringBuilder sb = new StringBuilder();
        sb.append("MP FCM notification received: ");
        sb.append(str);
        MPLog.PlaceComponentResult("MixpanelAPI.MixpanelFCMMessagingService", sb.toString());
        if (PlaceComponentResult2 != null) {
            if (!mixpanelPushNotification.KClassImpl$Data$declaredNonStaticMembers$2()) {
                MPLog.getAuthRequestContext("MixpanelAPI.MixpanelFCMMessagingService", "MP FCM notification has error");
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (mixpanelNotificationData.newProxyInstance != null) {
                notificationManager.notify(mixpanelNotificationData.newProxyInstance, 1, PlaceComponentResult2);
            } else {
                notificationManager.notify(mixpanelPushNotification.BuiltInFictitiousFunctionClassFactory, PlaceComponentResult2);
            }
        }
    }

    public void cancelNotification(Bundle bundle, NotificationManager notificationManager) {
        int i = bundle.getInt("mp_notification_id");
        String string = bundle.getString("mp_tag");
        if (string != null) {
            notificationManager.cancel(string, 1);
        } else {
            notificationManager.cancel(i);
        }
    }

    private static void a(int i, int i2, byte b, short s, int i3, Object[] objArr) {
        B b2 = new B();
        StringBuilder sb = new StringBuilder();
        int i4 = i2 + ((int) (moveToNextValue ^ 3097486228508854431L));
        int i5 = i4 == -1 ? 1 : 0;
        if (i5 != 0) {
            byte[] bArr = scheduleImpl;
            if (bArr != null) {
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                for (int i6 = 0; i6 < length; i6++) {
                    bArr2[i6] = (byte) (bArr[i6] ^ 3097486228508854431L);
                }
                bArr = bArr2;
            }
            if (bArr != null) {
                i4 = (byte) (((byte) (scheduleImpl[i3 + ((int) (getAuthRequestContext ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (moveToNextValue ^ 3097486228508854431L)));
            } else {
                i4 = (short) (((short) (DatabaseTableConfigUtil[i3 + ((int) (getAuthRequestContext ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (moveToNextValue ^ 3097486228508854431L)));
            }
        }
        if (i4 > 0) {
            b2.getAuthRequestContext = ((i3 + i4) - 2) + ((int) (getAuthRequestContext ^ 3097486228508854431L)) + i5;
            b2.MyBillsEntityDataFactory = (char) (i + ((int) (getErrorConfigVersion ^ 3097486228508854431L)));
            sb.append(b2.MyBillsEntityDataFactory);
            b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
            byte[] bArr3 = scheduleImpl;
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
                    byte[] bArr5 = scheduleImpl;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr5[r9] ^ 3097486228508854431L)) + s)) ^ b));
                } else {
                    short[] sArr = DatabaseTableConfigUtil;
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
