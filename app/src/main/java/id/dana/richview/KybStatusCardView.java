package id.dana.richview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.BaseRichView;

/* loaded from: classes9.dex */
public class KybStatusCardView extends BaseRichView {
    @BindView(R.id.dot)
    ImageView dot;
    @BindView(R.id.ic_image)
    ImageView icKyb;
    @BindView(R.id.kyb_image_arrow)
    ImageView kybImageArrow;
    @BindView(R.id.kyb_status_label)
    TextView labelKybStatus;

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.cardview_kyb_status;
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
    }

    public KybStatusCardView(Context context) {
        super(context);
    }

    public KybStatusCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KybStatusCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // id.dana.base.BaseRichView
    public void parseAttrs(Context context, AttributeSet attributeSet) {
        ButterKnife.BuiltInFictitiousFunctionClassFactory(this, this);
        if (attributeSet != null) {
            int i = 0;
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.SecuritySettingsActivity$createPinLauncher$2$2, 0, 0);
            try {
                InstrumentInjector.Resources_setImageResource(this.icKyb, obtainStyledAttributes.getResourceId(3, R.drawable.ic_kyb));
                this.labelKybStatus.setText(obtainStyledAttributes.getString(4));
                InstrumentInjector.Resources_setImageResource(this.kybImageArrow, obtainStyledAttributes.getResourceId(1, R.drawable.arrow));
                this.kybImageArrow.setRotation(obtainStyledAttributes.getFloat(2, 0.0f));
                ImageView imageView = this.dot;
                if (!obtainStyledAttributes.getBoolean(0, false)) {
                    i = 8;
                }
                imageView.setVisibility(i);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.icKyb.setImageDrawable(drawable);
    }

    public String getKybVerifyStatusText() {
        return this.labelKybStatus.getText().toString();
    }

    public void setKybVerifyStatusText(String str) {
        this.labelKybStatus.setText(str);
    }

    public void setCircleMarkVisibility(boolean z) {
        this.dot.setVisibility(z ? 0 : 8);
    }
}
