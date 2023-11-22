package id.dana.core.ui.richview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import androidx.core.text.TextUtilsCompat;
import androidx.core.view.ViewCompat;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.google.common.base.Ascii;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import id.dana.core.ui.R;
import java.util.Locale;

/* loaded from: classes4.dex */
public class PinEntryEditText extends AppCompatEditText {
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    private boolean PlaceComponentResult;
    protected boolean animate;
    protected int animatedType;
    protected float[] charBottom;
    protected Paint charPaint;
    protected float charSize;
    protected View.OnClickListener clickListener;
    protected ColorStateList colorStates;
    protected boolean digitSquare;
    private final Handler getAuthRequestContext;
    private boolean getErrorConfigVersion;
    protected boolean hasError;
    protected Paint lastCharPaint;
    protected RectF[] lineCoords;
    protected float lineStroke;
    protected float lineStrokeSelected;
    protected Paint linesPaint;
    protected int[] listColors;
    protected IOnBackButtonListener listener;
    private final Runnable lookAheadTest;
    protected String mask;
    protected StringBuilder maskChars;
    protected int maxLength;
    protected float numChars;
    protected OnPinEnteredListener onPinEnteredListener;
    protected ColorStateList originalTextColors;
    protected Drawable pinBackground;
    private boolean scheduleImpl;
    protected String singleCharHint;
    protected Paint singleCharPaint;
    protected float space;
    protected int[][] states;
    protected float textBottomPadding;
    protected Rect textHeight;
    public static final byte[] MyBillsEntityDataFactory = {75, -120, 119, 39, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int BuiltInFictitiousFunctionClassFactory = 248;

    /* loaded from: classes4.dex */
    public interface IOnBackButtonListener {
        boolean PlaceComponentResult();
    }

    /* loaded from: classes4.dex */
    public interface OnPinEnteredListener {

        /* renamed from: id.dana.core.ui.richview.PinEntryEditText$OnPinEnteredListener$-CC  reason: invalid class name */
        /* loaded from: classes4.dex */
        public final /* synthetic */ class CC {
            public static void MyBillsEntityDataFactory() {
            }
        }

        void MyBillsEntityDataFactory();

        void getAuthRequestContext(CharSequence charSequence);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$id-dana-core-ui-richview-PinEntryEditText  reason: not valid java name */
    public /* synthetic */ void m619lambda$new$0$iddanacoreuirichviewPinEntryEditText() {
        this.scheduleImpl = false;
        invalidate();
    }

    public PinEntryEditText(Context context) {
        super(context);
        this.mask = null;
        this.maskChars = null;
        this.singleCharHint = null;
        this.animatedType = 0;
        this.space = 24.0f;
        this.numChars = 4.0f;
        this.textBottomPadding = 8.0f;
        this.maxLength = 4;
        this.textHeight = new Rect();
        this.digitSquare = false;
        this.onPinEnteredListener = null;
        this.lineStroke = 1.0f;
        this.lineStrokeSelected = 2.0f;
        this.animate = false;
        this.hasError = false;
        this.states = new int[][]{new int[]{16842913}, new int[]{16842914}, new int[]{16842908}, new int[]{-16842908}};
        this.listColors = new int[]{-16711936, -65536, -16777216, -7829368};
        this.colorStates = new ColorStateList(this.states, this.listColors);
        this.getAuthRequestContext = new Handler(Looper.getMainLooper());
        this.lookAheadTest = new Runnable() { // from class: id.dana.core.ui.richview.PinEntryEditText$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                PinEntryEditText.this.m619lambda$new$0$iddanacoreuirichviewPinEntryEditText();
            }
        };
        this.scheduleImpl = true;
    }

    public PinEntryEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mask = null;
        this.maskChars = null;
        this.singleCharHint = null;
        this.animatedType = 0;
        this.space = 24.0f;
        this.numChars = 4.0f;
        this.textBottomPadding = 8.0f;
        this.maxLength = 4;
        this.textHeight = new Rect();
        this.digitSquare = false;
        this.onPinEnteredListener = null;
        this.lineStroke = 1.0f;
        this.lineStrokeSelected = 2.0f;
        this.animate = false;
        this.hasError = false;
        this.states = new int[][]{new int[]{16842913}, new int[]{16842914}, new int[]{16842908}, new int[]{-16842908}};
        this.listColors = new int[]{-16711936, -65536, -16777216, -7829368};
        this.colorStates = new ColorStateList(this.states, this.listColors);
        this.getAuthRequestContext = new Handler(Looper.getMainLooper());
        this.lookAheadTest = new Runnable() { // from class: id.dana.core.ui.richview.PinEntryEditText$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                PinEntryEditText.this.m619lambda$new$0$iddanacoreuirichviewPinEntryEditText();
            }
        };
        this.scheduleImpl = true;
        KClassImpl$Data$declaredNonStaticMembers$2(context, attributeSet);
    }

    public PinEntryEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mask = null;
        this.maskChars = null;
        this.singleCharHint = null;
        this.animatedType = 0;
        this.space = 24.0f;
        this.numChars = 4.0f;
        this.textBottomPadding = 8.0f;
        this.maxLength = 4;
        this.textHeight = new Rect();
        this.digitSquare = false;
        this.onPinEnteredListener = null;
        this.lineStroke = 1.0f;
        this.lineStrokeSelected = 2.0f;
        this.animate = false;
        this.hasError = false;
        this.states = new int[][]{new int[]{16842913}, new int[]{16842914}, new int[]{16842908}, new int[]{-16842908}};
        this.listColors = new int[]{-16711936, -65536, -16777216, -7829368};
        this.colorStates = new ColorStateList(this.states, this.listColors);
        this.getAuthRequestContext = new Handler(Looper.getMainLooper());
        this.lookAheadTest = new Runnable() { // from class: id.dana.core.ui.richview.PinEntryEditText$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                PinEntryEditText.this.m619lambda$new$0$iddanacoreuirichviewPinEntryEditText();
            }
        };
        this.scheduleImpl = true;
        KClassImpl$Data$declaredNonStaticMembers$2(context, attributeSet);
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(Context context, AttributeSet attributeSet) {
        float f = context.getResources().getDisplayMetrics().density;
        this.lineStroke *= f;
        this.lineStrokeSelected *= f;
        this.space *= f;
        this.textBottomPadding = f * this.textBottomPadding;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.encodingStream, 0, 0);
        try {
            TypedValue typedValue = new TypedValue();
            obtainStyledAttributes.getValue(R.styleable.getRawPath, typedValue);
            this.animatedType = typedValue.data;
            this.mask = obtainStyledAttributes.getString(R.styleable.getTextEndPadding);
            this.singleCharHint = obtainStyledAttributes.getString(R.styleable.SecuritySettingsActivity$createPinLauncher$2$1);
            this.lineStroke = obtainStyledAttributes.getDimension(R.styleable.isInfoWindowShown, this.lineStroke);
            this.lineStrokeSelected = obtainStyledAttributes.getDimension(R.styleable.applyTrimPathIfNeeded, this.lineStrokeSelected);
            this.space = obtainStyledAttributes.getDimension(R.styleable.SecuritySettingsActivity$createPinLauncher$2$2, this.space);
            this.textBottomPadding = obtainStyledAttributes.getDimension(R.styleable.ArrayTable$3, this.textBottomPadding);
            this.digitSquare = obtainStyledAttributes.getBoolean(R.styleable.useDaemonThreadFactory, this.digitSquare);
            this.pinBackground = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, R.styleable.WrappedDrawableState);
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.BaseSocialFeedContract$Presenter);
            if (colorStateList != null) {
                this.colorStates = colorStateList;
            }
            obtainStyledAttributes.recycle();
            this.charPaint = new Paint(getPaint());
            this.lastCharPaint = new Paint(getPaint());
            this.singleCharPaint = new Paint(getPaint());
            Paint paint = new Paint(getPaint());
            this.linesPaint = paint;
            paint.setStrokeWidth(this.lineStroke);
            TypedValue typedValue2 = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.getAuthRequestContext, typedValue2, true);
            this.listColors[0] = typedValue2.data;
            this.listColors[1] = isInEditMode() ? -7829368 : ContextCompat.BuiltInFictitiousFunctionClassFactory(context, R.color.MyBillsEntityDataFactory);
            this.listColors[2] = isInEditMode() ? -7829368 : ContextCompat.BuiltInFictitiousFunctionClassFactory(context, R.color.MyBillsEntityDataFactory);
            setBackgroundResource(0);
            int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", SecurityConstants.KEY_MAXLENGTH, 4);
            this.maxLength = attributeIntValue;
            this.numChars = attributeIntValue;
            super.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: id.dana.core.ui.richview.PinEntryEditText.1
                @Override // android.view.ActionMode.Callback
                public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                    return false;
                }

                @Override // android.view.ActionMode.Callback
                public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                    return false;
                }

                @Override // android.view.ActionMode.Callback
                public void onDestroyActionMode(ActionMode actionMode) {
                }

                @Override // android.view.ActionMode.Callback
                public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                    return false;
                }
            });
            super.setOnClickListener(new View.OnClickListener() { // from class: id.dana.core.ui.richview.PinEntryEditText$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PinEntryEditText.this.m617lambda$init$1$iddanacoreuirichviewPinEntryEditText(view);
                }
            });
            super.setOnLongClickListener(new View.OnLongClickListener() { // from class: id.dana.core.ui.richview.PinEntryEditText$$ExternalSyntheticLambda3
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return PinEntryEditText.this.m618lambda$init$2$iddanacoreuirichviewPinEntryEditText(view);
                }
            });
            if ((getInputType() & 128) == 128 || (getInputType() & 16) == 16 || (getInputType() & 144) == 144) {
                setTransformationMethod(PasswordTransformationMethod.getInstance());
                if (TextUtils.isEmpty(this.mask)) {
                    this.mask = "●";
                }
            }
            if (!TextUtils.isEmpty(this.mask)) {
                this.maskChars = KClassImpl$Data$declaredNonStaticMembers$2();
            }
            getPaint().getTextBounds(HiAnalyticsConstant.REPORT_VAL_SEPARATOR, 0, 1, this.textHeight);
            this.animate = this.animatedType >= 0;
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$init$1$id-dana-core-ui-richview-PinEntryEditText  reason: not valid java name */
    public /* synthetic */ void m617lambda$init$1$iddanacoreuirichviewPinEntryEditText(View view) {
        setSelectionLastChar();
        View.OnClickListener onClickListener = this.clickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$init$2$id-dana-core-ui-richview-PinEntryEditText  reason: not valid java name */
    public /* synthetic */ boolean m618lambda$init$2$iddanacoreuirichviewPinEntryEditText(View view) {
        setSelectionLastChar();
        return true;
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        super.setTextColor(i);
        MyBillsEntityDataFactory();
    }

    private void MyBillsEntityDataFactory() {
        int NetworkUserEntityData$$ExternalSyntheticLambda4;
        float f;
        ColorStateList textColors = getTextColors();
        this.originalTextColors = textColors;
        if (textColors != null) {
            this.lastCharPaint.setColor(textColors.getDefaultColor());
            this.charPaint.setColor(this.originalTextColors.getDefaultColor());
            this.singleCharPaint.setColor(getCurrentHintTextColor());
        }
        int width = (getWidth() - ViewCompat.NetworkUserEntityData$$ExternalSyntheticLambda6(this)) - ViewCompat.NetworkUserEntityData$$ExternalSyntheticLambda4(this);
        float f2 = this.space;
        if (f2 < 0.0f) {
            this.charSize = width / ((this.numChars * 2.0f) - 1.0f);
        } else {
            float f3 = this.numChars;
            this.charSize = (width - (f2 * (f3 - 1.0f))) / f3;
        }
        int i = (int) this.numChars;
        this.lineCoords = new RectF[i];
        this.charBottom = new float[i];
        int height = getHeight();
        int paddingBottom = getPaddingBottom();
        int i2 = 1;
        if (TextUtilsCompat.PlaceComponentResult(Locale.getDefault()) == 1) {
            i2 = -1;
            NetworkUserEntityData$$ExternalSyntheticLambda4 = (int) ((getWidth() - ViewCompat.NetworkUserEntityData$$ExternalSyntheticLambda4(this)) - this.charSize);
        } else {
            NetworkUserEntityData$$ExternalSyntheticLambda4 = ViewCompat.NetworkUserEntityData$$ExternalSyntheticLambda4(this);
        }
        for (int i3 = 0; i3 < this.numChars; i3++) {
            float f4 = NetworkUserEntityData$$ExternalSyntheticLambda4;
            float f5 = height - paddingBottom;
            this.lineCoords[i3] = new RectF(f4, f5, this.charSize + f4, f5);
            if (this.pinBackground != null) {
                if (this.digitSquare) {
                    this.lineCoords[i3].top = getPaddingTop();
                    RectF rectF = this.lineCoords[i3];
                    rectF.right = rectF.height() + f4;
                } else {
                    this.lineCoords[i3].top -= this.textHeight.height() + (this.textBottomPadding * 2.0f);
                }
            }
            float f6 = this.space;
            if (f6 < 0.0f) {
                f = f4 + (i2 * this.charSize * 2.0f);
            } else {
                f = f4 + (i2 * (this.charSize + f6));
            }
            NetworkUserEntityData$$ExternalSyntheticLambda4 = (int) f;
            this.charBottom[i3] = this.lineCoords[i3].bottom - this.textBottomPadding;
        }
    }

    public void setDigitSquare(boolean z) {
        this.digitSquare = z;
        invalidate();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.clickListener = onClickListener;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        MyBillsEntityDataFactory();
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        throw new RuntimeException("setCustomSelectionActionModeCallback() not supported.");
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        IOnBackButtonListener iOnBackButtonListener;
        if (keyEvent.getAction() == 1 && i == 4 && (iOnBackButtonListener = this.listener) != null && iOnBackButtonListener.PlaceComponentResult()) {
            return false;
        }
        return super.onKeyPreIme(i, keyEvent);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, final int i, int i2, int i3) {
        setError(false);
        OnPinEnteredListener onPinEnteredListener = this.onPinEnteredListener;
        if (onPinEnteredListener != null) {
            onPinEnteredListener.MyBillsEntityDataFactory();
            if (this.lineCoords == null || !this.animate) {
                if (charSequence.length() == this.maxLength) {
                    this.onPinEnteredListener.getAuthRequestContext(charSequence);
                    return;
                }
                return;
            }
        }
        int i4 = this.animatedType;
        if (i4 == -1) {
            invalidate();
        } else if (i3 > i2) {
            if (i4 == 0) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, getPaint().getTextSize());
                ofFloat.setDuration(200L);
                ofFloat.setInterpolator(new OvershootInterpolator());
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: id.dana.core.ui.richview.PinEntryEditText$$ExternalSyntheticLambda0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        PinEntryEditText.this.m616lambda$animatePopIn$3$iddanacoreuirichviewPinEntryEditText(valueAnimator);
                    }
                });
                if (getText().length() == this.maxLength && this.onPinEnteredListener != null) {
                    ofFloat.addListener(new Animator.AnimatorListener() { // from class: id.dana.core.ui.richview.PinEntryEditText.2
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            PinEntryEditText.this.onPinEnteredListener.getAuthRequestContext(PinEntryEditText.this.getText());
                        }
                    });
                }
                ofFloat.start();
                return;
            }
            this.charBottom[i] = this.lineCoords[i].bottom - this.textBottomPadding;
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(this.charBottom[i] + getPaint().getTextSize(), this.charBottom[i]);
            ofFloat2.setDuration(300L);
            ofFloat2.setInterpolator(new OvershootInterpolator());
            ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: id.dana.core.ui.richview.PinEntryEditText$$ExternalSyntheticLambda4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PinEntryEditText.this.m614xdd011e40(i, valueAnimator);
                }
            });
            this.lastCharPaint.setAlpha(255);
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 255);
            ofInt.setDuration(300L);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: id.dana.core.ui.richview.PinEntryEditText$$ExternalSyntheticLambda5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PinEntryEditText.this.m615xc2428d01(valueAnimator);
                }
            });
            AnimatorSet animatorSet = new AnimatorSet();
            if (charSequence.length() == this.maxLength && this.onPinEnteredListener != null) {
                animatorSet.addListener(new Animator.AnimatorListener() { // from class: id.dana.core.ui.richview.PinEntryEditText.3
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        PinEntryEditText.this.onPinEnteredListener.getAuthRequestContext(PinEntryEditText.this.getText());
                    }
                });
            }
            animatorSet.playTogether(ofFloat2, ofInt);
            animatorSet.start();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        maskLastPinCharacter();
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        maskLastPinCharacter();
    }

    public int getMaxLength() {
        return this.maxLength;
    }

    public void setMaxLength(int i) {
        this.maxLength = i;
        this.numChars = i;
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.maxLength)});
        MyBillsEntityDataFactory();
        invalidate();
    }

    public void showCharacters() {
        setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        this.getAuthRequestContext.removeCallbacks(this.lookAheadTest);
        invalidate();
        setSelectionLastChar();
    }

    public void hideCharacters() {
        setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        this.getAuthRequestContext.removeCallbacks(this.lookAheadTest);
        this.getErrorConfigVersion = false;
        this.PlaceComponentResult = true;
        invalidate();
        setSelectionLastChar();
    }

    public void setSelectionLastChar() {
        if (getText() == null || getText().length() < 0) {
            return;
        }
        setSelection(getText().length());
    }

    public void maskLastPinCharacter() {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
    }

    private StringBuilder KClassImpl$Data$declaredNonStaticMembers$2() {
        this.maskChars = new StringBuilder();
        int length = getText().length();
        for (int i = 0; i < length; i++) {
            if (i == length - 1 && !this.KClassImpl$Data$declaredNonStaticMembers$2 && !this.PlaceComponentResult) {
                this.maskChars.append(getText().charAt(i));
                this.getAuthRequestContext.removeCallbacks(this.lookAheadTest);
                this.getAuthRequestContext.postDelayed(this.lookAheadTest, 2000L);
            } else {
                this.maskChars.append(this.mask);
            }
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        if (this.PlaceComponentResult) {
            this.PlaceComponentResult = false;
        }
        if (!this.scheduleImpl) {
            if (this.maskChars.length() > 0) {
                StringBuilder sb = this.maskChars;
                sb.replace(sb.length() - 1, this.maskChars.length(), this.mask);
            }
            this.scheduleImpl = true;
            this.getErrorConfigVersion = false;
        } else if (!this.getErrorConfigVersion && this.maskChars.length() > 0) {
            this.getAuthRequestContext.removeCallbacks(this.lookAheadTest);
            this.getAuthRequestContext.postDelayed(this.lookAheadTest, 2000L);
            this.getErrorConfigVersion = true;
        }
        return this.maskChars;
    }

    protected void updateColorForLines(boolean z) {
        if (this.hasError) {
            this.linesPaint.setColor(this.colorStates.getColorForState(new int[]{16842914}, -7829368));
        } else if (isFocused()) {
            this.linesPaint.setStrokeWidth(this.lineStrokeSelected);
            this.linesPaint.setColor(this.colorStates.getColorForState(new int[]{16842908}, -7829368));
            if (z) {
                this.linesPaint.setColor(this.colorStates.getColorForState(new int[]{16842913}, -7829368));
            }
        } else {
            this.linesPaint.setStrokeWidth(this.lineStroke);
            this.linesPaint.setColor(this.colorStates.getColorForState(new int[]{-16842908}, -7829368));
        }
    }

    protected void updateDrawableState(boolean z, boolean z2) {
        if (this.hasError) {
            this.pinBackground.setState(new int[]{16842914});
        } else if (isFocused()) {
            this.pinBackground.setState(new int[]{16842908});
            if (z2) {
                this.pinBackground.setState(new int[]{16842908, 16842913});
            } else if (z) {
                this.pinBackground.setState(new int[]{16842908, 16842912});
            }
        } else {
            this.pinBackground.setState(new int[]{-16842908});
        }
    }

    public void setError(boolean z) {
        this.hasError = z;
    }

    public void focus() {
        requestFocus();
        ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$animatePopIn$3$id-dana-core-ui-richview-PinEntryEditText  reason: not valid java name */
    public /* synthetic */ void m616lambda$animatePopIn$3$iddanacoreuirichviewPinEntryEditText(ValueAnimator valueAnimator) {
        this.lastCharPaint.setTextSize(((Float) valueAnimator.getAnimatedValue()).floatValue());
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$animateBottomUp$4$id-dana-core-ui-richview-PinEntryEditText  reason: not valid java name */
    public /* synthetic */ void m614xdd011e40(int i, ValueAnimator valueAnimator) {
        this.charBottom[i] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$animateBottomUp$5$id-dana-core-ui-richview-PinEntryEditText  reason: not valid java name */
    public /* synthetic */ void m615xc2428d01(ValueAnimator valueAnimator) {
        this.lastCharPaint.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    public void setAnimateText(boolean z) {
        this.animate = z;
    }

    public void setOnPinEnteredListener(OnPinEnteredListener onPinEnteredListener) {
        this.onPinEnteredListener = onPinEnteredListener;
    }

    public void setOnBackButtonListener(IOnBackButtonListener iOnBackButtonListener) {
        this.listener = iOnBackButtonListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0041 -> B:15:0x004b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray r10, int r11) {
        /*
            byte[] r0 = id.dana.core.ui.richview.PinEntryEditText.MyBillsEntityDataFactory
            r1 = 23
            byte[] r1 = new byte[r1]
            r2 = 22
            r3 = 3
            r4 = 0
            if (r0 != 0) goto L15
            r5 = r1
            r6 = 3
            r7 = 22
            r8 = 0
            r1 = r0
            r0 = r11
            r11 = r10
            goto L4b
        L15:
            r5 = 97
            r3 = r1
            r5 = 3
            r6 = 97
            r7 = 0
            r1 = r0
            r0 = r11
            r11 = r10
        L1f:
            byte r8 = (byte) r6
            r3[r7] = r8
            int r5 = r5 + 1
            if (r7 != r2) goto L41
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3, r4)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r10 = r1.isInstance(r10)
            if (r10 == 0) goto L3c
            android.content.Context r11 = (android.content.Context) r11
            android.graphics.drawable.Drawable r10 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r11, r0)
            return r10
        L3c:
            android.graphics.drawable.Drawable r10 = r11.getDrawable(r0)
            return r10
        L41:
            r8 = r1[r5]
            int r7 = r7 + 1
            r9 = r5
            r5 = r3
            r3 = r8
            r8 = r7
            r7 = r6
            r6 = r9
        L4b:
            int r7 = r7 + r3
            int r3 = r7 + (-8)
            r7 = r8
            r9 = r6
            r6 = r3
            r3 = r5
            r5 = r9
            goto L1f
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.core.ui.richview.PinEntryEditText.__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        CharSequence KClassImpl$Data$declaredNonStaticMembers$2;
        float f;
        if (this.mask == null) {
            KClassImpl$Data$declaredNonStaticMembers$2 = getText();
        } else if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            KClassImpl$Data$declaredNonStaticMembers$2 = getText();
        } else {
            KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
        }
        int length = KClassImpl$Data$declaredNonStaticMembers$2.length();
        float[] fArr = new float[length];
        getPaint().getTextWidths(KClassImpl$Data$declaredNonStaticMembers$2, 0, length, fArr);
        String str = this.singleCharHint;
        float f2 = 0.0f;
        if (str != null) {
            int length2 = str.length();
            float[] fArr2 = new float[length2];
            getPaint().getTextWidths(this.singleCharHint, fArr2);
            for (int i = 0; i < length2; i++) {
                f2 += fArr2[i];
            }
            f = f2;
        } else {
            f = 0.0f;
        }
        int i2 = 0;
        while (i2 < this.numChars) {
            if (this.pinBackground != null) {
                updateDrawableState(i2 < length, i2 == length);
                this.pinBackground.setBounds((int) this.lineCoords[i2].left, (int) this.lineCoords[i2].top, (int) this.lineCoords[i2].right, (int) this.lineCoords[i2].bottom);
                this.pinBackground.draw(canvas);
            }
            float f3 = this.lineCoords[i2].left + (this.charSize / 2.0f);
            if (length > i2) {
                if (!this.animate || i2 != length - 1) {
                    canvas.drawText(KClassImpl$Data$declaredNonStaticMembers$2, i2, i2 + 1, f3 - (fArr[i2] / 2.0f), this.charBottom[i2], this.charPaint);
                } else {
                    canvas.drawText(KClassImpl$Data$declaredNonStaticMembers$2, i2, i2 + 1, f3 - (fArr[i2] / 2.0f), this.charBottom[i2], this.lastCharPaint);
                }
            } else {
                String str2 = this.singleCharHint;
                if (str2 != null) {
                    canvas.drawText(str2, f3 - (f / 2.0f), this.charBottom[i2], this.singleCharPaint);
                }
            }
            if (this.pinBackground == null) {
                updateColorForLines(i2 <= length);
                canvas.drawLine(this.lineCoords[i2].left, this.lineCoords[i2].bottom, this.lineCoords[i2].right, this.lineCoords[i2].bottom, this.linesPaint);
            }
            i2++;
        }
    }
}
