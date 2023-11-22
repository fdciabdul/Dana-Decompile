package id.dana.riskChallenges.ui.passkey;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.view.FlowExtKt;
import androidx.view.HasDefaultViewModelProviderFactory;
import androidx.view.Lifecycle;
import androidx.view.LifecycleOwner;
import androidx.view.LifecycleOwnerKt;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import androidx.view.viewmodel.CreationExtras;
import id.dana.core.ui.BaseViewBindingFragment;
import id.dana.core.ui.constant.DialogType;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.core.ui.dialog.CommonDialog;
import id.dana.core.ui.dialog.DanaAlertDialog;
import id.dana.core.ui.extension.FragmentExtKt;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.passkey.Passkey;
import id.dana.riskChallenges.R;
import id.dana.riskChallenges.constant.RiskChallengeKey;
import id.dana.riskChallenges.databinding.FragmentPasskeyVerificationBinding;
import id.dana.riskChallenges.di.component.RiskChallengesComponentKt;
import id.dana.riskChallenges.domain.passkey.model.PasskeyCeremony;
import id.dana.riskChallenges.ui.passkey.PasskeyVerificationUiState;
import id.dana.riskChallenges.ui.resetpin.model.VerificationMethodModel;
import id.dana.riskChallenges.ui.util.StringWrapperExtKt;
import id.dana.riskChallenges.ui.util.model.HistoryFallbackModel;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\u0018\u0000 A2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001AB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010-\u001a\u00020.H\u0014J\u001a\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u00104\u001a\u00020.H\u0002J\u001a\u00105\u001a\u00020.2\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0014\u0010:\u001a\u00020.2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010<H\u0002J\u0010\u0010=\u001a\u00020.2\u0006\u0010;\u001a\u00020<H\u0002J\u0010\u0010>\u001a\u00020.2\u0006\u0010?\u001a\u00020\u0010H\u0002J\u0014\u0010@\u001a\u00020.2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010<H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0017\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b\u001b\u0010\u0003\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\t\u001a\u0004\b$\u0010%R\u001e\u0010'\u001a\u00020(8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006B"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/PasskeyVerificationFragment;", "Lid/dana/core/ui/BaseViewBindingFragment;", "Lid/dana/riskChallenges/databinding/FragmentPasskeyVerificationBinding;", "()V", "failedAuthStartDialog", "Lid/dana/core/ui/dialog/CommonDialog;", "getFailedAuthStartDialog", "()Lid/dana/core/ui/dialog/CommonDialog;", "failedAuthStartDialog$delegate", "Lkotlin/Lazy;", "failedVerificationDialog", "Lid/dana/core/ui/dialog/DanaAlertDialog;", "getFailedVerificationDialog", "()Lid/dana/core/ui/dialog/DanaAlertDialog;", "failedVerificationDialog$delegate", "fallbackVerificationMethod", "", "passkey", "Lid/dana/passkey/Passkey;", "kotlin.jvm.PlatformType", "getPasskey", "()Lid/dana/passkey/Passkey;", "passkey$delegate", "phoneNumber", BioUtilityBridge.SECURITY_ID, "threadExecutor", "Lid/dana/utils/concurrent/ThreadExecutor;", "getThreadExecutor$annotations", "getThreadExecutor", "()Lid/dana/utils/concurrent/ThreadExecutor;", "setThreadExecutor", "(Lid/dana/utils/concurrent/ThreadExecutor;)V", "trackerPurpose", "trackerSource", "viewModel", "Lid/dana/riskChallenges/ui/passkey/PasskeyVerificationViewModel;", "getViewModel", "()Lid/dana/riskChallenges/ui/passkey/PasskeyVerificationViewModel;", "viewModel$delegate", "viewModelFactory", "Lid/dana/core/ui/di/module/ViewModelFactory;", "getViewModelFactory", "()Lid/dana/core/ui/di/module/ViewModelFactory;", "setViewModelFactory", "(Lid/dana/core/ui/di/module/ViewModelFactory;)V", "configToolbar", "", "inflateViewBinding", "inflater", "Landroid/view/LayoutInflater;", BranchLinkConstant.PathTarget.CONTAINER, "Landroid/view/ViewGroup;", "observeEffect", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setFragmentResultCanceledOrFallback", "throwable", "", "setFragmentResultFailed", "setFragmentResultSucceed", "credentialId", "showFailedEnrollmentRiskDialog", "Companion", "feature-risk-challenges_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PasskeyVerificationFragment extends BaseViewBindingFragment<FragmentPasskeyVerificationBinding> {
    public static final Companion MyBillsEntityDataFactory = new Companion(null);
    private final Lazy DatabaseTableConfigUtil;
    private String GetContactSyncConfig;
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;
    private String NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Lazy PlaceComponentResult;
    private final Lazy getErrorConfigVersion;
    private String lookAheadTest;
    private String moveToNextValue;
    private String scheduleImpl;
    @Inject
    public ThreadExecutor threadExecutor;
    @Inject
    public ViewModelFactory viewModelFactory;

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final /* synthetic */ FragmentPasskeyVerificationBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentPasskeyVerificationBinding KClassImpl$Data$declaredNonStaticMembers$2 = FragmentPasskeyVerificationBinding.KClassImpl$Data$declaredNonStaticMembers$2(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        super.KClassImpl$Data$declaredNonStaticMembers$2();
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentPasskeyVerificationBinding) vb).BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda2.setText(getString(R.string.res_0x7f1310d4_verifypinstatemanager_executeriskchallenge_2_2));
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "");
        super.onViewCreated(view, savedInstanceState);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "");
        RiskChallengesComponentKt.BuiltInFictitiousFunctionClassFactory(requireActivity).KClassImpl$Data$declaredNonStaticMembers$2(this);
        StateFlow<PasskeyVerificationUiState> stateFlow = ((PasskeyVerificationViewModel) this.DatabaseTableConfigUtil.getValue()).PlaceComponentResult;
        Lifecycle lifecycle = getViewLifecycleOwner().getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "");
        Flow onEach = FlowKt.onEach(FlowKt.distinctUntilChanged(FlowExtKt.PlaceComponentResult(stateFlow, lifecycle)), new PasskeyVerificationFragment$observeEffect$1(this, null));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "");
        FlowKt.launchIn(onEach, LifecycleOwnerKt.PlaceComponentResult(viewLifecycleOwner));
        final PasskeyVerificationViewModel passkeyVerificationViewModel = (PasskeyVerificationViewModel) this.DatabaseTableConfigUtil.getValue();
        PasskeyCeremony.Type.Authentication authentication = PasskeyCeremony.Type.Authentication.INSTANCE;
        Intrinsics.checkNotNullParameter(authentication, "");
        passkeyVerificationViewModel.BuiltInFictitiousFunctionClassFactory.execute(new PasskeyCeremony.Params(authentication, null, null, null, 14, null), new Function1<Pair<? extends String, ? extends List<? extends VerificationMethodModel>>, Unit>() { // from class: id.dana.riskChallenges.ui.passkey.PasskeyVerificationViewModel$startPasskeyCeremony$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Pair<? extends String, ? extends List<? extends VerificationMethodModel>> pair) {
                invoke2((Pair<String, ? extends List<VerificationMethodModel>>) pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<String, ? extends List<VerificationMethodModel>> pair) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(pair, "");
                String component1 = pair.component1();
                mutableStateFlow = PasskeyVerificationViewModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                do {
                    value = mutableStateFlow.getValue();
                    PasskeyVerificationUiState passkeyVerificationUiState = (PasskeyVerificationUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new PasskeyVerificationUiState.OnPasskeyPromptOpen(component1)));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.riskChallenges.ui.passkey.PasskeyVerificationViewModel$startPasskeyCeremony$2
            /* JADX INFO: Access modifiers changed from: package-private */
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
                mutableStateFlow = PasskeyVerificationViewModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                do {
                    value = mutableStateFlow.getValue();
                    PasskeyVerificationUiState passkeyVerificationUiState = (PasskeyVerificationUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new PasskeyVerificationUiState.OnPasskeyAuthStartFailed(th)));
            }
        });
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(Throwable th) {
        if (FragmentExtKt.PlaceComponentResult(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("FALLBACK VERIFICATION: ");
            sb.append(this.scheduleImpl);
            DanaLog.MyBillsEntityDataFactory("PASSKEY", sb.toString());
            if (!(this.scheduleImpl.length() == 0)) {
                FragmentManager parentFragmentManager = getParentFragmentManager();
                Pair[] pairArr = new Pair[4];
                pairArr[0] = TuplesKt.to("KEY_RESULT", 0);
                pairArr[1] = TuplesKt.to("KEY_IS_ERROR", Boolean.TRUE);
                pairArr[2] = TuplesKt.to("KEY_TRY_TO_FALLBACK", Boolean.TRUE);
                String str = this.scheduleImpl;
                pairArr[3] = TuplesKt.to("KEY_HISTORY_FALLBACK_MODEL", new HistoryFallbackModel("PASSKEYS", str != null ? str : ""));
                parentFragmentManager.setFragmentResult("KEY_RISK_CHALLENGE_FRAGMENT", BundleKt.PlaceComponentResult(pairArr));
            } else if (th == null) {
                getParentFragmentManager().setFragmentResult("KEY_RISK_CHALLENGE_FRAGMENT", BundleKt.PlaceComponentResult(TuplesKt.to("KEY_RESULT", 0)));
            } else {
                FragmentManager parentFragmentManager2 = getParentFragmentManager();
                Pair[] pairArr2 = new Pair[3];
                pairArr2[0] = TuplesKt.to("KEY_RESULT", 0);
                pairArr2[1] = TuplesKt.to("KEY_IS_ERROR", Boolean.TRUE);
                String message = th.getMessage();
                pairArr2[2] = TuplesKt.to("KEY_ERROR_MESSAGE", message != null ? message : "");
                parentFragmentManager2.setFragmentResult("KEY_RISK_CHALLENGE_FRAGMENT", BundleKt.PlaceComponentResult(pairArr2));
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ7\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/PasskeyVerificationFragment$Companion;", "", "", "p0", "p1", "p2", "p3", "p4", "Lid/dana/riskChallenges/ui/passkey/PasskeyVerificationFragment;", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/riskChallenges/ui/passkey/PasskeyVerificationFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static PasskeyVerificationFragment MyBillsEntityDataFactory(String p0, String p1, String p2, String p3, @RiskChallengeKey String p4) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            Intrinsics.checkNotNullParameter(p3, "");
            Intrinsics.checkNotNullParameter(p4, "");
            PasskeyVerificationFragment passkeyVerificationFragment = new PasskeyVerificationFragment();
            passkeyVerificationFragment.moveToNextValue = p0;
            passkeyVerificationFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = p1;
            passkeyVerificationFragment.GetContactSyncConfig = p2;
            passkeyVerificationFragment.lookAheadTest = p3;
            passkeyVerificationFragment.scheduleImpl = p4;
            return passkeyVerificationFragment;
        }
    }

    public PasskeyVerificationFragment() {
        final PasskeyVerificationFragment passkeyVerificationFragment = this;
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: id.dana.riskChallenges.ui.passkey.PasskeyVerificationFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelFactory viewModelFactory = PasskeyVerificationFragment.this.viewModelFactory;
                if (viewModelFactory == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    viewModelFactory = null;
                }
                return viewModelFactory;
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: id.dana.riskChallenges.ui.passkey.PasskeyVerificationFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: id.dana.riskChallenges.ui.passkey.PasskeyVerificationFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) Function0.this.invoke();
            }
        });
        final Function0 function03 = null;
        this.DatabaseTableConfigUtil = FragmentViewModelLazyKt.BuiltInFictitiousFunctionClassFactory(passkeyVerificationFragment, Reflection.getOrCreateKotlinClass(PasskeyVerificationViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.riskChallenges.ui.passkey.PasskeyVerificationFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = FragmentViewModelLazyKt.PlaceComponentResult(Lazy.this).getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: id.dana.riskChallenges.ui.passkey.PasskeyVerificationFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = Function0.this;
                if (function04 == null || (creationExtras = (CreationExtras) function04.invoke()) == null) {
                    ViewModelStoreOwner PlaceComponentResult = FragmentViewModelLazyKt.PlaceComponentResult(lazy);
                    HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = PlaceComponentResult instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) PlaceComponentResult : null;
                    CreationExtras defaultViewModelCreationExtras = hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : null;
                    return defaultViewModelCreationExtras == null ? CreationExtras.Empty.INSTANCE : defaultViewModelCreationExtras;
                }
                return creationExtras;
            }
        }, function0);
        this.getErrorConfigVersion = LazyKt.lazy(new Function0<Passkey>() { // from class: id.dana.riskChallenges.ui.passkey.PasskeyVerificationFragment$passkey$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Passkey invoke() {
                return Passkey.newBuilder(PasskeyVerificationFragment.this.requireContext()).build();
            }
        });
        this.moveToNextValue = "";
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = "";
        this.GetContactSyncConfig = "";
        this.lookAheadTest = "";
        this.scheduleImpl = "";
        this.PlaceComponentResult = LazyKt.lazy(new Function0<DanaAlertDialog>() { // from class: id.dana.riskChallenges.ui.passkey.PasskeyVerificationFragment$failedVerificationDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DanaAlertDialog invoke() {
                Context requireContext = PasskeyVerificationFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "");
                DanaAlertDialog.Builder builder = new DanaAlertDialog.Builder(requireContext);
                final PasskeyVerificationFragment passkeyVerificationFragment2 = PasskeyVerificationFragment.this;
                builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = passkeyVerificationFragment2.getString(R.string.passkey_enrollment_failed_enrollment_title_dialog);
                builder.moveToNextValue = passkeyVerificationFragment2.getString(R.string.passkey_enrollment_failed_enrollment_desc_dialog);
                String string = passkeyVerificationFragment2.getString(R.string.passkey_got_it);
                Intrinsics.checkNotNullExpressionValue(string, "");
                String str = string;
                Intrinsics.checkNotNullParameter(str, "");
                builder.PrepareContext = str;
                builder.lookAheadTest = Boolean.FALSE;
                Function0<Unit> function04 = new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.passkey.PasskeyVerificationFragment$failedVerificationDialog$2$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        PasskeyVerificationFragment.this.KClassImpl$Data$declaredNonStaticMembers$2((Throwable) null);
                    }
                };
                Intrinsics.checkNotNullParameter(function04, "");
                builder.newProxyInstance = function04;
                return builder.BuiltInFictitiousFunctionClassFactory();
            }
        });
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new PasskeyVerificationFragment$failedAuthStartDialog$2(this));
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(PasskeyVerificationFragment passkeyVerificationFragment, Throwable th) {
        Intrinsics.checkNotNullParameter(passkeyVerificationFragment, "");
        passkeyVerificationFragment.KClassImpl$Data$declaredNonStaticMembers$2(th);
    }

    public static final /* synthetic */ CommonDialog MyBillsEntityDataFactory(PasskeyVerificationFragment passkeyVerificationFragment) {
        return (CommonDialog) passkeyVerificationFragment.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
    }

    public static final /* synthetic */ DanaAlertDialog PlaceComponentResult(PasskeyVerificationFragment passkeyVerificationFragment) {
        return (DanaAlertDialog) passkeyVerificationFragment.PlaceComponentResult.getValue();
    }

    public static final /* synthetic */ Passkey KClassImpl$Data$declaredNonStaticMembers$2(PasskeyVerificationFragment passkeyVerificationFragment) {
        return (Passkey) passkeyVerificationFragment.getErrorConfigVersion.getValue();
    }

    public static final /* synthetic */ PasskeyVerificationViewModel scheduleImpl(PasskeyVerificationFragment passkeyVerificationFragment) {
        return (PasskeyVerificationViewModel) passkeyVerificationFragment.DatabaseTableConfigUtil.getValue();
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(PasskeyVerificationFragment passkeyVerificationFragment, String str) {
        if (FragmentExtKt.PlaceComponentResult(passkeyVerificationFragment)) {
            passkeyVerificationFragment.getParentFragmentManager().setFragmentResult("KEY_RISK_CHALLENGE_FRAGMENT", BundleKt.PlaceComponentResult(TuplesKt.to("KEY_RESULT", -1), TuplesKt.to("KEY_PASSKEY_CREDENTIAL_ID", str)));
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(PasskeyVerificationFragment passkeyVerificationFragment, final Throwable th) {
        Context requireContext = passkeyVerificationFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "");
        CommonDialog.Builder builder = new CommonDialog.Builder(requireContext);
        builder.getAuthRequestContext = true;
        DialogType dialogType = DialogType.WARNING;
        Intrinsics.checkNotNullParameter(dialogType, "");
        builder.DatabaseTableConfigUtil = dialogType;
        builder.lookAheadTest = th != null ? StringWrapperExtKt.MyBillsEntityDataFactory(th) : null;
        builder.BuiltInFictitiousFunctionClassFactory = new DialogInterface.OnDismissListener() { // from class: id.dana.riskChallenges.ui.passkey.PasskeyVerificationFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                PasskeyVerificationFragment.KClassImpl$Data$declaredNonStaticMembers$2(PasskeyVerificationFragment.this, th);
            }
        };
        new CommonDialog(builder.PlaceComponentResult, builder.BuiltInFictitiousFunctionClassFactory, builder.MyBillsEntityDataFactory, builder).moveToNextValue();
    }
}
