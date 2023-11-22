package id.dana.riskChallenges.ui.micface;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.view.HasDefaultViewModelProviderFactory;
import androidx.view.LifecycleOwnerKt;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import androidx.view.viewmodel.CreationExtras;
import com.anggrayudi.storage.permission.FragmentPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.core.ui.BaseViewBindingFragment;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.core.ui.extension.FragmentExtKt;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.lib.bio.faceauth.FaceAuthentication;
import id.dana.lib.bio.faceauth.FaceAuthenticationCallback;
import id.dana.lib.bio.faceauth.exception.DanaBioException;
import id.dana.riskChallenges.R;
import id.dana.riskChallenges.constant.RiskChallengeKey;
import id.dana.riskChallenges.databinding.FragmentMicFaceBinding;
import id.dana.riskChallenges.di.component.RiskChallengesComponent;
import id.dana.riskChallenges.di.provider.RiskChallengesProvider;
import id.dana.riskChallenges.ui.micface.viewmodel.MicFaceUiState;
import id.dana.riskChallenges.ui.micface.viewmodel.MicFaceViewModel;
import id.dana.riskChallenges.ui.util.mapper.RiskChallengeMapper;
import id.dana.riskChallenges.ui.util.model.HistoryFallbackModel;
import id.dana.riskChallenges.ui.util.model.TrackerModel;
import id.dana.riskChallenges.ui.util.uicomponent.UiComponent;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001e\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\u0005R\u0013\u0010\u000e\u001a\u00020\rX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0011\u001a\u00020\u0010X\u0087\"¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\f\u001a\u00020\u00138\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0016X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0012\u0010\u001a\u001a\u00020\u0019X\u0087\"¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0017\u001a\u00020\u001cX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010\u000f"}, d2 = {"Lid/dana/riskChallenges/ui/micface/MicFaceFragment;", "Lid/dana/core/ui/BaseViewBindingFragment;", "Lid/dana/riskChallenges/databinding/FragmentMicFaceBinding;", "", "lookAheadTest", "()V", "Landroid/view/View;", "p0", "Landroid/os/Bundle;", "p1", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "BuiltInFictitiousFunctionClassFactory", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/Lazy;", "Lid/dana/lib/bio/faceauth/FaceAuthentication;", BioUtilityBridge.FACE_AUTHENTICATION, "Lid/dana/lib/bio/faceauth/FaceAuthentication;", "Lid/dana/riskChallenges/di/component/RiskChallengesComponent;", "PlaceComponentResult", "Lid/dana/riskChallenges/di/component/RiskChallengesComponent;", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "Lid/dana/core/ui/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/core/ui/di/module/ViewModelFactory;", "Lid/dana/riskChallenges/ui/micface/viewmodel/MicFaceViewModel;", "getErrorConfigVersion", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MicFaceFragment extends BaseViewBindingFragment<FragmentMicFaceBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    String PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private RiskChallengesComponent BuiltInFictitiousFunctionClassFactory;
    @Inject
    public FaceAuthentication faceAuthentication;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory;
    @Inject
    public ViewModelFactory viewModelFactory;

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final /* synthetic */ FragmentMicFaceBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentMicFaceBinding KClassImpl$Data$declaredNonStaticMembers$2 = FragmentMicFaceBinding.KClassImpl$Data$declaredNonStaticMembers$2(layoutInflater, viewGroup);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void lookAheadTest() {
        BuiltInFictitiousFunctionClassFactory();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v28, types: [android.os.Parcelable] */
    @Override // id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View p0, Bundle p1) {
        Object obj;
        Intrinsics.checkNotNullParameter(p0, "");
        super.onViewCreated(p0, p1);
        Context applicationContext = requireActivity().getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.riskChallenges.di.provider.RiskChallengesProvider");
        }
        RiskChallengesComponent BuiltInFictitiousFunctionClassFactory = ((RiskChallengesProvider) applicationContext).provideRiskChallengesComponent().BuiltInFictitiousFunctionClassFactory();
        this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(this), null, null, new MicFaceFragment$initLifecycleFragment$1(this, null), 3, null);
        Bundle arguments = getArguments();
        this.PlaceComponentResult = arguments != null ? arguments.getString("KEY_SECURITY_ID") : null;
        MicFaceViewModel micFaceViewModel = (MicFaceViewModel) this.MyBillsEntityDataFactory.getValue();
        Bundle arguments2 = getArguments();
        String string = arguments2 != null ? arguments2.getString("KEY_FALLBACK_VERIFICATION_METHOD") : null;
        if (string == null) {
            string = "";
        }
        Intrinsics.checkNotNullParameter(string, "");
        micFaceViewModel.KClassImpl$Data$declaredNonStaticMembers$2 = string;
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                obj = (Parcelable) arguments3.getParcelable("KEY_UI_COMPONENT", UiComponent.class);
            } else {
                ?? parcelable = arguments3.getParcelable("KEY_UI_COMPONENT");
                obj = parcelable instanceof UiComponent ? parcelable : null;
            }
            r9 = (UiComponent) obj;
        }
        if (r9 != null) {
            Object obj2 = this.PlaceComponentResult;
            if (obj2 != null) {
                ((FragmentMicFaceBinding) obj2).KClassImpl$Data$declaredNonStaticMembers$2.setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(requireContext(), r9.MyBillsEntityDataFactory));
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        Object obj3 = this.PlaceComponentResult;
        if (obj3 != null) {
            ((FragmentMicFaceBinding) obj3).BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.setText(getString(R.string.face_verification));
            Object obj4 = this.PlaceComponentResult;
            if (obj4 != null) {
                AppCompatImageView appCompatImageView = ((FragmentMicFaceBinding) obj4).BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory;
                int i = R.drawable.getAuthRequestContext;
                if (appCompatImageView instanceof ImageView) {
                    InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
                } else {
                    appCompatImageView.setImageResource(i);
                }
                Object obj5 = this.PlaceComponentResult;
                if (obj5 != null) {
                    ((FragmentMicFaceBinding) obj5).BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.riskChallenges.ui.micface.MicFaceFragment$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            MicFaceFragment.PlaceComponentResult(MicFaceFragment.this);
                        }
                    });
                    ((FragmentPermissionRequest) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).check();
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        if (FragmentExtKt.PlaceComponentResult(this)) {
            getParentFragmentManager().setFragmentResult("KEY_RISK_CHALLENGE_FRAGMENT", BundleKt.PlaceComponentResult(TuplesKt.to("KEY_RESULT", 0)));
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/riskChallenges/ui/micface/MicFaceFragment$Companion;", "", "", "p0", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "p1", "p2", "Lid/dana/riskChallenges/ui/util/model/TrackerModel;", "p3", "Lid/dana/riskChallenges/ui/micface/MicFaceFragment;", "getAuthRequestContext", "(Ljava/lang/String;Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;Ljava/lang/String;Lid/dana/riskChallenges/ui/util/model/TrackerModel;)Lid/dana/riskChallenges/ui/micface/MicFaceFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static MicFaceFragment getAuthRequestContext(String p0, UiComponent p1, String p2, TrackerModel p3) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p2, "");
            Intrinsics.checkNotNullParameter(p3, "");
            MicFaceFragment micFaceFragment = new MicFaceFragment();
            micFaceFragment.setArguments(BundleKt.PlaceComponentResult(TuplesKt.to("KEY_SECURITY_ID", p0), TuplesKt.to("KEY_UI_COMPONENT", p1), TuplesKt.to("KEY_FALLBACK_VERIFICATION_METHOD", p2), TuplesKt.to("KEY_TRACKER_MODEL", p3)));
            return micFaceFragment;
        }
    }

    public MicFaceFragment() {
        final MicFaceFragment micFaceFragment = this;
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: id.dana.riskChallenges.ui.micface.MicFaceFragment$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelFactory viewModelFactory = MicFaceFragment.this.viewModelFactory;
                if (viewModelFactory == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    viewModelFactory = null;
                }
                return viewModelFactory;
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: id.dana.riskChallenges.ui.micface.MicFaceFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: id.dana.riskChallenges.ui.micface.MicFaceFragment$special$$inlined$viewModels$default$2
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
        this.MyBillsEntityDataFactory = FragmentViewModelLazyKt.BuiltInFictitiousFunctionClassFactory(micFaceFragment, Reflection.getOrCreateKotlinClass(MicFaceViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.riskChallenges.ui.micface.MicFaceFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: id.dana.riskChallenges.ui.micface.MicFaceFragment$special$$inlined$viewModels$default$4
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
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<FragmentPermissionRequest>() { // from class: id.dana.riskChallenges.ui.micface.MicFaceFragment$cameraPermission$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FragmentPermissionRequest invoke() {
                FragmentPermissionRequest.Builder builder = new FragmentPermissionRequest.Builder(MicFaceFragment.this);
                String[] strArr = {"android.permission.CAMERA"};
                Intrinsics.checkNotNullParameter(strArr, "");
                builder.getAuthRequestContext = ArraysKt.toSet(strArr);
                final MicFaceFragment micFaceFragment2 = MicFaceFragment.this;
                PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.riskChallenges.ui.micface.MicFaceFragment$cameraPermission$2.1
                    @Override // com.anggrayudi.storage.permission.PermissionCallback
                    public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                        PermissionCallback.CC.getAuthRequestContext(permissionRequest);
                    }

                    @Override // com.anggrayudi.storage.permission.PermissionCallback
                    public final /* synthetic */ void onShouldRedirectToSystemSettings(List list) {
                        PermissionCallback.CC.BuiltInFictitiousFunctionClassFactory(list);
                    }

                    @Override // com.anggrayudi.storage.permission.PermissionCallback
                    public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        if (MicFaceFragment.this.getContext() != null && MicFaceFragment.this.PlaceComponentResult != null && p0.MyBillsEntityDataFactory()) {
                            final MicFaceViewModel BuiltInFictitiousFunctionClassFactory = MicFaceFragment.BuiltInFictitiousFunctionClassFactory(MicFaceFragment.this);
                            Context requireContext = MicFaceFragment.this.requireContext();
                            Intrinsics.checkNotNullExpressionValue(requireContext, "");
                            String str = MicFaceFragment.this.PlaceComponentResult;
                            if (str == null) {
                                str = "";
                            }
                            RiskChallengeMapper riskChallengeMapper = RiskChallengeMapper.INSTANCE;
                            TrackerModel KClassImpl$Data$declaredNonStaticMembers$2 = MicFaceFragment.KClassImpl$Data$declaredNonStaticMembers$2(MicFaceFragment.this);
                            String str2 = KClassImpl$Data$declaredNonStaticMembers$2 != null ? KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory : null;
                            if (str2 == null) {
                                str2 = "";
                            }
                            RiskChallengeMapper.MyBillsEntityDataFactory(str2);
                            Intrinsics.checkNotNullParameter(requireContext, "");
                            Intrinsics.checkNotNullParameter(str, "");
                            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.getErrorConfigVersion();
                            BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.PlaceComponentResult(requireContext, str, new FaceAuthenticationCallback() { // from class: id.dana.riskChallenges.ui.micface.viewmodel.MicFaceViewModel$verifyFaceAuth$2
                                @Override // id.dana.lib.bio.faceauth.FaceAuthenticationCallback
                                public final void onCancel() {
                                    MutableStateFlow mutableStateFlow;
                                    Object value;
                                    MicFaceViewModel.this.getAuthRequestContext.lookAheadTest();
                                    mutableStateFlow = MicFaceViewModel.this.PlaceComponentResult;
                                    do {
                                        value = mutableStateFlow.getValue();
                                        MicFaceUiState micFaceUiState = (MicFaceUiState) value;
                                    } while (!mutableStateFlow.compareAndSet(value, MicFaceUiState.OnVerifyFaceAuthCancel.INSTANCE));
                                }

                                @Override // id.dana.lib.bio.faceauth.FaceAuthenticationCallback
                                public final void onFailed(DanaBioException.FaceAuthenticationException p02) {
                                    MutableStateFlow mutableStateFlow;
                                    Object value;
                                    Intrinsics.checkNotNullParameter(p02, "");
                                    MicFaceViewModel micFaceViewModel = MicFaceViewModel.this;
                                    int errorCode = p02.getErrorCode();
                                    String message = p02.getMessage();
                                    Intrinsics.checkNotNullParameter(message, "");
                                    micFaceViewModel.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(errorCode, message);
                                    mutableStateFlow = MicFaceViewModel.this.PlaceComponentResult;
                                    do {
                                        value = mutableStateFlow.getValue();
                                        MicFaceUiState micFaceUiState = (MicFaceUiState) value;
                                    } while (!mutableStateFlow.compareAndSet(value, MicFaceUiState.OnVerifyFaceAuthFailed.INSTANCE));
                                }

                                @Override // id.dana.lib.bio.faceauth.FaceAuthenticationCallback
                                public final void onSuccess(String p02) {
                                    MutableStateFlow mutableStateFlow;
                                    Object value;
                                    Intrinsics.checkNotNullParameter(p02, "");
                                    MicFaceViewModel.this.getAuthRequestContext.scheduleImpl();
                                    mutableStateFlow = MicFaceViewModel.this.PlaceComponentResult;
                                    do {
                                        value = mutableStateFlow.getValue();
                                        MicFaceUiState micFaceUiState = (MicFaceUiState) value;
                                    } while (!mutableStateFlow.compareAndSet(value, MicFaceUiState.OnVerifyFaceAuthSuccess.INSTANCE));
                                }
                            });
                            return;
                        }
                        MicFaceFragment.this.getParentFragmentManager().setFragmentResult("KEY_RISK_CHALLENGE_FRAGMENT", BundleKt.PlaceComponentResult(TuplesKt.to("KEY_RESULT", 0), TuplesKt.to("KEY_IS_ERROR", Boolean.TRUE)));
                    }
                };
                Intrinsics.checkNotNullParameter(permissionCallback, "");
                builder.BuiltInFictitiousFunctionClassFactory = permissionCallback;
                return builder.PlaceComponentResult();
            }
        });
    }

    public static /* synthetic */ void PlaceComponentResult(MicFaceFragment micFaceFragment) {
        Intrinsics.checkNotNullParameter(micFaceFragment, "");
        micFaceFragment.BuiltInFictitiousFunctionClassFactory();
    }

    public static final /* synthetic */ TrackerModel KClassImpl$Data$declaredNonStaticMembers$2(MicFaceFragment micFaceFragment) {
        Object obj;
        Bundle arguments = micFaceFragment.getArguments();
        if (arguments != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                obj = (Parcelable) arguments.getParcelable("KEY_TRACKER_MODEL", TrackerModel.class);
            } else {
                Object parcelable = arguments.getParcelable("KEY_TRACKER_MODEL");
                obj = (Parcelable) ((TrackerModel) (parcelable instanceof TrackerModel ? parcelable : null));
            }
            return (TrackerModel) obj;
        }
        return null;
    }

    public static final /* synthetic */ MicFaceViewModel BuiltInFictitiousFunctionClassFactory(MicFaceFragment micFaceFragment) {
        return (MicFaceViewModel) micFaceFragment.MyBillsEntityDataFactory.getValue();
    }

    public static final /* synthetic */ void getAuthRequestContext(MicFaceFragment micFaceFragment) {
        if (FragmentExtKt.PlaceComponentResult(micFaceFragment)) {
            micFaceFragment.getParentFragmentManager().setFragmentResult("KEY_RISK_CHALLENGE_FRAGMENT", BundleKt.PlaceComponentResult(TuplesKt.to("KEY_RESULT", 0), TuplesKt.to("KEY_IS_ERROR", Boolean.TRUE), TuplesKt.to("KEY_TRY_TO_FALLBACK", Boolean.TRUE), TuplesKt.to("KEY_HISTORY_FALLBACK_MODEL", new HistoryFallbackModel(RiskChallengeKey.MIC_FACE, ((MicFaceViewModel) micFaceFragment.MyBillsEntityDataFactory.getValue()).KClassImpl$Data$declaredNonStaticMembers$2))));
        }
    }
}
