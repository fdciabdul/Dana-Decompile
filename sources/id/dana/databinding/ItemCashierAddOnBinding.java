package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemCashierAddOnBinding implements ViewBinding {
    public final AppCompatTextView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatTextView MyBillsEntityDataFactory;
    public final AppCompatCheckBox PlaceComponentResult;
    public final AppCompatTextView getAuthRequestContext;
    private final ConstraintLayout scheduleImpl;

    private ItemCashierAddOnBinding(ConstraintLayout constraintLayout, AppCompatCheckBox appCompatCheckBox, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.scheduleImpl = constraintLayout;
        this.PlaceComponentResult = appCompatCheckBox;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView;
        this.BuiltInFictitiousFunctionClassFactory = appCompatTextView;
        this.getAuthRequestContext = appCompatTextView2;
        this.MyBillsEntityDataFactory = appCompatTextView3;
    }

    public static ItemCashierAddOnBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int i = R.id.cbAddOn;
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cbAddOn);
        if (appCompatCheckBox != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivInfo);
            if (appCompatImageView != null) {
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvAddOnAmount);
                if (appCompatTextView != null) {
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvAddOnTitle);
                    if (appCompatTextView2 != null) {
                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvAddOnType);
                        if (appCompatTextView3 != null) {
                            return new ItemCashierAddOnBinding((ConstraintLayout) view, appCompatCheckBox, appCompatImageView, appCompatTextView, appCompatTextView2, appCompatTextView3);
                        }
                        i = R.id.tvAddOnType;
                    } else {
                        i = R.id.tvAddOnTitle;
                    }
                } else {
                    i = R.id.tvAddOnAmount;
                }
            } else {
                i = R.id.ivInfo;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
