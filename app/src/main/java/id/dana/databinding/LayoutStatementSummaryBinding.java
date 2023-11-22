package id.dana.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.statement.view.AccumulateStatementAmountView;
import id.dana.statement.view.StatementDateView;

/* loaded from: classes4.dex */
public final class LayoutStatementSummaryBinding implements ViewBinding {
    public final DanaButtonPrimaryView BuiltInFictitiousFunctionClassFactory;
    public final ImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final StatementDateView NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final LinearLayout NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final LinearLayout PlaceComponentResult;
    public final LinearLayout getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final RecyclerView lookAheadTest;
    public final AccumulateStatementAmountView moveToNextValue;
    public final TextView scheduleImpl;

    private LayoutStatementSummaryBinding(LinearLayout linearLayout, DanaButtonPrimaryView danaButtonPrimaryView, ConstraintLayout constraintLayout, ImageView imageView, LinearLayout linearLayout2, LinearLayout linearLayout3, RecyclerView recyclerView, TextView textView, TextView textView2, AccumulateStatementAmountView accumulateStatementAmountView, StatementDateView statementDateView) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = linearLayout;
        this.BuiltInFictitiousFunctionClassFactory = danaButtonPrimaryView;
        this.MyBillsEntityDataFactory = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = imageView;
        this.PlaceComponentResult = linearLayout2;
        this.getAuthRequestContext = linearLayout3;
        this.lookAheadTest = recyclerView;
        this.getErrorConfigVersion = textView;
        this.scheduleImpl = textView2;
        this.moveToNextValue = accumulateStatementAmountView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = statementDateView;
    }

    public static LayoutStatementSummaryBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int i = R.id.btn_download_statement;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_download_statement);
        if (danaButtonPrimaryView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cl_empty_statement);
            if (constraintLayout != null) {
                ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_empty_placeholder);
                if (imageView != null) {
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ll_btn_download);
                    if (linearLayout != null) {
                        LinearLayout linearLayout2 = (LinearLayout) view;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rv_statement_detail);
                        if (recyclerView != null) {
                            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_empty_note);
                            if (textView != null) {
                                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_statement_detail_info);
                                if (textView2 != null) {
                                    AccumulateStatementAmountView accumulateStatementAmountView = (AccumulateStatementAmountView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4572view_accumulate_statement_amount);
                                    if (accumulateStatementAmountView != null) {
                                        StatementDateView statementDateView = (StatementDateView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.WithdrawSavedCardChannelModel);
                                        if (statementDateView != null) {
                                            return new LayoutStatementSummaryBinding(linearLayout2, danaButtonPrimaryView, constraintLayout, imageView, linearLayout, linearLayout2, recyclerView, textView, textView2, accumulateStatementAmountView, statementDateView);
                                        }
                                        i = R.id.WithdrawSavedCardChannelModel;
                                    } else {
                                        i = R.id.f4572view_accumulate_statement_amount;
                                    }
                                } else {
                                    i = R.id.tv_statement_detail_info;
                                }
                            } else {
                                i = R.id.tv_empty_note;
                            }
                        } else {
                            i = R.id.rv_statement_detail;
                        }
                    } else {
                        i = R.id.ll_btn_download;
                    }
                } else {
                    i = R.id.iv_empty_placeholder;
                }
            } else {
                i = R.id.cl_empty_statement;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }
}
