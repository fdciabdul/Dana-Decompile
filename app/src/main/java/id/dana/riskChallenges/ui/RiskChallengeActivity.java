package id.dana.riskChallenges.ui;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
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
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentResultListener;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.riskChallenges.databinding.ActivityRiskChallengeBinding;
import id.dana.riskChallenges.ui.createpin.CreatePinStateManager;
import id.dana.riskChallenges.ui.danaprotection.ActivityVerificationStateManager;
import id.dana.riskChallenges.ui.passkey.launcher.authentication.LoginPasskeyStateManager;
import id.dana.riskChallenges.ui.passkey.launcher.enrollment.EnrollPasskeyStateManager;
import id.dana.riskChallenges.ui.passkey.launcher.unlink.UnlinkPasskeyStateManager;
import id.dana.riskChallenges.ui.resetpin.ResetPinStateManager;
import id.dana.riskChallenges.ui.resetpin.model.ResetPinModel;
import id.dana.riskChallenges.ui.resetpin.model.UseCaseStrategy;
import id.dana.riskChallenges.ui.util.StrategyKey;
import id.dana.riskChallenges.ui.util.model.BasicRiskChallengesModel;
import id.dana.riskChallenges.ui.util.statemanager.ChallengeState;
import id.dana.riskChallenges.ui.util.statemanager.RiskChallengeStateFactory;
import id.dana.riskChallenges.ui.util.uicomponent.UiComponent;
import id.dana.riskChallenges.ui.verifypin.VerifyPinStateManager;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.whenAvailable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001b\u0010\u0011\u001a\u00020\f8CX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/riskChallenges/ui/RiskChallengeActivity;", "Lid/dana/core/ui/BaseViewBindingActivity;", "Lid/dana/riskChallenges/databinding/ActivityRiskChallengeBinding;", "inflateViewBinding", "()Lid/dana/riskChallenges/databinding/ActivityRiskChallengeBinding;", "", IAPSyncCommand.COMMAND_INIT, "()V", "Lid/dana/riskChallenges/ui/util/statemanager/ChallengeState;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/riskChallenges/ui/util/statemanager/ChallengeState;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/riskChallenges/ui/util/statemanager/RiskChallengeStateFactory;", "getErrorConfigVersion", "Lkotlin/Lazy;", "getStateFactory", "()Lid/dana/riskChallenges/ui/util/statemanager/RiskChallengeStateFactory;", "stateFactory", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "lookAheadTest", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RiskChallengeActivity extends BaseViewBindingActivity<ActivityRiskChallengeBinding> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private ChallengeState BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy stateFactory = LazyKt.lazy(new Function0<RiskChallengeStateFactory>() { // from class: id.dana.riskChallenges.ui.RiskChallengeActivity$stateFactory$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final RiskChallengeStateFactory invoke() {
            return new RiskChallengeStateFactory(RiskChallengeActivity.this);
        }
    });

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private UiComponent KClassImpl$Data$declaredNonStaticMembers$2;
    public static final byte[] $$a = {107, 3, 14, 112, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 84;
    public static final byte[] PlaceComponentResult = {61, 16, -46, 32, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int getAuthRequestContext = 62;
    private static char[] scheduleImpl = {62255, 22745, 42200, 61655, 23749, 43258, 62716, 16559, 44263, 63743, 17540, 37075, 64675, 18568, 38052, 57520, 19624, 39086, 58552, 12364, 40046, 59467, 13402, 32884, 60535, 14459, 45222, 6985, 59205, 45916, 8004, 60278, 46951, 843, 61309, 47988, 1811, 54047, 48906, 2817, 55087, 41787, 3898, 56098, 62255, 22745, 42200, 61655, 23749, 43258, 62716, 16559, 44265, 63740, 17626, 37037, 64656, 18564, 38067, 57532, 19629, 39092, 62243, 22734, 42217, 61644, 23758, 62329, 22740, 42122, 61597, 23706, 43255, 62625, 16569, 44209, 63722, 17559, 37019, 64647, 18649, 38113, 57583, 19695, 39158, 58618, 12372, 40030, 59456, 13387, 32807, 60530, 14380, 33852, 53353, 15424, 34847, 54273, 8204, 35927, 55393, 9326, 28796, 56364, 10634, 30080, 49553, 11665, 31177, 50592, 4523, 32224, 51640, 5574, 24988, 62255, 22658, 42122, 61633, 23756, 43178, 62632, 16569, 44258, 63724, 17613, 37064, 64646, 18650, 38113, 57581, 19692, 39157, 58538, 12292, 40030, 59410, 13342, 32802, 60448, 14461, 33853, 53352, 15434, 34847, 54354, 8283, 35853, 55347, 9320, 28797, 56361, 10704, 30088, 49554, 11667, 31135, 50673, 4524, 32225, 51644, 5569, 25038, 52685, 6612, 26075, 45548, 7651, 27124, 46584, 256, 27910, 47374, 1351, 20815, 48419, 2339, 21860, 41274, 15576, 38690, 27517, 16227, 37687, 26368, 15118, 36625, 25370, 14099, 35688, 24424, 13175, 34684, 23364, 12106, 33563, 22278, 11100, 65525, 21420, 10213, 64493, 20358, 9093, 63453, 19353, 8081, 62384, 18361, 7155, 61358, 17405, 6039, 60362, 49113, 5004, 58912, 47658, 3645, 57914, 46701, 2561, 56845, 45598, 1567, 55861, 44607, 572, 54906, 43563, 32276, 53836, 42582, 31242, 52896, 41637, 30382, 51897, 40639, 29392, 50826, 39569, 28308, 47683, 4518, 60845, 47536, 5564, 57804, 48594, 2507, 58759, 45451, 3583, 55801, 46505, 506, 56797, 43470, 1502, 53699, 44509, 31027, 54590, 41269, 32057, 51546, 42260, 28943, 52480, 39194, 30067, 49517, 40308, 27001, 50538, 37184, 27996, 14606, 38220, 24761, 15536, 35051, 25762, 12474, 35992, 22743, 13454, 32896, 23794, 10489, 34024, 20726, 11430, 63686, 21645, 8329, 64712, 18466, 9270, 61492, 19509, 6203, 26155, 52677, 12756, 26071, 51652, 15870};
    private static long NetworkUserEntityData$$ExternalSyntheticLambda2 = 8152005891243727031L;

    /* JADX WARN: Removed duplicated region for block: B:20:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0025 -> B:23:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = 106 - r7
            byte[] r0 = id.dana.riskChallenges.ui.RiskChallengeActivity.PlaceComponentResult
            int r6 = 23 - r6
            int r8 = r8 + 4
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
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
            int r8 = r8 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            int r3 = r3 + 1
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
            int r7 = r7 + r8
            int r7 = r7 + (-4)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.riskChallenges.ui.RiskChallengeActivity.a(byte, short, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002a -> B:23:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r7, short r8, int r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 + 4
            int r8 = r8 * 3
            int r8 = r8 + 21
            byte[] r0 = id.dana.riskChallenges.ui.RiskChallengeActivity.$$a
            int r7 = r7 * 2
            int r7 = r7 + 75
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L33
        L17:
            r3 = 0
        L18:
            r6 = r9
            r9 = r7
            r7 = r6
            byte r4 = (byte) r9
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r8) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            r3 = r0[r7]
            r6 = r9
            r9 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L33:
            int r7 = -r7
            int r9 = r9 + 1
            int r10 = r10 + r7
            int r7 = r10 + (-7)
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.riskChallenges.ui.RiskChallengeActivity.c(int, short, int, java.lang.Object[]):void");
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        b(18 - TextUtils.indexOf("", ""), TextUtils.indexOf("", "") + 44, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(KeyEvent.keyCodeFromString("") + 5, 62 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getTapTimeout() >> 16), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", ""), 34 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 49, 67 - View.resolveSizeAndState(0, 0, 0), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b((ViewConfiguration.getWindowTouchSlop() >> 8) + 64, 115 - KeyEvent.normalizeMetaState(0), (char) (AndroidCharacter.getMirror('0') - '0'), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 63, (ViewConfiguration.getJumpTapTimeout() >> 16) + 179, (char) ((-16724060) - Color.rgb(0, 0, 0)), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 60, 243 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (TextUtils.lastIndexOf("", '0', 0) + 18790), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b((ViewConfiguration.getTouchSlop() >> 8) + 6, 303 - View.combineMeasuredStates(0, 0), (char) (38236 - View.resolveSize(0, 0)), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 911, 17 - MotionEvent.axisFromString(""), (char) KeyEvent.normalizeMetaState(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = PlaceComponentResult[30];
                byte b2 = PlaceComponentResult[25];
                Object[] objArr13 = new Object[1];
                a(b, b2, (byte) (b2 | 36), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b3 = PlaceComponentResult[30];
                byte b4 = PlaceComponentResult[9];
                Object[] objArr14 = new Object[1];
                a(b3, b4, (byte) (b4 | Ascii.DC4), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - View.MeasureSpec.getSize(0), (ViewConfiguration.getEdgeSlop() >> 16) + 3, (char) KeyEvent.normalizeMetaState(0));
                        byte b5 = $$a[47];
                        byte b6 = b5;
                        Object[] objArr16 = new Object[1];
                        c(b5, b6, (byte) (b6 - 1), objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 800, 15 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - Color.argb(0, 0, 0, 0), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 14, (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + 816, (ViewConfiguration.getJumpTapTimeout() >> 16) + 29, (char) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - TextUtils.lastIndexOf("", '0', 0), TextUtils.getOffsetAfter("", 0) + 15, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r4 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, View.MeasureSpec.getMode(0) + 35, (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {1087156517, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - Process.getGidForName(""), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 17, (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b7 = PlaceComponentResult[30];
                byte b8 = PlaceComponentResult[25];
                Object[] objArr19 = new Object[1];
                a(b7, b8, (byte) (b8 | 36), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b9 = PlaceComponentResult[30];
                byte b10 = PlaceComponentResult[9];
                Object[] objArr20 = new Object[1];
                a(b9, b10, (byte) (b10 | Ascii.DC4), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + 61, 46 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) KeyEvent.getDeadChar(0, 0));
                        byte b11 = $$a[2];
                        byte b12 = (byte) ($$a[47] - 1);
                        Object[] objArr22 = new Object[1];
                        c(b11, b12, (byte) (b12 | Ascii.ETB), objArr22);
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
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - TextUtils.getTrimmedLength(""), (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {1087156517, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getWindowTouchSlop() >> 8), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 17, (char) Color.red(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b13 = PlaceComponentResult[30];
                byte b14 = PlaceComponentResult[25];
                Object[] objArr25 = new Object[1];
                a(b13, b14, (byte) (b14 | 36), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b15 = PlaceComponentResult[30];
                byte b16 = PlaceComponentResult[9];
                Object[] objArr26 = new Object[1];
                a(b15, b16, (byte) (b16 | Ascii.DC4), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(119 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (ViewConfiguration.getFadingEdgeLength() >> 16) + 3, (char) (TextUtils.lastIndexOf("", '0', 0) + 38969));
                        byte b17 = $$a[2];
                        byte b18 = (byte) ($$a[47] - 1);
                        Object[] objArr28 = new Object[1];
                        c(b17, b18, (byte) (b18 | Ascii.ETB), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getLongPressTimeout() >> 16), 35 - KeyEvent.keyCodeFromString(""), (char) View.combineMeasuredStates(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {1087156517, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.green(0), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 18, (char) TextUtils.indexOf("", ""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b19 = PlaceComponentResult[30];
                byte b20 = PlaceComponentResult[25];
                Object[] objArr31 = new Object[1];
                a(b19, b20, (byte) (b20 | 36), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b21 = PlaceComponentResult[30];
                byte b22 = PlaceComponentResult[9];
                Object[] objArr32 = new Object[1];
                a(b21, b22, (byte) (b22 | Ascii.DC4), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - (ViewConfiguration.getWindowTouchSlop() >> 8), Process.getGidForName("") + 4, (char) ExpandableListView.getPackedPositionGroup(0L));
                        Object[] objArr34 = new Object[1];
                        c((byte) ($$a[47] - 1), (byte) (-$$a[8]), (byte) (-$$a[53]), objArr34);
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
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 930, (ViewConfiguration.getFadingEdgeLength() >> 16) + 35, (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {1087156517, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 912, 18 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) TextUtils.getOffsetAfter("", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        int combineMeasuredStates = 18 - View.combineMeasuredStates(0, 0);
        int codePointAt = super.getResources().getString(R.string.nps_survey_title_suggestion).substring(0, 1).codePointAt(0) - 39;
        try {
            Object[] objArr2 = new Object[1];
            a(PlaceComponentResult[25], (byte) (-PlaceComponentResult[32]), PlaceComponentResult[7], objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            a(PlaceComponentResult[41], PlaceComponentResult[48], (byte) (-PlaceComponentResult[59]), new Object[1]);
            Object[] objArr3 = new Object[1];
            b(combineMeasuredStates, codePointAt, (char) (((ApplicationInfo) cls.getMethod((String) r3[0], null).invoke(this, null)).targetSdkVersion - 33), objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            int length = getPackageName().length() - 2;
            try {
                Object[] objArr4 = new Object[1];
                a(PlaceComponentResult[25], (byte) (-PlaceComponentResult[32]), PlaceComponentResult[7], objArr4);
                Class<?> cls3 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                a(PlaceComponentResult[41], PlaceComponentResult[48], (byte) (-PlaceComponentResult[59]), objArr5);
                Object[] objArr6 = new Object[1];
                b(length, ((ApplicationInfo) cls3.getMethod((String) objArr5[0], null).invoke(this, null)).targetSdkVersion + 29, (char) (super.getResources().getString(R.string.pin_regular_changes_dialog_title).substring(3, 4).codePointAt(0) - 98), objArr6);
                int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                if (intValue < 99000 || intValue > 99999) {
                    Context baseContext = getBaseContext();
                    if (baseContext == null) {
                        Object[] objArr7 = new Object[1];
                        b(26 - TextUtils.getOffsetBefore("", 0), TextUtils.lastIndexOf("", '0', 0) + 1, (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1), objArr7);
                        Class<?> cls4 = Class.forName((String) objArr7[0]);
                        Object[] objArr8 = new Object[1];
                        b(getPackageName().length() + 11, super.getResources().getString(R.string.tooltip_home_request_desc).substring(37, 38).codePointAt(0) - 90, (char) (getPackageName().codePointAt(5) + 17181), objArr8);
                        baseContext = (Context) cls4.getMethod((String) objArr8[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext != null) {
                        baseContext = baseContext.getApplicationContext();
                    }
                    if (baseContext != null) {
                        try {
                            Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj == null) {
                                obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), TextUtils.indexOf((CharSequence) "", '0') + 36, (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                            }
                            Object invoke = ((Method) obj).invoke(null, null);
                            int length2 = getPackageName().length() + 41;
                            try {
                                Object[] objArr9 = new Object[1];
                                a(PlaceComponentResult[25], (byte) (-PlaceComponentResult[32]), PlaceComponentResult[7], objArr9);
                                Class<?> cls5 = Class.forName((String) objArr9[0]);
                                Object[] objArr10 = new Object[1];
                                a(PlaceComponentResult[41], PlaceComponentResult[48], (byte) (-PlaceComponentResult[59]), objArr10);
                                Object[] objArr11 = new Object[1];
                                b(length2, ((ApplicationInfo) cls5.getMethod((String) objArr10[0], null).invoke(this, null)).targetSdkVersion + 34, (char) (TextUtils.indexOf((CharSequence) "", '0') + 1), objArr11);
                                String str = (String) objArr11[0];
                                Object[] objArr12 = new Object[1];
                                b(64 - Gravity.getAbsoluteGravity(0, 0), AndroidCharacter.getMirror('0') + 'C', (char) (super.getResources().getString(R.string.error_search_not_found_title).substring(17, 18).length() - 1), objArr12);
                                String str2 = (String) objArr12[0];
                                int indexOf = 63 - TextUtils.indexOf((CharSequence) "", '0', 0, 0);
                                try {
                                    Object[] objArr13 = new Object[1];
                                    a(PlaceComponentResult[25], (byte) (-PlaceComponentResult[32]), PlaceComponentResult[7], objArr13);
                                    Class<?> cls6 = Class.forName((String) objArr13[0]);
                                    Object[] objArr14 = new Object[1];
                                    a(PlaceComponentResult[41], PlaceComponentResult[48], (byte) (-PlaceComponentResult[59]), objArr14);
                                    int i = ((ApplicationInfo) cls6.getMethod((String) objArr14[0], null).invoke(this, null)).targetSdkVersion + 146;
                                    try {
                                        Object[] objArr15 = new Object[1];
                                        a(PlaceComponentResult[25], (byte) (-PlaceComponentResult[32]), PlaceComponentResult[7], objArr15);
                                        Class<?> cls7 = Class.forName((String) objArr15[0]);
                                        Object[] objArr16 = new Object[1];
                                        a(PlaceComponentResult[41], PlaceComponentResult[48], (byte) (-PlaceComponentResult[59]), objArr16);
                                        Object[] objArr17 = new Object[1];
                                        b(indexOf, i, (char) (((ApplicationInfo) cls7.getMethod((String) objArr16[0], null).invoke(this, null)).targetSdkVersion + 53123), objArr17);
                                        String str3 = (String) objArr17[0];
                                        int length3 = super.getResources().getString(R.string.widget_quick_action_pay_button).substring(1, 3).length() + 58;
                                        int codePointAt2 = super.getResources().getString(R.string.security_setting_question_state_on).substring(0, 2).codePointAt(1) + 133;
                                        try {
                                            Object[] objArr18 = new Object[1];
                                            a(PlaceComponentResult[25], (byte) (-PlaceComponentResult[32]), PlaceComponentResult[7], objArr18);
                                            Class<?> cls8 = Class.forName((String) objArr18[0]);
                                            Object[] objArr19 = new Object[1];
                                            a(PlaceComponentResult[41], PlaceComponentResult[48], (byte) (-PlaceComponentResult[59]), objArr19);
                                            Object[] objArr20 = new Object[1];
                                            b(length3, codePointAt2, (char) (((ApplicationInfo) cls8.getMethod((String) objArr19[0], null).invoke(this, null)).targetSdkVersion + 18756), objArr20);
                                            String str4 = (String) objArr20[0];
                                            int length4 = super.getResources().getString(R.string.default_mobile_recharge_promotion).substring(0, 1).length() + 5;
                                            try {
                                                Object[] objArr21 = new Object[1];
                                                a(PlaceComponentResult[25], (byte) (-PlaceComponentResult[32]), PlaceComponentResult[7], objArr21);
                                                Class<?> cls9 = Class.forName((String) objArr21[0]);
                                                Object[] objArr22 = new Object[1];
                                                a(PlaceComponentResult[41], PlaceComponentResult[48], (byte) (-PlaceComponentResult[59]), objArr22);
                                                Object[] objArr23 = new Object[1];
                                                b(length4, ((ApplicationInfo) cls9.getMethod((String) objArr22[0], null).invoke(this, null)).targetSdkVersion + 270, (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 38235), objArr23);
                                                try {
                                                    Object[] objArr24 = {baseContext, str, str2, str3, str4, true, (String) objArr23[0], 995651014};
                                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                                    if (obj2 == null) {
                                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + 911, 18 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                                    }
                                                    ((Method) obj2).invoke(invoke, objArr24);
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
                    byte b = PlaceComponentResult[30];
                    byte b2 = PlaceComponentResult[25];
                    Object[] objArr25 = new Object[1];
                    a(b, b2, (byte) (b2 | 36), objArr25);
                    Class<?> cls10 = Class.forName((String) objArr25[0]);
                    byte b3 = PlaceComponentResult[30];
                    byte b4 = PlaceComponentResult[9];
                    Object[] objArr26 = new Object[1];
                    a(b3, b4, (byte) (b4 | Ascii.DC4), objArr26);
                    try {
                        Object[] objArr27 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                        if (obj3 == null) {
                            Class cls11 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getEdgeSlop() >> 16), KeyEvent.getDeadChar(0, 0) + 4, (char) ExpandableListView.getPackedPositionType(0L));
                            Object[] objArr28 = new Object[1];
                            c((byte) ($$a[47] - 1), (byte) (-$$a[8]), (byte) (-$$a[53]), objArr28);
                            obj3 = cls11.getMethod((String) objArr28[0], Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                        }
                        Object[] objArr29 = (Object[]) ((Method) obj3).invoke(null, objArr27);
                        int i2 = ((int[]) objArr29[1])[0];
                        if (((int[]) objArr29[0])[0] != i2) {
                            long j = ((r2 ^ i2) & 4294967295L) | 42949672960L;
                            try {
                                Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj4 != null) {
                                    objArr = null;
                                } else {
                                    objArr = null;
                                    obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                }
                                Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                                try {
                                    Object[] objArr30 = {-782087854, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj5 == null) {
                                        obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + 912, TextUtils.lastIndexOf("", '0') + 19, (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                    }
                                    ((Method) obj5).invoke(invoke2, objArr30);
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
        } catch (Throwable th13) {
            Throwable cause13 = th13.getCause();
            if (cause13 == null) {
                throw th13;
            }
            throw cause13;
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                Object[] objArr = new Object[1];
                a(PlaceComponentResult[25], (byte) (-PlaceComponentResult[32]), PlaceComponentResult[7], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                a(PlaceComponentResult[41], PlaceComponentResult[48], (byte) (-PlaceComponentResult[59]), new Object[1]);
                Object[] objArr2 = new Object[1];
                b(((ApplicationInfo) cls.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 7, super.getResources().getString(R.string.error_select_own_number).substring(10, 11).codePointAt(0) - 32, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b(super.getResources().getString(R.string.promocode_bottomsheet_expired_title).substring(17, 18).length() + 17, 26 - View.MeasureSpec.getSize(0), (char) (getPackageName().length() + 17284), objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 18 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(super.getResources().getString(R.string.top_up_dialog_note_helper).substring(0, 6).length() + 20, getPackageName().codePointAt(1) - 100, (char) (super.getResources().getString(R.string.res_0x7f130f2f_networkuserentitydata_externalsyntheticlambda4).substring(13, 14).codePointAt(0) - 115), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b(View.combineMeasuredStates(0, 0) + 18, 25 - MotionEvent.axisFromString(""), (char) (getPackageName().length() + 17284), objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.red(0), 35 - (ViewConfiguration.getTapTimeout() >> 16), (char) Color.alpha(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 911, (KeyEvent.getMaxKeyCode() >> 16) + 18, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @JvmName(name = "getStateFactory")
    private final RiskChallengeStateFactory getStateFactory() {
        return (RiskChallengeStateFactory) this.stateFactory.getValue();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final ActivityRiskChallengeBinding inflateViewBinding() {
        ActivityRiskChallengeBinding MyBillsEntityDataFactory = ActivityRiskChallengeBinding.MyBillsEntityDataFactory(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void init() {
        Parcelable parcelable;
        LoginPasskeyStateManager authRequestContext;
        Object obj;
        Parcelable parcelable2;
        Object obj2;
        Object obj3;
        Object obj4;
        ResetPinStateManager resetPinStateManager;
        Object obj5;
        Object obj6;
        Parcelable parcelable3;
        Object obj7;
        setRequestedOrientation(Build.VERSION.SDK_INT == 26 ? -1 : 1);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) extras.getParcelable("KEY_UI_COMPONENT", UiComponent.class);
            } else {
                Parcelable parcelable4 = extras.getParcelable("KEY_UI_COMPONENT");
                if (!(parcelable4 instanceof UiComponent)) {
                    parcelable4 = null;
                }
                parcelable = (UiComponent) parcelable4;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (UiComponent) parcelable;
            RiskChallengeStateFactory stateFactory = getStateFactory();
            Intrinsics.checkNotNullParameter(extras, "");
            String string = extras.getString("KEY_STRATEGY");
            if (string != null) {
                switch (string.hashCode()) {
                    case -1263778231:
                        if (string.equals(StrategyKey.PASSKEY_AUTHENTICATION)) {
                            LoginPasskeyStateManager.Companion companion = LoginPasskeyStateManager.INSTANCE;
                            authRequestContext = LoginPasskeyStateManager.Companion.getAuthRequestContext(stateFactory.KClassImpl$Data$declaredNonStaticMembers$2, extras);
                            this.BuiltInFictitiousFunctionClassFactory = authRequestContext;
                            break;
                        }
                        break;
                    case -981754140:
                        if (string.equals(StrategyKey.PASSKEY_UNLINK)) {
                            UnlinkPasskeyStateManager.Companion companion2 = UnlinkPasskeyStateManager.INSTANCE;
                            authRequestContext = UnlinkPasskeyStateManager.Companion.MyBillsEntityDataFactory(stateFactory.KClassImpl$Data$declaredNonStaticMembers$2, extras);
                            this.BuiltInFictitiousFunctionClassFactory = authRequestContext;
                            break;
                        }
                        break;
                    case -546636625:
                        if (string.equals(StrategyKey.VERIFY_PIN)) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                obj = (Parcelable) extras.getParcelable("KEY_UI_COMPONENT", UiComponent.class);
                            } else {
                                Object parcelable5 = extras.getParcelable("KEY_UI_COMPONENT");
                                if (!(parcelable5 instanceof UiComponent)) {
                                    parcelable5 = null;
                                }
                                obj = (Parcelable) ((UiComponent) parcelable5);
                            }
                            UiComponent uiComponent = (UiComponent) obj;
                            if (Build.VERSION.SDK_INT >= 33) {
                                parcelable2 = (Parcelable) extras.getParcelable("KEY_USE_CASE_STRATEGY", UseCaseStrategy.class);
                            } else {
                                Object parcelable6 = extras.getParcelable("KEY_USE_CASE_STRATEGY");
                                parcelable2 = (UseCaseStrategy) (parcelable6 instanceof UseCaseStrategy ? parcelable6 : null);
                            }
                            UseCaseStrategy useCaseStrategy = (UseCaseStrategy) parcelable2;
                            String string2 = extras.getString("KEY_SCENE");
                            String string3 = extras.getString("KEY_SOURCE");
                            authRequestContext = new VerifyPinStateManager(stateFactory.KClassImpl$Data$declaredNonStaticMembers$2, useCaseStrategy == null ? new UseCaseStrategy("", null, null, 6, null) : useCaseStrategy, string2 == null ? "" : string2, uiComponent, string3 == null ? "" : string3);
                            this.BuiltInFictitiousFunctionClassFactory = authRequestContext;
                            break;
                        }
                        break;
                    case 225579210:
                        if (string.equals(StrategyKey.PASSKEY_REGISTRATION)) {
                            EnrollPasskeyStateManager.Companion companion3 = EnrollPasskeyStateManager.INSTANCE;
                            authRequestContext = EnrollPasskeyStateManager.Companion.KClassImpl$Data$declaredNonStaticMembers$2(stateFactory.KClassImpl$Data$declaredNonStaticMembers$2, extras);
                            this.BuiltInFictitiousFunctionClassFactory = authRequestContext;
                            break;
                        }
                        break;
                    case 516708965:
                        if (string.equals("RESET_PIN")) {
                            String string4 = extras.getString("KEY_PHONE_NUMBER");
                            if (Build.VERSION.SDK_INT >= 33) {
                                obj2 = (Parcelable) extras.getParcelable("KEY_UI_COMPONENT", UiComponent.class);
                            } else {
                                Object parcelable7 = extras.getParcelable("KEY_UI_COMPONENT");
                                if (!(parcelable7 instanceof UiComponent)) {
                                    parcelable7 = null;
                                }
                                obj2 = (Parcelable) ((UiComponent) parcelable7);
                            }
                            UiComponent uiComponent2 = (UiComponent) obj2;
                            if (Build.VERSION.SDK_INT >= 33) {
                                obj3 = (Parcelable) extras.getParcelable("KEY_DATA_RISK_CONSULT", ResetPinModel.class);
                            } else {
                                Object parcelable8 = extras.getParcelable("KEY_DATA_RISK_CONSULT");
                                if (!(parcelable8 instanceof ResetPinModel)) {
                                    parcelable8 = null;
                                }
                                obj3 = (Parcelable) ((ResetPinModel) parcelable8);
                            }
                            ResetPinModel resetPinModel = (ResetPinModel) obj3;
                            if (Build.VERSION.SDK_INT >= 33) {
                                obj4 = (Parcelable) extras.getParcelable("KEY_USE_CASE_STRATEGY", UseCaseStrategy.class);
                            } else {
                                Object parcelable9 = extras.getParcelable("KEY_USE_CASE_STRATEGY");
                                obj4 = (Parcelable) ((UseCaseStrategy) (parcelable9 instanceof UseCaseStrategy ? parcelable9 : null));
                            }
                            UseCaseStrategy useCaseStrategy2 = (UseCaseStrategy) obj4;
                            String string5 = extras.getString("KEY_SOURCE");
                            String string6 = extras.getString("KEY_PURPOSE");
                            if (resetPinModel != null) {
                                resetPinStateManager = new ResetPinStateManager(stateFactory.KClassImpl$Data$declaredNonStaticMembers$2, uiComponent2, resetPinModel, extras.getString("KEY_LOGIN_TYPE"), useCaseStrategy2, string4 == null ? "" : string4, null, string5 == null ? "" : string5, string6 == null ? "" : string6, 64, null);
                            } else {
                                resetPinStateManager = new ResetPinStateManager(stateFactory.KClassImpl$Data$declaredNonStaticMembers$2, uiComponent2, null, null, useCaseStrategy2, string4 == null ? "" : string4, ResetPinStateManager.ResetPinState.RiskReject.INSTANCE, string5 == null ? "" : string5, string6 == null ? "" : string6, 12, null);
                            }
                            authRequestContext = resetPinStateManager;
                            this.BuiltInFictitiousFunctionClassFactory = authRequestContext;
                            break;
                        }
                        break;
                    case 1535674857:
                        if (string.equals(StrategyKey.SUSPICIOUS_ACTIVITY_VERIFICATION)) {
                            String string7 = extras.getString("KEY_PHONE_NUMBER");
                            if (Build.VERSION.SDK_INT >= 33) {
                                obj5 = (Parcelable) extras.getParcelable("KEY_UI_COMPONENT", UiComponent.class);
                            } else {
                                Object parcelable10 = extras.getParcelable("KEY_UI_COMPONENT");
                                if (!(parcelable10 instanceof UiComponent)) {
                                    parcelable10 = null;
                                }
                                obj5 = (Parcelable) ((UiComponent) parcelable10);
                            }
                            UiComponent uiComponent3 = (UiComponent) obj5;
                            if (Build.VERSION.SDK_INT >= 33) {
                                obj6 = (Parcelable) extras.getParcelable("KEY_DATA_RISK_CONSULT", BasicRiskChallengesModel.class);
                            } else {
                                Object parcelable11 = extras.getParcelable("KEY_DATA_RISK_CONSULT");
                                obj6 = (Parcelable) ((BasicRiskChallengesModel) (parcelable11 instanceof BasicRiskChallengesModel ? parcelable11 : null));
                            }
                            BasicRiskChallengesModel basicRiskChallengesModel = (BasicRiskChallengesModel) obj6;
                            String string8 = extras.getString("KEY_SOURCE");
                            authRequestContext = new ActivityVerificationStateManager(stateFactory.KClassImpl$Data$declaredNonStaticMembers$2, uiComponent3, basicRiskChallengesModel, string7 == null ? "" : string7, string8 == null ? "" : string8);
                            this.BuiltInFictitiousFunctionClassFactory = authRequestContext;
                            break;
                        }
                        break;
                    case 1855593394:
                        if (string.equals(StrategyKey.CREATE_PIN)) {
                            String string9 = extras.getString("KEY_SECURITY_ID");
                            String string10 = extras.getString("KEY_RISK_TOKEN");
                            if (Build.VERSION.SDK_INT >= 33) {
                                parcelable3 = (Parcelable) extras.getParcelable("KEY_USE_CASE_STRATEGY", UseCaseStrategy.class);
                            } else {
                                Parcelable parcelable12 = extras.getParcelable("KEY_USE_CASE_STRATEGY");
                                if (!(parcelable12 instanceof UseCaseStrategy)) {
                                    parcelable12 = null;
                                }
                                parcelable3 = (UseCaseStrategy) parcelable12;
                            }
                            UseCaseStrategy useCaseStrategy3 = (UseCaseStrategy) parcelable3;
                            if (Build.VERSION.SDK_INT >= 33) {
                                obj7 = (Parcelable) extras.getParcelable("KEY_UI_COMPONENT", UiComponent.class);
                            } else {
                                Object parcelable13 = extras.getParcelable("KEY_UI_COMPONENT");
                                obj7 = (Parcelable) ((UiComponent) (parcelable13 instanceof UiComponent ? parcelable13 : null));
                            }
                            UiComponent uiComponent4 = (UiComponent) obj7;
                            String string11 = extras.getString("KEY_PHONE_NUMBER");
                            String string12 = extras.getString("KEY_SOURCE");
                            FragmentActivity fragmentActivity = stateFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                            String str = string11 == null ? "" : string11;
                            String str2 = string9 == null ? "" : string9;
                            String str3 = string10 == null ? "" : string10;
                            if (useCaseStrategy3 == null) {
                                useCaseStrategy3 = new UseCaseStrategy("", null, null, 6, null);
                            }
                            authRequestContext = new CreatePinStateManager(fragmentActivity, str, str3, str2, useCaseStrategy3, uiComponent4, string12 == null ? "" : string12);
                            this.BuiltInFictitiousFunctionClassFactory = authRequestContext;
                            break;
                        }
                        break;
                }
            }
            throw new NotImplementedError("RiskChallenge not implement");
        }
        getSupportFragmentManager().setFragmentResultListener("KEY_RISK_CHALLENGE_FRAGMENT", this, new FragmentResultListener() { // from class: id.dana.riskChallenges.ui.RiskChallengeActivity$$ExternalSyntheticLambda0
            @Override // androidx.fragment.app.FragmentResultListener
            public final void onFragmentResult(String str4, Bundle bundle) {
                RiskChallengeActivity.m2876init$lambda1(RiskChallengeActivity.this, str4, bundle);
            }
        });
    }

    /* renamed from: init$lambda-1 */
    public static final void m2876init$lambda1(RiskChallengeActivity riskChallengeActivity, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(riskChallengeActivity, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(bundle, "");
        ChallengeState challengeState = riskChallengeActivity.BuiltInFictitiousFunctionClassFactory;
        if (challengeState != null) {
            challengeState.onFragmentResult(str, bundle);
        }
    }

    private static void b(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i) {
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (scheduleImpl[whenavailable.BuiltInFictitiousFunctionClassFactory + i2] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ NetworkUserEntityData$$ExternalSyntheticLambda2))) ^ c;
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
