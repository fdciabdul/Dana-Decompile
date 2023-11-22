package id.dana.data.moreforyou;

import id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda10;
import id.dana.data.cache.CacheEntityData;
import id.dana.data.cache.CacheKey;
import id.dana.data.content.SpaceCode;
import id.dana.data.content.mapper.SpaceResultMapper;
import id.dana.data.content.source.ContentDeliveryEntityDataFactory;
import id.dana.data.content.source.cache.ContentDeliveryCacheEntityDataFactory;
import id.dana.data.content.source.network.result.SpaceRpcResult;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.domain.moreforyou.MoreForYouRepository;
import id.dana.domain.promotion.Space;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B)\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u0017\u001a\u00020\r¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\b\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u000e\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/data/moreforyou/MoreForYouEntityRepository;", "Lid/dana/domain/moreforyou/MoreForYouRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "Lio/reactivex/Observable;", "Lid/dana/domain/promotion/Space;", "getMoreForYouCDP", "()Lio/reactivex/Observable;", "Lid/dana/data/content/source/cache/ContentDeliveryCacheEntityDataFactory;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/content/source/cache/ContentDeliveryCacheEntityDataFactory;", "PlaceComponentResult", "Lid/dana/data/content/source/ContentDeliveryEntityDataFactory;", "Lid/dana/data/content/source/ContentDeliveryEntityDataFactory;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "getAuthRequestContext", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "MyBillsEntityDataFactory", "Lid/dana/data/content/mapper/SpaceResultMapper;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/content/mapper/SpaceResultMapper;", "p0", "p1", "p2", "p3", "<init>", "(Lid/dana/data/content/source/ContentDeliveryEntityDataFactory;Lid/dana/data/content/source/cache/ContentDeliveryCacheEntityDataFactory;Lid/dana/data/content/mapper/SpaceResultMapper;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MoreForYouEntityRepository implements MoreForYouRepository, HoldLoginV1Repository {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final ContentDeliveryCacheEntityDataFactory PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final SpaceResultMapper getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final ContentDeliveryEntityDataFactory BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final HoldLoginV1EntityRepository MyBillsEntityDataFactory;

    @Inject
    public MoreForYouEntityRepository(ContentDeliveryEntityDataFactory contentDeliveryEntityDataFactory, ContentDeliveryCacheEntityDataFactory contentDeliveryCacheEntityDataFactory, SpaceResultMapper spaceResultMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(contentDeliveryEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(contentDeliveryCacheEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(spaceResultMapper, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.BuiltInFictitiousFunctionClassFactory = contentDeliveryEntityDataFactory;
        this.PlaceComponentResult = contentDeliveryCacheEntityDataFactory;
        this.getAuthRequestContext = spaceResultMapper;
        this.MyBillsEntityDataFactory = holdLoginV1EntityRepository;
    }

    @Override // id.dana.domain.moreforyou.MoreForYouRepository
    public final Observable<Space> getMoreForYouCDP() {
        Observable<SpaceRpcResult> observable = this.BuiltInFictitiousFunctionClassFactory.createData2("network").get(SpaceCode.HOME_MORE_FOR_YOU_INFO);
        Intrinsics.checkNotNullExpressionValue(observable, "");
        Intrinsics.checkNotNullParameter(observable, "");
        Observable authenticatedRequest = this.MyBillsEntityDataFactory.authenticatedRequest(observable);
        Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
        Observable doOnNext = authenticatedRequest.doOnNext(new Consumer() { // from class: id.dana.data.moreforyou.MoreForYouEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MoreForYouEntityRepository.BuiltInFictitiousFunctionClassFactory(MoreForYouEntityRepository.this, (SpaceRpcResult) obj);
            }
        });
        CacheEntityData<SpaceRpcResult> createData2 = this.PlaceComponentResult.createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        Observable<Space> map = doOnNext.startWith((ObservableSource) createData2.getObject(CacheKey.HOME.CDP_MORE_FOR_YOU_INFO, SpaceRpcResult.class)).map(new CashierEntityRepository$$ExternalSyntheticLambda10(this.getAuthRequestContext));
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(MoreForYouEntityRepository moreForYouEntityRepository, SpaceRpcResult spaceRpcResult) {
        Intrinsics.checkNotNullParameter(moreForYouEntityRepository, "");
        CacheEntityData<SpaceRpcResult> createData2 = moreForYouEntityRepository.PlaceComponentResult.createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        createData2.saveData(CacheKey.HOME.CDP_MORE_FOR_YOU_INFO, spaceRpcResult);
    }
}
