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
import id.dana.utils.ImageResize;

/* loaded from: classes5.dex */
public class OneKlikViewHolder extends BaseRecyclerViewHolder<PayMethodModel> {
    private Context BuiltInFictitiousFunctionClassFactory;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private BaseRecyclerViewHolder.OnItemClickListener getAuthRequestContext;
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
        String PlaceComponentResult = payMethodModel2.PlaceComponentResult();
        int MyBillsEntityDataFactory = payMethodModel2.MyBillsEntityDataFactory();
        GlideApp.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory).PlaceComponentResult(PlaceComponentResult).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).BuiltInFictitiousFunctionClassFactory((BaseRequestOptions<?>) ImageResize.getAuthRequestContext()).getErrorConfigVersion(MyBillsEntityDataFactory).PlaceComponentResult(MyBillsEntityDataFactory).MyBillsEntityDataFactory(this.ivLogo);
        this.tvTitle.setText(payMethodModel2.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory));
        this.tvDescription.setText(payMethodModel2.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory));
        this.KClassImpl$Data$declaredNonStaticMembers$2 = payMethodModel2.getAuthRequestContext();
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

    public OneKlikViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_paymethod_one_klik, viewGroup);
        this.BuiltInFictitiousFunctionClassFactory = viewGroup.getContext();
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public void setOnItemClickListener(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            this.getAuthRequestContext = onItemClickListener;
            super.setOnItemClickListener(onItemClickListener);
        }
    }

    @OnClick({R.id.f4091rb_selected_card})
    public void radioButtonClick() {
        BaseRecyclerViewHolder.OnItemClickListener onItemClickListener = this.getAuthRequestContext;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(getAdapterPosition());
        }
    }
}
