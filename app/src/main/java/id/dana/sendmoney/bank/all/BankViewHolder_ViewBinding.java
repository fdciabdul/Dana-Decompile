package id.dana.sendmoney.bank.all;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class BankViewHolder_ViewBinding implements Unbinder {
    private BankViewHolder BuiltInFictitiousFunctionClassFactory;

    public BankViewHolder_ViewBinding(BankViewHolder bankViewHolder, View view) {
        this.BuiltInFictitiousFunctionClassFactory = bankViewHolder;
        bankViewHolder.ivLogo = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.SendMoneyHomePresenter, "field 'ivLogo'", ImageView.class);
        bankViewHolder.tvPrefixDescription = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_prefix_description, "field 'tvPrefixDescription'", TextView.class);
        bankViewHolder.tvTitle = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        bankViewHolder.tvViewDescription = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_description, "field 'tvViewDescription'", TextView.class);
        bankViewHolder.ivChangeIcon = (AppCompatImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_change_icon, "field 'ivChangeIcon'", AppCompatImageView.class);
        bankViewHolder.vDividerFull = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.view_divider_full, "field 'vDividerFull'");
        bankViewHolder.vDividerWithMargin = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.view_divider_with_margin, "field 'vDividerWithMargin'");
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        BankViewHolder bankViewHolder = this.BuiltInFictitiousFunctionClassFactory;
        if (bankViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        bankViewHolder.ivLogo = null;
        bankViewHolder.tvPrefixDescription = null;
        bankViewHolder.tvTitle = null;
        bankViewHolder.tvViewDescription = null;
        bankViewHolder.ivChangeIcon = null;
        bankViewHolder.vDividerFull = null;
        bankViewHolder.vDividerWithMargin = null;
    }
}
