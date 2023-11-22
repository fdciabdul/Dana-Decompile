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
public class DirectDebitViewHolder_ViewBinding implements Unbinder {
    private View BuiltInFictitiousFunctionClassFactory;
    private DirectDebitViewHolder getAuthRequestContext;

    public DirectDebitViewHolder_ViewBinding(final DirectDebitViewHolder directDebitViewHolder, View view) {
        this.getAuthRequestContext = directDebitViewHolder;
        directDebitViewHolder.ivFilter = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_filter, "field 'ivFilter'", ImageView.class);
        directDebitViewHolder.ivLogo = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.SendMoneyHomePresenter, "field 'ivLogo'", ImageView.class);
        directDebitViewHolder.ivPrefixDescription = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_prefix_description, "field 'ivPrefixDescription'", ImageView.class);
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.f4091rb_selected_card, "field 'rbSelectedCard' and method 'radioButtonClick'");
        directDebitViewHolder.rbSelectedCard = (RadioButton) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, R.id.f4091rb_selected_card, "field 'rbSelectedCard'", RadioButton.class);
        this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.sendmoney.paymethod.viewholder.DirectDebitViewHolder_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                directDebitViewHolder.radioButtonClick();
            }
        });
        directDebitViewHolder.tvDescription = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_description, "field 'tvDescription'", TextView.class);
        directDebitViewHolder.tvDivider = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_divider, "field 'tvDivider'", TextView.class);
        directDebitViewHolder.tvTitle = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        directDebitViewHolder.tvWarning = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f4541tv_warning, "field 'tvWarning'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        DirectDebitViewHolder directDebitViewHolder = this.getAuthRequestContext;
        if (directDebitViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.getAuthRequestContext = null;
        directDebitViewHolder.ivFilter = null;
        directDebitViewHolder.ivLogo = null;
        directDebitViewHolder.ivPrefixDescription = null;
        directDebitViewHolder.rbSelectedCard = null;
        directDebitViewHolder.tvDescription = null;
        directDebitViewHolder.tvDivider = null;
        directDebitViewHolder.tvTitle = null;
        directDebitViewHolder.tvWarning = null;
        this.BuiltInFictitiousFunctionClassFactory.setOnClickListener(null);
        this.BuiltInFictitiousFunctionClassFactory = null;
    }
}
