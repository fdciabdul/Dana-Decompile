package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.callback.CropBoundsChangeListener;
import com.yalantis.ucrop.model.CropParameters;
import com.yalantis.ucrop.model.ImageState;
import com.yalantis.ucrop.task.BitmapCropTask;
import com.yalantis.ucrop.util.CubicEasing;
import com.yalantis.ucrop.util.RectUtils;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* loaded from: classes8.dex */
public class CropImageView extends TransformImageView {
    public static final float DEFAULT_ASPECT_RATIO = 0.0f;
    public static final int DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION = 500;
    public static final int DEFAULT_MAX_BITMAP_SIZE = 0;
    public static final float DEFAULT_MAX_SCALE_MULTIPLIER = 10.0f;
    public static final float SOURCE_IMAGE_ASPECT_RATIO = 0.0f;
    private long BuiltInFictitiousFunctionClassFactory;
    private Runnable DatabaseTableConfigUtil;
    private CropBoundsChangeListener KClassImpl$Data$declaredNonStaticMembers$2;
    private final RectF MyBillsEntityDataFactory;
    private float NetworkUserEntityData$$ExternalSyntheticLambda0;
    private int PlaceComponentResult;
    private int getAuthRequestContext;
    private float getErrorConfigVersion;
    private Runnable initRecordTimeStamp;
    private float lookAheadTest;
    private float moveToNextValue;
    private final Matrix scheduleImpl;

    public CropImageView(Context context) {
        this(context, null);
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.MyBillsEntityDataFactory = new RectF();
        this.scheduleImpl = new Matrix();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 10.0f;
        this.initRecordTimeStamp = null;
        this.PlaceComponentResult = 0;
        this.getAuthRequestContext = 0;
        this.BuiltInFictitiousFunctionClassFactory = 500L;
    }

    public void cropAndSaveImage(Bitmap.CompressFormat compressFormat, int i, BitmapCropCallback bitmapCropCallback) {
        cancelAllAnimations();
        setImageToWrapCropBounds(false);
        new BitmapCropTask(getContext(), getViewBitmap(), new ImageState(this.MyBillsEntityDataFactory, RectUtils.BuiltInFictitiousFunctionClassFactory(this.mCurrentImageCorners), getCurrentScale(), getCurrentAngle()), new CropParameters(this.PlaceComponentResult, this.getAuthRequestContext, compressFormat, i, getImageInputPath(), getImageOutputPath(), getExifInfo()), bitmapCropCallback).execute(new Void[0]);
    }

    public float getMaxScale() {
        return this.lookAheadTest;
    }

    public float getMinScale() {
        return this.getErrorConfigVersion;
    }

    public float getTargetAspectRatio() {
        return this.moveToNextValue;
    }

    public void setCropRect(RectF rectF) {
        this.moveToNextValue = rectF.width() / rectF.height();
        this.MyBillsEntityDataFactory.set(rectF.left - getPaddingLeft(), rectF.top - getPaddingTop(), rectF.right - getPaddingRight(), rectF.bottom - getPaddingBottom());
        if (getDrawable() != null) {
            getAuthRequestContext(r9.getIntrinsicWidth(), r9.getIntrinsicHeight());
        }
        setImageToWrapCropBounds();
    }

    public void setTargetAspectRatio(float f) {
        if (getDrawable() == null) {
            this.moveToNextValue = f;
            return;
        }
        if (f == 0.0f) {
            this.moveToNextValue = r0.getIntrinsicWidth() / r0.getIntrinsicHeight();
        } else {
            this.moveToNextValue = f;
        }
        CropBoundsChangeListener cropBoundsChangeListener = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (cropBoundsChangeListener != null) {
            cropBoundsChangeListener.PlaceComponentResult(this.moveToNextValue);
        }
    }

    public CropBoundsChangeListener getCropBoundsChangeListener() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public void setCropBoundsChangeListener(CropBoundsChangeListener cropBoundsChangeListener) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = cropBoundsChangeListener;
    }

    public void setMaxResultImageSizeX(int i) {
        this.PlaceComponentResult = i;
    }

    public void setMaxResultImageSizeY(int i) {
        this.getAuthRequestContext = i;
    }

    public void setImageToWrapCropBoundsAnimDuration(long j) {
        if (j > 0) {
            this.BuiltInFictitiousFunctionClassFactory = j;
            return;
        }
        throw new IllegalArgumentException("Animation duration cannot be negative value.");
    }

    public void setMaxScaleMultiplier(float f) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = f;
    }

    public void zoomOutImage(float f) {
        zoomOutImage(f, this.MyBillsEntityDataFactory.centerX(), this.MyBillsEntityDataFactory.centerY());
    }

    public void zoomOutImage(float f, float f2, float f3) {
        if (f >= getMinScale()) {
            postScale(f / getCurrentScale(), f2, f3);
        }
    }

    public void zoomInImage(float f) {
        zoomInImage(f, this.MyBillsEntityDataFactory.centerX(), this.MyBillsEntityDataFactory.centerY());
    }

    public void zoomInImage(float f, float f2, float f3) {
        if (f <= getMaxScale()) {
            postScale(f / getCurrentScale(), f2, f3);
        }
    }

    @Override // com.yalantis.ucrop.view.TransformImageView
    public void postScale(float f, float f2, float f3) {
        if (f > 1.0f && getCurrentScale() * f <= getMaxScale()) {
            super.postScale(f, f2, f3);
        } else if (f >= 1.0f || getCurrentScale() * f < getMinScale()) {
        } else {
            super.postScale(f, f2, f3);
        }
    }

    public void postRotate(float f) {
        postRotate(f, this.MyBillsEntityDataFactory.centerX(), this.MyBillsEntityDataFactory.centerY());
    }

    public void cancelAllAnimations() {
        removeCallbacks(this.DatabaseTableConfigUtil);
        removeCallbacks(this.initRecordTimeStamp);
    }

    public void setImageToWrapCropBounds() {
        setImageToWrapCropBounds(true);
    }

    public void setImageToWrapCropBounds(boolean z) {
        float f;
        float max;
        float f2;
        if (!this.mBitmapLaidOut || isImageWrapCropBounds()) {
            return;
        }
        float f3 = this.mCurrentImageCenter[0];
        float f4 = this.mCurrentImageCenter[1];
        float currentScale = getCurrentScale();
        float centerX = this.MyBillsEntityDataFactory.centerX() - f3;
        float centerY = this.MyBillsEntityDataFactory.centerY() - f4;
        this.scheduleImpl.reset();
        this.scheduleImpl.setTranslate(centerX, centerY);
        float[] copyOf = Arrays.copyOf(this.mCurrentImageCorners, this.mCurrentImageCorners.length);
        this.scheduleImpl.mapPoints(copyOf);
        boolean isImageWrapCropBounds = isImageWrapCropBounds(copyOf);
        if (!isImageWrapCropBounds) {
            RectF rectF = new RectF(this.MyBillsEntityDataFactory);
            this.scheduleImpl.reset();
            this.scheduleImpl.setRotate(getCurrentAngle());
            this.scheduleImpl.mapRect(rectF);
            float[] PlaceComponentResult = RectUtils.PlaceComponentResult(this.mCurrentImageCorners);
            f = centerX;
            max = (Math.max(rectF.width() / PlaceComponentResult[0], rectF.height() / PlaceComponentResult[1]) * currentScale) - currentScale;
            f2 = centerY;
        } else {
            this.scheduleImpl.reset();
            this.scheduleImpl.setRotate(-getCurrentAngle());
            float[] copyOf2 = Arrays.copyOf(this.mCurrentImageCorners, this.mCurrentImageCorners.length);
            float[] BuiltInFictitiousFunctionClassFactory = RectUtils.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory);
            this.scheduleImpl.mapPoints(copyOf2);
            this.scheduleImpl.mapPoints(BuiltInFictitiousFunctionClassFactory);
            RectF BuiltInFictitiousFunctionClassFactory2 = RectUtils.BuiltInFictitiousFunctionClassFactory(copyOf2);
            RectF BuiltInFictitiousFunctionClassFactory3 = RectUtils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory);
            float f5 = BuiltInFictitiousFunctionClassFactory2.left - BuiltInFictitiousFunctionClassFactory3.left;
            float f6 = BuiltInFictitiousFunctionClassFactory2.top - BuiltInFictitiousFunctionClassFactory3.top;
            float f7 = BuiltInFictitiousFunctionClassFactory2.right - BuiltInFictitiousFunctionClassFactory3.right;
            float f8 = BuiltInFictitiousFunctionClassFactory2.bottom - BuiltInFictitiousFunctionClassFactory3.bottom;
            float[] fArr = new float[4];
            if (f5 <= 0.0f) {
                f5 = 0.0f;
            }
            fArr[0] = f5;
            if (f6 <= 0.0f) {
                f6 = 0.0f;
            }
            fArr[1] = f6;
            if (f7 >= 0.0f) {
                f7 = 0.0f;
            }
            fArr[2] = f7;
            if (f8 >= 0.0f) {
                f8 = 0.0f;
            }
            fArr[3] = f8;
            this.scheduleImpl.reset();
            this.scheduleImpl.setRotate(getCurrentAngle());
            this.scheduleImpl.mapPoints(fArr);
            f = -(fArr[0] + fArr[2]);
            f2 = -(fArr[1] + fArr[3]);
            max = 0.0f;
        }
        if (z) {
            WrapCropBoundsRunnable wrapCropBoundsRunnable = new WrapCropBoundsRunnable(this, this.BuiltInFictitiousFunctionClassFactory, f3, f4, f, f2, currentScale, max, isImageWrapCropBounds);
            this.DatabaseTableConfigUtil = wrapCropBoundsRunnable;
            post(wrapCropBoundsRunnable);
            return;
        }
        postTranslate(f, f2);
        if (isImageWrapCropBounds) {
            return;
        }
        zoomInImage(currentScale + max, this.MyBillsEntityDataFactory.centerX(), this.MyBillsEntityDataFactory.centerY());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yalantis.ucrop.view.TransformImageView
    public void onImageLaidOut() {
        super.onImageLaidOut();
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        if (this.moveToNextValue == 0.0f) {
            this.moveToNextValue = intrinsicWidth / intrinsicHeight;
        }
        int i = (int) (this.mThisWidth / this.moveToNextValue);
        if (i > this.mThisHeight) {
            this.MyBillsEntityDataFactory.set((this.mThisWidth - ((int) (this.mThisHeight * this.moveToNextValue))) / 2, 0.0f, r2 + r4, this.mThisHeight);
        } else {
            this.MyBillsEntityDataFactory.set(0.0f, (this.mThisHeight - i) / 2, this.mThisWidth, i + r4);
        }
        getAuthRequestContext(intrinsicWidth, intrinsicHeight);
        float width = this.MyBillsEntityDataFactory.width();
        float height = this.MyBillsEntityDataFactory.height();
        float max = Math.max(this.MyBillsEntityDataFactory.width() / intrinsicWidth, this.MyBillsEntityDataFactory.height() / intrinsicHeight);
        float f = this.MyBillsEntityDataFactory.left;
        float f2 = (height - (intrinsicHeight * max)) / 2.0f;
        float f3 = this.MyBillsEntityDataFactory.top;
        this.mCurrentImageMatrix.reset();
        this.mCurrentImageMatrix.postScale(max, max);
        this.mCurrentImageMatrix.postTranslate(((width - (intrinsicWidth * max)) / 2.0f) + f, f2 + f3);
        setImageMatrix(this.mCurrentImageMatrix);
        CropBoundsChangeListener cropBoundsChangeListener = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (cropBoundsChangeListener != null) {
            cropBoundsChangeListener.PlaceComponentResult(this.moveToNextValue);
        }
        if (this.mTransformImageListener != null) {
            this.mTransformImageListener.BuiltInFictitiousFunctionClassFactory(getCurrentScale());
            this.mTransformImageListener.MyBillsEntityDataFactory(getCurrentAngle());
        }
    }

    protected boolean isImageWrapCropBounds() {
        return isImageWrapCropBounds(this.mCurrentImageCorners);
    }

    protected boolean isImageWrapCropBounds(float[] fArr) {
        this.scheduleImpl.reset();
        this.scheduleImpl.setRotate(-getCurrentAngle());
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        this.scheduleImpl.mapPoints(copyOf);
        float[] BuiltInFictitiousFunctionClassFactory = RectUtils.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory);
        this.scheduleImpl.mapPoints(BuiltInFictitiousFunctionClassFactory);
        return RectUtils.BuiltInFictitiousFunctionClassFactory(copyOf).contains(RectUtils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zoomImageToPosition(float f, float f2, float f3, long j) {
        if (f > getMaxScale()) {
            f = getMaxScale();
        }
        float currentScale = getCurrentScale();
        ZoomImageToPosition zoomImageToPosition = new ZoomImageToPosition(this, j, currentScale, f - currentScale, f2, f3);
        this.initRecordTimeStamp = zoomImageToPosition;
        post(zoomImageToPosition);
    }

    private void getAuthRequestContext(float f, float f2) {
        float min = Math.min(Math.min(this.MyBillsEntityDataFactory.width() / f, this.MyBillsEntityDataFactory.width() / f2), Math.min(this.MyBillsEntityDataFactory.height() / f2, this.MyBillsEntityDataFactory.height() / f));
        this.getErrorConfigVersion = min;
        this.lookAheadTest = min * this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void processStyledAttributes(TypedArray typedArray) {
        float abs = Math.abs(typedArray.getFloat(R.styleable.H, 0.0f));
        float abs2 = Math.abs(typedArray.getFloat(R.styleable.I, 0.0f));
        if (abs == 0.0f || abs2 == 0.0f) {
            this.moveToNextValue = 0.0f;
        } else {
            this.moveToNextValue = abs / abs2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class WrapCropBoundsRunnable implements Runnable {
        private final WeakReference<CropImageView> BuiltInFictitiousFunctionClassFactory;
        private final long KClassImpl$Data$declaredNonStaticMembers$2;
        private final float MyBillsEntityDataFactory;
        private final float NetworkUserEntityData$$ExternalSyntheticLambda0;
        private final float PlaceComponentResult;
        private final float getAuthRequestContext;
        private final float getErrorConfigVersion;
        private final float lookAheadTest;
        private final boolean moveToNextValue;
        private final long scheduleImpl = System.currentTimeMillis();

        public WrapCropBoundsRunnable(CropImageView cropImageView, long j, float f, float f2, float f3, float f4, float f5, float f6, boolean z) {
            this.BuiltInFictitiousFunctionClassFactory = new WeakReference<>(cropImageView);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
            this.getErrorConfigVersion = f;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = f2;
            this.MyBillsEntityDataFactory = f3;
            this.PlaceComponentResult = f4;
            this.lookAheadTest = f5;
            this.getAuthRequestContext = f6;
            this.moveToNextValue = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            CropImageView cropImageView = this.BuiltInFictitiousFunctionClassFactory.get();
            if (cropImageView == null) {
                return;
            }
            float min = (float) Math.min(this.KClassImpl$Data$declaredNonStaticMembers$2, System.currentTimeMillis() - this.scheduleImpl);
            float authRequestContext = CubicEasing.getAuthRequestContext(min, this.MyBillsEntityDataFactory, (float) this.KClassImpl$Data$declaredNonStaticMembers$2);
            float authRequestContext2 = CubicEasing.getAuthRequestContext(min, this.PlaceComponentResult, (float) this.KClassImpl$Data$declaredNonStaticMembers$2);
            float MyBillsEntityDataFactory = CubicEasing.MyBillsEntityDataFactory(min, this.getAuthRequestContext, (float) this.KClassImpl$Data$declaredNonStaticMembers$2);
            if (min < ((float) this.KClassImpl$Data$declaredNonStaticMembers$2)) {
                cropImageView.postTranslate(authRequestContext - (cropImageView.mCurrentImageCenter[0] - this.getErrorConfigVersion), authRequestContext2 - (cropImageView.mCurrentImageCenter[1] - this.NetworkUserEntityData$$ExternalSyntheticLambda0));
                if (!this.moveToNextValue) {
                    cropImageView.zoomInImage(this.lookAheadTest + MyBillsEntityDataFactory, cropImageView.MyBillsEntityDataFactory.centerX(), cropImageView.MyBillsEntityDataFactory.centerY());
                }
                if (cropImageView.isImageWrapCropBounds()) {
                    return;
                }
                cropImageView.post(this);
            }
        }
    }

    /* loaded from: classes8.dex */
    static class ZoomImageToPosition implements Runnable {
        private final WeakReference<CropImageView> BuiltInFictitiousFunctionClassFactory;
        private final float KClassImpl$Data$declaredNonStaticMembers$2;
        private final long MyBillsEntityDataFactory;
        private final float NetworkUserEntityData$$ExternalSyntheticLambda0;
        private final float PlaceComponentResult;
        private final float getAuthRequestContext;
        private final long scheduleImpl = System.currentTimeMillis();

        public ZoomImageToPosition(CropImageView cropImageView, long j, float f, float f2, float f3, float f4) {
            this.BuiltInFictitiousFunctionClassFactory = new WeakReference<>(cropImageView);
            this.MyBillsEntityDataFactory = j;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = f;
            this.getAuthRequestContext = f2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = f3;
            this.PlaceComponentResult = f4;
        }

        @Override // java.lang.Runnable
        public void run() {
            CropImageView cropImageView = this.BuiltInFictitiousFunctionClassFactory.get();
            if (cropImageView == null) {
                return;
            }
            float min = (float) Math.min(this.MyBillsEntityDataFactory, System.currentTimeMillis() - this.scheduleImpl);
            float MyBillsEntityDataFactory = CubicEasing.MyBillsEntityDataFactory(min, this.getAuthRequestContext, (float) this.MyBillsEntityDataFactory);
            if (min < ((float) this.MyBillsEntityDataFactory)) {
                cropImageView.zoomInImage(this.NetworkUserEntityData$$ExternalSyntheticLambda0 + MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult);
                cropImageView.post(this);
                return;
            }
            cropImageView.setImageToWrapCropBounds();
        }
    }
}
