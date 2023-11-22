package com.bumptech.glide.load.model;

import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class MultiModelLoaderFactory {
    private static final Factory BuiltInFictitiousFunctionClassFactory = new Factory();
    private static final ModelLoader<Object, Object> MyBillsEntityDataFactory = new EmptyModelLoader();
    public final List<Entry<?, ?>> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Set<Entry<?, ?>> PlaceComponentResult;
    private final Factory getAuthRequestContext;
    private final Pools.Pool<List<Throwable>> getErrorConfigVersion;

    public MultiModelLoaderFactory(Pools.Pool<List<Throwable>> pool) {
        this(pool, BuiltInFictitiousFunctionClassFactory);
    }

    private MultiModelLoaderFactory(Pools.Pool<List<Throwable>> pool, Factory factory) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
        this.PlaceComponentResult = new HashSet();
        this.getErrorConfigVersion = pool;
        this.getAuthRequestContext = factory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <Model> List<ModelLoader<Model, ?>> getAuthRequestContext(Class<Model> cls) {
        ArrayList arrayList;
        synchronized (this) {
            try {
                arrayList = new ArrayList();
                for (Entry<?, ?> entry : this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    if (!this.PlaceComponentResult.contains(entry) && entry.getAuthRequestContext(cls)) {
                        this.PlaceComponentResult.add(entry);
                        arrayList.add((ModelLoader) Preconditions.PlaceComponentResult(entry.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this)));
                        this.PlaceComponentResult.remove(entry);
                    }
                }
            } catch (Throwable th) {
                this.PlaceComponentResult.clear();
                throw th;
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<Class<?>> MyBillsEntityDataFactory(Class<?> cls) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList();
            for (Entry<?, ?> entry : this.KClassImpl$Data$declaredNonStaticMembers$2) {
                if (!arrayList.contains(entry.BuiltInFictitiousFunctionClassFactory) && entry.getAuthRequestContext(cls)) {
                    arrayList.add(entry.BuiltInFictitiousFunctionClassFactory);
                }
            }
        }
        return arrayList;
    }

    public final <Model, Data> ModelLoader<Model, Data> BuiltInFictitiousFunctionClassFactory(Class<Model> cls, Class<Data> cls2) {
        synchronized (this) {
            try {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (Entry<?, ?> entry : this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    if (this.PlaceComponentResult.contains(entry)) {
                        z = true;
                    } else if (entry.MyBillsEntityDataFactory(cls, cls2)) {
                        this.PlaceComponentResult.add(entry);
                        arrayList.add((ModelLoader) Preconditions.PlaceComponentResult(entry.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this)));
                        this.PlaceComponentResult.remove(entry);
                    }
                }
                if (arrayList.size() > 1) {
                    return Factory.MyBillsEntityDataFactory(arrayList, this.getErrorConfigVersion);
                } else if (arrayList.size() == 1) {
                    return (ModelLoader) arrayList.get(0);
                } else if (!z) {
                    throw new Registry.NoModelLoaderAvailableException((Class<?>) cls, (Class<?>) cls2);
                } else {
                    return (ModelLoader<Model, Data>) MyBillsEntityDataFactory;
                }
            } catch (Throwable th) {
                this.PlaceComponentResult.clear();
                throw th;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class Entry<Model, Data> {
        final Class<Data> BuiltInFictitiousFunctionClassFactory;
        final ModelLoaderFactory<? extends Model, ? extends Data> KClassImpl$Data$declaredNonStaticMembers$2;
        private final Class<Model> getAuthRequestContext;

        public Entry(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
            this.getAuthRequestContext = cls;
            this.BuiltInFictitiousFunctionClassFactory = cls2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = modelLoaderFactory;
        }

        public final boolean MyBillsEntityDataFactory(Class<?> cls, Class<?> cls2) {
            return getAuthRequestContext(cls) && this.BuiltInFictitiousFunctionClassFactory.isAssignableFrom(cls2);
        }

        public final boolean getAuthRequestContext(Class<?> cls) {
            return this.getAuthRequestContext.isAssignableFrom(cls);
        }
    }

    /* loaded from: classes3.dex */
    static class Factory {
        Factory() {
        }

        public static <Model, Data> MultiModelLoader<Model, Data> MyBillsEntityDataFactory(List<ModelLoader<Model, Data>> list, Pools.Pool<List<Throwable>> pool) {
            return new MultiModelLoader<>(list, pool);
        }
    }

    /* loaded from: classes3.dex */
    static class EmptyModelLoader implements ModelLoader<Object, Object> {
        @Override // com.bumptech.glide.load.model.ModelLoader
        public final boolean BuiltInFictitiousFunctionClassFactory(Object obj) {
            return false;
        }

        @Override // com.bumptech.glide.load.model.ModelLoader
        public final ModelLoader.LoadData<Object> KClassImpl$Data$declaredNonStaticMembers$2(Object obj, int i, int i2, Options options) {
            return null;
        }

        EmptyModelLoader() {
        }
    }
}
