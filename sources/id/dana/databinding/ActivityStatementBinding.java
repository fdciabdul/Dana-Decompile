package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.richview.statement.StatementChartView;

/* loaded from: classes4.dex */
public final class ActivityStatementBinding implements ViewBinding {
    private final LinearLayout BuiltInFictitiousFunctionClassFactory;
    public final LayoutToolbarBinding KClassImpl$Data$declaredNonStaticMembers$2;
    public final StatementChartView MyBillsEntityDataFactory;
    public final LayoutStatementSummaryBinding PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;

    private ActivityStatementBinding(LinearLayout linearLayout, ConstraintLayout constraintLayout, LayoutStatementSummaryBinding layoutStatementSummaryBinding, LayoutToolbarBinding layoutToolbarBinding, StatementChartView statementChartView) {
        this.BuiltInFictitiousFunctionClassFactory = linearLayout;
        this.getAuthRequestContext = constraintLayout;
        this.PlaceComponentResult = layoutStatementSummaryBinding;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = layoutToolbarBinding;
        this.MyBillsEntityDataFactory = statementChartView;
    }

    public static ActivityStatementBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_statement, (ViewGroup) null, false);
        int i = R.id.f3783fl_feeds_tab;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3783fl_feeds_tab);
        if (constraintLayout != null) {
            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.layout_statement_summary);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                LayoutStatementSummaryBinding KClassImpl$Data$declaredNonStaticMembers$2 = LayoutStatementSummaryBinding.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory);
                View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.SecurityGuardProfileProvider);
                if (BuiltInFictitiousFunctionClassFactory2 != null) {
                    LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2);
                    StatementChartView statementChartView = (StatementChartView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.SQLiteDatabaseCorruptException);
                    if (statementChartView != null) {
                        return new ActivityStatementBinding((LinearLayout) inflate, constraintLayout, KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory, statementChartView);
                    }
                    i = R.id.SQLiteDatabaseCorruptException;
                } else {
                    i = R.id.SecurityGuardProfileProvider;
                }
            } else {
                i = R.id.layout_statement_summary;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
