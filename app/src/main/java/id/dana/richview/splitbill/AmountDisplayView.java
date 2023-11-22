package id.dana.richview.splitbill;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.richview.CurrencyTextView;

/* loaded from: classes5.dex */
public class AmountDisplayView extends BaseRichView {
    private SetOnAmountClickListener MyBillsEntityDataFactory;
    @BindView(R.id.btn_change)
    Button btnChange;
    @BindView(R.id.ctv_amount)
    CurrencyTextView ctvAmount;
    @BindView(R.id.tv_remaining_amount)
    TextView tvRemainingAmount;

    /* loaded from: classes5.dex */
    public interface SetOnAmountClickListener {
        void PlaceComponentResult();
    }

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_amount_display;
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
    }

    public AmountDisplayView(Context context) {
        super(context);
    }

    public AmountDisplayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AmountDisplayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // id.dana.base.BaseRichView
    public void setSingleClick() {
        setOnClickListener(getSingleItemClickListener());
        this.btnChange.setOnClickListener(getSingleItemClickListener());
    }

    @Override // id.dana.base.BaseRichView
    public void onSingleClick(View view) {
        this.MyBillsEntityDataFactory.PlaceComponentResult();
    }

    public String getAmount() {
        return this.ctvAmount.getAmount();
    }

    public void setAmountText(String str) {
        this.ctvAmount.setText(str);
    }

    public void setAmountRemain(boolean z) {
        setAmountRemain(z, null);
    }

    public void setAmountRemain(boolean z, String str) {
        this.tvRemainingAmount.setVisibility(z ? 0 : 8);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.tvRemainingAmount.setText(str);
    }

    public boolean isAnyAmountRemain() {
        return this.tvRemainingAmount.getVisibility() == 0 && this.tvRemainingAmount.getText().toString().contains(getContext().getString(R.string.split_bill_zero_amount_message));
    }

    public void setOnAmountClickListener(SetOnAmountClickListener setOnAmountClickListener) {
        this.MyBillsEntityDataFactory = setOnAmountClickListener;
    }
}
