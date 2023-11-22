package id.dana.sendmoney.paymethod.viewholder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import butterknife.OnClick;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.model.PayMethodModel;
import id.dana.sendmoney.paymethod.PaymentIconFactory;
import id.dana.utils.ImageResize;

/* loaded from: classes5.dex */
public class DebitCardViewHolder extends BaseRecyclerViewHolder<PayMethodModel> {
    private boolean BuiltInFictitiousFunctionClassFactory;
    private Context MyBillsEntityDataFactory;
    private BaseRecyclerViewHolder.OnItemClickListener getAuthRequestContext;
    @BindView(R.id.iv_filter)
    ImageView ivFilter;
    @BindView(R.id.SendMoneyHomePresenter)
    ImageView ivLogo;
    @BindView(R.id.f4091rb_selected_card)
    RadioButton rbSelectedCard;
    @BindView(R.id.tv_description)
    TextView tvDescription;
    @BindView(R.id.tv_divider)
    TextView tvDivider;
    @BindView(R.id.tv_prefix_description)
    TextView tvPrefixDescription;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.f4541tv_warning)
    TextView tvWarning;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(PayMethodModel payMethodModel) {
        PayMethodModel payMethodModel2 = payMethodModel;
        this.rbSelectedCard.setChecked(payMethodModel2.lookAheadTest());
        if (payMethodModel2.DatabaseTableConfigUtil()) {
            BuiltInFictitiousFunctionClassFactory("", PaymentIconFactory.getAuthRequestContext(payMethodModel2.KClassImpl$Data$declaredNonStaticMembers$2));
        } else {
            BuiltInFictitiousFunctionClassFactory(payMethodModel2.PlaceComponentResult(), payMethodModel2.MyBillsEntityDataFactory());
        }
        this.tvTitle.setText(payMethodModel2.PlaceComponentResult(this.MyBillsEntityDataFactory));
        this.tvDescription.setText(payMethodModel2.getAuthRequestContext(getContext()));
        this.BuiltInFictitiousFunctionClassFactory = payMethodModel2.getAuthRequestContext();
        boolean authRequestContext = payMethodModel2.getAuthRequestContext();
        this.tvPrefixDescription.setVisibility(authRequestContext ? 0 : 8);
        this.tvDivider.setVisibility(authRequestContext ? 0 : 8);
        this.rbSelectedCard.setEnabled(authRequestContext);
        if (authRequestContext) {
            return;
        }
        this.tvDescription.setText(getContext().getString(R.string.cant_use_pay_method));
        this.tvDescription.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f26702131100367));
        this.tvTitle.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f24012131099998));
        this.ivFilter.setVisibility(0);
    }

    public DebitCardViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_paymethod_debit_card, viewGroup);
        this.MyBillsEntityDataFactory = viewGroup.getContext();
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public void setOnItemClickListener(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener) {
        if (this.BuiltInFictitiousFunctionClassFactory) {
            super.setOnItemClickListener(onItemClickListener);
            this.getAuthRequestContext = onItemClickListener;
        }
    }

    private void BuiltInFictitiousFunctionClassFactory(String str, int i) {
        GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(str).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).BuiltInFictitiousFunctionClassFactory((BaseRequestOptions<?>) ImageResize.getAuthRequestContext()).getErrorConfigVersion(i).PlaceComponentResult(i).MyBillsEntityDataFactory(this.ivLogo);
    }

    @OnClick({R.id.f4091rb_selected_card})
    public void radioButtonClick() {
        BaseRecyclerViewHolder.OnItemClickListener onItemClickListener = this.getAuthRequestContext;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(getAdapterPosition());
        }
    }
}
