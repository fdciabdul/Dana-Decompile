package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.imageview.ShapeableImageView;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonGhostView;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;

/* loaded from: classes4.dex */
public final class BottomSheetPermissionPromptBinding implements ViewBinding {
    public final DanaButtonPrimaryView BuiltInFictitiousFunctionClassFactory;
    public final CoordinatorLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final ShapeableImageView MyBillsEntityDataFactory;
    public final AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final FrameLayout PlaceComponentResult;
    public final DanaButtonGhostView getAuthRequestContext;
    public final AppCompatTextView getErrorConfigVersion;

    private BottomSheetPermissionPromptBinding(CoordinatorLayout coordinatorLayout, DanaButtonPrimaryView danaButtonPrimaryView, DanaButtonGhostView danaButtonGhostView, FrameLayout frameLayout, ShapeableImageView shapeableImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = coordinatorLayout;
        this.BuiltInFictitiousFunctionClassFactory = danaButtonPrimaryView;
        this.getAuthRequestContext = danaButtonGhostView;
        this.PlaceComponentResult = frameLayout;
        this.MyBillsEntityDataFactory = shapeableImageView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatTextView;
        this.getErrorConfigVersion = appCompatTextView2;
    }

    public static BottomSheetPermissionPromptBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet_permission_prompt, viewGroup, false);
        int i = R.id.btn_allow_permission;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btn_allow_permission);
        if (danaButtonPrimaryView != null) {
            DanaButtonGhostView danaButtonGhostView = (DanaButtonGhostView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btn_deny_permission);
            if (danaButtonGhostView != null) {
                FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.fl_permission_prompt);
                if (frameLayout != null) {
                    ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_prompt_illustration);
                    if (shapeableImageView != null) {
                        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_prompt_desc);
                        if (appCompatTextView != null) {
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_prompt_title);
                            if (appCompatTextView2 != null) {
                                return new BottomSheetPermissionPromptBinding((CoordinatorLayout) inflate, danaButtonPrimaryView, danaButtonGhostView, frameLayout, shapeableImageView, appCompatTextView, appCompatTextView2);
                            }
                            i = R.id.tv_prompt_title;
                        } else {
                            i = R.id.tv_prompt_desc;
                        }
                    } else {
                        i = R.id.iv_prompt_illustration;
                    }
                } else {
                    i = R.id.fl_permission_prompt;
                }
            } else {
                i = R.id.btn_deny_permission;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
