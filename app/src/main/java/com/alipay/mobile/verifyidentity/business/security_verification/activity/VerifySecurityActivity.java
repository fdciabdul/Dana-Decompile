package com.alipay.mobile.verifyidentity.business.security_verification.activity;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
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
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.errorcode.IAPError;
import com.alipay.iap.android.common.task.async.IAPAsyncTask;
import com.alipay.mobile.verifyidentity.RpcSettings;
import com.alipay.mobile.verifyidentity.base.message.Message;
import com.alipay.mobile.verifyidentity.base.message.RequestConstants;
import com.alipay.mobile.verifyidentity.base.message.VIRespone;
import com.alipay.mobile.verifyidentity.base.product.IProduct;
import com.alipay.mobile.verifyidentity.business.activity.ActivityInterface;
import com.alipay.mobile.verifyidentity.business.activity.ActivityInterfaceManager;
import com.alipay.mobile.verifyidentity.business.activity.ClientLogKitManager;
import com.alipay.mobile.verifyidentity.business.activity.HandlerCallback;
import com.alipay.mobile.verifyidentity.business.activity.ProductActivity;
import com.alipay.mobile.verifyidentity.business.security_verification.activity.VerifySecurityFragment;
import com.alipay.mobile.verifyidentity.business.security_verification.product.SecurityVerifyModule;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.QuestionItem;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.alipay.mobile.verifyidentity.framework.engine.VIEngineUtils;
import com.alipay.mobile.verifyidentity.framework.engine.VIResult;
import com.alipay.mobile.verifyidentity.uitools.ColorUtils;
import com.alipay.mobile.verifyidentity.uitools.CustomUi;
import com.alipay.mobile.verifyidentity.uitools.POPUIType;
import com.alipay.mobile.verifyidentity.uitools.dialog.ModalInterface;
import com.alipay.mobileiclib.common.service.facade.solution.dto.MICRpcRequest;
import com.alipay.mobileiclib.common.service.facade.solution.dto.MICRpcResponse;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.whenAvailable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class VerifySecurityActivity extends ProductActivity {
    private static final int CLOSE_ACTIVITY = 2001;
    private static IProduct.ICallback iCallback;
    private static SecurityVerifyModule virifySecurityProduct;
    private String button1Action;
    private String button1Text;
    private FrameLayout container;
    private String foot_tip;
    private String from_title;
    private boolean has_other;
    private Intent mIntent;
    private Message message;
    private String nextAction;
    private String nextStep;
    private int pageSize;
    private String pageTitle;
    private String prodmngId;
    private String productType;
    private View rl_title;
    private String sceneId;
    private int selectindex;
    private String tntInstId;
    private TextView tvVerification;
    private String userId;
    private String verifyId;
    public static final byte[] $$g = {4, -41, 37, 5, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$h = 197;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {16, -117, -56, -112, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int NetworkUserEntityData$$ExternalSyntheticLambda0 = 172;
    private static char[] getErrorConfigVersion = {62255, 49787, 37276, 26413, 13901, 1504, 56072, 43549, 31225, 20238, 7918, 60919, 41848, 29374, 16855, 6014, 59021, 46134, 62243, 49772, 37293, 26422, 13894, 62255, 49787, 37276, 26413, 13901, 1504, 56072, 43549, 31223, 20237, 7856, 60809, 41803, 29362, 16832, 6002, 59016, 46124, 35676, 23286, 10246, 65361, 52974, 39942, 21415, 8905, 62253, 49760, 37258, 26413, 13895, 1511, 56088, 43634, 31206, 20237, 7852, 60878, 41833, 29360, 16832, 6002, 59025, 46123, 51340, 63875, 43579, 23698, 3559, 15896, 57504, 37374, 16980, 29933, 9558, 54836, 39066, 18710, 31344, 11480, 56634, 36737, 45291, 24859, 5059, 50351, 62730, 42912, 26711, 6507, 52157, 64582, 44413, 24464, 'p', 13019, 58338, 37942, 18079, 30707, 14353, 60069, 39681, 19542, 32436, 12110, 53345, 33476, 45949, 25719, 5847, 51051, 62255, 49696, 37326, 26427, 13892, 1456, 56156, 43531, 31218, 20254, 7929, 60818, 41838, 29408, 16773, 5935, 59084, 46199, 35662, 23230, 10294, 65288, 52906, 40016, 21488, 8911, 61513, 51122, 38530, 25701, 15318, 2425, 55373, 44945, 32108, 19463, 993, 53514, 41212, 30624, 17731, 5357, 60357, 47414, 34953, 24454, 11557, 64716, 45677, 33046, 20671, 9814, 62731, 50350, 39500, 27122, 14486, 3644, 56755, 44245, 25131, 12761, 1824, 54808, 54680, 58560, 46969, 16857, 4351, 9050, 64954, 36067, 24394, 27041, 14364, 52082, 34271, 21510, 26464, 12744, 49275, 37572, 44536, 31759, 3716, 55743, 59417, 47796, 29973, 1071, 54957, 57611, 45112, 17027, 7479, 12236, 65277, 35189, 23438, 27363, 9476, 63418, 34334, 20815, 25514, 12895, 52597, 40919, 44598, 31077, 2961, 55933, 38108, 43000, 30223, 238, 54244, 57932, 48382, 20242, 7797, 10460, 64269, 35429, 17560, 5936, 8597, 61686, 62246, 49761, 37260, 26415, 13905, 1459, 56131, 43548, 31218, 20252, 7854, 60870, 41764, 29349, 16860, 5993, 59035, 46116, 35676, 23276, 10291, 65354, 52968, 40013, 21409, 8920, 61457, 51109, 38622, 25714, 15253, 2366, 55375, 44935, 32061, 19473, 993, 53510, 41121, 30652, 17687, 5293, 60361, 47400, 34947, 24543, 11635, 64670, 45613, 33105, 20647, 9753, 62720, 50358, 39449, 27061, 14531, 3683, 56740, 44228, 62327, 49723, 37324, 26481, 13840, 1464};
    private static long lookAheadTest = -9066053001706290667L;
    private ArrayList<ArrayList<List<QuestionItem>>> adapterList = new ArrayList<>();
    private QuestionItem[] questionItemArr = new QuestionItem[0];
    private String[] answerId = new String[0];
    private List<Fragment> mFragments = new ArrayList();

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void g(int r7, short r8, int r9, java.lang.Object[] r10) {
        /*
            int r8 = 56 - r8
            byte[] r0 = com.alipay.mobile.verifyidentity.business.security_verification.activity.VerifySecurityActivity.BuiltInFictitiousFunctionClassFactory
            int r9 = r9 + 97
            int r7 = r7 + 16
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            goto L2d
        L14:
            r3 = 0
        L15:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r7) goto L24
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L24:
            r3 = r0[r8]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L2d:
            int r8 = -r8
            int r10 = r10 + r8
            int r8 = r10 + (-4)
            int r9 = r9 + 1
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r9
            r9 = r8
            r8 = r6
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.verifyidentity.business.security_verification.activity.VerifySecurityActivity.g(int, short, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void i(short r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 3
            int r8 = 42 - r8
            int r6 = r6 + 4
            int r7 = r7 * 2
            int r7 = r7 + 75
            byte[] r0 = com.alipay.mobile.verifyidentity.business.security_verification.activity.VerifySecurityActivity.$$g
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
            goto L38
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r7
            int r6 = r6 + 1
            r1[r3] = r4
            if (r3 != r8) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L38:
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
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.verifyidentity.business.security_verification.activity.VerifySecurityActivity.i(short, short, short, java.lang.Object[]):void");
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.ProductActivity, com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        h(Color.green(0), (char) (ViewConfiguration.getWindowTouchSlop() >> 8), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 18, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        h(18 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) TextUtils.indexOf("", "", 0, 0), 4 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatDelay() >> 16), Color.blue(0) + 35, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    h((Process.myPid() >> 22) + 67, (char) (15349 - (ViewConfiguration.getFadingEdgeLength() >> 16)), 49 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    h(116 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) TextUtils.getOffsetBefore("", 0), 65 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    h((ViewConfiguration.getEdgeSlop() >> 16) + 179, (char) (9957 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), (-16777152) - Color.rgb(0, 0, 0), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    h(243 - KeyEvent.getDeadChar(0, 0), (char) (ViewConfiguration.getTouchSlop() >> 8), TextUtils.getOffsetBefore("", 0) + 60, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    h(303 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (MotionEvent.axisFromString("") + 1), View.getDefaultSize(0, 0) + 6, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Gravity.getAbsoluteGravity(0, 0), 18 - View.resolveSizeAndState(0, 0, 0), (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                g(BuiltInFictitiousFunctionClassFactory[25], (byte) (-BuiltInFictitiousFunctionClassFactory[31]), (byte) (-BuiltInFictitiousFunctionClassFactory[32]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = BuiltInFictitiousFunctionClassFactory[25];
                byte b2 = (byte) (b | Ascii.RS);
                Object[] objArr14 = new Object[1];
                g(b, b2, (byte) (b2 & 40), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 55, 3 - Color.red(0), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)));
                        Object[] objArr16 = new Object[1];
                        i($$g[78], $$g[47], $$g[68], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - KeyEvent.keyCodeFromString(""), 14 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - Color.alpha(0), AndroidCharacter.getMirror('0') - '!', (char) KeyEvent.getDeadChar(0, 0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + 815, 29 - KeyEvent.keyCodeFromString(""), (char) (57995 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 800, 15 - ((Process.getThreadPriority(0) + 20) >> 6), (char) ExpandableListView.getPackedPositionGroup(0L)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - KeyEvent.getDeadChar(0, 0), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-1795361728, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myTid() >> 22) + 911, KeyEvent.keyCodeFromString("") + 18, (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                g(BuiltInFictitiousFunctionClassFactory[25], (byte) (-BuiltInFictitiousFunctionClassFactory[31]), (byte) (-BuiltInFictitiousFunctionClassFactory[32]), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b3 = BuiltInFictitiousFunctionClassFactory[25];
                byte b4 = (byte) (b3 | Ascii.RS);
                Object[] objArr20 = new Object[1];
                g(b3, b4, (byte) (b4 & 40), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + 61, TextUtils.lastIndexOf("", '0', 0) + 47, (char) View.MeasureSpec.getMode(0));
                        Object[] objArr22 = new Object[1];
                        i((byte) (-$$g[28]), (byte) (-$$g[9]), (byte) (-$$g[8]), objArr22);
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
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.blue(0), TextUtils.lastIndexOf("", '0') + 36, (char) KeyEvent.keyCodeFromString(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-1795361728, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), TextUtils.lastIndexOf("", '0') + 19, (char) Color.alpha(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                g(BuiltInFictitiousFunctionClassFactory[25], (byte) (-BuiltInFictitiousFunctionClassFactory[31]), (byte) (-BuiltInFictitiousFunctionClassFactory[32]), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b5 = BuiltInFictitiousFunctionClassFactory[25];
                byte b6 = (byte) (b5 | Ascii.RS);
                Object[] objArr26 = new Object[1];
                g(b5, b6, (byte) (b6 & 40), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - TextUtils.indexOf("", "", 0, 0), 2 - ImageFormat.getBitsPerPixel(0), (char) (38968 - View.resolveSizeAndState(0, 0, 0)));
                        Object[] objArr28 = new Object[1];
                        i((byte) (-$$g[28]), (byte) (-$$g[9]), (byte) (-$$g[8]), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.combineMeasuredStates(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-1795361728, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getTapTimeout() >> 16), Color.argb(0, 0, 0, 0) + 18, (char) TextUtils.indexOf("", "", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                g(BuiltInFictitiousFunctionClassFactory[25], (byte) (-BuiltInFictitiousFunctionClassFactory[31]), (byte) (-BuiltInFictitiousFunctionClassFactory[32]), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b7 = BuiltInFictitiousFunctionClassFactory[25];
                byte b8 = (byte) (b7 | Ascii.RS);
                Object[] objArr32 = new Object[1];
                g(b7, b8, (byte) (b8 & 40), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - TextUtils.getOffsetAfter("", 0), 3 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) ((-1) - Process.getGidForName("")));
                        byte b9 = $$g[40];
                        byte b10 = (byte) ($$g[47] - 1);
                        Object[] objArr34 = new Object[1];
                        i(b9, b10, b10, objArr34);
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
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + PDF417Common.NUMBER_OF_CODEWORDS, 35 - View.combineMeasuredStates(0, 0), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-1795361728, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + 912, (Process.myPid() >> 22) + 18, (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            h(24 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (getPackageName().length() - 7), 26 - (ViewConfiguration.getScrollBarSize() >> 8), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            h(super.getResources().getString(R.string.com_mixpanel_android_notification_image).substring(0, 5).length() + 44, (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1), super.getResources().getString(R.string.insurance_button_title).substring(1, 3).codePointAt(0) - 79, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0, 0) + 930, 35 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (AndroidCharacter.getMirror('0') - '0'))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + 911, 18 - Color.blue(0), (char) View.MeasureSpec.getMode(0))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // com.alipay.mobile.verifyidentity.business.activity.ProductActivity, com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            int codePointAt = super.getResources().getString(R.string.set_success).substring(1, 2).codePointAt(0) - 78;
            try {
                Object[] objArr = new Object[1];
                g(BuiltInFictitiousFunctionClassFactory[30], (byte) (BuiltInFictitiousFunctionClassFactory[49] - 1), BuiltInFictitiousFunctionClassFactory[25], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                g(BuiltInFictitiousFunctionClassFactory[8], BuiltInFictitiousFunctionClassFactory[25], BuiltInFictitiousFunctionClassFactory[5], new Object[1]);
                Object[] objArr2 = new Object[1];
                h(codePointAt, (char) (((ApplicationInfo) cls.getMethod((String) r2[0], null).invoke(this, null)).targetSdkVersion - 33), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 26, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                try {
                    Object[] objArr3 = new Object[1];
                    g(BuiltInFictitiousFunctionClassFactory[30], (byte) (BuiltInFictitiousFunctionClassFactory[49] - 1), BuiltInFictitiousFunctionClassFactory[25], objArr3);
                    Class<?> cls3 = Class.forName((String) objArr3[0]);
                    Object[] objArr4 = new Object[1];
                    g(BuiltInFictitiousFunctionClassFactory[8], BuiltInFictitiousFunctionClassFactory[25], BuiltInFictitiousFunctionClassFactory[5], objArr4);
                    Object[] objArr5 = new Object[1];
                    h(((ApplicationInfo) cls3.getMethod((String) objArr4[0], null).invoke(this, null)).targetSdkVersion + 16, (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1), super.getResources().getString(R.string.zakat_button_title).substring(1, 3).length() + 16, objArr5);
                    baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 36, (char) TextUtils.indexOf("", "", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr6 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.keyCodeFromString(""), 18 - TextUtils.indexOf("", "", 0, 0), (char) (ExpandableListView.getPackedPositionChild(0L) + 1))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr6);
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
        super.onResume();
    }

    public static IProduct.ICallback getCallback() {
        return iCallback;
    }

    public static void setCallback(IProduct.ICallback iCallback2) {
        iCallback = iCallback2;
    }

    public static void setPinProduct(SecurityVerifyModule securityVerifyModule) {
        virifySecurityProduct = securityVerifyModule;
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.ProductActivity, com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        try {
            Object[] objArr2 = new Object[1];
            g(BuiltInFictitiousFunctionClassFactory[30], (byte) (BuiltInFictitiousFunctionClassFactory[49] - 1), BuiltInFictitiousFunctionClassFactory[25], objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            g(BuiltInFictitiousFunctionClassFactory[8], BuiltInFictitiousFunctionClassFactory[25], BuiltInFictitiousFunctionClassFactory[5], objArr3);
            int i = ((ApplicationInfo) cls.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion - 33;
            char packedPositionChild = (char) (ExpandableListView.getPackedPositionChild(0L) + 1);
            try {
                Object[] objArr4 = new Object[1];
                g(BuiltInFictitiousFunctionClassFactory[30], (byte) (BuiltInFictitiousFunctionClassFactory[49] - 1), BuiltInFictitiousFunctionClassFactory[25], objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                g(BuiltInFictitiousFunctionClassFactory[8], BuiltInFictitiousFunctionClassFactory[25], BuiltInFictitiousFunctionClassFactory[5], new Object[1]);
                Object[] objArr5 = new Object[1];
                h(i, packedPositionChild, ((ApplicationInfo) cls2.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 15, objArr5);
                Class<?> cls3 = Class.forName((String) objArr5[0]);
                int i2 = 19 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                try {
                    Object[] objArr6 = new Object[1];
                    g(BuiltInFictitiousFunctionClassFactory[30], (byte) (BuiltInFictitiousFunctionClassFactory[49] - 1), BuiltInFictitiousFunctionClassFactory[25], objArr6);
                    Class<?> cls4 = Class.forName((String) objArr6[0]);
                    g(BuiltInFictitiousFunctionClassFactory[8], BuiltInFictitiousFunctionClassFactory[25], BuiltInFictitiousFunctionClassFactory[5], new Object[1]);
                    Object[] objArr7 = new Object[1];
                    h(i2, (char) (((ApplicationInfo) cls4.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 33), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 4, objArr7);
                    int intValue = ((Integer) cls3.getDeclaredMethod((String) objArr7[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                    if (intValue < 99000 || intValue > 99999) {
                        Context baseContext = getBaseContext();
                        if (baseContext == null) {
                            Object[] objArr8 = new Object[1];
                            h(Process.getGidForName("") + 24, (char) (super.getResources().getString(R.string.voucher_asset_empty_title).substring(5, 6).length() - 1), (ViewConfiguration.getTouchSlop() >> 8) + 26, objArr8);
                            Class<?> cls5 = Class.forName((String) objArr8[0]);
                            int length = getPackageName().length() + 42;
                            try {
                                Object[] objArr9 = new Object[1];
                                g(BuiltInFictitiousFunctionClassFactory[30], (byte) (BuiltInFictitiousFunctionClassFactory[49] - 1), BuiltInFictitiousFunctionClassFactory[25], objArr9);
                                Class<?> cls6 = Class.forName((String) objArr9[0]);
                                g(BuiltInFictitiousFunctionClassFactory[8], BuiltInFictitiousFunctionClassFactory[25], BuiltInFictitiousFunctionClassFactory[5], new Object[1]);
                                Object[] objArr10 = new Object[1];
                                h(length, (char) (((ApplicationInfo) cls6.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 33), TextUtils.lastIndexOf("", '0', 0, 0) + 19, objArr10);
                                baseContext = (Context) cls5.getMethod((String) objArr10[0], new Class[0]).invoke(null, null);
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
                                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), Color.argb(0, 0, 0, 0) + 35, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                                }
                                Object invoke = ((Method) obj).invoke(null, null);
                                Object[] objArr11 = new Object[1];
                                h(super.getResources().getString(R.string.card_binding_camera_helper).substring(0, 5).codePointAt(1) - 32, (char) (super.getResources().getString(R.string.send_money_text_under_maintenance).substring(13, 15).codePointAt(0) + 15252), (ViewConfiguration.getTapTimeout() >> 16) + 48, objArr11);
                                String str = (String) objArr11[0];
                                int length2 = super.getResources().getString(R.string.dana_viz_prompt_dialog_success_verification_subtitle).substring(0, 9).length() + 106;
                                try {
                                    Object[] objArr12 = new Object[1];
                                    g(BuiltInFictitiousFunctionClassFactory[30], (byte) (BuiltInFictitiousFunctionClassFactory[49] - 1), BuiltInFictitiousFunctionClassFactory[25], objArr12);
                                    Class<?> cls7 = Class.forName((String) objArr12[0]);
                                    g(BuiltInFictitiousFunctionClassFactory[8], BuiltInFictitiousFunctionClassFactory[25], BuiltInFictitiousFunctionClassFactory[5], new Object[1]);
                                    Object[] objArr13 = new Object[1];
                                    h(length2, (char) (((ApplicationInfo) cls7.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 33), 64 - TextUtils.getCapsMode("", 0, 0), objArr13);
                                    String str2 = (String) objArr13[0];
                                    try {
                                        Object[] objArr14 = new Object[1];
                                        g(BuiltInFictitiousFunctionClassFactory[30], (byte) (BuiltInFictitiousFunctionClassFactory[49] - 1), BuiltInFictitiousFunctionClassFactory[25], objArr14);
                                        Class<?> cls8 = Class.forName((String) objArr14[0]);
                                        Object[] objArr15 = new Object[1];
                                        g(BuiltInFictitiousFunctionClassFactory[8], BuiltInFictitiousFunctionClassFactory[25], BuiltInFictitiousFunctionClassFactory[5], objArr15);
                                        Object[] objArr16 = new Object[1];
                                        h(((ApplicationInfo) cls8.getMethod((String) objArr15[0], null).invoke(this, null)).targetSdkVersion + 146, (char) (getPackageName().length() + 9949), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 64, objArr16);
                                        String str3 = (String) objArr16[0];
                                        Object[] objArr17 = new Object[1];
                                        h(super.getResources().getString(R.string.empty_state_loyalty_desc_v3).substring(0, 1).codePointAt(0) + 159, (char) (getPackageName().codePointAt(2) - 46), 61 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), objArr17);
                                        String str4 = (String) objArr17[0];
                                        Object[] objArr18 = new Object[1];
                                        h((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 303, (char) View.MeasureSpec.makeMeasureSpec(0, 0), super.getResources().getString(R.string.modify_group_photo_bottomsheet_description).substring(10, 11).codePointAt(0) + BranchLinkConstant.DeepLinkErrorCode.SAME_ALIAS, objArr18);
                                        try {
                                            Object[] objArr19 = {baseContext, str, str2, str3, str4, true, (String) objArr18[0], 995651014};
                                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                            if (obj2 == null) {
                                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 912, TextUtils.lastIndexOf("", '0', 0, 0) + 19, (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                            }
                                            ((Method) obj2).invoke(invoke, objArr19);
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
                        Object[] objArr20 = new Object[1];
                        g(BuiltInFictitiousFunctionClassFactory[25], (byte) (-BuiltInFictitiousFunctionClassFactory[31]), (byte) (-BuiltInFictitiousFunctionClassFactory[32]), objArr20);
                        Class<?> cls9 = Class.forName((String) objArr20[0]);
                        byte b = BuiltInFictitiousFunctionClassFactory[25];
                        byte b2 = (byte) (b | Ascii.RS);
                        Object[] objArr21 = new Object[1];
                        g(b, b2, (byte) (b2 & 40), objArr21);
                        try {
                            Object[] objArr22 = {Integer.valueOf(((Integer) cls9.getMethod((String) objArr21[0], Object.class).invoke(null, this)).intValue())};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                            if (obj3 == null) {
                                Class cls10 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + 494, 4 - KeyEvent.normalizeMetaState(0), (char) Color.alpha(0));
                                byte b3 = $$g[40];
                                byte b4 = (byte) ($$g[47] - 1);
                                Object[] objArr23 = new Object[1];
                                i(b3, b4, b4, objArr23);
                                obj3 = cls10.getMethod((String) objArr23[0], Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                            }
                            Object[] objArr24 = (Object[]) ((Method) obj3).invoke(null, objArr22);
                            int i3 = ((int[]) objArr24[1])[0];
                            if (((int[]) objArr24[0])[0] != i3) {
                                long j = ((r2 ^ i3) & 4294967295L) | 42949672960L;
                                try {
                                    Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                    if (obj4 != null) {
                                        objArr = null;
                                    } else {
                                        objArr = null;
                                        obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) TextUtils.indexOf("", "", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                    }
                                    Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                                    try {
                                        Object[] objArr25 = {117944609, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                        Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                        if (obj5 == null) {
                                            obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getTrimmedLength("") + 911, Color.rgb(0, 0, 0) + 16777234, (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                        }
                                        ((Method) obj5).invoke(invoke2, objArr25);
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
                            super.onCreate(bundle);
                            setContentView(com.alipay.mobile.verifyidentity.business.security_verification.R.layout.activity_verifu_security);
                            this.mIntent = getIntent();
                            initView();
                            initData();
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
        } catch (Throwable th12) {
            Throwable cause12 = th12.getCause();
            if (cause12 == null) {
                throw th12;
            }
            throw cause12;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.questionItemArr = new QuestionItem[0];
        this.answerId = new String[0];
        if (intent != null) {
            this.mIntent = intent;
        }
        initData();
    }

    private void initView() {
        this.container = (FrameLayout) findViewById(com.alipay.mobile.verifyidentity.business.security_verification.R.id.container);
        this.tvVerification = (TextView) findViewById(com.alipay.mobile.verifyidentity.business.security_verification.R.id.tv_title);
        this.rl_title = findViewById(com.alipay.mobile.verifyidentity.business.security_verification.R.id.rl_title);
        if (CustomUi.getTitleTypeface() != null) {
            this.tvVerification.setTypeface(CustomUi.getTitleTypeface());
        }
        findViewById(com.alipay.mobile.verifyidentity.business.security_verification.R.id.ll_back).setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.verifyidentity.business.security_verification.activity.VerifySecurityActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VerifySecurityActivity.this.doCancel();
                VerifySecurityActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAlertDialog(String str, final MICRpcResponse mICRpcResponse) {
        if (isFinishing()) {
            return;
        }
        InstrumentInjector.log_d("CustomUi", "  showAlertDialog ");
        CustomUi.showCommonDialog(this, "", str, 1001, false, new ModalInterface() { // from class: com.alipay.mobile.verifyidentity.business.security_verification.activity.VerifySecurityActivity.2
            @Override // com.alipay.mobile.verifyidentity.uitools.dialog.ModalInterface
            public void onCancel() {
            }

            @Override // com.alipay.mobile.verifyidentity.uitools.dialog.ModalInterface
            public void onOk() {
                InstrumentInjector.log_d("CustomUi", "  showAlertDialog   onOk");
                VIRespone vIRespone = new VIRespone(1001);
                MICRpcResponse mICRpcResponse2 = mICRpcResponse;
                if (mICRpcResponse2 != null) {
                    vIRespone.setResponseMessage(mICRpcResponse2.convertToMessage());
                }
                vIRespone.setMessage(VerifySecurityActivity.this.message);
                vIRespone.setVerifyId(VerifySecurityActivity.this.verifyId);
                if (VerifySecurityActivity.getCallback() != null) {
                    VerifySecurityActivity.getCallback().onResult(VerifySecurityActivity.virifySecurityProduct, vIRespone);
                }
                if (TextUtils.isEmpty(mICRpcResponse.nextStep) || VerifySecurityActivity.this.nextStep.equalsIgnoreCase(mICRpcResponse.nextStep)) {
                    VerifySecurityActivity.this.finish();
                    VerifySecurityActivity.this.resetCallback();
                }
            }
        });
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.BaseActivity
    public void initData() {
        Intent intent = this.mIntent;
        if (intent == null) {
            return;
        }
        Message message = (Message) intent.getSerializableExtra("message");
        this.message = message;
        if (message != null) {
            this.nextStep = message.getNextStep();
            this.prodmngId = this.message.getProdmngId();
            this.nextAction = this.message.getNextAction();
            this.sceneId = this.message.getSceneId();
            this.userId = this.message.getUserId();
            this.tntInstId = this.message.getTntInstId();
            this.productType = this.message.getProductType();
            this.verifyId = this.message.getVerifyId();
            try {
                JSONObject jSONObject = new JSONObject(this.message.getData());
                this.pageTitle = jSONObject.optString("head_title");
                this.button1Text = jSONObject.optString(SecurityConstants.KEY_FROM_BUTTON);
                this.from_title = jSONObject.optString("form_title");
                this.foot_tip = jSONObject.optString("foot_tip");
                this.has_other = jSONObject.optBoolean("HAS_OTHERS");
                String optString = optString(jSONObject, SecurityConstants.KEY_DEFAULT_SELETED_INDEX);
                if (TextUtils.isEmpty(optString)) {
                    optString = "0";
                }
                this.selectindex = Integer.parseInt(optString);
                JSONObject jSONObject2 = new JSONObject(jSONObject.optString(SecurityConstants.KEY_QUESTION_JSON));
                JSONArray jSONArray = jSONObject2.getJSONArray(SecurityConstants.KEY_PAGES);
                this.pageSize = jSONObject2.getInt(SecurityConstants.KEY_PAGE_SIZE);
                parseQuestionJson(jSONArray);
            } catch (Exception unused) {
            }
        }
        if (!TextUtils.isEmpty(this.pageTitle)) {
            this.tvVerification.setText(this.pageTitle);
        }
        createViewByData();
        setFragment(0);
        registerHandlerCallback(new HandlerCallback() { // from class: com.alipay.mobile.verifyidentity.business.security_verification.activity.VerifySecurityActivity.3
            @Override // com.alipay.mobile.verifyidentity.business.activity.HandlerCallback
            public void handleMessage(android.os.Message message2) {
                if (message2.what != 2001 || VerifySecurityActivity.this.isFinishing()) {
                    return;
                }
                VerifySecurityActivity.this.finish();
                VerifySecurityActivity.this.resetCallback();
            }
        });
    }

    private void createViewByData() {
        this.mFragments.clear();
        int i = 0;
        while (i < this.adapterList.size()) {
            VerifySecurityFragment verifySecurityFragment = new VerifySecurityFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(SecurityConstants.KEY_SET_SECURITY_BUNDLE, this.adapterList.get(i));
            bundle.putInt(SecurityConstants.KEY_PAGE_SIZE, this.pageSize);
            i++;
            bundle.putInt("pageNum", i);
            bundle.putInt(SecurityConstants.KEY_DEFAULT_SELETED_INDEX, this.selectindex);
            bundle.putString("verifyId", this.verifyId);
            bundle.putBoolean("HAS_OTHERS", this.has_other);
            if (!TextUtils.isEmpty(this.from_title)) {
                bundle.putString("form_title", this.from_title);
            }
            if (!TextUtils.isEmpty(this.foot_tip)) {
                bundle.putString("foot_tip", this.foot_tip);
            }
            verifySecurityFragment.setArguments(bundle);
            verifySecurityFragment.setCommitCallBack(new VerifySecurityFragment.CommitCallBack() { // from class: com.alipay.mobile.verifyidentity.business.security_verification.activity.VerifySecurityActivity.4
                @Override // com.alipay.mobile.verifyidentity.business.security_verification.activity.VerifySecurityFragment.CommitCallBack
                public void commit(String[] strArr, QuestionItem[] questionItemArr, int i2, int i3) {
                    if (i3 != i2) {
                        if (i3 < i2) {
                            VerifySecurityActivity verifySecurityActivity = VerifySecurityActivity.this;
                            verifySecurityActivity.answerId = (String[]) VerifySecurityActivity.concat(verifySecurityActivity.answerId, strArr);
                            VerifySecurityActivity verifySecurityActivity2 = VerifySecurityActivity.this;
                            verifySecurityActivity2.questionItemArr = (QuestionItem[]) VerifySecurityActivity.concat(verifySecurityActivity2.questionItemArr, questionItemArr);
                            VerifySecurityActivity.this.setFragment(i3);
                            return;
                        }
                        return;
                    }
                    if (i3 == 1) {
                        VerifySecurityActivity.this.answerId = strArr;
                        VerifySecurityActivity.this.questionItemArr = questionItemArr;
                    } else {
                        VerifySecurityActivity verifySecurityActivity3 = VerifySecurityActivity.this;
                        verifySecurityActivity3.answerId = (String[]) VerifySecurityActivity.concat(verifySecurityActivity3.answerId, strArr);
                        VerifySecurityActivity verifySecurityActivity4 = VerifySecurityActivity.this;
                        verifySecurityActivity4.questionItemArr = (QuestionItem[]) VerifySecurityActivity.concat(verifySecurityActivity4.questionItemArr, questionItemArr);
                    }
                    VerifySecurityActivity.this.confirm();
                }

                @Override // com.alipay.mobile.verifyidentity.business.security_verification.activity.VerifySecurityFragment.CommitCallBack
                public void onVerifyResult(VIResult vIResult) {
                    VIRespone vIRespone = new VIRespone(vIResult.getResult());
                    vIRespone.setVerifyId(VerifySecurityActivity.this.verifyId);
                    VerifySecurityActivity.this.message.setVerifyMessage(vIResult.getMessage());
                    if (VerifySecurityActivity.getCallback() != null) {
                        VerifySecurityActivity.getCallback().onResult(VerifySecurityActivity.virifySecurityProduct, vIRespone);
                    }
                    VerifySecurityActivity.this.finish();
                    VerifySecurityActivity.this.resetCallback();
                }
            });
            this.mFragments.add(verifySecurityFragment);
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
            getFragmentManager().beginTransaction().replace(com.alipay.mobile.verifyidentity.business.security_verification.R.id.container, this.mFragments.get(i)).commitAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void confirm() {
        IAPAsyncTask.asyncTask(new IAPAsyncTask.Runner<MICRpcResponse>() { // from class: com.alipay.mobile.verifyidentity.business.security_verification.activity.VerifySecurityActivity.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alipay.iap.android.common.task.async.IAPAsyncTask.Runner
            public MICRpcResponse execute() throws Exception {
                VerifySecurityActivity.this.showSubmittingDialog();
                MICRpcRequest mICRpcRequest = new MICRpcRequest();
                mICRpcRequest.verifyId = VerifySecurityActivity.this.verifyId;
                mICRpcRequest.module = VerifySecurityActivity.this.nextStep;
                mICRpcRequest.action = RequestConstants.VERIFY;
                mICRpcRequest.envData = new JSONObject(VIEngineUtils.getEnvData(VerifySecurityActivity.this)).toString();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(RequestConstants.KEY_QUESTION_ANSWER_VIEWS, VerifySecurityActivity.this.buildConfirmData());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("data", jSONObject);
                mICRpcRequest.data = jSONObject2.toString();
                try {
                    return RpcSettings.retrieveRpcService().dispatch(mICRpcRequest);
                } catch (Throwable unused) {
                    return null;
                }
            }

            @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
            public void onSuccess(MICRpcResponse mICRpcResponse) {
                VerifySecurityActivity.this.hideSubmittingDialog();
                if (mICRpcResponse == null) {
                    ClientLogKitManager.getClientLogKit().log("event", new String[]{"a5.b2.c3", "1", ""}, null, "", "SecVI_Seed_SecQuestion_OpenResult", "", "", false);
                    VerifySecurityActivity verifySecurityActivity = VerifySecurityActivity.this;
                    CustomUi.showCenterToast(verifySecurityActivity, verifySecurityActivity.getResources().getString(com.alipay.mobile.verifyidentity.business.security_verification.R.string.system_busy_error), 0, POPUIType.TOAST_NET_ERROR);
                } else if (mICRpcResponse.sysErrCode.equals(SecurityConstants.KEY_OUT_TIME_CODE1) || mICRpcResponse.sysErrCode.equals("204")) {
                    VerifySecurityActivity.this.getWeakHandler().sendEmptyMessageDelayed(2001, 2000L);
                    VerifySecurityActivity.this.showAlertDialog(mICRpcResponse.sysErrMsg, mICRpcResponse);
                } else if ("VALIDATE_LOCKED_SQA_SPECIAL".equalsIgnoreCase(mICRpcResponse.verifyCode)) {
                    VIRespone vIRespone = new VIRespone(3000);
                    VerifySecurityActivity.this.message.setVerifyMessage(mICRpcResponse.verifyMessage);
                    vIRespone.setMessage(VerifySecurityActivity.this.message);
                    if (VerifySecurityActivity.getCallback() != null) {
                        VerifySecurityActivity.getCallback().onResult(VerifySecurityActivity.virifySecurityProduct, vIRespone);
                    }
                    VerifySecurityActivity.this.finish();
                    VerifySecurityActivity.this.resetCallback();
                } else if (mICRpcResponse.finish) {
                    if (!mICRpcResponse.verifySuccess) {
                        VerifySecurityActivity.this.showAlertDialog(mICRpcResponse.verifyMessage, mICRpcResponse);
                        return;
                    }
                    VIRespone vIRespone2 = new VIRespone(1000);
                    vIRespone2.setResponseMessage(mICRpcResponse.convertToMessage());
                    vIRespone2.setVerifyId(mICRpcResponse.verifyId);
                    vIRespone2.setMessage(VerifySecurityActivity.this.message);
                    if (VerifySecurityActivity.getCallback() != null) {
                        VerifySecurityActivity.getCallback().onResult(VerifySecurityActivity.virifySecurityProduct, vIRespone2);
                    }
                    VerifySecurityActivity.this.finish();
                    VerifySecurityActivity.this.resetCallback();
                } else if (!mICRpcResponse.verifySuccess && VerifySecurityActivity.this.nextStep.equalsIgnoreCase(mICRpcResponse.nextStep)) {
                    CustomUi.showCommonDialog(VerifySecurityActivity.this, "", mICRpcResponse.verifyMessage, 1001, false, new ModalInterface() { // from class: com.alipay.mobile.verifyidentity.business.security_verification.activity.VerifySecurityActivity.5.1
                        @Override // com.alipay.mobile.verifyidentity.uitools.dialog.ModalInterface
                        public void onCancel() {
                        }

                        @Override // com.alipay.mobile.verifyidentity.uitools.dialog.ModalInterface
                        public void onOk() {
                            InstrumentInjector.log_d("CustomUi", "  showAlertDialog   onOk");
                        }
                    });
                } else if (!TextUtils.isEmpty(mICRpcResponse.verifyMessage)) {
                    VerifySecurityActivity.this.showAlertDialog(mICRpcResponse.verifyMessage, mICRpcResponse);
                } else {
                    VerifySecurityActivity verifySecurityActivity2 = VerifySecurityActivity.this;
                    verifySecurityActivity2.showAlertDialog(verifySecurityActivity2.getResources().getString(com.alipay.mobile.verifyidentity.business.security_verification.R.string.Sysytem_error), mICRpcResponse);
                }
            }

            @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
            public void onFailure(IAPError iAPError) {
                VerifySecurityActivity.this.hideSubmittingDialog();
                VerifySecurityActivity verifySecurityActivity = VerifySecurityActivity.this;
                CustomUi.showCenterToast(verifySecurityActivity, verifySecurityActivity.getResources().getString(com.alipay.mobile.verifyidentity.business.security_verification.R.string.system_busy_error), 0, POPUIType.TOAST_NET_ERROR);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray buildConfirmData() {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < this.questionItemArr.length; i++) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("questionId", this.questionItemArr[i].getQuestionId());
                if (this.answerId[i].startsWith("[") && this.answerId[i].endsWith("]")) {
                    jSONObject.put(RequestConstants.KEY_MULTIPLE_ANSWER, new JSONArray(this.answerId[i]));
                } else {
                    jSONObject.put(RequestConstants.KEY_MULTIPLE_ANSWER, new JSONArray().put(this.answerId[i]));
                }
            } catch (Exception unused) {
            }
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    private void parseQuestionJson(JSONArray jSONArray) throws JSONException {
        JSONArray jSONArray2;
        int i;
        String string;
        this.adapterList.clear();
        int i2 = 0;
        while (i2 < jSONArray.length()) {
            JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
            jSONObject.getString("pageNum");
            JSONArray jSONArray3 = jSONObject.getJSONArray(SecurityConstants.KEY_QUERYVIEWS);
            ArrayList<List<QuestionItem>> arrayList = new ArrayList<>();
            int i3 = 0;
            while (i3 < jSONArray3.length()) {
                Object obj = jSONArray3.get(i3);
                ArrayList arrayList2 = new ArrayList();
                boolean z = obj instanceof JSONArray;
                String str = SecurityConstants.KEY_ANSWER_DISPLAY_TYPE;
                String str2 = "text";
                String str3 = SecurityConstants.KEY_MEMORYID;
                String str4 = "questionId";
                String str5 = SecurityConstants.KEY_QUESTION_TYPE;
                String str6 = SecurityConstants.KEY_DISPLAY_TYPE;
                int i4 = i2;
                ArrayList<List<QuestionItem>> arrayList3 = arrayList;
                if (z) {
                    JSONArray jSONArray4 = (JSONArray) jSONArray3.get(i3);
                    jSONArray2 = jSONArray3;
                    int i5 = 0;
                    while (i5 < jSONArray4.length()) {
                        JSONObject jSONObject2 = (JSONObject) jSONArray4.get(i5);
                        JSONArray jSONArray5 = jSONArray4;
                        QuestionItem questionItem = new QuestionItem();
                        int i6 = i3;
                        String optString = optString(jSONObject2, str);
                        String str7 = str;
                        String optString2 = optString(jSONObject2, str2);
                        String str8 = str2;
                        String optString3 = optString(jSONObject2, str3);
                        String str9 = str3;
                        String optString4 = optString(jSONObject2, str4);
                        String str10 = str4;
                        String optString5 = optString(jSONObject2, str5);
                        String str11 = str5;
                        String optString6 = optString(jSONObject2, str6);
                        String str12 = str6;
                        String optString7 = optString(jSONObject2, SecurityConstants.KEY_PLACE_HOLDER);
                        questionItem.setQuestionType(optString5);
                        questionItem.setAnswerDisplayType(optString);
                        questionItem.setMemoryId(optString3);
                        questionItem.setQuestionId(optString4);
                        questionItem.setContent(optString2);
                        questionItem.setDisplayType(optString6);
                        questionItem.setPlaceHolder(optString7);
                        if (jSONObject2.has(SecurityConstants.KEY_OPTIONS)) {
                            JSONArray jSONArray6 = jSONObject2.getJSONArray(SecurityConstants.KEY_OPTIONS);
                            ArrayList<QuestionItem.QuestionsOptions> arrayList4 = new ArrayList<>();
                            for (int i7 = 0; i7 < jSONArray6.length(); i7++) {
                                JSONObject jSONObject3 = (JSONObject) jSONArray6.get(i7);
                                arrayList4.add(new QuestionItem.QuestionsOptions(jSONObject3.getString(SecurityConstants.KEY_TEXT), jSONObject3.getString(SecurityConstants.KEY_VALUE)));
                            }
                            questionItem.setQuestionsOptionsList(arrayList4);
                        }
                        arrayList2.add(questionItem);
                        i5++;
                        jSONArray4 = jSONArray5;
                        i3 = i6;
                        str = str7;
                        str2 = str8;
                        str3 = str9;
                        str4 = str10;
                        str5 = str11;
                        str6 = str12;
                    }
                    i = i3;
                } else {
                    jSONArray2 = jSONArray3;
                    i = i3;
                    if (obj instanceof JSONObject) {
                        JSONObject jSONObject4 = (JSONObject) obj;
                        QuestionItem questionItem2 = new QuestionItem();
                        String optString8 = optString(jSONObject4, SecurityConstants.KEY_ANSWER_DISPLAY_TYPE);
                        String optString9 = optString(jSONObject4, "text");
                        String optString10 = optString(jSONObject4, SecurityConstants.KEY_MEMORYID);
                        String optString11 = optString(jSONObject4, "questionId");
                        String optString12 = optString(jSONObject4, SecurityConstants.KEY_QUESTION_TYPE);
                        String optString13 = optString(jSONObject4, SecurityConstants.KEY_DISPLAY_TYPE);
                        String optString14 = optString(jSONObject4, SecurityConstants.KEY_PLACE_HOLDER);
                        questionItem2.setQuestionType(optString12);
                        questionItem2.setAnswerDisplayType(optString8);
                        questionItem2.setMemoryId(optString10);
                        questionItem2.setQuestionId(optString11);
                        questionItem2.setContent(optString9);
                        questionItem2.setDisplayType(optString13);
                        questionItem2.setPlaceHolder(optString14);
                        if (jSONObject4.has(SecurityConstants.KEY_OPTIONS)) {
                            JSONArray jSONArray7 = jSONObject4.getJSONArray(SecurityConstants.KEY_OPTIONS);
                            ArrayList<QuestionItem.QuestionsOptions> arrayList5 = new ArrayList<>();
                            for (int i8 = 0; i8 < jSONArray7.length(); i8++) {
                                JSONObject jSONObject5 = (JSONObject) jSONArray7.get(i8);
                                String str13 = "";
                                if (jSONObject5.has(SecurityConstants.KEY_TEXT)) {
                                    string = jSONObject5.getString(SecurityConstants.KEY_TEXT);
                                } else {
                                    string = jSONObject5.has(SecurityConstants.KEY_TEXT_KBA) ? jSONObject5.getString(SecurityConstants.KEY_TEXT_KBA) : "";
                                }
                                if (jSONObject5.has(SecurityConstants.KEY_VALUE)) {
                                    str13 = jSONObject5.getString(SecurityConstants.KEY_VALUE);
                                } else if (jSONObject5.has("value")) {
                                    str13 = jSONObject5.getString("value");
                                }
                                arrayList5.add(new QuestionItem.QuestionsOptions(string, str13));
                            }
                            questionItem2.setQuestionsOptionsList(arrayList5);
                        }
                        arrayList2.add(questionItem2);
                    }
                }
                arrayList3.add(arrayList2);
                i3 = i + 1;
                arrayList = arrayList3;
                i2 = i4;
                jSONArray3 = jSONArray2;
            }
            this.adapterList.add(arrayList);
            i2++;
        }
    }

    private String optString(JSONObject jSONObject, String str) throws JSONException {
        return jSONObject.has(str) ? jSONObject.getString(str) : "";
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == keyEvent.getKeyCode()) {
            doCancel();
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doCancel() {
        Message message = this.message;
        String verifyId = message != null ? message.getVerifyId() : "";
        VIRespone vIRespone = new VIRespone(1003);
        vIRespone.setVerifyId(verifyId);
        vIRespone.setMessage(this.message);
        if (getCallback() != null) {
            getCallback().onResult(virifySecurityProduct, vIRespone);
        }
        resetCallback();
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.ProductActivity, com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetCallback() {
        iCallback = null;
        virifySecurityProduct = null;
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
        if (commonActivityInterface.navTitleFont() > 0) {
            this.tvVerification.setTextSize(1, commonActivityInterface.navTitleFont());
        }
    }

    private static void h(int i, char c, int i2, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i2) {
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (getErrorConfigVersion[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ lookAheadTest))) ^ c;
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        char[] cArr = new char[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i2) {
            cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        objArr[0] = new String(cArr);
    }
}
