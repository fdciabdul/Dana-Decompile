package id.dana.riskChallenges.ui.passkey.main;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.analytics.tracker.passkey.PasskeyTrackerImpl;
import id.dana.core.ui.BaseViewBindingFragment;
import id.dana.core.ui.constant.DialogType;
import id.dana.core.ui.databinding.ViewBaseToolbarBinding;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.core.ui.dialog.CommonDialog;
import id.dana.core.ui.dialog.DanaAlertDialog;
import id.dana.core.ui.extension.FragmentExtKt;
import id.dana.core.ui.extension.TextViewExtKt;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.data.auth.face.repository.source.network.NetworkFaceAuthenticationEntityData;
import id.dana.passkey.Passkey;
import id.dana.riskChallenges.R;
import id.dana.riskChallenges.databinding.FragmentPasskeyEnrollmentMainBinding;
import id.dana.riskChallenges.di.component.RiskChallengesComponentKt;
import id.dana.riskChallenges.domain.passkey.model.PasskeyCeremony;
import id.dana.riskChallenges.domain.passkey.model.PasskeyEnrollmentWithRiskChallenges;
import id.dana.riskChallenges.navigation.Navigation;
import id.dana.riskChallenges.ui.passkey.EnrollmentFaqFragment;
import id.dana.tracker.constant.TrackerType;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.danah5.DanaH5Facade;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b,\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0005J!\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u0005R\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0087\"¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0013\u0010\u000f\u001a\u00020\u0015X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u0006\u0010\u0016R\u0013\u0010\u0006\u001a\u00020\u0017X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u0004\u0010\u0016R\u0013\u0010\u0019\u001a\u00020\u0018X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u0016R\u0016\u0010\u0010\u001a\u00020\u001a8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0004\u001a\u00020\u001d8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0017\u0010\u001b\u001a\u0006*\u00020 0 X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b!\u0010\u0016R\u0018\u0010!\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u001fR\u0012\u0010#\u001a\u00020\"X\u0087\"¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u001d8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b%\u0010\u001fR\u0016\u0010\u0007\u001a\u00020\u001d8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b&\u0010\u001fR\u0013\u0010\u001e\u001a\u00020'X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b(\u0010\u0016R\u0012\u0010*\u001a\u00020)X\u0087\"¢\u0006\u0006\n\u0004\b*\u0010+"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/main/EnrollmentMainFragment;", "Lid/dana/core/ui/BaseViewBindingFragment;", "Lid/dana/riskChallenges/databinding/FragmentPasskeyEnrollmentMainBinding;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "MyBillsEntityDataFactory", "lookAheadTest", "onResume", "Landroid/view/View;", "p0", "Landroid/os/Bundle;", "p1", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "Ldagger/Lazy;", "Lid/dana/utils/danah5/DanaH5Facade;", "danaH5Facade", "Ldagger/Lazy;", "Lid/dana/core/ui/dialog/DanaAlertDialog;", "Lkotlin/Lazy;", "Lid/dana/core/ui/dialog/CommonDialog;", "Lid/dana/riskChallenges/navigation/Navigation;", "getAuthRequestContext", "", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Z", "", "moveToNextValue", "Ljava/lang/String;", "Lid/dana/passkey/Passkey;", "getErrorConfigVersion", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/utils/concurrent/ThreadExecutor;", "scheduleImpl", "DatabaseTableConfigUtil", "Lid/dana/riskChallenges/ui/passkey/main/EnrollmentMainViewModel;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/core/ui/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/core/ui/di/module/ViewModelFactory;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EnrollmentMainFragment extends BaseViewBindingFragment<FragmentPasskeyEnrollmentMainBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private String lookAheadTest;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final Lazy moveToNextValue;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext;
    @Inject
    public dagger.Lazy<DanaH5Facade> danaH5Facade;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private String getErrorConfigVersion;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private String KClassImpl$Data$declaredNonStaticMembers$2;
    private String scheduleImpl;
    @Inject
    public ThreadExecutor threadExecutor;
    @Inject
    public ViewModelFactory viewModelFactory;

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final /* synthetic */ FragmentPasskeyEnrollmentMainBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentPasskeyEnrollmentMainBinding KClassImpl$Data$declaredNonStaticMembers$2 = FragmentPasskeyEnrollmentMainBinding.KClassImpl$Data$declaredNonStaticMembers$2(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        super.KClassImpl$Data$declaredNonStaticMembers$2();
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ViewBaseToolbarBinding viewBaseToolbarBinding = ((FragmentPasskeyEnrollmentMainBinding) vb).scheduleImpl;
            viewBaseToolbarBinding.NetworkUserEntityData$$ExternalSyntheticLambda2.setText(getString(R.string.passkey_activate));
            AppCompatImageView appCompatImageView = viewBaseToolbarBinding.KClassImpl$Data$declaredNonStaticMembers$2;
            int i = R.drawable.ic_cross_close_white;
            if (appCompatImageView instanceof ImageView) {
                InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
            } else {
                appCompatImageView.setImageResource(i);
            }
            viewBaseToolbarBinding.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.riskChallenges.ui.passkey.main.EnrollmentMainFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EnrollmentMainFragment.PlaceComponentResult(EnrollmentMainFragment.this);
                }
            });
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void lookAheadTest() {
        PlaceComponentResult();
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onViewCreated(p0, p1);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "");
        RiskChallengesComponentKt.BuiltInFictitiousFunctionClassFactory(requireActivity).BuiltInFictitiousFunctionClassFactory(this);
        StateFlow<EnrollmentMainUiState> stateFlow = ((EnrollmentMainViewModel) this.moveToNextValue.getValue()).moveToNextValue;
        Lifecycle lifecycle = getViewLifecycleOwner().getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "");
        Flow onEach = FlowKt.onEach(FlowKt.distinctUntilChanged(FlowExtKt.PlaceComponentResult(stateFlow, lifecycle)), new EnrollmentMainFragment$observeEffect$1(this, null));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "");
        FlowKt.launchIn(onEach, LifecycleOwnerKt.PlaceComponentResult(viewLifecycleOwner));
        StateFlow<Boolean> stateFlow2 = ((EnrollmentMainViewModel) this.moveToNextValue.getValue()).KClassImpl$Data$declaredNonStaticMembers$2;
        Lifecycle lifecycle2 = getViewLifecycleOwner().getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle2, "");
        Flow onEach2 = FlowKt.onEach(FlowKt.distinctUntilChanged(FlowExtKt.PlaceComponentResult(stateFlow2, lifecycle2)), new EnrollmentMainFragment$observeState$1(this, null));
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "");
        FlowKt.launchIn(onEach2, LifecycleOwnerKt.PlaceComponentResult(viewLifecycleOwner2));
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentPasskeyEnrollmentMainBinding) vb).MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.riskChallenges.ui.passkey.main.EnrollmentMainFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EnrollmentMainFragment.KClassImpl$Data$declaredNonStaticMembers$2(EnrollmentMainFragment.this);
                }
            });
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                ((FragmentPasskeyEnrollmentMainBinding) vb2).KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.riskChallenges.ui.passkey.main.EnrollmentMainFragment$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        EnrollmentMainFragment.getAuthRequestContext(EnrollmentMainFragment.this);
                    }
                });
                VB vb3 = this.PlaceComponentResult;
                if (vb3 != 0) {
                    TextView textView = ((FragmentPasskeyEnrollmentMainBinding) vb3).getErrorConfigVersion;
                    Intrinsics.checkNotNullExpressionValue(textView, "");
                    int i = R.color.KClassImpl$Data$declaredNonStaticMembers$2;
                    String string = getString(R.string.passkey_enrollment_main_description_about_passkey);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    TextViewExtKt.PlaceComponentResult(textView, i, string, true, new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.passkey.main.EnrollmentMainFragment$onViewCreated$3
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
                            FragmentTransaction beginTransaction = EnrollmentMainFragment.moveToNextValue(EnrollmentMainFragment.this).PlaceComponentResult.beginTransaction();
                            Intrinsics.checkNotNullExpressionValue(beginTransaction, "");
                            FragmentExtKt.BuiltInFictitiousFunctionClassFactory(beginTransaction);
                            Intrinsics.checkNotNullExpressionValue(beginTransaction.MyBillsEntityDataFactory(R.id.initRecordTimeStamp, EnrollmentFaqFragment.class, null, null), "");
                            if (!beginTransaction.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                                throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
                            }
                            beginTransaction.scheduleImpl = true;
                            beginTransaction.NetworkUserEntityData$$ExternalSyntheticLambda8 = null;
                            beginTransaction.getAuthRequestContext();
                        }
                    });
                    VB vb4 = this.PlaceComponentResult;
                    if (vb4 != 0) {
                        ((FragmentPasskeyEnrollmentMainBinding) vb4).PlaceComponentResult.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.riskChallenges.ui.passkey.main.EnrollmentMainFragment$$ExternalSyntheticLambda3
                            @Override // android.widget.CompoundButton.OnCheckedChangeListener
                            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                                EnrollmentMainFragment.MyBillsEntityDataFactory(EnrollmentMainFragment.this, z);
                            }
                        });
                        VB vb5 = this.PlaceComponentResult;
                        if (vb5 != 0) {
                            TextView textView2 = ((FragmentPasskeyEnrollmentMainBinding) vb5).lookAheadTest;
                            Intrinsics.checkNotNullExpressionValue(textView2, "");
                            int i2 = R.color.KClassImpl$Data$declaredNonStaticMembers$2;
                            String string2 = getString(R.string.passkey_enrollment_tnc_description_tnc_link);
                            Intrinsics.checkNotNullExpressionValue(string2, "");
                            TextViewExtKt.PlaceComponentResult(textView2, i2, string2, true, new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.passkey.main.EnrollmentMainFragment$onViewCreated$5
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
                                    dagger.Lazy<DanaH5Facade> lazy = EnrollmentMainFragment.this.danaH5Facade;
                                    if (lazy == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("");
                                        lazy = null;
                                    }
                                    lazy.get().startContainerFullUrl("https://m.dana.id/m/standalone/tnc");
                                }
                            });
                            if (this.BuiltInFictitiousFunctionClassFactory) {
                                MutableStateFlow<Boolean> mutableStateFlow = ((EnrollmentMainViewModel) this.moveToNextValue.getValue()).getAuthRequestContext;
                                do {
                                } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), Boolean.TRUE));
                                MyBillsEntityDataFactory();
                                return;
                            }
                            EnrollmentMainViewModel enrollmentMainViewModel = (EnrollmentMainViewModel) this.moveToNextValue.getValue();
                            String str = this.lookAheadTest;
                            Intrinsics.checkNotNullParameter(str, "");
                            PasskeyTrackerImpl passkeyTrackerImpl = enrollmentMainViewModel.lookAheadTest;
                            Intrinsics.checkNotNullParameter(str, "");
                            passkeyTrackerImpl.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.PasskeyEvent.PASSKEY_INTRODUCTION, new Pair[]{TuplesKt.to("Source", str)});
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

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        EnrollmentMainViewModel enrollmentMainViewModel = (EnrollmentMainViewModel) this.moveToNextValue.getValue();
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            boolean isChecked = ((FragmentPasskeyEnrollmentMainBinding) vb).PlaceComponentResult.isChecked();
            MutableStateFlow<Boolean> mutableStateFlow = enrollmentMainViewModel.getAuthRequestContext;
            do {
            } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), Boolean.valueOf(isChecked)));
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final void PlaceComponentResult() {
        if (FragmentExtKt.PlaceComponentResult(this)) {
            getParentFragmentManager().setFragmentResult("KEY_RISK_CHALLENGE_FRAGMENT", BundleKt.PlaceComponentResult(TuplesKt.to("KEY_RESULT", 0)));
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        if (FragmentExtKt.PlaceComponentResult(this)) {
            getParentFragmentManager().setFragmentResult("KEY_RISK_CHALLENGE_FRAGMENT", BundleKt.PlaceComponentResult(TuplesKt.to("KEY_RESULT", -1), TuplesKt.to("KEY_NEED_SHOW_VERIFICATION_FRAGMENT", Boolean.TRUE)));
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lid/dana/riskChallenges/ui/passkey/main/EnrollmentMainFragment$Companion;", "", "()V", "newInstance", "Lid/dana/riskChallenges/ui/passkey/main/EnrollmentMainFragment;", "trackSource", "", "trackPurpose", NetworkFaceAuthenticationEntityData.PAGE_SOURCE, BioUtilityBridge.SECURITY_ID, "needShowVerificationFragmentFromChallengesCompleted", "", "feature-risk-challenges_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static EnrollmentMainFragment KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2, String str3, String str4, boolean z) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            EnrollmentMainFragment enrollmentMainFragment = new EnrollmentMainFragment();
            enrollmentMainFragment.lookAheadTest = str;
            enrollmentMainFragment.KClassImpl$Data$declaredNonStaticMembers$2 = str3;
            enrollmentMainFragment.getErrorConfigVersion = str4;
            enrollmentMainFragment.BuiltInFictitiousFunctionClassFactory = z;
            enrollmentMainFragment.scheduleImpl = str2;
            return enrollmentMainFragment;
        }
    }

    public EnrollmentMainFragment() {
        final EnrollmentMainFragment enrollmentMainFragment = this;
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: id.dana.riskChallenges.ui.passkey.main.EnrollmentMainFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelFactory viewModelFactory = EnrollmentMainFragment.this.viewModelFactory;
                if (viewModelFactory == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    viewModelFactory = null;
                }
                return viewModelFactory;
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: id.dana.riskChallenges.ui.passkey.main.EnrollmentMainFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: id.dana.riskChallenges.ui.passkey.main.EnrollmentMainFragment$special$$inlined$viewModels$default$2
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
        this.moveToNextValue = FragmentViewModelLazyKt.BuiltInFictitiousFunctionClassFactory(enrollmentMainFragment, Reflection.getOrCreateKotlinClass(EnrollmentMainViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.riskChallenges.ui.passkey.main.EnrollmentMainFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: id.dana.riskChallenges.ui.passkey.main.EnrollmentMainFragment$special$$inlined$viewModels$default$4
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
        this.lookAheadTest = "";
        this.scheduleImpl = "";
        this.KClassImpl$Data$declaredNonStaticMembers$2 = "";
        this.getAuthRequestContext = LazyKt.lazy(new Function0<Navigation>() { // from class: id.dana.riskChallenges.ui.passkey.main.EnrollmentMainFragment$navigation$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Navigation invoke() {
                FragmentManager parentFragmentManager = EnrollmentMainFragment.this.getParentFragmentManager();
                Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
                return new Navigation(parentFragmentManager);
            }
        });
        this.PlaceComponentResult = LazyKt.lazy(new Function0<DanaAlertDialog>() { // from class: id.dana.riskChallenges.ui.passkey.main.EnrollmentMainFragment$failedEnrollmentDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DanaAlertDialog invoke() {
                Context requireContext = EnrollmentMainFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "");
                DanaAlertDialog.Builder builder = new DanaAlertDialog.Builder(requireContext);
                final EnrollmentMainFragment enrollmentMainFragment2 = EnrollmentMainFragment.this;
                builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = enrollmentMainFragment2.getString(R.string.passkey_enrollment_failed_enrollment_title_dialog);
                builder.moveToNextValue = enrollmentMainFragment2.getString(R.string.passkey_enrollment_failed_enrollment_desc_dialog);
                String string = enrollmentMainFragment2.getString(R.string.passkey_got_it);
                Intrinsics.checkNotNullExpressionValue(string, "");
                String str = string;
                Intrinsics.checkNotNullParameter(str, "");
                builder.PrepareContext = str;
                builder.lookAheadTest = Boolean.FALSE;
                Function0<Unit> function04 = new Function0<Unit>() { // from class: id.dana.riskChallenges.ui.passkey.main.EnrollmentMainFragment$failedEnrollmentDialog$2$1$1
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
                        EnrollmentMainFragment.this.getParentFragmentManager().popBackStack();
                    }
                };
                Intrinsics.checkNotNullParameter(function04, "");
                builder.newProxyInstance = function04;
                return builder.BuiltInFictitiousFunctionClassFactory();
            }
        });
        this.MyBillsEntityDataFactory = LazyKt.lazy(new EnrollmentMainFragment$failedEnrollmentStartDialog$2(this));
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = LazyKt.lazy(new Function0<Passkey>() { // from class: id.dana.riskChallenges.ui.passkey.main.EnrollmentMainFragment$passkey$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Passkey invoke() {
                return Passkey.newBuilder(EnrollmentMainFragment.this.requireContext()).build();
            }
        });
    }

    public static /* synthetic */ void getAuthRequestContext(EnrollmentMainFragment enrollmentMainFragment) {
        Intrinsics.checkNotNullParameter(enrollmentMainFragment, "");
        enrollmentMainFragment.PlaceComponentResult();
    }

    public static /* synthetic */ void PlaceComponentResult(EnrollmentMainFragment enrollmentMainFragment) {
        Intrinsics.checkNotNullParameter(enrollmentMainFragment, "");
        enrollmentMainFragment.PlaceComponentResult();
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(EnrollmentMainFragment enrollmentMainFragment, boolean z) {
        Intrinsics.checkNotNullParameter(enrollmentMainFragment, "");
        MutableStateFlow<Boolean> mutableStateFlow = ((EnrollmentMainViewModel) enrollmentMainFragment.moveToNextValue.getValue()).getAuthRequestContext;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), Boolean.valueOf(z)));
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(EnrollmentMainFragment enrollmentMainFragment) {
        Intrinsics.checkNotNullParameter(enrollmentMainFragment, "");
        enrollmentMainFragment.MyBillsEntityDataFactory();
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(EnrollmentMainFragment enrollmentMainFragment) {
        Intrinsics.checkNotNullParameter(enrollmentMainFragment, "");
        enrollmentMainFragment.getParentFragmentManager().popBackStack();
    }

    public static final /* synthetic */ DanaAlertDialog BuiltInFictitiousFunctionClassFactory(EnrollmentMainFragment enrollmentMainFragment) {
        return (DanaAlertDialog) enrollmentMainFragment.PlaceComponentResult.getValue();
    }

    public static final /* synthetic */ CommonDialog scheduleImpl(EnrollmentMainFragment enrollmentMainFragment) {
        return (CommonDialog) enrollmentMainFragment.MyBillsEntityDataFactory.getValue();
    }

    public static final /* synthetic */ Navigation moveToNextValue(EnrollmentMainFragment enrollmentMainFragment) {
        return (Navigation) enrollmentMainFragment.getAuthRequestContext.getValue();
    }

    public static final /* synthetic */ Passkey NetworkUserEntityData$$ExternalSyntheticLambda0(EnrollmentMainFragment enrollmentMainFragment) {
        return (Passkey) enrollmentMainFragment.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue();
    }

    public static final /* synthetic */ EnrollmentMainViewModel NetworkUserEntityData$$ExternalSyntheticLambda1(EnrollmentMainFragment enrollmentMainFragment) {
        return (EnrollmentMainViewModel) enrollmentMainFragment.moveToNextValue.getValue();
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(EnrollmentMainFragment enrollmentMainFragment, PasskeyEnrollmentWithRiskChallenges passkeyEnrollmentWithRiskChallenges) {
        if (FragmentExtKt.PlaceComponentResult(enrollmentMainFragment)) {
            enrollmentMainFragment.getParentFragmentManager().setFragmentResult("KEY_RISK_CHALLENGE_FRAGMENT", BundleKt.PlaceComponentResult(TuplesKt.to("KEY_RESULT", -1), TuplesKt.to("KEY_NEED_HANDLE_VERIFICATION_METHOD", Boolean.TRUE), TuplesKt.to("KEY_DATA_RISK_CONSULT", passkeyEnrollmentWithRiskChallenges)));
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(final EnrollmentMainFragment enrollmentMainFragment, String str) {
        Context requireContext = enrollmentMainFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "");
        CommonDialog.Builder builder = new CommonDialog.Builder(requireContext);
        builder.getAuthRequestContext = true;
        DialogType dialogType = DialogType.WARNING;
        Intrinsics.checkNotNullParameter(dialogType, "");
        builder.DatabaseTableConfigUtil = dialogType;
        builder.lookAheadTest = str;
        builder.BuiltInFictitiousFunctionClassFactory = new DialogInterface.OnDismissListener() { // from class: id.dana.riskChallenges.ui.passkey.main.EnrollmentMainFragment$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                EnrollmentMainFragment.MyBillsEntityDataFactory(EnrollmentMainFragment.this);
            }
        };
        new CommonDialog(builder.PlaceComponentResult, builder.BuiltInFictitiousFunctionClassFactory, builder.MyBillsEntityDataFactory, builder).moveToNextValue();
    }

    private final void MyBillsEntityDataFactory() {
        ((EnrollmentMainViewModel) this.moveToNextValue.getValue()).getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2, PasskeyCeremony.Type.Registration.INSTANCE, this.getErrorConfigVersion);
        BuiltInFictitiousFunctionClassFactory();
    }
}
