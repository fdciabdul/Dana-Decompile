package id.dana.riskChallenges.ui.missedCallOtp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.view.HasDefaultViewModelProviderFactory;
import androidx.view.LifecycleOwnerKt;
import androidx.view.Observer;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import androidx.view.viewmodel.CreationExtras;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.anggrayudi.storage.permission.FragmentPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.core.ui.BaseViewBindingFragment;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.core.ui.dialog.DanaAlertDialog;
import id.dana.core.ui.dialog.DanaLoadingDialogFragment;
import id.dana.core.ui.extension.FragmentExtKt;
import id.dana.core.ui.richview.BottomInfoSnackbar;
import id.dana.core.ui.richview.InputPhoneView;
import id.dana.core.ui.richview.RetryAndTimerView;
import id.dana.core.ui.util.KeyboardHelper;
import id.dana.core.ui.util.connectivity.ConnectivityMonitor;
import id.dana.core.ui.util.connectivity.mapper.ConnectivityModelMapperKt;
import id.dana.core.ui.util.connectivity.model.ConnectivityModel;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.constant.DanaUrl;
import id.dana.data.login.source.network.model.LoginIdType;
import id.dana.domain.citcall.interactor.GetCitcallOtp;
import id.dana.domain.citcall.model.MiscallConsult;
import id.dana.domain.citcall.model.MiscallResponse;
import id.dana.riskChallenges.R;
import id.dana.riskChallenges.databinding.FragmentMissedCallOtpBinding;
import id.dana.riskChallenges.di.component.RiskChallengesComponent;
import id.dana.riskChallenges.di.provider.RiskChallengesProvider;
import id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$fourDigitsReceiver$2;
import id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$verifyCommandReceiver$2;
import id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpUIState;
import id.dana.riskChallenges.ui.util.model.TrackerModel;
import id.dana.riskChallenges.ui.util.uicomponent.UiComponent;
import id.dana.textbehavior.InvalidReason;
import id.dana.textbehavior.OnValidatedListener;
import id.dana.utils.danah5.DanaH5Facade;
import id.dana.utils.permission.ManifestPermission;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;

@Metadata(d1 = {"\u0000§\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u000e\u0018\u0000 h2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001hB\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\"2\u0006\u0010F\u001a\u00020\"H\u0002J\b\u0010G\u001a\u00020DH\u0002J\b\u0010H\u001a\u00020DH\u0002J\b\u0010I\u001a\u00020DH\u0002J\b\u0010J\u001a\u00020DH\u0002J\u001a\u0010K\u001a\u00020\u00022\u0006\u0010L\u001a\u00020M2\b\u0010N\u001a\u0004\u0018\u00010OH\u0016J\b\u0010P\u001a\u00020QH\u0002J\b\u0010R\u001a\u00020DH\u0002J\b\u0010S\u001a\u00020DH\u0002J\b\u0010T\u001a\u00020DH\u0002J\b\u0010U\u001a\u00020DH\u0016J\b\u0010V\u001a\u00020DH\u0016J\b\u0010W\u001a\u00020DH\u0016J\b\u0010X\u001a\u00020DH\u0016J\u001a\u0010Y\u001a\u00020D2\u0006\u0010Z\u001a\u00020[2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016J\b\u0010^\u001a\u00020DH\u0002J\b\u0010_\u001a\u00020DH\u0002J\u0010\u0010`\u001a\u00020D2\u0006\u0010a\u001a\u00020\"H\u0002J\u0018\u0010b\u001a\u00020D2\u000e\b\u0002\u0010c\u001a\b\u0012\u0004\u0012\u00020D0dH\u0002J\b\u0010e\u001a\u00020DH\u0002J\b\u0010f\u001a\u00020DH\u0002J\b\u0010g\u001a\u00020DH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u000b\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b%\u0010&R\u001b\u0010'\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u000b\u001a\u0004\b)\u0010*R\u000e\u0010,\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00101\u001a\u0004\u0018\u0001028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u001b\u00105\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\u000b\u001a\u0004\b6\u0010\u001fR\u001b\u00108\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\u000b\u001a\u0004\b:\u0010;R\u001e\u0010=\u001a\u00020>8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006i"}, d2 = {"Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpFragment;", "Lid/dana/core/ui/BaseViewBindingFragment;", "Lid/dana/riskChallenges/databinding/FragmentMissedCallOtpBinding;", "()V", "allPermission", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "bottomInfoSnackbar", "Lid/dana/core/ui/richview/BottomInfoSnackbar;", "getBottomInfoSnackbar", "()Lid/dana/core/ui/richview/BottomInfoSnackbar;", "bottomInfoSnackbar$delegate", "Lkotlin/Lazy;", "callPhonePermission", "callbackPermission", "id/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpFragment$callbackPermission$1", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpFragment$callbackPermission$1;", "connectivityMonitor", "Lid/dana/core/ui/util/connectivity/ConnectivityMonitor;", "getConnectivityMonitor", "()Lid/dana/core/ui/util/connectivity/ConnectivityMonitor;", "connectivityMonitor$delegate", "danaH5Facade", "Ldagger/Lazy;", "Lid/dana/utils/danah5/DanaH5Facade;", "getDanaH5Facade", "()Ldagger/Lazy;", "setDanaH5Facade", "(Ldagger/Lazy;)V", "fourDigitsReceiver", "Landroid/content/BroadcastReceiver;", "getFourDigitsReceiver", "()Landroid/content/BroadcastReceiver;", "fourDigitsReceiver$delegate", "isAutoFill", "", "value", "isConnected", "setConnected", "(Z)V", "loadingDialog", "Lid/dana/core/ui/dialog/DanaLoadingDialogFragment;", "getLoadingDialog", "()Lid/dana/core/ui/dialog/DanaLoadingDialogFragment;", "loadingDialog$delegate", "readCallLogPermission", "riskChallengesComponent", "Lid/dana/riskChallenges/di/component/RiskChallengesComponent;", "titleToolbar", "", "uiComponent", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "getUiComponent", "()Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "verifyCommandReceiver", "getVerifyCommandReceiver", "verifyCommandReceiver$delegate", "viewModel", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpViewModel;", "getViewModel", "()Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpViewModel;", "viewModel$delegate", "viewModelFactory", "Lid/dana/core/ui/di/module/ViewModelFactory;", "getViewModelFactory", "()Lid/dana/core/ui/di/module/ViewModelFactory;", "setViewModelFactory", "(Lid/dana/core/ui/di/module/ViewModelFactory;)V", "buildPermission", "", "enableReadCallLog", "enableCallPhone", "clearPhoneNumberText", "dismissDialog", "forceSetConnected", "getArgs", "inflateViewBinding", "inflater", "Landroid/view/LayoutInflater;", BranchLinkConstant.PathTarget.CONTAINER, "Landroid/view/ViewGroup;", "initRequestData", "Lid/dana/domain/citcall/model/MiscallConsult;", "initToolbar", "initView", "observeUiState", "onBackPressed", "onPause", "onResume", "onStart", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "publishConnectionBarMonitor", "setFragmentResultCancel", "setInputPhoneNumberStatus", "active", "showKeyboard", "onShow", "Lkotlin/Function0;", "showMaxAttemptsReached", "showProgress", "verifyAutoFillWhenConnected", "Companion", "feature-risk-challenges_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MissedCallOtpFragment extends BaseViewBindingFragment<FragmentMissedCallOtpBinding> {
    public static final Companion MyBillsEntityDataFactory = new Companion(null);
    private final Lazy DatabaseTableConfigUtil;
    private boolean GetContactSyncConfig;
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda0 = LazyKt.lazy(new Function0<ConnectivityMonitor>() { // from class: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$connectivityMonitor$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ConnectivityMonitor invoke() {
            Context requireContext = MissedCallOtpFragment.this.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "");
            return new ConnectivityMonitor(requireContext);
        }
    });
    private final FragmentPermissionRequest NetworkUserEntityData$$ExternalSyntheticLambda1;
    private String NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final FragmentPermissionRequest PlaceComponentResult;
    @Inject
    public dagger.Lazy<DanaH5Facade> danaH5Facade;
    private final MissedCallOtpFragment$callbackPermission$1 getErrorConfigVersion;
    private RiskChallengesComponent initRecordTimeStamp;
    private final Lazy isLayoutRequested;
    private final FragmentPermissionRequest lookAheadTest;
    private boolean moveToNextValue;
    private final Lazy scheduleImpl;
    @Inject
    public ViewModelFactory viewModelFactory;

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final /* synthetic */ FragmentMissedCallOtpBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentMissedCallOtpBinding authRequestContext = FragmentMissedCallOtpBinding.getAuthRequestContext(layoutInflater, viewGroup);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    @JvmName(name = "getUiComponent")
    private final UiComponent BuiltInFictitiousFunctionClassFactory() {
        Object obj;
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                obj = (Parcelable) arguments.getParcelable("KEY_UI_COMPONENT", UiComponent.class);
            } else {
                Object parcelable = arguments.getParcelable("KEY_UI_COMPONENT");
                obj = (Parcelable) ((UiComponent) (parcelable instanceof UiComponent ? parcelable : null));
            }
            return (UiComponent) obj;
        }
        return null;
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "");
        super.onViewCreated(view, savedInstanceState);
        Context applicationContext = requireActivity().getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.riskChallenges.di.provider.RiskChallengesProvider");
        }
        RiskChallengesComponent BuiltInFictitiousFunctionClassFactory = ((RiskChallengesProvider) applicationContext).provideRiskChallengesComponent().BuiltInFictitiousFunctionClassFactory();
        this.initRecordTimeStamp = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(this), null, null, new MissedCallOtpFragment$observeUiState$1(this, null), 3, null);
        MissedCallOtpViewModel missedCallOtpViewModel = (MissedCallOtpViewModel) this.isLayoutRequested.getValue();
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("KEY_PHONE_NUMBER") : null;
        if (string == null) {
            string = "";
        }
        Intrinsics.checkNotNullParameter(string, "");
        missedCallOtpViewModel.BuiltInFictitiousFunctionClassFactory = string;
        UiComponent BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = BuiltInFictitiousFunctionClassFactory2 != null ? getString(BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory) : null;
        MissedCallOtpViewModel missedCallOtpViewModel2 = (MissedCallOtpViewModel) this.isLayoutRequested.getValue();
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString("KEY_SECURITY_ID") : null;
        if (string2 == null) {
            string2 = "";
        }
        Intrinsics.checkNotNullParameter(string2, "");
        missedCallOtpViewModel2.lookAheadTest = string2;
        MissedCallOtpViewModel missedCallOtpViewModel3 = (MissedCallOtpViewModel) this.isLayoutRequested.getValue();
        Bundle arguments3 = getArguments();
        String string3 = arguments3 != null ? arguments3.getString("KEY_USE_CASE_STRATEGY") : null;
        if (string3 == null) {
            string3 = "";
        }
        Intrinsics.checkNotNullParameter(string3, "");
        missedCallOtpViewModel3.getErrorConfigVersion = string3;
        MissedCallOtpViewModel missedCallOtpViewModel4 = (MissedCallOtpViewModel) this.isLayoutRequested.getValue();
        Bundle arguments4 = getArguments();
        missedCallOtpViewModel4.MyBillsEntityDataFactory = arguments4 != null ? arguments4.getString("KEY_RISK_TOKEN") : null;
        UiComponent BuiltInFictitiousFunctionClassFactory3 = BuiltInFictitiousFunctionClassFactory();
        if (BuiltInFictitiousFunctionClassFactory3 != null) {
            VB vb = this.PlaceComponentResult;
            if (vb != 0) {
                ((FragmentMissedCallOtpBinding) vb).MyBillsEntityDataFactory.setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(requireContext(), BuiltInFictitiousFunctionClassFactory3.MyBillsEntityDataFactory));
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        VB vb2 = this.PlaceComponentResult;
        if (vb2 != 0) {
            RetryAndTimerView retryAndTimerView = ((FragmentMissedCallOtpBinding) vb2).scheduleImpl;
            Intrinsics.checkNotNullExpressionValue(retryAndTimerView, "");
            retryAndTimerView.setVisibility(8);
            retryAndTimerView.setEnable(true);
            retryAndTimerView.setHasFallback(false);
            retryAndTimerView.setResendText(R.string.res_0x7f130e73_networkuserentitydata_externalsyntheticlambda6);
            retryAndTimerView.setOnTryAgainClick(new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$initView$2$1
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
                    VB vb3 = MissedCallOtpFragment.this.PlaceComponentResult;
                    if (vb3 != 0) {
                        ((FragmentMissedCallOtpBinding) vb3).PlaceComponentResult.getInput().requestFocus();
                        final MissedCallOtpViewModel moveToNextValue = MissedCallOtpFragment.moveToNextValue(MissedCallOtpFragment.this);
                        MiscallConsult NetworkUserEntityData$$ExternalSyntheticLambda0 = MissedCallOtpFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(MissedCallOtpFragment.this);
                        Intrinsics.checkNotNullParameter(NetworkUserEntityData$$ExternalSyntheticLambda0, "");
                        MutableStateFlow<MissedCallOtpUIState> mutableStateFlow = moveToNextValue.PlaceComponentResult;
                        do {
                        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), MissedCallOtpUIState.ShowResendProgress.INSTANCE));
                        moveToNextValue.getAuthRequestContext.get().execute(new GetCitcallOtp.Param(NetworkUserEntityData$$ExternalSyntheticLambda0), new Function1<MiscallResponse, Unit>() { // from class: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpViewModel$resendRequestOTP$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(MiscallResponse miscallResponse) {
                                invoke2(miscallResponse);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(MiscallResponse miscallResponse) {
                                MutableStateFlow mutableStateFlow2;
                                Object value;
                                MutableStateFlow mutableStateFlow3;
                                Object value2;
                                MutableStateFlow mutableStateFlow4;
                                Object value3;
                                MutableStateFlow mutableStateFlow5;
                                Object value4;
                                MutableStateFlow mutableStateFlow6;
                                Object value5;
                                Intrinsics.checkNotNullParameter(miscallResponse, "");
                                mutableStateFlow2 = MissedCallOtpViewModel.this.PlaceComponentResult;
                                do {
                                    value = mutableStateFlow2.getValue();
                                    MissedCallOtpUIState missedCallOtpUIState = (MissedCallOtpUIState) value;
                                } while (!mutableStateFlow2.compareAndSet(value, MissedCallOtpUIState.DismissResendProgress.INSTANCE));
                                mutableStateFlow3 = MissedCallOtpViewModel.this.PlaceComponentResult;
                                do {
                                    value2 = mutableStateFlow3.getValue();
                                    MissedCallOtpUIState missedCallOtpUIState2 = (MissedCallOtpUIState) value2;
                                } while (!mutableStateFlow3.compareAndSet(value2, new MissedCallOtpUIState.Success(miscallResponse)));
                                mutableStateFlow4 = MissedCallOtpViewModel.this.PlaceComponentResult;
                                do {
                                    value3 = mutableStateFlow4.getValue();
                                    MissedCallOtpUIState missedCallOtpUIState3 = (MissedCallOtpUIState) value3;
                                } while (!mutableStateFlow4.compareAndSet(value3, MissedCallOtpUIState.None.INSTANCE));
                                mutableStateFlow5 = MissedCallOtpViewModel.this.PlaceComponentResult;
                                do {
                                    value4 = mutableStateFlow5.getValue();
                                    MissedCallOtpUIState missedCallOtpUIState4 = (MissedCallOtpUIState) value4;
                                } while (!mutableStateFlow5.compareAndSet(value4, MissedCallOtpUIState.ResendOTPSuccess.INSTANCE));
                                mutableStateFlow6 = MissedCallOtpViewModel.this.PlaceComponentResult;
                                do {
                                    value5 = mutableStateFlow6.getValue();
                                    MissedCallOtpUIState missedCallOtpUIState5 = (MissedCallOtpUIState) value5;
                                } while (!mutableStateFlow6.compareAndSet(value5, MissedCallOtpUIState.None.INSTANCE));
                            }
                        }, new Function1<Throwable, Unit>() { // from class: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpViewModel$resendRequestOTP$3
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
                                MutableStateFlow mutableStateFlow2;
                                Object value;
                                Intrinsics.checkNotNullParameter(th, "");
                                mutableStateFlow2 = MissedCallOtpViewModel.this.PlaceComponentResult;
                                do {
                                    value = mutableStateFlow2.getValue();
                                    MissedCallOtpUIState missedCallOtpUIState = (MissedCallOtpUIState) value;
                                } while (!mutableStateFlow2.compareAndSet(value, MissedCallOtpUIState.DismissResendProgress.INSTANCE));
                                MissedCallOtpViewModel.getAuthRequestContext(MissedCallOtpViewModel.this, th, false);
                            }
                        });
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            });
            VB vb3 = this.PlaceComponentResult;
            if (vb3 != 0) {
                InputPhoneView inputPhoneView = ((FragmentMissedCallOtpBinding) vb3).PlaceComponentResult;
                inputPhoneView.setPrefix("+62");
                inputPhoneView.getInput().setHint("");
                inputPhoneView.setOnValidatedListener(new OnValidatedListener() { // from class: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$initView$3$1
                    @Override // id.dana.textbehavior.OnValidatedListener
                    public final void MyBillsEntityDataFactory(String p0, List<InvalidReason> p1) {
                    }

                    @Override // id.dana.textbehavior.OnValidatedListener
                    public final void getAuthRequestContext(String p0) {
                        boolean z;
                        z = MissedCallOtpFragment.this.moveToNextValue;
                        if (z) {
                            return;
                        }
                        MissedCallOtpViewModel moveToNextValue = MissedCallOtpFragment.moveToNextValue(MissedCallOtpFragment.this);
                        if (p0 == null) {
                            p0 = "";
                        }
                        moveToNextValue.MyBillsEntityDataFactory(p0, MissedCallOtpFragment.moveToNextValue(MissedCallOtpFragment.this).lookAheadTest, MissedCallOtpFragment.moveToNextValue(MissedCallOtpFragment.this).BuiltInFictitiousFunctionClassFactory, MissedCallOtpFragment.moveToNextValue(MissedCallOtpFragment.this).getErrorConfigVersion);
                    }
                });
                MDUtil.INSTANCE.textChanged(inputPhoneView.getInput(), new Function1<CharSequence, Unit>() { // from class: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$initView$3$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(CharSequence charSequence) {
                        invoke2(charSequence);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(CharSequence charSequence) {
                        Intrinsics.checkNotNullParameter(charSequence, "");
                        VB vb4 = MissedCallOtpFragment.this.PlaceComponentResult;
                        if (vb4 != 0) {
                            ((FragmentMissedCallOtpBinding) vb4).PlaceComponentResult.setNormalViewV2();
                            MissedCallOtpFragment.scheduleImpl(MissedCallOtpFragment.this).dismiss();
                            return;
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                });
                VB vb4 = this.PlaceComponentResult;
                if (vb4 != 0) {
                    ((FragmentMissedCallOtpBinding) vb4).moveToNextValue.PlaceComponentResult.setText(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                    VB vb5 = this.PlaceComponentResult;
                    if (vb5 != 0) {
                        AppCompatImageView appCompatImageView = ((FragmentMissedCallOtpBinding) vb5).moveToNextValue.BuiltInFictitiousFunctionClassFactory;
                        int i = R.drawable.getAuthRequestContext;
                        if (appCompatImageView instanceof ImageView) {
                            InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
                        } else {
                            appCompatImageView.setImageResource(i);
                        }
                        VB vb6 = this.PlaceComponentResult;
                        if (vb6 != 0) {
                            ((FragmentMissedCallOtpBinding) vb6).moveToNextValue.BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$$ExternalSyntheticLambda2
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view2) {
                                    MissedCallOtpFragment.PlaceComponentResult(MissedCallOtpFragment.this);
                                }
                            });
                            VB vb7 = this.PlaceComponentResult;
                            if (vb7 != 0) {
                                ((FragmentMissedCallOtpBinding) vb7).moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2.inflateMenu(R.menu.BuiltInFictitiousFunctionClassFactory);
                                VB vb8 = this.PlaceComponentResult;
                                if (vb8 != 0) {
                                    ((FragmentMissedCallOtpBinding) vb8).moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() { // from class: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$$ExternalSyntheticLambda3
                                        @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
                                        public final boolean KClassImpl$Data$declaredNonStaticMembers$2(MenuItem menuItem) {
                                            boolean PlaceComponentResult;
                                            PlaceComponentResult = MissedCallOtpFragment.PlaceComponentResult(MissedCallOtpFragment.this, menuItem);
                                            return PlaceComponentResult;
                                        }
                                    });
                                    ((ConnectivityMonitor) this.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue()).PlaceComponentResult(getViewLifecycleOwner(), new Observer() { // from class: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$$ExternalSyntheticLambda0
                                        @Override // androidx.view.Observer
                                        public final void onChanged(Object obj) {
                                            MissedCallOtpFragment.getAuthRequestContext(MissedCallOtpFragment.this, (ConnectivityModel) obj);
                                        }
                                    });
                                    return;
                                }
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PhoneStateReceiver.ACTION_LAST_FOUR_DIGIT);
        intentFilter.addAction(PhoneStateReceiver.ACTION_VERIFY);
        ContextCompat.PlaceComponentResult(requireContext(), (BroadcastReceiver) this.scheduleImpl.getValue(), intentFilter, "android.permission.READ_PHONE_STATE", null, 4);
        ContextCompat.PlaceComponentResult(requireContext(), (BroadcastReceiver) this.NetworkUserEntityData$$ExternalSyntheticLambda7.getValue(), intentFilter, "android.permission.READ_PHONE_STATE", null, 4);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        PlaceComponentResult();
    }

    public final void PlaceComponentResult() {
        if (this.moveToNextValue && this.GetContactSyncConfig) {
            MissedCallOtpViewModel missedCallOtpViewModel = (MissedCallOtpViewModel) this.isLayoutRequested.getValue();
            VB vb = this.PlaceComponentResult;
            if (vb != 0) {
                missedCallOtpViewModel.MyBillsEntityDataFactory(((FragmentMissedCallOtpBinding) vb).PlaceComponentResult.getInput().getText().toString(), ((MissedCallOtpViewModel) this.isLayoutRequested.getValue()).lookAheadTest, ((MissedCallOtpViewModel) this.isLayoutRequested.getValue()).BuiltInFictitiousFunctionClassFactory, ((MissedCallOtpViewModel) this.isLayoutRequested.getValue()).getErrorConfigVersion);
                this.moveToNextValue = false;
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.unregisterReceiver((BroadcastReceiver) this.scheduleImpl.getValue());
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.unregisterReceiver((BroadcastReceiver) this.NetworkUserEntityData$$ExternalSyntheticLambda7.getValue());
        }
        ((ConnectivityMonitor) this.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue()).PlaceComponentResult(getViewLifecycleOwner());
    }

    public static final boolean PlaceComponentResult(MissedCallOtpFragment missedCallOtpFragment, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(missedCallOtpFragment, "");
        if (menuItem.getItemId() == R.id.option_help) {
            dagger.Lazy<DanaH5Facade> lazy = missedCallOtpFragment.danaH5Facade;
            if (lazy == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                lazy = null;
            }
            lazy.get().startContainerFullUrl(DanaUrl.DANA_OTP_ARTICLE);
            return false;
        }
        return false;
    }

    private final void MyBillsEntityDataFactory() {
        getParentFragmentManager().setFragmentResult("KEY_RISK_CHALLENGE_FRAGMENT", BundleKt.PlaceComponentResult(TuplesKt.to("KEY_RESULT", 0)));
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJC\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpFragment$Companion;", "", "", "p0", "p1", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "p2", "p3", "p4", "Lid/dana/riskChallenges/ui/util/model/TrackerModel;", "p5", "Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpFragment;", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;Ljava/lang/String;Ljava/lang/String;Lid/dana/riskChallenges/ui/util/model/TrackerModel;)Lid/dana/riskChallenges/ui/missedCallOtp/MissedCallOtpFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static MissedCallOtpFragment getAuthRequestContext(String p0, String p1, UiComponent p2, String p3, String p4, TrackerModel p5) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p3, "");
            Intrinsics.checkNotNullParameter(p5, "");
            MissedCallOtpFragment missedCallOtpFragment = new MissedCallOtpFragment();
            missedCallOtpFragment.setArguments(BundleKt.PlaceComponentResult(TuplesKt.to("KEY_PHONE_NUMBER", p0), TuplesKt.to("KEY_UI_COMPONENT", p2), TuplesKt.to("KEY_SECURITY_ID", p1), TuplesKt.to("KEY_USE_CASE_STRATEGY", p3), TuplesKt.to("KEY_RISK_TOKEN", p4), TuplesKt.to("KEY_TRACKER_MODEL", p5)));
            return missedCallOtpFragment;
        }
    }

    /* JADX WARN: Type inference failed for: r1v15, types: [id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$callbackPermission$1] */
    public MissedCallOtpFragment() {
        final MissedCallOtpFragment missedCallOtpFragment = this;
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelFactory viewModelFactory = MissedCallOtpFragment.this.viewModelFactory;
                if (viewModelFactory == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    viewModelFactory = null;
                }
                return viewModelFactory;
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$special$$inlined$viewModels$default$2
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
        this.isLayoutRequested = FragmentViewModelLazyKt.BuiltInFictitiousFunctionClassFactory(missedCallOtpFragment, Reflection.getOrCreateKotlinClass(MissedCallOtpViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$special$$inlined$viewModels$default$4
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
        this.DatabaseTableConfigUtil = LazyKt.lazy(new Function0<DanaLoadingDialogFragment>() { // from class: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$loadingDialog$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DanaLoadingDialogFragment invoke() {
                return new DanaLoadingDialogFragment();
            }
        });
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<BottomInfoSnackbar>() { // from class: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$bottomInfoSnackbar$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BottomInfoSnackbar invoke() {
                BottomInfoSnackbar.Companion companion = BottomInfoSnackbar.INSTANCE;
                VB vb = MissedCallOtpFragment.this.PlaceComponentResult;
                if (vb != 0) {
                    ConstraintLayout constraintLayout = ((FragmentMissedCallOtpBinding) vb).MyBillsEntityDataFactory;
                    Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
                    return BottomInfoSnackbar.Companion.getAuthRequestContext(constraintLayout);
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        });
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = LazyKt.lazy(new Function0<MissedCallOtpFragment$verifyCommandReceiver$2.AnonymousClass1>() { // from class: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$verifyCommandReceiver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$verifyCommandReceiver$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                final MissedCallOtpFragment missedCallOtpFragment2 = MissedCallOtpFragment.this;
                return new BroadcastReceiver() { // from class: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$verifyCommandReceiver$2.1
                    @Override // android.content.BroadcastReceiver
                    public final void onReceive(Context context, Intent intent) {
                        Intrinsics.checkNotNullParameter(intent, "");
                        if (intent.hasExtra(PhoneStateReceiver.VERIFY) && intent.getBooleanExtra(PhoneStateReceiver.VERIFY, false)) {
                            MissedCallOtpFragment.this.PlaceComponentResult();
                            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(r2), Dispatchers.getIO(), null, new MissedCallOtpFragment$forceSetConnected$1(MissedCallOtpFragment.this, null), 2, null);
                        }
                    }
                };
            }
        });
        this.scheduleImpl = LazyKt.lazy(new Function0<MissedCallOtpFragment$fourDigitsReceiver$2.AnonymousClass1>() { // from class: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$fourDigitsReceiver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$fourDigitsReceiver$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                final MissedCallOtpFragment missedCallOtpFragment2 = MissedCallOtpFragment.this;
                return new BroadcastReceiver() { // from class: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$fourDigitsReceiver$2.1
                    @Override // android.content.BroadcastReceiver
                    public final void onReceive(Context context, Intent intent) {
                        Intrinsics.checkNotNullParameter(intent, "");
                        String stringExtra = intent.getStringExtra(PhoneStateReceiver.LAST_FOUR_DIGIT);
                        String str = stringExtra;
                        if ((str == null || str.length() == 0) || Intrinsics.areEqual(stringExtra, "null")) {
                            return;
                        }
                        MissedCallOtpFragment.this.moveToNextValue = true;
                        VB vb = MissedCallOtpFragment.this.PlaceComponentResult;
                        if (vb != 0) {
                            ((FragmentMissedCallOtpBinding) vb).PlaceComponentResult.setInput(stringExtra);
                            VB vb2 = MissedCallOtpFragment.this.PlaceComponentResult;
                            if (vb2 != 0) {
                                ((FragmentMissedCallOtpBinding) vb2).PlaceComponentResult.getInput().setSelection(stringExtra.length());
                                return;
                            }
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                };
            }
        });
        ?? r1 = new PermissionCallback() { // from class: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$callbackPermission$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                MissedCallOtpFragment.moveToNextValue(MissedCallOtpFragment.this).PlaceComponentResult(MissedCallOtpFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(MissedCallOtpFragment.this));
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onShouldRedirectToSystemSettings(List<PermissionReport> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                MissedCallOtpFragment.moveToNextValue(MissedCallOtpFragment.this).PlaceComponentResult(MissedCallOtpFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(MissedCallOtpFragment.this));
            }
        };
        this.getErrorConfigVersion = r1;
        FragmentPermissionRequest.Builder builder = new FragmentPermissionRequest.Builder(missedCallOtpFragment);
        String[] strArr = {ManifestPermission.READ_CALL_LOG, "android.permission.CALL_PHONE", "android.permission.READ_PHONE_STATE"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.getAuthRequestContext = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = (PermissionCallback) r1;
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.BuiltInFictitiousFunctionClassFactory = permissionCallback;
        this.PlaceComponentResult = builder.PlaceComponentResult();
        FragmentPermissionRequest.Builder builder2 = new FragmentPermissionRequest.Builder(missedCallOtpFragment);
        String[] strArr2 = {ManifestPermission.READ_CALL_LOG, "android.permission.READ_PHONE_STATE"};
        Intrinsics.checkNotNullParameter(strArr2, "");
        builder2.getAuthRequestContext = ArraysKt.toSet(strArr2);
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder2.BuiltInFictitiousFunctionClassFactory = permissionCallback;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = builder2.PlaceComponentResult();
        FragmentPermissionRequest.Builder builder3 = new FragmentPermissionRequest.Builder(missedCallOtpFragment);
        String[] strArr3 = {"android.permission.CALL_PHONE", "android.permission.READ_PHONE_STATE"};
        Intrinsics.checkNotNullParameter(strArr3, "");
        builder3.getAuthRequestContext = ArraysKt.toSet(strArr3);
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder3.BuiltInFictitiousFunctionClassFactory = permissionCallback;
        this.lookAheadTest = builder3.PlaceComponentResult();
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(MissedCallOtpFragment missedCallOtpFragment) {
        Intrinsics.checkNotNullParameter(missedCallOtpFragment, "");
        VB vb = missedCallOtpFragment.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentMissedCallOtpBinding) vb).PlaceComponentResult.getInput().clearFocus();
            KeyboardHelper.getAuthRequestContext(missedCallOtpFragment.getGetAuthRequestContext());
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static /* synthetic */ void getAuthRequestContext(EditText editText, MissedCallOtpFragment missedCallOtpFragment, Function0 function0) {
        Intrinsics.checkNotNullParameter(missedCallOtpFragment, "");
        Intrinsics.checkNotNullParameter(function0, "");
        editText.requestFocus();
        FragmentActivity activity = missedCallOtpFragment.getActivity();
        if (activity != null) {
            KeyboardHelper.getAuthRequestContext((Activity) activity);
            function0.invoke();
        }
    }

    public static /* synthetic */ void PlaceComponentResult(MissedCallOtpFragment missedCallOtpFragment) {
        Intrinsics.checkNotNullParameter(missedCallOtpFragment, "");
        missedCallOtpFragment.MyBillsEntityDataFactory();
    }

    public static /* synthetic */ void getAuthRequestContext(MissedCallOtpFragment missedCallOtpFragment, ConnectivityModel connectivityModel) {
        Intrinsics.checkNotNullParameter(missedCallOtpFragment, "");
        Intrinsics.checkNotNullExpressionValue(connectivityModel, "");
        missedCallOtpFragment.GetContactSyncConfig = ConnectivityModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(connectivityModel);
        missedCallOtpFragment.PlaceComponentResult();
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(MissedCallOtpFragment missedCallOtpFragment, boolean z, boolean z2) {
        if (z && z2) {
            missedCallOtpFragment.PlaceComponentResult.check();
        } else if (z2) {
            missedCallOtpFragment.lookAheadTest.check();
        } else {
            missedCallOtpFragment.NetworkUserEntityData$$ExternalSyntheticLambda1.check();
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(MissedCallOtpFragment missedCallOtpFragment) {
        VB vb = missedCallOtpFragment.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentMissedCallOtpBinding) vb).PlaceComponentResult.clearText();
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ BottomInfoSnackbar scheduleImpl(MissedCallOtpFragment missedCallOtpFragment) {
        return (BottomInfoSnackbar) missedCallOtpFragment.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
    }

    public static final /* synthetic */ ConnectivityMonitor getErrorConfigVersion(MissedCallOtpFragment missedCallOtpFragment) {
        return (ConnectivityMonitor) missedCallOtpFragment.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue();
    }

    public static final /* synthetic */ MissedCallOtpViewModel moveToNextValue(MissedCallOtpFragment missedCallOtpFragment) {
        return (MissedCallOtpViewModel) missedCallOtpFragment.isLayoutRequested.getValue();
    }

    public static final /* synthetic */ MiscallConsult NetworkUserEntityData$$ExternalSyntheticLambda0(MissedCallOtpFragment missedCallOtpFragment) {
        return new MiscallConsult(((MissedCallOtpViewModel) missedCallOtpFragment.isLayoutRequested.getValue()).BuiltInFictitiousFunctionClassFactory, LoginIdType.MOBILE_NO, "REGISTER", ((MissedCallOtpViewModel) missedCallOtpFragment.isLayoutRequested.getValue()).BuiltInFictitiousFunctionClassFactory);
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda1(MissedCallOtpFragment missedCallOtpFragment) {
        missedCallOtpFragment.GetContactSyncConfig = true;
        missedCallOtpFragment.PlaceComponentResult();
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(MissedCallOtpFragment missedCallOtpFragment, boolean z) {
        if (z) {
            VB vb = missedCallOtpFragment.PlaceComponentResult;
            if (vb != 0) {
                ((FragmentMissedCallOtpBinding) vb).PlaceComponentResult.setBackgroundIntoWhite();
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        } else {
            VB vb2 = missedCallOtpFragment.PlaceComponentResult;
            if (vb2 != 0) {
                ((FragmentMissedCallOtpBinding) vb2).PlaceComponentResult.setBackgroundIntoGrey();
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        VB vb3 = missedCallOtpFragment.PlaceComponentResult;
        if (vb3 != 0) {
            ((FragmentMissedCallOtpBinding) vb3).PlaceComponentResult.setEditable(z);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda2(final MissedCallOtpFragment missedCallOtpFragment) {
        if (missedCallOtpFragment.getContext() != null) {
            Context requireContext = missedCallOtpFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "");
            DanaAlertDialog.Builder builder = new DanaAlertDialog.Builder(requireContext);
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.res_0x7f080905_networkuserentitydata_externalsyntheticlambda0;
            builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.res_0x7f130e71_networkuserentitydata_externalsyntheticlambda5);
            builder.moveToNextValue = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.res_0x7f130e70_networkuserentitydata_externalsyntheticlambda4);
            String string = missedCallOtpFragment.requireContext().getString(R.string.res_0x7f130e6f_networkuserentitydata_externalsyntheticlambda7);
            Intrinsics.checkNotNullExpressionValue(string, "");
            String upperCase = string.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "");
            String str = upperCase;
            Intrinsics.checkNotNullParameter(str, "");
            builder.PrepareContext = str;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$showMaxAttemptsReached$dialog$1
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
                    if (FragmentExtKt.PlaceComponentResult(MissedCallOtpFragment.this)) {
                        MissedCallOtpFragment.this.getParentFragmentManager().setFragmentResult("KEY_RISK_CHALLENGE_FRAGMENT", BundleKt.PlaceComponentResult(TuplesKt.to("KEY_RESULT", 0), TuplesKt.to("KEY_IS_ERROR", Boolean.TRUE)));
                    }
                }
            };
            Intrinsics.checkNotNullParameter(function0, "");
            builder.newProxyInstance = function0;
            DanaAlertDialog BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory();
            FragmentManager parentFragmentManager = missedCallOtpFragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
            Intrinsics.checkNotNullParameter(parentFragmentManager, "");
            BuiltInFictitiousFunctionClassFactory.show(parentFragmentManager, "DanaAlertDialog");
        }
    }

    public static final /* synthetic */ void initRecordTimeStamp(MissedCallOtpFragment missedCallOtpFragment) {
        DanaLoadingDialogFragment danaLoadingDialogFragment = (DanaLoadingDialogFragment) missedCallOtpFragment.DatabaseTableConfigUtil.getValue();
        FragmentManager parentFragmentManager = missedCallOtpFragment.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
        danaLoadingDialogFragment.show(parentFragmentManager, "LOADING_DIALOG");
    }

    public final void MyBillsEntityDataFactory(final Function0<Unit> function0) {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            View findViewById = ((FragmentMissedCallOtpBinding) vb).PlaceComponentResult.findViewById(R.id.newProxyInstance);
            final EditText editText = findViewById instanceof EditText ? (EditText) findViewById : null;
            if (editText != null) {
                editText.post(new Runnable() { // from class: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        MissedCallOtpFragment.getAuthRequestContext(editText, this, function0);
                    }
                });
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void lookAheadTest() {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentMissedCallOtpBinding) vb).PlaceComponentResult.getInput().post(new Runnable() { // from class: id.dana.riskChallenges.ui.missedCallOtp.MissedCallOtpFragment$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    MissedCallOtpFragment.BuiltInFictitiousFunctionClassFactory(MissedCallOtpFragment.this);
                }
            });
            MyBillsEntityDataFactory();
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
