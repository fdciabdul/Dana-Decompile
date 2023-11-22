package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemCashierAddOnPriorityBinding implements ViewBinding {
    public final LinearLayout BuiltInFictitiousFunctionClassFactory;
    public final AppCompatCheckBox KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final AppCompatTextView PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    public final AppCompatTextView getErrorConfigVersion;
    private final ConstraintLayout lookAheadTest;

    private ItemCashierAddOnPriorityBinding(ConstraintLayout constraintLayout, AppCompatCheckBox appCompatCheckBox, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, LinearLayout linearLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.lookAheadTest = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatCheckBox;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.getAuthRequestContext = appCompatImageView2;
        this.BuiltInFictitiousFunctionClassFactory = linearLayout;
        this.PlaceComponentResult = appCompatTextView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatTextView2;
        this.getErrorConfigVersion = appCompatTextView3;
    }

    public static ItemCashierAddOnPriorityBinding PlaceComponentResult(View view) {
        int i = R.id.cbAddOnPriority;
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cbAddOnPriority);
        if (appCompatCheckBox != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.icAddOnPriority);
            if (appCompatImageView != null) {
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivInfoPriority);
                if (appCompatImageView2 != null) {
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.llAddOnTitle);
                    if (linearLayout != null) {
                        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvAddOnAmount);
                        if (appCompatTextView != null) {
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvAddOnPriorityDesc);
                            if (appCompatTextView2 != null) {
                                AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvAddOnPriorityTitle);
                                if (appCompatTextView3 != null) {
                                    return new ItemCashierAddOnPriorityBinding((ConstraintLayout) view, appCompatCheckBox, appCompatImageView, appCompatImageView2, linearLayout, appCompatTextView, appCompatTextView2, appCompatTextView3);
                                }
                                i = R.id.tvAddOnPriorityTitle;
                            } else {
                                i = R.id.tvAddOnPriorityDesc;
                            }
                        } else {
                            i = R.id.tvAddOnAmount;
                        }
                    } else {
                        i = R.id.llAddOnTitle;
                    }
                } else {
                    i = R.id.ivInfoPriority;
                }
            } else {
                i = R.id.icAddOnPriority;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest;
    }
}
