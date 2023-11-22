package com.cyberfend.cyfsecurity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes3.dex */
public class CircleProgressBar extends View {
    private static final String MyBillsEntityDataFactory = "CircleProgressBar";
    private float BuiltInFictitiousFunctionClassFactory;
    private int DatabaseTableConfigUtil;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private RectF NetworkUserEntityData$$ExternalSyntheticLambda0;
    private float PlaceComponentResult;

    /* renamed from: a  reason: collision with root package name */
    Handler f7423a;
    private float getAuthRequestContext;
    private int getErrorConfigVersion;
    private Runnable initRecordTimeStamp;
    private int lookAheadTest;
    private Paint moveToNextValue;
    private Paint scheduleImpl;

    static /* synthetic */ int b(CircleProgressBar circleProgressBar) {
        int i = circleProgressBar.DatabaseTableConfigUtil;
        circleProgressBar.DatabaseTableConfigUtil = i + 1;
        return i;
    }

    static /* synthetic */ float c(CircleProgressBar circleProgressBar) {
        float f = circleProgressBar.BuiltInFictitiousFunctionClassFactory;
        circleProgressBar.BuiltInFictitiousFunctionClassFactory = 1.0f + f;
        return f;
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.PlaceComponentResult = 20.0f;
        this.getAuthRequestContext = 20.0f;
        this.BuiltInFictitiousFunctionClassFactory = 0.0f;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 100;
        this.lookAheadTest = 0;
        this.getErrorConfigVersion = 270;
        this.DatabaseTableConfigUtil = 0;
        this.f7423a = new Handler();
        this.initRecordTimeStamp = new Runnable() { // from class: com.cyberfend.cyfsecurity.CircleProgressBar.1
            @Override // java.lang.Runnable
            public final void run() {
                String unused = CircleProgressBar.MyBillsEntityDataFactory;
                if (CircleProgressBar.this.DatabaseTableConfigUtil < 9) {
                    String unused2 = CircleProgressBar.MyBillsEntityDataFactory;
                    CircleProgressBar.b(CircleProgressBar.this);
                    CircleProgressBar.c(CircleProgressBar.this);
                    CircleProgressBar.this.postInvalidate();
                    CircleProgressBar.this.f7423a.postDelayed(CircleProgressBar.this.initRecordTimeStamp, 100L);
                    return;
                }
                String unused3 = CircleProgressBar.MyBillsEntityDataFactory;
            }
        };
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new RectF();
        Paint paint = new Paint(1);
        this.moveToNextValue = paint;
        paint.setColor(context.getResources().getColor(R.color.PlaceComponentResult_res_0x7f060025));
        this.moveToNextValue.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.scheduleImpl = paint2;
        paint2.setColor(context.getResources().getColor(R.color.getAuthRequestContext_res_0x7f060026));
        this.scheduleImpl.setStyle(Paint.Style.FILL);
        this.f7423a.postDelayed(this.initRecordTimeStamp, 100L);
    }

    public void setProgressBarColor(int i) {
        this.scheduleImpl.setColor(i);
        this.moveToNextValue.setColor(Color.argb(Math.round(Color.alpha(i) * 0.25f), Color.red(i), Color.green(i), Color.blue(i)));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int min = Math.min(getDefaultSize(getSuggestedMinimumWidth(), i), getDefaultSize(getSuggestedMinimumHeight(), i2));
        setMeasuredDimension(min, min);
        RectF rectF = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        float f = this.getAuthRequestContext / 2.0f;
        float f2 = 0.0f + f;
        float f3 = min - f;
        rectF.set(f2, f2, f3, f3);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawOval(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.moveToNextValue);
        canvas.drawArc(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.getErrorConfigVersion, (this.BuiltInFictitiousFunctionClassFactory * 360.0f) / this.KClassImpl$Data$declaredNonStaticMembers$2, true, this.scheduleImpl);
    }

    public void setProgress(float f) {
        synchronized (this) {
            this.BuiltInFictitiousFunctionClassFactory = f * this.KClassImpl$Data$declaredNonStaticMembers$2;
            this.DatabaseTableConfigUtil = 0;
            this.f7423a.postDelayed(this.initRecordTimeStamp, 100L);
            postInvalidate();
        }
    }
}
