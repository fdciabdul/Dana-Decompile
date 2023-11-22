package id.dana.sendmoney.paymethod.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.model.PayMethodModel;

/* loaded from: classes5.dex */
public class BalanceViewHolder extends BaseRecyclerViewHolder<PayMethodModel> {
    private BaseRecyclerViewHolder.OnItemClickListener BuiltInFictitiousFunctionClassFactory;
    @BindView(R.id.SendMoneyHomePresenter)
    ImageView ivLogo;
    @BindView(R.id.f4091rb_selected_card)
    RadioButton rbSelectedCard;
    @BindView(R.id.tv_description)
    TextView tvDescription;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(PayMethodModel payMethodModel) {
        PayMethodModel payMethodModel2 = payMethodModel;
        this.rbSelectedCard.setChecked(payMethodModel2.lookAheadTest());
        InstrumentInjector.Resources_setImageResource(this.ivLogo, payMethodModel2.MyBillsEntityDataFactory());
        this.tvTitle.setText(payMethodModel2.PlaceComponentResult(getContext()));
        this.tvDescription.setText(payMethodModel2.getAuthRequestContext(getContext()));
    }

    public BalanceViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_paymethod_balance, viewGroup);
    }

    @OnClick({R.id.f4091rb_selected_card})
    public void radioButtonClick() {
        this.BuiltInFictitiousFunctionClassFactory.onItemClick(getAdapterPosition());
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public void setOnItemClickListener(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener) {
        super.setOnItemClickListener(onItemClickListener);
        this.BuiltInFictitiousFunctionClassFactory = onItemClickListener;
    }
}
