package id.dana.data.miniprogram.source;

import id.dana.data.miniprogram.MiniProgramMapperKt;
import id.dana.data.miniprogram.model.MiniProgramEntity;
import id.dana.data.miniprogram.model.StoreStateConfigData;
import id.dana.data.miniprogram.source.local.PreferenceStoreMiniProgramsEntityData;
import id.dana.data.miniprogram.source.local.PreferenceStoreMiniProgramsEntityData$$ExternalSyntheticLambda0;
import id.dana.data.miniprogram.source.local.PreferenceStoreMiniProgramsEntityData$$ExternalSyntheticLambda2;
import id.dana.data.miniprogram.source.network.NetworkMiniPrograms;
import id.dana.data.miniprogram.source.split.SplitConfigStoreStateEntityData;
import id.dana.domain.miniprogram.MiniProgramRepository;
import id.dana.domain.miniprogram.model.MiniProgram;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB!\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0015\u0012\u0006\u0010\n\u001a\u00020\u0019\u0012\u0006\u0010\u000b\u001a\u00020\u0012¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J3\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0016\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/data/miniprogram/source/MiniProgramEntityRepository;", "Lid/dana/domain/miniprogram/MiniProgramRepository;", "Lio/reactivex/Observable;", "", "Lid/dana/domain/miniprogram/model/MiniProgram;", "getMiniPrograms", "()Lio/reactivex/Observable;", "", "p0", "", "p1", "p2", "", "setFavoriteMiniPrograms", "(Ljava/lang/String;ZLjava/util/List;)Lio/reactivex/Observable;", "", "setRecentMiniProgram", "(Ljava/lang/String;J)Lio/reactivex/Observable;", "Lid/dana/data/miniprogram/source/network/NetworkMiniPrograms;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/miniprogram/source/network/NetworkMiniPrograms;", "Lid/dana/data/miniprogram/source/local/PreferenceStoreMiniProgramsEntityData;", "PlaceComponentResult", "Lid/dana/data/miniprogram/source/local/PreferenceStoreMiniProgramsEntityData;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/miniprogram/source/split/SplitConfigStoreStateEntityData;", "getAuthRequestContext", "Lid/dana/data/miniprogram/source/split/SplitConfigStoreStateEntityData;", "<init>", "(Lid/dana/data/miniprogram/source/local/PreferenceStoreMiniProgramsEntityData;Lid/dana/data/miniprogram/source/split/SplitConfigStoreStateEntityData;Lid/dana/data/miniprogram/source/network/NetworkMiniPrograms;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MiniProgramEntityRepository implements MiniProgramRepository {
    private final NetworkMiniPrograms KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final PreferenceStoreMiniProgramsEntityData BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final SplitConfigStoreStateEntityData PlaceComponentResult;

    @Inject
    public MiniProgramEntityRepository(PreferenceStoreMiniProgramsEntityData preferenceStoreMiniProgramsEntityData, SplitConfigStoreStateEntityData splitConfigStoreStateEntityData, NetworkMiniPrograms networkMiniPrograms) {
        Intrinsics.checkNotNullParameter(preferenceStoreMiniProgramsEntityData, "");
        Intrinsics.checkNotNullParameter(splitConfigStoreStateEntityData, "");
        Intrinsics.checkNotNullParameter(networkMiniPrograms, "");
        this.BuiltInFictitiousFunctionClassFactory = preferenceStoreMiniProgramsEntityData;
        this.PlaceComponentResult = splitConfigStoreStateEntityData;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = networkMiniPrograms;
    }

    @Override // id.dana.domain.miniprogram.MiniProgramRepository
    public final Observable<List<MiniProgram>> getMiniPrograms() {
        Observable take = NetworkMiniPrograms.MyBillsEntityDataFactory().map(new Function() { // from class: id.dana.data.miniprogram.source.MiniProgramEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return MiniProgramEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2((List) obj);
            }
        }).take(10L);
        Intrinsics.checkNotNullExpressionValue(take, "");
        Observable map = take.map(new Function() { // from class: id.dana.data.miniprogram.source.MiniProgramEntityRepository$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return MiniProgramEntityRepository.MyBillsEntityDataFactory((List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        Observable map2 = map.map(new Function() { // from class: id.dana.data.miniprogram.source.MiniProgramEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return MiniProgramEntityRepository.getAuthRequestContext(MiniProgramEntityRepository.this, (List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map2, "");
        Observable<List<MiniProgram>> map3 = map2.map(new Function() { // from class: id.dana.data.miniprogram.source.MiniProgramEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return MiniProgramEntityRepository.BuiltInFictitiousFunctionClassFactory(MiniProgramEntityRepository.this, (List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map3, "");
        return map3;
    }

    @Override // id.dana.domain.miniprogram.MiniProgramRepository
    public final Observable<Unit> setFavoriteMiniPrograms(final String p0, final boolean p1, final List<String> p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Observable<Unit> flatMap = Observable.fromCallable(new Callable() { // from class: id.dana.data.miniprogram.source.MiniProgramEntityRepository$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return MiniProgramEntityRepository.MyBillsEntityDataFactory(MiniProgramEntityRepository.this, p1, p2, p0);
            }
        }).flatMap(new Function() { // from class: id.dana.data.miniprogram.source.MiniProgramEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return MiniProgramEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(MiniProgramEntityRepository.this, (List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Override // id.dana.domain.miniprogram.MiniProgramRepository
    public final Observable<Unit> setRecentMiniProgram(final String p0, final long p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<Unit> flatMap = Observable.fromCallable(new Callable() { // from class: id.dana.data.miniprogram.source.MiniProgramEntityRepository$$ExternalSyntheticLambda6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return MiniProgramEntityRepository.BuiltInFictitiousFunctionClassFactory(MiniProgramEntityRepository.this, p0, p1);
            }
        }).flatMap(new Function() { // from class: id.dana.data.miniprogram.source.MiniProgramEntityRepository$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return MiniProgramEntityRepository.getAuthRequestContext(MiniProgramEntityRepository.this, (Map) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    public static /* synthetic */ ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(MiniProgramEntityRepository miniProgramEntityRepository, final List list) {
        Intrinsics.checkNotNullParameter(miniProgramEntityRepository, "");
        Intrinsics.checkNotNullParameter(list, "");
        final PreferenceStoreMiniProgramsEntityData preferenceStoreMiniProgramsEntityData = miniProgramEntityRepository.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(list, "");
        Observable fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.miniprogram.source.local.PreferenceStoreMiniProgramsEntityData$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PreferenceStoreMiniProgramsEntityData.PlaceComponentResult(PreferenceStoreMiniProgramsEntityData.this, list);
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    public static /* synthetic */ Map BuiltInFictitiousFunctionClassFactory(MiniProgramEntityRepository miniProgramEntityRepository, String str, long j) {
        Intrinsics.checkNotNullParameter(miniProgramEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Observable fromCallable = Observable.fromCallable(new PreferenceStoreMiniProgramsEntityData$$ExternalSyntheticLambda2(miniProgramEntityRepository.BuiltInFictitiousFunctionClassFactory));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        Object blockingFirst = fromCallable.blockingFirst();
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
        HashMap hashMap = (HashMap) blockingFirst;
        hashMap.put(str, Long.valueOf(j));
        return MapsKt.toMap(CollectionsKt.take(CollectionsKt.sortedWith(MapsKt.toList(hashMap), new Comparator() { // from class: id.dana.data.miniprogram.source.MiniProgramEntityRepository$setRecentMiniProgram$lambda-3$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues((Long) ((Pair) t2).getSecond(), (Long) ((Pair) t).getSecond());
            }
        }), 4));
    }

    public static /* synthetic */ List getAuthRequestContext(MiniProgramEntityRepository miniProgramEntityRepository, List list) {
        Intrinsics.checkNotNullParameter(miniProgramEntityRepository, "");
        Intrinsics.checkNotNullParameter(list, "");
        Observable fromCallable = Observable.fromCallable(new PreferenceStoreMiniProgramsEntityData$$ExternalSyntheticLambda0(miniProgramEntityRepository.BuiltInFictitiousFunctionClassFactory));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        Object blockingFirst = fromCallable.blockingFirst();
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
        List list2 = (List) blockingFirst;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MiniProgram miniProgram = (MiniProgram) it.next();
            miniProgram.setFavorite(list2.contains(miniProgram.getAppId()));
        }
        return list;
    }

    public static /* synthetic */ StoreStateConfigData KClassImpl$Data$declaredNonStaticMembers$2(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return new StoreStateConfigData();
    }

    public static /* synthetic */ List MyBillsEntityDataFactory(MiniProgramEntityRepository miniProgramEntityRepository, boolean z, final List list, String str) {
        Intrinsics.checkNotNullParameter(miniProgramEntityRepository, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str, "");
        Observable fromCallable = Observable.fromCallable(new PreferenceStoreMiniProgramsEntityData$$ExternalSyntheticLambda0(miniProgramEntityRepository.BuiltInFictitiousFunctionClassFactory));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        Object blockingFirst = fromCallable.blockingFirst();
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
        List mutableList = CollectionsKt.toMutableList((Collection) ((List) blockingFirst));
        if (z) {
            if ((!list.isEmpty()) != false) {
                CollectionsKt.removeAll(mutableList, (Function1) new Function1<String, Boolean>() { // from class: id.dana.data.miniprogram.source.MiniProgramEntityRepository$setFavoriteMiniPrograms$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(String str2) {
                        Intrinsics.checkNotNullParameter(str2, "");
                        return Boolean.valueOf(!list.contains(str2));
                    }
                });
            }
            int size = mutableList.size();
            StoreStateConfigData blockingFirst2 = miniProgramEntityRepository.PlaceComponentResult.MyBillsEntityDataFactory().onErrorReturn(new Function() { // from class: id.dana.data.miniprogram.source.MiniProgramEntityRepository$$ExternalSyntheticLambda4
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return MiniProgramEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2((Throwable) obj);
                }
            }).blockingFirst();
            Intrinsics.checkNotNullExpressionValue(blockingFirst2, "");
            if (size < blockingFirst2.getAuthRequestContext) {
                mutableList.add(str);
            } else {
                throw new Exception();
            }
        } else {
            mutableList.remove(str);
        }
        return mutableList;
    }

    public static /* synthetic */ List KClassImpl$Data$declaredNonStaticMembers$2(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(MiniProgramMapperKt.getAuthRequestContext((MiniProgramEntity) it.next()));
        }
        return arrayList;
    }

    public static /* synthetic */ List BuiltInFictitiousFunctionClassFactory(MiniProgramEntityRepository miniProgramEntityRepository, List list) {
        Intrinsics.checkNotNullParameter(miniProgramEntityRepository, "");
        Intrinsics.checkNotNullParameter(list, "");
        Observable fromCallable = Observable.fromCallable(new PreferenceStoreMiniProgramsEntityData$$ExternalSyntheticLambda2(miniProgramEntityRepository.BuiltInFictitiousFunctionClassFactory));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        Object blockingFirst = fromCallable.blockingFirst();
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
        HashMap hashMap = (HashMap) blockingFirst;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MiniProgram miniProgram = (MiniProgram) it.next();
            if (hashMap.keySet().contains(miniProgram.getAppId())) {
                Object obj = hashMap.get(miniProgram.getAppId());
                Intrinsics.checkNotNull(obj);
                miniProgram.setLastOpen(((Number) obj).longValue());
            }
        }
        return list;
    }

    public static /* synthetic */ List MyBillsEntityDataFactory(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        return CollectionsKt.sortedWith(list, new Comparator() { // from class: id.dana.data.miniprogram.source.MiniProgramEntityRepository$sortByTitle$lambda-10$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((MiniProgram) t).getTitle(), ((MiniProgram) t2).getTitle());
            }
        });
    }

    public static /* synthetic */ ObservableSource getAuthRequestContext(MiniProgramEntityRepository miniProgramEntityRepository, Map map) {
        Intrinsics.checkNotNullParameter(miniProgramEntityRepository, "");
        Intrinsics.checkNotNullParameter(map, "");
        final PreferenceStoreMiniProgramsEntityData preferenceStoreMiniProgramsEntityData = miniProgramEntityRepository.BuiltInFictitiousFunctionClassFactory;
        final HashMap hashMap = new HashMap(map);
        Intrinsics.checkNotNullParameter(hashMap, "");
        Observable fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.miniprogram.source.local.PreferenceStoreMiniProgramsEntityData$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PreferenceStoreMiniProgramsEntityData.BuiltInFictitiousFunctionClassFactory(PreferenceStoreMiniProgramsEntityData.this, hashMap);
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }
}
