package id.dana.onboarding.verify.faceloginconfirmation;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import id.dana.analytics.firebase.Crashlytics;
import id.dana.databinding.BottomSheetFaceOnlyConfirmationBinding;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 &2\u00020\u0001:\u0001&B\t\b\u0016¢\u0006\u0004\b#\u0010$B1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c¢\u0006\u0004\b#\u0010%J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0006J!\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0016\u001a\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001eR\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u001e"}, d2 = {"Lid/dana/onboarding/verify/faceloginconfirmation/FaceLoginConfirmationFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Landroid/content/DialogInterface;", "p0", "", "onCancel", "(Landroid/content/DialogInterface;)V", "Landroid/os/Bundle;", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "p1", "p2", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onDismiss", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lid/dana/databinding/BottomSheetFaceOnlyConfirmationBinding;", "MyBillsEntityDataFactory", "Lid/dana/databinding/BottomSheetFaceOnlyConfirmationBinding;", "BuiltInFictitiousFunctionClassFactory", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "PlaceComponentResult", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "Lkotlin/Function0;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lkotlin/jvm/functions/Function0;", "getAuthRequestContext", "lookAheadTest", "KClassImpl$Data$declaredNonStaticMembers$2", "getErrorConfigVersion", "<init>", "()V", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FaceLoginConfirmationFragment extends BottomSheetDialogFragment {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private BottomSheetFaceOnlyConfirmationBinding BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Function0<Unit> getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private FragmentPermissionRequest MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Function0<Unit> PlaceComponentResult;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Function0<Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    public FaceLoginConfirmationFragment(Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03) {
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(function02, "");
        Intrinsics.checkNotNullParameter(function03, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();
        this.getAuthRequestContext = function0;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function02;
        this.PlaceComponentResult = function03;
    }

    public FaceLoginConfirmationFragment() {
        this(new Function0<Unit>() { // from class: id.dana.onboarding.verify.faceloginconfirmation.FaceLoginConfirmationFragment.1
            /* renamed from: invoke */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        }, new Function0<Unit>() { // from class: id.dana.onboarding.verify.faceloginconfirmation.FaceLoginConfirmationFragment.2
            /* renamed from: invoke */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        }, new Function0<Unit>() { // from class: id.dana.onboarding.verify.faceloginconfirmation.FaceLoginConfirmationFragment.3
            /* renamed from: invoke */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
        Crashlytics.Companion companion = Crashlytics.INSTANCE;
        Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
        Intrinsics.checkNotNullParameter("FaceLoginConfirmationFragment recreated by system", "");
        authRequestContext.getAuthRequestContext.log("FaceLoginConfirmationFragment recreated by system");
        InstantiationException instantiationException = new InstantiationException("FaceLoginConfirmationFragment");
        Intrinsics.checkNotNullParameter(instantiationException, "");
        authRequestContext.getAuthRequestContext.recordException(instantiationException);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle p0) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext(), R.style.f50062132017470);
        bottomSheetDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: id.dana.onboarding.verify.faceloginconfirmation.FaceLoginConfirmationFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                FaceLoginConfirmationFragment.getAuthRequestContext(dialogInterface);
            }
        });
        return bottomSheetDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext.invoke();
        super.onCancel(p0);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext.invoke();
        super.onDismiss(p0);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater p0, ViewGroup p1, Bundle p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        BottomSheetFaceOnlyConfirmationBinding MyBillsEntityDataFactory = BottomSheetFaceOnlyConfirmationBinding.MyBillsEntityDataFactory(p0, p1);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        this.BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory;
        FrameLayout frameLayout = MyBillsEntityDataFactory.getErrorConfigVersion;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        return frameLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onViewCreated(p0, p1);
        FragmentPermissionRequest.Builder builder = new FragmentPermissionRequest.Builder(this);
        String[] strArr = {"android.permission.CAMERA"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.getAuthRequestContext = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.onboarding.verify.faceloginconfirmation.FaceLoginConfirmationFragment$initPermission$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p02, boolean p12) {
                Function0 function0;
                Function0 function02;
                Intrinsics.checkNotNullParameter(p02, "");
                if (p02.MyBillsEntityDataFactory()) {
                    function02 = FaceLoginConfirmationFragment.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    function02.invoke();
                } else {
                    function0 = FaceLoginConfirmationFragment.this.PlaceComponentResult;
                    function0.invoke();
                }
                FaceLoginConfirmationFragment.this.dismissAllowingStateLoss();
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onShouldRedirectToSystemSettings(List<PermissionReport> p02) {
                Function0 function0;
                Intrinsics.checkNotNullParameter(p02, "");
                function0 = FaceLoginConfirmationFragment.this.PlaceComponentResult;
                function0.invoke();
                FaceLoginConfirmationFragment.this.dismissAllowingStateLoss();
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.BuiltInFictitiousFunctionClassFactory = permissionCallback;
        this.MyBillsEntityDataFactory = builder.PlaceComponentResult();
        BottomSheetFaceOnlyConfirmationBinding bottomSheetFaceOnlyConfirmationBinding = this.BuiltInFictitiousFunctionClassFactory;
        BottomSheetFaceOnlyConfirmationBinding bottomSheetFaceOnlyConfirmationBinding2 = null;
        if (bottomSheetFaceOnlyConfirmationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bottomSheetFaceOnlyConfirmationBinding = null;
        }
        bottomSheetFaceOnlyConfirmationBinding.getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.onboarding.verify.faceloginconfirmation.FaceLoginConfirmationFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FaceLoginConfirmationFragment.getAuthRequestContext(FaceLoginConfirmationFragment.this);
            }
        });
        BottomSheetFaceOnlyConfirmationBinding bottomSheetFaceOnlyConfirmationBinding3 = this.BuiltInFictitiousFunctionClassFactory;
        if (bottomSheetFaceOnlyConfirmationBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            bottomSheetFaceOnlyConfirmationBinding2 = bottomSheetFaceOnlyConfirmationBinding3;
        }
        bottomSheetFaceOnlyConfirmationBinding2.MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.onboarding.verify.faceloginconfirmation.FaceLoginConfirmationFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FaceLoginConfirmationFragment.PlaceComponentResult(FaceLoginConfirmationFragment.this);
            }
        });
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ7\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/onboarding/verify/faceloginconfirmation/FaceLoginConfirmationFragment$Companion;", "", "Lkotlin/Function0;", "", "p0", "p1", "p2", "Lid/dana/onboarding/verify/faceloginconfirmation/FaceLoginConfirmationFragment;", "getAuthRequestContext", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Lid/dana/onboarding/verify/faceloginconfirmation/FaceLoginConfirmationFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static FaceLoginConfirmationFragment getAuthRequestContext(Function0<Unit> p0, Function0<Unit> p1, Function0<Unit> p2) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            return new FaceLoginConfirmationFragment(p0, p1, p2);
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
                from.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: id.dana.onboarding.verify.faceloginconfirmation.FaceLoginConfirmationFragment$onCreateDialog$1$1$1$1
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

    public static /* synthetic */ void PlaceComponentResult(FaceLoginConfirmationFragment faceLoginConfirmationFragment) {
        Intrinsics.checkNotNullParameter(faceLoginConfirmationFragment, "");
        faceLoginConfirmationFragment.getAuthRequestContext.invoke();
        faceLoginConfirmationFragment.dismissAllowingStateLoss();
    }

    public static /* synthetic */ void getAuthRequestContext(FaceLoginConfirmationFragment faceLoginConfirmationFragment) {
        Intrinsics.checkNotNullParameter(faceLoginConfirmationFragment, "");
        FragmentPermissionRequest fragmentPermissionRequest = faceLoginConfirmationFragment.MyBillsEntityDataFactory;
        if (fragmentPermissionRequest == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            fragmentPermissionRequest = null;
        }
        fragmentPermissionRequest.check();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
