package id.dana.data.cache;

import id.dana.data.storage.GeneralPreferences;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J5\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ/\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\b\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/data/cache/GeneralPreferenceCacheEntityData;", "Lid/dana/data/cache/GeneralCacheEntityData;", "", "T", "", "key", "Ljava/lang/Class;", "clazz", "Lio/reactivex/Observable;", "get", "(Ljava/lang/String;Ljava/lang/Class;)Lio/reactivex/Observable;", "obj", "", "save", "(Ljava/lang/String;Ljava/lang/Object;)Lio/reactivex/Observable;", "Lid/dana/data/storage/GeneralPreferences;", "generalPreferences", "Lid/dana/data/storage/GeneralPreferences;", "<init>", "(Lid/dana/data/storage/GeneralPreferences;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class GeneralPreferenceCacheEntityData implements GeneralCacheEntityData {
    private final GeneralPreferences generalPreferences;

    @Inject
    public GeneralPreferenceCacheEntityData(GeneralPreferences generalPreferences) {
        Intrinsics.checkNotNullParameter(generalPreferences, "");
        this.generalPreferences = generalPreferences;
    }

    @Override // id.dana.data.cache.GeneralCacheEntityData
    public final <T> Observable<T> get(final String key, final Class<T> clazz) {
        Intrinsics.checkNotNullParameter(key, "");
        Intrinsics.checkNotNullParameter(clazz, "");
        Observable<T> create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.cache.GeneralPreferenceCacheEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                GeneralPreferenceCacheEntityData.m812get$lambda2(GeneralPreferenceCacheEntityData.this, key, clazz, observableEmitter);
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "");
        return create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: get$lambda-2  reason: not valid java name */
    public static final void m812get$lambda2(GeneralPreferenceCacheEntityData generalPreferenceCacheEntityData, String str, Class cls, ObservableEmitter observableEmitter) {
        Unit unit;
        Intrinsics.checkNotNullParameter(generalPreferenceCacheEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(cls, "");
        Intrinsics.checkNotNullParameter(observableEmitter, "");
        Object object = generalPreferenceCacheEntityData.generalPreferences.getObject(str, cls);
        if (object != null) {
            observableEmitter.onNext(object);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            observableEmitter.onError(new NullPointerException());
        }
        observableEmitter.onComplete();
    }

    @Override // id.dana.data.cache.GeneralCacheEntityData
    public final <T> Observable<Boolean> save(String key, T obj) {
        Intrinsics.checkNotNullParameter(key, "");
        Intrinsics.checkNotNullParameter(obj, "");
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.generalPreferences.saveData(key, obj)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }
}
