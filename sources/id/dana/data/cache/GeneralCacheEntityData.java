package id.dana.data.cache;

import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J5\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\b\b\u0000\u0010\u0002*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H&¢\u0006\u0004\b\b\u0010\tJ/\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007\"\b\b\u0000\u0010\u0002*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00028\u0000H&¢\u0006\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/cache/GeneralCacheEntityData;", "", "T", "", "key", "Ljava/lang/Class;", "clazz", "Lio/reactivex/Observable;", "get", "(Ljava/lang/String;Ljava/lang/Class;)Lio/reactivex/Observable;", "obj", "", "save", "(Ljava/lang/String;Ljava/lang/Object;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public interface GeneralCacheEntityData {
    <T> Observable<T> get(String key, Class<T> clazz);

    <T> Observable<Boolean> save(String key, T obj);
}
