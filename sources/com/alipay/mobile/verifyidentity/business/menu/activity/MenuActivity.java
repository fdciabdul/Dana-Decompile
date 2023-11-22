package com.alipay.mobile.verifyidentity.business.menu.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.mobile.verifyidentity.base.adapter.ListViewAdapter;
import com.alipay.mobile.verifyidentity.base.adapter.ViewHolder;
import com.alipay.mobile.verifyidentity.base.message.RequestConstants;
import com.alipay.mobile.verifyidentity.business.activity.BaseActivity;
import com.alipay.mobile.verifyidentity.framework.engine.VIAction;
import com.alipay.mobile.verifyidentity.framework.engine.VIEngine;
import com.alipay.mobile.verifyidentity.framework.engine.VIResult;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.text.Typography;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.whenAvailable;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class MenuActivity extends BaseActivity {
    public static final String VERIFY_SUCCESS = "verify_success";
    private String center_title;
    private ListView listView;
    private ProductCreateReceiver receiver;
    private TextView tv_center_title;
    private View tv_confirm;
    private TextView tv_title;
    private String verifyId;
    public static final byte[] $$d = {56, 110, 47, 101, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$e = 216;
    public static final byte[] getAuthRequestContext = {TarHeader.LF_DIR, -98, 98, -100, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int PlaceComponentResult = 64;
    private static char[] BuiltInFictitiousFunctionClassFactory = {36337, 11945, 52058, 26599, Typography.pound, 48458, 23038, 64223, 38727, 13292, 60632, 35197, 9718, 50836, 25393, 8172, 47251, 21796, 62243, 20576, 46517, 6434, 32374, 36765, 11461, 51510, 25995, 719, 48934, 23442, 63667, 38181, 12675, 61162, 35695, 10153, 50420, 24906, 7564, 47866, 22354, 62358, 37104, 19812, 59831, 34548, 9032, 57269, 31975, 62253, 20588, 46482, 6457, 32375, 50067, 10032, 33902, 59782, 19761, 37444, 63386, 23353, 47172, 7672, 24894, 50769, 11239, 41821, '^', 58866, 18775, 11782, 37821, 30553, 54323, 47589, 7424, 49775, 42929, 2843, 59443, 19865, 12613, 38443, 31644, 57154, 48254, 25026, 50474, 43635, 3981, 62246, 20518, 13700, 39203, 32476, 9173, 34617, 25734, 51635, 44395, 4822, 63414, 23344, 14528, 40376, 16667, 9925, 35811, 28440, 52417, 45564, 5394, 64254, 24566, 26541, 50350, 8532, 36269, 60150, 22342, 46070, 4245, 32016, 55712, 1683, 25412, 53180, 11414, 35135, 62945, 21134, 48953, 7092, 30856, 42340, 478, 28288, 52014, 14290, 38097, 61731, 23940, 47728, 59251, 17356, 41079, 3407, 27039, 54902, 13073, 40851, 64572, 22806, 34238, 57953, 20243, 44015, 2144, 30043, 53680, 15967, 39682, 51119, 9304, 33029, 60832, 19033, 46840, 5030, 28748, 56564, 14754, 26137, 49827, 12185, 35919, 59578, 21910, 62332, 20520, 46469, 6441, 32299, 50122, 10102, 33819, 59854, 19833, 37392, 63426, 23403, 47126, 7612, 24928, 50783, 11244, 36708, 60511, 12720, 38159, 64085, 24492, 41809, 'W', 26017, 51547, 11948, 29683, 55115, 13476, 39321, 64797, 17138, 42899, 2832, 26858, 52626, 4407, 30446, 56263, 16185, 40167, 57730, 17717, 43661, 4053, 21368, 45264, 5587, 31102, 57040, 8828, 34674, 58570, 18545, 44324, 62145, 22133, 47948, 6336, 31849, 49438, 62246, 20589, 46484, 6459, 32353, 50119, 10091, 33792, 59794, 19744, 37446, 63378, 23412, 47185, 7652, 24869, 50779, 11240, 36644, 60504, 12771, 38174, 64064, 24497, 41729, 'D', 26105, 51473, 11950, 29670, 55053, 13490, 39375, 64779, 17061, 42885, 2833, 26802, 52681, 4384, 30391, 56273, 16225, 40188, 57811, 17771, 43659, 4050, 21357, 45213, 5535, 31085, 57040, 8802, 34673, 58505, 18467, 44415, 62092, 22064, 6272, 48064, 24099, 62098, 38359, 10299};
    private static long lookAheadTest = 2206892240126365721L;
    private List<RadioBean> radioList = new ArrayList();
    private int seletItemPosition = 0;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void e(int r8, byte r9, int r10, java.lang.Object[] r11) {
        /*
            int r8 = r8 + 97
            byte[] r0 = com.alipay.mobile.verifyidentity.business.menu.activity.MenuActivity.getAuthRequestContext
            int r9 = r9 + 16
            int r10 = r10 + 4
            byte[] r1 = new byte[r9]
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
            if (r4 != r9) goto L24
            java.lang.String r8 = new java.lang.String
            r8.<init>(r1, r2)
            r11[r2] = r8
            return
        L24:
            r3 = r0[r10]
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
            int r9 = r9 + (-4)
            int r10 = r11 + 1
            r11 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r9
            r9 = r8
            r8 = r6
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.verifyidentity.business.menu.activity.MenuActivity.e(int, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void f(byte r7, byte r8, int r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 2
            int r7 = r7 + 75
            int r9 = r9 * 3
            int r9 = 42 - r9
            byte[] r0 = com.alipay.mobile.verifyidentity.business.menu.activity.MenuActivity.$$d
            int r8 = 46 - r8
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L18
            r7 = r8
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L34
        L18:
            r3 = 0
        L19:
            int r8 = r8 + 1
            byte r4 = (byte) r7
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r9) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            r3 = r0[r8]
            r6 = r9
            r9 = r7
            r7 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L34:
            int r9 = r9 + r8
            int r8 = r9 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            r6 = r8
            r8 = r7
            r7 = r6
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.verifyidentity.business.menu.activity.MenuActivity.f(byte, byte, int, java.lang.Object[]):void");
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        d(View.MeasureSpec.makeMeasureSpec(0, 0) + 18, ViewConfiguration.getScrollDefaultDelay() >> 16, (char) (Color.green(0) + 32478), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        d(5 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 17 - Process.getGidForName(""), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - TextUtils.indexOf("", ""), (char) TextUtils.getOffsetAfter("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    d(TextUtils.indexOf("", "", 0, 0) + 48, 67 - View.MeasureSpec.getMode(0), (char) (ExpandableListView.getPackedPositionChild(0L) + 20517), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    d((ViewConfiguration.getJumpTapTimeout() >> 16) + 64, 115 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 38019), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    d((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 63, (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 179, (char) TextUtils.getCapsMode("", 0, 0), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    d(60 - (Process.myPid() >> 22), 243 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    d(6 - KeyEvent.normalizeMetaState(0), KeyEvent.getDeadChar(0, 0) + 303, (char) (60406 - TextUtils.lastIndexOf("", '0', 0, 0)), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + 911, 18 - (ViewConfiguration.getTouchSlop() >> 8), (char) ((-16777216) - Color.rgb(0, 0, 0)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = getAuthRequestContext[32];
                byte b2 = getAuthRequestContext[25];
                Object[] objArr13 = new Object[1];
                e(b, b2, (byte) (b2 | 37), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                e((byte) (getAuthRequestContext[32] - 1), getAuthRequestContext[25], getAuthRequestContext[35], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + 55, 3 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (ViewConfiguration.getEdgeSlop() >> 16));
                        Object[] objArr16 = new Object[1];
                        f($$d[78], $$d[53], $$d[31], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, (Process.myTid() >> 22) + 15, (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - ((Process.getThreadPriority(0) + 20) >> 6), (Process.myTid() >> 22) + 15, (char) (AndroidCharacter.getMirror('0') - '0'))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - (ViewConfiguration.getScrollBarSize() >> 8), 28 - Process.getGidForName(""), (char) (57994 - View.combineMeasuredStates(0, 0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 14, (char) View.combineMeasuredStates(0, 0)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r9 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 35, (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {532838569, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), TextUtils.indexOf((CharSequence) "", '0', 0) + 19, (char) View.MeasureSpec.getMode(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b3 = getAuthRequestContext[32];
                byte b4 = getAuthRequestContext[25];
                Object[] objArr19 = new Object[1];
                e(b3, b4, (byte) (b4 | 37), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                e((byte) (getAuthRequestContext[32] - 1), getAuthRequestContext[25], getAuthRequestContext[35], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - Color.alpha(0), (ViewConfiguration.getWindowTouchSlop() >> 8) + 46, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)));
                        Object[] objArr22 = new Object[1];
                        f($$d[9], $$d[84], $$d[8], objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.getTrimmedLength("") + 35, (char) View.getDefaultSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {532838569, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getFadingEdgeLength() >> 16), TextUtils.indexOf((CharSequence) "", '0', 0) + 19, (char) View.resolveSize(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b5 = getAuthRequestContext[32];
                byte b6 = getAuthRequestContext[25];
                Object[] objArr25 = new Object[1];
                e(b5, b6, (byte) (b6 | 37), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                e((byte) (getAuthRequestContext[32] - 1), getAuthRequestContext[25], getAuthRequestContext[35], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.argb(0, 0, 0, 0) + 118, 3 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (38968 - (ViewConfiguration.getWindowTouchSlop() >> 8)));
                        Object[] objArr28 = new Object[1];
                        f($$d[9], $$d[84], $$d[8], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0', 0, 0), TextUtils.indexOf("", "", 0, 0) + 35, (char) ((-1) - ImageFormat.getBitsPerPixel(0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {532838569, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + 912, 18 - TextUtils.getTrimmedLength(""), (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b7 = getAuthRequestContext[32];
                byte b8 = getAuthRequestContext[25];
                Object[] objArr31 = new Object[1];
                e(b7, b8, (byte) (b8 | 37), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                e((byte) (getAuthRequestContext[32] - 1), getAuthRequestContext[25], getAuthRequestContext[35], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - ((Process.getThreadPriority(0) + 20) >> 6), 3 - TextUtils.getOffsetAfter("", 0), (char) (Process.myPid() >> 22));
                        byte b9 = (byte) ($$d[78] - 1);
                        byte b10 = b9;
                        Object[] objArr34 = new Object[1];
                        f(b9, b10, b10, objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778145, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 35, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {532838569, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 911, (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18, (char) (Process.myTid() >> 22))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // com.alipay.mobile.verifyidentity.business.activity.BaseActivity
    public void modifyViewFromOutside() {
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                Object[] objArr = new Object[1];
                e(getAuthRequestContext[25], (byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                e((byte) (-getAuthRequestContext[5]), getAuthRequestContext[56], (byte) (getAuthRequestContext[0] - 1), new Object[1]);
                Object[] objArr2 = new Object[1];
                d(((ApplicationInfo) cls.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 7, super.getResources().getString(R.string.remarks_not_editable).substring(2, 3).codePointAt(0) - 93, (char) (Process.getGidForName("") + 31923), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                int length = getPackageName().length() + 11;
                int codePointAt = super.getResources().getString(R.string.top_up_history_title).substring(3, 4).codePointAt(0) + 17;
                try {
                    Object[] objArr3 = new Object[1];
                    e(getAuthRequestContext[25], (byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], objArr3);
                    Class<?> cls3 = Class.forName((String) objArr3[0]);
                    e((byte) (-getAuthRequestContext[5]), getAuthRequestContext[56], (byte) (getAuthRequestContext[0] - 1), new Object[1]);
                    Object[] objArr4 = new Object[1];
                    d(length, codePointAt, (char) (((ApplicationInfo) cls3.getMethod((String) r10[0], null).invoke(this, null)).targetSdkVersion - 33), objArr4);
                    baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), View.MeasureSpec.makeMeasureSpec(0, 0) + 35, (char) (Color.rgb(0, 0, 0) + 16777216))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 910, View.getDefaultSize(0, 0) + 18, (char) View.resolveSizeAndState(0, 0, 0))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr5);
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
        super.onPause();
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            int codePointAt = super.getResources().getString(R.string.title_bottom_sheet).substring(0, 1).codePointAt(0) - 41;
            try {
                Object[] objArr = new Object[1];
                e(getAuthRequestContext[25], (byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                e((byte) (-getAuthRequestContext[5]), getAuthRequestContext[56], (byte) (getAuthRequestContext[0] - 1), new Object[1]);
                Object[] objArr2 = new Object[1];
                d(codePointAt, ((ApplicationInfo) cls.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 10, (char) (getPackageName().codePointAt(1) + 31822), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                d(super.getResources().getString(R.string.deals_express_snackbar_pending).substring(45, 46).length() + 17, getPackageName().codePointAt(6) - 48, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), objArr3);
                baseContext = (Context) cls2.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0'), View.resolveSizeAndState(0, 0, 0) + 35, (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.makeMeasureSpec(0, 0), ((Process.getThreadPriority(0) + 20) >> 6) + 18, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @Override // com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr = new Object[1];
        d(getPackageName().length() + 11, getPackageName().length() - 7, (char) (super.getResources().getString(R.string.lets_update_to_dana_premium).substring(27, 28).length() + 32477), objArr);
        Class<?> cls = Class.forName((String) objArr[0]);
        int fadingEdgeLength = (ViewConfiguration.getFadingEdgeLength() >> 16) + 5;
        try {
            Object[] objArr2 = new Object[1];
            e(getAuthRequestContext[25], (byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], objArr2);
            Class<?> cls2 = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            e((byte) (-getAuthRequestContext[5]), getAuthRequestContext[56], (byte) (getAuthRequestContext[0] - 1), objArr3);
            int i = ((ApplicationInfo) cls2.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion - 15;
            try {
                Object[] objArr4 = new Object[1];
                e(getAuthRequestContext[25], (byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], objArr4);
                Class<?> cls3 = Class.forName((String) objArr4[0]);
                e((byte) (-getAuthRequestContext[5]), getAuthRequestContext[56], (byte) (getAuthRequestContext[0] - 1), new Object[1]);
                Object[] objArr5 = new Object[1];
                d(fadingEdgeLength, i, (char) (((ApplicationInfo) cls3.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 33), objArr5);
                int intValue = ((Integer) cls.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                if (intValue < 99000 || intValue > 99999) {
                    Context baseContext = getBaseContext();
                    if (baseContext == null) {
                        Object[] objArr6 = new Object[1];
                        d(getPackageName().length() + 19, super.getResources().getString(R.string.smartpay_info_desc_2).substring(21, 22).length() + 22, (char) (((Process.getThreadPriority(0) + 20) >> 6) + 31922), objArr6);
                        Class<?> cls4 = Class.forName((String) objArr6[0]);
                        Object[] objArr7 = new Object[1];
                        d(17 - TextUtils.lastIndexOf("", '0'), 49 - TextUtils.getTrimmedLength(""), (char) (super.getResources().getString(R.string.payment_setting_failed_dialog_message).substring(6, 7).codePointAt(0) + BranchLinkConstant.DeepLinkErrorCode.SAME_ALIAS), objArr7);
                        baseContext = (Context) cls4.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext != null) {
                        baseContext = baseContext.getApplicationContext();
                    }
                    if (baseContext != null) {
                        try {
                            Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj == null) {
                                obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getOffsetBefore("", 0), 36 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) View.MeasureSpec.getSize(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                            }
                            Object invoke = ((Method) obj).invoke(null, null);
                            int normalizeMetaState = KeyEvent.normalizeMetaState(0) + 48;
                            try {
                                Object[] objArr8 = new Object[1];
                                e(getAuthRequestContext[25], (byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], objArr8);
                                Class<?> cls5 = Class.forName((String) objArr8[0]);
                                Object[] objArr9 = new Object[1];
                                e((byte) (-getAuthRequestContext[5]), getAuthRequestContext[56], (byte) (getAuthRequestContext[0] - 1), objArr9);
                                int i2 = ((ApplicationInfo) cls5.getMethod((String) objArr9[0], null).invoke(this, null)).targetSdkVersion + 34;
                                try {
                                    Object[] objArr10 = new Object[1];
                                    e(getAuthRequestContext[25], (byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], objArr10);
                                    Class<?> cls6 = Class.forName((String) objArr10[0]);
                                    Object[] objArr11 = new Object[1];
                                    e((byte) (-getAuthRequestContext[5]), getAuthRequestContext[56], (byte) (getAuthRequestContext[0] - 1), objArr11);
                                    Object[] objArr12 = new Object[1];
                                    d(normalizeMetaState, i2, (char) (((ApplicationInfo) cls6.getMethod((String) objArr11[0], null).invoke(this, null)).targetSdkVersion + 20483), objArr12);
                                    String str = (String) objArr12[0];
                                    Object[] objArr13 = new Object[1];
                                    d(getPackageName().length() + 57, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 114, (char) (super.getResources().getString(R.string.empty_promoquest_message).substring(20, 21).length() + 38017), objArr13);
                                    String str2 = (String) objArr13[0];
                                    int codePointAt = getPackageName().codePointAt(2) + 18;
                                    int maxKeyCode = 179 - (KeyEvent.getMaxKeyCode() >> 16);
                                    try {
                                        Object[] objArr14 = new Object[1];
                                        e(getAuthRequestContext[25], (byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], objArr14);
                                        Class<?> cls7 = Class.forName((String) objArr14[0]);
                                        e((byte) (-getAuthRequestContext[5]), getAuthRequestContext[56], (byte) (getAuthRequestContext[0] - 1), new Object[1]);
                                        Object[] objArr15 = new Object[1];
                                        d(codePointAt, maxKeyCode, (char) (((ApplicationInfo) cls7.getMethod((String) r7[0], null).invoke(this, null)).targetSdkVersion - 33), objArr15);
                                        String str3 = (String) objArr15[0];
                                        Object[] objArr16 = new Object[1];
                                        d(getPackageName().codePointAt(1) - 40, super.getResources().getString(R.string.voucher_code_valid).substring(6, 7).length() + 242, (char) TextUtils.indexOf("", ""), objArr16);
                                        String str4 = (String) objArr16[0];
                                        Object[] objArr17 = new Object[1];
                                        d(super.getResources().getString(R.string.installment_month).substring(0, 3).codePointAt(1) - 109, getPackageName().length() + 296, (char) (super.getResources().getString(R.string.bank_promo_header).substring(0, 1).codePointAt(0) + 60324), objArr17);
                                        try {
                                            Object[] objArr18 = {baseContext, str, str2, str3, str4, true, (String) objArr17[0], 995651014};
                                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                            if (obj2 == null) {
                                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + 911, Color.red(0) + 18, (char) (Process.myTid() >> 22))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                            }
                                            ((Method) obj2).invoke(invoke, objArr18);
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
                    byte b = getAuthRequestContext[32];
                    byte b2 = getAuthRequestContext[25];
                    Object[] objArr19 = new Object[1];
                    e(b, b2, (byte) (b2 | 37), objArr19);
                    Class<?> cls8 = Class.forName((String) objArr19[0]);
                    Object[] objArr20 = new Object[1];
                    e((byte) (getAuthRequestContext[32] - 1), getAuthRequestContext[25], getAuthRequestContext[35], objArr20);
                    try {
                        Object[] objArr21 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                        if (obj3 == null) {
                            Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + 494, 4 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)));
                            byte b3 = (byte) ($$d[78] - 1);
                            byte b4 = b3;
                            Object[] objArr22 = new Object[1];
                            f(b3, b4, b4, objArr22);
                            obj3 = cls9.getMethod((String) objArr22[0], Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                        }
                        Object[] objArr23 = (Object[]) ((Method) obj3).invoke(null, objArr21);
                        int i3 = ((int[]) objArr23[1])[0];
                        if (((int[]) objArr23[0])[0] != i3) {
                            long j = ((r2 ^ i3) & 4294967295L) | 42949672960L;
                            try {
                                Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj4 == null) {
                                    obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getFadingEdgeLength() >> 16), 36 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) View.getDefaultSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                }
                                Object invoke2 = ((Method) obj4).invoke(null, null);
                                try {
                                    Object[] objArr24 = {-872826378, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj5 == null) {
                                        obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollDefaultDelay() >> 16), KeyEvent.keyCodeFromString("") + 18, (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                    }
                                    ((Method) obj5).invoke(invoke2, objArr24);
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
                        requestWindowFeature(1);
                        setContentView(com.alipay.mobile.verifyidentity.business.menu.R.layout.activity_menu);
                        initView();
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

    private void initView() {
        this.tv_title = (TextView) findViewById(com.alipay.mobile.verifyidentity.business.menu.R.id.tv_title);
        this.listView = (ListView) findViewById(com.alipay.mobile.verifyidentity.business.menu.R.id.listView);
        this.tv_confirm = findViewById(com.alipay.mobile.verifyidentity.business.menu.R.id.tv_confirm);
        this.tv_center_title = (TextView) findViewById(com.alipay.mobile.verifyidentity.business.menu.R.id.tv_center_title);
        findViewById(com.alipay.mobile.verifyidentity.business.menu.R.id.ll_back).setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.verifyidentity.business.menu.activity.MenuActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MenuActivity.this.finish();
            }
        });
        findViewById(com.alipay.mobile.verifyidentity.business.menu.R.id.tv_confirm).setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.verifyidentity.business.menu.activity.MenuActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MenuActivity.this.confirm();
            }
        });
        setConfirmState(true);
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.BaseActivity
    public void initData() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("renderData");
        this.verifyId = intent.getStringExtra("verifyId");
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                JSONObject jSONObject = new JSONObject(stringExtra);
                String optString = jSONObject.optString("head_title");
                this.center_title = jSONObject.optString("form_title");
                this.tv_title.setText(optString);
                JSONArray optJSONArray = jSONObject.optJSONArray(RequestConstants.Menu.METHODS);
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    this.radioList.add(new RadioBean(jSONObject2.optString("name"), jSONObject2.optString("code")));
                }
            } catch (Exception unused) {
            }
        }
        this.tv_center_title.setText(this.center_title);
        registerReceiver();
        this.listView.setAdapter((ListAdapter) new MenuAdapter(this, this.radioList, com.alipay.mobile.verifyidentity.business.menu.R.layout.adapter_menu));
    }

    /* loaded from: classes7.dex */
    class MenuAdapter extends ListViewAdapter<RadioBean> {
        public MenuAdapter(Context context, List<RadioBean> list, int i) {
            super(context, list, i);
        }

        @Override // com.alipay.mobile.verifyidentity.base.adapter.ListViewAdapter
        public void convert(ViewHolder viewHolder, RadioBean radioBean, final int i) {
            if (i == MenuActivity.this.seletItemPosition) {
                viewHolder.getView(com.alipay.mobile.verifyidentity.business.menu.R.id.iv_icon).setBackgroundResource(com.alipay.mobile.verifyidentity.business.menu.R.drawable.menu_radio_on);
            } else {
                viewHolder.getView(com.alipay.mobile.verifyidentity.business.menu.R.id.iv_icon).setBackgroundResource(com.alipay.mobile.verifyidentity.business.menu.R.drawable.menu_radio_off);
            }
            ((TextView) viewHolder.getView(com.alipay.mobile.verifyidentity.business.menu.R.id.tv_title)).setText(radioBean.name);
            viewHolder.getView(com.alipay.mobile.verifyidentity.business.menu.R.id.rl_select).setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.verifyidentity.business.menu.activity.MenuActivity.MenuAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MenuActivity.this.seletItemPosition = i;
                    MenuActivity.this.setConfirmState(true);
                    MenuAdapter.this.notifyDataSetChanged();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void confirm() {
        if (this.radioList.size() == 0) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("verifyId", this.verifyId);
        hashMap.put("verifyType", "1");
        hashMap.put("module", this.radioList.get(this.seletItemPosition).code);
        VIEngine.startVerify(this, RequestConstants.VerifyProductVerify, hashMap, null, new VIEngine.VIListener() { // from class: com.alipay.mobile.verifyidentity.business.menu.activity.MenuActivity.3
            @Override // com.alipay.mobile.verifyidentity.framework.engine.VIEngine.VIListener
            public void onVerifyAction(VIAction vIAction) {
            }

            @Override // com.alipay.mobile.verifyidentity.framework.engine.VIEngine.VIListener
            public void onVerifyResult(VIResult vIResult) {
                if (vIResult.getResult() == 1000) {
                    Intent intent = new Intent();
                    intent.setAction(MenuActivity.VERIFY_SUCCESS);
                    intent.putExtra("verifyId", MenuActivity.this.verifyId);
                    MenuActivity.this.sendBroadcast(intent);
                }
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConfirmState(boolean z) {
        if (z) {
            this.tv_confirm.setClickable(true);
            this.tv_confirm.setBackgroundResource(com.alipay.mobile.verifyidentity.business.menu.R.drawable.bnt_sure);
        } else {
            this.tv_confirm.setClickable(false);
            this.tv_confirm.setBackgroundResource(com.alipay.mobile.verifyidentity.business.menu.R.drawable.confirm_unselected);
        }
        this.tv_confirm.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class ProductCreateReceiver extends BroadcastReceiver {
        private ProductCreateReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (MenuActivity.this.isFinishing()) {
                return;
            }
            MenuActivity.this.finish();
        }
    }

    private void registerReceiver() {
        this.receiver = new ProductCreateReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(this.verifyId);
        registerReceiver(this.receiver, intentFilter);
    }

    private void unrigisterReceiver() {
        unregisterReceiver(this.receiver);
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unrigisterReceiver();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class RadioBean {
        public String code;
        public String name;

        public RadioBean(String str, String str2) {
            this.name = str;
            this.code = str2;
        }
    }

    private static void d(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i) {
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (BuiltInFictitiousFunctionClassFactory[whenavailable.BuiltInFictitiousFunctionClassFactory + i2] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ lookAheadTest))) ^ c;
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
