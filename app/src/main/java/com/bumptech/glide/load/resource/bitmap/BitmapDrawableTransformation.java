package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;

@Deprecated
/* loaded from: classes7.dex */
public class BitmapDrawableTransformation implements Transformation<BitmapDrawable> {
    private final Transformation<Drawable> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // com.bumptech.glide.load.Transformation
    public final Resource<BitmapDrawable> PlaceComponentResult(Context context, Resource<BitmapDrawable> resource, int i, int i2) {
        Resource PlaceComponentResult = this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(context, resource, i, i2);
        if (PlaceComponentResult.getAuthRequestContext() instanceof BitmapDrawable) {
            return PlaceComponentResult;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Wrapped transformation unexpectedly returned a non BitmapDrawable resource: ");
        sb.append(PlaceComponentResult.getAuthRequestContext());
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof BitmapDrawableTransformation) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.equals(((BitmapDrawableTransformation) obj).KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
    }

    @Override // com.bumptech.glide.load.Key
    public final void getAuthRequestContext(MessageDigest messageDigest) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(messageDigest);
    }
}
