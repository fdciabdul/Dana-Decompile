package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewKybTransactionLimitBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    public final ProgressBar KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final TextView PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;
    public final View moveToNextValue;

    private ViewKybTransactionLimitBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, ProgressBar progressBar, TextView textView, TextView textView2, View view) {
        this.getAuthRequestContext = constraintLayout;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = progressBar;
        this.PlaceComponentResult = textView;
        this.BuiltInFictitiousFunctionClassFactory = textView2;
        this.moveToNextValue = view;
    }

    public static ViewKybTransactionLimitBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_kyb_transaction_limit, (ViewGroup) null, false);
        int i = R.id.iv_limit_almost_reached;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_limit_almost_reached);
        if (appCompatImageView != null) {
            ProgressBar progressBar = (ProgressBar) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.pb_transaction_progress);
            if (progressBar != null) {
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_monthly_transaction_limit);
                if (textView != null) {
                    TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_transaction_progress);
                    if (textView2 != null) {
                        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.view_top_line);
                        if (BuiltInFictitiousFunctionClassFactory != null) {
                            return new ViewKybTransactionLimitBinding((ConstraintLayout) inflate, appCompatImageView, progressBar, textView, textView2, BuiltInFictitiousFunctionClassFactory);
                        }
                        i = R.id.view_top_line;
                    } else {
                        i = R.id.tv_transaction_progress;
                    }
                } else {
                    i = R.id.tv_monthly_transaction_limit;
                }
            } else {
                i = R.id.pb_transaction_progress;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
