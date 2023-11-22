package id.dana.component.dividercomponent;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import id.dana.component.BaseRichView;
import id.dana.component.R;
import id.dana.component.utils.SizeUtil;

/* loaded from: classes4.dex */
public class DanaDividerView extends BaseRichView {
    private int BuiltInFictitiousFunctionClassFactory;
    private String KClassImpl$Data$declaredNonStaticMembers$2;
    ConstraintLayout containerView;
    TextView title;

    public DanaDividerView(Context context) {
        super(context);
    }

    public DanaDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DanaDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public DanaDividerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // id.dana.component.BaseRichView
    public int getLayout() {
        return R.layout.view_dana_divider_layout;
    }

    @Override // id.dana.component.BaseRichView
    public void parseAttrs(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.access$throwIllegalArgumentType, 0, 0);
            try {
                this.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getInt(R.styleable.f8039o, 0);
                this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getString(R.styleable.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    @Override // id.dana.component.BaseRichView
    public void setup() {
        this.containerView = (ConstraintLayout) getRootView().findViewById(R.id.cl_container_divider_view);
        this.title = (TextView) getRootView().findViewById(R.id.L);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, SizeUtil.PlaceComponentResult(1));
        switch (this.BuiltInFictitiousFunctionClassFactory) {
            case 0:
                this.containerView.setLayoutParams(new FrameLayout.LayoutParams(-1, SizeUtil.PlaceComponentResult(4)));
                return;
            case 1:
                this.containerView.setLayoutParams(new FrameLayout.LayoutParams(-1, SizeUtil.PlaceComponentResult(8)));
                return;
            case 2:
                this.containerView.setLayoutParams(new FrameLayout.LayoutParams(-1, SizeUtil.PlaceComponentResult(12)));
                return;
            case 3:
                this.containerView.setLayoutParams(new FrameLayout.LayoutParams(-1, SizeUtil.PlaceComponentResult(16)));
                return;
            case 4:
                this.containerView.setLayoutParams(layoutParams);
                return;
            case 5:
                layoutParams.setMargins(SizeUtil.PlaceComponentResult(16), 0, 0, 0);
                this.containerView.setLayoutParams(layoutParams);
                return;
            case 6:
                layoutParams.setMargins(0, 0, SizeUtil.PlaceComponentResult(16), 0);
                this.containerView.setLayoutParams(layoutParams);
                return;
            case 7:
                layoutParams.setMargins(SizeUtil.PlaceComponentResult(16), 0, SizeUtil.PlaceComponentResult(16), 0);
                this.containerView.setLayoutParams(layoutParams);
                return;
            case 8:
                this.containerView.setLayoutParams(new FrameLayout.LayoutParams(-1, SizeUtil.PlaceComponentResult(22)));
                this.title.setVisibility(0);
                this.title.setText(this.KClassImpl$Data$declaredNonStaticMembers$2);
                return;
            default:
                return;
        }
    }
}
