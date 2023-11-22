package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.Method;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class WrappedDrawableApi21 extends WrappedDrawableApi14 {
    private static Method PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WrappedDrawableApi21(Drawable drawable) {
        super(drawable);
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WrappedDrawableApi21(WrappedDrawableState wrappedDrawableState, Resources resources) {
        super(wrappedDrawableState, resources);
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.setHotspot(f, f2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.getDirtyBounds();
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        if (getAuthRequestContext()) {
            super.setTintList(colorStateList);
        } else {
            this.KClassImpl$Data$declaredNonStaticMembers$2.setTintList(colorStateList);
        }
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int i) {
        if (getAuthRequestContext()) {
            super.setTint(i);
        } else {
            this.KClassImpl$Data$declaredNonStaticMembers$2.setTint(i);
        }
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (getAuthRequestContext()) {
            super.setTintMode(mode);
        } else {
            this.KClassImpl$Data$declaredNonStaticMembers$2.setTintMode(mode);
        }
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        if (super.setState(iArr)) {
            invalidateSelf();
            return true;
        }
        return false;
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14
    protected boolean getAuthRequestContext() {
        if (Build.VERSION.SDK_INT == 21) {
            Drawable drawable = this.KClassImpl$Data$declaredNonStaticMembers$2;
            return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        Method method;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null && (method = PlaceComponentResult) != null) {
            try {
                return ((Boolean) method.invoke(this.KClassImpl$Data$declaredNonStaticMembers$2, new Object[0])).booleanValue();
            } catch (Exception e) {
                InstrumentInjector.log_w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", e);
            }
        }
        return false;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2() {
        if (PlaceComponentResult == null) {
            try {
                PlaceComponentResult = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception e) {
                InstrumentInjector.log_w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e);
            }
        }
    }
}
