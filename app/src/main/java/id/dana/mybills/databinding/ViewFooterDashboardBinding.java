package id.dana.mybills.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.mybills.R;
import id.dana.mybills.ui.customview.CurrentBalanceMyBillsViewV2;

/* loaded from: classes5.dex */
public final class ViewFooterDashboardBinding implements ViewBinding {
    public final Group BuiltInFictitiousFunctionClassFactory;
    public final DanaButtonSecondaryView KClassImpl$Data$declaredNonStaticMembers$2;
    public final CurrentBalanceMyBillsViewV2 MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final Group PlaceComponentResult;
    public final DanaButtonPrimaryView getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    private final ConstraintLayout lookAheadTest;
    public final AppCompatImageView moveToNextValue;
    public final TextView scheduleImpl;

    private ViewFooterDashboardBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, DanaButtonSecondaryView danaButtonSecondaryView, CurrentBalanceMyBillsViewV2 currentBalanceMyBillsViewV2, Group group, Group group2, AppCompatImageView appCompatImageView, TextView textView, TextView textView2, TextView textView3) {
        this.lookAheadTest = constraintLayout;
        this.getAuthRequestContext = danaButtonPrimaryView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonSecondaryView;
        this.MyBillsEntityDataFactory = currentBalanceMyBillsViewV2;
        this.PlaceComponentResult = group;
        this.BuiltInFictitiousFunctionClassFactory = group2;
        this.moveToNextValue = appCompatImageView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView;
        this.getErrorConfigVersion = textView2;
        this.scheduleImpl = textView3;
    }

    public static ViewFooterDashboardBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_footer_dashboard, (ViewGroup) null, false);
        int i = R.id.A;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (danaButtonPrimaryView != null) {
            i = R.id.VerifyPinStateManager$executeRiskChallenge$2$1;
            DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (danaButtonSecondaryView != null) {
                i = R.id.currentBalanceMyBillsView;
                CurrentBalanceMyBillsViewV2 currentBalanceMyBillsViewV2 = (CurrentBalanceMyBillsViewV2) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (currentBalanceMyBillsViewV2 != null) {
                    i = R.id.group_information;
                    Group group = (Group) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (group != null) {
                        i = R.id.group_total_bills;
                        Group group2 = (Group) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (group2 != null) {
                            i = R.id.res_0x7f0a0b60_requestmoneyqrcontract_view;
                            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (appCompatImageView != null) {
                                i = R.id.res_0x7f0a1737_emergencynotifactivity_getemergencynotifmodule_1;
                                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (textView != null) {
                                    i = R.id.tv_total_price_items;
                                    TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                    if (textView2 != null) {
                                        i = R.id.res_0x7f0a1957_setindex_kotlin_stdlib;
                                        TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                        if (textView3 != null) {
                                            return new ViewFooterDashboardBinding((ConstraintLayout) inflate, danaButtonPrimaryView, danaButtonSecondaryView, currentBalanceMyBillsViewV2, group, group2, appCompatImageView, textView, textView2, textView3);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest;
    }
}
