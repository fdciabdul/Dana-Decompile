package id.dana.richview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseRichView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes9.dex */
public class RibbonView extends BaseRichView {
    @BindView(R.id.CircularRevealCoordinatorLayout)
    ImageView ivInfo;
    @BindView(R.id.iv_ribbon)
    LinearLayout ivRibbon;
    @BindView(R.id.ll_lineBottom)
    LinearLayout llLineBottom;
    @BindView(R.id.tv_ribbon_lineBottom)
    TextView tvRibbonLineBottom;
    @BindView(R.id.tv_ribbon_lineTop)
    TextView tvRibbonLineTop;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Position {
        public static final int BOTTOM_LEFT = 1;
        public static final int HEADER_RIGHT = 0;
    }

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_ribbon_display;
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
    }

    public RibbonView(Context context) {
        super(context);
    }

    public RibbonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RibbonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public RibbonView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // id.dana.base.BaseRichView
    public void parseAttrs(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            setStyledAttributes(context, attributeSet, R.styleable.KeyEvent$DispatcherState);
            try {
                setRibbonView();
            } finally {
                getStyledAttributes().recycle();
            }
        }
    }

    public void setRibbonPosition(Integer num) {
        if (num.intValue() == 0) {
            this.ivRibbon.setBackgroundResource(R.drawable.img_ribbon_header_right);
        } else if (num.intValue() == 1) {
            this.ivRibbon.setBackgroundResource(R.drawable.img_ribbon_bottom_left);
        }
    }

    public void setRibbonLineTopText(String str) {
        TextView textView = this.tvRibbonLineTop;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setRibbonLineBottomText(String str) {
        TextView textView = this.tvRibbonLineBottom;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setIvInfoVisibility(boolean z) {
        this.ivInfo.setVisibility(z ? 0 : 8);
    }

    public void setSingleLineRibbon(boolean z) {
        LinearLayout linearLayout = this.llLineBottom;
        if (linearLayout != null) {
            linearLayout.setVisibility(z ? 8 : 0);
        }
    }

    public void setTextSizeLineTop(float f) {
        this.tvRibbonLineTop.setTextSize(0, f);
    }

    public void setTextSizeLineBottom(float f) {
        this.tvRibbonLineBottom.setTextSize(0, f);
    }

    public void setIvInfoSize(int i) {
        this.ivInfo.getLayoutParams().height = i;
        this.ivInfo.getLayoutParams().width = i;
        this.ivInfo.requestLayout();
    }

    public void setRibbonView() {
        Integer valueOf = Integer.valueOf(getStyledAttributes().getInt(3, 0));
        if (valueOf.intValue() == 0) {
            this.ivRibbon.setBackgroundResource(R.drawable.img_ribbon_header_right);
        } else if (valueOf.intValue() == 1) {
            this.ivRibbon.setBackgroundResource(R.drawable.img_ribbon_bottom_left);
        }
        setSingleLineRibbon(getStyledAttributes().getBoolean(2, false));
        setIvInfoVisibility(getStyledAttributes().getBoolean(1, false));
        setRibbonLineTopText(getStyledAttributes().getString(5));
        TextView textView = this.tvRibbonLineBottom;
        if (textView != null) {
            textView.setText(getStyledAttributes().getString(4));
        }
        setTextSizeLineTop(getStyledAttributes().getDimensionPixelSize(7, (int) this.tvRibbonLineTop.getTextSize()));
        setTextSizeLineBottom(getStyledAttributes().getDimensionPixelSize(6, (int) this.tvRibbonLineBottom.getTextSize()));
        setIvInfoSize(getStyledAttributes().getDimensionPixelSize(0, this.ivInfo.getHeight()));
    }
}
