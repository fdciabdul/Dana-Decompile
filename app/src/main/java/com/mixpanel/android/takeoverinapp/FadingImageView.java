package com.mixpanel.android.takeoverinapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.fullstory.instrumentation.FSDraw;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes.dex */
public class FadingImageView extends ImageView implements FSDraw {
    private Shader BuiltInFictitiousFunctionClassFactory;
    private Shader KClassImpl$Data$declaredNonStaticMembers$2;
    private Paint MyBillsEntityDataFactory;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private Paint PlaceComponentResult;
    private Matrix getAuthRequestContext;
    private boolean getErrorConfigVersion;
    private int lookAheadTest;

    public void fsSuperDraw_16fc30b5413226ea7f218c406c8c09b4(Canvas canvas) {
        if (InstrumentInjector.isRecordingDraw(this, canvas)) {
            return;
        }
        super.draw(canvas);
    }

    public FadingImageView(Context context) {
        super(context);
        MyBillsEntityDataFactory();
    }

    public FadingImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        MyBillsEntityDataFactory();
    }

    public FadingImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        MyBillsEntityDataFactory();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.getErrorConfigVersion) {
            this.lookAheadTest = getMeasuredHeight();
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = getMeasuredWidth();
            this.getAuthRequestContext.setScale(1.0f, View.MeasureSpec.getSize(i2));
            this.KClassImpl$Data$declaredNonStaticMembers$2.setLocalMatrix(this.getAuthRequestContext);
            this.BuiltInFictitiousFunctionClassFactory.setLocalMatrix(this.getAuthRequestContext);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int saveLayer;
        if (this.getErrorConfigVersion) {
            Rect clipBounds = canvas.getClipBounds();
            if (Build.VERSION.SDK_INT >= 26) {
                saveLayer = canvas.saveLayer(0.0f, 0.0f, clipBounds.width(), clipBounds.height(), null);
            } else {
                saveLayer = canvas.saveLayer(0.0f, 0.0f, clipBounds.width(), clipBounds.height(), null, 31);
            }
            fsSuperDraw_16fc30b5413226ea7f218c406c8c09b4(canvas);
            canvas.drawRect(0.0f, 0.0f, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.lookAheadTest, this.MyBillsEntityDataFactory);
            canvas.restoreToCount(saveLayer);
            return;
        }
        fsSuperDraw_16fc30b5413226ea7f218c406c8c09b4(canvas);
    }

    private void MyBillsEntityDataFactory() {
        this.getAuthRequestContext = new Matrix();
        this.MyBillsEntityDataFactory = new Paint();
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, new int[]{-16777216, -16777216, -452984832, 0}, new float[]{0.0f, 0.2f, 0.4f, 1.0f}, Shader.TileMode.CLAMP);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = linearGradient;
        this.MyBillsEntityDataFactory.setShader(linearGradient);
        this.MyBillsEntityDataFactory.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.PlaceComponentResult = new Paint();
        LinearGradient linearGradient2 = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, new int[]{0, 0, -16777216, -16777216}, new float[]{0.0f, 0.85f, 0.98f, 1.0f}, Shader.TileMode.CLAMP);
        this.BuiltInFictitiousFunctionClassFactory = linearGradient2;
        this.PlaceComponentResult.setShader(linearGradient2);
        this.MyBillsEntityDataFactory.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public void showShadow(boolean z) {
        this.getErrorConfigVersion = z;
    }
}
