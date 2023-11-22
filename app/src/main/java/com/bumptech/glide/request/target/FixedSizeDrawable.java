package com.bumptech.glide.request.target;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.util.Preconditions;
import com.fullstory.instrumentation.FSDraw;

/* loaded from: classes7.dex */
public class FixedSizeDrawable extends Drawable implements FSDraw {
    private Drawable BuiltInFictitiousFunctionClassFactory;
    private State KClassImpl$Data$declaredNonStaticMembers$2;
    private final Matrix MyBillsEntityDataFactory;
    private final RectF PlaceComponentResult;
    private boolean getAuthRequestContext;
    private final RectF scheduleImpl;

    public FixedSizeDrawable(Drawable drawable, int i, int i2) {
        this(new State(drawable.getConstantState(), i, i2), drawable);
    }

    FixedSizeDrawable(State state, Drawable drawable) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (State) Preconditions.PlaceComponentResult(state);
        this.BuiltInFictitiousFunctionClassFactory = (Drawable) Preconditions.PlaceComponentResult(drawable);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.MyBillsEntityDataFactory = new Matrix();
        this.scheduleImpl = new RectF(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.PlaceComponentResult = new RectF();
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.PlaceComponentResult.set(i, i2, i3, i4);
        this.MyBillsEntityDataFactory.setRectToRect(this.scheduleImpl, this.PlaceComponentResult, Matrix.ScaleToFit.CENTER);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        super.setBounds(rect);
        this.PlaceComponentResult.set(rect);
        this.MyBillsEntityDataFactory.setRectToRect(this.scheduleImpl, this.PlaceComponentResult, Matrix.ScaleToFit.CENTER);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        this.BuiltInFictitiousFunctionClassFactory.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.BuiltInFictitiousFunctionClassFactory.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated
    public void setDither(boolean z) {
        this.BuiltInFictitiousFunctionClassFactory.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.BuiltInFictitiousFunctionClassFactory.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.Callback getCallback() {
        return this.BuiltInFictitiousFunctionClassFactory.getCallback();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.BuiltInFictitiousFunctionClassFactory.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, PorterDuff.Mode mode) {
        this.BuiltInFictitiousFunctionClassFactory.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.BuiltInFictitiousFunctionClassFactory.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.BuiltInFictitiousFunctionClassFactory.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return this.BuiltInFictitiousFunctionClassFactory.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.BuiltInFictitiousFunctionClassFactory.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.BuiltInFictitiousFunctionClassFactory.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.BuiltInFictitiousFunctionClassFactory.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        this.BuiltInFictitiousFunctionClassFactory.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        super.unscheduleSelf(runnable);
        this.BuiltInFictitiousFunctionClassFactory.unscheduleSelf(runnable);
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        super.scheduleSelf(runnable, j);
        this.BuiltInFictitiousFunctionClassFactory.scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.save();
        canvas.concat(this.MyBillsEntityDataFactory);
        this.BuiltInFictitiousFunctionClassFactory.draw(canvas);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.BuiltInFictitiousFunctionClassFactory.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.BuiltInFictitiousFunctionClassFactory.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.BuiltInFictitiousFunctionClassFactory.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.getAuthRequestContext && super.mutate() == this) {
            this.BuiltInFictitiousFunctionClassFactory = this.BuiltInFictitiousFunctionClassFactory.mutate();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new State(this.KClassImpl$Data$declaredNonStaticMembers$2);
            this.getAuthRequestContext = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* loaded from: classes7.dex */
    static final class State extends Drawable.ConstantState {
        final int BuiltInFictitiousFunctionClassFactory;
        final int PlaceComponentResult;
        private final Drawable.ConstantState getAuthRequestContext;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return 0;
        }

        State(State state) {
            this(state.getAuthRequestContext, state.BuiltInFictitiousFunctionClassFactory, state.PlaceComponentResult);
        }

        State(Drawable.ConstantState constantState, int i, int i2) {
            this.getAuthRequestContext = constantState;
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.PlaceComponentResult = i2;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            return new FixedSizeDrawable(this, this.getAuthRequestContext.newDrawable());
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            return new FixedSizeDrawable(this, this.getAuthRequestContext.newDrawable(resources));
        }
    }
}
