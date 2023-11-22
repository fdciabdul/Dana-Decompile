package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;

/* loaded from: classes4.dex */
public final class ActivityFamilyAccountRegistrationBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    public final DanaButtonPrimaryView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final LayoutToolbarBinding PlaceComponentResult;
    public final TextView getAuthRequestContext;
    private final ConstraintLayout lookAheadTest;

    private ActivityFamilyAccountRegistrationBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, AppCompatImageView appCompatImageView, LayoutToolbarBinding layoutToolbarBinding, TextView textView, TextView textView2) {
        this.lookAheadTest = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonPrimaryView;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.PlaceComponentResult = layoutToolbarBinding;
        this.BuiltInFictitiousFunctionClassFactory = textView;
        this.getAuthRequestContext = textView2;
    }

    public static ActivityFamilyAccountRegistrationBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_family_account_registration, (ViewGroup) null, false);
        int i = R.id.f3451isLayoutRequested_res_0x7f0a011f;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3451isLayoutRequested_res_0x7f0a011f);
        if (danaButtonPrimaryView != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivContent);
            if (appCompatImageView != null) {
                View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.layoutToolbar);
                if (BuiltInFictitiousFunctionClassFactory != null) {
                    LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvDescContent);
                    if (textView != null) {
                        TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvTitleContent);
                        if (textView2 != null) {
                            return new ActivityFamilyAccountRegistrationBinding((ConstraintLayout) inflate, danaButtonPrimaryView, appCompatImageView, MyBillsEntityDataFactory, textView, textView2);
                        }
                        i = R.id.tvTitleContent;
                    } else {
                        i = R.id.tvDescContent;
                    }
                } else {
                    i = R.id.layoutToolbar;
                }
            } else {
                i = R.id.ivContent;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest;
    }
}
