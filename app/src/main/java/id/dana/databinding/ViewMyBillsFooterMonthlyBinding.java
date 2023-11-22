package id.dana.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.mybills.view.CurrentBalanceMyBillsView;

/* loaded from: classes4.dex */
public final class ViewMyBillsFooterMonthlyBinding implements ViewBinding {
    public final DanaButtonSecondaryView BuiltInFictitiousFunctionClassFactory;
    public final CurrentBalanceMyBillsView KClassImpl$Data$declaredNonStaticMembers$2;
    public final Group MyBillsEntityDataFactory;
    private final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final DanaButtonPrimaryView PlaceComponentResult;
    public final Group getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final TextView lookAheadTest;
    public final TextView moveToNextValue;
    public final AppCompatImageView scheduleImpl;

    private ViewMyBillsFooterMonthlyBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, DanaButtonSecondaryView danaButtonSecondaryView, CurrentBalanceMyBillsView currentBalanceMyBillsView, Group group, Group group2, AppCompatImageView appCompatImageView, TextView textView, TextView textView2, TextView textView3) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = constraintLayout;
        this.PlaceComponentResult = danaButtonPrimaryView;
        this.BuiltInFictitiousFunctionClassFactory = danaButtonSecondaryView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = currentBalanceMyBillsView;
        this.MyBillsEntityDataFactory = group;
        this.getAuthRequestContext = group2;
        this.scheduleImpl = appCompatImageView;
        this.moveToNextValue = textView;
        this.getErrorConfigVersion = textView2;
        this.lookAheadTest = textView3;
    }

    public static ViewMyBillsFooterMonthlyBinding PlaceComponentResult(View view) {
        int i = R.id.btnPay;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btnPay);
        if (danaButtonPrimaryView != null) {
            DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btnTopUp);
            if (danaButtonSecondaryView != null) {
                CurrentBalanceMyBillsView currentBalanceMyBillsView = (CurrentBalanceMyBillsView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.currentBalanceMyBillsView);
                if (currentBalanceMyBillsView != null) {
                    Group group = (Group) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.group_information);
                    if (group != null) {
                        Group group2 = (Group) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.group_total_bills);
                        if (group2 != null) {
                            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.res_0x7f0a0b60_requestmoneyqrcontract_view);
                            if (appCompatImageView != null) {
                                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.res_0x7f0a1737_emergencynotifactivity_getemergencynotifmodule_1);
                                if (textView != null) {
                                    TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_total_price_items);
                                    if (textView2 != null) {
                                        TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.res_0x7f0a1957_setindex_kotlin_stdlib);
                                        if (textView3 != null) {
                                            return new ViewMyBillsFooterMonthlyBinding((ConstraintLayout) view, danaButtonPrimaryView, danaButtonSecondaryView, currentBalanceMyBillsView, group, group2, appCompatImageView, textView, textView2, textView3);
                                        }
                                        i = R.id.res_0x7f0a1957_setindex_kotlin_stdlib;
                                    } else {
                                        i = R.id.tv_total_price_items;
                                    }
                                } else {
                                    i = R.id.res_0x7f0a1737_emergencynotifactivity_getemergencynotifmodule_1;
                                }
                            } else {
                                i = R.id.res_0x7f0a0b60_requestmoneyqrcontract_view;
                            }
                        } else {
                            i = R.id.group_total_bills;
                        }
                    } else {
                        i = R.id.group_information;
                    }
                } else {
                    i = R.id.currentBalanceMyBillsView;
                }
            } else {
                i = R.id.btnTopUp;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
