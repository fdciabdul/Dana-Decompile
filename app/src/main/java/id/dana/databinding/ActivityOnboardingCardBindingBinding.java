package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.richview.HelpListView;

/* loaded from: classes2.dex */
public final class ActivityOnboardingCardBindingBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    public final DanaButtonPrimaryView KClassImpl$Data$declaredNonStaticMembers$2;
    public final HelpListView MyBillsEntityDataFactory;
    public final ConstraintLayout PlaceComponentResult;
    public final LinearLayout getAuthRequestContext;
    public final View lookAheadTest;

    private ActivityOnboardingCardBindingBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, HelpListView helpListView, LinearLayout linearLayout, TextView textView, View view) {
        this.PlaceComponentResult = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonPrimaryView;
        this.MyBillsEntityDataFactory = helpListView;
        this.getAuthRequestContext = linearLayout;
        this.BuiltInFictitiousFunctionClassFactory = textView;
        this.lookAheadTest = view;
    }

    public static ActivityOnboardingCardBindingBinding PlaceComponentResult(View view) {
        int i = R.id.f3479btnNextOnboarding;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3479btnNextOnboarding);
        if (danaButtonPrimaryView != null) {
            HelpListView helpListView = (HelpListView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3819helpListViewOnboardingCardBinding);
            if (helpListView != null) {
                LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.llBottomSectionOnboarding);
                if (linearLayout != null) {
                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvTitleOnboardingCardBinding);
                    if (textView != null) {
                        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.viewSeparatorOnboarding);
                        if (BuiltInFictitiousFunctionClassFactory != null) {
                            return new ActivityOnboardingCardBindingBinding((ConstraintLayout) view, danaButtonPrimaryView, helpListView, linearLayout, textView, BuiltInFictitiousFunctionClassFactory);
                        }
                        i = R.id.viewSeparatorOnboarding;
                    } else {
                        i = R.id.tvTitleOnboardingCardBinding;
                    }
                } else {
                    i = R.id.llBottomSectionOnboarding;
                }
            } else {
                i = R.id.f3819helpListViewOnboardingCardBinding;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
