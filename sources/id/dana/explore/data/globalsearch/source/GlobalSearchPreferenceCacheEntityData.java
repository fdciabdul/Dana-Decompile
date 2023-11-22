package id.dana.explore.data.globalsearch.source;

import id.dana.explore.data.globalsearch.GlobalSearchCacheEntityData;
import id.dana.explore.data.globalsearch.model.PopularSearchCache;
import id.dana.utils.exception.CallableReturnNullError;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ5\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH\u0016¢\u0006\u0004\b\f\u0010\rJ1\u0010\t\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u000ej\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f`\u00100\bH\u0016¢\u0006\u0004\b\t\u0010\rJ\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\b\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0012\u0010\u0015J9\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\b2\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u000ej\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f`\u0010H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\f\u001a\u00020\u00162\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H\u0016¢\u0006\u0004\b\f\u0010\u0019R\u0014\u0010\u0017\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c"}, d2 = {"Lid/dana/explore/data/globalsearch/source/GlobalSearchPreferenceCacheEntityData;", "Lid/dana/explore/data/globalsearch/GlobalSearchCacheEntityData;", "", "T", "", "p0", "Ljava/lang/Class;", "p1", "Lio/reactivex/Observable;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/Class;)Lio/reactivex/Observable;", "Lid/dana/explore/data/globalsearch/model/PopularSearchCache;", "getAuthRequestContext", "()Lio/reactivex/Observable;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "", "PlaceComponentResult", "()Ljava/util/List;", "", "(Ljava/lang/String;Ljava/lang/Object;)Lio/reactivex/Observable;", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/HashMap;)Lio/reactivex/Observable;", "(Ljava/util/List;)V", "Lid/dana/explore/data/globalsearch/source/GlobalSearchPreference;", "MyBillsEntityDataFactory", "Lid/dana/explore/data/globalsearch/source/GlobalSearchPreference;", "<init>", "(Lid/dana/explore/data/globalsearch/source/GlobalSearchPreference;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GlobalSearchPreferenceCacheEntityData implements GlobalSearchCacheEntityData {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final GlobalSearchPreference BuiltInFictitiousFunctionClassFactory;

    @Inject
    public GlobalSearchPreferenceCacheEntityData(GlobalSearchPreference globalSearchPreference) {
        Intrinsics.checkNotNullParameter(globalSearchPreference, "");
        this.BuiltInFictitiousFunctionClassFactory = globalSearchPreference;
    }

    @Override // id.dana.explore.data.globalsearch.GlobalSearchCacheEntityData
    public final <T> Observable<T> KClassImpl$Data$declaredNonStaticMembers$2(final String p0, final Class<T> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Observable<T> create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.explore.data.globalsearch.source.GlobalSearchPreferenceCacheEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                GlobalSearchPreferenceCacheEntityData.getAuthRequestContext(GlobalSearchPreferenceCacheEntityData.this, p0, p1, observableEmitter);
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "");
        return create;
    }

    @Override // id.dana.explore.data.globalsearch.GlobalSearchCacheEntityData
    public final <T> Observable<Boolean> PlaceComponentResult(String p0, T p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(p0, p1)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.explore.data.globalsearch.GlobalSearchCacheEntityData
    public final Observable<Unit> BuiltInFictitiousFunctionClassFactory(final HashMap<String, Long> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<Unit> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.explore.data.globalsearch.source.GlobalSearchPreferenceCacheEntityData$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return GlobalSearchPreferenceCacheEntityData.MyBillsEntityDataFactory(GlobalSearchPreferenceCacheEntityData.this, p0);
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    @Override // id.dana.explore.data.globalsearch.GlobalSearchCacheEntityData
    public final Observable<HashMap<String, Long>> KClassImpl$Data$declaredNonStaticMembers$2() {
        Observable<HashMap<String, Long>> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.explore.data.globalsearch.source.GlobalSearchPreferenceCacheEntityData$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return GlobalSearchPreferenceCacheEntityData.BuiltInFictitiousFunctionClassFactory(GlobalSearchPreferenceCacheEntityData.this);
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    @Override // id.dana.explore.data.globalsearch.GlobalSearchCacheEntityData
    public final Observable<PopularSearchCache> getAuthRequestContext() {
        Observable<PopularSearchCache> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.explore.data.globalsearch.source.GlobalSearchPreferenceCacheEntityData$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return GlobalSearchPreferenceCacheEntityData.KClassImpl$Data$declaredNonStaticMembers$2(GlobalSearchPreferenceCacheEntityData.this);
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    @Override // id.dana.explore.data.globalsearch.GlobalSearchCacheEntityData
    public final void getAuthRequestContext(List<String> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        GlobalSearchPreference globalSearchPreference = this.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(p0, "");
        globalSearchPreference.KClassImpl$Data$declaredNonStaticMembers$2.saveData("trending_keyword_list", (String) p0);
    }

    @Override // id.dana.explore.data.globalsearch.GlobalSearchCacheEntityData
    public final List<String> PlaceComponentResult() {
        List<String> list = (List) this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2.getObject("trending_keyword_list", List.class);
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public static /* synthetic */ PopularSearchCache KClassImpl$Data$declaredNonStaticMembers$2(GlobalSearchPreferenceCacheEntityData globalSearchPreferenceCacheEntityData) {
        Intrinsics.checkNotNullParameter(globalSearchPreferenceCacheEntityData, "");
        PopularSearchCache popularSearchCache = (PopularSearchCache) globalSearchPreferenceCacheEntityData.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2.getObject("POPULAR_SEARCH_PLACEHOLDER", PopularSearchCache.class);
        return popularSearchCache == null ? new PopularSearchCache(0L, 0, null, 7, null) : popularSearchCache;
    }

    public static /* synthetic */ Unit MyBillsEntityDataFactory(GlobalSearchPreferenceCacheEntityData globalSearchPreferenceCacheEntityData, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(globalSearchPreferenceCacheEntityData, "");
        Intrinsics.checkNotNullParameter(hashMap, "");
        GlobalSearchPreference globalSearchPreference = globalSearchPreferenceCacheEntityData.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(hashMap, "");
        globalSearchPreference.KClassImpl$Data$declaredNonStaticMembers$2.saveData("GLOBAL_SEARCH_RECENT_SEARCH", (String) hashMap);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void getAuthRequestContext(GlobalSearchPreferenceCacheEntityData globalSearchPreferenceCacheEntityData, String str, Class cls, ObservableEmitter observableEmitter) {
        Intrinsics.checkNotNullParameter(globalSearchPreferenceCacheEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(cls, "");
        Intrinsics.checkNotNullParameter(observableEmitter, "");
        Object MyBillsEntityDataFactory = globalSearchPreferenceCacheEntityData.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(str, cls);
        Intrinsics.checkNotNull(MyBillsEntityDataFactory);
        observableEmitter.onNext(MyBillsEntityDataFactory);
        observableEmitter.onComplete();
    }

    public static /* synthetic */ HashMap BuiltInFictitiousFunctionClassFactory(GlobalSearchPreferenceCacheEntityData globalSearchPreferenceCacheEntityData) {
        Intrinsics.checkNotNullParameter(globalSearchPreferenceCacheEntityData, "");
        HashMap hashMap = (HashMap) globalSearchPreferenceCacheEntityData.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2.getObject("GLOBAL_SEARCH_RECENT_SEARCH", HashMap.class);
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        if (hashMap != null) {
            return hashMap;
        }
        throw new CallableReturnNullError("GlobalSearchPreferenceCacheEntityData#getRecentSearch");
    }
}
