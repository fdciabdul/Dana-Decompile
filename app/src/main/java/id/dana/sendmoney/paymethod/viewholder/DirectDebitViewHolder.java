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
public class DirectDebitViewHolder extends BaseRecyclerViewHolder<PayMethodModel> {
    private BaseRecyclerViewHolder.OnItemClickListener BuiltInFictitiousFunctionClassFactory;
    private boolean MyBillsEntityDataFactory;
    private Context getAuthRequestContext;
    @BindView(R.id.iv_filter)
    ImageView ivFilter;
    @BindView(R.id.SendMoneyHomePresenter)
    ImageView ivLogo;
    @BindView(R.id.iv_prefix_description)
    ImageView ivPrefixDescription;
    @BindView(R.id.f4091rb_selected_card)
    RadioButton rbSelectedCard;
    @BindView(R.id.tv_description)
    TextView tvDescription;
    @BindView(R.id.tv_divider)
    TextView tvDivider;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.f4541tv_warning)
    TextView tvWarning;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(PayMethodModel payMethodModel) {
        PayMethodModel payMethodModel2 = payMethodModel;
        this.rbSelectedCard.setChecked(payMethodModel2.lookAheadTest());
        if (payMethodModel2.DatabaseTableConfigUtil()) {
            getAuthRequestContext("", PaymentIconFactory.getAuthRequestContext(payMethodModel2.KClassImpl$Data$declaredNonStaticMembers$2));
        } else {
            getAuthRequestContext(payMethodModel2.PlaceComponentResult(), payMethodModel2.MyBillsEntityDataFactory());
        }
        this.tvTitle.setText(payMethodModel2.PlaceComponentResult(this.getAuthRequestContext));
        this.tvDescription.setText(payMethodModel2.getAuthRequestContext(getContext()));
        this.MyBillsEntityDataFactory = payMethodModel2.getAuthRequestContext();
        boolean authRequestContext = payMethodModel2.getAuthRequestContext();
        this.ivPrefixDescription.setVisibility(authRequestContext ? 0 : 8);
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

    public DirectDebitViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_paymethod_direct_debit, viewGroup);
        this.getAuthRequestContext = viewGroup.getContext();
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public void setOnItemClickListener(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener) {
        if (this.MyBillsEntityDataFactory) {
            super.setOnItemClickListener(onItemClickListener);
            this.BuiltInFictitiousFunctionClassFactory = onItemClickListener;
        }
    }

    private void getAuthRequestContext(String str, int i) {
        GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(str).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).BuiltInFictitiousFunctionClassFactory((BaseRequestOptions<?>) ImageResize.getAuthRequestContext()).getErrorConfigVersion(i).PlaceComponentResult(i).MyBillsEntityDataFactory(this.ivLogo);
    }

    @OnClick({R.id.f4091rb_selected_card})
    public void radioButtonClick() {
        BaseRecyclerViewHolder.OnItemClickListener onItemClickListener = this.BuiltInFictitiousFunctionClassFactory;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(getAdapterPosition());
        }
    }
}
