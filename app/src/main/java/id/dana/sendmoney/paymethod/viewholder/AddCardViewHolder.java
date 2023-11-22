package id.dana.sendmoney.paymethod.viewholder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.domain.payasset.model.Institution;
import id.dana.model.PayMethodModel;
import id.dana.utils.ImageResize;

/* loaded from: classes5.dex */
public class AddCardViewHolder extends BaseRecyclerViewHolder<PayMethodModel> {
    private Context KClassImpl$Data$declaredNonStaticMembers$2;
    private BaseRecyclerViewHolder.OnItemClickListener getAuthRequestContext;
    @BindView(R.id.SendMoneyHomePresenter)
    ImageView ivLogo;
    @BindView(R.id.iv_prefix_description)
    ImageView ivPrefixDescription;
    @BindView(R.id.f4091rb_selected_card)
    RadioButton rbSelectedCard;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(PayMethodModel payMethodModel) {
        int i;
        PayMethodModel payMethodModel2 = payMethodModel;
        this.rbSelectedCard.setChecked(payMethodModel2.lookAheadTest());
        this.tvTitle.setText(payMethodModel2.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2));
        String PlaceComponentResult = payMethodModel2.PlaceComponentResult();
        int MyBillsEntityDataFactory = payMethodModel2.MyBillsEntityDataFactory();
        GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(PlaceComponentResult).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).BuiltInFictitiousFunctionClassFactory((BaseRequestOptions<?>) ImageResize.getAuthRequestContext()).getErrorConfigVersion(MyBillsEntityDataFactory).PlaceComponentResult(MyBillsEntityDataFactory).MyBillsEntityDataFactory(this.ivLogo);
        if (Institution.BCA_ONEKLIK.equalsIgnoreCase(payMethodModel2.lookAheadTest)) {
            i = R.drawable.ic_oneklik;
        } else {
            i = payMethodModel2.moveToNextValue() ? R.drawable.ic_logo_expresspay : R.drawable.ic_visamaster;
        }
        InstrumentInjector.Resources_setImageResource(this.ivPrefixDescription, i);
    }

    public AddCardViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_paymethod_add_card, viewGroup);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = viewGroup.getContext();
    }

    @OnClick({R.id.f4091rb_selected_card})
    public void radioButtonClick() {
        this.getAuthRequestContext.onItemClick(getAdapterPosition());
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public void setOnItemClickListener(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener) {
        super.setOnItemClickListener(onItemClickListener);
        this.getAuthRequestContext = onItemClickListener;
    }
}
