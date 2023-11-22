package com.xiaomi.mipush.sdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
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
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.android.phone.mobilesdk.socketcraft.api.WSContextConstant;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.Typography;
import o.A;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes8.dex */
public abstract class BaseService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private a f7736a;
    public static final byte[] $$a = {11, Ascii.GS, 107, 8, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 67;
    public static final byte[] PlaceComponentResult = {4, -87, 42, 65, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int BuiltInFictitiousFunctionClassFactory = 49;
    private static int MyBillsEntityDataFactory = 269894738;

    /* loaded from: classes8.dex */
    public static class a extends Handler {
        private WeakReference<BaseService> getAuthRequestContext;

        public a(WeakReference<BaseService> weakReference) {
            this.getAuthRequestContext = weakReference;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference<BaseService> weakReference;
            BaseService baseService;
            if (message.what != 1001 || (weakReference = this.getAuthRequestContext) == null || (baseService = weakReference.get()) == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("TimeoutHandler ");
            sb.append(baseService.toString());
            sb.append(" kill self");
            com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory(sb.toString());
            if (!baseService.mo257a()) {
                baseService.stopSelf();
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory("TimeoutHandler has job");
            sendEmptyMessageDelayed(1001, 1000L);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void e(short r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = 106 - r8
            int r7 = r7 * 3
            int r7 = 16 - r7
            byte[] r0 = com.xiaomi.mipush.sdk.BaseService.PlaceComponentResult
            int r6 = r6 + 4
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L15
            r4 = r8
            r3 = 0
            r8 = r7
            goto L2c
        L15:
            r3 = 0
        L16:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r6 = r6 + 1
            if (r3 != r7) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r8
            r8 = r7
            r7 = r5
        L2c:
            int r7 = r7 + r4
            int r7 = r7 + 2
            r5 = r8
            r8 = r7
            r7 = r5
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.BaseService.e(short, short, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void f(byte r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 3
            int r6 = 42 - r6
            int r7 = r7 + 4
            byte[] r0 = com.xiaomi.mipush.sdk.BaseService.$$a
            int r8 = r8 * 2
            int r8 = 103 - r8
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L18
            r8 = r7
            r4 = r8
            r3 = 0
            r7 = r6
            goto L2e
        L18:
            r3 = 0
        L19:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L2e:
            int r4 = -r4
            int r6 = r6 + r4
            int r6 = r6 + (-7)
            int r8 = r8 + 1
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.BaseService.f(byte, short, byte, java.lang.Object[]):void");
    }

    /* renamed from: a */
    protected abstract boolean mo257a();

    @Override // android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        d(false, TextUtils.lastIndexOf("", '0') + 219, View.MeasureSpec.getMode(0) + 8, ExpandableListView.getPackedPositionGroup(0L) + 18, new char[]{65483, 65517, 15, '\f', 0, 2, 16, 16, 65534, 11, 1, 15, '\f', 6, 1, 65483, '\f', 16}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        d(true, TextUtils.indexOf((CharSequence) "", '0', 0) + 224, '3' - AndroidCharacter.getMirror('0'), View.MeasureSpec.getSize(0) + 5, new char[]{65517, 17, 5, 65532, 1}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.getMode(0), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 34, (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    d(true, 190 - (ViewConfiguration.getEdgeSlop() >> 16), 29 - TextUtils.getOffsetBefore("", 0), 47 - ImageFormat.getBitsPerPixel(0), new char[]{65515, 29, 65521, 65516, 29, 65519, 28, 28, 29, JSONLexer.EOI, 65519, 65514, 65514, 65519, 65514, 65515, 30, 31, 28, 30, 65520, 65521, 65522, 29, 65513, 65521, 65519, 28, 65520, 30, 65519, 65516, 27, 65519, 65517, 31, 65520, 65513, 65521, 65522, 31, 65522, 65515, 65519, 65522, 30, JSONLexer.EOI, 29}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    d(false, TextUtils.getOffsetAfter("", 0) + WSContextConstant.HANDSHAKE_RECEIVE_SIZE, Process.getGidForName("") + 27, 64 - TextUtils.getOffsetAfter("", 0), new char[]{65518, 65521, 65523, 65518, '#', 65519, '!', 65525, 65519, 65525, 65521, 65521, 65525, 65527, 65527, 65525, 65518, 65519, 65518, 65519, '!', InputCardNumberView.DIVIDER, 65519, 65526, Typography.quote, 65521, 31, 65523, 65524, Typography.quote, Typography.dollar, 65527, 65518, 65526, Typography.quote, '!', 65527, 65523, Typography.quote, 65519, 65519, 65522, 65520, 65520, Typography.dollar, 65519, Typography.quote, 65519, 65524, 65521, 65524, InputCardNumberView.DIVIDER, 65527, '#', 65526, Typography.quote, 65520, 65520, '!', Typography.quote, 65522, 65526, '!', '!'}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    d(true, 187 - (ViewConfiguration.getTouchSlop() >> 8), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 19, 64 - ExpandableListView.getPackedPositionGroup(0L), new char[]{65520, '!', 29, 65523, 65516, 65519, 65517, 65517, 65524, 65524, 65524, 65520, 65518, 65523, 65525, 30, '!', 65517, 65518, 65525, 65521, 65521, Typography.quote, 65522, 65525, 65521, 65523, 65521, Typography.quote, 65517, 65518, '!', 31, 65525, Typography.quote, 30, 29, 65516, 65524, 65520, 65517, Typography.quote, 65524, 65524, 65522, 65523, 30, 65524, 65518, InputCardNumberView.DIVIDER, 65523, 31, 65523, Typography.quote, Typography.quote, 65524, 65525, Typography.quote, 65523, 65519, 29, 30, 65518, InputCardNumberView.DIVIDER}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    d(true, 216 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 34, 59 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), new char[]{4, 17, 0, 20, 16, 18, 3, 17, 0, 20, 6, 65485, 19, 18, 0, 2, 19, 0, 4, 17, 7, 19, 65485, 0, '\r', 0, 3, 65486, 65486, 65497, 18, 15, 19, 19, 7, 18, 19, '\r', 4, 21, 4, 65486, 65489, 21, 65486, 19, 18, 4, 6, '\r', '\b', 65486, '\b', 15, 0, 65486, '\f', 14, 2, 65485}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    d(false, 169 - Color.alpha(0), 2 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), View.resolveSize(0, 0) + 6, new char[]{0, 65535, 7, 65532, 2, 65532}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getCapsMode("", 0, 0), 17 - ImageFormat.getBitsPerPixel(0), (char) Color.alpha(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = (byte) (PlaceComponentResult[5] + 1);
                Object[] objArr13 = new Object[1];
                e((short) 14, b, b, objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b2 = PlaceComponentResult[5];
                Object[] objArr14 = new Object[1];
                e(b2, (byte) (b2 + 1), (byte) (-PlaceComponentResult[5]), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - View.MeasureSpec.getMode(0), 3 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))));
                        Object[] objArr16 = new Object[1];
                        f($$a[68], (byte) ($$a[47] - 1), (byte) (-$$a[12]), objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 801, 14 - Process.getGidForName(""), (char) (MotionEvent.axisFromString("") + 1))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), 15 - ((Process.getThreadPriority(0) + 20) >> 6), (char) Color.blue(0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - Color.red(0), 29 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) (57995 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, 15 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) (ViewConfiguration.getScrollBarSize() >> 8)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0'), View.MeasureSpec.makeMeasureSpec(0, 0) + 35, (char) Drawable.resolveOpacity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-1405949268, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778127, 18 - (ViewConfiguration.getEdgeSlop() >> 16), (char) TextUtils.getTrimmedLength(""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b3 = (byte) (PlaceComponentResult[5] + 1);
                Object[] objArr19 = new Object[1];
                e((short) 14, b3, b3, objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b4 = PlaceComponentResult[5];
                Object[] objArr20 = new Object[1];
                e(b4, (byte) (b4 + 1), (byte) (-PlaceComponentResult[5]), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), 46 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                        byte b5 = (byte) (-$$a[8]);
                        Object[] objArr22 = new Object[1];
                        f(b5, (byte) (b5 | 16), (byte) ($$a[47] - 1), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getTapTimeout() >> 16), Process.getGidForName("") + 36, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {-1405949268, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + 911, 17 - TextUtils.indexOf((CharSequence) "", '0'), (char) ((-1) - TextUtils.lastIndexOf("", '0')))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b6 = (byte) (PlaceComponentResult[5] + 1);
                Object[] objArr25 = new Object[1];
                e((short) 14, b6, b6, objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b7 = PlaceComponentResult[5];
                Object[] objArr26 = new Object[1];
                e(b7, (byte) (b7 + 1), (byte) (-PlaceComponentResult[5]), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - Color.red(0), View.resolveSizeAndState(0, 0, 0) + 3, (char) (ExpandableListView.getPackedPositionType(0L) + 38968));
                        byte b8 = (byte) (-$$a[8]);
                        Object[] objArr28 = new Object[1];
                        f(b8, (byte) (b8 | 16), (byte) ($$a[47] - 1), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 35, (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-1405949268, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.getSize(0), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 19, (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b9 = (byte) (PlaceComponentResult[5] + 1);
                Object[] objArr31 = new Object[1];
                e((short) 14, b9, b9, objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b10 = PlaceComponentResult[5];
                Object[] objArr32 = new Object[1];
                e(b10, (byte) (b10 + 1), (byte) (-PlaceComponentResult[5]), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + 107, 3 - (KeyEvent.getMaxKeyCode() >> 16), (char) View.getDefaultSize(0, 0));
                        Object[] objArr34 = new Object[1];
                        f((byte) ($$a[47] - 1), (byte) (-$$a[53]), (byte) (-$$a[9]), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + PDF417Common.NUMBER_OF_CODEWORDS, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 34, (char) TextUtils.getTrimmedLength(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {-1405949268, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + 911, 18 - KeyEvent.keyCodeFromString(""), (char) ('0' - AndroidCharacter.getMirror('0')))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        try {
            byte b = (byte) (PlaceComponentResult[5] + 1);
            Object[] objArr = new Object[1];
            e((short) 14, b, b, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = PlaceComponentResult[5];
            Object[] objArr2 = new Object[1];
            e(b2, (byte) (b2 + 1), (byte) (-PlaceComponentResult[5]), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + 494, 4 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) TextUtils.indexOf("", "", 0));
                    Object[] objArr4 = new Object[1];
                    f((byte) ($$a[47] - 1), (byte) (-$$a[53]), (byte) (-$$a[9]), objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0', 0), 35 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {1488665389, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 911, 18 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (this.f7736a == null) {
            this.f7736a = new a(new WeakReference(this));
        }
        a aVar = this.f7736a;
        if (aVar.hasMessages(1001)) {
            aVar.removeMessages(1001);
        }
        aVar.sendEmptyMessageDelayed(1001, 1000L);
    }

    private static void d(boolean z, int i, int i2, int i3, char[] cArr, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i3];
        a2.MyBillsEntityDataFactory = 0;
        while (a2.MyBillsEntityDataFactory < i3) {
            a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
            cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
            int i4 = a2.MyBillsEntityDataFactory;
            cArr2[i4] = (char) (cArr2[i4] - ((int) (MyBillsEntityDataFactory ^ (-5694784870793460699L))));
            a2.MyBillsEntityDataFactory++;
        }
        if (i2 > 0) {
            a2.BuiltInFictitiousFunctionClassFactory = i2;
            char[] cArr3 = new char[i3];
            System.arraycopy(cArr2, 0, cArr3, 0, i3);
            System.arraycopy(cArr3, 0, cArr2, i3 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
            System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i3 - a2.BuiltInFictitiousFunctionClassFactory);
        }
        if (z) {
            char[] cArr4 = new char[i3];
            a2.MyBillsEntityDataFactory = 0;
            while (a2.MyBillsEntityDataFactory < i3) {
                cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i3 - a2.MyBillsEntityDataFactory) - 1];
                a2.MyBillsEntityDataFactory++;
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }
}
