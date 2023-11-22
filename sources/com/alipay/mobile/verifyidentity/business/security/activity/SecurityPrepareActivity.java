package com.alipay.mobile.verifyidentity.business.security.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
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
import android.widget.TextView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.androidinter.app.safepaybase.widget.CenterTextView;
import com.alipay.fc.riskcloud.biz.mic.rpc.ICRpcService;
import com.alipay.iap.android.common.errorcode.IAPError;
import com.alipay.iap.android.common.task.async.IAPAsyncTask;
import com.alipay.mobile.verifyidentity.RpcSettings;
import com.alipay.mobile.verifyidentity.base.OnClickUrl;
import com.alipay.mobile.verifyidentity.base.message.Message;
import com.alipay.mobile.verifyidentity.base.message.MessageConstants;
import com.alipay.mobile.verifyidentity.base.message.RequestConstants;
import com.alipay.mobile.verifyidentity.business.activity.ActivityInterface;
import com.alipay.mobile.verifyidentity.business.activity.ActivityInterfaceManager;
import com.alipay.mobile.verifyidentity.business.activity.BaseActivity;
import com.alipay.mobile.verifyidentity.business.activity.ClientLogKitManager;
import com.alipay.mobile.verifyidentity.business.menu.activity.MenuActivity;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.alipay.mobile.verifyidentity.business.securitycommon.widget.NoDoubleClickUtils;
import com.alipay.mobile.verifyidentity.framework.engine.VIAction;
import com.alipay.mobile.verifyidentity.framework.engine.VIEngine;
import com.alipay.mobile.verifyidentity.framework.engine.VIEngineUtils;
import com.alipay.mobile.verifyidentity.framework.engine.VIResult;
import com.alipay.mobile.verifyidentity.uitools.ColorUtils;
import com.alipay.mobile.verifyidentity.uitools.CustomUi;
import com.alipay.mobile.verifyidentity.uitools.dialog.CommonDialog;
import com.alipay.mobile.verifyidentity.uitools.dialog.ModalInterface;
import com.alipay.mobileiclib.common.service.facade.solution.dto.MICRpcRequest;
import com.alipay.mobileiclib.common.service.facade.solution.dto.MICRpcResponse;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import o.C;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class SecurityPrepareActivity extends BaseActivity {
    private String button1Action;
    private String button1Text;
    private String button2Action;
    private String button2Text;
    private boolean isClickSetUp = false;
    private Message message;
    private String nextAction;
    private String nextStep;
    private String pageTitle;
    private String prodmngId;
    private String productType;
    private String protocolText;
    private String protocolTip;
    private String protocolUrl;
    private SecuritySuccessReceiver receiver;
    private MICRpcResponse requestResult;
    private View rl_title;
    private String sceneId;
    private String setUpText;
    private String tntInstId;
    private TextView tv_bnt1;
    private TextView tv_bnt2;
    private CenterTextView tv_center;
    private TextView tv_link;
    private TextView tv_link_before;
    private TextView tv_title;
    private String userId;
    private String verifyId;
    public static final byte[] $$d = {77, -56, -115, -110, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$e = 230;
    public static final byte[] getAuthRequestContext = {83, 16, 71, 115, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int BuiltInFictitiousFunctionClassFactory = 144;
    private static char getErrorConfigVersion = 56697;
    private static char PlaceComponentResult = 11864;
    private static char lookAheadTest = 41470;
    private static char moveToNextValue = 35355;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void e(byte r8, short r9, short r10, java.lang.Object[] r11) {
        /*
            byte[] r0 = com.alipay.mobile.verifyidentity.business.security.activity.SecurityPrepareActivity.getAuthRequestContext
            int r8 = r8 + 97
            int r9 = 56 - r9
            int r10 = 23 - r10
            byte[] r1 = new byte[r10]
            r2 = 0
            if (r0 != 0) goto L14
            r8 = r9
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r11
            r11 = r10
            goto L2f
        L14:
            r3 = 0
        L15:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r10) goto L24
            java.lang.String r8 = new java.lang.String
            r8.<init>(r1, r2)
            r11[r2] = r8
            return
        L24:
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
        L2f:
            int r9 = r9 + r10
            int r8 = r8 + 1
            int r9 = r9 + (-4)
            r10 = r11
            r11 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r9
            r9 = r8
            r8 = r6
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.verifyidentity.business.security.activity.SecurityPrepareActivity.e(byte, short, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void f(byte r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = 46 - r6
            int r8 = r8 * 3
            int r8 = 42 - r8
            int r7 = r7 * 2
            int r7 = r7 + 75
            byte[] r0 = com.alipay.mobile.verifyidentity.business.security.activity.SecurityPrepareActivity.$$d
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r7 = r6
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L38
        L1a:
            r3 = 0
            r5 = r7
            r7 = r6
            r6 = r5
        L1e:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r7 = r7 + 1
            if (r3 != r8) goto L2d
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2d:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L38:
            int r6 = r6 + r8
            int r6 = r6 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.verifyidentity.business.security.activity.SecurityPrepareActivity.f(byte, byte, short, java.lang.Object[]):void");
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        Method method;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        d(18 - TextUtils.getOffsetAfter("", 0), new char[]{29048, 3683, 42184, 63726, 22713, 64765, 47645, 44098, 32068, 54954, 54099, 53423, 47971, 4247, 38441, 27628, 38190, 7028}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        d(5 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), new char[]{61584, 58273, 63300, 4435, 7911, 41654}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.resolveSize(0, 0), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 35, (char) (AndroidCharacter.getMirror('0') - '0'))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    d((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 49, new char[]{47250, 19133, 4801, 49267, 53864, 39423, 3037, 50452, 5513, 22076, 28213, 21986, 47500, 56267, 24149, 47496, 24783, 15721, 56531, 9818, 7359, 19789, 34638, 38848, 3889, 1142, 36703, 38610, 33555, 45541, 46556, 1961, 35344, 4440, 54332, 40718, 41410, 63258, 35776, 55715, 62973, 59561, 12180, 48172, 43045, 62014, 15823, 39713}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    d(((Process.getThreadPriority(0) + 20) >> 6) + 64, new char[]{57588, 15543, 10037, 4535, 41410, 63258, 59056, 45230, 7359, 19789, 2214, 49744, 56256, 8378, 36281, 19777, 7941, 27055, 22038, 65393, 56256, 8378, 59977, 37292, 60584, 21579, 46802, 21531, 36703, 38610, 7941, 27055, 28893, 58414, 11487, 53000, 29853, 64844, 9663, 28946, 933, 46203, 42578, 3941, 24299, 35889, 49966, 1882, 58951, 26082, 30984, 13512, 59762, 65399, 47624, 52161, 47624, 52161, 19006, 44471, 44135, 7293, 3889, 1142}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    d(64 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), new char[]{16422, 38302, 32445, 32985, 59762, 65399, 23340, 51414, 1210, 42443, 62327, 33058, 8145, 1427, 47143, 9049, 46556, 1961, 20299, 61399, 14171, 15575, 39652, 879, 62973, 59561, 3037, 50452, 20253, 11941, 47250, 19133, 57298, 5068, 57796, 18142, 44673, 22710, 4801, 49267, 2724, 43640, 36281, 19777, 35776, 55715, 18865, 53604, 41410, 63258, 38441, 27628, 16422, 38302, 56129, 53758, 46144, 6679, 35344, 4440, 56129, 53758, 26548, 23653}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    d(59 - TextUtils.lastIndexOf("", '0', 0), new char[]{63029, 28529, 55171, 63852, 10694, 29008, 63908, 4864, 11921, 17334, 45351, 12122, 35754, 56190, 20133, 40806, 40000, 19430, 10579, 441, 27990, 48003, 26175, 29858, 14707, 5744, 23079, 4657, 36139, 44561, 55596, 48918, 23079, 4657, 44865, 18312, 18138, 8280, 45254, 14979, 30272, 19491, 33504, 1570, 20376, 45122, 24288, 35681, 61041, 37308, 27118, 17231, 37192, 880, 30779, 14236, 23350, 26125, 59150, 46071}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    d(6 - ExpandableListView.getPackedPositionGroup(0L), new char[]{7917, 30840, 36337, 58893, 16422, 38302}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + 911, 18 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                e(getAuthRequestContext[32], getAuthRequestContext[31], (byte) (-getAuthRequestContext[30]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = (byte) (getAuthRequestContext[32] - 1);
                Object[] objArr14 = new Object[1];
                e(b, (byte) (b | 22), (byte) (-getAuthRequestContext[30]), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16777271, 2 - TextUtils.lastIndexOf("", '0', 0), (char) View.MeasureSpec.makeMeasureSpec(0, 0));
                        Object[] objArr16 = new Object[1];
                        f($$d[53], $$d[78], $$d[31], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, 16 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) TextUtils.indexOf("", "", 0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 16, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), View.getDefaultSize(0, 0) + 29, (char) (57994 - TextUtils.getOffsetBefore("", 0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 800, TextUtils.lastIndexOf("", '0', 0, 0) + 16, (char) TextUtils.getOffsetAfter("", 0)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - View.getDefaultSize(0, 0), (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {62981126, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getPressedStateDuration() >> 16), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 18, (char) Color.alpha(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                e(getAuthRequestContext[32], getAuthRequestContext[31], (byte) (-getAuthRequestContext[30]), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b2 = (byte) (getAuthRequestContext[32] - 1);
                Object[] objArr20 = new Object[1];
                e(b2, (byte) (b2 | 22), (byte) (-getAuthRequestContext[30]), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - Color.red(0), 46 - (ViewConfiguration.getTouchSlop() >> 8), (char) TextUtils.getCapsMode("", 0, 0));
                        Object[] objArr22 = new Object[1];
                        f($$d[84], $$d[9], $$d[8], objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - KeyEvent.normalizeMetaState(0), (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {62981126, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getWindowTouchSlop() >> 8) + 911, TextUtils.getOffsetBefore("", 0) + 18, (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                e(getAuthRequestContext[32], getAuthRequestContext[31], (byte) (-getAuthRequestContext[30]), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b3 = (byte) (getAuthRequestContext[32] - 1);
                Object[] objArr26 = new Object[1];
                e(b3, (byte) (b3 | 22), (byte) (-getAuthRequestContext[30]), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 118, TextUtils.lastIndexOf("", '0') + 4, (char) (Drawable.resolveOpacity(0, 0) + 38968));
                        Object[] objArr28 = new Object[1];
                        f($$d[84], $$d[9], $$d[8], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (Process.myPid() >> 22), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 35, (char) TextUtils.indexOf("", ""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {62981126, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 911, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 18, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                e(getAuthRequestContext[32], getAuthRequestContext[31], (byte) (-getAuthRequestContext[30]), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b4 = (byte) (getAuthRequestContext[32] - 1);
                Object[] objArr32 = new Object[1];
                e(b4, (byte) (b4 | 22), (byte) (-getAuthRequestContext[30]), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - View.MeasureSpec.getMode(0), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 2, (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))));
                        byte b5 = (byte) ($$d[78] - 1);
                        byte b6 = b5;
                        Object[] objArr34 = new Object[1];
                        f(b5, b6, b6, objArr34);
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
                                method = obj16;
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                method = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.indexOf("", "", 0) + 35, (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, method);
                            }
                            Object invoke6 = ((Method) method).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {62981126, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + 911, 18 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) Color.alpha(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
            Object[] objArr = new Object[1];
            d(26 - KeyEvent.keyCodeFromString(""), new char[]{29048, 3683, 42184, 63726, 22713, 64765, 47645, 44098, 30272, 19491, 50707, 58062, 61023, 25567, 10560, 40849, 62725, 11694, 2618, 42180, 49940, 50891, 42180, 6004, 27303, 16138}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            d(getPackageName().length() + 11, new char[]{62517, 27856, 1925, 43540, 23350, 26125, 61296, 519, 1582, 18625, 8998, 16274, 5925, 36327, 10560, 40849, 19332, 25311}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.resolveSize(0, 0), Process.getGidForName("") + 36, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), 18 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) (MotionEvent.axisFromString("") + 1))).getMethod("MyBillsEntityDataFactory", Context.class);
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
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr = new Object[1];
        d(getPackageName().length() + 11, new char[]{29048, 3683, 42184, 63726, 22713, 64765, 47645, 44098, 32068, 54954, 54099, 53423, 47971, 4247, 38441, 27628, 38190, 7028}, objArr);
        Class<?> cls = Class.forName((String) objArr[0]);
        Object[] objArr2 = new Object[1];
        d((ViewConfiguration.getScrollDefaultDelay() >> 16) + 5, new char[]{61584, 58273, 63300, 4435, 7911, 41654}, objArr2);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr2[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr3 = new Object[1];
                d((ViewConfiguration.getJumpTapTimeout() >> 16) + 26, new char[]{29048, 3683, 42184, 63726, 22713, 64765, 47645, 44098, 30272, 19491, 50707, 58062, 61023, 25567, 10560, 40849, 62725, 11694, 2618, 42180, 49940, 50891, 42180, 6004, 27303, 16138}, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                d(18 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), new char[]{62517, 27856, 1925, 43540, 23350, 26125, 61296, 519, 1582, 18625, 8998, 16274, 5925, 36327, 10560, 40849, 19332, 25311}, objArr4);
                baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getTrimmedLength(""), 34 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) TextUtils.getTrimmedLength(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr5 = new Object[1];
                    d(super.getResources().getString(R.string.btn_check_code).substring(0, 1).codePointAt(0) - 19, new char[]{47250, 19133, 4801, 49267, 53864, 39423, 3037, 50452, 5513, 22076, 28213, 21986, 47500, 56267, 24149, 47496, 24783, 15721, 56531, 9818, 7359, 19789, 34638, 38848, 3889, 1142, 36703, 38610, 33555, 45541, 46556, 1961, 35344, 4440, 54332, 40718, 41410, 63258, 35776, 55715, 62973, 59561, 12180, 48172, 43045, 62014, 15823, 39713}, objArr5);
                    String str = (String) objArr5[0];
                    Object[] objArr6 = new Object[1];
                    d(65 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), new char[]{57588, 15543, 10037, 4535, 41410, 63258, 59056, 45230, 7359, 19789, 2214, 49744, 56256, 8378, 36281, 19777, 7941, 27055, 22038, 65393, 56256, 8378, 59977, 37292, 60584, 21579, 46802, 21531, 36703, 38610, 7941, 27055, 28893, 58414, 11487, 53000, 29853, 64844, 9663, 28946, 933, 46203, 42578, 3941, 24299, 35889, 49966, 1882, 58951, 26082, 30984, 13512, 59762, 65399, 47624, 52161, 47624, 52161, 19006, 44471, 44135, 7293, 3889, 1142}, objArr6);
                    String str2 = (String) objArr6[0];
                    try {
                        byte b = getAuthRequestContext[25];
                        Object[] objArr7 = new Object[1];
                        e(b, (byte) (b | TarHeader.LF_BLK), getAuthRequestContext[25], objArr7);
                        Class<?> cls3 = Class.forName((String) objArr7[0]);
                        Object[] objArr8 = new Object[1];
                        e((byte) (-getAuthRequestContext[5]), getAuthRequestContext[25], getAuthRequestContext[27], objArr8);
                        Object[] objArr9 = new Object[1];
                        d(((ApplicationInfo) cls3.getMethod((String) objArr8[0], null).invoke(this, null)).targetSdkVersion + 31, new char[]{16422, 38302, 32445, 32985, 59762, 65399, 23340, 51414, 1210, 42443, 62327, 33058, 8145, 1427, 47143, 9049, 46556, 1961, 20299, 61399, 14171, 15575, 39652, 879, 62973, 59561, 3037, 50452, 20253, 11941, 47250, 19133, 57298, 5068, 57796, 18142, 44673, 22710, 4801, 49267, 2724, 43640, 36281, 19777, 35776, 55715, 18865, 53604, 41410, 63258, 38441, 27628, 16422, 38302, 56129, 53758, 46144, 6679, 35344, 4440, 56129, 53758, 26548, 23653}, objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        d(super.getResources().getString(R.string.empty_state_add_button).substring(0, 2).codePointAt(1) + 28, new char[]{63029, 28529, 55171, 63852, 10694, 29008, 63908, 4864, 11921, 17334, 45351, 12122, 35754, 56190, 20133, 40806, 40000, 19430, 10579, 441, 27990, 48003, 26175, 29858, 14707, 5744, 23079, 4657, 36139, 44561, 55596, 48918, 23079, 4657, 44865, 18312, 18138, 8280, 45254, 14979, 30272, 19491, 33504, 1570, 20376, 45122, 24288, 35681, 61041, 37308, 27118, 17231, 37192, 880, 30779, 14236, 23350, 26125, 59150, 46071}, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        d(super.getResources().getString(R.string.share_activity_hint).substring(5, 6).length() + 5, new char[]{7917, 30840, 36337, 58893, 16422, 38302}, objArr11);
                        try {
                            Object[] objArr12 = {baseContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 911, Color.red(0) + 18, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                } catch (Throwable th3) {
                    Throwable cause3 = th3.getCause();
                    if (cause3 == null) {
                        throw th3;
                    }
                    throw cause3;
                }
            }
        }
        try {
            Object[] objArr13 = new Object[1];
            e(getAuthRequestContext[32], getAuthRequestContext[31], (byte) (-getAuthRequestContext[30]), objArr13);
            Class<?> cls4 = Class.forName((String) objArr13[0]);
            byte b2 = (byte) (getAuthRequestContext[32] - 1);
            Object[] objArr14 = new Object[1];
            e(b2, (byte) (b2 | 22), (byte) (-getAuthRequestContext[30]), objArr14);
            try {
                Object[] objArr15 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 4 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) Gravity.getAbsoluteGravity(0, 0));
                    byte b3 = (byte) ($$d[78] - 1);
                    byte b4 = b3;
                    Object[] objArr16 = new Object[1];
                    f(b3, b4, b4, objArr16);
                    obj3 = cls5.getMethod((String) objArr16[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr17 = (Object[]) ((Method) obj3).invoke(null, objArr15);
                int i = ((int[]) objArr17[1])[0];
                if (((int[]) objArr17[0])[0] != i) {
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) TextUtils.indexOf("", ""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(null, null);
                        try {
                            Object[] objArr18 = {-2113500161, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 18 - View.combineMeasuredStates(0, 0), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr18);
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
                super.onCreate(bundle);
                setContentView(com.alipay.mobile.verifyidentity.business.security.R.layout.activity_securityquestion_list);
                initView();
                initData();
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

    private void initView() {
        this.tv_title = (TextView) findViewById(com.alipay.mobile.verifyidentity.business.security.R.id.tv_title);
        this.tv_center = (CenterTextView) findViewById(com.alipay.mobile.verifyidentity.business.security.R.id.tv_content_center);
        this.tv_link_before = (TextView) findViewById(com.alipay.mobile.verifyidentity.business.security.R.id.tv_link_before);
        this.rl_title = findViewById(com.alipay.mobile.verifyidentity.business.security.R.id.rl_title);
        this.tv_link = (TextView) findViewById(com.alipay.mobile.verifyidentity.business.security.R.id.tv_link);
        this.tv_bnt1 = (TextView) findViewById(com.alipay.mobile.verifyidentity.business.security.R.id.tv_bnt1);
        this.tv_bnt2 = (TextView) findViewById(com.alipay.mobile.verifyidentity.business.security.R.id.tv_bnt2);
        findViewById(com.alipay.mobile.verifyidentity.business.security.R.id.ll_back).setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.verifyidentity.business.security.activity.SecurityPrepareActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SecurityPrepareActivity.this.finish();
            }
        });
        registerReceiver();
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
                JSONObject jSONObject = new JSONObject(new JSONObject(this.message.getData()).optString(MessageConstants.KEY_PAGE_MODEL));
                this.setUpText = jSONObject.optString(MessageConstants.KEY_SETUP_TEXT);
                this.protocolTip = jSONObject.optString(MessageConstants.KEY_PROTOCOLTIP);
                this.protocolText = jSONObject.optString(MessageConstants.KEY_PROTOCOLTEXT);
                this.pageTitle = jSONObject.optString("pageTitle");
                this.protocolUrl = jSONObject.optString("protocolUrl");
                this.button1Text = jSONObject.optString(MessageConstants.KEY_BUTTON1TEXT);
                this.button1Action = jSONObject.optString(MessageConstants.KEY_BUTTON1ACTION);
                this.button2Text = jSONObject.optString(MessageConstants.KEY_BUTTON2TEXT);
                this.button2Action = jSONObject.optString(MessageConstants.KEY_BUTTON2ACTION);
            } catch (Exception unused) {
            }
        }
        initViewFromData();
    }

    private void registerReceiver() {
        this.receiver = new SecuritySuccessReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SecurityConstants.KEY_SET_SECURITY_SUCCESSFUL);
        intentFilter.addAction(MenuActivity.VERIFY_SUCCESS);
        registerReceiver(this.receiver, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class SecuritySuccessReceiver extends BroadcastReceiver {
        private SecuritySuccessReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(SecurityConstants.KEY_SET_SECURITY_SUCCESSFUL)) {
                if (SecurityPrepareActivity.this.isFinishing()) {
                    return;
                }
                SecurityPrepareActivity.this.finish();
            } else if (intent.getAction().equals(MenuActivity.VERIFY_SUCCESS) && intent.getExtras().getString("verifyId").equals(SecurityPrepareActivity.this.verifyId)) {
                if (SecurityPrepareActivity.this.isClickSetUp) {
                    SecurityPrepareActivity securityPrepareActivity = SecurityPrepareActivity.this;
                    securityPrepareActivity.gotoSetquestionPage(securityPrepareActivity.requestResult);
                    return;
                }
                SecurityPrepareActivity securityPrepareActivity2 = SecurityPrepareActivity.this;
                securityPrepareActivity2.getSetupData(securityPrepareActivity2.requestResult.nextAction);
            }
        }
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            d(super.getResources().getString(R.string.image_capture_see_photo_tip_spannable).substring(6, 7).length() + 25, new char[]{29048, 3683, 42184, 63726, 22713, 64765, 47645, 44098, 30272, 19491, 50707, 58062, 61023, 25567, 10560, 40849, 62725, 11694, 2618, 42180, 49940, 50891, 42180, 6004, 27303, 16138}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                byte b = getAuthRequestContext[25];
                Object[] objArr2 = new Object[1];
                e(b, (byte) (b | TarHeader.LF_BLK), getAuthRequestContext[25], objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                e((byte) (-getAuthRequestContext[5]), getAuthRequestContext[25], getAuthRequestContext[27], new Object[1]);
                Object[] objArr3 = new Object[1];
                d(((ApplicationInfo) cls2.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 15, new char[]{62517, 27856, 1925, 43540, 23350, 26125, 61296, 519, 1582, 18625, 8998, 16274, 5925, 36327, 10560, 40849, 19332, 25311}, objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - ExpandableListView.getPackedPositionChild(0L), (ViewConfiguration.getWindowTouchSlop() >> 8) + 35, (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 19 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (Process.myTid() >> 22))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        NoDoubleClickUtils.initLastClickTime();
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        unregisterReceiver(this.receiver);
        super.onDestroy();
    }

    private void initViewFromData() {
        if (!TextUtils.isEmpty(this.pageTitle)) {
            this.tv_title.setVisibility(0);
            this.tv_title.setText(this.pageTitle);
        }
        if (!TextUtils.isEmpty(this.setUpText)) {
            this.tv_center.setVisibility(0);
            this.tv_center.setText(this.setUpText);
        }
        if (!TextUtils.isEmpty(this.protocolTip)) {
            this.tv_link_before.setVisibility(0);
            this.tv_link_before.setText(this.protocolTip);
        }
        if (!TextUtils.isEmpty(this.protocolText)) {
            this.tv_link.setVisibility(0);
            this.tv_link.setText(this.protocolText);
        }
        if (!TextUtils.isEmpty(this.button1Text)) {
            this.tv_bnt1.setVisibility(0);
            this.tv_bnt1.setText(this.button1Text);
        }
        if (!TextUtils.isEmpty(this.button2Text)) {
            this.tv_bnt2.setVisibility(0);
            this.tv_bnt2.setText(this.button2Text);
        }
        this.tv_bnt1.setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.verifyidentity.business.security.activity.SecurityPrepareActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NoDoubleClickUtils.isDoubleClick()) {
                    return;
                }
                SecurityPrepareActivity.this.isClickSetUp = true;
                SecurityPrepareActivity securityPrepareActivity = SecurityPrepareActivity.this;
                securityPrepareActivity.getSetupData(securityPrepareActivity.button1Action);
            }
        });
        this.tv_bnt2.setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.verifyidentity.business.security.activity.SecurityPrepareActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NoDoubleClickUtils.isDoubleClick()) {
                    return;
                }
                SecurityPrepareActivity.this.isClickSetUp = false;
                SecurityPrepareActivity securityPrepareActivity = SecurityPrepareActivity.this;
                securityPrepareActivity.getSetupData(securityPrepareActivity.button2Action);
            }
        });
        findViewById(com.alipay.mobile.verifyidentity.business.security.R.id.tv_link).setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.verifyidentity.business.security.activity.SecurityPrepareActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnClickUrl onClickUrl = VIEngine.getOnClickUrl();
                if (onClickUrl != null) {
                    SecurityPrepareActivity securityPrepareActivity = SecurityPrepareActivity.this;
                    onClickUrl.onClickHttpUrl(securityPrepareActivity, securityPrepareActivity.protocolUrl);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getSetupData(final String str) {
        IAPAsyncTask.asyncTask(new IAPAsyncTask.Runner<MICRpcResponse>() { // from class: com.alipay.mobile.verifyidentity.business.security.activity.SecurityPrepareActivity.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alipay.iap.android.common.task.async.IAPAsyncTask.Runner
            public MICRpcResponse execute() throws Exception {
                SecurityPrepareActivity.this.showSubmittingDialog();
                MICRpcRequest mICRpcRequest = new MICRpcRequest();
                mICRpcRequest.action = str;
                mICRpcRequest.module = SecurityPrepareActivity.this.nextStep;
                mICRpcRequest.envData = new JSONObject(VIEngineUtils.getEnvData(SecurityPrepareActivity.this)).toString();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("sceneId", SecurityPrepareActivity.this.sceneId);
                jSONObject.put("userId", SecurityPrepareActivity.this.userId);
                jSONObject.put(RequestConstants.SecVIKeyTntInstId, SecurityPrepareActivity.this.tntInstId);
                jSONObject.put("productType", SecurityPrepareActivity.this.productType);
                mICRpcRequest.data = jSONObject.toString();
                mICRpcRequest.prodmngId = SecurityPrepareActivity.this.prodmngId;
                ICRpcService retrieveRpcService = RpcSettings.retrieveRpcService();
                HashMap hashMap = new HashMap();
                hashMap.put("module", mICRpcRequest.module);
                hashMap.put("data", mICRpcRequest.data);
                if (mICRpcRequest.action.equals(RequestConstants.CLOSE_SUBMIT)) {
                    ClientLogKitManager.getClientLogKit().log("event", new String[]{"a5.b3.c2", "0", ""}, hashMap, "", "SecVI_Seed_SecQuestion_CloseRequest", "", "", false);
                } else if (mICRpcRequest.action.equals(RequestConstants.CLOSE_PREPARE)) {
                    ClientLogKitManager.getClientLogKit().log("event", new String[]{"a5.b3.c1", "0", ""}, hashMap, "", "SecVI_Seed_SecQuestion_ClosePreRequest", "", "", false);
                } else if (mICRpcRequest.action.equals(RequestConstants.REGISTER_BIO_PREPARE)) {
                    ClientLogKitManager.getClientLogKit().log("event", new String[]{"a5.b2.c1", "0", ""}, hashMap, "", "SecVI_Seed_SecQuestion_OpenPreRequest", "", "", false);
                } else if (mICRpcRequest.action.equals(RequestConstants.UPDATE_PREPARE)) {
                    ClientLogKitManager.getClientLogKit().log("event", new String[]{"a5.b4.c1", "0", ""}, hashMap, "", "SecVI_Seed_SecQuestion_ResetPreRequest", "", "", false);
                }
                try {
                    return retrieveRpcService.dispatch(mICRpcRequest);
                } catch (Throwable unused) {
                    return null;
                }
            }

            @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
            public void onSuccess(MICRpcResponse mICRpcResponse) {
                SecurityPrepareActivity.this.hideSubmittingDialog();
                if (mICRpcResponse != null) {
                    SecurityPrepareActivity.this.requestResult = mICRpcResponse;
                    if (!mICRpcResponse.success) {
                        if (mICRpcResponse.sysErrCode.equalsIgnoreCase("user_status_error") || mICRpcResponse.sysErrCode.equalsIgnoreCase("bussiness_fail") || mICRpcResponse.sysErrCode.equalsIgnoreCase("unkown_action_fail") || mICRpcResponse.sysErrCode.equalsIgnoreCase("VERIFY_INIT_NO_VALID_PRODUCT")) {
                            final CommonDialog commonDialog = new CommonDialog(SecurityPrepareActivity.this, true, null);
                            commonDialog.setMessage(mICRpcResponse.sysErrMsg);
                            commonDialog.setModalInterface(new ModalInterface() { // from class: com.alipay.mobile.verifyidentity.business.security.activity.SecurityPrepareActivity.5.1
                                @Override // com.alipay.mobile.verifyidentity.uitools.dialog.ModalInterface
                                public void onCancel() {
                                }

                                @Override // com.alipay.mobile.verifyidentity.uitools.dialog.ModalInterface
                                public void onOk() {
                                    CommonDialog commonDialog2 = commonDialog;
                                    if (commonDialog2 != null) {
                                        commonDialog2.dismiss();
                                    }
                                    SecurityPrepareActivity.this.finish();
                                }
                            });
                            SecurityPrepareActivity securityPrepareActivity = SecurityPrepareActivity.this;
                            if (securityPrepareActivity == null || securityPrepareActivity.isFinishing()) {
                                return;
                            }
                            commonDialog.show();
                            return;
                        } else if (mICRpcResponse.sysErrCode.equals(SecurityConstants.KEY_OUT_TIME_CODE1) || mICRpcResponse.sysErrCode.equals("204")) {
                            SecurityPrepareActivity securityPrepareActivity2 = SecurityPrepareActivity.this;
                            if (securityPrepareActivity2 != null && !securityPrepareActivity2.isFinishing()) {
                                CustomUi.showCenterToast(SecurityPrepareActivity.this, mICRpcResponse.sysErrMsg);
                            }
                            SecurityPrepareActivity.this.finish();
                            return;
                        } else {
                            SecurityPrepareActivity securityPrepareActivity3 = SecurityPrepareActivity.this;
                            if (securityPrepareActivity3 != null && !securityPrepareActivity3.isFinishing()) {
                                SecurityPrepareActivity securityPrepareActivity4 = SecurityPrepareActivity.this;
                                CustomUi.showCenterToast(securityPrepareActivity4, securityPrepareActivity4.getResources().getString(com.alipay.mobile.verifyidentity.business.security.R.string.Sysytem_error));
                            }
                            if (mICRpcResponse.finish) {
                                SecurityPrepareActivity.this.finish();
                                return;
                            }
                            return;
                        }
                    }
                    if (str.equals(RequestConstants.CLOSE_SUBMIT)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("finishedCode", mICRpcResponse.finishCode);
                        hashMap.put("finishedMsg", mICRpcResponse.finishMessage);
                        hashMap.put("verifyMsg", mICRpcResponse.verifyMessage);
                        ClientLogKitManager.getClientLogKit().log("event", new String[]{"a5.b3.c3", "0", ""}, hashMap, "", "SecVI_Seed_SecQuestion_CloseResult", "", "", false);
                    }
                    if (!mICRpcResponse.finish) {
                        SecurityPrepareActivity.this.parseJsonResult(mICRpcResponse);
                        return;
                    }
                    SecurityPrepareActivity securityPrepareActivity5 = SecurityPrepareActivity.this;
                    CustomUi.showTipToast(securityPrepareActivity5, 0, securityPrepareActivity5.getResources().getString(com.alipay.mobile.verifyidentity.business.security.R.string.set_success));
                    SecurityPrepareActivity.this.finish();
                    return;
                }
                SecurityPrepareActivity securityPrepareActivity6 = SecurityPrepareActivity.this;
                CustomUi.showCenterToast(securityPrepareActivity6, securityPrepareActivity6.getResources().getString(com.alipay.mobile.verifyidentity.business.security.R.string.system_busy_error));
            }

            @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
            public void onFailure(IAPError iAPError) {
                SecurityPrepareActivity.this.hideSubmittingDialog();
                SecurityPrepareActivity securityPrepareActivity = SecurityPrepareActivity.this;
                CustomUi.showCenterToast(securityPrepareActivity, securityPrepareActivity.getResources().getString(com.alipay.mobile.verifyidentity.business.security.R.string.Sysytem_error));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseJsonResult(final MICRpcResponse mICRpcResponse) {
        try {
            String string = new JSONObject(mICRpcResponse.data).getString("verifyId");
            this.verifyId = string;
            if (!TextUtils.isEmpty(string)) {
                HashMap hashMap = new HashMap();
                hashMap.put("verifyType", "1");
                hashMap.put("verifyId", this.verifyId);
                VIEngine.startVerify(this, RequestConstants.VerifyProductVerify, hashMap, null, new VIEngine.VIListener() { // from class: com.alipay.mobile.verifyidentity.business.security.activity.SecurityPrepareActivity.6
                    @Override // com.alipay.mobile.verifyidentity.framework.engine.VIEngine.VIListener
                    public void onVerifyAction(VIAction vIAction) {
                    }

                    @Override // com.alipay.mobile.verifyidentity.framework.engine.VIEngine.VIListener
                    public void onVerifyResult(VIResult vIResult) {
                        if (vIResult == null || vIResult.getResult() != 1000) {
                            return;
                        }
                        if (SecurityPrepareActivity.this.isClickSetUp) {
                            SecurityPrepareActivity.this.gotoSetquestionPage(mICRpcResponse);
                        } else {
                            SecurityPrepareActivity.this.getSetupData(mICRpcResponse.nextAction);
                        }
                    }
                }, null);
            } else if (this.isClickSetUp) {
                gotoSetquestionPage(mICRpcResponse);
            } else {
                getSetupData(mICRpcResponse.nextAction);
            }
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoSetquestionPage(MICRpcResponse mICRpcResponse) {
        Message convertToMessage = mICRpcResponse.convertToMessage();
        convertToMessage.setSceneId(this.sceneId);
        convertToMessage.setUserId(this.userId);
        convertToMessage.setTntInstId(this.tntInstId);
        convertToMessage.setProdmngId(mICRpcResponse.prodmngId);
        convertToMessage.setProductType(this.productType);
        Intent intent = new Intent(this, SetSecurityActivity.class);
        intent.putExtra("message", convertToMessage);
        startActivity(intent);
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
                cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i2) ^ ((cArr3[0] << 4) + ((char) (moveToNextValue ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (lookAheadTest ^ 6353485791441662354L)))));
                cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i2) ^ ((cArr3[1] << 4) + ((char) (PlaceComponentResult ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (getErrorConfigVersion ^ 6353485791441662354L)))));
                i2 -= 40503;
            }
            cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
            cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
            c.BuiltInFictitiousFunctionClassFactory += 2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}
