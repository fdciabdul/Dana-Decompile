package id.dana.data.geofence.repository.source;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.account.repository.source.SecuredAccountPreferences;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.errorconfig.ErrorConfigEntityData;
import id.dana.data.geofence.mapper.PoiResultMapperKt;
import id.dana.data.geofence.repository.GeoFenceEntityData;
import id.dana.data.geofence.repository.source.network.result.PoiFetchResult;
import id.dana.data.geofence.repository.source.persistence.entity.RecentPoiEntity;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.data.login.source.LoginEntityData;
import id.dana.data.storage.GeneralPreferences;
import id.dana.data.util.RetryWithDelay;
import id.dana.domain.geofence.GeoFenceRepository;
import id.dana.domain.geofence.model.Poi;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.SingleSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.flow.Flow;

@Singleton
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B1\b\u0007\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u00103\u001a\u000202\u0012\u0006\u0010?\u001a\u00020>\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u0010<\u001a\u00020;¢\u0006\u0004\bA\u0010BJ*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096\u0001¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096\u0001¢\u0006\u0004\b\u0006\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u000eH\u0096\u0001¢\u0006\u0004\b\u0014\u0010\u0010J\u0010\u0010\u0016\u001a\u00020\u0015H\u0096\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0018\u0010\u0013J)\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u001c0\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u0004H\u0016¢\u0006\u0004\b \u0010!J#\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00190\u00042\u0006\u0010\"\u001a\u00020\u001aH\u0016¢\u0006\u0004\b$\u0010%J#\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001cH\u0002¢\u0006\u0004\b'\u0010\u001eJ#\u0010(\u001a\b\u0012\u0004\u0012\u00020&0\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016¢\u0006\u0004\b(\u0010\u001eJ\u001d\u0010,\u001a\u00020+2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020)0\u0019H\u0002¢\u0006\u0004\b,\u0010-J\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020&0\u00042\u0006\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b0\u00101R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00106\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u00109\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010<\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@"}, d2 = {"Lid/dana/data/geofence/repository/source/GeoFenceEntityRepository;", "Lid/dana/domain/geofence/GeoFenceRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "T", "Lio/reactivex/Observable;", "observable", "authenticatedRequest", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", "Lkotlinx/coroutines/flow/Flow;", "flow", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/data/account/repository/source/AccountEntityData;", "createAccountData", "()Lid/dana/data/account/repository/source/AccountEntityData;", "Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createLocalErrorConfigData", "()Lid/dana/data/errorconfig/ErrorConfigEntityData;", "Lid/dana/data/geofence/repository/GeoFenceEntityData;", "createLocalPoiData", "()Lid/dana/data/geofence/repository/GeoFenceEntityData;", "createNetworkErrorConfigData", "Lid/dana/data/login/source/LoginEntityData;", "createNetworkLogin", "()Lid/dana/data/login/source/LoginEntityData;", "createNetworkPoiData", "", "", "poiIds", "", "filterOutTodayNotifiedPoiId", "(Ljava/util/List;)Lio/reactivex/Observable;", "", "getCurrentPOICacheTime", "()Lio/reactivex/Observable;", "location", "Lid/dana/domain/geofence/model/Poi;", "getListPoi", "(Ljava/lang/String;)Lio/reactivex/Observable;", "", "notifyByPoiIds", "notifyPOIs", "Lid/dana/data/geofence/repository/source/persistence/entity/RecentPoiEntity;", "newPOIs", "", "savelistPOIs", "(Ljava/util/List;)V", "", "maxRetry", "setRetryInterval", "(I)Lio/reactivex/Observable;", "Lid/dana/data/config/DeviceInformationProvider;", "deviceInformationProvider", "Lid/dana/data/config/DeviceInformationProvider;", "Lid/dana/data/storage/GeneralPreferences;", "generalPreferences", "Lid/dana/data/storage/GeneralPreferences;", "Lid/dana/data/geofence/repository/source/GeoFenceDataFactory;", "geoFenceDataFactory", "Lid/dana/data/geofence/repository/source/GeoFenceDataFactory;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "holdLoginV1EntityRepository", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/account/repository/source/SecuredAccountPreferences;", "securedAccountPreferences", "Lid/dana/data/account/repository/source/SecuredAccountPreferences;", "<init>", "(Lid/dana/data/geofence/repository/source/GeoFenceDataFactory;Lid/dana/data/config/DeviceInformationProvider;Lid/dana/data/account/repository/source/SecuredAccountPreferences;Lid/dana/data/storage/GeneralPreferences;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GeoFenceEntityRepository implements GeoFenceRepository, HoldLoginV1Repository {
    private final DeviceInformationProvider deviceInformationProvider;
    private final GeneralPreferences generalPreferences;
    private final GeoFenceDataFactory geoFenceDataFactory;
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final SecuredAccountPreferences securedAccountPreferences;

    public final <T> Observable<T> authenticatedRequest(Observable<T> observable) {
        Intrinsics.checkNotNullParameter(observable, "");
        Observable<T> authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(observable);
        Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
        return authenticatedRequest;
    }

    public final <T> Flow<T> authenticatedRequest(Flow<? extends T> flow) {
        Intrinsics.checkNotNullParameter(flow, "");
        return this.holdLoginV1EntityRepository.PlaceComponentResult(flow);
    }

    public final AccountEntityData createAccountData() {
        AccountEntityData createAccountData = this.holdLoginV1EntityRepository.createAccountData();
        Intrinsics.checkNotNullExpressionValue(createAccountData, "");
        return createAccountData;
    }

    public final ErrorConfigEntityData createLocalErrorConfigData() {
        ErrorConfigEntityData createLocalErrorConfigData = this.holdLoginV1EntityRepository.createLocalErrorConfigData();
        Intrinsics.checkNotNullExpressionValue(createLocalErrorConfigData, "");
        return createLocalErrorConfigData;
    }

    public final ErrorConfigEntityData createNetworkErrorConfigData() {
        ErrorConfigEntityData createNetworkErrorConfigData = this.holdLoginV1EntityRepository.createNetworkErrorConfigData();
        Intrinsics.checkNotNullExpressionValue(createNetworkErrorConfigData, "");
        return createNetworkErrorConfigData;
    }

    public final LoginEntityData createNetworkLogin() {
        LoginEntityData createNetworkLogin = this.holdLoginV1EntityRepository.createNetworkLogin();
        Intrinsics.checkNotNullExpressionValue(createNetworkLogin, "");
        return createNetworkLogin;
    }

    @Inject
    public GeoFenceEntityRepository(GeoFenceDataFactory geoFenceDataFactory, DeviceInformationProvider deviceInformationProvider, SecuredAccountPreferences securedAccountPreferences, GeneralPreferences generalPreferences, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(geoFenceDataFactory, "");
        Intrinsics.checkNotNullParameter(deviceInformationProvider, "");
        Intrinsics.checkNotNullParameter(securedAccountPreferences, "");
        Intrinsics.checkNotNullParameter(generalPreferences, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.geoFenceDataFactory = geoFenceDataFactory;
        this.deviceInformationProvider = deviceInformationProvider;
        this.securedAccountPreferences = securedAccountPreferences;
        this.generalPreferences = generalPreferences;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setRetryInterval$lambda-0  reason: not valid java name */
    public static final Boolean m1321setRetryInterval$lambda0(GeoFenceEntityRepository geoFenceEntityRepository, int i) {
        Intrinsics.checkNotNullParameter(geoFenceEntityRepository, "");
        return geoFenceEntityRepository.generalPreferences.setGeofenceRetryInterval(i);
    }

    @Override // id.dana.domain.geofence.GeoFenceRepository
    public final Observable<Boolean> setRetryInterval(final int maxRetry) {
        Observable<Boolean> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.geofence.repository.source.GeoFenceEntityRepository$$ExternalSyntheticLambda9
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean m1321setRetryInterval$lambda0;
                m1321setRetryInterval$lambda0 = GeoFenceEntityRepository.m1321setRetryInterval$lambda0(GeoFenceEntityRepository.this, maxRetry);
                return m1321setRetryInterval$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    @Override // id.dana.domain.geofence.GeoFenceRepository
    public final Observable<Long> getCurrentPOICacheTime() {
        Observable<Long> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.geofence.repository.source.GeoFenceEntityRepository$$ExternalSyntheticLambda10
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Long m1315getCurrentPOICacheTime$lambda1;
                m1315getCurrentPOICacheTime$lambda1 = GeoFenceEntityRepository.m1315getCurrentPOICacheTime$lambda1(GeoFenceEntityRepository.this);
                return m1315getCurrentPOICacheTime$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getCurrentPOICacheTime$lambda-1  reason: not valid java name */
    public static final Long m1315getCurrentPOICacheTime$lambda1(GeoFenceEntityRepository geoFenceEntityRepository) {
        Intrinsics.checkNotNullParameter(geoFenceEntityRepository, "");
        if (geoFenceEntityRepository.securedAccountPreferences.getLastUpdatePOI() == null) {
            geoFenceEntityRepository.securedAccountPreferences.saveLastUpdatePOI(Long.valueOf(System.currentTimeMillis()));
        }
        return geoFenceEntityRepository.securedAccountPreferences.getLastUpdatePOI();
    }

    @Override // id.dana.domain.geofence.GeoFenceRepository
    public final Observable<List<Poi>> getListPoi(String location) {
        Intrinsics.checkNotNullParameter(location, "");
        Observable<List<Poi>> map = authenticatedRequest(createNetworkPoiData().getListPoi(location)).doOnNext(new Consumer() { // from class: id.dana.data.geofence.repository.source.GeoFenceEntityRepository$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GeoFenceEntityRepository.m1316getListPoi$lambda2(GeoFenceEntityRepository.this, (PoiFetchResult) obj);
            }
        }).map(new Function() { // from class: id.dana.data.geofence.repository.source.GeoFenceEntityRepository$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m1317getListPoi$lambda3;
                m1317getListPoi$lambda3 = GeoFenceEntityRepository.m1317getListPoi$lambda3((PoiFetchResult) obj);
                return m1317getListPoi$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getListPoi$lambda-2  reason: not valid java name */
    public static final void m1316getListPoi$lambda2(GeoFenceEntityRepository geoFenceEntityRepository, PoiFetchResult poiFetchResult) {
        Intrinsics.checkNotNullParameter(geoFenceEntityRepository, "");
        geoFenceEntityRepository.securedAccountPreferences.saveLastUpdatePOI(Long.valueOf(System.currentTimeMillis()));
        Intrinsics.checkNotNullExpressionValue(poiFetchResult, "");
        geoFenceEntityRepository.savelistPOIs(PoiResultMapperKt.toRecentPoiEntity(poiFetchResult));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getListPoi$lambda-3  reason: not valid java name */
    public static final List m1317getListPoi$lambda3(PoiFetchResult poiFetchResult) {
        Intrinsics.checkNotNullParameter(poiFetchResult, "");
        return PoiResultMapperKt.toPoi(poiFetchResult);
    }

    private final void savelistPOIs(List<RecentPoiEntity> newPOIs) {
        PoiFetchResult blockingSingle = createLocalPoiData().getListPoi("").blockingSingle();
        Intrinsics.checkNotNullExpressionValue(blockingSingle, "");
        List<RecentPoiEntity> recentPoiEntity = PoiResultMapperKt.toRecentPoiEntity(blockingSingle);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(recentPoiEntity, 10));
        Iterator<T> it = recentPoiEntity.iterator();
        while (it.hasNext()) {
            arrayList.add(((RecentPoiEntity) it.next()).getPoiId());
        }
        final ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            createLocalPoiData().saveListPoi(newPOIs);
            return;
        }
        List<RecentPoiEntity> list = SequencesKt.toList(SequencesKt.filter(CollectionsKt.asSequence(newPOIs), new Function1<RecentPoiEntity, Boolean>() { // from class: id.dana.data.geofence.repository.source.GeoFenceEntityRepository$savelistPOIs$filteredPOIs$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(RecentPoiEntity recentPoiEntity2) {
                Intrinsics.checkNotNullParameter(recentPoiEntity2, "");
                List<String> list2 = arrayList2;
                boolean z = true;
                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                    Iterator<T> it2 = list2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        } else if (Intrinsics.areEqual((String) it2.next(), recentPoiEntity2.getPoiId())) {
                            z = false;
                            break;
                        }
                    }
                }
                return Boolean.valueOf(z);
            }
        }));
        if ((!list.isEmpty()) == true) {
            createLocalPoiData().saveListPoi(list);
        }
    }

    @Override // id.dana.domain.geofence.GeoFenceRepository
    public final Observable<Boolean> notifyPOIs(List<String> poiIds) {
        Intrinsics.checkNotNullParameter(poiIds, "");
        Observable flatMap = filterOutTodayNotifiedPoiId(poiIds).flatMap(new Function() { // from class: id.dana.data.geofence.repository.source.GeoFenceEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1320notifyPOIs$lambda5;
                m1320notifyPOIs$lambda5 = GeoFenceEntityRepository.m1320notifyPOIs$lambda5(GeoFenceEntityRepository.this, (List) obj);
                return m1320notifyPOIs$lambda5;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: notifyPOIs$lambda-5  reason: not valid java name */
    public static final ObservableSource m1320notifyPOIs$lambda5(GeoFenceEntityRepository geoFenceEntityRepository, List list) {
        Observable<Boolean> notifyByPoiIds;
        Intrinsics.checkNotNullParameter(geoFenceEntityRepository, "");
        Intrinsics.checkNotNullParameter(list, "");
        if (list.isEmpty()) {
            notifyByPoiIds = Observable.just(Boolean.FALSE);
            Intrinsics.checkNotNullExpressionValue(notifyByPoiIds, "");
        } else {
            notifyByPoiIds = geoFenceEntityRepository.notifyByPoiIds(list);
        }
        return notifyByPoiIds;
    }

    private final Observable<List<String>> filterOutTodayNotifiedPoiId(List<String> poiIds) {
        Observable<List<String>> flatMapSingle = Observable.fromIterable(poiIds).flatMapSingle(new Function() { // from class: id.dana.data.geofence.repository.source.GeoFenceEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource m1311filterOutTodayNotifiedPoiId$lambda9;
                m1311filterOutTodayNotifiedPoiId$lambda9 = GeoFenceEntityRepository.m1311filterOutTodayNotifiedPoiId$lambda9(GeoFenceEntityRepository.this, (String) obj);
                return m1311filterOutTodayNotifiedPoiId$lambda9;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMapSingle, "");
        return flatMapSingle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: filterOutTodayNotifiedPoiId$lambda-9  reason: not valid java name */
    public static final SingleSource m1311filterOutTodayNotifiedPoiId$lambda9(GeoFenceEntityRepository geoFenceEntityRepository, final String str) {
        Intrinsics.checkNotNullParameter(geoFenceEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Observable filter = geoFenceEntityRepository.createLocalPoiData().hasNotifiedToday(str).map(new Function() { // from class: id.dana.data.geofence.repository.source.GeoFenceEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Pair m1312filterOutTodayNotifiedPoiId$lambda9$lambda6;
                m1312filterOutTodayNotifiedPoiId$lambda9$lambda6 = GeoFenceEntityRepository.m1312filterOutTodayNotifiedPoiId$lambda9$lambda6(str, (Boolean) obj);
                return m1312filterOutTodayNotifiedPoiId$lambda9$lambda6;
            }
        }).filter(new Predicate() { // from class: id.dana.data.geofence.repository.source.GeoFenceEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean m1313filterOutTodayNotifiedPoiId$lambda9$lambda7;
                m1313filterOutTodayNotifiedPoiId$lambda9$lambda7 = GeoFenceEntityRepository.m1313filterOutTodayNotifiedPoiId$lambda9$lambda7((Pair) obj);
                return m1313filterOutTodayNotifiedPoiId$lambda9$lambda7;
            }
        });
        final GeoFenceEntityRepository$filterOutTodayNotifiedPoiId$1$3 geoFenceEntityRepository$filterOutTodayNotifiedPoiId$1$3 = new PropertyReference1Impl() { // from class: id.dana.data.geofence.repository.source.GeoFenceEntityRepository$filterOutTodayNotifiedPoiId$1$3
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public final Object get(Object obj) {
                return ((Pair) obj).getFirst();
            }
        };
        return filter.map(new Function() { // from class: id.dana.data.geofence.repository.source.GeoFenceEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String m1314filterOutTodayNotifiedPoiId$lambda9$lambda8;
                m1314filterOutTodayNotifiedPoiId$lambda9$lambda8 = GeoFenceEntityRepository.m1314filterOutTodayNotifiedPoiId$lambda9$lambda8(KProperty1.this, (Pair) obj);
                return m1314filterOutTodayNotifiedPoiId$lambda9$lambda8;
            }
        }).toList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: filterOutTodayNotifiedPoiId$lambda-9$lambda-6  reason: not valid java name */
    public static final Pair m1312filterOutTodayNotifiedPoiId$lambda9$lambda6(String str, Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(bool, "");
        return TuplesKt.to(str, bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: filterOutTodayNotifiedPoiId$lambda-9$lambda-7  reason: not valid java name */
    public static final boolean m1313filterOutTodayNotifiedPoiId$lambda9$lambda7(Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "");
        return !((Boolean) pair.getSecond()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: filterOutTodayNotifiedPoiId$lambda-9$lambda-8  reason: not valid java name */
    public static final String m1314filterOutTodayNotifiedPoiId$lambda9$lambda8(KProperty1 kProperty1, Pair pair) {
        Intrinsics.checkNotNullParameter(kProperty1, "");
        return (String) kProperty1.invoke(pair);
    }

    private final Observable<Boolean> notifyByPoiIds(final List<String> poiIds) {
        Observable<Boolean> map = authenticatedRequest(createNetworkPoiData().notifyPois(PoiResultMapperKt.toPoiNotificationInfo(poiIds, this.deviceInformationProvider))).retryWhen(new RetryWithDelay(this.generalPreferences.getGeofenceRetryInterval(), 1500L)).doOnNext(new Consumer() { // from class: id.dana.data.geofence.repository.source.GeoFenceEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GeoFenceEntityRepository.m1318notifyByPoiIds$lambda10(GeoFenceEntityRepository.this, poiIds, (BaseRpcResult) obj);
            }
        }).map(new Function() { // from class: id.dana.data.geofence.repository.source.GeoFenceEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean m1319notifyByPoiIds$lambda11;
                m1319notifyByPoiIds$lambda11 = GeoFenceEntityRepository.m1319notifyByPoiIds$lambda11((BaseRpcResult) obj);
                return m1319notifyByPoiIds$lambda11;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: notifyByPoiIds$lambda-10  reason: not valid java name */
    public static final void m1318notifyByPoiIds$lambda10(GeoFenceEntityRepository geoFenceEntityRepository, List list, BaseRpcResult baseRpcResult) {
        Intrinsics.checkNotNullParameter(geoFenceEntityRepository, "");
        Intrinsics.checkNotNullParameter(list, "");
        if (baseRpcResult.success) {
            geoFenceEntityRepository.createLocalPoiData().saveLastPoiNotificationDate(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: notifyByPoiIds$lambda-11  reason: not valid java name */
    public static final Boolean m1319notifyByPoiIds$lambda11(BaseRpcResult baseRpcResult) {
        Intrinsics.checkNotNullParameter(baseRpcResult, "");
        return Boolean.valueOf(baseRpcResult.success);
    }

    private final GeoFenceEntityData createNetworkPoiData() {
        return this.geoFenceDataFactory.createData2("network");
    }

    private final GeoFenceEntityData createLocalPoiData() {
        return this.geoFenceDataFactory.createData2("local");
    }
}
