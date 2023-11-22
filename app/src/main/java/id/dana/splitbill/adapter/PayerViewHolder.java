package id.dana.splitbill.adapter;

import android.content.Context;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.richview.CurrencyEditText;
import id.dana.data.util.NumberUtils;
import id.dana.richview.CircleImageSelectionView;
import id.dana.splitbill.adapter.PayerViewHolder;
import id.dana.splitbill.model.SplitBillPayerModel;
import id.dana.utils.LocaleUtil;
import id.dana.utils.NumberFormatterUtil;

/* loaded from: classes5.dex */
public class PayerViewHolder extends BaseRecyclerViewHolder<SplitBillPayerModel> {
    private long MyBillsEntityDataFactory;
    @BindView(R.id.cisv_avatar)
    CircleImageSelectionView cisvAvatar;
    @BindView(R.id.f3751res_0x7f0a068e_abstractmapbasedmultimap_asmap)
    CurrencyEditText etAmount;
    OnModifyPayerListener getAuthRequestContext;
    @BindView(R.id.tv_payer_name)
    TextView tvPayerName;
    @BindView(R.id.tv_phone_number)
    TextView tvPhoneNumber;
    @BindView(R.id.tv_requester_excluded_amount)
    TextView tvRequesterExcludeAmount;

    /* loaded from: classes5.dex */
    public interface OnModifyPayerListener {
        void BuiltInFictitiousFunctionClassFactory(int i);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void getAuthRequestContext(long j, int i);
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(SplitBillPayerModel splitBillPayerModel) {
        String str;
        String str2;
        final SplitBillPayerModel splitBillPayerModel2 = splitBillPayerModel;
        if (splitBillPayerModel2 != null) {
            this.cisvAvatar.loadImage(splitBillPayerModel2.MyBillsEntityDataFactory, R.drawable.ic_avatar_grey_default);
            this.cisvAvatar.setPaddingPhoto(4);
            this.cisvAvatar.useRemoveIcon(true);
            if (splitBillPayerModel2.KClassImpl$Data$declaredNonStaticMembers$2()) {
                this.cisvAvatar.setActionIcon(splitBillPayerModel2.MyBillsEntityDataFactory() ? R.drawable.ic_add_green : R.drawable.ic_minus_red);
            } else {
                this.cisvAvatar.setActionIcon(R.drawable.cancel);
            }
            this.cisvAvatar.setListener(new CircleImageSelectionView.Listener() { // from class: id.dana.splitbill.adapter.PayerViewHolder$$ExternalSyntheticLambda3
                @Override // id.dana.richview.CircleImageSelectionView.Listener
                public final void MyBillsEntityDataFactory() {
                    PayerViewHolder payerViewHolder = PayerViewHolder.this;
                    SplitBillPayerModel splitBillPayerModel3 = splitBillPayerModel2;
                    PayerViewHolder.OnModifyPayerListener onModifyPayerListener = payerViewHolder.getAuthRequestContext;
                    if (onModifyPayerListener != null) {
                        onModifyPayerListener.BuiltInFictitiousFunctionClassFactory(splitBillPayerModel3.KClassImpl$Data$declaredNonStaticMembers$2() ? 0 : payerViewHolder.getAdapterPosition());
                    }
                }
            });
            this.tvPhoneNumber.setText(NumberUtils.getNormalizePrefixPhoneNumber(splitBillPayerModel2.scheduleImpl));
            TextView textView = this.tvPhoneNumber;
            boolean MyBillsEntityDataFactory = splitBillPayerModel2.MyBillsEntityDataFactory();
            Context context = getContext();
            int i = R.color.f27042131100474;
            textView.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(context, MyBillsEntityDataFactory ? R.color.f27042131100474 : R.color.BuiltInFictitiousFunctionClassFactory_res_0x7f06005d));
            if (splitBillPayerModel2.KClassImpl$Data$declaredNonStaticMembers$2()) {
                this.tvPayerName.setText(getContext().getString(R.string.lookAheadTest));
            } else {
                TextView textView2 = this.tvPayerName;
                if (splitBillPayerModel2.NetworkUserEntityData$$ExternalSyntheticLambda0.equals("-")) {
                    str = splitBillPayerModel2.moveToNextValue;
                } else {
                    str = splitBillPayerModel2.NetworkUserEntityData$$ExternalSyntheticLambda0;
                }
                if ("splitBillPayer".equals(str)) {
                    str2 = getContext().getString(R.string.payer);
                } else if (splitBillPayerModel2.NetworkUserEntityData$$ExternalSyntheticLambda0.equals("-")) {
                    str2 = splitBillPayerModel2.moveToNextValue;
                } else {
                    str2 = splitBillPayerModel2.NetworkUserEntityData$$ExternalSyntheticLambda0;
                }
                textView2.setText(str2);
            }
            TextView textView3 = this.tvPayerName;
            boolean MyBillsEntityDataFactory2 = splitBillPayerModel2.MyBillsEntityDataFactory();
            Context context2 = getContext();
            if (!MyBillsEntityDataFactory2) {
                i = R.color.BuiltInFictitiousFunctionClassFactory_res_0x7f06005d;
            }
            textView3.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(context2, i));
            if (splitBillPayerModel2.KClassImpl$Data$declaredNonStaticMembers$2()) {
                this.tvRequesterExcludeAmount.setVisibility(splitBillPayerModel2.MyBillsEntityDataFactory() ? 0 : 8);
                this.etAmount.setVisibility(splitBillPayerModel2.MyBillsEntityDataFactory() ? 8 : 0);
            } else {
                this.etAmount.setVisibility(0);
            }
            if (this.etAmount.getVisibility() == 0) {
                this.etAmount.setText(splitBillPayerModel2.getAuthRequestContext == null ? "Rp0" : splitBillPayerModel2.getAuthRequestContext.getAuthRequestContext());
                this.etAmount.setLocked(splitBillPayerModel2.PlaceComponentResult());
                this.etAmount.setVisibility(0);
                this.etAmount.setFilters(new InputFilter[]{new InputFilter.LengthFilter(NumberFormatterUtil.BuiltInFictitiousFunctionClassFactory(LocaleUtil.getAuthRequestContext(), this.MyBillsEntityDataFactory, "Rp").length())});
                this.etAmount.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: id.dana.splitbill.adapter.PayerViewHolder$$ExternalSyntheticLambda0
                    @Override // android.widget.TextView.OnEditorActionListener
                    public final boolean onEditorAction(TextView textView4, int i2, KeyEvent keyEvent) {
                        return PayerViewHolder.this.MyBillsEntityDataFactory(i2);
                    }
                });
                this.etAmount.setListener(new CurrencyEditText.Listener() { // from class: id.dana.splitbill.adapter.PayerViewHolder$$ExternalSyntheticLambda1
                    @Override // id.dana.core.ui.richview.CurrencyEditText.Listener
                    public final void PlaceComponentResult() {
                        PayerViewHolder payerViewHolder = PayerViewHolder.this;
                        if (payerViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(splitBillPayerModel2)) {
                            payerViewHolder.KClassImpl$Data$declaredNonStaticMembers$2();
                        }
                    }
                });
                this.etAmount.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: id.dana.splitbill.adapter.PayerViewHolder$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnFocusChangeListener
                    public final void onFocusChange(View view, boolean z) {
                        PayerViewHolder payerViewHolder = PayerViewHolder.this;
                        SplitBillPayerModel splitBillPayerModel3 = splitBillPayerModel2;
                        if (z || !payerViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(splitBillPayerModel3)) {
                            return;
                        }
                        payerViewHolder.KClassImpl$Data$declaredNonStaticMembers$2();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PayerViewHolder(ViewGroup viewGroup, OnModifyPayerListener onModifyPayerListener, long j) {
        super(viewGroup.getContext(), R.layout.item_split_bill_payer, viewGroup);
        this.getAuthRequestContext = onModifyPayerListener;
        this.MyBillsEntityDataFactory = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
    public boolean MyBillsEntityDataFactory(int i) {
        if (6 == i) {
            KClassImpl$Data$declaredNonStaticMembers$2();
            this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.etAmount.setLocked(true);
        this.etAmount.clearFocus();
        OnModifyPayerListener onModifyPayerListener = this.getAuthRequestContext;
        if (onModifyPayerListener != null) {
            onModifyPayerListener.getAuthRequestContext(Long.valueOf(this.etAmount.getAmount()).longValue(), getAdapterPosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(SplitBillPayerModel splitBillPayerModel) {
        return (splitBillPayerModel == null || splitBillPayerModel.getAuthRequestContext == null || splitBillPayerModel.getAuthRequestContext.MyBillsEntityDataFactory.equals(this.etAmount.getAmount())) ? false : true;
    }
}
