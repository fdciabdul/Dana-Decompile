package id.dana.feeds.data.storage.persistence;

import dagger.Lazy;
import id.dana.data.base.BasePersistence;
import id.dana.data.base.BasePersistenceDao;
import id.dana.data.social.repository.source.persistence.entity.FollowerEntity;
import id.dana.data.social.repository.source.persistence.entity.FollowingEntity;
import id.dana.data.social.repository.source.persistence.entity.FollowingItemEntity;
import id.dana.feeds.data.relationship.mapper.FollowerMapperKt;
import id.dana.feeds.data.relationship.mapper.FollowingMapperKt;
import id.dana.feeds.data.storage.persistence.exception.RelationshipDataNotFoundException;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0007\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\bJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u0006\u0010\u0004\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0011R\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0011"}, d2 = {"Lid/dana/feeds/data/storage/persistence/PersistenceRelationshipEntityData;", "Lid/dana/data/base/BasePersistence;", "Lid/dana/feeds/data/storage/persistence/LocalRelationshipEntityData;", "", "p0", "Lio/reactivex/Observable;", "Lid/dana/data/social/repository/source/persistence/entity/FollowerEntity;", "MyBillsEntityDataFactory", "()Lio/reactivex/Observable;", "Lid/dana/data/social/repository/source/persistence/entity/FollowingEntity;", "getAuthRequestContext", "", "Lid/dana/data/social/repository/source/persistence/entity/FollowingItemEntity;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lio/reactivex/subjects/BehaviorSubject;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lio/reactivex/subjects/BehaviorSubject;", "PlaceComponentResult", "Ldagger/Lazy;", "Lid/dana/data/base/BasePersistenceDao;", "<init>", "(Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PersistenceRelationshipEntityData extends BasePersistence implements LocalRelationshipEntityData {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public BehaviorSubject<FollowingEntity> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public BehaviorSubject<FollowerEntity> BuiltInFictitiousFunctionClassFactory;
    public BehaviorSubject<FollowerEntity> MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public BehaviorSubject<FollowingEntity> PlaceComponentResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v0, types: [id.dana.data.social.repository.source.persistence.entity.PaginatorEntity, java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    @Inject
    public PersistenceRelationshipEntityData(Lazy<BasePersistenceDao> lazy) {
        super(lazy);
        Intrinsics.checkNotNullParameter(lazy, "");
        BehaviorSubject<FollowerEntity> BuiltInFictitiousFunctionClassFactory = BehaviorSubject.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory;
        BehaviorSubject<FollowingEntity> BuiltInFictitiousFunctionClassFactory2 = BehaviorSubject.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory2, "");
        this.PlaceComponentResult = BuiltInFictitiousFunctionClassFactory2;
        BehaviorSubject<FollowerEntity> BuiltInFictitiousFunctionClassFactory3 = BehaviorSubject.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory3, "");
        this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory3;
        BehaviorSubject<FollowingEntity> BuiltInFictitiousFunctionClassFactory4 = BehaviorSubject.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory4, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory4;
        int i = 3;
        ?? r2 = 0;
        this.PlaceComponentResult.onNext(new FollowingEntity(r2, r2, i, r2));
        this.MyBillsEntityDataFactory.onNext(new FollowerEntity(r2, r2, i, r2));
    }

    public final Observable<FollowingEntity> getAuthRequestContext() {
        Observable<FollowingEntity> map = Observable.just(getDb().followingDao().getFollowingItemEntityList()).map(new Function() { // from class: id.dana.feeds.data.storage.persistence.PersistenceRelationshipEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PersistenceRelationshipEntityData.getAuthRequestContext((List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    public final Observable<FollowerEntity> MyBillsEntityDataFactory() {
        Observable<FollowerEntity> map = Observable.just(getDb().followerDao().getFollowerItemEntityList()).map(new Function() { // from class: id.dana.feeds.data.storage.persistence.PersistenceRelationshipEntityData$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PersistenceRelationshipEntityData.KClassImpl$Data$declaredNonStaticMembers$2((List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    public final Observable<FollowingItemEntity> BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable flatMap = getDb().followingDao().getSelectedFollowing(p0).flatMap(new Function() { // from class: id.dana.feeds.data.storage.persistence.PersistenceRelationshipEntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PersistenceRelationshipEntityData.BuiltInFictitiousFunctionClassFactory((List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    public static /* synthetic */ FollowerEntity KClassImpl$Data$declaredNonStaticMembers$2(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        return FollowerMapperKt.BuiltInFictitiousFunctionClassFactory(list);
    }

    public static /* synthetic */ ObservableSource BuiltInFictitiousFunctionClassFactory(List list) {
        Observable just;
        Intrinsics.checkNotNullParameter(list, "");
        if (list.isEmpty()) {
            just = Observable.error(new RelationshipDataNotFoundException());
        } else {
            just = Observable.just(CollectionsKt.first(list));
        }
        return just;
    }

    public static /* synthetic */ FollowingEntity getAuthRequestContext(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        return FollowingMapperKt.getAuthRequestContext(list);
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(List list) {
        Observable just;
        Intrinsics.checkNotNullParameter(list, "");
        if (list.isEmpty()) {
            just = Observable.error(new RelationshipDataNotFoundException());
        } else {
            just = Observable.just(CollectionsKt.first(list));
        }
        return just;
    }
}
