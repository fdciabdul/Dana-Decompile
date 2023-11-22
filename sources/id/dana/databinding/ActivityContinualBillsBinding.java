package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.mybills.view.FooterMonthlyView;
import id.dana.mybills.view.TotalEstimatedBillsView;

/* loaded from: classes4.dex */
public final class ActivityContinualBillsBinding implements ViewBinding {
    public final RecyclerView BuiltInFictitiousFunctionClassFactory;
    public final TotalEstimatedBillsView KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextView MyBillsEntityDataFactory;
    public final LayoutToolbarBinding PlaceComponentResult;
    public final FooterMonthlyView getAuthRequestContext;
    public final TextView lookAheadTest;
    private final ConstraintLayout scheduleImpl;

    private ActivityContinualBillsBinding(ConstraintLayout constraintLayout, FooterMonthlyView footerMonthlyView, LayoutToolbarBinding layoutToolbarBinding, RecyclerView recyclerView, TotalEstimatedBillsView totalEstimatedBillsView, TextView textView, TextView textView2) {
        this.scheduleImpl = constraintLayout;
        this.getAuthRequestContext = footerMonthlyView;
        this.PlaceComponentResult = layoutToolbarBinding;
        this.BuiltInFictitiousFunctionClassFactory = recyclerView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = totalEstimatedBillsView;
        this.MyBillsEntityDataFactory = textView;
        this.lookAheadTest = textView2;
    }

    public static ActivityContinualBillsBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_continual_bills, (ViewGroup) null, false);
        int i = R.id.footerMyBillsView;
        FooterMonthlyView footerMonthlyView = (FooterMonthlyView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.footerMyBillsView);
        if (footerMonthlyView != null) {
            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.SecurityGuardProfileProvider);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.rvBillPaymentStatus);
                if (recyclerView != null) {
                    TotalEstimatedBillsView totalEstimatedBillsView = (TotalEstimatedBillsView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.totalEstimatedBillView);
                    if (totalEstimatedBillsView != null) {
                        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_date_range);
                        if (textView != null) {
                            TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.getQualifiedNames);
                            if (textView2 != null) {
                                return new ActivityContinualBillsBinding((ConstraintLayout) inflate, footerMonthlyView, MyBillsEntityDataFactory, recyclerView, totalEstimatedBillsView, textView, textView2);
                            }
                            i = R.id.getQualifiedNames;
                        } else {
                            i = R.id.tv_date_range;
                        }
                    } else {
                        i = R.id.totalEstimatedBillView;
                    }
                } else {
                    i = R.id.rvBillPaymentStatus;
                }
            } else {
                i = R.id.SecurityGuardProfileProvider;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
