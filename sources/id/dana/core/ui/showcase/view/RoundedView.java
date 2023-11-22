package id.dana.core.ui.showcase.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.fullstory.instrumentation.FSDispatchDraw;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.core.ui.R;

/* loaded from: classes4.dex */
public class RoundedView extends FrameLayout implements FSDispatchDraw {
    private float BuiltInFictitiousFunctionClassFactory;
    private float KClassImpl$Data$declaredNonStaticMembers$2;
    private float MyBillsEntityDataFactory;
    private float PlaceComponentResult;
    private float getAuthRequestContext;

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        return fsSuperDrawChild_a4a2f45475e56bf57b94ff48239048e0(canvas, view, j);
    }

    public void fsSuperDispatchDraw_a4a2f45475e56bf57b94ff48239048e0(Canvas canvas) {
        if (InstrumentInjector.isRecordingDispatchDraw(this, canvas)) {
            return;
        }
        super.dispatchDraw(canvas);
    }

    public boolean fsSuperDrawChild_a4a2f45475e56bf57b94ff48239048e0(Canvas canvas, View view, long j) {
        if (InstrumentInjector.isRecordingDrawChild(this, canvas, view, j)) {
            return false;
        }
        return super.drawChild(canvas, view, j);
    }

    public RoundedView(Context context) {
        super(context);
        PlaceComponentResult(context, null, 0);
    }

    public RoundedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        PlaceComponentResult(context, attributeSet, 0);
    }

    public RoundedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        PlaceComponentResult(context, attributeSet, i);
    }

    public void setCornerRadius(float f) {
        this.PlaceComponentResult = f;
        invalidate();
    }

    public void setTopLeftCornerRadius(float f) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = f;
        invalidate();
    }

    public void setTopRightCornerRadius(float f) {
        this.BuiltInFictitiousFunctionClassFactory = f;
        invalidate();
    }

    public void setBottomLeftCornerRadius(float f) {
        this.getAuthRequestContext = f;
        invalidate();
    }

    public void setBottomRightCornerRadius(float f) {
        this.MyBillsEntityDataFactory = f;
        invalidate();
    }

    private void PlaceComponentResult(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BannerEntityDataFactory_Factory, i, 0);
        this.PlaceComponentResult = obtainStyledAttributes.getDimension(R.styleable.View$OnClickListener, -1.0f);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getDimension(R.styleable.TrackerKey$GlobalSearchOpenProperties, 0.0f);
        this.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getDimension(R.styleable.InvestmentWalletAdapter, 0.0f);
        this.getAuthRequestContext = obtainStyledAttributes.getDimension(R.styleable.getPhoneMask, 0.0f);
        this.MyBillsEntityDataFactory = obtainStyledAttributes.getDimension(R.styleable.SchedulerPoolFactory, 0.0f);
        obtainStyledAttributes.recycle();
        setLayerType(1, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        float[] fArr;
        int save = canvas.save();
        Path path = new Path();
        float f = this.PlaceComponentResult;
        if (f == -1.0f) {
            float f2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            float f3 = this.BuiltInFictitiousFunctionClassFactory;
            float f4 = this.MyBillsEntityDataFactory;
            float f5 = this.getAuthRequestContext;
            fArr = new float[]{f2, f2, f3, f3, f4, f4, f5, f5};
        } else {
            fArr = new float[]{f, f, f, f, f, f, f, f};
        }
        path.addRoundRect(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), fArr, Path.Direction.CW);
        canvas.clipPath(path);
        fsSuperDispatchDraw_a4a2f45475e56bf57b94ff48239048e0(canvas);
        canvas.restoreToCount(save);
    }
}
