package androidx.view;

import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class MediatorLiveData<T> extends MutableLiveData<T> {
    SafeIterableMap<LiveData<?>, Source<?>> PlaceComponentResult = new SafeIterableMap<>();

    public final <S> void getAuthRequestContext(LiveData<S> liveData, Observer<? super S> observer) {
        Source<?> source = new Source<>(liveData, observer);
        Source<?> BuiltInFictitiousFunctionClassFactory = this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(liveData, source);
        if (BuiltInFictitiousFunctionClassFactory != null && BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory != observer) {
            throw new IllegalArgumentException("This source was already added with the different observer");
        }
        if (BuiltInFictitiousFunctionClassFactory == null && MyBillsEntityDataFactory()) {
            source.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(source);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.view.LiveData
    public void BuiltInFictitiousFunctionClassFactory() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> it = this.PlaceComponentResult.iterator();
        while (it.hasNext()) {
            Source<?> value = it.next().getValue();
            value.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(value);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.view.LiveData
    public void getAuthRequestContext() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> it = this.PlaceComponentResult.iterator();
        while (it.hasNext()) {
            Source<?> value = it.next().getValue();
            value.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory((Observer<? super Object>) value);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Source<V> implements Observer<V> {
        final Observer<? super V> BuiltInFictitiousFunctionClassFactory;
        final LiveData<V> KClassImpl$Data$declaredNonStaticMembers$2;
        int PlaceComponentResult = -1;

        Source(LiveData<V> liveData, Observer<? super V> observer) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = liveData;
            this.BuiltInFictitiousFunctionClassFactory = observer;
        }

        @Override // androidx.view.Observer
        public void onChanged(V v) {
            if (this.PlaceComponentResult != this.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion) {
                this.PlaceComponentResult = this.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion;
                this.BuiltInFictitiousFunctionClassFactory.onChanged(v);
            }
        }
    }
}
