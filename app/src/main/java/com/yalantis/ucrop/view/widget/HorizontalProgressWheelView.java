package com.yalantis.ucrop.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.yalantis.ucrop.R;

/* loaded from: classes8.dex */
public class HorizontalProgressWheelView extends View {
    private int BuiltInFictitiousFunctionClassFactory;
    private final Rect KClassImpl$Data$declaredNonStaticMembers$2;
    private float MyBillsEntityDataFactory;
    private float NetworkUserEntityData$$ExternalSyntheticLambda0;
    private int PlaceComponentResult;
    private int getAuthRequestContext;
    private int getErrorConfigVersion;
    private boolean lookAheadTest;
    private Paint moveToNextValue;
    private ScrollingListener scheduleImpl;

    /* loaded from: classes8.dex */
    public interface ScrollingListener {
        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(float f);
    }

    public HorizontalProgressWheelView(Context context) {
        this(context, null);
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new Rect();
        this.PlaceComponentResult = ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.res_0x7f06032d_networkuserentitydata_externalsyntheticlambda0);
        this.getErrorConfigVersion = getContext().getResources().getDimensionPixelSize(R.dimen.getErrorConfigVersion);
        this.BuiltInFictitiousFunctionClassFactory = getContext().getResources().getDimensionPixelSize(R.dimen.lookAheadTest);
        this.getAuthRequestContext = getContext().getResources().getDimensionPixelSize(R.dimen.moveToNextValue);
        Paint paint = new Paint(1);
        this.moveToNextValue = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.moveToNextValue.setStrokeWidth(this.getErrorConfigVersion);
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new Rect();
    }

    public void setScrollingListener(ScrollingListener scrollingListener) {
        this.scheduleImpl = scrollingListener;
    }

    public void setMiddleLineColor(int i) {
        this.PlaceComponentResult = i;
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.MyBillsEntityDataFactory = motionEvent.getX();
        } else if (action == 1) {
            ScrollingListener scrollingListener = this.scheduleImpl;
            if (scrollingListener != null) {
                this.lookAheadTest = false;
                scrollingListener.MyBillsEntityDataFactory();
            }
        } else if (action == 2) {
            float x = motionEvent.getX() - this.MyBillsEntityDataFactory;
            if (x != 0.0f) {
                if (!this.lookAheadTest) {
                    this.lookAheadTest = true;
                    ScrollingListener scrollingListener2 = this.scheduleImpl;
                    if (scrollingListener2 != null) {
                        scrollingListener2.KClassImpl$Data$declaredNonStaticMembers$2();
                    }
                }
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 -= x;
                postInvalidate();
                this.MyBillsEntityDataFactory = motionEvent.getX();
                ScrollingListener scrollingListener3 = this.scheduleImpl;
                if (scrollingListener3 != null) {
                    scrollingListener3.MyBillsEntityDataFactory(-x);
                }
            }
        }
        return true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.KClassImpl$Data$declaredNonStaticMembers$2);
        int width = this.KClassImpl$Data$declaredNonStaticMembers$2.width();
        int i = this.getErrorConfigVersion + this.getAuthRequestContext;
        int i2 = width / i;
        float f = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        float f2 = i;
        this.moveToNextValue.setColor(getResources().getColor(R.color.res_0x7f06032d_networkuserentitydata_externalsyntheticlambda0));
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i2 / 4;
            if (i3 < i4) {
                this.moveToNextValue.setAlpha((int) ((i3 / i4) * 255.0f));
            } else if (i3 > (i2 * 3) / 4) {
                this.moveToNextValue.setAlpha((int) (((i2 - i3) / i4) * 255.0f));
            } else {
                this.moveToNextValue.setAlpha(255);
            }
            float f3 = -(f % f2);
            float f4 = this.KClassImpl$Data$declaredNonStaticMembers$2.left;
            float f5 = this.KClassImpl$Data$declaredNonStaticMembers$2.left;
            canvas.drawLine(f4 + f3 + ((this.getErrorConfigVersion + this.getAuthRequestContext) * i3), this.KClassImpl$Data$declaredNonStaticMembers$2.centerY() - (this.BuiltInFictitiousFunctionClassFactory / 4.0f), f3 + f5 + ((this.getErrorConfigVersion + this.getAuthRequestContext) * i3), this.KClassImpl$Data$declaredNonStaticMembers$2.centerY() + (this.BuiltInFictitiousFunctionClassFactory / 4.0f), this.moveToNextValue);
        }
        this.moveToNextValue.setColor(this.PlaceComponentResult);
        canvas.drawLine(this.KClassImpl$Data$declaredNonStaticMembers$2.centerX(), this.KClassImpl$Data$declaredNonStaticMembers$2.centerY() - (this.BuiltInFictitiousFunctionClassFactory / 2.0f), this.KClassImpl$Data$declaredNonStaticMembers$2.centerX(), this.KClassImpl$Data$declaredNonStaticMembers$2.centerY() + (this.BuiltInFictitiousFunctionClassFactory / 2.0f), this.moveToNextValue);
    }
}
