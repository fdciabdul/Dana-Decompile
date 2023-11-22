package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputLayout;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.component.edittextcomponent.DanaTextBoxView;

/* loaded from: classes4.dex */
public final class FragmentCashierVerifyLimitAmountDailyBinding implements ViewBinding {
    public final AppCompatTextView BuiltInFictitiousFunctionClassFactory;
    public final TextInputLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final DanaTextBoxView MyBillsEntityDataFactory;
    public final AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final DanaButtonSecondaryView PlaceComponentResult;
    public final AppCompatTextView getAuthRequestContext;
    public final AppCompatTextView getErrorConfigVersion;
    private final ConstraintLayout moveToNextValue;

    private FragmentCashierVerifyLimitAmountDailyBinding(ConstraintLayout constraintLayout, DanaButtonSecondaryView danaButtonSecondaryView, DanaTextBoxView danaTextBoxView, TextInputLayout textInputLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4) {
        this.moveToNextValue = constraintLayout;
        this.PlaceComponentResult = danaButtonSecondaryView;
        this.MyBillsEntityDataFactory = danaTextBoxView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textInputLayout;
        this.getAuthRequestContext = appCompatTextView;
        this.BuiltInFictitiousFunctionClassFactory = appCompatTextView2;
        this.getErrorConfigVersion = appCompatTextView3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatTextView4;
    }

    public static FragmentCashierVerifyLimitAmountDailyBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.fragment_cashier_verify_limit_amount_daily, (ViewGroup) null, false);
        int i = R.id.res_0x7f0a0166_networkuserentitydata_externalsyntheticlambda2;
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.res_0x7f0a0166_networkuserentitydata_externalsyntheticlambda2);
        if (danaButtonSecondaryView != null) {
            DanaTextBoxView danaTextBoxView = (DanaTextBoxView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.etLimitInput);
            if (danaTextBoxView != null) {
                TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tilLimitInput);
                if (textInputLayout != null) {
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvDailyLimitSubTitle);
                    if (appCompatTextView != null) {
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.cl_item_wallet_container);
                        if (appCompatTextView2 != null) {
                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvTitle);
                            if (appCompatTextView3 != null) {
                                AppCompatTextView appCompatTextView4 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvTitle2);
                                if (appCompatTextView4 != null) {
                                    return new FragmentCashierVerifyLimitAmountDailyBinding((ConstraintLayout) inflate, danaButtonSecondaryView, danaTextBoxView, textInputLayout, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4);
                                }
                                i = R.id.tvTitle2;
                            } else {
                                i = R.id.tvTitle;
                            }
                        } else {
                            i = R.id.cl_item_wallet_container;
                        }
                    } else {
                        i = R.id.tvDailyLimitSubTitle;
                    }
                } else {
                    i = R.id.tilLimitInput;
                }
            } else {
                i = R.id.etLimitInput;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue;
    }
}
