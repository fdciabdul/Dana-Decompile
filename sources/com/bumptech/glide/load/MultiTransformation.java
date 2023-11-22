package com.bumptech.glide.load;

import android.content.Context;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class MultiTransformation<T> implements Transformation<T> {
    private final Collection<? extends Transformation<T>> KClassImpl$Data$declaredNonStaticMembers$2;

    @SafeVarargs
    public MultiTransformation(Transformation<T>... transformationArr) {
        if (transformationArr.length == 0) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = Arrays.asList(transformationArr);
    }

    @Override // com.bumptech.glide.load.Transformation
    public final Resource<T> PlaceComponentResult(Context context, Resource<T> resource, int i, int i2) {
        Iterator<? extends Transformation<T>> it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
        Resource<T> resource2 = resource;
        while (it.hasNext()) {
            Resource<T> PlaceComponentResult = it.next().PlaceComponentResult(context, resource2, i, i2);
            if (resource2 != null && !resource2.equals(resource) && !resource2.equals(PlaceComponentResult)) {
                resource2.lookAheadTest();
            }
            resource2 = PlaceComponentResult;
        }
        return resource2;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof MultiTransformation) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.equals(((MultiTransformation) obj).KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
    }

    @Override // com.bumptech.glide.load.Key
    public final void getAuthRequestContext(MessageDigest messageDigest) {
        Iterator<? extends Transformation<T>> it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
        while (it.hasNext()) {
            it.next().getAuthRequestContext(messageDigest);
        }
    }
}
