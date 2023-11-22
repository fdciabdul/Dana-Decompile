package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;

/* loaded from: classes4.dex */
public final class DialogPaylaterCicilOnboardingBinding implements ViewBinding {
    public final AppCompatCheckBox BuiltInFictitiousFunctionClassFactory;
    public final DanaButtonPrimaryView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final ConstraintLayout PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    public final ConstraintLayout moveToNextValue;
    public final AppCompatTextView scheduleImpl;

    private DialogPaylaterCicilOnboardingBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, AppCompatCheckBox appCompatCheckBox, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView) {
        this.moveToNextValue = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonPrimaryView;
        this.BuiltInFictitiousFunctionClassFactory = appCompatCheckBox;
        this.PlaceComponentResult = constraintLayout2;
        this.getAuthRequestContext = appCompatImageView;
        this.MyBillsEntityDataFactory = appCompatImageView2;
        this.scheduleImpl = appCompatTextView;
    }

    public static DialogPaylaterCicilOnboardingBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.dialog_paylater_cicil_onboarding, (ViewGroup) null, false);
        int i = R.id.btn_ok;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btn_ok);
        if (danaButtonPrimaryView != null) {
            AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.cb_paylater_tnc);
            if (appCompatCheckBox != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.RecurringAnnouncementEntity);
                if (appCompatImageView != null) {
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_onboarding);
                    if (appCompatImageView2 != null) {
                        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_paylater_tnc_desc);
                        if (appCompatTextView != null) {
                            return new DialogPaylaterCicilOnboardingBinding(constraintLayout, danaButtonPrimaryView, appCompatCheckBox, constraintLayout, appCompatImageView, appCompatImageView2, appCompatTextView);
                        }
                        i = R.id.tv_paylater_tnc_desc;
                    } else {
                        i = R.id.iv_onboarding;
                    }
                } else {
                    i = R.id.RecurringAnnouncementEntity;
                }
            } else {
                i = R.id.cb_paylater_tnc;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue;
    }
}
