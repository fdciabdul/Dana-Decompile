package id.dana.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonGhostView;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;

/* loaded from: classes4.dex */
public final class BottomSheetContactPermissionRequestBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final FrameLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final DanaButtonPrimaryView PlaceComponentResult;
    public final DanaButtonGhostView getAuthRequestContext;
    private final FrameLayout getErrorConfigVersion;
    public final AppCompatTextView moveToNextValue;

    private BottomSheetContactPermissionRequestBinding(FrameLayout frameLayout, DanaButtonGhostView danaButtonGhostView, DanaButtonPrimaryView danaButtonPrimaryView, FrameLayout frameLayout2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.getErrorConfigVersion = frameLayout;
        this.getAuthRequestContext = danaButtonGhostView;
        this.PlaceComponentResult = danaButtonPrimaryView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = frameLayout2;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.MyBillsEntityDataFactory = appCompatImageView2;
        this.moveToNextValue = appCompatTextView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatTextView2;
    }

    public static BottomSheetContactPermissionRequestBinding PlaceComponentResult(View view) {
        int i = R.id.btnNegative;
        DanaButtonGhostView danaButtonGhostView = (DanaButtonGhostView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btnNegative);
        if (danaButtonGhostView != null) {
            DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btnPositive);
            if (danaButtonPrimaryView != null) {
                FrameLayout frameLayout = (FrameLayout) view;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.secondaryHash_res_0x7f0a08d3);
                if (appCompatImageView != null) {
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivIcon);
                    if (appCompatImageView2 != null) {
                        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvDesc);
                        if (appCompatTextView != null) {
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvTitle);
                            if (appCompatTextView2 != null) {
                                return new BottomSheetContactPermissionRequestBinding(frameLayout, danaButtonGhostView, danaButtonPrimaryView, frameLayout, appCompatImageView, appCompatImageView2, appCompatTextView, appCompatTextView2);
                            }
                            i = R.id.tvTitle;
                        } else {
                            i = R.id.tvDesc;
                        }
                    } else {
                        i = R.id.ivIcon;
                    }
                } else {
                    i = R.id.secondaryHash_res_0x7f0a08d3;
                }
            } else {
                i = R.id.btnPositive;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }
}
