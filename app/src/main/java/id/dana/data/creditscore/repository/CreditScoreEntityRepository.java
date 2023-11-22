package id.dana.data.creditscore.repository;

import id.dana.data.creditscore.mapper.InsertDeviceScoringDataRequestMapperKt;
import id.dana.data.creditscore.repository.source.network.response.InsertDeviceScoringDataResult;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.domain.creditscore.CreditScoreRepository;
import id.dana.domain.creditscore.model.InsertInstalledAppsScoringData;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0013\u0010\f\u001a\u00020\tX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u000e\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/data/creditscore/repository/CreditScoreEntityRepository;", "Lid/dana/domain/creditscore/CreditScoreRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "Lid/dana/domain/creditscore/model/InsertInstalledAppsScoringData;", "p0", "Lio/reactivex/Observable;", "", "sendDataInstalledApp", "(Lid/dana/domain/creditscore/model/InsertInstalledAppsScoringData;)Lio/reactivex/Observable;", "Lid/dana/data/creditscore/repository/CreditScoreEntityData;", "MyBillsEntityDataFactory", "Lkotlin/Lazy;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/creditscore/repository/CreditScoreEntityDataFactory;", "PlaceComponentResult", "Lid/dana/data/creditscore/repository/CreditScoreEntityDataFactory;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "getAuthRequestContext", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "p1", "<init>", "(Lid/dana/data/creditscore/repository/CreditScoreEntityDataFactory;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CreditScoreEntityRepository implements CreditScoreRepository, HoldLoginV1Repository {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final CreditScoreEntityDataFactory BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final HoldLoginV1EntityRepository PlaceComponentResult;

    @Inject
    public CreditScoreEntityRepository(CreditScoreEntityDataFactory creditScoreEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(creditScoreEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.BuiltInFictitiousFunctionClassFactory = creditScoreEntityDataFactory;
        this.PlaceComponentResult = holdLoginV1EntityRepository;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<CreditScoreEntityData>() { // from class: id.dana.data.creditscore.repository.CreditScoreEntityRepository$createNetworkCreditScoreEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreditScoreEntityData invoke() {
                CreditScoreEntityDataFactory creditScoreEntityDataFactory2;
                creditScoreEntityDataFactory2 = CreditScoreEntityRepository.this.BuiltInFictitiousFunctionClassFactory;
                return creditScoreEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2;
            }
        });
    }

    public static /* synthetic */ Boolean KClassImpl$Data$declaredNonStaticMembers$2(InsertDeviceScoringDataResult insertDeviceScoringDataResult) {
        Intrinsics.checkNotNullParameter(insertDeviceScoringDataResult, "");
        return Boolean.valueOf(insertDeviceScoringDataResult.success);
    }

    @Override // id.dana.domain.creditscore.CreditScoreRepository
    public final Observable<Boolean> sendDataInstalledApp(InsertInstalledAppsScoringData p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ObservableSource map = ((CreditScoreEntityData) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).getAuthRequestContext(InsertDeviceScoringDataRequestMapperKt.BuiltInFictitiousFunctionClassFactory(p0)).map(new Function() { // from class: id.dana.data.creditscore.repository.CreditScoreEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CreditScoreEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2((InsertDeviceScoringDataResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        Intrinsics.checkNotNullParameter(map, "");
        Observable<Boolean> authenticatedRequest = this.PlaceComponentResult.authenticatedRequest(map);
        Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
        return authenticatedRequest;
    }
}
