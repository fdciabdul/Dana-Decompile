package ru.noties.markwon.spans;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import com.fullstory.instrumentation.FSDraw;
import ru.noties.markwon.renderer.ImageSize;
import ru.noties.markwon.renderer.ImageSizeResolver;

/* loaded from: classes6.dex */
public class AsyncDrawable extends Drawable implements FSDraw {
    private Drawable.Callback BuiltInFictitiousFunctionClassFactory;
    int KClassImpl$Data$declaredNonStaticMembers$2;
    private final ImageSize MyBillsEntityDataFactory;
    private final ImageSizeResolver NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final String PlaceComponentResult;
    float getAuthRequestContext;
    private Drawable moveToNextValue;
    private final Loader scheduleImpl;

    /* loaded from: classes6.dex */
    public interface Loader {
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public AsyncDrawable(String str, Loader loader, ImageSizeResolver imageSizeResolver, ImageSize imageSize) {
        this.PlaceComponentResult = str;
        this.scheduleImpl = loader;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = imageSizeResolver;
        this.MyBillsEntityDataFactory = imageSize;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue != null;
    }

    public final void PlaceComponentResult() {
        this.BuiltInFictitiousFunctionClassFactory = null;
        super.setCallback(null);
        Drawable drawable = this.moveToNextValue;
        if (drawable != null) {
            drawable.setCallback(null);
            Drawable drawable2 = this.moveToNextValue;
            if (drawable2 instanceof Animatable) {
                ((Animatable) drawable2).stop();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (KClassImpl$Data$declaredNonStaticMembers$2()) {
            this.moveToNextValue.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (KClassImpl$Data$declaredNonStaticMembers$2()) {
            return this.moveToNextValue.getOpacity();
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (KClassImpl$Data$declaredNonStaticMembers$2()) {
            return this.moveToNextValue.getIntrinsicWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (KClassImpl$Data$declaredNonStaticMembers$2()) {
            return this.moveToNextValue.getIntrinsicHeight();
        }
        return 0;
    }
}
