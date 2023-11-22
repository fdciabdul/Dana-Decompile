package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.fullstory.instrumentation.FSDraw;

/* loaded from: classes3.dex */
class RoundRectDrawable extends Drawable implements FSDraw {
    float BuiltInFictitiousFunctionClassFactory;
    ColorStateList KClassImpl$Data$declaredNonStaticMembers$2;
    private ColorStateList NetworkUserEntityData$$ExternalSyntheticLambda0;
    float getAuthRequestContext;
    private PorterDuffColorFilter lookAheadTest;
    private final RectF moveToNextValue;
    private final Rect scheduleImpl;
    boolean MyBillsEntityDataFactory = false;
    boolean PlaceComponentResult = true;
    private PorterDuff.Mode initRecordTimeStamp = PorterDuff.Mode.SRC_IN;
    private final Paint getErrorConfigVersion = new Paint(5);

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RoundRectDrawable(ColorStateList colorStateList, float f) {
        this.BuiltInFictitiousFunctionClassFactory = f;
        BuiltInFictitiousFunctionClassFactory(colorStateList);
        this.moveToNextValue = new RectF();
        this.scheduleImpl = new Rect();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void BuiltInFictitiousFunctionClassFactory(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = colorStateList;
        this.getErrorConfigVersion.setColor(colorStateList.getColorForState(getState(), this.KClassImpl$Data$declaredNonStaticMembers$2.getDefaultColor()));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.getErrorConfigVersion;
        if (this.lookAheadTest == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.lookAheadTest);
            z = true;
        }
        RectF rectF = this.moveToNextValue;
        float f = this.BuiltInFictitiousFunctionClassFactory;
        canvas.drawRoundRect(rectF, f, f, paint);
        if (z) {
            paint.setColorFilter(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.moveToNextValue.set(rect.left, rect.top, rect.right, rect.bottom);
        this.scheduleImpl.set(rect);
        if (this.MyBillsEntityDataFactory) {
            this.scheduleImpl.inset((int) Math.ceil(RoundRectDrawableWithShadow.PlaceComponentResult(this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult)), (int) Math.ceil(RoundRectDrawableWithShadow.MyBillsEntityDataFactory(this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult)));
            this.moveToNextValue.set(this.scheduleImpl);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        KClassImpl$Data$declaredNonStaticMembers$2(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.scheduleImpl, this.BuiltInFictitiousFunctionClassFactory);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.getErrorConfigVersion.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.getErrorConfigVersion.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = colorStateList;
        PorterDuff.Mode mode = this.initRecordTimeStamp;
        this.lookAheadTest = (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.initRecordTimeStamp = mode;
        ColorStateList colorStateList = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        this.lookAheadTest = (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z = colorForState != this.getErrorConfigVersion.getColor();
        if (z) {
            this.getErrorConfigVersion.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (colorStateList2 == null || (mode = this.initRecordTimeStamp) == null) {
            return z;
        }
        this.lookAheadTest = (colorStateList2 == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList2.getColorForState(getState(), 0), mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.KClassImpl$Data$declaredNonStaticMembers$2) != null && colorStateList.isStateful()) || super.isStateful();
    }
}
