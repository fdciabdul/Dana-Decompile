package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes3.dex */
public abstract class DrawableResource<T extends Drawable> implements Resource<T>, Initializable {
    protected final T BuiltInFictitiousFunctionClassFactory;

    public DrawableResource(T t) {
        this.BuiltInFictitiousFunctionClassFactory = (T) Preconditions.PlaceComponentResult(t);
    }

    public void BuiltInFictitiousFunctionClassFactory() {
        T t = this.BuiltInFictitiousFunctionClassFactory;
        if (t instanceof BitmapDrawable) {
            ((BitmapDrawable) t).getBitmap().prepareToDraw();
        } else if (t instanceof GifDrawable) {
            ((GifDrawable) t).BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.PlaceComponentResult.prepareToDraw();
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final /* synthetic */ Object getAuthRequestContext() {
        Drawable.ConstantState constantState = this.BuiltInFictitiousFunctionClassFactory.getConstantState();
        if (constantState == null) {
            return this.BuiltInFictitiousFunctionClassFactory;
        }
        return constantState.newDrawable();
    }
}
