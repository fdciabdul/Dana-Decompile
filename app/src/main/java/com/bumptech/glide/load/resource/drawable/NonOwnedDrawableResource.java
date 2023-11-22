package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.Resource;

/* loaded from: classes3.dex */
public final class NonOwnedDrawableResource extends DrawableResource<Drawable> {
    @Override // com.bumptech.glide.load.engine.Resource
    public final void lookAheadTest() {
    }

    public static Resource<Drawable> getAuthRequestContext(Drawable drawable) {
        if (drawable != null) {
            return new NonOwnedDrawableResource(drawable);
        }
        return null;
    }

    private NonOwnedDrawableResource(Drawable drawable) {
        super(drawable);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final Class<Drawable> KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory.getClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final int MyBillsEntityDataFactory() {
        return Math.max(1, this.BuiltInFictitiousFunctionClassFactory.getIntrinsicWidth() * this.BuiltInFictitiousFunctionClassFactory.getIntrinsicHeight() * 4);
    }
}
