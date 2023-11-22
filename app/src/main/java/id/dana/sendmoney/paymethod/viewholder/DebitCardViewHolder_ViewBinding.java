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
public class DebitCardViewHolder_ViewBinding implements Unbinder {
    private View MyBillsEntityDataFactory;
    private DebitCardViewHolder getAuthRequestContext;

    public DebitCardViewHolder_ViewBinding(final DebitCardViewHolder debitCardViewHolder, View view) {
        this.getAuthRequestContext = debitCardViewHolder;
        debitCardViewHolder.ivFilter = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_filter, "field 'ivFilter'", ImageView.class);
        debitCardViewHolder.ivLogo = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.SendMoneyHomePresenter, "field 'ivLogo'", ImageView.class);
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.f4091rb_selected_card, "field 'rbSelectedCard' and method 'radioButtonClick'");
        debitCardViewHolder.rbSelectedCard = (RadioButton) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, R.id.f4091rb_selected_card, "field 'rbSelectedCard'", RadioButton.class);
        this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.sendmoney.paymethod.viewholder.DebitCardViewHolder_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                debitCardViewHolder.radioButtonClick();
            }
        });
        debitCardViewHolder.tvDescription = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_description, "field 'tvDescription'", TextView.class);
        debitCardViewHolder.tvDivider = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_divider, "field 'tvDivider'", TextView.class);
        debitCardViewHolder.tvPrefixDescription = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_prefix_description, "field 'tvPrefixDescription'", TextView.class);
        debitCardViewHolder.tvTitle = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        debitCardViewHolder.tvWarning = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f4541tv_warning, "field 'tvWarning'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        DebitCardViewHolder debitCardViewHolder = this.getAuthRequestContext;
        if (debitCardViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.getAuthRequestContext = null;
        debitCardViewHolder.ivFilter = null;
        debitCardViewHolder.ivLogo = null;
        debitCardViewHolder.rbSelectedCard = null;
        debitCardViewHolder.tvDescription = null;
        debitCardViewHolder.tvDivider = null;
        debitCardViewHolder.tvPrefixDescription = null;
        debitCardViewHolder.tvTitle = null;
        debitCardViewHolder.tvWarning = null;
        this.MyBillsEntityDataFactory.setOnClickListener(null);
        this.MyBillsEntityDataFactory = null;
    }
}
