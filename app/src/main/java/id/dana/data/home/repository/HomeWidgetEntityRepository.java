package id.dana.data.home.repository;

import id.dana.data.danaprotection.repository.source.local.DanaProtectionInfoPreference;
import id.dana.data.foundation.facade.SecurityGuardFacade;
import id.dana.data.foundation.utils.CommonUtil;
import id.dana.data.home.mapper.MoreForYouMapperKt;
import id.dana.data.home.mapper.NewsWidgetActivityMapperKt;
import id.dana.data.home.mapper.PromoBannerAnnouncementMapperKt;
import id.dana.data.home.mapper.PromoBannerContentMapperKt;
import id.dana.data.home.mapper.SingleBalanceMapperKt;
import id.dana.data.home.repository.source.local.DanaProtectionHomeWidgetPreference;
import id.dana.data.home.repository.source.presistence.PersistenceHomeWidgetEntityData;
import id.dana.data.home.repository.source.presistence.SingleBalanceProcessing;
import id.dana.data.home.repository.source.presistence.dao.MoreForYouDao;
import id.dana.data.home.repository.source.presistence.dao.NewsWidgetActivityDao;
import id.dana.data.home.repository.source.presistence.dao.PromoBannerAnnouncementDao;
import id.dana.data.home.repository.source.presistence.dao.PromoBannerContentDao;
import id.dana.data.home.repository.source.presistence.entity.MoreForYouDaoEntity;
import id.dana.data.home.repository.source.presistence.entity.NewsWidgetActivityDaoEntity;
import id.dana.data.home.repository.source.presistence.entity.PromoBannerAnnouncementDaoEntity;
import id.dana.data.home.repository.source.presistence.entity.PromoBannerContentDaoEntity;
import id.dana.data.home.repository.source.presistence.entity.SingleBalanceDaoEntity;
import id.dana.domain.danaprotection.model.DanaProtectionWidgetConfig;
import id.dana.domain.feeds.model.ActivityData;
import id.dana.domain.home.HomeWidgetRepository;
import id.dana.domain.home.model.DanaProtectionHomeWidgetInfoModel;
import id.dana.domain.home.model.DanaProtectionHomeWidgetModel;
import id.dana.domain.home.model.MoreForYouData;
import id.dana.domain.home.model.PromoBannerAnnouncementModel;
import id.dana.domain.home.model.PromoBannerContentModel;
import id.dana.domain.user.CurrencyAmount;
import id.dana.utils.extension.StringExtKt;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020$\u0012\u0006\u0010*\u001a\u00020\u001d\u0012\u0006\u0010+\u001a\u00020!\u0012\u0006\u0010,\u001a\u00020'¢\u0006\u0004\b-\u0010.J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u001b\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0005J\u001b\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0005J\u001b\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\b0\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0005J\u001b\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\b0\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0005J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0018\u001a\u00020\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001a\u001a\u00020\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH\u0016¢\u0006\u0004\b\u001a\u0010\u0019J\u001d\u0010\u001b\u001a\u00020\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\bH\u0016¢\u0006\u0004\b\u001b\u0010\u0019J\u001d\u0010\u001c\u001a\u00020\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\bH\u0016¢\u0006\u0004\b\u001c\u0010\u0019R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010%R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010("}, d2 = {"Lid/dana/data/home/repository/HomeWidgetEntityRepository;", "Lid/dana/domain/home/HomeWidgetRepository;", "Lio/reactivex/Observable;", "Lid/dana/domain/user/CurrencyAmount;", "getBalanceFromPersistence", "()Lio/reactivex/Observable;", "Lid/dana/domain/home/model/DanaProtectionHomeWidgetModel;", "getDanaProtectionHomeWidgetInfoWithConfigFromLocal", "", "Lid/dana/domain/home/model/MoreForYouData;", "getMoreForYouDataFromPersistence", "Lid/dana/domain/feeds/model/ActivityData;", "getNewsWidgetActivitiesFromPersistence", "Lid/dana/domain/home/model/PromoBannerAnnouncementModel;", "getPromoBannerAnnouncementFromPersistence", "Lid/dana/domain/home/model/PromoBannerContentModel;", "getPromoBannerCdpContentFromPersistence", "p0", "Lio/reactivex/Completable;", "saveBalanceIntoPersistence", "(Lid/dana/domain/user/CurrencyAmount;)Lio/reactivex/Completable;", "Lid/dana/domain/home/model/DanaProtectionHomeWidgetInfoModel;", "saveDanaProtectionHomeWidgetInfoLocal", "(Lid/dana/domain/home/model/DanaProtectionHomeWidgetInfoModel;)Lio/reactivex/Completable;", "saveMoreForYouDataIntoPersistence", "(Ljava/util/List;)Lio/reactivex/Completable;", "saveNewsWidgetActivitiesIntoPersistence", "savePromoBannerAnnouncementIntoPersistence", "savePromoBannerCdpContentIntoPersistence", "Lid/dana/data/home/repository/source/local/DanaProtectionHomeWidgetPreference;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/home/repository/source/local/DanaProtectionHomeWidgetPreference;", "PlaceComponentResult", "Lid/dana/data/danaprotection/repository/source/local/DanaProtectionInfoPreference;", "Lid/dana/data/danaprotection/repository/source/local/DanaProtectionInfoPreference;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/home/repository/source/presistence/PersistenceHomeWidgetEntityData;", "Lid/dana/data/home/repository/source/presistence/PersistenceHomeWidgetEntityData;", "getAuthRequestContext", "Lid/dana/data/foundation/facade/SecurityGuardFacade;", "Lid/dana/data/foundation/facade/SecurityGuardFacade;", "MyBillsEntityDataFactory", "p1", "p2", "p3", "<init>", "(Lid/dana/data/home/repository/source/presistence/PersistenceHomeWidgetEntityData;Lid/dana/data/home/repository/source/local/DanaProtectionHomeWidgetPreference;Lid/dana/data/danaprotection/repository/source/local/DanaProtectionInfoPreference;Lid/dana/data/foundation/facade/SecurityGuardFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HomeWidgetEntityRepository implements HomeWidgetRepository {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final PersistenceHomeWidgetEntityData getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final DanaProtectionHomeWidgetPreference PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final DanaProtectionInfoPreference BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final SecurityGuardFacade MyBillsEntityDataFactory;

    @Inject
    public HomeWidgetEntityRepository(PersistenceHomeWidgetEntityData persistenceHomeWidgetEntityData, DanaProtectionHomeWidgetPreference danaProtectionHomeWidgetPreference, DanaProtectionInfoPreference danaProtectionInfoPreference, SecurityGuardFacade securityGuardFacade) {
        Intrinsics.checkNotNullParameter(persistenceHomeWidgetEntityData, "");
        Intrinsics.checkNotNullParameter(danaProtectionHomeWidgetPreference, "");
        Intrinsics.checkNotNullParameter(danaProtectionInfoPreference, "");
        Intrinsics.checkNotNullParameter(securityGuardFacade, "");
        this.getAuthRequestContext = persistenceHomeWidgetEntityData;
        this.PlaceComponentResult = danaProtectionHomeWidgetPreference;
        this.BuiltInFictitiousFunctionClassFactory = danaProtectionInfoPreference;
        this.MyBillsEntityDataFactory = securityGuardFacade;
    }

    @Override // id.dana.domain.home.HomeWidgetRepository
    public final Observable<CurrencyAmount> getBalanceFromPersistence() {
        final String MyBillsEntityDataFactory = CommonUtil.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory, "");
        final PersistenceHomeWidgetEntityData persistenceHomeWidgetEntityData = this.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(MyBillsEntityDataFactory, "");
        Observable<SingleBalanceDaoEntity> BuiltInFictitiousFunctionClassFactory = SingleBalanceProcessing.BuiltInFictitiousFunctionClassFactory();
        ThreadsKt.thread((r12 & 1) != 0, (r12 & 2) != 0 ? false : false, (r12 & 4) != 0 ? null : null, (r12 & 8) != 0 ? null : null, (r12 & 16) != 0 ? -1 : 0, new Function0<Unit>() { // from class: id.dana.data.home.repository.source.presistence.PersistenceHomeWidgetEntityData$getBalance$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Object m3179constructorimpl;
                SingleBalanceDaoEntity singleBalanceDaoEntity = new SingleBalanceDaoEntity(null, "0", "Rp.", true, 1, null);
                PersistenceHomeWidgetEntityData persistenceHomeWidgetEntityData2 = PersistenceHomeWidgetEntityData.this;
                String str = MyBillsEntityDataFactory;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    m3179constructorimpl = Result.m3179constructorimpl(persistenceHomeWidgetEntityData2.getDb().singleBalanceDao().MyBillsEntityDataFactory(str));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m3179constructorimpl = Result.m3179constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m3186isSuccessimpl(m3179constructorimpl)) {
                    SingleBalanceDaoEntity singleBalanceDaoEntity2 = (SingleBalanceDaoEntity) m3179constructorimpl;
                    if (singleBalanceDaoEntity2 == null) {
                        SingleBalanceProcessing.KClassImpl$Data$declaredNonStaticMembers$2(singleBalanceDaoEntity);
                    } else {
                        SingleBalanceProcessing.KClassImpl$Data$declaredNonStaticMembers$2(singleBalanceDaoEntity2);
                    }
                }
                if (Result.m3182exceptionOrNullimpl(m3179constructorimpl) != null) {
                    SingleBalanceProcessing.KClassImpl$Data$declaredNonStaticMembers$2(singleBalanceDaoEntity);
                }
            }
        });
        Observable map = BuiltInFictitiousFunctionClassFactory.map(new Function() { // from class: id.dana.data.home.repository.HomeWidgetEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return HomeWidgetEntityRepository.getAuthRequestContext((SingleBalanceDaoEntity) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.home.HomeWidgetRepository
    public final Completable saveBalanceIntoPersistence(CurrencyAmount p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String MyBillsEntityDataFactory = CommonUtil.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory, "");
        final PersistenceHomeWidgetEntityData persistenceHomeWidgetEntityData = this.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        final SingleBalanceDaoEntity authRequestContext = SingleBalanceMapperKt.getAuthRequestContext(p0, MyBillsEntityDataFactory);
        Intrinsics.checkNotNullParameter(authRequestContext, "");
        ThreadsKt.thread((r12 & 1) != 0, (r12 & 2) != 0 ? false : false, (r12 & 4) != 0 ? null : null, (r12 & 8) != 0 ? null : null, (r12 & 16) != 0 ? -1 : 0, new Function0<Unit>() { // from class: id.dana.data.home.repository.source.presistence.PersistenceHomeWidgetEntityData$saveBalance$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PersistenceHomeWidgetEntityData persistenceHomeWidgetEntityData2 = PersistenceHomeWidgetEntityData.this;
                SingleBalanceDaoEntity singleBalanceDaoEntity = authRequestContext;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    persistenceHomeWidgetEntityData2.getDb().singleBalanceDao().MyBillsEntityDataFactory(singleBalanceDaoEntity);
                    Result.m3179constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m3179constructorimpl(ResultKt.createFailure(th));
                }
                SingleBalanceProcessing.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext);
            }
        });
        Completable MyBillsEntityDataFactory2 = Completable.MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory2, "");
        return MyBillsEntityDataFactory2;
    }

    @Override // id.dana.domain.home.HomeWidgetRepository
    public final Observable<List<ActivityData>> getNewsWidgetActivitiesFromPersistence() {
        final PersistenceHomeWidgetEntityData persistenceHomeWidgetEntityData = this.getAuthRequestContext;
        Observable doOnNext = PersistenceHomeWidgetEntityData.KClassImpl$Data$declaredNonStaticMembers$2(new Function0<List<? extends NewsWidgetActivityDaoEntity>>() { // from class: id.dana.data.home.repository.source.presistence.PersistenceHomeWidgetEntityData$getNewsWidgetActivities$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends NewsWidgetActivityDaoEntity> invoke() {
                return PersistenceHomeWidgetEntityData.this.getDb().newsWidgetActivityDao().BuiltInFictitiousFunctionClassFactory();
            }
        }).doOnNext(new Consumer() { // from class: id.dana.data.home.repository.source.presistence.PersistenceHomeWidgetEntityData$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PersistenceHomeWidgetEntityData.getAuthRequestContext(PersistenceHomeWidgetEntityData.this, (List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(doOnNext, "");
        Observable<List<ActivityData>> map = doOnNext.map(new Function() { // from class: id.dana.data.home.repository.HomeWidgetEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return HomeWidgetEntityRepository.MyBillsEntityDataFactory((List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.home.HomeWidgetRepository
    public final Completable saveNewsWidgetActivitiesIntoPersistence(List<? extends ActivityData> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        final PersistenceHomeWidgetEntityData persistenceHomeWidgetEntityData = this.getAuthRequestContext;
        List<NewsWidgetActivityDaoEntity> KClassImpl$Data$declaredNonStaticMembers$2 = NewsWidgetActivityMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(p0);
        Intrinsics.checkNotNullParameter(KClassImpl$Data$declaredNonStaticMembers$2, "");
        List<NewsWidgetActivityDaoEntity> list = KClassImpl$Data$declaredNonStaticMembers$2;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (NewsWidgetActivityDaoEntity newsWidgetActivityDaoEntity : list) {
            if (newsWidgetActivityDaoEntity.MyBillsEntityDataFactory.length() == 0) {
                StringBuilder sb = new StringBuilder();
                String str = newsWidgetActivityDaoEntity.PlaceComponentResult;
                sb.append(str != null ? StringsKt.trim((CharSequence) str).toString() : null);
                String str2 = newsWidgetActivityDaoEntity.BuiltInFictitiousFunctionClassFactory;
                sb.append(str2 != null ? StringsKt.trim((CharSequence) str2).toString() : null);
                String PlaceComponentResult = StringExtKt.PlaceComponentResult(sb.toString());
                Intrinsics.checkNotNullParameter(PlaceComponentResult, "");
                newsWidgetActivityDaoEntity.MyBillsEntityDataFactory = PlaceComponentResult;
            }
            arrayList.add(newsWidgetActivityDaoEntity);
        }
        final ArrayList arrayList2 = arrayList;
        Completable ignoreElements = PersistenceHomeWidgetEntityData.KClassImpl$Data$declaredNonStaticMembers$2(new Function0<Unit>() { // from class: id.dana.data.home.repository.source.presistence.PersistenceHomeWidgetEntityData$saveNewsWidgetActivites$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                List list2;
                List list3;
                List list4;
                PersistenceHomeWidgetEntityData persistenceHomeWidgetEntityData2 = PersistenceHomeWidgetEntityData.this;
                List sortedWith = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: id.dana.data.home.repository.source.presistence.PersistenceHomeWidgetEntityData$saveNewsWidgetActivites$2$1$invoke$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((NewsWidgetActivityDaoEntity) t).MyBillsEntityDataFactory, ((NewsWidgetActivityDaoEntity) t2).MyBillsEntityDataFactory);
                    }
                });
                list2 = PersistenceHomeWidgetEntityData.this.KClassImpl$Data$declaredNonStaticMembers$2;
                Triple MyBillsEntityDataFactory = PersistenceHomeWidgetEntityData.MyBillsEntityDataFactory(persistenceHomeWidgetEntityData2, sortedWith, CollectionsKt.sortedWith(list2, new Comparator() { // from class: id.dana.data.home.repository.source.presistence.PersistenceHomeWidgetEntityData$saveNewsWidgetActivites$2$1$invoke$$inlined$sortedBy$2
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((NewsWidgetActivityDaoEntity) t).MyBillsEntityDataFactory, ((NewsWidgetActivityDaoEntity) t2).MyBillsEntityDataFactory);
                    }
                }));
                List list5 = (List) MyBillsEntityDataFactory.component1();
                List list6 = (List) MyBillsEntityDataFactory.component2();
                List list7 = (List) MyBillsEntityDataFactory.component3();
                list3 = PersistenceHomeWidgetEntityData.this.KClassImpl$Data$declaredNonStaticMembers$2;
                list3.clear();
                list4 = PersistenceHomeWidgetEntityData.this.KClassImpl$Data$declaredNonStaticMembers$2;
                list4.addAll(list7);
                NewsWidgetActivityDao newsWidgetActivityDao = PersistenceHomeWidgetEntityData.this.getDb().newsWidgetActivityDao();
                List list8 = list6;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list8, 10));
                Iterator it = list8.iterator();
                while (it.hasNext()) {
                    arrayList3.add(((NewsWidgetActivityDaoEntity) it.next()).MyBillsEntityDataFactory);
                }
                newsWidgetActivityDao.PlaceComponentResult(arrayList3);
                NewsWidgetActivityDao newsWidgetActivityDao2 = PersistenceHomeWidgetEntityData.this.getDb().newsWidgetActivityDao();
                Object[] array = list5.toArray(new NewsWidgetActivityDaoEntity[0]);
                if (array != null) {
                    NewsWidgetActivityDaoEntity[] newsWidgetActivityDaoEntityArr = (NewsWidgetActivityDaoEntity[]) array;
                    newsWidgetActivityDao2.MyBillsEntityDataFactory((NewsWidgetActivityDaoEntity[]) Arrays.copyOf(newsWidgetActivityDaoEntityArr, newsWidgetActivityDaoEntityArr.length));
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
        }).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "");
        return ignoreElements;
    }

    @Override // id.dana.domain.home.HomeWidgetRepository
    public final Observable<List<PromoBannerContentModel>> getPromoBannerCdpContentFromPersistence() {
        final PersistenceHomeWidgetEntityData persistenceHomeWidgetEntityData = this.getAuthRequestContext;
        Observable doOnNext = PersistenceHomeWidgetEntityData.KClassImpl$Data$declaredNonStaticMembers$2(new Function0<List<? extends PromoBannerContentDaoEntity>>() { // from class: id.dana.data.home.repository.source.presistence.PersistenceHomeWidgetEntityData$getPromoBannerContent$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends PromoBannerContentDaoEntity> invoke() {
                return PersistenceHomeWidgetEntityData.this.getDb().promoBannerContentDao().KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }).flatMap(new Function() { // from class: id.dana.data.home.repository.source.presistence.PersistenceHomeWidgetEntityData$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PersistenceHomeWidgetEntityData.BuiltInFictitiousFunctionClassFactory((List) obj);
            }
        }).doOnNext(new Consumer() { // from class: id.dana.data.home.repository.source.presistence.PersistenceHomeWidgetEntityData$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PersistenceHomeWidgetEntityData.BuiltInFictitiousFunctionClassFactory(PersistenceHomeWidgetEntityData.this, (List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(doOnNext, "");
        Observable<List<PromoBannerContentModel>> map = doOnNext.map(new Function() { // from class: id.dana.data.home.repository.HomeWidgetEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return HomeWidgetEntityRepository.PlaceComponentResult((List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.home.HomeWidgetRepository
    public final Completable savePromoBannerCdpContentIntoPersistence(List<PromoBannerContentModel> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        final PersistenceHomeWidgetEntityData persistenceHomeWidgetEntityData = this.getAuthRequestContext;
        final List<PromoBannerContentDaoEntity> KClassImpl$Data$declaredNonStaticMembers$2 = PromoBannerContentMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(p0);
        Intrinsics.checkNotNullParameter(KClassImpl$Data$declaredNonStaticMembers$2, "");
        Completable ignoreElements = PersistenceHomeWidgetEntityData.KClassImpl$Data$declaredNonStaticMembers$2(new Function0<Unit>() { // from class: id.dana.data.home.repository.source.presistence.PersistenceHomeWidgetEntityData$savePromoBannerContent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                List list;
                List list2;
                List list3;
                PersistenceHomeWidgetEntityData persistenceHomeWidgetEntityData2 = PersistenceHomeWidgetEntityData.this;
                List sortedWith = CollectionsKt.sortedWith(KClassImpl$Data$declaredNonStaticMembers$2, new Comparator() { // from class: id.dana.data.home.repository.source.presistence.PersistenceHomeWidgetEntityData$savePromoBannerContent$1$invoke$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((PromoBannerContentDaoEntity) t).getAuthRequestContext, ((PromoBannerContentDaoEntity) t2).getAuthRequestContext);
                    }
                });
                list = PersistenceHomeWidgetEntityData.this.PlaceComponentResult;
                Triple MyBillsEntityDataFactory = PersistenceHomeWidgetEntityData.MyBillsEntityDataFactory(persistenceHomeWidgetEntityData2, sortedWith, CollectionsKt.sortedWith(list, new Comparator() { // from class: id.dana.data.home.repository.source.presistence.PersistenceHomeWidgetEntityData$savePromoBannerContent$1$invoke$$inlined$sortedBy$2
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((PromoBannerContentDaoEntity) t).getAuthRequestContext, ((PromoBannerContentDaoEntity) t2).getAuthRequestContext);
                    }
                }));
                List list4 = (List) MyBillsEntityDataFactory.component1();
                List list5 = (List) MyBillsEntityDataFactory.component2();
                List list6 = (List) MyBillsEntityDataFactory.component3();
                list2 = PersistenceHomeWidgetEntityData.this.PlaceComponentResult;
                list2.clear();
                list3 = PersistenceHomeWidgetEntityData.this.PlaceComponentResult;
                list3.addAll(list6);
                PromoBannerContentDao promoBannerContentDao = PersistenceHomeWidgetEntityData.this.getDb().promoBannerContentDao();
                List list7 = list5;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list7, 10));
                Iterator it = list7.iterator();
                while (it.hasNext()) {
                    arrayList.add(((PromoBannerContentDaoEntity) it.next()).getAuthRequestContext);
                }
                promoBannerContentDao.getAuthRequestContext(arrayList);
                PromoBannerContentDao promoBannerContentDao2 = PersistenceHomeWidgetEntityData.this.getDb().promoBannerContentDao();
                Object[] array = list4.toArray(new PromoBannerContentDaoEntity[0]);
                if (array != null) {
                    PromoBannerContentDaoEntity[] promoBannerContentDaoEntityArr = (PromoBannerContentDaoEntity[]) array;
                    promoBannerContentDao2.KClassImpl$Data$declaredNonStaticMembers$2((PromoBannerContentDaoEntity[]) Arrays.copyOf(promoBannerContentDaoEntityArr, promoBannerContentDaoEntityArr.length));
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
        }).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "");
        return ignoreElements;
    }

    @Override // id.dana.domain.home.HomeWidgetRepository
    public final Observable<List<PromoBannerAnnouncementModel>> getPromoBannerAnnouncementFromPersistence() {
        final PersistenceHomeWidgetEntityData persistenceHomeWidgetEntityData = this.getAuthRequestContext;
        Observable doOnNext = PersistenceHomeWidgetEntityData.KClassImpl$Data$declaredNonStaticMembers$2(new Function0<List<? extends PromoBannerAnnouncementDaoEntity>>() { // from class: id.dana.data.home.repository.source.presistence.PersistenceHomeWidgetEntityData$getPromoBannerAnnouncement$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends PromoBannerAnnouncementDaoEntity> invoke() {
                return PersistenceHomeWidgetEntityData.this.getDb().promoBannerAnnouncementDao().PlaceComponentResult();
            }
        }).flatMap(new Function() { // from class: id.dana.data.home.repository.source.presistence.PersistenceHomeWidgetEntityData$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PersistenceHomeWidgetEntityData.MyBillsEntityDataFactory((List) obj);
            }
        }).doOnNext(new Consumer() { // from class: id.dana.data.home.repository.source.presistence.PersistenceHomeWidgetEntityData$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PersistenceHomeWidgetEntityData.MyBillsEntityDataFactory(PersistenceHomeWidgetEntityData.this, (List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(doOnNext, "");
        Observable<List<PromoBannerAnnouncementModel>> map = doOnNext.map(new Function() { // from class: id.dana.data.home.repository.HomeWidgetEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return HomeWidgetEntityRepository.BuiltInFictitiousFunctionClassFactory((List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.home.HomeWidgetRepository
    public final Completable savePromoBannerAnnouncementIntoPersistence(List<PromoBannerAnnouncementModel> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        final PersistenceHomeWidgetEntityData persistenceHomeWidgetEntityData = this.getAuthRequestContext;
        final List<PromoBannerAnnouncementDaoEntity> MyBillsEntityDataFactory = PromoBannerAnnouncementMapperKt.MyBillsEntityDataFactory(p0);
        Intrinsics.checkNotNullParameter(MyBillsEntityDataFactory, "");
        Completable ignoreElements = PersistenceHomeWidgetEntityData.KClassImpl$Data$declaredNonStaticMembers$2(new Function0<Unit>() { // from class: id.dana.data.home.repository.source.presistence.PersistenceHomeWidgetEntityData$savePromoBannerAnnouncement$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                List list;
                List list2;
                List list3;
                PersistenceHomeWidgetEntityData persistenceHomeWidgetEntityData2 = PersistenceHomeWidgetEntityData.this;
                List sortedWith = CollectionsKt.sortedWith(MyBillsEntityDataFactory, new Comparator() { // from class: id.dana.data.home.repository.source.presistence.PersistenceHomeWidgetEntityData$savePromoBannerAnnouncement$1$invoke$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((PromoBannerAnnouncementDaoEntity) t).initRecordTimeStamp, ((PromoBannerAnnouncementDaoEntity) t2).initRecordTimeStamp);
                    }
                });
                list = PersistenceHomeWidgetEntityData.this.BuiltInFictitiousFunctionClassFactory;
                Triple MyBillsEntityDataFactory2 = PersistenceHomeWidgetEntityData.MyBillsEntityDataFactory(persistenceHomeWidgetEntityData2, sortedWith, CollectionsKt.sortedWith(list, new Comparator() { // from class: id.dana.data.home.repository.source.presistence.PersistenceHomeWidgetEntityData$savePromoBannerAnnouncement$1$invoke$$inlined$sortedBy$2
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((PromoBannerAnnouncementDaoEntity) t).initRecordTimeStamp, ((PromoBannerAnnouncementDaoEntity) t2).initRecordTimeStamp);
                    }
                }));
                List list4 = (List) MyBillsEntityDataFactory2.component1();
                List list5 = (List) MyBillsEntityDataFactory2.component2();
                List list6 = (List) MyBillsEntityDataFactory2.component3();
                list2 = PersistenceHomeWidgetEntityData.this.BuiltInFictitiousFunctionClassFactory;
                list2.clear();
                list3 = PersistenceHomeWidgetEntityData.this.BuiltInFictitiousFunctionClassFactory;
                list3.addAll(list6);
                PromoBannerAnnouncementDao promoBannerAnnouncementDao = PersistenceHomeWidgetEntityData.this.getDb().promoBannerAnnouncementDao();
                List list7 = list5;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list7, 10));
                Iterator it = list7.iterator();
                while (it.hasNext()) {
                    arrayList.add(((PromoBannerAnnouncementDaoEntity) it.next()).initRecordTimeStamp);
                }
                promoBannerAnnouncementDao.getAuthRequestContext(arrayList);
                PromoBannerAnnouncementDao promoBannerAnnouncementDao2 = PersistenceHomeWidgetEntityData.this.getDb().promoBannerAnnouncementDao();
                Object[] array = list4.toArray(new PromoBannerAnnouncementDaoEntity[0]);
                if (array != null) {
                    PromoBannerAnnouncementDaoEntity[] promoBannerAnnouncementDaoEntityArr = (PromoBannerAnnouncementDaoEntity[]) array;
                    promoBannerAnnouncementDao2.getAuthRequestContext((PromoBannerAnnouncementDaoEntity[]) Arrays.copyOf(promoBannerAnnouncementDaoEntityArr, promoBannerAnnouncementDaoEntityArr.length));
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
        }).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "");
        return ignoreElements;
    }

    @Override // id.dana.domain.home.HomeWidgetRepository
    public final Observable<List<MoreForYouData>> getMoreForYouDataFromPersistence() {
        final PersistenceHomeWidgetEntityData persistenceHomeWidgetEntityData = this.getAuthRequestContext;
        Observable doOnNext = PersistenceHomeWidgetEntityData.KClassImpl$Data$declaredNonStaticMembers$2(new Function0<List<? extends MoreForYouDaoEntity>>() { // from class: id.dana.data.home.repository.source.presistence.PersistenceHomeWidgetEntityData$getMoreForYouData$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends MoreForYouDaoEntity> invoke() {
                return PersistenceHomeWidgetEntityData.this.getDb().moreForYouDao().PlaceComponentResult();
            }
        }).flatMap(new Function() { // from class: id.dana.data.home.repository.source.presistence.PersistenceHomeWidgetEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PersistenceHomeWidgetEntityData.KClassImpl$Data$declaredNonStaticMembers$2((List) obj);
            }
        }).doOnNext(new Consumer() { // from class: id.dana.data.home.repository.source.presistence.PersistenceHomeWidgetEntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PersistenceHomeWidgetEntityData.KClassImpl$Data$declaredNonStaticMembers$2(PersistenceHomeWidgetEntityData.this, (List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(doOnNext, "");
        Observable<List<MoreForYouData>> map = doOnNext.map(new Function() { // from class: id.dana.data.home.repository.HomeWidgetEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return HomeWidgetEntityRepository.getAuthRequestContext((List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.home.HomeWidgetRepository
    public final Completable saveMoreForYouDataIntoPersistence(List<MoreForYouData> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        final PersistenceHomeWidgetEntityData persistenceHomeWidgetEntityData = this.getAuthRequestContext;
        final List<MoreForYouDaoEntity> MyBillsEntityDataFactory = MoreForYouMapperKt.MyBillsEntityDataFactory(p0);
        Intrinsics.checkNotNullParameter(MyBillsEntityDataFactory, "");
        Completable ignoreElements = PersistenceHomeWidgetEntityData.KClassImpl$Data$declaredNonStaticMembers$2(new Function0<Unit>() { // from class: id.dana.data.home.repository.source.presistence.PersistenceHomeWidgetEntityData$saveMoreForYouData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                List list;
                List list2;
                List list3;
                PersistenceHomeWidgetEntityData persistenceHomeWidgetEntityData2 = PersistenceHomeWidgetEntityData.this;
                List sortedWith = CollectionsKt.sortedWith(MyBillsEntityDataFactory, new Comparator() { // from class: id.dana.data.home.repository.source.presistence.PersistenceHomeWidgetEntityData$saveMoreForYouData$1$invoke$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((MoreForYouDaoEntity) t).KClassImpl$Data$declaredNonStaticMembers$2, ((MoreForYouDaoEntity) t2).KClassImpl$Data$declaredNonStaticMembers$2);
                    }
                });
                list = PersistenceHomeWidgetEntityData.this.MyBillsEntityDataFactory;
                Triple MyBillsEntityDataFactory2 = PersistenceHomeWidgetEntityData.MyBillsEntityDataFactory(persistenceHomeWidgetEntityData2, sortedWith, CollectionsKt.sortedWith(list, new Comparator() { // from class: id.dana.data.home.repository.source.presistence.PersistenceHomeWidgetEntityData$saveMoreForYouData$1$invoke$$inlined$sortedBy$2
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((MoreForYouDaoEntity) t).KClassImpl$Data$declaredNonStaticMembers$2, ((MoreForYouDaoEntity) t2).KClassImpl$Data$declaredNonStaticMembers$2);
                    }
                }));
                List list4 = (List) MyBillsEntityDataFactory2.component1();
                List list5 = (List) MyBillsEntityDataFactory2.component2();
                List list6 = (List) MyBillsEntityDataFactory2.component3();
                list2 = PersistenceHomeWidgetEntityData.this.MyBillsEntityDataFactory;
                list2.clear();
                list3 = PersistenceHomeWidgetEntityData.this.MyBillsEntityDataFactory;
                list3.addAll(list6);
                MoreForYouDao moreForYouDao = PersistenceHomeWidgetEntityData.this.getDb().moreForYouDao();
                List list7 = list5;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list7, 10));
                Iterator it = list7.iterator();
                while (it.hasNext()) {
                    arrayList.add(((MoreForYouDaoEntity) it.next()).KClassImpl$Data$declaredNonStaticMembers$2);
                }
                moreForYouDao.KClassImpl$Data$declaredNonStaticMembers$2(arrayList);
                MoreForYouDao moreForYouDao2 = PersistenceHomeWidgetEntityData.this.getDb().moreForYouDao();
                Object[] array = list4.toArray(new MoreForYouDaoEntity[0]);
                if (array != null) {
                    MoreForYouDaoEntity[] moreForYouDaoEntityArr = (MoreForYouDaoEntity[]) array;
                    moreForYouDao2.MyBillsEntityDataFactory((MoreForYouDaoEntity[]) Arrays.copyOf(moreForYouDaoEntityArr, moreForYouDaoEntityArr.length));
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
        }).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "");
        return ignoreElements;
    }

    @Override // id.dana.domain.home.HomeWidgetRepository
    public final Completable saveDanaProtectionHomeWidgetInfoLocal(DanaProtectionHomeWidgetInfoModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        DanaProtectionHomeWidgetPreference danaProtectionHomeWidgetPreference = this.PlaceComponentResult;
        Intrinsics.checkNotNullParameter(p0, "");
        danaProtectionHomeWidgetPreference.MyBillsEntityDataFactory.saveData("DANA_PROTECTION_HOME_WIDGET_DATA", danaProtectionHomeWidgetPreference.KClassImpl$Data$declaredNonStaticMembers$2.toJson(p0, DanaProtectionHomeWidgetInfoModel.class));
        Completable ignoreElements = Observable.just(Unit.INSTANCE).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "");
        return ignoreElements;
    }

    @Override // id.dana.domain.home.HomeWidgetRepository
    public final Observable<DanaProtectionHomeWidgetModel> getDanaProtectionHomeWidgetInfoWithConfigFromLocal() {
        DanaProtectionWidgetConfig KClassImpl$Data$declaredNonStaticMembers$2 = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2();
        DanaProtectionHomeWidgetPreference danaProtectionHomeWidgetPreference = this.PlaceComponentResult;
        Observable<DanaProtectionHomeWidgetModel> just = Observable.just(new DanaProtectionHomeWidgetModel(KClassImpl$Data$declaredNonStaticMembers$2, (DanaProtectionHomeWidgetInfoModel) danaProtectionHomeWidgetPreference.KClassImpl$Data$declaredNonStaticMembers$2.fromJson(danaProtectionHomeWidgetPreference.MyBillsEntityDataFactory.getString("DANA_PROTECTION_HOME_WIDGET_DATA"), DanaProtectionHomeWidgetInfoModel.class)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    public static /* synthetic */ List BuiltInFictitiousFunctionClassFactory(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        return PromoBannerAnnouncementMapperKt.getAuthRequestContext(list);
    }

    public static /* synthetic */ List getAuthRequestContext(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        return MoreForYouMapperKt.PlaceComponentResult(list);
    }

    public static /* synthetic */ CurrencyAmount getAuthRequestContext(SingleBalanceDaoEntity singleBalanceDaoEntity) {
        Intrinsics.checkNotNullParameter(singleBalanceDaoEntity, "");
        return SingleBalanceMapperKt.BuiltInFictitiousFunctionClassFactory(singleBalanceDaoEntity);
    }

    public static /* synthetic */ List PlaceComponentResult(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        return PromoBannerContentMapperKt.BuiltInFictitiousFunctionClassFactory(list);
    }

    public static /* synthetic */ List MyBillsEntityDataFactory(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        return NewsWidgetActivityMapperKt.getAuthRequestContext(list);
    }
}
