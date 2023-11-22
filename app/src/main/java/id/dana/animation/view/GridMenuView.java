package id.dana.animation.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.databinding.ViewGridMenuBinding;

/* loaded from: classes5.dex */
public class GridMenuView extends ViewBindingRichView<ViewGridMenuBinding> {
    private Drawable KClassImpl$Data$declaredNonStaticMembers$2;
    private String getAuthRequestContext;

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_grid_menu;
    }

    public GridMenuView(Context context) {
        super(context);
    }

    public GridMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GridMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public GridMenuView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public ViewGridMenuBinding initViewBinding(View view) {
        return ViewGridMenuBinding.getAuthRequestContext(view);
    }

    @Override // id.dana.base.BaseRichView
    public void parseAttrs(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.retainOrRemoveAllInternal);
            try {
                this.getAuthRequestContext = obtainStyledAttributes.getString(1);
                this.KClassImpl$Data$declaredNonStaticMembers$2 = ContextCompat.PlaceComponentResult(getContext(), obtainStyledAttributes.getResourceId(0, -1));
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        setTitle(this.getAuthRequestContext);
        setImage(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public void setTitle(String str) {
        getBinding().MyBillsEntityDataFactory.setText(str);
    }

    public void setImage(Drawable drawable) {
        getBinding().BuiltInFictitiousFunctionClassFactory.setImageDrawable(drawable);
    }

    public void setImage(int i) {
        InstrumentInjector.Resources_setImageResource(getBinding().BuiltInFictitiousFunctionClassFactory, i);
    }
}
