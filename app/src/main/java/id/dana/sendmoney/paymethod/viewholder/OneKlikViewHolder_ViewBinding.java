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
public class OneKlikViewHolder_ViewBinding implements Unbinder {
    private OneKlikViewHolder BuiltInFictitiousFunctionClassFactory;
    private View KClassImpl$Data$declaredNonStaticMembers$2;

    public OneKlikViewHolder_ViewBinding(final OneKlikViewHolder oneKlikViewHolder, View view) {
        this.BuiltInFictitiousFunctionClassFactory = oneKlikViewHolder;
        oneKlikViewHolder.ivFilter = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_filter, "field 'ivFilter'", ImageView.class);
        oneKlikViewHolder.ivLogo = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.SendMoneyHomePresenter, "field 'ivLogo'", ImageView.class);
        oneKlikViewHolder.ivPrefixDescription = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_prefix_description, "field 'ivPrefixDescription'", ImageView.class);
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.f4091rb_selected_card, "field 'rbSelectedCard' and method 'radioButtonClick'");
        oneKlikViewHolder.rbSelectedCard = (RadioButton) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, R.id.f4091rb_selected_card, "field 'rbSelectedCard'", RadioButton.class);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.sendmoney.paymethod.viewholder.OneKlikViewHolder_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                oneKlikViewHolder.radioButtonClick();
            }
        });
        oneKlikViewHolder.tvDescription = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_description, "field 'tvDescription'", TextView.class);
        oneKlikViewHolder.tvDivider = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_divider, "field 'tvDivider'", TextView.class);
        oneKlikViewHolder.tvTitle = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        oneKlikViewHolder.tvWarning = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f4541tv_warning, "field 'tvWarning'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        OneKlikViewHolder oneKlikViewHolder = this.BuiltInFictitiousFunctionClassFactory;
        if (oneKlikViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        oneKlikViewHolder.ivFilter = null;
        oneKlikViewHolder.ivLogo = null;
        oneKlikViewHolder.ivPrefixDescription = null;
        oneKlikViewHolder.rbSelectedCard = null;
        oneKlikViewHolder.tvDescription = null;
        oneKlikViewHolder.tvDivider = null;
        oneKlikViewHolder.tvTitle = null;
        oneKlikViewHolder.tvWarning = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(null);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
    }
}
