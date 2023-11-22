package com.yalantis.ucrop.view.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.model.AspectRatio;
import java.util.Locale;

/* loaded from: classes8.dex */
public class AspectRatioTextView extends TextView {
    private final Rect BuiltInFictitiousFunctionClassFactory;
    private float KClassImpl$Data$declaredNonStaticMembers$2;
    private float MyBillsEntityDataFactory;
    private float PlaceComponentResult;
    private String getAuthRequestContext;
    private int getErrorConfigVersion;
    private Paint lookAheadTest;

    public AspectRatioTextView(Context context) {
        this(context, null);
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.BuiltInFictitiousFunctionClassFactory = new Rect();
        PlaceComponentResult(context.obtainStyledAttributes(attributeSet, R.styleable.E));
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.BuiltInFictitiousFunctionClassFactory = new Rect();
        PlaceComponentResult(context.obtainStyledAttributes(attributeSet, R.styleable.E));
    }

    public void setActiveColor(int i) {
        BuiltInFictitiousFunctionClassFactory(i);
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isSelected()) {
            canvas.getClipBounds(this.BuiltInFictitiousFunctionClassFactory);
            int i = this.BuiltInFictitiousFunctionClassFactory.bottom;
            int i2 = this.getErrorConfigVersion;
            canvas.drawCircle((this.BuiltInFictitiousFunctionClassFactory.right - this.BuiltInFictitiousFunctionClassFactory.left) / 2.0f, i - i2, i2 / 2, this.lookAheadTest);
        }
    }

    private void PlaceComponentResult(TypedArray typedArray) {
        setGravity(1);
        this.getAuthRequestContext = typedArray.getString(R.styleable.getValueOfTouchPositionAbsolute);
        this.MyBillsEntityDataFactory = typedArray.getFloat(R.styleable.VerifyPinStateManager$executeRiskChallenge$2$2, 0.0f);
        float f = typedArray.getFloat(R.styleable.getOnBoardingScenario, 0.0f);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = f;
        float f2 = this.MyBillsEntityDataFactory;
        if (f2 == 0.0f || f == 0.0f) {
            this.PlaceComponentResult = 0.0f;
        } else {
            this.PlaceComponentResult = f2 / f;
        }
        this.getErrorConfigVersion = getContext().getResources().getDimensionPixelSize(R.dimen.res_0x7f0703e3_networkuserentitydata_externalsyntheticlambda0);
        Paint paint = new Paint(1);
        this.lookAheadTest = paint;
        paint.setStyle(Paint.Style.FILL);
        PlaceComponentResult();
        BuiltInFictitiousFunctionClassFactory(getResources().getColor(R.color.initRecordTimeStamp));
        typedArray.recycle();
    }

    private void BuiltInFictitiousFunctionClassFactory(int i) {
        Paint paint = this.lookAheadTest;
        if (paint != null) {
            paint.setColor(i);
        }
        setTextColor(new ColorStateList(new int[][]{new int[]{16842913}, new int[]{0}}, new int[]{i, ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.scheduleImpl_res_0x7f060331)}));
    }

    private void PlaceComponentResult() {
        if (TextUtils.isEmpty(this.getAuthRequestContext)) {
            setText(String.format(Locale.US, "%d:%d", Integer.valueOf((int) this.MyBillsEntityDataFactory), Integer.valueOf((int) this.KClassImpl$Data$declaredNonStaticMembers$2)));
        } else {
            setText(this.getAuthRequestContext);
        }
    }

    public float getAspectRatio(boolean z) {
        if (z) {
            if (this.PlaceComponentResult != 0.0f) {
                float f = this.MyBillsEntityDataFactory;
                float f2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                this.MyBillsEntityDataFactory = f2;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = f;
                this.PlaceComponentResult = f2 / f;
            }
            PlaceComponentResult();
        }
        return this.PlaceComponentResult;
    }

    public void setAspectRatio(AspectRatio aspectRatio) {
        this.getAuthRequestContext = aspectRatio.getAuthRequestContext;
        this.MyBillsEntityDataFactory = aspectRatio.BuiltInFictitiousFunctionClassFactory;
        float f = aspectRatio.KClassImpl$Data$declaredNonStaticMembers$2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = f;
        float f2 = this.MyBillsEntityDataFactory;
        if (f2 == 0.0f || f == 0.0f) {
            this.PlaceComponentResult = 0.0f;
        } else {
            this.PlaceComponentResult = f2 / f;
        }
        PlaceComponentResult();
    }
}
