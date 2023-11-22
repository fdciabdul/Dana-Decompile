package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
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
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.R;
import com.fullstory.instrumentation.FSDraw;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes6.dex */
public class ImageFilterButton extends AppCompatImageButton implements FSDraw {
    private float BuiltInFictitiousFunctionClassFactory;
    private float DatabaseTableConfigUtil;
    private float GetContactSyncConfig;
    private Drawable KClassImpl$Data$declaredNonStaticMembers$2;
    private Path NetworkUserEntityData$$ExternalSyntheticLambda0;
    private float NetworkUserEntityData$$ExternalSyntheticLambda2;
    private Drawable PlaceComponentResult;
    private boolean getErrorConfigVersion;
    private float initRecordTimeStamp;
    private float lookAheadTest;
    LayerDrawable mLayer;
    Drawable[] mLayers;
    RectF mRect;
    ViewOutlineProvider mViewOutlineProvider;
    private ImageFilterView.ImageMatrix moveToNextValue;
    private float scheduleImpl;
    public static final byte[] getAuthRequestContext = {114, -79, -70, 22, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int MyBillsEntityDataFactory = 230;

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
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0029). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(java.lang.Object[] r8) {
        /*
            byte[] r0 = androidx.constraintlayout.utils.widget.ImageFilterButton.getAuthRequestContext
            r1 = 23
            byte[] r1 = new byte[r1]
            r2 = 97
            r3 = 3
            r4 = 0
            if (r0 != 0) goto Lf
            r5 = 3
            r6 = 0
            goto L29
        Lf:
            r5 = 0
        L10:
            byte r6 = (byte) r2
            int r3 = r3 + 1
            r1[r5] = r6
            r6 = 22
            if (r5 != r6) goto L21
            java.lang.String r0 = new java.lang.String
            r0.<init>(r1, r4)
            r8[r4] = r0
            return
        L21:
            int r5 = r5 + 1
            r6 = r0[r3]
            r7 = r5
            r5 = r3
            r3 = r6
            r6 = r7
        L29:
            int r3 = -r3
            int r2 = r2 + r3
            int r2 = r2 + (-8)
            r3 = r5
            r5 = r6
            goto L10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.utils.widget.ImageFilterButton.a(java.lang.Object[]):void");
    }

    public void fsSuperDraw_2d7c4d52651cd02cbbc96e7bda40bb74(Canvas canvas) {
        if (InstrumentInjector.isRecordingDraw(this, canvas)) {
            return;
        }
        super.draw(canvas);
    }

    public ImageFilterButton(Context context) {
        super(context);
        this.moveToNextValue = new ImageFilterView.ImageMatrix();
        this.BuiltInFictitiousFunctionClassFactory = 0.0f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0.0f;
        this.GetContactSyncConfig = Float.NaN;
        this.mLayers = new Drawable[2];
        this.getErrorConfigVersion = true;
        this.PlaceComponentResult = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.lookAheadTest = Float.NaN;
        this.scheduleImpl = Float.NaN;
        this.initRecordTimeStamp = Float.NaN;
        this.DatabaseTableConfigUtil = Float.NaN;
        KClassImpl$Data$declaredNonStaticMembers$2(null);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.moveToNextValue = new ImageFilterView.ImageMatrix();
        this.BuiltInFictitiousFunctionClassFactory = 0.0f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0.0f;
        this.GetContactSyncConfig = Float.NaN;
        this.mLayers = new Drawable[2];
        this.getErrorConfigVersion = true;
        this.PlaceComponentResult = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.lookAheadTest = Float.NaN;
        this.scheduleImpl = Float.NaN;
        this.initRecordTimeStamp = Float.NaN;
        this.DatabaseTableConfigUtil = Float.NaN;
        KClassImpl$Data$declaredNonStaticMembers$2(attributeSet);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.moveToNextValue = new ImageFilterView.ImageMatrix();
        this.BuiltInFictitiousFunctionClassFactory = 0.0f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0.0f;
        this.GetContactSyncConfig = Float.NaN;
        this.mLayers = new Drawable[2];
        this.getErrorConfigVersion = true;
        this.PlaceComponentResult = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.lookAheadTest = Float.NaN;
        this.scheduleImpl = Float.NaN;
        this.initRecordTimeStamp = Float.NaN;
        this.DatabaseTableConfigUtil = Float.NaN;
        KClassImpl$Data$declaredNonStaticMembers$2(attributeSet);
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.setLastTelemetrySync);
            int indexCount = obtainStyledAttributes.getIndexCount();
            this.PlaceComponentResult = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, R.styleable.getBackgroundScanPeriod);
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
                        setImagePanX(obtainStyledAttributes.getFloat(index, this.lookAheadTest));
                    } else if (index == R.styleable.f24getInWholeMillisecondsimpl) {
                        setImagePanY(obtainStyledAttributes.getFloat(index, this.scheduleImpl));
                    } else if (index == R.styleable.ReduceOps$8ReducingSink) {
                        setImageRotate(obtainStyledAttributes.getFloat(index, this.DatabaseTableConfigUtil));
                    } else if (index == R.styleable.f11$r8$lambda$TGidIAE3L8As7QVHBZ6_rXBA0k) {
                        setImageZoom(obtainStyledAttributes.getFloat(index, this.initRecordTimeStamp));
                    }
                } else {
                    this.getErrorConfigVersion = obtainStyledAttributes.getBoolean(index, this.getErrorConfigVersion);
                }
            }
            obtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = drawable;
            if (this.PlaceComponentResult != null && drawable != null) {
                Drawable[] drawableArr = this.mLayers;
                Drawable mutate = getDrawable().mutate();
                this.KClassImpl$Data$declaredNonStaticMembers$2 = mutate;
                drawableArr[0] = mutate;
                this.mLayers[1] = this.PlaceComponentResult.mutate();
                LayerDrawable layerDrawable = new LayerDrawable(this.mLayers);
                this.mLayer = layerDrawable;
                __fsTypeCheck_4b4d9d1bdba79bb02f8b35e64692ffb0(layerDrawable, 1).setAlpha((int) (this.BuiltInFictitiousFunctionClassFactory * 255.0f));
                if (!this.getErrorConfigVersion) {
                    __fsTypeCheck_4b4d9d1bdba79bb02f8b35e64692ffb0(this.mLayer, 0).setAlpha((int) ((1.0f - this.BuiltInFictitiousFunctionClassFactory) * 255.0f));
                }
                super.setImageDrawable(this.mLayer);
                return;
            }
            Drawable drawable2 = getDrawable();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = drawable2;
            if (drawable2 != null) {
                Drawable[] drawableArr2 = this.mLayers;
                Drawable mutate2 = drawable2.mutate();
                this.KClassImpl$Data$declaredNonStaticMembers$2 = mutate2;
                drawableArr2[0] = mutate2;
            }
        }
    }

    public float getImagePanX() {
        return this.lookAheadTest;
    }

    public float getImagePanY() {
        return this.scheduleImpl;
    }

    public float getImageZoom() {
        return this.initRecordTimeStamp;
    }

    public float getImageRotate() {
        return this.DatabaseTableConfigUtil;
    }

    public void setImagePanX(float f) {
        this.lookAheadTest = f;
        getAuthRequestContext();
    }

    public void setImagePanY(float f) {
        this.scheduleImpl = f;
        getAuthRequestContext();
    }

    public void setImageZoom(float f) {
        this.initRecordTimeStamp = f;
        getAuthRequestContext();
    }

    public void setImageRotate(float f) {
        this.DatabaseTableConfigUtil = f;
        getAuthRequestContext();
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.PlaceComponentResult != null && drawable != null) {
            Drawable mutate = drawable.mutate();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = mutate;
            Drawable[] drawableArr = this.mLayers;
            drawableArr[0] = mutate;
            drawableArr[1] = this.PlaceComponentResult;
            LayerDrawable layerDrawable = new LayerDrawable(this.mLayers);
            this.mLayer = layerDrawable;
            super.setImageDrawable(layerDrawable);
            setCrossfade(this.BuiltInFictitiousFunctionClassFactory);
            return;
        }
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageResource(int i) {
        Drawable BuiltInFictitiousFunctionClassFactory;
        if (this.PlaceComponentResult != null) {
            BuiltInFictitiousFunctionClassFactory = ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(getContext(), i);
            Drawable mutate = BuiltInFictitiousFunctionClassFactory.mutate();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = mutate;
            Drawable[] drawableArr = this.mLayers;
            drawableArr[0] = mutate;
            drawableArr[1] = this.PlaceComponentResult;
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
        this.PlaceComponentResult = mutate;
        Drawable[] drawableArr = this.mLayers;
        drawableArr[0] = this.KClassImpl$Data$declaredNonStaticMembers$2;
        drawableArr[1] = mutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.mLayers);
        this.mLayer = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.BuiltInFictitiousFunctionClassFactory);
    }

    private void getAuthRequestContext() {
        if (Float.isNaN(this.lookAheadTest) && Float.isNaN(this.scheduleImpl) && Float.isNaN(this.initRecordTimeStamp) && Float.isNaN(this.DatabaseTableConfigUtil)) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            MyBillsEntityDataFactory();
        }
    }

    private void MyBillsEntityDataFactory() {
        if (Float.isNaN(this.lookAheadTest) && Float.isNaN(this.scheduleImpl) && Float.isNaN(this.initRecordTimeStamp) && Float.isNaN(this.DatabaseTableConfigUtil)) {
            return;
        }
        float f = Float.isNaN(this.lookAheadTest) ? 0.0f : this.lookAheadTest;
        float f2 = Float.isNaN(this.scheduleImpl) ? 0.0f : this.scheduleImpl;
        float f3 = Float.isNaN(this.initRecordTimeStamp) ? 1.0f : this.initRecordTimeStamp;
        float f4 = Float.isNaN(this.DatabaseTableConfigUtil) ? 0.0f : this.DatabaseTableConfigUtil;
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

    public void setSaturation(float f) {
        this.moveToNextValue.BuiltInFictitiousFunctionClassFactory = f;
        this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2(this);
    }

    public float getSaturation() {
        return this.moveToNextValue.BuiltInFictitiousFunctionClassFactory;
    }

    public void setContrast(float f) {
        this.moveToNextValue.PlaceComponentResult = f;
        this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2(this);
    }

    public float getContrast() {
        return this.moveToNextValue.PlaceComponentResult;
    }

    public void setWarmth(float f) {
        this.moveToNextValue.moveToNextValue = f;
        this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2(this);
    }

    public float getWarmth() {
        return this.moveToNextValue.moveToNextValue;
    }

    public void setCrossfade(float f) {
        this.BuiltInFictitiousFunctionClassFactory = f;
        if (this.mLayers != null) {
            if (!this.getErrorConfigVersion) {
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
        this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2 = f;
        this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2(this);
    }

    public void setRoundPercent(float f) {
        boolean z = this.NetworkUserEntityData$$ExternalSyntheticLambda2 != f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = f;
        if (f != 0.0f) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new Path();
            }
            if (this.mRect == null) {
                this.mRect = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.mViewOutlineProvider == null) {
                    ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.ImageFilterButton.1
                        @Override // android.view.ViewOutlineProvider
                        public void getOutline(View view, Outline outline) {
                            outline.setRoundRect(0, 0, ImageFilterButton.this.getWidth(), ImageFilterButton.this.getHeight(), (Math.min(r3, r4) * ImageFilterButton.this.NetworkUserEntityData$$ExternalSyntheticLambda2) / 2.0f);
                        }
                    };
                    this.mViewOutlineProvider = viewOutlineProvider;
                    setOutlineProvider(viewOutlineProvider);
                }
                setClipToOutline(true);
            }
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.NetworkUserEntityData$$ExternalSyntheticLambda2) / 2.0f;
            this.mRect.set(0.0f, 0.0f, width, height);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.reset();
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.addRoundRect(this.mRect, min, min, Path.Direction.CW);
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
            this.GetContactSyncConfig = f;
            float f2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = -1.0f;
            setRoundPercent(f2);
            return;
        }
        boolean z = this.GetContactSyncConfig != f;
        this.GetContactSyncConfig = f;
        if (f != 0.0f) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new Path();
            }
            if (this.mRect == null) {
                this.mRect = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.mViewOutlineProvider == null) {
                    ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.ImageFilterButton.2
                        @Override // android.view.ViewOutlineProvider
                        public void getOutline(View view, Outline outline) {
                            outline.setRoundRect(0, 0, ImageFilterButton.this.getWidth(), ImageFilterButton.this.getHeight(), ImageFilterButton.this.GetContactSyncConfig);
                        }
                    };
                    this.mViewOutlineProvider = viewOutlineProvider;
                    setOutlineProvider(viewOutlineProvider);
                }
                setClipToOutline(true);
            }
            this.mRect.set(0.0f, 0.0f, getWidth(), getHeight());
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.reset();
            Path path = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            RectF rectF = this.mRect;
            float f3 = this.GetContactSyncConfig;
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
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    public float getRound() {
        return this.GetContactSyncConfig;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        if (Build.VERSION.SDK_INT >= 21 || this.GetContactSyncConfig == 0.0f || this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
            z = false;
        } else {
            z = true;
            canvas.save();
            canvas.clipPath(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        }
        fsSuperDraw_2d7c4d52651cd02cbbc96e7bda40bb74(canvas);
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
