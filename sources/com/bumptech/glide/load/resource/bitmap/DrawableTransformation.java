package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public class DrawableTransformation implements Transformation<Drawable> {
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private final Transformation<Bitmap> PlaceComponentResult;

    public DrawableTransformation(Transformation<Bitmap> transformation, boolean z) {
        this.PlaceComponentResult = transformation;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
    }

    @Override // com.bumptech.glide.load.Transformation
    public final Resource<Drawable> PlaceComponentResult(Context context, Resource<Drawable> resource, int i, int i2) {
        BitmapPool bitmapPool = Glide.BuiltInFictitiousFunctionClassFactory(context).BuiltInFictitiousFunctionClassFactory;
        Drawable authRequestContext = resource.getAuthRequestContext();
        Resource<Bitmap> KClassImpl$Data$declaredNonStaticMembers$2 = DrawableToBitmapConverter.KClassImpl$Data$declaredNonStaticMembers$2(bitmapPool, authRequestContext, i, i2);
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to convert ");
                sb.append(authRequestContext);
                sb.append(" to a Bitmap");
                throw new IllegalArgumentException(sb.toString());
            }
            return resource;
        }
        Resource<Bitmap> PlaceComponentResult = this.PlaceComponentResult.PlaceComponentResult(context, KClassImpl$Data$declaredNonStaticMembers$2, i, i2);
        if (PlaceComponentResult.equals(KClassImpl$Data$declaredNonStaticMembers$2)) {
            PlaceComponentResult.lookAheadTest();
            return resource;
        }
        return LazyBitmapDrawableResource.PlaceComponentResult(context.getResources(), PlaceComponentResult);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof DrawableTransformation) {
            return this.PlaceComponentResult.equals(((DrawableTransformation) obj).PlaceComponentResult);
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
