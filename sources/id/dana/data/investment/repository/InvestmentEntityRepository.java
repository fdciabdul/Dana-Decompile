package id.dana.data.investment.repository;

import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.data.investment.mapper.DanaPlusMethodConfigResultMapperKt;
import id.dana.data.investment.repository.source.InvestmentEntityData;
import id.dana.data.investment.repository.source.InvestmentEntityDataFactory;
import id.dana.data.investment.repository.source.network.response.AccountInvestmentResult;
import id.dana.data.investment.repository.source.network.response.AccountInvestmentResultKt;
import id.dana.data.investment.repository.source.split.response.DanaPlusMethodConfigResult;
import id.dana.domain.investment.InvestmentRepository;
import id.dana.domain.investment.model.DanaPlusMethodConfig;
import id.dana.domain.investment.model.UserInvestmentInfo;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B!\b\u0007\u0012\u0006\u0010\b\u001a\u00020\f\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u0006*\u00020\u00100\u0010X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\r\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0015R\u0014\u0010\u0011\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0017\u001a\u00020\u0019X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0013\u0010\u001a\u001a\u00020\u0019X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u0012"}, d2 = {"Lid/dana/data/investment/repository/InvestmentEntityRepository;", "Lid/dana/domain/investment/InvestmentRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "Lio/reactivex/Observable;", "Lid/dana/domain/investment/model/DanaPlusMethodConfig;", "getDanaPlusMethodConfig", "()Lio/reactivex/Observable;", "", "p0", "Lid/dana/domain/investment/model/UserInvestmentInfo;", "getUserInvestment", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "PlaceComponentResult", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "MyBillsEntityDataFactory", "Lid/dana/data/account/repository/source/AccountEntityData;", "getAuthRequestContext", "Lkotlin/Lazy;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/investment/repository/source/InvestmentEntityDataFactory;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/investment/repository/source/InvestmentEntityDataFactory;", "Lid/dana/data/investment/repository/source/InvestmentEntityData;", "getErrorConfigVersion", "p1", "p2", "<init>", "(Lid/dana/data/account/repository/source/AccountEntityDataFactory;Lid/dana/data/investment/repository/source/InvestmentEntityDataFactory;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class InvestmentEntityRepository implements InvestmentRepository, HoldLoginV1Repository {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final InvestmentEntityDataFactory getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final HoldLoginV1EntityRepository PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final AccountEntityDataFactory MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory;
    private final Lazy getErrorConfigVersion;

    @Inject
    public InvestmentEntityRepository(AccountEntityDataFactory accountEntityDataFactory, InvestmentEntityDataFactory investmentEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(accountEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(investmentEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.MyBillsEntityDataFactory = accountEntityDataFactory;
        this.getAuthRequestContext = investmentEntityDataFactory;
        this.PlaceComponentResult = holdLoginV1EntityRepository;
        this.BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<AccountEntityData>() { // from class: id.dana.data.investment.repository.InvestmentEntityRepository$accountLocalEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AccountEntityData invoke() {
                AccountEntityDataFactory accountEntityDataFactory2;
                accountEntityDataFactory2 = InvestmentEntityRepository.this.MyBillsEntityDataFactory;
                return accountEntityDataFactory2.createData2("local");
            }
        });
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<InvestmentEntityData>() { // from class: id.dana.data.investment.repository.InvestmentEntityRepository$investmentNetworkEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final InvestmentEntityData invoke() {
                InvestmentEntityDataFactory investmentEntityDataFactory2;
                investmentEntityDataFactory2 = InvestmentEntityRepository.this.getAuthRequestContext;
                return Intrinsics.areEqual("network", "split") ? investmentEntityDataFactory2.PlaceComponentResult : investmentEntityDataFactory2.MyBillsEntityDataFactory;
            }
        });
        this.getErrorConfigVersion = LazyKt.lazy(new Function0<InvestmentEntityData>() { // from class: id.dana.data.investment.repository.InvestmentEntityRepository$investmentSplitEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final InvestmentEntityData invoke() {
                InvestmentEntityDataFactory investmentEntityDataFactory2;
                investmentEntityDataFactory2 = InvestmentEntityRepository.this.getAuthRequestContext;
                return Intrinsics.areEqual("split", "split") ? investmentEntityDataFactory2.PlaceComponentResult : investmentEntityDataFactory2.MyBillsEntityDataFactory;
            }
        });
    }

    public static /* synthetic */ UserInvestmentInfo PlaceComponentResult(AccountInvestmentResult accountInvestmentResult) {
        Intrinsics.checkNotNullParameter(accountInvestmentResult, "");
        return AccountInvestmentResultKt.KClassImpl$Data$declaredNonStaticMembers$2(accountInvestmentResult);
    }

    public static /* synthetic */ ObservableSource getAuthRequestContext(InvestmentEntityRepository investmentEntityRepository, String str, String str2) {
        Intrinsics.checkNotNullParameter(investmentEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        return ((InvestmentEntityData) investmentEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).MyBillsEntityDataFactory(str2, str);
    }

    public static /* synthetic */ DanaPlusMethodConfig getAuthRequestContext(DanaPlusMethodConfigResult danaPlusMethodConfigResult) {
        Intrinsics.checkNotNullParameter(danaPlusMethodConfigResult, "");
        return DanaPlusMethodConfigResultMapperKt.getAuthRequestContext(danaPlusMethodConfigResult);
    }

    @Override // id.dana.domain.investment.InvestmentRepository
    public final Observable<DanaPlusMethodConfig> getDanaPlusMethodConfig() {
        Observable map = ((InvestmentEntityData) this.getErrorConfigVersion.getValue()).KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.data.investment.repository.InvestmentEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return InvestmentEntityRepository.getAuthRequestContext((DanaPlusMethodConfigResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.investment.InvestmentRepository
    public final Observable<UserInvestmentInfo> getUserInvestment(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable map = ((AccountEntityData) this.BuiltInFictitiousFunctionClassFactory.getValue()).getUserId().flatMap(new Function() { // from class: id.dana.data.investment.repository.InvestmentEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return InvestmentEntityRepository.getAuthRequestContext(InvestmentEntityRepository.this, p0, (String) obj);
            }
        }).map(new Function() { // from class: id.dana.data.investment.repository.InvestmentEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return InvestmentEntityRepository.PlaceComponentResult((AccountInvestmentResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        Intrinsics.checkNotNullParameter(map, "");
        Observable<UserInvestmentInfo> authenticatedRequest = this.PlaceComponentResult.authenticatedRequest(map);
        Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
        return authenticatedRequest;
    }
}
