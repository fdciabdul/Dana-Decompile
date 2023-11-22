package com.alibaba.griver.core.kernel.ipc.client;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
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
import com.alibaba.ariver.app.ipc.ClientMsgReceiver;
import com.alibaba.ariver.kernel.api.IIpcChannel;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcMessage;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.B;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;
import o.C;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes3.dex */
public class IpcMsgClientService extends Service {
    private static int BuiltInFictitiousFunctionClassFactory;
    private static int KClassImpl$Data$declaredNonStaticMembers$2;
    private static int PlaceComponentResult;
    public static Class[] SERVICE_CLASSES;
    private static byte[] getErrorConfigVersion;
    private static short[] moveToNextValue;

    /* renamed from: a  reason: collision with root package name */
    private IIpcChannel f6428a;
    public static final byte[] $$a = {Ascii.DC4, -68, -64, 70, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 173;
    public static final byte[] getAuthRequestContext = {112, 91, -28, 61, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int MyBillsEntityDataFactory = 210;

    static void PlaceComponentResult() {
        PlaceComponentResult = 1257195691;
        BuiltInFictitiousFunctionClassFactory = 2049985978;
        getErrorConfigVersion = new byte[]{-95, -33, -93, -11, -20, -125, -125, 42, -91, 96, Ascii.ESC, -22, -21, -20, -33, -9, -36, -126, -93, -101, -85, 39, 123, 45, 42, 124, 8, 39, Byte.MAX_VALUE, 22, Ascii.ETB, 43, 41, Byte.MAX_VALUE, Ascii.SUB, Ascii.EM, TarHeader.LF_SYMLINK, 66, Ascii.EM, 76, 8, 42, 65, 7, 40, 43, 126, Ascii.ETB, 123, 35, 65, 126, 19, 65, Ascii.ETB, 9, Ascii.ETB, 123, Ascii.CAN, 40, Ascii.ETB, Ascii.ETB, TarHeader.LF_LINK, 82, 22, 124, 43, 42, -18, -47, -74, -18, Ascii.RS, -85, -68, Ascii.RS, -68, -28, Ascii.US, -67, -69, -71, -67, -31, -73, -29, -55, -85, -15, -88, -30, -69, -70, -16, -67, -46, -71, -51, -68, -84, -67, -17, -47, -54, -47, -58, -47, -70, -32, -72, -16, -86, -14, -87, -67, Ascii.US, -70, -67, -16, -50, -31, -57, Ascii.RS, -47, -75, -26, -54, -69, -49, -68, -55, 68, 72, 61, 56, -21, 68, -18, 74, 61, TarHeader.LF_CHR, -19, 59, 74, 34, Ascii.EM, 68, 71, TarHeader.LF_CONTIG, -16, 68, 73, 1, 94, 72, 74, -19, 19, 34, 70, 62, 91, Ascii.DC4, 92, Ascii.ETB, 72, 94, -19, Ascii.EM, 93, 68, Ascii.SUB, -19, 56, 62, 56, 61, 68, 34, 69, -21, 74, 72, -17, 72, 72, 68, 74, -15, -18, Ascii.NAK, -21, TarHeader.LF_BLK, -19, -84, -75, -70, -36, -126, 101, -82, -17, 116, -24, -78, -67, -83, -86, -74, 105, -11, -86, -68, 97, -15, -83, -65, 102, -6, -96, -126, -33, -73, -83, -68, -95, -126, -33, -67, 106, -23, -78, -127, -83, -36, Byte.MIN_VALUE, -81, -96, -71, -89, 117, -2, -96, -66, -82, 102, -77, -90, -12, -80, -81, -77, -65, SignedBytes.MAX_POWER_OF_TWO, -7, 67, -9, 74, -97, -97, -97, -97, -97, -97, -97};
        KClassImpl$Data$declaredNonStaticMembers$2 = -1053864581;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 4
            int r8 = r8 + 16
            int r7 = 106 - r7
            byte[] r0 = com.alibaba.griver.core.kernel.ipc.client.IpcMsgClientService.getAuthRequestContext
            int r6 = r6 * 15
            int r6 = 18 - r6
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L15
            r4 = r7
            r3 = 0
            r7 = r6
            goto L2c
        L15:
            r3 = 0
        L16:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r8) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            int r6 = r6 + 1
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r5
        L2c:
            int r6 = r6 + r4
            int r6 = r6 + 2
            r5 = r7
            r7 = r6
            r6 = r5
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.kernel.ipc.client.IpcMsgClientService.b(int, byte, short, java.lang.Object[]):void");
    }

    private static void c(byte b, byte b2, byte b3, Object[] objArr) {
        int i = b3 + 4;
        int i2 = 103 - (b * 2);
        int i3 = 42 - (b2 * 3);
        byte[] bArr = $$a;
        byte[] bArr2 = new byte[i3];
        int i4 = -1;
        int i5 = i3 - 1;
        if (bArr == null) {
            int i6 = (i5 + (-i)) - 7;
            i = i;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = -1;
            i5 = i5;
            i2 = i6;
        }
        while (true) {
            int i7 = i4 + 1;
            bArr2[i7] = (byte) i2;
            if (i7 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i8 = i + 1;
            int i9 = i5;
            Object[] objArr2 = objArr;
            byte[] bArr3 = bArr2;
            byte[] bArr4 = bArr;
            int i10 = (i2 + (-bArr[i8])) - 7;
            i = i8;
            objArr = objArr2;
            bArr = bArr4;
            bArr2 = bArr3;
            i4 = i7;
            i5 = i9;
            i2 = i10;
        }
    }

    @Override // android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        d((ViewConfiguration.getPressedStateDuration() >> 16) - 819922116, TextUtils.lastIndexOf("", '0') - 33, (byte) (Process.getGidForName("") + 103), (short) (40 - Color.blue(0)), TextUtils.indexOf("", "", 0, 0) + 1950349852, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        d((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 819922105, View.resolveSize(0, 0) - 47, (byte) (3 - (Process.myTid() >> 22)), (short) ((-37) - KeyEvent.getDeadChar(0, 0)), View.MeasureSpec.makeMeasureSpec(0, 0) + 1950349869, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - MotionEvent.axisFromString(""), 35 - Drawable.resolveOpacity(0, 0), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    d((ViewConfiguration.getEdgeSlop() >> 16) - 819922158, (-4) - TextUtils.indexOf("", "", 0), (byte) ((-84) - KeyEvent.normalizeMetaState(0)), (short) ((-53) - KeyEvent.getDeadChar(0, 0)), (Process.myPid() >> 22) + 1950349873, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    d((-819922116) - (ViewConfiguration.getScrollDefaultDelay() >> 16), 12 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (byte) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 49), (short) ((-82) - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))), (ViewConfiguration.getTouchSlop() >> 8) + 1950349920, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    d((-819922163) - View.MeasureSpec.makeMeasureSpec(0, 0), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 12, (byte) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 79), (short) ((ViewConfiguration.getTapTimeout() >> 16) - 37), 1950349983 - View.MeasureSpec.getSize(0), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    d(Process.getGidForName("") - 819922108, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 7, (byte) (View.getDefaultSize(0, 0) - 4), (short) ((-48) - (ViewConfiguration.getMaximumFlingVelocity() >> 16)), 1950350046 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    d((-819922156) - View.MeasureSpec.getSize(0), View.resolveSizeAndState(0, 0, 0) - 46, (byte) ((KeyEvent.getMaxKeyCode() >> 16) - 63), (short) (((Process.getThreadPriority(0) + 20) >> 6) + 95), 1950350105 - (ViewConfiguration.getScrollBarSize() >> 8), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.combineMeasuredStates(0, 0), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 17, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = (byte) (getAuthRequestContext[5] + 1);
                byte b2 = b;
                Object[] objArr13 = new Object[1];
                b(b, b2, b2, objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b3 = (byte) (-getAuthRequestContext[5]);
                byte b4 = b3;
                Object[] objArr14 = new Object[1];
                b(b3, b4, (byte) (b4 - 1), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), View.MeasureSpec.makeMeasureSpec(0, 0) + 3, (char) View.MeasureSpec.getMode(0));
                        Object[] objArr16 = new Object[1];
                        c((byte) (-$$a[12]), $$a[68], $$a[78], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (ViewConfiguration.getTouchSlop() >> 8) + 15, (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + 800, Color.red(0) + 15, (char) View.combineMeasuredStates(0, 0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetAfter("", 0) + 815, 29 - Color.argb(0, 0, 0, 0), (char) (View.getDefaultSize(0, 0) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + 800, KeyEvent.normalizeMetaState(0) + 15, (char) TextUtils.indexOf("", "", 0, 0)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r5 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), Color.alpha(0) + 35, (char) TextUtils.indexOf("", "", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {2099637469, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getJumpTapTimeout() >> 16), 18 - (ViewConfiguration.getTapTimeout() >> 16), (char) ((-1) - ImageFormat.getBitsPerPixel(0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b5 = (byte) (getAuthRequestContext[5] + 1);
                byte b6 = b5;
                Object[] objArr19 = new Object[1];
                b(b5, b6, b6, objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b7 = (byte) (-getAuthRequestContext[5]);
                byte b8 = b7;
                Object[] objArr20 = new Object[1];
                b(b7, b8, (byte) (b8 - 1), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + 61, TextUtils.indexOf("", "", 0) + 46, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16));
                        Object[] objArr22 = new Object[1];
                        c((byte) ($$a[47] - 1), (byte) (-$$a[8]), (byte) (-$$a[28]), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 35 - (ViewConfiguration.getTapTimeout() >> 16), (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {2099637469, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.normalizeMetaState(0), 18 - View.getDefaultSize(0, 0), (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b9 = (byte) (getAuthRequestContext[5] + 1);
                byte b10 = b9;
                Object[] objArr25 = new Object[1];
                b(b9, b10, b10, objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b11 = (byte) (-getAuthRequestContext[5]);
                byte b12 = b11;
                Object[] objArr26 = new Object[1];
                b(b11, b12, (byte) (b12 - 1), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - Color.argb(0, 0, 0, 0), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 2, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 38967));
                        Object[] objArr28 = new Object[1];
                        c((byte) ($$a[47] - 1), (byte) (-$$a[8]), (byte) (-$$a[28]), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, View.resolveSize(0, 0) + 35, (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {2099637469, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 910, Color.green(0) + 18, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b13 = (byte) (getAuthRequestContext[5] + 1);
                byte b14 = b13;
                Object[] objArr31 = new Object[1];
                b(b13, b14, b14, objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b15 = (byte) (-getAuthRequestContext[5]);
                byte b16 = b15;
                Object[] objArr32 = new Object[1];
                b(b15, b16, (byte) (b16 - 1), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - View.resolveSize(0, 0), TextUtils.lastIndexOf("", '0', 0, 0) + 4, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16));
                        Object[] objArr34 = new Object[1];
                        c((byte) (-$$a[9]), (byte) ($$a[47] - 1), $$a[40], objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getLongPressTimeout() >> 16) + 35, (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {2099637469, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0', 0, 0), 18 - (Process.myTid() >> 22), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    static {
        PlaceComponentResult();
        SERVICE_CLASSES = new Class[]{Lite1.class, Lite2.class, Lite3.class};
    }

    @Override // android.app.Service
    public void onCreate() {
        try {
            byte b = (byte) (getAuthRequestContext[5] + 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            b(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (-getAuthRequestContext[5]);
            byte b4 = b3;
            Object[] objArr2 = new Object[1];
            b(b3, b4, (byte) (b4 - 1), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.argb(0, 0, 0, 0) + 494, View.resolveSize(0, 0) + 4, (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1));
                    Object[] objArr4 = new Object[1];
                    c((byte) (-$$a[9]), (byte) ($$a[47] - 1), $$a[40], objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (Process.myPid() >> 22) + 35, (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-1797683940, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ((byte) KeyEvent.getModifierMetaStateMask()), 17 - TextUtils.lastIndexOf("", '0'), (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                RVLogger.d("AriverInt:IpcMsgClientService", "onCreate");
                this.f6428a = new IIpcChannel.Stub() { // from class: com.alibaba.griver.core.kernel.ipc.client.IpcMsgClientService.1
                    @Override // com.alibaba.ariver.kernel.api.IIpcChannel
                    public void sendMessage(IpcMessage ipcMessage) throws RemoteException {
                        ClientMsgReceiver.getInstance().handleMessage(ipcMessage);
                    }

                    @Override // com.alibaba.ariver.kernel.api.IIpcChannel
                    public boolean isFinishing() throws RemoteException {
                        WeakReference<Activity> topActivity = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getTopActivity();
                        return topActivity.get() != null && topActivity.get().isFinishing();
                    }
                };
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
    public IBinder onBind(Intent intent) {
        RVLogger.d("AriverInt:IpcMsgClientService", "onBind");
        return this.f6428a.asBinder();
    }

    /* loaded from: classes3.dex */
    public static class Lite1 extends IpcMsgClientService {
        public static final byte[] $$d = {86, TarHeader.LF_NORMAL, -68, 79, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
        public static final int $$e = 132;
        public static final byte[] PlaceComponentResult = {11, -83, -14, 91, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
        public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 213;
        private static char scheduleImpl = 47607;
        private static char BuiltInFictitiousFunctionClassFactory = 1896;
        private static char lookAheadTest = 18461;
        private static char getErrorConfigVersion = 41230;

        /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0033). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void f(byte r7, short r8, int r9, java.lang.Object[] r10) {
            /*
                int r8 = r8 * 15
                int r8 = 18 - r8
                int r9 = r9 * 3
                int r9 = 16 - r9
                int r7 = r7 + 105
                byte[] r0 = com.alibaba.griver.core.kernel.ipc.client.IpcMsgClientService.Lite1.PlaceComponentResult
                byte[] r1 = new byte[r9]
                r2 = 0
                if (r0 != 0) goto L18
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r10
                r10 = r9
                r9 = r8
                goto L33
            L18:
                r3 = 0
            L19:
                int r8 = r8 + 1
                int r4 = r3 + 1
                byte r5 = (byte) r7
                r1[r3] = r5
                if (r4 != r9) goto L2a
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L2a:
                r3 = r0[r8]
                r6 = r9
                r9 = r8
                r8 = r3
                r3 = r1
                r1 = r0
                r0 = r10
                r10 = r6
            L33:
                int r7 = r7 + r8
                int r7 = r7 + 2
                r8 = r9
                r9 = r10
                r10 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L19
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.kernel.ipc.client.IpcMsgClientService.Lite1.f(byte, short, int, java.lang.Object[]):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0033). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void g(short r6, byte r7, byte r8, java.lang.Object[] r9) {
            /*
                int r6 = r6 * 2
                int r6 = 103 - r6
                byte[] r0 = com.alibaba.griver.core.kernel.ipc.client.IpcMsgClientService.Lite1.$$d
                int r7 = r7 * 3
                int r7 = 42 - r7
                int r8 = r8 + 4
                byte[] r1 = new byte[r7]
                r2 = 0
                if (r0 != 0) goto L18
                r6 = r7
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r9
                r9 = r8
                goto L33
            L18:
                r3 = 0
            L19:
                byte r4 = (byte) r6
                r1[r3] = r4
                int r3 = r3 + 1
                if (r3 != r7) goto L28
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L28:
                r4 = r0[r8]
                r5 = r8
                r8 = r6
                r6 = r7
                r7 = r4
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r9
                r9 = r5
            L33:
                int r7 = -r7
                int r8 = r8 + r7
                int r7 = r8 + (-7)
                int r8 = r9 + 1
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                r5 = r7
                r7 = r6
                r6 = r5
                goto L19
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.kernel.ipc.client.IpcMsgClientService.Lite1.g(short, byte, byte, java.lang.Object[]):void");
        }

        @Override // com.alibaba.griver.core.kernel.ipc.client.IpcMsgClientService, android.app.Service, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            Object[] objArr;
            Object[] objArr2;
            Object[] objArr3;
            Object[] objArr4;
            super.attachBaseContext(context);
            Object[] objArr5 = new Object[1];
            e((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 17, new char[]{16759, 5957, 41262, 49553, 56939, 41408, 58132, 54680, 23944, 36948, 20378, 50196, 25462, 17070, 60573, 59278, 6740, 65125}, objArr5);
            Class<?> cls = Class.forName((String) objArr5[0]);
            Object[] objArr6 = new Object[1];
            e((ViewConfiguration.getScrollBarSize() >> 8) + 5, new char[]{51141, 58351, 61747, 37146, 22174, 59235}, objArr6);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context applicationContext = context != null ? context.getApplicationContext() : context;
                if (applicationContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - TextUtils.getOffsetBefore("", 0), (char) (Process.myTid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        e((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 48, new char[]{27634, 29295, 12798, 11572, 35013, 28928, 41301, 58567, 18017, 46091, 8927, 16199, 25273, 9865, 32852, 43553, 13834, 55212, 57458, 37394, 50199, 27741, 1515, 14804, 4526, 52600, 26874, 35755, 40894, 61888, 9650, 61883, 26400, 22270, 3525, 30577, 144, 57701, 15313, 62748, 43419, 63337, 39504, 28983, 44376, 30906, 21576, 50773}, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        e((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 63, new char[]{48780, 6891, 49029, 40480, 144, 57701, 45368, 60534, 50199, 27741, 15200, 56285, 42315, 17142, 53978, 62486, 45224, 3069, 59816, 21460, 42315, 17142, 61344, 20921, 18476, 5859, 19648, 45263, 26874, 35755, 45224, 3069, 35034, 54515, 30411, 38859, 9272, 14450, 9773, 23489, 27195, 51890, 65233, 41739, 30300, 25072, 34234, 53676, 15165, 65215, 32639, 31156, 34727, 36101, 14858, 35929, 14858, 35929, 21654, 27762, 47620, 21585, 4526, 52600}, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        e(64 - TextUtils.indexOf("", "", 0, 0), new char[]{55853, 29070, 9712, 23841, 34727, 36101, 48502, 40501, 22166, 46357, 44058, 13570, 56068, 22443, 58415, 52214, 9650, 61883, 52330, 55984, 45484, 15493, 47336, 22147, 43419, 63337, 41301, 58567, 65487, 26623, 27634, 29295, 49789, 60316, 22067, 6834, 15916, 26826, 12798, 11572, 50378, 11173, 53978, 62486, 15313, 62748, 10736, 34851, 144, 57701, 60573, 59278, 55853, 29070, 39454, 60565, 21878, 60382, 26400, 22270, 39454, 60565, 50583, 10948}, objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        e(60 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), new char[]{35486, 9540, 24305, 38274, 28132, 30334, 15478, 64596, 52104, 21961, 60203, 39652, 29886, 23765, 61190, 32178, 10627, 36779, 5788, 13000, 15133, 6262, 64301, 27492, 53369, 58505, 2439, 47084, 5781, 39402, 32691, 18393, 2439, 47084, 52871, 24629, 17248, 1300, 2368, 32863, 57490, 29715, 25378, 23375, 58528, 22994, 48386, 53048, 11941, 42799, 384, 7549, 36293, 9525, 55942, 56089, 30320, 15761, 32295, 42185}, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        e(TextUtils.lastIndexOf("", '0', 0) + 7, new char[]{41470, 8825, 15365, 46197, 55853, 29070}, objArr11);
                        try {
                            Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + 911, ImageFormat.getBitsPerPixel(0) + 19, (char) TextUtils.indexOf("", "", 0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                    byte b = (byte) (-PlaceComponentResult[5]);
                    byte b2 = (byte) (b - 1);
                    Object[] objArr13 = new Object[1];
                    f(b, b2, b2, objArr13);
                    Class<?> cls2 = Class.forName((String) objArr13[0]);
                    byte b3 = (byte) (PlaceComponentResult[5] + 1);
                    byte b4 = (byte) (-PlaceComponentResult[5]);
                    Object[] objArr14 = new Object[1];
                    f(b3, b4, (byte) (b4 - 1), objArr14);
                    try {
                        Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                        if (obj3 == null) {
                            Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(54 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 4, (char) TextUtils.indexOf("", "", 0, 0));
                            Object[] objArr16 = new Object[1];
                            g((byte) (-$$d[12]), $$d[68], (byte) ($$d[47] - 1), objArr16);
                            obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                        }
                        Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - TextUtils.getCapsMode("", 0, 0), Color.red(0) + 15, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("getAuthRequestContext", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                            }
                            int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                            try {
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + 800, 14 - TextUtils.lastIndexOf("", '0', 0, 0), (char) KeyEvent.keyCodeFromString(""))).getMethod("PlaceComponentResult", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                                }
                                if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                    ArrayList arrayList = new ArrayList();
                                    try {
                                        Object[] objArr17 = {invoke2};
                                        Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                        if (obj6 == null) {
                                            obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 815, Gravity.getAbsoluteGravity(0, 0) + 29, (char) (57994 - TextUtils.getOffsetBefore("", 0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), Drawable.resolveOpacity(0, 0) + 15, (char) (ViewConfiguration.getJumpTapTimeout() >> 16)));
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                        }
                                        arrayList.add(((Method) obj6).invoke(null, objArr17));
                                        long j = ((r5 ^ intValue2) & 4294967295L) | 60129542144L;
                                        try {
                                            Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                            if (obj7 != null) {
                                                objArr = null;
                                            } else {
                                                objArr = null;
                                                obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getOffsetBefore("", 0), 36 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                            }
                                            Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                            try {
                                                Object[] objArr18 = {651362788, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                                Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                                if (obj8 == null) {
                                                    obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 910, 17 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) TextUtils.indexOf("", ""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    Object[] objArr19 = {this};
                    byte b5 = (byte) (-PlaceComponentResult[5]);
                    byte b6 = (byte) (b5 - 1);
                    Object[] objArr20 = new Object[1];
                    f(b5, b6, b6, objArr20);
                    Class<?> cls4 = Class.forName((String) objArr20[0]);
                    byte b7 = (byte) (PlaceComponentResult[5] + 1);
                    byte b8 = (byte) (-PlaceComponentResult[5]);
                    Object[] objArr21 = new Object[1];
                    f(b7, b8, (byte) (b8 - 1), objArr21);
                    try {
                        Object[] objArr22 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr21[0], Object.class).invoke(null, objArr19)).intValue())};
                        Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                        if (obj9 == null) {
                            Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - Color.argb(0, 0, 0, 0), View.getDefaultSize(0, 0) + 46, (char) TextUtils.getTrimmedLength(""));
                            byte b9 = (byte) ($$d[47] - 1);
                            byte b10 = (byte) (-$$d[8]);
                            Object[] objArr23 = new Object[1];
                            g(b9, b10, (byte) (b10 | 16), objArr23);
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
                                    objArr4 = null;
                                } else {
                                    objArr4 = null;
                                    obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776287) - Color.rgb(0, 0, 0), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 34, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                                }
                                Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                                try {
                                    Object[] objArr25 = {651362788, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj11 == null) {
                                        obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 910, TextUtils.lastIndexOf("", '0', 0, 0) + 19, (char) TextUtils.getCapsMode("", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    Object[] objArr26 = {this};
                    byte b11 = (byte) (-PlaceComponentResult[5]);
                    byte b12 = (byte) (b11 - 1);
                    Object[] objArr27 = new Object[1];
                    f(b11, b12, b12, objArr27);
                    Class<?> cls6 = Class.forName((String) objArr27[0]);
                    byte b13 = (byte) (PlaceComponentResult[5] + 1);
                    byte b14 = (byte) (-PlaceComponentResult[5]);
                    Object[] objArr28 = new Object[1];
                    f(b13, b14, (byte) (b14 - 1), objArr28);
                    try {
                        Object[] objArr29 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr28[0], Object.class).invoke(null, objArr26)).intValue())};
                        Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                        if (obj12 == null) {
                            Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + 118, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 2, (char) (View.MeasureSpec.getSize(0) + 38968));
                            byte b15 = (byte) ($$d[47] - 1);
                            byte b16 = (byte) (-$$d[8]);
                            Object[] objArr30 = new Object[1];
                            g(b15, b16, (byte) (b16 | 16), objArr30);
                            obj12 = cls7.getMethod((String) objArr30[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                        }
                        Object[] objArr31 = (Object[]) ((Method) obj12).invoke(null, objArr29);
                        int i2 = ((int[]) objArr31[1])[0];
                        if (((int[]) objArr31[0])[0] != i2) {
                            long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                            try {
                                Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj13 != null) {
                                    objArr3 = null;
                                } else {
                                    objArr3 = null;
                                    obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - View.combineMeasuredStates(0, 0), (char) View.combineMeasuredStates(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                                }
                                Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                                try {
                                    Object[] objArr32 = {651362788, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj14 == null) {
                                        obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getEdgeSlop() >> 16), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 18, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                    }
                                    ((Method) obj14).invoke(invoke5, objArr32);
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
                    Object[] objArr33 = {this};
                    byte b17 = (byte) (-PlaceComponentResult[5]);
                    byte b18 = (byte) (b17 - 1);
                    Object[] objArr34 = new Object[1];
                    f(b17, b18, b18, objArr34);
                    Class<?> cls8 = Class.forName((String) objArr34[0]);
                    byte b19 = (byte) (PlaceComponentResult[5] + 1);
                    byte b20 = (byte) (-PlaceComponentResult[5]);
                    Object[] objArr35 = new Object[1];
                    f(b19, b20, (byte) (b20 - 1), objArr35);
                    try {
                        Object[] objArr36 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr35[0], Object.class).invoke(null, objArr33)).intValue())};
                        Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                        if (obj15 == null) {
                            Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - KeyEvent.keyCodeFromString(""), 3 - ((Process.getThreadPriority(0) + 20) >> 6), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                            Object[] objArr37 = new Object[1];
                            g((byte) (-$$d[9]), (byte) ($$d[47] - 1), (byte) (-$$d[53]), objArr37);
                            obj15 = cls9.getMethod((String) objArr37[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                        }
                        Object[] objArr38 = (Object[]) ((Method) obj15).invoke(null, objArr36);
                        int i3 = ((int[]) objArr38[1])[0];
                        if (((int[]) objArr38[0])[0] != i3) {
                            long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                            try {
                                Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj16 != null) {
                                    objArr2 = null;
                                } else {
                                    objArr2 = null;
                                    obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0', 0), TextUtils.indexOf((CharSequence) "", '0', 0) + 36, (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                                }
                                Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                                try {
                                    Object[] objArr39 = {651362788, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj17 == null) {
                                        obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + 911, 18 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) ((-1) - Process.getGidForName("")))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                    }
                                    ((Method) obj17).invoke(invoke6, objArr39);
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

        @Override // com.alibaba.griver.core.kernel.ipc.client.IpcMsgClientService, android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return super.getApplicationContext();
        }

        @Override // com.alibaba.griver.core.kernel.ipc.client.IpcMsgClientService, android.content.ContextWrapper
        public Context getBaseContext() {
            return super.getBaseContext();
        }

        @Override // com.alibaba.griver.core.kernel.ipc.client.IpcMsgClientService, android.content.ContextWrapper, android.content.Context
        public Resources getResources() {
            return super.getResources();
        }

        @Override // com.alibaba.griver.core.kernel.ipc.client.IpcMsgClientService, android.app.Service
        public void onCreate() {
            try {
                byte b = (byte) (-PlaceComponentResult[5]);
                byte b2 = (byte) (b - 1);
                Object[] objArr = new Object[1];
                f(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (PlaceComponentResult[5] + 1);
                byte b4 = (byte) (-PlaceComponentResult[5]);
                Object[] objArr2 = new Object[1];
                f(b3, b4, (byte) (b4 - 1), objArr2);
                try {
                    Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj == null) {
                        Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(493 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 4 - TextUtils.getOffsetBefore("", 0), (char) (ViewConfiguration.getEdgeSlop() >> 16));
                        Object[] objArr4 = new Object[1];
                        g((byte) (-$$d[9]), (byte) ($$d[47] - 1), (byte) (-$$d[53]), objArr4);
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
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, TextUtils.indexOf("", "", 0, 0) + 35, (char) Color.alpha(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                            }
                            Object invoke = ((Method) obj2).invoke(null, null);
                            try {
                                Object[] objArr6 = {839159253, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj3 == null) {
                                    obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + 911, 18 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) TextUtils.indexOf("", ""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

        private static void e(int i, char[] cArr, Object[] objArr) {
            C c = new C();
            char[] cArr2 = new char[cArr.length];
            c.BuiltInFictitiousFunctionClassFactory = 0;
            char[] cArr3 = new char[2];
            while (c.BuiltInFictitiousFunctionClassFactory < cArr.length) {
                cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
                int i2 = 58224;
                for (int i3 = 0; i3 < 16; i3++) {
                    cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i2) ^ ((cArr3[0] << 4) + ((char) (getErrorConfigVersion ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (lookAheadTest ^ 6353485791441662354L)))));
                    cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i2) ^ ((cArr3[1] << 4) + ((char) (BuiltInFictitiousFunctionClassFactory ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (scheduleImpl ^ 6353485791441662354L)))));
                    i2 -= 40503;
                }
                cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
                cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
                c.BuiltInFictitiousFunctionClassFactory += 2;
            }
            objArr[0] = new String(cArr2, 0, i);
        }
    }

    /* loaded from: classes3.dex */
    public static class Lite2 extends IpcMsgClientService {
        public static final byte[] $$d = {11, -83, -14, 91, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
        public static final int $$e = 232;
        public static final byte[] BuiltInFictitiousFunctionClassFactory = {TarHeader.LF_CHR, -70, 75, 72, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
        public static final int PlaceComponentResult = 72;
        private static char[] KClassImpl$Data$declaredNonStaticMembers$2 = {39477, 39462, 39472, 39458, 39463, 39469, 39910, 39459, 39876, 39475, 39473, 39465, 39453, 39873, 39903, 39902, 39900, 39908, 39901, 39470, 39906, 39909, 39907, 39904, 39474, 39905, 39468, 39456, 39460, 39898, 39911, 39471, 39457, 39461, 39454};
        private static boolean lookAheadTest = true;
        private static boolean getErrorConfigVersion = true;
        private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 909155220;

        /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x0037). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void f(int r6, short r7, byte r8, java.lang.Object[] r9) {
            /*
                int r7 = r7 * 15
                int r7 = r7 + 4
                byte[] r0 = com.alibaba.griver.core.kernel.ipc.client.IpcMsgClientService.Lite2.BuiltInFictitiousFunctionClassFactory
                int r6 = r6 + 105
                int r8 = r8 * 2
                int r8 = r8 + 16
                byte[] r1 = new byte[r8]
                int r8 = r8 + (-1)
                r2 = 0
                if (r0 != 0) goto L1a
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r9
                r9 = r8
                r8 = r7
                goto L37
            L1a:
                r3 = 0
            L1b:
                r5 = r7
                r7 = r6
                r6 = r5
                byte r4 = (byte) r7
                r1[r3] = r4
                int r4 = r3 + 1
                if (r3 != r8) goto L2d
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L2d:
                r3 = r0[r6]
                r5 = r7
                r7 = r6
                r6 = r3
                r3 = r1
                r1 = r0
                r0 = r9
                r9 = r8
                r8 = r5
            L37:
                int r6 = -r6
                int r7 = r7 + 1
                int r8 = r8 + r6
                int r6 = r8 + 2
                r8 = r9
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L1b
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.kernel.ipc.client.IpcMsgClientService.Lite2.f(int, short, byte, java.lang.Object[]):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x002d). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void g(byte r7, int r8, int r9, java.lang.Object[] r10) {
            /*
                int r7 = r7 + 4
                byte[] r0 = com.alibaba.griver.core.kernel.ipc.client.IpcMsgClientService.Lite2.$$d
                int r9 = r9 * 3
                int r9 = r9 + 21
                int r8 = r8 * 2
                int r8 = r8 + 75
                byte[] r1 = new byte[r9]
                r2 = 0
                if (r0 != 0) goto L15
                r3 = r8
                r5 = 0
                r8 = r7
                goto L2d
            L15:
                r3 = 0
            L16:
                r6 = r8
                r8 = r7
                r7 = r6
                byte r4 = (byte) r7
                int r5 = r3 + 1
                r1[r3] = r4
                if (r5 != r9) goto L28
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L28:
                r3 = r0[r8]
                r6 = r8
                r8 = r7
                r7 = r6
            L2d:
                int r7 = r7 + 1
                int r3 = -r3
                int r8 = r8 + r3
                int r8 = r8 + (-7)
                r3 = r5
                goto L16
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.kernel.ipc.client.IpcMsgClientService.Lite2.g(byte, int, int, java.lang.Object[]):void");
        }

        @Override // com.alibaba.griver.core.kernel.ipc.client.IpcMsgClientService, android.app.Service, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            Object[] objArr;
            Object[] objArr2;
            Object[] objArr3;
            Object[] objArr4;
            super.attachBaseContext(context);
            Object[] objArr5 = new Object[1];
            e(null, (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 127, new byte[]{-120, -120, -117, -118, -123, -124, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr5);
            Class<?> cls = Class.forName((String) objArr5[0]);
            Object[] objArr6 = new Object[1];
            e(null, AndroidCharacter.getMirror('0') + 'O', new byte[]{-125, -122, -114, -115, -116}, null, objArr6);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context applicationContext = context != null ? context.getApplicationContext() : context;
                if (applicationContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), View.resolveSize(0, 0) + 35, (char) Color.argb(0, 0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        e(null, TextUtils.getTrimmedLength("") + 127, new byte[]{-117, -112, -105, -103, -112, -104, -108, -113, -110, -111, -109, -108, -109, -107, -112, -109, -117, -127, -125, -107, -125, -111, -105, -125, -112, -118, -118, -125, -127, -112, -106, -106, -112, -106, -107, -117, -108, -118, -117, -113, -111, -109, -125, -110, -111, -112, -118, -113}, null, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        e(null, 126 - TextUtils.indexOf((CharSequence) "", '0'), new byte[]{-105, -125, -111, -106, -103, -118, -106, -110, -106, -110, -113, -109, -109, -113, -105, -105, -113, -106, -113, -118, -106, -117, -110, -102, -105, -110, -118, -118, -111, -104, -125, -118, -107, -107, -125, -111, -117, -109, -103, -112, -105, -112, -106, -125, -106, -108, -107, -107, -104, -106, -106, -125, -102, -109, -118, -125, -111, -110, -109, -108, -125, -112, -102, -127}, null, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        e(null, TextUtils.getCapsMode("", 0, 0) + 127, new byte[]{-109, -102, -102, -108, -112, -109, -102, -113, -102, -108, -106, -107, -117, -118, -109, -108, -103, -127, -110, -111, -104, -106, -108, -111, -111, -112, -113, -103, -111, -107, -125, -113, -118, -113, -108, -108, -111, -109, -108, -113, -105, -127, -103, -107, -125, -104, -117, -127, -113, -110, -105, -106, -106, -111, -111, -111, -104, -107, -113, -109, -103, -117, -106, -107}, null, objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        e(null, 127 - Color.argb(0, 0, 0, 0), new byte[]{-120, -100, -126, -117, -93, -117, -97, -107, -93, -97, -100, -120, -117, -96, -126, -122, -97, -122, -99, -127, -97, -116, -123, -118, -121, -117, -124, -127, -95, -94, -120, -125, -124, -127, -95, -96, -121, -100, -120, -127, -118, -100, -127, -117, -124, -101, -100, -121, -127, -126, -127, -125, -97, -97, -98, -120, -99, -100, -100, -101}, null, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        e(null, 128 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), new byte[]{-106, -107, -121, -104, -121, -109}, null, objArr11);
                        try {
                            Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), 18 - (Process.myPid() >> 22), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                    byte b = BuiltInFictitiousFunctionClassFactory[5];
                    byte b2 = b;
                    Object[] objArr13 = new Object[1];
                    f(b, b2, (byte) (b2 - 1), objArr13);
                    Class<?> cls2 = Class.forName((String) objArr13[0]);
                    byte b3 = (byte) (BuiltInFictitiousFunctionClassFactory[5] - 1);
                    byte b4 = b3;
                    Object[] objArr14 = new Object[1];
                    f(b3, b4, b4, objArr14);
                    try {
                        Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                        if (obj3 == null) {
                            Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 54, 4 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (ViewConfiguration.getLongPressTimeout() >> 16));
                            byte b5 = (byte) ($$d[47] - 1);
                            byte b6 = $$d[47];
                            Object[] objArr16 = new Object[1];
                            g(b5, b6, b6, objArr16);
                            obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                        }
                        Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + 800, 15 - KeyEvent.getDeadChar(0, 0), (char) TextUtils.getOffsetAfter("", 0))).getMethod("getAuthRequestContext", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                            }
                            int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                            try {
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, 14 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) TextUtils.getTrimmedLength(""))).getMethod("PlaceComponentResult", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                                }
                                if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                    ArrayList arrayList = new ArrayList();
                                    try {
                                        Object[] objArr17 = {invoke2};
                                        Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                        if (obj6 == null) {
                                            obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(814 - TextUtils.lastIndexOf("", '0', 0, 0), TextUtils.indexOf((CharSequence) "", '0') + 30, (char) (57994 - (ViewConfiguration.getMinimumFlingVelocity() >> 16)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getTrimmedLength("") + 800, TextUtils.indexOf((CharSequence) "", '0') + 16, (char) View.resolveSize(0, 0)));
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
                                                obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 35 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                            }
                                            Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                            try {
                                                Object[] objArr18 = {-551545377, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                                Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                                if (obj8 == null) {
                                                    obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getWindowTouchSlop() >> 8), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 18, (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    byte b7 = BuiltInFictitiousFunctionClassFactory[5];
                    byte b8 = b7;
                    Object[] objArr19 = new Object[1];
                    f(b7, b8, (byte) (b8 - 1), objArr19);
                    Class<?> cls4 = Class.forName((String) objArr19[0]);
                    byte b9 = (byte) (BuiltInFictitiousFunctionClassFactory[5] - 1);
                    byte b10 = b9;
                    Object[] objArr20 = new Object[1];
                    f(b9, b10, b10, objArr20);
                    try {
                        Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                        Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                        if (obj9 == null) {
                            Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myTid() >> 22) + 61, 47 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) ((-1) - Process.getGidForName("")));
                            Object[] objArr22 = new Object[1];
                            g((byte) 23, (byte) (-$$d[2]), (byte) ($$d[47] - 1), objArr22);
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
                                    obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 881, 35 - View.resolveSize(0, 0), (char) View.MeasureSpec.getSize(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                                }
                                Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                                try {
                                    Object[] objArr24 = {-551545377, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj11 == null) {
                                        obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getTapTimeout() >> 16), 19 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    byte b11 = BuiltInFictitiousFunctionClassFactory[5];
                    byte b12 = b11;
                    Object[] objArr25 = new Object[1];
                    f(b11, b12, (byte) (b12 - 1), objArr25);
                    Class<?> cls6 = Class.forName((String) objArr25[0]);
                    byte b13 = (byte) (BuiltInFictitiousFunctionClassFactory[5] - 1);
                    byte b14 = b13;
                    Object[] objArr26 = new Object[1];
                    f(b13, b14, b14, objArr26);
                    try {
                        Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                        Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                        if (obj12 == null) {
                            Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(117 - TextUtils.lastIndexOf("", '0', 0, 0), TextUtils.indexOf((CharSequence) "", '0') + 4, (char) (38968 - View.MeasureSpec.makeMeasureSpec(0, 0)));
                            Object[] objArr28 = new Object[1];
                            g((byte) 23, (byte) (-$$d[2]), (byte) ($$d[47] - 1), objArr28);
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
                                    obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, (KeyEvent.getMaxKeyCode() >> 16) + 35, (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                                }
                                Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                                try {
                                    Object[] objArr30 = {-551545377, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj14 == null) {
                                        obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (ViewConfiguration.getFadingEdgeLength() >> 16) + 18, (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    byte b15 = BuiltInFictitiousFunctionClassFactory[5];
                    byte b16 = b15;
                    Object[] objArr31 = new Object[1];
                    f(b15, b16, (byte) (b16 - 1), objArr31);
                    Class<?> cls8 = Class.forName((String) objArr31[0]);
                    byte b17 = (byte) (BuiltInFictitiousFunctionClassFactory[5] - 1);
                    byte b18 = b17;
                    Object[] objArr32 = new Object[1];
                    f(b17, b18, b18, objArr32);
                    try {
                        Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                        Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                        if (obj15 == null) {
                            Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + 107, 3 - KeyEvent.normalizeMetaState(0), (char) ((-1) - ImageFormat.getBitsPerPixel(0)));
                            Object[] objArr34 = new Object[1];
                            g((byte) (-$$d[53]), (byte) ($$d[47] - 1), (byte) (-$$d[8]), objArr34);
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
                                    obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.indexOf("", "", 0, 0) + 35, (char) KeyEvent.getDeadChar(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                                }
                                Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                                try {
                                    Object[] objArr36 = {-551545377, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj17 == null) {
                                        obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.blue(0), TextUtils.getCapsMode("", 0, 0) + 18, (char) Color.red(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

        @Override // com.alibaba.griver.core.kernel.ipc.client.IpcMsgClientService, android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return super.getApplicationContext();
        }

        @Override // com.alibaba.griver.core.kernel.ipc.client.IpcMsgClientService, android.content.ContextWrapper
        public Context getBaseContext() {
            return super.getBaseContext();
        }

        @Override // com.alibaba.griver.core.kernel.ipc.client.IpcMsgClientService, android.content.ContextWrapper, android.content.Context
        public Resources getResources() {
            return super.getResources();
        }

        @Override // com.alibaba.griver.core.kernel.ipc.client.IpcMsgClientService, android.app.Service
        public void onCreate() {
            try {
                byte b = BuiltInFictitiousFunctionClassFactory[5];
                byte b2 = b;
                Object[] objArr = new Object[1];
                f(b, b2, (byte) (b2 - 1), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (BuiltInFictitiousFunctionClassFactory[5] - 1);
                byte b4 = b3;
                Object[] objArr2 = new Object[1];
                f(b3, b4, b4, objArr2);
                try {
                    Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj == null) {
                        Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + 494, 4 - Color.red(0), (char) TextUtils.getTrimmedLength(""));
                        Object[] objArr4 = new Object[1];
                        g((byte) (-$$d[53]), (byte) ($$d[47] - 1), (byte) (-$$d[8]), objArr4);
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
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getFadingEdgeLength() >> 16) + 35, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                            }
                            Object invoke = ((Method) obj2).invoke(null, null);
                            try {
                                Object[] objArr6 = {1634783290, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj3 == null) {
                                    obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 19 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

        private static void e(int[] iArr, int i, byte[] bArr, char[] cArr, Object[] objArr) {
            BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
            char[] cArr2 = KClassImpl$Data$declaredNonStaticMembers$2;
            if (cArr2 != null) {
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                for (int i2 = 0; i2 < length; i2++) {
                    cArr3[i2] = (char) (cArr2[i2] ^ 4571606982258105150L);
                }
                cArr2 = cArr3;
            }
            int i3 = (int) (4571606982258105150L ^ NetworkUserEntityData$$ExternalSyntheticLambda0);
            if (getErrorConfigVersion) {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
                char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                    cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i3);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                }
                objArr[0] = new String(cArr4);
            } else if (lookAheadTest) {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
                char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                    cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                }
                objArr[0] = new String(cArr5);
            } else {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
                char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                    cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                }
                objArr[0] = new String(cArr6);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class Lite3 extends IpcMsgClientService {
        private static short[] getErrorConfigVersion;
        public static final byte[] $$d = {116, 58, -28, -63, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
        public static final int $$e = 138;
        public static final byte[] PlaceComponentResult = {56, -13, -61, 104, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
        public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 233;
        private static int lookAheadTest = 1257195755;
        private static int moveToNextValue = 568805628;
        private static byte[] scheduleImpl = {1, -115, -125, -113, 121, 112, -81, -81, TarHeader.LF_FIFO, -119, -52, 71, 118, 119, 112, -125, 123, Byte.MIN_VALUE, 14, 122, -107, 93, -115, 35, -115, -95, 115, -114, -96, 108, -115, -91, 90, 93, 113, -113, -91, 94, 95, 118, -90, 95, -112, 108, -114, -89, 109, -116, 113, -94, 93, -95, -119, -89, -94, 89, -89, 93, 111, 93, -95, 92, -116, 93, 93, 119, -106, 90, -96, 113, -114, 83, 118, -107, -66, 118, 70, -117, -72, 70, -72, SignedBytes.MAX_POWER_OF_TWO, 71, -71, -69, -67, -71, 69, -65, 67, 109, -117, 117, -116, 66, -69, -70, 116, -71, -110, -67, 105, -72, -120, -71, 119, -107, 106, -107, 110, -107, -70, 68, -68, 116, -118, 114, -115, -71, 71, -70, -71, 116, -106, 69, 111, 70, -107, -79, 78, 106, -69, -105, -72, 109, 83, -126, -122, 73, -74, 123, -126, 120, -124, 73, -77, 121, 75, -124, -84, 85, -126, -121, -73, 126, -126, -123, 77, -88, -122, -124, 121, 83, -84, Byte.MIN_VALUE, 72, -85, 82, -86, 87, -122, -88, 121, 85, -87, -126, 84, 121, -74, 72, -74, 73, -126, -84, -127, 123, -124, -122, Byte.MAX_VALUE, -122, -122, -126, -124, 125, 120, 81, 123, -78, 121, 87, -8, 1, 14, -24, 22, TarHeader.LF_LINK, -6, -69, SignedBytes.MAX_POWER_OF_TWO, -68, 6, 9, -7, -2, 2, 61, -63, -2, 8, TarHeader.LF_DIR, -59, -7, 11, TarHeader.LF_SYMLINK, -50, -12, 22, -21, 3, -7, 8, -11, 22, -21, 9, 62, -67, 6, Ascii.NAK, -7, -24, Ascii.DC4, -5, -12, 13, -13, 65, -54, -12, 10, -6, TarHeader.LF_SYMLINK, 7, -14, -64, 4, -5, 7, 11, 13, 85, -82, 80, -84, 95};
        private static int BuiltInFictitiousFunctionClassFactory = -1027237661;

        private static void f(byte b, int i, int i2, Object[] objArr) {
            int i3 = 19 - (b * 15);
            int i4 = 16 - (i * 2);
            int i5 = 106 - i2;
            byte[] bArr = PlaceComponentResult;
            byte[] bArr2 = new byte[i4];
            int i6 = -1;
            int i7 = i4 - 1;
            if (bArr == null) {
                i5 = i7 + i3 + 2;
                i3++;
                i7 = i7;
                objArr = objArr;
                bArr = bArr;
                bArr2 = bArr2;
                i6 = -1;
            }
            while (true) {
                int i8 = i6 + 1;
                bArr2[i8] = (byte) i5;
                if (i8 == i7) {
                    objArr[0] = new String(bArr2, 0);
                    return;
                }
                i5 = i5 + bArr[i3] + 2;
                i3++;
                i7 = i7;
                objArr = objArr;
                bArr = bArr;
                bArr2 = bArr2;
                i6 = i8;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x0037). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void g(int r6, int r7, byte r8, java.lang.Object[] r9) {
            /*
                int r6 = r6 + 4
                int r7 = r7 * 2
                int r7 = r7 + 75
                byte[] r0 = com.alibaba.griver.core.kernel.ipc.client.IpcMsgClientService.Lite3.$$d
                int r8 = r8 * 3
                int r8 = 42 - r8
                byte[] r1 = new byte[r8]
                int r8 = r8 + (-1)
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
                byte r4 = (byte) r7
                r1[r3] = r4
                int r6 = r6 + 1
                int r4 = r3 + 1
                if (r3 != r8) goto L2d
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L2d:
                r3 = r0[r6]
                r5 = r7
                r7 = r6
                r6 = r3
                r3 = r1
                r1 = r0
                r0 = r9
                r9 = r8
                r8 = r5
            L37:
                int r6 = -r6
                int r8 = r8 + r6
                int r6 = r8 + (-7)
                r8 = r9
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                r5 = r7
                r7 = r6
                r6 = r5
                goto L1c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.kernel.ipc.client.IpcMsgClientService.Lite3.g(int, int, byte, java.lang.Object[]):void");
        }

        @Override // com.alibaba.griver.core.kernel.ipc.client.IpcMsgClientService, android.app.Service, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            Object[] objArr;
            Object[] objArr2;
            Object[] objArr3;
            Object[] objArr4;
            super.attachBaseContext(context);
            Object[] objArr5 = new Object[1];
            e((short) (Process.myPid() >> 22), (byte) (TextUtils.indexOf("", "") + 18), (-117) - (ViewConfiguration.getTouchSlop() >> 8), KeyEvent.normalizeMetaState(0) + 2010460036, (-1795686402) - Drawable.resolveOpacity(0, 0), objArr5);
            Class<?> cls = Class.forName((String) objArr5[0]);
            Object[] objArr6 = new Object[1];
            e((short) KeyEvent.getDeadChar(0, 0), (byte) (ExpandableListView.getPackedPositionGroup(0L) + 30), (-117) - KeyEvent.keyCodeFromString(""), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 2010460054, (-1795686390) - (ViewConfiguration.getMinimumFlingVelocity() >> 16), objArr6);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context applicationContext = context != null ? context.getApplicationContext() : context;
                if (applicationContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        e((short) TextUtils.getTrimmedLength(""), (byte) (61 - (ViewConfiguration.getPressedStateDuration() >> 16)), TextUtils.getOffsetAfter("", 0) - 117, 2010460060 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (ViewConfiguration.getJumpTapTimeout() >> 16) - 1795686444, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        e((short) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), (byte) (38 - (ViewConfiguration.getPressedStateDuration() >> 16)), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) - 117, View.resolveSizeAndState(0, 0, 0) + 2010460107, (-1795686402) - View.MeasureSpec.getSize(0), objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        e((short) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1), (byte) (KeyEvent.getDeadChar(0, 0) + 25), (-116) - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 2010460170 - ExpandableListView.getPackedPositionChild(0L), (-1795686449) - (ViewConfiguration.getJumpTapTimeout() >> 16), objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        e((short) (Color.rgb(0, 0, 0) + 16777216), (byte) ((-104) - View.MeasureSpec.makeMeasureSpec(0, 0)), ((Process.getThreadPriority(0) + 20) >> 6) - 117, 2010460235 - KeyEvent.getDeadChar(0, 0), TextUtils.lastIndexOf("", '0', 0) - 1795686394, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        e((short) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1), (byte) (53 - View.resolveSize(0, 0)), (-117) - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), View.MeasureSpec.makeMeasureSpec(0, 0) + 2010460295, (ViewConfiguration.getMaximumFlingVelocity() >> 16) - 1795686442, objArr11);
                        try {
                            Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getTapTimeout() >> 16), View.resolveSizeAndState(0, 0, 0) + 18, (char) View.getDefaultSize(0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                    Object[] objArr13 = {this};
                    byte b = (byte) (PlaceComponentResult[5] + 1);
                    byte b2 = b;
                    Object[] objArr14 = new Object[1];
                    f(b, b2, b2, objArr14);
                    Class<?> cls2 = Class.forName((String) objArr14[0]);
                    byte b3 = (byte) (-PlaceComponentResult[5]);
                    Object[] objArr15 = new Object[1];
                    f(b3, (byte) (b3 - 1), (byte) (-PlaceComponentResult[5]), objArr15);
                    try {
                        Object[] objArr16 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr15[0], Object.class).invoke(null, objArr13)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                        if (obj3 == null) {
                            Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 54, ExpandableListView.getPackedPositionGroup(0L) + 3, (char) ExpandableListView.getPackedPositionGroup(0L));
                            Object[] objArr17 = new Object[1];
                            g($$d[78], $$d[47], $$d[68], objArr17);
                            obj3 = cls3.getMethod((String) objArr17[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                        }
                        Object invoke2 = ((Method) obj3).invoke(null, objArr16);
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), TextUtils.getOffsetBefore("", 0) + 15, (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("getAuthRequestContext", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                            }
                            int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                            try {
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 800, 15 - Color.green(0), (char) Color.alpha(0))).getMethod("PlaceComponentResult", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                                }
                                if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                    ArrayList arrayList = new ArrayList();
                                    try {
                                        Object[] objArr18 = {invoke2};
                                        Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                        if (obj6 == null) {
                                            obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + 815, View.MeasureSpec.makeMeasureSpec(0, 0) + 29, (char) (TextUtils.indexOf("", "") + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + 800, 16 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) TextUtils.getTrimmedLength("")));
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                        }
                                        arrayList.add(((Method) obj6).invoke(null, objArr18));
                                        long j = ((r8 ^ intValue2) & 4294967295L) | 60129542144L;
                                        try {
                                            Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                            if (obj7 != null) {
                                                objArr = null;
                                            } else {
                                                objArr = null;
                                                obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 36, (char) Color.blue(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                            }
                                            Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                            try {
                                                Object[] objArr19 = {296758462, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                                Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                                if (obj8 == null) {
                                                    obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 18 - ExpandableListView.getPackedPositionGroup(0L), (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    Object[] objArr20 = {this};
                    byte b4 = (byte) (PlaceComponentResult[5] + 1);
                    byte b5 = b4;
                    Object[] objArr21 = new Object[1];
                    f(b4, b5, b5, objArr21);
                    Class<?> cls4 = Class.forName((String) objArr21[0]);
                    byte b6 = (byte) (-PlaceComponentResult[5]);
                    Object[] objArr22 = new Object[1];
                    f(b6, (byte) (b6 - 1), (byte) (-PlaceComponentResult[5]), objArr22);
                    try {
                        Object[] objArr23 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr22[0], Object.class).invoke(null, objArr20)).intValue())};
                        Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                        if (obj9 == null) {
                            Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + 61, 46 - View.getDefaultSize(0, 0), (char) Color.blue(0));
                            Object[] objArr24 = new Object[1];
                            g((byte) (-$$d[28]), (byte) (-$$d[9]), (byte) (-$$d[8]), objArr24);
                            obj9 = cls5.getMethod((String) objArr24[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                        }
                        Object[] objArr25 = (Object[]) ((Method) obj9).invoke(null, objArr23);
                        int i = ((int[]) objArr25[1])[0];
                        if (((int[]) objArr25[0])[0] != i) {
                            long j2 = ((r2 ^ i) & 4294967295L) | 17179869184L;
                            try {
                                Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj10 != null) {
                                    objArr4 = null;
                                } else {
                                    objArr4 = null;
                                    obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - ((Process.getThreadPriority(0) + 20) >> 6), (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                                }
                                Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                                try {
                                    Object[] objArr26 = {296758462, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj11 == null) {
                                        obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ((byte) KeyEvent.getModifierMetaStateMask()), 18 - View.combineMeasuredStates(0, 0), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                    }
                                    ((Method) obj11).invoke(invoke4, objArr26);
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
                    Object[] objArr27 = {this};
                    byte b7 = (byte) (PlaceComponentResult[5] + 1);
                    byte b8 = b7;
                    Object[] objArr28 = new Object[1];
                    f(b7, b8, b8, objArr28);
                    Class<?> cls6 = Class.forName((String) objArr28[0]);
                    byte b9 = (byte) (-PlaceComponentResult[5]);
                    Object[] objArr29 = new Object[1];
                    f(b9, (byte) (b9 - 1), (byte) (-PlaceComponentResult[5]), objArr29);
                    try {
                        Object[] objArr30 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr29[0], Object.class).invoke(null, objArr27)).intValue())};
                        Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                        if (obj12 == null) {
                            Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(119 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (ViewConfiguration.getFadingEdgeLength() >> 16) + 3, (char) (TextUtils.lastIndexOf("", '0') + 38969));
                            Object[] objArr31 = new Object[1];
                            g((byte) (-$$d[28]), (byte) (-$$d[9]), (byte) (-$$d[8]), objArr31);
                            obj12 = cls7.getMethod((String) objArr31[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                        }
                        Object[] objArr32 = (Object[]) ((Method) obj12).invoke(null, objArr30);
                        int i2 = ((int[]) objArr32[1])[0];
                        if (((int[]) objArr32[0])[0] != i2) {
                            long j3 = ((r2 ^ i2) & 4294967295L) | 8589934592L;
                            try {
                                Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj13 != null) {
                                    objArr3 = null;
                                } else {
                                    objArr3 = null;
                                    obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.getSize(0), 35 - KeyEvent.normalizeMetaState(0), (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                                }
                                Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                                try {
                                    Object[] objArr33 = {296758462, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj14 == null) {
                                        obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ExpandableListView.getPackedPositionChild(0L), 18 - TextUtils.getOffsetAfter("", 0), (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                    }
                                    ((Method) obj14).invoke(invoke5, objArr33);
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
                    Object[] objArr34 = {this};
                    byte b10 = (byte) (PlaceComponentResult[5] + 1);
                    byte b11 = b10;
                    Object[] objArr35 = new Object[1];
                    f(b10, b11, b11, objArr35);
                    Class<?> cls8 = Class.forName((String) objArr35[0]);
                    byte b12 = (byte) (-PlaceComponentResult[5]);
                    Object[] objArr36 = new Object[1];
                    f(b12, (byte) (b12 - 1), (byte) (-PlaceComponentResult[5]), objArr36);
                    try {
                        Object[] objArr37 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr36[0], Object.class).invoke(null, objArr34)).intValue())};
                        Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                        if (obj15 == null) {
                            Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.combineMeasuredStates(0, 0) + 107, 2 - ImageFormat.getBitsPerPixel(0), (char) (ViewConfiguration.getLongPressTimeout() >> 16));
                            byte b13 = $$d[40];
                            byte b14 = (byte) ($$d[47] - 1);
                            Object[] objArr38 = new Object[1];
                            g(b13, b14, b14, objArr38);
                            obj15 = cls9.getMethod((String) objArr38[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                        }
                        Object[] objArr39 = (Object[]) ((Method) obj15).invoke(null, objArr37);
                        int i3 = ((int[]) objArr39[1])[0];
                        if (((int[]) objArr39[0])[0] != i3) {
                            long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                            try {
                                Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj16 != null) {
                                    objArr2 = null;
                                } else {
                                    objArr2 = null;
                                    obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 34, (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                                }
                                Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                                try {
                                    Object[] objArr40 = {296758462, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj17 == null) {
                                        obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + 911, (ViewConfiguration.getFadingEdgeLength() >> 16) + 18, (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                    }
                                    ((Method) obj17).invoke(invoke6, objArr40);
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

        @Override // com.alibaba.griver.core.kernel.ipc.client.IpcMsgClientService, android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return super.getApplicationContext();
        }

        @Override // com.alibaba.griver.core.kernel.ipc.client.IpcMsgClientService, android.content.ContextWrapper
        public Context getBaseContext() {
            return super.getBaseContext();
        }

        @Override // com.alibaba.griver.core.kernel.ipc.client.IpcMsgClientService, android.content.ContextWrapper, android.content.Context
        public Resources getResources() {
            return super.getResources();
        }

        @Override // com.alibaba.griver.core.kernel.ipc.client.IpcMsgClientService, android.app.Service
        public void onCreate() {
            try {
                byte b = (byte) (PlaceComponentResult[5] + 1);
                byte b2 = b;
                Object[] objArr = new Object[1];
                f(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (-PlaceComponentResult[5]);
                Object[] objArr2 = new Object[1];
                f(b3, (byte) (b3 - 1), (byte) (-PlaceComponentResult[5]), objArr2);
                try {
                    Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj == null) {
                        Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 494, (-16777212) - Color.rgb(0, 0, 0), (char) TextUtils.getOffsetAfter("", 0));
                        byte b4 = $$d[40];
                        byte b5 = (byte) ($$d[47] - 1);
                        Object[] objArr4 = new Object[1];
                        g(b4, b5, b5, objArr4);
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
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) View.resolveSizeAndState(0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                            }
                            Object invoke = ((Method) obj2).invoke(null, null);
                            try {
                                Object[] objArr6 = {1614775499, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj3 == null) {
                                    obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 18 - (Process.myTid() >> 22), (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

        private static void e(short s, byte b, int i, int i2, int i3, Object[] objArr) {
            B b2 = new B();
            StringBuilder sb = new StringBuilder();
            int i4 = i + ((int) (lookAheadTest ^ 3097486228508854431L));
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
                    i4 = (byte) (((byte) (scheduleImpl[i2 + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (lookAheadTest ^ 3097486228508854431L)));
                } else {
                    i4 = (short) (((short) (getErrorConfigVersion[i2 + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (lookAheadTest ^ 3097486228508854431L)));
                }
            }
            if (i4 > 0) {
                b2.getAuthRequestContext = ((i2 + i4) - 2) + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L)) + i5;
                b2.MyBillsEntityDataFactory = (char) (i3 + ((int) (moveToNextValue ^ 3097486228508854431L)));
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
                        short[] sArr = getErrorConfigVersion;
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

    private static void d(int i, int i2, byte b, short s, int i3, Object[] objArr) {
        B b2 = new B();
        StringBuilder sb = new StringBuilder();
        int i4 = i2 + ((int) (PlaceComponentResult ^ 3097486228508854431L));
        int i5 = i4 == -1 ? 1 : 0;
        if (i5 != 0) {
            byte[] bArr = getErrorConfigVersion;
            if (bArr != null) {
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                for (int i6 = 0; i6 < length; i6++) {
                    bArr2[i6] = (byte) (bArr[i6] ^ 3097486228508854431L);
                }
                bArr = bArr2;
            }
            if (bArr != null) {
                i4 = (byte) (((byte) (getErrorConfigVersion[i3 + ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (PlaceComponentResult ^ 3097486228508854431L)));
            } else {
                i4 = (short) (((short) (moveToNextValue[i3 + ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (PlaceComponentResult ^ 3097486228508854431L)));
            }
        }
        if (i4 > 0) {
            b2.getAuthRequestContext = ((i3 + i4) - 2) + ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3097486228508854431L)) + i5;
            b2.MyBillsEntityDataFactory = (char) (i + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L)));
            sb.append(b2.MyBillsEntityDataFactory);
            b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
            byte[] bArr3 = getErrorConfigVersion;
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
                    byte[] bArr5 = getErrorConfigVersion;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr5[r9] ^ 3097486228508854431L)) + s)) ^ b));
                } else {
                    short[] sArr = moveToNextValue;
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
