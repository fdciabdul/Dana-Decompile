package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import com.fullstory.instrumentation.FSDraw;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class WrappedDrawableApi14 extends Drawable implements Drawable.Callback, WrappedDrawable, TintAwareDrawable, FSDraw {
    static final PorterDuff.Mode MyBillsEntityDataFactory = PorterDuff.Mode.SRC_IN;
    private boolean BuiltInFictitiousFunctionClassFactory;
    Drawable KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    private int PlaceComponentResult;
    WrappedDrawableState getAuthRequestContext;
    private PorterDuff.Mode getErrorConfigVersion;

    protected boolean getAuthRequestContext() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WrappedDrawableApi14(WrappedDrawableState wrappedDrawableState, Resources resources) {
        this.getAuthRequestContext = wrappedDrawableState;
        KClassImpl$Data$declaredNonStaticMembers$2(resources);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WrappedDrawableApi14(Drawable drawable) {
        this.getAuthRequestContext = MyBillsEntityDataFactory();
        PlaceComponentResult(drawable);
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(Resources resources) {
        WrappedDrawableState wrappedDrawableState = this.getAuthRequestContext;
        if (wrappedDrawableState == null || wrappedDrawableState.MyBillsEntityDataFactory == null) {
            return;
        }
        PlaceComponentResult(this.getAuthRequestContext.MyBillsEntityDataFactory.newDrawable(resources));
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        WrappedDrawableState wrappedDrawableState = this.getAuthRequestContext;
        return changingConfigurations | (wrappedDrawableState != null ? wrappedDrawableState.getChangingConfigurations() : 0) | this.KClassImpl$Data$declaredNonStaticMembers$2.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        WrappedDrawableState wrappedDrawableState;
        ColorStateList colorStateList = (!getAuthRequestContext() || (wrappedDrawableState = this.getAuthRequestContext) == null) ? null : wrappedDrawableState.getAuthRequestContext;
        return (colorStateList != null && colorStateList.isStateful()) || this.KClassImpl$Data$declaredNonStaticMembers$2.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return getAuthRequestContext(iArr) || this.KClassImpl$Data$declaredNonStaticMembers$2.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.KClassImpl$Data$declaredNonStaticMembers$2.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        DrawableCompat.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return DrawableCompat.NetworkUserEntityData$$ExternalSyntheticLambda0(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        return DrawableCompat.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2, i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getLayoutDirection() {
        return DrawableCompat.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        WrappedDrawableState wrappedDrawableState = this.getAuthRequestContext;
        if (wrappedDrawableState == null || !wrappedDrawableState.PlaceComponentResult()) {
            return null;
        }
        this.getAuthRequestContext.PlaceComponentResult = getChangingConfigurations();
        return this.getAuthRequestContext;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0 && super.mutate() == this) {
            this.getAuthRequestContext = MyBillsEntityDataFactory();
            Drawable drawable = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (drawable != null) {
                drawable.mutate();
            }
            WrappedDrawableState wrappedDrawableState = this.getAuthRequestContext;
            if (wrappedDrawableState != null) {
                Drawable drawable2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                wrappedDrawableState.MyBillsEntityDataFactory = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        }
        return this;
    }

    private WrappedDrawableState MyBillsEntityDataFactory() {
        return new WrappedDrawableState(this.getAuthRequestContext);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        this.getAuthRequestContext.getAuthRequestContext = colorStateList;
        getAuthRequestContext(getState());
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory = mode;
        getAuthRequestContext(getState());
    }

    private boolean getAuthRequestContext(int[] iArr) {
        if (getAuthRequestContext()) {
            ColorStateList colorStateList = this.getAuthRequestContext.getAuthRequestContext;
            PorterDuff.Mode mode = this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory;
            if (colorStateList != null && mode != null) {
                int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
                if (!this.BuiltInFictitiousFunctionClassFactory || colorForState != this.PlaceComponentResult || mode != this.getErrorConfigVersion) {
                    setColorFilter(colorForState, mode);
                    this.PlaceComponentResult = colorForState;
                    this.getErrorConfigVersion = mode;
                    this.BuiltInFictitiousFunctionClassFactory = true;
                    return true;
                }
            } else {
                this.BuiltInFictitiousFunctionClassFactory = false;
                clearColorFilter();
            }
            return false;
        }
        return false;
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawable
    public final Drawable PlaceComponentResult() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawable
    public final void PlaceComponentResult(Drawable drawable) {
        Drawable drawable2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            WrappedDrawableState wrappedDrawableState = this.getAuthRequestContext;
            if (wrappedDrawableState != null) {
                wrappedDrawableState.MyBillsEntityDataFactory = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }
}
