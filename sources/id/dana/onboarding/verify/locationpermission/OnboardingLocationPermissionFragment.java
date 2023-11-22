package id.dana.onboarding.verify.locationpermission;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.anggrayudi.storage.permission.FragmentPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import id.dana.R;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.analytics.tracker.performanceduration.DanaPerformanceDurationTracker;
import id.dana.databinding.FragmentOnboardingPermissionLocationBinding;
import id.dana.utils.permission.ManifestPermission;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0001%B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u001c¢\u0006\u0004\b#\u0010$J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0013J!\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b \u0010!"}, d2 = {"Lid/dana/onboarding/verify/locationpermission/OnboardingLocationPermissionFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Landroid/app/Activity;", "p0", "", "onAttach", "(Landroid/app/Activity;)V", "Landroid/os/Bundle;", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "p1", "p2", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onPause", "()V", "onResume", "onStart", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lid/dana/databinding/FragmentOnboardingPermissionLocationBinding;", "MyBillsEntityDataFactory", "Lid/dana/databinding/FragmentOnboardingPermissionLocationBinding;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/onboarding/verify/locationpermission/OnboardingLocationPermissionListener;", "PlaceComponentResult", "Lid/dana/onboarding/verify/locationpermission/OnboardingLocationPermissionListener;", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "moveToNextValue", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Lid/dana/onboarding/verify/locationpermission/OnboardingLocationPermissionListener;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OnboardingLocationPermissionFragment extends BottomSheetDialogFragment {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private FragmentOnboardingPermissionLocationBinding KClassImpl$Data$declaredNonStaticMembers$2;
    private final OnboardingLocationPermissionListener PlaceComponentResult;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private FragmentPermissionRequest BuiltInFictitiousFunctionClassFactory;

    public OnboardingLocationPermissionFragment(OnboardingLocationPermissionListener onboardingLocationPermissionListener) {
        Intrinsics.checkNotNullParameter(onboardingLocationPermissionListener, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();
        this.PlaceComponentResult = onboardingLocationPermissionListener;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Activity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onAttach(p0);
        DanaPerformanceDurationTracker danaPerformanceDurationTracker = DanaPerformanceDurationTracker.INSTANCE;
        DanaPerformanceDurationTracker.MyBillsEntityDataFactory(TrackerDataKey.ViewScreenName.PERMISSION_LOCATION_SCREEN);
        DanaPerformanceDurationTracker.INSTANCE.BuiltInFictitiousFunctionClassFactory(TrackerDataKey.ViewScreenName.PERMISSION_LOCATION_SCREEN, TrackerDataKey.Property.RENDER_PERMISSION_SCREEN, System.currentTimeMillis());
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle p0) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext(), R.style.f50012132017464);
        bottomSheetDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: id.dana.onboarding.verify.locationpermission.OnboardingLocationPermissionFragment$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                OnboardingLocationPermissionFragment.getAuthRequestContext(dialogInterface);
            }
        });
        return bottomSheetDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater p0, ViewGroup p1, Bundle p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        FragmentOnboardingPermissionLocationBinding KClassImpl$Data$declaredNonStaticMembers$2 = FragmentOnboardingPermissionLocationBinding.KClassImpl$Data$declaredNonStaticMembers$2(p0, p1);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2;
        FrameLayout frameLayout = KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        return frameLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        FragmentOnboardingPermissionLocationBinding fragmentOnboardingPermissionLocationBinding = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (fragmentOnboardingPermissionLocationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            fragmentOnboardingPermissionLocationBinding = null;
        }
        fragmentOnboardingPermissionLocationBinding.lookAheadTest.playAnimation();
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        FragmentOnboardingPermissionLocationBinding fragmentOnboardingPermissionLocationBinding = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (fragmentOnboardingPermissionLocationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            fragmentOnboardingPermissionLocationBinding = null;
        }
        fragmentOnboardingPermissionLocationBinding.lookAheadTest.pauseAnimation();
        super.onPause();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        FragmentOnboardingPermissionLocationBinding fragmentOnboardingPermissionLocationBinding = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (fragmentOnboardingPermissionLocationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            fragmentOnboardingPermissionLocationBinding = null;
        }
        ViewParent parent = fragmentOnboardingPermissionLocationBinding.getErrorConfigVersion.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            return;
        }
        viewGroup.getLayoutParams().height = -1;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onViewCreated(p0, p1);
        DanaPerformanceDurationTracker.INSTANCE.PlaceComponentResult(TrackerDataKey.ViewScreenName.PERMISSION_LOCATION_SCREEN, TrackerDataKey.Property.RENDER_PERMISSION_SCREEN, System.currentTimeMillis());
        DanaPerformanceDurationTracker.INSTANCE.KClassImpl$Data$declaredNonStaticMembers$2(TrackerDataKey.ViewScreenName.PERMISSION_LOCATION_SCREEN, TrackerDataKey.Property.USER_IDLE_PERMISSION_SCREEN, System.currentTimeMillis());
        FragmentPermissionRequest.Builder builder = new FragmentPermissionRequest.Builder(this);
        String[] strArr = {"android.permission.ACCESS_FINE_LOCATION", ManifestPermission.ACCESS_COARSE_LOCATION};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.getAuthRequestContext = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.onboarding.verify.locationpermission.OnboardingLocationPermissionFragment$initPermission$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p02, boolean p12) {
                OnboardingLocationPermissionListener onboardingLocationPermissionListener;
                Intrinsics.checkNotNullParameter(p02, "");
                DanaPerformanceDurationTracker.INSTANCE.PlaceComponentResult(TrackerDataKey.ViewScreenName.PERMISSION_LOCATION_SCREEN, TrackerDataKey.Property.PERMISSION_PROCESSING_LOGIN_IN_MILLIS, System.currentTimeMillis());
                onboardingLocationPermissionListener = OnboardingLocationPermissionFragment.this.PlaceComponentResult;
                onboardingLocationPermissionListener.onPermissionsChecked(p02, p12);
                OnboardingLocationPermissionFragment.this.dismissAllowingStateLoss();
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onShouldRedirectToSystemSettings(List<PermissionReport> p02) {
                OnboardingLocationPermissionListener onboardingLocationPermissionListener;
                Intrinsics.checkNotNullParameter(p02, "");
                DanaPerformanceDurationTracker.INSTANCE.PlaceComponentResult(TrackerDataKey.ViewScreenName.PERMISSION_LOCATION_SCREEN, TrackerDataKey.Property.PERMISSION_PROCESSING_LOGIN_IN_MILLIS, System.currentTimeMillis());
                onboardingLocationPermissionListener = OnboardingLocationPermissionFragment.this.PlaceComponentResult;
                onboardingLocationPermissionListener.onShouldRedirectToSystemSettings(p02);
                OnboardingLocationPermissionFragment.this.dismissAllowingStateLoss();
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.BuiltInFictitiousFunctionClassFactory = permissionCallback;
        this.BuiltInFictitiousFunctionClassFactory = builder.PlaceComponentResult();
        FragmentOnboardingPermissionLocationBinding fragmentOnboardingPermissionLocationBinding = this.KClassImpl$Data$declaredNonStaticMembers$2;
        FragmentOnboardingPermissionLocationBinding fragmentOnboardingPermissionLocationBinding2 = null;
        if (fragmentOnboardingPermissionLocationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            fragmentOnboardingPermissionLocationBinding = null;
        }
        fragmentOnboardingPermissionLocationBinding.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.onboarding.verify.locationpermission.OnboardingLocationPermissionFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OnboardingLocationPermissionFragment.getAuthRequestContext(OnboardingLocationPermissionFragment.this);
            }
        });
        FragmentOnboardingPermissionLocationBinding fragmentOnboardingPermissionLocationBinding3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (fragmentOnboardingPermissionLocationBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            fragmentOnboardingPermissionLocationBinding2 = fragmentOnboardingPermissionLocationBinding3;
        }
        fragmentOnboardingPermissionLocationBinding2.getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.onboarding.verify.locationpermission.OnboardingLocationPermissionFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OnboardingLocationPermissionFragment.MyBillsEntityDataFactory(OnboardingLocationPermissionFragment.this);
            }
        });
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/onboarding/verify/locationpermission/OnboardingLocationPermissionFragment$Companion;", "", "Lid/dana/onboarding/verify/locationpermission/OnboardingLocationPermissionListener;", "p0", "Lid/dana/onboarding/verify/locationpermission/OnboardingLocationPermissionFragment;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/onboarding/verify/locationpermission/OnboardingLocationPermissionListener;)Lid/dana/onboarding/verify/locationpermission/OnboardingLocationPermissionFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static OnboardingLocationPermissionFragment KClassImpl$Data$declaredNonStaticMembers$2(OnboardingLocationPermissionListener p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            return new OnboardingLocationPermissionFragment(p0);
        }
    }

    public static /* synthetic */ void getAuthRequestContext(DialogInterface dialogInterface) {
        BottomSheetDialog bottomSheetDialog = dialogInterface instanceof BottomSheetDialog ? (BottomSheetDialog) dialogInterface : null;
        if (bottomSheetDialog != null) {
            View findViewById = bottomSheetDialog.findViewById(R.id.design_bottom_sheet);
            FrameLayout frameLayout = findViewById instanceof FrameLayout ? (FrameLayout) findViewById : null;
            if (frameLayout != null) {
                final BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                Intrinsics.checkNotNullExpressionValue(from, "");
                from.setPeekHeight(Resources.getSystem().getDisplayMetrics().heightPixels);
                from.setState(3);
                from.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: id.dana.onboarding.verify.locationpermission.OnboardingLocationPermissionFragment$onCreateDialog$1$1$1$1
                    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                    public final void onSlide(View p0, float p1) {
                        Intrinsics.checkNotNullParameter(p0, "");
                    }

                    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                    public final void onStateChanged(View p0, int p1) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        if (p1 == 1) {
                            from.setState(3);
                        }
                    }
                });
            }
        }
    }

    public static /* synthetic */ void getAuthRequestContext(OnboardingLocationPermissionFragment onboardingLocationPermissionFragment) {
        Intrinsics.checkNotNullParameter(onboardingLocationPermissionFragment, "");
        FragmentPermissionRequest fragmentPermissionRequest = onboardingLocationPermissionFragment.BuiltInFictitiousFunctionClassFactory;
        if (fragmentPermissionRequest == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            fragmentPermissionRequest = null;
        }
        fragmentPermissionRequest.check();
        DanaPerformanceDurationTracker.INSTANCE.getAuthRequestContext(TrackerDataKey.ViewScreenName.PERMISSION_LOCATION_SCREEN, TrackerDataKey.Property.USER_IDLE_PERMISSION_SCREEN, System.currentTimeMillis());
        DanaPerformanceDurationTracker.INSTANCE.BuiltInFictitiousFunctionClassFactory(TrackerDataKey.ViewScreenName.PERMISSION_LOCATION_SCREEN, TrackerDataKey.Property.PERMISSION_PROCESSING_LOGIN_IN_MILLIS, System.currentTimeMillis());
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(OnboardingLocationPermissionFragment onboardingLocationPermissionFragment) {
        Intrinsics.checkNotNullParameter(onboardingLocationPermissionFragment, "");
        DanaPerformanceDurationTracker.INSTANCE.getAuthRequestContext(TrackerDataKey.ViewScreenName.PERMISSION_LOCATION_SCREEN, TrackerDataKey.Property.USER_IDLE_PERMISSION_SCREEN, System.currentTimeMillis());
        onboardingLocationPermissionFragment.PlaceComponentResult.getAuthRequestContext();
        onboardingLocationPermissionFragment.dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
