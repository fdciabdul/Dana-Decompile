package id.dana.data.cache;

import id.dana.data.storage.GeneralPreferences;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/* loaded from: classes4.dex */
public class GeneralPreferencesCacheEntityData<T> implements CacheEntityData<T> {
    private final GeneralPreferences generalPreferences;

    public GeneralPreferencesCacheEntityData(GeneralPreferences generalPreferences) {
        this.generalPreferences = generalPreferences;
    }

    @Override // id.dana.data.cache.CacheEntityData
    public Observable<T> getObject(final String str, final Class<T> cls) {
        return Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.cache.GeneralPreferencesCacheEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                GeneralPreferencesCacheEntityData.this.m813x41f3257c(str, cls, observableEmitter);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$getObject$0$id-dana-data-cache-GeneralPreferencesCacheEntityData */
    public /* synthetic */ void m813x41f3257c(String str, Class cls, ObservableEmitter observableEmitter) throws Exception {
        Object object = this.generalPreferences.getObject(str, cls);
        if (object != null) {
            observableEmitter.onNext(object);
        }
        observableEmitter.onComplete();
    }

    @Override // id.dana.data.cache.CacheEntityData
    public Observable<Boolean> saveData(String str, T t) {
        return Observable.just(Boolean.valueOf(this.generalPreferences.saveData(str, t)));
    }
}
