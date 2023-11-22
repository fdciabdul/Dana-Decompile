package id.dana.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.cashier.view.DailyLimitBoxView;

/* loaded from: classes4.dex */
public final class ItemDailyLimitBoxBinding implements ViewBinding {
    private final RelativeLayout BuiltInFictitiousFunctionClassFactory;
    public final DailyLimitBoxView KClassImpl$Data$declaredNonStaticMembers$2;

    private ItemDailyLimitBoxBinding(RelativeLayout relativeLayout, DailyLimitBoxView dailyLimitBoxView) {
        this.BuiltInFictitiousFunctionClassFactory = relativeLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = dailyLimitBoxView;
    }

    public static ItemDailyLimitBoxBinding getAuthRequestContext(View view) {
        DailyLimitBoxView dailyLimitBoxView = (DailyLimitBoxView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.viewDailyLimit);
        if (dailyLimitBoxView != null) {
            return new ItemDailyLimitBoxBinding((RelativeLayout) view, dailyLimitBoxView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.viewDailyLimit)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
