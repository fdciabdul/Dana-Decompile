package id.dana.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.richview.CurrencyTextView;

/* loaded from: classes4.dex */
public final class ViewMyBillsMonthlyBinding implements ViewBinding {
    public final View BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final View MyBillsEntityDataFactory;
    public final ConstraintLayout PlaceComponentResult;
    public final DanaButtonPrimaryView getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final RecyclerView lookAheadTest;
    public final CurrencyTextView moveToNextValue;
    public final TextView scheduleImpl;

    private ViewMyBillsMonthlyBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, ConstraintLayout constraintLayout2, View view, View view2, RecyclerView recyclerView, TextView textView, CurrencyTextView currencyTextView, TextView textView2) {
        this.PlaceComponentResult = constraintLayout;
        this.getAuthRequestContext = danaButtonPrimaryView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout2;
        this.BuiltInFictitiousFunctionClassFactory = view;
        this.MyBillsEntityDataFactory = view2;
        this.lookAheadTest = recyclerView;
        this.getErrorConfigVersion = textView;
        this.moveToNextValue = currencyTextView;
        this.scheduleImpl = textView2;
    }

    public static ViewMyBillsMonthlyBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int i = R.id.btn_my_bills_add_bill;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_my_bills_add_bill);
        if (danaButtonPrimaryView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.divider_bottom_line);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.divider_line);
                if (BuiltInFictitiousFunctionClassFactory2 != null) {
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rv_my_bills_monthly);
                    if (recyclerView != null) {
                        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_my_bills_monthly_count);
                        if (textView != null) {
                            CurrencyTextView currencyTextView = (CurrencyTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_my_bills_monthly_total_amount);
                            if (currencyTextView != null) {
                                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_view_all);
                                if (textView2 != null) {
                                    return new ViewMyBillsMonthlyBinding(constraintLayout, danaButtonPrimaryView, constraintLayout, BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory2, recyclerView, textView, currencyTextView, textView2);
                                }
                                i = R.id.tv_view_all;
                            } else {
                                i = R.id.tv_my_bills_monthly_total_amount;
                            }
                        } else {
                            i = R.id.tv_my_bills_monthly_count;
                        }
                    } else {
                        i = R.id.rv_my_bills_monthly;
                    }
                } else {
                    i = R.id.divider_line;
                }
            } else {
                i = R.id.divider_bottom_line;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
