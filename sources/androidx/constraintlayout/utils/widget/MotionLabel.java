package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.FloatLayout;
import androidx.constraintlayout.widget.R;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.material.badge.BadgeDrawable;

/* loaded from: classes6.dex */
public class MotionLabel extends View implements FloatLayout {
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {123, 85, -72, 69, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int PlaceComponentResult = 191;
    static String TAG = "MotionLabel";
    private int A;
    private float B;
    private boolean BottomSheetCardBindingView$watcherCardNumberView$1;
    private int BuiltInFictitiousFunctionClassFactory;
    private float C;
    private int DatabaseTableConfigUtil;
    private int FragmentBottomSheetPaymentSettingBinding;
    private int GetContactSyncConfig;
    private boolean MyBillsEntityDataFactory;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private int NetworkUserEntityData$$ExternalSyntheticLambda1;
    private int NetworkUserEntityData$$ExternalSyntheticLambda2;
    private Rect NetworkUserEntityData$$ExternalSyntheticLambda3;
    private int NetworkUserEntityData$$ExternalSyntheticLambda4;
    private Bitmap NetworkUserEntityData$$ExternalSyntheticLambda5;
    private float NetworkUserEntityData$$ExternalSyntheticLambda6;
    private float NetworkUserEntityData$$ExternalSyntheticLambda7;
    private int NetworkUserEntityData$$ExternalSyntheticLambda8;
    private Drawable PrepareContext;
    private BitmapShader SubSequence;
    private int VerifyPinStateManager$executeRiskChallenge$2$1;
    private float getAuthRequestContext;
    private float getCallingPid;
    private String getErrorConfigVersion;
    private Matrix getSupportButtonTintMode;
    private Layout initRecordTimeStamp;
    private String isLayoutRequested;
    private float lookAheadTest;
    float mBackgroundPanX;
    float mBackgroundPanY;
    boolean mNotBuilt;
    Matrix mOutlinePositionMatrix;
    TextPaint mPaint;
    Path mPath;
    RectF mRect;
    float mRotate;
    Paint mTempPaint;
    Rect mTempRect;
    ViewOutlineProvider mViewOutlineProvider;
    float mZoom;
    private float moveToNextValue;
    private float newProxyInstance;
    Paint paintCache;
    float paintTextSize;
    private float readMicros;
    private float scheduleImpl;
    private float whenAvailable;

    public MotionLabel(Context context) {
        super(context);
        this.mPaint = new TextPaint();
        this.mPath = new Path();
        this.FragmentBottomSheetPaymentSettingBinding = 65535;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = 65535;
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = 0.0f;
        this.newProxyInstance = Float.NaN;
        this.whenAvailable = 48.0f;
        this.getAuthRequestContext = Float.NaN;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = 0.0f;
        this.isLayoutRequested = "Hello World";
        this.mNotBuilt = true;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = new Rect();
        this.GetContactSyncConfig = 1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 1;
        this.DatabaseTableConfigUtil = 1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = 1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = BadgeDrawable.TOP_START;
        this.BuiltInFictitiousFunctionClassFactory = 0;
        this.MyBillsEntityDataFactory = false;
        this.B = Float.NaN;
        this.C = Float.NaN;
        this.readMicros = 0.0f;
        this.getCallingPid = 0.0f;
        this.paintCache = new Paint();
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = 0;
        this.mBackgroundPanX = Float.NaN;
        this.mBackgroundPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        BuiltInFictitiousFunctionClassFactory(context, null);
    }

    public MotionLabel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new TextPaint();
        this.mPath = new Path();
        this.FragmentBottomSheetPaymentSettingBinding = 65535;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = 65535;
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = 0.0f;
        this.newProxyInstance = Float.NaN;
        this.whenAvailable = 48.0f;
        this.getAuthRequestContext = Float.NaN;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = 0.0f;
        this.isLayoutRequested = "Hello World";
        this.mNotBuilt = true;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = new Rect();
        this.GetContactSyncConfig = 1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 1;
        this.DatabaseTableConfigUtil = 1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = 1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = BadgeDrawable.TOP_START;
        this.BuiltInFictitiousFunctionClassFactory = 0;
        this.MyBillsEntityDataFactory = false;
        this.B = Float.NaN;
        this.C = Float.NaN;
        this.readMicros = 0.0f;
        this.getCallingPid = 0.0f;
        this.paintCache = new Paint();
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = 0;
        this.mBackgroundPanX = Float.NaN;
        this.mBackgroundPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        BuiltInFictitiousFunctionClassFactory(context, attributeSet);
    }

    public MotionLabel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new TextPaint();
        this.mPath = new Path();
        this.FragmentBottomSheetPaymentSettingBinding = 65535;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = 65535;
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = 0.0f;
        this.newProxyInstance = Float.NaN;
        this.whenAvailable = 48.0f;
        this.getAuthRequestContext = Float.NaN;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = 0.0f;
        this.isLayoutRequested = "Hello World";
        this.mNotBuilt = true;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = new Rect();
        this.GetContactSyncConfig = 1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 1;
        this.DatabaseTableConfigUtil = 1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = 1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = BadgeDrawable.TOP_START;
        this.BuiltInFictitiousFunctionClassFactory = 0;
        this.MyBillsEntityDataFactory = false;
        this.B = Float.NaN;
        this.C = Float.NaN;
        this.readMicros = 0.0f;
        this.getCallingPid = 0.0f;
        this.paintCache = new Paint();
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = 0;
        this.mBackgroundPanX = Float.NaN;
        this.mBackgroundPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        BuiltInFictitiousFunctionClassFactory(context, attributeSet);
    }

    private void BuiltInFictitiousFunctionClassFactory(Context context, AttributeSet attributeSet) {
        KClassImpl$Data$declaredNonStaticMembers$2(context);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.compositeOverlayWithThemeSurfaceColorIfNeeded);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.setOnSeeAllClickListener) {
                    setText(obtainStyledAttributes.getText(index));
                } else if (index == R.styleable.AudioManager$OnModeChangedListener) {
                    this.getErrorConfigVersion = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.RecentContactRepository) {
                    this.getAuthRequestContext = obtainStyledAttributes.getDimensionPixelSize(index, (int) this.getAuthRequestContext);
                } else if (index == R.styleable.addAllCpuMetricReadings) {
                    this.whenAvailable = obtainStyledAttributes.getDimensionPixelSize(index, (int) this.whenAvailable);
                } else if (index == R.styleable.onLoadingGetInvestmentCardAssets) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda8 = obtainStyledAttributes.getInt(index, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
                } else if (index == R.styleable.SseAuthenticationResponseParser) {
                    this.A = obtainStyledAttributes.getInt(index, this.A);
                } else if (index == R.styleable.getQueryKey) {
                    this.FragmentBottomSheetPaymentSettingBinding = obtainStyledAttributes.getColor(index, this.FragmentBottomSheetPaymentSettingBinding);
                } else if (index == R.styleable.isValidRowNumber) {
                    this.newProxyInstance = obtainStyledAttributes.getDimension(index, this.newProxyInstance);
                    if (Build.VERSION.SDK_INT >= 21) {
                        setRound(this.newProxyInstance);
                    }
                } else if (index == R.styleable.LoginTrackingConstants$HoldLogin) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda7 = obtainStyledAttributes.getFloat(index, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
                    if (Build.VERSION.SDK_INT >= 21) {
                        setRoundPercent(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
                    }
                } else if (index == R.styleable.DateRetargetClass) {
                    setGravity(obtainStyledAttributes.getInt(index, -1));
                } else if (index == R.styleable.f31sortDescendingQwZRm1k) {
                    this.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.setAttachContext) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda4 = obtainStyledAttributes.getInt(index, this.NetworkUserEntityData$$ExternalSyntheticLambda4);
                    this.BottomSheetCardBindingView$watcherCardNumberView$1 = true;
                } else if (index == R.styleable.getBoards) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda6 = obtainStyledAttributes.getDimension(index, this.NetworkUserEntityData$$ExternalSyntheticLambda6);
                    this.BottomSheetCardBindingView$watcherCardNumberView$1 = true;
                } else if (index == R.styleable.Camera$OnZoomChangeListener) {
                    this.PrepareContext = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, index);
                    this.BottomSheetCardBindingView$watcherCardNumberView$1 = true;
                } else if (index == R.styleable.SharedPreferencesUtils) {
                    this.mBackgroundPanX = obtainStyledAttributes.getFloat(index, this.mBackgroundPanX);
                } else if (index == R.styleable.OptimizedMessage) {
                    this.mBackgroundPanY = obtainStyledAttributes.getFloat(index, this.mBackgroundPanY);
                } else if (index == R.styleable.getImgUrl) {
                    this.readMicros = obtainStyledAttributes.getFloat(index, this.readMicros);
                } else if (index == R.styleable.NearbyPlaceEntityRepository$$ExternalSyntheticLambda1) {
                    this.getCallingPid = obtainStyledAttributes.getFloat(index, this.getCallingPid);
                } else if (index == R.styleable.AbstractScopeAdapter) {
                    this.mRotate = obtainStyledAttributes.getFloat(index, this.mRotate);
                } else if (index == R.styleable.AbstractContract$AbstractView) {
                    this.mZoom = obtainStyledAttributes.getFloat(index, this.mZoom);
                } else if (index == R.styleable.stopIgnoringView) {
                    this.B = obtainStyledAttributes.getDimension(index, this.B);
                } else if (index == R.styleable.getMimeType) {
                    this.C = obtainStyledAttributes.getDimension(index, this.C);
                } else if (index == R.styleable.getLottieParams) {
                    this.VerifyPinStateManager$executeRiskChallenge$2$1 = obtainStyledAttributes.getInt(index, this.VerifyPinStateManager$executeRiskChallenge$2$1);
                }
            }
            obtainStyledAttributes.recycle();
        }
        getAuthRequestContext();
        setupPath();
    }

    Bitmap blur(Bitmap bitmap, int i) {
        int width = bitmap.getWidth() / 2;
        int height = bitmap.getHeight() / 2;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
        for (int i2 = 0; i2 < i && width >= 32 && height >= 32; i2++) {
            width /= 2;
            height /= 2;
            createScaledBitmap = Bitmap.createScaledBitmap(createScaledBitmap, width, height, true);
        }
        return createScaledBitmap;
    }

    private void getAuthRequestContext() {
        if (this.PrepareContext != null) {
            this.getSupportButtonTintMode = new Matrix();
            int intrinsicWidth = this.PrepareContext.getIntrinsicWidth();
            int intrinsicHeight = this.PrepareContext.getIntrinsicHeight();
            if (intrinsicWidth <= 0 && (intrinsicWidth = getWidth()) == 0) {
                intrinsicWidth = Float.isNaN(this.C) ? 128 : (int) this.C;
            }
            if (intrinsicHeight <= 0 && (intrinsicHeight = getHeight()) == 0) {
                intrinsicHeight = Float.isNaN(this.B) ? 128 : (int) this.B;
            }
            if (this.VerifyPinStateManager$executeRiskChallenge$2$1 != 0) {
                intrinsicWidth /= 2;
                intrinsicHeight /= 2;
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
            this.PrepareContext.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            this.PrepareContext.setFilterBitmap(true);
            this.PrepareContext.draw(canvas);
            if (this.VerifyPinStateManager$executeRiskChallenge$2$1 != 0) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda5 = blur(this.NetworkUserEntityData$$ExternalSyntheticLambda5, 4);
            }
            Bitmap bitmap = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            this.SubSequence = new BitmapShader(bitmap, tileMode, tileMode);
        }
    }

    public void setGravity(int i) {
        if ((i & 8388615) == 0) {
            i |= 8388611;
        }
        if ((i & 112) == 0) {
            i |= 48;
        }
        if (i != this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            invalidate();
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
        int i2 = i & 112;
        if (i2 == 48) {
            this.getCallingPid = -1.0f;
        } else if (i2 == 80) {
            this.getCallingPid = 1.0f;
        } else {
            this.getCallingPid = 0.0f;
        }
        int i3 = i & 8388615;
        if (i3 != 3) {
            if (i3 != 5) {
                if (i3 != 8388611) {
                    if (i3 != 8388613) {
                        this.readMicros = 0.0f;
                        return;
                    }
                }
            }
            this.readMicros = 1.0f;
            return;
        }
        this.readMicros = -1.0f;
    }

    private float BuiltInFictitiousFunctionClassFactory() {
        float f = Float.isNaN(this.getAuthRequestContext) ? 1.0f : this.whenAvailable / this.getAuthRequestContext;
        TextPaint textPaint = this.mPaint;
        String str = this.isLayoutRequested;
        return (((((Float.isNaN(this.lookAheadTest) ? getMeasuredWidth() : this.lookAheadTest) - getPaddingLeft()) - getPaddingRight()) - (f * textPaint.measureText(str, 0, str.length()))) * (this.readMicros + 1.0f)) / 2.0f;
    }

    private float MyBillsEntityDataFactory() {
        float f = Float.isNaN(this.getAuthRequestContext) ? 1.0f : this.whenAvailable / this.getAuthRequestContext;
        Paint.FontMetrics fontMetrics = this.mPaint.getFontMetrics();
        return ((((((Float.isNaN(this.moveToNextValue) ? getMeasuredHeight() : this.moveToNextValue) - getPaddingTop()) - getPaddingBottom()) - ((fontMetrics.descent - fontMetrics.ascent) * f)) * (1.0f - this.getCallingPid)) / 2.0f) - (f * fontMetrics.ascent);
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(androidx.appcompat.R.attr.readMicros, typedValue, true);
        TextPaint textPaint = this.mPaint;
        int i = typedValue.data;
        this.FragmentBottomSheetPaymentSettingBinding = i;
        textPaint.setColor(i);
    }

    public void setText(CharSequence charSequence) {
        this.isLayoutRequested = charSequence.toString();
        invalidate();
    }

    void setupPath() {
        Typeface typeface;
        Typeface typefaceCreateDerived;
        this.GetContactSyncConfig = getPaddingLeft();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = getPaddingRight();
        this.DatabaseTableConfigUtil = getPaddingTop();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = getPaddingBottom();
        String str = this.getErrorConfigVersion;
        int i = this.A;
        int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        if (str != null) {
            typeface = Typeface.create(str, i2);
            if (typeface != null) {
                setTypeface(typeface);
                this.mPaint.setColor(this.FragmentBottomSheetPaymentSettingBinding);
                this.mPaint.setStrokeWidth(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
                this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
                this.mPaint.setFlags(128);
                setTextSize(this.whenAvailable);
                this.mPaint.setAntiAlias(true);
            }
        } else {
            typeface = null;
        }
        if (i == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i == 2) {
            typeface = Typeface.SERIF;
        } else if (i == 3) {
            typeface = Typeface.MONOSPACE;
        }
        if (i2 > 0) {
            if (typeface == null) {
                typefaceCreateDerived = Typeface.defaultFromStyle(i2);
            } else {
                typefaceCreateDerived = InstrumentInjector.typefaceCreateDerived(typeface, i2);
            }
            setTypeface(typefaceCreateDerived);
            int style = ((typefaceCreateDerived != null ? typefaceCreateDerived.getStyle() : 0) ^ (-1)) & i2;
            this.mPaint.setFakeBoldText((style & 1) != 0);
            this.mPaint.setTextSkewX((style & 2) != 0 ? -0.25f : 0.0f);
        } else {
            this.mPaint.setFakeBoldText(false);
            this.mPaint.setTextSkewX(0.0f);
            setTypeface(typeface);
        }
        this.mPaint.setColor(this.FragmentBottomSheetPaymentSettingBinding);
        this.mPaint.setStrokeWidth(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mPaint.setFlags(128);
        setTextSize(this.whenAvailable);
        this.mPaint.setAntiAlias(true);
    }

    void buildShape(float f) {
        if (this.BottomSheetCardBindingView$watcherCardNumberView$1 || f != 1.0f) {
            this.mPath.reset();
            String str = this.isLayoutRequested;
            int length = str.length();
            this.mPaint.getTextBounds(str, 0, length, this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            this.mPaint.getTextPath(str, 0, length, 0.0f, 0.0f, this.mPath);
            if (f != 1.0f) {
                String str2 = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append(Debug.PlaceComponentResult());
                sb.append(" scale ");
                sb.append(f);
                InstrumentInjector.log_v(str2, sb.toString());
                Matrix matrix = new Matrix();
                matrix.postScale(f, f);
                this.mPath.transform(matrix);
            }
            Rect rect = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
            rect.right--;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3.left++;
            this.NetworkUserEntityData$$ExternalSyntheticLambda3.bottom++;
            Rect rect2 = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
            rect2.top--;
            RectF rectF = new RectF();
            rectF.bottom = getHeight();
            rectF.right = getWidth();
            this.mNotBuilt = false;
        }
    }

    @Override // android.view.View
    public void layout(int i, int i2, int i3, int i4) {
        super.layout(i, i2, i3, i4);
        boolean isNaN = Float.isNaN(this.getAuthRequestContext);
        float f = isNaN ? 1.0f : this.whenAvailable / this.getAuthRequestContext;
        this.lookAheadTest = i3 - i;
        this.moveToNextValue = i4 - i2;
        if (this.MyBillsEntityDataFactory) {
            if (this.mTempRect == null) {
                this.mTempPaint = new Paint();
                this.mTempRect = new Rect();
                this.mTempPaint.set(this.mPaint);
                this.paintTextSize = this.mTempPaint.getTextSize();
            }
            Paint paint = this.mTempPaint;
            String str = this.isLayoutRequested;
            paint.getTextBounds(str, 0, str.length(), this.mTempRect);
            int width = this.mTempRect.width();
            int height = (int) (this.mTempRect.height() * 1.3f);
            float f2 = (this.lookAheadTest - this.NetworkUserEntityData$$ExternalSyntheticLambda2) - this.GetContactSyncConfig;
            float f3 = (this.moveToNextValue - this.NetworkUserEntityData$$ExternalSyntheticLambda1) - this.DatabaseTableConfigUtil;
            if (isNaN) {
                float f4 = width;
                float f5 = height;
                if (f4 * f3 > f5 * f2) {
                    this.mPaint.setTextSize((this.paintTextSize * f2) / f4);
                } else {
                    this.mPaint.setTextSize((this.paintTextSize * f3) / f5);
                }
            } else {
                float f6 = width;
                float f7 = height;
                f = f6 * f3 > f7 * f2 ? f2 / f6 : f3 / f7;
            }
        }
        if (this.BottomSheetCardBindingView$watcherCardNumberView$1 || !isNaN) {
            float f8 = i;
            float f9 = i2;
            float f10 = i3;
            float f11 = i4;
            if (this.getSupportButtonTintMode != null) {
                this.lookAheadTest = f10 - f8;
                this.moveToNextValue = f11 - f9;
                KClassImpl$Data$declaredNonStaticMembers$2();
            }
            buildShape(f);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.FloatLayout
    public void layout(float f, float f2, float f3, float f4) {
        int i = (int) (f + 0.5f);
        this.scheduleImpl = f - i;
        int i2 = (int) (f3 + 0.5f);
        int i3 = i2 - i;
        int i4 = (int) (f4 + 0.5f);
        int i5 = (int) (0.5f + f2);
        int i6 = i4 - i5;
        float f5 = f3 - f;
        this.lookAheadTest = f5;
        float f6 = f4 - f2;
        this.moveToNextValue = f6;
        if (this.getSupportButtonTintMode != null) {
            this.lookAheadTest = f5;
            this.moveToNextValue = f6;
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
        if (getMeasuredHeight() != i6 || getMeasuredWidth() != i3) {
            measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(i6, 1073741824));
            super.layout(i, i5, i2, i4);
        } else {
            super.layout(i, i5, i2, i4);
        }
        if (this.MyBillsEntityDataFactory) {
            if (this.mTempRect == null) {
                this.mTempPaint = new Paint();
                this.mTempRect = new Rect();
                this.mTempPaint.set(this.mPaint);
                this.paintTextSize = this.mTempPaint.getTextSize();
            }
            this.lookAheadTest = f5;
            this.moveToNextValue = f6;
            Paint paint = this.mTempPaint;
            String str = this.isLayoutRequested;
            paint.getTextBounds(str, 0, str.length(), this.mTempRect);
            float height = this.mTempRect.height() * 1.3f;
            float f7 = (f5 - this.NetworkUserEntityData$$ExternalSyntheticLambda2) - this.GetContactSyncConfig;
            float f8 = (f6 - this.NetworkUserEntityData$$ExternalSyntheticLambda1) - this.DatabaseTableConfigUtil;
            float width = this.mTempRect.width();
            if (width * f8 > height * f7) {
                this.mPaint.setTextSize((this.paintTextSize * f7) / width);
            } else {
                this.mPaint.setTextSize((this.paintTextSize * f8) / height);
            }
            if (this.BottomSheetCardBindingView$watcherCardNumberView$1 || !Float.isNaN(this.getAuthRequestContext)) {
                buildShape(Float.isNaN(this.getAuthRequestContext) ? 1.0f : this.whenAvailable / this.getAuthRequestContext);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f = Float.isNaN(this.getAuthRequestContext) ? 1.0f : this.whenAvailable / this.getAuthRequestContext;
        super.onDraw(canvas);
        if (!this.BottomSheetCardBindingView$watcherCardNumberView$1 && f == 1.0f) {
            canvas.drawText(this.isLayoutRequested, this.scheduleImpl + this.GetContactSyncConfig + BuiltInFictitiousFunctionClassFactory(), this.DatabaseTableConfigUtil + MyBillsEntityDataFactory(), this.mPaint);
            return;
        }
        if (this.mNotBuilt) {
            buildShape(f);
        }
        if (this.mOutlinePositionMatrix == null) {
            this.mOutlinePositionMatrix = new Matrix();
        }
        if (this.BottomSheetCardBindingView$watcherCardNumberView$1) {
            this.paintCache.set(this.mPaint);
            this.mOutlinePositionMatrix.reset();
            float BuiltInFictitiousFunctionClassFactory = this.GetContactSyncConfig + BuiltInFictitiousFunctionClassFactory();
            float MyBillsEntityDataFactory = this.DatabaseTableConfigUtil + MyBillsEntityDataFactory();
            this.mOutlinePositionMatrix.postTranslate(BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory);
            this.mOutlinePositionMatrix.preScale(f, f);
            this.mPath.transform(this.mOutlinePositionMatrix);
            if (this.SubSequence != null) {
                this.mPaint.setFilterBitmap(true);
                this.mPaint.setShader(this.SubSequence);
            } else {
                this.mPaint.setColor(this.FragmentBottomSheetPaymentSettingBinding);
            }
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setStrokeWidth(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
            canvas.drawPath(this.mPath, this.mPaint);
            if (this.SubSequence != null) {
                this.mPaint.setShader(null);
            }
            this.mPaint.setColor(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
            canvas.drawPath(this.mPath, this.mPaint);
            this.mOutlinePositionMatrix.reset();
            this.mOutlinePositionMatrix.postTranslate(-BuiltInFictitiousFunctionClassFactory, -MyBillsEntityDataFactory);
            this.mPath.transform(this.mOutlinePositionMatrix);
            this.mPaint.set(this.paintCache);
            return;
        }
        float BuiltInFictitiousFunctionClassFactory2 = this.GetContactSyncConfig + BuiltInFictitiousFunctionClassFactory();
        float MyBillsEntityDataFactory2 = this.DatabaseTableConfigUtil + MyBillsEntityDataFactory();
        this.mOutlinePositionMatrix.reset();
        this.mOutlinePositionMatrix.preTranslate(BuiltInFictitiousFunctionClassFactory2, MyBillsEntityDataFactory2);
        this.mPath.transform(this.mOutlinePositionMatrix);
        this.mPaint.setColor(this.FragmentBottomSheetPaymentSettingBinding);
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mPaint.setStrokeWidth(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
        canvas.drawPath(this.mPath, this.mPaint);
        this.mOutlinePositionMatrix.reset();
        this.mOutlinePositionMatrix.preTranslate(-BuiltInFictitiousFunctionClassFactory2, -MyBillsEntityDataFactory2);
        this.mPath.transform(this.mOutlinePositionMatrix);
    }

    public void setTextOutlineThickness(float f) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = f;
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = true;
        if (Float.isNaN(f)) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = 1.0f;
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = false;
        }
        invalidate();
    }

    public void setTextFillColor(int i) {
        this.FragmentBottomSheetPaymentSettingBinding = i;
        invalidate();
    }

    public void setTextOutlineColor(int i) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = i;
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = true;
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        if (this.mPaint.getTypeface() != typeface) {
            this.mPaint.setTypeface(typeface);
            if (this.initRecordTimeStamp != null) {
                this.initRecordTimeStamp = null;
                requestLayout();
                invalidate();
            }
        }
    }

    public Typeface getTypeface() {
        return this.mPaint.getTypeface();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        this.MyBillsEntityDataFactory = false;
        this.GetContactSyncConfig = getPaddingLeft();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = getPaddingRight();
        this.DatabaseTableConfigUtil = getPaddingTop();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = getPaddingBottom();
        if (mode != 1073741824 || mode2 != 1073741824) {
            TextPaint textPaint = this.mPaint;
            String str = this.isLayoutRequested;
            textPaint.getTextBounds(str, 0, str.length(), this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            if (mode != 1073741824) {
                size = (int) (this.NetworkUserEntityData$$ExternalSyntheticLambda3.width() + 0.99999f);
            }
            size += this.GetContactSyncConfig + this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (mode2 != 1073741824) {
                int fontMetricsInt = (int) (this.mPaint.getFontMetricsInt(null) + 0.99999f);
                if (mode2 == Integer.MIN_VALUE) {
                    fontMetricsInt = Math.min(size2, fontMetricsInt);
                }
                size2 = this.DatabaseTableConfigUtil + this.NetworkUserEntityData$$ExternalSyntheticLambda1 + fontMetricsInt;
            }
        } else if (this.BuiltInFictitiousFunctionClassFactory != 0) {
            this.MyBillsEntityDataFactory = true;
        }
        setMeasuredDimension(size, size2);
    }

    public void setRoundPercent(float f) {
        boolean z = this.NetworkUserEntityData$$ExternalSyntheticLambda7 != f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = f;
        if (f != 0.0f) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            if (this.mRect == null) {
                this.mRect = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.mViewOutlineProvider == null) {
                    ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.MotionLabel.1
                        @Override // android.view.ViewOutlineProvider
                        public void getOutline(View view, Outline outline) {
                            outline.setRoundRect(0, 0, MotionLabel.this.getWidth(), MotionLabel.this.getHeight(), (Math.min(r3, r4) * MotionLabel.this.NetworkUserEntityData$$ExternalSyntheticLambda7) / 2.0f);
                        }
                    };
                    this.mViewOutlineProvider = viewOutlineProvider;
                    setOutlineProvider(viewOutlineProvider);
                }
                setClipToOutline(true);
            }
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.NetworkUserEntityData$$ExternalSyntheticLambda7) / 2.0f;
            this.mRect.set(0.0f, 0.0f, width, height);
            this.mPath.reset();
            this.mPath.addRoundRect(this.mRect, min, min, Path.Direction.CW);
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
            this.newProxyInstance = f;
            float f2 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = -1.0f;
            setRoundPercent(f2);
            return;
        }
        boolean z = this.newProxyInstance != f;
        this.newProxyInstance = f;
        if (f != 0.0f) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            if (this.mRect == null) {
                this.mRect = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.mViewOutlineProvider == null) {
                    ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.MotionLabel.2
                        @Override // android.view.ViewOutlineProvider
                        public void getOutline(View view, Outline outline) {
                            outline.setRoundRect(0, 0, MotionLabel.this.getWidth(), MotionLabel.this.getHeight(), MotionLabel.this.newProxyInstance);
                        }
                    };
                    this.mViewOutlineProvider = viewOutlineProvider;
                    setOutlineProvider(viewOutlineProvider);
                }
                setClipToOutline(true);
            }
            this.mRect.set(0.0f, 0.0f, getWidth(), getHeight());
            this.mPath.reset();
            Path path = this.mPath;
            RectF rectF = this.mRect;
            float f3 = this.newProxyInstance;
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
        return this.NetworkUserEntityData$$ExternalSyntheticLambda7;
    }

    public float getRound() {
        return this.newProxyInstance;
    }

    public void setTextSize(float f) {
        this.whenAvailable = f;
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(Debug.PlaceComponentResult());
        sb.append("  ");
        sb.append(f);
        sb.append(" / ");
        sb.append(this.getAuthRequestContext);
        InstrumentInjector.log_v(str, sb.toString());
        TextPaint textPaint = this.mPaint;
        if (!Float.isNaN(this.getAuthRequestContext)) {
            f = this.getAuthRequestContext;
        }
        textPaint.setTextSize(f);
        buildShape(Float.isNaN(this.getAuthRequestContext) ? 1.0f : this.whenAvailable / this.getAuthRequestContext);
        requestLayout();
        invalidate();
    }

    public int getTextOutlineColor() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda4;
    }

    public float getTextBackgroundPanX() {
        return this.mBackgroundPanX;
    }

    public float getTextBackgroundPanY() {
        return this.mBackgroundPanY;
    }

    public float getTextBackgroundZoom() {
        return this.mZoom;
    }

    public float getTextBackgroundRotate() {
        return this.mRotate;
    }

    public void setTextBackgroundPanX(float f) {
        this.mBackgroundPanX = f;
        KClassImpl$Data$declaredNonStaticMembers$2();
        invalidate();
    }

    public void setTextBackgroundPanY(float f) {
        this.mBackgroundPanY = f;
        KClassImpl$Data$declaredNonStaticMembers$2();
        invalidate();
    }

    public void setTextBackgroundZoom(float f) {
        this.mZoom = f;
        KClassImpl$Data$declaredNonStaticMembers$2();
        invalidate();
    }

    public void setTextBackgroundRotate(float f) {
        this.mRotate = f;
        KClassImpl$Data$declaredNonStaticMembers$2();
        invalidate();
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2() {
        float f = Float.isNaN(this.mBackgroundPanX) ? 0.0f : this.mBackgroundPanX;
        float f2 = Float.isNaN(this.mBackgroundPanY) ? 0.0f : this.mBackgroundPanY;
        float f3 = Float.isNaN(this.mZoom) ? 1.0f : this.mZoom;
        float f4 = Float.isNaN(this.mRotate) ? 0.0f : this.mRotate;
        this.getSupportButtonTintMode.reset();
        float width = this.NetworkUserEntityData$$ExternalSyntheticLambda5.getWidth();
        float height = this.NetworkUserEntityData$$ExternalSyntheticLambda5.getHeight();
        float f5 = Float.isNaN(this.C) ? this.lookAheadTest : this.C;
        float f6 = Float.isNaN(this.B) ? this.moveToNextValue : this.B;
        float f7 = f3 * (width * f6 < height * f5 ? f5 / width : f6 / height);
        this.getSupportButtonTintMode.postScale(f7, f7);
        float f8 = width * f7;
        float f9 = f5 - f8;
        float f10 = f7 * height;
        float f11 = f6 - f10;
        if (!Float.isNaN(this.B)) {
            f11 = this.B / 2.0f;
        }
        if (!Float.isNaN(this.C)) {
            f9 = this.C / 2.0f;
        }
        this.getSupportButtonTintMode.postTranslate((((f * f9) + f5) - f8) * 0.5f, (((f2 * f11) + f6) - f10) * 0.5f);
        this.getSupportButtonTintMode.postRotate(f4, f5 / 2.0f, f6 / 2.0f);
        this.SubSequence.setLocalMatrix(this.getSupportButtonTintMode);
    }

    public float getTextPanX() {
        return this.readMicros;
    }

    public void setTextPanX(float f) {
        this.readMicros = f;
        invalidate();
    }

    public float getTextPanY() {
        return this.getCallingPid;
    }

    public void setTextPanY(float f) {
        this.getCallingPid = f;
        invalidate();
    }

    public float getTextureHeight() {
        return this.B;
    }

    public void setTextureHeight(float f) {
        this.B = f;
        KClassImpl$Data$declaredNonStaticMembers$2();
        invalidate();
    }

    public float getTextureWidth() {
        return this.C;
    }

    public void setTextureWidth(float f) {
        this.C = f;
        KClassImpl$Data$declaredNonStaticMembers$2();
        invalidate();
    }

    public float getScaleFromTextSize() {
        return this.getAuthRequestContext;
    }

    public void setScaleFromTextSize(float f) {
        this.getAuthRequestContext = f;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003f -> B:15:0x0044). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray r10, int r11) {
        /*
            byte[] r0 = androidx.constraintlayout.utils.widget.MotionLabel.KClassImpl$Data$declaredNonStaticMembers$2
            r1 = 23
            byte[] r1 = new byte[r1]
            r2 = 22
            r3 = 0
            r4 = 4
            if (r0 != 0) goto L15
            r5 = r1
            r6 = 4
            r7 = 22
            r8 = 0
            r1 = r0
            r0 = r11
            r11 = r10
            goto L44
        L15:
            r5 = 97
            r4 = r1
            r6 = 4
            r7 = 0
            r1 = r0
            r0 = r11
            r11 = r10
        L1d:
            byte r8 = (byte) r5
            r4[r7] = r8
            int r8 = r7 + 1
            if (r7 != r2) goto L3f
            java.lang.String r1 = new java.lang.String
            r1.<init>(r4, r3)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r10 = r1.isInstance(r10)
            if (r10 == 0) goto L3a
            android.content.Context r11 = (android.content.Context) r11
            android.graphics.drawable.Drawable r10 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r11, r0)
            return r10
        L3a:
            android.graphics.drawable.Drawable r10 = r11.getDrawable(r0)
            return r10
        L3f:
            r7 = r1[r6]
            r9 = r5
            r5 = r4
            r4 = r9
        L44:
            int r7 = -r7
            int r4 = r4 + r7
            int r6 = r6 + 1
            int r4 = r4 + (-8)
            r7 = r8
            r9 = r5
            r5 = r4
            r4 = r9
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.utils.widget.MotionLabel.__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }
}
