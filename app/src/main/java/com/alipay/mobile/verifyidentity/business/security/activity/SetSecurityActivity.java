package com.alipay.mobile.verifyidentity.business.security.activity;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
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
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.errorcode.IAPError;
import com.alipay.iap.android.common.task.async.IAPAsyncTask;
import com.alipay.mobile.verifyidentity.RpcSettings;
import com.alipay.mobile.verifyidentity.base.message.Message;
import com.alipay.mobile.verifyidentity.base.message.MessageConstants;
import com.alipay.mobile.verifyidentity.base.message.RequestConstants;
import com.alipay.mobile.verifyidentity.business.activity.ActivityInterface;
import com.alipay.mobile.verifyidentity.business.activity.ActivityInterfaceManager;
import com.alipay.mobile.verifyidentity.business.activity.BaseActivity;
import com.alipay.mobile.verifyidentity.business.activity.ClientLogKitManager;
import com.alipay.mobile.verifyidentity.business.activity.HandlerCallback;
import com.alipay.mobile.verifyidentity.business.security.activity.SetSecurityFragment;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.QuestionItem;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.alipay.mobile.verifyidentity.framework.engine.VIEngineUtils;
import com.alipay.mobile.verifyidentity.uitools.ColorUtils;
import com.alipay.mobile.verifyidentity.uitools.CustomUi;
import com.alipay.mobileiclib.common.service.facade.solution.dto.MICRpcRequest;
import com.alipay.mobileiclib.common.service.facade.solution.dto.MICRpcResponse;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import o.B;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class SetSecurityActivity extends BaseActivity {
    private static final int CLOSE_ACTIVITY = 2001;
    private static short[] NetworkUserEntityData$$ExternalSyntheticLambda0;
    private String button1Action;
    private String button1Text;
    private FrameLayout container;
    private String from_title;
    private Message message;
    private String nextAction;
    private String nextStep;
    private int pageSize;
    private String pageTitle;
    private String prodmngId;
    private String productType;
    private View rl_title;
    private String sceneId;
    private String tntInstId;
    private TextView tv_title;
    private String userId;
    public static final byte[] $$d = {TarHeader.LF_DIR, 18, -76, 65, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$e = 104;
    public static final byte[] getAuthRequestContext = {76, 9, -56, 93, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int BuiltInFictitiousFunctionClassFactory = 46;
    private static int scheduleImpl = 1257195724;
    private static int lookAheadTest = -823019251;
    private static byte[] getErrorConfigVersion = {32, 12, 62, 10, -8, -15, 42, 42, -77, 8, 77, -62, -13, -14, -15, 62, -10, 1, 45, -119, 90, 98, TarHeader.LF_SYMLINK, 88, -15, 60, 1, -22, -28, 89, -13, -23, 1, -21, 3, Ascii.US, -46, -31, 126, -16, -19, -63, 42, 57, 58, 59, -18, 6, -21, 32, 5, -36, 11, -79, 4, 8, 3, 2, -34, -11, 19, -36, -41, 17, -34, 3, -80, 66, -42, -86, 120, -43, -85, 119, -42, -82, 97, 102, 122, -44, -82, 101, 100, 125, -83, 100, -37, 119, -43, -84, 118, -41, 122, -87, 102, -86, -46, -84, -87, 98, -84, 102, 116, 102, -86, 103, -41, 102, 102, 124, -35, 97, -85, 122, -43, 114, 17, -76, -55, 17, -63, -74, -57, -63, -57, -1, -62, -56, -58, -52, -56, -60, -54, -2, Ascii.FS, -74, Ascii.DC4, -69, -3, -58, -59, 19, -56, -83, -52, Ascii.CAN, -57, -73, -56, 18, -76, Ascii.NAK, -76, Ascii.EM, -76, -59, -61, -53, 19, -75, 13, -68, -56, -62, -59, -56, 19, -79, -60, Ascii.SUB, -63, -76, -48, -7, Ascii.NAK, -58, -78, -57, Ascii.FS, 114, 42, 38, -31, TarHeader.LF_FIFO, -13, 42, -16, 36, -31, 59, -15, -29, 36, 60, Ascii.NAK, 42, 39, TarHeader.LF_CONTIG, -18, 42, 37, Ascii.GS, 0, 38, 36, -15, Ascii.ESC, 60, 40, -32, 3, Ascii.SUB, 2, Ascii.ETB, 38, 0, -15, Ascii.NAK, 1, 42, Ascii.DC4, -15, TarHeader.LF_FIFO, -32, TarHeader.LF_FIFO, -31, 42, 60, 41, -13, 36, 38, -17, 38, 38, 42, 36, -19, -16, Ascii.EM, -13, 58, -15, 118, 43, -76, -67, 91, -123, 100, 41, -22, -13, -17, -75, -68, 44, 45, -79, 112, 116, 45, -69, 104, 120, 44, -70, 97, 125, 39, -123, 90, -78, 44, -69, 40, -123, 90, -68, 109, -16, -75, -120, 44, 91, -121, 42, 39, Byte.MIN_VALUE, 34, -12, 121, 39, -71, 41, 97, -74, 33, 115, -73, 42, -74, -70, 44, -70, -47, -65, -45, Byte.MIN_VALUE};
    private static int PlaceComponentResult = -526743796;
    private ArrayList<ArrayList<List<QuestionItem>>> adapterList = new ArrayList<>();
    private QuestionItem[] questionItemArr = new QuestionItem[0];
    private String[] answerId = new String[0];
    private List<Fragment> mFragments = new ArrayList();

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(int r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 + 4
            int r6 = r6 + 97
            int r8 = 23 - r8
            byte[] r0 = com.alipay.mobile.verifyidentity.business.security.activity.SetSecurityActivity.getAuthRequestContext
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
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
            r5 = r7
            r7 = r6
            r6 = r5
        L1a:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            r3 = r0[r6]
            r5 = r8
            r8 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L32:
            int r7 = r7 + r6
            int r7 = r7 + (-4)
            int r6 = r8 + 1
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.verifyidentity.business.security.activity.SetSecurityActivity.d(int, short, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void f(byte r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 + 4
            int r7 = r7 * 2
            int r7 = 103 - r7
            int r8 = r8 * 3
            int r8 = r8 + 21
            byte[] r0 = com.alipay.mobile.verifyidentity.business.security.activity.SetSecurityActivity.$$d
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
            goto L35
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            r3 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L35:
            int r8 = r8 + r6
            int r6 = r7 + 1
            int r7 = r8 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.verifyidentity.business.security.activity.SetSecurityActivity.f(byte, short, byte, java.lang.Object[]):void");
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        e((short) ((-2) - View.resolveSize(0, 0)), (byte) (KeyEvent.getDeadChar(0, 0) - 111), KeyEvent.getDeadChar(0, 0) - 84, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 1435119724, Color.alpha(0) + 2078346959, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        e((short) ((-103) - ExpandableListView.getPackedPositionChild(0L)), (byte) ((ViewConfiguration.getScrollBarSize() >> 8) + 75), View.combineMeasuredStates(0, 0) - 84, 1435119743 - Color.blue(0), 2078346971 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    e((short) (TextUtils.getOffsetBefore("", 0) + 104), (byte) (Color.green(0) - 98), (-84) - ExpandableListView.getPackedPositionGroup(0L), 1435119793 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), ExpandableListView.getPackedPositionChild(0L) + 2078346918, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    e((short) (37 - Color.blue(0)), (byte) (124 - ExpandableListView.getPackedPositionGroup(0L)), (ViewConfiguration.getEdgeSlop() >> 16) - 84, ExpandableListView.getPackedPositionChild(0L) + 1435119841, KeyEvent.keyCodeFromString("") + 2078346959, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    e((short) ((Process.myTid() >> 22) - 20), (byte) ((-91) - (ViewConfiguration.getScrollDefaultDelay() >> 16)), (-83) - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), 1435119904 - (ViewConfiguration.getWindowTouchSlop() >> 8), (ViewConfiguration.getScrollBarSize() >> 8) + 2078346912, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    e((short) ((-111) - ((Process.getThreadPriority(0) + 20) >> 6)), (byte) (TextUtils.getOffsetBefore("", 0) - 70), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 85, 1435119967 - ImageFormat.getBitsPerPixel(0), 2078346965 - ImageFormat.getBitsPerPixel(0), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    e((short) (72 - View.resolveSizeAndState(0, 0, 0)), (byte) ((-111) - TextUtils.indexOf((CharSequence) "", '0')), (ViewConfiguration.getDoubleTapTimeout() >> 16) - 84, AndroidCharacter.getMirror('0') + 12652, 2078346919 - View.MeasureSpec.getMode(0), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 911, 19 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                d(getAuthRequestContext[1], (short) 37, (byte) (-getAuthRequestContext[30]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                d((byte) (BuiltInFictitiousFunctionClassFactory & 24), getAuthRequestContext[35], (byte) (-getAuthRequestContext[30]), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + 55, 2 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (Process.getGidForName("") + 1));
                        Object[] objArr16 = new Object[1];
                        f((byte) ($$d[78] - 1), $$d[12], $$d[78], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + 800, Color.blue(0) + 15, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getPressedStateDuration() >> 16), 15 - View.MeasureSpec.getSize(0), (char) Color.green(0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - ExpandableListView.getPackedPositionGroup(0L), 29 - View.resolveSize(0, 0), (char) (57994 - (ViewConfiguration.getTapTimeout() >> 16)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - TextUtils.getOffsetAfter("", 0), 16 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getTrimmedLength("") + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-972751941, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getKeyRepeatDelay() >> 16), 18 - KeyEvent.normalizeMetaState(0), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                d(getAuthRequestContext[1], (short) 37, (byte) (-getAuthRequestContext[30]), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                d((byte) (BuiltInFictitiousFunctionClassFactory & 24), getAuthRequestContext[35], (byte) (-getAuthRequestContext[30]), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - TextUtils.getOffsetAfter("", 0), 46 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) Drawable.resolveOpacity(0, 0));
                        byte b = (byte) ($$d[23] - 1);
                        byte b2 = (byte) ($$d[78] - 1);
                        Object[] objArr22 = new Object[1];
                        f(b, b2, b2, objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + 930, 35 - Color.green(0), (char) View.MeasureSpec.getMode(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-972751941, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + 911, (Process.myTid() >> 22) + 18, (char) (Process.myTid() >> 22))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                d(getAuthRequestContext[1], (short) 37, (byte) (-getAuthRequestContext[30]), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                d((byte) (BuiltInFictitiousFunctionClassFactory & 24), getAuthRequestContext[35], (byte) (-getAuthRequestContext[30]), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - Color.green(0), 3 - TextUtils.getCapsMode("", 0, 0), (char) (38968 - (ViewConfiguration.getScrollBarFadeDuration() >> 16)));
                        byte b3 = (byte) ($$d[23] - 1);
                        byte b4 = (byte) ($$d[78] - 1);
                        Object[] objArr28 = new Object[1];
                        f(b3, b4, b4, objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-972751941, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + 911, 17 - TextUtils.lastIndexOf("", '0', 0, 0), (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                d(getAuthRequestContext[1], (short) 37, (byte) (-getAuthRequestContext[30]), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                d((byte) (BuiltInFictitiousFunctionClassFactory & 24), getAuthRequestContext[35], (byte) (-getAuthRequestContext[30]), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - TextUtils.getCapsMode("", 0, 0), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 3, (char) (ViewConfiguration.getLongPressTimeout() >> 16));
                        Object[] objArr34 = new Object[1];
                        f($$d[53], $$d[9], $$d[8], objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r3 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getScrollBarSize() >> 8), (char) Color.blue(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-972751941, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.makeMeasureSpec(0, 0) + 911, Color.alpha(0) + 18, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
            short windowTouchSlop = (short) ((ViewConfiguration.getWindowTouchSlop() >> 8) - 9);
            try {
                byte b = getAuthRequestContext[25];
                byte b2 = b;
                Object[] objArr = new Object[1];
                d(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                d((byte) (-getAuthRequestContext[5]), (byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[27], objArr2);
                byte b3 = (byte) (((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion + 69);
                try {
                    byte b4 = getAuthRequestContext[25];
                    byte b5 = b4;
                    Object[] objArr3 = new Object[1];
                    d(b4, b5, b5, objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    d((byte) (-getAuthRequestContext[5]), (byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[27], new Object[1]);
                    Object[] objArr4 = new Object[1];
                    e(windowTouchSlop, b3, ((ApplicationInfo) cls2.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 117, super.getResources().getString(R.string.promo_quest_entry_description).substring(8, 9).length() + 1435119747, super.getResources().getString(R.string.payment_result_transaction_fee_content).substring(15, 18).length() + 2078346956, objArr4);
                    Class<?> cls3 = Class.forName((String) objArr4[0]);
                    try {
                        byte b6 = getAuthRequestContext[25];
                        byte b7 = b6;
                        Object[] objArr5 = new Object[1];
                        d(b6, b7, b7, objArr5);
                        Class<?> cls4 = Class.forName((String) objArr5[0]);
                        d((byte) (-getAuthRequestContext[5]), (byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[27], new Object[1]);
                        Object[] objArr6 = new Object[1];
                        e((short) (((ApplicationInfo) cls4.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 15), (byte) (super.getResources().getString(R.string.family_account_text_resend_title).substring(5, 6).codePointAt(0) - 22), Process.getGidForName("") - 83, 1435119774 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), super.getResources().getString(R.string.link_not_found_desc).substring(16, 21).codePointAt(3) + 2078346851, objArr6);
                        baseContext = (Context) cls3.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
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
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getLongPressTimeout() >> 16), TextUtils.indexOf((CharSequence) "", '0') + 36, (char) KeyEvent.getDeadChar(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr7 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 912, (KeyEvent.getMaxKeyCode() >> 16) + 18, (char) View.resolveSizeAndState(0, 0, 0))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr7);
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
        super.onPause();
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            e((short) (super.getResources().getString(R.string.max_participant_error_message).substring(6, 7).length() - 10), (byte) (102 - KeyEvent.normalizeMetaState(0)), super.getResources().getString(R.string.citcall_consult_limit_dialog_desc).substring(3, 4).length() - 85, 1435119632 + super.getResources().getString(R.string.bottom_on_boarding_body_text_split_bill_second).substring(11, 12).codePointAt(0), 2078346960 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            e((short) (getPackageName().codePointAt(1) - 82), (byte) (83 - TextUtils.getOffsetAfter("", 0)), View.MeasureSpec.getMode(0) - 84, 1435119775 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 2078346961 - (ViewConfiguration.getDoubleTapTimeout() >> 16), objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 34 - TextUtils.lastIndexOf("", '0', 0), (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 912, (KeyEvent.getMaxKeyCode() >> 16) + 18, (char) TextUtils.indexOf("", "", 0, 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        short scrollDefaultDelay = (short) ((ViewConfiguration.getScrollDefaultDelay() >> 16) - 2);
        byte axisFromString = (byte) ((-112) - MotionEvent.axisFromString(""));
        try {
            byte b = getAuthRequestContext[25];
            byte b2 = b;
            Object[] objArr2 = new Object[1];
            d(b, b2, b2, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            d((byte) (-getAuthRequestContext[5]), (byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[27], new Object[1]);
            Object[] objArr3 = new Object[1];
            e(scrollDefaultDelay, axisFromString, ((ApplicationInfo) cls.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 117, 1435119725 + Color.argb(0, 0, 0, 0), 2078346927 + super.getResources().getString(R.string.my_bills_label_dana_balance_insufficient).substring(22, 23).codePointAt(0), objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            e((short) (getPackageName().codePointAt(4) - 199), (byte) (super.getResources().getString(R.string.ucrop_mutate_exception_hint).substring(21, 22).codePointAt(0) - 36), super.getResources().getString(R.string.pushverify_verify_dialog_login_deny_message).substring(23, 24).codePointAt(0) - 116, super.getResources().getString(R.string.choose_photo).substring(9, 10).codePointAt(0) + 1435119632, getPackageName().length() + 2078346964, objArr4);
            int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    short length = (short) (super.getResources().getString(R.string.discard_changes_dialog_filled_title).substring(19, 21).length() - 11);
                    try {
                        byte b3 = getAuthRequestContext[25];
                        byte b4 = b3;
                        Object[] objArr5 = new Object[1];
                        d(b3, b4, b4, objArr5);
                        Class<?> cls3 = Class.forName((String) objArr5[0]);
                        Object[] objArr6 = new Object[1];
                        d((byte) (-getAuthRequestContext[5]), (byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[27], objArr6);
                        byte b5 = (byte) (((ApplicationInfo) cls3.getMethod((String) objArr6[0], null).invoke(this, null)).targetSdkVersion + 69);
                        try {
                            byte b6 = getAuthRequestContext[25];
                            byte b7 = b6;
                            Object[] objArr7 = new Object[1];
                            d(b6, b7, b7, objArr7);
                            Class<?> cls4 = Class.forName((String) objArr7[0]);
                            d((byte) (-getAuthRequestContext[5]), (byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[27], new Object[1]);
                            Object[] objArr8 = new Object[1];
                            e(length, b5, ((ApplicationInfo) cls4.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 117, getPackageName().codePointAt(1) + 1435119648, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 2078346960, objArr8);
                            Class<?> cls5 = Class.forName((String) objArr8[0]);
                            Object[] objArr9 = new Object[1];
                            e((short) (getPackageName().length() + 11), (byte) (super.getResources().getString(R.string.family_account_lets_activate).substring(2, 3).codePointAt(0) - 33), (-84) - TextUtils.getTrimmedLength(""), super.getResources().getString(R.string.express_pay_desc_gpn).substring(38, 39).length() + 1435119773, 2078346961 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), objArr9);
                            baseContext = (Context) cls5.getMethod((String) objArr9[0], new Class[0]).invoke(null, null);
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
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), 35 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (Process.myPid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        try {
                            byte b8 = getAuthRequestContext[25];
                            byte b9 = b8;
                            Object[] objArr10 = new Object[1];
                            d(b8, b9, b9, objArr10);
                            Class<?> cls6 = Class.forName((String) objArr10[0]);
                            Object[] objArr11 = new Object[1];
                            d((byte) (-getAuthRequestContext[5]), (byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[27], objArr11);
                            short s = (short) (((ApplicationInfo) cls6.getMethod((String) objArr11[0], null).invoke(this, null)).targetSdkVersion + 71);
                            byte alpha = (byte) ((-98) - Color.alpha(0));
                            try {
                                byte b10 = getAuthRequestContext[25];
                                byte b11 = b10;
                                Object[] objArr12 = new Object[1];
                                d(b10, b11, b11, objArr12);
                                Class<?> cls7 = Class.forName((String) objArr12[0]);
                                Object[] objArr13 = new Object[1];
                                d((byte) (-getAuthRequestContext[5]), (byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[27], objArr13);
                                int i = ((ApplicationInfo) cls7.getMethod((String) objArr13[0], null).invoke(this, null)).targetSdkVersion - 117;
                                try {
                                    byte b12 = getAuthRequestContext[25];
                                    byte b13 = b12;
                                    Object[] objArr14 = new Object[1];
                                    d(b12, b13, b13, objArr14);
                                    Class<?> cls8 = Class.forName((String) objArr14[0]);
                                    Object[] objArr15 = new Object[1];
                                    d((byte) (-getAuthRequestContext[5]), (byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[27], objArr15);
                                    Object[] objArr16 = new Object[1];
                                    e(s, alpha, i, ((ApplicationInfo) cls8.getMethod((String) objArr15[0], null).invoke(this, null)).targetSdkVersion + 1435119759, (Process.myTid() >> 22) + 2078346917, objArr16);
                                    String str = (String) objArr16[0];
                                    try {
                                        byte b14 = getAuthRequestContext[25];
                                        byte b15 = b14;
                                        Object[] objArr17 = new Object[1];
                                        d(b14, b15, b15, objArr17);
                                        Class<?> cls9 = Class.forName((String) objArr17[0]);
                                        Object[] objArr18 = new Object[1];
                                        d((byte) (-getAuthRequestContext[5]), (byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[27], objArr18);
                                        short s2 = (short) (((ApplicationInfo) cls9.getMethod((String) objArr18[0], null).invoke(this, null)).targetSdkVersion + 4);
                                        byte codePointAt = (byte) (super.getResources().getString(R.string.category_loyalty).substring(9, 10).codePointAt(0) + 27);
                                        int length2 = super.getResources().getString(R.string.show_qr_notes).substring(74, 76).length() - 86;
                                        try {
                                            byte b16 = getAuthRequestContext[25];
                                            byte b17 = b16;
                                            Object[] objArr19 = new Object[1];
                                            d(b16, b17, b17, objArr19);
                                            Class<?> cls10 = Class.forName((String) objArr19[0]);
                                            Object[] objArr20 = new Object[1];
                                            d((byte) (-getAuthRequestContext[5]), (byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[27], objArr20);
                                            Object[] objArr21 = new Object[1];
                                            e(s2, codePointAt, length2, ((ApplicationInfo) cls10.getMethod((String) objArr20[0], null).invoke(this, null)).targetSdkVersion + 1435119807, 2078346959 - TextUtils.getCapsMode("", 0, 0), objArr21);
                                            String str2 = (String) objArr21[0];
                                            Object[] objArr22 = new Object[1];
                                            e((short) (super.getResources().getString(R.string.recentnumber).substring(6, 7).codePointAt(0) - 52), (byte) (ImageFormat.getBitsPerPixel(0) - 90), (-85) - Process.getGidForName(""), super.getResources().getString(R.string.setting_security_settings).substring(1, 2).codePointAt(0) + 1435119803, super.getResources().getString(R.string.feed_onboarding_desc_2).substring(54, 57).codePointAt(1) + 2078346796, objArr22);
                                            String str3 = (String) objArr22[0];
                                            Object[] objArr23 = new Object[1];
                                            e((short) (super.getResources().getString(R.string.qr_expired_error_action).substring(7, 8).codePointAt(0) - 143), (byte) (super.getResources().getString(R.string.input_phone_number_warning_text).substring(18, 19).length() - 71), TextUtils.indexOf((CharSequence) "", '0', 0, 0) - 83, super.getResources().getString(R.string.input_password).substring(51, 57).codePointAt(3) + 1435119890, 2078346966 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), objArr23);
                                            String str4 = (String) objArr23[0];
                                            Object[] objArr24 = new Object[1];
                                            e((short) (super.getResources().getString(R.string.request_money_add_bank_name_check_limit_error).substring(12, 13).length() + 71), (byte) (super.getResources().getString(R.string.feeds_delete_dialog).substring(0, 1).codePointAt(0) - 175), getPackageName().codePointAt(4) - 181, Color.rgb(0, 0, 0) + 1451897244, super.getResources().getString(R.string.passkey_faq_one_desc).substring(0, 8).codePointAt(1) + 2078346822, objArr24);
                                            try {
                                                Object[] objArr25 = {baseContext, str, str2, str3, str4, true, (String) objArr24[0], 995651014};
                                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                                if (obj2 == null) {
                                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getPressedStateDuration() >> 16), 18 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) View.resolveSize(0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                                }
                                                ((Method) obj2).invoke(invoke, objArr25);
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
            }
            try {
                Object[] objArr26 = new Object[1];
                d(getAuthRequestContext[1], (short) 37, (byte) (-getAuthRequestContext[30]), objArr26);
                Class<?> cls11 = Class.forName((String) objArr26[0]);
                Object[] objArr27 = new Object[1];
                d((byte) (BuiltInFictitiousFunctionClassFactory & 24), getAuthRequestContext[35], (byte) (-getAuthRequestContext[30]), objArr27);
                try {
                    Object[] objArr28 = {Integer.valueOf(((Integer) cls11.getMethod((String) objArr27[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls12 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - TextUtils.indexOf("", ""), 4 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) TextUtils.indexOf("", "", 0));
                        Object[] objArr29 = new Object[1];
                        f($$d[53], $$d[9], $$d[8], objArr29);
                        obj3 = cls12.getMethod((String) objArr29[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr30 = (Object[]) ((Method) obj3).invoke(null, objArr28);
                    int i2 = ((int[]) objArr30[1])[0];
                    if (((int[]) objArr30[0])[0] != i2) {
                        long j = ((r2 ^ i2) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 930, Color.alpha(0) + 35, (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr31 = {-1141467056, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 912, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 18, (char) ((-1) - TextUtils.lastIndexOf("", '0')))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr31);
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
                    super.onCreate(bundle);
                    setContentView(com.alipay.mobile.verifyidentity.business.security.R.layout.activity_set_security);
                    initView();
                    initData();
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
        } catch (Throwable th14) {
            Throwable cause14 = th14.getCause();
            if (cause14 == null) {
                throw th14;
            }
            throw cause14;
        }
    }

    private void initView() {
        this.container = (FrameLayout) findViewById(com.alipay.mobile.verifyidentity.business.security.R.id.container);
        this.tv_title = (TextView) findViewById(com.alipay.mobile.verifyidentity.business.security.R.id.tv_title);
        this.rl_title = findViewById(com.alipay.mobile.verifyidentity.business.security.R.id.rl_title);
        findViewById(com.alipay.mobile.verifyidentity.business.security.R.id.ll_back).setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.verifyidentity.business.security.activity.SetSecurityActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SetSecurityActivity.this.finish();
            }
        });
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.BaseActivity
    public void initData() {
        Message message = (Message) getIntent().getSerializableExtra("message");
        this.message = message;
        if (message != null) {
            this.nextStep = message.getNextStep();
            this.prodmngId = this.message.getProdmngId();
            this.nextAction = this.message.getNextAction();
            this.sceneId = this.message.getSceneId();
            this.userId = this.message.getUserId();
            this.tntInstId = this.message.getTntInstId();
            this.productType = this.message.getProductType();
            try {
                JSONObject jSONObject = new JSONObject(this.message.getData());
                JSONObject jSONObject2 = new JSONObject(jSONObject.optString(MessageConstants.KEY_PAGE_MODEL));
                JSONObject jSONObject3 = new JSONObject(jSONObject.optString(MessageConstants.KEY_ALL_QUESTIONS));
                JSONArray jSONArray = jSONObject3.getJSONArray(SecurityConstants.KEY_PAGES);
                this.pageSize = jSONObject3.getInt(SecurityConstants.KEY_PAGE_SIZE);
                this.pageTitle = jSONObject2.optString("pageTitle");
                this.button1Text = jSONObject2.optString(MessageConstants.KEY_BUTTON1TEXT);
                this.button1Action = jSONObject2.optString(MessageConstants.KEY_BUTTON1ACTION);
                this.from_title = jSONObject2.optString(SecurityConstants.KEY_FROM_TITLE_SQ);
                parceQuestionJson(jSONArray);
            } catch (Exception unused) {
            }
        }
        if (!TextUtils.isEmpty(this.pageTitle)) {
            this.tv_title.setText(this.pageTitle);
        }
        createViewByData();
        setFragment(0);
        registerHandlerCallback(new HandlerCallback() { // from class: com.alipay.mobile.verifyidentity.business.security.activity.SetSecurityActivity.2
            @Override // com.alipay.mobile.verifyidentity.business.activity.HandlerCallback
            public void handleMessage(android.os.Message message2) {
                if (message2.what != 2001 || SetSecurityActivity.this.isFinishing()) {
                    return;
                }
                SetSecurityActivity.this.finish();
            }
        });
    }

    private void createViewByData() {
        int i = 0;
        while (i < this.adapterList.size()) {
            SetSecurityFragment setSecurityFragment = new SetSecurityFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(SecurityConstants.KEY_SET_SECURITY_BUNDLE, this.adapterList.get(i));
            bundle.putInt(SecurityConstants.KEY_PAGE_SIZE, this.pageSize);
            i++;
            bundle.putInt("pageNum", i);
            if (!TextUtils.isEmpty(this.from_title)) {
                bundle.putString("form_title", this.from_title);
            }
            setSecurityFragment.setArguments(bundle);
            setSecurityFragment.setCommitCallBack(new SetSecurityFragment.CommitCallBack() { // from class: com.alipay.mobile.verifyidentity.business.security.activity.SetSecurityActivity.3
                @Override // com.alipay.mobile.verifyidentity.business.security.activity.SetSecurityFragment.CommitCallBack
                public void commit(String[] strArr, QuestionItem[] questionItemArr, int i2, int i3) {
                    if (i3 != i2) {
                        if (i3 < i2) {
                            SetSecurityActivity setSecurityActivity = SetSecurityActivity.this;
                            setSecurityActivity.answerId = (String[]) SetSecurityActivity.concat(setSecurityActivity.answerId, strArr);
                            SetSecurityActivity setSecurityActivity2 = SetSecurityActivity.this;
                            setSecurityActivity2.questionItemArr = (QuestionItem[]) SetSecurityActivity.concat(setSecurityActivity2.questionItemArr, questionItemArr);
                            SetSecurityActivity.this.setFragment(i3);
                            return;
                        }
                        return;
                    }
                    if (i3 == 1) {
                        SetSecurityActivity.this.answerId = strArr;
                        SetSecurityActivity.this.questionItemArr = questionItemArr;
                    } else {
                        SetSecurityActivity setSecurityActivity3 = SetSecurityActivity.this;
                        setSecurityActivity3.answerId = (String[]) SetSecurityActivity.concat(setSecurityActivity3.answerId, strArr);
                        SetSecurityActivity setSecurityActivity4 = SetSecurityActivity.this;
                        setSecurityActivity4.questionItemArr = (QuestionItem[]) SetSecurityActivity.concat(setSecurityActivity4.questionItemArr, questionItemArr);
                    }
                    SetSecurityActivity.this.confirm();
                }
            });
            this.mFragments.add(setSecurityFragment);
        }
    }

    public static <T> T[] concat(T[] tArr, T[] tArr2) {
        T[] tArr3 = (T[]) Arrays.copyOf(tArr, tArr.length + tArr2.length);
        System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFragment(int i) {
        if (this.mFragments.size() > 0) {
            getFragmentManager().beginTransaction().replace(com.alipay.mobile.verifyidentity.business.security.R.id.container, this.mFragments.get(i)).commitAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void confirm() {
        IAPAsyncTask.asyncTask(new IAPAsyncTask.Runner<MICRpcResponse>() { // from class: com.alipay.mobile.verifyidentity.business.security.activity.SetSecurityActivity.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alipay.iap.android.common.task.async.IAPAsyncTask.Runner
            public MICRpcResponse execute() throws Exception {
                SetSecurityActivity.this.showSubmittingDialog();
                MICRpcRequest mICRpcRequest = new MICRpcRequest();
                mICRpcRequest.action = SetSecurityActivity.this.nextAction;
                mICRpcRequest.module = SetSecurityActivity.this.nextStep;
                mICRpcRequest.envData = new JSONObject(VIEngineUtils.getEnvData(SetSecurityActivity.this)).toString();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("sceneId", SetSecurityActivity.this.sceneId);
                jSONObject.put("userId", SetSecurityActivity.this.userId);
                jSONObject.put(RequestConstants.SecVIKeyTntInstId, SetSecurityActivity.this.tntInstId);
                jSONObject.put("productType", SetSecurityActivity.this.productType);
                jSONObject.put(RequestConstants.KEY_USER_ANSWER, SetSecurityActivity.this.buildConfirmData().toString());
                mICRpcRequest.data = jSONObject.toString();
                mICRpcRequest.prodmngId = SetSecurityActivity.this.prodmngId;
                if (mICRpcRequest.action.equals(RequestConstants.REGISTER_BIO_SUBMIT)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("module", mICRpcRequest.module);
                    hashMap.put("data", mICRpcRequest.data);
                    ClientLogKitManager.getClientLogKit().log("event", new String[]{"a5.b2.c2", "0", ""}, hashMap, "", "SecVI_Seed_SecQuestion_OpenRequest", "", "", false);
                } else if (mICRpcRequest.action.equals(RequestConstants.UPDATE_SUBMIT)) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("module", mICRpcRequest.module);
                    hashMap2.put("data", mICRpcRequest.data);
                    ClientLogKitManager.getClientLogKit().log("event", new String[]{"a5.b4.c2", "0", ""}, hashMap2, "", "SecVI_Seed_SecQuestion_OpenRequest", "", "", false);
                }
                try {
                    return RpcSettings.retrieveRpcService().dispatch(mICRpcRequest);
                } catch (Throwable unused) {
                    return null;
                }
            }

            @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
            public void onSuccess(MICRpcResponse mICRpcResponse) {
                SetSecurityActivity.this.hideSubmittingDialog();
                if (mICRpcResponse != null) {
                    if (!SetSecurityActivity.this.nextAction.equals(RequestConstants.REGISTER_BIO_SUBMIT)) {
                        if (SetSecurityActivity.this.nextAction.equals(RequestConstants.UPDATE_SUBMIT)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("finishedCode", mICRpcResponse.finishCode);
                            hashMap.put("finishedMsg", mICRpcResponse.finishMessage);
                            hashMap.put("verifyMsg", mICRpcResponse.verifyMessage);
                            ClientLogKitManager.getClientLogKit().log("event", new String[]{"a5.b4.c3", "0", ""}, hashMap, "", "SecVI_Seed_SecQuestion_ResetResult", "", "", false);
                        }
                    } else {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("finishedCode", mICRpcResponse.finishCode);
                        hashMap2.put("finishedMsg", mICRpcResponse.finishMessage);
                        hashMap2.put("verifyMsg", mICRpcResponse.verifyMessage);
                        ClientLogKitManager.getClientLogKit().log("event", new String[]{"a5.b2.c3", "0", ""}, hashMap2, "", "SecVI_Seed_SecQuestion_OpenResult", "", "", false);
                    }
                    if (mICRpcResponse.sysErrCode.equals(SecurityConstants.KEY_OUT_TIME_CODE1) || mICRpcResponse.sysErrCode.equals("204")) {
                        SetSecurityActivity.this.getWeakHandler().sendEmptyMessageDelayed(2001, 2000L);
                        CustomUi.showCenterToast(SetSecurityActivity.this, mICRpcResponse.sysErrMsg);
                        Intent intent = new Intent();
                        intent.setAction(SecurityConstants.KEY_SET_SECURITY_SUCCESSFUL);
                        SetSecurityActivity.this.sendBroadcast(intent);
                        return;
                    } else if (mICRpcResponse.finish) {
                        if (!mICRpcResponse.success) {
                            CustomUi.showCenterToast(SetSecurityActivity.this, mICRpcResponse.sysErrMsg);
                        } else {
                            SetSecurityActivity setSecurityActivity = SetSecurityActivity.this;
                            CustomUi.showTipToast(setSecurityActivity, 0, setSecurityActivity.getResources().getString(com.alipay.mobile.verifyidentity.business.security.R.string.set_success));
                        }
                        SetSecurityActivity.this.getWeakHandler().sendEmptyMessageDelayed(2001, 0L);
                        Intent intent2 = new Intent();
                        intent2.setAction(SecurityConstants.KEY_SET_SECURITY_SUCCESSFUL);
                        SetSecurityActivity.this.sendBroadcast(intent2);
                        return;
                    } else {
                        SetSecurityActivity setSecurityActivity2 = SetSecurityActivity.this;
                        CustomUi.showCenterToast(setSecurityActivity2, setSecurityActivity2.getResources().getString(com.alipay.mobile.verifyidentity.business.security.R.string.Sysytem_error));
                        return;
                    }
                }
                ClientLogKitManager.getClientLogKit().log("event", new String[]{"a5.b2.c3", "1", ""}, null, "", "SecVI_Seed_SecQuestion_OpenResult", "", "", false);
                SetSecurityActivity setSecurityActivity3 = SetSecurityActivity.this;
                CustomUi.showCenterToast(setSecurityActivity3, setSecurityActivity3.getResources().getString(com.alipay.mobile.verifyidentity.business.security.R.string.system_busy_error));
            }

            @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
            public void onFailure(IAPError iAPError) {
                SetSecurityActivity.this.hideSubmittingDialog();
                SetSecurityActivity setSecurityActivity = SetSecurityActivity.this;
                CustomUi.showCenterToast(setSecurityActivity, setSecurityActivity.getResources().getString(com.alipay.mobile.verifyidentity.business.security.R.string.Sysytem_error));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray buildConfirmData() {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < this.questionItemArr.length; i++) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("1", this.questionItemArr[i].getQuestionId());
                jSONObject.put("11", this.questionItemArr[i].getDisplayType());
                jSONObject.put(PrepareException.ERROR_OFFLINE_APP, buildAnswerJsonArr(this.questionItemArr[i], i));
            } catch (Exception unused) {
            }
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    private JSONArray buildAnswerJsonArr(QuestionItem questionItem, int i) throws Exception {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("1", questionItem.getQuestionId());
        jSONObject.put("3", new JSONArray().put(this.answerId[i]));
        jSONObject.put("4", buildFixAnswer(this.answerId[i], questionItem));
        jSONObject.put("5", 0);
        jSONObject.put("6", 1);
        jSONObject.put("7", questionItem.getMemoryId());
        jSONObject.put("8", questionItem.getQuestionType());
        jSONObject.put(PrepareException.ERROR_OFFLINE_APP, questionItem.getDisplayType());
        jSONObject.put("10", questionItem.getAnswerDisplayType());
        jSONArray.put(jSONObject);
        return jSONArray;
    }

    private JSONArray buildFixAnswer(String str, QuestionItem questionItem) {
        if (questionItem.getQuestionsOptionsList() == null) {
            return new JSONArray();
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < questionItem.getQuestionsOptionsList().size(); i++) {
            QuestionItem.QuestionsOptions questionsOptions = questionItem.getQuestionsOptionsList().get(i);
            if (!questionsOptions.getValue().equals(str)) {
                jSONArray.put(questionsOptions.getValue());
            }
        }
        return jSONArray;
    }

    private void parceQuestionJson(JSONArray jSONArray) throws JSONException {
        this.adapterList.clear();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = (JSONObject) jSONArray.get(i);
            jSONObject.getString("pageNum");
            JSONArray jSONArray2 = jSONObject.getJSONArray(SecurityConstants.KEY_QUESTION_PAGE_LIUST);
            ArrayList<List<QuestionItem>> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONArray jSONArray3 = (JSONArray) jSONArray2.get(i2);
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray3.get(i3);
                    QuestionItem questionItem = new QuestionItem();
                    String string = jSONObject2.getString(SecurityConstants.KEY_ANSWER_DISPLAY_TYPE);
                    String string2 = jSONObject2.getString("content");
                    String string3 = jSONObject2.getString(SecurityConstants.KEY_MEMORYID);
                    String string4 = jSONObject2.getString("questionId");
                    String string5 = jSONObject2.getString(SecurityConstants.KEY_QUESTION_TYPE);
                    String string6 = jSONObject2.getString(SecurityConstants.KEY_DISPLAY_TYPE);
                    questionItem.setQuestionType(string5);
                    questionItem.setAnswerDisplayType(string);
                    questionItem.setMemoryId(string3);
                    questionItem.setQuestionId(string4);
                    questionItem.setContent(string2);
                    questionItem.setDisplayType(string6);
                    if (jSONObject2.has(SecurityConstants.KEY_OPTIONS)) {
                        JSONArray jSONArray4 = jSONObject2.getJSONArray(SecurityConstants.KEY_OPTIONS);
                        ArrayList<QuestionItem.QuestionsOptions> arrayList3 = new ArrayList<>();
                        for (int i4 = 0; i4 < jSONArray4.length(); i4++) {
                            JSONObject jSONObject3 = (JSONObject) jSONArray4.get(i4);
                            arrayList3.add(new QuestionItem.QuestionsOptions(jSONObject3.getString(SecurityConstants.KEY_TEXT), jSONObject3.getString(SecurityConstants.KEY_VALUE)));
                        }
                        questionItem.setQuestionsOptionsList(arrayList3);
                    }
                    arrayList2.add(questionItem);
                }
                arrayList.add(arrayList2);
            }
            this.adapterList.add(arrayList);
        }
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.BaseActivity
    public void modifyViewFromOutside() {
        ActivityInterface commonActivityInterface = ActivityInterfaceManager.getCommonActivityInterface();
        if (TextUtils.isEmpty(commonActivityInterface.navBigColor())) {
            return;
        }
        int parseColor = ColorUtils.parseColor(commonActivityInterface.navBigColor());
        if (ColorUtils.isColorInvalid(parseColor)) {
            return;
        }
        this.rl_title.setBackgroundColor(parseColor);
    }

    private static void e(short s, byte b, int i, int i2, int i3, Object[] objArr) {
        B b2 = new B();
        StringBuilder sb = new StringBuilder();
        int i4 = i + ((int) (scheduleImpl ^ 3097486228508854431L));
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
                i4 = (byte) (((byte) (getErrorConfigVersion[i2 + ((int) (PlaceComponentResult ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (scheduleImpl ^ 3097486228508854431L)));
            } else {
                i4 = (short) (((short) (NetworkUserEntityData$$ExternalSyntheticLambda0[i2 + ((int) (PlaceComponentResult ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (scheduleImpl ^ 3097486228508854431L)));
            }
        }
        if (i4 > 0) {
            b2.getAuthRequestContext = ((i2 + i4) - 2) + ((int) (PlaceComponentResult ^ 3097486228508854431L)) + i5;
            b2.MyBillsEntityDataFactory = (char) (i3 + ((int) (lookAheadTest ^ 3097486228508854431L)));
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
                    short[] sArr = NetworkUserEntityData$$ExternalSyntheticLambda0;
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
