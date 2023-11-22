package id.dana.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public abstract class BaseRichView extends FrameLayout {
    private View view;

    public abstract int getLayout();

    protected void onInjectedView(View view) {
    }

    protected void parseAttrs(Context context, AttributeSet attributeSet) {
    }

    public abstract void setup();

    public BaseRichView(Context context) {
        super(context);
        init(context, null);
    }

    public BaseRichView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public BaseRichView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    public BaseRichView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context, attributeSet);
    }

    protected void init(Context context, AttributeSet attributeSet) {
        parseAttrs(context, attributeSet);
        View inflate = View.inflate(context, getLayout(), this);
        this.view = inflate;
        onInjectedView(inflate);
        setup();
    }
}
