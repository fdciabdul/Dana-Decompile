package id.dana.richview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.BaseRichView;

/* loaded from: classes9.dex */
public class TransactionBubbleView extends BaseRichView {
    private OnMoreButtonCLickListener PlaceComponentResult;
    @BindView(R.id.button_more)
    TextView buttonMore;
    @BindView(R.id.iv_icon)
    ImageView ivIcon;
    @BindView(R.id.f4356res_0x7f0a1618_snapshotcontroller_1)
    TextView tvAmount;
    @BindView(R.id.tv_message)
    TextView tvMessage;

    /* loaded from: classes9.dex */
    public interface OnMoreButtonCLickListener {
    }

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_transaction_baloon;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.button_more})
    public void onMoreButtonClicked() {
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
    }

    public TransactionBubbleView(Context context) {
        super(context);
    }

    public TransactionBubbleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TransactionBubbleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public TransactionBubbleView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void setMessage(int i) {
        this.tvMessage.setText(getContext().getResources().getString(i));
    }

    public void setIcon(int i) {
        this.ivIcon.setImageDrawable(InstrumentInjector.Resources_getDrawable(getContext().getResources(), i));
    }

    public void setAmount(String str) {
        this.tvAmount.setText(str);
    }

    public void setAmountViewVisibility(int i) {
        if (i == 1) {
            this.tvAmount.setVisibility(0);
        } else {
            this.tvAmount.setVisibility(4);
        }
    }

    public void setMoreButtonVisibility(int i) {
        if (i == 1) {
            this.buttonMore.setVisibility(0);
        } else {
            this.buttonMore.setVisibility(4);
        }
    }

    public void setOnMoreButton(OnMoreButtonCLickListener onMoreButtonCLickListener) {
        this.PlaceComponentResult = onMoreButtonCLickListener;
    }
}
