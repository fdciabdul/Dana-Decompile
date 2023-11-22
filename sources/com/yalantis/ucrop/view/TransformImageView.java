package com.yalantis.ucrop.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.fullstory.instrumentation.InstrumentInjector;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import com.yalantis.ucrop.util.FastBitmapDrawable;
import com.yalantis.ucrop.util.RectUtils;

/* loaded from: classes8.dex */
public class TransformImageView extends ImageView {
    private float[] BuiltInFictitiousFunctionClassFactory;
    private String KClassImpl$Data$declaredNonStaticMembers$2;
    private ExifInfo MyBillsEntityDataFactory;
    private final float[] NetworkUserEntityData$$ExternalSyntheticLambda0;
    private float[] PlaceComponentResult;
    private String getAuthRequestContext;
    private int lookAheadTest;
    protected boolean mBitmapDecoded;
    protected boolean mBitmapLaidOut;
    protected final float[] mCurrentImageCenter;
    protected final float[] mCurrentImageCorners;
    protected Matrix mCurrentImageMatrix;
    protected int mThisHeight;
    protected int mThisWidth;
    protected TransformImageListener mTransformImageListener;

    /* loaded from: classes8.dex */
    public interface TransformImageListener {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(float f);

        void BuiltInFictitiousFunctionClassFactory(Exception exc);

        void MyBillsEntityDataFactory(float f);
    }

    public TransformImageView(Context context) {
        this(context, null);
    }

    public TransformImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TransformImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentImageCorners = new float[8];
        this.mCurrentImageCenter = new float[2];
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new float[9];
        this.mCurrentImageMatrix = new Matrix();
        this.mBitmapDecoded = false;
        this.mBitmapLaidOut = false;
        this.lookAheadTest = 0;
        init();
    }

    public void setTransformImageListener(TransformImageListener transformImageListener) {
        this.mTransformImageListener = transformImageListener;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == ImageView.ScaleType.MATRIX) {
            super.setScaleType(scaleType);
        } else {
            InstrumentInjector.log_w("TransformImageView", "Invalid ScaleType. Only ScaleType.MATRIX can be used");
        }
    }

    public void setMaxBitmapSize(int i) {
        this.lookAheadTest = i;
    }

    public int getMaxBitmapSize() {
        if (this.lookAheadTest <= 0) {
            this.lookAheadTest = BitmapLoadUtils.KClassImpl$Data$declaredNonStaticMembers$2(getContext());
        }
        return this.lookAheadTest;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        setImageDrawable(new FastBitmapDrawable(bitmap));
    }

    public String getImageInputPath() {
        return this.getAuthRequestContext;
    }

    public String getImageOutputPath() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public ExifInfo getExifInfo() {
        return this.MyBillsEntityDataFactory;
    }

    public void setImageUri(Uri uri, Uri uri2) throws Exception {
        int maxBitmapSize = getMaxBitmapSize();
        BitmapLoadUtils.PlaceComponentResult(getContext(), uri, uri2, maxBitmapSize, maxBitmapSize, new BitmapLoadCallback() { // from class: com.yalantis.ucrop.view.TransformImageView.1
            @Override // com.yalantis.ucrop.callback.BitmapLoadCallback
            public final void BuiltInFictitiousFunctionClassFactory(Bitmap bitmap, ExifInfo exifInfo, String str, String str2) {
                TransformImageView.this.getAuthRequestContext = str;
                TransformImageView.this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
                TransformImageView.this.MyBillsEntityDataFactory = exifInfo;
                TransformImageView.this.mBitmapDecoded = true;
                TransformImageView.this.setImageBitmap(bitmap);
            }

            @Override // com.yalantis.ucrop.callback.BitmapLoadCallback
            public final void getAuthRequestContext(Exception exc) {
                InstrumentInjector.log_e("TransformImageView", "onFailure: setImageUri", exc);
                if (TransformImageView.this.mTransformImageListener != null) {
                    TransformImageView.this.mTransformImageListener.BuiltInFictitiousFunctionClassFactory(exc);
                }
            }
        });
    }

    public float getCurrentScale() {
        return getMatrixScale(this.mCurrentImageMatrix);
    }

    public float getMatrixScale(Matrix matrix) {
        return (float) Math.sqrt(Math.pow(getMatrixValue(matrix, 0), 2.0d) + Math.pow(getMatrixValue(matrix, 3), 2.0d));
    }

    public float getCurrentAngle() {
        return getMatrixAngle(this.mCurrentImageMatrix);
    }

    public float getMatrixAngle(Matrix matrix) {
        return (float) (-(Math.atan2(getMatrixValue(matrix, 1), getMatrixValue(matrix, 0)) * 57.29577951308232d));
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        super.setImageMatrix(matrix);
        this.mCurrentImageMatrix.set(matrix);
        this.mCurrentImageMatrix.mapPoints(this.mCurrentImageCorners, this.PlaceComponentResult);
        this.mCurrentImageMatrix.mapPoints(this.mCurrentImageCenter, this.BuiltInFictitiousFunctionClassFactory);
    }

    public Bitmap getViewBitmap() {
        if (getDrawable() == null || !(getDrawable() instanceof FastBitmapDrawable)) {
            return null;
        }
        return ((FastBitmapDrawable) getDrawable()).MyBillsEntityDataFactory;
    }

    public void postTranslate(float f, float f2) {
        if (f == 0.0f && f2 == 0.0f) {
            return;
        }
        this.mCurrentImageMatrix.postTranslate(f, f2);
        setImageMatrix(this.mCurrentImageMatrix);
    }

    public void postScale(float f, float f2, float f3) {
        if (f != 0.0f) {
            this.mCurrentImageMatrix.postScale(f, f, f2, f3);
            setImageMatrix(this.mCurrentImageMatrix);
            TransformImageListener transformImageListener = this.mTransformImageListener;
            if (transformImageListener != null) {
                transformImageListener.BuiltInFictitiousFunctionClassFactory(getMatrixScale(this.mCurrentImageMatrix));
            }
        }
    }

    public void postRotate(float f, float f2, float f3) {
        if (f != 0.0f) {
            this.mCurrentImageMatrix.postRotate(f, f2, f3);
            setImageMatrix(this.mCurrentImageMatrix);
            TransformImageListener transformImageListener = this.mTransformImageListener;
            if (transformImageListener != null) {
                transformImageListener.MyBillsEntityDataFactory(getMatrixAngle(this.mCurrentImageMatrix));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z || (this.mBitmapDecoded && !this.mBitmapLaidOut)) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth();
            int paddingRight = getPaddingRight();
            int height = getHeight();
            int paddingBottom = getPaddingBottom();
            this.mThisWidth = (width - paddingRight) - paddingLeft;
            this.mThisHeight = (height - paddingBottom) - paddingTop;
            onImageLaidOut();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onImageLaidOut() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        InstrumentInjector.log_d("TransformImageView", String.format("Image size: [%d:%d]", Integer.valueOf((int) intrinsicWidth), Integer.valueOf((int) intrinsicHeight)));
        RectF rectF = new RectF(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
        this.PlaceComponentResult = RectUtils.BuiltInFictitiousFunctionClassFactory(rectF);
        this.BuiltInFictitiousFunctionClassFactory = RectUtils.KClassImpl$Data$declaredNonStaticMembers$2(rectF);
        this.mBitmapLaidOut = true;
        TransformImageListener transformImageListener = this.mTransformImageListener;
        if (transformImageListener != null) {
            transformImageListener.BuiltInFictitiousFunctionClassFactory();
        }
    }

    protected float getMatrixValue(Matrix matrix, int i) {
        matrix.getValues(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0[i];
    }

    protected void printMatrix(String str, Matrix matrix) {
        float matrixValue = getMatrixValue(matrix, 2);
        float matrixValue2 = getMatrixValue(matrix, 5);
        float matrixScale = getMatrixScale(matrix);
        float matrixAngle = getMatrixAngle(matrix);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(": matrix: { x: ");
        sb.append(matrixValue);
        sb.append(", y: ");
        sb.append(matrixValue2);
        sb.append(", scale: ");
        sb.append(matrixScale);
        sb.append(", angle: ");
        sb.append(matrixAngle);
        sb.append(" }");
        InstrumentInjector.log_d("TransformImageView", sb.toString());
    }
}
