package com.alibaba.griver.device.jsapi.nfc.service;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.nfc.cardemulation.HostApduService;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.ResultReceiver;
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
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.JSON;
import com.alibaba.griver.device.jsapi.nfc.TinyAppConstants;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.mobile.verifyidentity.uitools.POPUIType;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.B;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes2.dex */
public class TinyAppHostApduService extends HostApduService {
    private static short[] getErrorConfigVersion;

    /* renamed from: a  reason: collision with root package name */
    private String f6511a = null;
    private ResultReceiver b;
    public static final byte[] $$a = {75, -120, 119, 39, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 44;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {4, -87, 42, 65, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 74;
    private static int MyBillsEntityDataFactory = 1257195656;
    private static int PlaceComponentResult = -1425737925;
    private static byte[] lookAheadTest = {100, Ascii.EM, -29, Ascii.ETB, 13, Ascii.DC4, -9, -9, 78, Ascii.GS, -40, 95, 14, 15, Ascii.DC4, -29, 11, -28, 113, -106, -19, -75, -59, -122, -38, -2, -112, -37, -3, -71, -38, -62, 103, 106, -114, -36, -62, 107, 108, -109, -61, 108, -83, -71, -37, -60, -70, -39, -114, -1, 106, -2, -42, -60, -1, 102, -60, 106, -68, 106, -2, 105, -39, 106, 106, -108, -77, 103, -3, -114, -37, -74, -106, 117, 78, -106, -122, 67, 80, -122, 80, -120, -121, 81, 83, 77, 81, -123, 79, -117, -99, 67, -107, 124, -118, 83, 82, -108, 81, 122, 77, 97, 80, SignedBytes.MAX_POWER_OF_TWO, 81, -105, 117, 98, 117, -98, 117, 82, -124, 76, -108, 66, -102, 125, 81, -121, 82, 81, -108, 118, -123, -97, -122, 117, 89, -66, 98, 83, 119, 80, -99, -74, -71, -75, 126, 101, TarHeader.LF_NORMAL, -71, 47, -77, 126, 104, 46, SignedBytes.MAX_POWER_OF_TWO, -77, -101, 66, -71, -76, 100, 45, -71, -78, 122, -97, -75, -77, 46, 72, -101, -73, Byte.MAX_VALUE, 96, 73, 97, 68, -75, -97, 46, 66, -98, -71, 67, 46, 101, Byte.MAX_VALUE, 101, 126, -71, -101, -74, TarHeader.LF_NORMAL, -77, -75, 44, -75, -75, -71, -77, 42, 47, 70, TarHeader.LF_NORMAL, 105, 46, -70, 107, 66, 121, -101, 81, TarHeader.LF_SYMLINK, 109, -84, 3, -89, 65, 122, 106, 105, 69, 38, -126, 105, 123, 46, -66, 106, 124, TarHeader.LF_DIR, -71, 111, 81, -100, 68, 106, 123, 110, 81, -100, 122, 41, -90, 65, 78, 106, -101, 79, 108, 111, 118, 116, 2, -67, 111, 125, 109, TarHeader.LF_DIR, SignedBytes.MAX_POWER_OF_TWO, 117, -125, Byte.MAX_VALUE, 108, SignedBytes.MAX_POWER_OF_TWO, 124, 112, -97, -86, 100, -88, -103};
    private static int getAuthRequestContext = -1265568718;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 + 105
            int r7 = r7 + 4
            int r6 = r6 * 4
            int r6 = 16 - r6
            byte[] r0 = com.alibaba.griver.device.jsapi.nfc.service.TinyAppHostApduService.BuiltInFictitiousFunctionClassFactory
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L32
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r3 = r3 + 1
            int r7 = r7 + 1
            if (r3 != r6) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L32:
            int r9 = r9 + r7
            int r7 = r9 + 2
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.device.jsapi.nfc.service.TinyAppHostApduService.c(byte, int, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0039). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(int r5, int r6, byte r7, java.lang.Object[] r8) {
        /*
            int r7 = r7 + 4
            byte[] r0 = com.alibaba.griver.device.jsapi.nfc.service.TinyAppHostApduService.$$a
            int r5 = r5 * 3
            int r5 = 42 - r5
            int r6 = r6 * 2
            int r6 = 103 - r6
            byte[] r1 = new byte[r5]
            r2 = -1
            int r5 = r5 + r2
            if (r0 != 0) goto L19
            r6 = r5
            r2 = r1
            r3 = -1
            r1 = r0
            r0 = r8
            r8 = r7
            goto L39
        L19:
            r4 = r7
            r7 = r6
        L1b:
            r6 = r4
            int r2 = r2 + 1
            byte r3 = (byte) r7
            r1[r2] = r3
            if (r2 != r5) goto L2c
            java.lang.String r5 = new java.lang.String
            r6 = 0
            r5.<init>(r1, r6)
            r8[r6] = r5
            return
        L2c:
            int r6 = r6 + 1
            r3 = r0[r6]
            r4 = r6
            r6 = r5
            r5 = r3
            r3 = r2
            r2 = r1
            r1 = r0
            r0 = r8
            r8 = r7
            r7 = r4
        L39:
            int r5 = -r5
            int r8 = r8 + r5
            int r5 = r8 + (-7)
            r8 = r0
            r0 = r1
            r1 = r2
            r2 = r3
            r4 = r7
            r7 = r5
            r5 = r6
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.device.jsapi.nfc.service.TinyAppHostApduService.d(int, int, byte, java.lang.Object[]):void");
    }

    @Override // android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        e((Process.myPid() >> 22) + 504643773, (-24) - View.combineMeasuredStates(0, 0), (byte) ((-4) - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), (short) (117 - TextUtils.indexOf((CharSequence) "", '0')), Color.green(0) + 25183059, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        e(View.getDefaultSize(0, 0) + 504643785, (-24) - (ViewConfiguration.getJumpTapTimeout() >> 16), (byte) (39 - TextUtils.indexOf((CharSequence) "", '0')), (short) ((-55) - TextUtils.lastIndexOf("", '0', 0, 0)), 8405861 - Color.rgb(0, 0, 0), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) TextUtils.getTrimmedLength(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    e((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 504643730, (-25) - ExpandableListView.getPackedPositionChild(0L), (byte) (52 - MotionEvent.axisFromString("")), (short) ((-43) - (ViewConfiguration.getTapTimeout() >> 16)), 25183083 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    e(504643773 - View.MeasureSpec.getSize(0), (-24) - (ViewConfiguration.getScrollDefaultDelay() >> 16), (byte) (((byte) KeyEvent.getModifierMetaStateMask()) - 37), (short) (11 - ExpandableListView.getPackedPositionChild(0L)), 25183130 - TextUtils.getCapsMode("", 0, 0), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    e(504643726 - Color.argb(0, 0, 0, 0), (-24) - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (byte) ((ViewConfiguration.getTouchSlop() >> 8) - 68), (short) ((ViewConfiguration.getTapTimeout() >> 16) - 110), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 25183194, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    e(504643780 - Color.argb(0, 0, 0, 0), AndroidCharacter.getMirror('0') - 'H', (byte) (View.MeasureSpec.makeMeasureSpec(0, 0) - 11), (short) (ExpandableListView.getPackedPositionType(0L) + 22), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 25183258, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    e(504643733 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (-24) - TextUtils.getOffsetBefore("", 0), (byte) (25 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), (short) ((-26) - ((byte) KeyEvent.getModifierMetaStateMask())), 25183318 - View.MeasureSpec.getSize(0), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.keyCodeFromString(""), Color.alpha(0) + 18, (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = (byte) (BuiltInFictitiousFunctionClassFactory[5] + 1);
                Object[] objArr13 = new Object[1];
                c(b, (byte) (b | 14), (byte) (-BuiltInFictitiousFunctionClassFactory[5]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b2 = (byte) (BuiltInFictitiousFunctionClassFactory[5] + 1);
                byte b3 = BuiltInFictitiousFunctionClassFactory[5];
                Object[] objArr14 = new Object[1];
                c(b2, b3, (byte) (b3 + 1), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + 56, 2 - TextUtils.indexOf((CharSequence) "", '0'), (char) (ViewConfiguration.getJumpTapTimeout() >> 16));
                        Object[] objArr16 = new Object[1];
                        d($$a[68], (byte) (-$$a[12]), $$a[78], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollDefaultDelay() >> 16) + 800, (ViewConfiguration.getWindowTouchSlop() >> 8) + 15, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, TextUtils.getOffsetBefore("", 0) + 15, (char) TextUtils.getCapsMode("", 0, 0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + 815, 29 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) (57995 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), 14 - ExpandableListView.getPackedPositionChild(0L), (char) (ViewConfiguration.getWindowTouchSlop() >> 8)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (Process.myPid() >> 22), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 34, (char) ExpandableListView.getPackedPositionType(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-1157468186, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + 911, 18 - KeyEvent.normalizeMetaState(0), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b4 = (byte) (BuiltInFictitiousFunctionClassFactory[5] + 1);
                Object[] objArr19 = new Object[1];
                c(b4, (byte) (b4 | 14), (byte) (-BuiltInFictitiousFunctionClassFactory[5]), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b5 = (byte) (BuiltInFictitiousFunctionClassFactory[5] + 1);
                byte b6 = BuiltInFictitiousFunctionClassFactory[5];
                Object[] objArr20 = new Object[1];
                c(b5, b6, (byte) (b6 + 1), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), Color.rgb(0, 0, 0) + 16777262, (char) TextUtils.indexOf("", "", 0));
                        Object[] objArr22 = new Object[1];
                        d((byte) (-$$a[8]), (byte) ($$a[47] - 1), (byte) (-$$a[28]), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 881, 35 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {-1157468186, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getTouchSlop() >> 8), 18 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b7 = (byte) (BuiltInFictitiousFunctionClassFactory[5] + 1);
                Object[] objArr25 = new Object[1];
                c(b7, (byte) (b7 | 14), (byte) (-BuiltInFictitiousFunctionClassFactory[5]), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b8 = (byte) (BuiltInFictitiousFunctionClassFactory[5] + 1);
                byte b9 = BuiltInFictitiousFunctionClassFactory[5];
                Object[] objArr26 = new Object[1];
                c(b8, b9, (byte) (b9 + 1), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - ExpandableListView.getPackedPositionGroup(0L), TextUtils.getTrimmedLength("") + 3, (char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 38968));
                        Object[] objArr28 = new Object[1];
                        d((byte) (-$$a[8]), (byte) ($$a[47] - 1), (byte) (-$$a[28]), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - KeyEvent.keyCodeFromString(""), (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-1157468186, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 911, Color.red(0) + 18, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b10 = (byte) (BuiltInFictitiousFunctionClassFactory[5] + 1);
                Object[] objArr31 = new Object[1];
                c(b10, (byte) (b10 | 14), (byte) (-BuiltInFictitiousFunctionClassFactory[5]), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b11 = (byte) (BuiltInFictitiousFunctionClassFactory[5] + 1);
                byte b12 = BuiltInFictitiousFunctionClassFactory[5];
                Object[] objArr32 = new Object[1];
                c(b11, b12, (byte) (b12 + 1), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 107, View.MeasureSpec.getSize(0) + 3, (char) (ViewConfiguration.getWindowTouchSlop() >> 8));
                        Object[] objArr34 = new Object[1];
                        d((byte) ($$a[47] - 1), (byte) (-$$a[9]), $$a[40], objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 930, 34 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {-1157468186, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + 912, 18 - Gravity.getAbsoluteGravity(0, 0), (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
            byte b = (byte) (BuiltInFictitiousFunctionClassFactory[5] + 1);
            Object[] objArr = new Object[1];
            c(b, (byte) (b | 14), (byte) (-BuiltInFictitiousFunctionClassFactory[5]), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (BuiltInFictitiousFunctionClassFactory[5] + 1);
            byte b3 = BuiltInFictitiousFunctionClassFactory[5];
            Object[] objArr2 = new Object[1];
            c(b2, b3, (byte) (b3 + 1), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(493 - ((byte) KeyEvent.getModifierMetaStateMask()), 4 - Color.red(0), (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1));
                    Object[] objArr4 = new Object[1];
                    d((byte) ($$a[47] - 1), (byte) (-$$a[9]), $$a[40], objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - KeyEvent.getDeadChar(0, 0), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 36, (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {868990595, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 911, ((byte) KeyEvent.getModifierMetaStateMask()) + 19, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                RVLogger.d("TinyApp_HostApduService", "service onCreate");
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
    public int onStartCommand(Intent intent, int i, int i2) {
        RVLogger.d("TinyApp_HostApduService", "service onStartCommand");
        if (intent == null) {
            return super.onStartCommand(null, i, i2);
        }
        ResultReceiver resultReceiver = (ResultReceiver) intent.getParcelableExtra(TinyAppConstants.KEY_RESULT_RECEIVER);
        this.b = resultReceiver;
        if (resultReceiver != null) {
            ResultReceiver resultReceiver2 = new ResultReceiver(new Handler(Looper.getMainLooper())) { // from class: com.alibaba.griver.device.jsapi.nfc.service.TinyAppHostApduService.1
                @Override // android.os.ResultReceiver
                protected void onReceiveResult(int i3, Bundle bundle) {
                    RVLogger.d("TinyApp_HostApduService", "onReceive apduCommand");
                    try {
                        TinyAppHostApduService.this.sendResponseApdu(bundle.getByteArray(TinyAppConstants.KEY_APDU_COMMAND));
                    } catch (Exception e) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("onReceive has exception");
                        sb.append(e);
                        RVLogger.d("TinyApp_HostApduService", sb.toString());
                    }
                }
            };
            Bundle bundle = new Bundle();
            bundle.putParcelable(TinyAppConstants.KEY_RESULT_RECEIVER, resultReceiver2);
            this.b.send(10019, bundle);
            RVLogger.d("TinyApp_HostApduService", "service onStartCommand, get receiveReceiver success");
        }
        this.f6511a = intent.getStringExtra(TinyAppConstants.KEY_APP_ID);
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(TinyAppConstants.KEY_AID_LIST);
        int intExtra = intent.getIntExtra("key_time_limit", 1500);
        int i3 = intExtra >= 1500 ? intExtra : 1500;
        if (i3 > 60000) {
            i3 = 60000;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("aid_list = ");
        sb.append(JSON.toJSONString(stringArrayListExtra));
        sb.append(" appId = ");
        sb.append(this.f6511a);
        sb.append(" timeLimit = ");
        sb.append(i3);
        RVLogger.d("TinyApp_HostApduService", sb.toString());
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        RVLogger.d("TinyApp_HostApduService", "service onDestroy");
        ResultReceiver resultReceiver = this.b;
        if (resultReceiver != null) {
            resultReceiver.send(10020, null);
        }
    }

    @Override // android.nfc.cardemulation.HostApduService
    public byte[] processCommandApdu(byte[] bArr, Bundle bundle) {
        if (this.b == null) {
            RVLogger.e("TinyApp_HostApduService", "processCommandApdu... resultReceiver is null");
            return null;
        } else if (bArr == null) {
            RVLogger.e("TinyApp_HostApduService", "processCommandApdu... commandApdu is null");
            this.b.send(13005, bundle);
            return null;
        } else {
            RVLogger.e("TinyApp_HostApduService", "processCommandApdu...");
            Bundle bundle2 = new Bundle();
            bundle2.putByteArray(TinyAppConstants.KEY_APDU_COMMAND, bArr);
            this.b.send(10000, bundle2);
            return null;
        }
    }

    @Override // android.nfc.cardemulation.HostApduService
    public void onDeactivated(int i) {
        String str = i == 0 ? "DEACTIVATION_LINK_LOSS" : i == 1 ? "DEACTIVATION_DESELECTED" : "DEACTIVATION_UNKNOWN";
        StringBuilder sb = new StringBuilder();
        sb.append("onDeactivated, reason = ");
        sb.append(str);
        RVLogger.debug("TinyApp_HostApduService", sb.toString());
        if (this.b != null) {
            Bundle bundle = new Bundle();
            bundle.putString(TinyAppConstants.KEY_APP_ID, this.f6511a);
            bundle.putInt(TinyAppConstants.KEY_EVENT_TYPE, 41);
            bundle.putInt(TinyAppConstants.KEY_DEACTIVATED_REASON, i);
            this.b.send(POPUIType.TOAST_NET_ERROR, bundle);
        }
    }

    private static void e(int i, int i2, byte b, short s, int i3, Object[] objArr) {
        B b2 = new B();
        StringBuilder sb = new StringBuilder();
        int i4 = i2 + ((int) (MyBillsEntityDataFactory ^ 3097486228508854431L));
        int i5 = i4 == -1 ? 1 : 0;
        if (i5 != 0) {
            byte[] bArr = lookAheadTest;
            if (bArr != null) {
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                for (int i6 = 0; i6 < length; i6++) {
                    bArr2[i6] = (byte) (bArr[i6] ^ 3097486228508854431L);
                }
                bArr = bArr2;
            }
            if (bArr != null) {
                i4 = (byte) (((byte) (lookAheadTest[i3 + ((int) (getAuthRequestContext ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (MyBillsEntityDataFactory ^ 3097486228508854431L)));
            } else {
                i4 = (short) (((short) (getErrorConfigVersion[i3 + ((int) (getAuthRequestContext ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (MyBillsEntityDataFactory ^ 3097486228508854431L)));
            }
        }
        if (i4 > 0) {
            b2.getAuthRequestContext = ((i3 + i4) - 2) + ((int) (getAuthRequestContext ^ 3097486228508854431L)) + i5;
            b2.MyBillsEntityDataFactory = (char) (i + ((int) (PlaceComponentResult ^ 3097486228508854431L)));
            sb.append(b2.MyBillsEntityDataFactory);
            b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
            byte[] bArr3 = lookAheadTest;
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
                    byte[] bArr5 = lookAheadTest;
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
