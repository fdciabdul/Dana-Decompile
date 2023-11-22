package com.alipay.mobile.verifyidentity.business.security.activity;

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
import com.alibaba.fastjson.parser.JSONLexer;
import com.alipay.iap.android.common.errorcode.IAPError;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.alipay.iap.android.common.task.async.IAPAsyncTask;
import com.alipay.mobile.verifyidentity.RpcSettings;
import com.alipay.mobile.verifyidentity.base.OnClickUrl;
import com.alipay.mobile.verifyidentity.base.adapter.ListViewAdapter;
import com.alipay.mobile.verifyidentity.base.adapter.ViewHolder;
import com.alipay.mobile.verifyidentity.base.message.Message;
import com.alipay.mobile.verifyidentity.base.message.RequestConstants;
import com.alipay.mobile.verifyidentity.business.activity.ActivityInterface;
import com.alipay.mobile.verifyidentity.business.activity.ActivityInterfaceManager;
import com.alipay.mobile.verifyidentity.business.activity.BaseActivity;
import com.alipay.mobile.verifyidentity.business.activity.ClientLogKitManager;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.MenuItem;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.alipay.mobile.verifyidentity.framework.engine.VIEngine;
import com.alipay.mobile.verifyidentity.framework.engine.VIEngineUtils;
import com.alipay.mobile.verifyidentity.uitools.ColorUtils;
import com.alipay.mobileiclib.common.service.facade.solution.dto.MICRpcRequest;
import com.alipay.mobileiclib.common.service.facade.solution.dto.MICRpcResponse;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import com.huawei.hms.framework.common.ContainerUtils;
import id.dana.R;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.text.Typography;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;
import o.getCallingPid;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class SecurityListActivity extends BaseActivity implements View.OnClickListener {
    private String action;
    private SecurityListAdapter adapter;
    private ListView lv_content;
    private String menuTitle;
    private Message message;
    private boolean mshowMenu;
    private String productCode;
    private View rl_title;
    private String sceneId;
    private String secData;
    private String tntInstId;
    private TextView tv_title;
    private String userId;
    public static final byte[] $$d = {116, 15, TarHeader.LF_BLK, -20, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$e = 90;
    public static final byte[] getAuthRequestContext = {104, -68, 0, 44, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int PlaceComponentResult = 153;
    private static char scheduleImpl = 42066;
    private static char[] BuiltInFictitiousFunctionClassFactory = {37306, 37288, 37274, 37366, 37374, 37262, 37294, 37310, 37275, 37307, 37375, 37344, 37345, 37371, 37286, 37460, 37283, 37305, 37295, 37461, 37459, 37281, 37367, 37287, 37456, 37365, 37311, 37292, 37309, 37279, 37308, 37369, 37457, 37293, 37458, 37290, 37302, 37280, 37285, 37463, 37462, 37284, 37368, 37291, 37282, 37289, 37370, 37372, 37373};
    private List<MenuItem> menuItemList = new ArrayList();
    boolean isFirstResume = true;

    private static void e(byte b, int i, byte b2, Object[] objArr) {
        int i2 = 56 - b2;
        byte[] bArr = getAuthRequestContext;
        int i3 = 106 - i;
        int i4 = 23 - b;
        byte[] bArr2 = new byte[i4];
        int i5 = -1;
        int i6 = i4 - 1;
        if (bArr == null) {
            i2++;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
            i3 = (i3 + i6) - 4;
            i6 = i6;
        }
        while (true) {
            int i7 = i5 + 1;
            bArr2[i7] = (byte) i3;
            if (i7 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b3 = bArr[i2];
            int i8 = i3;
            i2++;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = i7;
            i3 = (i8 + b3) - 4;
            i6 = i6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void f(short r7, short r8, short r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 2
            int r7 = 103 - r7
            int r9 = r9 * 3
            int r9 = r9 + 21
            byte[] r0 = com.alipay.mobile.verifyidentity.business.security.activity.SecurityListActivity.$$d
            int r8 = 46 - r8
            byte[] r1 = new byte[r9]
            int r9 = r9 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r7 = r8
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L38
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r8 = r8 + 1
            if (r3 != r9) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r8
            r8 = r7
            r7 = r5
            r6 = r10
            r10 = r9
            r9 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L38:
            int r9 = -r9
            int r8 = r8 + r9
            int r8 = r8 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.verifyidentity.business.security.activity.SecurityListActivity.f(short, short, short, java.lang.Object[]):void");
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        d((byte) (62 - TextUtils.getCapsMode("", 0, 0)), new char[]{0, 27, '*', 29, '#', 16, '/', '\b', ',', '%', '\b', '!', 30, '#', 21, ')', 13863, 13863}, KeyEvent.getDeadChar(0, 0) + 18, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        d((byte) (Drawable.resolveOpacity(0, 0) + 112), new char[]{'+', '%', 0, 16, 13934}, 5 - (ViewConfiguration.getFadingEdgeLength() >> 16), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.argb(0, 0, 0, 0), 35 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    d((byte) ((ViewConfiguration.getScrollBarSize() >> 8) + 74), new char[]{'0', 21, 29, 24, '\b', '-', 1, 24, 0, '*', 24, '0', ')', '*', 3, InputCardNumberView.DIVIDER, 13813, 13813, Typography.quote, 3, '0', 22, 24, Typography.quote, ',', '0', 29, 1, '*', ',', 0, ')', '\n', Typography.amp, '-', 6, 3, '\n', 24, '\b', '+', '.', '\n', Typography.quote, '(', 5, 28, Typography.amp}, 48 - View.MeasureSpec.getMode(0), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    d((byte) (12 - View.getDefaultSize(0, 0)), new char[]{4, '0', 29, '-', 3, '\n', '\b', 24, '0', 22, 4, '-', '.', 1, 6, 11, 13748, 13748, '.', 3, '.', 1, '!', '-', InputCardNumberView.DIVIDER, Typography.quote, 0, Typography.amp, 29, 1, 13748, 13748, 22, '0', '\b', 27, 13829, 13829, '\f', '-', '-', 11, '\'', 0, 21, '0', 0, '.', 13749, 13749, '-', 0, 0, '-', 11, 3, 11, 3, JSONLexer.EOI, Typography.quote, 1, 25, ',', '0'}, 64 - View.resolveSizeAndState(0, 0, 0), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    d((byte) (TextUtils.lastIndexOf("", '0') + 50), new char[]{'.', 6, '(', 28, 0, '-', 6, 20, 13779, 13779, 25, 1, 5, '.', 7, '-', 0, ')', '\b', '0', '/', Typography.quote, 5, '0', '+', '.', 1, 24, 13869, 13869, '0', 21, '+', ',', '+', 27, 28, '/', 29, 24, 24, '+', 6, 11, 24, '\b', 5, Typography.quote, 3, '\n', 21, ')', '.', 6, '.', '/', '+', '/', '\n', Typography.amp, '.', '/', '-', 4}, MotionEvent.axisFromString("") + 65, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    d((byte) (89 - (ViewConfiguration.getMinimumFlingVelocity() >> 16)), new char[]{30, 16, '\f', 23, InputCardNumberView.DIVIDER, 23, 13838, 13838, '0', 1, 27, 0, '\r', '\n', 21, 30, ')', 0, '\r', 23, 2, Typography.quote, '\n', '\r', 2, 1, 0, Typography.quote, ',', 29, 14, 7, 0, Typography.quote, '(', 7, 23, ')', '.', '\t', 5, 27, 18, 7, 21, 28, 0, Typography.dollar, '%', 16, '\n', 18, '.', '\r', Typography.amp, 14, '*', 28, 16, '%'}, TextUtils.indexOf((CharSequence) "", '0') + 61, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    d((byte) (76 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), new char[]{5, '\n', 7, '\r', '.', 6}, 7 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + 912, 18 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                e((byte) (-getAuthRequestContext[30]), getAuthRequestContext[2], getAuthRequestContext[31], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                e((byte) (-getAuthRequestContext[30]), getAuthRequestContext[7], (byte) (getAuthRequestContext[34] + 1), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(56 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 3 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1));
                        Object[] objArr16 = new Object[1];
                        f((byte) (-$$d[12]), (byte) (-$$d[53]), $$d[47], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - ExpandableListView.getPackedPositionGroup(0L), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 14, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + 800, 14 - TextUtils.lastIndexOf("", '0', 0), (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(816 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), Color.green(0) + 29, (char) (57994 - (ViewConfiguration.getScrollDefaultDelay() >> 16)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + 800, 16 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) ((Process.getThreadPriority(0) + 20) >> 6)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), 35 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-538876847, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ExpandableListView.getPackedPositionChild(0L), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 18, (char) ((-1) - ImageFormat.getBitsPerPixel(0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                e((byte) (-getAuthRequestContext[30]), getAuthRequestContext[2], getAuthRequestContext[31], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                e((byte) (-getAuthRequestContext[30]), getAuthRequestContext[7], (byte) (getAuthRequestContext[34] + 1), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - KeyEvent.normalizeMetaState(0), (ViewConfiguration.getPressedStateDuration() >> 16) + 46, (char) (ViewConfiguration.getFadingEdgeLength() >> 16));
                        Object[] objArr22 = new Object[1];
                        f((byte) ($$d[47] - 1), $$d[20], (byte) ($$d[47] - 1), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getTouchSlop() >> 8), 35 - KeyEvent.keyCodeFromString(""), (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-538876847, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + 911, (ViewConfiguration.getLongPressTimeout() >> 16) + 18, (char) View.MeasureSpec.getMode(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                e((byte) (-getAuthRequestContext[30]), getAuthRequestContext[2], getAuthRequestContext[31], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                e((byte) (-getAuthRequestContext[30]), getAuthRequestContext[7], (byte) (getAuthRequestContext[34] + 1), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), TextUtils.indexOf("", "", 0, 0) + 3, (char) (38968 - KeyEvent.getDeadChar(0, 0)));
                        Object[] objArr28 = new Object[1];
                        f((byte) ($$d[47] - 1), $$d[20], (byte) ($$d[47] - 1), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 35 - View.MeasureSpec.getMode(0), (char) View.MeasureSpec.getMode(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-538876847, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + 911, 18 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                e((byte) (-getAuthRequestContext[30]), getAuthRequestContext[2], getAuthRequestContext[31], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                e((byte) (-getAuthRequestContext[30]), getAuthRequestContext[7], (byte) (getAuthRequestContext[34] + 1), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + 107, Color.alpha(0) + 3, (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1));
                        Object[] objArr34 = new Object[1];
                        f((byte) (-$$d[9]), (byte) ($$d[47] - 1), (byte) (-$$d[8]), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.combineMeasuredStates(0, 0), 35 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) View.combineMeasuredStates(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-538876847, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 911, 17 - TextUtils.indexOf((CharSequence) "", '0'), (char) TextUtils.indexOf("", ""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
    public void initData() {
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        d((byte) (super.getResources().getString(R.string.res_0x7f13171b_getwalletv3recommendationconfig_lambda_193).substring(14, 16).length() + 60), new char[]{0, 27, '*', 29, '#', 16, '/', '\b', ',', '%', '\b', '!', 30, '#', 21, ')', 13863, 13863}, TextUtils.getCapsMode("", 0, 0) + 18, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        d((byte) (getPackageName().length() + 105), new char[]{'+', '%', 0, 16, 13934}, TextUtils.lastIndexOf("", '0', 0) + 6, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                d((byte) ((ViewConfiguration.getTouchSlop() >> 8) + 113), new char[]{0, 27, '*', 29, '#', 16, '/', '\b', 5, 27, '!', 19, 6, JSONLexer.EOI, 7, 16, 18, 15, '\b', '%', '\t', 22, '#', '*', 1, '0'}, TextUtils.lastIndexOf("", '0', 0, 0) + 27, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                try {
                    Object[] objArr5 = new Object[1];
                    e(getAuthRequestContext[2], getAuthRequestContext[32], (byte) (getAuthRequestContext[59] + 1), objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    e(getAuthRequestContext[27], getAuthRequestContext[13], getAuthRequestContext[2], objArr6);
                    Object[] objArr7 = new Object[1];
                    d((byte) (((ApplicationInfo) cls3.getMethod((String) objArr6[0], null).invoke(this, null)).targetSdkVersion + 30), new char[]{21, 6, 13863, 13863, '*', 28, '\f', 2, 13865, 13865, 17, 15, Typography.quote, '\r', 7, 16, '#', 23}, 19 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), objArr7);
                    baseContext = (Context) cls2.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - Drawable.resolveOpacity(0, 0), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr8 = new Object[1];
                    d((byte) (getPackageName().codePointAt(0) - 31), new char[]{'0', 21, 29, 24, '\b', '-', 1, 24, 0, '*', 24, '0', ')', '*', 3, InputCardNumberView.DIVIDER, 13813, 13813, Typography.quote, 3, '0', 22, 24, Typography.quote, ',', '0', 29, 1, '*', ',', 0, ')', '\n', Typography.amp, '-', 6, 3, '\n', 24, '\b', '+', '.', '\n', Typography.quote, '(', 5, 28, Typography.amp}, super.getResources().getString(R.string.mp_empty_mini_programs).substring(8, 9).length() + 47, objArr8);
                    String str = (String) objArr8[0];
                    try {
                        Object[] objArr9 = new Object[1];
                        e(getAuthRequestContext[2], getAuthRequestContext[32], (byte) (getAuthRequestContext[59] + 1), objArr9);
                        Class<?> cls4 = Class.forName((String) objArr9[0]);
                        e(getAuthRequestContext[27], getAuthRequestContext[13], getAuthRequestContext[2], new Object[1]);
                        Object[] objArr10 = new Object[1];
                        d((byte) (((ApplicationInfo) cls4.getMethod((String) r3[0], null).invoke(this, null)).targetSdkVersion - 21), new char[]{4, '0', 29, '-', 3, '\n', '\b', 24, '0', 22, 4, '-', '.', 1, 6, 11, 13748, 13748, '.', 3, '.', 1, '!', '-', InputCardNumberView.DIVIDER, Typography.quote, 0, Typography.amp, 29, 1, 13748, 13748, 22, '0', '\b', 27, 13829, 13829, '\f', '-', '-', 11, '\'', 0, 21, '0', 0, '.', 13749, 13749, '-', 0, 0, '-', 11, 3, 11, 3, JSONLexer.EOI, Typography.quote, 1, 25, ',', '0'}, getPackageName().codePointAt(4) - 33, objArr10);
                        String str2 = (String) objArr10[0];
                        byte length = (byte) (getPackageName().length() + 42);
                        char[] cArr = {'.', 6, '(', 28, 0, '-', 6, 20, 13779, 13779, 25, 1, 5, '.', 7, '-', 0, ')', '\b', '0', '/', Typography.quote, 5, '0', '+', '.', 1, 24, 13869, 13869, '0', 21, '+', ',', '+', 27, 28, '/', 29, 24, 24, '+', 6, 11, 24, '\b', 5, Typography.quote, 3, '\n', 21, ')', '.', 6, '.', '/', '+', '/', '\n', Typography.amp, '.', '/', '-', 4};
                        try {
                            Object[] objArr11 = new Object[1];
                            e(getAuthRequestContext[2], getAuthRequestContext[32], (byte) (getAuthRequestContext[59] + 1), objArr11);
                            Class<?> cls5 = Class.forName((String) objArr11[0]);
                            Object[] objArr12 = new Object[1];
                            e(getAuthRequestContext[27], getAuthRequestContext[13], getAuthRequestContext[2], objArr12);
                            Object[] objArr13 = new Object[1];
                            d(length, cArr, ((ApplicationInfo) cls5.getMethod((String) objArr12[0], null).invoke(this, null)).targetSdkVersion + 31, objArr13);
                            String str3 = (String) objArr13[0];
                            Object[] objArr14 = new Object[1];
                            d((byte) (super.getResources().getString(R.string.request_money_amount_calculator_action).substring(2, 3).length() + 88), new char[]{30, 16, '\f', 23, InputCardNumberView.DIVIDER, 23, 13838, 13838, '0', 1, 27, 0, '\r', '\n', 21, 30, ')', 0, '\r', 23, 2, Typography.quote, '\n', '\r', 2, 1, 0, Typography.quote, ',', 29, 14, 7, 0, Typography.quote, '(', 7, 23, ')', '.', '\t', 5, 27, 18, 7, 21, 28, 0, Typography.dollar, '%', 16, '\n', 18, '.', '\r', Typography.amp, 14, '*', 28, 16, '%'}, super.getResources().getString(R.string.otp_title).substring(3, 4).length() + 59, objArr14);
                            String str4 = (String) objArr14[0];
                            Object[] objArr15 = new Object[1];
                            d((byte) (Process.getGidForName("") + 76), new char[]{5, '\n', 7, '\r', '.', 6}, super.getResources().getString(R.string.my_bills_internet_connection_problem).substring(18, 21).length() + 3, objArr15);
                            try {
                                Object[] objArr16 = {baseContext, str, str2, str3, str4, true, (String) objArr15[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + 911, TextUtils.lastIndexOf("", '0', 0, 0) + 19, (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                }
                                ((Method) obj2).invoke(invoke, objArr16);
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
            Object[] objArr17 = new Object[1];
            e((byte) (-getAuthRequestContext[30]), getAuthRequestContext[2], getAuthRequestContext[31], objArr17);
            Class<?> cls6 = Class.forName((String) objArr17[0]);
            Object[] objArr18 = new Object[1];
            e((byte) (-getAuthRequestContext[30]), getAuthRequestContext[7], (byte) (getAuthRequestContext[34] + 1), objArr18);
            try {
                Object[] objArr19 = {Integer.valueOf(((Integer) cls6.getMethod((String) objArr18[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - ExpandableListView.getPackedPositionType(0L), 4 - (Process.myPid() >> 22), (char) ('0' - AndroidCharacter.getMirror('0')));
                    Object[] objArr20 = new Object[1];
                    f((byte) (-$$d[9]), (byte) ($$d[47] - 1), (byte) (-$$d[8]), objArr20);
                    obj3 = cls7.getMethod((String) objArr20[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr21 = (Object[]) ((Method) obj3).invoke(null, objArr19);
                int i = ((int[]) objArr21[1])[0];
                if (((int[]) objArr21[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 36, (char) TextUtils.indexOf("", "", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr22 = {1356531902, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myTid() >> 22) + 911, View.getDefaultSize(0, 0) + 18, (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr22);
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
                setContentView(com.alipay.mobile.verifyidentity.business.security.R.layout.activity_security_list);
                findViewById(com.alipay.mobile.verifyidentity.business.security.R.id.ll_back).setOnClickListener(this);
                this.lv_content = (ListView) findViewById(com.alipay.mobile.verifyidentity.business.security.R.id.lv_content);
                SecurityListAdapter securityListAdapter = new SecurityListAdapter(this, this.menuItemList, com.alipay.mobile.verifyidentity.business.security.R.layout.security_item);
                this.adapter = securityListAdapter;
                this.lv_content.setAdapter((ListAdapter) securityListAdapter);
                this.tv_title = (TextView) findViewById(com.alipay.mobile.verifyidentity.business.security.R.id.tv_title);
                this.rl_title = findViewById(com.alipay.mobile.verifyidentity.business.security.R.id.rl_title);
                initListData();
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

    private void processIntent() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        this.userId = intent.getStringExtra("userId");
        this.sceneId = intent.getStringExtra("sceneId");
        this.tntInstId = intent.getStringExtra(RequestConstants.SecVIKeyTntInstId);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        processIntent();
    }

    protected void initListData() {
        Message message = (Message) getIntent().getSerializableExtra("message");
        this.message = message;
        if (message != null) {
            this.sceneId = message.getSceneId();
            this.userId = this.message.getUserId();
            this.tntInstId = this.message.getTntInstId();
            String data = this.message.getData();
            this.secData = this.message.getSecData();
            this.action = this.message.getAction();
            this.productCode = this.message.getProductCode();
            parceJsonResult(data);
        }
        if (this.mshowMenu) {
            this.adapter.notifyDataSetChanged();
        }
        this.tv_title.setText(this.menuTitle);
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            d((byte) (113 - TextUtils.getOffsetAfter("", 0)), new char[]{0, 27, '*', 29, '#', 16, '/', '\b', 5, 27, '!', 19, 6, JSONLexer.EOI, 7, 16, 18, 15, '\b', '%', '\t', 22, '#', '*', 1, '0'}, super.getResources().getString(R.string.financial_header_total_assets).substring(0, 9).length() + 17, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            d((byte) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 63), new char[]{21, 6, 13863, 13863, '*', 28, '\f', 2, 13865, 13865, 17, 15, Typography.quote, '\r', 7, 16, '#', 23}, 18 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getTrimmedLength("") + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + 911, 18 - (ViewConfiguration.getScrollBarSize() >> 8), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        if (!this.isFirstResume) {
            refleshList();
        }
        this.isFirstResume = false;
    }

    private void refleshList() {
        IAPAsyncTask.asyncTask(new IAPAsyncTask.Runner<MICRpcResponse>() { // from class: com.alipay.mobile.verifyidentity.business.security.activity.SecurityListActivity.1
            @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
            public void onFailure(IAPError iAPError) {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alipay.iap.android.common.task.async.IAPAsyncTask.Runner
            public MICRpcResponse execute() throws Exception {
                MICRpcRequest mICRpcRequest = new MICRpcRequest();
                mICRpcRequest.action = SecurityListActivity.this.action;
                mICRpcRequest.envData = new JSONObject(VIEngineUtils.getEnvData(SecurityListActivity.this)).toString();
                mICRpcRequest.module = SecurityListActivity.this.productCode;
                mICRpcRequest.prodmngId = "query";
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("userId", SecurityListActivity.this.userId);
                jSONObject.put("sceneId", SecurityListActivity.this.sceneId);
                jSONObject.put(RequestConstants.SecVIKeyTntInstId, SecurityListActivity.this.tntInstId);
                mICRpcRequest.data = jSONObject.toString();
                try {
                    return RpcSettings.retrieveRpcService().dispatch(mICRpcRequest);
                } catch (Throwable unused) {
                    return null;
                }
            }

            @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
            public void onSuccess(MICRpcResponse mICRpcResponse) {
                if (mICRpcResponse == null) {
                    return;
                }
                SecurityListActivity.this.parceJsonResult(mICRpcResponse.data);
                if (SecurityListActivity.this.mshowMenu) {
                    SecurityListActivity.this.adapter.notifyDataSetChanged();
                }
            }
        });
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parceJsonResult(String str) {
        this.menuItemList.clear();
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject(SecurityConstants.KEY_MENU_DATA);
            this.mshowMenu = jSONObject.getBoolean(SecurityConstants.KEY_SHOW_MENU);
            this.menuTitle = jSONObject.getString(SecurityConstants.KEY_MENU_TITLE);
            JSONArray jSONArray = jSONObject2.getJSONArray(SecurityConstants.KEY_MENUGROUPS);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONArray jSONArray2 = ((JSONObject) jSONArray.get(i)).getJSONArray(SecurityConstants.KEY_MENUITEMS);
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject jSONObject3 = (JSONObject) jSONArray2.get(i2);
                    MenuItem menuItem = new MenuItem();
                    JSONObject jSONObject4 = jSONObject3.getJSONObject("extInfo");
                    menuItem.setDesc(jSONObject3.getString("desc"));
                    menuItem.setRedDot(jSONObject4.getString("redDot"));
                    menuItem.setStatus(jSONObject4.getString("status"));
                    menuItem.setType(jSONObject4.getString("type"));
                    menuItem.setTitle(jSONObject3.getString("title"));
                    Map<String, String> parseRequestParam = parseRequestParam(jSONObject3.getString("url"));
                    String str2 = parseRequestParam.get("productCode");
                    String str3 = parseRequestParam.get("productId");
                    menuItem.setProductCode(str2);
                    menuItem.setProductId(str3);
                    String parceSecData = parceSecData(str2);
                    if (!TextUtils.isEmpty(parceSecData)) {
                        menuItem.setUrl(parceSecData);
                    } else {
                        menuItem.setUrl(jSONObject3.getString("url"));
                    }
                    this.menuItemList.add(menuItem);
                }
                List<MenuItem> list = this.menuItemList;
                list.get(list.size() - 1).setNeedLine(true);
            }
        } catch (Exception unused) {
        }
    }

    private String parceSecData(String str) {
        if (TextUtils.isEmpty(this.secData)) {
            return "";
        }
        try {
            return new JSONObject(this.secData).getJSONObject(str).getString("url");
        } catch (Exception unused) {
            return "";
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class SecurityListAdapter extends ListViewAdapter<MenuItem> {
        public SecurityListAdapter(Context context, List<MenuItem> list, int i) {
            super(context, list, i);
        }

        @Override // com.alipay.mobile.verifyidentity.base.adapter.ListViewAdapter
        public void convert(ViewHolder viewHolder, final MenuItem menuItem, int i) {
            ((TextView) viewHolder.getView(com.alipay.mobile.verifyidentity.business.security.R.id.tv_left)).setText(menuItem.getTitle());
            ((TextView) viewHolder.getView(com.alipay.mobile.verifyidentity.business.security.R.id.tv_status)).setText(menuItem.getDesc());
            viewHolder.getView(com.alipay.mobile.verifyidentity.business.security.R.id.red_point).setVisibility(menuItem.getRedDot().equals("TRUE") ? 0 : 4);
            viewHolder.getView(com.alipay.mobile.verifyidentity.business.security.R.id.rl_item).setOnClickListener(new View.OnClickListener() { // from class: com.alipay.mobile.verifyidentity.business.security.activity.SecurityListActivity.SecurityListAdapter.1
                private static int $10 = 0;
                private static int $11 = 1;
                private static int[] BuiltInFictitiousFunctionClassFactory = {-1837979870, 827843809, 97735692, 1084913501, 1914874252, -2044420824, -2786339, 181392031, -1438490910, -1920559283, -1910762689, -2090917271, -292549676, -276194174, -1851194684, -1781297425, 1732286031, -283312115};
                private static int MyBillsEntityDataFactory = 1;
                private static int getAuthRequestContext;

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    OnClickUrl onClickUrl;
                    int i2 = MyBillsEntityDataFactory + 97;
                    getAuthRequestContext = i2 % 128;
                    Object[] objArr = null;
                    if (i2 % 2 != 0) {
                        boolean isEmpty = TextUtils.isEmpty(menuItem.getProductCode());
                        objArr.hashCode();
                        if (isEmpty) {
                            return;
                        }
                    } else {
                        if (TextUtils.isEmpty(menuItem.getProductCode())) {
                            return;
                        }
                    }
                    String productCode = menuItem.getProductCode();
                    if (productCode.equals("email")) {
                        OnClickUrl onClickUrl2 = VIEngine.getOnClickUrl();
                        if (onClickUrl2 != null) {
                            onClickUrl2.onClickHttpUrl(SecurityListActivity.this, menuItem.getUrl());
                            return;
                        }
                        return;
                    }
                    Object[] objArr2 = new Object[1];
                    a(3 - View.resolveSize(0, 0), new int[]{1427934701, 2100200870}, objArr2);
                    if ((productCode.equals(((String) objArr2[0]).intern()) ? 'G' : (char) 14) != 14) {
                        int i3 = MyBillsEntityDataFactory + 39;
                        getAuthRequestContext = i3 % 128;
                        if (i3 % 2 != 0) {
                            onClickUrl = VIEngine.getOnClickUrl();
                            objArr.hashCode();
                            if (!(onClickUrl != null)) {
                                return;
                            }
                        } else {
                            onClickUrl = VIEngine.getOnClickUrl();
                            if ((onClickUrl != null ? '2' : ',') != '2') {
                                return;
                            }
                        }
                        int i4 = getAuthRequestContext + 125;
                        MyBillsEntityDataFactory = i4 % 128;
                        if ((i4 % 2 == 0 ? 'E' : '9') == '9') {
                            onClickUrl.onClickHttpUrl(SecurityListActivity.this, menuItem.getUrl());
                            return;
                        }
                        onClickUrl.onClickHttpUrl(SecurityListActivity.this, menuItem.getUrl());
                        int length = objArr.length;
                    } else if (productCode.equals(SecurityConstants.KEY_SQ)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("sceneId", SecurityListActivity.this.sceneId);
                        hashMap.put("userId", SecurityListActivity.this.userId);
                        hashMap.put(RequestConstants.SecVIKeyTntInstId, SecurityListActivity.this.tntInstId);
                        hashMap.put("bizId", UUID.randomUUID().toString());
                        hashMap.put("action", RequestConstants.QUERY_BIO_STATUS);
                        hashMap.put("productCode", productCode);
                        hashMap.put(RequestConstants.SecVIKeyProductMngId, IAPSyncCommand.COMMAND_INIT);
                        hashMap.put("productId", menuItem.getProductId());
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("module", productCode);
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("userId", SecurityListActivity.this.userId);
                            jSONObject.put("sceneId", SecurityListActivity.this.sceneId);
                            jSONObject.put(RequestConstants.SecVIKeyTntInstId, SecurityListActivity.this.tntInstId);
                            jSONObject.put("productType", menuItem.getProductId());
                            hashMap2.put("data", jSONObject.toString());
                        } catch (JSONException unused) {
                        }
                        ClientLogKitManager.getClientLogKit().log("event", new String[]{"a5.b1.c1", "0", ""}, hashMap2, "", "SecVI_Seed_SecQuestion_QueryStatus", "", "", false);
                        VIEngine.startProduct(SecurityListActivity.this, hashMap, null, new VIEngine.OnQueryResult() { // from class: com.alipay.mobile.verifyidentity.business.security.activity.SecurityListActivity.SecurityListAdapter.1.1
                            @Override // com.alipay.mobile.verifyidentity.framework.engine.VIEngine.OnQueryResult
                            public void onFail() {
                            }

                            @Override // com.alipay.mobile.verifyidentity.framework.engine.VIEngine.OnQueryResult
                            public void onSuccess() {
                            }
                        });
                    }
                }

                private static void a(int i2, int[] iArr, Object[] objArr) {
                    int length;
                    int[] iArr2;
                    int i3;
                    VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
                    char[] cArr = new char[4];
                    char[] cArr2 = new char[iArr.length * 2];
                    int[] iArr3 = BuiltInFictitiousFunctionClassFactory;
                    if (iArr3 != null) {
                        int length2 = iArr3.length;
                        int[] iArr4 = new int[length2];
                        try {
                            int i4 = $11 + 93;
                            $10 = i4 % 128;
                            int i5 = i4 % 2;
                            int i6 = 0;
                            while (true) {
                                if (i6 >= length2) {
                                    break;
                                }
                                iArr4[i6] = (int) (iArr3[i6] ^ (-3152031022165484798L));
                                i6++;
                            }
                            iArr3 = iArr4;
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                    int length3 = iArr3.length;
                    int[] iArr5 = new int[length3];
                    int[] iArr6 = BuiltInFictitiousFunctionClassFactory;
                    if (iArr6 != null) {
                        try {
                            int i7 = $10 + 19;
                            $11 = i7 % 128;
                            if (i7 % 2 == 0) {
                                length = iArr6.length;
                                iArr2 = new int[length];
                            } else {
                                length = iArr6.length;
                                iArr2 = new int[length];
                            }
                            int i8 = 0;
                            while (true) {
                                if (!(i8 < length)) {
                                    break;
                                }
                                iArr2[i8] = (int) (iArr6[i8] ^ (-3152031022165484798L));
                                i8++;
                                length3 = length3;
                            }
                            i3 = length3;
                            iArr6 = iArr2;
                        } catch (Exception e2) {
                            throw e2;
                        }
                    } else {
                        i3 = length3;
                    }
                    System.arraycopy(iArr6, 0, iArr5, 0, i3);
                    verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
                    while (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
                        int i9 = $10 + 75;
                        $11 = i9 % 128;
                        int i10 = i9 % 2;
                        cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
                        cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
                        cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
                        cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
                        verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
                        verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
                        VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr5);
                        int i11 = 0;
                        while (true) {
                            if (!(i11 < 16)) {
                                break;
                            }
                            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr5[i11];
                            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                            int i12 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i12;
                            i11++;
                            int i13 = $11 + 21;
                            $10 = i13 % 128;
                            int i14 = i13 % 2;
                        }
                        int i15 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                        verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                        verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i15;
                        verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr5[16];
                        verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr5[17];
                        int i16 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                        int i17 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                        cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
                        cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                        cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
                        cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                        VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr5);
                        cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
                        cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
                        cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
                        cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
                        verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
                    }
                    String str = new String(cArr2, 0, i2);
                    int i18 = $11 + 9;
                    $10 = i18 % 128;
                    if (i18 % 2 == 0) {
                        objArr[0] = str;
                        return;
                    }
                    Object[] objArr2 = null;
                    int length4 = objArr2.length;
                    objArr[0] = str;
                }
            });
        }
    }

    public Map<String, String> parseRequestParam(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        if (str.contains("?")) {
            String[] split = str.split("\\?", 2);
            if (split.length < 2) {
                return null;
            }
            str = split[1];
        }
        if (str.contains(ContainerUtils.FIELD_DELIMITER)) {
            for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
                parseBasicParam(hashMap, str2);
            }
            return hashMap;
        }
        parseBasicParam(hashMap, str);
        return hashMap;
    }

    private void parseBasicParam(Map<String, String> map, String str) {
        String[] split = str.split("=");
        if (split.length < 2) {
            return;
        }
        map.put(split[0], split[1]);
    }

    @Override // com.alipay.mobile.verifyidentity.business.activity.BaseActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            d((byte) (super.getResources().getString(R.string.account_freeze_title).substring(4, 5).length() + 112), new char[]{0, 27, '*', 29, '#', 16, '/', '\b', 5, 27, '!', 19, 6, JSONLexer.EOI, 7, 16, 18, 15, '\b', '%', '\t', 22, '#', '*', 1, '0'}, (ViewConfiguration.getEdgeSlop() >> 16) + 26, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte length = (byte) (super.getResources().getString(R.string.feed_sharing_activation_dialog_desc).substring(8, 9).length() + 62);
            char[] cArr = {21, 6, 13863, 13863, '*', 28, '\f', 2, 13865, 13865, 17, 15, Typography.quote, '\r', 7, 16, '#', 23};
            try {
                Object[] objArr2 = new Object[1];
                e(getAuthRequestContext[2], getAuthRequestContext[32], (byte) (getAuthRequestContext[59] + 1), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                e(getAuthRequestContext[27], getAuthRequestContext[13], getAuthRequestContext[2], new Object[1]);
                Object[] objArr3 = new Object[1];
                d(length, cArr, ((ApplicationInfo) cls2.getMethod((String) r10[0], null).invoke(this, null)).targetSdkVersion - 15, objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (ViewConfiguration.getEdgeSlop() >> 16) + 35, (char) View.resolveSizeAndState(0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 19 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) ((-1) - TextUtils.lastIndexOf("", '0')))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
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
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        finish();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    private static void d(byte b, char[] cArr, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = BuiltInFictitiousFunctionClassFactory;
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
