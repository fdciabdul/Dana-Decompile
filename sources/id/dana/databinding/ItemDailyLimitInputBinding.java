package id.dana.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.cashier.view.DailyLimitCashierView;

/* loaded from: classes4.dex */
public final class ItemDailyLimitInputBinding implements ViewBinding {
    private final RelativeLayout BuiltInFictitiousFunctionClassFactory;
    public final DailyLimitCashierView getAuthRequestContext;

    private ItemDailyLimitInputBinding(RelativeLayout relativeLayout, DailyLimitCashierView dailyLimitCashierView) {
        this.BuiltInFictitiousFunctionClassFactory = relativeLayout;
        this.getAuthRequestContext = dailyLimitCashierView;
    }

    public static ItemDailyLimitInputBinding getAuthRequestContext(View view) {
        DailyLimitCashierView dailyLimitCashierView = (DailyLimitCashierView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.viewDailyLimit);
        if (dailyLimitCashierView != null) {
            return new ItemDailyLimitInputBinding((RelativeLayout) view, dailyLimitCashierView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.viewDailyLimit)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
