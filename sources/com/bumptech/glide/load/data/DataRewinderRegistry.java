package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class DataRewinderRegistry {
    private static final DataRewinder.Factory<?> KClassImpl$Data$declaredNonStaticMembers$2 = new DataRewinder.Factory<Object>() { // from class: com.bumptech.glide.load.data.DataRewinderRegistry.1
        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public final DataRewinder<Object> BuiltInFictitiousFunctionClassFactory(Object obj) {
            return new DefaultRewinder(obj);
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public final Class<Object> KClassImpl$Data$declaredNonStaticMembers$2() {
            throw new UnsupportedOperationException("Not implemented");
        }
    };
    public final Map<Class<?>, DataRewinder.Factory<?>> PlaceComponentResult = new HashMap();

    public final <T> DataRewinder<T> MyBillsEntityDataFactory(T t) {
        DataRewinder<T> dataRewinder;
        synchronized (this) {
            Preconditions.PlaceComponentResult(t);
            DataRewinder.Factory<?> factory = this.PlaceComponentResult.get(t.getClass());
            if (factory == null) {
                Iterator<DataRewinder.Factory<?>> it = this.PlaceComponentResult.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    DataRewinder.Factory<?> next = it.next();
                    if (next.KClassImpl$Data$declaredNonStaticMembers$2().isAssignableFrom(t.getClass())) {
                        factory = next;
                        break;
                    }
                }
            }
            if (factory == null) {
                factory = KClassImpl$Data$declaredNonStaticMembers$2;
            }
            dataRewinder = (DataRewinder<T>) factory.BuiltInFictitiousFunctionClassFactory(t);
        }
        return dataRewinder;
    }

    /* loaded from: classes3.dex */
    static final class DefaultRewinder implements DataRewinder<Object> {
        private final Object KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // com.bumptech.glide.load.data.DataRewinder
        public final void MyBillsEntityDataFactory() {
        }

        DefaultRewinder(Object obj) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = obj;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder
        public final Object PlaceComponentResult() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }
}
