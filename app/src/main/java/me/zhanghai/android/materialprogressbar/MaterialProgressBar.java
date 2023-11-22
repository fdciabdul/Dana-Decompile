package me.zhanghai.android.materialprogressbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.appcompat.widget.TintTypedArray;
import com.fullstory.instrumentation.InstrumentInjector;
import me.zhanghai.android.materialprogressbar.internal.DrawableCompat;

/* loaded from: classes9.dex */
public class MaterialProgressBar extends ProgressBar {
    public static final int DETERMINATE_CIRCULAR_PROGRESS_STYLE_DYNAMIC = 1;
    public static final int DETERMINATE_CIRCULAR_PROGRESS_STYLE_NORMAL = 0;
    public static final int PROGRESS_STYLE_CIRCULAR = 0;
    public static final int PROGRESS_STYLE_HORIZONTAL = 1;
    private static final String TAG = "MaterialProgressBar";
    private int mProgressStyle;
    private final TintInfo mProgressTintInfo;
    private boolean mSuperInitialized;

    public MaterialProgressBar(Context context) {
        super(context);
        this.mSuperInitialized = true;
        this.mProgressTintInfo = new TintInfo();
        init(null, 0, 0);
    }

    public MaterialProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSuperInitialized = true;
        this.mProgressTintInfo = new TintInfo();
        init(attributeSet, 0, 0);
    }

    public MaterialProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSuperInitialized = true;
        this.mProgressTintInfo = new TintInfo();
        init(attributeSet, i, 0);
    }

    public MaterialProgressBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mSuperInitialized = true;
        this.mProgressTintInfo = new TintInfo();
        init(attributeSet, i, i2);
    }

    private void init(AttributeSet attributeSet, int i, int i2) {
        Context context = getContext();
        TintTypedArray authRequestContext = TintTypedArray.getAuthRequestContext(context, attributeSet, R.styleable.MaterialProgressBar, i, i2);
        this.mProgressStyle = authRequestContext.BuiltInFictitiousFunctionClassFactory.getInt(R.styleable.MaterialProgressBar_mpb_progressStyle, 0);
        boolean authRequestContext2 = authRequestContext.getAuthRequestContext(R.styleable.MaterialProgressBar_mpb_setBothDrawables, false);
        boolean authRequestContext3 = authRequestContext.getAuthRequestContext(R.styleable.MaterialProgressBar_mpb_useIntrinsicPadding, true);
        boolean authRequestContext4 = authRequestContext.getAuthRequestContext(R.styleable.MaterialProgressBar_mpb_showProgressBackground, this.mProgressStyle == 1);
        int i3 = authRequestContext.BuiltInFictitiousFunctionClassFactory.getInt(R.styleable.MaterialProgressBar_mpb_determinateCircularProgressStyle, 0);
        if (authRequestContext.getAuthRequestContext(R.styleable.MaterialProgressBar_mpb_progressTint)) {
            this.mProgressTintInfo.mProgressTint = authRequestContext.PlaceComponentResult(R.styleable.MaterialProgressBar_mpb_progressTint);
            this.mProgressTintInfo.mHasProgressTint = true;
        }
        if (authRequestContext.getAuthRequestContext(R.styleable.MaterialProgressBar_mpb_progressTintMode)) {
            this.mProgressTintInfo.mProgressTintMode = DrawableCompat.parseTintMode(authRequestContext.BuiltInFictitiousFunctionClassFactory.getInt(R.styleable.MaterialProgressBar_mpb_progressTintMode, -1), null);
            this.mProgressTintInfo.mHasProgressTintMode = true;
        }
        if (authRequestContext.getAuthRequestContext(R.styleable.MaterialProgressBar_mpb_secondaryProgressTint)) {
            this.mProgressTintInfo.mSecondaryProgressTint = authRequestContext.PlaceComponentResult(R.styleable.MaterialProgressBar_mpb_secondaryProgressTint);
            this.mProgressTintInfo.mHasSecondaryProgressTint = true;
        }
        if (authRequestContext.getAuthRequestContext(R.styleable.MaterialProgressBar_mpb_secondaryProgressTintMode)) {
            this.mProgressTintInfo.mSecondaryProgressTintMode = DrawableCompat.parseTintMode(authRequestContext.BuiltInFictitiousFunctionClassFactory.getInt(R.styleable.MaterialProgressBar_mpb_secondaryProgressTintMode, -1), null);
            this.mProgressTintInfo.mHasSecondaryProgressTintMode = true;
        }
        if (authRequestContext.getAuthRequestContext(R.styleable.MaterialProgressBar_mpb_progressBackgroundTint)) {
            this.mProgressTintInfo.mProgressBackgroundTint = authRequestContext.PlaceComponentResult(R.styleable.MaterialProgressBar_mpb_progressBackgroundTint);
            this.mProgressTintInfo.mHasProgressBackgroundTint = true;
        }
        if (authRequestContext.getAuthRequestContext(R.styleable.MaterialProgressBar_mpb_progressBackgroundTintMode)) {
            this.mProgressTintInfo.mProgressBackgroundTintMode = DrawableCompat.parseTintMode(authRequestContext.BuiltInFictitiousFunctionClassFactory.getInt(R.styleable.MaterialProgressBar_mpb_progressBackgroundTintMode, -1), null);
            this.mProgressTintInfo.mHasProgressBackgroundTintMode = true;
        }
        if (authRequestContext.getAuthRequestContext(R.styleable.MaterialProgressBar_mpb_indeterminateTint)) {
            this.mProgressTintInfo.mIndeterminateTint = authRequestContext.PlaceComponentResult(R.styleable.MaterialProgressBar_mpb_indeterminateTint);
            this.mProgressTintInfo.mHasIndeterminateTint = true;
        }
        if (authRequestContext.getAuthRequestContext(R.styleable.MaterialProgressBar_mpb_indeterminateTintMode)) {
            this.mProgressTintInfo.mIndeterminateTintMode = DrawableCompat.parseTintMode(authRequestContext.BuiltInFictitiousFunctionClassFactory.getInt(R.styleable.MaterialProgressBar_mpb_indeterminateTintMode, -1), null);
            this.mProgressTintInfo.mHasIndeterminateTintMode = true;
        }
        authRequestContext.BuiltInFictitiousFunctionClassFactory.recycle();
        int i4 = this.mProgressStyle;
        if (i4 == 0) {
            if ((isIndeterminate() || authRequestContext2) && !isInEditMode()) {
                setIndeterminateDrawable(new AnimationScaleIndeterminateCircularProgressDrawable(context));
            }
            if (!isIndeterminate() || authRequestContext2) {
                setProgressDrawable(new CircularProgressDrawable(i3, context));
            }
        } else if (i4 == 1) {
            if ((isIndeterminate() || authRequestContext2) && !isInEditMode()) {
                setIndeterminateDrawable(new IndeterminateHorizontalProgressDrawable(context));
            }
            if (!isIndeterminate() || authRequestContext2) {
                setProgressDrawable(new HorizontalProgressDrawable(context));
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown progress style: ");
            sb.append(this.mProgressStyle);
            throw new IllegalArgumentException(sb.toString());
        }
        setUseIntrinsicPadding(authRequestContext3);
        setShowProgressBackground(authRequestContext4);
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminate(boolean z) {
        synchronized (this) {
            super.setIndeterminate(z);
            if (this.mSuperInitialized && !(getCurrentDrawable() instanceof MaterialProgressDrawable)) {
                InstrumentInjector.log_w(TAG, "Current drawable is not a MaterialProgressDrawable, you may want to set app:mpb_setBothDrawables");
            }
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        fixCanvasScalingAndColorFilterWhenHardwareAccelerated();
    }

    private void fixCanvasScalingAndColorFilterWhenHardwareAccelerated() {
        if (Build.VERSION.SDK_INT >= 21 || !isHardwareAccelerated() || getLayerType() == 1) {
            return;
        }
        setLayerType(1, null);
    }

    public int getProgressStyle() {
        return this.mProgressStyle;
    }

    @Override // android.widget.ProgressBar
    public Drawable getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    public boolean getUseIntrinsicPadding() {
        Drawable currentDrawable = getCurrentDrawable();
        if (currentDrawable instanceof IntrinsicPaddingDrawable) {
            return ((IntrinsicPaddingDrawable) currentDrawable).getUseIntrinsicPadding();
        }
        return false;
    }

    public void setUseIntrinsicPadding(boolean z) {
        Drawable currentDrawable = getCurrentDrawable();
        if (currentDrawable instanceof IntrinsicPaddingDrawable) {
            ((IntrinsicPaddingDrawable) currentDrawable).setUseIntrinsicPadding(z);
        }
        Drawable indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable instanceof IntrinsicPaddingDrawable) {
            ((IntrinsicPaddingDrawable) indeterminateDrawable).setUseIntrinsicPadding(z);
        }
    }

    public boolean getShowProgressBackground() {
        Drawable currentDrawable = getCurrentDrawable();
        if (currentDrawable instanceof ShowBackgroundDrawable) {
            return ((ShowBackgroundDrawable) currentDrawable).getShowBackground();
        }
        return false;
    }

    public void setShowProgressBackground(boolean z) {
        Drawable currentDrawable = getCurrentDrawable();
        if (currentDrawable instanceof ShowBackgroundDrawable) {
            ((ShowBackgroundDrawable) currentDrawable).setShowBackground(z);
        }
        Drawable indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable instanceof ShowBackgroundDrawable) {
            ((ShowBackgroundDrawable) indeterminateDrawable).setShowBackground(z);
        }
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(Drawable drawable) {
        super.setProgressDrawable(drawable);
        if (this.mProgressTintInfo != null) {
            applyProgressTints();
        }
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(Drawable drawable) {
        super.setIndeterminateDrawable(drawable);
        if (this.mProgressTintInfo != null) {
            applyIndeterminateTint();
        }
    }

    @Override // android.widget.ProgressBar
    public ColorStateList getProgressTintList() {
        logProgressBarTintWarning();
        return getSupportProgressTintList();
    }

    @Override // android.widget.ProgressBar
    public void setProgressTintList(ColorStateList colorStateList) {
        logProgressBarTintWarning();
        setSupportProgressTintList(colorStateList);
    }

    @Override // android.widget.ProgressBar
    public PorterDuff.Mode getProgressTintMode() {
        logProgressBarTintWarning();
        return getSupportProgressTintMode();
    }

    @Override // android.widget.ProgressBar
    public void setProgressTintMode(PorterDuff.Mode mode) {
        logProgressBarTintWarning();
        setSupportProgressTintMode(mode);
    }

    @Override // android.widget.ProgressBar
    public ColorStateList getSecondaryProgressTintList() {
        logProgressBarTintWarning();
        return getSupportSecondaryProgressTintList();
    }

    @Override // android.widget.ProgressBar
    public void setSecondaryProgressTintList(ColorStateList colorStateList) {
        logProgressBarTintWarning();
        setSupportSecondaryProgressTintList(colorStateList);
    }

    @Override // android.widget.ProgressBar
    public PorterDuff.Mode getSecondaryProgressTintMode() {
        logProgressBarTintWarning();
        return getSupportSecondaryProgressTintMode();
    }

    @Override // android.widget.ProgressBar
    public void setSecondaryProgressTintMode(PorterDuff.Mode mode) {
        logProgressBarTintWarning();
        setSupportSecondaryProgressTintMode(mode);
    }

    @Override // android.widget.ProgressBar
    public ColorStateList getProgressBackgroundTintList() {
        logProgressBarTintWarning();
        return getSupportProgressBackgroundTintList();
    }

    @Override // android.widget.ProgressBar
    public void setProgressBackgroundTintList(ColorStateList colorStateList) {
        logProgressBarTintWarning();
        setSupportProgressBackgroundTintList(colorStateList);
    }

    @Override // android.widget.ProgressBar
    public PorterDuff.Mode getProgressBackgroundTintMode() {
        logProgressBarTintWarning();
        return getSupportProgressBackgroundTintMode();
    }

    @Override // android.widget.ProgressBar
    public void setProgressBackgroundTintMode(PorterDuff.Mode mode) {
        logProgressBarTintWarning();
        setSupportProgressBackgroundTintMode(mode);
    }

    @Override // android.widget.ProgressBar
    public ColorStateList getIndeterminateTintList() {
        logProgressBarTintWarning();
        return getSupportIndeterminateTintList();
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateTintList(ColorStateList colorStateList) {
        logProgressBarTintWarning();
        setSupportIndeterminateTintList(colorStateList);
    }

    @Override // android.widget.ProgressBar
    public PorterDuff.Mode getIndeterminateTintMode() {
        logProgressBarTintWarning();
        return getSupportIndeterminateTintMode();
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateTintMode(PorterDuff.Mode mode) {
        logProgressBarTintWarning();
        setSupportIndeterminateTintMode(mode);
    }

    private void logProgressBarTintWarning() {
        InstrumentInjector.log_w(TAG, "Non-support version of tint method called, this is error-prone and will crash below Lollipop if you are calling it as a method of ProgressBar instead of MaterialProgressBar");
    }

    public ColorStateList getSupportProgressTintList() {
        return this.mProgressTintInfo.mProgressTint;
    }

    public void setSupportProgressTintList(ColorStateList colorStateList) {
        this.mProgressTintInfo.mProgressTint = colorStateList;
        this.mProgressTintInfo.mHasProgressTint = true;
        applyPrimaryProgressTint();
    }

    public PorterDuff.Mode getSupportProgressTintMode() {
        return this.mProgressTintInfo.mProgressTintMode;
    }

    public void setSupportProgressTintMode(PorterDuff.Mode mode) {
        this.mProgressTintInfo.mProgressTintMode = mode;
        this.mProgressTintInfo.mHasProgressTintMode = true;
        applyPrimaryProgressTint();
    }

    public ColorStateList getSupportSecondaryProgressTintList() {
        return this.mProgressTintInfo.mSecondaryProgressTint;
    }

    public void setSupportSecondaryProgressTintList(ColorStateList colorStateList) {
        this.mProgressTintInfo.mSecondaryProgressTint = colorStateList;
        this.mProgressTintInfo.mHasSecondaryProgressTint = true;
        applySecondaryProgressTint();
    }

    public PorterDuff.Mode getSupportSecondaryProgressTintMode() {
        return this.mProgressTintInfo.mSecondaryProgressTintMode;
    }

    public void setSupportSecondaryProgressTintMode(PorterDuff.Mode mode) {
        this.mProgressTintInfo.mSecondaryProgressTintMode = mode;
        this.mProgressTintInfo.mHasSecondaryProgressTintMode = true;
        applySecondaryProgressTint();
    }

    public ColorStateList getSupportProgressBackgroundTintList() {
        return this.mProgressTintInfo.mProgressBackgroundTint;
    }

    public void setSupportProgressBackgroundTintList(ColorStateList colorStateList) {
        this.mProgressTintInfo.mProgressBackgroundTint = colorStateList;
        this.mProgressTintInfo.mHasProgressBackgroundTint = true;
        applyProgressBackgroundTint();
    }

    public PorterDuff.Mode getSupportProgressBackgroundTintMode() {
        return this.mProgressTintInfo.mProgressBackgroundTintMode;
    }

    public void setSupportProgressBackgroundTintMode(PorterDuff.Mode mode) {
        this.mProgressTintInfo.mProgressBackgroundTintMode = mode;
        this.mProgressTintInfo.mHasProgressBackgroundTintMode = true;
        applyProgressBackgroundTint();
    }

    public ColorStateList getSupportIndeterminateTintList() {
        return this.mProgressTintInfo.mIndeterminateTint;
    }

    public void setSupportIndeterminateTintList(ColorStateList colorStateList) {
        this.mProgressTintInfo.mIndeterminateTint = colorStateList;
        this.mProgressTintInfo.mHasIndeterminateTint = true;
        applyIndeterminateTint();
    }

    public PorterDuff.Mode getSupportIndeterminateTintMode() {
        return this.mProgressTintInfo.mIndeterminateTintMode;
    }

    public void setSupportIndeterminateTintMode(PorterDuff.Mode mode) {
        this.mProgressTintInfo.mIndeterminateTintMode = mode;
        this.mProgressTintInfo.mHasIndeterminateTintMode = true;
        applyIndeterminateTint();
    }

    private void applyProgressTints() {
        if (getProgressDrawable() == null) {
            return;
        }
        applyPrimaryProgressTint();
        applyProgressBackgroundTint();
        applySecondaryProgressTint();
    }

    private void applyPrimaryProgressTint() {
        Drawable tintTargetFromProgressDrawable;
        if (getProgressDrawable() == null) {
            return;
        }
        if ((this.mProgressTintInfo.mHasProgressTint || this.mProgressTintInfo.mHasProgressTintMode) && (tintTargetFromProgressDrawable = getTintTargetFromProgressDrawable(16908301, true)) != null) {
            applyTintForDrawable(tintTargetFromProgressDrawable, this.mProgressTintInfo.mProgressTint, this.mProgressTintInfo.mHasProgressTint, this.mProgressTintInfo.mProgressTintMode, this.mProgressTintInfo.mHasProgressTintMode);
        }
    }

    private void applySecondaryProgressTint() {
        Drawable tintTargetFromProgressDrawable;
        if (getProgressDrawable() == null) {
            return;
        }
        if ((this.mProgressTintInfo.mHasSecondaryProgressTint || this.mProgressTintInfo.mHasSecondaryProgressTintMode) && (tintTargetFromProgressDrawable = getTintTargetFromProgressDrawable(16908303, false)) != null) {
            applyTintForDrawable(tintTargetFromProgressDrawable, this.mProgressTintInfo.mSecondaryProgressTint, this.mProgressTintInfo.mHasSecondaryProgressTint, this.mProgressTintInfo.mSecondaryProgressTintMode, this.mProgressTintInfo.mHasSecondaryProgressTintMode);
        }
    }

    private void applyProgressBackgroundTint() {
        Drawable tintTargetFromProgressDrawable;
        if (getProgressDrawable() == null) {
            return;
        }
        if ((this.mProgressTintInfo.mHasProgressBackgroundTint || this.mProgressTintInfo.mHasProgressBackgroundTintMode) && (tintTargetFromProgressDrawable = getTintTargetFromProgressDrawable(16908288, false)) != null) {
            applyTintForDrawable(tintTargetFromProgressDrawable, this.mProgressTintInfo.mProgressBackgroundTint, this.mProgressTintInfo.mHasProgressBackgroundTint, this.mProgressTintInfo.mProgressBackgroundTintMode, this.mProgressTintInfo.mHasProgressBackgroundTintMode);
        }
    }

    private Drawable getTintTargetFromProgressDrawable(int i, boolean z) {
        Drawable progressDrawable = getProgressDrawable();
        if (progressDrawable == null) {
            return null;
        }
        progressDrawable.mutate();
        Drawable findDrawableByLayerId = progressDrawable instanceof LayerDrawable ? ((LayerDrawable) progressDrawable).findDrawableByLayerId(i) : null;
        return (findDrawableByLayerId == null && z) ? progressDrawable : findDrawableByLayerId;
    }

    private void applyIndeterminateTint() {
        Drawable indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable == null) {
            return;
        }
        if (this.mProgressTintInfo.mHasIndeterminateTint || this.mProgressTintInfo.mHasIndeterminateTintMode) {
            indeterminateDrawable.mutate();
            applyTintForDrawable(indeterminateDrawable, this.mProgressTintInfo.mIndeterminateTint, this.mProgressTintInfo.mHasIndeterminateTint, this.mProgressTintInfo.mIndeterminateTintMode, this.mProgressTintInfo.mHasIndeterminateTintMode);
        }
    }

    private void applyTintForDrawable(Drawable drawable, ColorStateList colorStateList, boolean z, PorterDuff.Mode mode, boolean z2) {
        if (z || z2) {
            if (z) {
                if (drawable instanceof TintableDrawable) {
                    ((TintableDrawable) drawable).setTintList(colorStateList);
                } else {
                    logDrawableTintWarning();
                    if (Build.VERSION.SDK_INT >= 21) {
                        drawable.setTintList(colorStateList);
                    }
                }
            }
            if (z2) {
                if (drawable instanceof TintableDrawable) {
                    ((TintableDrawable) drawable).setTintMode(mode);
                } else {
                    logDrawableTintWarning();
                    if (Build.VERSION.SDK_INT >= 21) {
                        drawable.setTintMode(mode);
                    }
                }
            }
            if (drawable.isStateful()) {
                drawable.setState(getDrawableState());
            }
        }
    }

    private void logDrawableTintWarning() {
        InstrumentInjector.log_w(TAG, "Drawable did not implement TintableDrawable, it won't be tinted below Lollipop");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class TintInfo {
        public boolean mHasIndeterminateTint;
        public boolean mHasIndeterminateTintMode;
        public boolean mHasProgressBackgroundTint;
        public boolean mHasProgressBackgroundTintMode;
        public boolean mHasProgressTint;
        public boolean mHasProgressTintMode;
        public boolean mHasSecondaryProgressTint;
        public boolean mHasSecondaryProgressTintMode;
        public ColorStateList mIndeterminateTint;
        public PorterDuff.Mode mIndeterminateTintMode;
        public ColorStateList mProgressBackgroundTint;
        public PorterDuff.Mode mProgressBackgroundTintMode;
        public ColorStateList mProgressTint;
        public PorterDuff.Mode mProgressTintMode;
        public ColorStateList mSecondaryProgressTint;
        public PorterDuff.Mode mSecondaryProgressTintMode;

        private TintInfo() {
        }
    }
}
