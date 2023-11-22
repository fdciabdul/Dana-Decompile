package com.bumptech.glide.provider;

import androidx.collection.ArrayMap;
import com.bumptech.glide.util.MultiClassKey;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public class ModelToResourceClassCache {
    private final AtomicReference<MultiClassKey> PlaceComponentResult = new AtomicReference<>();
    public final ArrayMap<MultiClassKey, List<Class<?>>> getAuthRequestContext = new ArrayMap<>();

    public final List<Class<?>> BuiltInFictitiousFunctionClassFactory(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        List<Class<?>> list;
        MultiClassKey andSet = this.PlaceComponentResult.getAndSet(null);
        if (andSet == null) {
            andSet = new MultiClassKey(cls, cls2, cls3);
        } else {
            andSet.MyBillsEntityDataFactory = cls;
            andSet.KClassImpl$Data$declaredNonStaticMembers$2 = cls2;
            andSet.BuiltInFictitiousFunctionClassFactory = cls3;
        }
        synchronized (this.getAuthRequestContext) {
            list = this.getAuthRequestContext.get(andSet);
        }
        this.PlaceComponentResult.set(andSet);
        return list;
    }
}
