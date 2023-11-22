package id.dana.richview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatImageView;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.core.ui.databinding.ViewDanaLogoProgressBinding;

/* loaded from: classes2.dex */
public class LogoProgressView extends ViewBindingRichView<ViewDanaLogoProgressBinding> {
    private int BuiltInFictitiousFunctionClassFactory;
    private Animation KClassImpl$Data$declaredNonStaticMembers$2;
    private int PlaceComponentResult;

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.res_0x7f0d04f1_networkuserentitydata_externalsyntheticlambda0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public ViewDanaLogoProgressBinding initViewBinding(View view) {
        return ViewDanaLogoProgressBinding.BuiltInFictitiousFunctionClassFactory(view);
    }

    public LogoProgressView(Context context) {
        super(context);
    }

    public LogoProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LogoProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public LogoProgressView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // id.dana.base.BaseRichView
    public void parseAttrs(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ArrayTable$3);
            try {
                float dimension = obtainStyledAttributes.getDimension(1, 0.0f);
                float dimension2 = obtainStyledAttributes.getDimension(0, 0.0f);
                this.PlaceComponentResult = Math.round(dimension);
                this.BuiltInFictitiousFunctionClassFactory = Math.round(dimension2);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        if (this.PlaceComponentResult > 0) {
            AppCompatImageView appCompatImageView = getBinding().MyBillsEntityDataFactory;
            int i = this.PlaceComponentResult;
            ViewGroup.LayoutParams layoutParams = appCompatImageView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = i;
                layoutParams.height = i;
            }
        }
        if (this.BuiltInFictitiousFunctionClassFactory > 0) {
            AppCompatImageView appCompatImageView2 = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
            int i2 = this.BuiltInFictitiousFunctionClassFactory;
            ViewGroup.LayoutParams layoutParams2 = appCompatImageView2.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = i2;
                layoutParams2.height = i2;
            }
        }
    }

    public void startRefresh() {
        onAttachedToWindow();
        stopRefresh();
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.res_0x7f010050_kclassimpl_data_declarednonstaticmembers_2);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = loadAnimation;
        loadAnimation.setInterpolator(new LinearInterpolator());
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.startAnimation(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public void stopRefresh() {
        Animation animation = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (animation != null) {
            animation.cancel();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        }
    }
}
