package com.mixpanel.android.takeoverinapp;

import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;

/* loaded from: classes8.dex */
public class MiniCircleImageView extends ImageView {
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private Paint MyBillsEntityDataFactory;
    private int PlaceComponentResult;

    public MiniCircleImageView(Context context) {
        super(context);
        getAuthRequestContext();
    }

    public MiniCircleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        getAuthRequestContext();
    }

    public MiniCircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        getAuthRequestContext();
    }

    private void getAuthRequestContext() {
        this.MyBillsEntityDataFactory = new Paint(1);
        if (Build.VERSION.SDK_INT >= 23) {
            this.MyBillsEntityDataFactory.setColor(getResources().getColor(17170443, null));
        } else {
            this.MyBillsEntityDataFactory.setColor(getResources().getColor(17170443));
        }
        this.MyBillsEntityDataFactory.setStyle(Paint.Style.STROKE);
        this.MyBillsEntityDataFactory.setStrokeWidth(TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics()));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.PlaceComponentResult = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
    }
}
