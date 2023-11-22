package id.dana.onboarding.verify.pinincorrectlock;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.databinding.FragmentPinIncorrectLockBinding;
import id.dana.databinding.LayoutToolbarBinding;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u001f\u0010\u0010J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J!\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d"}, d2 = {"Lid/dana/onboarding/verify/pinincorrectlock/PinIncorrectLockFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Landroid/os/Bundle;", "p0", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "p1", "p2", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "onDestroy", "()V", "onStart", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lid/dana/databinding/FragmentPinIncorrectLockBinding;", "MyBillsEntityDataFactory", "Lid/dana/databinding/FragmentPinIncorrectLockBinding;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/Long;", "PlaceComponentResult", "", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ljava/lang/Integer;", "BuiltInFictitiousFunctionClassFactory", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PinIncorrectLockFragment extends BottomSheetDialogFragment {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private Long PlaceComponentResult;
    private FragmentPinIncorrectLockBinding MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private Integer BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> PlaceComponentResult = new LinkedHashMap();

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle p0) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext(), R.style.f50012132017464);
        bottomSheetDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: id.dana.onboarding.verify.pinincorrectlock.PinIncorrectLockFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                PinIncorrectLockFragment.KClassImpl$Data$declaredNonStaticMembers$2(dialogInterface);
            }
        });
        return bottomSheetDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater p0, ViewGroup p1, Bundle p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        FragmentPinIncorrectLockBinding PlaceComponentResult = FragmentPinIncorrectLockBinding.PlaceComponentResult(p0, p1);
        this.MyBillsEntityDataFactory = PlaceComponentResult;
        Intrinsics.checkNotNull(PlaceComponentResult);
        ConstraintLayout constraintLayout = PlaceComponentResult.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        return constraintLayout;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        ConstraintLayout constraintLayout;
        super.onStart();
        FragmentPinIncorrectLockBinding fragmentPinIncorrectLockBinding = this.MyBillsEntityDataFactory;
        ViewParent parent = (fragmentPinIncorrectLockBinding == null || (constraintLayout = fragmentPinIncorrectLockBinding.PlaceComponentResult) == null) ? null : constraintLayout.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? parent : null;
        if (viewGroup == null) {
            return;
        }
        viewGroup.getLayoutParams().height = -1;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.MyBillsEntityDataFactory = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View p0, Bundle p1) {
        Integer num;
        DanaButtonSecondaryView danaButtonSecondaryView;
        LayoutToolbarBinding layoutToolbarBinding;
        Intrinsics.checkNotNullParameter(p0, "");
        super.onViewCreated(p0, p1);
        Bundle arguments = getArguments();
        this.PlaceComponentResult = arguments != null ? Long.valueOf(arguments.getLong("LAST_FAILED_TIME")) : null;
        Bundle arguments2 = getArguments();
        Integer valueOf = arguments2 != null ? Integer.valueOf(arguments2.getInt("LOCKED_EXPIRE_SECONDS")) : null;
        this.BuiltInFictitiousFunctionClassFactory = valueOf;
        if (valueOf != null) {
            double intValue = valueOf.intValue();
            Double.isNaN(intValue);
            num = Integer.valueOf((int) Math.ceil(intValue / 60.0d));
        } else {
            num = null;
        }
        if (num != null) {
            int intValue2 = num.intValue();
            FragmentPinIncorrectLockBinding fragmentPinIncorrectLockBinding = this.MyBillsEntityDataFactory;
            AppCompatTextView appCompatTextView = fragmentPinIncorrectLockBinding != null ? fragmentPinIncorrectLockBinding.scheduleImpl : null;
            if (appCompatTextView != null) {
                appCompatTextView.setText(getString(R.string.pin_incorrect_lock_title, Integer.valueOf(intValue2)));
            }
        }
        FragmentPinIncorrectLockBinding fragmentPinIncorrectLockBinding2 = this.MyBillsEntityDataFactory;
        if (fragmentPinIncorrectLockBinding2 != null && (layoutToolbarBinding = fragmentPinIncorrectLockBinding2.BuiltInFictitiousFunctionClassFactory) != null) {
            layoutToolbarBinding.initRecordTimeStamp.setVisibility(8);
            layoutToolbarBinding.moveToNextValue.setVisibility(0);
            ImageView imageView = layoutToolbarBinding.moveToNextValue;
            Context context = getContext();
            imageView.setImageDrawable(context != null ? ContextCompat.PlaceComponentResult(context, (int) R.drawable.ic_dana_logo_icon_text) : null);
        }
        FragmentPinIncorrectLockBinding fragmentPinIncorrectLockBinding3 = this.MyBillsEntityDataFactory;
        if (fragmentPinIncorrectLockBinding3 == null || (danaButtonSecondaryView = fragmentPinIncorrectLockBinding3.MyBillsEntityDataFactory) == null) {
            return;
        }
        danaButtonSecondaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.onboarding.verify.pinincorrectlock.PinIncorrectLockFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PinIncorrectLockFragment.MyBillsEntityDataFactory(PinIncorrectLockFragment.this);
            }
        });
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/onboarding/verify/pinincorrectlock/PinIncorrectLockFragment$Companion;", "", "", "p0", "Lid/dana/onboarding/verify/pinincorrectlock/PinIncorrectLockFragment;", "PlaceComponentResult", "(I)Lid/dana/onboarding/verify/pinincorrectlock/PinIncorrectLockFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static PinIncorrectLockFragment PlaceComponentResult(int p0) {
            Bundle bundle = new Bundle();
            bundle.putInt("LOCKED_EXPIRE_SECONDS", p0);
            PinIncorrectLockFragment pinIncorrectLockFragment = new PinIncorrectLockFragment();
            pinIncorrectLockFragment.setArguments(bundle);
            return pinIncorrectLockFragment;
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(DialogInterface dialogInterface) {
        BottomSheetDialog bottomSheetDialog = dialogInterface instanceof BottomSheetDialog ? (BottomSheetDialog) dialogInterface : null;
        if (bottomSheetDialog != null) {
            View findViewById = bottomSheetDialog.findViewById(R.id.design_bottom_sheet);
            FrameLayout frameLayout = findViewById instanceof FrameLayout ? (FrameLayout) findViewById : null;
            if (frameLayout != null) {
                final BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                Intrinsics.checkNotNullExpressionValue(from, "");
                from.setPeekHeight(Resources.getSystem().getDisplayMetrics().heightPixels);
                from.setState(3);
                from.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: id.dana.onboarding.verify.pinincorrectlock.PinIncorrectLockFragment$onCreateDialog$1$1$1$1
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

    public static /* synthetic */ void MyBillsEntityDataFactory(PinIncorrectLockFragment pinIncorrectLockFragment) {
        Intrinsics.checkNotNullParameter(pinIncorrectLockFragment, "");
        pinIncorrectLockFragment.dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.PlaceComponentResult.clear();
    }
}
