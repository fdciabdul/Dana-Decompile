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
public class AddCardViewHolder_ViewBinding implements Unbinder {
    private AddCardViewHolder BuiltInFictitiousFunctionClassFactory;
    private View MyBillsEntityDataFactory;

    public AddCardViewHolder_ViewBinding(final AddCardViewHolder addCardViewHolder, View view) {
        this.BuiltInFictitiousFunctionClassFactory = addCardViewHolder;
        addCardViewHolder.ivLogo = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.SendMoneyHomePresenter, "field 'ivLogo'", ImageView.class);
        addCardViewHolder.ivPrefixDescription = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_prefix_description, "field 'ivPrefixDescription'", ImageView.class);
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.f4091rb_selected_card, "field 'rbSelectedCard' and method 'radioButtonClick'");
        addCardViewHolder.rbSelectedCard = (RadioButton) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, R.id.f4091rb_selected_card, "field 'rbSelectedCard'", RadioButton.class);
        this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.sendmoney.paymethod.viewholder.AddCardViewHolder_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                addCardViewHolder.radioButtonClick();
            }
        });
        addCardViewHolder.tvTitle = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        AddCardViewHolder addCardViewHolder = this.BuiltInFictitiousFunctionClassFactory;
        if (addCardViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        addCardViewHolder.ivLogo = null;
        addCardViewHolder.ivPrefixDescription = null;
        addCardViewHolder.rbSelectedCard = null;
        addCardViewHolder.tvTitle = null;
        this.MyBillsEntityDataFactory.setOnClickListener(null);
        this.MyBillsEntityDataFactory = null;
    }
}
