package com.alibaba.griver.core.ui.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
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
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.app.AppNode;
import com.alibaba.ariver.app.activity.ActivityHelper;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppContext;
import com.alibaba.ariver.app.api.activity.StartClientBundle;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.IIpcChannel;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcChannelManager;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.griver.api.activity.GriverActivityRestoreExtension;
import com.alibaba.griver.api.common.activity.ActivityHelperExtension;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.api.ui.splash.GriverSplashFragmentExtension;
import com.alibaba.griver.base.common.action.GriverInterceptBackEventExtension;
import com.alibaba.griver.base.common.action.GriverSplashBackButtonVisibilityExtension;
import com.alibaba.griver.base.common.adapter.ImageListener;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import com.alibaba.griver.base.common.utils.ImageUtils;
import com.alibaba.griver.base.common.utils.UCUtils;
import com.alibaba.griver.base.resource.appcenter.GriverAppCenter;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitor;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitorManager;
import com.alibaba.griver.base.stagemonitor.impl.GriverFullLinkStageMonitor;
import com.alibaba.griver.base.stagemonitor.impl.GriverKeepAliveFullLinkStageMonitor;
import com.alibaba.griver.core.keepalive.KeepAliveAppManager;
import com.alibaba.griver.core.kernel.ipc.server.IpcMsgServerService;
import com.alibaba.griver.core.ui.NebulaAppContext;
import com.alibaba.griver.core.utils.DiagnosticToolUtils;
import com.alibaba.griver.core.utils.WebViewUtils;
import com.alibaba.griver.image.framework.utils.FileUtils;
import com.alibaba.griver.ui.splash.GriverSplashView;
import com.alibaba.griver.ui.splash.LoadingView;
import com.alibaba.griver.ui.splash.SplashFragment;
import com.alibaba.griver.ui.splash.SplashLoadingView;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.android.phone.mobilesdk.socketcraft.api.WSContextConstant;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.Typography;
import o.A;
import o.C;
import o.D;
import o.E;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;
import o.getCallingPid;
import o.getOnBoardingScenario;
import o.whenAvailable;

/* loaded from: classes2.dex */
public class GriverBaseActivity extends FragmentActivity {
    public static Class[] ACTIVITY_BACK_CLASSES;
    public static Class[] ACTIVITY_CLASSES;
    private static char PlaceComponentResult;
    private static char lookAheadTest;
    private static char moveToNextValue;
    private static char scheduleImpl;
    protected ActivityHelper mActivityHelper;
    protected ActivityHelperExtension mActivityHelperExtension;
    public static final byte[] $$a = {75, -23, 102, -23, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 129;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {16, -117, -56, -112, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int getAuthRequestContext = 20;

    static void BuiltInFictitiousFunctionClassFactory() {
        moveToNextValue = (char) 32864;
        PlaceComponentResult = (char) 39162;
        lookAheadTest = (char) 46461;
        scheduleImpl = (char) 48255;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0028). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = 56 - r8
            int r6 = 23 - r6
            byte[] r0 = com.alibaba.griver.core.ui.activity.GriverBaseActivity.KClassImpl$Data$declaredNonStaticMembers$2
            int r7 = r7 + 97
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L13
            r3 = r7
            r4 = 0
            r7 = r6
            goto L28
        L13:
            r3 = 0
        L14:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L23:
            r3 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r5
        L28:
            int r3 = -r3
            int r6 = r6 + r3
            int r6 = r6 + (-4)
            int r8 = r8 + 1
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverBaseActivity.c(byte, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(byte r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 3
            int r8 = r8 + 21
            int r6 = r6 * 2
            int r6 = r6 + 75
            int r7 = r7 + 4
            byte[] r0 = com.alibaba.griver.core.ui.activity.GriverBaseActivity.$$a
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
            int r4 = -r4
            int r8 = r8 + r4
            int r8 = r8 + (-7)
            r5 = r8
            r8 = r6
            r6 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverBaseActivity.d(byte, int, short, java.lang.Object[]):void");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        b(17 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), new char[]{60049, 1903, 32471, 38367, 44289, 24015, 3080, 15861, 16483, 30326, 64632, 16258, 13985, 34802, 36946, 36011, 48896, 58344}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 4, new char[]{27373, 51673, 46214, 29619, 28578, 42816}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.alpha(0), 34 - Process.getGidForName(""), (char) Drawable.resolveOpacity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b(48 - (ViewConfiguration.getWindowTouchSlop() >> 8), new char[]{57145, 64158, 32336, 35236, 45191, 18535, 10193, 57635, 7481, 50887, 47302, 3721, 21218, 30540, 31466, 50948, 64436, 62667, 22716, 10238, 33426, 4654, 22233, 7326, 10649, 42878, 64259, 64758, 29817, 40688, 53248, 24769, 165, 38736, 40755, 9185, 23842, 25569, 15026, 2526, 62199, 60197, 25212, 63901, 58966, 18608, 62123, 30351}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(63 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), new char[]{59345, 44215, 53878, 13459, 23842, 25569, 45676, 58111, 33426, 4654, 18397, 58825, 17130, 24778, 11640, 155, 61077, 51522, 11235, 30887, 17130, 24778, 17949, 5900, 16793, 28349, 44970, 64928, 64259, 64758, 61077, 51522, 41288, 42431, 39483, 62416, 5023, 32593, 64623, 23104, 34618, 50457, 25370, 16455, 59196, 50670, 15848, 54038, 10019, 554, 11986, 59278, 11818, 58406, 565, 52507, 565, 52507, 404, 42140, 9428, 13481, 10649, 42878}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b(TextUtils.getTrimmedLength("") + 64, new char[]{56274, 31262, 23894, 53751, 11818, 58406, 36666, 25234, 3210, 16494, 54448, 41699, 60095, 725, 36172, 35165, 53248, 24769, 7888, 61413, 46132, 39264, 37883, 60638, 62199, 60197, 10193, 57635, 10368, 65527, 57145, 64158, 13305, 1899, 8247, 55957, 51231, 19659, 32336, 35236, 7479, 11867, 11640, 155, 15026, 2526, 28051, 24728, 23842, 25569, 36946, 36011, 56274, 31262, 56163, 60085, 50595, 44165, 165, 38736, 56163, 60085, 27911, 8446}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(60 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), new char[]{27574, 44037, 64043, 50836, 63458, 55132, 39995, 58458, 64646, 42464, 58545, 1523, 23558, 28522, 15432, 64288, 55167, 42366, 22538, 22029, 40315, 36471, 5087, 12287, 63984, 10798, 13075, 29064, 10698, 7959, 51817, 17616, 13075, 29064, 65035, 36086, 58107, 19753, 4450, 45198, 39421, 49374, 10763, 5524, 64016, 6451, 51004, 19546, 58766, 48488, 631, 62445, 48232, 14403, 64293, 25858, 11851, 29397, 29908, 15123}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b((ViewConfiguration.getJumpTapTimeout() >> 16) + 6, new char[]{57963, 61231, 64185, 28600, 56274, 31262}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 911, (ViewConfiguration.getEdgeSlop() >> 16) + 18, (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                Object[] objArr13 = {this};
                Object[] objArr14 = new Object[1];
                c(KClassImpl$Data$declaredNonStaticMembers$2[30], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[32]), (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[31]), objArr14);
                Class<?> cls2 = Class.forName((String) objArr14[0]);
                byte b = KClassImpl$Data$declaredNonStaticMembers$2[30];
                byte b2 = (byte) (b + 1);
                Object[] objArr15 = new Object[1];
                c(b, b2, (byte) (b2 | 22), objArr15);
                try {
                    Object[] objArr16 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr15[0], Object.class).invoke(null, objArr13)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - TextUtils.getOffsetBefore("", 0), 4 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1));
                        byte b3 = $$a[47];
                        Object[] objArr17 = new Object[1];
                        d(b3, (byte) (b3 - 1), $$a[47], objArr17);
                        obj3 = cls3.getMethod((String) objArr17[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr16);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), TextUtils.getTrimmedLength("") + 15, (char) (Process.myTid() >> 22))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 15, (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr18 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(814 - ExpandableListView.getPackedPositionChild(0L), 29 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, 15 - Drawable.resolveOpacity(0, 0), (char) (KeyEvent.getMaxKeyCode() >> 16)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr18));
                                    long j = ((r8 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) TextUtils.getOffsetAfter("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr19 = {-1626191051, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.alpha(0), TextUtils.getOffsetBefore("", 0) + 18, (char) ExpandableListView.getPackedPositionType(0L))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj8);
                                            }
                                            ((Method) obj8).invoke(invoke3, objArr19);
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
                Object[] objArr20 = {this};
                Object[] objArr21 = new Object[1];
                c(KClassImpl$Data$declaredNonStaticMembers$2[30], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[32]), (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[31]), objArr21);
                Class<?> cls4 = Class.forName((String) objArr21[0]);
                byte b4 = KClassImpl$Data$declaredNonStaticMembers$2[30];
                byte b5 = (byte) (b4 + 1);
                Object[] objArr22 = new Object[1];
                c(b4, b5, (byte) (b5 | 22), objArr22);
                try {
                    Object[] objArr23 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr22[0], Object.class).invoke(null, objArr20)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - View.getDefaultSize(0, 0), View.resolveSize(0, 0) + 46, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)));
                        Object[] objArr24 = new Object[1];
                        d((byte) (-$$a[9]), (byte) (-$$a[1]), (byte) ($$a[47] - 1), objArr24);
                        obj9 = cls5.getMethod((String) objArr24[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr25 = (Object[]) ((Method) obj9).invoke(null, objArr23);
                    int i = ((int[]) objArr25[1])[0];
                    if (((int[]) objArr25[0])[0] != i) {
                        long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), TextUtils.lastIndexOf("", '0') + 36, (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr26 = {-1626191051, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + 911, (KeyEvent.getMaxKeyCode() >> 16) + 18, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr26);
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
                Object[] objArr27 = {this};
                Object[] objArr28 = new Object[1];
                c(KClassImpl$Data$declaredNonStaticMembers$2[30], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[32]), (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[31]), objArr28);
                Class<?> cls6 = Class.forName((String) objArr28[0]);
                byte b6 = KClassImpl$Data$declaredNonStaticMembers$2[30];
                byte b7 = (byte) (b6 + 1);
                Object[] objArr29 = new Object[1];
                c(b6, b7, (byte) (b7 | 22), objArr29);
                try {
                    Object[] objArr30 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr29[0], Object.class).invoke(null, objArr27)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + 118, 3 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) (View.resolveSize(0, 0) + 38968));
                        Object[] objArr31 = new Object[1];
                        d((byte) (-$$a[9]), (byte) (-$$a[1]), (byte) ($$a[47] - 1), objArr31);
                        obj12 = cls7.getMethod((String) objArr31[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr32 = (Object[]) ((Method) obj12).invoke(null, objArr30);
                    int i2 = ((int[]) objArr32[1])[0];
                    if (((int[]) objArr32[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getEdgeSlop() >> 16), 35 - View.MeasureSpec.getSize(0), (char) View.getDefaultSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr33 = {-1626191051, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getTouchSlop() >> 8), 19 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (Process.myPid() >> 22))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr33);
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
                Object[] objArr34 = {this};
                Object[] objArr35 = new Object[1];
                c(KClassImpl$Data$declaredNonStaticMembers$2[30], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[32]), (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[31]), objArr35);
                Class<?> cls8 = Class.forName((String) objArr35[0]);
                byte b8 = KClassImpl$Data$declaredNonStaticMembers$2[30];
                byte b9 = (byte) (b8 + 1);
                Object[] objArr36 = new Object[1];
                c(b8, b9, (byte) (b9 | 22), objArr36);
                try {
                    Object[] objArr37 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr36[0], Object.class).invoke(null, objArr34)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + 107, 3 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                        Object[] objArr38 = new Object[1];
                        d((byte) ($$a[47] - 1), (byte) (-$$a[53]), (byte) (-$$a[8]), objArr38);
                        obj15 = cls9.getMethod((String) objArr38[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr39 = (Object[]) ((Method) obj15).invoke(null, objArr37);
                    int i3 = ((int[]) objArr39[1])[0];
                    if (((int[]) objArr39[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, KeyEvent.normalizeMetaState(0) + 35, (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr40 = {-1626191051, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + 911, 18 - Gravity.getAbsoluteGravity(0, 0), (char) ((-1) - Process.getGidForName("")))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr40);
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

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    static {
        BuiltInFictitiousFunctionClassFactory();
        ACTIVITY_CLASSES = new Class[]{Lite1.class, Lite2.class, Lite3.class};
        ACTIVITY_BACK_CLASSES = new Class[]{Back1.class, Back2.class, Back3.class, Back4.class, Back5.class, Back6.class};
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        GriverSplashFragmentExtension.AbstractSplashFragment splashFragment;
        char c;
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        b(super.getResources().getString(R.string.card_binding_onboarding_content_easy_to_manage).substring(73, 74).codePointAt(0) - 14, new char[]{60049, 1903, 32471, 38367, 44289, 24015, 3080, 15861, 16483, 30326, 64632, 16258, 13985, 34802, 36946, 36011, 48896, 58344}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        b(TextUtils.indexOf("", "") + 5, new char[]{27373, 51673, 46214, 29619, 28578, 42816}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                b(26 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), new char[]{60049, 1903, 32471, 38367, 44289, 24015, 3080, 15861, 39421, 49374, 48642, 55031, 1023, 57419, 54406, 28761, 44878, 15174, 22899, 11892, 31530, 42232, 47841, 10345, 43730, 14548}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                b(getPackageName().length() + 11, new char[]{37493, 12937, 4949, 13341, 11851, 29397, 27963, 38684, 1304, 50941, 1746, 55510, 55182, 37689, 54406, 28761, 15084, 54672}, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 930, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 34, (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        byte b = KClassImpl$Data$declaredNonStaticMembers$2[25];
                        byte b2 = b;
                        Object[] objArr6 = new Object[1];
                        c(b, b2, (byte) (b2 | TarHeader.LF_BLK), objArr6);
                        Class<?> cls3 = Class.forName((String) objArr6[0]);
                        Object[] objArr7 = new Object[1];
                        c(KClassImpl$Data$declaredNonStaticMembers$2[41], KClassImpl$Data$declaredNonStaticMembers$2[5], KClassImpl$Data$declaredNonStaticMembers$2[25], objArr7);
                        Object[] objArr8 = new Object[1];
                        b(((ApplicationInfo) cls3.getMethod((String) objArr7[0], null).invoke(this, null)).targetSdkVersion + 15, new char[]{57145, 64158, 32336, 35236, 45191, 18535, 10193, 57635, 7481, 50887, 47302, 3721, 21218, 30540, 31466, 50948, 64436, 62667, 22716, 10238, 33426, 4654, 22233, 7326, 10649, 42878, 64259, 64758, 29817, 40688, 53248, 24769, 165, 38736, 40755, 9185, 23842, 25569, 15026, 2526, 62199, 60197, 25212, 63901, 58966, 18608, 62123, 30351}, objArr8);
                        String str = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        b(super.getResources().getString(R.string.sendmoneygroup_x2p_searchview_hint).substring(4, 5).codePointAt(0) + 32, new char[]{59345, 44215, 53878, 13459, 23842, 25569, 45676, 58111, 33426, 4654, 18397, 58825, 17130, 24778, 11640, 155, 61077, 51522, 11235, 30887, 17130, 24778, 17949, 5900, 16793, 28349, 44970, 64928, 64259, 64758, 61077, 51522, 41288, 42431, 39483, 62416, 5023, 32593, 64623, 23104, 34618, 50457, 25370, 16455, 59196, 50670, 15848, 54038, 10019, 554, 11986, 59278, 11818, 58406, 565, 52507, 565, 52507, 404, 42140, 9428, 13481, 10649, 42878}, objArr9);
                        String str2 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        b(View.MeasureSpec.makeMeasureSpec(0, 0) + 64, new char[]{56274, 31262, 23894, 53751, 11818, 58406, 36666, 25234, 3210, 16494, 54448, 41699, 60095, 725, 36172, 35165, 53248, 24769, 7888, 61413, 46132, 39264, 37883, 60638, 62199, 60197, 10193, 57635, 10368, 65527, 57145, 64158, 13305, 1899, 8247, 55957, 51231, 19659, 32336, 35236, 7479, 11867, 11640, 155, 15026, 2526, 28051, 24728, 23842, 25569, 36946, 36011, 56274, 31262, 56163, 60085, 50595, 44165, 165, 38736, 56163, 60085, 27911, 8446}, objArr10);
                        String str3 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        b(super.getResources().getString(R.string.min_debit_amount).substring(0, 16).length() + 44, new char[]{27574, 44037, 64043, 50836, 63458, 55132, 39995, 58458, 64646, 42464, 58545, 1523, 23558, 28522, 15432, 64288, 55167, 42366, 22538, 22029, 40315, 36471, 5087, 12287, 63984, 10798, 13075, 29064, 10698, 7959, 51817, 17616, 13075, 29064, 65035, 36086, 58107, 19753, 4450, 45198, 39421, 49374, 10763, 5524, 64016, 6451, 51004, 19546, 58766, 48488, 631, 62445, 48232, 14403, 64293, 25858, 11851, 29397, 29908, 15123}, objArr11);
                        String str4 = (String) objArr11[0];
                        Object[] objArr12 = new Object[1];
                        b(super.getResources().getString(R.string.share_activity_cancel_dialog_button_positive).substring(0, 1).length() + 5, new char[]{57963, 61231, 64185, 28600, 56274, 31262}, objArr12);
                        try {
                            Object[] objArr13 = {baseContext, str, str2, str3, str4, true, (String) objArr12[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + 911, TextUtils.lastIndexOf("", '0', 0, 0) + 19, (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                            }
                            ((Method) obj2).invoke(invoke, objArr13);
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
            Object[] objArr14 = new Object[1];
            c(KClassImpl$Data$declaredNonStaticMembers$2[30], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[32]), (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[31]), objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            byte b3 = KClassImpl$Data$declaredNonStaticMembers$2[30];
            byte b4 = (byte) (b3 + 1);
            Object[] objArr15 = new Object[1];
            c(b3, b4, (byte) (b4 | 22), objArr15);
            try {
                Object[] objArr16 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + 494, 5 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) TextUtils.getCapsMode("", 0, 0));
                    Object[] objArr17 = new Object[1];
                    d((byte) ($$a[47] - 1), (byte) (-$$a[53]), (byte) (-$$a[8]), objArr17);
                    obj3 = cls5.getMethod((String) objArr17[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr18 = (Object[]) ((Method) obj3).invoke(null, objArr16);
                int i = ((int[]) objArr18[1])[0];
                if (((int[]) objArr18[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 36 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) TextUtils.getOffsetBefore("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr19 = {227262562, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ImageFormat.getBitsPerPixel(0), Color.rgb(0, 0, 0) + 16777234, (char) (Process.getGidForName("") + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr19);
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
                if (bundle != null && Build.VERSION.SDK_INT == 29) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("GriverBaseActivity#onCreate, app comes into the foreground from the background, classloader=");
                    sb.append(bundle.getClassLoader());
                    GriverLogger.d("GriverBaseActivity", sb.toString());
                    bundle.setClassLoader(getClassLoader());
                }
                try {
                    super.onCreate(bundle);
                } catch (BadParcelableException e) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("GriverBaseActivity#onCreate, catch exception: ");
                    sb2.append(e.toString());
                    GriverLogger.w("GriverBaseActivity", sb2.toString());
                }
                StartClientBundle startClientBundle = (StartClientBundle) BundleUtils.getParcelable(getIntent().getExtras(), RVConstants.EXTRA_ARIVER_START_BUNDLE);
                if (!KeepAliveAppManager.getInstance().enableKeepAlive() && bundle != null && bundle.size() > 0) {
                    String string = bundle.getString("RESTORE_APPID");
                    Bundle bundle2 = bundle.getBundle("RESTORE_STARTUP_PARAMS");
                    if (RVProxy.sHasSetupProxy) {
                        MonitorMap.Builder builder = new MonitorMap.Builder();
                        builder.message("Open the app by restore");
                        GriverMonitor.error(GriverMonitorConstants.ERROR_OPEN_APP_EXCEPTION, "GriverAppContainer", builder.build());
                        ((GriverActivityRestoreExtension) RVProxy.get(GriverActivityRestoreExtension.class)).restore(this, string, bundle2);
                    }
                    finish();
                } else if (startClientBundle == null || startClientBundle.startParams == null) {
                    if (RVProxy.sHasSetupProxy) {
                        MonitorMap.Builder builder2 = new MonitorMap.Builder();
                        builder2.message("Open the app without using the correct interface");
                        GriverMonitor.error(GriverMonitorConstants.ERROR_OPEN_APP_EXCEPTION, "GriverAppContainer", builder2.build());
                    }
                    finish();
                } else if (!RVProxy.sHasSetupProxy) {
                    finish();
                } else {
                    try {
                        String string2 = BundleUtils.getString(startClientBundle.startParams, "screenOrientation", "portrait");
                        int hashCode = string2.hashCode();
                        if (hashCode == 3005871) {
                            if (string2.equals("auto")) {
                                c = 1;
                            }
                            c = 65535;
                        } else if (hashCode != 729267099) {
                            if (hashCode == 1430647483 && string2.equals("landscape")) {
                                c = 0;
                            }
                            c = 65535;
                        } else {
                            if (string2.equals("portrait")) {
                                c = 2;
                            }
                            c = 65535;
                        }
                        if (c == 0) {
                            setRequestedOrientation(0);
                        } else if (c == 1) {
                            setRequestedOrientation(-1);
                        } else {
                            setRequestedOrientation(1);
                        }
                    } catch (Throwable th6) {
                        GriverLogger.e("GriverBaseActivity", "GriverBaseActivity#onCreate, setRequestedOrientation failed", th6);
                    }
                    ActivityHelper activityHelper = new ActivityHelper(this) { // from class: com.alibaba.griver.core.ui.activity.GriverBaseActivity.1
                        @Override // com.alibaba.ariver.app.activity.ActivityHelper
                        public AppContext createAppContext(App app, FragmentActivity fragmentActivity) {
                            return new NebulaAppContext((AppNode) app, GriverBaseActivity.this, com.alibaba.griver.core.R.id.fragment_container, com.alibaba.griver.core.R.id.tab_container);
                        }
                    };
                    this.mActivityHelper = activityHelper;
                    activityHelper.setupParams(getIntent());
                    setContentView(com.alibaba.griver.core.R.layout.griver_layout_base_activity);
                    this.mActivityHelper.onCreate();
                    if (RVProxy.get(GriverSplashBackButtonVisibilityExtension.class, true) != null) {
                        a((AppNode) this.mActivityHelper.getApp());
                    }
                    if (!UCUtils.isDynamicDelivery()) {
                        overridePendingTransition(com.alibaba.griver.core.R.anim.griver_core_app_enter_up_in, com.alibaba.griver.core.R.anim.griver_core_app_enter_scale);
                    }
                    Bundle extras = getIntent().getExtras();
                    boolean z = BundleUtils.getBoolean(extras, "isTransparent", false);
                    if (z) {
                        a();
                    }
                    try {
                        WebViewUtils.setWindowSoftInputMode(this, extras, z);
                    } catch (Exception e2) {
                        GriverLogger.e("GriverBaseActivity", "setWindowSoftInputMode failed", e2);
                    }
                    final GriverFullLinkStageMonitor griverFullLinkStageMonitor = (GriverFullLinkStageMonitor) GriverStageMonitorManager.getInstance().getStageMonitor(GriverFullLinkStageMonitor.getMonitorToken(this.mActivityHelper.getApp()));
                    if (griverFullLinkStageMonitor != null) {
                        griverFullLinkStageMonitor.transitToNext(PerfId.activityCreated);
                    }
                    ActivityHelperExtension activityHelperExtension = (ActivityHelperExtension) RVProxy.get(ActivityHelperExtension.class);
                    this.mActivityHelperExtension = activityHelperExtension;
                    activityHelperExtension.bindActivity(this);
                    this.mActivityHelperExtension.onCreate(bundle);
                    DiagnosticToolUtils.showDiagnosticTool(this, this.mActivityHelper);
                    if (Build.VERSION.SDK_INT >= 28) {
                        WindowManager.LayoutParams attributes = getWindow().getAttributes();
                        attributes.layoutInDisplayCutoutMode = 0;
                        getWindow().setAttributes(attributes);
                    }
                    App app = this.mActivityHelper.getApp();
                    if (app == null || !(app instanceof AppNode)) {
                        return;
                    }
                    AppNode appNode = (AppNode) app;
                    if (appNode.getSplashView() == null || !(appNode.getSplashView() instanceof GriverSplashView) || (splashFragment = ((GriverSplashView) appNode.getSplashView()).getSplashFragment()) == null || !(splashFragment instanceof SplashFragment)) {
                        return;
                    }
                    ((SplashFragment) splashFragment).loadingViewInitListener = new SplashFragment.OnLoadingViewInitListener() { // from class: com.alibaba.griver.core.ui.activity.GriverBaseActivity.2
                        @Override // com.alibaba.griver.ui.splash.SplashFragment.OnLoadingViewInitListener
                        public void onInited(LoadingView loadingView) {
                            if (loadingView == null || !(loadingView instanceof SplashLoadingView)) {
                                return;
                            }
                            ((SplashLoadingView) loadingView).setOnCancelListener(new LoadingView.OnCancelListener() { // from class: com.alibaba.griver.core.ui.activity.GriverBaseActivity.2.1
                                @Override // com.alibaba.griver.ui.splash.LoadingView.OnCancelListener
                                public void onCancel() {
                                    if (griverFullLinkStageMonitor != null) {
                                        griverFullLinkStageMonitor.addParam(GriverMonitorConstants.MINI_PROGRAM_APP_CLOSE_TYPE, GriverMonitorConstants.MINI_PROGRAM_APP_CLOSE_BY_BACK_BUTTON);
                                    }
                                }
                            });
                        }
                    };
                }
            } catch (Throwable th7) {
                Throwable cause6 = th7.getCause();
                if (cause6 == null) {
                    throw th7;
                }
                throw cause6;
            }
        } catch (Throwable th8) {
            Throwable cause7 = th8.getCause();
            if (cause7 == null) {
                throw th8;
            }
            throw cause7;
        }
    }

    private void a() {
        ((RelativeLayout) findViewById(com.alibaba.griver.core.R.id.fragment_container)).setBackgroundColor(-1);
    }

    public String getCurrentUri() {
        App app;
        ActivityHelper activityHelper = this.mActivityHelper;
        if (activityHelper == null || (app = activityHelper.getApp()) == null || app.getActivePage() == null) {
            return null;
        }
        return app.getActivePage().getPageURI();
    }

    public App getCurrentApp() {
        ActivityHelper activityHelper = this.mActivityHelper;
        if (activityHelper == null) {
            return null;
        }
        return activityHelper.getApp();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.mActivityHelper != null) {
            if (i == 4) {
                boolean z = RVProxy.get(GriverInterceptBackEventExtension.class, true) != null;
                boolean intercept = ((GriverInterceptBackEventExtension) RVProxy.get(GriverInterceptBackEventExtension.class)).intercept((AppNode) this.mActivityHelper.getApp());
                if (z && intercept) {
                    return true;
                }
                if (this.mActivityHelper.getApp() != null && (this.mActivityHelper.getApp().isFirstPage() || this.mActivityHelper.getApp().getActivePage() == null)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(GriverFullLinkStageMonitor.MONITOR_TOKEN);
                    sb.append(this.mActivityHelper.getApp().getAppId());
                    sb.append(this.mActivityHelper.getApp().getStartToken());
                    GriverStageMonitor stageMonitor = GriverStageMonitorManager.getInstance().getStageMonitor(sb.toString());
                    if (stageMonitor != null) {
                        stageMonitor.addParam(GriverMonitorConstants.MINI_PROGRAM_APP_CLOSE_TYPE, GriverMonitorConstants.MINI_PROGRAM_APP_CLOSE_BY_KEYCODE_BACK);
                    }
                }
            }
            return this.mActivityHelper.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void a(AppNode appNode) {
        GriverSplashFragmentExtension.AbstractSplashFragment splashFragment;
        if (appNode == null) {
            return;
        }
        int visibility = ((GriverSplashBackButtonVisibilityExtension) RVProxy.get(GriverSplashBackButtonVisibilityExtension.class)).getVisibility(appNode);
        if (appNode.getSplashView() == null || !(appNode.getSplashView() instanceof GriverSplashView) || (splashFragment = ((GriverSplashView) appNode.getSplashView()).getSplashFragment()) == null || !(splashFragment instanceof SplashFragment)) {
            return;
        }
        ((SplashFragment) splashFragment).setBackButtonVisibility(visibility);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ActivityHelperExtension activityHelperExtension = this.mActivityHelperExtension;
        if (activityHelperExtension != null) {
            activityHelperExtension.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        ActivityHelper activityHelper = this.mActivityHelper;
        if (activityHelper != null) {
            activityHelper.onNewIntent(intent);
            this.mActivityHelperExtension.onNewIntent(intent);
        }
    }

    @Override // androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ActivityHelper activityHelper = this.mActivityHelper;
        if (activityHelper != null && activityHelper.getApp() != null) {
            App app = this.mActivityHelper.getApp();
            bundle.putString("RESTORE_APPID", app.getAppId());
            bundle.putBundle("RESTORE_STARTUP_PARAMS", app.getStartParams());
            bundle.putBundle("RESTORE_SCENE_PARAMS", app.getSceneParams());
        }
        GriverLogger.d("GriverBaseActivity", "onSaveInstanceState");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        ActivityHelper activityHelper = this.mActivityHelper;
        if (activityHelper != null) {
            activityHelper.onRequestPermissionResult(i, strArr, iArr);
            this.mActivityHelperExtension.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ActivityHelper activityHelper = this.mActivityHelper;
        if (activityHelper != null) {
            activityHelper.onActivityResult(i, i2, intent);
            this.mActivityHelperExtension.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        ActivityHelper activityHelper = this.mActivityHelper;
        if (activityHelper != null) {
            activityHelper.finish();
            this.mActivityHelperExtension.finish();
        }
        if (a(this)) {
            finishAndRemoveTask();
        } else {
            super.finish();
        }
    }

    private boolean a(Activity activity) {
        ActivityManager activityManager;
        if (((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext() == null || (activityManager = (ActivityManager) ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext().getSystemService(AkuEventParamsKey.KEY_ACTIVITY)) == null) {
            return true;
        }
        for (ActivityManager.RunningTaskInfo runningTaskInfo : activityManager.getRunningTasks(Integer.MAX_VALUE)) {
            if (runningTaskInfo.baseActivity != null && TextUtils.equals(activity.getClass().getName(), runningTaskInfo.baseActivity.getClassName())) {
                StringBuilder sb = new StringBuilder();
                sb.append("canRemoveTask found RunningTaskInfo: ");
                sb.append(runningTaskInfo);
                RVLogger.d("AriverInt:BaseAppContext", sb.toString());
                if (runningTaskInfo.numActivities > 1) {
                    RVLogger.d("AriverInt:BaseAppContext", "canRemoveTask remove task because have another activity!");
                    return false;
                }
                return true;
            }
        }
        return true;
    }

    @Override // android.app.Activity
    public void finishAndRemoveTask() {
        ActivityHelper activityHelper = this.mActivityHelper;
        if (activityHelper != null) {
            activityHelper.finishAndRemoveTask();
        }
        super.finishAndRemoveTask();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ActivityHelper activityHelper = this.mActivityHelper;
        if (activityHelper != null) {
            activityHelper.onDestroy();
            this.mActivityHelperExtension.onDestroy();
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        ActivityHelper activityHelper = this.mActivityHelper;
        if (activityHelper != null) {
            activityHelper.onStop();
            this.mActivityHelperExtension.onStop();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                byte b = KClassImpl$Data$declaredNonStaticMembers$2[25];
                byte b2 = b;
                Object[] objArr = new Object[1];
                c(b, b2, (byte) (b2 | TarHeader.LF_BLK), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                c(KClassImpl$Data$declaredNonStaticMembers$2[41], KClassImpl$Data$declaredNonStaticMembers$2[5], KClassImpl$Data$declaredNonStaticMembers$2[25], new Object[1]);
                Object[] objArr2 = new Object[1];
                b(((ApplicationInfo) cls.getMethod((String) r7[0], null).invoke(this, null)).targetSdkVersion - 7, new char[]{60049, 1903, 32471, 38367, 44289, 24015, 3080, 15861, 39421, 49374, 48642, 55031, 1023, 57419, 54406, 28761, 44878, 15174, 22899, 11892, 31530, 42232, 47841, 10345, 43730, 14548}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b(18 - (KeyEvent.getMaxKeyCode() >> 16), new char[]{37493, 12937, 4949, 13341, 11851, 29397, 27963, 38684, 1304, 50941, 1746, 55510, 55182, 37689, 54406, 28761, 15084, 54672}, objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + 930, (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 34, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + 911, MotionEvent.axisFromString("") + 19, (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Context.class);
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
        ActivityHelper activityHelper = this.mActivityHelper;
        if (activityHelper != null) {
            activityHelper.onPause();
            this.mActivityHelperExtension.onPause();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(26 - (ViewConfiguration.getPressedStateDuration() >> 16), new char[]{60049, 1903, 32471, 38367, 44289, 24015, 3080, 15861, 39421, 49374, 48642, 55031, 1023, 57419, 54406, 28761, 44878, 15174, 22899, 11892, 31530, 42232, 47841, 10345, 43730, 14548}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b(getPackageName().codePointAt(3) - 82, new char[]{37493, 12937, 4949, 13341, 11851, 29397, 27963, 38684, 1304, 50941, 1746, 55510, 55182, 37689, 54406, 28761, 15084, 54672}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, Color.blue(0) + 35, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + 911, TextUtils.lastIndexOf("", '0') + 19, (char) Color.blue(0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        ActivityHelper activityHelper = this.mActivityHelper;
        if (activityHelper != null) {
            activityHelper.onResume();
            this.mActivityHelperExtension.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        ActivityHelper activityHelper = this.mActivityHelper;
        if (activityHelper != null) {
            activityHelper.onUserLeaveHint();
        }
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        super.onUserInteraction();
        ActivityHelper activityHelper = this.mActivityHelper;
        if (activityHelper != null) {
            activityHelper.onUserInteraction();
        }
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActivityHelper activityHelper = this.mActivityHelper;
        if (activityHelper != null) {
            activityHelper.onConfigurationChanged(configuration);
        }
    }

    /* loaded from: classes6.dex */
    public static class Main extends GriverBaseActivity {
        public static final byte[] $$d = {8, 17, -121, -18, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
        public static final int $$e = WSContextConstant.HANDSHAKE_RECEIVE_SIZE;
        public static final byte[] PlaceComponentResult = {104, -1, -63, 36, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
        public static final int moveToNextValue = 88;
        private static int[] NetworkUserEntityData$$ExternalSyntheticLambda0 = {498249613, -1513366847, -1708989957, -878876929, -1072269836, 2038733218, -108527094, 856867750, -97722236, -1556381136, 35684931, -829598580, -762091693, 270449137, 1987159668, -2072921594, -1150793625, 969320274};

        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002a). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void f(int r6, byte r7, byte r8, java.lang.Object[] r9) {
            /*
                int r7 = 106 - r7
                int r6 = r6 + 4
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverBaseActivity.Main.PlaceComponentResult
                int r8 = 23 - r8
                byte[] r1 = new byte[r8]
                int r8 = r8 + (-1)
                r2 = 0
                if (r0 != 0) goto L13
                r3 = r7
                r4 = 0
                r7 = r6
                goto L2a
            L13:
                r3 = 0
            L14:
                byte r4 = (byte) r7
                r1[r3] = r4
                int r6 = r6 + 1
                int r4 = r3 + 1
                if (r3 != r8) goto L25
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L25:
                r3 = r0[r6]
                r5 = r7
                r7 = r6
                r6 = r5
            L2a:
                int r3 = -r3
                int r6 = r6 + r3
                int r6 = r6 + (-4)
                r3 = r4
                r5 = r7
                r7 = r6
                r6 = r5
                goto L14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverBaseActivity.Main.f(int, byte, byte, java.lang.Object[]):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002c). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void g(int r6, byte r7, byte r8, java.lang.Object[] r9) {
            /*
                int r6 = r6 * 2
                int r6 = 103 - r6
                int r8 = r8 + 4
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverBaseActivity.Main.$$d
                int r7 = r7 * 3
                int r7 = r7 + 21
                byte[] r1 = new byte[r7]
                int r7 = r7 + (-1)
                r2 = 0
                if (r0 != 0) goto L17
                r6 = r7
                r4 = r8
                r3 = 0
                goto L2c
            L17:
                r3 = 0
            L18:
                byte r4 = (byte) r6
                r1[r3] = r4
                if (r3 != r7) goto L25
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L25:
                r4 = r0[r8]
                int r3 = r3 + 1
                r5 = r7
                r7 = r6
                r6 = r5
            L2c:
                int r8 = r8 + 1
                int r7 = r7 + r4
                int r7 = r7 + (-7)
                r5 = r7
                r7 = r6
                r6 = r5
                goto L18
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverBaseActivity.Main.g(int, byte, byte, java.lang.Object[]):void");
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            Object[] objArr;
            Object[] objArr2;
            Object[] objArr3;
            Object[] objArr4;
            super.attachBaseContext(context);
            Object[] objArr5 = new Object[1];
            e(18 - (ViewConfiguration.getPressedStateDuration() >> 16), new int[]{-1191486257, 1728220142, -145984861, 387125705, 1625897590, 1649937476, 1026984963, 76743811, -722381723, -1600710107}, objArr5);
            Class<?> cls = Class.forName((String) objArr5[0]);
            Object[] objArr6 = new Object[1];
            e(5 - KeyEvent.getDeadChar(0, 0), new int[]{-945370047, -1002093040, -618641009, 1321333673}, objArr6);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context applicationContext = context != null ? context.getApplicationContext() : context;
                if (applicationContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getOffsetBefore("", 0), 35 - TextUtils.getOffsetBefore("", 0), (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        e(ExpandableListView.getPackedPositionGroup(0L) + 48, new int[]{-917704877, 507767010, -1800690588, -1557128890, 1692082105, 1164330415, -1940861942, -1788311524, -1847877175, 1693506965, -615003314, 674714838, 2087994561, -67047975, -112438251, -1272985607, -2137252971, -1776963234, -96306850, 2077514594, 370585765, 838924698, -437418716, -871016365}, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        e((-16777152) - Color.rgb(0, 0, 0), new int[]{989280353, 1487996737, -1003838312, -1949528249, -802512791, -509219149, -872003385, 2059034038, 188509801, -2051057113, 1285912742, 1100339995, 1473909737, -1444263412, -335641449, -869429390, 927676088, -1818713465, -1022906310, -853666911, -892213323, 1170076687, -381008118, 985414808, -852826343, 70959910, 769610104, -1137179416, -1860742795, 17838583, -1624023919, -880895251}, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        e(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 65, new int[]{-499016795, 563127685, 1294789151, 1338655781, 1021964546, 835111327, 1328029368, 1297093251, -61456517, 1368456572, -575019311, 1169568518, -741531058, -1391388155, -2131733880, 1979972058, 1294656008, 662001523, -676205568, 104629227, -241546421, 1530755582, -847194902, 28328136, 1880801673, -1448617197, -1112139468, -2050551769, 1874568009, 46402042, 838745438, -134678542}, objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        e(59 - ImageFormat.getBitsPerPixel(0), new int[]{-1356949019, -1360717653, -974124705, -1161892522, 982077517, 2024670903, 1897753901, 748155088, 1608731282, 1417842260, 519628481, 1217903930, -1874639200, -117919361, 1004810374, 939668086, -1186273421, 1179124665, -1808251933, 1465126596, 130517742, 70932477, 48066468, -985396537, -2027381228, 863723223, 574581382, 860349144, 340420839, -1765714891}, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        e(7 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), new int[]{889108049, -468270810, 1632031388, -23933498}, objArr11);
                        try {
                            Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 19 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                    Object[] objArr13 = {this};
                    Object[] objArr14 = new Object[1];
                    f(PlaceComponentResult[3], PlaceComponentResult[25], PlaceComponentResult[30], objArr14);
                    Class<?> cls2 = Class.forName((String) objArr14[0]);
                    Object[] objArr15 = new Object[1];
                    f(21, PlaceComponentResult[9], PlaceComponentResult[30], objArr15);
                    try {
                        Object[] objArr16 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr15[0], Object.class).invoke(null, objArr13)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                        if (obj3 == null) {
                            Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (ViewConfiguration.getScrollBarSize() >> 8), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 3, (char) (AndroidCharacter.getMirror('0') - '0'));
                            byte b = $$d[12];
                            byte b2 = $$d[78];
                            Object[] objArr17 = new Object[1];
                            g(b, b2, (byte) (b2 - 1), objArr17);
                            obj3 = cls3.getMethod((String) objArr17[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                        }
                        Object invoke2 = ((Method) obj3).invoke(null, objArr16);
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - Color.blue(0), 16 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("getAuthRequestContext", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                            }
                            int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                            try {
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (KeyEvent.getMaxKeyCode() >> 16) + 15, (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))))).getMethod("PlaceComponentResult", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                                }
                                if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                    ArrayList arrayList = new ArrayList();
                                    try {
                                        Object[] objArr18 = {invoke2};
                                        Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                        if (obj6 == null) {
                                            obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + 815, 30 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) (57994 - (ViewConfiguration.getPressedStateDuration() >> 16)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 15 - View.resolveSizeAndState(0, 0, 0), (char) (ViewConfiguration.getWindowTouchSlop() >> 8)));
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                        }
                                        arrayList.add(((Method) obj6).invoke(null, objArr18));
                                        long j = ((r7 ^ intValue2) & 4294967295L) | 60129542144L;
                                        try {
                                            Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                            if (obj7 != null) {
                                                objArr = null;
                                            } else {
                                                objArr = null;
                                                obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 36 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                            }
                                            Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                            try {
                                                Object[] objArr19 = {-885585238, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                                Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                                if (obj8 == null) {
                                                    obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ExpandableListView.getPackedPositionChild(0L), 18 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj8);
                                                }
                                                ((Method) obj8).invoke(invoke3, objArr19);
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
                    Object[] objArr20 = {this};
                    Object[] objArr21 = new Object[1];
                    f(PlaceComponentResult[3], PlaceComponentResult[25], PlaceComponentResult[30], objArr21);
                    Class<?> cls4 = Class.forName((String) objArr21[0]);
                    Object[] objArr22 = new Object[1];
                    f(21, PlaceComponentResult[9], PlaceComponentResult[30], objArr22);
                    try {
                        Object[] objArr23 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr22[0], Object.class).invoke(null, objArr20)).intValue())};
                        Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                        if (obj9 == null) {
                            Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 62, 46 - (ViewConfiguration.getEdgeSlop() >> 16), (char) TextUtils.getCapsMode("", 0, 0));
                            byte b3 = (byte) ($$d[78] - 1);
                            byte b4 = b3;
                            Object[] objArr24 = new Object[1];
                            g(b3, b4, (byte) (b4 | Ascii.ETB), objArr24);
                            obj9 = cls5.getMethod((String) objArr24[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                        }
                        Object[] objArr25 = (Object[]) ((Method) obj9).invoke(null, objArr23);
                        int i = ((int[]) objArr25[1])[0];
                        if (((int[]) objArr25[0])[0] != i) {
                            long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                            try {
                                Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj10 != null) {
                                    objArr2 = null;
                                } else {
                                    objArr2 = null;
                                    obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, Drawable.resolveOpacity(0, 0) + 35, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                                }
                                Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                                try {
                                    Object[] objArr26 = {-885585238, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj11 == null) {
                                        obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + 911, 18 - View.MeasureSpec.getMode(0), (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                    }
                                    ((Method) obj11).invoke(invoke4, objArr26);
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
                    Object[] objArr27 = {this};
                    Object[] objArr28 = new Object[1];
                    f(PlaceComponentResult[3], PlaceComponentResult[25], PlaceComponentResult[30], objArr28);
                    Class<?> cls6 = Class.forName((String) objArr28[0]);
                    Object[] objArr29 = new Object[1];
                    f(21, PlaceComponentResult[9], PlaceComponentResult[30], objArr29);
                    try {
                        Object[] objArr30 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr29[0], Object.class).invoke(null, objArr27)).intValue())};
                        Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                        if (obj12 == null) {
                            Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - KeyEvent.normalizeMetaState(0), 3 - View.getDefaultSize(0, 0), (char) (38968 - (ViewConfiguration.getJumpTapTimeout() >> 16)));
                            byte b5 = (byte) ($$d[78] - 1);
                            byte b6 = b5;
                            Object[] objArr31 = new Object[1];
                            g(b5, b6, (byte) (b6 | Ascii.ETB), objArr31);
                            obj12 = cls7.getMethod((String) objArr31[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                        }
                        Object[] objArr32 = (Object[]) ((Method) obj12).invoke(null, objArr30);
                        int i2 = ((int[]) objArr32[1])[0];
                        if (((int[]) objArr32[0])[0] != i2) {
                            long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                            try {
                                Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj13 != null) {
                                    objArr3 = null;
                                } else {
                                    objArr3 = null;
                                    obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                                }
                                Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                                try {
                                    Object[] objArr33 = {-885585238, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj14 == null) {
                                        obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getLongPressTimeout() >> 16), 19 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) TextUtils.getOffsetAfter("", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                    }
                                    ((Method) obj14).invoke(invoke5, objArr33);
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
                    Object[] objArr34 = {this};
                    Object[] objArr35 = new Object[1];
                    f(PlaceComponentResult[3], PlaceComponentResult[25], PlaceComponentResult[30], objArr35);
                    Class<?> cls8 = Class.forName((String) objArr35[0]);
                    Object[] objArr36 = new Object[1];
                    f(21, PlaceComponentResult[9], PlaceComponentResult[30], objArr36);
                    try {
                        Object[] objArr37 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr36[0], Object.class).invoke(null, objArr34)).intValue())};
                        Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                        if (obj15 == null) {
                            Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 107, 3 - TextUtils.getTrimmedLength(""), (char) TextUtils.getOffsetBefore("", 0));
                            Object[] objArr38 = new Object[1];
                            g($$d[9], $$d[8], $$d[53], objArr38);
                            obj15 = cls9.getMethod((String) objArr38[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                        }
                        Object[] objArr39 = (Object[]) ((Method) obj15).invoke(null, objArr37);
                        int i3 = ((int[]) objArr39[1])[0];
                        if (((int[]) objArr39[0])[0] != i3) {
                            long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                            try {
                                Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj16 != null) {
                                    objArr4 = null;
                                } else {
                                    objArr4 = null;
                                    obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - Color.argb(0, 0, 0, 0), (char) (TextUtils.indexOf((CharSequence) "", '0') + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                                }
                                Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                                try {
                                    Object[] objArr40 = {-885585238, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj17 == null) {
                                        obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), 19 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                    }
                                    ((Method) obj17).invoke(invoke6, objArr40);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return super.getApplicationContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
        public Context getBaseContext() {
            return super.getBaseContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
        public Resources getResources() {
            return super.getResources();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle bundle) {
            Object[] objArr;
            try {
                Object[] objArr2 = new Object[1];
                f(PlaceComponentResult[1], (byte) (-PlaceComponentResult[32]), PlaceComponentResult[25], objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                f((byte) (-PlaceComponentResult[59]), PlaceComponentResult[48], PlaceComponentResult[41], new Object[1]);
                Object[] objArr3 = new Object[1];
                e(((ApplicationInfo) cls.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 15, new int[]{-1191486257, 1728220142, -145984861, 387125705, 1625897590, 1649937476, 1026984963, 76743811, -722381723, -1600710107}, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                e(6 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), new int[]{-945370047, -1002093040, -618641009, 1321333673}, objArr4);
                int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                if (intValue < 99000 || intValue > 99999) {
                    Context baseContext = getBaseContext();
                    if (baseContext == null) {
                        Object[] objArr5 = new Object[1];
                        e(27 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), new int[]{-1191486257, 1728220142, -145984861, 387125705, 811307614, 1308594601, -1533917711, 1196475233, 1508720357, 1182793107, 1241147189, 1092395584, -193001857, -1571160621}, objArr5);
                        Class<?> cls3 = Class.forName((String) objArr5[0]);
                        try {
                            Object[] objArr6 = new Object[1];
                            f(PlaceComponentResult[1], (byte) (-PlaceComponentResult[32]), PlaceComponentResult[25], objArr6);
                            Class<?> cls4 = Class.forName((String) objArr6[0]);
                            f((byte) (-PlaceComponentResult[59]), PlaceComponentResult[48], PlaceComponentResult[41], new Object[1]);
                            Object[] objArr7 = new Object[1];
                            e(((ApplicationInfo) cls4.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 15, new int[]{-282369827, 298731135, -130050689, -1337600837, -2041865400, -1356098127, 2052283160, 2066336746, 1136710199, -396609809}, objArr7);
                            baseContext = (Context) cls3.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
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
                                obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 930, 35 - Gravity.getAbsoluteGravity(0, 0), (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                            }
                            Object invoke = ((Method) obj).invoke(null, null);
                            Object[] objArr8 = new Object[1];
                            e(getPackageName().codePointAt(2) + 2, new int[]{-917704877, 507767010, -1800690588, -1557128890, 1692082105, 1164330415, -1940861942, -1788311524, -1847877175, 1693506965, -615003314, 674714838, 2087994561, -67047975, -112438251, -1272985607, -2137252971, -1776963234, -96306850, 2077514594, 370585765, 838924698, -437418716, -871016365}, objArr8);
                            String str = (String) objArr8[0];
                            Object[] objArr9 = new Object[1];
                            e(64 - Drawable.resolveOpacity(0, 0), new int[]{989280353, 1487996737, -1003838312, -1949528249, -802512791, -509219149, -872003385, 2059034038, 188509801, -2051057113, 1285912742, 1100339995, 1473909737, -1444263412, -335641449, -869429390, 927676088, -1818713465, -1022906310, -853666911, -892213323, 1170076687, -381008118, 985414808, -852826343, 70959910, 769610104, -1137179416, -1860742795, 17838583, -1624023919, -880895251}, objArr9);
                            String str2 = (String) objArr9[0];
                            Object[] objArr10 = new Object[1];
                            e(getPackageName().codePointAt(2) + 18, new int[]{-499016795, 563127685, 1294789151, 1338655781, 1021964546, 835111327, 1328029368, 1297093251, -61456517, 1368456572, -575019311, 1169568518, -741531058, -1391388155, -2131733880, 1979972058, 1294656008, 662001523, -676205568, 104629227, -241546421, 1530755582, -847194902, 28328136, 1880801673, -1448617197, -1112139468, -2050551769, 1874568009, 46402042, 838745438, -134678542}, objArr10);
                            String str3 = (String) objArr10[0];
                            Object[] objArr11 = new Object[1];
                            e(Process.getGidForName("") + 61, new int[]{-1356949019, -1360717653, -974124705, -1161892522, 982077517, 2024670903, 1897753901, 748155088, 1608731282, 1417842260, 519628481, 1217903930, -1874639200, -117919361, 1004810374, 939668086, -1186273421, 1179124665, -1808251933, 1465126596, 130517742, 70932477, 48066468, -985396537, -2027381228, 863723223, 574581382, 860349144, 340420839, -1765714891}, objArr11);
                            String str4 = (String) objArr11[0];
                            try {
                                Object[] objArr12 = new Object[1];
                                f(PlaceComponentResult[1], (byte) (-PlaceComponentResult[32]), PlaceComponentResult[25], objArr12);
                                Class<?> cls5 = Class.forName((String) objArr12[0]);
                                f((byte) (-PlaceComponentResult[59]), PlaceComponentResult[48], PlaceComponentResult[41], new Object[1]);
                                Object[] objArr13 = new Object[1];
                                e(((ApplicationInfo) cls5.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 27, new int[]{889108049, -468270810, 1632031388, -23933498}, objArr13);
                                try {
                                    Object[] objArr14 = {baseContext, str, str2, str3, str4, true, (String) objArr13[0], 995651014};
                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                    if (obj2 == null) {
                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 18 - (ViewConfiguration.getScrollBarSize() >> 8), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                    }
                                    ((Method) obj2).invoke(invoke, objArr14);
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
                    }
                }
                try {
                    Object[] objArr15 = new Object[1];
                    f(PlaceComponentResult[3], PlaceComponentResult[25], PlaceComponentResult[30], objArr15);
                    Class<?> cls6 = Class.forName((String) objArr15[0]);
                    Object[] objArr16 = new Object[1];
                    f(21, PlaceComponentResult[9], PlaceComponentResult[30], objArr16);
                    try {
                        Object[] objArr17 = {Integer.valueOf(((Integer) cls6.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                        if (obj3 == null) {
                            Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getTapTimeout() >> 16), View.MeasureSpec.makeMeasureSpec(0, 0) + 4, (char) View.MeasureSpec.getMode(0));
                            Object[] objArr18 = new Object[1];
                            g($$d[9], $$d[8], $$d[53], objArr18);
                            obj3 = cls7.getMethod((String) objArr18[0], Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                        }
                        Object[] objArr19 = (Object[]) ((Method) obj3).invoke(null, objArr17);
                        int i = ((int[]) objArr19[1])[0];
                        if (((int[]) objArr19[0])[0] != i) {
                            long j = ((r3 ^ i) & 4294967295L) | 42949672960L;
                            try {
                                Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj4 != null) {
                                    objArr = null;
                                } else {
                                    objArr = null;
                                    obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(977 - AndroidCharacter.getMirror('0'), 35 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) TextUtils.indexOf("", "", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                }
                                Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                                try {
                                    Object[] objArr20 = {-1480032157, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj5 == null) {
                                        obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), 18 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                    }
                                    ((Method) obj5).invoke(invoke2, objArr20);
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
                        }
                        super.onCreate(bundle);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onPause() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr = new Object[1];
                e(getPackageName().length() + 19, new int[]{-1191486257, 1728220142, -145984861, 387125705, 811307614, 1308594601, -1533917711, 1196475233, 1508720357, 1182793107, 1241147189, 1092395584, -193001857, -1571160621}, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                e(getPackageName().length() + 11, new int[]{-282369827, 298731135, -130050689, -1337600837, -2041865400, -1356098127, 2052283160, 2066336746, 1136710199, -396609809}, objArr2);
                baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0', 0, 0), 35 - View.getDefaultSize(0, 0), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr3 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.alpha(0), 18 - Gravity.getAbsoluteGravity(0, 0), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Context.class);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onResume() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                try {
                    Object[] objArr = new Object[1];
                    f(PlaceComponentResult[1], (byte) (-PlaceComponentResult[32]), PlaceComponentResult[25], objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    f((byte) (-PlaceComponentResult[59]), PlaceComponentResult[48], PlaceComponentResult[41], new Object[1]);
                    Object[] objArr2 = new Object[1];
                    e(((ApplicationInfo) cls.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 7, new int[]{-1191486257, 1728220142, -145984861, 387125705, 811307614, 1308594601, -1533917711, 1196475233, 1508720357, 1182793107, 1241147189, 1092395584, -193001857, -1571160621}, objArr2);
                    Class<?> cls2 = Class.forName((String) objArr2[0]);
                    Object[] objArr3 = new Object[1];
                    e(getPackageName().length() + 11, new int[]{-282369827, 298731135, -130050689, -1337600837, -2041865400, -1356098127, 2052283160, 2066336746, 1136710199, -396609809}, objArr3);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 36 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr4 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetAfter("", 0) + 911, 18 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity, android.app.Activity
        public void finish() {
            super.finish();
            overridePendingTransition(com.alibaba.griver.core.R.anim.griver_core_app_exit_scale, com.alibaba.griver.core.R.anim.griver_core_app_exit_down_out);
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity, android.app.Activity
        public void finishAndRemoveTask() {
            super.finishAndRemoveTask();
            overridePendingTransition(com.alibaba.griver.core.R.anim.griver_core_app_exit_scale, com.alibaba.griver.core.R.anim.griver_core_app_exit_down_out);
        }

        private static void e(int i, int[] iArr, Object[] objArr) {
            VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
            char[] cArr = new char[4];
            char[] cArr2 = new char[iArr.length * 2];
            int[] iArr2 = NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (iArr2 != null) {
                int length = iArr2.length;
                int[] iArr3 = new int[length];
                for (int i2 = 0; i2 < length; i2++) {
                    iArr3[i2] = (int) (iArr2[i2] ^ (-3152031022165484798L));
                }
                iArr2 = iArr3;
            }
            int length2 = iArr2.length;
            int[] iArr4 = new int[length2];
            int[] iArr5 = NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (iArr5 != null) {
                int length3 = iArr5.length;
                int[] iArr6 = new int[length3];
                for (int i3 = 0; i3 < length3; i3++) {
                    iArr6[i3] = (int) (iArr5[i3] ^ (-3152031022165484798L));
                }
                iArr5 = iArr6;
            }
            System.arraycopy(iArr5, 0, iArr4, 0, length2);
            verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
                cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
                cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
                cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
                cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
                VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
                for (int i4 = 0; i4 < 16; i4++) {
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i4];
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    int i5 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i5;
                }
                int i6 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i6;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
                int i7 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                int i8 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
                cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
                cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
                cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
                verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
            }
            objArr[0] = new String(cArr2, 0, i);
        }
    }

    /* loaded from: classes3.dex */
    public static class Lite extends GriverBaseActivity {
        public static final byte[] $$d = {113, -101, 105, Ascii.SUB, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
        public static final int $$e = 179;
        public static final byte[] PlaceComponentResult = {72, -11, 97, 122, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
        public static final int moveToNextValue = 210;
        private static char getErrorConfigVersion = 32870;
        private static long scheduleImpl = 4360990799332652212L;
        private static int lookAheadTest = -956812108;

        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0032). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void e(int r6, byte r7, byte r8, java.lang.Object[] r9) {
            /*
                int r8 = 106 - r8
                int r7 = 23 - r7
                int r6 = 56 - r6
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite.PlaceComponentResult
                byte[] r1 = new byte[r7]
                int r7 = r7 + (-1)
                r2 = 0
                if (r0 != 0) goto L17
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r9
                r9 = r8
                r8 = r7
                r7 = r6
                goto L32
            L17:
                r3 = 0
            L18:
                byte r4 = (byte) r8
                r1[r3] = r4
                if (r3 != r7) goto L25
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L25:
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
            L32:
                int r9 = r9 + r6
                int r6 = r7 + 1
                int r7 = r9 + (-4)
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                r5 = r8
                r8 = r7
                r7 = r5
                goto L18
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite.e(int, byte, byte, java.lang.Object[]):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0031). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void g(short r7, short r8, byte r9, java.lang.Object[] r10) {
            /*
                int r9 = r9 * 3
                int r9 = 42 - r9
                int r8 = 46 - r8
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite.$$d
                int r7 = r7 * 2
                int r7 = r7 + 75
                byte[] r1 = new byte[r9]
                r2 = 0
                if (r0 != 0) goto L17
                r3 = r1
                r5 = 0
                r1 = r0
                r0 = r10
                r10 = r9
                goto L31
            L17:
                r3 = 0
            L18:
                byte r4 = (byte) r7
                int r5 = r3 + 1
                r1[r3] = r4
                if (r5 != r9) goto L27
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L27:
                int r8 = r8 + 1
                r3 = r0[r8]
                r6 = r10
                r10 = r9
                r9 = r3
                r3 = r1
                r1 = r0
                r0 = r6
            L31:
                int r7 = r7 + r9
                int r7 = r7 + (-7)
                r9 = r10
                r10 = r0
                r0 = r1
                r1 = r3
                r3 = r5
                goto L18
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite.g(short, short, byte, java.lang.Object[]):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:111:0x0575  */
        /* JADX WARN: Removed duplicated region for block: B:112:0x057a  */
        /* JADX WARN: Removed duplicated region for block: B:156:0x0748  */
        /* JADX WARN: Removed duplicated region for block: B:157:0x074d  */
        /* JADX WARN: Removed duplicated region for block: B:201:0x092d  */
        /* JADX WARN: Removed duplicated region for block: B:202:0x0932  */
        /* JADX WARN: Removed duplicated region for block: B:245:0x0afe A[ORIG_RETURN, RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:248:0x0751 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:256:0x0294 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:270:0x0936 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:282:0x057e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0285  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x028a  */
        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void attachBaseContext(android.content.Context r30) {
            /*
                Method dump skipped, instructions count: 3222
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite.attachBaseContext(android.content.Context):void");
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return super.getApplicationContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
        public Context getBaseContext() {
            return super.getBaseContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
        public Resources getResources() {
            return super.getResources();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onPause() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                try {
                    Object[] objArr = new Object[1];
                    e((byte) (moveToNextValue >>> 2), PlaceComponentResult[25], PlaceComponentResult[32], objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    Object[] objArr2 = new Object[1];
                    e(PlaceComponentResult[25], PlaceComponentResult[27], PlaceComponentResult[13], objArr2);
                    Object[] objArr3 = new Object[1];
                    f((char) (((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion + 31651), KeyEvent.keyCodeFromString(""), new char[]{22675, 16406, 50350, 6267}, new char[]{7701, 4950, 48495, 37988, 24300, 22785, 18769, 33519, 44037, 26685, 13658, 880, 18054, 24185, 17608, 17695, 16748, 20435, 3956, 17671, 28496, 40399, 30258, 28430, 16588, 31465}, new char[]{0, 0, 0, 0}, objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    Object[] objArr4 = new Object[1];
                    f((char) (super.getResources().getString(R.string.onboarding_permission_location_title).substring(4, 5).codePointAt(0) + 324), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), new char[]{51054, 13681, 47122, 54017}, new char[]{14793, 10068, 32517, 2942, 62715, 53934, 34029, 17023, 6041, 64813, 49309, 48303, 30368, 59408, 8319, 34615, 11980, 44140}, new char[]{0, 0, 0, 0}, objArr4);
                    baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 34 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) View.combineMeasuredStates(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr5 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 18 - Color.argb(0, 0, 0, 0), (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Context.class);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr5);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onResume() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr = new Object[1];
                f((char) (getPackageName().codePointAt(4) + 31587), ViewConfiguration.getMaximumFlingVelocity() >> 16, new char[]{22675, 16406, 50350, 6267}, new char[]{7701, 4950, 48495, 37988, 24300, 22785, 18769, 33519, 44037, 26685, 13658, 880, 18054, 24185, 17608, 17695, 16748, 20435, 3956, 17671, 28496, 40399, 30258, 28430, 16588, 31465}, new char[]{0, 0, 0, 0}, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                f((char) (getPackageName().length() + 433), Process.myTid() >> 22, new char[]{51054, 13681, 47122, 54017}, new char[]{14793, 10068, 32517, 2942, 62715, 53934, 34029, 17023, 6041, 64813, 49309, 48303, 30368, 59408, 8319, 34615, 11980, 44140}, new char[]{0, 0, 0, 0}, objArr2);
                baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ((Process.getThreadPriority(0) + 20) >> 6), 35 - ExpandableListView.getPackedPositionType(0L), (char) KeyEvent.keyCodeFromString(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr3 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.alpha(0), 18 - (ViewConfiguration.getTapTimeout() >> 16), (char) Color.green(0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle bundle) {
            Object[] objArr;
            char c = (char) (15864 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)));
            try {
                Object[] objArr2 = new Object[1];
                e((byte) (moveToNextValue >>> 2), PlaceComponentResult[25], PlaceComponentResult[32], objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                e(PlaceComponentResult[25], PlaceComponentResult[27], PlaceComponentResult[13], new Object[1]);
                Object[] objArr3 = new Object[1];
                f(c, ((ApplicationInfo) cls.getMethod((String) r7[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{5551, 10736, 63649, 41789}, new char[]{1942, 33074, 13412, 17796, 38300, 50183, 52897, 60564, 8014, 16478, 38119, 51668, 63493, 5156, 35494, 2727, 1148, 4197}, new char[]{0, 0, 0, 0}, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                char length = (char) (getPackageName().length() + 30034);
                try {
                    Object[] objArr4 = new Object[1];
                    e((byte) (moveToNextValue >>> 2), PlaceComponentResult[25], PlaceComponentResult[32], objArr4);
                    Class<?> cls3 = Class.forName((String) objArr4[0]);
                    e(PlaceComponentResult[25], PlaceComponentResult[27], PlaceComponentResult[13], new Object[1]);
                    Object[] objArr5 = new Object[1];
                    f(length, ((ApplicationInfo) cls3.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 1464996622, new char[]{4872, 44525, 22952, 57973}, new char[]{4329, 64305, 27008, 9391, 31962}, new char[]{0, 0, 0, 0}, objArr5);
                    int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                    if (intValue < 99000 || intValue > 99999) {
                        Context baseContext = getBaseContext();
                        if (baseContext == null) {
                            Object[] objArr6 = new Object[1];
                            f((char) (super.getResources().getString(R.string.hint_search_country).substring(4, 5).length() + 31683), super.getResources().getString(R.string.feed_notification_activity_title).substring(0, 6).codePointAt(4) - 102, new char[]{22675, 16406, 50350, 6267}, new char[]{7701, 4950, 48495, 37988, 24300, 22785, 18769, 33519, 44037, 26685, 13658, 880, 18054, 24185, 17608, 17695, 16748, 20435, 3956, 17671, 28496, 40399, 30258, 28430, 16588, 31465}, new char[]{0, 0, 0, 0}, objArr6);
                            Class<?> cls4 = Class.forName((String) objArr6[0]);
                            Object[] objArr7 = new Object[1];
                            f((char) (440 - (ViewConfiguration.getLongPressTimeout() >> 16)), super.getResources().getString(R.string.mybills_tooltip_reminder).substring(29, 31).length() - 2, new char[]{51054, 13681, 47122, 54017}, new char[]{14793, 10068, 32517, 2942, 62715, 53934, 34029, 17023, 6041, 64813, 49309, 48303, 30368, 59408, 8319, 34615, 11980, 44140}, new char[]{0, 0, 0, 0}, objArr7);
                            baseContext = (Context) cls4.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
                        }
                        if (baseContext != null) {
                            baseContext = baseContext.getApplicationContext();
                        }
                        if (baseContext != null) {
                            try {
                                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj == null) {
                                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (ViewConfiguration.getLongPressTimeout() >> 16) + 35, (char) (Process.getGidForName("") + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                                }
                                Object invoke = ((Method) obj).invoke(null, null);
                                char codePointAt = (char) (super.getResources().getString(R.string.promo_payment_method_net_banking).substring(5, 6).codePointAt(0) - 32);
                                try {
                                    Object[] objArr8 = new Object[1];
                                    e((byte) (moveToNextValue >>> 2), PlaceComponentResult[25], PlaceComponentResult[32], objArr8);
                                    Class<?> cls5 = Class.forName((String) objArr8[0]);
                                    e(PlaceComponentResult[25], PlaceComponentResult[27], PlaceComponentResult[13], new Object[1]);
                                    Object[] objArr9 = new Object[1];
                                    f(codePointAt, ((ApplicationInfo) cls5.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{5574, 22816, 27711, 40108}, new char[]{32471, 42695, 10367, 42822, 4311, 10349, 36762, 47418, 33214, 59170, 5669, 63550, 59698, 7685, 59423, 3844, 11822, 34567, 46521, 2841, 57757, 15741, 48853, 48169, 3604, 40140, 42444, 23054, 2888, 47334, 24575, 19930, 41304, 21675, 65409, 30652, 10656, 17263, 40558, 29383, 12714, 41322, 8098, 31421, 40139, 36902, 4201, 46343}, new char[]{0, 0, 0, 0}, objArr9);
                                    String str = (String) objArr9[0];
                                    try {
                                        Object[] objArr10 = new Object[1];
                                        e((byte) (moveToNextValue >>> 2), PlaceComponentResult[25], PlaceComponentResult[32], objArr10);
                                        Class<?> cls6 = Class.forName((String) objArr10[0]);
                                        e(PlaceComponentResult[25], PlaceComponentResult[27], PlaceComponentResult[13], new Object[1]);
                                        Object[] objArr11 = new Object[1];
                                        f((char) (((ApplicationInfo) cls6.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 33), super.getResources().getString(R.string.water_button_title).substring(1, 3).length() - 2, new char[]{60687, 4493, 32839, 60371}, new char[]{7640, 9235, 40035, 29383, 35956, 19098, 56764, 45050, 1201, 2082, 63361, 8185, 41543, 64054, 62292, 34540, 9167, 6499, 52950, 56570, 47283, 5516, 338, 57086, 51206, 22427, 65390, 32858, 29460, 37029, 363, 52496, 5129, 32226, 51940, 61957, 64074, 18032, 39389, 52656, 1550, 21332, 14151, 19077, 55810, 25269, 63015, 61129, 47744, 64176, 20367, 28027, 15520, 56600, 41333, 5642, 56060, 9143, 32780, 2900, 47769, 12430, 33895, 63835}, new char[]{0, 0, 0, 0}, objArr11);
                                        String str2 = (String) objArr11[0];
                                        Object[] objArr12 = new Object[1];
                                        f((char) (super.getResources().getString(R.string.header_form_country_destination).substring(1, 2).length() - 1), (-1) - TextUtils.lastIndexOf("", '0', 0, 0), new char[]{6585, 11936, 9470, 37118}, new char[]{12885, 61578, 20741, 16285, 60663, 28109, 3128, 56791, 64764, 56063, 8630, 57114, 57276, 63095, 25304, 45947, 57706, 32142, 7369, 58843, 12224, 37140, 37217, 57800, 21900, 18939, 44966, 18445, 6968, 7572, 41854, 44892, 32404, 62353, 56054, 53794, 32616, 44894, 63266, 30819, 57928, 65114, 46544, 54679, 24035, 56065, 31048, 50590, 47775, 38092, 57808, 40245, 13328, 45091, 48598, 35064, 40317, 56077, 22207, 19750, 52890, 58813, 22604, 26090}, new char[]{0, 0, 0, 0}, objArr12);
                                        String str3 = (String) objArr12[0];
                                        Object[] objArr13 = new Object[1];
                                        f((char) (ViewConfiguration.getKeyRepeatDelay() >> 16), getPackageName().codePointAt(6) - 97, new char[]{31937, 20490, 30313, 20450}, new char[]{54316, 6468, 27717, 52803, 12137, 29889, 41163, 63488, 8688, 53730, 18504, 38978, 48078, 54657, 46409, 15035, 31205, 37802, 33418, 63943, 33574, 22613, 44419, 28492, 57829, 2997, 20266, 14629, 53051, 45296, 14002, 44390, 17487, 9195, 13287, 7418, 65292, 64128, 31361, 43657, 1972, 61449, 63264, 64519, 64685, 29286, 45398, 34246, 1408, 13361, 59166, 63048, 3970, 11012, 64308, 23277, 1555, 51476, 2103, 10360}, new char[]{0, 0, 0, 0}, objArr13);
                                        String str4 = (String) objArr13[0];
                                        Object[] objArr14 = new Object[1];
                                        f((char) (16471 - TextUtils.getCapsMode("", 0, 0)), super.getResources().getString(R.string.setting_wallet_security_settings).substring(5, 6).codePointAt(0) - 116, new char[]{25870, 6927, 22358, 34624}, new char[]{62376, 15589, 39829, 28931, 61002, 49710}, new char[]{0, 0, 0, 0}, objArr14);
                                        try {
                                            Object[] objArr15 = {baseContext, str, str2, str3, str4, true, (String) objArr14[0], 995651014};
                                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                            if (obj2 == null) {
                                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + 911, View.MeasureSpec.makeMeasureSpec(0, 0) + 18, (char) (ExpandableListView.getPackedPositionChild(0L) + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                            }
                                            ((Method) obj2).invoke(invoke, objArr15);
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
                        }
                    }
                    try {
                        Object[] objArr16 = new Object[1];
                        e(PlaceComponentResult[31], (byte) (-PlaceComponentResult[30]), PlaceComponentResult[25], objArr16);
                        Class<?> cls7 = Class.forName((String) objArr16[0]);
                        Object[] objArr17 = new Object[1];
                        e((byte) (PlaceComponentResult[34] + 1), (byte) (-PlaceComponentResult[30]), PlaceComponentResult[7], objArr17);
                        try {
                            Object[] objArr18 = {Integer.valueOf(((Integer) cls7.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue())};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                            if (obj3 == null) {
                                Class cls8 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - View.MeasureSpec.getMode(0), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 5, (char) Color.alpha(0));
                                byte b = (byte) ($$d[78] - 1);
                                byte b2 = b;
                                Object[] objArr19 = new Object[1];
                                g(b, b2, b2, objArr19);
                                obj3 = cls8.getMethod((String) objArr19[0], Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                            }
                            Object[] objArr20 = (Object[]) ((Method) obj3).invoke(null, objArr18);
                            int i = ((int[]) objArr20[1])[0];
                            if (((int[]) objArr20[0])[0] != i) {
                                long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                                try {
                                    Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                    if (obj4 != null) {
                                        objArr = null;
                                    } else {
                                        objArr = null;
                                        obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.argb(0, 0, 0, 0), View.resolveSizeAndState(0, 0, 0) + 35, (char) Color.green(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                    }
                                    Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                                    try {
                                        Object[] objArr21 = {2013313974, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                        Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                        if (obj5 == null) {
                                            obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.resolveSize(0, 0), 17 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                        }
                                        ((Method) obj5).invoke(invoke2, objArr21);
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
                            }
                            super.onCreate(bundle);
                            if (IpcChannelManager.getInstance().getServerChannel() == null) {
                                Intent intent = new Intent();
                                intent.setClass(this, IpcMsgServerService.class);
                                startService(intent);
                                bindService(intent, new ServiceConnection() { // from class: com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite.1
                                    @Override // android.content.ServiceConnection
                                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("onServiceConnected ");
                                        sb.append(componentName);
                                        RVLogger.d("GriverBaseActivity", sb.toString());
                                        IpcChannelManager.getInstance().registerServerChannel(IIpcChannel.Stub.asInterface(iBinder));
                                    }

                                    @Override // android.content.ServiceConnection
                                    public void onServiceDisconnected(ComponentName componentName) {
                                        IpcChannelManager.getInstance().unRegisterServerChannel();
                                    }
                                }, 0);
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
            } catch (Throwable th10) {
                Throwable cause10 = th10.getCause();
                if (cause10 == null) {
                    throw th10;
                }
                throw cause10;
            }
        }

        private static void f(char c, int i, char[] cArr, char[] cArr2, char[] cArr3, Object[] objArr) {
            E e = new E();
            int length = cArr.length;
            char[] cArr4 = new char[length];
            int length2 = cArr3.length;
            char[] cArr5 = new char[length2];
            System.arraycopy(cArr, 0, cArr4, 0, length);
            System.arraycopy(cArr3, 0, cArr5, 0, length2);
            cArr4[0] = (char) (cArr4[0] ^ c);
            cArr5[2] = (char) (cArr5[2] + ((char) i));
            int length3 = cArr2.length;
            char[] cArr6 = new char[length3];
            e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
            while (e.KClassImpl$Data$declaredNonStaticMembers$2 < length3) {
                int i2 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
                int i3 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
                e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i2]) % 65535);
                cArr5[i3] = (char) (((cArr4[i3] * 32718) + cArr5[i2]) / 65535);
                cArr4[i3] = e.MyBillsEntityDataFactory;
                cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i3] ^ cArr2[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (scheduleImpl ^ 4360990799332652212L)) ^ ((int) (lookAheadTest ^ 4360990799332652212L))) ^ ((char) (getErrorConfigVersion ^ 4360990799332652212L)));
                e.KClassImpl$Data$declaredNonStaticMembers$2++;
            }
            objArr[0] = new String(cArr6);
        }
    }

    /* loaded from: classes3.dex */
    public static class Back extends GriverBaseActivity {

        /* renamed from: a  reason: collision with root package name */
        private boolean f6464a = false;
        public static final byte[] $$d = {41, -91, 83, 107, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
        public static final int $$e = 122;
        public static final byte[] PlaceComponentResult = {Ascii.ETB, -59, 18, 83, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
        public static final int scheduleImpl = 150;
        private static int getErrorConfigVersion = 269894761;

        private static void f(byte b, int i, int i2, Object[] objArr) {
            int i3 = i + 4;
            byte[] bArr = PlaceComponentResult;
            int i4 = 106 - i2;
            int i5 = 23 - b;
            byte[] bArr2 = new byte[i5];
            int i6 = -1;
            int i7 = i5 - 1;
            if (bArr == null) {
                i4 = (i7 + i3) - 4;
                i7 = i7;
                i3 = i3;
            }
            while (true) {
                i6++;
                bArr2[i6] = (byte) i4;
                int i8 = i3 + 1;
                if (i6 == i7) {
                    objArr[0] = new String(bArr2, 0);
                    return;
                }
                i4 = (i4 + bArr[i8]) - 4;
                i7 = i7;
                i3 = i8;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0030). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void g(int r6, byte r7, byte r8, java.lang.Object[] r9) {
            /*
                int r6 = r6 * 2
                int r6 = r6 + 75
                int r8 = r8 + 4
                int r7 = r7 * 3
                int r7 = 42 - r7
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back.$$d
                byte[] r1 = new byte[r7]
                r2 = 0
                if (r0 != 0) goto L17
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r9
                r9 = r8
                goto L30
            L17:
                r3 = 0
            L18:
                byte r4 = (byte) r6
                r1[r3] = r4
                int r3 = r3 + 1
                if (r3 != r7) goto L27
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L27:
                r4 = r0[r8]
                r5 = r9
                r9 = r6
                r6 = r4
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r5
            L30:
                int r6 = -r6
                int r8 = r8 + 1
                int r9 = r9 + r6
                int r6 = r9 + (-7)
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L18
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back.g(int, byte, byte, java.lang.Object[]):void");
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            Object[] objArr;
            Object[] objArr2;
            Object[] objArr3;
            Object[] objArr4;
            super.attachBaseContext(context);
            Object[] objArr5 = new Object[1];
            e(TextUtils.getOffsetAfter("", 0) + 18, 14 - TextUtils.getCapsMode("", 0, 0), 175 - (ViewConfiguration.getJumpTapTimeout() >> 16), new char[]{'\f', 15, 65517, 65483, 16, '\f', 65483, 1, 6, '\f', 15, 1, 11, 65534, 16, 16, 2, 0}, true, objArr5);
            Class<?> cls = Class.forName((String) objArr5[0]);
            Object[] objArr6 = new Object[1];
            e(5 - Color.argb(0, 0, 0, 0), Color.blue(0) + 2, 180 - (ViewConfiguration.getFadingEdgeLength() >> 16), new char[]{1, 65532, 5, 17, 65517}, false, objArr6);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context applicationContext = context != null ? context.getApplicationContext() : context;
                if (applicationContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0', 0), View.resolveSizeAndState(0, 0, 0) + 35, (char) KeyEvent.normalizeMetaState(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        e(48 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 26 - TextUtils.getOffsetAfter("", 0), 147 - TextUtils.getOffsetAfter("", 0), new char[]{65516, 29, 65519, 28, 28, 29, JSONLexer.EOI, 65519, 65514, 65514, 65519, 65514, 65515, 30, 31, 28, 30, 65520, 65521, 65522, 29, 65513, 65521, 65519, 28, 65520, 30, 65519, 65516, 27, 65519, 65517, 31, 65520, 65513, 65521, 65522, 31, 65522, 65515, 65519, 65522, 30, JSONLexer.EOI, 29, 65515, 29, 65521}, true, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        e((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 63, 29 - TextUtils.lastIndexOf("", '0', 0, 0), TextUtils.getOffsetBefore("", 0) + 142, new char[]{65522, 65526, '!', '!', 65518, 65521, 65523, 65518, '#', 65519, '!', 65525, 65519, 65525, 65521, 65521, 65525, 65527, 65527, 65525, 65518, 65519, 65518, 65519, '!', InputCardNumberView.DIVIDER, 65519, 65526, Typography.quote, 65521, 31, 65523, 65524, Typography.quote, Typography.dollar, 65527, 65518, 65526, Typography.quote, '!', 65527, 65523, Typography.quote, 65519, 65519, 65522, 65520, 65520, Typography.dollar, 65519, Typography.quote, 65519, 65524, 65521, 65524, InputCardNumberView.DIVIDER, 65527, '#', 65526, Typography.quote, 65520, 65520, '!', Typography.quote}, false, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        e((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 63, 10 - TextUtils.lastIndexOf("", '0', 0, 0), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 144, new char[]{65524, 65524, 65524, 65520, 65518, 65523, 65525, 30, '!', 65517, 65518, 65525, 65521, 65521, Typography.quote, 65522, 65525, 65521, 65523, 65521, Typography.quote, 65517, 65518, '!', 31, 65525, Typography.quote, 30, 29, 65516, 65524, 65520, 65517, Typography.quote, 65524, 65524, 65522, 65523, 30, 65524, 65518, InputCardNumberView.DIVIDER, 65523, 31, 65523, Typography.quote, Typography.quote, 65524, 65525, Typography.quote, 65523, 65519, 29, 30, 65518, InputCardNumberView.DIVIDER, 65520, '!', 29, 65523, 65516, 65519, 65517, 65517}, true, objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        e((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 59, ((Process.getThreadPriority(0) + 20) >> 6) + 25, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 172, new char[]{65485, 2, 14, '\f', 65486, 0, 15, '\b', 65486, '\b', '\r', 6, 4, 18, 19, 65486, 21, 65489, 65486, 4, 21, 4, '\r', 19, 18, 7, 19, 19, 15, 18, 65497, 65486, 65486, 3, 0, '\r', 0, 65485, 19, 7, 17, 4, 0, 19, 2, 0, 18, 19, 65485, 6, 20, 0, 17, 3, 18, 16, 20, 0, 17, 4}, false, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        e(6 - View.resolveSize(0, 0), '3' - AndroidCharacter.getMirror('0'), (ViewConfiguration.getTouchSlop() >> 8) + 126, new char[]{2, 65532, 7, 65535, 0, 65532}, true, objArr11);
                        try {
                            Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 912, 18 - (Process.myTid() >> 22), (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                    Object[] objArr13 = {this};
                    Object[] objArr14 = new Object[1];
                    f((byte) (-PlaceComponentResult[30]), 36, PlaceComponentResult[25], objArr14);
                    Class<?> cls2 = Class.forName((String) objArr14[0]);
                    Object[] objArr15 = new Object[1];
                    f((byte) (-PlaceComponentResult[30]), (byte) (PlaceComponentResult[35] - 1), PlaceComponentResult[7], objArr15);
                    try {
                        Object[] objArr16 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr15[0], Object.class).invoke(null, objArr13)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                        if (obj3 == null) {
                            Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + 56, 3 - (ViewConfiguration.getTapTimeout() >> 16), (char) TextUtils.getTrimmedLength(""));
                            Object[] objArr17 = new Object[1];
                            g($$d[47], $$d[68], (byte) ($$d[47] - 1), objArr17);
                            obj3 = cls3.getMethod((String) objArr17[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                        }
                        Object invoke2 = ((Method) obj3).invoke(null, objArr16);
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + 800, (ViewConfiguration.getEdgeSlop() >> 16) + 15, (char) (Process.myTid() >> 22))).getMethod("getAuthRequestContext", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                            }
                            int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                            try {
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getJumpTapTimeout() >> 16), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 14, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("PlaceComponentResult", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                                }
                                if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                    ArrayList arrayList = new ArrayList();
                                    try {
                                        Object[] objArr18 = {invoke2};
                                        Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                        if (obj6 == null) {
                                            obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - TextUtils.getOffsetAfter("", 0), TextUtils.getTrimmedLength("") + 29, (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 800, View.MeasureSpec.getMode(0) + 15, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16)));
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                        }
                                        arrayList.add(((Method) obj6).invoke(null, objArr18));
                                        long j = ((r9 ^ intValue2) & 4294967295L) | 60129542144L;
                                        try {
                                            Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                            if (obj7 != null) {
                                                objArr = null;
                                            } else {
                                                objArr = null;
                                                obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 'S' - AndroidCharacter.getMirror('0'), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                            }
                                            Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                            try {
                                                Object[] objArr19 = {-2117726752, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                                Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                                if (obj8 == null) {
                                                    obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarSize() >> 8), 18 - ExpandableListView.getPackedPositionType(0L), (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj8);
                                                }
                                                ((Method) obj8).invoke(invoke3, objArr19);
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
                    Object[] objArr20 = {this};
                    Object[] objArr21 = new Object[1];
                    f((byte) (-PlaceComponentResult[30]), 36, PlaceComponentResult[25], objArr21);
                    Class<?> cls4 = Class.forName((String) objArr21[0]);
                    Object[] objArr22 = new Object[1];
                    f((byte) (-PlaceComponentResult[30]), (byte) (PlaceComponentResult[35] - 1), PlaceComponentResult[7], objArr22);
                    try {
                        Object[] objArr23 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr22[0], Object.class).invoke(null, objArr20)).intValue())};
                        Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                        if (obj9 == null) {
                            Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 61, 47 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1));
                            byte b = (byte) (-$$d[9]);
                            byte b2 = (byte) (-$$d[8]);
                            Object[] objArr24 = new Object[1];
                            g(b, b2, (byte) (b2 | 16), objArr24);
                            obj9 = cls5.getMethod((String) objArr24[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                        }
                        Object[] objArr25 = (Object[]) ((Method) obj9).invoke(null, objArr23);
                        int i = ((int[]) objArr25[1])[0];
                        if (((int[]) objArr25[0])[0] != i) {
                            long j2 = ((r2 ^ i) & 4294967295L) | 17179869184L;
                            try {
                                Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj10 != null) {
                                    objArr2 = null;
                                } else {
                                    objArr2 = null;
                                    obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                                }
                                Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                                try {
                                    Object[] objArr26 = {-2117726752, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj11 == null) {
                                        obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 912, (Process.myPid() >> 22) + 18, (char) (Process.myTid() >> 22))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                    }
                                    ((Method) obj11).invoke(invoke4, objArr26);
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
                    Object[] objArr27 = {this};
                    Object[] objArr28 = new Object[1];
                    f((byte) (-PlaceComponentResult[30]), 36, PlaceComponentResult[25], objArr28);
                    Class<?> cls6 = Class.forName((String) objArr28[0]);
                    Object[] objArr29 = new Object[1];
                    f((byte) (-PlaceComponentResult[30]), (byte) (PlaceComponentResult[35] - 1), PlaceComponentResult[7], objArr29);
                    try {
                        Object[] objArr30 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr29[0], Object.class).invoke(null, objArr27)).intValue())};
                        Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                        if (obj12 == null) {
                            Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(119 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 4 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 38967));
                            byte b3 = (byte) (-$$d[9]);
                            byte b4 = (byte) (-$$d[8]);
                            Object[] objArr31 = new Object[1];
                            g(b3, b4, (byte) (b4 | 16), objArr31);
                            obj12 = cls7.getMethod((String) objArr31[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                        }
                        Object[] objArr32 = (Object[]) ((Method) obj12).invoke(null, objArr30);
                        int i2 = ((int[]) objArr32[1])[0];
                        if (((int[]) objArr32[0])[0] != i2) {
                            long j3 = ((r2 ^ i2) & 4294967295L) | 8589934592L;
                            try {
                                Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj13 != null) {
                                    objArr3 = null;
                                } else {
                                    objArr3 = null;
                                    obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, ((Process.getThreadPriority(0) + 20) >> 6) + 35, (char) KeyEvent.getDeadChar(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                                }
                                Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                                try {
                                    Object[] objArr33 = {-2117726752, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj14 == null) {
                                        obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.makeMeasureSpec(0, 0) + 911, 18 - ExpandableListView.getPackedPositionGroup(0L), (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                    }
                                    ((Method) obj14).invoke(invoke5, objArr33);
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
                    Object[] objArr34 = {this};
                    Object[] objArr35 = new Object[1];
                    f((byte) (-PlaceComponentResult[30]), 36, PlaceComponentResult[25], objArr35);
                    Class<?> cls8 = Class.forName((String) objArr35[0]);
                    Object[] objArr36 = new Object[1];
                    f((byte) (-PlaceComponentResult[30]), (byte) (PlaceComponentResult[35] - 1), PlaceComponentResult[7], objArr36);
                    try {
                        Object[] objArr37 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr36[0], Object.class).invoke(null, objArr34)).intValue())};
                        Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                        if (obj15 == null) {
                            Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + 107, 3 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) View.getDefaultSize(0, 0));
                            byte b5 = (byte) ($$d[47] - 1);
                            Object[] objArr38 = new Object[1];
                            g(b5, b5, (byte) (-$$d[53]), objArr38);
                            obj15 = cls9.getMethod((String) objArr38[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                        }
                        Object[] objArr39 = (Object[]) ((Method) obj15).invoke(null, objArr37);
                        int i3 = ((int[]) objArr39[1])[0];
                        if (((int[]) objArr39[0])[0] != i3) {
                            long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                            try {
                                Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj16 != null) {
                                    objArr4 = null;
                                } else {
                                    objArr4 = null;
                                    obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, View.MeasureSpec.makeMeasureSpec(0, 0) + 35, (char) View.resolveSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                                }
                                Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                                try {
                                    Object[] objArr40 = {-2117726752, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj17 == null) {
                                        obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.combineMeasuredStates(0, 0) + 911, (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18, (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                    }
                                    ((Method) obj17).invoke(invoke6, objArr40);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return super.getApplicationContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
        public Context getBaseContext() {
            return super.getBaseContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
        public Resources getResources() {
            return super.getResources();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onPause() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                int codePointAt = super.getResources().getString(R.string.sendmoney_remarks_add_hint).substring(25, 26).codePointAt(0) - 6;
                try {
                    Object[] objArr = new Object[1];
                    f(PlaceComponentResult[25], PlaceComponentResult[9], PlaceComponentResult[32], objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    f(PlaceComponentResult[27], PlaceComponentResult[59], PlaceComponentResult[13], new Object[1]);
                    Object[] objArr2 = new Object[1];
                    e(codePointAt, ((ApplicationInfo) cls.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 23, TextUtils.lastIndexOf("", '0') + 176, new char[]{19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15, '\f', 6, 1, 65483, 65534, '\r', '\r', 65483, 65502, 0, 17, 6}, false, objArr2);
                    Class<?> cls2 = Class.forName((String) objArr2[0]);
                    int argb = Color.argb(0, 0, 0, 0) + 18;
                    try {
                        Object[] objArr3 = new Object[1];
                        f(PlaceComponentResult[25], PlaceComponentResult[9], PlaceComponentResult[32], objArr3);
                        Class<?> cls3 = Class.forName((String) objArr3[0]);
                        f(PlaceComponentResult[27], PlaceComponentResult[59], PlaceComponentResult[13], new Object[1]);
                        Object[] objArr4 = new Object[1];
                        e(argb, ((ApplicationInfo) cls3.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 24, 182 - View.resolveSizeAndState(0, 0, 0), new char[]{6, 65495, '\n', 4, 65531, '\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529, 65535, 2, 6}, true, objArr4);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollBarSize() >> 8), 35 - View.MeasureSpec.getMode(0), (char) TextUtils.indexOf("", "", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr5 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + 911, Gravity.getAbsoluteGravity(0, 0) + 18, (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Context.class);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle bundle) {
            Object[] objArr;
            Object[] objArr2 = new Object[1];
            e(super.getResources().getString(R.string.my_bills_later_this_month).substring(13, 15).codePointAt(0) - 92, super.getResources().getString(R.string.use_this_receipt_photo).substring(16, 17).length() + 13, 175 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), new char[]{'\f', 15, 65517, 65483, 16, '\f', 65483, 1, 6, '\f', 15, 1, 11, 65534, 16, 16, 2, 0}, true, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            e(KeyEvent.normalizeMetaState(0) + 5, 2 - (ViewConfiguration.getScrollDefaultDelay() >> 16), super.getResources().getString(R.string.setting_new_security_settings).substring(1, 2).length() + 179, new char[]{1, 65532, 5, 17, 65517}, false, objArr3);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr4 = new Object[1];
                    e(getPackageName().codePointAt(1) - 74, getPackageName().length() + 3, super.getResources().getString(R.string.info_subtitle_3).substring(0, 15).codePointAt(0) + 107, new char[]{19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15, '\f', 6, 1, 65483, 65534, '\r', '\r', 65483, 65502, 0, 17, 6}, false, objArr4);
                    Class<?> cls2 = Class.forName((String) objArr4[0]);
                    int codePointAt = getPackageName().codePointAt(1) - 82;
                    int i = 10 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1));
                    try {
                        Object[] objArr5 = new Object[1];
                        f(PlaceComponentResult[25], PlaceComponentResult[9], PlaceComponentResult[32], objArr5);
                        Class<?> cls3 = Class.forName((String) objArr5[0]);
                        Object[] objArr6 = new Object[1];
                        f(PlaceComponentResult[27], PlaceComponentResult[59], PlaceComponentResult[13], objArr6);
                        Object[] objArr7 = new Object[1];
                        e(codePointAt, i, ((ApplicationInfo) cls3.getMethod((String) objArr6[0], null).invoke(this, null)).targetSdkVersion + 149, new char[]{6, 65495, '\n', 4, 65531, '\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529, 65535, 2, 6}, true, objArr7);
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
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.getMode(0), ((Process.getThreadPriority(0) + 20) >> 6) + 35, (char) View.combineMeasuredStates(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr8 = new Object[1];
                        e(super.getResources().getString(R.string.disabled_transfer_dest_caption).substring(0, 1).codePointAt(0) - 17, getPackageName().length() + 19, getPackageName().codePointAt(3) + 47, new char[]{65516, 29, 65519, 28, 28, 29, JSONLexer.EOI, 65519, 65514, 65514, 65519, 65514, 65515, 30, 31, 28, 30, 65520, 65521, 65522, 29, 65513, 65521, 65519, 28, 65520, 30, 65519, 65516, 27, 65519, 65517, 31, 65520, 65513, 65521, 65522, 31, 65522, 65515, 65519, 65522, 30, JSONLexer.EOI, 29, 65515, 29, 65521}, true, objArr8);
                        String str = (String) objArr8[0];
                        try {
                            Object[] objArr9 = new Object[1];
                            f(PlaceComponentResult[25], PlaceComponentResult[9], PlaceComponentResult[32], objArr9);
                            Class<?> cls4 = Class.forName((String) objArr9[0]);
                            Object[] objArr10 = new Object[1];
                            f(PlaceComponentResult[27], PlaceComponentResult[59], PlaceComponentResult[13], objArr10);
                            Object[] objArr11 = new Object[1];
                            e(((ApplicationInfo) cls4.getMethod((String) objArr10[0], null).invoke(this, null)).targetSdkVersion + 31, super.getResources().getString(R.string.registration_source_merchant_app).substring(0, 19).codePointAt(14) - 82, 143 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), new char[]{65522, 65526, '!', '!', 65518, 65521, 65523, 65518, '#', 65519, '!', 65525, 65519, 65525, 65521, 65521, 65525, 65527, 65527, 65525, 65518, 65519, 65518, 65519, '!', InputCardNumberView.DIVIDER, 65519, 65526, Typography.quote, 65521, 31, 65523, 65524, Typography.quote, Typography.dollar, 65527, 65518, 65526, Typography.quote, '!', 65527, 65523, Typography.quote, 65519, 65519, 65522, 65520, 65520, Typography.dollar, 65519, Typography.quote, 65519, 65524, 65521, 65524, InputCardNumberView.DIVIDER, 65527, '#', 65526, Typography.quote, 65520, 65520, '!', Typography.quote}, false, objArr11);
                            String str2 = (String) objArr11[0];
                            int codePointAt2 = super.getResources().getString(R.string.mp_empty_mini_programs_desc).substring(26, 27).codePointAt(0) + 32;
                            try {
                                Object[] objArr12 = new Object[1];
                                f(PlaceComponentResult[25], PlaceComponentResult[9], PlaceComponentResult[32], objArr12);
                                Class<?> cls5 = Class.forName((String) objArr12[0]);
                                f(PlaceComponentResult[27], PlaceComponentResult[59], PlaceComponentResult[13], new Object[1]);
                                Object[] objArr13 = new Object[1];
                                e(codePointAt2, ((ApplicationInfo) cls5.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 22, getPackageName().codePointAt(4) + 47, new char[]{65524, 65524, 65524, 65520, 65518, 65523, 65525, 30, '!', 65517, 65518, 65525, 65521, 65521, Typography.quote, 65522, 65525, 65521, 65523, 65521, Typography.quote, 65517, 65518, '!', 31, 65525, Typography.quote, 30, 29, 65516, 65524, 65520, 65517, Typography.quote, 65524, 65524, 65522, 65523, 30, 65524, 65518, InputCardNumberView.DIVIDER, 65523, 31, 65523, Typography.quote, Typography.quote, 65524, 65525, Typography.quote, 65523, 65519, 29, 30, 65518, InputCardNumberView.DIVIDER, 65520, '!', 29, 65523, 65516, 65519, 65517, 65517}, true, objArr13);
                                String str3 = (String) objArr13[0];
                                int lastIndexOf = 59 - TextUtils.lastIndexOf("", '0', 0);
                                try {
                                    Object[] objArr14 = new Object[1];
                                    f(PlaceComponentResult[25], PlaceComponentResult[9], PlaceComponentResult[32], objArr14);
                                    Class<?> cls6 = Class.forName((String) objArr14[0]);
                                    Object[] objArr15 = new Object[1];
                                    f(PlaceComponentResult[27], PlaceComponentResult[59], PlaceComponentResult[13], objArr15);
                                    int i2 = ((ApplicationInfo) cls6.getMethod((String) objArr15[0], null).invoke(this, null)).targetSdkVersion - 8;
                                    try {
                                        Object[] objArr16 = new Object[1];
                                        f(PlaceComponentResult[25], PlaceComponentResult[9], PlaceComponentResult[32], objArr16);
                                        Class<?> cls7 = Class.forName((String) objArr16[0]);
                                        Object[] objArr17 = new Object[1];
                                        f(PlaceComponentResult[27], PlaceComponentResult[59], PlaceComponentResult[13], objArr17);
                                        Object[] objArr18 = new Object[1];
                                        e(lastIndexOf, i2, ((ApplicationInfo) cls7.getMethod((String) objArr17[0], null).invoke(this, null)).targetSdkVersion + 140, new char[]{65485, 2, 14, '\f', 65486, 0, 15, '\b', 65486, '\b', '\r', 6, 4, 18, 19, 65486, 21, 65489, 65486, 4, 21, 4, '\r', 19, 18, 7, 19, 19, 15, 18, 65497, 65486, 65486, 3, 0, '\r', 0, 65485, 19, 7, 17, 4, 0, 19, 2, 0, 18, 19, 65485, 6, 20, 0, 17, 3, 18, 16, 20, 0, 17, 4}, false, objArr18);
                                        String str4 = (String) objArr18[0];
                                        try {
                                            Object[] objArr19 = new Object[1];
                                            f(PlaceComponentResult[25], PlaceComponentResult[9], PlaceComponentResult[32], objArr19);
                                            Class<?> cls8 = Class.forName((String) objArr19[0]);
                                            f(PlaceComponentResult[27], PlaceComponentResult[59], PlaceComponentResult[13], new Object[1]);
                                            Object[] objArr20 = new Object[1];
                                            e(((ApplicationInfo) cls8.getMethod((String) r0[0], null).invoke(this, null)).targetSdkVersion - 27, 3 - View.MeasureSpec.getSize(0), TextUtils.lastIndexOf("", '0') + 127, new char[]{2, 65532, 7, 65535, 0, 65532}, true, objArr20);
                                            try {
                                                Object[] objArr21 = {baseContext, str, str2, str3, str4, true, (String) objArr20[0], 995651014};
                                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                                if (obj2 == null) {
                                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.combineMeasuredStates(0, 0) + 911, MotionEvent.axisFromString("") + 19, (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                                }
                                                ((Method) obj2).invoke(invoke, objArr21);
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
                }
            }
            try {
                Object[] objArr22 = new Object[1];
                f((byte) (-PlaceComponentResult[30]), 36, PlaceComponentResult[25], objArr22);
                Class<?> cls9 = Class.forName((String) objArr22[0]);
                Object[] objArr23 = new Object[1];
                f((byte) (-PlaceComponentResult[30]), (byte) (PlaceComponentResult[35] - 1), PlaceComponentResult[7], objArr23);
                try {
                    Object[] objArr24 = {Integer.valueOf(((Integer) cls9.getMethod((String) objArr23[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls10 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getScrollDefaultDelay() >> 16), TextUtils.getTrimmedLength("") + 4, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16));
                        byte b = (byte) ($$d[47] - 1);
                        Object[] objArr25 = new Object[1];
                        g(b, b, (byte) (-$$d[53]), objArr25);
                        obj3 = cls10.getMethod((String) objArr25[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr26 = (Object[]) ((Method) obj3).invoke(null, objArr24);
                    int i3 = ((int[]) objArr26[1])[0];
                    if (((int[]) objArr26[0])[0] != i3) {
                        long j = ((r0 ^ i3) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(977 - AndroidCharacter.getMirror('0'), View.MeasureSpec.getMode(0) + 35, (char) View.combineMeasuredStates(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr27 = {-1000926719, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 911, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 17, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr27);
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
                    }
                    super.onCreate(bundle);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onResume() {
            App app;
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                int codePointAt = super.getResources().getString(R.string.citcall_verification_subtitle).substring(16, 17).codePointAt(0) - 6;
                try {
                    Object[] objArr = new Object[1];
                    f(PlaceComponentResult[25], PlaceComponentResult[9], PlaceComponentResult[32], objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    f(PlaceComponentResult[27], PlaceComponentResult[59], PlaceComponentResult[13], new Object[1]);
                    Object[] objArr2 = new Object[1];
                    e(codePointAt, ((ApplicationInfo) cls.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 23, 175 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), new char[]{19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15, '\f', 6, 1, 65483, 65534, '\r', '\r', 65483, 65502, 0, 17, 6}, false, objArr2);
                    Class<?> cls2 = Class.forName((String) objArr2[0]);
                    Object[] objArr3 = new Object[1];
                    e(super.getResources().getString(R.string.saving_save_changes).substring(0, 1).codePointAt(0) - 65, View.resolveSizeAndState(0, 0, 0) + 9, 182 - ExpandableListView.getPackedPositionGroup(0L), new char[]{6, 65495, '\n', 4, 65531, '\b', '\b', 11, 65529, 4, 5, 65535, '\n', 65527, 65529, 65535, 2, 6}, true, objArr3);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", ""), KeyEvent.keyCodeFromString("") + 35, (char) (Process.myPid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr4 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 863, TextUtils.lastIndexOf("", '0', 0) + 19, (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
            if (this.mActivityHelper == null || (app = this.mActivityHelper.getApp()) == null) {
                return;
            }
            GriverKeepAliveFullLinkStageMonitor griverKeepAliveFullLinkStageMonitor = (GriverKeepAliveFullLinkStageMonitor) GriverStageMonitorManager.getInstance().getStageMonitor(GriverKeepAliveFullLinkStageMonitor.getMonitorToken(app));
            if (griverKeepAliveFullLinkStageMonitor != null) {
                griverKeepAliveFullLinkStageMonitor.restart();
            }
            if (Build.VERSION.SDK_INT >= 21 && !this.f6464a) {
                final AppModel queryAppInfo = GriverAppCenter.queryAppInfo(app.getAppId(), app.getAppVersion());
                if (queryAppInfo == null || queryAppInfo.getAppInfoModel() == null) {
                    return;
                }
                ImageUtils.loadImage(queryAppInfo.getAppInfoModel().getLogo(), new ImageListener() { // from class: com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back.1
                    @Override // com.alibaba.griver.base.common.adapter.ImageListener
                    public void onImage(final Bitmap bitmap) {
                        Back.this.runOnUiThread(new Runnable() { // from class: com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Back.this.setTaskDescription(new ActivityManager.TaskDescription(queryAppInfo.getAppInfoModel().getName(), bitmap));
                                Back.this.f6464a = true;
                            }
                        });
                    }
                });
            }
            KeepAliveAppManager.getInstance().moveFromTaskToFrontAliveActivityByAppId(app.getAppId(), app.getStartToken());
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity, android.app.Activity
        public void finish() {
            App app;
            boolean z = true;
            if (this.mActivityHelper != null && (app = this.mActivityHelper.getApp()) != null) {
                z = BundleUtils.getBoolean(app.getSceneParams(), KeepAliveAppManager.SHOW_FINISH_ANIM, true);
            }
            super.finish();
            if (z) {
                overridePendingTransition(com.alibaba.griver.core.R.anim.griver_core_app_exit_scale, com.alibaba.griver.core.R.anim.griver_core_app_exit_down_out);
            } else {
                overridePendingTransition(0, 0);
            }
            try {
                finishAndRemoveTask();
            } catch (Throwable unused) {
                GriverLogger.w("GriverBaseActivity", "low android version not support this api: finishAndRemoveTask");
            }
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity, android.app.Activity
        public void finishAndRemoveTask() {
            App app;
            boolean z = true;
            if (this.mActivityHelper != null && (app = this.mActivityHelper.getApp()) != null) {
                z = BundleUtils.getBoolean(app.getSceneParams(), KeepAliveAppManager.SHOW_FINISH_ANIM, true);
            }
            super.finishAndRemoveTask();
            if (z) {
                overridePendingTransition(com.alibaba.griver.core.R.anim.griver_core_app_exit_scale, com.alibaba.griver.core.R.anim.griver_core_app_exit_down_out);
            } else {
                overridePendingTransition(0, 0);
            }
        }

        private static void e(int i, int i2, int i3, char[] cArr, boolean z, Object[] objArr) {
            A a2 = new A();
            char[] cArr2 = new char[i];
            a2.MyBillsEntityDataFactory = 0;
            while (a2.MyBillsEntityDataFactory < i) {
                a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
                cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i3);
                int i4 = a2.MyBillsEntityDataFactory;
                cArr2[i4] = (char) (cArr2[i4] - ((int) (getErrorConfigVersion ^ (-5694784870793460699L))));
                a2.MyBillsEntityDataFactory++;
            }
            if (i2 > 0) {
                a2.BuiltInFictitiousFunctionClassFactory = i2;
                char[] cArr3 = new char[i];
                System.arraycopy(cArr2, 0, cArr3, 0, i);
                System.arraycopy(cArr3, 0, cArr2, i - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
                System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i - a2.BuiltInFictitiousFunctionClassFactory);
            }
            if (z) {
                char[] cArr4 = new char[i];
                a2.MyBillsEntityDataFactory = 0;
                while (a2.MyBillsEntityDataFactory < i) {
                    cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i - a2.MyBillsEntityDataFactory) - 1];
                    a2.MyBillsEntityDataFactory++;
                }
                cArr2 = cArr4;
            }
            objArr[0] = new String(cArr2);
        }
    }

    /* loaded from: classes3.dex */
    public static class Back1 extends Back {
        public static final byte[] $$g = {94, Ascii.EM, -44, 73, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
        public static final int $$h = 118;
        public static final byte[] getErrorConfigVersion = {56, -119, 46, TarHeader.LF_CONTIG, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
        public static final int NetworkUserEntityData$$ExternalSyntheticLambda0 = 239;
        private static long moveToNextValue = 5477434693369248842L;

        private static void j(int i, short s, int i2, Object[] objArr) {
            int i3 = 56 - i2;
            byte[] bArr = getErrorConfigVersion;
            int i4 = 23 - s;
            int i5 = i + 97;
            byte[] bArr2 = new byte[i4];
            int i6 = -1;
            int i7 = i4 - 1;
            if (bArr == null) {
                i5 = (i5 + (-i7)) - 4;
                objArr = objArr;
                bArr = bArr;
                bArr2 = bArr2;
                i6 = -1;
                i3++;
                i7 = i7;
            }
            while (true) {
                int i8 = i6 + 1;
                bArr2[i8] = (byte) i5;
                if (i8 == i7) {
                    objArr[0] = new String(bArr2, 0);
                    return;
                }
                int i9 = i3;
                i5 = (i5 + (-bArr[i3])) - 4;
                objArr = objArr;
                bArr = bArr;
                bArr2 = bArr2;
                i6 = i8;
                i3 = i9 + 1;
                i7 = i7;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x003a). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void k(byte r5, byte r6, byte r7, java.lang.Object[] r8) {
            /*
                int r6 = 46 - r6
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back1.$$g
                int r5 = r5 * 3
                int r5 = 42 - r5
                int r7 = r7 * 2
                int r7 = r7 + 75
                byte[] r1 = new byte[r5]
                r2 = -1
                int r5 = r5 + r2
                if (r0 != 0) goto L1a
                r7 = r6
                r2 = r1
                r3 = -1
                r6 = r5
                r1 = r0
                r0 = r8
                r8 = r7
                goto L3a
            L1a:
                r4 = r7
                r7 = r6
                r6 = r4
            L1d:
                int r2 = r2 + 1
                byte r3 = (byte) r6
                r1[r2] = r3
                if (r2 != r5) goto L2d
                java.lang.String r5 = new java.lang.String
                r6 = 0
                r5.<init>(r1, r6)
                r8[r6] = r5
                return
            L2d:
                int r7 = r7 + 1
                r3 = r0[r7]
                r4 = r6
                r6 = r5
                r5 = r3
                r3 = r2
                r2 = r1
                r1 = r0
                r0 = r8
                r8 = r7
                r7 = r4
            L3a:
                int r7 = r7 + r5
                int r5 = r7 + (-7)
                r7 = r8
                r8 = r0
                r0 = r1
                r1 = r2
                r2 = r3
                r4 = r6
                r6 = r5
                r5 = r4
                goto L1d
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back1.k(byte, byte, byte, java.lang.Object[]):void");
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            Object[] objArr;
            Object[] objArr2;
            Object[] objArr3;
            Object[] objArr4;
            super.attachBaseContext(context);
            Object[] objArr5 = new Object[1];
            h(ViewConfiguration.getScrollBarFadeDuration() >> 16, new char[]{18111, 18142, 4185, 55425, 22250, 57749, 15265, 33406, 32856, 43034, 28969, 52650, 52160, 28312, 43259, 14156, 5461, 21772, 60990, 32497, 23788, 7144}, objArr5);
            Class<?> cls = Class.forName((String) objArr5[0]);
            Object[] objArr6 = new Object[1];
            h(TextUtils.getOffsetBefore("", 0), new char[]{42202, 42167, 2590, 60103, 53451, 64453, 2518, 1092, 25142}, objArr6);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context applicationContext = context != null ? context.getApplicationContext() : context;
                if (applicationContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 35, (char) ((-1) - Process.getGidForName("")))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        h(ViewConfiguration.getMaximumFlingVelocity() >> 16, new char[]{56247, 56192, 11089, 33646, 60994, 55952, 24604, 15004, 7439, 37663, 10907, 29972, 22160, 21894, 62297, 36818, 34890, 28249, 46467, 50698, 49574, 8354, 32316, 293, 15227, 63864, 16609, 23546, 31971, 46000, 2338, 37424, 46653, 29807, 54259, 44217, 61390, 3717, 38104, 59229, 8473, 50946, 23898, 8668, 6864, 39365, 10190, 30786, 23565, 21016, 59460, 45721}, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        h(ViewConfiguration.getMaximumDrawingCacheSize() >> 24, new char[]{49870, 49839, 4521, 16773, 17578, 57406, 41719, 36904, 1056, 43450, 59513, 57340, 20410, 28536, 12776, 9577, 37170, 21666, 30568, 27872, 55516, 6745, 48263, 43933, 8706, 50130, 33375, 61719, 26056, 35097, 52168, 14553, 44878, 20119, 4427, 1542, 63213, 13359, 22069, 19892, 14437, 64928, 40889, 35639, 939, 41835, 58740, 53933, 17781, 26852, 10920, 6179, 35997, 20888, 28694, 26581, 54815, 5908, 47513, 44373, 6542, 56458, 65362, 62622, 25351, 33291, 50397, 12871}, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        h(TextUtils.getOffsetAfter("", 0), new char[]{1995, 2041, 13638, 15755, 453, 50389, 57002, 54593, 49530, 36187, 38005, 39583, 35555, 19404, 19943, 24578, 21602, 28751, 2919, 10636, 7562, 16097, 49371, 61095, 59217, 59246, 65030, 46200, 41164, 44530, 47046, 32235, 27157, 27258, 27968, 17208, 13244, 4288, 10813, 2267, 64865, 55579, 58289, 52819, 50851, 34770, 39214, 38855, 32811, 19468, 22262, 23833, 18893, 30077, 3148, 8934, 4881, 13309, 50625, 59454, 56460, 63585, 33542, 45477, 42581, 42729, 47234, 30498}, objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        h((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0), new char[]{60333, 60357, 13937, 48448, 22204, 51111, 24176, 33322, 11606, 36449, 5283, 52733, 26329, 18594, 52602, 14123, 47131, 29503, 35828, 32432, 61928, 15826, 16464, 47577, 2916, 58440, 32472, 58140, 19706, 44758, 14165, 10968, 34417, 26968, 60877, 5207, 57228, 5089, 43681, 24500, 4358, 55924, 25377, 39229, 10908, 34035, 6589, 49317, 27676, 20325, 54843, 2663, 42430, 30215, 36043, 30092, 65399, 12500, 17673, 48900, 12472, 64269, 896, 59033}, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        h((-1) - TextUtils.lastIndexOf("", '0', 0, 0), new char[]{23953, 23976, 61270, 8464, 48268, 7898, 49760, 26692, 39723, 22349}, objArr11);
                        try {
                            Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (ViewConfiguration.getLongPressTimeout() >> 16) + 18, (char) View.getDefaultSize(0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                    j((byte) (-getErrorConfigVersion[32]), getErrorConfigVersion[30], (byte) (-getErrorConfigVersion[31]), objArr13);
                    Class<?> cls2 = Class.forName((String) objArr13[0]);
                    Object[] objArr14 = new Object[1];
                    j((byte) (NetworkUserEntityData$$ExternalSyntheticLambda0 & 24), getErrorConfigVersion[30], 30, objArr14);
                    try {
                        Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                        if (obj3 == null) {
                            Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - View.MeasureSpec.getMode(0), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 3, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)));
                            Object[] objArr16 = new Object[1];
                            k($$g[31], $$g[53], $$g[78], objArr16);
                            obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                        }
                        Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - TextUtils.getCapsMode("", 0, 0), View.combineMeasuredStates(0, 0) + 15, (char) TextUtils.getTrimmedLength(""))).getMethod("getAuthRequestContext", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                            }
                            int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                            try {
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - TextUtils.lastIndexOf("", '0', 0, 0), 16 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("PlaceComponentResult", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                                }
                                if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                    ArrayList arrayList = new ArrayList();
                                    try {
                                        Object[] objArr17 = {invoke2};
                                        Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                        if (obj6 == null) {
                                            obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + 815, 29 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 57993))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + 800, 15 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)))));
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                        }
                                        arrayList.add(((Method) obj6).invoke(null, objArr17));
                                        long j = ((r11 ^ intValue2) & 4294967295L) | 60129542144L;
                                        try {
                                            Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                            if (obj7 != null) {
                                                objArr = null;
                                            } else {
                                                objArr = null;
                                                obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (Process.myPid() >> 22), 35 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                            }
                                            Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                            try {
                                                Object[] objArr18 = {358780059, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                                Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                                if (obj8 == null) {
                                                    obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 912, 18 - TextUtils.getCapsMode("", 0, 0), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    j((byte) (-getErrorConfigVersion[32]), getErrorConfigVersion[30], (byte) (-getErrorConfigVersion[31]), objArr19);
                    Class<?> cls4 = Class.forName((String) objArr19[0]);
                    Object[] objArr20 = new Object[1];
                    j((byte) (NetworkUserEntityData$$ExternalSyntheticLambda0 & 24), getErrorConfigVersion[30], 30, objArr20);
                    try {
                        Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                        Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                        if (obj9 == null) {
                            Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (ViewConfiguration.getKeyRepeatDelay() >> 16), 46 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (Process.getGidForName("") + 1));
                            Object[] objArr22 = new Object[1];
                            k($$g[8], $$g[84], $$g[9], objArr22);
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
                                    obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getOffsetBefore("", 0), 35 - (ViewConfiguration.getTapTimeout() >> 16), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                                }
                                Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                                try {
                                    Object[] objArr24 = {358780059, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj11 == null) {
                                        obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getOffsetBefore("", 0), KeyEvent.getDeadChar(0, 0) + 18, (char) View.combineMeasuredStates(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    j((byte) (-getErrorConfigVersion[32]), getErrorConfigVersion[30], (byte) (-getErrorConfigVersion[31]), objArr25);
                    Class<?> cls6 = Class.forName((String) objArr25[0]);
                    Object[] objArr26 = new Object[1];
                    j((byte) (NetworkUserEntityData$$ExternalSyntheticLambda0 & 24), getErrorConfigVersion[30], 30, objArr26);
                    try {
                        Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                        Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                        if (obj12 == null) {
                            Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(117 - Process.getGidForName(""), (ViewConfiguration.getScrollBarSize() >> 8) + 3, (char) (TextUtils.lastIndexOf("", '0') + 38969));
                            Object[] objArr28 = new Object[1];
                            k($$g[8], $$g[84], $$g[9], objArr28);
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
                                    obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, Color.red(0) + 35, (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                                }
                                Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                                try {
                                    Object[] objArr30 = {358780059, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj14 == null) {
                                        obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.combineMeasuredStates(0, 0), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18, (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    j((byte) (-getErrorConfigVersion[32]), getErrorConfigVersion[30], (byte) (-getErrorConfigVersion[31]), objArr31);
                    Class<?> cls8 = Class.forName((String) objArr31[0]);
                    Object[] objArr32 = new Object[1];
                    j((byte) (NetworkUserEntityData$$ExternalSyntheticLambda0 & 24), getErrorConfigVersion[30], 30, objArr32);
                    try {
                        Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                        Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                        if (obj15 == null) {
                            Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + 108, View.resolveSizeAndState(0, 0, 0) + 3, (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))));
                            byte b = (byte) ($$g[78] - 1);
                            byte b2 = b;
                            Object[] objArr34 = new Object[1];
                            k(b, b2, b2, objArr34);
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
                                    obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollDefaultDelay() >> 16), KeyEvent.normalizeMetaState(0) + 35, (char) TextUtils.indexOf("", "", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                                }
                                Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                                try {
                                    Object[] objArr36 = {358780059, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj17 == null) {
                                        obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.makeMeasureSpec(0, 0), 19 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return super.getApplicationContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
        public Context getBaseContext() {
            return super.getBaseContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
        public Resources getResources() {
            return super.getResources();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle bundle) {
            Object[] objArr = new Object[1];
            h(1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), new char[]{18111, 18142, 4185, 55425, 22250, 57749, 15265, 33406, 32856, 43034, 28969, 52650, 52160, 28312, 43259, 14156, 5461, 21772, 60990, 32497, 23788, 7144}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            h(ViewConfiguration.getLongPressTimeout() >> 16, new char[]{42202, 42167, 2590, 60103, 53451, 64453, 2518, 1092, 25142}, objArr2);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr2[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    try {
                        byte b = getErrorConfigVersion[25];
                        byte b2 = b;
                        Object[] objArr3 = new Object[1];
                        j(b, b2, (byte) (b2 | TarHeader.LF_BLK), objArr3);
                        Class<?> cls2 = Class.forName((String) objArr3[0]);
                        j(getErrorConfigVersion[5], getErrorConfigVersion[41], getErrorConfigVersion[25], new Object[1]);
                        Object[] objArr4 = new Object[1];
                        h(((ApplicationInfo) cls2.getMethod((String) r2[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{4637, 4732, 13850, 51203, 56042, 51158, 11043, 3710, 54522, 36441, 25003, 16810, 40812, 18648, 47143, 47922, 16836, 29507, 65195, 62205, 2123, 15793, 13587, 13717, 62177, 58424, 2973, 28417, 46412, 44716}, objArr4);
                        Class<?> cls3 = Class.forName((String) objArr4[0]);
                        Object[] objArr5 = new Object[1];
                        h(super.getResources().getString(R.string.transfer_account_status_title_pending).substring(3, 4).length() - 1, new char[]{52484, 52583, 30130, 50708, 27654, 33893, 9506, 47250, 3049, 52726, 28588, 63273, 16484, 2928, 46636, 3481, 40703, 12521, 61628, 17425, 55115, 32286}, objArr5);
                        baseContext = (Context) cls3.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
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
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 930, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 35, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr6 = new Object[1];
                        h(super.getResources().getString(R.string.empty_state_bank_cards_desc_v3).substring(0, 6).codePointAt(0) - 84, new char[]{56247, 56192, 11089, 33646, 60994, 55952, 24604, 15004, 7439, 37663, 10907, 29972, 22160, 21894, 62297, 36818, 34890, 28249, 46467, 50698, 49574, 8354, 32316, 293, 15227, 63864, 16609, 23546, 31971, 46000, 2338, 37424, 46653, 29807, 54259, 44217, 61390, 3717, 38104, 59229, 8473, 50946, 23898, 8668, 6864, 39365, 10190, 30786, 23565, 21016, 59460, 45721}, objArr6);
                        String str = (String) objArr6[0];
                        Object[] objArr7 = new Object[1];
                        h(super.getResources().getString(R.string.BuiltInFictitiousFunctionClassFactory).substring(4, 5).codePointAt(0) - 97, new char[]{49870, 49839, 4521, 16773, 17578, 57406, 41719, 36904, 1056, 43450, 59513, 57340, 20410, 28536, 12776, 9577, 37170, 21666, 30568, 27872, 55516, 6745, 48263, 43933, 8706, 50130, 33375, 61719, 26056, 35097, 52168, 14553, 44878, 20119, 4427, 1542, 63213, 13359, 22069, 19892, 14437, 64928, 40889, 35639, 939, 41835, 58740, 53933, 17781, 26852, 10920, 6179, 35997, 20888, 28694, 26581, 54815, 5908, 47513, 44373, 6542, 56458, 65362, 62622, 25351, 33291, 50397, 12871}, objArr7);
                        String str2 = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        h(super.getResources().getString(R.string.session_expired_desc).substring(9, 10).length() - 1, new char[]{1995, 2041, 13638, 15755, 453, 50389, 57002, 54593, 49530, 36187, 38005, 39583, 35555, 19404, 19943, 24578, 21602, 28751, 2919, 10636, 7562, 16097, 49371, 61095, 59217, 59246, 65030, 46200, 41164, 44530, 47046, 32235, 27157, 27258, 27968, 17208, 13244, 4288, 10813, 2267, 64865, 55579, 58289, 52819, 50851, 34770, 39214, 38855, 32811, 19468, 22262, 23833, 18893, 30077, 3148, 8934, 4881, 13309, 50625, 59454, 56460, 63585, 33542, 45477, 42581, 42729, 47234, 30498}, objArr8);
                        String str3 = (String) objArr8[0];
                        try {
                            byte b3 = getErrorConfigVersion[25];
                            byte b4 = b3;
                            Object[] objArr9 = new Object[1];
                            j(b3, b4, (byte) (b4 | TarHeader.LF_BLK), objArr9);
                            Class<?> cls4 = Class.forName((String) objArr9[0]);
                            j(getErrorConfigVersion[5], getErrorConfigVersion[41], getErrorConfigVersion[25], new Object[1]);
                            Object[] objArr10 = new Object[1];
                            h(((ApplicationInfo) cls4.getMethod((String) r3[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{60333, 60357, 13937, 48448, 22204, 51111, 24176, 33322, 11606, 36449, 5283, 52733, 26329, 18594, 52602, 14123, 47131, 29503, 35828, 32432, 61928, 15826, 16464, 47577, 2916, 58440, 32472, 58140, 19706, 44758, 14165, 10968, 34417, 26968, 60877, 5207, 57228, 5089, 43681, 24500, 4358, 55924, 25377, 39229, 10908, 34035, 6589, 49317, 27676, 20325, 54843, 2663, 42430, 30215, 36043, 30092, 65399, 12500, 17673, 48900, 12472, 64269, 896, 59033}, objArr10);
                            String str4 = (String) objArr10[0];
                            Object[] objArr11 = new Object[1];
                            h(super.getResources().getString(R.string.cashier_general_processing_title).substring(0, 1).length() - 1, new char[]{23953, 23976, 61270, 8464, 48268, 7898, 49760, 26692, 39723, 22349}, objArr11);
                            try {
                                Object[] objArr12 = {baseContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + 911, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 17, (char) TextUtils.indexOf("", ""))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                }
                                ((Method) obj2).invoke(invoke, objArr12);
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
                }
            }
            try {
                Object[] objArr13 = new Object[1];
                j((byte) (-getErrorConfigVersion[32]), getErrorConfigVersion[30], (byte) (-getErrorConfigVersion[31]), objArr13);
                Class<?> cls5 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                j((byte) (NetworkUserEntityData$$ExternalSyntheticLambda0 & 24), getErrorConfigVersion[30], 30, objArr14);
                try {
                    Object[] objArr15 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 3 - MotionEvent.axisFromString(""), (char) (ViewConfiguration.getFadingEdgeLength() >> 16));
                        byte b5 = (byte) ($$g[78] - 1);
                        byte b6 = b5;
                        Object[] objArr16 = new Object[1];
                        k(b5, b6, b6, objArr16);
                        obj3 = cls6.getMethod((String) objArr16[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr17 = (Object[]) ((Method) obj3).invoke(null, objArr15);
                    int i = ((int[]) objArr17[1])[0];
                    if (((int[]) objArr17[0])[0] != i) {
                        long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(977 - AndroidCharacter.getMirror('0'), 35 - TextUtils.getTrimmedLength(""), (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(null, null);
                            try {
                                Object[] objArr18 = {778140528, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + 911, 18 - View.MeasureSpec.getSize(0), (char) ((-1) - Process.getGidForName("")))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr18);
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
                    }
                    super.onCreate(bundle);
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
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onPause() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr = new Object[1];
                h(ViewConfiguration.getScrollDefaultDelay() >> 16, new char[]{4637, 4732, 13850, 51203, 56042, 51158, 11043, 3710, 54522, 36441, 25003, 16810, 40812, 18648, 47143, 47922, 16836, 29507, 65195, 62205, 2123, 15793, 13587, 13717, 62177, 58424, 2973, 28417, 46412, 44716}, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                h(ViewConfiguration.getTouchSlop() >> 8, new char[]{52484, 52583, 30130, 50708, 27654, 33893, 9506, 47250, 3049, 52726, 28588, 63273, 16484, 2928, 46636, 3481, 40703, 12521, 61628, 17425, 55115, 32286}, objArr2);
                baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 35 - Color.blue(0), (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr3 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 911, 18 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("MyBillsEntityDataFactory", Context.class);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onResume() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr = new Object[1];
                h(super.getResources().getString(R.string.referral_code_tap_msg).substring(3, 4).length() - 1, new char[]{4637, 4732, 13850, 51203, 56042, 51158, 11043, 3710, 54522, 36441, 25003, 16810, 40812, 18648, 47143, 47922, 16836, 29507, 65195, 62205, 2123, 15793, 13587, 13717, 62177, 58424, 2973, 28417, 46412, 44716}, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                try {
                    byte b = getErrorConfigVersion[25];
                    byte b2 = b;
                    Object[] objArr2 = new Object[1];
                    j(b, b2, (byte) (b2 | TarHeader.LF_BLK), objArr2);
                    Class<?> cls2 = Class.forName((String) objArr2[0]);
                    j(getErrorConfigVersion[5], getErrorConfigVersion[41], getErrorConfigVersion[25], new Object[1]);
                    Object[] objArr3 = new Object[1];
                    h(((ApplicationInfo) cls2.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{52484, 52583, 30130, 50708, 27654, 33893, 9506, 47250, 3049, 52726, 28588, 63273, 16484, 2928, 46636, 3481, 40703, 12521, 61628, 17425, 55115, 32286}, objArr3);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, Color.red(0) + 35, (char) View.combineMeasuredStates(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr4 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), TextUtils.lastIndexOf("", '0', 0) + 19, (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

        private static void h(int i, char[] cArr, Object[] objArr) {
            D d = new D();
            char[] KClassImpl$Data$declaredNonStaticMembers$2 = D.KClassImpl$Data$declaredNonStaticMembers$2(moveToNextValue ^ 3919452569568103912L, cArr, i);
            d.MyBillsEntityDataFactory = 4;
            while (d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$2.length) {
                d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
                KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (moveToNextValue ^ 3919452569568103912L)));
                d.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$2, 4, KClassImpl$Data$declaredNonStaticMembers$2.length - 4);
        }
    }

    /* loaded from: classes3.dex */
    public static class Back6 extends Back {
        public static final byte[] $$g = {117, -10, 119, -11, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
        public static final int $$h = 249;
        public static final byte[] NetworkUserEntityData$$ExternalSyntheticLambda0 = {11, 41, -68, -59, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
        public static final int moveToNextValue = 53;
        private static long lookAheadTest = 6830892050329663017L;

        /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0032). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void h(int r7, int r8, short r9, java.lang.Object[] r10) {
            /*
                int r8 = r8 + 4
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back6.NetworkUserEntityData$$ExternalSyntheticLambda0
                int r7 = 23 - r7
                int r9 = r9 + 97
                byte[] r1 = new byte[r7]
                r2 = 0
                if (r0 != 0) goto L14
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r10
                r10 = r8
                r8 = r7
                goto L32
            L14:
                r3 = 0
                r6 = r8
                r8 = r7
                r7 = r9
                r9 = r6
            L19:
                int r4 = r3 + 1
                byte r5 = (byte) r7
                r1[r3] = r5
                if (r4 != r8) goto L28
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L28:
                int r9 = r9 + 1
                r3 = r0[r9]
                r6 = r10
                r10 = r9
                r9 = r3
                r3 = r1
                r1 = r0
                r0 = r6
            L32:
                int r7 = r7 + r9
                int r7 = r7 + (-4)
                r9 = r10
                r10 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L19
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back6.h(int, int, short, java.lang.Object[]):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0037). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void k(byte r6, int r7, int r8, java.lang.Object[] r9) {
            /*
                int r6 = r6 + 4
                int r8 = r8 * 2
                int r8 = r8 + 75
                int r7 = r7 * 3
                int r7 = r7 + 21
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back6.$$g
                byte[] r1 = new byte[r7]
                int r7 = r7 + (-1)
                r2 = 0
                if (r0 != 0) goto L1b
                r8 = r7
                r3 = r1
                r4 = 0
                r7 = r6
                r1 = r0
                r0 = r9
                r9 = r8
                goto L37
            L1b:
                r3 = 0
            L1c:
                int r6 = r6 + 1
                byte r4 = (byte) r8
                r1[r3] = r4
                if (r3 != r7) goto L2b
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L2b:
                r4 = r0[r6]
                int r3 = r3 + 1
                r5 = r7
                r7 = r6
                r6 = r4
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r9
                r9 = r5
            L37:
                int r8 = r8 + r6
                int r8 = r8 + (-7)
                r6 = r7
                r7 = r9
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L1c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back6.k(byte, int, int, java.lang.Object[]):void");
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            Object[] objArr;
            Object[] objArr2;
            Object[] objArr3;
            Object[] objArr4;
            super.attachBaseContext(context);
            Object[] objArr5 = new Object[1];
            j(-((byte) KeyEvent.getModifierMetaStateMask()), new char[]{26751, 26654, 45822, 48614, 53912, 34580, 35153, 51712, 25001, 41981, 44258, 50112, 46616, 37099, 40868, 61618, 42241, 33267, 36589, 57731, 54300, 32499}, objArr5);
            Class<?> cls = Class.forName((String) objArr5[0]);
            Object[] objArr6 = new Object[1];
            j(TextUtils.getCapsMode("", 0, 0) + 1, new char[]{43232, 43149, 7497, 58199, 54066, 18304, 9969, 38016, 24600}, objArr6);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context applicationContext = context != null ? context.getApplicationContext() : context;
                if (applicationContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (Process.myTid() >> 22) + 35, (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        j(1 - (ViewConfiguration.getLongPressTimeout() >> 16), new char[]{49672, 49727, 38207, 26501, 2964, 11580, 44701, 4145, 47343, 33852, 30350, 6800, 7223, 46897, 17880, 10690, 3937, 42594, 21646, 14486, 32297, 22909, 9109, 55261, 27000, 18475, 12996, 59022, 22644, 31607, 403, 62928, 19238, 27172, 4302, 34005, 47633, 7498, 65441, 37813, 42314, 3137, 52911, 41656, 37911, 16146, 56751, 45490, 34630, 11843, 44201, 16613}, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        j(-TextUtils.lastIndexOf("", '0'), new char[]{727, 694, 20806, 45032, 59441, 60853, 27314, 55388, 23318, 16462, 48874, 63849, 56507, 29464, 36335, 51816, 53183, 25166, 40163, 56173, 48885, 40273, 60328, 13428, 43431, 35926, 64252, 1394, 39161, 48905, 51711, 5672, 35827, 44555, 55536, 26491, 31380, 55607, 14282, 28749, 26000, 51252, 1738, 16706, 21706, 64363, 5523, 21068, 18328, 60008, 25795, 41806, 14036, 1392, 29657, 48220, 8666, 13424, 17114, 36176, 4319, 10106, 20869, 40463, 986, 22135, 41094, 61274}, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        j(1 - (Process.myPid() >> 22), new char[]{24074, 24120, 24947, 6792, 21345, 45367, 23171, 28015, 57408, 28785, 3035, 16947, 32826, 17266, 14557, 28986, 37687, 21117, 10705, 24632, 57979, 44343, 24265, 36727, 62764, 48180, 20376, 48676, 50213, 36668, 31948, 44323, 55152, 40504, 28102, 56444, 9757, 59654, 33535, 51995, 14668, 63569, 46079, 64031, 2074, 51980, 41204, 59679, 6942, 55902, 53664, 6221, 27228, 13643, 50878, 1878, 32012, 1095, 63423, 13826, 19461, 5967, 58604, 9485, 24400, 26187, 5604, 21510}, objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        j(1 - TextUtils.indexOf("", "", 0), new char[]{33636, 33548, 43485, 54710, 15611, 27667, 37480, 41536, 36808, 47255, 50409, 11680, 23816, 35776, 63396, 7906, 20038, 39633, 59046, 4085, 16145, 26072, 37286, 57592, 10257, 29902, 32930, 53681, 6427, 18372, 46011, 49889, 2588, 22214, 41647, 46050, 64293, 8699, 19847, 42117, 58403, 12514, 31883, 38272, 54573, 1009, 28547, 34444, 50721, 4843, 7817, 30658, 46887, 65005, 2525, 26829, 41058, 52402, 14483, 22985, 37177, 57343, 11150, 19136}, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        j((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1, new char[]{52441, 52448, 39979, 5413, 972, 9199, 42948, 25235, 45217, 36144}, objArr11);
                        try {
                            Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + 911, 19 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                    h((byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), (byte) (moveToNextValue & 238), NetworkUserEntityData$$ExternalSyntheticLambda0[32], objArr13);
                    Class<?> cls2 = Class.forName((String) objArr13[0]);
                    Object[] objArr14 = new Object[1];
                    h((byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), (byte) (moveToNextValue & 95), (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[32] - 1), objArr14);
                    try {
                        Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                        if (obj3 == null) {
                            Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - TextUtils.indexOf("", ""), 3 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) View.resolveSizeAndState(0, 0, 0));
                            byte b = $$g[47];
                            byte b2 = $$g[78];
                            Object[] objArr16 = new Object[1];
                            k(b, b2, b2, objArr16);
                            obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                        }
                        Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + 800, Gravity.getAbsoluteGravity(0, 0) + 15, (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("getAuthRequestContext", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                            }
                            int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                            try {
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + 800, 14 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("PlaceComponentResult", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                                }
                                if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                    ArrayList arrayList = new ArrayList();
                                    try {
                                        Object[] objArr17 = {invoke2};
                                        Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                        if (obj6 == null) {
                                            obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(816 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (ViewConfiguration.getLongPressTimeout() >> 16) + 29, (char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - KeyEvent.getDeadChar(0, 0), 15 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0'))));
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
                                                obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (-16777181) - Color.rgb(0, 0, 0), (char) ((-1) - TextUtils.lastIndexOf("", '0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                            }
                                            Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                            try {
                                                Object[] objArr18 = {-423325396, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                                Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                                if (obj8 == null) {
                                                    obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 18 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) View.combineMeasuredStates(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    h((byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), (byte) (moveToNextValue & 238), NetworkUserEntityData$$ExternalSyntheticLambda0[32], objArr19);
                    Class<?> cls4 = Class.forName((String) objArr19[0]);
                    Object[] objArr20 = new Object[1];
                    h((byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), (byte) (moveToNextValue & 95), (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[32] - 1), objArr20);
                    try {
                        Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                        Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                        if (obj9 == null) {
                            Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + 61, TextUtils.indexOf("", "", 0) + 46, (char) (Process.myPid() >> 22));
                            Object[] objArr22 = new Object[1];
                            k($$g[28], (byte) ($$g[78] - 1), $$g[9], objArr22);
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
                                    obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 34 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                                }
                                Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                                try {
                                    Object[] objArr24 = {-423325396, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj11 == null) {
                                        obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 912, 17 - TextUtils.indexOf((CharSequence) "", '0'), (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    h((byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), (byte) (moveToNextValue & 238), NetworkUserEntityData$$ExternalSyntheticLambda0[32], objArr25);
                    Class<?> cls6 = Class.forName((String) objArr25[0]);
                    Object[] objArr26 = new Object[1];
                    h((byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), (byte) (moveToNextValue & 95), (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[32] - 1), objArr26);
                    try {
                        Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                        Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                        if (obj12 == null) {
                            Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + 118, TextUtils.indexOf("", "") + 3, (char) (Color.blue(0) + 38968));
                            Object[] objArr28 = new Object[1];
                            k($$g[28], (byte) ($$g[78] - 1), $$g[9], objArr28);
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
                                    obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 35 - View.getDefaultSize(0, 0), (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                                }
                                Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                                try {
                                    Object[] objArr30 = {-423325396, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj14 == null) {
                                        obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ImageFormat.getBitsPerPixel(0), 18 - View.getDefaultSize(0, 0), (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    h((byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), (byte) (moveToNextValue & 238), NetworkUserEntityData$$ExternalSyntheticLambda0[32], objArr31);
                    Class<?> cls8 = Class.forName((String) objArr31[0]);
                    Object[] objArr32 = new Object[1];
                    h((byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), (byte) (moveToNextValue & 95), (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[32] - 1), objArr32);
                    try {
                        Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                        Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                        if (obj15 == null) {
                            Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 107, 3 - KeyEvent.getDeadChar(0, 0), (char) KeyEvent.getDeadChar(0, 0));
                            Object[] objArr34 = new Object[1];
                            k((byte) (-$$g[40]), $$g[8], (byte) ($$g[78] - 1), objArr34);
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
                                    obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 34 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) TextUtils.getCapsMode("", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                                }
                                Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                                try {
                                    Object[] objArr36 = {-423325396, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj17 == null) {
                                        obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + 911, (ViewConfiguration.getEdgeSlop() >> 16) + 18, (char) TextUtils.getCapsMode("", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return super.getApplicationContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
        public Context getBaseContext() {
            return super.getBaseContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
        public Resources getResources() {
            return super.getResources();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle bundle) {
            Object[] objArr;
            Object[] objArr2 = new Object[1];
            j(super.getResources().getString(R.string.payment_header_new_total_assets_nine_plus).substring(0, 3).length() - 2, new char[]{26751, 26654, 45822, 48614, 53912, 34580, 35153, 51712, 25001, 41981, 44258, 50112, 46616, 37099, 40868, 61618, 42241, 33267, 36589, 57731, 54300, 32499}, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            j((Process.myTid() >> 22) + 1, new char[]{43232, 43149, 7497, 58199, 54066, 18304, 9969, 38016, 24600}, objArr3);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr4 = new Object[1];
                    j(getPackageName().length() - 6, new char[]{58537, 58568, 11166, 18979, 34447, 3010, 4145, 15813, 13758, 15005, 23335, 38871, 15040, 2440, 26687, 42203, 10724, 6303, 31039, 46488, 22735, 59273, 3619, 23188, 20457, 63116, 7969, 27532, 32464, 50572}, objArr4);
                    Class<?> cls2 = Class.forName((String) objArr4[0]);
                    try {
                        Object[] objArr5 = new Object[1];
                        h(NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[9], NetworkUserEntityData$$ExternalSyntheticLambda0[25], objArr5);
                        Class<?> cls3 = Class.forName((String) objArr5[0]);
                        h(NetworkUserEntityData$$ExternalSyntheticLambda0[27], NetworkUserEntityData$$ExternalSyntheticLambda0[59], (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[5]), new Object[1]);
                        Object[] objArr6 = new Object[1];
                        j(((ApplicationInfo) cls3.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 32, new char[]{6596, 6567, 52967, 58571, 18521, 63141, 62803, 37691, 64360, 57336, 62921, 22894, 51132, 60650, 50909, 27210, 54443, 65023, 55233, 31566, 42427, 748}, objArr6);
                        baseContext = (Context) cls2.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
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
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0'), 35 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) View.getDefaultSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        j(TextUtils.indexOf("", "", 0) + 1, new char[]{49672, 49727, 38207, 26501, 2964, 11580, 44701, 4145, 47343, 33852, 30350, 6800, 7223, 46897, 17880, 10690, 3937, 42594, 21646, 14486, 32297, 22909, 9109, 55261, 27000, 18475, 12996, 59022, 22644, 31607, 403, 62928, 19238, 27172, 4302, 34005, 47633, 7498, 65441, 37813, 42314, 3137, 52911, 41656, 37911, 16146, 56751, 45490, 34630, 11843, 44201, 16613}, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        j(super.getResources().getString(R.string.general_network_error_title).substring(6, 7).codePointAt(0) - 100, new char[]{727, 694, 20806, 45032, 59441, 60853, 27314, 55388, 23318, 16462, 48874, 63849, 56507, 29464, 36335, 51816, 53183, 25166, 40163, 56173, 48885, 40273, 60328, 13428, 43431, 35926, 64252, 1394, 39161, 48905, 51711, 5672, 35827, 44555, 55536, 26491, 31380, 55607, 14282, 28749, 26000, 51252, 1738, 16706, 21706, 64363, 5523, 21068, 18328, 60008, 25795, 41806, 14036, 1392, 29657, 48220, 8666, 13424, 17114, 36176, 4319, 10106, 20869, 40463, 986, 22135, 41094, 61274}, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        j(-MotionEvent.axisFromString(""), new char[]{24074, 24120, 24947, 6792, 21345, 45367, 23171, 28015, 57408, 28785, 3035, 16947, 32826, 17266, 14557, 28986, 37687, 21117, 10705, 24632, 57979, 44343, 24265, 36727, 62764, 48180, 20376, 48676, 50213, 36668, 31948, 44323, 55152, 40504, 28102, 56444, 9757, 59654, 33535, 51995, 14668, 63569, 46079, 64031, 2074, 51980, 41204, 59679, 6942, 55902, 53664, 6221, 27228, 13643, 50878, 1878, 32012, 1095, 63423, 13826, 19461, 5967, 58604, 9485, 24400, 26187, 5604, 21510}, objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        j((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 1, new char[]{33636, 33548, 43485, 54710, 15611, 27667, 37480, 41536, 36808, 47255, 50409, 11680, 23816, 35776, 63396, 7906, 20038, 39633, 59046, 4085, 16145, 26072, 37286, 57592, 10257, 29902, 32930, 53681, 6427, 18372, 46011, 49889, 2588, 22214, 41647, 46050, 64293, 8699, 19847, 42117, 58403, 12514, 31883, 38272, 54573, 1009, 28547, 34444, 50721, 4843, 7817, 30658, 46887, 65005, 2525, 26829, 41058, 52402, 14483, 22985, 37177, 57343, 11150, 19136}, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        j(super.getResources().getString(R.string.mybills_edit_bill_date_label).substring(7, 8).length() + 0, new char[]{52441, 52448, 39979, 5413, 972, 9199, 42948, 25235, 45217, 36144}, objArr11);
                        try {
                            Object[] objArr12 = {baseContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 911, (ViewConfiguration.getJumpTapTimeout() >> 16) + 18, (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                            }
                            ((Method) obj2).invoke(invoke, objArr12);
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
                h((byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), (byte) (moveToNextValue & 238), NetworkUserEntityData$$ExternalSyntheticLambda0[32], objArr13);
                Class<?> cls4 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                h((byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), (byte) (moveToNextValue & 95), (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[32] - 1), objArr14);
                try {
                    Object[] objArr15 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), TextUtils.indexOf((CharSequence) "", '0', 0) + 5, (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))));
                        Object[] objArr16 = new Object[1];
                        k((byte) (-$$g[40]), $$g[8], (byte) ($$g[78] - 1), objArr16);
                        obj3 = cls5.getMethod((String) objArr16[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr17 = (Object[]) ((Method) obj3).invoke(null, objArr15);
                    int i = ((int[]) objArr17[1])[0];
                    if (((int[]) objArr17[0])[0] != i) {
                        long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + PDF417Common.NUMBER_OF_CODEWORDS, Color.red(0) + 35, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr18 = {-730333795, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 17, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onPause() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                try {
                    Object[] objArr = new Object[1];
                    h(NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[9], NetworkUserEntityData$$ExternalSyntheticLambda0[25], objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    h(NetworkUserEntityData$$ExternalSyntheticLambda0[27], NetworkUserEntityData$$ExternalSyntheticLambda0[59], (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[5]), new Object[1]);
                    Object[] objArr2 = new Object[1];
                    j(((ApplicationInfo) cls.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 32, new char[]{58537, 58568, 11166, 18979, 34447, 3010, 4145, 15813, 13758, 15005, 23335, 38871, 15040, 2440, 26687, 42203, 10724, 6303, 31039, 46488, 22735, 59273, 3619, 23188, 20457, 63116, 7969, 27532, 32464, 50572}, objArr2);
                    Class<?> cls2 = Class.forName((String) objArr2[0]);
                    Object[] objArr3 = new Object[1];
                    j((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 1, new char[]{6596, 6567, 52967, 58571, 18521, 63141, 62803, 37691, 64360, 57336, 62921, 22894, 51132, 60650, 50909, 27210, 54443, 65023, 55233, 31566, 42427, 748}, objArr3);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 930, ExpandableListView.getPackedPositionGroup(0L) + 35, (char) ExpandableListView.getPackedPositionType(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr4 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarSize() >> 8), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18, (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("MyBillsEntityDataFactory", Context.class);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onResume() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                try {
                    Object[] objArr = new Object[1];
                    h(NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[9], NetworkUserEntityData$$ExternalSyntheticLambda0[25], objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    h(NetworkUserEntityData$$ExternalSyntheticLambda0[27], NetworkUserEntityData$$ExternalSyntheticLambda0[59], (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[5]), new Object[1]);
                    Object[] objArr2 = new Object[1];
                    j(((ApplicationInfo) cls.getMethod((String) r7[0], null).invoke(this, null)).targetSdkVersion - 32, new char[]{58537, 58568, 11166, 18979, 34447, 3010, 4145, 15813, 13758, 15005, 23335, 38871, 15040, 2440, 26687, 42203, 10724, 6303, 31039, 46488, 22735, 59273, 3619, 23188, 20457, 63116, 7969, 27532, 32464, 50572}, objArr2);
                    Class<?> cls2 = Class.forName((String) objArr2[0]);
                    Object[] objArr3 = new Object[1];
                    j(super.getResources().getString(R.string.uh_oh_no_internet_connection).substring(0, 1).codePointAt(0) - 84, new char[]{6596, 6567, 52967, 58571, 18521, 63141, 62803, 37691, 64360, 57336, 62921, 22894, 51132, 60650, 50909, 27210, 54443, 65023, 55233, 31566, 42427, 748}, objArr3);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getTapTimeout() >> 16), (char) View.MeasureSpec.getSize(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr4 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (KeyEvent.getMaxKeyCode() >> 16), AndroidCharacter.getMirror('0') - 30, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

        private static void j(int i, char[] cArr, Object[] objArr) {
            D d = new D();
            char[] KClassImpl$Data$declaredNonStaticMembers$2 = D.KClassImpl$Data$declaredNonStaticMembers$2(lookAheadTest ^ 3919452569568103912L, cArr, i);
            d.MyBillsEntityDataFactory = 4;
            while (d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$2.length) {
                d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
                KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (lookAheadTest ^ 3919452569568103912L)));
                d.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$2, 4, KClassImpl$Data$declaredNonStaticMembers$2.length - 4);
        }
    }

    /* loaded from: classes3.dex */
    public static class Back4 extends Back {
        public static final byte[] $$g = {62, -79, -77, -78, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
        public static final int $$h = 230;
        public static final byte[] moveToNextValue = {11, -83, -14, 91, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
        public static final int getErrorConfigVersion = 86;
        private static long NetworkUserEntityData$$ExternalSyntheticLambda0 = 6332662029304545865L;

        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0031). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void j(byte r6, int r7, byte r8, java.lang.Object[] r9) {
            /*
                int r8 = 106 - r8
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back4.moveToNextValue
                int r6 = r6 + 4
                int r7 = r7 + 16
                byte[] r1 = new byte[r7]
                int r7 = r7 + (-1)
                r2 = 0
                if (r0 != 0) goto L17
                r8 = r7
                r3 = r1
                r4 = 0
                r7 = r6
                r1 = r0
                r0 = r9
                r9 = r8
                goto L31
            L17:
                r3 = 0
            L18:
                byte r4 = (byte) r8
                r1[r3] = r4
                if (r3 != r7) goto L25
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L25:
                int r3 = r3 + 1
                r4 = r0[r6]
                r5 = r7
                r7 = r6
                r6 = r4
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r9
                r9 = r5
            L31:
                int r8 = r8 + r6
                int r8 = r8 + (-4)
                int r6 = r7 + 1
                r7 = r9
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L18
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back4.j(byte, int, byte, java.lang.Object[]):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002e). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void k(short r6, byte r7, int r8, java.lang.Object[] r9) {
            /*
                int r6 = r6 * 3
                int r6 = r6 + 21
                int r8 = r8 * 2
                int r8 = 103 - r8
                int r7 = r7 + 4
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back4.$$g
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
                int r7 = r7 + r4
                int r7 = r7 + (-7)
                r5 = r8
                r8 = r7
                r7 = r5
                goto L18
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back4.k(short, byte, int, java.lang.Object[]):void");
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            Object[] objArr;
            Object[] objArr2;
            Object[] objArr3;
            Object[] objArr4;
            super.attachBaseContext(context);
            Object[] objArr5 = new Object[1];
            h((ViewConfiguration.getEdgeSlop() >> 16) + 17657, new char[]{37739, 55197, 6812, 23955, 32897, 52158, 3768, 29163, 46253, 65464, 8862, 26089, 43220, 5056, 22263, 39416, 56553, 2032}, objArr5);
            Class<?> cls = Class.forName((String) objArr5[0]);
            Object[] objArr6 = new Object[1];
            h(View.resolveSizeAndState(0, 0, 0) + 64081, new char[]{37735, 26914, 26621, 32144, 31274}, objArr6);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context applicationContext = context != null ? context.getApplicationContext() : context;
                if (applicationContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 930, 35 - Drawable.resolveOpacity(0, 0), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        h(TextUtils.getOffsetBefore("", 0) + 23071, new char[]{37693, 51574, 9986, 40303, 64326, 20981, 36745, 58859, 17349, 47224, 5727, 19513, 43547, 171, 32393, 54509, 13003, 28468, 50450, 8998, 39170, 63458, 11715, 35829, 57734, 24126, 46100, 4651, 18524, 42733, 7369, 31406, 53459, 3779, 27430, 49422, 16176, 38216, 62376, 10627, 34789, 64923, 23080, 45065, 60988, 17482, 41646, 6366}, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        h(20930 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), new char[]{37739, 49918, 12478, 26157, 54376, 3062, 31164, 44917, 7526, 19616, 41657, 4212, 18018, 46582, 60341, 22897, 36648, 65257, 11518, 33384, 61562, 10222, 38314, 52078, 14628, 26801, 57001, 3124, 25134, 53683, 1958, 30055, 43849, 6799, 18588, 48721, 60493, 17292, 45468, 59230, 21783, 34003, 64197, 10320, 40517, 52688, 9109, 37202, 50953, 14024, 25743, 55872, 2055, 32712, 44428, 844, 28930, 41154, 5843, 17427, 47623, 59855, 24528, 36166}, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        h(13121 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), new char[]{37688, 41082, 62957, 2731, 24119, 37752, 41150, 62969, 2362, 24187, 37816, 41200, 62519, 2420, 24244, 37874, 42875, 62526, 2476, 24253, 37420, 42813, 62717, 2542, 23845, 37429, 42921, 62697, 2160, 23857, 37539, 42934, 64285, 2063, 23962, 37585, 42572, 64344, 2202, 24021, 37146, 42501, 64401, 2261, 23582, 37207, 42693, 64391, 3932, 23618, 37339, 42652, 64012, 3918, 23770, 37320, 42245, 64070, 3977, 23751, 36944, 42306, 64129, 4044}, objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        h(TextUtils.lastIndexOf("", '0', 0, 0) + 2274, new char[]{37730, 39839, 33468, 35289, 45309, 48981, 42595, 44290, 54374, 56450, 52142, 62144, 63912, 57363, 61228, 5719, 7551, 1434, 3244, 15322, 8959, 10508, 20520, 24339, 18037, 20102, 30129, 31939, 27634, 37380, 39205, 32832, 36683, 46713, 48781, 42471, 44237, 56288, 49665, 51554, 61507, 65395, 59273, 61166, 5583, 7401, 2819, 12832, 14665, 8303, 10455, 22447, 24204, 17840, 19481, 31531, 25175, 27005, 37252, 39074}, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        h(26724 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), new char[]{37683, 64327, 17400, 43533, 12980, 39636}, objArr11);
                        try {
                            Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getOffsetBefore("", 0), 18 - ((Process.getThreadPriority(0) + 20) >> 6), (char) ((-1) - ImageFormat.getBitsPerPixel(0)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                    byte b = moveToNextValue[25];
                    Object[] objArr13 = new Object[1];
                    j((byte) 37, b, b, objArr13);
                    Class<?> cls2 = Class.forName((String) objArr13[0]);
                    Object[] objArr14 = new Object[1];
                    j(moveToNextValue[35], moveToNextValue[25], moveToNextValue[7], objArr14);
                    try {
                        Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                        if (obj3 == null) {
                            Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(56 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 2, (char) ExpandableListView.getPackedPositionType(0L));
                            Object[] objArr16 = new Object[1];
                            k($$g[78], $$g[47], $$g[12], objArr16);
                            obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                        }
                        Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - TextUtils.lastIndexOf("", '0', 0, 0), 15 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) Color.alpha(0))).getMethod("getAuthRequestContext", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                            }
                            int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                            try {
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - Color.alpha(0), 14 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("PlaceComponentResult", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                                }
                                if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                    ArrayList arrayList = new ArrayList();
                                    try {
                                        Object[] objArr17 = {invoke2};
                                        Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                        if (obj6 == null) {
                                            obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - ((Process.getThreadPriority(0) + 20) >> 6), 29 - KeyEvent.getDeadChar(0, 0), (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 57995))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - Color.green(0), 15 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) Drawable.resolveOpacity(0, 0)));
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
                                                obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.resolveSizeAndState(0, 0, 0), (ViewConfiguration.getFadingEdgeLength() >> 16) + 35, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                            }
                                            Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                            try {
                                                Object[] objArr18 = {-1737365562, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                                Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                                if (obj8 == null) {
                                                    obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.alpha(0), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 17, (char) TextUtils.getOffsetAfter("", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    Object[] objArr19 = {this};
                    byte b2 = moveToNextValue[25];
                    Object[] objArr20 = new Object[1];
                    j((byte) 37, b2, b2, objArr20);
                    Class<?> cls4 = Class.forName((String) objArr20[0]);
                    Object[] objArr21 = new Object[1];
                    j(moveToNextValue[35], moveToNextValue[25], moveToNextValue[7], objArr21);
                    try {
                        Object[] objArr22 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr21[0], Object.class).invoke(null, objArr19)).intValue())};
                        Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                        if (obj9 == null) {
                            Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - View.MeasureSpec.getMode(0), 45 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) ((-1) - ImageFormat.getBitsPerPixel(0)));
                            Object[] objArr23 = new Object[1];
                            k((byte) ($$g[78] - 1), $$g[28], (byte) ($$g[78] - 1), objArr23);
                            obj9 = cls5.getMethod((String) objArr23[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                        }
                        Object[] objArr24 = (Object[]) ((Method) obj9).invoke(null, objArr22);
                        int i = ((int[]) objArr24[1])[0];
                        if (((int[]) objArr24[0])[0] != i) {
                            long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                            try {
                                Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj10 != null) {
                                    objArr2 = null;
                                } else {
                                    objArr2 = null;
                                    obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (Process.myTid() >> 22), Color.green(0) + 35, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                                }
                                Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                                try {
                                    Object[] objArr25 = {-1737365562, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj11 == null) {
                                        obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + 912, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 18, (char) KeyEvent.keyCodeFromString(""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                    }
                                    ((Method) obj11).invoke(invoke4, objArr25);
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
                    Object[] objArr26 = {this};
                    byte b3 = moveToNextValue[25];
                    Object[] objArr27 = new Object[1];
                    j((byte) 37, b3, b3, objArr27);
                    Class<?> cls6 = Class.forName((String) objArr27[0]);
                    Object[] objArr28 = new Object[1];
                    j(moveToNextValue[35], moveToNextValue[25], moveToNextValue[7], objArr28);
                    try {
                        Object[] objArr29 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr28[0], Object.class).invoke(null, objArr26)).intValue())};
                        Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                        if (obj12 == null) {
                            Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (Process.myPid() >> 22), Drawable.resolveOpacity(0, 0) + 3, (char) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 38968));
                            Object[] objArr30 = new Object[1];
                            k((byte) ($$g[78] - 1), $$g[28], (byte) ($$g[78] - 1), objArr30);
                            obj12 = cls7.getMethod((String) objArr30[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                        }
                        Object[] objArr31 = (Object[]) ((Method) obj12).invoke(null, objArr29);
                        int i2 = ((int[]) objArr31[1])[0];
                        if (((int[]) objArr31[0])[0] != i2) {
                            long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                            try {
                                Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj13 != null) {
                                    objArr3 = null;
                                } else {
                                    objArr3 = null;
                                    obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (Process.myTid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                                }
                                Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                                try {
                                    Object[] objArr32 = {-1737365562, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj14 == null) {
                                        obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 18 - ExpandableListView.getPackedPositionGroup(0L), (char) TextUtils.getTrimmedLength(""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                    }
                                    ((Method) obj14).invoke(invoke5, objArr32);
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
                    Object[] objArr33 = {this};
                    byte b4 = moveToNextValue[25];
                    Object[] objArr34 = new Object[1];
                    j((byte) 37, b4, b4, objArr34);
                    Class<?> cls8 = Class.forName((String) objArr34[0]);
                    Object[] objArr35 = new Object[1];
                    j(moveToNextValue[35], moveToNextValue[25], moveToNextValue[7], objArr35);
                    try {
                        Object[] objArr36 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr35[0], Object.class).invoke(null, objArr33)).intValue())};
                        Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                        if (obj15 == null) {
                            Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - (ViewConfiguration.getFadingEdgeLength() >> 16), 3 - ExpandableListView.getPackedPositionGroup(0L), (char) (ViewConfiguration.getScrollBarSize() >> 8));
                            Object[] objArr37 = new Object[1];
                            k($$g[8], (byte) (-$$g[40]), $$g[9], objArr37);
                            obj15 = cls9.getMethod((String) objArr37[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                        }
                        Object[] objArr38 = (Object[]) ((Method) obj15).invoke(null, objArr36);
                        int i3 = ((int[]) objArr38[1])[0];
                        if (((int[]) objArr38[0])[0] != i3) {
                            long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                            try {
                                Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj16 != null) {
                                    objArr4 = null;
                                } else {
                                    objArr4 = null;
                                    obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                                }
                                Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                                try {
                                    Object[] objArr39 = {-1737365562, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj17 == null) {
                                        obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.blue(0), AndroidCharacter.getMirror('0') - 30, (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                    }
                                    ((Method) obj17).invoke(invoke6, objArr39);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return super.getApplicationContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
        public Context getBaseContext() {
            return super.getBaseContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
        public Resources getResources() {
            return super.getResources();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle bundle) {
            Object[] objArr;
            Object[] objArr2 = new Object[1];
            h(super.getResources().getString(R.string.bank_promo_header).substring(0, 1).length() + 17656, new char[]{37739, 55197, 6812, 23955, 32897, 52158, 3768, 29163, 46253, 65464, 8862, 26089, 43220, 5056, 22263, 39416, 56553, 2032}, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            h(View.MeasureSpec.getSize(0) + 64081, new char[]{37735, 26914, 26621, 32144, 31274}, objArr3);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr4 = new Object[1];
                    h(55001 - View.combineMeasuredStates(0, 0), new char[]{37739, 17853, 16092, 6131, 51201, 41310, 39544, 19659, 9635, 7899, 63232, 43127, 33127, 31340, 11424, 1492, 65260, 55050, 34876, 24936, 23466, 3247, 58846, 56848, 46899, 26719}, objArr4);
                    Class<?> cls2 = Class.forName((String) objArr4[0]);
                    Object[] objArr5 = new Object[1];
                    h(super.getResources().getString(R.string.mybills_edit_bill_amount_label).substring(3, 4).codePointAt(0) + 27691, new char[]{37737, 65512, 19030, 54973, 8499, 36247, 6388, 27498, 63426, 16949, 44672, 14622, 33917, 4288, 25404, 53178, 23061, 42339}, objArr5);
                    baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), 35 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr6 = new Object[1];
                        h(super.getResources().getString(R.string.discard_changes_dialog_unfilled_message).substring(6, 7).length() + 23070, new char[]{37693, 51574, 9986, 40303, 64326, 20981, 36745, 58859, 17349, 47224, 5727, 19513, 43547, 171, 32393, 54509, 13003, 28468, 50450, 8998, 39170, 63458, 11715, 35829, 57734, 24126, 46100, 4651, 18524, 42733, 7369, 31406, 53459, 3779, 27430, 49422, 16176, 38216, 62376, 10627, 34789, 64923, 23080, 45065, 60988, 17482, 41646, 6366}, objArr6);
                        String str = (String) objArr6[0];
                        Object[] objArr7 = new Object[1];
                        h((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 20928, new char[]{37739, 49918, 12478, 26157, 54376, 3062, 31164, 44917, 7526, 19616, 41657, 4212, 18018, 46582, 60341, 22897, 36648, 65257, 11518, 33384, 61562, 10222, 38314, 52078, 14628, 26801, 57001, 3124, 25134, 53683, 1958, 30055, 43849, 6799, 18588, 48721, 60493, 17292, 45468, 59230, 21783, 34003, 64197, 10320, 40517, 52688, 9109, 37202, 50953, 14024, 25743, 55872, 2055, 32712, 44428, 844, 28930, 41154, 5843, 17427, 47623, 59855, 24528, 36166}, objArr7);
                        String str2 = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        h(13121 - (ViewConfiguration.getTouchSlop() >> 8), new char[]{37688, 41082, 62957, 2731, 24119, 37752, 41150, 62969, 2362, 24187, 37816, 41200, 62519, 2420, 24244, 37874, 42875, 62526, 2476, 24253, 37420, 42813, 62717, 2542, 23845, 37429, 42921, 62697, 2160, 23857, 37539, 42934, 64285, 2063, 23962, 37585, 42572, 64344, 2202, 24021, 37146, 42501, 64401, 2261, 23582, 37207, 42693, 64391, 3932, 23618, 37339, 42652, 64012, 3918, 23770, 37320, 42245, 64070, 3977, 23751, 36944, 42306, 64129, 4044}, objArr8);
                        String str3 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        h(getPackageName().length() + 2266, new char[]{37730, 39839, 33468, 35289, 45309, 48981, 42595, 44290, 54374, 56450, 52142, 62144, 63912, 57363, 61228, 5719, 7551, 1434, 3244, 15322, 8959, 10508, 20520, 24339, 18037, 20102, 30129, 31939, 27634, 37380, 39205, 32832, 36683, 46713, 48781, 42471, 44237, 56288, 49665, 51554, 61507, 65395, 59273, 61166, 5583, 7401, 2819, 12832, 14665, 8303, 10455, 22447, 24204, 17840, 19481, 31531, 25175, 27005, 37252, 39074}, objArr9);
                        String str4 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        h(super.getResources().getString(R.string.eazy_eats_restaurant_title).substring(0, 4).codePointAt(2) + 26640, new char[]{37683, 64327, 17400, 43533, 12980, 39636}, objArr10);
                        try {
                            Object[] objArr11 = {baseContext, str, str2, str3, str4, true, (String) objArr10[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getLongPressTimeout() >> 16) + 911, (ViewConfiguration.getScrollBarSize() >> 8) + 18, (char) KeyEvent.keyCodeFromString(""))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                            }
                            ((Method) obj2).invoke(invoke, objArr11);
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
            try {
                byte b = moveToNextValue[25];
                Object[] objArr12 = new Object[1];
                j((byte) 37, b, b, objArr12);
                Class<?> cls3 = Class.forName((String) objArr12[0]);
                Object[] objArr13 = new Object[1];
                j(moveToNextValue[35], moveToNextValue[25], moveToNextValue[7], objArr13);
                try {
                    Object[] objArr14 = {Integer.valueOf(((Integer) cls3.getMethod((String) objArr13[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls4 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (Process.myTid() >> 22) + 4, (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)));
                        Object[] objArr15 = new Object[1];
                        k($$g[8], (byte) (-$$g[40]), $$g[9], objArr15);
                        obj3 = cls4.getMethod((String) objArr15[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr16 = (Object[]) ((Method) obj3).invoke(null, objArr14);
                    int i = ((int[]) objArr16[1])[0];
                    if (((int[]) objArr16[0])[0] != i) {
                        long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.getMode(0), 35 - (KeyEvent.getMaxKeyCode() >> 16), (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr17 = {1203191487, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), Color.red(0) + 18, (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr17);
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
                    super.onCreate(bundle);
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
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onPause() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr = new Object[1];
                h((ViewConfiguration.getWindowTouchSlop() >> 8) + 55001, new char[]{37739, 17853, 16092, 6131, 51201, 41310, 39544, 19659, 9635, 7899, 63232, 43127, 33127, 31340, 11424, 1492, 65260, 55050, 34876, 24936, 23466, 3247, 58846, 56848, 46899, 26719}, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                try {
                    Object[] objArr2 = new Object[1];
                    j(moveToNextValue[25], (byte) (-moveToNextValue[30]), moveToNextValue[32], objArr2);
                    Class<?> cls2 = Class.forName((String) objArr2[0]);
                    Object[] objArr3 = new Object[1];
                    j((byte) (moveToNextValue[59] + 1), moveToNextValue[56], moveToNextValue[13], objArr3);
                    Object[] objArr4 = new Object[1];
                    h(((ApplicationInfo) cls2.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 27766, new char[]{37737, 65512, 19030, 54973, 8499, 36247, 6388, 27498, 63426, 16949, 44672, 14622, 33917, 4288, 25404, 53178, 23061, 42339}, objArr4);
                    baseContext = (Context) cls.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - ExpandableListView.getPackedPositionChild(0L), (ViewConfiguration.getScrollBarSize() >> 8) + 35, (char) KeyEvent.normalizeMetaState(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr5 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + 911, KeyEvent.getDeadChar(0, 0) + 18, (char) (TextUtils.indexOf((CharSequence) "", '0') + 1))).getMethod("MyBillsEntityDataFactory", Context.class);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr5);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onResume() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr = new Object[1];
                h(super.getResources().getString(R.string.privacy_setting_title).substring(0, 1).codePointAt(0) + 54921, new char[]{37739, 17853, 16092, 6131, 51201, 41310, 39544, 19659, 9635, 7899, 63232, 43127, 33127, 31340, 11424, 1492, 65260, 55050, 34876, 24936, 23466, 3247, 58846, 56848, 46899, 26719}, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                try {
                    Object[] objArr2 = new Object[1];
                    j(moveToNextValue[25], (byte) (-moveToNextValue[30]), moveToNextValue[32], objArr2);
                    Class<?> cls2 = Class.forName((String) objArr2[0]);
                    Object[] objArr3 = new Object[1];
                    j((byte) (moveToNextValue[59] + 1), moveToNextValue[56], moveToNextValue[13], objArr3);
                    Object[] objArr4 = new Object[1];
                    h(((ApplicationInfo) cls2.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 27766, new char[]{37737, 65512, 19030, 54973, 8499, 36247, 6388, 27498, 63426, 16949, 44672, 14622, 33917, 4288, 25404, 53178, 23061, 42339}, objArr4);
                    baseContext = (Context) cls.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (KeyEvent.getMaxKeyCode() >> 16), (char) TextUtils.getOffsetBefore("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr5 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.red(0), MotionEvent.axisFromString("") + 19, (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr5);
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

        private static void h(int i, char[] cArr, Object[] objArr) {
            getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
            getonboardingscenario.MyBillsEntityDataFactory = i;
            int length = cArr.length;
            long[] jArr = new long[length];
            getonboardingscenario.getAuthRequestContext = 0;
            while (getonboardingscenario.getAuthRequestContext < cArr.length) {
                jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (NetworkUserEntityData$$ExternalSyntheticLambda0 ^ 4796183387843776835L);
                getonboardingscenario.getAuthRequestContext++;
            }
            char[] cArr2 = new char[length];
            getonboardingscenario.getAuthRequestContext = 0;
            while (getonboardingscenario.getAuthRequestContext < cArr.length) {
                cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                getonboardingscenario.getAuthRequestContext++;
            }
            objArr[0] = new String(cArr2);
        }
    }

    /* loaded from: classes3.dex */
    public static class Back5 extends Back {
        public static final byte[] $$g = {TarHeader.LF_CHR, -70, 75, 72, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
        public static final int $$h = FileUtils.JPEG_MARKER_EOI;
        public static final byte[] moveToNextValue = {Ascii.ESC, -74, -29, -66, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
        public static final int lookAheadTest = 134;
        private static char[] NetworkUserEntityData$$ExternalSyntheticLambda0 = {62255, 2523, 1756, 973, 6349, 5568, 4808, 12221, 9463, 8685, 16112, 15273, 12491, 19858, 19072, 18322, 23688, 22924, 22172, 21398, 26758, 26033, 25262, 32678, 29863, 29097, 62253, 2496, 1738, 973, 6343, 5575, 4824, 12242, 9446, 8685, 16108, 15342, 12521, 19856, 19072, 18322, 23697, 22923, 62255, 2523, 1756, 973, 6349, 5568, 4808, 12221, 9465, 8686, 16046, 15319, 12536, 19870, 19095, 18334, 23693, 22934, 56887, 9432, 11257, 11970, 13778, 62329, 2518, 1678, 903, 6290, 5581, 4757, 12203, 9377, 8696, 16099, 15329, 12527, 19907, 19141, 18381, 23759, 22996, 22238, 21390, 26806, 26042, 25279, 32757, 29858, 29182, 36360, 35667, 32776, 40261, 39493, 38734, 44055, 43299, 42538, 41766, 47204, 46384, 45620, 53059, 50241, 49435, 56916, 56145, 53256, 60770, 60002, 59198, 62255, 2432, 1678, 987, 6340, 5520, 4764, 12203, 9458, 8702, 16057, 15282, 12526, 19904, 19141, 18383, 23756, 22999, 22158, 21470, 26806, 26088, 25322, 32752, 29936, 29103, 36361, 35666, 32770, 40261, 39446, 38681, 44109, 43377, 42540, 41767, 47201, 46442, 45628, 53056, 50243, 49485, 56837, 56150, 53257, 60774, 60005, 59244, 64621, 63862, 63103, 62326, 2443, 1678, 908, 6290, 5526, 4764, 12275, 9461, 8619, 16057, 15328, 12472, 62332, 2436, 1757, 989, 6299, 5534, 4766, 12199, 9390, 8613, 16056, 15286, 12475, 19906, 19140, 18380, 23711, 22912, 22236, 21387, 26848, 26043, 25277, 32752, 29937, 29099, 36361, 35599, 32860, 40263, 39443, 38728, 44057, 43377, 42538, 41767, 47200, 46398, 45626, 53067, 50254, 49435, 56913, 56147, 53330, 60769, 59957, 59193, 64568, 63868, 63019, 62250, 2432, 1672, 986, 6294, 5521, 4760, 12201, 9377, 8700, 16052, 15281, 12466, 28361, 37934, 39715, 40480, 34110, 34940, 36716, 45651, 47389, 48147, 41729, 42505, 44363, 53354, 55155, 55910, 49524, 50283, 52083, 52835, 62812, 63557, 65351, 57858, 59726, 60503, 5054, 5802, 7601, Typography.half, 1978, 2737, 12704, 13448, 15250, 16094, 9614, 10377, 12174, 21171, 23032, 23778, 17382, 18087, 19948, 28880, 30684, 31441, 25026, 25822, 27528, 28374, 37999, 39801, 40502, 34106, 34860, 36652, 45579, 47371, 47187, 17087, 19880, 18613, 21428, 24252};
        private static long getErrorConfigVersion = -8605684106971444811L;

        /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0033). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void h(int r6, short r7, int r8, java.lang.Object[] r9) {
            /*
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back5.moveToNextValue
                int r8 = 106 - r8
                int r7 = 23 - r7
                int r6 = 55 - r6
                byte[] r1 = new byte[r7]
                int r7 = r7 + (-1)
                r2 = 0
                if (r0 != 0) goto L17
                r8 = r7
                r3 = r1
                r4 = 0
                r7 = r6
                r1 = r0
                r0 = r9
                r9 = r8
                goto L33
            L17:
                r3 = 0
            L18:
                byte r4 = (byte) r8
                r1[r3] = r4
                int r6 = r6 + 1
                if (r3 != r7) goto L27
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L27:
                int r3 = r3 + 1
                r4 = r0[r6]
                r5 = r7
                r7 = r6
                r6 = r4
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r9
                r9 = r5
            L33:
                int r8 = r8 + r6
                int r8 = r8 + (-4)
                r6 = r7
                r7 = r9
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L18
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back5.h(int, short, int, java.lang.Object[]):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002c). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void k(int r6, byte r7, int r8, java.lang.Object[] r9) {
            /*
                int r7 = r7 * 2
                int r7 = 103 - r7
                int r6 = r6 + 4
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back5.$$g
                int r8 = r8 * 3
                int r8 = r8 + 21
                byte[] r1 = new byte[r8]
                int r8 = r8 + (-1)
                r2 = 0
                if (r0 != 0) goto L17
                r4 = 0
                r3 = r6
                r7 = r8
                goto L2c
            L17:
                r3 = 0
            L18:
                byte r4 = (byte) r7
                r1[r3] = r4
                int r4 = r3 + 1
                if (r3 != r8) goto L27
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L27:
                r3 = r0[r6]
                r5 = r8
                r8 = r7
                r7 = r5
            L2c:
                int r6 = r6 + 1
                int r8 = r8 + r3
                int r8 = r8 + (-7)
                r3 = r4
                r5 = r8
                r8 = r7
                r7 = r5
                goto L18
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back5.k(int, byte, int, java.lang.Object[]):void");
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            Object[] objArr;
            Object[] objArr2;
            Object[] objArr3;
            Object[] objArr4;
            super.attachBaseContext(context);
            Object[] objArr5 = new Object[1];
            j(TextUtils.indexOf((CharSequence) "", '0') + 45, (char) (KeyEvent.getMaxKeyCode() >> 16), 'B' - AndroidCharacter.getMirror('0'), objArr5);
            Class<?> cls = Class.forName((String) objArr5[0]);
            Object[] objArr6 = new Object[1];
            j(View.combineMeasuredStates(0, 0) + 62, (char) ((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 11540), 5 - (ViewConfiguration.getTapTimeout() >> 16), objArr6);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context applicationContext = context != null ? context.getApplicationContext() : context;
                if (applicationContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - Drawable.resolveOpacity(0, 0), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        j((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 66, (char) Color.alpha(0), 47 - TextUtils.lastIndexOf("", '0', 0, 0), objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        j(115 - Color.argb(0, 0, 0, 0), (char) (Color.rgb(0, 0, 0) + 16777216), 64 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        j(TextUtils.getOffsetBefore("", 0) + 179, (char) TextUtils.getOffsetBefore("", 0), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 64, objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        j(AndroidCharacter.getMirror('0') + 195, (char) (40431 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))), 60 - (ViewConfiguration.getFadingEdgeLength() >> 16), objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        j(303 - View.resolveSize(0, 0), (char) (19237 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), (Process.myPid() >> 22) + 6, objArr11);
                        try {
                            Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 912, View.resolveSize(0, 0) + 18, (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                    h(moveToNextValue[31], (byte) (-moveToNextValue[30]), moveToNextValue[25], objArr13);
                    Class<?> cls2 = Class.forName((String) objArr13[0]);
                    Object[] objArr14 = new Object[1];
                    h((byte) (moveToNextValue[34] + 1), (byte) (-moveToNextValue[30]), moveToNextValue[7], objArr14);
                    try {
                        Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                        if (obj3 == null) {
                            Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 54, (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 3, (char) Drawable.resolveOpacity(0, 0));
                            Object[] objArr16 = new Object[1];
                            k((byte) ($$g[78] - 1), $$g[12], $$g[78], objArr16);
                            obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                        }
                        Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 800, 16 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("getAuthRequestContext", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                            }
                            int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                            try {
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + 800, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 15, (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("PlaceComponentResult", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                                }
                                if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                    ArrayList arrayList = new ArrayList();
                                    try {
                                        Object[] objArr17 = {invoke2};
                                        Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                        if (obj6 == null) {
                                            obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - (KeyEvent.getMaxKeyCode() >> 16), 29 - (ViewConfiguration.getTouchSlop() >> 8), (char) (57994 - (ViewConfiguration.getEdgeSlop() >> 16)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 15 - (ViewConfiguration.getTouchSlop() >> 8), (char) ExpandableListView.getPackedPositionType(0L)));
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
                                                obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (Process.myTid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                            }
                                            Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                            try {
                                                Object[] objArr18 = {-1683049657, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                                Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                                if (obj8 == null) {
                                                    obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), TextUtils.getOffsetAfter("", 0) + 18, (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    h(moveToNextValue[31], (byte) (-moveToNextValue[30]), moveToNextValue[25], objArr19);
                    Class<?> cls4 = Class.forName((String) objArr19[0]);
                    Object[] objArr20 = new Object[1];
                    h((byte) (moveToNextValue[34] + 1), (byte) (-moveToNextValue[30]), moveToNextValue[7], objArr20);
                    try {
                        Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                        Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                        if (obj9 == null) {
                            Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 62, 46 - TextUtils.getOffsetAfter("", 0), (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))));
                            byte b = (byte) ($$g[23] - 1);
                            byte b2 = (byte) ($$g[78] - 1);
                            Object[] objArr22 = new Object[1];
                            k(b, b2, b2, objArr22);
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
                                    obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.getSize(0), Color.rgb(0, 0, 0) + 16777251, (char) ExpandableListView.getPackedPositionType(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                                }
                                Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                                try {
                                    Object[] objArr24 = {-1683049657, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj11 == null) {
                                        obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getLongPressTimeout() >> 16) + 911, 18 - View.MeasureSpec.getSize(0), (char) ('0' - AndroidCharacter.getMirror('0')))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    h(moveToNextValue[31], (byte) (-moveToNextValue[30]), moveToNextValue[25], objArr25);
                    Class<?> cls6 = Class.forName((String) objArr25[0]);
                    Object[] objArr26 = new Object[1];
                    h((byte) (moveToNextValue[34] + 1), (byte) (-moveToNextValue[30]), moveToNextValue[7], objArr26);
                    try {
                        Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                        Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                        if (obj12 == null) {
                            Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.combineMeasuredStates(0, 0) + 118, 3 - KeyEvent.keyCodeFromString(""), (char) (TextUtils.lastIndexOf("", '0') + 38969));
                            byte b3 = (byte) ($$g[23] - 1);
                            byte b4 = (byte) ($$g[78] - 1);
                            Object[] objArr28 = new Object[1];
                            k(b3, b4, b4, objArr28);
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
                                    obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, ExpandableListView.getPackedPositionGroup(0L) + 35, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                                }
                                Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                                try {
                                    Object[] objArr30 = {-1683049657, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj14 == null) {
                                        obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 912, View.getDefaultSize(0, 0) + 18, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    h(moveToNextValue[31], (byte) (-moveToNextValue[30]), moveToNextValue[25], objArr31);
                    Class<?> cls8 = Class.forName((String) objArr31[0]);
                    Object[] objArr32 = new Object[1];
                    h((byte) (moveToNextValue[34] + 1), (byte) (-moveToNextValue[30]), moveToNextValue[7], objArr32);
                    try {
                        Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                        Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                        if (obj15 == null) {
                            Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 108, 3 - (ViewConfiguration.getScrollBarSize() >> 8), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16));
                            Object[] objArr34 = new Object[1];
                            k($$g[53], $$g[9], $$g[8], objArr34);
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
                                    obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getEdgeSlop() >> 16), (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                                }
                                Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                                try {
                                    Object[] objArr36 = {-1683049657, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj17 == null) {
                                        obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 911, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 18, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return super.getApplicationContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
        public Context getBaseContext() {
            return super.getBaseContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
        public Resources getResources() {
            return super.getResources();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle bundle) {
            Object[] objArr;
            Object[] objArr2;
            Object[] objArr3 = new Object[1];
            j((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 44, (char) (super.getResources().getString(R.string.zdoc_no_document_msg).substring(1, 2).length() - 1), super.getResources().getString(R.string.mybills_payment_total).substring(0, 7).codePointAt(1) - 93, objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            j(super.getResources().getString(R.string.payment_authentication).substring(21, 22).codePointAt(0) - 48, (char) (getPackageName().codePointAt(1) + 11440), super.getResources().getString(R.string.pay_method_top_up_desc).substring(19, 20).codePointAt(0) - 111, objArr4);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr5 = new Object[1];
                    j((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16), TextUtils.indexOf("", "", 0) + 26, objArr5);
                    Class<?> cls2 = Class.forName((String) objArr5[0]);
                    int i = 27 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1));
                    try {
                        Object[] objArr6 = new Object[1];
                        h((byte) (moveToNextValue[59] + 1), moveToNextValue[25], moveToNextValue[32], objArr6);
                        Class<?> cls3 = Class.forName((String) objArr6[0]);
                        h(moveToNextValue[25], moveToNextValue[27], moveToNextValue[13], new Object[1]);
                        Object[] objArr7 = new Object[1];
                        j(i, (char) (((ApplicationInfo) cls3.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 33), super.getResources().getString(R.string.mobilepostpaid_description).substring(7, 8).length() + 17, objArr7);
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
                        if (obj != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ExpandableListView.getPackedPositionType(0L), 34 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(objArr, objArr);
                        Object[] objArr8 = new Object[1];
                        j(super.getResources().getString(R.string.installment_description).substring(7, 9).length() + 65, (char) (getPackageName().length() - 7), super.getResources().getString(R.string.receiver_name_as_on_id_card).substring(0, 3).codePointAt(0) - 30, objArr8);
                        String str = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        j(getPackageName().codePointAt(3) + 15, (char) (getPackageName().length() - 7), 64 - KeyEvent.keyCodeFromString(""), objArr9);
                        String str2 = (String) objArr9[0];
                        try {
                            Object[] objArr10 = new Object[1];
                            h((byte) (moveToNextValue[59] + 1), moveToNextValue[25], moveToNextValue[32], objArr10);
                            Class<?> cls4 = Class.forName((String) objArr10[0]);
                            Object[] objArr11 = new Object[1];
                            h(moveToNextValue[25], moveToNextValue[27], moveToNextValue[13], objArr11);
                            Object[] objArr12 = new Object[1];
                            j(((ApplicationInfo) cls4.getMethod((String) objArr11[0], null).invoke(this, null)).targetSdkVersion + 146, (char) (getPackageName().codePointAt(2) - 46), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 64, objArr12);
                            String str3 = (String) objArr12[0];
                            Object[] objArr13 = new Object[1];
                            j(getPackageName().length() + 236, (char) (getPackageName().codePointAt(4) + 40334), 60 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), objArr13);
                            String str4 = (String) objArr13[0];
                            Object[] objArr14 = new Object[1];
                            j(super.getResources().getString(R.string.twilio_login_request_expired_message).substring(20, 22).length() + 301, (char) (getPackageName().length() + 19229), super.getResources().getString(R.string.maybe_later).substring(1, 2).length() + 5, objArr14);
                            try {
                                Object[] objArr15 = {baseContext, str, str2, str3, str4, true, (String) objArr14[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", "", 0, 0), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 18, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                }
                                ((Method) obj2).invoke(invoke, objArr15);
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
                }
            }
            try {
                Object[] objArr16 = new Object[1];
                h(moveToNextValue[31], (byte) (-moveToNextValue[30]), moveToNextValue[25], objArr16);
                Class<?> cls5 = Class.forName((String) objArr16[0]);
                Object[] objArr17 = new Object[1];
                h((byte) (moveToNextValue[34] + 1), (byte) (-moveToNextValue[30]), moveToNextValue[7], objArr17);
                try {
                    Object[] objArr18 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 494, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 3, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16));
                        Object[] objArr19 = new Object[1];
                        k($$g[53], $$g[9], $$g[8], objArr19);
                        obj3 = cls6.getMethod((String) objArr19[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr20 = (Object[]) ((Method) obj3).invoke(null, objArr18);
                    int i2 = ((int[]) objArr20[1])[0];
                    if (((int[]) objArr20[0])[0] != i2) {
                        long j = ((r0 ^ i2) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - View.combineMeasuredStates(0, 0), (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr21 = {-463554580, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + 911, 18 - ExpandableListView.getPackedPositionType(0L), (char) ((-16777216) - Color.rgb(0, 0, 0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr21);
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
                    }
                    super.onCreate(bundle);
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
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onPause() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                try {
                    Object[] objArr = new Object[1];
                    h((byte) (moveToNextValue[59] + 1), moveToNextValue[25], moveToNextValue[32], objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    Object[] objArr2 = new Object[1];
                    h(moveToNextValue[25], moveToNextValue[27], moveToNextValue[13], objArr2);
                    int i = ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion - 33;
                    try {
                        Object[] objArr3 = new Object[1];
                        h((byte) (moveToNextValue[59] + 1), moveToNextValue[25], moveToNextValue[32], objArr3);
                        Class<?> cls2 = Class.forName((String) objArr3[0]);
                        h(moveToNextValue[25], moveToNextValue[27], moveToNextValue[13], new Object[1]);
                        Object[] objArr4 = new Object[1];
                        j(i, (char) (((ApplicationInfo) cls2.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 33), super.getResources().getString(R.string.empty_state_desc_first_comment).substring(14, 15).length() + 25, objArr4);
                        Class<?> cls3 = Class.forName((String) objArr4[0]);
                        Object[] objArr5 = new Object[1];
                        j(super.getResources().getString(R.string.passkey_faq_three_desc).substring(25, 26).length() + 25, (char) View.resolveSizeAndState(0, 0, 0), 18 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), objArr5);
                        baseContext = (Context) cls3.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getTouchSlop() >> 8), 35 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr6 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 17 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) KeyEvent.getDeadChar(0, 0))).getMethod("MyBillsEntityDataFactory", Context.class);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
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
            super.onPause();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onResume() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr = new Object[1];
                j(ExpandableListView.getPackedPositionGroup(0L), (char) (super.getResources().getString(R.string.feeds_empty_title).substring(5, 6).codePointAt(0) - 32), getPackageName().length() + 19, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                j(super.getResources().getString(R.string.pop_up_description_saving_limit_about_info_non_kyc).substring(91, 93).length() + 24, (char) View.resolveSizeAndState(0, 0, 0), getPackageName().codePointAt(5) - 92, objArr2);
                baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, TextUtils.getOffsetBefore("", 0) + 35, (char) Color.argb(0, 0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr3 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", "", 0), 18 - TextUtils.indexOf("", "", 0), (char) KeyEvent.normalizeMetaState(0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

        private static void j(int i, char c, int i2, Object[] objArr) {
            whenAvailable whenavailable = new whenAvailable();
            long[] jArr = new long[i2];
            whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
            while (whenavailable.BuiltInFictitiousFunctionClassFactory < i2) {
                jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (NetworkUserEntityData$$ExternalSyntheticLambda0[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ getErrorConfigVersion))) ^ c;
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

    private static void b(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        while (c.BuiltInFictitiousFunctionClassFactory < cArr.length) {
            cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
            cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
            int i2 = 58224;
            for (int i3 = 0; i3 < 16; i3++) {
                cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i2) ^ ((cArr3[0] << 4) + ((char) (scheduleImpl ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (lookAheadTest ^ 6353485791441662354L)))));
                cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i2) ^ ((cArr3[1] << 4) + ((char) (PlaceComponentResult ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (moveToNextValue ^ 6353485791441662354L)))));
                i2 -= 40503;
            }
            cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
            cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
            c.BuiltInFictitiousFunctionClassFactory += 2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }

    /* loaded from: classes3.dex */
    public static class Lite2 extends Lite {
        public static final byte[] $$g = {11, 41, -68, -59, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
        public static final int $$h = 186;
        public static final byte[] lookAheadTest = {TarHeader.LF_LINK, 16, -25, 45, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
        public static final int getErrorConfigVersion = 41;
        private static char initRecordTimeStamp = 13492;
        private static long scheduleImpl = 4360990799332652212L;
        private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 1830827303;

        /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0030). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void j(byte r6, byte r7, byte r8, java.lang.Object[] r9) {
            /*
                int r7 = r7 + 16
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite2.lookAheadTest
                int r6 = 106 - r6
                int r8 = r8 + 4
                byte[] r1 = new byte[r7]
                int r7 = r7 + (-1)
                r2 = 0
                if (r0 != 0) goto L15
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r9
                r9 = r8
                goto L30
            L15:
                r3 = 0
            L16:
                byte r4 = (byte) r6
                r1[r3] = r4
                if (r3 != r7) goto L23
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L23:
                int r3 = r3 + 1
                int r8 = r8 + 1
                r4 = r0[r8]
                r5 = r9
                r9 = r8
                r8 = r4
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r5
            L30:
                int r8 = -r8
                int r6 = r6 + r8
                int r6 = r6 + (-4)
                r8 = r9
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L16
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite2.j(byte, byte, byte, java.lang.Object[]):void");
        }

        private static void k(int i, short s, int i2, Object[] objArr) {
            byte[] bArr = $$g;
            int i3 = 103 - (s * 2);
            int i4 = i + 4;
            int i5 = 42 - (i2 * 3);
            byte[] bArr2 = new byte[i5];
            int i6 = -1;
            int i7 = i5 - 1;
            if (bArr == null) {
                i4++;
                int i8 = (i7 + i4) - 7;
                i7 = i7;
                i3 = i8;
            }
            while (true) {
                i6++;
                bArr2[i6] = (byte) i3;
                if (i6 == i7) {
                    objArr[0] = new String(bArr2, 0);
                    return;
                }
                int i9 = bArr[i4];
                i4++;
                i7 = i7;
                i3 = (i3 + i9) - 7;
            }
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            Object[] objArr;
            Object[] objArr2;
            Object[] objArr3;
            Object[] objArr4;
            super.attachBaseContext(context);
            Object[] objArr5 = new Object[1];
            h(new char[]{0, 0, 0, 0}, new char[]{46864, 14858, 29579, 1306, 63831, 14791, 42641, 41563, 41817, 7212, 27462, 24904, 36666, 8298, 57884, 5122, 45131, 13540}, (char) (23842 - (ViewConfiguration.getMaximumFlingVelocity() >> 16)), ViewConfiguration.getScrollDefaultDelay() >> 16, new char[]{22256, 50158, 8706, 15709}, objArr5);
            Class<?> cls = Class.forName((String) objArr5[0]);
            Object[] objArr6 = new Object[1];
            h(new char[]{0, 0, 0, 0}, new char[]{25983, 10940, 9646, 15181, 44522}, (char) (54554 - (ViewConfiguration.getDoubleTapTimeout() >> 16)), (-1739351996) - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), new char[]{17600, 21400, 6808, 43733}, objArr6);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context applicationContext = context != null ? context.getApplicationContext() : context;
                if (applicationContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 35, (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        h(new char[]{0, 0, 0, 0}, new char[]{27945, 26586, 35097, 55515, 16071, 50251, 9733, 970, 12586, 62129, 27909, 45476, 30512, 34665, 57354, 16032, 18914, 39046, 37475, 31176, 33557, 37084, 3286, 64348, 10271, 47067, 16527, 60892, 46590, 32158, 12654, 49653, 58923, 62076, 40131, 54543, 47298, 1193, 55815, 65519, 62391, 58238, 55099, 8053, 12568, 63527, 31353, 30715}, (char) View.MeasureSpec.getSize(0), ViewConfiguration.getFadingEdgeLength() >> 16, new char[]{34523, 44502, 303, 1629}, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        h(new char[]{0, 0, 0, 0}, new char[]{29357, 19017, 41127, 42151, 6310, 5693, 12146, 60283, 17190, 32449, 42442, 43598, 23775, 22798, 929, 20325, 12577, 19276, 61511, 41365, 11160, 23998, 43779, 50571, 33061, 5124, 48687, 32175, 41632, 46653, 32265, 22908, 46481, 41894, 44371, 57213, 18532, 59725, 15326, 7564, 61217, 21542, '\\', 31816, 1336, 9490, 53368, 5507, 9220, 28467, 44384, 8237, 10532, 43878, 14896, 32609, 3514, 3813, 21379, 18199, 51881, 38166, 21486, 26561}, (char) (TextUtils.lastIndexOf("", '0') + 1), TextUtils.getOffsetBefore("", 0), new char[]{6685, 59620, 36967, 43175}, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        h(new char[]{0, 0, 0, 0}, new char[]{39947, 54873, 4690, 56498, 52376, 33752, 8852, 24028, 13000, 5632, 57057, 41030, 6964, 60684, 49080, 19159, 35985, 51998, 24314, 35294, 59398, 22521, 37047, 32772, 41209, 56391, 6158, 38208, 25430, 23201, 8837, 31685, 41004, 59298, 3552, 54326, 12951, 29621, 42332, 5232, 56814, 45718, 32439, 15229, 55946, 23276, 63918, 24983, 62589, 26310, 34874, 1013, 12555, 54344, 20984, 55879, 42428, 7198, 26421, 27798, 44889, 64447, 28866, 28029}, (char) Color.argb(0, 0, 0, 0), View.resolveSize(0, 0), new char[]{56114, 46023, 8408, 13896}, objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        h(new char[]{0, 0, 0, 0}, new char[]{5506, 39624, 1637, 63334, 48376, 38714, 9006, 29386, 56447, 44759, 63033, 15033, 55911, 34788, 24990, 63745, 45597, 19418, 8847, 59388, 9348, 32976, 43104, 53993, 30220, 51998, 25194, 9206, 11153, 63501, 19513, 65297, 15475, 34467, 44580, 50141, 22045, 7812, 44078, 55006, 19106, 37352, 27619, 50947, 4273, 8274, 22560, 23810, 24124, 44021, 5677, 41566, 19053, 8433, 11734, 25126, 24741, 40035, 18367, 50567}, (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1), ViewConfiguration.getPressedStateDuration() >> 16, new char[]{46232, 55346, 32202, 53850}, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        h(new char[]{0, 0, 0, 0}, new char[]{31669, 11123, 9805, 11758, 65094, 33939}, (char) (TextUtils.indexOf("", "", 0, 0) + 11149), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), new char[]{2609, 37643, 36289, 13099}, objArr11);
                        try {
                            Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getCapsMode("", 0, 0), (ViewConfiguration.getJumpTapTimeout() >> 16) + 18, (char) Color.red(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                    byte b = lookAheadTest[25];
                    byte b2 = b;
                    Object[] objArr13 = new Object[1];
                    j(b, b2, (byte) (b2 | 36), objArr13);
                    Class<?> cls2 = Class.forName((String) objArr13[0]);
                    byte b3 = lookAheadTest[9];
                    byte b4 = lookAheadTest[25];
                    Object[] objArr14 = new Object[1];
                    j(b3, b4, (byte) (b4 | Ascii.NAK), objArr14);
                    try {
                        Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                        if (obj3 == null) {
                            Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + 56, (ViewConfiguration.getTapTimeout() >> 16) + 3, (char) Color.green(0));
                            Object[] objArr16 = new Object[1];
                            k((byte) ($$g[78] - 1), $$g[12], $$g[31], objArr16);
                            obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                        }
                        Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - Color.green(0), 15 - Color.red(0), (char) KeyEvent.keyCodeFromString(""))).getMethod("getAuthRequestContext", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                            }
                            int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                            try {
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 16 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("PlaceComponentResult", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                                }
                                if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                    ArrayList arrayList = new ArrayList();
                                    try {
                                        Object[] objArr17 = {invoke2};
                                        Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                        if (obj6 == null) {
                                            obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myPid() >> 22) + 815, KeyEvent.getDeadChar(0, 0) + 29, (char) (TextUtils.getOffsetBefore("", 0) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (Process.myTid() >> 22), TextUtils.getOffsetBefore("", 0) + 15, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))));
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                        }
                                        arrayList.add(((Method) obj6).invoke(null, objArr17));
                                        long j = ((r10 ^ intValue2) & 4294967295L) | 60129542144L;
                                        try {
                                            Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                            if (obj7 != null) {
                                                objArr4 = null;
                                            } else {
                                                objArr4 = null;
                                                obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + PDF417Common.NUMBER_OF_CODEWORDS, (Process.myTid() >> 22) + 35, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                            }
                                            Object invoke3 = ((Method) obj7).invoke(objArr4, objArr4);
                                            try {
                                                Object[] objArr18 = {-1682177161, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                                Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                                if (obj8 == null) {
                                                    obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778127, 18 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) TextUtils.indexOf("", "", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    Object[] objArr19 = {this};
                    byte b5 = lookAheadTest[25];
                    byte b6 = b5;
                    Object[] objArr20 = new Object[1];
                    j(b5, b6, (byte) (b6 | 36), objArr20);
                    Class<?> cls4 = Class.forName((String) objArr20[0]);
                    byte b7 = lookAheadTest[9];
                    byte b8 = lookAheadTest[25];
                    Object[] objArr21 = new Object[1];
                    j(b7, b8, (byte) (b8 | Ascii.NAK), objArr21);
                    try {
                        Object[] objArr22 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr21[0], Object.class).invoke(null, objArr19)).intValue())};
                        Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                        if (obj9 == null) {
                            Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (KeyEvent.getMaxKeyCode() >> 16), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 46, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16));
                            Object[] objArr23 = new Object[1];
                            k((byte) ($$g[23] - 1), (byte) ($$g[78] - 1), $$g[8], objArr23);
                            obj9 = cls5.getMethod((String) objArr23[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                        }
                        Object[] objArr24 = (Object[]) ((Method) obj9).invoke(null, objArr22);
                        int i = ((int[]) objArr24[1])[0];
                        if (((int[]) objArr24[0])[0] != i) {
                            long j2 = ((r2 ^ i) & 4294967295L) | 17179869184L;
                            try {
                                Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj10 != null) {
                                    objArr3 = null;
                                } else {
                                    objArr3 = null;
                                    obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (-16777181) - Color.rgb(0, 0, 0), (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                                }
                                Object invoke4 = ((Method) obj10).invoke(objArr3, objArr3);
                                try {
                                    Object[] objArr25 = {-1682177161, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj11 == null) {
                                        obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0, 0) + 912, (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 18, (char) TextUtils.indexOf("", "", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                    }
                                    ((Method) obj11).invoke(invoke4, objArr25);
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
                    Object[] objArr26 = {this};
                    byte b9 = lookAheadTest[25];
                    byte b10 = b9;
                    Object[] objArr27 = new Object[1];
                    j(b9, b10, (byte) (b10 | 36), objArr27);
                    Class<?> cls6 = Class.forName((String) objArr27[0]);
                    byte b11 = lookAheadTest[9];
                    byte b12 = lookAheadTest[25];
                    Object[] objArr28 = new Object[1];
                    j(b11, b12, (byte) (b12 | Ascii.NAK), objArr28);
                    try {
                        Object[] objArr29 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr28[0], Object.class).invoke(null, objArr26)).intValue())};
                        Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                        if (obj12 == null) {
                            Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (ViewConfiguration.getTapTimeout() >> 16), 2 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (38968 - TextUtils.getTrimmedLength("")));
                            Object[] objArr30 = new Object[1];
                            k((byte) ($$g[23] - 1), (byte) ($$g[78] - 1), $$g[8], objArr30);
                            obj12 = cls7.getMethod((String) objArr30[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                        }
                        Object[] objArr31 = (Object[]) ((Method) obj12).invoke(null, objArr29);
                        int i2 = ((int[]) objArr31[1])[0];
                        if (((int[]) objArr31[0])[0] != i2) {
                            long j3 = ((r2 ^ i2) & 4294967295L) | 8589934592L;
                            try {
                                Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj13 != null) {
                                    objArr2 = null;
                                } else {
                                    objArr2 = null;
                                    obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                                }
                                Object invoke5 = ((Method) obj13).invoke(objArr2, objArr2);
                                try {
                                    Object[] objArr32 = {-1682177161, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj14 == null) {
                                        obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getLongPressTimeout() >> 16), 18 - Gravity.getAbsoluteGravity(0, 0), (char) (Process.myPid() >> 22))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                    }
                                    ((Method) obj14).invoke(invoke5, objArr32);
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
                    Object[] objArr33 = {this};
                    byte b13 = lookAheadTest[25];
                    byte b14 = b13;
                    Object[] objArr34 = new Object[1];
                    j(b13, b14, (byte) (b14 | 36), objArr34);
                    Class<?> cls8 = Class.forName((String) objArr34[0]);
                    byte b15 = lookAheadTest[9];
                    byte b16 = lookAheadTest[25];
                    Object[] objArr35 = new Object[1];
                    j(b15, b16, (byte) (b16 | Ascii.NAK), objArr35);
                    try {
                        Object[] objArr36 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr35[0], Object.class).invoke(null, objArr33)).intValue())};
                        Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                        if (obj15 == null) {
                            Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + 107, View.MeasureSpec.makeMeasureSpec(0, 0) + 3, (char) Drawable.resolveOpacity(0, 0));
                            Object[] objArr37 = new Object[1];
                            k($$g[53], $$g[9], (byte) ($$g[78] - 1), objArr37);
                            obj15 = cls9.getMethod((String) objArr37[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                        }
                        Object[] objArr38 = (Object[]) ((Method) obj15).invoke(null, objArr36);
                        int i3 = ((int[]) objArr38[1])[0];
                        if (((int[]) objArr38[0])[0] != i3) {
                            long j4 = ((r2 ^ i3) & 4294967295L) | 4294967296L;
                            try {
                                Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj16 != null) {
                                    objArr = null;
                                } else {
                                    objArr = null;
                                    obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (ViewConfiguration.getTapTimeout() >> 16) + 35, (char) (ExpandableListView.getPackedPositionChild(0L) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                                }
                                Object invoke6 = ((Method) obj16).invoke(objArr, objArr);
                                try {
                                    Object[] objArr39 = {-1682177161, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj17 == null) {
                                        obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getJumpTapTimeout() >> 16), View.resolveSizeAndState(0, 0, 0) + 18, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                    }
                                    ((Method) obj17).invoke(invoke6, objArr39);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return super.getApplicationContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
        public Context getBaseContext() {
            return super.getBaseContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
        public Resources getResources() {
            return super.getResources();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle bundle) {
            Object[] objArr;
            char[] cArr = {0, 0, 0, 0};
            char[] cArr2 = {46864, 14858, 29579, 1306, 63831, 14791, 42641, 41563, 41817, 7212, 27462, 24904, 36666, 8298, 57884, 5122, 45131, 13540};
            try {
                Object[] objArr2 = new Object[1];
                j((byte) (-lookAheadTest[32]), lookAheadTest[30], lookAheadTest[7], objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                j(lookAheadTest[48], lookAheadTest[8], (byte) (-lookAheadTest[59]), objArr3);
                Object[] objArr4 = new Object[1];
                h(cArr, cArr2, (char) (((ApplicationInfo) cls.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 23809), KeyEvent.getDeadChar(0, 0), new char[]{22256, 50158, 8706, 15709}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                h(new char[]{0, 0, 0, 0}, new char[]{25983, 10940, 9646, 15181, 44522}, (char) (super.getResources().getString(R.string.no_recent_bank_message).substring(2, 4).codePointAt(1) + 54453), super.getResources().getString(R.string.otp_limited_dialog_title).substring(6, 7).codePointAt(0) - 1739352093, new char[]{17600, 21400, 6808, 43733}, objArr5);
                int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                if (intValue < 99000 || intValue > 99999) {
                    Context baseContext = getBaseContext();
                    if (baseContext == null) {
                        Object[] objArr6 = new Object[1];
                        h(new char[]{0, 0, 0, 0}, new char[]{21218, 38736, 51522, 28042, 50537, 56235, 54660, 57472, 32446, 52317, 24164, 52600, 43484, 18192, 20383, 45345, 45112, 9817, 28928, 17188, 12280, 1527, 10505, 50899, 22773, 12229}, (char) (super.getResources().getString(R.string.upload_files_bridge_bottomsheet_title).substring(9, 10).codePointAt(0) + 3669), ViewConfiguration.getDoubleTapTimeout() >> 16, new char[]{30997, 63623, 52891, 18958}, objArr6);
                        Class<?> cls3 = Class.forName((String) objArr6[0]);
                        char[] cArr3 = {0, 0, 0, 0};
                        char[] cArr4 = {41954, 35121, 51397, 4102, 12169, 28081, 20420, 59137, 6602, 31361, 5607, 64245, 38466, 10394, 13285, 46341, 31310, 41394};
                        try {
                            Object[] objArr7 = new Object[1];
                            j((byte) (-lookAheadTest[32]), lookAheadTest[30], lookAheadTest[7], objArr7);
                            Class<?> cls4 = Class.forName((String) objArr7[0]);
                            Object[] objArr8 = new Object[1];
                            j(lookAheadTest[48], lookAheadTest[8], (byte) (-lookAheadTest[59]), objArr8);
                            char c = (char) (((ApplicationInfo) cls4.getMethod((String) objArr8[0], null).invoke(this, null)).targetSdkVersion + 32807);
                            try {
                                Object[] objArr9 = new Object[1];
                                j((byte) (-lookAheadTest[32]), lookAheadTest[30], lookAheadTest[7], objArr9);
                                Class<?> cls5 = Class.forName((String) objArr9[0]);
                                j(lookAheadTest[48], lookAheadTest[8], (byte) (-lookAheadTest[59]), new Object[1]);
                                Object[] objArr10 = new Object[1];
                                h(cArr3, cArr4, c, ((ApplicationInfo) cls5.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{6056, 53588, 18549, 1408}, objArr10);
                                baseContext = (Context) cls3.getMethod((String) objArr10[0], new Class[0]).invoke(null, null);
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
                                obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, KeyEvent.getDeadChar(0, 0) + 35, (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                            }
                            Object invoke = ((Method) obj).invoke(null, null);
                            char[] cArr5 = {0, 0, 0, 0};
                            char[] cArr6 = {27945, 26586, 35097, 55515, 16071, 50251, 9733, 970, 12586, 62129, 27909, 45476, 30512, 34665, 57354, 16032, 18914, 39046, 37475, 31176, 33557, 37084, 3286, 64348, 10271, 47067, 16527, 60892, 46590, 32158, 12654, 49653, 58923, 62076, 40131, 54543, 47298, 1193, 55815, 65519, 62391, 58238, 55099, 8053, 12568, 63527, 31353, 30715};
                            try {
                                Object[] objArr11 = new Object[1];
                                j((byte) (-lookAheadTest[32]), lookAheadTest[30], lookAheadTest[7], objArr11);
                                Class<?> cls6 = Class.forName((String) objArr11[0]);
                                j(lookAheadTest[48], lookAheadTest[8], (byte) (-lookAheadTest[59]), new Object[1]);
                                Object[] objArr12 = new Object[1];
                                h(cArr5, cArr6, (char) (((ApplicationInfo) cls6.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 33), getPackageName().codePointAt(5) - 110, new char[]{34523, 44502, 303, 1629}, objArr12);
                                String str = (String) objArr12[0];
                                char[] cArr7 = {0, 0, 0, 0};
                                char[] cArr8 = {29357, 19017, 41127, 42151, 6310, 5693, 12146, 60283, 17190, 32449, 42442, 43598, 23775, 22798, 929, 20325, 12577, 19276, 61511, 41365, 11160, 23998, 43779, 50571, 33061, 5124, 48687, 32175, 41632, 46653, 32265, 22908, 46481, 41894, 44371, 57213, 18532, 59725, 15326, 7564, 61217, 21542, '\\', 31816, 1336, 9490, 53368, 5507, 9220, 28467, 44384, 8237, 10532, 43878, 14896, 32609, 3514, 3813, 21379, 18199, 51881, 38166, 21486, 26561};
                                try {
                                    Object[] objArr13 = new Object[1];
                                    j((byte) (-lookAheadTest[32]), lookAheadTest[30], lookAheadTest[7], objArr13);
                                    Class<?> cls7 = Class.forName((String) objArr13[0]);
                                    j(lookAheadTest[48], lookAheadTest[8], (byte) (-lookAheadTest[59]), new Object[1]);
                                    Object[] objArr14 = new Object[1];
                                    h(cArr7, cArr8, (char) (((ApplicationInfo) cls7.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 33), getPackageName().codePointAt(2) - 46, new char[]{6685, 59620, 36967, 43175}, objArr14);
                                    String str2 = (String) objArr14[0];
                                    Object[] objArr15 = new Object[1];
                                    h(new char[]{0, 0, 0, 0}, new char[]{39947, 54873, 4690, 56498, 52376, 33752, 8852, 24028, 13000, 5632, 57057, 41030, 6964, 60684, 49080, 19159, 35985, 51998, 24314, 35294, 59398, 22521, 37047, 32772, 41209, 56391, 6158, 38208, 25430, 23201, 8837, 31685, 41004, 59298, 3552, 54326, 12951, 29621, 42332, 5232, 56814, 45718, 32439, 15229, 55946, 23276, 63918, 24983, 62589, 26310, 34874, 1013, 12555, 54344, 20984, 55879, 42428, 7198, 26421, 27798, 44889, 64447, 28866, 28029}, (char) Color.blue(0), getPackageName().codePointAt(1) - 100, new char[]{56114, 46023, 8408, 13896}, objArr15);
                                    String str3 = (String) objArr15[0];
                                    char[] cArr9 = {0, 0, 0, 0};
                                    char[] cArr10 = {5506, 39624, 1637, 63334, 48376, 38714, 9006, 29386, 56447, 44759, 63033, 15033, 55911, 34788, 24990, 63745, 45597, 19418, 8847, 59388, 9348, 32976, 43104, 53993, 30220, 51998, 25194, 9206, 11153, 63501, 19513, 65297, 15475, 34467, 44580, 50141, 22045, 7812, 44078, 55006, 19106, 37352, 27619, 50947, 4273, 8274, 22560, 23810, 24124, 44021, 5677, 41566, 19053, 8433, 11734, 25126, 24741, 40035, 18367, 50567};
                                    char length = (char) (super.getResources().getString(R.string.express_pay).substring(9, 10).length() - 1);
                                    try {
                                        Object[] objArr16 = new Object[1];
                                        j((byte) (-lookAheadTest[32]), lookAheadTest[30], lookAheadTest[7], objArr16);
                                        Class<?> cls8 = Class.forName((String) objArr16[0]);
                                        j(lookAheadTest[48], lookAheadTest[8], (byte) (-lookAheadTest[59]), new Object[1]);
                                        Object[] objArr17 = new Object[1];
                                        h(cArr9, cArr10, length, ((ApplicationInfo) cls8.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{46232, 55346, 32202, 53850}, objArr17);
                                        String str4 = (String) objArr17[0];
                                        Object[] objArr18 = new Object[1];
                                        h(new char[]{0, 0, 0, 0}, new char[]{31669, 11123, 9805, 11758, 65094, 33939}, (char) (super.getResources().getString(R.string.my_card_def_subtitle).substring(0, 2).length() + 11147), super.getResources().getString(R.string.feed_onboarding_activate).substring(8, 13).length() - 5, new char[]{2609, 37643, 36289, 13099}, objArr18);
                                        try {
                                            Object[] objArr19 = {baseContext, str, str2, str3, str4, true, (String) objArr18[0], 995651014};
                                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                            if (obj2 == null) {
                                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + 911, ExpandableListView.getPackedPositionGroup(0L) + 18, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                            }
                                            ((Method) obj2).invoke(invoke, objArr19);
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
                    }
                }
                try {
                    byte b = lookAheadTest[25];
                    byte b2 = b;
                    Object[] objArr20 = new Object[1];
                    j(b, b2, (byte) (b2 | 36), objArr20);
                    Class<?> cls9 = Class.forName((String) objArr20[0]);
                    byte b3 = lookAheadTest[9];
                    byte b4 = lookAheadTest[25];
                    Object[] objArr21 = new Object[1];
                    j(b3, b4, (byte) (b4 | Ascii.NAK), objArr21);
                    try {
                        Object[] objArr22 = {Integer.valueOf(((Integer) cls9.getMethod((String) objArr21[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                        if (obj3 == null) {
                            Class cls10 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + 494, 3 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1));
                            Object[] objArr23 = new Object[1];
                            k($$g[53], $$g[9], (byte) ($$g[78] - 1), objArr23);
                            obj3 = cls10.getMethod((String) objArr23[0], Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                        }
                        Object[] objArr24 = (Object[]) ((Method) obj3).invoke(null, objArr22);
                        int i = ((int[]) objArr24[1])[0];
                        if (((int[]) objArr24[0])[0] != i) {
                            long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                            try {
                                Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj4 != null) {
                                    objArr = null;
                                } else {
                                    objArr = null;
                                    obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 34, (char) TextUtils.getCapsMode("", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                }
                                Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                                try {
                                    Object[] objArr25 = {-1123739812, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj5 == null) {
                                        obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + 911, TextUtils.lastIndexOf("", '0') + 19, (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                    }
                                    ((Method) obj5).invoke(invoke2, objArr25);
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
                        super.onCreate(bundle);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onPause() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr = new Object[1];
                h(new char[]{0, 0, 0, 0}, new char[]{21218, 38736, 51522, 28042, 50537, 56235, 54660, 57472, 32446, 52317, 24164, 52600, 43484, 18192, 20383, 45345, 45112, 9817, 28928, 17188, 12280, 1527, 10505, 50899, 22773, 12229}, (char) (getPackageName().codePointAt(3) + 3690), getPackageName().codePointAt(3) - 100, new char[]{30997, 63623, 52891, 18958}, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                h(new char[]{0, 0, 0, 0}, new char[]{41954, 35121, 51397, 4102, 12169, 28081, 20420, 59137, 6602, 31361, 5607, 64245, 38466, 10394, 13285, 46341, 31310, 41394}, (char) (super.getResources().getString(R.string.promo_applied_title).substring(0, 6).length() + 32834), super.getResources().getString(R.string.deals_express_voucher_context_offline_fnb).substring(6, 7).codePointAt(0) - 114, new char[]{6056, 53588, 18549, 1408}, objArr2);
                baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 34, (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr3 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + 911, (-16777198) - Color.rgb(0, 0, 0), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Context.class);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onResume() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                char[] cArr = {0, 0, 0, 0};
                char[] cArr2 = {21218, 38736, 51522, 28042, 50537, 56235, 54660, 57472, 32446, 52317, 24164, 52600, 43484, 18192, 20383, 45345, 45112, 9817, 28928, 17188, 12280, 1527, 10505, 50899, 22773, 12229};
                try {
                    Object[] objArr = new Object[1];
                    j((byte) (-lookAheadTest[32]), lookAheadTest[30], lookAheadTest[7], objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    Object[] objArr2 = new Object[1];
                    j(lookAheadTest[48], lookAheadTest[8], (byte) (-lookAheadTest[59]), objArr2);
                    Object[] objArr3 = new Object[1];
                    h(cArr, cArr2, (char) (((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion + 3757), getPackageName().length() - 7, new char[]{30997, 63623, 52891, 18958}, objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    Object[] objArr4 = new Object[1];
                    h(new char[]{0, 0, 0, 0}, new char[]{41954, 35121, 51397, 4102, 12169, 28081, 20420, 59137, 6602, 31361, 5607, 64245, 38466, 10394, 13285, 46341, 31310, 41394}, (char) (super.getResources().getString(R.string.error_empty_first_name).substring(12, 13).length() + 32839), Process.myPid() >> 22, new char[]{6056, 53588, 18549, 1408}, objArr4);
                    baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatDelay() >> 16), 35 - View.MeasureSpec.getMode(0), (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr5 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 910, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 18, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr5);
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

        private static void h(char[] cArr, char[] cArr2, char c, int i, char[] cArr3, Object[] objArr) {
            E e = new E();
            int length = cArr3.length;
            char[] cArr4 = new char[length];
            int length2 = cArr.length;
            char[] cArr5 = new char[length2];
            System.arraycopy(cArr3, 0, cArr4, 0, length);
            System.arraycopy(cArr, 0, cArr5, 0, length2);
            cArr4[0] = (char) (cArr4[0] ^ c);
            cArr5[2] = (char) (cArr5[2] + ((char) i));
            int length3 = cArr2.length;
            char[] cArr6 = new char[length3];
            e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
            while (e.KClassImpl$Data$declaredNonStaticMembers$2 < length3) {
                int i2 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
                int i3 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
                e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i2]) % 65535);
                cArr5[i3] = (char) (((cArr4[i3] * 32718) + cArr5[i2]) / 65535);
                cArr4[i3] = e.MyBillsEntityDataFactory;
                cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i3] ^ cArr2[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (scheduleImpl ^ 4360990799332652212L)) ^ ((int) (NetworkUserEntityData$$ExternalSyntheticLambda0 ^ 4360990799332652212L))) ^ ((char) (initRecordTimeStamp ^ 4360990799332652212L)));
                e.KClassImpl$Data$declaredNonStaticMembers$2++;
            }
            objArr[0] = new String(cArr6);
        }
    }

    /* loaded from: classes3.dex */
    public static class Back2 extends Back {
        public static final byte[] $$g = {10, -99, -17, -84, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
        public static final int $$h = 23;
        public static final byte[] lookAheadTest = {116, 39, -17, SignedBytes.MAX_POWER_OF_TWO, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
        public static final int getErrorConfigVersion = 174;
        private static char[] NetworkUserEntityData$$ExternalSyntheticLambda0 = {35502, 35577, 35575, 35573, 35566, 35570, 35576, 35543, 35545, 35574, 35566, 35537, 35497, 35532, 35573, 35568, 35569, 35569, 35568, 35560, 35576, 35520, 35571, 35573, 35581, 35580, 35536, 35333, 35389, 35385, 35387, 35385, 35391, 35387, 35378, 35381, 35386, 35388, 35380, 35341, 35343, 35383, 35385, 35389, 35498, 35570, 35566, 35573, 35575, 35577, 35572, 35565, 35570, 35578, 35575, 35566, 35583, 35489, 35534, 35567, 35536, 35543, 35528, 35332, 35340, 35335, 35333, 35535, 35531, 35526, 35354, 35358, 35357, 35535, 35357, 35529, 35532, 35357, 35531, 35356, 35356, 35357, 35358, 35531, 35534, 35534, 35531, 35534, 35535, 35354, 35355, 35356, 35354, 35528, 35529, 35526, 35357, 35537, 35529, 35531, 35356, 35528, 35354, 35531, 35532, 35359, 35531, 35533, 35355, 35528, 35537, 35529, 35526, 35355, 35526, 35521, 35400, 35399, 35361, 35402, 35443, 35403, 35365, 35365, 35365, 35360, 35421, 35418, 35421, 35422, 35360, 35422, 35361, 35361, 35398, 35403, 35400, 35403, 35363, 35361, 35362, 35402, 35440, 35398, 35423, 35401, 35440, 35403, 35363, 35400, 35399, 35399, 35396, 35398, 35401, 35361, 35361, 35360, 35403, 35403, 35400, 35401, 35363, 35360, 35363, 35362, 35403, 35401, 35420, 35399, 35440, 35399, 35361, 35361, 35396, 35438, 35398, 35422, 35400, 35557, 35432, 35726, 35766, 35724, 35427, 35431, 35430, 35429, 35427, 35427, 35431, 35432, 35433, 35432, 35430, 35727, 35766, 35727, 35727, 35726, 35729, 35768, 35729, 35428, 35725, 35722, 35427, 35722, 35765, 35725, 35724, 35724, 35724, 35726, 35428, 35724, 35727, 35429, 35426, 35427, 35722, 35726, 35433, 35429, 35431, 35731, 35768, 35767, 35722, 35725, 35767, 35726, 35432, 35726, 35724, 35429, 35429, 35426, 35426, 35725, 35724, 35428, 35426, 35565, 35438, 35437, 35409, 35400, 35430, 35441, 35449, 35438, 35441, 35446, 35438, 35436, 35437, 35400, 35410, 35442, 35442, 35449, 35408, 35370, 35367, 35397, 35432, 35433, 35431, 35437, 35436, 35430, 35432, 35440, 35436, 35436, 35409, 35371, 35399, 35401, 35400, 35430, 35439, 35445, 35441, 35438, 35407, 35407, 35439, 35443, 35411, 35405, 35437, 35440, 35411, 35408, 35438, 35440, 35438, 35430, 35433, 35438, 35438, 35491, 35562, 35564, 35564, 35567, 35564};

        /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0036). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void j(short r6, short r7, int r8, java.lang.Object[] r9) {
            /*
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back2.lookAheadTest
                int r7 = r7 * 2
                int r7 = 16 - r7
                int r6 = r6 * 15
                int r6 = r6 + 4
                int r8 = r8 + 105
                byte[] r1 = new byte[r7]
                int r7 = r7 + (-1)
                r2 = 0
                if (r0 != 0) goto L1b
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r9
                r9 = r8
                r8 = r7
                r7 = r6
                goto L36
            L1b:
                r3 = 0
            L1c:
                byte r4 = (byte) r8
                r1[r3] = r4
                if (r3 != r7) goto L29
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L29:
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
            L36:
                int r6 = -r6
                int r9 = r9 + r6
                int r6 = r7 + 1
                int r7 = r9 + 2
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                r5 = r8
                r8 = r7
                r7 = r5
                goto L1c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back2.j(short, short, int, java.lang.Object[]):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0036). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void k(byte r6, byte r7, short r8, java.lang.Object[] r9) {
            /*
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back2.$$g
                int r8 = r8 * 2
                int r8 = r8 + 75
                int r6 = r6 * 3
                int r6 = 42 - r6
                int r7 = r7 + 4
                byte[] r1 = new byte[r6]
                int r6 = r6 + (-1)
                r2 = 0
                if (r0 != 0) goto L1b
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r9
                r9 = r8
                r8 = r7
                r7 = r6
                goto L36
            L1b:
                r3 = 0
            L1c:
                byte r4 = (byte) r8
                r1[r3] = r4
                if (r3 != r6) goto L29
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L29:
                int r3 = r3 + 1
                r4 = r0[r7]
                r5 = r7
                r7 = r6
                r6 = r4
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r9
                r9 = r8
                r8 = r5
            L36:
                int r6 = -r6
                int r9 = r9 + r6
                int r6 = r9 + (-7)
                int r8 = r8 + 1
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                r5 = r8
                r8 = r6
                r6 = r7
                r7 = r5
                goto L1c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back2.k(byte, byte, short, java.lang.Object[]):void");
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            Object[] objArr;
            Object[] objArr2;
            Object[] objArr3;
            Object[] objArr4;
            super.attachBaseContext(context);
            Object[] objArr5 = new Object[1];
            h(new int[]{44, 18, 0, 6}, new byte[]{1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0}, true, objArr5);
            Class<?> cls = Class.forName((String) objArr5[0]);
            Object[] objArr6 = new Object[1];
            h(new int[]{62, 5, 51, 4}, new byte[]{0, 0, 0, 1, 1}, false, objArr6);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context applicationContext = context != null ? context.getApplicationContext() : context;
                if (applicationContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, Color.argb(0, 0, 0, 0) + 35, (char) Drawable.resolveOpacity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        h(new int[]{67, 48, 31, 35}, null, true, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        h(new int[]{115, 64, 139, 0}, new byte[]{0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0}, true, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        h(new int[]{179, 64, 197, 0}, new byte[]{1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0}, false, objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        h(new int[]{243, 60, 133, 27}, new byte[]{0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0}, true, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        h(new int[]{303, 6, 65, 6}, new byte[]{0, 1, 0, 0, 0, 1}, false, objArr11);
                        try {
                            Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.getDeadChar(0, 0), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 18, (char) TextUtils.getTrimmedLength(""))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                    byte b = lookAheadTest[5];
                    Object[] objArr13 = new Object[1];
                    j(b, (byte) (b - 1), lookAheadTest[5], objArr13);
                    Class<?> cls2 = Class.forName((String) objArr13[0]);
                    byte b2 = (byte) (lookAheadTest[5] - 1);
                    byte b3 = b2;
                    Object[] objArr14 = new Object[1];
                    j(b2, b3, b3, objArr14);
                    try {
                        Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                        if (obj3 == null) {
                            Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - ExpandableListView.getPackedPositionGroup(0L), TextUtils.lastIndexOf("", '0', 0, 0) + 4, (char) KeyEvent.normalizeMetaState(0));
                            Object[] objArr16 = new Object[1];
                            k($$g[68], (byte) ($$g[47] - 1), $$g[47], objArr16);
                            obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                        }
                        Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - Color.red(0), (Process.myTid() >> 22) + 15, (char) Color.alpha(0))).getMethod("getAuthRequestContext", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                            }
                            int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                            try {
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), TextUtils.getTrimmedLength("") + 15, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("PlaceComponentResult", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                                }
                                if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                    ArrayList arrayList = new ArrayList();
                                    try {
                                        Object[] objArr17 = {invoke2};
                                        Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                        if (obj6 == null) {
                                            obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 814, MotionEvent.axisFromString("") + 30, (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 57993))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + 800, (KeyEvent.getMaxKeyCode() >> 16) + 15, (char) (Color.rgb(0, 0, 0) + 16777216)));
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
                                                obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), View.MeasureSpec.makeMeasureSpec(0, 0) + 35, (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                            }
                                            Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                            try {
                                                Object[] objArr18 = {673702224, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                                Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                                if (obj8 == null) {
                                                    obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + 911, 18 - KeyEvent.normalizeMetaState(0), (char) TextUtils.getCapsMode("", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    byte b4 = lookAheadTest[5];
                    Object[] objArr19 = new Object[1];
                    j(b4, (byte) (b4 - 1), lookAheadTest[5], objArr19);
                    Class<?> cls4 = Class.forName((String) objArr19[0]);
                    byte b5 = (byte) (lookAheadTest[5] - 1);
                    byte b6 = b5;
                    Object[] objArr20 = new Object[1];
                    j(b5, b6, b6, objArr20);
                    try {
                        Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                        Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                        if (obj9 == null) {
                            Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), Color.argb(0, 0, 0, 0) + 46, (char) ExpandableListView.getPackedPositionType(0L));
                            Object[] objArr22 = new Object[1];
                            k((byte) (-$$g[8]), (byte) $$h, (byte) (-$$g[9]), objArr22);
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
                                    obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                                }
                                Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                                try {
                                    Object[] objArr24 = {673702224, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj11 == null) {
                                        obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 912, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 18, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    byte b7 = lookAheadTest[5];
                    Object[] objArr25 = new Object[1];
                    j(b7, (byte) (b7 - 1), lookAheadTest[5], objArr25);
                    Class<?> cls6 = Class.forName((String) objArr25[0]);
                    byte b8 = (byte) (lookAheadTest[5] - 1);
                    byte b9 = b8;
                    Object[] objArr26 = new Object[1];
                    j(b8, b9, b9, objArr26);
                    try {
                        Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                        Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                        if (obj12 == null) {
                            Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 117, (ViewConfiguration.getWindowTouchSlop() >> 8) + 3, (char) (38967 - ((byte) KeyEvent.getModifierMetaStateMask())));
                            Object[] objArr28 = new Object[1];
                            k((byte) (-$$g[8]), (byte) $$h, (byte) (-$$g[9]), objArr28);
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
                                    obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - (ViewConfiguration.getEdgeSlop() >> 16), (char) TextUtils.indexOf("", "", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                                }
                                Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                                try {
                                    Object[] objArr30 = {673702224, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj14 == null) {
                                        obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - ExpandableListView.getPackedPositionType(0L), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 17, (char) TextUtils.indexOf("", "", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    byte b10 = lookAheadTest[5];
                    Object[] objArr31 = new Object[1];
                    j(b10, (byte) (b10 - 1), lookAheadTest[5], objArr31);
                    Class<?> cls8 = Class.forName((String) objArr31[0]);
                    byte b11 = (byte) (lookAheadTest[5] - 1);
                    byte b12 = b11;
                    Object[] objArr32 = new Object[1];
                    j(b11, b12, b12, objArr32);
                    try {
                        Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                        Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                        if (obj15 == null) {
                            Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - KeyEvent.normalizeMetaState(0), KeyEvent.keyCodeFromString("") + 3, (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))));
                            Object[] objArr34 = new Object[1];
                            k((byte) ($$g[47] - 1), (byte) (-$$g[53]), (byte) ($$g[47] - 1), objArr34);
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
                                    obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) Color.blue(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                                }
                                Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                                try {
                                    Object[] objArr36 = {673702224, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj17 == null) {
                                        obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + 911, (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 17, (char) TextUtils.getOffsetBefore("", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return super.getApplicationContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
        public Context getBaseContext() {
            return super.getBaseContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
        public Resources getResources() {
            return super.getResources();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle bundle) {
            Object[] objArr;
            Object[] objArr2 = new Object[1];
            h(new int[]{44, 18, 0, 6}, new byte[]{1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0}, true, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            h(new int[]{62, 5, 51, 4}, new byte[]{0, 0, 0, 1, 1}, false, objArr3);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr4 = new Object[1];
                    h(new int[]{0, 26, 0, 0}, new byte[]{1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1}, false, objArr4);
                    Class<?> cls2 = Class.forName((String) objArr4[0]);
                    Object[] objArr5 = new Object[1];
                    h(new int[]{26, 18, 57, 6}, new byte[]{0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1}, false, objArr5);
                    baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getTrimmedLength(""), 35 - View.MeasureSpec.getSize(0), (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr6 = new Object[1];
                        h(new int[]{67, 48, 31, 35}, null, true, objArr6);
                        String str = (String) objArr6[0];
                        Object[] objArr7 = new Object[1];
                        h(new int[]{115, 64, 139, 0}, new byte[]{0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0}, true, objArr7);
                        String str2 = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        h(new int[]{179, 64, 197, 0}, new byte[]{1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0}, false, objArr8);
                        String str3 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        h(new int[]{243, 60, 133, 27}, new byte[]{0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0}, true, objArr9);
                        String str4 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        h(new int[]{303, 6, 65, 6}, new byte[]{0, 1, 0, 0, 0, 1}, false, objArr10);
                        try {
                            Object[] objArr11 = {baseContext, str, str2, str3, str4, true, (String) objArr10[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.getSize(0), 17 - TextUtils.indexOf((CharSequence) "", '0'), (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                            }
                            ((Method) obj2).invoke(invoke, objArr11);
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
            try {
                byte b = lookAheadTest[5];
                Object[] objArr12 = new Object[1];
                j(b, (byte) (b - 1), lookAheadTest[5], objArr12);
                Class<?> cls3 = Class.forName((String) objArr12[0]);
                byte b2 = (byte) (lookAheadTest[5] - 1);
                byte b3 = b2;
                Object[] objArr13 = new Object[1];
                j(b2, b3, b3, objArr13);
                try {
                    Object[] objArr14 = {Integer.valueOf(((Integer) cls3.getMethod((String) objArr13[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls4 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 4 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)));
                        Object[] objArr15 = new Object[1];
                        k((byte) ($$g[47] - 1), (byte) (-$$g[53]), (byte) ($$g[47] - 1), objArr15);
                        obj3 = cls4.getMethod((String) objArr15[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr16 = (Object[]) ((Method) obj3).invoke(null, objArr14);
                    int i = ((int[]) objArr16[1])[0];
                    if (((int[]) objArr16[0])[0] != i) {
                        long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ((Process.getThreadPriority(0) + 20) >> 6), 35 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) Color.blue(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr17 = {1529579057, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.keyCodeFromString(""), KeyEvent.normalizeMetaState(0) + 18, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr17);
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
                    super.onCreate(bundle);
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
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onPause() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr = new Object[1];
                h(new int[]{0, 26, 0, 0}, new byte[]{1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1}, false, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                h(new int[]{26, 18, 57, 6}, new byte[]{0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1}, false, objArr2);
                baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, ((Process.getThreadPriority(0) + 20) >> 6) + 35, (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr3 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 911, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 18, (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("MyBillsEntityDataFactory", Context.class);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onResume() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr = new Object[1];
                h(new int[]{0, 26, 0, 0}, new byte[]{1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1}, false, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                h(new int[]{26, 18, 57, 6}, new byte[]{0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1}, false, objArr2);
                baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (Process.myTid() >> 22), (char) View.MeasureSpec.getMode(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr3 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ExpandableListView.getPackedPositionChild(0L), 18 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) (MotionEvent.axisFromString("") + 1))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

        private static void h(int[] iArr, byte[] bArr, boolean z, Object[] objArr) {
            VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
            int i = iArr[0];
            int i2 = iArr[1];
            int i3 = iArr[2];
            int i4 = iArr[3];
            char[] cArr = NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (cArr != null) {
                int length = cArr.length;
                char[] cArr2 = new char[length];
                for (int i5 = 0; i5 < length; i5++) {
                    cArr2[i5] = (char) (cArr[i5] ^ 5097613533456403102L);
                }
                cArr = cArr2;
            }
            char[] cArr3 = new char[i2];
            System.arraycopy(cArr, i, cArr3, 0, i2);
            if (bArr != null) {
                char[] cArr4 = new char[i2];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                char c = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                    if (bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1) {
                        cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                    } else {
                        cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                    }
                    c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
                cArr3 = cArr4;
            }
            if (i4 > 0) {
                char[] cArr5 = new char[i2];
                System.arraycopy(cArr3, 0, cArr5, 0, i2);
                int i6 = i2 - i4;
                System.arraycopy(cArr5, 0, cArr3, i6, i4);
                System.arraycopy(cArr5, i4, cArr3, 0, i6);
            }
            if (z) {
                char[] cArr6 = new char[i2];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                    cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i2 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
                cArr3 = cArr6;
            }
            if (i3 > 0) {
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                    cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
            }
            objArr[0] = new String(cArr3);
        }
    }

    /* loaded from: classes3.dex */
    public static class Back3 extends Back {
        public static final byte[] $$g = {75, -120, 119, 39, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
        public static final int $$h = 188;
        public static final byte[] lookAheadTest = {10, Byte.MIN_VALUE, TarHeader.LF_LINK, 76, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
        public static final int NetworkUserEntityData$$ExternalSyntheticLambda0 = 100;
        private static char[] moveToNextValue = {35500, 35580, 35581, 35573, 35571, 35520, 35576, 35560, 35568, 35569, 35569, 35568, 35573, 35532, 35497, 35537, 35566, 35574, 35545, 35543, 35576, 35570, 35566, 35573, 35575, 35577, 35503, 35580, 35572, 35568, 35570, 35568, 35574, 35570, 35565, 35564, 35573, 35575, 35567, 35524, 35526, 35566, 35568, 35572, 35495, 35558, 35556, 35554, 35359, 35555, 35561, 35524, 35521, 35356, 35583, 35534, 35564, 35359, 35556, 35563, 35555, 35354, 35366, 35394, 35406, 35417, 35410, 35500, 35581, 35581, 35538, 35539, 35541, 35499, 35536, 35541, 35541, 35580, 35581, 35537, 35497, 35498, 35499, 35537, 35537, 35494, 35498, 35501, 35536, 35539, 35499, 35538, 35540, 35498, 35539, 35536, 35539, 35538, 35497, 35498, 35540, 35536, 35494, 35497, 35536, 35578, 35578, 35579, 35541, 35503, 35501, 35501, 35503, 35501, 35541, 35463, 35541, 35536, 35498, 35543, 35580, 35540, 35502, 35502, 35502, 35501, 35494, 35495, 35494, 35499, 35501, 35499, 35498, 35498, 35539, 35540, 35541, 35540, 35500, 35498, 35503, 35543, 35581, 35539, 35496, 35538, 35581, 35540, 35500, 35541, 35536, 35536, 35537, 35539, 35538, 35498, 35498, 35501, 35540, 35540, 35541, 35538, 35500, 35501, 35500, 35503, 35540, 35538, 35497, 35536, 35581, 35536, 35498, 35498, 35537, 35579, 35539, 35499, 35541, 35463, 35503, 35541, 35581, 35539, 35494, 35498, 35501, 35496, 35494, 35494, 35498, 35503, 35500, 35503, 35501, 35538, 35581, 35538, 35538, 35541, 35540, 35583, 35540, 35499, 35536, 35537, 35494, 35537, 35576, 35536, 35539, 35539, 35539, 35541, 35499, 35539, 35538, 35496, 35497, 35494, 35537, 35541, 35500, 35496, 35498, 35542, 35583, 35578, 35537, 35536, 35578, 35541, 35503, 35541, 35539, 35496, 35496, 35497, 35497, 35536, 35539, 35499, 35497, 35457, 35526, 35559, 35552, 35520, 35526, 35558, 35554, 35522, 35522, 35557, 35556, 35560, 35554, 35357, 35583, 35580, 35578, 35550, 35524, 35555, 35555, 35559, 35359, 35357, 35555, 35552, 35354, 35356, 35359, 35576, 35546, 35489, 35527, 35564, 35561, 35561, 35529, 35583, 35552, 35555, 35557, 35565, 35556, 35557, 35564, 35556, 35357, 35583, 35524, 35552, 35557, 35559, 35557, 35557, 35356, 35357, 35557, 35559, 35557, 35458, 35501, 35503, 35503, 35502, 35503};

        /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0034). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void j(short r7, int r8, int r9, java.lang.Object[] r10) {
            /*
                int r7 = 106 - r7
                int r8 = r8 * 15
                int r8 = 18 - r8
                int r9 = r9 * 2
                int r9 = 16 - r9
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back3.lookAheadTest
                byte[] r1 = new byte[r9]
                r2 = 0
                if (r0 != 0) goto L18
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r10
                r10 = r9
                r9 = r8
                goto L34
            L18:
                r3 = 0
            L19:
                int r4 = r3 + 1
                byte r5 = (byte) r7
                r1[r3] = r5
                int r8 = r8 + 1
                if (r4 != r9) goto L2a
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L2a:
                r3 = r0[r8]
                r6 = r8
                r8 = r7
                r7 = r3
                r3 = r1
                r1 = r0
                r0 = r10
                r10 = r9
                r9 = r6
            L34:
                int r8 = r8 + r7
                int r7 = r8 + 2
                r8 = r9
                r9 = r10
                r10 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L19
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back3.j(short, int, int, java.lang.Object[]):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0036). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void k(byte r6, short r7, int r8, java.lang.Object[] r9) {
            /*
                int r8 = 46 - r8
                int r7 = r7 * 3
                int r7 = 42 - r7
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back3.$$g
                int r6 = r6 * 2
                int r6 = r6 + 75
                byte[] r1 = new byte[r7]
                int r7 = r7 + (-1)
                r2 = 0
                if (r0 != 0) goto L1a
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r9
                r9 = r8
                r8 = r7
                goto L36
            L1a:
                r3 = 0
            L1b:
                int r8 = r8 + 1
                byte r4 = (byte) r6
                r1[r3] = r4
                if (r3 != r7) goto L2a
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L2a:
                int r3 = r3 + 1
                r4 = r0[r8]
                r5 = r8
                r8 = r7
                r7 = r4
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r9
                r9 = r5
            L36:
                int r6 = r6 + r7
                int r6 = r6 + (-7)
                r7 = r8
                r8 = r9
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L1b
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back3.k(byte, short, int, java.lang.Object[]):void");
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            Object[] objArr;
            Object[] objArr2;
            Object[] objArr3;
            Object[] objArr4;
            super.attachBaseContext(context);
            Object[] objArr5 = new Object[1];
            h(new int[]{44, 18, 17, 0}, new byte[]{0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0}, false, objArr5);
            Class<?> cls = Class.forName((String) objArr5[0]);
            Object[] objArr6 = new Object[1];
            h(new int[]{62, 5, 99, 3}, null, true, objArr6);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context applicationContext = context != null ? context.getApplicationContext() : context;
                if (applicationContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.indexOf("", "", 0) + 35, (char) TextUtils.indexOf("", "", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        h(new int[]{67, 48, 0, 28}, new byte[]{0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1}, false, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        h(new int[]{115, 64, 0, 0}, new byte[]{1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0}, true, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        h(new int[]{179, 64, 0, 0}, new byte[]{0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0}, false, objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        h(new int[]{243, 60, 16, 25}, new byte[]{0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1}, false, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        h(new int[]{303, 6, 0, 0}, new byte[]{1, 1, 0, 0, 0, 1}, false, objArr11);
                        try {
                            Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getKeyRepeatDelay() >> 16), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 19, (char) KeyEvent.keyCodeFromString(""))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                    byte b = (byte) (lookAheadTest[5] + 1);
                    byte b2 = b;
                    Object[] objArr13 = new Object[1];
                    j(b, b2, b2, objArr13);
                    Class<?> cls2 = Class.forName((String) objArr13[0]);
                    byte b3 = (byte) (-lookAheadTest[5]);
                    byte b4 = b3;
                    Object[] objArr14 = new Object[1];
                    j(b3, b4, (byte) (b4 - 1), objArr14);
                    try {
                        Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                        if (obj3 == null) {
                            Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + 55, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 3, (char) View.getDefaultSize(0, 0));
                            Object[] objArr16 = new Object[1];
                            k($$g[78], $$g[31], $$g[53], objArr16);
                            obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                        }
                        Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), 16 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                            }
                            int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                            try {
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 15, (char) Drawable.resolveOpacity(0, 0))).getMethod("PlaceComponentResult", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                                }
                                if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                    ArrayList arrayList = new ArrayList();
                                    try {
                                        Object[] objArr17 = {invoke2};
                                        Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                        if (obj6 == null) {
                                            obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 816, ((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.RS, (char) (Color.blue(0) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getTouchSlop() >> 8), View.resolveSizeAndState(0, 0, 0) + 15, (char) (AndroidCharacter.getMirror('0') - '0')));
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
                                                obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getLongPressTimeout() >> 16), (Process.myTid() >> 22) + 35, (char) TextUtils.indexOf("", "", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                            }
                                            Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                            try {
                                                Object[] objArr18 = {-513764807, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                                Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                                if (obj8 == null) {
                                                    obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 911, (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 18, (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    byte b5 = (byte) (lookAheadTest[5] + 1);
                    byte b6 = b5;
                    Object[] objArr19 = new Object[1];
                    j(b5, b6, b6, objArr19);
                    Class<?> cls4 = Class.forName((String) objArr19[0]);
                    byte b7 = (byte) (-lookAheadTest[5]);
                    byte b8 = b7;
                    Object[] objArr20 = new Object[1];
                    j(b7, b8, (byte) (b8 - 1), objArr20);
                    try {
                        Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                        Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                        if (obj9 == null) {
                            Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myPid() >> 22) + 61, ExpandableListView.getPackedPositionChild(0L) + 47, (char) Color.alpha(0));
                            Object[] objArr22 = new Object[1];
                            k($$g[9], $$g[8], $$g[84], objArr22);
                            obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                        }
                        Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                        int i = ((int[]) objArr23[1])[0];
                        if (((int[]) objArr23[0])[0] != i) {
                            long j2 = ((r0 ^ i) & 4294967295L) | 17179869184L;
                            try {
                                Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj10 != null) {
                                    objArr4 = null;
                                } else {
                                    objArr4 = null;
                                    obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getPressedStateDuration() >> 16), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 35, (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                                }
                                Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                                try {
                                    Object[] objArr24 = {-513764807, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj11 == null) {
                                        obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 910, View.getDefaultSize(0, 0) + 18, (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    byte b9 = (byte) (lookAheadTest[5] + 1);
                    byte b10 = b9;
                    Object[] objArr25 = new Object[1];
                    j(b9, b10, b10, objArr25);
                    Class<?> cls6 = Class.forName((String) objArr25[0]);
                    byte b11 = (byte) (-lookAheadTest[5]);
                    byte b12 = b11;
                    Object[] objArr26 = new Object[1];
                    j(b11, b12, (byte) (b12 - 1), objArr26);
                    try {
                        Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                        Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                        if (obj12 == null) {
                            Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 117, 3 - View.MeasureSpec.getSize(0), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 38967));
                            Object[] objArr28 = new Object[1];
                            k($$g[9], $$g[8], $$g[84], objArr28);
                            obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                        }
                        Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                        int i2 = ((int[]) objArr29[1])[0];
                        if (((int[]) objArr29[0])[0] != i2) {
                            long j3 = ((r0 ^ i2) & 4294967295L) | 8589934592L;
                            try {
                                Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj13 != null) {
                                    objArr3 = null;
                                } else {
                                    objArr3 = null;
                                    obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getOffsetAfter("", 0), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 34, (char) KeyEvent.normalizeMetaState(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                                }
                                Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                                try {
                                    Object[] objArr30 = {-513764807, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj14 == null) {
                                        obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 912, TextUtils.getCapsMode("", 0, 0) + 18, (char) Color.argb(0, 0, 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    byte b13 = (byte) (lookAheadTest[5] + 1);
                    byte b14 = b13;
                    Object[] objArr31 = new Object[1];
                    j(b13, b14, b14, objArr31);
                    Class<?> cls8 = Class.forName((String) objArr31[0]);
                    byte b15 = (byte) (-lookAheadTest[5]);
                    byte b16 = b15;
                    Object[] objArr32 = new Object[1];
                    j(b15, b16, (byte) (b16 - 1), objArr32);
                    try {
                        Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                        Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                        if (obj15 == null) {
                            Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 106, 4 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) Color.green(0));
                            byte b17 = (byte) ($$g[78] - 1);
                            byte b18 = b17;
                            Object[] objArr34 = new Object[1];
                            k(b17, b18, b18, objArr34);
                            obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                        }
                        Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                        int i3 = ((int[]) objArr35[1])[0];
                        if (((int[]) objArr35[0])[0] != i3) {
                            long j4 = ((r0 ^ i3) & 4294967295L) | 4294967296L;
                            try {
                                Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj16 != null) {
                                    objArr2 = null;
                                } else {
                                    objArr2 = null;
                                    obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", "", 0, 0), 34 - TextUtils.indexOf((CharSequence) "", '0'), (char) Color.argb(0, 0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                                }
                                Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                                try {
                                    Object[] objArr36 = {-513764807, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj17 == null) {
                                        obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 911, (-16777198) - Color.rgb(0, 0, 0), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return super.getApplicationContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
        public Context getBaseContext() {
            return super.getBaseContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
        public Resources getResources() {
            return super.getResources();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle bundle) {
            Object[] objArr;
            Method method;
            Object[] objArr2 = new Object[1];
            h(new int[]{44, 18, 17, 0}, new byte[]{0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0}, false, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            h(new int[]{62, 5, 99, 3}, null, true, objArr3);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr4 = new Object[1];
                    h(new int[]{0, 26, 0, 26}, new byte[]{0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1}, true, objArr4);
                    Class<?> cls2 = Class.forName((String) objArr4[0]);
                    Object[] objArr5 = new Object[1];
                    h(new int[]{26, 18, 0, 6}, new byte[]{1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1}, false, objArr5);
                    baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), 35 - View.combineMeasuredStates(0, 0), (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr6 = new Object[1];
                        h(new int[]{67, 48, 0, 28}, new byte[]{0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1}, false, objArr6);
                        String str = (String) objArr6[0];
                        Object[] objArr7 = new Object[1];
                        h(new int[]{115, 64, 0, 0}, new byte[]{1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0}, true, objArr7);
                        String str2 = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        h(new int[]{179, 64, 0, 0}, new byte[]{0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0}, false, objArr8);
                        String str3 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        h(new int[]{243, 60, 16, 25}, new byte[]{0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1}, false, objArr9);
                        String str4 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        h(new int[]{303, 6, 0, 0}, new byte[]{1, 1, 0, 0, 0, 1}, false, objArr10);
                        try {
                            Object[] objArr11 = {baseContext, str, str2, str3, str4, true, (String) objArr10[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + 911, 18 - (ViewConfiguration.getScrollBarSize() >> 8), (char) View.MeasureSpec.getSize(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                            }
                            ((Method) obj2).invoke(invoke, objArr11);
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
            try {
                byte b = (byte) (lookAheadTest[5] + 1);
                byte b2 = b;
                Object[] objArr12 = new Object[1];
                j(b, b2, b2, objArr12);
                Class<?> cls3 = Class.forName((String) objArr12[0]);
                byte b3 = (byte) (-lookAheadTest[5]);
                byte b4 = b3;
                Object[] objArr13 = new Object[1];
                j(b3, b4, (byte) (b4 - 1), objArr13);
                try {
                    Object[] objArr14 = {Integer.valueOf(((Integer) cls3.getMethod((String) objArr13[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls4 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 493, 4 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) ((Process.getThreadPriority(0) + 20) >> 6));
                        byte b5 = (byte) ($$g[78] - 1);
                        byte b6 = b5;
                        Object[] objArr15 = new Object[1];
                        k(b5, b6, b6, objArr15);
                        obj3 = cls4.getMethod((String) objArr15[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr16 = (Object[]) ((Method) obj3).invoke(null, objArr14);
                    int i = ((int[]) objArr16[1])[0];
                    if (((int[]) objArr16[0])[0] != i) {
                        long j = ((r1 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                method = obj4;
                                objArr = null;
                            } else {
                                objArr = null;
                                method = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0', 0), 35 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) ((-1) - Process.getGidForName("")))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, method);
                            }
                            Object invoke2 = ((Method) method).invoke(objArr, objArr);
                            try {
                                Object[] objArr17 = {871654534, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 911, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 18, (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr17);
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
                    super.onCreate(bundle);
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
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onPause() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr = new Object[1];
                h(new int[]{0, 26, 0, 26}, new byte[]{0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1}, true, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                h(new int[]{26, 18, 0, 6}, new byte[]{1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1}, false, objArr2);
                baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - TextUtils.getCapsMode("", 0, 0), (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr3 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 911, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 18, (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1))).getMethod("MyBillsEntityDataFactory", Context.class);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Back, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onResume() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr = new Object[1];
                h(new int[]{0, 26, 0, 26}, new byte[]{0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1}, true, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                h(new int[]{26, 18, 0, 6}, new byte[]{1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1}, false, objArr2);
                baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr3 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + 911, 18 - Color.red(0), (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

        private static void h(int[] iArr, byte[] bArr, boolean z, Object[] objArr) {
            VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
            int i = iArr[0];
            int i2 = iArr[1];
            int i3 = iArr[2];
            int i4 = iArr[3];
            char[] cArr = moveToNextValue;
            if (cArr != null) {
                int length = cArr.length;
                char[] cArr2 = new char[length];
                for (int i5 = 0; i5 < length; i5++) {
                    cArr2[i5] = (char) (cArr[i5] ^ 5097613533456403102L);
                }
                cArr = cArr2;
            }
            char[] cArr3 = new char[i2];
            System.arraycopy(cArr, i, cArr3, 0, i2);
            if (bArr != null) {
                char[] cArr4 = new char[i2];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                char c = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                    if (bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1) {
                        cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                    } else {
                        cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                    }
                    c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
                cArr3 = cArr4;
            }
            if (i4 > 0) {
                char[] cArr5 = new char[i2];
                System.arraycopy(cArr3, 0, cArr5, 0, i2);
                int i6 = i2 - i4;
                System.arraycopy(cArr5, 0, cArr3, i6, i4);
                System.arraycopy(cArr5, i4, cArr3, 0, i6);
            }
            if (z) {
                char[] cArr6 = new char[i2];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                    cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i2 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
                cArr3 = cArr6;
            }
            if (i3 > 0) {
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                    cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
            }
            objArr[0] = new String(cArr3);
        }
    }

    /* loaded from: classes3.dex */
    public static class Lite3 extends Lite {
        public static final byte[] $$g = {8, -125, -40, -38, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
        public static final int $$h = 69;
        public static final byte[] lookAheadTest = {116, 39, -17, SignedBytes.MAX_POWER_OF_TWO, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
        public static final int NetworkUserEntityData$$ExternalSyntheticLambda0 = 233;
        private static char[] getErrorConfigVersion = {35500, 35580, 35581, 35573, 35571, 35520, 35576, 35560, 35568, 35569, 35569, 35568, 35573, 35532, 35497, 35537, 35566, 35574, 35545, 35543, 35576, 35570, 35566, 35573, 35575, 35577, 35538, 35388, 35383, 35382, 35391, 35329, 35385, 35342, 35344, 35384, 35386, 35390, 35330, 35334, 35390, 35386, 35388, 35386, 35503, 35575, 35573, 35571, 35564, 35568, 35574, 35541, 35534, 35565, 35532, 35551, 35581, 35564, 35573, 35576, 35568, 35563, 35500, 35576, 35521, 35577, 35565, 35461, 35539, 35538, 35497, 35498, 35540, 35536, 35494, 35497, 35536, 35578, 35578, 35579, 35541, 35503, 35501, 35501, 35503, 35501, 35541, 35580, 35581, 35581, 35538, 35539, 35541, 35499, 35536, 35541, 35541, 35580, 35581, 35537, 35497, 35498, 35499, 35537, 35537, 35494, 35498, 35501, 35536, 35539, 35499, 35538, 35540, 35498, 35539, 35522, 35389, 35347, 35387, 35363, 35385, 35346, 35346, 35384, 35365, 35384, 35345, 35386, 35388, 35351, 35348, 35349, 35348, 35386, 35389, 35388, 35388, 35349, 35346, 35346, 35386, 35387, 35385, 35384, 35384, 35389, 35348, 35388, 35365, 35386, 35344, 35387, 35365, 35391, 35351, 35346, 35348, 35388, 35389, 35388, 35387, 35346, 35346, 35347, 35349, 35347, 35342, 35343, 35342, 35349, 35350, 35350, 35350, 35388, 35364, 35391, 35346, 35384, 35389, 35548, 35354, 35358, 35555, 35552, 35555, 35553, 35334, 35377, 35334, 35334, 35337, 35336, 35379, 35336, 35359, 35332, 35333, 35354, 35333, 35372, 35332, 35335, 35335, 35335, 35337, 35359, 35335, 35334, 35356, 35357, 35354, 35333, 35337, 35552, 35356, 35358, 35338, 35379, 35374, 35333, 35332, 35374, 35337, 35555, 35337, 35335, 35356, 35356, 35357, 35357, 35332, 35335, 35359, 35357, 35359, 35555, 35337, 35377, 35335, 35354, 35358, 35553, 35356, 35492, 35565, 35533, 35539, 35571, 35567, 35535, 35535, 35566, 35569, 35573, 35567, 35558, 35528, 35529, 35527, 35499, 35537, 35564, 35564, 35568, 35560, 35558, 35564, 35565, 35559, 35561, 35560, 35525, 35495, 35498, 35536, 35577, 35570, 35570, 35538, 35528, 35565, 35564, 35566, 35574, 35569, 35566, 35577, 35569, 35558, 35528, 35537, 35565, 35566, 35568, 35566, 35566, 35561, 35558, 35566, 35568, 35566, 35536, 35539, 35534, 35384, 35382, 35386, 35389, 35386};

        /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0035). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void j(int r6, int r7, byte r8, java.lang.Object[] r9) {
            /*
                int r6 = r6 * 4
                int r6 = r6 + 16
                int r7 = r7 * 15
                int r7 = 18 - r7
                int r8 = r8 + 105
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite3.lookAheadTest
                byte[] r1 = new byte[r6]
                int r6 = r6 + (-1)
                r2 = 0
                if (r0 != 0) goto L1a
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r9
                r9 = r8
                r8 = r7
                goto L35
            L1a:
                r3 = 0
            L1b:
                int r7 = r7 + 1
                byte r4 = (byte) r8
                r1[r3] = r4
                int r4 = r3 + 1
                if (r3 != r6) goto L2c
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L2c:
                r3 = r0[r7]
                r5 = r8
                r8 = r7
                r7 = r3
                r3 = r1
                r1 = r0
                r0 = r9
                r9 = r5
            L35:
                int r9 = r9 + r7
                int r7 = r9 + 2
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                r5 = r8
                r8 = r7
                r7 = r5
                goto L1b
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite3.j(int, int, byte, java.lang.Object[]):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0037). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void k(int r6, int r7, short r8, java.lang.Object[] r9) {
            /*
                int r7 = r7 * 3
                int r7 = r7 + 21
                int r6 = r6 * 2
                int r6 = 103 - r6
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite3.$$g
                int r8 = r8 + 4
                byte[] r1 = new byte[r7]
                int r7 = r7 + (-1)
                r2 = 0
                if (r0 != 0) goto L1a
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r9
                r9 = r8
                r8 = r7
                goto L37
            L1a:
                r3 = 0
            L1b:
                int r8 = r8 + 1
                byte r4 = (byte) r6
                r1[r3] = r4
                if (r3 != r7) goto L2a
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L2a:
                r4 = r0[r8]
                int r3 = r3 + 1
                r5 = r7
                r7 = r6
                r6 = r4
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r9
                r9 = r8
                r8 = r5
            L37:
                int r7 = r7 + r6
                int r6 = r7 + (-7)
                r7 = r8
                r8 = r9
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L1b
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite3.k(int, int, short, java.lang.Object[]):void");
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            Object[] objArr;
            Object[] objArr2;
            Object[] objArr3;
            Object[] objArr4;
            super.attachBaseContext(context);
            Object[] objArr5 = new Object[1];
            h(new int[]{44, 18, 2, 0}, new byte[]{1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0}, false, objArr5);
            Class<?> cls = Class.forName((String) objArr5[0]);
            Object[] objArr6 = new Object[1];
            h(new int[]{62, 5, 0, 0}, new byte[]{0, 1, 0, 0, 0}, true, objArr6);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context applicationContext = context != null ? context.getApplicationContext() : context;
                if (applicationContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        h(new int[]{67, 48, 0, 0}, new byte[]{1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1}, false, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        h(new int[]{115, 64, 88, 0}, new byte[]{1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1}, false, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        h(new int[]{179, 64, 76, 55}, new byte[]{0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0}, false, objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        h(new int[]{243, 60, 5, 23}, new byte[]{0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1}, false, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        h(new int[]{303, 6, 115, 2}, new byte[]{1, 1, 0, 1, 0, 0}, true, objArr11);
                        try {
                            Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarSize() >> 8), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 18, (char) Color.blue(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                    byte b = (byte) (lookAheadTest[5] + 1);
                    Object[] objArr13 = new Object[1];
                    j(b, b, (byte) (-lookAheadTest[5]), objArr13);
                    Class<?> cls2 = Class.forName((String) objArr13[0]);
                    byte b2 = (byte) (lookAheadTest[5] + 1);
                    byte b3 = (byte) (-lookAheadTest[5]);
                    Object[] objArr14 = new Object[1];
                    j(b2, b3, (byte) (b3 - 1), objArr14);
                    try {
                        Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                        if (obj3 == null) {
                            Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - KeyEvent.getDeadChar(0, 0), Process.getGidForName("") + 4, (char) Color.argb(0, 0, 0, 0));
                            Object[] objArr16 = new Object[1];
                            k($$g[12], $$g[78], $$g[47], objArr16);
                            obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                        }
                        Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 14, (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("getAuthRequestContext", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                            }
                            int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                            try {
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (KeyEvent.getMaxKeyCode() >> 16), View.getDefaultSize(0, 0) + 15, (char) View.resolveSize(0, 0))).getMethod("PlaceComponentResult", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                                }
                                if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                    ArrayList arrayList = new ArrayList();
                                    try {
                                        Object[] objArr17 = {invoke2};
                                        Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                        if (obj6 == null) {
                                            obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - Color.alpha(0), 30 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (Color.blue(0) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), View.MeasureSpec.getMode(0) + 15, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16)));
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                        }
                                        arrayList.add(((Method) obj6).invoke(null, objArr17));
                                        long j = ((r6 ^ intValue2) & 4294967295L) | 60129542144L;
                                        try {
                                            Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                            if (obj7 != null) {
                                                objArr = null;
                                            } else {
                                                objArr = null;
                                                obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", "", 0), 35 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                            }
                                            Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                            try {
                                                Object[] objArr18 = {136102262, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                                Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                                if (obj8 == null) {
                                                    obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0', 0), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18, (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    byte b4 = (byte) (lookAheadTest[5] + 1);
                    Object[] objArr19 = new Object[1];
                    j(b4, b4, (byte) (-lookAheadTest[5]), objArr19);
                    Class<?> cls4 = Class.forName((String) objArr19[0]);
                    byte b5 = (byte) (lookAheadTest[5] + 1);
                    byte b6 = (byte) (-lookAheadTest[5]);
                    Object[] objArr20 = new Object[1];
                    j(b5, b6, (byte) (b6 - 1), objArr20);
                    try {
                        Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                        Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                        if (obj9 == null) {
                            Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (ViewConfiguration.getTapTimeout() >> 16), 46 - View.getDefaultSize(0, 0), (char) Color.red(0));
                            byte b7 = (byte) ($$g[78] - 1);
                            Object[] objArr22 = new Object[1];
                            k(b7, b7, $$g[28], objArr22);
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
                                    obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.getSize(0), (ViewConfiguration.getEdgeSlop() >> 16) + 35, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                                }
                                Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                                try {
                                    Object[] objArr24 = {136102262, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj11 == null) {
                                        obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 912, (ViewConfiguration.getWindowTouchSlop() >> 8) + 18, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    byte b8 = (byte) (lookAheadTest[5] + 1);
                    Object[] objArr25 = new Object[1];
                    j(b8, b8, (byte) (-lookAheadTest[5]), objArr25);
                    Class<?> cls6 = Class.forName((String) objArr25[0]);
                    byte b9 = (byte) (lookAheadTest[5] + 1);
                    byte b10 = (byte) (-lookAheadTest[5]);
                    Object[] objArr26 = new Object[1];
                    j(b9, b10, (byte) (b10 - 1), objArr26);
                    try {
                        Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                        Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                        if (obj12 == null) {
                            Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - TextUtils.getOffsetBefore("", 0), 3 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (TextUtils.lastIndexOf("", '0') + 38969));
                            byte b11 = (byte) ($$g[78] - 1);
                            Object[] objArr28 = new Object[1];
                            k(b11, b11, $$g[28], objArr28);
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
                                    obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", ""), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 35, (char) Color.alpha(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                                }
                                Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                                try {
                                    Object[] objArr30 = {136102262, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj14 == null) {
                                        obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 912, KeyEvent.normalizeMetaState(0) + 18, (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    byte b12 = (byte) (lookAheadTest[5] + 1);
                    Object[] objArr31 = new Object[1];
                    j(b12, b12, (byte) (-lookAheadTest[5]), objArr31);
                    Class<?> cls8 = Class.forName((String) objArr31[0]);
                    byte b13 = (byte) (lookAheadTest[5] + 1);
                    byte b14 = (byte) (-lookAheadTest[5]);
                    Object[] objArr32 = new Object[1];
                    j(b13, b14, (byte) (b14 - 1), objArr32);
                    try {
                        Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                        Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                        if (obj15 == null) {
                            Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(108 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 4 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))));
                            Object[] objArr34 = new Object[1];
                            k($$g[9], $$g[8], (byte) (-$$g[40]), objArr34);
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
                                    obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.getDefaultSize(0, 0), 36 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                                }
                                Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                                try {
                                    Object[] objArr36 = {136102262, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj17 == null) {
                                        obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 18 - Drawable.resolveOpacity(0, 0), (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return super.getApplicationContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
        public Context getBaseContext() {
            return super.getBaseContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
        public Resources getResources() {
            return super.getResources();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle bundle) {
            Object[] objArr;
            Object[] objArr2 = new Object[1];
            h(new int[]{44, 18, 2, 0}, new byte[]{1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0}, false, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            h(new int[]{62, 5, 0, 0}, new byte[]{0, 1, 0, 0, 0}, true, objArr3);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr4 = new Object[1];
                    h(new int[]{0, 26, 0, 0}, new byte[]{0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1}, true, objArr4);
                    Class<?> cls2 = Class.forName((String) objArr4[0]);
                    Object[] objArr5 = new Object[1];
                    h(new int[]{26, 18, 54, 0}, new byte[]{1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1}, false, objArr5);
                    baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - Process.getGidForName(""), 35 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (MotionEvent.axisFromString("") + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr6 = new Object[1];
                        h(new int[]{67, 48, 0, 0}, new byte[]{1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1}, false, objArr6);
                        String str = (String) objArr6[0];
                        Object[] objArr7 = new Object[1];
                        h(new int[]{115, 64, 88, 0}, new byte[]{1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1}, false, objArr7);
                        String str2 = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        h(new int[]{179, 64, 76, 55}, new byte[]{0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0}, false, objArr8);
                        String str3 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        h(new int[]{243, 60, 5, 23}, new byte[]{0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1}, false, objArr9);
                        String str4 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        h(new int[]{303, 6, 115, 2}, new byte[]{1, 1, 0, 1, 0, 0}, true, objArr10);
                        try {
                            Object[] objArr11 = {baseContext, str, str2, str3, str4, true, (String) objArr10[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (ViewConfiguration.getLongPressTimeout() >> 16) + 18, (char) TextUtils.indexOf("", ""))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                            }
                            ((Method) obj2).invoke(invoke, objArr11);
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
            try {
                byte b = (byte) (lookAheadTest[5] + 1);
                Object[] objArr12 = new Object[1];
                j(b, b, (byte) (-lookAheadTest[5]), objArr12);
                Class<?> cls3 = Class.forName((String) objArr12[0]);
                byte b2 = (byte) (lookAheadTest[5] + 1);
                byte b3 = (byte) (-lookAheadTest[5]);
                Object[] objArr13 = new Object[1];
                j(b2, b3, (byte) (b3 - 1), objArr13);
                try {
                    Object[] objArr14 = {Integer.valueOf(((Integer) cls3.getMethod((String) objArr13[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls4 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + 494, View.MeasureSpec.makeMeasureSpec(0, 0) + 4, (char) (ViewConfiguration.getTouchSlop() >> 8));
                        Object[] objArr15 = new Object[1];
                        k($$g[9], $$g[8], (byte) (-$$g[40]), objArr15);
                        obj3 = cls4.getMethod((String) objArr15[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr16 = (Object[]) ((Method) obj3).invoke(null, objArr14);
                    int i = ((int[]) objArr16[1])[0];
                    if (((int[]) objArr16[0])[0] != i) {
                        long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 34, (char) View.getDefaultSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr17 = {960942063, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + 911, 18 - TextUtils.getOffsetAfter("", 0), (char) (Color.rgb(0, 0, 0) + 16777216))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr17);
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
                    super.onCreate(bundle);
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
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onPause() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr = new Object[1];
                h(new int[]{0, 26, 0, 0}, new byte[]{0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1}, true, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                h(new int[]{26, 18, 54, 0}, new byte[]{1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1}, false, objArr2);
                baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - View.MeasureSpec.getMode(0), (char) TextUtils.getOffsetAfter("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr3 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + 911, 18 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Context.class);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onResume() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr = new Object[1];
                h(new int[]{0, 26, 0, 0}, new byte[]{0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1}, true, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                h(new int[]{26, 18, 54, 0}, new byte[]{1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1}, false, objArr2);
                baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0', 0, 0), View.MeasureSpec.getSize(0) + 35, (char) View.resolveSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr3 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 910, 19 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

        private static void h(int[] iArr, byte[] bArr, boolean z, Object[] objArr) {
            VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
            int i = iArr[0];
            int i2 = iArr[1];
            int i3 = iArr[2];
            int i4 = iArr[3];
            char[] cArr = getErrorConfigVersion;
            if (cArr != null) {
                int length = cArr.length;
                char[] cArr2 = new char[length];
                for (int i5 = 0; i5 < length; i5++) {
                    cArr2[i5] = (char) (cArr[i5] ^ 5097613533456403102L);
                }
                cArr = cArr2;
            }
            char[] cArr3 = new char[i2];
            System.arraycopy(cArr, i, cArr3, 0, i2);
            if (bArr != null) {
                char[] cArr4 = new char[i2];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                char c = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                    if (bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1) {
                        cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                    } else {
                        cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                    }
                    c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
                cArr3 = cArr4;
            }
            if (i4 > 0) {
                char[] cArr5 = new char[i2];
                System.arraycopy(cArr3, 0, cArr5, 0, i2);
                int i6 = i2 - i4;
                System.arraycopy(cArr5, 0, cArr3, i6, i4);
                System.arraycopy(cArr5, i4, cArr3, 0, i6);
            }
            if (z) {
                char[] cArr6 = new char[i2];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                    cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i2 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
                cArr3 = cArr6;
            }
            if (i3 > 0) {
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                    cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                }
            }
            objArr[0] = new String(cArr3);
        }
    }

    /* loaded from: classes3.dex */
    public static class Lite1 extends Lite {
        public static final byte[] $$g = {15, -40, -114, -21, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
        public static final int $$h = 188;
        public static final byte[] scheduleImpl = {Ascii.ETB, -59, 18, 83, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
        public static final int NetworkUserEntityData$$ExternalSyntheticLambda0 = 89;
        private static char getErrorConfigVersion = 42066;
        private static char[] lookAheadTest = {37302, 37367, 37374, 37287, 37460, 37288, 37284, 37307, 37369, 37463, 37275, 37304, 37306, 37283, 37372, 37293, 37290, 37274, 37371, 37286, 37370, 37368, 37295, 37294, 37373, 37297, 37299, 37279, 37262, 37366, 37289, 37461, 37291, 37292, 37309, 37296, 37310, 37280, 37281, 37298, 37308, 37375, 37344, 37282, 37285, 37345, 37305, 37311, 37365};

        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x0031). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void j(byte r6, short r7, byte r8, java.lang.Object[] r9) {
            /*
                int r6 = 106 - r6
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite1.scheduleImpl
                int r7 = 55 - r7
                int r8 = r8 + 16
                byte[] r1 = new byte[r8]
                int r8 = r8 + (-1)
                r2 = 0
                if (r0 != 0) goto L15
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r9
                r9 = r8
                goto L31
            L15:
                r3 = 0
            L16:
                byte r4 = (byte) r6
                r1[r3] = r4
                int r7 = r7 + 1
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
                r6 = r4
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r9
                r9 = r5
            L31:
                int r6 = -r6
                int r8 = r8 + r6
                int r6 = r8 + (-4)
                r8 = r9
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L16
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite1.j(byte, short, byte, java.lang.Object[]):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0033). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void k(short r7, short r8, byte r9, java.lang.Object[] r10) {
            /*
                int r7 = r7 * 3
                int r7 = 42 - r7
                byte[] r0 = com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite1.$$g
                int r8 = r8 + 4
                int r9 = r9 * 2
                int r9 = 103 - r9
                byte[] r1 = new byte[r7]
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
                byte r5 = (byte) r9
                r1[r3] = r5
                if (r4 != r7) goto L29
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L29:
                r3 = r0[r8]
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
                int r10 = r10 + r7
                int r7 = r10 + (-7)
                int r9 = r9 + 1
                r10 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                r6 = r9
                r9 = r7
                r7 = r8
                r8 = r6
                goto L1a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite1.k(short, short, byte, java.lang.Object[]):void");
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
        public void attachBaseContext(Context context) {
            Object[] objArr;
            Object[] objArr2;
            Object[] objArr3;
            Object[] objArr4;
            super.attachBaseContext(context);
            Object[] objArr5 = new Object[1];
            h(new char[]{24, '%', '!', 28, '(', 16, 31, '.', Typography.amp, ')', '0', 24, 30, ')', 30, 19, 13828, 13828}, Process.getGidForName("") + 19, (byte) (TextUtils.getOffsetAfter("", 0) + 27), objArr5);
            Class<?> cls = Class.forName((String) objArr5[0]);
            Object[] objArr6 = new Object[1];
            h(new char[]{'*', 1, 18, 20, 13925}, KeyEvent.keyCodeFromString("") + 5, (byte) ((ViewConfiguration.getTouchSlop() >> 8) + 103), objArr6);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context applicationContext = context != null ? context.getApplicationContext() : context;
                if (applicationContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, View.resolveSizeAndState(0, 0, 0) + 35, (char) TextUtils.getTrimmedLength(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        h(new char[]{JSONLexer.EOI, 28, 15, '\b', '\'', Typography.quote, Typography.dollar, '\b', 23, 14, Typography.quote, 31, 17, 23, 1, '\t', 13796, 13796, '\t', 22, '!', Typography.quote, 29, '\f', 28, 18, 4, 29, 25, 31, 30, 23, Typography.dollar, 15, 22, 31, 31, 30, 6, Typography.dollar, 23, 28, 15, 11, 16, 15, '\t', 15}, 48 - (ViewConfiguration.getScrollBarSize() >> 8), (byte) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 57), objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        h(new char[]{27, 16, 11, 29, 31, 30, Typography.dollar, 6, '!', Typography.quote, Typography.quote, 15, 30, 4, 4, 16, 13742, 13742, '%', '\t', 30, 4, 7, 15, 15, 22, 30, 15, 4, 29, 13742, 13742, Typography.quote, '!', 15, 4, 13823, 13823, '#', 20, 27, '0', 23, '\t', 28, JSONLexer.EOI, 0, 23, 13743, 13743, 22, 28, 28, 22, '%', 6, '%', 6, 29, 19, 3, 2, 28, 18}, Color.green(0) + 64, (byte) (6 - Color.alpha(0)), objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        h(new char[]{23, 3, 17, 16, 28, 22, 25, 17, 13853, 13853, 2, 3, 0, 16, '#', 27, 30, 23, 25, '\'', 22, 17, 21, 16, 23, 28, Typography.dollar, '\b', 13943, 13943, JSONLexer.EOI, 28, 25, 28, 22, 3, 14, 22, 15, '\b', 2, 29, 4, 16, 6, Typography.dollar, 22, 16, 31, 30, 30, 19, 23, 3, Typography.quote, 16, 27, 14, Typography.dollar, 15, Typography.quote, 16, 15, Typography.quote}, (ViewConfiguration.getWindowTouchSlop() >> 8) + 64, (byte) (123 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))), objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        h(new char[]{0, '\n', '\f', '*', ')', '/', 13778, 13778, 30, 25, '%', 24, '*', '\n', 6, 31, 23, 30, '\f', 28, JSONLexer.EOI, '%', '\n', '*', '\f', 19, 27, 30, '!', '\'', '(', '\b', 27, 30, 17, ',', 30, '(', ',', '+', JSONLexer.EOI, ',', 14, '/', 17, '(', 2, 19, '#', '\f', '+', '/', 21, '-', 18, ',', 17, '%', '\f', '#'}, 59 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (byte) ((-16777187) - Color.rgb(0, 0, 0)), objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        h(new char[]{31, '+', 17, '.', 23, 3}, Drawable.resolveOpacity(0, 0) + 6, (byte) (13 - Gravity.getAbsoluteGravity(0, 0)), objArr11);
                        try {
                            Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getWindowTouchSlop() >> 8), MotionEvent.axisFromString("") + 19, (char) TextUtils.indexOf("", "", 0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                    j(scheduleImpl[25], (byte) (-scheduleImpl[31]), scheduleImpl[25], objArr13);
                    Class<?> cls2 = Class.forName((String) objArr13[0]);
                    Object[] objArr14 = new Object[1];
                    j(scheduleImpl[9], (short) 30, scheduleImpl[25], objArr14);
                    try {
                        Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                        if (obj3 == null) {
                            Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 3 - View.combineMeasuredStates(0, 0), (char) (ViewConfiguration.getFadingEdgeLength() >> 16));
                            Object[] objArr16 = new Object[1];
                            k($$g[68], (byte) ($$g[47] - 1), (byte) (-$$g[12]), objArr16);
                            obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                        }
                        Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + 800, 14 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("getAuthRequestContext", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                            }
                            int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                            try {
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + 800, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 15, (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("PlaceComponentResult", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                                }
                                if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                    ArrayList arrayList = new ArrayList();
                                    try {
                                        Object[] objArr17 = {invoke2};
                                        Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                        if (obj6 == null) {
                                            obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - TextUtils.indexOf("", "", 0, 0), 29 - TextUtils.getCapsMode("", 0, 0), (char) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getScrollBarSize() >> 8), (ViewConfiguration.getWindowTouchSlop() >> 8) + 15, (char) View.resolveSize(0, 0)));
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
                                                obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Gravity.getAbsoluteGravity(0, 0), ExpandableListView.getPackedPositionGroup(0L) + 35, (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                            }
                                            Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                            try {
                                                Object[] objArr18 = {-1193682212, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                                Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                                if (obj8 == null) {
                                                    obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.red(0), 18 - Color.alpha(0), (char) KeyEvent.keyCodeFromString(""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    j(scheduleImpl[25], (byte) (-scheduleImpl[31]), scheduleImpl[25], objArr19);
                    Class<?> cls4 = Class.forName((String) objArr19[0]);
                    Object[] objArr20 = new Object[1];
                    j(scheduleImpl[9], (short) 30, scheduleImpl[25], objArr20);
                    try {
                        Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                        Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                        if (obj9 == null) {
                            Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(60 - Process.getGidForName(""), (ViewConfiguration.getTouchSlop() >> 8) + 46, (char) (ViewConfiguration.getLongPressTimeout() >> 16));
                            byte b = (byte) (-$$g[8]);
                            Object[] objArr22 = new Object[1];
                            k(b, (byte) (b | 16), (byte) ($$g[47] - 1), objArr22);
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
                                    obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Drawable.resolveOpacity(0, 0), 34 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) TextUtils.indexOf("", "", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                                }
                                Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                                try {
                                    Object[] objArr24 = {-1193682212, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj11 == null) {
                                        obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.getDeadChar(0, 0), KeyEvent.normalizeMetaState(0) + 18, (char) TextUtils.getOffsetAfter("", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    j(scheduleImpl[25], (byte) (-scheduleImpl[31]), scheduleImpl[25], objArr25);
                    Class<?> cls6 = Class.forName((String) objArr25[0]);
                    Object[] objArr26 = new Object[1];
                    j(scheduleImpl[9], (short) 30, scheduleImpl[25], objArr26);
                    try {
                        Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                        Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                        if (obj12 == null) {
                            Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + 118, 3 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 38967));
                            byte b2 = (byte) (-$$g[8]);
                            Object[] objArr28 = new Object[1];
                            k(b2, (byte) (b2 | 16), (byte) ($$g[47] - 1), objArr28);
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
                                    obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getPressedStateDuration() >> 16), 36 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) View.MeasureSpec.getSize(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                                }
                                Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                                try {
                                    Object[] objArr30 = {-1193682212, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj14 == null) {
                                        obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 18 - (ViewConfiguration.getTapTimeout() >> 16), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    j(scheduleImpl[25], (byte) (-scheduleImpl[31]), scheduleImpl[25], objArr31);
                    Class<?> cls8 = Class.forName((String) objArr31[0]);
                    Object[] objArr32 = new Object[1];
                    j(scheduleImpl[9], (short) 30, scheduleImpl[25], objArr32);
                    try {
                        Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                        Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                        if (obj15 == null) {
                            Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - TextUtils.getTrimmedLength(""), ExpandableListView.getPackedPositionGroup(0L) + 3, (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1));
                            Object[] objArr34 = new Object[1];
                            k((byte) ($$g[47] - 1), (byte) (-$$g[53]), (byte) (-$$g[9]), objArr34);
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
                                    obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.blue(0), 34 - TextUtils.lastIndexOf("", '0', 0, 0), (char) TextUtils.indexOf("", ""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                                }
                                Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                                try {
                                    Object[] objArr36 = {-1193682212, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj17 == null) {
                                        obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0) + 911, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 18, (char) (Process.myTid() >> 22))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
        public Context getApplicationContext() {
            return super.getApplicationContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
        public Context getBaseContext() {
            return super.getBaseContext();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
        public Resources getResources() {
            return super.getResources();
        }

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle bundle) {
            Object[] objArr;
            Object[] objArr2 = new Object[1];
            h(new char[]{24, '%', '!', 28, '(', 16, 31, '.', Typography.amp, ')', '0', 24, 30, ')', 30, 19, 13828, 13828}, Color.alpha(0) + 18, (byte) (super.getResources().getString(R.string.input_receiver_number).substring(0, 21).codePointAt(11) - 91), objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            h(new char[]{'*', 1, 18, 20, 13925}, getPackageName().length() - 2, (byte) ((ViewConfiguration.getEdgeSlop() >> 16) + 103), objArr3);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    char[] cArr = {24, '%', '!', 28, '(', 16, 31, '.', JSONLexer.EOI, ',', '0', '.', 29, Typography.quote, '\f', 14, '/', 18, 14, 7, 17, '\n', 30, 20, 25, 30};
                    int trimmedLength = TextUtils.getTrimmedLength("") + 26;
                    try {
                        Object[] objArr4 = new Object[1];
                        j((byte) (-scheduleImpl[32]), (byte) (scheduleImpl[49] - 1), scheduleImpl[30], objArr4);
                        Class<?> cls2 = Class.forName((String) objArr4[0]);
                        Object[] objArr5 = new Object[1];
                        j(scheduleImpl[48], scheduleImpl[25], scheduleImpl[8], objArr5);
                        Object[] objArr6 = new Object[1];
                        h(cArr, trimmedLength, (byte) (((ApplicationInfo) cls2.getMethod((String) objArr5[0], null).invoke(this, null)).targetSdkVersion + 56), objArr6);
                        Class<?> cls3 = Class.forName((String) objArr6[0]);
                        Object[] objArr7 = new Object[1];
                        h(new char[]{'(', 19, 13833, 13833, 17, '%', 14, '#', 13835, 13835, '\f', 20, 30, JSONLexer.EOI, '\f', 14, Typography.amp, '\''}, super.getResources().getString(R.string.progress1).substring(0, 5).codePointAt(1) - 82, (byte) (33 - (ViewConfiguration.getMinimumFlingVelocity() >> 16)), objArr7);
                        baseContext = (Context) cls3.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
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
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776287) - Color.rgb(0, 0, 0), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 36, (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr8 = new Object[1];
                        h(new char[]{JSONLexer.EOI, 28, 15, '\b', '\'', Typography.quote, Typography.dollar, '\b', 23, 14, Typography.quote, 31, 17, 23, 1, '\t', 13796, 13796, '\t', 22, '!', Typography.quote, 29, '\f', 28, 18, 4, 29, 25, 31, 30, 23, Typography.dollar, 15, 22, 31, 31, 30, 6, Typography.dollar, 23, 28, 15, 11, 16, 15, '\t', 15}, super.getResources().getString(R.string.card_filter_done).substring(3, 4).codePointAt(0) - 53, (byte) ((KeyEvent.getMaxKeyCode() >> 16) + 57), objArr8);
                        String str = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        h(new char[]{27, 16, 11, 29, 31, 30, Typography.dollar, 6, '!', Typography.quote, Typography.quote, 15, 30, 4, 4, 16, 13742, 13742, '%', '\t', 30, 4, 7, 15, 15, 22, 30, 15, 4, 29, 13742, 13742, Typography.quote, '!', 15, 4, 13823, 13823, '#', 20, 27, '0', 23, '\t', 28, JSONLexer.EOI, 0, 23, 13743, 13743, 22, 28, 28, 22, '%', 6, '%', 6, 29, 19, 3, 2, 28, 18}, getPackageName().length() + 57, (byte) (6 - View.resolveSizeAndState(0, 0, 0)), objArr9);
                        String str2 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        h(new char[]{23, 3, 17, 16, 28, 22, 25, 17, 13853, 13853, 2, 3, 0, 16, '#', 27, 30, 23, 25, '\'', 22, 17, 21, 16, 23, 28, Typography.dollar, '\b', 13943, 13943, JSONLexer.EOI, 28, 25, 28, 22, 3, 14, 22, 15, '\b', 2, 29, 4, 16, 6, Typography.dollar, 22, 16, 31, 30, 30, 19, 23, 3, Typography.quote, 16, 27, 14, Typography.dollar, 15, Typography.quote, 16, 15, Typography.quote}, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 63, (byte) (super.getResources().getString(R.string.share_feed_loading_description).substring(16, 17).length() + 122), objArr10);
                        String str3 = (String) objArr10[0];
                        char[] cArr2 = {0, '\n', '\f', '*', ')', '/', 13778, 13778, 30, 25, '%', 24, '*', '\n', 6, 31, 23, 30, '\f', 28, JSONLexer.EOI, '%', '\n', '*', '\f', 19, 27, 30, '!', '\'', '(', '\b', 27, 30, 17, ',', 30, '(', ',', '+', JSONLexer.EOI, ',', 14, '/', 17, '(', 2, 19, '#', '\f', '+', '/', 21, '-', 18, ',', 17, '%', '\f', '#'};
                        int length = super.getResources().getString(R.string.dana_deals_buy_now_text).substring(0, 1).length() + 59;
                        try {
                            Object[] objArr11 = new Object[1];
                            j((byte) (-scheduleImpl[32]), (byte) (scheduleImpl[49] - 1), scheduleImpl[30], objArr11);
                            Class<?> cls4 = Class.forName((String) objArr11[0]);
                            j(scheduleImpl[48], scheduleImpl[25], scheduleImpl[8], new Object[1]);
                            Object[] objArr12 = new Object[1];
                            h(cArr2, length, (byte) (((ApplicationInfo) cls4.getMethod((String) r3[0], null).invoke(this, null)).targetSdkVersion - 4), objArr12);
                            String str4 = (String) objArr12[0];
                            char[] cArr3 = {31, '+', 17, '.', 23, 3};
                            try {
                                Object[] objArr13 = new Object[1];
                                j((byte) (-scheduleImpl[32]), (byte) (scheduleImpl[49] - 1), scheduleImpl[30], objArr13);
                                Class<?> cls5 = Class.forName((String) objArr13[0]);
                                j(scheduleImpl[48], scheduleImpl[25], scheduleImpl[8], new Object[1]);
                                Object[] objArr14 = new Object[1];
                                h(cArr3, ((ApplicationInfo) cls5.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 27, (byte) (super.getResources().getString(R.string.passkey_enrollment_faq).substring(10, 11).length() + 12), objArr14);
                                try {
                                    Object[] objArr15 = {baseContext, str, str2, str3, str4, true, (String) objArr14[0], 995651014};
                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                    if (obj2 == null) {
                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ExpandableListView.getPackedPositionChild(0L), 18 - (Process.myTid() >> 22), (char) Color.red(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                    }
                                    ((Method) obj2).invoke(invoke, objArr15);
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
                Object[] objArr16 = new Object[1];
                j(scheduleImpl[25], (byte) (-scheduleImpl[31]), scheduleImpl[25], objArr16);
                Class<?> cls6 = Class.forName((String) objArr16[0]);
                Object[] objArr17 = new Object[1];
                j(scheduleImpl[9], (short) 30, scheduleImpl[25], objArr17);
                try {
                    Object[] objArr18 = {Integer.valueOf(((Integer) cls6.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 493, ExpandableListView.getPackedPositionChild(0L) + 5, (char) (Process.getGidForName("") + 1));
                        Object[] objArr19 = new Object[1];
                        k((byte) ($$g[47] - 1), (byte) (-$$g[53]), (byte) (-$$g[9]), objArr19);
                        obj3 = cls7.getMethod((String) objArr19[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr20 = (Object[]) ((Method) obj3).invoke(null, objArr18);
                    int i = ((int[]) objArr20[1])[0];
                    if (((int[]) objArr20[0])[0] != i) {
                        long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getTouchSlop() >> 8), ExpandableListView.getPackedPositionGroup(0L) + 35, (char) TextUtils.indexOf("", ""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr21 = {-470102771, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + 911, 19 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) (Process.getGidForName("") + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr21);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onPause() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr = new Object[1];
                h(new char[]{24, '%', '!', 28, '(', 16, 31, '.', JSONLexer.EOI, ',', '0', '.', 29, Typography.quote, '\f', 14, '/', 18, 14, 7, 17, '\n', 30, 20, 25, 30}, getPackageName().length() + 19, (byte) (90 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                h(new char[]{'(', 19, 13833, 13833, 17, '%', 14, '#', 13835, 13835, '\f', 20, 30, JSONLexer.EOI, '\f', 14, Typography.amp, '\''}, super.getResources().getString(R.string.help_button).substring(0, 11).codePointAt(7) - 98, (byte) (super.getResources().getString(R.string.leaderboard_above_you).substring(0, 3).length() + 30), objArr2);
                baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr3 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776305) - Color.rgb(0, 0, 0), 18 - (ViewConfiguration.getEdgeSlop() >> 16), (char) TextUtils.indexOf("", "", 0, 0))).getMethod("MyBillsEntityDataFactory", Context.class);
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

        @Override // com.alibaba.griver.core.ui.activity.GriverBaseActivity.Lite, com.alibaba.griver.core.ui.activity.GriverBaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onResume() {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr = new Object[1];
                h(new char[]{24, '%', '!', 28, '(', 16, 31, '.', JSONLexer.EOI, ',', '0', '.', 29, Typography.quote, '\f', 14, '/', 18, 14, 7, 17, '\n', 30, 20, 25, 30}, KeyEvent.getDeadChar(0, 0) + 26, (byte) (88 - TextUtils.lastIndexOf("", '0')), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                h(new char[]{'(', 19, 13833, 13833, 17, '%', 14, '#', 13835, 13835, '\f', 20, 30, JSONLexer.EOI, '\f', 14, Typography.amp, '\''}, View.MeasureSpec.getMode(0) + 18, (byte) (33 - KeyEvent.normalizeMetaState(0)), objArr2);
                baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myPid() >> 22) + PDF417Common.NUMBER_OF_CODEWORDS, Gravity.getAbsoluteGravity(0, 0) + 35, (char) Color.alpha(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr3 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0', 0), 18 - TextUtils.getCapsMode("", 0, 0), (char) Color.blue(0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

        private static void h(char[] cArr, int i, byte b, Object[] objArr) {
            int i2;
            getCallingPid getcallingpid = new getCallingPid();
            char[] cArr2 = lookAheadTest;
            if (cArr2 != null) {
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                for (int i3 = 0; i3 < length; i3++) {
                    cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
                }
                cArr2 = cArr3;
            }
            char c = (char) ((-1549216646985767851L) ^ getErrorConfigVersion);
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
}
