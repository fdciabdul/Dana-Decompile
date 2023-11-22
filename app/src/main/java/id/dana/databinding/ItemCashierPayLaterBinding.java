package id.dana.databinding;

import android.view.View;
import android.widget.RadioButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemCashierPayLaterBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final RadioButton PlaceComponentResult;
    public final View getAuthRequestContext;
    public final AppCompatTextView getErrorConfigVersion;
    public final AppCompatTextView lookAheadTest;
    public final AppCompatTextView moveToNextValue;
    public final AppCompatTextView scheduleImpl;

    private ItemCashierPayLaterBinding(ConstraintLayout constraintLayout, View view, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, RadioButton radioButton, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
        this.getAuthRequestContext = view;
        this.MyBillsEntityDataFactory = constraintLayout2;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.PlaceComponentResult = radioButton;
        this.getErrorConfigVersion = appCompatTextView;
        this.lookAheadTest = appCompatTextView2;
        this.moveToNextValue = appCompatTextView3;
        this.scheduleImpl = appCompatTextView4;
    }

    public static ItemCashierPayLaterBinding PlaceComponentResult(View view) {
        int i = R.id.divider;
        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.divider);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivIconAsset);
            if (appCompatImageView != null) {
                RadioButton radioButton = (RadioButton) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rgPaymentMethod);
                if (radioButton != null) {
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.isHelperTextDisplayed);
                    if (appCompatTextView != null) {
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvNewOrPromo);
                        if (appCompatTextView2 != null) {
                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4317tvSecondaryDescription);
                            if (appCompatTextView3 != null) {
                                AppCompatTextView appCompatTextView4 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvTitle);
                                if (appCompatTextView4 != null) {
                                    return new ItemCashierPayLaterBinding(constraintLayout, BuiltInFictitiousFunctionClassFactory, constraintLayout, appCompatImageView, radioButton, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4);
                                }
                                i = R.id.tvTitle;
                            } else {
                                i = R.id.f4317tvSecondaryDescription;
                            }
                        } else {
                            i = R.id.tvNewOrPromo;
                        }
                    } else {
                        i = R.id.isHelperTextDisplayed;
                    }
                } else {
                    i = R.id.rgPaymentMethod;
                }
            } else {
                i = R.id.ivIconAsset;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
