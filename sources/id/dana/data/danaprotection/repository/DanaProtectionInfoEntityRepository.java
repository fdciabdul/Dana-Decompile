package id.dana.data.danaprotection.repository;

import id.dana.analytics.firebase.Crashlytics;
import id.dana.data.account.repository.AccountEntityRepository;
import id.dana.data.danaprotection.mapper.DanaProtectionInfoMapperKt;
import id.dana.data.danaprotection.repository.source.DanaProtectionEntityData;
import id.dana.data.danaprotection.repository.source.DanaProtectionEntityDataFactory;
import id.dana.data.danaprotection.repository.source.network.result.DanaProtectionInfoResult;
import id.dana.data.util.DateTimeUtil;
import id.dana.domain.danaprotection.DanaProtectionInfoRepository;
import id.dana.domain.danaprotection.model.DanaProtectionInfoModel;
import id.dana.domain.danaprotection.model.DanaProtectionRecommendationModel;
import id.dana.domain.danaprotection.model.DanaProtectionWidgetConfig;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import j$.util.Optional;
import java.util.List;
import java.util.NoSuchElementException;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020 \u0012\u0006\u0010&\u001a\u00020\u001c¢\u0006\u0004\b'\u0010(J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0005J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0015\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u00022\u0006\u0010\u0007\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u00020\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0004\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010!R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0013\u0010\"\u001a\u00020$X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0004\u0010%R\u0013\u0010\u0012\u001a\u00020$X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001f\u0010%"}, d2 = {"Lid/dana/data/danaprotection/repository/DanaProtectionInfoEntityRepository;", "Lid/dana/domain/danaprotection/DanaProtectionInfoRepository;", "Lio/reactivex/Observable;", "Lid/dana/data/danaprotection/repository/source/network/result/DanaProtectionInfoResult;", "getAuthRequestContext", "()Lio/reactivex/Observable;", "", "p0", "Lid/dana/domain/danaprotection/model/DanaProtectionInfoModel;", "getDanaProtectionInfo", "(I)Lio/reactivex/Observable;", "", "Lid/dana/domain/danaprotection/model/DanaProtectionRecommendationModel;", "getDanaProtectionRecommendationInMemoryCache", "()Ljava/util/List;", "Lid/dana/domain/danaprotection/model/DanaProtectionWidgetConfig;", "getDanaProtectionWidgetConfigInCache", "", "BuiltInFictitiousFunctionClassFactory", "(I)Z", "", "setDanaProtectionRecommendationInMemoryCache", "(Ljava/util/List;)V", "setDanaProtectionWidgetConfigInCache", "(Lid/dana/domain/danaprotection/model/DanaProtectionWidgetConfig;)Lio/reactivex/Observable;", "", "trackError", "(Ljava/lang/Throwable;)Z", "Lid/dana/data/account/repository/AccountEntityRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/account/repository/AccountEntityRepository;", "MyBillsEntityDataFactory", "Lid/dana/data/danaprotection/repository/source/DanaProtectionEntityDataFactory;", "Lid/dana/data/danaprotection/repository/source/DanaProtectionEntityDataFactory;", "PlaceComponentResult", "Ljava/util/List;", "Lid/dana/data/danaprotection/repository/source/DanaProtectionEntityData;", "Lkotlin/Lazy;", "p1", "<init>", "(Lid/dana/data/danaprotection/repository/source/DanaProtectionEntityDataFactory;Lid/dana/data/account/repository/AccountEntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DanaProtectionInfoEntityRepository implements DanaProtectionInfoRepository {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final DanaProtectionEntityDataFactory getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final AccountEntityRepository MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private List<DanaProtectionRecommendationModel> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult;

    @Inject
    public DanaProtectionInfoEntityRepository(DanaProtectionEntityDataFactory danaProtectionEntityDataFactory, AccountEntityRepository accountEntityRepository) {
        Intrinsics.checkNotNullParameter(danaProtectionEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(accountEntityRepository, "");
        this.getAuthRequestContext = danaProtectionEntityDataFactory;
        this.MyBillsEntityDataFactory = accountEntityRepository;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = CollectionsKt.emptyList();
        this.BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<DanaProtectionEntityData>() { // from class: id.dana.data.danaprotection.repository.DanaProtectionInfoEntityRepository$networkDanaProtectionInfo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DanaProtectionEntityData invoke() {
                DanaProtectionEntityDataFactory danaProtectionEntityDataFactory2;
                danaProtectionEntityDataFactory2 = DanaProtectionInfoEntityRepository.this.getAuthRequestContext;
                return Intrinsics.areEqual("network", "network") ? danaProtectionEntityDataFactory2.getAuthRequestContext : danaProtectionEntityDataFactory2.MyBillsEntityDataFactory;
            }
        });
        this.PlaceComponentResult = LazyKt.lazy(new Function0<DanaProtectionEntityData>() { // from class: id.dana.data.danaprotection.repository.DanaProtectionInfoEntityRepository$localDanaProtectionInfo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DanaProtectionEntityData invoke() {
                DanaProtectionEntityDataFactory danaProtectionEntityDataFactory2;
                danaProtectionEntityDataFactory2 = DanaProtectionInfoEntityRepository.this.getAuthRequestContext;
                return Intrinsics.areEqual("local", "network") ? danaProtectionEntityDataFactory2.getAuthRequestContext : danaProtectionEntityDataFactory2.MyBillsEntityDataFactory;
            }
        });
    }

    @Override // id.dana.domain.danaprotection.DanaProtectionInfoRepository
    public final void setDanaProtectionRecommendationInMemoryCache(List<DanaProtectionRecommendationModel> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
    }

    @Override // id.dana.domain.danaprotection.DanaProtectionInfoRepository
    public final List<DanaProtectionRecommendationModel> getDanaProtectionRecommendationInMemoryCache() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.domain.danaprotection.DanaProtectionInfoRepository
    public final boolean trackError(Throwable p0) {
        if (p0 != null) {
            Crashlytics.Companion companion = Crashlytics.INSTANCE;
            Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
            Intrinsics.checkNotNullParameter(p0, "");
            authRequestContext.getAuthRequestContext.recordException(p0);
            return true;
        }
        return false;
    }

    private final Observable<DanaProtectionInfoResult> getAuthRequestContext() {
        Observable<DanaProtectionInfoResult> map = this.MyBillsEntityDataFactory.getUserId().flatMap(new Function() { // from class: id.dana.data.danaprotection.repository.DanaProtectionInfoEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return DanaProtectionInfoEntityRepository.BuiltInFictitiousFunctionClassFactory(DanaProtectionInfoEntityRepository.this, (String) obj);
            }
        }).map(new Function() { // from class: id.dana.data.danaprotection.repository.DanaProtectionInfoEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return DanaProtectionInfoEntityRepository.BuiltInFictitiousFunctionClassFactory(DanaProtectionInfoEntityRepository.this, (DanaProtectionInfoResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    public static /* synthetic */ DanaProtectionInfoModel getAuthRequestContext(DanaProtectionInfoResult danaProtectionInfoResult) {
        Intrinsics.checkNotNullParameter(danaProtectionInfoResult, "");
        return DanaProtectionInfoMapperKt.PlaceComponentResult(danaProtectionInfoResult);
    }

    public static /* synthetic */ ObservableSource BuiltInFictitiousFunctionClassFactory(DanaProtectionInfoEntityRepository danaProtectionInfoEntityRepository, String str) {
        Intrinsics.checkNotNullParameter(danaProtectionInfoEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        return ((DanaProtectionEntityData) danaProtectionInfoEntityRepository.BuiltInFictitiousFunctionClassFactory.getValue()).MyBillsEntityDataFactory(str);
    }

    public static /* synthetic */ ObservableSource getAuthRequestContext(DanaProtectionInfoEntityRepository danaProtectionInfoEntityRepository, int i, Optional optional) {
        Intrinsics.checkNotNullParameter(danaProtectionInfoEntityRepository, "");
        Intrinsics.checkNotNullParameter(optional, "");
        if (optional.KClassImpl$Data$declaredNonStaticMembers$2()) {
            if (danaProtectionInfoEntityRepository.BuiltInFictitiousFunctionClassFactory(i)) {
                return danaProtectionInfoEntityRepository.getAuthRequestContext();
            }
            Object obj = optional.PlaceComponentResult;
            if (obj != null) {
                return Observable.just(obj);
            }
            throw new NoSuchElementException("No value present");
        }
        return danaProtectionInfoEntityRepository.getAuthRequestContext();
    }

    public static /* synthetic */ DanaProtectionInfoResult BuiltInFictitiousFunctionClassFactory(DanaProtectionInfoEntityRepository danaProtectionInfoEntityRepository, DanaProtectionInfoResult danaProtectionInfoResult) {
        Intrinsics.checkNotNullParameter(danaProtectionInfoEntityRepository, "");
        Intrinsics.checkNotNullParameter(danaProtectionInfoResult, "");
        ((DanaProtectionEntityData) danaProtectionInfoEntityRepository.PlaceComponentResult.getValue()).getAuthRequestContext(danaProtectionInfoResult);
        ((DanaProtectionEntityData) danaProtectionInfoEntityRepository.PlaceComponentResult.getValue()).MyBillsEntityDataFactory(DateTimeUtil.getCurrentTimeMillis());
        return danaProtectionInfoResult;
    }

    private final boolean BuiltInFictitiousFunctionClassFactory(int p0) {
        Long blockingFirst = ((DanaProtectionEntityData) this.PlaceComponentResult.getValue()).KClassImpl$Data$declaredNonStaticMembers$2().blockingFirst();
        long currentTimeMillis = DateTimeUtil.getCurrentTimeMillis();
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
        return DateTimeUtil.getDifferenceInMinutes(currentTimeMillis, blockingFirst.longValue()) >= ((long) p0);
    }

    @Override // id.dana.domain.danaprotection.DanaProtectionInfoRepository
    public final Observable<DanaProtectionInfoModel> getDanaProtectionInfo(final int p0) {
        Observable<R> flatMap = ((DanaProtectionEntityData) this.PlaceComponentResult.getValue()).MyBillsEntityDataFactory().flatMap(new Function() { // from class: id.dana.data.danaprotection.repository.DanaProtectionInfoEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return DanaProtectionInfoEntityRepository.getAuthRequestContext(DanaProtectionInfoEntityRepository.this, p0, (Optional) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        Observable<DanaProtectionInfoModel> map = flatMap.map(new Function() { // from class: id.dana.data.danaprotection.repository.DanaProtectionInfoEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return DanaProtectionInfoEntityRepository.getAuthRequestContext((DanaProtectionInfoResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.danaprotection.DanaProtectionInfoRepository
    public final Observable<DanaProtectionWidgetConfig> getDanaProtectionWidgetConfigInCache() {
        return ((DanaProtectionEntityData) this.PlaceComponentResult.getValue()).BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.domain.danaprotection.DanaProtectionInfoRepository
    public final Observable<Boolean> setDanaProtectionWidgetConfigInCache(DanaProtectionWidgetConfig p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return ((DanaProtectionEntityData) this.PlaceComponentResult.getValue()).getAuthRequestContext(p0);
    }
}
