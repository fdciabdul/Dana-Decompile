package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class WrappedDrawableState extends Drawable.ConstantState {
    PorterDuff.Mode BuiltInFictitiousFunctionClassFactory;
    Drawable.ConstantState MyBillsEntityDataFactory;
    int PlaceComponentResult;
    ColorStateList getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WrappedDrawableState(WrappedDrawableState wrappedDrawableState) {
        this.getAuthRequestContext = null;
        this.BuiltInFictitiousFunctionClassFactory = WrappedDrawableApi14.MyBillsEntityDataFactory;
        if (wrappedDrawableState != null) {
            this.PlaceComponentResult = wrappedDrawableState.PlaceComponentResult;
            this.MyBillsEntityDataFactory = wrappedDrawableState.MyBillsEntityDataFactory;
            this.getAuthRequestContext = wrappedDrawableState.getAuthRequestContext;
            this.BuiltInFictitiousFunctionClassFactory = wrappedDrawableState.BuiltInFictitiousFunctionClassFactory;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new WrappedDrawableApi21(this, resources);
        }
        return new WrappedDrawableApi14(this, resources);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        int i = this.PlaceComponentResult;
        Drawable.ConstantState constantState = this.MyBillsEntityDataFactory;
        return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean PlaceComponentResult() {
        return this.MyBillsEntityDataFactory != null;
    }
}
