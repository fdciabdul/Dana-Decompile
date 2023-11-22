package id.dana.danapoly.ui.splash;

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
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.view.ComponentActivity;
import androidx.view.FlowExtKt;
import androidx.view.Lifecycle;
import androidx.view.LifecycleOwnerKt;
import androidx.view.ViewModelKt;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.view.viewmodel.CreationExtras;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.danapoly.databinding.ActivityDanapolySplashBinding;
import id.dana.danapoly.di.component.DanapolyComponent;
import id.dana.danapoly.di.provider.DanapolyComponentProvider;
import id.dana.danapoly.domain.config.model.PlayBoard;
import id.dana.danapoly.ui.board.DanapolyBoardTabActivity;
import id.dana.danapoly.ui.board.DanapolyNoEventActivity;
import id.dana.danapoly.ui.model.DanapolyDeeplinkModel;
import id.dana.danapoly.ui.model.PlayBoardModel;
import id.dana.danapoly.ui.model.mapper.PlayBoardModelMapperKt;
import id.dana.danapoly.ui.splash.viewmodel.DanapolyConfigUiState;
import id.dana.danapoly.ui.splash.viewmodel.DanapolyConfigViewModel;
import id.dana.domain.core.usecase.NoParams;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.whenAvailable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0018\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0013\u0010\u0010\u001a\u00020\rX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\u0012\u001a\u00020\u00118\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/danapoly/ui/splash/DanapolySplashActivity;", "Lid/dana/core/ui/BaseViewBindingActivity;", "Lid/dana/danapoly/databinding/ActivityDanapolySplashBinding;", "inflateViewBinding", "()Lid/dana/danapoly/databinding/ActivityDanapolySplashBinding;", "", IAPSyncCommand.COMMAND_INIT, "()V", "initComponent", "Lid/dana/danapoly/di/component/DanapolyComponent;", "PlaceComponentResult", "Lid/dana/danapoly/di/component/DanapolyComponent;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/danapoly/ui/splash/viewmodel/DanapolyConfigViewModel;", "scheduleImpl", "Lkotlin/Lazy;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/core/ui/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/core/ui/di/module/ViewModelFactory;", "getViewModelFactory", "()Lid/dana/core/ui/di/module/ViewModelFactory;", "setViewModelFactory", "(Lid/dana/core/ui/di/module/ViewModelFactory;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanapolySplashActivity extends BaseViewBindingActivity<ActivityDanapolySplashBinding> {
    public static final String BUNDLE_POP_UP = "bundle_prize";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static char[] getErrorConfigVersion;
    private static long lookAheadTest;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private DanapolyComponent BuiltInFictitiousFunctionClassFactory;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    public ViewModelFactory viewModelFactory;
    public static final byte[] $$a = {116, 44, -28, -115, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 31;
    public static final byte[] getAuthRequestContext = {105, Ascii.NAK, -43, 101, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 181;

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        INSTANCE = new Companion(null);
    }

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        getErrorConfigVersion = new char[]{62255, 57991, 53348, 51145, 46525, 43876, 39616, 35057, 32279, 28129, 17336, 12621, 8411, 5718, 1048, 64494, 59720, 57136, 52868, 48210, 37398, 33173, 30566, 25898, 21639, 19045, 62253, 58012, 53362, 51145, 46519, 43875, 39632, 34974, 32262, 28129, 17316, 12554, 8441, 5716, 1048, 64494, 59729, 57143, 33179, 36915, 41680, 46461, 50953, 55760, 59508, 64069, 3245, 8022, 12626, 17287, 21084, 25838, 30395, 35158, 39929, 44446, 14497, 10514, 7127, 3152, 32308, 62329, 57994, 53302, 51075, 46562, 43881, 39581, 35047, 32321, 28148, 17323, 12549, 8447, 5639, 1117, 64433, 59663, 57192, 52934, 48202, 37414, 33182, 30583, 25977, 21634, 18994, 14720, 12215, 7480, 3265, 58045, 53266, 51095, 46591, 43858, 39586, 34900, 32340, 28092, 17167, 12641, 8343, 5660, 1141, 64408, 59686, 57210, 52866, 62255, 58076, 53302, 51167, 46516, 43828, 39572, 35047, 32274, 28146, 17393, 12630, 8446, 5636, 1117, 64435, 59660, 57195, 52886, 48154, 37414, 33228, 30498, 25980, 21712, 19043, 14721, 12214, 7474, 3265, 58094, 53317, 51149, 46509, 43860, 39587, 34897, 32270, 28084, 17164, 12643, 8385, 5709, 1138, 64409, 59682, 57213, 52944, 48173, 37770, 33255, 30514, 26267, 21738, 19012, 14750, 12278, 7504, 3323, 57937, 53339, 51133, 46424, 43876, 61508, 57824, 54109, 50401, 46803, 43010, 39342, 35795, 32118, 28305, 16584, 12906, 9107, 5438, 1892, 63624, 60007, 56324, 52732, 49015, 37192, 33447, 29773, 26180, 22505, 18783, 15033, 11475, 7764, 4091, 57811, 54060, 50337, 46741, 43114, 39323, 35688, 32098, 28298, 16447, 12886, 9135, 5409, 1871, 63738, 59933, 56341, 52669, 48960, 37048, 33419, 29782, 26024, 22484, 18730, 15010, 11465, 7788, 3993, 57661, 54068, 50312, 46641, 43094, 62246, 58013, 53364, 51147, 46497, 43831, 39563, 35056, 32274, 28144, 17318, 12546, 8372, 5697, 1028, 64501, 59739, 57144, 52868, 48200, 37411, 33166, 30560, 25953, 21633, 19060, 14809, 12193, 7534, 3286, 58029, 53250, 51151, 46523, 43781, 39605, 34897, 32258, 28137, 17168, 12599, 8321, 5697, 1132, 64403, 59771, 57131, 52866, 48237, 37837, 33279, 30589, 26256, 21746, 18961, 14809, 12195, 7439, 3308, 57920, 50731, 55195, 58728, 62153, 32956, 40544};
        lookAheadTest = 6263587432846844649L;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 + 97
            int r6 = r6 + 4
            byte[] r0 = id.dana.danapoly.ui.splash.DanapolySplashActivity.getAuthRequestContext
            int r7 = 23 - r7
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L13
            r4 = r8
            r3 = 0
            r8 = r7
            goto L2a
        L13:
            r3 = 0
        L14:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r6 = r6 + 1
            if (r3 != r7) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L23:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r8
            r8 = r7
            r7 = r5
        L2a:
            int r7 = r7 + r4
            int r7 = r7 + (-4)
            r5 = r8
            r8 = r7
            r7 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danapoly.ui.splash.DanapolySplashActivity.a(int, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0030 -> B:11:0x003a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = 46 - r7
            byte[] r0 = id.dana.danapoly.ui.splash.DanapolySplashActivity.$$a
            int r8 = r8 * 2
            int r8 = 103 - r8
            int r6 = r6 * 3
            int r6 = 42 - r6
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r8 = r7
            r3 = r1
            r4 = 0
            r7 = r6
            r1 = r0
            r0 = r9
            r9 = r8
            goto L3a
        L1b:
            r3 = 0
            r5 = r8
            r8 = r7
            r7 = r5
        L1f:
            int r8 = r8 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L30
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L30:
            r3 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L3a:
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
            goto L1f
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danapoly.ui.splash.DanapolySplashActivity.c(int, byte, short, java.lang.Object[]):void");
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        b((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 19, 43 - ExpandableListView.getPackedPositionChild(0L), (char) (29364 - Color.alpha(0)), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(Gravity.getAbsoluteGravity(0, 0) + 5, 62 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 52099), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (Process.myPid() >> 22), KeyEvent.keyCodeFromString("") + 35, (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 47, 's' - AndroidCharacter.getMirror('0'), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(64 - View.resolveSize(0, 0), (ViewConfiguration.getEdgeSlop() >> 16) + 115, (char) ((-1) - Process.getGidForName("")), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 64, 179 - Color.green(0), (char) ((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 824), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(Color.rgb(0, 0, 0) + 16777276, 243 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b((Process.myPid() >> 22) + 6, 304 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) (13659 - ExpandableListView.getPackedPositionChild(0L)), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 911, (ViewConfiguration.getScrollBarSize() >> 8) + 18, (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                a((byte) (KClassImpl$Data$declaredNonStaticMembers$2 & 110), (byte) (-getAuthRequestContext[30]), getAuthRequestContext[32], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = getAuthRequestContext[1];
                byte b2 = (byte) (-getAuthRequestContext[30]);
                Object[] objArr14 = new Object[1];
                a(b, b2, (byte) (b2 + 1), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - View.combineMeasuredStates(0, 0), 3 - TextUtils.getCapsMode("", 0, 0), (char) ((-1) - Process.getGidForName("")));
                        Object[] objArr16 = new Object[1];
                        c($$a[68], (byte) (-$$a[53]), (byte) (-$$a[12]), objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + 800, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 14, (char) ((-1) - ImageFormat.getBitsPerPixel(0)))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + 800, 15 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 28, (char) (TextUtils.getTrimmedLength("") + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 16, (char) (ViewConfiguration.getFadingEdgeLength() >> 16)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getTapTimeout() >> 16), 35 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) Drawable.resolveOpacity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {679256653, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.blue(0), 18 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((byte) (KClassImpl$Data$declaredNonStaticMembers$2 & 110), (byte) (-getAuthRequestContext[30]), getAuthRequestContext[32], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b3 = getAuthRequestContext[1];
                byte b4 = (byte) (-getAuthRequestContext[30]);
                Object[] objArr20 = new Object[1];
                a(b3, b4, (byte) (b4 + 1), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 61, (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 46, (char) (ViewConfiguration.getTapTimeout() >> 16));
                        Object[] objArr22 = new Object[1];
                        c((byte) (-$$a[8]), $$a[20], (byte) ($$a[47] - 1), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) ((-1) - Process.getGidForName("")))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {679256653, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0) + 911, 17 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((byte) (KClassImpl$Data$declaredNonStaticMembers$2 & 110), (byte) (-getAuthRequestContext[30]), getAuthRequestContext[32], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b5 = getAuthRequestContext[1];
                byte b6 = (byte) (-getAuthRequestContext[30]);
                Object[] objArr26 = new Object[1];
                a(b5, b6, (byte) (b6 + 1), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + 118, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 3, (char) (TextUtils.getOffsetAfter("", 0) + 38968));
                        Object[] objArr28 = new Object[1];
                        c((byte) (-$$a[8]), $$a[20], (byte) ($$a[47] - 1), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getOffsetAfter("", 0), KeyEvent.getDeadChar(0, 0) + 35, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {679256653, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - ExpandableListView.getPackedPositionType(0L), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 17, (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((byte) (KClassImpl$Data$declaredNonStaticMembers$2 & 110), (byte) (-getAuthRequestContext[30]), getAuthRequestContext[32], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b7 = getAuthRequestContext[1];
                byte b8 = (byte) (-getAuthRequestContext[30]);
                Object[] objArr32 = new Object[1];
                a(b7, b8, (byte) (b8 + 1), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), 3 - View.MeasureSpec.getSize(0), (char) (ViewConfiguration.getFadingEdgeLength() >> 16));
                        byte b9 = (byte) ($$a[47] - 1);
                        Object[] objArr34 = new Object[1];
                        c(b9, b9, (byte) (-$$a[9]), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + PDF417Common.NUMBER_OF_CODEWORDS, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 34, (char) TextUtils.getOffsetBefore("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {679256653, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + 912, 18 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) TextUtils.getCapsMode("", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        try {
            byte b = getAuthRequestContext[9];
            byte b2 = getAuthRequestContext[25];
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            a(getAuthRequestContext[59], getAuthRequestContext[27], (byte) (-getAuthRequestContext[5]), new Object[1]);
            Object[] objArr2 = new Object[1];
            b(((ApplicationInfo) cls.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 15, 43 - ExpandableListView.getPackedPositionChild(0L), (char) (getPackageName().length() + 29357), objArr2);
            Class<?> cls2 = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            b(getPackageName().length() - 2, getPackageName().codePointAt(3) - 38, (char) (52098 - (ViewConfiguration.getJumpTapTimeout() >> 16)), objArr3);
            int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr4 = new Object[1];
                    b(super.getResources().getString(R.string.res_0x7f130456_networkuserentitydata_externalsyntheticlambda1).substring(1, 3).length() + 24, super.getResources().getString(R.string.topup_and_pay_amount_monthly_limit_error_message).substring(9, 10).codePointAt(0) - 97, (char) (super.getResources().getString(R.string.citcall_wrong_otp_message).substring(27, 28).length() - 1), objArr4);
                    Class<?> cls3 = Class.forName((String) objArr4[0]);
                    try {
                        byte b3 = getAuthRequestContext[9];
                        byte b4 = getAuthRequestContext[25];
                        Object[] objArr5 = new Object[1];
                        a(b3, b4, b4, objArr5);
                        Class<?> cls4 = Class.forName((String) objArr5[0]);
                        a(getAuthRequestContext[59], getAuthRequestContext[27], (byte) (-getAuthRequestContext[5]), new Object[1]);
                        Object[] objArr6 = new Object[1];
                        b(((ApplicationInfo) cls4.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 15, 25 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1), objArr6);
                        baseContext = (Context) cls3.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
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
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (ViewConfiguration.getLongPressTimeout() >> 16) + 35, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        b(super.getResources().getString(R.string.card_list_empty_desc).substring(19, 21).length() + 46, Gravity.getAbsoluteGravity(0, 0) + 67, (char) View.getDefaultSize(0, 0), objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        b(getPackageName().codePointAt(4) - 33, (ViewConfiguration.getPressedStateDuration() >> 16) + 115, (char) (getPackageName().length() - 7), objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        b(super.getResources().getString(R.string.modify_group_photo_bottomsheet_description).substring(10, 11).length() + 63, super.getResources().getString(R.string.text_desc_landing_second_point).substring(34, 35).codePointAt(0) + 78, (char) (super.getResources().getString(R.string.sendmoney_upgrade_kyc_dialog_description).substring(33, 35).length() + 822), objArr9);
                        String str3 = (String) objArr9[0];
                        try {
                            byte b5 = getAuthRequestContext[9];
                            byte b6 = getAuthRequestContext[25];
                            Object[] objArr10 = new Object[1];
                            a(b5, b6, b6, objArr10);
                            Class<?> cls5 = Class.forName((String) objArr10[0]);
                            Object[] objArr11 = new Object[1];
                            a(getAuthRequestContext[59], getAuthRequestContext[27], (byte) (-getAuthRequestContext[5]), objArr11);
                            Object[] objArr12 = new Object[1];
                            b(((ApplicationInfo) cls5.getMethod((String) objArr11[0], null).invoke(this, null)).targetSdkVersion + 27, super.getResources().getString(R.string.loading_info_text_preprocessing).substring(1, 2).codePointAt(0) + 142, (char) (getPackageName().length() - 7), objArr12);
                            String str4 = (String) objArr12[0];
                            Object[] objArr13 = new Object[1];
                            b(super.getResources().getString(R.string.my_bills_intro_second_content_description).substring(43, 45).length() + 4, super.getResources().getString(R.string.promo_code).substring(7, 8).length() + 302, (char) (super.getResources().getString(R.string.msg_registration_complete).substring(5, 6).length() + 13659), objArr13);
                            try {
                                Object[] objArr14 = {baseContext, str, str2, str3, str4, true, (String) objArr13[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), Gravity.getAbsoluteGravity(0, 0) + 18, (char) (Process.myPid() >> 22))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                a((byte) (KClassImpl$Data$declaredNonStaticMembers$2 & 110), (byte) (-getAuthRequestContext[30]), getAuthRequestContext[32], objArr15);
                Class<?> cls6 = Class.forName((String) objArr15[0]);
                byte b7 = getAuthRequestContext[1];
                byte b8 = (byte) (-getAuthRequestContext[30]);
                Object[] objArr16 = new Object[1];
                a(b7, b8, (byte) (b8 + 1), objArr16);
                try {
                    Object[] objArr17 = {Integer.valueOf(((Integer) cls6.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 493, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 4, (char) KeyEvent.getDeadChar(0, 0));
                        byte b9 = (byte) ($$a[47] - 1);
                        Object[] objArr18 = new Object[1];
                        c(b9, b9, (byte) (-$$a[9]), objArr18);
                        obj3 = cls7.getMethod((String) objArr18[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr19 = (Object[]) ((Method) obj3).invoke(null, objArr17);
                    int i = ((int[]) objArr19[1])[0];
                    if (((int[]) objArr19[0])[0] != i) {
                        long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getScrollBarSize() >> 8), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(null, null);
                            try {
                                Object[] objArr20 = {-1863157286, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 911, 18 - ((Process.getThreadPriority(0) + 20) >> 6), (char) KeyEvent.keyCodeFromString(""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                byte b = getAuthRequestContext[9];
                byte b2 = getAuthRequestContext[25];
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                a(getAuthRequestContext[59], getAuthRequestContext[27], (byte) (-getAuthRequestContext[5]), objArr2);
                int i = ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion - 7;
                int codePointAt = super.getResources().getString(R.string.card_binding_onboarding_title).substring(1, 2).codePointAt(0) - 97;
                try {
                    byte b3 = getAuthRequestContext[9];
                    byte b4 = getAuthRequestContext[25];
                    Object[] objArr3 = new Object[1];
                    a(b3, b4, b4, objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    a(getAuthRequestContext[59], getAuthRequestContext[27], (byte) (-getAuthRequestContext[5]), new Object[1]);
                    Object[] objArr4 = new Object[1];
                    b(i, codePointAt, (char) (((ApplicationInfo) cls2.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 33), objArr4);
                    Class<?> cls3 = Class.forName((String) objArr4[0]);
                    try {
                        byte b5 = getAuthRequestContext[9];
                        byte b6 = getAuthRequestContext[25];
                        Object[] objArr5 = new Object[1];
                        a(b5, b6, b6, objArr5);
                        Class<?> cls4 = Class.forName((String) objArr5[0]);
                        a(getAuthRequestContext[59], getAuthRequestContext[27], (byte) (-getAuthRequestContext[5]), new Object[1]);
                        Object[] objArr6 = new Object[1];
                        b(((ApplicationInfo) cls4.getMethod((String) r10[0], null).invoke(this, null)).targetSdkVersion - 15, 27 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (getPackageName().length() - 7), objArr6);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 930, ((Process.getThreadPriority(0) + 20) >> 6) + 35, (char) TextUtils.indexOf("", "", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr7 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getFadingEdgeLength() >> 16), ExpandableListView.getPackedPositionGroup(0L) + 18, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(26 - TextUtils.indexOf("", "", 0), getPackageName().length() - 7, (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b(super.getResources().getString(R.string.image_capture_upload_photo_btn_label).substring(0, 6).codePointAt(4) - 47, (ViewConfiguration.getEdgeSlop() >> 16) + 26, (char) TextUtils.getTrimmedLength(""), objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + PDF417Common.NUMBER_OF_CODEWORDS, View.resolveSize(0, 0) + 35, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + 911, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 18, (char) Color.blue(0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    public DanapolySplashActivity() {
        final DanapolySplashActivity danapolySplashActivity = this;
        final Function0 function0 = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DanapolyConfigViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.danapoly.ui.splash.DanapolySplashActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ComponentActivity.this.getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: id.dana.danapoly.ui.splash.DanapolySplashActivity$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return DanapolySplashActivity.this.getViewModelFactory();
            }
        }, new Function0<CreationExtras>() { // from class: id.dana.danapoly.ui.splash.DanapolySplashActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = Function0.this;
                if (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) {
                    CreationExtras defaultViewModelCreationExtras = danapolySplashActivity.getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "");
                    return defaultViewModelCreationExtras;
                }
                return creationExtras;
            }
        });
    }

    @JvmName(name = "getViewModelFactory")
    public final ViewModelFactory getViewModelFactory() {
        ViewModelFactory viewModelFactory = this.viewModelFactory;
        if (viewModelFactory != null) {
            return viewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setViewModelFactory")
    public final void setViewModelFactory(ViewModelFactory viewModelFactory) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "");
        this.viewModelFactory = viewModelFactory;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final ActivityDanapolySplashBinding inflateViewBinding() {
        ActivityDanapolySplashBinding KClassImpl$Data$declaredNonStaticMembers$22 = ActivityDanapolySplashBinding.KClassImpl$Data$declaredNonStaticMembers$2(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$22, "");
        return KClassImpl$Data$declaredNonStaticMembers$22;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void init() {
        overridePendingTransition(id.dana.danapoly.R.anim.PlaceComponentResult_res_0x7f01002d, id.dana.danapoly.R.anim.getAuthRequestContext_res_0x7f01002f);
        StateFlow<DanapolyConfigUiState> stateFlow = ((DanapolyConfigViewModel) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).MyBillsEntityDataFactory;
        Lifecycle lifecycle = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "");
        FlowKt.launchIn(FlowKt.onEach(FlowExtKt.PlaceComponentResult(stateFlow, lifecycle), new DanapolySplashActivity$initViewModelState$1(this, null)), LifecycleOwnerKt.PlaceComponentResult(this));
        DanapolyDeeplinkModel danapolyDeeplinkModel = (DanapolyDeeplinkModel) getIntent().getParcelableExtra(BUNDLE_POP_UP);
        if (danapolyDeeplinkModel != null && danapolyDeeplinkModel.isWinnerNotification()) {
            DanapolyBoardTabActivity.Companion companion = DanapolyBoardTabActivity.INSTANCE;
            DanapolyBoardTabActivity.Companion.MyBillsEntityDataFactory(this, danapolyDeeplinkModel.getLastEventId());
            finish();
            return;
        }
        final DanapolyConfigViewModel danapolyConfigViewModel = (DanapolyConfigViewModel) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
        danapolyConfigViewModel.KClassImpl$Data$declaredNonStaticMembers$2.execute(NoParams.INSTANCE, new Function0<Unit>() { // from class: id.dana.danapoly.ui.splash.viewmodel.DanapolyConfigViewModel$getPlayBoard$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MutableStateFlow mutableStateFlow;
                Object value;
                mutableStateFlow = DanapolyConfigViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    DanapolyConfigUiState danapolyConfigUiState = (DanapolyConfigUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new DanapolyConfigUiState.DanapolyLoading(true)));
            }
        }, new Function1<PlayBoard, Unit>() { // from class: id.dana.danapoly.ui.splash.viewmodel.DanapolyConfigViewModel$getPlayBoard$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(PlayBoard playBoard) {
                invoke2(playBoard);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(PlayBoard playBoard) {
                MutableStateFlow mutableStateFlow;
                Object value;
                MutableStateFlow mutableStateFlow2;
                Object value2;
                Intrinsics.checkNotNullParameter(playBoard, "");
                if (playBoard.getEventId().length() > 0) {
                    mutableStateFlow2 = DanapolyConfigViewModel.this.getAuthRequestContext;
                    do {
                        value2 = mutableStateFlow2.getValue();
                        DanapolyConfigUiState danapolyConfigUiState = (DanapolyConfigUiState) value2;
                    } while (!mutableStateFlow2.compareAndSet(value2, new DanapolyConfigUiState.OnSuccessLoadConfiguration(playBoard.getEventId(), PlayBoardModelMapperKt.toPlayBoardModel(playBoard))));
                    return;
                }
                mutableStateFlow = DanapolyConfigViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    DanapolyConfigUiState danapolyConfigUiState2 = (DanapolyConfigUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new DanapolyConfigUiState.OnEventNotExist(playBoard.getLastActiveEventId())));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danapoly.ui.splash.viewmodel.DanapolyConfigViewModel$getPlayBoard$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(th, "");
                mutableStateFlow = DanapolyConfigViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    DanapolyConfigUiState danapolyConfigUiState = (DanapolyConfigUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new DanapolyConfigUiState.OnErrorLoadConfiguration(th)));
            }
        }, new Function0<Unit>() { // from class: id.dana.danapoly.ui.splash.viewmodel.DanapolyConfigViewModel$getPlayBoard$4
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MutableStateFlow mutableStateFlow;
                Object value;
                mutableStateFlow = DanapolyConfigViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    DanapolyConfigUiState danapolyConfigUiState = (DanapolyConfigUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new DanapolyConfigUiState.DanapolyLoading(false)));
            }
        }, ViewModelKt.PlaceComponentResult(danapolyConfigViewModel));
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void initComponent() {
        Context applicationContext = getApplicationContext();
        if (applicationContext != null) {
            DanapolyComponent MyBillsEntityDataFactory = ((DanapolyComponentProvider) applicationContext).provideDanapolyComponent().MyBillsEntityDataFactory();
            this.BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory;
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.danapoly.di.provider.DanapolyComponentProvider");
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/danapoly/ui/splash/DanapolySplashActivity$Companion;", "", "Landroid/content/Context;", "p0", "Lid/dana/danapoly/ui/model/DanapolyDeeplinkModel;", "p1", "", "PlaceComponentResult", "(Landroid/content/Context;Lid/dana/danapoly/ui/model/DanapolyDeeplinkModel;)V", "", "BUNDLE_POP_UP", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static void PlaceComponentResult(Context p0, DanapolyDeeplinkModel p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intent intent = new Intent(p0, DanapolySplashActivity.class);
            if (p1 != null) {
                intent.putExtra(DanapolySplashActivity.BUNDLE_POP_UP, p1);
            }
            p0.startActivity(intent);
        }
    }

    public static final /* synthetic */ void access$goToDanapolyBoard(DanapolySplashActivity danapolySplashActivity, PlayBoardModel playBoardModel) {
        DanapolyDeeplinkModel danapolyDeeplinkModel = (DanapolyDeeplinkModel) danapolySplashActivity.getIntent().getParcelableExtra(BUNDLE_POP_UP);
        DanapolyBoardTabActivity.Companion companion = DanapolyBoardTabActivity.INSTANCE;
        DanapolyBoardTabActivity.Companion.BuiltInFictitiousFunctionClassFactory(danapolySplashActivity, playBoardModel, danapolyDeeplinkModel);
        danapolySplashActivity.finish();
    }

    public static final /* synthetic */ void access$goToNoEventActivity(DanapolySplashActivity danapolySplashActivity, String str) {
        DanapolyNoEventActivity.Companion companion = DanapolyNoEventActivity.INSTANCE;
        DanapolyNoEventActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(danapolySplashActivity, str);
        danapolySplashActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void goToDanapolyBoard$default(DanapolySplashActivity danapolySplashActivity, PlayBoardModel playBoardModel, int i, Object obj) {
        if ((i & 1) != 0) {
            playBoardModel = null;
        }
        DanapolyDeeplinkModel danapolyDeeplinkModel = (DanapolyDeeplinkModel) danapolySplashActivity.getIntent().getParcelableExtra(BUNDLE_POP_UP);
        DanapolyBoardTabActivity.Companion companion = DanapolyBoardTabActivity.INSTANCE;
        DanapolyBoardTabActivity.Companion.BuiltInFictitiousFunctionClassFactory(danapolySplashActivity, playBoardModel, danapolyDeeplinkModel);
        danapolySplashActivity.finish();
    }

    private static void b(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i) {
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (getErrorConfigVersion[whenavailable.BuiltInFictitiousFunctionClassFactory + i2] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ lookAheadTest))) ^ c;
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
