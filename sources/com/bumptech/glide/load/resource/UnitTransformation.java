package com.bumptech.glide.load.resource;

import android.content.Context;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public final class UnitTransformation<T> implements Transformation<T> {
    private static final Transformation<?> getAuthRequestContext = new UnitTransformation();

    @Override // com.bumptech.glide.load.Transformation
    public final Resource<T> PlaceComponentResult(Context context, Resource<T> resource, int i, int i2) {
        return resource;
    }

    @Override // com.bumptech.glide.load.Key
    public final void getAuthRequestContext(MessageDigest messageDigest) {
    }

    public static <T> UnitTransformation<T> KClassImpl$Data$declaredNonStaticMembers$2() {
        return (UnitTransformation) getAuthRequestContext;
    }

    private UnitTransformation() {
    }
}
