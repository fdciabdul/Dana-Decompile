package id.dana.data.cancelsurvey.repository;

import id.dana.cashier.utils.CashierKeyParams;
import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.cancelsurvey.mapper.CancelSurveyEntityRepositoryMapperKt;
import id.dana.data.cancelsurvey.model.CancellationSurveyConfigModel;
import id.dana.data.cancelsurvey.repository.source.CancelSurveyEntityData;
import id.dana.data.cancelsurvey.repository.source.CancelSurveyEntityDataFactory;
import id.dana.data.cancelsurvey.repository.source.network.response.SurveyCancelReasonConsultResponse;
import id.dana.data.cancelsurvey.repository.source.network.response.SurveyCancelReasonSubmitResponse;
import id.dana.data.errorconfig.ErrorConfigEntityData;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.data.login.source.LoginEntityData;
import id.dana.domain.cancelsurvey.model.CancelReason;
import id.dana.domain.cancelsurvey.model.CancellationSurveyConfig;
import id.dana.domain.cancelsurvey.repository.CancelSurveyRepository;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Singleton
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0007\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b2\u00103J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096\u0001¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096\u0001¢\u0006\u0004\b\u0006\u0010\nJ3\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013H\u0096\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016H\u0096\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0016H\u0096\u0001¢\u0006\u0004\b\u0019\u0010\u0018J\u0010\u0010\u001b\u001a\u00020\u001aH\u0096\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00042\u0006\u0010\u001d\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001f\u0010 J-\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\"\u0010\u0012R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020)8CX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001b\u00101\u001a\u00020)8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\b/\u0010+\u001a\u0004\b0\u0010-"}, d2 = {"Lid/dana/data/cancelsurvey/repository/CancelSurveyEntityRepository;", "Lid/dana/domain/cancelsurvey/repository/CancelSurveyRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "T", "Lio/reactivex/Observable;", "observable", "authenticatedRequest", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", "Lkotlinx/coroutines/flow/Flow;", "flow", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "", CashierKeyParams.CASHIER_ORDER_ID, "scenario", "goodsId", "", "Lid/dana/domain/cancelsurvey/model/CancelReason;", "consultCancelSurveyReason", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/account/repository/source/AccountEntityData;", "createAccountData", "()Lid/dana/data/account/repository/source/AccountEntityData;", "Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createLocalErrorConfigData", "()Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createNetworkErrorConfigData", "Lid/dana/data/login/source/LoginEntityData;", "createNetworkLogin", "()Lid/dana/data/login/source/LoginEntityData;", "suffixKey", "Lid/dana/domain/cancelsurvey/model/CancellationSurveyConfig;", "fetchCancelSurveyReasonConfig", "(Ljava/lang/String;)Lio/reactivex/Observable;", "", "submitCancelReason", "Lid/dana/data/cancelsurvey/repository/source/CancelSurveyEntityDataFactory;", "cancelSurveyEntityDataFactory", "Lid/dana/data/cancelsurvey/repository/source/CancelSurveyEntityDataFactory;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "holdLoginV1EntityRepository", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/cancelsurvey/repository/source/CancelSurveyEntityData;", "networkCancelSurveyEntityData$delegate", "Lkotlin/Lazy;", "getNetworkCancelSurveyEntityData", "()Lid/dana/data/cancelsurvey/repository/source/CancelSurveyEntityData;", "networkCancelSurveyEntityData", "splitCancelSurveyEntityData$delegate", "getSplitCancelSurveyEntityData", "splitCancelSurveyEntityData", "<init>", "(Lid/dana/data/cancelsurvey/repository/source/CancelSurveyEntityDataFactory;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CancelSurveyEntityRepository implements CancelSurveyRepository, HoldLoginV1Repository {
    private final CancelSurveyEntityDataFactory cancelSurveyEntityDataFactory;
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;

    /* renamed from: networkCancelSurveyEntityData$delegate  reason: from kotlin metadata */
    private final Lazy networkCancelSurveyEntityData;

    /* renamed from: splitCancelSurveyEntityData$delegate  reason: from kotlin metadata */
    private final Lazy splitCancelSurveyEntityData;

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
    public CancelSurveyEntityRepository(CancelSurveyEntityDataFactory cancelSurveyEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(cancelSurveyEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.cancelSurveyEntityDataFactory = cancelSurveyEntityDataFactory;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
        this.networkCancelSurveyEntityData = LazyKt.lazy(new Function0<CancelSurveyEntityData>() { // from class: id.dana.data.cancelsurvey.repository.CancelSurveyEntityRepository$networkCancelSurveyEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CancelSurveyEntityData invoke() {
                CancelSurveyEntityDataFactory cancelSurveyEntityDataFactory2;
                cancelSurveyEntityDataFactory2 = CancelSurveyEntityRepository.this.cancelSurveyEntityDataFactory;
                return cancelSurveyEntityDataFactory2.createData2("network");
            }
        });
        this.splitCancelSurveyEntityData = LazyKt.lazy(new Function0<CancelSurveyEntityData>() { // from class: id.dana.data.cancelsurvey.repository.CancelSurveyEntityRepository$splitCancelSurveyEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CancelSurveyEntityData invoke() {
                CancelSurveyEntityDataFactory cancelSurveyEntityDataFactory2;
                cancelSurveyEntityDataFactory2 = CancelSurveyEntityRepository.this.cancelSurveyEntityDataFactory;
                return cancelSurveyEntityDataFactory2.createData2("split");
            }
        });
    }

    @JvmName(name = "getNetworkCancelSurveyEntityData")
    private final CancelSurveyEntityData getNetworkCancelSurveyEntityData() {
        return (CancelSurveyEntityData) this.networkCancelSurveyEntityData.getValue();
    }

    @JvmName(name = "getSplitCancelSurveyEntityData")
    private final CancelSurveyEntityData getSplitCancelSurveyEntityData() {
        return (CancelSurveyEntityData) this.splitCancelSurveyEntityData.getValue();
    }

    @Override // id.dana.domain.cancelsurvey.repository.CancelSurveyRepository
    public final Observable<CancellationSurveyConfig> fetchCancelSurveyReasonConfig(String suffixKey) {
        Intrinsics.checkNotNullParameter(suffixKey, "");
        Observable map = getSplitCancelSurveyEntityData().fetchCancelSurveyReasonConfig(suffixKey).map(new Function() { // from class: id.dana.data.cancelsurvey.repository.CancelSurveyEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CancellationSurveyConfig m816fetchCancelSurveyReasonConfig$lambda0;
                m816fetchCancelSurveyReasonConfig$lambda0 = CancelSurveyEntityRepository.m816fetchCancelSurveyReasonConfig$lambda0((CancellationSurveyConfigModel) obj);
                return m816fetchCancelSurveyReasonConfig$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: fetchCancelSurveyReasonConfig$lambda-0  reason: not valid java name */
    public static final CancellationSurveyConfig m816fetchCancelSurveyReasonConfig$lambda0(CancellationSurveyConfigModel cancellationSurveyConfigModel) {
        Intrinsics.checkNotNullParameter(cancellationSurveyConfigModel, "");
        return cancellationSurveyConfigModel.toCancellationSurveyConfig();
    }

    @Override // id.dana.domain.cancelsurvey.repository.CancelSurveyRepository
    public final Observable<List<CancelReason>> consultCancelSurveyReason(String cashierOrderId, String scenario, String goodsId) {
        Intrinsics.checkNotNullParameter(cashierOrderId, "");
        Intrinsics.checkNotNullParameter(scenario, "");
        Intrinsics.checkNotNullParameter(goodsId, "");
        Observable<List<CancelReason>> map = authenticatedRequest(getNetworkCancelSurveyEntityData().consultCancelSurvey(cashierOrderId, scenario, goodsId)).map(new Function() { // from class: id.dana.data.cancelsurvey.repository.CancelSurveyEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m815consultCancelSurveyReason$lambda1;
                m815consultCancelSurveyReason$lambda1 = CancelSurveyEntityRepository.m815consultCancelSurveyReason$lambda1((SurveyCancelReasonConsultResponse) obj);
                return m815consultCancelSurveyReason$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: consultCancelSurveyReason$lambda-1  reason: not valid java name */
    public static final List m815consultCancelSurveyReason$lambda1(SurveyCancelReasonConsultResponse surveyCancelReasonConsultResponse) {
        Intrinsics.checkNotNullParameter(surveyCancelReasonConsultResponse, "");
        return CancelSurveyEntityRepositoryMapperKt.toListOfCancelReason(surveyCancelReasonConsultResponse.getCancelReasons());
    }

    @Override // id.dana.domain.cancelsurvey.repository.CancelSurveyRepository
    public final Observable<Boolean> submitCancelReason(String cashierOrderId, String scenario, String goodsId) {
        Intrinsics.checkNotNullParameter(cashierOrderId, "");
        Intrinsics.checkNotNullParameter(scenario, "");
        Intrinsics.checkNotNullParameter(goodsId, "");
        Observable<Boolean> map = authenticatedRequest(getNetworkCancelSurveyEntityData().submitCancelSurvey(cashierOrderId, scenario, goodsId)).map(new Function() { // from class: id.dana.data.cancelsurvey.repository.CancelSurveyEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean m817submitCancelReason$lambda2;
                m817submitCancelReason$lambda2 = CancelSurveyEntityRepository.m817submitCancelReason$lambda2((SurveyCancelReasonSubmitResponse) obj);
                return m817submitCancelReason$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: submitCancelReason$lambda-2  reason: not valid java name */
    public static final Boolean m817submitCancelReason$lambda2(SurveyCancelReasonSubmitResponse surveyCancelReasonSubmitResponse) {
        Intrinsics.checkNotNullParameter(surveyCancelReasonSubmitResponse, "");
        return Boolean.valueOf(surveyCancelReasonSubmitResponse.success);
    }
}
