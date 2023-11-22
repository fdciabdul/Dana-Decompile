package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.constraintlayout.widget.R;
import com.fullstory.instrumentation.FSDraw;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes6.dex */
public class ImageFilterView extends AppCompatImageView implements FSDraw {
    private float BuiltInFictitiousFunctionClassFactory;
    private Drawable KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    private Drawable getAuthRequestContext;
    private ImageMatrix getErrorConfigVersion;
    private Path lookAheadTest;
    LayerDrawable mLayer;
    Drawable[] mLayers;
    float mPanX;
    float mPanY;
    RectF mRect;
    float mRotate;
    ViewOutlineProvider mViewOutlineProvider;
    float mZoom;
    private float moveToNextValue;
    private float scheduleImpl;
    public static final byte[] PlaceComponentResult = {88, 72, 91, 85, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int MyBillsEntityDataFactory = 51;

    public static Drawable __fsTypeCheck_4b4d9d1bdba79bb02f8b35e64692ffb0(LayerDrawable layerDrawable, int i) {
        Object[] objArr = new Object[1];
        a(objArr);
        return Class.forName((String) objArr[0]).isInstance(layerDrawable) ? InstrumentInjector.Resources_getDrawable((Context) layerDrawable, i) : layerDrawable.getDrawable(i);
    }

    public static Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(TypedArray typedArray, int i) {
        Object[] objArr = new Object[1];
        a(objArr);
        return Class.forName((String) objArr[0]).isInstance(typedArray) ? InstrumentInjector.Resources_getDrawable((Context) typedArray, i) : typedArray.getDrawable(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x002a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(java.lang.Object[] r9) {
        /*
            byte[] r0 = androidx.constraintlayout.utils.widget.ImageFilterView.PlaceComponentResult
            r1 = 23
            byte[] r1 = new byte[r1]
            r2 = 22
            r3 = 97
            r4 = 0
            r5 = 4
            if (r0 != 0) goto L13
            r5 = 22
            r6 = 4
            r7 = 0
            goto L2a
        L13:
            r6 = 0
        L14:
            byte r7 = (byte) r3
            r1[r6] = r7
            if (r6 != r2) goto L21
            java.lang.String r0 = new java.lang.String
            r0.<init>(r1, r4)
            r9[r4] = r0
            return
        L21:
            int r6 = r6 + 1
            r7 = r0[r5]
            r8 = r5
            r5 = r3
            r3 = r7
            r7 = r6
            r6 = r8
        L2a:
            int r3 = -r3
            int r6 = r6 + 1
            int r5 = r5 + r3
            int r3 = r5 + (-8)
            r5 = r6
            r6 = r7
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.utils.widget.ImageFilterView.a(java.lang.Object[]):void");
    }

    public void fsSuperDraw_53e124331d9bcd4bb99d438aa0407cdc(Canvas canvas) {
        if (InstrumentInjector.isRecordingDraw(this, canvas)) {
            return;
        }
        super.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class ImageMatrix {
        float[] getAuthRequestContext = new float[20];
        ColorMatrix MyBillsEntityDataFactory = new ColorMatrix();
        ColorMatrix scheduleImpl = new ColorMatrix();
        float KClassImpl$Data$declaredNonStaticMembers$2 = 1.0f;
        float BuiltInFictitiousFunctionClassFactory = 1.0f;
        float PlaceComponentResult = 1.0f;
        float moveToNextValue = 1.0f;

        private void BuiltInFictitiousFunctionClassFactory(float f) {
            float f2 = 1.0f - f;
            float f3 = 0.2999f * f2;
            float f4 = 0.587f * f2;
            float f5 = f2 * 0.114f;
            float[] fArr = this.getAuthRequestContext;
            fArr[0] = f3 + f;
            fArr[1] = f4;
            fArr[2] = f5;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = f3;
            fArr[6] = f4 + f;
            fArr[7] = f5;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = f3;
            fArr[11] = f4;
            fArr[12] = f5 + f;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void PlaceComponentResult(float f) {
            float log;
            float f2;
            float f3;
            if (f <= 0.0f) {
                f = 0.01f;
            }
            float f4 = (5000.0f / f) / 100.0f;
            if (f4 > 66.0f) {
                double d = f4 - 60.0f;
                f2 = ((float) Math.pow(d, -0.13320475816726685d)) * 329.69873f;
                log = ((float) Math.pow(d, 0.07551484555006027d)) * 288.12216f;
            } else {
                log = (((float) Math.log(f4)) * 99.4708f) - 161.11957f;
                f2 = 255.0f;
            }
            if (f4 < 66.0f) {
                f3 = f4 > 19.0f ? (((float) Math.log(f4 - 10.0f)) * 138.51773f) - 305.0448f : 0.0f;
            } else {
                f3 = 255.0f;
            }
            float min = Math.min(255.0f, Math.max(f2, 0.0f));
            float min2 = Math.min(255.0f, Math.max(log, 0.0f));
            float min3 = Math.min(255.0f, Math.max(f3, 0.0f));
            float log2 = (float) Math.log(50.0d);
            float log3 = (float) Math.log(40.0d);
            float min4 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float min5 = min2 / Math.min(255.0f, Math.max((log2 * 99.4708f) - 161.11957f, 0.0f));
            float min6 = min3 / Math.min(255.0f, Math.max((log3 * 138.51773f) - 305.0448f, 0.0f));
            float[] fArr = this.getAuthRequestContext;
            fArr[0] = min / min4;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = min5;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = min6;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void getAuthRequestContext(float f) {
            float[] fArr = this.getAuthRequestContext;
            fArr[0] = f;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = f;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = f;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void KClassImpl$Data$declaredNonStaticMembers$2(ImageView imageView) {
            boolean z;
            this.MyBillsEntityDataFactory.reset();
            float f = this.BuiltInFictitiousFunctionClassFactory;
            boolean z2 = true;
            if (f != 1.0f) {
                BuiltInFictitiousFunctionClassFactory(f);
                this.MyBillsEntityDataFactory.set(this.getAuthRequestContext);
                z = true;
            } else {
                z = false;
            }
            float f2 = this.PlaceComponentResult;
            if (f2 != 1.0f) {
                this.scheduleImpl.setScale(f2, f2, f2, 1.0f);
                this.MyBillsEntityDataFactory.postConcat(this.scheduleImpl);
                z = true;
            }
            float f3 = this.moveToNextValue;
            if (f3 != 1.0f) {
                PlaceComponentResult(f3);
                this.scheduleImpl.set(this.getAuthRequestContext);
                this.MyBillsEntityDataFactory.postConcat(this.scheduleImpl);
                z = true;
            }
            float f4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (f4 != 1.0f) {
                getAuthRequestContext(f4);
                this.scheduleImpl.set(this.getAuthRequestContext);
                this.MyBillsEntityDataFactory.postConcat(this.scheduleImpl);
            } else {
                z2 = z;
            }
            if (z2) {
                imageView.setColorFilter(new ColorMatrixColorFilter(this.MyBillsEntityDataFactory));
            } else {
                imageView.clearColorFilter();
            }
        }
    }

    public float getImagePanX() {
        return this.mPanX;
    }

    public float getImagePanY() {
        return this.mPanY;
    }

    public float getImageZoom() {
        return this.mZoom;
    }

    public float getImageRotate() {
        return this.mRotate;
    }

    public void setImagePanX(float f) {
        this.mPanX = f;
        BuiltInFictitiousFunctionClassFactory();
    }

    public void setImagePanY(float f) {
        this.mPanY = f;
        BuiltInFictitiousFunctionClassFactory();
    }

    public void setImageZoom(float f) {
        this.mZoom = f;
        BuiltInFictitiousFunctionClassFactory();
    }

    public void setImageRotate(float f) {
        this.mRotate = f;
        BuiltInFictitiousFunctionClassFactory();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null && drawable != null) {
            Drawable mutate = drawable.mutate();
            this.getAuthRequestContext = mutate;
            Drawable[] drawableArr = this.mLayers;
            drawableArr[0] = mutate;
            drawableArr[1] = this.KClassImpl$Data$declaredNonStaticMembers$2;
            LayerDrawable layerDrawable = new LayerDrawable(this.mLayers);
            this.mLayer = layerDrawable;
            super.setImageDrawable(layerDrawable);
            setCrossfade(this.BuiltInFictitiousFunctionClassFactory);
            return;
        }
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        Drawable BuiltInFictitiousFunctionClassFactory;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            BuiltInFictitiousFunctionClassFactory = ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(getContext(), i);
            Drawable mutate = BuiltInFictitiousFunctionClassFactory.mutate();
            this.getAuthRequestContext = mutate;
            Drawable[] drawableArr = this.mLayers;
            drawableArr[0] = mutate;
            drawableArr[1] = this.KClassImpl$Data$declaredNonStaticMembers$2;
            LayerDrawable layerDrawable = new LayerDrawable(this.mLayers);
            this.mLayer = layerDrawable;
            super.setImageDrawable(layerDrawable);
            setCrossfade(this.BuiltInFictitiousFunctionClassFactory);
            return;
        }
        super.setImageResource(i);
    }

    public void setAltImageResource(int i) {
        Drawable BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory = ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(getContext(), i);
        Drawable mutate = BuiltInFictitiousFunctionClassFactory.mutate();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = mutate;
        Drawable[] drawableArr = this.mLayers;
        drawableArr[0] = this.getAuthRequestContext;
        drawableArr[1] = mutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.mLayers);
        this.mLayer = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.BuiltInFictitiousFunctionClassFactory);
    }

    private void BuiltInFictitiousFunctionClassFactory() {
        if (Float.isNaN(this.mPanX) && Float.isNaN(this.mPanY) && Float.isNaN(this.mZoom) && Float.isNaN(this.mRotate)) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            MyBillsEntityDataFactory();
        }
    }

    private void MyBillsEntityDataFactory() {
        if (Float.isNaN(this.mPanX) && Float.isNaN(this.mPanY) && Float.isNaN(this.mZoom) && Float.isNaN(this.mRotate)) {
            return;
        }
        float f = Float.isNaN(this.mPanX) ? 0.0f : this.mPanX;
        float f2 = Float.isNaN(this.mPanY) ? 0.0f : this.mPanY;
        float f3 = Float.isNaN(this.mZoom) ? 1.0f : this.mZoom;
        float f4 = Float.isNaN(this.mRotate) ? 0.0f : this.mRotate;
        Matrix matrix = new Matrix();
        matrix.reset();
        float intrinsicWidth = getDrawable().getIntrinsicWidth();
        float intrinsicHeight = getDrawable().getIntrinsicHeight();
        float width = getWidth();
        float height = getHeight();
        float f5 = f3 * (intrinsicWidth * height < intrinsicHeight * width ? width / intrinsicWidth : height / intrinsicHeight);
        matrix.postScale(f5, f5);
        float f6 = intrinsicWidth * f5;
        float f7 = f5 * intrinsicHeight;
        matrix.postTranslate((((f * (width - f6)) + width) - f6) * 0.5f, (((f2 * (height - f7)) + height) - f7) * 0.5f);
        matrix.postRotate(f4, width / 2.0f, height / 2.0f);
        setImageMatrix(matrix);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public ImageFilterView(Context context) {
        super(context);
        this.getErrorConfigVersion = new ImageMatrix();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.getAuthRequestContext = null;
        this.BuiltInFictitiousFunctionClassFactory = 0.0f;
        this.moveToNextValue = 0.0f;
        this.scheduleImpl = Float.NaN;
        this.mLayers = new Drawable[2];
        this.mPanX = Float.NaN;
        this.mPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        KClassImpl$Data$declaredNonStaticMembers$2(null);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.getErrorConfigVersion = new ImageMatrix();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.getAuthRequestContext = null;
        this.BuiltInFictitiousFunctionClassFactory = 0.0f;
        this.moveToNextValue = 0.0f;
        this.scheduleImpl = Float.NaN;
        this.mLayers = new Drawable[2];
        this.mPanX = Float.NaN;
        this.mPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        KClassImpl$Data$declaredNonStaticMembers$2(attributeSet);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.getErrorConfigVersion = new ImageMatrix();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.getAuthRequestContext = null;
        this.BuiltInFictitiousFunctionClassFactory = 0.0f;
        this.moveToNextValue = 0.0f;
        this.scheduleImpl = Float.NaN;
        this.mLayers = new Drawable[2];
        this.mPanX = Float.NaN;
        this.mPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        KClassImpl$Data$declaredNonStaticMembers$2(attributeSet);
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.setLastTelemetrySync);
            int indexCount = obtainStyledAttributes.getIndexCount();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, R.styleable.getBackgroundScanPeriod);
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.calcCaptureRect) {
                    this.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R.styleable.DaggerKycAmlEddActivityComponent$KycAmlEddActivityComponentImpl$KycAmlEddRepositoryProvider) {
                    setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.GetFriendsFeedWithInitFeedAndFeatureCheck) {
                    setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.setRightEdgeEffectColor) {
                    setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.getSchemeBytes) {
                    setBrightness(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.getHashMap) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                    }
                } else if (index == R.styleable.parseLineAndAppendValue) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                    }
                } else if (index != R.styleable.f9$r8$lambda$7v3KTaJFlJz89NRMIclzm3mWc) {
                    if (index == R.styleable.setPluginState) {
                        setImagePanX(obtainStyledAttributes.getFloat(index, this.mPanX));
                    } else if (index == R.styleable.f24getInWholeMillisecondsimpl) {
                        setImagePanY(obtainStyledAttributes.getFloat(index, this.mPanY));
                    } else if (index == R.styleable.ReduceOps$8ReducingSink) {
                        setImageRotate(obtainStyledAttributes.getFloat(index, this.mRotate));
                    } else if (index == R.styleable.f11$r8$lambda$TGidIAE3L8As7QVHBZ6_rXBA0k) {
                        setImageZoom(obtainStyledAttributes.getFloat(index, this.mZoom));
                    }
                } else {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0 = obtainStyledAttributes.getBoolean(index, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                }
            }
            obtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.getAuthRequestContext = drawable;
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null && drawable != null) {
                Drawable[] drawableArr = this.mLayers;
                Drawable mutate = getDrawable().mutate();
                this.getAuthRequestContext = mutate;
                drawableArr[0] = mutate;
                this.mLayers[1] = this.KClassImpl$Data$declaredNonStaticMembers$2.mutate();
                LayerDrawable layerDrawable = new LayerDrawable(this.mLayers);
                this.mLayer = layerDrawable;
                __fsTypeCheck_4b4d9d1bdba79bb02f8b35e64692ffb0(layerDrawable, 1).setAlpha((int) (this.BuiltInFictitiousFunctionClassFactory * 255.0f));
                if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                    __fsTypeCheck_4b4d9d1bdba79bb02f8b35e64692ffb0(this.mLayer, 0).setAlpha((int) ((1.0f - this.BuiltInFictitiousFunctionClassFactory) * 255.0f));
                }
                super.setImageDrawable(this.mLayer);
                return;
            }
            Drawable drawable2 = getDrawable();
            this.getAuthRequestContext = drawable2;
            if (drawable2 != null) {
                Drawable[] drawableArr2 = this.mLayers;
                Drawable mutate2 = drawable2.mutate();
                this.getAuthRequestContext = mutate2;
                drawableArr2[0] = mutate2;
            }
        }
    }

    public void setSaturation(float f) {
        this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory = f;
        this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2(this);
    }

    public float getSaturation() {
        return this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory;
    }

    public void setContrast(float f) {
        this.getErrorConfigVersion.PlaceComponentResult = f;
        this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2(this);
    }

    public float getContrast() {
        return this.getErrorConfigVersion.PlaceComponentResult;
    }

    public void setWarmth(float f) {
        this.getErrorConfigVersion.moveToNextValue = f;
        this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2(this);
    }

    public float getWarmth() {
        return this.getErrorConfigVersion.moveToNextValue;
    }

    public void setCrossfade(float f) {
        this.BuiltInFictitiousFunctionClassFactory = f;
        if (this.mLayers != null) {
            if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                __fsTypeCheck_4b4d9d1bdba79bb02f8b35e64692ffb0(this.mLayer, 0).setAlpha((int) ((1.0f - this.BuiltInFictitiousFunctionClassFactory) * 255.0f));
            }
            __fsTypeCheck_4b4d9d1bdba79bb02f8b35e64692ffb0(this.mLayer, 1).setAlpha((int) (this.BuiltInFictitiousFunctionClassFactory * 255.0f));
            super.setImageDrawable(this.mLayer);
        }
    }

    public float getCrossfade() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public void setBrightness(float f) {
        this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2 = f;
        this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2(this);
    }

    public float getBrightness() {
        return this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public void setRoundPercent(float f) {
        boolean z = this.moveToNextValue != f;
        this.moveToNextValue = f;
        if (f != 0.0f) {
            if (this.lookAheadTest == null) {
                this.lookAheadTest = new Path();
            }
            if (this.mRect == null) {
                this.mRect = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.mViewOutlineProvider == null) {
                    ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.ImageFilterView.1
                        @Override // android.view.ViewOutlineProvider
                        public void getOutline(View view, Outline outline) {
                            outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), (Math.min(r3, r4) * ImageFilterView.this.moveToNextValue) / 2.0f);
                        }
                    };
                    this.mViewOutlineProvider = viewOutlineProvider;
                    setOutlineProvider(viewOutlineProvider);
                }
                setClipToOutline(true);
            }
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.moveToNextValue) / 2.0f;
            this.mRect.set(0.0f, 0.0f, width, height);
            this.lookAheadTest.reset();
            this.lookAheadTest.addRoundRect(this.mRect, min, min, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (!z || Build.VERSION.SDK_INT < 21) {
            return;
        }
        invalidateOutline();
    }

    public void setRound(float f) {
        if (Float.isNaN(f)) {
            this.scheduleImpl = f;
            float f2 = this.moveToNextValue;
            this.moveToNextValue = -1.0f;
            setRoundPercent(f2);
            return;
        }
        boolean z = this.scheduleImpl != f;
        this.scheduleImpl = f;
        if (f != 0.0f) {
            if (this.lookAheadTest == null) {
                this.lookAheadTest = new Path();
            }
            if (this.mRect == null) {
                this.mRect = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.mViewOutlineProvider == null) {
                    ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.ImageFilterView.2
                        @Override // android.view.ViewOutlineProvider
                        public void getOutline(View view, Outline outline) {
                            outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), ImageFilterView.this.scheduleImpl);
                        }
                    };
                    this.mViewOutlineProvider = viewOutlineProvider;
                    setOutlineProvider(viewOutlineProvider);
                }
                setClipToOutline(true);
            }
            this.mRect.set(0.0f, 0.0f, getWidth(), getHeight());
            this.lookAheadTest.reset();
            Path path = this.lookAheadTest;
            RectF rectF = this.mRect;
            float f3 = this.scheduleImpl;
            path.addRoundRect(rectF, f3, f3, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (!z || Build.VERSION.SDK_INT < 21) {
            return;
        }
        invalidateOutline();
    }

    public float getRoundPercent() {
        return this.moveToNextValue;
    }

    public float getRound() {
        return this.scheduleImpl;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        if (Build.VERSION.SDK_INT >= 21 || this.moveToNextValue == 0.0f || this.lookAheadTest == null) {
            z = false;
        } else {
            z = true;
            canvas.save();
            canvas.clipPath(this.lookAheadTest);
        }
        fsSuperDraw_53e124331d9bcd4bb99d438aa0407cdc(canvas);
        if (z) {
            canvas.restore();
        }
    }

    @Override // android.view.View
    public void layout(int i, int i2, int i3, int i4) {
        super.layout(i, i2, i3, i4);
        MyBillsEntityDataFactory();
    }
}
