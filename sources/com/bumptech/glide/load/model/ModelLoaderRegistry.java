package com.bumptech.glide.load.model;

import androidx.core.util.Pools;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class ModelLoaderRegistry {
    public final ModelLoaderCache BuiltInFictitiousFunctionClassFactory;
    public final MultiModelLoaderFactory PlaceComponentResult;

    public ModelLoaderRegistry(Pools.Pool<List<Throwable>> pool) {
        this(new MultiModelLoaderFactory(pool));
    }

    private ModelLoaderRegistry(MultiModelLoaderFactory multiModelLoaderFactory) {
        this.BuiltInFictitiousFunctionClassFactory = new ModelLoaderCache();
        this.PlaceComponentResult = multiModelLoaderFactory;
    }

    public final List<Class<?>> BuiltInFictitiousFunctionClassFactory(Class<?> cls) {
        List<Class<?>> MyBillsEntityDataFactory;
        synchronized (this) {
            MyBillsEntityDataFactory = this.PlaceComponentResult.MyBillsEntityDataFactory(cls);
        }
        return MyBillsEntityDataFactory;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <A> List<ModelLoader<A, ?>> MyBillsEntityDataFactory(Class<A> cls) {
        List list;
        synchronized (this) {
            ModelLoaderCache.Entry<?> entry = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.get(cls);
            list = entry == null ? (List<ModelLoader<A, ?>>) false : entry.KClassImpl$Data$declaredNonStaticMembers$2;
            if (list == null) {
                list = (List<ModelLoader<A, ?>>) Collections.unmodifiableList(this.PlaceComponentResult.getAuthRequestContext(cls));
                if (this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.put(cls, new ModelLoaderCache.Entry<>(list)) != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Already cached loaders for model: ");
                    sb.append(cls);
                    throw new IllegalStateException(sb.toString());
                }
            }
        }
        return (List<ModelLoader<A, ?>>) list;
    }

    public static <A> Class<A> PlaceComponentResult(A a2) {
        return (Class<A>) a2.getClass();
    }

    /* loaded from: classes3.dex */
    public static class ModelLoaderCache {
        public final Map<Class<?>, Entry<?>> MyBillsEntityDataFactory = new HashMap();

        ModelLoaderCache() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public static class Entry<Model> {
            final List<ModelLoader<Model, ?>> KClassImpl$Data$declaredNonStaticMembers$2;

            public Entry(List<ModelLoader<Model, ?>> list) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
            }
        }
    }
}
