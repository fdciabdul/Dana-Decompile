package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import com.fullstory.instrumentation.FSDraw;

/* loaded from: classes.dex */
class ActionBarBackgroundDrawable extends Drawable implements FSDraw {
    final ActionBarContainer BuiltInFictitiousFunctionClassFactory;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public ActionBarBackgroundDrawable(ActionBarContainer actionBarContainer) {
        this.BuiltInFictitiousFunctionClassFactory = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.BuiltInFictitiousFunctionClassFactory.mIsSplit) {
            if (this.BuiltInFictitiousFunctionClassFactory.mSplitBackground != null) {
                this.BuiltInFictitiousFunctionClassFactory.mSplitBackground.draw(canvas);
                return;
            }
            return;
        }
        if (this.BuiltInFictitiousFunctionClassFactory.mBackground != null) {
            this.BuiltInFictitiousFunctionClassFactory.mBackground.draw(canvas);
        }
        if (this.BuiltInFictitiousFunctionClassFactory.mStackedBackground == null || !this.BuiltInFictitiousFunctionClassFactory.mIsStacked) {
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory.mStackedBackground.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.BuiltInFictitiousFunctionClassFactory.mIsSplit) {
            if (this.BuiltInFictitiousFunctionClassFactory.mSplitBackground != null) {
                Api21Impl.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.mBackground, outline);
            }
        } else if (this.BuiltInFictitiousFunctionClassFactory.mBackground != null) {
            Api21Impl.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.mBackground, outline);
        }
    }

    /* loaded from: classes6.dex */
    static class Api21Impl {
        private Api21Impl() {
        }

        public static void getAuthRequestContext(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }
    }
}
