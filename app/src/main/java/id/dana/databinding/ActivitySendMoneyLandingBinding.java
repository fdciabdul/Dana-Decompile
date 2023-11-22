package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.sendmoney_v2.landing.view.RecentTransactionView;
import id.dana.sendmoney_v2.landing.view.SendMoneyScenariosView;

/* loaded from: classes4.dex */
public final class ActivitySendMoneyLandingBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final LayoutToolbarBinding KClassImpl$Data$declaredNonStaticMembers$2;
    public final SendMoneyScenariosView MyBillsEntityDataFactory;
    public final RecentTransactionView PlaceComponentResult;
    public final NestedScrollView getAuthRequestContext;
    private final ConstraintLayout lookAheadTest;

    private ActivitySendMoneyLandingBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, NestedScrollView nestedScrollView, RecentTransactionView recentTransactionView, SendMoneyScenariosView sendMoneyScenariosView, LayoutToolbarBinding layoutToolbarBinding) {
        this.lookAheadTest = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.getAuthRequestContext = nestedScrollView;
        this.PlaceComponentResult = recentTransactionView;
        this.MyBillsEntityDataFactory = sendMoneyScenariosView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = layoutToolbarBinding;
    }

    public static ActivitySendMoneyLandingBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_send_money_landing, (ViewGroup) null, false);
        int i = R.id.ivBackground;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivBackground);
        if (appCompatImageView != null) {
            NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.nestedScrollView);
            if (nestedScrollView != null) {
                RecentTransactionView recentTransactionView = (RecentTransactionView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.recentTransactionView);
                if (recentTransactionView != null) {
                    SendMoneyScenariosView sendMoneyScenariosView = (SendMoneyScenariosView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.recipientSelectorView);
                    if (sendMoneyScenariosView != null) {
                        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.toolbarSendMoney);
                        if (BuiltInFictitiousFunctionClassFactory != null) {
                            return new ActivitySendMoneyLandingBinding((ConstraintLayout) inflate, appCompatImageView, nestedScrollView, recentTransactionView, sendMoneyScenariosView, LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory));
                        }
                        i = R.id.toolbarSendMoney;
                    } else {
                        i = R.id.recipientSelectorView;
                    }
                } else {
                    i = R.id.recentTransactionView;
                }
            } else {
                i = R.id.nestedScrollView;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest;
    }
}
