package id.dana.notification;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.griver.core.GriverParams;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.plus.push.core.PushServiceInstance;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.contract.notification.PushNotificationContract;
import id.dana.contract.notification.PushNotificationPresenter;
import id.dana.crash.AppExceptionHandler;
import id.dana.danah5.share.ShareToFeedBridge;
import id.dana.data.constant.DanaUrl;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerPushNotificationComponent;
import id.dana.di.modules.PushNotificationModule;
import id.dana.domain.DefaultObserver;
import id.dana.domain.notificationcenter.interactor.ReportDevice;
import id.dana.domain.notificationcenter.model.ReportDeviceResponse;
import id.dana.domain.util.StringUtil;
import id.dana.kyb.KybNotificationBus;
import id.dana.notification.DanaFirebaseMessagingService;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.rum.Rum;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.twilio.tracker.TwilioMixpanelTracker;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import o.A;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes9.dex */
public class DanaFirebaseMessagingService extends FirebaseMessagingService implements PushNotificationContract.View {
    public static final String EMPTY = "empty";
    public static final String MESSAGE = "message";
    public static final String MESSAGE_DATA = "MESSAGE_DATA";
    public static final String TWILIO_CHALLENGE_NOTIFICATION_TYPE = "verify_push_challenge";
    public static final String TWILIO_CHALLENGE_SID = "challenge_sid";
    public static final String TWILIO_FACTOR_SID = "factor_sid";
    public static final String TYPE = "type";
    private boolean PlaceComponentResult;
    @Inject
    NotificationDirectorFactory notificationDirectorFactory;
    @Inject
    PushNotificationPresenter pushNotificationPresenter;
    @Inject
    TwilioMixpanelTracker twilioMixpanelTracker;
    public static final byte[] $$a = {121, 107, -47, -24, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 73;
    public static final byte[] getAuthRequestContext = {111, 84, 114, 59, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int MyBillsEntityDataFactory = 234;
    private static int scheduleImpl = 269894722;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 + 105
            int r6 = r6 * 4
            int r6 = r6 + 16
            byte[] r0 = id.dana.notification.DanaFirebaseMessagingService.getAuthRequestContext
            int r7 = r7 * 15
            int r7 = 18 - r7
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
            byte r4 = (byte) r8
            r1[r3] = r4
            int r7 = r7 + 1
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
            int r7 = r7 + 2
            r5 = r8
            r8 = r7
            r7 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.notification.DanaFirebaseMessagingService.a(int, int, int, java.lang.Object[]):void");
    }

    private static void b(short s, int i, int i2, Object[] objArr) {
        int i3 = 47 - i2;
        int i4 = (s * 2) + 75;
        int i5 = 42 - (i * 3);
        byte[] bArr = $$a;
        byte[] bArr2 = new byte[i5];
        int i6 = -1;
        int i7 = i5 - 1;
        if (bArr == null) {
            i4 = (i7 + i4) - 7;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i6 = -1;
            i3++;
            i7 = i7;
        }
        while (true) {
            int i8 = i6 + 1;
            bArr2[i8] = (byte) i4;
            if (i8 == i7) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i9 = i7;
            i4 = (i4 + bArr[i3]) - 7;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i6 = i8;
            i3++;
            i7 = i9;
        }
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService, com.google.firebase.messaging.EnhancedIntentService, android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        c(true, (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 202, 15 - (ViewConfiguration.getPressedStateDuration() >> 16), 18 - (ViewConfiguration.getPressedStateDuration() >> 16), new char[]{0, '\f', 15, 65517, 65483, 16, '\f', 65483, 1, 6, '\f', 15, 1, 11, 65534, 16, 16, 2}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        c(false, 206 - TextUtils.lastIndexOf("", '0'), KeyEvent.getDeadChar(0, 0) + 3, TextUtils.lastIndexOf("", '0') + 6, new char[]{65517, 1, 65532, 5, 17}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.combineMeasuredStates(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) View.resolveSizeAndState(0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    c(true, 174 - View.combineMeasuredStates(0, 0), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 27, 47 - TextUtils.indexOf((CharSequence) "", '0', 0), new char[]{29, 65521, 65516, 29, 65519, 28, 28, 29, JSONLexer.EOI, 65519, 65514, 65514, 65519, 65514, 65515, 30, 31, 28, 30, 65520, 65521, 65522, 29, 65513, 65521, 65519, 28, 65520, 30, 65519, 65516, 27, 65519, 65517, 31, 65520, 65513, 65521, 65522, 31, 65522, 65515, 65519, 65522, 30, JSONLexer.EOI, 29, 65515}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    c(false, (ViewConfiguration.getPressedStateDuration() >> 16) + 169, 33 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 64 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), new char[]{65520, '!', Typography.quote, 65522, 65526, '!', '!', 65518, 65521, 65523, 65518, '#', 65519, '!', 65525, 65519, 65525, 65521, 65521, 65525, 65527, 65527, 65525, 65518, 65519, 65518, 65519, '!', InputCardNumberView.DIVIDER, 65519, 65526, Typography.quote, 65521, 31, 65523, 65524, Typography.quote, Typography.dollar, 65527, 65518, 65526, Typography.quote, '!', 65527, 65523, Typography.quote, 65519, 65519, 65522, 65520, 65520, Typography.dollar, 65519, Typography.quote, 65519, 65524, 65521, 65524, InputCardNumberView.DIVIDER, 65527, '#', 65526, Typography.quote, 65520}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    c(false, 171 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 40 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 63, new char[]{65523, Typography.quote, 65525, 65524, Typography.quote, Typography.quote, 65523, 31, 65523, InputCardNumberView.DIVIDER, 65518, 65524, 30, 65523, 65522, 65524, 65524, Typography.quote, 65517, 65520, 65524, 65516, 29, 30, Typography.quote, 65525, 31, '!', 65518, 65517, Typography.quote, 65521, 65523, 65521, 65525, 65522, Typography.quote, 65521, 65521, 65525, 65518, 65517, '!', 30, 65525, 65523, 65518, 65520, 65524, 65524, 65524, 65517, 65517, 65519, 65516, 65523, 29, '!', 65520, InputCardNumberView.DIVIDER, 65518, 30, 29, 65519}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    c(false, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR, 37 - TextUtils.getOffsetAfter("", 0), 61 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), new char[]{65485, 6, 20, 0, 17, 3, 18, 16, 20, 0, 17, 4, 65485, 2, 14, '\f', 65486, 0, 15, '\b', 65486, '\b', '\r', 6, 4, 18, 19, 65486, 21, 65489, 65486, 4, 21, 4, '\r', 19, 18, 7, 19, 19, 15, 18, 65497, 65486, 65486, 3, 0, '\r', 0, 65485, 19, 7, 17, 4, 0, 19, 2, 0, 18, 19}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    c(true, 153 - TextUtils.getCapsMode("", 0, 0), ((byte) KeyEvent.getModifierMetaStateMask()) + 7, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 6, new char[]{65535, 0, 65532, 2, 65532, 7}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - ExpandableListView.getPackedPositionGroup(0L), ExpandableListView.getPackedPositionChild(0L) + 19, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                a(b, b, getAuthRequestContext[5], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b2 = (byte) (getAuthRequestContext[5] - 1);
                byte b3 = getAuthRequestContext[5];
                Object[] objArr14 = new Object[1];
                a(b2, b3, (byte) (b3 - 1), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getTrimmedLength("") + 55, TextUtils.lastIndexOf("", '0') + 4, (char) Color.green(0));
                        Object[] objArr16 = new Object[1];
                        b($$a[78], $$a[31], $$a[53], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 800, (Process.myTid() >> 22) + 15, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myPid() >> 22) + 800, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 14, (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - (ViewConfiguration.getWindowTouchSlop() >> 8), TextUtils.getOffsetAfter("", 0) + 29, (char) (TextUtils.getOffsetAfter("", 0) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 16, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r10 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - TextUtils.lastIndexOf("", '0', 0), (char) View.MeasureSpec.getSize(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {1788602075, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetAfter("", 0) + 911, (ViewConfiguration.getScrollBarSize() >> 8) + 18, (char) ExpandableListView.getPackedPositionType(0L))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a(b4, b4, getAuthRequestContext[5], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b5 = (byte) (getAuthRequestContext[5] - 1);
                byte b6 = getAuthRequestContext[5];
                Object[] objArr20 = new Object[1];
                a(b5, b6, (byte) (b6 - 1), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(60 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 45, (char) TextUtils.indexOf("", ""));
                        Object[] objArr22 = new Object[1];
                        b($$a[9], $$a[8], $$a[84], objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 34, (char) View.MeasureSpec.getSize(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {1788602075, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 911, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 19, (char) Color.blue(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a(b7, b7, getAuthRequestContext[5], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b8 = (byte) (getAuthRequestContext[5] - 1);
                byte b9 = getAuthRequestContext[5];
                Object[] objArr26 = new Object[1];
                a(b8, b9, (byte) (b9 - 1), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 119, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 4, (char) (38968 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))));
                        Object[] objArr28 = new Object[1];
                        b($$a[9], $$a[8], $$a[84], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getLongPressTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - ExpandableListView.getPackedPositionChild(0L), (char) TextUtils.getCapsMode("", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {1788602075, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getWindowTouchSlop() >> 8) + 911, (ViewConfiguration.getTouchSlop() >> 8) + 18, (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a(b10, b10, getAuthRequestContext[5], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b11 = (byte) (getAuthRequestContext[5] - 1);
                byte b12 = getAuthRequestContext[5];
                Object[] objArr32 = new Object[1];
                a(b11, b12, (byte) (b12 - 1), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 108, 3 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))));
                        byte b13 = (byte) ($$a[78] - 1);
                        byte b14 = b13;
                        Object[] objArr34 = new Object[1];
                        b(b13, b14, b14, objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getTouchSlop() >> 8) + 35, (char) View.MeasureSpec.getMode(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {1788602075, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 911, 18 - TextUtils.getTrimmedLength(""), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.AbstractContract.AbstractView
    public void dismissProgress() {
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

    @Override // id.dana.base.AbstractContract.AbstractView
    public void onError(String str) {
    }

    @Override // id.dana.contract.notification.PushNotificationContract.View
    public void onReportDeviceFailed() {
    }

    @Override // id.dana.contract.notification.PushNotificationContract.View
    public void onReportDeviceSuccess() {
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void showProgress() {
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService, com.google.firebase.messaging.EnhancedIntentService, android.app.Service
    public void onCreate() {
        try {
            byte b = 0;
            byte b2 = (byte) (getAuthRequestContext[5] - 1);
            Object[] objArr = new Object[1];
            a(b2, b2, getAuthRequestContext[5], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (getAuthRequestContext[5] - 1);
            byte b4 = getAuthRequestContext[5];
            Object[] objArr2 = new Object[1];
            a(b3, b4, (byte) (b4 - 1), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 494, 3 - ImageFormat.getBitsPerPixel(0), (char) (ViewConfiguration.getTouchSlop() >> 8));
                    byte b5 = (byte) ($$a[78] - 1);
                    byte b6 = b5;
                    Object[] objArr4 = new Object[1];
                    b(b5, b6, b6, objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 930, (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 34, (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-158977770, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0) + 911, (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18, (char) View.resolveSizeAndState(0, 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                Rum.CC.getAuthRequestContext().PlaceComponentResult("PushNotif.onCreate");
                Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = InstrumentInjector.getDefaultUncaughtExceptionHandler();
                if (defaultUncaughtExceptionHandler != null && !(defaultUncaughtExceptionHandler instanceof AppExceptionHandler)) {
                    InstrumentInjector.setDefaultUncaughtExceptionHandler(new AppExceptionHandler(defaultUncaughtExceptionHandler, null));
                }
                DaggerPushNotificationComponent.Builder MyBillsEntityDataFactory2 = DaggerPushNotificationComponent.MyBillsEntityDataFactory();
                MyBillsEntityDataFactory2.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) getApplication()).getApplicationComponent());
                MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2 = (PushNotificationModule) Preconditions.getAuthRequestContext(new PushNotificationModule(this));
                Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2, PushNotificationModule.class);
                Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory2.PlaceComponentResult, ApplicationComponent.class);
                new DaggerPushNotificationComponent.PushNotificationComponentImpl(MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory2.PlaceComponentResult, b).MyBillsEntityDataFactory(this);
                final PushNotificationPresenter pushNotificationPresenter = this.pushNotificationPresenter;
                pushNotificationPresenter.getAuthRequestContext.execute(new DefaultObserver<Boolean>() { // from class: id.dana.contract.notification.PushNotificationPresenter.2
                    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                    public /* synthetic */ void onNext(Object obj4) {
                        pushNotificationPresenter.scheduleImpl.onCheckPushNotifDiagnosticFeatureeSuccess(((Boolean) obj4).booleanValue());
                    }
                });
                Rum.CC.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory("PushNotif.onCreate");
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

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        String str;
        String str2;
        final String str3;
        final String str4;
        Rum.CC.getAuthRequestContext().PlaceComponentResult("PushNotif.onMessageReceived");
        if (this.PlaceComponentResult && PushServiceInstance.getPushService() != null) {
            Rum.CC.getAuthRequestContext().PlaceComponentResult("PushNotif.PushServiceInstance.getPushService", "PushNotif.onMessageReceived");
            PushServiceInstance.getPushService().dispatchMessage(remoteMessage);
            Rum.CC.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory("PushNotif.PushServiceInstance.getPushService");
        }
        getString(R.string.notif_title);
        getString(R.string.notif_message);
        if (remoteMessage.getNotification() != null) {
            str = remoteMessage.getNotification().getTitle();
            str2 = remoteMessage.getNotification().getBody();
        } else {
            str = remoteMessage.getData().get("title");
            str2 = remoteMessage.getData().get("body");
        }
        if (remoteMessage.getData().size() > 0) {
            remoteMessage.getData();
            final Map<String, String> data = remoteMessage.getData();
            if (data != null) {
                NotificationData KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(str, str2, data);
                byte b = 0;
                if (KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 != null && KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext != null) {
                    TwilioMixpanelTracker twilioMixpanelTracker = this.twilioMixpanelTracker;
                    final String str5 = KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2;
                    final String str6 = KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
                    Intrinsics.checkNotNullParameter(data, "");
                    Function1<EventTrackerModel.Builder, Unit> function1 = new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.twilio.tracker.TwilioMixpanelTracker$trackMixpanelPushNotifReceived$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                            invoke2(builder);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(EventTrackerModel.Builder builder) {
                            Intrinsics.checkNotNullParameter(builder, "");
                            builder.MyBillsEntityDataFactory = TrackerKey.Event.NOTIFICATION_PUSH_RECEIVED;
                            for (Map.Entry<String, String> entry : data.entrySet()) {
                                String key = entry.getKey();
                                String value = entry.getValue();
                                if (!StringsKt.equals("contextCode", key, true) && !StringsKt.equals("contextValue", value, true)) {
                                    builder.MyBillsEntityDataFactory(StringUtil.camelToSentenceCase(key), value);
                                }
                            }
                            String str7 = str5;
                            if (str7 != null) {
                                builder.MyBillsEntityDataFactory(TrackerKey.Property.CONTEXT_CODE, str7);
                            }
                            String str8 = str6;
                            if (str8 != null) {
                                builder.MyBillsEntityDataFactory(TrackerKey.Property.CONTEXT_VALUE, str8);
                            }
                            builder.MyBillsEntityDataFactory(TrackerKey.Property.PAYLOAD, data.toString());
                        }
                    };
                    EventTrackerModel.Builder PlaceComponentResult = EventTrackerModel.Builder.PlaceComponentResult(twilioMixpanelTracker.KClassImpl$Data$declaredNonStaticMembers$2);
                    Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
                    function1.invoke(PlaceComponentResult);
                    PlaceComponentResult.PlaceComponentResult();
                    EventTracker.PlaceComponentResult(new EventTrackerModel(PlaceComponentResult, b));
                } else {
                    final String str7 = null;
                    if (KClassImpl$Data$declaredNonStaticMembers$2.DatabaseTableConfigUtil != null) {
                        Uri parse = Uri.parse(KClassImpl$Data$declaredNonStaticMembers$2.DatabaseTableConfigUtil);
                        try {
                            str3 = parse.getQueryParameter("contextCode");
                        } catch (UnsupportedOperationException unused) {
                            str3 = null;
                        }
                        try {
                            str4 = parse.getQueryParameter("contextValue");
                        } catch (UnsupportedOperationException unused2) {
                            str4 = null;
                        }
                        if (str3 != null && str4 != null) {
                            TwilioMixpanelTracker twilioMixpanelTracker2 = this.twilioMixpanelTracker;
                            Intrinsics.checkNotNullParameter(data, "");
                            Function1<EventTrackerModel.Builder, Unit> function12 = new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.twilio.tracker.TwilioMixpanelTracker$trackMixpanelPushNotifReceived$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                                    invoke2(builder);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2(EventTrackerModel.Builder builder) {
                                    Intrinsics.checkNotNullParameter(builder, "");
                                    builder.MyBillsEntityDataFactory = TrackerKey.Event.NOTIFICATION_PUSH_RECEIVED;
                                    for (Map.Entry<String, String> entry : data.entrySet()) {
                                        String key = entry.getKey();
                                        String value = entry.getValue();
                                        if (!StringsKt.equals("contextCode", key, true) && !StringsKt.equals("contextValue", value, true)) {
                                            builder.MyBillsEntityDataFactory(StringUtil.camelToSentenceCase(key), value);
                                        }
                                    }
                                    String str72 = str3;
                                    if (str72 != null) {
                                        builder.MyBillsEntityDataFactory(TrackerKey.Property.CONTEXT_CODE, str72);
                                    }
                                    String str8 = str4;
                                    if (str8 != null) {
                                        builder.MyBillsEntityDataFactory(TrackerKey.Property.CONTEXT_VALUE, str8);
                                    }
                                    builder.MyBillsEntityDataFactory(TrackerKey.Property.PAYLOAD, data.toString());
                                }
                            };
                            EventTrackerModel.Builder PlaceComponentResult2 = EventTrackerModel.Builder.PlaceComponentResult(twilioMixpanelTracker2.KClassImpl$Data$declaredNonStaticMembers$2);
                            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
                            function12.invoke(PlaceComponentResult2);
                            PlaceComponentResult2.PlaceComponentResult();
                            EventTracker.PlaceComponentResult(new EventTrackerModel(PlaceComponentResult2, b));
                        } else {
                            TwilioMixpanelTracker twilioMixpanelTracker3 = this.twilioMixpanelTracker;
                            Intrinsics.checkNotNullParameter(data, "");
                            Function1<EventTrackerModel.Builder, Unit> function13 = new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.twilio.tracker.TwilioMixpanelTracker$trackMixpanelPushNotifReceived$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                                    invoke2(builder);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2(EventTrackerModel.Builder builder) {
                                    Intrinsics.checkNotNullParameter(builder, "");
                                    builder.MyBillsEntityDataFactory = TrackerKey.Event.NOTIFICATION_PUSH_RECEIVED;
                                    for (Map.Entry<String, String> entry : data.entrySet()) {
                                        String key = entry.getKey();
                                        String value = entry.getValue();
                                        if (!StringsKt.equals("contextCode", key, true) && !StringsKt.equals("contextValue", value, true)) {
                                            builder.MyBillsEntityDataFactory(StringUtil.camelToSentenceCase(key), value);
                                        }
                                    }
                                    String str72 = str7;
                                    if (str72 != null) {
                                        builder.MyBillsEntityDataFactory(TrackerKey.Property.CONTEXT_CODE, str72);
                                    }
                                    String str8 = str7;
                                    if (str8 != null) {
                                        builder.MyBillsEntityDataFactory(TrackerKey.Property.CONTEXT_VALUE, str8);
                                    }
                                    builder.MyBillsEntityDataFactory(TrackerKey.Property.PAYLOAD, data.toString());
                                }
                            };
                            EventTrackerModel.Builder PlaceComponentResult3 = EventTrackerModel.Builder.PlaceComponentResult(twilioMixpanelTracker3.KClassImpl$Data$declaredNonStaticMembers$2);
                            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult3, "");
                            function13.invoke(PlaceComponentResult3);
                            PlaceComponentResult3.PlaceComponentResult();
                            EventTracker.PlaceComponentResult(new EventTrackerModel(PlaceComponentResult3, b));
                        }
                    } else {
                        TwilioMixpanelTracker twilioMixpanelTracker4 = this.twilioMixpanelTracker;
                        Intrinsics.checkNotNullParameter(data, "");
                        Function1<EventTrackerModel.Builder, Unit> function14 = new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.twilio.tracker.TwilioMixpanelTracker$trackMixpanelPushNotifReceived$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                                invoke2(builder);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(EventTrackerModel.Builder builder) {
                                Intrinsics.checkNotNullParameter(builder, "");
                                builder.MyBillsEntityDataFactory = TrackerKey.Event.NOTIFICATION_PUSH_RECEIVED;
                                for (Map.Entry<String, String> entry : data.entrySet()) {
                                    String key = entry.getKey();
                                    String value = entry.getValue();
                                    if (!StringsKt.equals("contextCode", key, true) && !StringsKt.equals("contextValue", value, true)) {
                                        builder.MyBillsEntityDataFactory(StringUtil.camelToSentenceCase(key), value);
                                    }
                                }
                                String str72 = str7;
                                if (str72 != null) {
                                    builder.MyBillsEntityDataFactory(TrackerKey.Property.CONTEXT_CODE, str72);
                                }
                                String str8 = str7;
                                if (str8 != null) {
                                    builder.MyBillsEntityDataFactory(TrackerKey.Property.CONTEXT_VALUE, str8);
                                }
                                builder.MyBillsEntityDataFactory(TrackerKey.Property.PAYLOAD, data.toString());
                            }
                        };
                        EventTrackerModel.Builder PlaceComponentResult4 = EventTrackerModel.Builder.PlaceComponentResult(twilioMixpanelTracker4.KClassImpl$Data$declaredNonStaticMembers$2);
                        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult4, "");
                        function14.invoke(PlaceComponentResult4);
                        PlaceComponentResult4.PlaceComponentResult();
                        EventTracker.PlaceComponentResult(new EventTrackerModel(PlaceComponentResult4, b));
                    }
                }
                NotificationDirector PlaceComponentResult5 = this.notificationDirectorFactory.PlaceComponentResult(getApplicationContext(), KClassImpl$Data$declaredNonStaticMembers$2(str, str2, data));
                if (PlaceComponentResult5 != null) {
                    PlaceComponentResult5.MyBillsEntityDataFactory();
                }
            }
        }
        if (BuiltInFictitiousFunctionClassFactory(remoteMessage.getData())) {
            RxNotificationBus.BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2.onNext(Boolean.TRUE);
            if (MyBillsEntityDataFactory(remoteMessage.getData())) {
                TransactionDetailNotificationBus.PlaceComponentResult(remoteMessage.getData());
            }
        } else {
            KybNotificationBus.BuiltInFictitiousFunctionClassFactory();
        }
        Rum.CC.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory("PushNotif.onMessageReceived");
    }

    private static boolean MyBillsEntityDataFactory(Map<String, String> map) {
        String str = map.get("redirectType");
        if (str != null) {
            return str.equals("TRANSACTION_DETAIL");
        }
        return false;
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(Map<String, String> map) {
        String str = map.get("redirectType");
        boolean equals = str != null ? str.equals("INNER_URL") : false;
        String str2 = map.get(ShareToFeedBridge.REDIRECT_VALUE);
        return (equals || (str2 != null && str2.contains(DanaUrl.KYB) && str2.contains("directTo=native"))) ? false : true;
    }

    private NotificationData KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2, final Map<String, String> map) {
        String str3 = map.get("iconUrl");
        String str4 = map.get("contentType");
        String str5 = map.get("redirectType");
        String str6 = map.get(ShareToFeedBridge.REDIRECT_VALUE);
        String str7 = map.get(GriverParams.ShareParams.IMAGE_URL);
        String str8 = map.get("sound");
        String str9 = map.get("contextCode");
        String str10 = map.get("contextValue");
        NotificationData notificationData = new NotificationData();
        notificationData.scheduleImpl = str;
        notificationData.lookAheadTest = str2;
        notificationData.MyBillsEntityDataFactory = str4;
        notificationData.BuiltInFictitiousFunctionClassFactory = str3;
        notificationData.getErrorConfigVersion = str5;
        notificationData.DatabaseTableConfigUtil = str6;
        notificationData.moveToNextValue = str7;
        notificationData.NetworkUserEntityData$$ExternalSyntheticLambda0 = new HashMap<>(map);
        notificationData.initRecordTimeStamp = str8;
        notificationData.KClassImpl$Data$declaredNonStaticMembers$2 = str9;
        notificationData.getAuthRequestContext = str10;
        final String str11 = map.get("twilioEvent");
        if (str11 == null) {
            str11 = "";
        }
        if (PlaceComponentResult(map)) {
            final TwilioMixpanelTracker twilioMixpanelTracker = this.twilioMixpanelTracker;
            Intrinsics.checkNotNullParameter(map, "");
            Intrinsics.checkNotNullParameter(str11, "");
            Function1<EventTrackerModel.Builder, Unit> function1 = new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.twilio.tracker.TwilioMixpanelTracker$trackMixpanelTwilioPushNotifReceived$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                    invoke2(builder);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(EventTrackerModel.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "");
                    builder.MyBillsEntityDataFactory = TrackerKey.Event.PUSH_VERIFY_NOTIFICATION_RECEIVED;
                    builder.MyBillsEntityDataFactory("Source", "Login");
                    builder.MyBillsEntityDataFactory(TrackerKey.Property.TIME, TwilioMixpanelTracker.getAuthRequestContext());
                    builder.MyBillsEntityDataFactory(TrackerKey.Property.CHALLENGE_SID, TwilioMixpanelTracker.getAuthRequestContext(map.get(DanaFirebaseMessagingService.TWILIO_CHALLENGE_SID)));
                    builder.MyBillsEntityDataFactory(TrackerKey.Property.FACTOR_SID, TwilioMixpanelTracker.getAuthRequestContext(map.get(DanaFirebaseMessagingService.TWILIO_FACTOR_SID)));
                    builder.MyBillsEntityDataFactory(TrackerKey.Property.NOTIFICATION_TYPE, "Twilio");
                    builder.MyBillsEntityDataFactory(TrackerKey.Property.DEVICE_SOURCE, TwilioMixpanelTracker.BuiltInFictitiousFunctionClassFactory(str11));
                }
            };
            EventTrackerModel.Builder PlaceComponentResult = EventTrackerModel.Builder.PlaceComponentResult(twilioMixpanelTracker.KClassImpl$Data$declaredNonStaticMembers$2);
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
            function1.invoke(PlaceComponentResult);
            PlaceComponentResult.PlaceComponentResult();
            EventTracker.PlaceComponentResult(new EventTrackerModel(PlaceComponentResult, (byte) 0));
            notificationData.scheduleImpl = getString(R.string.twilio_notification_title);
            notificationData.getErrorConfigVersion = RedirectType.TWILIO_CHALLENGE;
            notificationData.NetworkUserEntityData$$ExternalSyntheticLambda2 = map.get(TWILIO_CHALLENGE_SID);
            notificationData.GetContactSyncConfig = map.get(TWILIO_FACTOR_SID);
            notificationData.lookAheadTest = map.get("message");
            PushNotificationPresenter pushNotificationPresenter = this.pushNotificationPresenter;
            pushNotificationPresenter.PlaceComponentResult.execute(map.get(TWILIO_CHALLENGE_SID), new Function1() { // from class: id.dana.contract.notification.PushNotificationPresenter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit unit;
                    Boolean bool = (Boolean) obj;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            }, new Function1() { // from class: id.dana.contract.notification.PushNotificationPresenter$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit unit;
                    Throwable th = (Throwable) obj;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            });
        }
        return notificationData;
    }

    private static boolean PlaceComponentResult(Map<String, String> map) {
        return TWILIO_CHALLENGE_NOTIFICATION_TYPE.equals(map.get("type"));
    }

    @Override // id.dana.contract.notification.PushNotificationContract.View
    public void onCheckPushNotifDiagnosticFeatureeSuccess(boolean z) {
        this.PlaceComponentResult = z;
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String str) {
        final PushNotificationPresenter pushNotificationPresenter = this.pushNotificationPresenter;
        pushNotificationPresenter.BuiltInFictitiousFunctionClassFactory.execute(new DefaultObserver<ReportDeviceResponse>() { // from class: id.dana.contract.notification.PushNotificationPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                ReportDeviceResponse reportDeviceResponse = (ReportDeviceResponse) obj;
                pushNotificationPresenter.scheduleImpl.onReportDeviceSuccess();
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                pushNotificationPresenter.scheduleImpl.onReportDeviceFailed();
            }
        }, ReportDevice.Params.forReportDevice(str, "", "", ((DanaApplication) getApplication()).getNetworkType()));
        final PushNotificationPresenter pushNotificationPresenter2 = this.pushNotificationPresenter;
        pushNotificationPresenter2.KClassImpl$Data$declaredNonStaticMembers$2.execute(new DefaultObserver<Boolean>() { // from class: id.dana.contract.notification.PushNotificationPresenter.3
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* bridge */ /* synthetic */ void onNext(Object obj) {
                Boolean bool = (Boolean) obj;
            }
        }, str);
    }

    private static void c(boolean z, int i, int i2, int i3, char[] cArr, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i3];
        a2.MyBillsEntityDataFactory = 0;
        while (a2.MyBillsEntityDataFactory < i3) {
            a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
            cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
            int i4 = a2.MyBillsEntityDataFactory;
            cArr2[i4] = (char) (cArr2[i4] - ((int) (scheduleImpl ^ (-5694784870793460699L))));
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
