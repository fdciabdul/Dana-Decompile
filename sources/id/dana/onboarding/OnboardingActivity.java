package id.dana.onboarding;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.net.Uri;
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
import android.widget.FrameLayout;
import androidx.view.LifecycleOwner;
import androidx.view.Observer;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import com.zhuinden.simplestack.Backstack;
import dagger.Lazy;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.animation.tab.ConnectivitySnackbarManager;
import id.dana.base.Key;
import id.dana.base.KeyBaseActivity;
import id.dana.base.MenuItemFacade;
import id.dana.biometric.domain.model.RiskActionConstant;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.core.ui.util.connectivity.ConnectivityMonitor;
import id.dana.core.ui.util.connectivity.ConnectivityMonitorKt;
import id.dana.core.ui.util.connectivity.InternetConnectionStatus;
import id.dana.core.ui.util.connectivity.mapper.ConnectivityModelMapperKt;
import id.dana.core.ui.util.connectivity.model.ConnectivityModel;
import id.dana.databinding.ActivityOnboardingBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerOnboardingComponent;
import id.dana.di.component.OnboardingComponent;
import id.dana.di.modules.OnboardingModule;
import id.dana.network.rpc.RpcLogging;
import id.dana.onboarding.OnboardingContract;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.onboarding.verify.VerifyNumberKey;
import id.dana.performancetracker.AppReadyMixpanelTracker;
import id.dana.rum.Rum;
import id.dana.tracker.EventTracker;
import id.dana.tracker.risk.RiskEventStrategy;
import id.dana.utils.KeyboardHelper;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getCallingPid;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 N2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001NB\u0007¢\u0006\u0004\bM\u0010\u000fJ5\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u000bH\u0016¢\u0006\u0004\b!\u0010\u000fJ\u000f\u0010\"\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\"\u0010#J\u000f\u0010\f\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\f\u0010$J\u0019\u0010'\u001a\u00020\u000b2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u000bH\u0014¢\u0006\u0004\b)\u0010\u000fJ\u000f\u0010*\u001a\u00020\u000bH\u0014¢\u0006\u0004\b*\u0010\u000fJ\u000f\u0010+\u001a\u00020\u000bH\u0002¢\u0006\u0004\b+\u0010\u000fJ\u0017\u0010,\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0018H\u0002¢\u0006\u0004\b,\u0010-R\u0013\u0010\f\u001a\u00020.X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b/\u00100R\u0013\u0010+\u001a\u000201X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b2\u00100R\u0016\u00105\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\"\u00107\u001a\u00020\u00188\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00104\u001a\u0004\b7\u0010$\"\u0004\b8\u0010-R\u0016\u0010,\u001a\u00020\u00188\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b9\u00104R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b;\u0010<R$\u0010D\u001a\u0004\u0018\u00010\u00048\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR(\u0010G\u001a\b\u0012\u0004\u0012\u00020F0E8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010L"}, d2 = {"Lid/dana/onboarding/OnboardingActivity;", "Lid/dana/base/KeyBaseActivity;", "Lid/dana/onboarding/OnboardingNavigationManagerWithMenu;", "Lid/dana/databinding/ActivityOnboardingBinding;", "", "p0", "", "p1", "p2", "", "p3", "", "getAuthRequestContext", "(Ljava/lang/String;FFJ)V", "configToolbar", "()V", "Lcom/zhuinden/simplestack/Backstack;", "backstack", "Lid/dana/base/MenuItemFacade;", "menuItemFacade", "createNavigationManager", "(Lcom/zhuinden/simplestack/Backstack;Lid/dana/base/MenuItemFacade;)Lid/dana/onboarding/OnboardingNavigationManagerWithMenu;", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "", "getContainerId", "()I", "Lid/dana/base/Key;", "getInitialKey", "()Lid/dana/base/Key;", IAPSyncCommand.COMMAND_INIT, "initViewBinding", "()Lid/dana/databinding/ActivityOnboardingBinding;", "()Z", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onPause", "onResume", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "(Z)V", "Lid/dana/core/ui/util/connectivity/ConnectivityMonitor;", "DatabaseTableConfigUtil", "Lkotlin/Lazy;", "Lid/dana/home/tab/ConnectivitySnackbarManager;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "GetContactSyncConfig", "Z", "PlaceComponentResult", "NetworkUserEntityData$$ExternalSyntheticLambda2", "isFromCitCall", "setFromCitCall", "initRecordTimeStamp", "Lid/dana/di/component/OnboardingComponent;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/di/component/OnboardingComponent;", "MyBillsEntityDataFactory", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Ljava/lang/String;", "getOtpPurpose", "()Ljava/lang/String;", "setOtpPurpose", "(Ljava/lang/String;)V", "otpPurpose", "Ldagger/Lazy;", "Lid/dana/onboarding/OnboardingContract$Presenter;", "presenter", "Ldagger/Lazy;", "getPresenter", "()Ldagger/Lazy;", "setPresenter", "(Ldagger/Lazy;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OnboardingActivity extends KeyBaseActivity<OnboardingNavigationManagerWithMenu, ActivityOnboardingBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final String DEEPLINK_RESET_PIN = "DEEPLINK_RESET_PIN";
    private static char PrepareContext;
    private static char[] newProxyInstance;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private boolean isFromCitCall;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private String otpPurpose;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private OnboardingComponent MyBillsEntityDataFactory;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;
    @Inject
    public Lazy<OnboardingContract.Presenter> presenter;
    public static final byte[] $$j = {116, 39, -17, SignedBytes.MAX_POWER_OF_TWO, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$k = 237;
    public static final byte[] NetworkUserEntityData$$ExternalSyntheticLambda0 = {42, -48, 107, -19, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int lookAheadTest = 17;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final kotlin.Lazy getAuthRequestContext = LazyKt.lazy(new Function0<ConnectivityMonitor>() { // from class: id.dana.onboarding.OnboardingActivity$connectivityMonitor$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ConnectivityMonitor invoke() {
            return new ConnectivityMonitor(OnboardingActivity.this);
        }
    });

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final kotlin.Lazy KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<ConnectivitySnackbarManager>() { // from class: id.dana.onboarding.OnboardingActivity$connectivitySnackbarManager$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ConnectivitySnackbarManager invoke() {
            OnboardingActivity onboardingActivity = OnboardingActivity.this;
            OnboardingActivity onboardingActivity2 = onboardingActivity;
            FrameLayout frameLayout = OnboardingActivity.access$getBinding(onboardingActivity).PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "");
            return new ConnectivitySnackbarManager(onboardingActivity2, frameLayout);
        }
    });

    static {
        PlaceComponentResult();
        INSTANCE = new Companion(null);
    }

    static void PlaceComponentResult() {
        PrepareContext = (char) 42066;
        newProxyInstance = new char[]{37374, 37346, 37274, 37287, 37365, 37344, 37370, 37286, 37353, 37357, 37279, 37351, 37306, 37367, 37294, 37289, 37349, 37308, 37369, 37288, 37356, 37283, 37371, 37309, 37290, 37359, 37307, 37293, 37291, 37310, 37358, 37366, 37292, 37348, 37275, 37368, 37281, 37375, 37262, 37302, 37373, 37311, 37305, 37282, 37372, 37350, 37280, 37347, 37345};
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void l(int r7, short r8, short r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 + 4
            byte[] r0 = id.dana.onboarding.OnboardingActivity.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r8 = r8 + 16
            int r9 = r9 + 97
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L15
            r9 = r8
            r3 = r1
            r5 = 0
            r8 = r7
            r1 = r0
            r0 = r10
            r10 = r9
            goto L32
        L15:
            r3 = 0
            r6 = r9
            r9 = r8
            r8 = r6
        L19:
            byte r4 = (byte) r8
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r9) goto L28
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L28:
            r3 = r0[r7]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L32:
            int r9 = r9 + r7
            int r7 = r9 + (-4)
            int r8 = r8 + 1
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
        throw new UnsupportedOperationException("Method not decompiled: id.dana.onboarding.OnboardingActivity.l(int, short, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void m(byte r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 3
            int r7 = 42 - r7
            int r6 = r6 * 2
            int r6 = r6 + 75
            int r8 = r8 + 4
            byte[] r0 = id.dana.onboarding.OnboardingActivity.$$j
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L34
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r8 = r8 + 1
            if (r3 != r7) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            r4 = r0[r8]
            int r3 = r3 + 1
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L34:
            int r6 = r6 + r8
            int r6 = r6 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.onboarding.OnboardingActivity.m(byte, byte, short, java.lang.Object[]):void");
    }

    @JvmStatic
    public static final void open(Activity activity, Uri uri) {
        Companion.MyBillsEntityDataFactory(activity, uri);
    }

    @Override // id.dana.base.KeyBaseActivity, id.dana.base.viewbinding.ViewBindingActivity
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.KeyBaseActivity, id.dana.base.viewbinding.ViewBindingActivity
    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.base.KeyBaseActivity, id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        k((byte) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 29), 18 - Color.alpha(0), new char[]{15, '#', 30, 21, '*', 11, Typography.quote, '*', '-', 18, '-', '\r', 25, ',', 31, 25, 13830, 13830}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        k((byte) (96 - (Process.myTid() >> 22)), 5 - (ViewConfiguration.getScrollBarSize() >> 8), new char[]{'.', Typography.dollar, 0, '\t', 13918}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (KeyEvent.getMaxKeyCode() >> 16), Color.blue(0) + 35, (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    k((byte) (80 - TextUtils.indexOf("", "", 0, 0)), 48 - (ViewConfiguration.getEdgeSlop() >> 16), new char[]{'\'', 28, 20, 11, '#', 30, Typography.quote, '\n', Typography.amp, 21, 29, 18, JSONLexer.EOI, Typography.amp, 4, 14, 13819, 13819, 19, 15, 29, '!', '\'', 25, 30, '*', 7, Typography.quote, '#', '!', 17, 21, InputCardNumberView.DIVIDER, 17, Typography.amp, '!', 17, 29, '\t', ')', Typography.dollar, 14, 25, 15, 23, '0', 17, 25}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    k((byte) (61 - TextUtils.getOffsetBefore("", 0)), KeyEvent.keyCodeFromString("") + 64, new char[]{20, 0, 14, InputCardNumberView.DIVIDER, 17, 29, ')', '\t', 29, '!', Typography.quote, 3, '#', 7, 1, 21, 13797, 13797, 14, 1, '#', 7, 16, '.', 20, 25, Typography.amp, 31, 7, Typography.quote, 13797, 13797, '!', 29, 27, '\b', 13878, 13878, ',', 2, 2, ')', 21, 3, 28, '\'', 7, '*', 13798, 13798, Typography.amp, 28, 28, Typography.amp, '#', 2, '#', 2, Typography.quote, 25, 6, 7, 30, '*'}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    k((byte) (84 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), Color.blue(0) + 64, new char[]{'#', 5, 25, 21, 28, Typography.amp, Typography.dollar, JSONLexer.EOI, 13813, 13813, 7, 6, 2, '*', Typography.amp, Typography.dollar, 17, 21, 21, 29, ')', JSONLexer.EOI, 16, '*', Typography.dollar, 14, Typography.quote, '\n', 13903, 13903, '\'', 28, '*', '#', ')', '\f', 21, ')', 20, 11, '\b', 20, 1, 21, '\t', ')', 20, 21, 17, 29, 31, 25, '#', 5, 20, 1, ')', 0, InputCardNumberView.DIVIDER, 17, 20, 1, 3, Typography.quote}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    k((byte) (30 - ExpandableListView.getPackedPositionGroup(0L)), Color.argb(0, 0, 0, 0) + 60, new char[]{5, 24, 27, '(', 18, 3, 13779, 13779, '#', 21, '#', 15, '/', 27, 2, 24, 21, 17, 25, '!', 15, 18, 27, '/', JSONLexer.EOI, 19, 16, 21, 31, 14, '!', '\b', 16, 21, 27, '-', '\'', 4, '/', 1, 20, '#', '\f', 0, '\b', '#', 17, JSONLexer.EOI, 19, 24, 0, '/', '/', '\f', 21, '-', 22, Typography.amp, 24, 19}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    k((byte) (39 - KeyEvent.getDeadChar(0, 0)), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 5, new char[]{Typography.quote, '-', 27, '+', '#', 5}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 911, 18 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                l(37, NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[32], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = NetworkUserEntityData$$ExternalSyntheticLambda0[35];
                byte b2 = NetworkUserEntityData$$ExternalSyntheticLambda0[25];
                Object[] objArr14 = new Object[1];
                l(b, b2, (byte) (b2 | 8), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 3 - TextUtils.indexOf("", ""), (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)));
                        Object[] objArr16 = new Object[1];
                        m($$j[78], $$j[31], $$j[47], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, TextUtils.lastIndexOf("", '0', 0, 0) + 16, (char) Color.alpha(0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - View.MeasureSpec.getSize(0), 15 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778031, (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 29, (char) (57993 - ImageFormat.getBitsPerPixel(0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 15, (char) (ViewConfiguration.getTouchSlop() >> 8)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getLongPressTimeout() >> 16), ((Process.getThreadPriority(0) + 20) >> 6) + 35, (char) Color.alpha(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {1293715289, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.alpha(0), 18 - (ViewConfiguration.getScrollBarSize() >> 8), (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                l(37, NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[32], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b3 = NetworkUserEntityData$$ExternalSyntheticLambda0[35];
                byte b4 = NetworkUserEntityData$$ExternalSyntheticLambda0[25];
                Object[] objArr20 = new Object[1];
                l(b3, b4, (byte) (b4 | 8), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.makeMeasureSpec(0, 0) + 61, 46 - Gravity.getAbsoluteGravity(0, 0), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)));
                        Object[] objArr22 = new Object[1];
                        m($$j[9], $$j[8], $$j[28], objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 930, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 34, (char) (Process.myPid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {1293715289, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.green(0), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18, (char) ExpandableListView.getPackedPositionType(0L))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                l(37, NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[32], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b5 = NetworkUserEntityData$$ExternalSyntheticLambda0[35];
                byte b6 = NetworkUserEntityData$$ExternalSyntheticLambda0[25];
                Object[] objArr26 = new Object[1];
                l(b5, b6, (byte) (b6 | 8), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + 118, 3 - (KeyEvent.getMaxKeyCode() >> 16), (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 38967));
                        Object[] objArr28 = new Object[1];
                        m($$j[9], $$j[8], $$j[28], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - ExpandableListView.getPackedPositionChild(0L), TextUtils.indexOf((CharSequence) "", '0', 0) + 36, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {1293715289, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.makeMeasureSpec(0, 0), 17 - TextUtils.lastIndexOf("", '0', 0, 0), (char) TextUtils.getOffsetBefore("", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                l(37, NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[32], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b7 = NetworkUserEntityData$$ExternalSyntheticLambda0[35];
                byte b8 = NetworkUserEntityData$$ExternalSyntheticLambda0[25];
                Object[] objArr32 = new Object[1];
                l(b7, b8, (byte) (b8 | 8), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(106 - TextUtils.indexOf((CharSequence) "", '0', 0), KeyEvent.getDeadChar(0, 0) + 3, (char) TextUtils.getTrimmedLength(""));
                        byte b9 = (byte) ($$j[78] - 1);
                        Object[] objArr34 = new Object[1];
                        m(b9, b9, (byte) (-$$j[40]), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getEdgeSlop() >> 16) + 35, (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {1293715289, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + 911, 18 - TextUtils.indexOf("", "", 0, 0), (char) KeyEvent.keyCodeFromString(""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.KeyBaseActivity, id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.KeyBaseActivity, id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.KeyBaseActivity
    public final int getContainerId() {
        return R.id.container;
    }

    @Override // id.dana.base.KeyBaseActivity, id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    public static final /* synthetic */ ActivityOnboardingBinding access$getBinding(OnboardingActivity onboardingActivity) {
        return (ActivityOnboardingBinding) onboardingActivity.getBinding();
    }

    @JvmName(name = "getPresenter")
    public final Lazy<OnboardingContract.Presenter> getPresenter() {
        Lazy<OnboardingContract.Presenter> lazy = this.presenter;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(Lazy<OnboardingContract.Presenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.presenter = lazy;
    }

    @JvmName(name = "isFromCitCall")
    /* renamed from: isFromCitCall  reason: from getter */
    public final boolean getIsFromCitCall() {
        return this.isFromCitCall;
    }

    @JvmName(name = "setFromCitCall")
    public final void setFromCitCall(boolean z) {
        this.isFromCitCall = z;
    }

    @JvmName(name = "getOtpPurpose")
    public final String getOtpPurpose() {
        return this.otpPurpose;
    }

    @JvmName(name = "setOtpPurpose")
    public final void setOtpPurpose(String str) {
        this.otpPurpose = str;
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity
    public final void init() {
        RpcLogging.INSTANCE.setEnabled(true);
        if (this.MyBillsEntityDataFactory == null) {
            DaggerOnboardingComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerOnboardingComponent.BuiltInFictitiousFunctionClassFactory();
            BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = (OnboardingModule) Preconditions.getAuthRequestContext(new OnboardingModule());
            if (BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory == null) {
                BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = new OnboardingModule();
            }
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, ApplicationComponent.class);
            this.MyBillsEntityDataFactory = new DaggerOnboardingComponent.OnboardingComponentImpl(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, (byte) 0);
        }
        OnboardingComponent onboardingComponent = this.MyBillsEntityDataFactory;
        if (onboardingComponent != null) {
            onboardingComponent.KClassImpl$Data$declaredNonStaticMembers$2(this);
        }
        if (getAuthRequestContext()) {
            getPresenter().get().BuiltInFictitiousFunctionClassFactory("LOGIN", new Function0<Unit>() { // from class: id.dana.onboarding.OnboardingActivity$init$1
                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AppReadyMixpanelTracker.moveToNextValue();
                }
            }, new Function0<Unit>() { // from class: id.dana.onboarding.OnboardingActivity$init$2
                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AppReadyMixpanelTracker.KClassImpl$Data$declaredNonStaticMembers$2();
                }
            }, new Function1<Boolean, Unit>() { // from class: id.dana.onboarding.OnboardingActivity$init$3
                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z) {
                    AppReadyMixpanelTracker appReadyMixpanelTracker = AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory;
                    AppReadyMixpanelTracker.getAuthRequestContext(z);
                }
            });
            KeyboardHelper.PlaceComponentResult(getWindow().getDecorView(), new KeyboardHelper.KeyboardVisibilityListener() { // from class: id.dana.onboarding.OnboardingActivity$setupKeyboardListener$1
                @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    OnboardingActivity.this.BuiltInFictitiousFunctionClassFactory = true;
                    ConnectivitySnackbarManager access$getConnectivitySnackbarManager = OnboardingActivity.access$getConnectivitySnackbarManager(OnboardingActivity.this);
                    if (access$getConnectivitySnackbarManager.KClassImpl$Data$declaredNonStaticMembers$2.isShownOrQueued()) {
                        access$getConnectivitySnackbarManager.KClassImpl$Data$declaredNonStaticMembers$2.dismiss();
                    }
                }

                @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
                public final void MyBillsEntityDataFactory() {
                    boolean z;
                    OnboardingActivity.this.BuiltInFictitiousFunctionClassFactory = false;
                    OnboardingActivity onboardingActivity = OnboardingActivity.this;
                    z = onboardingActivity.PlaceComponentResult;
                    onboardingActivity.BuiltInFictitiousFunctionClassFactory(z);
                }
            });
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final ActivityOnboardingBinding initViewBinding() {
        ActivityOnboardingBinding MyBillsEntityDataFactory = ActivityOnboardingBinding.MyBillsEntityDataFactory(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.base.KeyBaseActivity
    public final Key getInitialKey() {
        Bundle extras = getIntent().getExtras();
        boolean z = extras == null || !getIntent().hasExtra("phoneNumber");
        if (extras != null && extras.containsKey("FROM_LOGOUT") && extras.getBoolean("FROM_LOGOUT")) {
            VerifyNumberKey.Companion companion = VerifyNumberKey.INSTANCE;
            VerifyNumberKey.Builder BuiltInFictitiousFunctionClassFactory = VerifyNumberKey.Companion.BuiltInFictitiousFunctionClassFactory();
            Boolean bool = Boolean.TRUE;
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = bool != null ? bool.booleanValue() : false;
            return BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
        } else if (z) {
            VerifyNumberKey.Companion companion2 = VerifyNumberKey.INSTANCE;
            return VerifyNumberKey.Companion.BuiltInFictitiousFunctionClassFactory().PlaceComponentResult();
        } else {
            VerifyNumberKey.Companion companion3 = VerifyNumberKey.INSTANCE;
            VerifyNumberKey.Builder BuiltInFictitiousFunctionClassFactory2 = VerifyNumberKey.Companion.BuiltInFictitiousFunctionClassFactory();
            BuiltInFictitiousFunctionClassFactory2.PlaceComponentResult = extras != null ? extras.getString("phoneNumber") : null;
            Boolean valueOf = extras != null ? Boolean.valueOf(extras.getBoolean("isEditablePhoneNumber")) : null;
            BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2 = valueOf != null ? valueOf.booleanValue() : false;
            BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory = extras != null ? extras.getString("source") : null;
            return BuiltInFictitiousFunctionClassFactory2.PlaceComponentResult();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.KeyBaseActivity
    public final OnboardingNavigationManagerWithMenu createNavigationManager(Backstack backstack, MenuItemFacade menuItemFacade) {
        Intrinsics.checkNotNullParameter(backstack, "");
        Intrinsics.checkNotNullParameter(menuItemFacade, "");
        return new OnboardingNavigationManagerWithMenu(this, backstack, menuItemFacade);
    }

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
        setToolbarImage(R.drawable.ic_dana_logo_icon_text);
    }

    @Override // id.dana.base.KeyBaseActivity, id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        k((byte) (super.getResources().getString(R.string.notes_2).substring(13, 15).length() + 27), getPackageName().codePointAt(0) - 87, new char[]{15, '#', 30, 21, '*', 11, Typography.quote, '*', '-', 18, '-', '\r', 25, ',', 31, 25, 13830, 13830}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        k((byte) (super.getResources().getString(R.string.airtime_and_data).substring(0, 12).codePointAt(5) + 64), getPackageName().codePointAt(1) - 95, new char[]{'.', Typography.dollar, 0, '\t', 13918}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                k((byte) (super.getResources().getString(R.string.additional_info_form_debit_card).substring(15, 25).length() + 17), super.getResources().getString(R.string.family_account_text_desc_resend).substring(0, 3).codePointAt(2) - 6, new char[]{15, '#', 30, 21, '*', 11, Typography.quote, '*', 20, '#', '0', 6, '\'', 31, 21, '\f', 0, 14, 25, '(', 31, 6, 24, 25, 21, '#'}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                k((byte) (super.getResources().getString(R.string.send_money_save_rename_bank_account).substring(0, 1).length() + 74), getPackageName().codePointAt(4) - 79, new char[]{'!', 11, 13875, 13875, 22, Typography.amp, 24, '(', 13877, 13877, 28, 14, 28, 18, 21, '\f', '+', '\''}, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + PDF417Common.NUMBER_OF_CODEWORDS, ImageFormat.getBitsPerPixel(0) + 36, (char) (AndroidCharacter.getMirror('0') - '0'))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    k((byte) (80 - (ViewConfiguration.getTapTimeout() >> 16)), KeyEvent.keyCodeFromString("") + 48, new char[]{'\'', 28, 20, 11, '#', 30, Typography.quote, '\n', Typography.amp, 21, 29, 18, JSONLexer.EOI, Typography.amp, 4, 14, 13819, 13819, 19, 15, 29, '!', '\'', 25, 30, '*', 7, Typography.quote, '#', '!', 17, 21, InputCardNumberView.DIVIDER, 17, Typography.amp, '!', 17, 29, '\t', ')', Typography.dollar, 14, 25, 15, 23, '0', 17, 25}, objArr6);
                    String str = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    k((byte) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 61), super.getResources().getString(R.string.mybills_edit_bill_penalty_fee_label).substring(1, 3).codePointAt(1) - 46, new char[]{20, 0, 14, InputCardNumberView.DIVIDER, 17, 29, ')', '\t', 29, '!', Typography.quote, 3, '#', 7, 1, 21, 13797, 13797, 14, 1, '#', 7, 16, '.', 20, 25, Typography.amp, 31, 7, Typography.quote, 13797, 13797, '!', 29, 27, '\b', 13878, 13878, ',', 2, 2, ')', 21, 3, 28, '\'', 7, '*', 13798, 13798, Typography.amp, 28, 28, Typography.amp, '#', 2, '#', 2, Typography.quote, 25, 6, 7, 30, '*'}, objArr7);
                    String str2 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    k((byte) (super.getResources().getString(R.string.unregistered_number_title).substring(16, 17).length() + 82), super.getResources().getString(R.string.saving_gadget).substring(0, 6).codePointAt(1) - 33, new char[]{'#', 5, 25, 21, 28, Typography.amp, Typography.dollar, JSONLexer.EOI, 13813, 13813, 7, 6, 2, '*', Typography.amp, Typography.dollar, 17, 21, 21, 29, ')', JSONLexer.EOI, 16, '*', Typography.dollar, 14, Typography.quote, '\n', 13903, 13903, '\'', 28, '*', '#', ')', '\f', 21, ')', 20, 11, '\b', 20, 1, 21, '\t', ')', 20, 21, 17, 29, 31, 25, '#', 5, 20, 1, ')', 0, InputCardNumberView.DIVIDER, 17, 20, 1, 3, Typography.quote}, objArr8);
                    String str3 = (String) objArr8[0];
                    try {
                        Object[] objArr9 = new Object[1];
                        l(NetworkUserEntityData$$ExternalSyntheticLambda0[25], (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), NetworkUserEntityData$$ExternalSyntheticLambda0[25], objArr9);
                        Class<?> cls3 = Class.forName((String) objArr9[0]);
                        l((byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[59] + 1), NetworkUserEntityData$$ExternalSyntheticLambda0[56], (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[5]), new Object[1]);
                        Object[] objArr10 = new Object[1];
                        k((byte) (((ApplicationInfo) cls3.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 3), getPackageName().codePointAt(0) - 45, new char[]{5, 24, 27, '(', 18, 3, 13779, 13779, '#', 21, '#', 15, '/', 27, 2, 24, 21, 17, 25, '!', 15, 18, 27, '/', JSONLexer.EOI, 19, 16, 21, 31, 14, '!', '\b', 16, 21, 27, '-', '\'', 4, '/', 1, 20, '#', '\f', 0, '\b', '#', 17, JSONLexer.EOI, 19, 24, 0, '/', '/', '\f', 21, '-', 22, Typography.amp, 24, 19}, objArr10);
                        String str4 = (String) objArr10[0];
                        try {
                            Object[] objArr11 = new Object[1];
                            l(NetworkUserEntityData$$ExternalSyntheticLambda0[25], (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), NetworkUserEntityData$$ExternalSyntheticLambda0[25], objArr11);
                            Class<?> cls4 = Class.forName((String) objArr11[0]);
                            Object[] objArr12 = new Object[1];
                            l((byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[59] + 1), NetworkUserEntityData$$ExternalSyntheticLambda0[56], (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[5]), objArr12);
                            Object[] objArr13 = new Object[1];
                            k((byte) (((ApplicationInfo) cls4.getMethod((String) objArr12[0], null).invoke(this, null)).targetSdkVersion + 6), super.getResources().getString(R.string.twilio_not_have_pending_challenge_message).substring(9, 10).length() + 5, new char[]{Typography.quote, '-', 27, '+', '#', 5}, objArr13);
                            try {
                                Object[] objArr14 = {baseContext, str, str2, str3, str4, true, (String) objArr13[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getLongPressTimeout() >> 16), 18 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                }
                                ((Method) obj2).invoke(invoke, objArr14);
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
            Object[] objArr15 = new Object[1];
            l(37, NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[32], objArr15);
            Class<?> cls5 = Class.forName((String) objArr15[0]);
            byte b = NetworkUserEntityData$$ExternalSyntheticLambda0[35];
            byte b2 = NetworkUserEntityData$$ExternalSyntheticLambda0[25];
            Object[] objArr16 = new Object[1];
            l(b, b2, (byte) (b2 | 8), objArr16);
            try {
                Object[] objArr17 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getWindowTouchSlop() >> 8), 4 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (Process.myPid() >> 22));
                    byte b3 = (byte) ($$j[78] - 1);
                    Object[] objArr18 = new Object[1];
                    m(b3, b3, (byte) (-$$j[40]), objArr18);
                    obj3 = cls6.getMethod((String) objArr18[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr19 = (Object[]) ((Method) obj3).invoke(null, objArr17);
                int i = ((int[]) objArr19[1])[0];
                if (((int[]) objArr19[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ((Process.getThreadPriority(0) + 20) >> 6), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 34, (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr20 = {1658061286, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollDefaultDelay() >> 16) + 911, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 17, (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                super.onCreate(savedInstanceState);
                this.injectConnectionStatusReceiver = false;
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

    @Override // id.dana.base.KeyBaseActivity, id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            k((byte) (super.getResources().getString(R.string.dont_worry_access).substring(52, 54).length() + 25), View.MeasureSpec.getMode(0) + 26, new char[]{15, '#', 30, 21, '*', 11, Typography.quote, '*', 20, '#', '0', 6, '\'', 31, 21, '\f', 0, 14, 25, '(', 31, 6, 24, 25, 21, '#'}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                Object[] objArr2 = new Object[1];
                l(NetworkUserEntityData$$ExternalSyntheticLambda0[25], (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[30]), NetworkUserEntityData$$ExternalSyntheticLambda0[25], objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                l((byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[59] + 1), NetworkUserEntityData$$ExternalSyntheticLambda0[56], (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[5]), objArr3);
                Object[] objArr4 = new Object[1];
                k((byte) (((ApplicationInfo) cls2.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 42), super.getResources().getString(R.string.passkey_verification_process_title).substring(1, 2).length() + 17, new char[]{'!', 11, 13875, 13875, 22, Typography.amp, 24, '(', 13877, 13877, 28, 14, 28, 18, 21, '\f', '+', '\''}, objArr4);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollDefaultDelay() >> 16), Color.green(0) + 35, (char) TextUtils.getOffsetAfter("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.getSize(0), TextUtils.indexOf((CharSequence) "", '0', 0) + 19, (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        Rum.Companion companion = Rum.getAuthRequestContext;
        Rum.Companion.BuiltInFictitiousFunctionClassFactory().PlaceComponentResult("OnboardingActivity.onResume");
        if (getAuthRequestContext()) {
            getAuthRequestContext$default(this, RiskActionConstant.ON_PAGE_TRACK, 0.0f, 0.0f, 0L, 14, null);
            KClassImpl$Data$declaredNonStaticMembers$2();
            Rum.Companion companion2 = Rum.getAuthRequestContext;
            Rum.Companion.BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory("OnboardingActivity.onResume");
        }
    }

    @Override // id.dana.base.KeyBaseActivity, id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            k((byte) (AndroidCharacter.getMirror('0') - 21), super.getResources().getString(R.string.send_money_rename_saved_bank_account).substring(12, 13).length() + 25, new char[]{15, '#', 30, 21, '*', 11, Typography.quote, '*', 20, '#', '0', 6, '\'', 31, 21, '\f', 0, 14, 25, '(', 31, 6, 24, 25, 21, '#'}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            k((byte) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 76), super.getResources().getString(R.string.split_bill_remaining).substring(0, 26).length() - 8, new char[]{'!', 11, 13875, 13875, 22, Typography.amp, 24, '(', 13877, 13877, 28, 14, 28, 18, 21, '\f', '+', '\''}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) View.combineMeasuredStates(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getKeyRepeatDelay() >> 16), 18 - (ViewConfiguration.getTouchSlop() >> 8), (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1))).getMethod("MyBillsEntityDataFactory", Context.class);
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
        ((ConnectivityMonitor) this.getAuthRequestContext.getValue()).PlaceComponentResult((LifecycleOwner) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        String str = p0 ? InternetConnectionStatus.FAST_CONNECTION : InternetConnectionStatus.NOT_CONNECTED;
        if (!this.BuiltInFictitiousFunctionClassFactory) {
            ((ConnectivitySnackbarManager) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).BuiltInFictitiousFunctionClassFactory(str);
        }
        this.PlaceComponentResult = p0;
    }

    private final boolean getAuthRequestContext() {
        return getBackstack().top() instanceof VerifyNumberKey;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent ev) {
        if (getAuthRequestContext()) {
            boolean z = false;
            if (ev != null && ev.getActionMasked() == 0) {
                z = true;
            }
            if (z) {
                getAuthRequestContext(RiskActionConstant.ON_TOUCH, ev.getX(), ev.getY(), System.currentTimeMillis());
            }
            return super.dispatchTouchEvent(ev);
        }
        return super.dispatchTouchEvent(ev);
    }

    static /* synthetic */ void getAuthRequestContext$default(OnboardingActivity onboardingActivity, String str, float f, float f2, long j, int i, Object obj) {
        float f3 = (i & 2) != 0 ? 0.0f : f;
        float f4 = (i & 4) != 0 ? 0.0f : f2;
        if ((i & 8) != 0) {
            j = 0;
        }
        onboardingActivity.getAuthRequestContext(str, f3, f4, j);
    }

    private final void getAuthRequestContext(String p0, float p1, float p2, long p3) {
        RiskEventStrategy.Builder builder = new RiskEventStrategy.Builder(this);
        Intrinsics.checkNotNullParameter("InputPhoneNumber", "");
        builder.MyBillsEntityDataFactory = "InputPhoneNumber";
        Intrinsics.checkNotNullParameter(p0, "");
        builder.getAuthRequestContext = p0;
        if (Intrinsics.areEqual(p0, RiskActionConstant.ON_TOUCH)) {
            builder.moveToNextValue = Float.valueOf(p1);
            builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = Float.valueOf(p2);
            builder.BuiltInFictitiousFunctionClassFactory = Long.valueOf(p3);
        }
        EventTracker.BuiltInFictitiousFunctionClassFactory(builder.getAuthRequestContext());
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0005\u0010\tJ!\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b\u0005\u0010\fJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\r\u0010\tR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/onboarding/OnboardingActivity$Companion;", "", "Landroid/content/Context;", "p0", "Landroid/content/Intent;", "MyBillsEntityDataFactory", "(Landroid/content/Context;)Landroid/content/Intent;", "Landroid/app/Activity;", "", "(Landroid/app/Activity;)V", "Landroid/net/Uri;", "p1", "(Landroid/app/Activity;Landroid/net/Uri;)V", "getAuthRequestContext", "", OnboardingActivity.DEEPLINK_RESET_PIN, "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static Intent MyBillsEntityDataFactory(Context p0) {
            Intent flags = new Intent(p0, OnboardingActivity.class).setFlags(268468224);
            Intrinsics.checkNotNullExpressionValue(flags, "");
            return flags;
        }

        @JvmStatic
        public static void MyBillsEntityDataFactory(Activity p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intent flags = new Intent(p0, OnboardingActivity.class).setFlags(268468224);
            Intrinsics.checkNotNullExpressionValue(flags, "");
            p0.startActivity(flags);
        }

        @JvmStatic
        public static void MyBillsEntityDataFactory(Activity p0, Uri p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            p0.startActivity(new Intent(p0, OnboardingActivity.class).setData(p1));
        }

        @JvmStatic
        public static void getAuthRequestContext(Activity p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intent flags = new Intent(p0, OnboardingActivity.class).setFlags(268468224);
            Intrinsics.checkNotNullExpressionValue(flags, "");
            flags.putExtra("FROM_LOGOUT", true);
            p0.startActivity(flags);
        }
    }

    public static /* synthetic */ void $r8$lambda$tYxNqbhFW5kQa_ngkjvINKXXb2g(OnboardingActivity onboardingActivity, ConnectivityModel connectivityModel) {
        Intrinsics.checkNotNullParameter(onboardingActivity, "");
        Intrinsics.checkNotNullExpressionValue(connectivityModel, "");
        onboardingActivity.BuiltInFictitiousFunctionClassFactory(ConnectivityModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(connectivityModel));
    }

    public static final /* synthetic */ ConnectivitySnackbarManager access$getConnectivitySnackbarManager(OnboardingActivity onboardingActivity) {
        return (ConnectivitySnackbarManager) onboardingActivity.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
    }

    @JvmStatic
    public static final void open(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
        activity.startActivity(Companion.MyBillsEntityDataFactory((Context) activity));
    }

    @JvmStatic
    public static final void openAfterLogout(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intent MyBillsEntityDataFactory = Companion.MyBillsEntityDataFactory((Context) activity);
        MyBillsEntityDataFactory.putExtra("FROM_LOGOUT", true);
        activity.startActivity(MyBillsEntityDataFactory);
    }

    @JvmStatic
    public static final void openToResetPin(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(str, "");
        activity.startActivity(Companion.MyBillsEntityDataFactory((Context) activity).putExtra("phoneNumber", str).putExtra("isEditablePhoneNumber", true).putExtra("source", DEEPLINK_RESET_PIN));
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        ConnectivityMonitorKt.MyBillsEntityDataFactory((ConnectivityMonitor) this.getAuthRequestContext.getValue(), 1000L).PlaceComponentResult(this, new Observer() { // from class: id.dana.onboarding.OnboardingActivity$$ExternalSyntheticLambda0
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                OnboardingActivity.$r8$lambda$tYxNqbhFW5kQa_ngkjvINKXXb2g(OnboardingActivity.this, (ConnectivityModel) obj);
            }
        });
    }

    private static void k(byte b, int i, char[] cArr, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = newProxyInstance;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i3 = 0; i3 < length; i3++) {
                cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
            }
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ PrepareContext);
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
