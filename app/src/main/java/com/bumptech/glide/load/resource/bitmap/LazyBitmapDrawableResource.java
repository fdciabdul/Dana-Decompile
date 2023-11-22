package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes3.dex */
public final class LazyBitmapDrawableResource implements Resource<BitmapDrawable>, Initializable {
    private final Resources PlaceComponentResult;
    private final Resource<Bitmap> getAuthRequestContext;

    public static Resource<BitmapDrawable> PlaceComponentResult(Resources resources, Resource<Bitmap> resource) {
        if (resource == null) {
            return null;
        }
        return new LazyBitmapDrawableResource(resources, resource);
    }

    private LazyBitmapDrawableResource(Resources resources, Resource<Bitmap> resource) {
        this.PlaceComponentResult = (Resources) Preconditions.PlaceComponentResult(resources);
        this.getAuthRequestContext = (Resource) Preconditions.PlaceComponentResult(resource);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final Class<BitmapDrawable> KClassImpl$Data$declaredNonStaticMembers$2() {
        return BitmapDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final int MyBillsEntityDataFactory() {
        return this.getAuthRequestContext.MyBillsEntityDataFactory();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final void lookAheadTest() {
        this.getAuthRequestContext.lookAheadTest();
    }

    @Override // com.bumptech.glide.load.engine.Initializable
    public final void BuiltInFictitiousFunctionClassFactory() {
        Resource<Bitmap> resource = this.getAuthRequestContext;
        if (resource instanceof Initializable) {
            ((Initializable) resource).BuiltInFictitiousFunctionClassFactory();
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final /* synthetic */ BitmapDrawable getAuthRequestContext() {
        return new BitmapDrawable(this.PlaceComponentResult, this.getAuthRequestContext.getAuthRequestContext());
    }
}
