package com.xiaomi.push.service;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.C;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.whenAvailable;

/* loaded from: classes8.dex */
public class XMJobService extends Service {
    private static char BuiltInFictitiousFunctionClassFactory;
    private static char KClassImpl$Data$declaredNonStaticMembers$2;
    private static char MyBillsEntityDataFactory;
    private static char NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: a  reason: collision with root package name */
    static Service f7791a;

    /* renamed from: a  reason: collision with other field name */
    private IBinder f392a = null;
    public static final byte[] $$a = {18, -87, -121, -123, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 27;
    public static final byte[] getAuthRequestContext = {16, -117, -56, -112, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int PlaceComponentResult = 22;

    static {
        PlaceComponentResult();
    }

    static void PlaceComponentResult() {
        MyBillsEntityDataFactory = (char) 50566;
        KClassImpl$Data$declaredNonStaticMembers$2 = (char) 57871;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = (char) 28834;
        BuiltInFictitiousFunctionClassFactory = (char) 60089;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.xiaomi.push.service.XMJobService.getAuthRequestContext
            int r7 = r7 + 4
            int r8 = 106 - r8
            int r6 = r6 * 2
            int r6 = r6 + 16
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L16
            r4 = r8
            r3 = 0
            r8 = r7
            r7 = r6
            goto L2e
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L24:
            int r7 = r7 + 1
            r4 = r0[r7]
            int r3 = r3 + 1
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L2e:
            int r6 = r6 + r4
            int r6 = r6 + 2
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.XMJobService.b(byte, byte, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0027). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r5, int r6, byte r7, java.lang.Object[] r8) {
        /*
            int r7 = r7 * 2
            int r7 = 103 - r7
            int r6 = 47 - r6
            byte[] r0 = com.xiaomi.push.service.XMJobService.$$a
            int r5 = r5 * 3
            int r5 = r5 + 21
            byte[] r1 = new byte[r5]
            r2 = 0
            if (r0 != 0) goto L15
            r4 = r7
            r3 = 0
            r7 = r6
            goto L27
        L15:
            r3 = 0
        L16:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r5) goto L25
            java.lang.String r5 = new java.lang.String
            r5.<init>(r1, r2)
            r8[r2] = r5
            return
        L25:
            r4 = r0[r6]
        L27:
            int r6 = r6 + 1
            int r7 = r7 + r4
            int r7 = r7 + (-7)
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.XMJobService.c(int, int, byte, java.lang.Object[]):void");
    }

    @Override // android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        d(18 - TextUtils.indexOf("", "", 0), new char[]{17145, 64757, 60495, 22107, 393, 61784, 60145, 41644, 6895, 10105, 24958, 4255, 7225, 14219, 29801, 50029, 48205, 14988}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        d(5 - (ViewConfiguration.getScrollDefaultDelay() >> 16), new char[]{61903, 19906, 50941, 14248, 130, 12624}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), TextUtils.lastIndexOf("", '0', 0, 0) + 36, (char) Color.alpha(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    d(View.resolveSizeAndState(0, 0, 0) + 48, new char[]{47191, 36005, 63001, 15898, 55539, 43581, 2747, 44269, 45188, 3223, 21903, 49998, 10123, 2344, 36523, 43224, 57268, 41707, 42327, 8654, 32780, 61495, 17948, 4078, 55011, 51783, 13599, 49906, 63743, 22699, 43768, 43453, 53104, 40161, 44928, 6002, 38629, 63642, 33433, 39165, 11078, 27553, 58878, 13034, 39553, 51870, 13487, 23561}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    d(64 - (ViewConfiguration.getLongPressTimeout() >> 16), new char[]{37803, 33831, 48813, 48686, 38629, 63642, 8643, 60750, 32780, 61495, 63477, 25958, 13229, 38172, 28120, 29017, 4670, 23876, 18220, 32539, 13229, 38172, 17040, 57041, 38262, 33199, 53096, 54012, 13599, 49906, 4670, 23876, 16097, 23366, 38400, 16441, 59341, 33142, 28260, 42937, 2809, 33595, 11087, 36275, 3131, 59423, 31008, 49284, 38862, 11445, 20504, 15363, 55790, 4794, 32825, 7421, 32825, 7421, 27224, 33118, 57606, 36263, 55011, 51783}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    d(TextUtils.indexOf((CharSequence) "", '0') + 65, new char[]{58721, 55764, 47590, 27610, 55790, 4794, 1228, 56086, 49192, 1699, 61690, 29444, 25640, 51756, 22659, 45837, 43768, 43453, 56225, 43569, 49260, 40930, 17995, 54580, 11078, 27553, 2747, 44269, 31080, 49838, 47191, 36005, 13296, 38678, 48561, 22069, 57028, 15691, 63001, 15898, 7357, 20033, 28120, 29017, 33433, 39165, 52611, 56892, 38629, 63642, 29801, 50029, 58721, 55764, 44779, 33385, 42994, 8596, 53104, 40161, 44779, 33385, 35164, 28837}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    d((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 59, new char[]{58472, 9940, 26558, 10999, 38667, 43216, 4231, 2183, 23782, 45360, 19710, 34974, 12585, 54598, 4497, 56210, 44224, 30387, 62970, 46482, 51218, 54723, 30781, 58041, 60483, 44078, 12177, 7843, 45159, 54451, 57815, 12061, 12177, 7843, 63785, 23969, 60358, 61216, 42075, 4750, 54034, 25835, 41891, 12506, 23611, 9432, 23401, 61328, 45706, 35744, 1321, 48518, 32511, 45944, 8254, 46205, 44302, 26961, 20491, 18042}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    d(6 - Drawable.resolveOpacity(0, 0), new char[]{13462, 2193, 57029, 3749, 58721, 55764}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getWindowTouchSlop() >> 8), 18 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                Object[] objArr13 = new Object[1];
                b(b, (byte) (b | 14), (byte) (getAuthRequestContext[5] + 1), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b2 = (byte) (getAuthRequestContext[5] + 1);
                byte b3 = getAuthRequestContext[5];
                Object[] objArr14 = new Object[1];
                b(b2, b3, (byte) (-b3), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + 55, Gravity.getAbsoluteGravity(0, 0) + 3, (char) TextUtils.getCapsMode("", 0, 0));
                        Object[] objArr16 = new Object[1];
                        c($$a[78], $$a[53], $$a[12], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + 800, 15 - Drawable.resolveOpacity(0, 0), (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 15, (char) TextUtils.getCapsMode("", 0, 0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(814 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 29 - View.MeasureSpec.getMode(0), (char) (57994 - ExpandableListView.getPackedPositionGroup(0L)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getTouchSlop() >> 8), 15 - (Process.myTid() >> 22), (char) TextUtils.getOffsetBefore("", 0)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 930, 36 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) View.MeasureSpec.getMode(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {1226069780, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778127, 18 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b4 = (byte) (getAuthRequestContext[5] + 1);
                Object[] objArr19 = new Object[1];
                b(b4, (byte) (b4 | 14), (byte) (getAuthRequestContext[5] + 1), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b5 = (byte) (getAuthRequestContext[5] + 1);
                byte b6 = getAuthRequestContext[5];
                Object[] objArr20 = new Object[1];
                b(b5, b6, (byte) (-b6), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + 62, Process.getGidForName("") + 47, (char) View.getDefaultSize(0, 0));
                        Object[] objArr22 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[84], (byte) ($$a[78] - 1), objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r3 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) View.combineMeasuredStates(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {1226069780, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getFadingEdgeLength() >> 16), 18 - Color.alpha(0), (char) (AndroidCharacter.getMirror('0') - '0'))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b7 = (byte) (getAuthRequestContext[5] + 1);
                Object[] objArr25 = new Object[1];
                b(b7, (byte) (b7 | 14), (byte) (getAuthRequestContext[5] + 1), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b8 = (byte) (getAuthRequestContext[5] + 1);
                byte b9 = getAuthRequestContext[5];
                Object[] objArr26 = new Object[1];
                b(b8, b9, (byte) (-b9), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 118, 3 - (KeyEvent.getMaxKeyCode() >> 16), (char) (38967 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))));
                        Object[] objArr28 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[84], (byte) ($$a[78] - 1), objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r3 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getEdgeSlop() >> 16), View.MeasureSpec.makeMeasureSpec(0, 0) + 35, (char) View.MeasureSpec.getMode(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {1226069780, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.makeMeasureSpec(0, 0), TextUtils.indexOf((CharSequence) "", '0') + 19, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b10 = (byte) (getAuthRequestContext[5] + 1);
                Object[] objArr31 = new Object[1];
                b(b10, (byte) (b10 | 14), (byte) (getAuthRequestContext[5] + 1), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b11 = (byte) (getAuthRequestContext[5] + 1);
                byte b12 = getAuthRequestContext[5];
                Object[] objArr32 = new Object[1];
                b(b11, b12, (byte) (-b12), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - View.getDefaultSize(0, 0), (ViewConfiguration.getTapTimeout() >> 16) + 3, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                        Object[] objArr34 = new Object[1];
                        c($$a[8], (byte) ($$a[78] - 1), $$a[9], objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (Process.myPid() >> 22), View.combineMeasuredStates(0, 0) + 35, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {1226069780, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myPid() >> 22) + 911, AndroidCharacter.getMirror('0') - 30, (char) KeyEvent.normalizeMetaState(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
    public IBinder onBind(Intent intent) {
        IBinder iBinder = this.f392a;
        return iBinder != null ? iBinder : new Binder();
    }

    @Override // android.app.Service
    public void onCreate() {
        try {
            byte b = (byte) (getAuthRequestContext[5] + 1);
            Object[] objArr = new Object[1];
            b(b, (byte) (b | 14), (byte) (getAuthRequestContext[5] + 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (getAuthRequestContext[5] + 1);
            byte b3 = getAuthRequestContext[5];
            Object[] objArr2 = new Object[1];
            b(b2, b3, (byte) (-b3), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(495 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 4 - Color.green(0), (char) View.resolveSize(0, 0));
                    Object[] objArr4 = new Object[1];
                    c($$a[8], (byte) ($$a[78] - 1), $$a[9], objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getScrollBarSize() >> 8) + 35, (char) KeyEvent.getDeadChar(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-692238811, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.blue(0), ImageFormat.getBitsPerPixel(0) + 19, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                if (Build.VERSION.SDK_INT >= 21) {
                    this.f392a = new a(this).BuiltInFictitiousFunctionClassFactory;
                }
                f7791a = this;
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
    public void onDestroy() {
        super.onDestroy();
        f7791a = null;
    }

    /* loaded from: classes8.dex */
    static class a extends JobService {
        Binder BuiltInFictitiousFunctionClassFactory;
        private Handler MyBillsEntityDataFactory;
        public static final byte[] $$a = {8, -125, -40, -38, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
        public static final int $$b = 215;
        public static final byte[] getAuthRequestContext = {45, -79, -67, -1, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
        public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 150;
        private static char[] PlaceComponentResult = {59131, 47374, 22794, 63750, 39197, 14609, 55586, 31074, 6437, 47395, 22896, 63860, 39248, 14663, 55637, 31065, 6473, 47475, 62243, 44237, 19695, 60617, 36034, 12953, 27959, 36204, 11640, 19830, 60712, 3403, 44352, 52553, 27905, 36105, 11638, 19827, 60718, 3379, 44350, 52543, 27909, 36108, 11585, 19778, 60751, 3505, 44526, 52666, 28151, 36338, 11668, 19908, 60824, 3459, 44429, 52695, 28066, 36264, 11705, 19936, 60853, 3466, 44424, 52617, 28098, 36254, 11366, 19508, 60527, 3188, 44077, 63911, 42505, 17924, 58956, 34376, 9757, 50730, 26152, 1650, 42607, 17979, 58957, 34330, 9797, 50779, 26196, 1620, 42606, 17972, 59001, 34346, 9845, 50828, 26243, 1664, 42702, 18075, 59133, 34470, 9968, 50872, 26290, 1765, 42648, 18118, 59088, 34445, 9863, 50922, 26339, 1763, 42748, 18087, 59145, 34653, 9987, 50971, 26391, 1813, 42799, 18213, 59185, 34615, 10035, 51018, 26433, 1862, 42845, 18177, 59194, 34671, 10092, 50990, 26483, 15568, 25385, 33651, 9070, 17203, 58167, 780, 41728, 49930, 25360, 33566, 9069, 17259, 58211, 894, 41843, 49955, 25373, 33602, 8968, 17240, 58114, 1023, 41895, 50085, 25582, 33727, 9092, 17372, 58326, 921, 41927, 50069, 25532, 33764, 9204, 17320, 58359, 968, 41932, 50122, 25486, 33751, 8744, 16930, 57888, 623, 41574, 49764, 25089, 33365, 8777, 16920, 57873, 568, 41569, 49765, 25213, 33407, 8778, 16924, 57925, 603, 41565, 36263, 53825, 12879, 37457, 62036, 21015, 45628, 4662, 29307, 53860, 12901, 37392, 62041, 21001, 45579, 4635, 29194, 53812, 12847, 37410, 61990, 21054, 45767, 4759, 29400, 53968, 13002, 37603, 62195, 21230, 45810, 4860, 29422, 53895, 12958, 37583, 62084, 21122, 45758, 4854, 29374, 53941, 12962, 37662, 62302, 21331, 45892, 4940, 29532, 54113, 13108, 37751, 62261, 21282, 45846, 4879, 29466, 54027, 13087, 37666, 36886, 53243, 12271, 36847, 61429, 20476};
        private static long lookAheadTest = 4412864682850757812L;

        /* renamed from: com.xiaomi.push.service.XMJobService$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        static class HandlerC0158a extends Handler {
            JobService KClassImpl$Data$declaredNonStaticMembers$2;

            HandlerC0158a(JobService jobService) {
                super(jobService.getMainLooper());
                this.KClassImpl$Data$declaredNonStaticMembers$2 = jobService;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    JobParameters jobParameters = (JobParameters) message.obj;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Job finished ");
                    sb.append(jobParameters.getJobId());
                    com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
                    this.KClassImpl$Data$declaredNonStaticMembers$2.jobFinished(jobParameters, false);
                    if (jobParameters.getJobId() == 1) {
                        com.xiaomi.push.bc.BuiltInFictitiousFunctionClassFactory(false);
                    }
                }
            }
        }

        a(Service service) {
            this.BuiltInFictitiousFunctionClassFactory = null;
            this.BuiltInFictitiousFunctionClassFactory = (Binder) com.xiaomi.push.z.getAuthRequestContext(this, "onBind", new Intent());
            com.xiaomi.push.z.getAuthRequestContext(this, "attachBaseContext", service);
        }

        private static void b(byte b, int i, byte b2, Object[] objArr) {
            int i2 = 19 - (b * 15);
            int i3 = 16 - (i * 3);
            int i4 = b2 + 105;
            byte[] bArr = getAuthRequestContext;
            byte[] bArr2 = new byte[i3];
            int i5 = -1;
            int i6 = i3 - 1;
            if (bArr == null) {
                i2++;
                i4 = i6 + (-i4) + 2;
                i6 = i6;
            }
            while (true) {
                i5++;
                bArr2[i5] = (byte) i4;
                if (i5 == i6) {
                    objArr[0] = new String(bArr2, 0);
                    return;
                }
                int i7 = i4;
                int i8 = i6;
                i2++;
                i4 = i7 + (-bArr[i2]) + 2;
                i6 = i8;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002c). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void c(short r6, short r7, int r8, java.lang.Object[] r9) {
            /*
                int r7 = 47 - r7
                int r8 = r8 * 3
                int r8 = r8 + 21
                byte[] r0 = com.xiaomi.push.service.XMJobService.a.$$a
                int r6 = r6 * 2
                int r6 = r6 + 75
                byte[] r1 = new byte[r8]
                int r8 = r8 + (-1)
                r2 = 0
                if (r0 != 0) goto L17
                r4 = r7
                r6 = r8
                r3 = 0
                goto L2c
            L17:
                r3 = 0
            L18:
                byte r4 = (byte) r6
                r1[r3] = r4
                if (r3 != r8) goto L25
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L25:
                int r3 = r3 + 1
                r4 = r0[r7]
                r5 = r8
                r8 = r6
                r6 = r5
            L2c:
                int r7 = r7 + 1
                int r8 = r8 + r4
                int r8 = r8 + (-7)
                r5 = r8
                r8 = r6
                r6 = r5
                goto L18
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.XMJobService.a.c(short, short, int, java.lang.Object[]):void");
        }

        @Override // android.app.Service, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            Object[] objArr;
            Object[] objArr2;
            Object[] objArr3;
            Object[] objArr4;
            super.attachBaseContext(context);
            Object[] objArr5 = new Object[1];
            a((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 18, ViewConfiguration.getPressedStateDuration() >> 16, (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 5587), objArr5);
            Class<?> cls = Class.forName((String) objArr5[0]);
            Object[] objArr6 = new Object[1];
            a(5 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 18 - Drawable.resolveOpacity(0, 0), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1), objArr6);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context applicationContext = context != null ? context.getApplicationContext() : context;
                if (applicationContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 34, (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        a(48 - ExpandableListView.getPackedPositionType(0L), 23 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) (49632 - (ViewConfiguration.getScrollBarSize() >> 8)), objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        a(ExpandableListView.getPackedPositionChild(0L) + 65, 71 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) ((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 2696), objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        a(Process.getGidForName("") + 65, 135 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (53164 - View.MeasureSpec.makeMeasureSpec(0, 0)), objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        a(60 - (ViewConfiguration.getWindowTouchSlop() >> 8), View.MeasureSpec.getMode(0) + SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR, (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 32385), objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        a(TextUtils.lastIndexOf("", '0') + 7, View.combineMeasuredStates(0, 0) + DeepRecoverARiverProxy.TYPE_ENTITY_PLUGIN, (char) (TextUtils.getCapsMode("", 0, 0) + 25441), objArr11);
                        try {
                            Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getFadingEdgeLength() >> 16), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 17, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                    byte b = (byte) (getAuthRequestContext[5] - 1);
                    Object[] objArr13 = new Object[1];
                    b(b, b, getAuthRequestContext[5], objArr13);
                    Class<?> cls2 = Class.forName((String) objArr13[0]);
                    byte b2 = getAuthRequestContext[5];
                    byte b3 = (byte) (b2 - 1);
                    Object[] objArr14 = new Object[1];
                    b(b2, b3, b3, objArr14);
                    try {
                        Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                        if (obj3 == null) {
                            Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + 55, 3 - TextUtils.indexOf("", ""), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16));
                            Object[] objArr16 = new Object[1];
                            c($$a[78], $$a[53], $$a[78], objArr16);
                            obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                        }
                        Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), 15 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (Process.myTid() >> 22))).getMethod("getAuthRequestContext", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                            }
                            int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                            try {
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), TextUtils.lastIndexOf("", '0', 0, 0) + 16, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("PlaceComponentResult", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                                }
                                if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                    ArrayList arrayList = new ArrayList();
                                    try {
                                        Object[] objArr17 = {invoke2};
                                        Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                        if (obj6 == null) {
                                            obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + 815, 29 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (View.combineMeasuredStates(0, 0) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 800, 15 - ExpandableListView.getPackedPositionGroup(0L), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16)));
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
                                                obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) Color.alpha(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                            }
                                            Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                            try {
                                                Object[] objArr18 = {-703557823, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                                Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                                if (obj8 == null) {
                                                    obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 911, ExpandableListView.getPackedPositionGroup(0L) + 18, (char) View.getDefaultSize(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    byte b4 = (byte) (getAuthRequestContext[5] - 1);
                    Object[] objArr19 = new Object[1];
                    b(b4, b4, getAuthRequestContext[5], objArr19);
                    Class<?> cls4 = Class.forName((String) objArr19[0]);
                    byte b5 = getAuthRequestContext[5];
                    byte b6 = (byte) (b5 - 1);
                    Object[] objArr20 = new Object[1];
                    b(b5, b6, b6, objArr20);
                    try {
                        Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                        Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                        if (obj9 == null) {
                            Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - Color.blue(0), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 46, (char) (ViewConfiguration.getTapTimeout() >> 16));
                            Object[] objArr22 = new Object[1];
                            c($$a[9], $$a[84], (byte) ($$a[78] - 1), objArr22);
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
                                    obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (KeyEvent.getMaxKeyCode() >> 16) + 35, (char) ExpandableListView.getPackedPositionType(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                                }
                                Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                                try {
                                    Object[] objArr24 = {-703557823, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj11 == null) {
                                        obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + 911, 19 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    byte b7 = (byte) (getAuthRequestContext[5] - 1);
                    Object[] objArr25 = new Object[1];
                    b(b7, b7, getAuthRequestContext[5], objArr25);
                    Class<?> cls6 = Class.forName((String) objArr25[0]);
                    byte b8 = getAuthRequestContext[5];
                    byte b9 = (byte) (b8 - 1);
                    Object[] objArr26 = new Object[1];
                    b(b8, b9, b9, objArr26);
                    try {
                        Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                        Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                        if (obj12 == null) {
                            Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myPid() >> 22) + 118, (ViewConfiguration.getPressedStateDuration() >> 16) + 3, (char) (38968 - ExpandableListView.getPackedPositionGroup(0L)));
                            Object[] objArr28 = new Object[1];
                            c($$a[9], $$a[84], (byte) ($$a[78] - 1), objArr28);
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
                                    obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 35, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                                }
                                Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                                try {
                                    Object[] objArr30 = {-703557823, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj14 == null) {
                                        obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0', 0), View.resolveSize(0, 0) + 18, (char) View.resolveSizeAndState(0, 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    byte b10 = (byte) (getAuthRequestContext[5] - 1);
                    Object[] objArr31 = new Object[1];
                    b(b10, b10, getAuthRequestContext[5], objArr31);
                    Class<?> cls8 = Class.forName((String) objArr31[0]);
                    byte b11 = getAuthRequestContext[5];
                    byte b12 = (byte) (b11 - 1);
                    Object[] objArr32 = new Object[1];
                    b(b11, b12, b12, objArr32);
                    try {
                        Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                        Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                        if (obj15 == null) {
                            Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetAfter("", 0) + 107, 4 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)));
                            byte b13 = (byte) ($$a[78] - 1);
                            Object[] objArr34 = new Object[1];
                            c(b13, b13, $$a[8], objArr34);
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
                                    obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getOffsetBefore("", 0), View.combineMeasuredStates(0, 0) + 35, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                                }
                                Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                                try {
                                    Object[] objArr36 = {-703557823, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj17 == null) {
                                        obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ((byte) KeyEvent.getModifierMetaStateMask()), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 19, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b = (byte) (getAuthRequestContext[5] - 1);
                Object[] objArr = new Object[1];
                b(b, b, getAuthRequestContext[5], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b2 = getAuthRequestContext[5];
                byte b3 = (byte) (b2 - 1);
                Object[] objArr2 = new Object[1];
                b(b2, b3, b3, objArr2);
                try {
                    Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj == null) {
                        Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(493 - ((byte) KeyEvent.getModifierMetaStateMask()), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 4, (char) KeyEvent.getDeadChar(0, 0));
                        byte b4 = (byte) ($$a[78] - 1);
                        Object[] objArr4 = new Object[1];
                        c(b4, b4, $$a[8], objArr4);
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
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + 930, (ViewConfiguration.getEdgeSlop() >> 16) + 35, (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                            }
                            Object invoke = ((Method) obj2).invoke(null, null);
                            try {
                                Object[] objArr6 = {-536507152, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj3 == null) {
                                    obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), ExpandableListView.getPackedPositionGroup(0L) + 18, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

        @Override // android.app.job.JobService
        public boolean onStartJob(JobParameters jobParameters) {
            StringBuilder sb = new StringBuilder();
            sb.append("Job started ");
            sb.append(jobParameters.getJobId());
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
            Intent intent = new Intent(this, XMPushService.class);
            intent.setAction("com.xiaomi.push.timer");
            intent.setPackage(getPackageName());
            startService(intent);
            if (this.MyBillsEntityDataFactory == null) {
                this.MyBillsEntityDataFactory = new HandlerC0158a(this);
            }
            Handler handler = this.MyBillsEntityDataFactory;
            handler.sendMessage(Message.obtain(handler, 1, jobParameters));
            return true;
        }

        @Override // android.app.job.JobService
        public boolean onStopJob(JobParameters jobParameters) {
            StringBuilder sb = new StringBuilder();
            sb.append("Job stop ");
            sb.append(jobParameters.getJobId());
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
            return false;
        }

        private static void a(int i, int i2, char c, Object[] objArr) {
            whenAvailable whenavailable = new whenAvailable();
            long[] jArr = new long[i];
            whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
            while (whenavailable.BuiltInFictitiousFunctionClassFactory < i) {
                jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (PlaceComponentResult[whenavailable.BuiltInFictitiousFunctionClassFactory + i2] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ lookAheadTest))) ^ c;
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

    private static void d(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        while (c.BuiltInFictitiousFunctionClassFactory < cArr.length) {
            cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
            cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
            int i2 = 58224;
            for (int i3 = 0; i3 < 16; i3++) {
                cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i2) ^ ((cArr3[0] << 4) + ((char) (BuiltInFictitiousFunctionClassFactory ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (NetworkUserEntityData$$ExternalSyntheticLambda0 ^ 6353485791441662354L)))));
                cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i2) ^ ((cArr3[1] << 4) + ((char) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (MyBillsEntityDataFactory ^ 6353485791441662354L)))));
                i2 -= 40503;
            }
            cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
            cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
            c.BuiltInFictitiousFunctionClassFactory += 2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}
