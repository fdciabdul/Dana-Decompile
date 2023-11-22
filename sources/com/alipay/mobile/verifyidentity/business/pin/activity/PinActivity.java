package com.alipay.mobile.verifyidentity.business.pin.activity;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.androidinter.app.safepaybase.EncryptRandomType;
import com.alipay.androidinter.app.safepaybase.OnConfirmListener;
import com.alipay.androidinter.app.safepaybase.SafeInputContext;
import com.alipay.androidinter.app.safepaybase.alikeyboard.AliKeyboardType;
import com.alipay.androidinter.app.safepaybase.alikeyboard.AlipayKeyboard;
import com.alipay.iap.android.common.errorcode.IAPError;
import com.alipay.iap.android.common.task.async.IAPAsyncTask;
import com.alipay.mobile.verifyidentity.RpcSettings;
import com.alipay.mobile.verifyidentity.base.OnClickUrl;
import com.alipay.mobile.verifyidentity.base.message.Message;
import com.alipay.mobile.verifyidentity.base.message.RequestConstants;
import com.alipay.mobile.verifyidentity.base.message.VIRespone;
import com.alipay.mobile.verifyidentity.base.product.IProduct;
import com.alipay.mobile.verifyidentity.business.activity.ActivityInterface;
import com.alipay.mobile.verifyidentity.business.activity.ActivityInterfaceManager;
import com.alipay.mobile.verifyidentity.business.activity.ClientLogKitManager;
import com.alipay.mobile.verifyidentity.business.activity.HandlerCallback;
import com.alipay.mobile.verifyidentity.business.activity.ProductActivity;
import com.alipay.mobile.verifyidentity.business.pin.product.PinModule;
import com.alipay.mobile.verifyidentity.framework.engine.VIAction;
import com.alipay.mobile.verifyidentity.framework.engine.VIEngine;
import com.alipay.mobile.verifyidentity.framework.engine.VIResult;
import com.alipay.mobile.verifyidentity.uitools.ColorUtils;
import com.alipay.mobile.verifyidentity.uitools.CustomUi;
import com.alipay.mobile.verifyidentity.uitools.dialog.ModalInterface;
import com.alipay.mobileiclib.common.service.facade.solution.dto.MICRpcRequest;
import com.alipay.mobileiclib.common.service.facade.solution.dto.MICRpcResponse;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.text.Typography;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getCallingPid;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class PinActivity extends ProductActivity {
    private static final String INPUT_TYPE_NUMERIC = "numeric";
    private static final int TRANSLATE_ANIMATION = 2000;
    private static IProduct.ICallback iCallback;
    private static PinModule pinProduct;
    boolean HAS_OTHERS;
    String account_encrypt_pubkey;
    String account_encrypt_salt;
    private AlipayKeyboard alipayKeyboard;
    private float density;
    private float destMargin;
    private FrameLayout flBack;
    private FrameLayout flKeyboard;
    String footTips;
    String form_button;
    String form_input_tip_low;
    String form_input_tip_url;
    String form_title;
    boolean half_screen;
    String head_title;
    private ImageButton ibBack;
    private ImageButton ibHalfBack;
    private float initialMargin;
    String inputType;
    private LinearLayout llContent;
    Message message;
    String nextStep;
    String predata;
    private FrameLayout pwdInput;
    private View rl_title;
    private SafeInputContext safeInputContext;
    private float stepMargin;
    private TextView tvFindpass;
    private TextView tvFindpassCenter;
    private TextView tvTip;
    private TextView tvVerification;
    String verifyId;
    String verifyMessage;
    public static final byte[] $$g = {62, -79, -77, -78, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$h = 63;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {79, Ascii.DC4, Ascii.EM, -22, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int getErrorConfigVersion = 125;
    private static char scheduleImpl = 42066;
    private static char[] moveToNextValue = {37371, 37375, 37290, 37311, 37302, 37358, 37305, 37372, 37369, 37356, 37306, 37286, 37345, 37344, 37282, 37353, 37357, 37289, 37366, 37310, 37288, 37346, 37283, 37350, 37275, 37292, 37367, 37374, 37262, 37279, 37347, 37373, 37359, 37294, 37280, 37291, 37274, 37370, 37293, 37307, 37365, 37281, 37368, 37348, 37308, 37309, 37351, 37287, 37349};
    private int retryCount = 0;
    int inputCharCount = 6;
    private AliKeyboardType aliKeyboardType = AliKeyboardType.num;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void g(byte r8, short r9, byte r10, java.lang.Object[] r11) {
        /*
            int r8 = 106 - r8
            byte[] r0 = com.alipay.mobile.verifyidentity.business.pin.activity.PinActivity.BuiltInFictitiousFunctionClassFactory
            int r9 = r9 + 4
            int r10 = r10 + 16
            byte[] r1 = new byte[r10]
            r2 = 0
            if (r0 != 0) goto L14
            r8 = r9
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r11
            r11 = r10
            goto L31
        L14:
            r3 = 0
        L15:
            byte r4 = (byte) r8
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r10) goto L24
            java.lang.String r8 = new java.lang.String
            r8.<init>(r1, r2)
            r11[r2] = r8
            return
        L24:
            int r9 = r9 + 1
            r3 = r0[r9]
            r6 = r9
            r9 = r8
            r8 = r6
            r7 = r11
            r11 = r10
            r10 = r3
            r3 = r1
            r1 = r0
            r0 = r7
        L31:
            int r10 = -r10
            int r9 = r9 + r10
            int r9 = r9 + (-4)
            r10 = r11
            r11 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            r6 = r9
            r9 = r8
            r8 = r6
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.verifyidentity.business.pin.activity.PinActivity.g(byte, short, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void i(int r7, int r8, int r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 * 3
            int r9 = 42 - r9
            byte[] r0 = com.alipay.mobile.verifyidentity.business.pin.activity.PinActivity.$$g
            int r7 = 47 - r7
            int r8 = r8 * 2
            int r8 = 103 - r8
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            goto L33
        L19:
            r3 = 0
        L1a:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r9) goto L29
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L29:
            r3 = r0[r7]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L33:
            int r7 = -r7
            int r9 = r9 + r7
            int r7 = r8 + 1
            int r8 = r9 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.verifyidentity.business.pin.activity.PinActivity.i(int, int, int, java.lang.Object[]):void");
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.ProductActivity, com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        h(new char[]{Typography.quote, '(', Typography.amp, '*', InputCardNumberView.DIVIDER, '\r', '(', 7, 30, '0', '\b', '!', '0', 31, 23, 4, 13915, 13915}, 18 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (byte) (114 - (ViewConfiguration.getPressedStateDuration() >> 16)), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        h(new char[]{18, 0, '\'', '\b', 13901}, 5 - TextUtils.getOffsetAfter("", 0), (byte) (ExpandableListView.getPackedPositionType(0L) + 79), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.resolveSize(0, 0), KeyEvent.normalizeMetaState(0) + 35, (char) (Process.myPid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    h(new char[]{'.', 21, '\f', 22, 0, Typography.dollar, 19, 25, ',', 0, 24, 18, 3, 30, 22, '\r', 13819, 13819, '\f', 29, '\'', 21, 22, 11, '*', 14, 21, '(', 28, Typography.amp, 30, 5, 15, 11, InputCardNumberView.DIVIDER, 17, 18, 19, 22, 5, '-', 14, 1, 7, '#', '\n', '\t', 1}, Color.blue(0) + 48, (byte) (81 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    h(new char[]{30, '(', 7, Typography.dollar, 18, 19, 5, 22, '\'', 21, 16, '\'', ')', 21, 21, 6, 13846, 13846, 20, 24, ')', 21, '\t', '\b', '\n', Typography.dollar, 16, 4, 21, '(', 13846, 13846, 21, '\'', 5, 21, 13927, 13927, 0, '\b', Typography.dollar, 2, 6, 23, 21, '.', 21, '0', 13847, 13847, '.', 14, 14, '.', 6, 22, 6, 22, 24, '\'', 21, 27, '*', 14}, TextUtils.lastIndexOf("", '0') + 65, (byte) (111 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    h(new char[]{Typography.quote, 24, 3, '%', 14, '.', 28, 3, 13781, 13781, 27, 21, 21, '\r', 0, '+', 30, 5, 7, '*', Typography.amp, '-', 28, '\f', '-', 14, 19, 25, 13871, 13871, '.', 21, 0, '*', '!', 24, '#', '-', '\f', 22, 24, 19, 21, 6, 22, 5, 31, '(', 18, 19, 23, 4, Typography.quote, 24, 16, Typography.amp, ',', '#', 15, 11, 16, Typography.amp, '\'', 16}, 64 - (ViewConfiguration.getScrollBarSize() >> 8), (byte) (ExpandableListView.getPackedPositionChild(0L) + 52), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    h(new char[]{'.', '(', Typography.amp, 4, '/', '%', 13833, 13833, '(', 28, '(', Typography.quote, 11, '(', '0', '.', 5, 30, '.', InputCardNumberView.DIVIDER, 30, '/', '(', 11, 17, '\r', 31, '/', '%', '*', 17, '\f', 31, '/', 5, '\t', 27, InputCardNumberView.DIVIDER, 20, 7, 31, 5, '\f', 7, '\r', '\'', 16, 6, '.', '%', 20, '\r', Typography.quote, '\n', 3, 0, 6, '%', '%', '.'}, 60 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (byte) (84 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1))), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    h(new char[]{19, 11, 5, 7, Typography.quote, 24}, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 6, (byte) (KeyEvent.getDeadChar(0, 0) + 46), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 910, TextUtils.lastIndexOf("", '0') + 19, (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = BuiltInFictitiousFunctionClassFactory[25];
                Object[] objArr13 = new Object[1];
                g(b, (byte) (b | 36), BuiltInFictitiousFunctionClassFactory[25], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b2 = BuiltInFictitiousFunctionClassFactory[9];
                Object[] objArr14 = new Object[1];
                g(b2, (byte) (b2 | Ascii.DC4), BuiltInFictitiousFunctionClassFactory[25], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getWindowTouchSlop() >> 8) + 55, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 2, (char) View.MeasureSpec.getSize(0));
                        Object[] objArr16 = new Object[1];
                        i((byte) (-$$g[53]), (byte) (-$$g[12]), $$g[68], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - ExpandableListView.getPackedPositionType(0L), 15 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (TextUtils.indexOf((CharSequence) "", '0') + 1))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, 16 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 816, 29 - (KeyEvent.getMaxKeyCode() >> 16), (char) (57994 - Color.blue(0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getScrollBarSize() >> 8), TextUtils.lastIndexOf("", '0', 0, 0) + 16, (char) TextUtils.indexOf("", "", 0)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), 35 - Color.blue(0), (char) (Process.myPid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {249755261, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.red(0), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 18, (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b3 = BuiltInFictitiousFunctionClassFactory[25];
                Object[] objArr19 = new Object[1];
                g(b3, (byte) (b3 | 36), BuiltInFictitiousFunctionClassFactory[25], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b4 = BuiltInFictitiousFunctionClassFactory[9];
                Object[] objArr20 = new Object[1];
                g(b4, (byte) (b4 | Ascii.DC4), BuiltInFictitiousFunctionClassFactory[25], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + 61, 46 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) ((-1) - Process.getGidForName("")));
                        Object[] objArr22 = new Object[1];
                        i($$g[20], (byte) ($$g[47] - 1), (byte) (-$$g[8]), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - KeyEvent.keyCodeFromString(""), 35 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {249755261, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), 18 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) ((-1) - TextUtils.lastIndexOf("", '0')))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b5 = BuiltInFictitiousFunctionClassFactory[25];
                Object[] objArr25 = new Object[1];
                g(b5, (byte) (b5 | 36), BuiltInFictitiousFunctionClassFactory[25], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b6 = BuiltInFictitiousFunctionClassFactory[9];
                Object[] objArr26 = new Object[1];
                g(b6, (byte) (b6 | Ascii.DC4), BuiltInFictitiousFunctionClassFactory[25], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.argb(0, 0, 0, 0) + 118, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 3, (char) ((ViewConfiguration.getEdgeSlop() >> 16) + 38968));
                        Object[] objArr28 = new Object[1];
                        i($$g[20], (byte) ($$g[47] - 1), (byte) (-$$g[8]), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), TextUtils.indexOf("", "", 0) + 35, (char) Color.green(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {249755261, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 910, Color.red(0) + 18, (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b7 = BuiltInFictitiousFunctionClassFactory[25];
                Object[] objArr31 = new Object[1];
                g(b7, (byte) (b7 | 36), BuiltInFictitiousFunctionClassFactory[25], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b8 = BuiltInFictitiousFunctionClassFactory[9];
                Object[] objArr32 = new Object[1];
                g(b8, (byte) (b8 | Ascii.DC4), BuiltInFictitiousFunctionClassFactory[25], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 3, (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))));
                        Object[] objArr34 = new Object[1];
                        i((byte) ($$g[47] - 1), (byte) (-$$g[9]), (byte) ($$g[47] - 1), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - ExpandableListView.getPackedPositionChild(0L), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {249755261, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + 911, (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 18, (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // com.alipay.mobile.verifyidentity.business.activity.ProductActivity, com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.ProductActivity, com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.ProductActivity, com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.ProductActivity, com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            h(new char[]{Typography.quote, '(', Typography.amp, '*', InputCardNumberView.DIVIDER, '\r', '(', 7, 31, 5, 5, '\n', InputCardNumberView.DIVIDER, 21, '.', 18, 4, '\r', '.', 11, JSONLexer.EOI, '-', ',', 3, 28, '('}, super.getResources().getString(R.string.res_0x7f13015b_networkuserentitydata_externalsyntheticlambda0).substring(5, 6).length() + 25, (byte) (super.getResources().getString(R.string.kyb_status).substring(7, 8).length() + 15), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            char[] cArr = {24, 11, 13829, 13829, 6, '%', '#', InputCardNumberView.DIVIDER, 13831, 13831, 25, '\b', JSONLexer.EOI, InputCardNumberView.DIVIDER, '.', 18, ')', '0'};
            try {
                Object[] objArr2 = new Object[1];
                g((byte) (-BuiltInFictitiousFunctionClassFactory[32]), BuiltInFictitiousFunctionClassFactory[7], BuiltInFictitiousFunctionClassFactory[30], objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                g(BuiltInFictitiousFunctionClassFactory[48], (byte) (-BuiltInFictitiousFunctionClassFactory[59]), BuiltInFictitiousFunctionClassFactory[8], new Object[1]);
                Object[] objArr3 = new Object[1];
                h(cArr, ((ApplicationInfo) cls2.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 15, (byte) (super.getResources().getString(R.string.mtrl_picker_date_header_selected).substring(0, 4).length() + 25), objArr3);
                baseContext = (Context) cls.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getWindowTouchSlop() >> 8), 35 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 18 - (Process.myTid() >> 22), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr4);
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
        super.onResume();
    }

    static /* synthetic */ int access$808(PinActivity pinActivity) {
        int i = pinActivity.retryCount;
        pinActivity.retryCount = i + 1;
        return i;
    }

    public static IProduct.ICallback getCallback() {
        return iCallback;
    }

    public static void setCallback(IProduct.ICallback iCallback2) {
        iCallback = iCallback2;
    }

    public static void setPinProduct(PinModule pinModule) {
        pinProduct = pinModule;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doCancel() {
        Message message = this.message;
        String verifyId = message != null ? message.getVerifyId() : "";
        VIRespone vIRespone = new VIRespone(1003);
        vIRespone.setVerifyId(verifyId);
        vIRespone.setMessage(this.message);
        if (getCallback() != null) {
            getCallback().onResult(pinProduct, vIRespone);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("retryNum", String.valueOf(this.retryCount));
        ClientLogKitManager.getClientLogKit().log("event", new String[]{"a2.b3.c1", "0", ""}, hashMap, "", "SecVI_Seed_Pwd_Cancel", "", verifyId, false);
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.ProductActivity, com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        char[] cArr = {Typography.quote, '(', Typography.amp, '*', InputCardNumberView.DIVIDER, '\r', '(', 7, 30, '0', '\b', '!', '0', 31, 23, 4, 13915, 13915};
        int length = super.getResources().getString(R.string.family_account_text_organizer_summary_btn_retry).substring(6, 7).length() + 17;
        try {
            Object[] objArr = new Object[1];
            g((byte) (-BuiltInFictitiousFunctionClassFactory[32]), BuiltInFictitiousFunctionClassFactory[7], BuiltInFictitiousFunctionClassFactory[30], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            g(BuiltInFictitiousFunctionClassFactory[48], (byte) (-BuiltInFictitiousFunctionClassFactory[59]), BuiltInFictitiousFunctionClassFactory[8], objArr2);
            Object[] objArr3 = new Object[1];
            h(cArr, length, (byte) (((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion + 81), objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            char[] cArr2 = {18, 0, '\'', '\b', 13901};
            try {
                Object[] objArr4 = new Object[1];
                g((byte) (-BuiltInFictitiousFunctionClassFactory[32]), BuiltInFictitiousFunctionClassFactory[7], BuiltInFictitiousFunctionClassFactory[30], objArr4);
                Class<?> cls3 = Class.forName((String) objArr4[0]);
                g(BuiltInFictitiousFunctionClassFactory[48], (byte) (-BuiltInFictitiousFunctionClassFactory[59]), BuiltInFictitiousFunctionClassFactory[8], new Object[1]);
                Object[] objArr5 = new Object[1];
                h(cArr2, ((ApplicationInfo) cls3.getMethod((String) r4[0], null).invoke(this, null)).targetSdkVersion - 28, (byte) (View.getDefaultSize(0, 0) + 79), objArr5);
                int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                if (intValue < 99000 || intValue > 99999) {
                    Context baseContext = getBaseContext();
                    if (baseContext == null) {
                        Object[] objArr6 = new Object[1];
                        h(new char[]{Typography.quote, '(', Typography.amp, '*', InputCardNumberView.DIVIDER, '\r', '(', 7, 31, 5, 5, '\n', InputCardNumberView.DIVIDER, 21, '.', 18, 4, '\r', '.', 11, JSONLexer.EOI, '-', ',', 3, 28, '('}, super.getResources().getString(R.string.verify_your_device).substring(0, 5).length() + 21, (byte) (16 - View.getDefaultSize(0, 0)), objArr6);
                        Class<?> cls4 = Class.forName((String) objArr6[0]);
                        char[] cArr3 = {24, 11, 13829, 13829, 6, '%', '#', InputCardNumberView.DIVIDER, 13831, 13831, 25, '\b', JSONLexer.EOI, InputCardNumberView.DIVIDER, '.', 18, ')', '0'};
                        int argb = 18 - Color.argb(0, 0, 0, 0);
                        try {
                            Object[] objArr7 = new Object[1];
                            g((byte) (-BuiltInFictitiousFunctionClassFactory[32]), BuiltInFictitiousFunctionClassFactory[7], BuiltInFictitiousFunctionClassFactory[30], objArr7);
                            Class<?> cls5 = Class.forName((String) objArr7[0]);
                            g(BuiltInFictitiousFunctionClassFactory[48], (byte) (-BuiltInFictitiousFunctionClassFactory[59]), BuiltInFictitiousFunctionClassFactory[8], new Object[1]);
                            Object[] objArr8 = new Object[1];
                            h(cArr3, argb, (byte) (((ApplicationInfo) cls5.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 4), objArr8);
                            baseContext = (Context) cls4.getMethod((String) objArr8[0], new Class[0]).invoke(null, null);
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
                                obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778145, ExpandableListView.getPackedPositionGroup(0L) + 35, (char) View.resolveSizeAndState(0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                            }
                            Object invoke = ((Method) obj).invoke(null, null);
                            Object[] objArr9 = new Object[1];
                            h(new char[]{'.', 21, '\f', 22, 0, Typography.dollar, 19, 25, ',', 0, 24, 18, 3, 30, 22, '\r', 13819, 13819, '\f', 29, '\'', 21, 22, 11, '*', 14, 21, '(', 28, Typography.amp, 30, 5, 15, 11, InputCardNumberView.DIVIDER, 17, 18, 19, 22, 5, '-', 14, 1, 7, '#', '\n', '\t', 1}, 48 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (byte) (super.getResources().getString(R.string.dana_protection_security_suggestion_title).substring(1, 2).length() + 79), objArr9);
                            String str = (String) objArr9[0];
                            char[] cArr4 = {30, '(', 7, Typography.dollar, 18, 19, 5, 22, '\'', 21, 16, '\'', ')', 21, 21, 6, 13846, 13846, 20, 24, ')', 21, '\t', '\b', '\n', Typography.dollar, 16, 4, 21, '(', 13846, 13846, 21, '\'', 5, 21, 13927, 13927, 0, '\b', Typography.dollar, 2, 6, 23, 21, '.', 21, '0', 13847, 13847, '.', 14, 14, '.', 6, 22, 6, 22, 24, '\'', 21, 27, '*', 14};
                            int codePointAt = super.getResources().getString(R.string.dana_will_not_save_your_bank_photo).substring(0, 15).codePointAt(10) - 37;
                            try {
                                Object[] objArr10 = new Object[1];
                                g((byte) (-BuiltInFictitiousFunctionClassFactory[32]), BuiltInFictitiousFunctionClassFactory[7], BuiltInFictitiousFunctionClassFactory[30], objArr10);
                                Class<?> cls6 = Class.forName((String) objArr10[0]);
                                Object[] objArr11 = new Object[1];
                                g(BuiltInFictitiousFunctionClassFactory[48], (byte) (-BuiltInFictitiousFunctionClassFactory[59]), BuiltInFictitiousFunctionClassFactory[8], objArr11);
                                Object[] objArr12 = new Object[1];
                                h(cArr4, codePointAt, (byte) (((ApplicationInfo) cls6.getMethod((String) objArr11[0], null).invoke(this, null)).targetSdkVersion + 77), objArr12);
                                String str2 = (String) objArr12[0];
                                Object[] objArr13 = new Object[1];
                                h(new char[]{Typography.quote, 24, 3, '%', 14, '.', 28, 3, 13781, 13781, 27, 21, 21, '\r', 0, '+', 30, 5, 7, '*', Typography.amp, '-', 28, '\f', '-', 14, 19, 25, 13871, 13871, '.', 21, 0, '*', '!', 24, '#', '-', '\f', 22, 24, 19, 21, 6, 22, 5, 31, '(', 18, 19, 23, 4, Typography.quote, 24, 16, Typography.amp, ',', '#', 15, 11, 16, Typography.amp, '\'', 16}, super.getResources().getString(R.string.my_bills_edit_bills_save_changes_dialog_confirmation_left_btn).substring(1, 2).codePointAt(0) - 33, (byte) (51 - ExpandableListView.getPackedPositionType(0L)), objArr13);
                                String str3 = (String) objArr13[0];
                                Object[] objArr14 = new Object[1];
                                h(new char[]{'.', '(', Typography.amp, 4, '/', '%', 13833, 13833, '(', 28, '(', Typography.quote, 11, '(', '0', '.', 5, 30, '.', InputCardNumberView.DIVIDER, 30, '/', '(', 11, 17, '\r', 31, '/', '%', '*', 17, '\f', 31, '/', 5, '\t', 27, InputCardNumberView.DIVIDER, 20, 7, 31, 5, '\f', 7, '\r', '\'', 16, 6, '.', '%', 20, '\r', Typography.quote, '\n', 3, 0, 6, '%', '%', '.'}, 60 - View.getDefaultSize(0, 0), (byte) (super.getResources().getString(R.string.charged_transaction_fee_info).substring(9, 10).codePointAt(0) + 52), objArr14);
                                String str4 = (String) objArr14[0];
                                char[] cArr5 = {19, 11, 5, 7, Typography.quote, 24};
                                try {
                                    Object[] objArr15 = new Object[1];
                                    g((byte) (-BuiltInFictitiousFunctionClassFactory[32]), BuiltInFictitiousFunctionClassFactory[7], BuiltInFictitiousFunctionClassFactory[30], objArr15);
                                    Class<?> cls7 = Class.forName((String) objArr15[0]);
                                    g(BuiltInFictitiousFunctionClassFactory[48], (byte) (-BuiltInFictitiousFunctionClassFactory[59]), BuiltInFictitiousFunctionClassFactory[8], new Object[1]);
                                    Object[] objArr16 = new Object[1];
                                    h(cArr5, ((ApplicationInfo) cls7.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 27, (byte) (Color.blue(0) + 46), objArr16);
                                    try {
                                        Object[] objArr17 = {baseContext, str, str2, str3, str4, true, (String) objArr16[0], 995651014};
                                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                        if (obj2 == null) {
                                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776305) - Color.rgb(0, 0, 0), Gravity.getAbsoluteGravity(0, 0) + 18, (char) View.resolveSize(0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                        }
                                        ((Method) obj2).invoke(invoke, objArr17);
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
                        } catch (Throwable th5) {
                            Throwable cause5 = th5.getCause();
                            if (cause5 == null) {
                                throw th5;
                            }
                            throw cause5;
                        }
                    }
                }
                try {
                    byte b = BuiltInFictitiousFunctionClassFactory[25];
                    Object[] objArr18 = new Object[1];
                    g(b, (byte) (b | 36), BuiltInFictitiousFunctionClassFactory[25], objArr18);
                    Class<?> cls8 = Class.forName((String) objArr18[0]);
                    byte b2 = BuiltInFictitiousFunctionClassFactory[9];
                    Object[] objArr19 = new Object[1];
                    g(b2, (byte) (b2 | Ascii.DC4), BuiltInFictitiousFunctionClassFactory[25], objArr19);
                    try {
                        Object[] objArr20 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr19[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                        if (obj3 == null) {
                            Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + 494, 4 - TextUtils.getCapsMode("", 0, 0), (char) (Process.getGidForName("") + 1));
                            Object[] objArr21 = new Object[1];
                            i((byte) ($$g[47] - 1), (byte) (-$$g[9]), (byte) ($$g[47] - 1), objArr21);
                            obj3 = cls9.getMethod((String) objArr21[0], Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                        }
                        Object[] objArr22 = (Object[]) ((Method) obj3).invoke(null, objArr20);
                        int i = ((int[]) objArr22[1])[0];
                        if (((int[]) objArr22[0])[0] != i) {
                            long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                            try {
                                Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj4 == null) {
                                    obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                }
                                Object invoke2 = ((Method) obj4).invoke(null, null);
                                try {
                                    Object[] objArr23 = {1554117130, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj5 == null) {
                                        obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (Process.myPid() >> 22), 18 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) TextUtils.getOffsetBefore("", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                    }
                                    ((Method) obj5).invoke(invoke2, objArr23);
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
                        }
                        requestWindowFeature(1);
                        super.onCreate(bundle);
                        setContentView(com.alipay.mobile.verifyidentity.business.pin.R.layout.activity_pin);
                        this.density = getResources().getDisplayMetrics().density;
                        this.initialMargin = getResources().getDisplayMetrics().heightPixels;
                        this.llContent = (LinearLayout) findViewById(com.alipay.mobile.verifyidentity.business.pin.R.id.ll_content);
                        this.tvVerification = (TextView) findViewById(com.alipay.mobile.verifyidentity.business.pin.R.id.tv_verification);
                        this.tvTip = (TextView) findViewById(com.alipay.mobile.verifyidentity.business.pin.R.id.tv_tip);
                        this.pwdInput = (FrameLayout) findViewById(com.alipay.mobile.verifyidentity.business.pin.R.id.pwd_input);
                        this.flKeyboard = (FrameLayout) findViewById(com.alipay.mobile.verifyidentity.business.pin.R.id.fl_keyboard);
                        this.flBack = (FrameLayout) findViewById(com.alipay.mobile.verifyidentity.business.pin.R.id.fl_back);
                        this.ibHalfBack = (ImageButton) findViewById(com.alipay.mobile.verifyidentity.business.pin.R.id.ib_half_back);
                        this.ibBack = (ImageButton) findViewById(com.alipay.mobile.verifyidentity.business.pin.R.id.ib_back);
                        this.tvFindpass = (TextView) findViewById(com.alipay.mobile.verifyidentity.business.pin.R.id.tv_findpass);
                        AlipayKeyboard alipayKeyboard = (AlipayKeyboard) findViewById(com.alipay.mobile.verifyidentity.business.pin.R.id.keyboard);
                        this.alipayKeyboard = alipayKeyboard;
                        alipayKeyboard.initializeKeyboard(this.flKeyboard);
                        this.tvFindpassCenter = (TextView) findViewById(com.alipay.mobile.verifyidentity.business.pin.R.id.tv_findpass_center);
                        this.rl_title = findViewById(com.alipay.mobile.verifyidentity.business.pin.R.id.rl_title);
                        this.flBack.setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.verifyidentity.business.pin.activity.PinActivity.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PinActivity.this.doCancel();
                                PinActivity.this.finish();
                            }
                        });
                        registerHandlerCallback(new HandlerCallback() { // from class: com.alipay.mobile.verifyidentity.business.pin.activity.PinActivity.2
                            @Override // com.alipay.mobile.verifyidentity.business.activity.HandlerCallback
                            public void handleMessage(android.os.Message message) {
                                if (message.what == 2000) {
                                    PinActivity.this.translateUi();
                                }
                            }
                        });
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
        } catch (Throwable th11) {
            Throwable cause11 = th11.getCause();
            if (cause11 == null) {
                throw th11;
            }
            throw cause11;
        }
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.BaseActivity
    public void initData() {
        Message message = (Message) getIntent().getSerializableExtra("message");
        this.message = message;
        if (message != null) {
            this.verifyId = message.getVerifyId();
            this.verifyMessage = this.message.getVerifyMessage();
            this.nextStep = this.message.getNextStep();
            this.predata = this.message.getPredata();
            try {
                JSONObject jSONObject = new JSONObject(this.message.getData());
                this.HAS_OTHERS = jSONObject.optBoolean("HAS_OTHERS", false);
                this.half_screen = jSONObject.optBoolean(RequestConstants.Pin.HALF_SCREEN, false);
                this.account_encrypt_pubkey = jSONObject.optString(RequestConstants.Pin.ACCOUNT_ENCRYPT_PUBKEY);
                String optString = jSONObject.optString(RequestConstants.Pin.INPUTCHARCOUNT);
                this.inputCharCount = TextUtils.isEmpty(optString) ? 6 : Integer.parseInt(optString);
                this.inputType = jSONObject.optString(RequestConstants.Pin.INPUTTYPE);
                this.account_encrypt_salt = jSONObject.optString(RequestConstants.Pin.ACCOUNT_ENCRYPT_SALT);
                this.form_title = jSONObject.optString("form_title");
                if (!TextUtils.isEmpty(this.predata) && !TextUtils.isEmpty(this.verifyMessage)) {
                    this.form_title = this.verifyMessage;
                }
                this.form_button = jSONObject.optString(RequestConstants.Pin.FORM_BUTTON);
                this.form_input_tip_low = jSONObject.optString(RequestConstants.Pin.FORM_INPUT_TIP_LOW);
                this.form_input_tip_url = jSONObject.optString(RequestConstants.Pin.FORM_INPUT_TIP_URL);
                this.head_title = jSONObject.optString("head_title");
                this.footTips = jSONObject.optString("foot_tip");
            } catch (JSONException unused) {
            }
        }
        initViewFromData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideContent() {
        this.tvTip.setVisibility(8);
        this.pwdInput.setVisibility(8);
        this.tvFindpass.setVisibility(8);
        this.tvFindpassCenter.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showContent() {
        this.tvTip.setVisibility(0);
        this.pwdInput.setVisibility(0);
        if (!TextUtils.isEmpty(this.form_input_tip_low) && !TextUtils.isEmpty(this.form_input_tip_url)) {
            this.tvFindpass.setVisibility(0);
        }
        if (!this.HAS_OTHERS || TextUtils.isEmpty(this.footTips)) {
            return;
        }
        if (!TextUtils.isEmpty(this.form_input_tip_low) && !TextUtils.isEmpty(this.form_input_tip_url)) {
            this.tvFindpassCenter.setVisibility(0);
            this.tvFindpassCenter.setText(this.footTips);
            return;
        }
        this.tvFindpassCenter.setVisibility(8);
        this.tvFindpass.setVisibility(0);
        this.tvFindpass.setText(this.footTips);
    }

    private void initViewFromData() {
        if (INPUT_TYPE_NUMERIC.equalsIgnoreCase(this.inputType)) {
            this.safeInputContext = new SafeInputContext(this, true, this.inputCharCount);
            this.aliKeyboardType = AliKeyboardType.num;
        } else {
            this.safeInputContext = new SafeInputContext(this, false, this.inputCharCount);
            this.aliKeyboardType = AliKeyboardType.abc;
        }
        this.pwdInput.addView(this.safeInputContext.getContentView(), new FrameLayout.LayoutParams(-1, -2));
        this.safeInputContext.setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.verifyidentity.business.pin.activity.PinActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PinActivity.this.alipayKeyboard.isShowKeyboard()) {
                    PinActivity.this.alipayKeyboard.showKeyboard(PinActivity.this.aliKeyboardType, PinActivity.this.safeInputContext.getEditText(), 0L);
                }
                PinActivity.this.alipayKeyboard.post(new Runnable() { // from class: com.alipay.mobile.verifyidentity.business.pin.activity.PinActivity.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        InputMethodManager inputMethodManager = (InputMethodManager) PinActivity.this.getSystemService("input_method");
                        if (inputMethodManager != null) {
                            inputMethodManager.hideSoftInputFromWindow(PinActivity.this.safeInputContext.getEditText().getWindowToken(), 0);
                        }
                    }
                });
            }
        });
        this.safeInputContext.setRsaPublicKey(this.account_encrypt_pubkey);
        this.safeInputContext.setEncryptRandomStringAndType(this.account_encrypt_salt, EncryptRandomType.randombefore);
        this.safeInputContext.setOkButtonText(this.form_button);
        this.tvVerification.setText(this.head_title);
        this.tvTip.setText(this.form_title);
        if (!TextUtils.isEmpty(this.form_input_tip_low) && !TextUtils.isEmpty(this.form_input_tip_url)) {
            this.tvFindpass.setVisibility(0);
            this.tvFindpass.setText(this.form_input_tip_low);
            this.tvFindpass.setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.verifyidentity.business.pin.activity.PinActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    OnClickUrl onClickUrl = VIEngine.getOnClickUrl();
                    if (onClickUrl != null) {
                        PinActivity pinActivity = PinActivity.this;
                        onClickUrl.onClickHttpUrl(pinActivity, pinActivity.form_input_tip_url);
                    }
                    VIRespone vIRespone = new VIRespone(1007);
                    vIRespone.setVerifyId(PinActivity.this.verifyId);
                    vIRespone.setMessage(PinActivity.this.message);
                    if (PinActivity.getCallback() != null) {
                        PinActivity.getCallback().onResult(PinActivity.pinProduct, vIRespone);
                    }
                    PinActivity.this.finish();
                }
            });
        } else {
            this.tvFindpass.setVisibility(8);
        }
        if (this.HAS_OTHERS && !TextUtils.isEmpty(this.footTips)) {
            if (!TextUtils.isEmpty(this.form_input_tip_low) && !TextUtils.isEmpty(this.form_input_tip_url)) {
                this.tvFindpassCenter.setVisibility(0);
                this.tvFindpassCenter.setText(this.footTips);
                this.tvFindpassCenter.setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.verifyidentity.business.pin.activity.PinActivity.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("verifyType", "1");
                        hashMap.put("module", RequestConstants.MENU);
                        hashMap.put("verifyId", PinActivity.this.verifyId);
                        VIEngine.verify(PinActivity.this, RequestConstants.VerifyProductVerify, 9000, hashMap, null, new VIEngine.VIListener() { // from class: com.alipay.mobile.verifyidentity.business.pin.activity.PinActivity.5.1
                            @Override // com.alipay.mobile.verifyidentity.framework.engine.VIEngine.VIListener
                            public void onVerifyAction(VIAction vIAction) {
                            }

                            @Override // com.alipay.mobile.verifyidentity.framework.engine.VIEngine.VIListener
                            public void onVerifyResult(VIResult vIResult) {
                            }
                        }, null);
                    }
                });
            } else {
                this.tvFindpassCenter.setVisibility(8);
                this.tvFindpass.setVisibility(0);
                this.tvFindpass.setText(this.footTips);
                this.tvFindpass.setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.verifyidentity.business.pin.activity.PinActivity.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("verifyType", "1");
                        hashMap.put("module", RequestConstants.MENU);
                        hashMap.put("verifyId", PinActivity.this.verifyId);
                        VIEngine.verify(PinActivity.this, RequestConstants.VerifyProductVerify, 9000, hashMap, null, new VIEngine.VIListener() { // from class: com.alipay.mobile.verifyidentity.business.pin.activity.PinActivity.6.1
                            @Override // com.alipay.mobile.verifyidentity.framework.engine.VIEngine.VIListener
                            public void onVerifyAction(VIAction vIAction) {
                            }

                            @Override // com.alipay.mobile.verifyidentity.framework.engine.VIEngine.VIListener
                            public void onVerifyResult(VIResult vIResult) {
                            }
                        }, null);
                    }
                });
            }
        } else {
            this.tvFindpassCenter.setVisibility(8);
        }
        this.safeInputContext.setOnConfirmListener(new AnonymousClass7());
        HashMap hashMap = new HashMap();
        hashMap.put("halfScreen", String.valueOf(this.half_screen));
        ClientLogKitManager.getClientLogKit().log("event", new String[]{"a2.b1.c2", "0", ""}, hashMap, "", "SecVI_Seed_Pwd_DrawView", "", this.verifyId, false);
        if (!this.half_screen) {
            this.ibBack.setVisibility(0);
            this.ibHalfBack.setVisibility(8);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.llContent.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.topMargin = 0;
                this.llContent.setLayoutParams(layoutParams);
            }
            this.safeInputContext.getContentView().post(new Runnable() { // from class: com.alipay.mobile.verifyidentity.business.pin.activity.PinActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    PinActivity.this.alipayKeyboard.showKeyboard(PinActivity.this.aliKeyboardType, PinActivity.this.safeInputContext.getEditText(), 0L);
                }
            });
            return;
        }
        this.ibBack.setVisibility(8);
        this.ibHalfBack.setVisibility(0);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.llContent.getLayoutParams();
        layoutParams2.topMargin = (int) this.initialMargin;
        this.llContent.setLayoutParams(layoutParams2);
        float navigationBarHeight = (this.initialMargin - (this.density * 442.0f)) - getNavigationBarHeight();
        this.destMargin = navigationBarHeight;
        this.stepMargin = (this.initialMargin - navigationBarHeight) / 10.0f;
        translateUi();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.alipay.mobile.verifyidentity.business.pin.activity.PinActivity$7  reason: invalid class name */
    /* loaded from: classes7.dex */
    public class AnonymousClass7 implements OnConfirmListener {
        AnonymousClass7() {
        }

        @Override // com.alipay.androidinter.app.safepaybase.OnConfirmListener
        public void onUserConfirm(final String str) {
            if (PinActivity.this.safeInputContext != null) {
                PinActivity.this.safeInputContext.clearText();
                PinActivity.this.hideContent();
            }
            PinActivity.this.showSubmittingDialog();
            HashMap hashMap = new HashMap();
            hashMap.put("retryNum", String.valueOf(PinActivity.this.retryCount));
            ClientLogKitManager.getClientLogKit().log("event", new String[]{"a2.b2.c1", "0", ""}, hashMap, "", "SecVI_Seed_Pwd_Verify", "", PinActivity.this.verifyId, false);
            IAPAsyncTask.asyncTask(new IAPAsyncTask.Runner<MICRpcResponse>() { // from class: com.alipay.mobile.verifyidentity.business.pin.activity.PinActivity.7.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.alipay.iap.android.common.task.async.IAPAsyncTask.Runner
                public MICRpcResponse execute() throws Exception {
                    MICRpcRequest mICRpcRequest = new MICRpcRequest();
                    mICRpcRequest.action = RequestConstants.VERIFY;
                    mICRpcRequest.module = PinActivity.this.nextStep;
                    mICRpcRequest.verifyId = PinActivity.this.verifyId;
                    JSONObject jSONObject = new JSONObject();
                    if (TextUtils.isEmpty(PinActivity.this.predata)) {
                        jSONObject.put("data", str);
                    } else {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(RequestConstants.KEY_ENCRYPT_PWD, str);
                        jSONObject2.put(RequestConstants.KEY_PREDATA, PinActivity.this.predata);
                        jSONObject.put("data", jSONObject2.toString());
                    }
                    mICRpcRequest.data = jSONObject.toString();
                    mICRpcRequest.version = "1.0.0";
                    try {
                        return RpcSettings.retrieveRpcService().dispatch(mICRpcRequest);
                    } catch (Throwable unused) {
                        return null;
                    }
                }

                @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
                public void onSuccess(final MICRpcResponse mICRpcResponse) {
                    PinActivity.this.hideSubmittingDialog();
                    if (mICRpcResponse == null) {
                        if (PinActivity.this != null && !PinActivity.this.isFinishing()) {
                            PinActivity.this.safeInputContext.clearText();
                            CustomUi.showCenterToast(PinActivity.this, PinActivity.this.getResources().getString(com.alipay.mobile.verifyidentity.business.pin.R.string.pin_system_busy_error));
                        }
                        ClientLogKitManager.getClientLogKit().log("event", new String[]{"a2.b2.c2", "1", ""}, null, "", "SecVI_Seed_Pwd_Result", "", PinActivity.this.verifyId, false);
                        PinActivity.this.showContent();
                        return;
                    }
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("finishedCode", mICRpcResponse.finishCode);
                    hashMap2.put("finishedMsg", mICRpcResponse.finishMessage);
                    hashMap2.put("verifyMsg", mICRpcResponse.verifyMessage);
                    ClientLogKitManager.getClientLogKit().log("event", new String[]{"a2.b2.c2", "0", ""}, hashMap2, "", "SecVI_Seed_Pwd_Result", "", PinActivity.this.verifyId, false);
                    if (!mICRpcResponse.verifySuccess) {
                        PinActivity.this.safeInputContext.clearText();
                        if (!TextUtils.isEmpty(PinActivity.this.nextStep) && PinActivity.this.nextStep.equalsIgnoreCase(mICRpcResponse.nextStep)) {
                            CustomUi.showCommonDialog(PinActivity.this, "", mICRpcResponse.verifyMessage, 1001, true, new ModalInterface() { // from class: com.alipay.mobile.verifyidentity.business.pin.activity.PinActivity.7.1.1
                                @Override // com.alipay.mobile.verifyidentity.uitools.dialog.ModalInterface
                                public void onCancel() {
                                }

                                @Override // com.alipay.mobile.verifyidentity.uitools.dialog.ModalInterface
                                public void onOk() {
                                    InstrumentInjector.log_d("CustomUi", "  showAlertDialog   onOk");
                                }
                            });
                        } else {
                            CustomUi.showCommonDialog(PinActivity.this, "", mICRpcResponse.verifyMessage, 1001, false, new ModalInterface() { // from class: com.alipay.mobile.verifyidentity.business.pin.activity.PinActivity.7.1.2
                                @Override // com.alipay.mobile.verifyidentity.uitools.dialog.ModalInterface
                                public void onCancel() {
                                }

                                @Override // com.alipay.mobile.verifyidentity.uitools.dialog.ModalInterface
                                public void onOk() {
                                    InstrumentInjector.log_d("CustomUi", "  showAlertDialog   onOk");
                                    VIRespone vIRespone = new VIRespone(1001);
                                    vIRespone.setResponseMessage(mICRpcResponse.convertToMessage());
                                    vIRespone.setMessage(PinActivity.this.message);
                                    vIRespone.setVerifyId(mICRpcResponse.verifyId);
                                    if (PinActivity.getCallback() != null) {
                                        PinActivity.getCallback().onResult(PinActivity.pinProduct, vIRespone);
                                    }
                                    PinActivity.this.finish();
                                }
                            });
                        }
                    } else {
                        VIRespone vIRespone = new VIRespone(1000);
                        vIRespone.setResponseMessage(mICRpcResponse.convertToMessage());
                        vIRespone.setVerifyId(mICRpcResponse.verifyId);
                        vIRespone.setMessage(PinActivity.this.message);
                        if (PinActivity.getCallback() != null) {
                            PinActivity.getCallback().onResult(PinActivity.pinProduct, vIRespone);
                        }
                        PinActivity.this.finish();
                    }
                    PinActivity.this.showContent();
                }

                @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
                public void onFailure(final IAPError iAPError) {
                    PinActivity.this.safeInputContext.clearText();
                    PinActivity.this.hideSubmittingDialog();
                    PinActivity.access$808(PinActivity.this);
                    CustomUi.showCommonDialog(PinActivity.this, "", iAPError.errorMessage, 1001, true, new ModalInterface() { // from class: com.alipay.mobile.verifyidentity.business.pin.activity.PinActivity.7.1.3
                        @Override // com.alipay.mobile.verifyidentity.uitools.dialog.ModalInterface
                        public void onCancel() {
                        }

                        @Override // com.alipay.mobile.verifyidentity.uitools.dialog.ModalInterface
                        public void onOk() {
                            InstrumentInjector.log_d("CustomUi", "  showAlertDialog   onOk");
                            if ("5".equalsIgnoreCase(iAPError.errorCode)) {
                                PinActivity.this.finish();
                            }
                        }
                    });
                    PinActivity.this.showContent();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void translateUi() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.llContent.getLayoutParams();
        layoutParams.topMargin = (int) (layoutParams.topMargin - this.stepMargin);
        this.llContent.setLayoutParams(layoutParams);
        if (Math.abs(layoutParams.topMargin - this.destMargin) < 1.0f || layoutParams.topMargin < this.destMargin) {
            getWeakHandler().removeMessages(2000);
            this.safeInputContext.getContentView().post(new Runnable() { // from class: com.alipay.mobile.verifyidentity.business.pin.activity.PinActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    PinActivity.this.alipayKeyboard.showKeyboard(PinActivity.this.aliKeyboardType, PinActivity.this.safeInputContext.getEditText(), 0L);
                }
            });
            return;
        }
        getWeakHandler().sendEmptyMessageDelayed(2000, 10L);
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.BaseActivity
    public void modifyViewFromOutside() {
        ViewGroup.LayoutParams layoutParams;
        ActivityInterface commonActivityInterface = ActivityInterfaceManager.getCommonActivityInterface();
        if (!TextUtils.isEmpty(commonActivityInterface.navBigColor())) {
            int parseColor = ColorUtils.parseColor(commonActivityInterface.navBigColor());
            if (!ColorUtils.isColorInvalid(parseColor)) {
                this.rl_title.setBackgroundColor(parseColor);
            }
        }
        if (commonActivityInterface.navTitleHeight() > 0 && (layoutParams = this.rl_title.getLayoutParams()) != null) {
            layoutParams.height = (int) ((commonActivityInterface.navTitleHeight() * getResources().getDisplayMetrics().density) + 0.5f);
            this.rl_title.setLayoutParams(layoutParams);
        }
        ActivityInterface pinActivityInterface = ActivityInterfaceManager.getPinActivityInterface();
        if (pinActivityInterface.navTitleFont() > 0) {
            this.tvVerification.setTextSize(1, pinActivityInterface.navTitleFont());
        }
        if (!TextUtils.isEmpty(pinActivityInterface.navTitleColor())) {
            int parseColor2 = ColorUtils.parseColor(pinActivityInterface.navTitleColor());
            if (!ColorUtils.isColorInvalid(parseColor2)) {
                this.tvVerification.setTextColor(parseColor2);
            }
        }
        if (!TextUtils.isEmpty(pinActivityInterface.bodyTitleColor())) {
            int parseColor3 = ColorUtils.parseColor(pinActivityInterface.bodyTitleColor());
            if (!ColorUtils.isColorInvalid(parseColor3)) {
                this.tvTip.setTextColor(parseColor3);
            }
        }
        if (pinActivityInterface.bodyTitleFont() > 0) {
            this.tvTip.setTextSize(1, pinActivityInterface.bodyTitleFont());
        }
        if (pinActivityInterface.bodyTitleAlign() > 0) {
            this.tvTip.setGravity(pinActivityInterface.bodyTitleAlign());
        }
        setFontStyle();
    }

    private void setFontStyle() {
        if (CustomUi.getTitleTypeface() != null) {
            this.tvVerification.setTypeface(CustomUi.getTitleTypeface());
        }
        if (CustomUi.getContentTypeface() != null) {
            this.tvTip.setTypeface(CustomUi.getContentTypeface());
            this.tvFindpass.setTypeface(CustomUi.getContentTypeface());
            this.tvFindpassCenter.setTypeface(CustomUi.getContentTypeface());
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == keyEvent.getKeyCode()) {
            if (this.alipayKeyboard.isShowKeyboard()) {
                this.alipayKeyboard.hideKeyboard();
                return true;
            }
            doCancel();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.ProductActivity, com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            h(new char[]{Typography.quote, '(', Typography.amp, '*', InputCardNumberView.DIVIDER, '\r', '(', 7, 31, 5, 5, '\n', InputCardNumberView.DIVIDER, 21, '.', 18, 4, '\r', '.', 11, JSONLexer.EOI, '-', ',', 3, 28, '('}, getPackageName().length() + 19, (byte) (super.getResources().getString(R.string.lbl_dialog_incorrect_pin_or_otp_last_try).substring(2, 3).length() + 15), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            h(new char[]{24, 11, 13829, 13829, 6, '%', '#', InputCardNumberView.DIVIDER, 13831, 13831, 25, '\b', JSONLexer.EOI, InputCardNumberView.DIVIDER, '.', 18, ')', '0'}, 18 - View.resolveSizeAndState(0, 0, 0), (byte) (getPackageName().codePointAt(3) - 71), objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - View.getDefaultSize(0, 0), (char) TextUtils.indexOf("", "", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 910, 17 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1))).getMethod("MyBillsEntityDataFactory", Context.class);
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
        overridePendingTransition(0, 0);
        super.onPause();
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.ProductActivity, com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.safeInputContext.clearText();
        setCallback(null);
        setPinProduct(null);
    }

    private static void h(char[] cArr, int i, byte b, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = moveToNextValue;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i3 = 0; i3 < length; i3++) {
                cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
            }
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ scheduleImpl);
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
