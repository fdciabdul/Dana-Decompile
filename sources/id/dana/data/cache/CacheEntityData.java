package id.dana.data.cache;

import io.reactivex.Observable;

/* loaded from: classes4.dex */
public interface CacheEntityData<T> {
    Observable<T> getObject(String str, Class<T> cls);

    Observable<Boolean> saveData(String str, T t);
}
