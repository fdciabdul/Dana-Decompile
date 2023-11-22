package id.dana.riskChallenges.ui.resetpin;

import android.content.Context;
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
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.fragment.app.FragmentManager;
import androidx.view.ComponentActivity;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.view.viewmodel.CreationExtras;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.core.ui.dialog.DanaLoadingDialogFragment;
import id.dana.core.ui.util.KeyboardHelper;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.resetpin.interactor.SaveDanaVizPromptAfterResetPin;
import id.dana.network.util.DanaH5Helper;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.riskChallenges.R;
import id.dana.riskChallenges.databinding.ActivityRiskChallengeBinding;
import id.dana.riskChallenges.di.component.RiskChallengesComponent;
import id.dana.riskChallenges.di.provider.RiskChallengesProvider;
import id.dana.riskChallenges.ui.resetpin.ResetPinLauncher;
import id.dana.riskChallenges.ui.util.uicomponent.UIComponentType;
import id.dana.riskChallenges.ui.util.uicomponent.UiComponent;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Typography;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getCallingPid;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\u0007R\u0013\u0010\f\u001a\u00020\tX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\n\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0013\u0010\u001a\u001a\u00020\u0018X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0019\u0010\u000bR\"\u0010\u001c\u001a\u00020\u001b8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0013\u0010\u0012\u001a\u00020\"X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b#\u0010\u000b"}, d2 = {"Lid/dana/riskChallenges/ui/resetpin/SelfUnfreezeActivity;", "Lid/dana/core/ui/BaseViewBindingActivity;", "Lid/dana/riskChallenges/databinding/ActivityRiskChallengeBinding;", "inflateViewBinding", "()Lid/dana/riskChallenges/databinding/ActivityRiskChallengeBinding;", "", IAPSyncCommand.COMMAND_INIT, "()V", "onStart", "Lid/dana/core/ui/dialog/DanaLoadingDialogFragment;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/Lazy;", "getAuthRequestContext", "", "getErrorConfigVersion", "Z", "MyBillsEntityDataFactory", "", "lookAheadTest", "Ljava/lang/String;", "PlaceComponentResult", "Lid/dana/riskChallenges/di/component/RiskChallengesComponent;", "scheduleImpl", "Lid/dana/riskChallenges/di/component/RiskChallengesComponent;", "Lid/dana/riskChallenges/ui/resetpin/ResetPinLauncher;", "GetContactSyncConfig", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/core/ui/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/core/ui/di/module/ViewModelFactory;", "getViewModelFactory", "()Lid/dana/core/ui/di/module/ViewModelFactory;", "setViewModelFactory", "(Lid/dana/core/ui/di/module/ViewModelFactory;)V", "Lid/dana/riskChallenges/ui/resetpin/SelfUnfreezeViewModel;", "initRecordTimeStamp", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class SelfUnfreezeActivity extends BaseViewBindingActivity<ActivityRiskChallengeBinding> {

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final Lazy lookAheadTest;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private RiskChallengesComponent KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    public ViewModelFactory viewModelFactory;
    public static final byte[] $$a = {117, -10, 119, -11, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 63;
    public static final byte[] PlaceComponentResult = {103, 121, -60, -41, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int getAuthRequestContext = 154;
    private static char NetworkUserEntityData$$ExternalSyntheticLambda1 = 42066;
    private static char[] DatabaseTableConfigUtil = {37294, 37293, 37308, 37461, 37288, 37307, 37456, 37370, 37309, 37372, 37460, 37274, 37287, 37368, 37291, 37345, 37281, 37471, 37365, 37310, 37366, 37286, 37459, 37289, 37344, 37375, 37275, 37369, 37290, 37282, 37306, 37462, 37469, 37463, 37367, 37302, 37457, 37283, 37305, 37373, 37279, 37292, 37468, 37374, 37311, 37280, 37458, 37262, 37371};

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<ResetPinLauncher>() { // from class: id.dana.riskChallenges.ui.resetpin.SelfUnfreezeActivity$strategy$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ResetPinLauncher invoke() {
            String str;
            ResetPinLauncher.Builder builder = new ResetPinLauncher.Builder(SelfUnfreezeActivity.this, "Pre-Login");
            str = SelfUnfreezeActivity.this.PlaceComponentResult;
            Intrinsics.checkNotNullParameter(str, "");
            builder.PlaceComponentResult = str;
            Intrinsics.checkNotNullParameter(TrackerKey.RiskChallenge.Source.SELF_UNFREEZE, "");
            builder.BuiltInFictitiousFunctionClassFactory = TrackerKey.RiskChallenge.Source.SELF_UNFREEZE;
            UiComponent uiComponent = new UiComponent(UIComponentType.Full, R.color.KClassImpl$Data$declaredNonStaticMembers$2, R.string.forget_pin);
            Intrinsics.checkNotNullParameter(uiComponent, "");
            builder.scheduleImpl = uiComponent;
            final SelfUnfreezeActivity selfUnfreezeActivity = SelfUnfreezeActivity.this;
            Function1<Bundle, Unit> function1 = new Function1<Bundle, Unit>() { // from class: id.dana.riskChallenges.ui.resetpin.SelfUnfreezeActivity$strategy$2.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Bundle bundle) {
                    invoke2(bundle);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Bundle bundle) {
                    String str2;
                    Intrinsics.checkNotNullParameter(bundle, "");
                    SelfUnfreezeViewModel access$getVm = SelfUnfreezeActivity.access$getVm(SelfUnfreezeActivity.this);
                    str2 = SelfUnfreezeActivity.this.PlaceComponentResult;
                    Intrinsics.checkNotNullParameter(str2, "");
                    BaseUseCase.execute$default(access$getVm.BuiltInFictitiousFunctionClassFactory, new SaveDanaVizPromptAfterResetPin.Params(str2, true), new Function1<Boolean, Unit>() { // from class: id.dana.riskChallenges.ui.resetpin.SelfUnfreezeViewModel$saveDanaVizPromptAfterResetPin$1
                        public final void invoke(boolean z) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }
                    }, null, 4, null);
                    KeyboardHelper.PlaceComponentResult(SelfUnfreezeActivity.this);
                    SelfUnfreezeActivity.this.finish();
                }
            };
            Intrinsics.checkNotNullParameter(function1, "");
            builder.getErrorConfigVersion = function1;
            final SelfUnfreezeActivity selfUnfreezeActivity2 = SelfUnfreezeActivity.this;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.resetpin.SelfUnfreezeActivity$strategy$2.2
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
                    SelfUnfreezeActivity.access$redirectSelfUnfreezeH5Page(SelfUnfreezeActivity.this);
                }
            };
            Intrinsics.checkNotNullParameter(function0, "");
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = function0;
            final SelfUnfreezeActivity selfUnfreezeActivity3 = SelfUnfreezeActivity.this;
            Function1<Bundle, Unit> function12 = new Function1<Bundle, Unit>() { // from class: id.dana.riskChallenges.ui.resetpin.SelfUnfreezeActivity$strategy$2.3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Bundle bundle) {
                    invoke2(bundle);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Bundle bundle) {
                    Intrinsics.checkNotNullParameter(bundle, "");
                    SelfUnfreezeActivity.access$redirectSelfUnfreezeH5Page(SelfUnfreezeActivity.this);
                }
            };
            Intrinsics.checkNotNullParameter(function12, "");
            builder.PlaceComponentResult = function12;
            final SelfUnfreezeActivity selfUnfreezeActivity4 = SelfUnfreezeActivity.this;
            Function0<Unit> function02 = new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.resetpin.SelfUnfreezeActivity$strategy$2.4
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
                    SelfUnfreezeActivity.access$getDanaLoading(SelfUnfreezeActivity.this).dismissAllowingStateLoss();
                }
            };
            Intrinsics.checkNotNullParameter(function02, "");
            builder.MyBillsEntityDataFactory = function02;
            return builder.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    });

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private String PlaceComponentResult = "";

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext = LazyKt.lazy(new Function0<DanaLoadingDialogFragment>() { // from class: id.dana.riskChallenges.ui.resetpin.SelfUnfreezeActivity$danaLoading$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DanaLoadingDialogFragment invoke() {
            DanaLoadingDialogFragment.Companion companion = DanaLoadingDialogFragment.INSTANCE;
            return DanaLoadingDialogFragment.Companion.BuiltInFictitiousFunctionClassFactory();
        }
    });

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r7, short r8, byte r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 + 4
            int r7 = 23 - r7
            byte[] r0 = id.dana.riskChallenges.ui.resetpin.SelfUnfreezeActivity.PlaceComponentResult
            int r8 = 106 - r8
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L14
            r8 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L30
        L14:
            r3 = 0
            r6 = r9
            r9 = r8
            r8 = r6
        L18:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r7) goto L27
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L27:
            r3 = r0[r8]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L30:
            int r9 = r9 + r7
            int r9 = r9 + (-4)
            int r7 = r10 + 1
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r8
            r8 = r7
            r7 = r6
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.riskChallenges.ui.resetpin.SelfUnfreezeActivity.b(short, short, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 3
            int r7 = r7 + 21
            int r6 = r6 * 2
            int r6 = r6 + 75
            byte[] r0 = id.dana.riskChallenges.ui.resetpin.SelfUnfreezeActivity.$$a
            int r8 = 47 - r8
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
            goto L35
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r7) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
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
        L35:
            int r7 = r7 + r6
            int r6 = r9 + 1
            int r7 = r7 + (-7)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.riskChallenges.ui.resetpin.SelfUnfreezeActivity.c(int, byte, int, java.lang.Object[]):void");
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a((byte) (View.resolveSize(0, 0) + 94), new char[]{2, 14, 15, 7, '*', 24, 15, 16, ',', 3, 19, Typography.dollar, '\n', '+', '#', Typography.quote, 13895, 13895}, 18 - (ViewConfiguration.getScrollBarSize() >> 8), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a((byte) (TextUtils.getOffsetBefore("", 0) + 90), new char[]{28, Typography.dollar, 7, 25, 13912}, View.MeasureSpec.makeMeasureSpec(0, 0) + 5, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 930, (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 35, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a((byte) (76 - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), new char[]{20, '0', Typography.quote, ')', 21, 18, 27, ')', 7, Typography.quote, '%', 27, InputCardNumberView.DIVIDER, '#', '0', 22, 13816, 13816, 21, 6, 20, '#', '0', Typography.quote, 16, 7, 28, 20, '#', 18, 7, '#', 27, Typography.quote, ')', 18, 27, 16, InputCardNumberView.DIVIDER, 27, '\t', 27, 6, Typography.quote, 2, '\b', 21, Typography.quote}, (ViewConfiguration.getScrollBarSize() >> 8) + 48, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a((byte) (31 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)), new char[]{7, 14, 21, 20, 27, 16, 27, InputCardNumberView.DIVIDER, 20, '#', 14, '\r', 15, '*', ',', '*', 13767, 13767, 22, ',', 15, '*', 23, '\r', 22, 6, 14, Typography.quote, 28, 20, 13767, 13767, '#', 20, 6, ')', 13848, 13848, 23, 11, 11, 21, 29, '*', '0', 20, '0', '\b', 13768, 13768, 20, 27, 27, 20, 22, '.', 22, '.', Typography.dollar, 6, '0', 29, 16, 7}, (ViewConfiguration.getEdgeSlop() >> 16) + 64, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a((byte) (Drawable.resolveOpacity(0, 0) + 92), new char[]{Typography.dollar, '.', 29, 0, 27, 20, ')', '.', 13822, 13822, 29, '0', ',', '\b', 27, 11, 7, '#', '*', 20, Typography.dollar, 4, 2, 7, '\t', 27, 27, ')', 13912, 13912, 20, '0', 7, 20, ')', InputCardNumberView.DIVIDER, 6, '\b', Typography.quote, ')', 30, 27, ',', '*', InputCardNumberView.DIVIDER, 27, 1, 2, 27, 16, '#', Typography.quote, Typography.dollar, '.', 21, '\t', 7, '\b', 27, Typography.quote, 21, '\t', '\r', 14}, 63 - TextUtils.lastIndexOf("", '0', 0), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a((byte) (7 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))), new char[]{19, '\f', 2, '/', 4, 16, 13756, 13756, 21, 7, 14, 2, 19, 1, '\r', '\t', '#', 7, 6, '(', 1, 3, 1, 19, 2, InputCardNumberView.DIVIDER, 1, 7, 16, 0, 16, '!', 1, 7, 29, 14, Typography.amp, '0', 31, 22, 2, '*', 22, 25, 23, 14, 0, InputCardNumberView.DIVIDER, 3, 6, 31, '-', Typography.amp, 25, 31, '#', 30, 14, 6, 3}, (ViewConfiguration.getLongPressTimeout() >> 16) + 60, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a((byte) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 72), new char[]{14, 16, '+', 20, Typography.dollar, '.'}, 6 - TextUtils.indexOf("", ""), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.makeMeasureSpec(0, 0), (ViewConfiguration.getScrollBarSize() >> 8) + 18, (char) Color.green(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = (byte) (-PlaceComponentResult[30]);
                byte b2 = PlaceComponentResult[25];
                Object[] objArr13 = new Object[1];
                b(b, b2, (byte) (b2 | 37), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b((byte) (-PlaceComponentResult[30]), PlaceComponentResult[7], PlaceComponentResult[35], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + 55, 4 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (ViewConfiguration.getPressedStateDuration() >> 16));
                        byte b3 = $$a[78];
                        Object[] objArr16 = new Object[1];
                        c(b3, b3, $$a[53], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + 800, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 15, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 800, 15 - View.getDefaultSize(0, 0), (char) Color.argb(0, 0, 0, 0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + 815, 29 - KeyEvent.keyCodeFromString(""), (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + 800, (KeyEvent.getMaxKeyCode() >> 16) + 15, (char) (ViewConfiguration.getWindowTouchSlop() >> 8)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - View.combineMeasuredStates(0, 0), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-367983238, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 910, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 18, (char) View.resolveSizeAndState(0, 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b4 = (byte) (-PlaceComponentResult[30]);
                byte b5 = PlaceComponentResult[25];
                Object[] objArr19 = new Object[1];
                b(b4, b5, (byte) (b5 | 37), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                b((byte) (-PlaceComponentResult[30]), PlaceComponentResult[7], PlaceComponentResult[35], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 62, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 47, (char) (ViewConfiguration.getLongPressTimeout() >> 16));
                        Object[] objArr22 = new Object[1];
                        c($$a[9], (byte) ($$a[78] - 1), $$a[84], objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + PDF417Common.NUMBER_OF_CODEWORDS, Process.getGidForName("") + 36, (char) View.resolveSizeAndState(0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-367983238, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 18 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) Color.alpha(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b6 = (byte) (-PlaceComponentResult[30]);
                byte b7 = PlaceComponentResult[25];
                Object[] objArr25 = new Object[1];
                b(b6, b7, (byte) (b7 | 37), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                b((byte) (-PlaceComponentResult[30]), PlaceComponentResult[7], PlaceComponentResult[35], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - Color.green(0), KeyEvent.getDeadChar(0, 0) + 3, (char) (38968 - TextUtils.indexOf("", "", 0, 0)));
                        Object[] objArr28 = new Object[1];
                        c($$a[9], (byte) ($$a[78] - 1), $$a[84], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), Color.argb(0, 0, 0, 0) + 35, (char) View.getDefaultSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-367983238, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 19, (char) TextUtils.getTrimmedLength(""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b8 = (byte) (-PlaceComponentResult[30]);
                byte b9 = PlaceComponentResult[25];
                Object[] objArr31 = new Object[1];
                b(b8, b9, (byte) (b9 | 37), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                b((byte) (-PlaceComponentResult[30]), PlaceComponentResult[7], PlaceComponentResult[35], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + 107, 3 - Gravity.getAbsoluteGravity(0, 0), (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))));
                        Object[] objArr34 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[8], (byte) ($$a[78] - 1), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, View.resolveSize(0, 0) + 35, (char) View.resolveSizeAndState(0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-367983238, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (KeyEvent.getMaxKeyCode() >> 16), 18 - (ViewConfiguration.getEdgeSlop() >> 16), (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        Object[] objArr = new Object[1];
        a((byte) (getPackageName().length() + 87), new char[]{2, 14, 15, 7, '*', 24, 15, 16, ',', 3, 19, Typography.dollar, '\n', '+', '#', Typography.quote, 13895, 13895}, getPackageName().length() + 11, objArr);
        Class<?> cls = Class.forName((String) objArr[0]);
        try {
            Object[] objArr2 = new Object[1];
            b(PlaceComponentResult[25], PlaceComponentResult[32], PlaceComponentResult[25], objArr2);
            Class<?> cls2 = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            b(PlaceComponentResult[27], PlaceComponentResult[13], (byte) (PlaceComponentResult[59] + 1), objArr3);
            Object[] objArr4 = new Object[1];
            a((byte) (((ApplicationInfo) cls2.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 57), new char[]{28, Typography.dollar, 7, 25, 13912}, getPackageName().codePointAt(4) - 92, objArr4);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr5 = new Object[1];
                    a((byte) (getPackageName().length() + 15), new char[]{2, 14, 15, 7, '*', 24, 15, 16, 2, '*', '+', 16, '0', '(', 0, JSONLexer.EOI, '#', 24, 0, '(', '!', 19, 7, 29, 7, 21}, 26 - Color.alpha(0), objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    byte length = (byte) (super.getResources().getString(id.dana.R.string.send_money_group_total_participants).substring(0, 5).length() + 57);
                    char[] cArr = {'%', Typography.quote, 13862, 13862, 30, 14, '\f', 5, 13864, 13864, '#', 23, '#', 6, 0, JSONLexer.EOI, ',', 17};
                    try {
                        Object[] objArr6 = new Object[1];
                        b(PlaceComponentResult[25], PlaceComponentResult[32], PlaceComponentResult[25], objArr6);
                        Class<?> cls4 = Class.forName((String) objArr6[0]);
                        b(PlaceComponentResult[27], PlaceComponentResult[13], (byte) (PlaceComponentResult[59] + 1), new Object[1]);
                        Object[] objArr7 = new Object[1];
                        a(length, cArr, ((ApplicationInfo) cls4.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 15, objArr7);
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
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - ExpandableListView.getPackedPositionGroup(0L), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr8 = new Object[1];
                        a((byte) (super.getResources().getString(id.dana.R.string.mybills_error_message).substring(2, 3).codePointAt(0) - 33), new char[]{20, '0', Typography.quote, ')', 21, 18, 27, ')', 7, Typography.quote, '%', 27, InputCardNumberView.DIVIDER, '#', '0', 22, 13816, 13816, 21, 6, 20, '#', '0', Typography.quote, 16, 7, 28, 20, '#', 18, 7, '#', 27, Typography.quote, ')', 18, 27, 16, InputCardNumberView.DIVIDER, 27, '\t', 27, 6, Typography.quote, 2, '\b', 21, Typography.quote}, getPackageName().codePointAt(5) - 62, objArr8);
                        String str = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        a((byte) (31 - KeyEvent.normalizeMetaState(0)), new char[]{7, 14, 21, 20, 27, 16, 27, InputCardNumberView.DIVIDER, 20, '#', 14, '\r', 15, '*', ',', '*', 13767, 13767, 22, ',', 15, '*', 23, '\r', 22, 6, 14, Typography.quote, 28, 20, 13767, 13767, '#', 20, 6, ')', 13848, 13848, 23, 11, 11, 21, 29, '*', '0', 20, '0', '\b', 13768, 13768, 20, 27, 27, 20, 22, '.', 22, '.', Typography.dollar, 6, '0', 29, 16, 7}, super.getResources().getString(id.dana.R.string.daily_limit_description_helper).substring(3, 4).codePointAt(0) - 33, objArr9);
                        String str2 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        a((byte) (super.getResources().getString(id.dana.R.string.family_account_text_resend_invitation_error).substring(1, 2).codePointAt(0) - 5), new char[]{Typography.dollar, '.', 29, 0, 27, 20, ')', '.', 13822, 13822, 29, '0', ',', '\b', 27, 11, 7, '#', '*', 20, Typography.dollar, 4, 2, 7, '\t', 27, 27, ')', 13912, 13912, 20, '0', 7, 20, ')', InputCardNumberView.DIVIDER, 6, '\b', Typography.quote, ')', 30, 27, ',', '*', InputCardNumberView.DIVIDER, 27, 1, 2, 27, 16, '#', Typography.quote, Typography.dollar, '.', 21, '\t', 7, '\b', 27, Typography.quote, 21, '\t', '\r', 14}, super.getResources().getString(id.dana.R.string.first_time_phone_number_smart_friction).substring(4, 5).codePointAt(0) + 32, objArr10);
                        String str3 = (String) objArr10[0];
                        try {
                            Object[] objArr11 = new Object[1];
                            b(PlaceComponentResult[25], PlaceComponentResult[32], PlaceComponentResult[25], objArr11);
                            Class<?> cls5 = Class.forName((String) objArr11[0]);
                            b(PlaceComponentResult[27], PlaceComponentResult[13], (byte) (PlaceComponentResult[59] + 1), new Object[1]);
                            Object[] objArr12 = new Object[1];
                            a((byte) (((ApplicationInfo) cls5.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 26), new char[]{19, '\f', 2, '/', 4, 16, 13756, 13756, 21, 7, 14, 2, 19, 1, '\r', '\t', '#', 7, 6, '(', 1, 3, 1, 19, 2, InputCardNumberView.DIVIDER, 1, 7, 16, 0, 16, '!', 1, 7, 29, 14, Typography.amp, '0', 31, 22, 2, '*', 22, 25, 23, 14, 0, InputCardNumberView.DIVIDER, 3, 6, 31, '-', Typography.amp, 25, 31, '#', 30, 14, 6, 3}, getPackageName().codePointAt(4) - 37, objArr12);
                            String str4 = (String) objArr12[0];
                            Object[] objArr13 = new Object[1];
                            a((byte) (super.getResources().getString(id.dana.R.string.dialog_contact_us_call).substring(1, 2).codePointAt(0) - 25), new char[]{14, 16, '+', 20, Typography.dollar, '.'}, 6 - (ViewConfiguration.getFadingEdgeLength() >> 16), objArr13);
                            try {
                                Object[] objArr14 = {baseContext, str, str2, str3, str4, true, (String) objArr13[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.combineMeasuredStates(0, 0) + 911, (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 18, (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = (byte) (-PlaceComponentResult[30]);
                byte b2 = PlaceComponentResult[25];
                Object[] objArr15 = new Object[1];
                b(b, b2, (byte) (b2 | 37), objArr15);
                Class<?> cls6 = Class.forName((String) objArr15[0]);
                Object[] objArr16 = new Object[1];
                b((byte) (-PlaceComponentResult[30]), PlaceComponentResult[7], PlaceComponentResult[35], objArr16);
                try {
                    Object[] objArr17 = {Integer.valueOf(((Integer) cls6.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 494, 4 - KeyEvent.keyCodeFromString(""), (char) (ViewConfiguration.getScrollBarSize() >> 8));
                        Object[] objArr18 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[8], (byte) ($$a[78] - 1), objArr18);
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
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollBarSize() >> 8), 36 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) KeyEvent.keyCodeFromString(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(null, null);
                            try {
                                Object[] objArr20 = {763502963, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.alpha(0), 19 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
            Object[] objArr = new Object[1];
            a((byte) (21 - TextUtils.lastIndexOf("", '0')), new char[]{2, 14, 15, 7, '*', 24, 15, 16, 2, '*', '+', 16, '0', '(', 0, JSONLexer.EOI, '#', 24, 0, '(', '!', 19, 7, 29, 7, 21}, 27 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a((byte) (getPackageName().codePointAt(3) - 38), new char[]{'%', Typography.quote, 13862, 13862, 30, 14, '\f', 5, 13864, 13864, '#', 23, '#', 6, 0, JSONLexer.EOI, ',', 17}, super.getResources().getString(id.dana.R.string.res_0x7f130f2f_networkuserentitydata_externalsyntheticlambda4).substring(13, 14).length() + 17, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getLongPressTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (Process.myPid() >> 22), (char) View.resolveSizeAndState(0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + 911, View.MeasureSpec.getMode(0) + 18, (char) ExpandableListView.getPackedPositionType(0L))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a((byte) (Color.alpha(0) + 22), new char[]{2, 14, 15, 7, '*', 24, 15, 16, 2, '*', '+', 16, '0', '(', 0, JSONLexer.EOI, '#', 24, 0, '(', '!', 19, 7, 29, 7, 21}, getPackageName().length() + 19, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                Object[] objArr2 = new Object[1];
                b(PlaceComponentResult[25], PlaceComponentResult[32], PlaceComponentResult[25], objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b(PlaceComponentResult[27], PlaceComponentResult[13], (byte) (PlaceComponentResult[59] + 1), objArr3);
                Object[] objArr4 = new Object[1];
                a((byte) (((ApplicationInfo) cls2.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 29), new char[]{'%', Typography.quote, 13862, 13862, 30, 14, '\f', 5, 13864, 13864, '#', 23, '#', 6, 0, JSONLexer.EOI, ',', 17}, 18 - TextUtils.indexOf("", "", 0, 0), objArr4);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - TextUtils.lastIndexOf("", '0', 0), (char) KeyEvent.keyCodeFromString(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(959 - AndroidCharacter.getMirror('0'), ExpandableListView.getPackedPositionType(0L) + 18, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    public SelfUnfreezeActivity() {
        final SelfUnfreezeActivity selfUnfreezeActivity = this;
        final Function0 function0 = null;
        this.lookAheadTest = new ViewModelLazy(Reflection.getOrCreateKotlinClass(SelfUnfreezeViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.riskChallenges.ui.resetpin.SelfUnfreezeActivity$special$$inlined$viewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: id.dana.riskChallenges.ui.resetpin.SelfUnfreezeActivity$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return SelfUnfreezeActivity.this.getViewModelFactory();
            }
        }, new Function0<CreationExtras>() { // from class: id.dana.riskChallenges.ui.resetpin.SelfUnfreezeActivity$special$$inlined$viewModels$default$3
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
                    CreationExtras defaultViewModelCreationExtras = selfUnfreezeActivity.getDefaultViewModelCreationExtras();
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
    public final ActivityRiskChallengeBinding inflateViewBinding() {
        ActivityRiskChallengeBinding MyBillsEntityDataFactory = ActivityRiskChallengeBinding.MyBillsEntityDataFactory(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        if (this.MyBillsEntityDataFactory) {
            ((ResetPinLauncher) this.BuiltInFictitiousFunctionClassFactory.getValue()).BuiltInFictitiousFunctionClassFactory();
            this.MyBillsEntityDataFactory = false;
        }
    }

    public static final /* synthetic */ DanaLoadingDialogFragment access$getDanaLoading(SelfUnfreezeActivity selfUnfreezeActivity) {
        return (DanaLoadingDialogFragment) selfUnfreezeActivity.getAuthRequestContext.getValue();
    }

    public static final /* synthetic */ SelfUnfreezeViewModel access$getVm(SelfUnfreezeActivity selfUnfreezeActivity) {
        return (SelfUnfreezeViewModel) selfUnfreezeActivity.lookAheadTest.getValue();
    }

    public static final /* synthetic */ void access$redirectSelfUnfreezeH5Page(SelfUnfreezeActivity selfUnfreezeActivity) {
        KeyboardHelper.PlaceComponentResult(selfUnfreezeActivity);
        DanaH5Helper.INSTANCE.openUrl(selfUnfreezeActivity, "https://m.dana.id/m/ipg/securingAccount");
        selfUnfreezeActivity.finish();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void init() {
        Context applicationContext = getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.riskChallenges.di.provider.RiskChallengesProvider");
        }
        RiskChallengesComponent BuiltInFictitiousFunctionClassFactory = ((RiskChallengesProvider) applicationContext).provideRiskChallengesComponent().BuiltInFictitiousFunctionClassFactory();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this);
        Bundle extras = getIntent().getExtras();
        String string = extras != null ? extras.getString("KEY_PHONE_NUMBER") : null;
        if (string == null) {
            string = "";
        }
        this.PlaceComponentResult = string;
        getLifecycle().BuiltInFictitiousFunctionClassFactory((ResetPinLauncher) this.BuiltInFictitiousFunctionClassFactory.getValue());
        DanaLoadingDialogFragment danaLoadingDialogFragment = (DanaLoadingDialogFragment) this.getAuthRequestContext.getValue();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        danaLoadingDialogFragment.show(supportFragmentManager, "FullDanaLoading");
        this.MyBillsEntityDataFactory = true;
    }

    private static void a(byte b, char[] cArr, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = DatabaseTableConfigUtil;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i3 = 0; i3 < length; i3++) {
                cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
            }
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ NetworkUserEntityData$$ExternalSyntheticLambda1);
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
