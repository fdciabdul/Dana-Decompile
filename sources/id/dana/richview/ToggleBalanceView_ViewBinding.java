package id.dana.richview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class ToggleBalanceView_ViewBinding implements Unbinder {
    private View KClassImpl$Data$declaredNonStaticMembers$2;
    private ToggleBalanceView MyBillsEntityDataFactory;

    public ToggleBalanceView_ViewBinding(final ToggleBalanceView toggleBalanceView, View view) {
        this.MyBillsEntityDataFactory = toggleBalanceView;
        toggleBalanceView.tvCurrency = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f4378tv_currency, "field 'tvCurrency'", TextView.class);
        toggleBalanceView.tvShownBalance = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_shown_balance, "field 'tvShownBalance'", TextView.class);
        toggleBalanceView.tvHiddenBalance = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_hidden_balance, "field 'tvHiddenBalance'", TextView.class);
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.f3902iv_hide_balance, "field 'ivHideBalance' and method 'onHideBalanceClick'");
        toggleBalanceView.ivHideBalance = (ImageView) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, R.id.f3902iv_hide_balance, "field 'ivHideBalance'", ImageView.class);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.richview.ToggleBalanceView_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                toggleBalanceView.onHideBalanceClick();
            }
        });
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        ToggleBalanceView toggleBalanceView = this.MyBillsEntityDataFactory;
        if (toggleBalanceView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        toggleBalanceView.tvCurrency = null;
        toggleBalanceView.tvShownBalance = null;
        toggleBalanceView.tvHiddenBalance = null;
        toggleBalanceView.ivHideBalance = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(null);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
    }
}
