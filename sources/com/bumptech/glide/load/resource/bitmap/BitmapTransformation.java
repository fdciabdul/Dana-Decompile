package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;

/* loaded from: classes3.dex */
public abstract class BitmapTransformation implements Transformation<Bitmap> {
    protected abstract Bitmap getAuthRequestContext(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2);

    @Override // com.bumptech.glide.load.Transformation
    public final Resource<Bitmap> PlaceComponentResult(Context context, Resource<Bitmap> resource, int i, int i2) {
        if (!Util.KClassImpl$Data$declaredNonStaticMembers$2(i, i2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot apply transformation on width: ");
            sb.append(i);
            sb.append(" or height: ");
            sb.append(i2);
            sb.append(" less than or equal to zero and not Target.SIZE_ORIGINAL");
            throw new IllegalArgumentException(sb.toString());
        }
        BitmapPool bitmapPool = Glide.BuiltInFictitiousFunctionClassFactory(context).BuiltInFictitiousFunctionClassFactory;
        Bitmap authRequestContext = resource.getAuthRequestContext();
        if (i == Integer.MIN_VALUE) {
            i = authRequestContext.getWidth();
        }
        if (i2 == Integer.MIN_VALUE) {
            i2 = authRequestContext.getHeight();
        }
        Bitmap authRequestContext2 = getAuthRequestContext(bitmapPool, authRequestContext, i, i2);
        return !authRequestContext.equals(authRequestContext2) ? BitmapResource.MyBillsEntityDataFactory(authRequestContext2, bitmapPool) : resource;
    }
}
