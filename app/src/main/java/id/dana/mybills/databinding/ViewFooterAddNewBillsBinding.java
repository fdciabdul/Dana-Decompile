package id.dana.mybills.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.mybills.R;
import id.dana.mybills.ui.customview.CurrentBalanceMyBillsViewV2;

/* loaded from: classes9.dex */
public final class ViewFooterAddNewBillsBinding implements ViewBinding {
    public final DanaButtonSecondaryView BuiltInFictitiousFunctionClassFactory;
    public final DanaButtonPrimaryView KClassImpl$Data$declaredNonStaticMembers$2;
    public final CurrentBalanceMyBillsViewV2 PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;

    private ViewFooterAddNewBillsBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, DanaButtonSecondaryView danaButtonSecondaryView, CurrentBalanceMyBillsViewV2 currentBalanceMyBillsViewV2) {
        this.getAuthRequestContext = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonPrimaryView;
        this.BuiltInFictitiousFunctionClassFactory = danaButtonSecondaryView;
        this.PlaceComponentResult = currentBalanceMyBillsViewV2;
    }

    public static ViewFooterAddNewBillsBinding PlaceComponentResult(View view) {
        int i = R.id.A;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
        if (danaButtonPrimaryView != null) {
            i = R.id.res_0x7f0a0187_bottomsheetcardbindingview_watchercardnumberview_1;
            DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
            if (danaButtonSecondaryView != null) {
                i = R.id.currentBalance;
                CurrentBalanceMyBillsViewV2 currentBalanceMyBillsViewV2 = (CurrentBalanceMyBillsViewV2) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                if (currentBalanceMyBillsViewV2 != null) {
                    return new ViewFooterAddNewBillsBinding((ConstraintLayout) view, danaButtonPrimaryView, danaButtonSecondaryView, currentBalanceMyBillsViewV2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
