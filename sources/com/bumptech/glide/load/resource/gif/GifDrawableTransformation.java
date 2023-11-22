package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public class GifDrawableTransformation implements Transformation<GifDrawable> {
    private final Transformation<Bitmap> PlaceComponentResult;

    public GifDrawableTransformation(Transformation<Bitmap> transformation) {
        this.PlaceComponentResult = (Transformation) Preconditions.PlaceComponentResult(transformation);
    }

    @Override // com.bumptech.glide.load.Transformation
    public final Resource<GifDrawable> PlaceComponentResult(Context context, Resource<GifDrawable> resource, int i, int i2) {
        GifDrawable authRequestContext = resource.getAuthRequestContext();
        Resource<Bitmap> bitmapResource = new BitmapResource(authRequestContext.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.PlaceComponentResult, Glide.BuiltInFictitiousFunctionClassFactory(context).BuiltInFictitiousFunctionClassFactory);
        Resource<Bitmap> PlaceComponentResult = this.PlaceComponentResult.PlaceComponentResult(context, bitmapResource, i, i2);
        if (!bitmapResource.equals(PlaceComponentResult)) {
            bitmapResource.lookAheadTest();
        }
        Bitmap authRequestContext2 = PlaceComponentResult.getAuthRequestContext();
        authRequestContext.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult, authRequestContext2);
        return resource;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof GifDrawableTransformation) {
            return this.PlaceComponentResult.equals(((GifDrawableTransformation) obj).PlaceComponentResult);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.PlaceComponentResult.hashCode();
    }

    @Override // com.bumptech.glide.load.Key
    public final void getAuthRequestContext(MessageDigest messageDigest) {
        this.PlaceComponentResult.getAuthRequestContext(messageDigest);
    }
}
