package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.callback.OverlayViewChangeListener;
import com.yalantis.ucrop.util.RectUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes8.dex */
public class OverlayView extends View {
    public static final boolean DEFAULT_CIRCLE_DIMMED_LAYER = false;
    public static final int DEFAULT_CROP_GRID_COLUMN_COUNT = 2;
    public static final int DEFAULT_CROP_GRID_ROW_COUNT = 2;
    public static final int DEFAULT_FREESTYLE_CROP_MODE = 0;
    public static final boolean DEFAULT_SHOW_CROP_FRAME = true;
    public static final boolean DEFAULT_SHOW_CROP_GRID = true;
    public static final int FREESTYLE_CROP_MODE_DISABLE = 0;
    public static final int FREESTYLE_CROP_MODE_ENABLE = 1;
    public static final int FREESTYLE_CROP_MODE_ENABLE_WITH_PASS_THROUGH = 2;
    private Path BuiltInFictitiousFunctionClassFactory;
    private final RectF DatabaseTableConfigUtil;
    private int FragmentBottomSheetPaymentSettingBinding;
    private Paint GetContactSyncConfig;
    private OverlayViewChangeListener KClassImpl$Data$declaredNonStaticMembers$2;
    private Paint MyBillsEntityDataFactory;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private int NetworkUserEntityData$$ExternalSyntheticLambda1;
    private int NetworkUserEntityData$$ExternalSyntheticLambda2;
    private float NetworkUserEntityData$$ExternalSyntheticLambda3;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda5;
    private final RectF NetworkUserEntityData$$ExternalSyntheticLambda6;
    private float[] NetworkUserEntityData$$ExternalSyntheticLambda7;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda8;
    private Paint PlaceComponentResult;
    private float PrepareContext;
    private boolean getAuthRequestContext;
    private Paint getErrorConfigVersion;
    private int initRecordTimeStamp;
    private boolean isLayoutRequested;
    private int lookAheadTest;
    protected float[] mCropGridCenter;
    protected float[] mCropGridCorners;
    protected int mThisHeight;
    protected int mThisWidth;
    private int moveToNextValue;
    private float newProxyInstance;
    private int scheduleImpl;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface FreestyleMode {
    }

    public OverlayView(Context context) {
        this(context, null);
    }

    public OverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.DatabaseTableConfigUtil = new RectF();
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = new RectF();
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = null;
        this.BuiltInFictitiousFunctionClassFactory = new Path();
        this.GetContactSyncConfig = new Paint(1);
        this.getErrorConfigVersion = new Paint(1);
        this.PlaceComponentResult = new Paint(1);
        this.MyBillsEntityDataFactory = new Paint(1);
        this.initRecordTimeStamp = 0;
        this.newProxyInstance = -1.0f;
        this.PrepareContext = -1.0f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = -1;
        this.FragmentBottomSheetPaymentSettingBinding = getResources().getDimensionPixelSize(R.dimen.PlaceComponentResult_res_0x7f0703d8);
        this.lookAheadTest = getResources().getDimensionPixelSize(R.dimen.BuiltInFictitiousFunctionClassFactory_res_0x7f0703d9);
        this.scheduleImpl = getResources().getDimensionPixelSize(R.dimen.MyBillsEntityDataFactory_res_0x7f0703d7);
        init();
    }

    public OverlayViewChangeListener getOverlayViewChangeListener() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public void setOverlayViewChangeListener(OverlayViewChangeListener overlayViewChangeListener) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = overlayViewChangeListener;
    }

    public RectF getCropViewRect() {
        return this.DatabaseTableConfigUtil;
    }

    @Deprecated
    public boolean isFreestyleCropEnabled() {
        return this.initRecordTimeStamp == 1;
    }

    @Deprecated
    public void setFreestyleCropEnabled(boolean z) {
        this.initRecordTimeStamp = z ? 1 : 0;
    }

    public int getFreestyleCropMode() {
        return this.initRecordTimeStamp;
    }

    public void setFreestyleCropMode(int i) {
        this.initRecordTimeStamp = i;
        postInvalidate();
    }

    public void setCircleDimmedLayer(boolean z) {
        this.getAuthRequestContext = z;
    }

    public void setCropGridRowCount(int i) {
        this.moveToNextValue = i;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = null;
    }

    public void setCropGridColumnCount(int i) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = null;
    }

    public void setShowCropFrame(boolean z) {
        this.isLayoutRequested = z;
    }

    public void setShowCropGrid(boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = z;
    }

    public void setDimmedColor(int i) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = i;
    }

    public void setCropFrameStrokeWidth(int i) {
        this.PlaceComponentResult.setStrokeWidth(i);
    }

    public void setCropGridStrokeWidth(int i) {
        this.getErrorConfigVersion.setStrokeWidth(i);
    }

    public void setCropFrameColor(int i) {
        this.PlaceComponentResult.setColor(i);
    }

    public void setCropGridColor(int i) {
        this.getErrorConfigVersion.setColor(i);
    }

    public void setTargetAspectRatio(float f) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = f;
        if (this.mThisWidth > 0) {
            setupCropBounds();
            postInvalidate();
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = true;
    }

    public void setupCropBounds() {
        int i = this.mThisWidth;
        float f = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
        int i2 = (int) (i / f);
        int i3 = this.mThisHeight;
        if (i2 > i3) {
            int i4 = (i - ((int) (i3 * f))) / 2;
            this.DatabaseTableConfigUtil.set(getPaddingLeft() + i4, getPaddingTop(), getPaddingLeft() + r1 + i4, getPaddingTop() + this.mThisHeight);
        } else {
            int i5 = (i3 - i2) / 2;
            this.DatabaseTableConfigUtil.set(getPaddingLeft(), getPaddingTop() + i5, getPaddingLeft() + this.mThisWidth, getPaddingTop() + i2 + i5);
        }
        OverlayViewChangeListener overlayViewChangeListener = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (overlayViewChangeListener != null) {
            overlayViewChangeListener.MyBillsEntityDataFactory(this.DatabaseTableConfigUtil);
        }
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.mCropGridCorners = RectUtils.BuiltInFictitiousFunctionClassFactory(this.DatabaseTableConfigUtil);
        this.mCropGridCenter = RectUtils.KClassImpl$Data$declaredNonStaticMembers$2(this.DatabaseTableConfigUtil);
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = null;
        this.BuiltInFictitiousFunctionClassFactory.reset();
        this.BuiltInFictitiousFunctionClassFactory.addCircle(this.DatabaseTableConfigUtil.centerX(), this.DatabaseTableConfigUtil.centerY(), Math.min(this.DatabaseTableConfigUtil.width(), this.DatabaseTableConfigUtil.height()) / 2.0f, Path.Direction.CW);
    }

    protected void init() {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth();
            int paddingRight = getPaddingRight();
            int height = getHeight();
            int paddingBottom = getPaddingBottom();
            this.mThisWidth = (width - paddingRight) - paddingLeft;
            this.mThisHeight = (height - paddingBottom) - paddingTop;
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda8) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda8 = false;
                setTargetAspectRatio(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawDimmedLayer(canvas);
        drawCropGrid(canvas);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.DatabaseTableConfigUtil.isEmpty() || this.initRecordTimeStamp == 0) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if ((motionEvent.getAction() & 255) != 0) {
            if ((motionEvent.getAction() & 255) == 2 && motionEvent.getPointerCount() == 1 && this.NetworkUserEntityData$$ExternalSyntheticLambda1 != -1) {
                float min = Math.min(Math.max(x, getPaddingLeft()), getWidth() - getPaddingRight());
                float min2 = Math.min(Math.max(y, getPaddingTop()), getHeight() - getPaddingBottom());
                this.NetworkUserEntityData$$ExternalSyntheticLambda6.set(this.DatabaseTableConfigUtil);
                int i = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                if (i == 0) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda6.set(min, min2, this.DatabaseTableConfigUtil.right, this.DatabaseTableConfigUtil.bottom);
                } else if (i == 1) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda6.set(this.DatabaseTableConfigUtil.left, min2, min, this.DatabaseTableConfigUtil.bottom);
                } else if (i == 2) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda6.set(this.DatabaseTableConfigUtil.left, this.DatabaseTableConfigUtil.top, min, min2);
                } else if (i == 3) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda6.set(min, this.DatabaseTableConfigUtil.top, this.DatabaseTableConfigUtil.right, min2);
                } else if (i == 4) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda6.offset(min - this.newProxyInstance, min2 - this.PrepareContext);
                    if (this.NetworkUserEntityData$$ExternalSyntheticLambda6.left > getLeft() && this.NetworkUserEntityData$$ExternalSyntheticLambda6.top > getTop() && this.NetworkUserEntityData$$ExternalSyntheticLambda6.right < getRight() && this.NetworkUserEntityData$$ExternalSyntheticLambda6.bottom < getBottom()) {
                        this.DatabaseTableConfigUtil.set(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
                        KClassImpl$Data$declaredNonStaticMembers$2();
                        postInvalidate();
                    }
                    this.newProxyInstance = min;
                    this.PrepareContext = min2;
                    return true;
                }
                boolean z = this.NetworkUserEntityData$$ExternalSyntheticLambda6.height() >= ((float) this.lookAheadTest);
                boolean z2 = this.NetworkUserEntityData$$ExternalSyntheticLambda6.width() >= ((float) this.lookAheadTest);
                RectF rectF = this.DatabaseTableConfigUtil;
                rectF.set(z2 ? this.NetworkUserEntityData$$ExternalSyntheticLambda6.left : rectF.left, (z ? this.NetworkUserEntityData$$ExternalSyntheticLambda6 : this.DatabaseTableConfigUtil).top, (z2 ? this.NetworkUserEntityData$$ExternalSyntheticLambda6 : this.DatabaseTableConfigUtil).right, (z ? this.NetworkUserEntityData$$ExternalSyntheticLambda6 : this.DatabaseTableConfigUtil).bottom);
                if (z || z2) {
                    KClassImpl$Data$declaredNonStaticMembers$2();
                    postInvalidate();
                }
                this.newProxyInstance = min;
                this.PrepareContext = min2;
                return true;
            } else if ((motionEvent.getAction() & 255) == 1) {
                this.newProxyInstance = -1.0f;
                this.PrepareContext = -1.0f;
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = -1;
                OverlayViewChangeListener overlayViewChangeListener = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (overlayViewChangeListener != null) {
                    overlayViewChangeListener.MyBillsEntityDataFactory(this.DatabaseTableConfigUtil);
                    return false;
                }
                return false;
            } else {
                return false;
            }
        }
        double d = this.FragmentBottomSheetPaymentSettingBinding;
        int i2 = -1;
        for (int i3 = 0; i3 < 8; i3 += 2) {
            double sqrt = Math.sqrt(Math.pow(x - this.mCropGridCorners[i3], 2.0d) + Math.pow(y - this.mCropGridCorners[i3 + 1], 2.0d));
            if (sqrt < d) {
                i2 = i3 / 2;
                d = sqrt;
            }
        }
        int i4 = (this.initRecordTimeStamp == 1 && i2 < 0 && this.DatabaseTableConfigUtil.contains(x, y)) ? 4 : i2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = i4;
        boolean z3 = i4 != -1;
        if (!z3) {
            this.newProxyInstance = -1.0f;
            this.PrepareContext = -1.0f;
        } else if (this.newProxyInstance < 0.0f) {
            this.newProxyInstance = x;
            this.PrepareContext = y;
        }
        return z3;
    }

    protected void drawDimmedLayer(Canvas canvas) {
        canvas.save();
        if (this.getAuthRequestContext) {
            canvas.clipPath(this.BuiltInFictitiousFunctionClassFactory, Region.Op.DIFFERENCE);
        } else {
            canvas.clipRect(this.DatabaseTableConfigUtil, Region.Op.DIFFERENCE);
        }
        canvas.drawColor(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        canvas.restore();
        if (this.getAuthRequestContext) {
            canvas.drawCircle(this.DatabaseTableConfigUtil.centerX(), this.DatabaseTableConfigUtil.centerY(), Math.min(this.DatabaseTableConfigUtil.width(), this.DatabaseTableConfigUtil.height()) / 2.0f, this.GetContactSyncConfig);
        }
    }

    protected void drawCropGrid(Canvas canvas) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda5) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda7 == null && !this.DatabaseTableConfigUtil.isEmpty()) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new float[(this.moveToNextValue * 4) + (this.NetworkUserEntityData$$ExternalSyntheticLambda0 * 4)];
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                while (i3 < this.moveToNextValue) {
                    int i4 = i2 + 1;
                    this.NetworkUserEntityData$$ExternalSyntheticLambda7[i2] = this.DatabaseTableConfigUtil.left;
                    int i5 = i4 + 1;
                    float f = i3 + 1.0f;
                    this.NetworkUserEntityData$$ExternalSyntheticLambda7[i4] = (this.DatabaseTableConfigUtil.height() * (f / (this.moveToNextValue + 1))) + this.DatabaseTableConfigUtil.top;
                    int i6 = i5 + 1;
                    this.NetworkUserEntityData$$ExternalSyntheticLambda7[i5] = this.DatabaseTableConfigUtil.right;
                    this.NetworkUserEntityData$$ExternalSyntheticLambda7[i6] = (this.DatabaseTableConfigUtil.height() * (f / (this.moveToNextValue + 1))) + this.DatabaseTableConfigUtil.top;
                    i3++;
                    i2 = i6 + 1;
                }
                while (i < this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                    int i7 = i2 + 1;
                    float f2 = i + 1.0f;
                    this.NetworkUserEntityData$$ExternalSyntheticLambda7[i2] = (this.DatabaseTableConfigUtil.width() * (f2 / (this.NetworkUserEntityData$$ExternalSyntheticLambda0 + 1))) + this.DatabaseTableConfigUtil.left;
                    int i8 = i7 + 1;
                    this.NetworkUserEntityData$$ExternalSyntheticLambda7[i7] = this.DatabaseTableConfigUtil.top;
                    int i9 = i8 + 1;
                    this.NetworkUserEntityData$$ExternalSyntheticLambda7[i8] = (this.DatabaseTableConfigUtil.width() * (f2 / (this.NetworkUserEntityData$$ExternalSyntheticLambda0 + 1))) + this.DatabaseTableConfigUtil.left;
                    this.NetworkUserEntityData$$ExternalSyntheticLambda7[i9] = this.DatabaseTableConfigUtil.bottom;
                    i++;
                    i2 = i9 + 1;
                }
            }
            float[] fArr = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
            if (fArr != null) {
                canvas.drawLines(fArr, this.getErrorConfigVersion);
            }
        }
        if (this.isLayoutRequested) {
            canvas.drawRect(this.DatabaseTableConfigUtil, this.PlaceComponentResult);
        }
        if (this.initRecordTimeStamp != 0) {
            canvas.save();
            this.NetworkUserEntityData$$ExternalSyntheticLambda6.set(this.DatabaseTableConfigUtil);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6.inset(this.scheduleImpl, -r1);
            canvas.clipRect(this.NetworkUserEntityData$$ExternalSyntheticLambda6, Region.Op.DIFFERENCE);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6.set(this.DatabaseTableConfigUtil);
            this.NetworkUserEntityData$$ExternalSyntheticLambda6.inset(-r1, this.scheduleImpl);
            canvas.clipRect(this.NetworkUserEntityData$$ExternalSyntheticLambda6, Region.Op.DIFFERENCE);
            canvas.drawRect(this.DatabaseTableConfigUtil, this.MyBillsEntityDataFactory);
            canvas.restore();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void processStyledAttributes(TypedArray typedArray) {
        this.getAuthRequestContext = typedArray.getBoolean(R.styleable.AppCompatEmojiTextHelper, false);
        int color = typedArray.getColor(R.styleable.G, getResources().getColor(R.color.MyBillsEntityDataFactory_res_0x7f06032b));
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = color;
        this.GetContactSyncConfig.setColor(color);
        this.GetContactSyncConfig.setStyle(Paint.Style.STROKE);
        this.GetContactSyncConfig.setStrokeWidth(1.0f);
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.K, getResources().getDimensionPixelSize(R.dimen.getAuthRequestContext_res_0x7f0703d4));
        int color2 = typedArray.getColor(R.styleable.J, getResources().getColor(R.color.PlaceComponentResult_res_0x7f060329));
        this.PlaceComponentResult.setStrokeWidth(dimensionPixelSize);
        this.PlaceComponentResult.setColor(color2);
        this.PlaceComponentResult.setStyle(Paint.Style.STROKE);
        this.MyBillsEntityDataFactory.setStrokeWidth(dimensionPixelSize * 3);
        this.MyBillsEntityDataFactory.setColor(color2);
        this.MyBillsEntityDataFactory.setStyle(Paint.Style.STROKE);
        this.isLayoutRequested = typedArray.getBoolean(R.styleable.Q, true);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(R.styleable.P, getResources().getDimensionPixelSize(R.dimen.res_0x7f0703d5_kclassimpl_data_declarednonstaticmembers_2));
        int color3 = typedArray.getColor(R.styleable.L, getResources().getColor(R.color.res_0x7f06032a_kclassimpl_data_declarednonstaticmembers_2));
        this.getErrorConfigVersion.setStrokeWidth(dimensionPixelSize2);
        this.getErrorConfigVersion.setColor(color3);
        this.moveToNextValue = typedArray.getInt(R.styleable.M, 2);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = typedArray.getInt(R.styleable.getNameOrBuilderList, 2);
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = typedArray.getBoolean(R.styleable.N, true);
    }
}
