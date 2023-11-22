package id.dana.sendmoney.paymethod.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.model.PayMethodModel;

/* loaded from: classes5.dex */
public class SectionViewHolder extends BaseRecyclerViewHolder<PayMethodModel> {
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public void setOnItemClickListener(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener) {
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(PayMethodModel payMethodModel) {
        this.tvTitle.setText(payMethodModel.NetworkUserEntityData$$ExternalSyntheticLambda8);
    }

    public SectionViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_paymethod_section, viewGroup);
    }
}
