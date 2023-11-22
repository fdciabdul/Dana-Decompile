package id.dana.splitbill.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.ImageAttacherFactory;
import id.dana.data.util.NumberUtils;
import id.dana.model.CurrencyAmountModel;
import id.dana.richview.CurrencyTextView;
import id.dana.splitbill.model.PayerModel;

/* loaded from: classes5.dex */
public class PayerListViewHolder extends BaseRecyclerViewHolder<PayerModel> {
    private Context BuiltInFictitiousFunctionClassFactory;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    @BindView(R.id.civ_payer_avatar)
    CircleImageView civPayerAvatar;
    @BindView(R.id.cl_payer_container)
    ConstraintLayout clPayerContainer;
    @BindView(R.id.ctv_fund_amount)
    CurrencyTextView ctvFundAmount;
    @BindView(R.id.f3954iv_status)
    ImageView ivStatus;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone_number)
    TextView tvPhoneNumber;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(PayerModel payerModel) {
        MyBillsEntityDataFactory(payerModel, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PayerListViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_split_bill_recipient, viewGroup);
        this.BuiltInFictitiousFunctionClassFactory = viewGroup.getContext();
    }

    public final void MyBillsEntityDataFactory(PayerModel payerModel, boolean z) {
        if (payerModel != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
            KClassImpl$Data$declaredNonStaticMembers$2(payerModel.getAuthRequestContext());
            new ImageAttacherFactory().KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, this.civPayerAvatar, payerModel.KClassImpl$Data$declaredNonStaticMembers$2, R.drawable.ic_avatar_grey_default);
            MyBillsEntityDataFactory(payerModel);
            this.tvPhoneNumber.setText(NumberUtils.getNormalizePrefixPhoneNumber(payerModel.PlaceComponentResult));
            CurrencyAmountModel currencyAmountModel = payerModel.BuiltInFictitiousFunctionClassFactory;
            this.ctvFundAmount.setText(TextUtils.isEmpty(currencyAmountModel.MyBillsEntityDataFactory) ? "0" : currencyAmountModel.MyBillsEntityDataFactory);
            getAuthRequestContext(payerModel.lookAheadTest);
        }
    }

    private void getAuthRequestContext(String str) {
        if (TextUtils.isEmpty(str) || !this.KClassImpl$Data$declaredNonStaticMembers$2) {
            this.ivStatus.setVisibility(8);
            return;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1149187101:
                if (str.equals("SUCCESS")) {
                    c = 0;
                    break;
                }
                break;
            case -604548089:
                if (str.equals("IN_PROGRESS")) {
                    c = 1;
                    break;
                }
                break;
            case -591252731:
                if (str.equals("EXPIRED")) {
                    c = 2;
                    break;
                }
                break;
            case 1818119806:
                if (str.equals("REVOKED")) {
                    c = 3;
                    break;
                }
                break;
        }
        if (c == 0) {
            this.ivStatus.setImageDrawable(ContextCompat.PlaceComponentResult(getContext(), (int) R.drawable.success));
            this.ivStatus.setVisibility(0);
        } else if (c == 1) {
            this.ivStatus.setImageDrawable(ContextCompat.PlaceComponentResult(getContext(), (int) R.drawable.pending));
            this.ivStatus.setVisibility(0);
            this.ivStatus.setContentDescription(getContext().getString(R.string.imgNotPaid));
        } else if (c == 2) {
            this.ivStatus.setImageDrawable(ContextCompat.PlaceComponentResult(getContext(), (int) R.drawable.res_0x7f08065e_networkuserentitydata_externalsyntheticlambda1));
            this.ivStatus.setVisibility(0);
        } else if (c != 3) {
            this.ivStatus.setVisibility(4);
        } else {
            this.ivStatus.setImageDrawable(ContextCompat.PlaceComponentResult(getContext(), (int) R.drawable.revoked));
            this.ivStatus.setVisibility(0);
            this.ivStatus.setContentDescription(getContext().getString(R.string.imgPaid));
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        this.clPayerContainer.setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, z ? R.color.f26582131100339 : R.color.f27072131100488));
    }

    private void MyBillsEntityDataFactory(PayerModel payerModel) {
        this.tvName.setText(PlaceComponentResult(payerModel) ? this.BuiltInFictitiousFunctionClassFactory.getString(R.string.payer) : payerModel.MyBillsEntityDataFactory);
    }

    private static boolean PlaceComponentResult(PayerModel payerModel) {
        return TextUtils.isEmpty(payerModel.MyBillsEntityDataFactory) || "splitBillPayer".equals(payerModel.MyBillsEntityDataFactory);
    }
}
