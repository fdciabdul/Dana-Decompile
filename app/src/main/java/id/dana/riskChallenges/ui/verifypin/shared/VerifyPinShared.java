package id.dana.riskChallenges.ui.verifypin.shared;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.view.DefaultLifecycleObserver;
import androidx.view.HasDefaultViewModelProviderFactory;
import androidx.view.LifecycleOwner;
import androidx.view.LifecycleOwnerKt;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import androidx.view.viewmodel.CreationExtras;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import id.dana.core.ui.constant.BottomInfoSnackbarState;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.core.ui.dialog.DanaLoadingDialogFragment;
import id.dana.core.ui.dialog.DanaLogoProgressView;
import id.dana.core.ui.extension.FragmentExtKt;
import id.dana.core.ui.richview.BottomInfoSnackbar;
import id.dana.core.ui.richview.PinEntryEditText;
import id.dana.core.ui.util.KeyboardHelper;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.domain.DefaultObserver;
import id.dana.domain.featureconfig.interactor.CheckKnowledgeBasedAuthFeature;
import id.dana.riskChallenges.databinding.LayoutPinVerifyBinding;
import id.dana.riskChallenges.di.component.RiskChallengesComponent;
import id.dana.riskChallenges.di.provider.RiskChallengesProvider;
import id.dana.riskChallenges.domain.verifypassword.interactor.VerifyPasswordObservable;
import id.dana.riskChallenges.domain.verifypassword.model.VerifyPassword;
import id.dana.riskChallenges.ui.verifypin.VerifyPinUiState;
import id.dana.riskChallenges.ui.verifypin.VerifyPinViewModel;
import id.dana.riskChallenges.ui.verifypin.mapper.VerifyPinModelMapperKt;
import id.dana.utils.android.AppUtil;
import id.dana.utils.danah5.DanaH5Facade;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0006\u001a\u00020\u001c\u0012\b\u0010,\u001a\u0004\u0018\u00010\f\u0012\b\u0010-\u001a\u0004\u0018\u00010#¢\u0006\u0004\b.\u0010/J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0013\u0010\u0003\u001a\u00020\u000fX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0087\"¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0010\u001a\u00020\u0016X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\u0011R\u0012\u0010\u0018\u001a\u00020\u0017X\u0087\"¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\n\u001a\u00020\u001a8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010 \u001a\u0004\u0018\u00010#8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0013\u0010(\u001a\u00020&X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b'\u0010\u0011R\u0012\u0010*\u001a\u00020)X\u0087\"¢\u0006\u0006\n\u0004\b*\u0010+"}, d2 = {"Lid/dana/riskChallenges/ui/verifypin/shared/VerifyPinShared;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "Landroidx/lifecycle/LifecycleOwner;", "p0", "onCreate", "(Landroidx/lifecycle/LifecycleOwner;)V", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "Lid/dana/riskChallenges/databinding/LayoutPinVerifyBinding;", "Lid/dana/riskChallenges/databinding/LayoutPinVerifyBinding;", "getAuthRequestContext", "Lid/dana/core/ui/richview/BottomInfoSnackbar;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/Lazy;", "Ldagger/Lazy;", "Lid/dana/utils/danah5/DanaH5Facade;", "danaH5Facade", "Ldagger/Lazy;", "Lid/dana/core/ui/dialog/DanaLoadingDialogFragment;", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "dynamicUrlWrapper", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "Lid/dana/riskChallenges/ui/verifypin/shared/VerifyPinShared$errorSnackbarCallback$1;", "Lid/dana/riskChallenges/ui/verifypin/shared/VerifyPinShared$errorSnackbarCallback$1;", "Landroidx/fragment/app/Fragment;", "PlaceComponentResult", "Landroidx/fragment/app/Fragment;", "Lid/dana/riskChallenges/di/component/RiskChallengesComponent;", "moveToNextValue", "Lid/dana/riskChallenges/di/component/RiskChallengesComponent;", "scheduleImpl", "Landroid/view/ViewGroup;", "lookAheadTest", "Landroid/view/ViewGroup;", "Lid/dana/riskChallenges/ui/verifypin/VerifyPinViewModel;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getErrorConfigVersion", "Lid/dana/core/ui/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/core/ui/di/module/ViewModelFactory;", "p1", "p2", "<init>", "(Landroidx/fragment/app/Fragment;Lid/dana/riskChallenges/databinding/LayoutPinVerifyBinding;Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerifyPinShared implements DefaultLifecycleObserver {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final LayoutPinVerifyBinding getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory;
    private final VerifyPinShared$errorSnackbarCallback$1 MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Lazy getErrorConfigVersion;
    private final Fragment PlaceComponentResult;
    @Inject
    public dagger.Lazy<DanaH5Facade> danaH5Facade;
    @Inject
    public DynamicUrlWrapper dynamicUrlWrapper;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final ViewGroup moveToNextValue;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private RiskChallengesComponent scheduleImpl;
    @Inject
    public ViewModelFactory viewModelFactory;

    @Override // androidx.view.FullLifecycleObserver
    public final /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.getAuthRequestContext();
    }

    @Override // androidx.view.FullLifecycleObserver
    public final /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.MyBillsEntityDataFactory();
    }

    @Override // androidx.view.FullLifecycleObserver
    public final /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // androidx.view.FullLifecycleObserver
    public final /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.PlaceComponentResult();
    }

    @Override // androidx.view.FullLifecycleObserver
    public final /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.scheduleImpl();
    }

    /* JADX WARN: Removed duplicated region for block: B:272:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0160  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object getAuthRequestContext(id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared r17, id.dana.riskChallenges.ui.verifypin.VerifyPinUiState r18, kotlin.coroutines.Continuation r19) {
        /*
            Method dump skipped, instructions count: 851
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared.getAuthRequestContext(id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared, id.dana.riskChallenges.ui.verifypin.VerifyPinUiState, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.view.FullLifecycleObserver
    public final void onCreate(LifecycleOwner p0) {
        AppCompatTextView appCompatTextView;
        PinEntryEditText pinEntryEditText;
        PinEntryEditText pinEntryEditText2;
        Intrinsics.checkNotNullParameter(p0, "");
        DefaultLifecycleObserver.CC.KClassImpl$Data$declaredNonStaticMembers$2();
        Context applicationContext = this.PlaceComponentResult.requireActivity().getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.riskChallenges.di.provider.RiskChallengesProvider");
        }
        RiskChallengesComponent BuiltInFictitiousFunctionClassFactory = ((RiskChallengesProvider) applicationContext).provideRiskChallengesComponent().BuiltInFictitiousFunctionClassFactory();
        this.scheduleImpl = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(this);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(p0), null, null, new VerifyPinShared$observeUiState$1(p0, this, null), 3, null);
        LayoutPinVerifyBinding layoutPinVerifyBinding = this.getAuthRequestContext;
        PinEntryEditText pinEntryEditText3 = layoutPinVerifyBinding != null ? layoutPinVerifyBinding.MyBillsEntityDataFactory : null;
        if (pinEntryEditText3 != null) {
            pinEntryEditText3.setMaxLength(6);
        }
        LayoutPinVerifyBinding layoutPinVerifyBinding2 = this.getAuthRequestContext;
        if (layoutPinVerifyBinding2 != null && (pinEntryEditText2 = layoutPinVerifyBinding2.MyBillsEntityDataFactory) != null) {
            pinEntryEditText2.setOnPinEnteredListener(new PinEntryEditText.OnPinEnteredListener() { // from class: id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared$$ExternalSyntheticLambda2
                @Override // id.dana.core.ui.richview.PinEntryEditText.OnPinEnteredListener
                public final /* synthetic */ void MyBillsEntityDataFactory() {
                    PinEntryEditText.OnPinEnteredListener.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.core.ui.richview.PinEntryEditText.OnPinEnteredListener
                public final void getAuthRequestContext(CharSequence charSequence) {
                    VerifyPinShared.getAuthRequestContext(VerifyPinShared.this, charSequence);
                }
            });
        }
        LayoutPinVerifyBinding layoutPinVerifyBinding3 = this.getAuthRequestContext;
        if (layoutPinVerifyBinding3 != null && (pinEntryEditText = layoutPinVerifyBinding3.MyBillsEntityDataFactory) != null) {
            pinEntryEditText.focus();
        }
        LayoutPinVerifyBinding layoutPinVerifyBinding4 = this.getAuthRequestContext;
        if (layoutPinVerifyBinding4 != null && (appCompatTextView = layoutPinVerifyBinding4.PlaceComponentResult) != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VerifyPinShared.MyBillsEntityDataFactory(VerifyPinShared.this);
                }
            });
        }
        FragmentActivity requireActivity = this.PlaceComponentResult.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "");
        KeyboardHelper.getAuthRequestContext((Activity) requireActivity);
        VerifyPinViewModel verifyPinViewModel = (VerifyPinViewModel) this.getErrorConfigVersion.getValue();
        Bundle arguments = this.PlaceComponentResult.getArguments();
        verifyPinViewModel.getErrorConfigVersion = arguments != null ? arguments.getString("KEY_STRATEGY") : null;
        VerifyPinViewModel verifyPinViewModel2 = (VerifyPinViewModel) this.getErrorConfigVersion.getValue();
        Bundle arguments2 = this.PlaceComponentResult.getArguments();
        verifyPinViewModel2.lookAheadTest = arguments2 != null ? arguments2.getString("KEY_SCENE") : null;
        VerifyPinViewModel verifyPinViewModel3 = (VerifyPinViewModel) this.getErrorConfigVersion.getValue();
        Bundle arguments3 = this.PlaceComponentResult.getArguments();
        verifyPinViewModel3.KClassImpl$Data$declaredNonStaticMembers$2 = arguments3 != null ? arguments3.getString("KEY_SECURITY_ID") : null;
        VerifyPinViewModel verifyPinViewModel4 = (VerifyPinViewModel) this.getErrorConfigVersion.getValue();
        Bundle arguments4 = this.PlaceComponentResult.getArguments();
        verifyPinViewModel4.PlaceComponentResult = arguments4 != null ? arguments4.getString("KEY_PHONE_NUMBER") : null;
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        DanaLogoProgressView danaLogoProgressView;
        LayoutPinVerifyBinding layoutPinVerifyBinding = this.getAuthRequestContext;
        if (layoutPinVerifyBinding != null && (danaLogoProgressView = layoutPinVerifyBinding.getAuthRequestContext) != null) {
            danaLogoProgressView.setVisibility(8);
            danaLogoProgressView.stopRefresh();
        }
        LayoutPinVerifyBinding layoutPinVerifyBinding2 = this.getAuthRequestContext;
        PinEntryEditText pinEntryEditText = layoutPinVerifyBinding2 != null ? layoutPinVerifyBinding2.MyBillsEntityDataFactory : null;
        if (pinEntryEditText != null) {
            pinEntryEditText.setVisibility(0);
        }
    }

    /* JADX WARN: Type inference failed for: r5v8, types: [id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared$errorSnackbarCallback$1] */
    public VerifyPinShared(final Fragment fragment, LayoutPinVerifyBinding layoutPinVerifyBinding, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(fragment, "");
        this.PlaceComponentResult = fragment;
        this.getAuthRequestContext = layoutPinVerifyBinding;
        this.moveToNextValue = viewGroup;
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelFactory viewModelFactory = VerifyPinShared.this.viewModelFactory;
                if (viewModelFactory == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    viewModelFactory = null;
                }
                return viewModelFactory;
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared$special$$inlined$viewModels$default$2
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
        this.getErrorConfigVersion = FragmentViewModelLazyKt.BuiltInFictitiousFunctionClassFactory(fragment, Reflection.getOrCreateKotlinClass(VerifyPinViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared$special$$inlined$viewModels$default$4
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
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<DanaLoadingDialogFragment>() { // from class: id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared$danaLoadingDialog$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DanaLoadingDialogFragment invoke() {
                DanaLoadingDialogFragment.Companion companion = DanaLoadingDialogFragment.INSTANCE;
                return DanaLoadingDialogFragment.Companion.BuiltInFictitiousFunctionClassFactory();
            }
        });
        this.BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<BottomInfoSnackbar>() { // from class: id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared$bottomInfoSnackbar$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BottomInfoSnackbar invoke() {
                ViewGroup viewGroup2;
                BottomInfoSnackbar.Companion companion = BottomInfoSnackbar.INSTANCE;
                viewGroup2 = VerifyPinShared.this.moveToNextValue;
                Intrinsics.checkNotNull(viewGroup2);
                return BottomInfoSnackbar.Companion.getAuthRequestContext(viewGroup2);
            }
        });
        this.MyBillsEntityDataFactory = new BaseTransientBottomBar.BaseCallback<BottomInfoSnackbar>() { // from class: id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared$errorSnackbarCallback$1
            /* JADX WARN: Code restructure failed: missing block: B:6:0x001a, code lost:
            
                r3 = r1.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
             */
            @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final /* synthetic */ void onDismissed(id.dana.core.ui.richview.BottomInfoSnackbar r2, int r3) {
                /*
                    r1 = this;
                    id.dana.core.ui.richview.BottomInfoSnackbar r2 = (id.dana.core.ui.richview.BottomInfoSnackbar) r2
                    id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared r2 = id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared.this
                    androidx.fragment.app.Fragment r2 = id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared.NetworkUserEntityData$$ExternalSyntheticLambda0(r2)
                    boolean r2 = id.dana.core.ui.extension.FragmentExtKt.PlaceComponentResult(r2)
                    if (r2 == 0) goto L51
                    id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared r2 = id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared.this
                    androidx.fragment.app.Fragment r2 = id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared.NetworkUserEntityData$$ExternalSyntheticLambda0(r2)
                    android.content.Context r2 = r2.getContext()
                    if (r2 == 0) goto L2f
                    id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared r3 = id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared.this
                    id.dana.riskChallenges.databinding.LayoutPinVerifyBinding r3 = id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared.KClassImpl$Data$declaredNonStaticMembers$2(r3)
                    if (r3 == 0) goto L2f
                    id.dana.core.ui.richview.PinEntryEditText r3 = r3.MyBillsEntityDataFactory
                    if (r3 == 0) goto L2f
                    int r0 = id.dana.riskChallenges.R.color.BuiltInFictitiousFunctionClassFactory
                    int r2 = androidx.core.content.ContextCompat.BuiltInFictitiousFunctionClassFactory(r2, r0)
                    r3.setTextColor(r2)
                L2f:
                    id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared r2 = id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared.this
                    id.dana.riskChallenges.databinding.LayoutPinVerifyBinding r2 = id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared.KClassImpl$Data$declaredNonStaticMembers$2(r2)
                    if (r2 == 0) goto L42
                    id.dana.core.ui.richview.PinEntryEditText r2 = r2.MyBillsEntityDataFactory
                    if (r2 == 0) goto L42
                    java.lang.String r3 = ""
                    java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                    r2.setText(r3)
                L42:
                    id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared r2 = id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared.this
                    id.dana.riskChallenges.databinding.LayoutPinVerifyBinding r2 = id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared.KClassImpl$Data$declaredNonStaticMembers$2(r2)
                    if (r2 == 0) goto L51
                    id.dana.core.ui.richview.PinEntryEditText r2 = r2.MyBillsEntityDataFactory
                    if (r2 == 0) goto L51
                    r2.requestFocus()
                L51:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared$errorSnackbarCallback$1.onDismissed(java.lang.Object, int):void");
            }
        };
    }

    public static /* synthetic */ void getAuthRequestContext(VerifyPinShared verifyPinShared) {
        Intrinsics.checkNotNullParameter(verifyPinShared, "");
        verifyPinShared.getAuthRequestContext.MyBillsEntityDataFactory.clearFocus();
        KeyboardHelper.getAuthRequestContext(verifyPinShared.PlaceComponentResult.getGetAuthRequestContext());
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(VerifyPinShared verifyPinShared) {
        Intrinsics.checkNotNullParameter(verifyPinShared, "");
        verifyPinShared.getAuthRequestContext.MyBillsEntityDataFactory.requestFocus();
        PinEntryEditText pinEntryEditText = verifyPinShared.getAuthRequestContext.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(pinEntryEditText, "");
        KeyboardHelper.KClassImpl$Data$declaredNonStaticMembers$2(pinEntryEditText);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(VerifyPinShared verifyPinShared) {
        Intrinsics.checkNotNullParameter(verifyPinShared, "");
        final VerifyPinViewModel verifyPinViewModel = (VerifyPinViewModel) verifyPinShared.getErrorConfigVersion.getValue();
        verifyPinViewModel.MyBillsEntityDataFactory.get().execute(new DefaultObserver<Boolean>() { // from class: id.dana.riskChallenges.ui.verifypin.VerifyPinViewModel$checkKnowledgeBasedAuthFeature$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                MutableStateFlow mutableStateFlow;
                Object value;
                boolean booleanValue = ((Boolean) obj).booleanValue();
                mutableStateFlow = VerifyPinViewModel.this.BuiltInFictitiousFunctionClassFactory;
                do {
                    value = mutableStateFlow.getValue();
                    VerifyPinUiState verifyPinUiState = (VerifyPinUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new VerifyPinUiState.OnCheckKnowledgeBasedAuthFeatureSuccess(booleanValue)));
            }
        }, CheckKnowledgeBasedAuthFeature.Params.forParams("forgot_pin"));
        DanaLoadingDialogFragment danaLoadingDialogFragment = (DanaLoadingDialogFragment) verifyPinShared.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
        FragmentManager parentFragmentManager = verifyPinShared.PlaceComponentResult.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
        danaLoadingDialogFragment.show(parentFragmentManager, "FullDanaLoading");
    }

    public static /* synthetic */ void getAuthRequestContext(VerifyPinShared verifyPinShared, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(verifyPinShared, "");
        ((BottomInfoSnackbar) verifyPinShared.BuiltInFictitiousFunctionClassFactory.getValue()).dismiss();
        KeyboardHelper.getAuthRequestContext(verifyPinShared.PlaceComponentResult.getGetAuthRequestContext());
        if (charSequence != null) {
            final VerifyPinViewModel verifyPinViewModel = (VerifyPinViewModel) verifyPinShared.getErrorConfigVersion.getValue();
            String obj = charSequence.toString();
            boolean MyBillsEntityDataFactory = AppUtil.MyBillsEntityDataFactory(verifyPinShared.PlaceComponentResult.requireContext());
            Intrinsics.checkNotNullParameter(obj, "");
            MutableStateFlow<VerifyPinUiState> mutableStateFlow = verifyPinViewModel.BuiltInFictitiousFunctionClassFactory;
            do {
            } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), VerifyPinUiState.VerifyLoading.INSTANCE));
            String str = verifyPinViewModel.getErrorConfigVersion;
            String str2 = str == null ? "" : str;
            String str3 = verifyPinViewModel.lookAheadTest;
            String str4 = str3 == null ? "" : str3;
            String str5 = verifyPinViewModel.PlaceComponentResult;
            String str6 = str5 == null ? "" : str5;
            String str7 = verifyPinViewModel.KClassImpl$Data$declaredNonStaticMembers$2;
            verifyPinViewModel.moveToNextValue.get().execute(new VerifyPasswordObservable.Params(obj, str2, str4, MyBillsEntityDataFactory, str7 == null ? "" : str7, str6), new Function1<VerifyPassword, Unit>() { // from class: id.dana.riskChallenges.ui.verifypin.VerifyPinViewModel$verifyPin$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(VerifyPassword verifyPassword) {
                    invoke2(verifyPassword);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(VerifyPassword verifyPassword) {
                    Intrinsics.checkNotNullParameter(verifyPassword, "");
                    VerifyPinViewModel.this.PlaceComponentResult(VerifyPinModelMapperKt.getAuthRequestContext(verifyPassword));
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.riskChallenges.ui.verifypin.VerifyPinViewModel$verifyPin$3
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
                    Intrinsics.checkNotNullParameter(th, "");
                    VerifyPinViewModel.getAuthRequestContext(VerifyPinViewModel.this, th);
                }
            });
        }
    }

    public static final /* synthetic */ void PlaceComponentResult(VerifyPinShared verifyPinShared) {
        Fragment fragment = verifyPinShared.PlaceComponentResult;
        BottomSheetDialogFragment bottomSheetDialogFragment = fragment instanceof BottomSheetDialogFragment ? (BottomSheetDialogFragment) fragment : null;
        if (bottomSheetDialogFragment != null) {
            bottomSheetDialogFragment.dismissNow();
        }
    }

    public static final /* synthetic */ DanaLoadingDialogFragment scheduleImpl(VerifyPinShared verifyPinShared) {
        return (DanaLoadingDialogFragment) verifyPinShared.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
    }

    public static final /* synthetic */ VerifyPinViewModel getErrorConfigVersion(VerifyPinShared verifyPinShared) {
        return (VerifyPinViewModel) verifyPinShared.getErrorConfigVersion.getValue();
    }

    public static final /* synthetic */ void lookAheadTest(VerifyPinShared verifyPinShared) {
        if (FragmentExtKt.PlaceComponentResult(verifyPinShared.PlaceComponentResult)) {
            verifyPinShared.PlaceComponentResult.getParentFragmentManager().setFragmentResult("KEY_RISK_CHALLENGE_FRAGMENT", BundleKt.PlaceComponentResult(TuplesKt.to("KEY_RESULT", 0)));
        }
    }

    private final void MyBillsEntityDataFactory(String p0) {
        BottomInfoSnackbar bottomInfoSnackbar = (BottomInfoSnackbar) this.BuiltInFictitiousFunctionClassFactory.getValue();
        bottomInfoSnackbar.KClassImpl$Data$declaredNonStaticMembers$2(BottomInfoSnackbarState.ERROR);
        Intrinsics.checkNotNullParameter(p0, "");
        bottomInfoSnackbar.MyBillsEntityDataFactory.MyBillsEntityDataFactory.setText(p0);
        bottomInfoSnackbar.addCallback(this.MyBillsEntityDataFactory);
        bottomInfoSnackbar.show();
    }
}
