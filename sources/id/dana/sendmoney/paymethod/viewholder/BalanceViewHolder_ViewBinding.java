package id.dana.sendmoney.paymethod.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class BalanceViewHolder_ViewBinding implements Unbinder {
    private View KClassImpl$Data$declaredNonStaticMembers$2;
    private BalanceViewHolder MyBillsEntityDataFactory;

    public BalanceViewHolder_ViewBinding(final BalanceViewHolder balanceViewHolder, View view) {
        this.MyBillsEntityDataFactory = balanceViewHolder;
        balanceViewHolder.ivLogo = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.SendMoneyHomePresenter, "field 'ivLogo'", ImageView.class);
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.f4091rb_selected_card, "field 'rbSelectedCard' and method 'radioButtonClick'");
        balanceViewHolder.rbSelectedCard = (RadioButton) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, R.id.f4091rb_selected_card, "field 'rbSelectedCard'", RadioButton.class);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.sendmoney.paymethod.viewholder.BalanceViewHolder_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                balanceViewHolder.radioButtonClick();
            }
        });
        balanceViewHolder.tvDescription = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_description, "field 'tvDescription'", TextView.class);
        balanceViewHolder.tvTitle = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        BalanceViewHolder balanceViewHolder = this.MyBillsEntityDataFactory;
        if (balanceViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        balanceViewHolder.ivLogo = null;
        balanceViewHolder.rbSelectedCard = null;
        balanceViewHolder.tvDescription = null;
        balanceViewHolder.tvTitle = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(null);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
    }
}
