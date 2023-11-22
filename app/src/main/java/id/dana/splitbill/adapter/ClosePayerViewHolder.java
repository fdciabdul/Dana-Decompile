package id.dana.splitbill.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.data.util.NumberUtils;
import id.dana.splitbill.model.PayerModel;
import id.dana.utils.ImageResize;

/* loaded from: classes5.dex */
public class ClosePayerViewHolder extends BaseRecyclerViewHolder<PayerModel> {
    OnCheckedListener PlaceComponentResult;
    @BindView(R.id.cb_close_payer)
    CheckBox cbClosePayer;
    @BindView(R.id.civ_close_payer_avatar)
    CircleImageView civClosePayerAvatar;
    private Context getAuthRequestContext;
    @BindView(R.id.tv_close_payer_amount)
    TextView tvClosePayerAmount;
    @BindView(R.id.tv_close_payer_name)
    TextView tvClosePayerName;
    @BindView(R.id.tv_close_payer_phone)
    TextView tvClosePayerPhone;

    /* loaded from: classes5.dex */
    public interface OnCheckedListener {
        void PlaceComponentResult();
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(PayerModel payerModel) {
        final PayerModel payerModel2 = payerModel;
        this.cbClosePayer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.splitbill.adapter.ClosePayerViewHolder$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ClosePayerViewHolder closePayerViewHolder = ClosePayerViewHolder.this;
                payerModel2.scheduleImpl = z;
                closePayerViewHolder.PlaceComponentResult.PlaceComponentResult();
            }
        });
        this.cbClosePayer.setChecked(payerModel2.BuiltInFictitiousFunctionClassFactory());
        GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(payerModel2.KClassImpl$Data$declaredNonStaticMembers$2).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).BuiltInFictitiousFunctionClassFactory((BaseRequestOptions<?>) ImageResize.getAuthRequestContext()).getErrorConfigVersion((int) R.drawable.ic_contact_placeholder).PlaceComponentResult((int) R.drawable.ic_contact_placeholder).MyBillsEntityDataFactory((ImageView) this.civClosePayerAvatar);
        this.tvClosePayerName.setText(PlaceComponentResult(payerModel2) ? this.getAuthRequestContext.getString(R.string.payer) : payerModel2.MyBillsEntityDataFactory);
        this.tvClosePayerAmount.setText(payerModel2.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext());
        this.tvClosePayerPhone.setText(NumberUtils.getNormalizePrefixPhoneNumber(payerModel2.PlaceComponentResult));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClosePayerViewHolder(ViewGroup viewGroup, OnCheckedListener onCheckedListener) {
        super(viewGroup.getContext(), R.layout.item_close_payer, viewGroup);
        this.getAuthRequestContext = viewGroup.getContext();
        this.PlaceComponentResult = onCheckedListener;
    }

    private static boolean PlaceComponentResult(PayerModel payerModel) {
        return TextUtils.isEmpty(payerModel.MyBillsEntityDataFactory) || "splitBillPayer".equals(payerModel.MyBillsEntityDataFactory);
    }
}
