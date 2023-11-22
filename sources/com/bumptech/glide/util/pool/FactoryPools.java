package com.bumptech.glide.util.pool;

import android.util.Log;
import androidx.core.util.Pools;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class FactoryPools {
    private static final Resetter<Object> getAuthRequestContext = new Resetter<Object>() { // from class: com.bumptech.glide.util.pool.FactoryPools.1
        @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
        public final void PlaceComponentResult(Object obj) {
        }
    };

    /* loaded from: classes3.dex */
    public interface Factory<T> {
        T getAuthRequestContext();
    }

    /* loaded from: classes3.dex */
    public interface Poolable {
        StateVerifier d_();
    }

    /* loaded from: classes3.dex */
    public interface Resetter<T> {
        void PlaceComponentResult(T t);
    }

    private FactoryPools() {
    }

    public static <T extends Poolable> Pools.Pool<T> BuiltInFictitiousFunctionClassFactory(int i, Factory<T> factory) {
        return new FactoryPool(new Pools.SynchronizedPool(i), factory, getAuthRequestContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class FactoryPool<T> implements Pools.Pool<T> {
        private final Factory<T> BuiltInFictitiousFunctionClassFactory;
        private final Pools.Pool<T> MyBillsEntityDataFactory;
        private final Resetter<T> PlaceComponentResult;

        FactoryPool(Pools.Pool<T> pool, Factory<T> factory, Resetter<T> resetter) {
            this.MyBillsEntityDataFactory = pool;
            this.BuiltInFictitiousFunctionClassFactory = factory;
            this.PlaceComponentResult = resetter;
        }

        @Override // androidx.core.util.Pools.Pool
        public final T BuiltInFictitiousFunctionClassFactory() {
            T BuiltInFictitiousFunctionClassFactory = this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
            if (BuiltInFictitiousFunctionClassFactory == null) {
                BuiltInFictitiousFunctionClassFactory = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
                if (Log.isLoggable("FactoryPools", 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Created new ");
                    sb.append(BuiltInFictitiousFunctionClassFactory.getClass());
                    InstrumentInjector.log_v("FactoryPools", sb.toString());
                }
            }
            if (BuiltInFictitiousFunctionClassFactory instanceof Poolable) {
                ((Poolable) BuiltInFictitiousFunctionClassFactory).d_().MyBillsEntityDataFactory(false);
            }
            return BuiltInFictitiousFunctionClassFactory;
        }

        @Override // androidx.core.util.Pools.Pool
        public final boolean MyBillsEntityDataFactory(T t) {
            if (t instanceof Poolable) {
                ((Poolable) t).d_().MyBillsEntityDataFactory(true);
            }
            this.PlaceComponentResult.PlaceComponentResult(t);
            return this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(t);
        }
    }

    public static <T> Pools.Pool<List<T>> MyBillsEntityDataFactory() {
        return new FactoryPool(new Pools.SynchronizedPool(20), new Factory<List<T>>() { // from class: com.bumptech.glide.util.pool.FactoryPools.2
            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            public final /* synthetic */ Object getAuthRequestContext() {
                return new ArrayList();
            }
        }, new Resetter<List<T>>() { // from class: com.bumptech.glide.util.pool.FactoryPools.3
            @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
            public final /* synthetic */ void PlaceComponentResult(Object obj) {
                ((List) obj).clear();
            }
        });
    }
}
