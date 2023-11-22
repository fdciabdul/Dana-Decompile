package com.alibaba.griver.ui.tabbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.alibaba.ariver.kernel.common.utils.DimensionUtil;
import com.alibaba.griver.ui.R;

/* loaded from: classes6.dex */
public class DotView extends View {

    /* renamed from: a  reason: collision with root package name */
    private static final int f6758a = Color.parseColor("#FD3737");
    private Paint b;
    private int c;
    private int d;
    private Context e;

    public DotView(Context context) {
        this(context, null);
    }

    public DotView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DotView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.griverDotView);
        this.e = context;
        this.c = obtainStyledAttributes.getColor(R.styleable.griverDotView_griverDotColor, f6758a);
        Paint paint = new Paint(1);
        this.b = paint;
        paint.setColor(this.c);
        this.d = 0;
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, getDotRadius(), this.b);
    }

    public void setDotColor(int i) {
        if (i != 0) {
            this.b.setColor(i | (-16777216));
            invalidate();
        }
    }

    private int getDotRadius() {
        int i = this.d;
        if (i > 0 && i < getWidth()) {
            return this.d / 2;
        }
        return getWidth() / 2;
    }

    public void setDotWidth(int i) {
        this.d = DimensionUtil.dip2px(this.e, i);
        invalidate();
    }
}
