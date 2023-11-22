package id.dana.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewHomeInvestmentBinding implements ViewBinding {
    public final FrameLayout BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final AppCompatImageView PlaceComponentResult;
    public final AppCompatTextView getAuthRequestContext;
    public final TextView lookAheadTest;
    private final FrameLayout moveToNextValue;
    public final ViewHeaderWithActionBinding scheduleImpl;

    private ViewHomeInvestmentBinding(FrameLayout frameLayout, ConstraintLayout constraintLayout, FrameLayout frameLayout2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView, TextView textView, TextView textView2, ViewHeaderWithActionBinding viewHeaderWithActionBinding) {
        this.moveToNextValue = frameLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = frameLayout2;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.PlaceComponentResult = appCompatImageView2;
        this.getAuthRequestContext = appCompatTextView;
        this.lookAheadTest = textView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView2;
        this.scheduleImpl = viewHeaderWithActionBinding;
    }

    public static ViewHomeInvestmentBinding BuiltInFictitiousFunctionClassFactory(View view) {
        int i = R.id.clMyInvestmentPortfolioCard;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.clMyInvestmentPortfolioCard);
        if (constraintLayout != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivGainAndLoss);
            if (appCompatImageView != null) {
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivPortfolioLogo);
                if (appCompatImageView2 != null) {
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvGainAndLossPortfolio);
                    if (appCompatTextView != null) {
                        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvPortfolio);
                        if (textView != null) {
                            TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvPortfolioLastUpdated);
                            if (textView2 != null) {
                                View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.v_header_with_action);
                                if (BuiltInFictitiousFunctionClassFactory != null) {
                                    return new ViewHomeInvestmentBinding(frameLayout, constraintLayout, frameLayout, appCompatImageView, appCompatImageView2, appCompatTextView, textView, textView2, ViewHeaderWithActionBinding.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory));
                                }
                                i = R.id.v_header_with_action;
                            } else {
                                i = R.id.tvPortfolioLastUpdated;
                            }
                        } else {
                            i = R.id.tvPortfolio;
                        }
                    } else {
                        i = R.id.tvGainAndLossPortfolio;
                    }
                } else {
                    i = R.id.ivPortfolioLogo;
                }
            } else {
                i = R.id.ivGainAndLoss;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue;
    }
}
