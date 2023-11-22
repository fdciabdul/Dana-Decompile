package id.dana.data.merchantmanagement.repository;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.errorconfig.ErrorConfigEntityData;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.data.login.source.LoginEntityData;
import id.dana.data.merchantmanagement.MerchantManagementEntityData;
import id.dana.data.merchantmanagement.mapper.MerchantManagementMapperKt;
import id.dana.data.merchantmanagement.repository.source.MerchantManagementEntityDataFactory;
import id.dana.data.merchantmanagement.repository.source.network.result.BoundMerchantResult;
import id.dana.data.merchantmanagement.repository.source.network.result.UnbindConsultResult;
import id.dana.data.merchantmanagement.repository.source.network.result.UnbindEligibilityCheckResult;
import id.dana.domain.merchantmanagement.MerchantManagementRepository;
import id.dana.domain.merchantmanagement.model.LinkedMerchantInfo;
import id.dana.domain.merchantmanagement.model.UnbindConsultInfo;
import id.dana.domain.merchantmanagement.model.UnbindMerchantParam;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0007\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b0\u00101J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096\u0001¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096\u0001¢\u0006\u0004\b\u0006\u0010\nJ/\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014H\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0014H\u0096\u0001¢\u0006\u0004\b\u0017\u0010\u0016J\u0010\u0010\u0019\u001a\u00020\u0018H\u0096\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b!\u0010\"J/\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b$\u0010\u0010J\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u00042\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/"}, d2 = {"Lid/dana/data/merchantmanagement/repository/MerchantManagementEntityRepository;", "Lid/dana/domain/merchantmanagement/MerchantManagementRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "T", "Lio/reactivex/Observable;", "observable", "authenticatedRequest", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", "Lkotlinx/coroutines/flow/Flow;", "flow", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "", "clientId", "merchantId", "divisionId", "checkUnbindEligibility", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/account/repository/source/AccountEntityData;", "createAccountData", "()Lid/dana/data/account/repository/source/AccountEntityData;", "Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createLocalErrorConfigData", "()Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createNetworkErrorConfigData", "Lid/dana/data/login/source/LoginEntityData;", "createNetworkLogin", "()Lid/dana/data/login/source/LoginEntityData;", "Lid/dana/data/merchantmanagement/MerchantManagementEntityData;", "createNetworkMerchantManagementEntityData", "()Lid/dana/data/merchantmanagement/MerchantManagementEntityData;", "", ZdocRecordService.PAGE_NUMBER, "Lid/dana/domain/merchantmanagement/model/LinkedMerchantInfo;", "getLinkedMerchants", "(I)Lio/reactivex/Observable;", "Lid/dana/domain/merchantmanagement/model/UnbindConsultInfo;", "unbindConsult", "Lid/dana/domain/merchantmanagement/model/UnbindMerchantParam;", "unbindMerchantParam", "", "unbindMerchant", "(Lid/dana/domain/merchantmanagement/model/UnbindMerchantParam;)Lio/reactivex/Observable;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "holdLoginV1EntityRepository", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/merchantmanagement/repository/source/MerchantManagementEntityDataFactory;", "merchantManagementEntityDataFactory", "Lid/dana/data/merchantmanagement/repository/source/MerchantManagementEntityDataFactory;", "<init>", "(Lid/dana/data/merchantmanagement/repository/source/MerchantManagementEntityDataFactory;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MerchantManagementEntityRepository implements MerchantManagementRepository, HoldLoginV1Repository {
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final MerchantManagementEntityDataFactory merchantManagementEntityDataFactory;

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
    public MerchantManagementEntityRepository(MerchantManagementEntityDataFactory merchantManagementEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(merchantManagementEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.merchantManagementEntityDataFactory = merchantManagementEntityDataFactory;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
    }

    @Override // id.dana.domain.merchantmanagement.MerchantManagementRepository
    public final Observable<LinkedMerchantInfo> getLinkedMerchants(int pageNumber) {
        ObservableSource map = createNetworkMerchantManagementEntityData().getLinkedMerchants(pageNumber).map(new Function() { // from class: id.dana.data.merchantmanagement.repository.MerchantManagementEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                LinkedMerchantInfo m1502getLinkedMerchants$lambda0;
                m1502getLinkedMerchants$lambda0 = MerchantManagementEntityRepository.m1502getLinkedMerchants$lambda0((BoundMerchantResult) obj);
                return m1502getLinkedMerchants$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return authenticatedRequest((Observable) map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getLinkedMerchants$lambda-0  reason: not valid java name */
    public static final LinkedMerchantInfo m1502getLinkedMerchants$lambda0(BoundMerchantResult boundMerchantResult) {
        Intrinsics.checkNotNullParameter(boundMerchantResult, "");
        return MerchantManagementMapperKt.toLinkedMerchantInfo(boundMerchantResult);
    }

    @Override // id.dana.domain.merchantmanagement.MerchantManagementRepository
    public final Observable<UnbindConsultInfo> unbindConsult(final String clientId, final String merchantId, final String divisionId) {
        Intrinsics.checkNotNullParameter(clientId, "");
        Intrinsics.checkNotNullParameter(merchantId, "");
        ObservableSource map = createNetworkMerchantManagementEntityData().unbindConsult(clientId, merchantId, divisionId).map(new Function() { // from class: id.dana.data.merchantmanagement.repository.MerchantManagementEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                UnbindConsultInfo m1503unbindConsult$lambda2;
                m1503unbindConsult$lambda2 = MerchantManagementEntityRepository.m1503unbindConsult$lambda2(clientId, merchantId, divisionId, (UnbindConsultResult) obj);
                return m1503unbindConsult$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return authenticatedRequest((Observable) map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: unbindConsult$lambda-2  reason: not valid java name */
    public static final UnbindConsultInfo m1503unbindConsult$lambda2(String str, String str2, String str3, UnbindConsultResult unbindConsultResult) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(unbindConsultResult, "");
        UnbindConsultInfo unbindConsultInfo = MerchantManagementMapperKt.toUnbindConsultInfo(unbindConsultResult);
        unbindConsultInfo.setClientId(str);
        unbindConsultInfo.setMerchantId(str2);
        unbindConsultInfo.setDivisionId(str3);
        return unbindConsultInfo;
    }

    @Override // id.dana.domain.merchantmanagement.MerchantManagementRepository
    public final Observable<Boolean> unbindMerchant(UnbindMerchantParam unbindMerchantParam) {
        Intrinsics.checkNotNullParameter(unbindMerchantParam, "");
        ObservableSource map = createNetworkMerchantManagementEntityData().unbindMerchant(MerchantManagementMapperKt.toUnbindMerchantRequest(unbindMerchantParam)).filter(new Predicate() { // from class: id.dana.data.merchantmanagement.repository.MerchantManagementEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean m1504unbindMerchant$lambda3;
                m1504unbindMerchant$lambda3 = MerchantManagementEntityRepository.m1504unbindMerchant$lambda3((BaseRpcResult) obj);
                return m1504unbindMerchant$lambda3;
            }
        }).map(new Function() { // from class: id.dana.data.merchantmanagement.repository.MerchantManagementEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean m1505unbindMerchant$lambda4;
                m1505unbindMerchant$lambda4 = MerchantManagementEntityRepository.m1505unbindMerchant$lambda4((BaseRpcResult) obj);
                return m1505unbindMerchant$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return authenticatedRequest((Observable) map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: unbindMerchant$lambda-3  reason: not valid java name */
    public static final boolean m1504unbindMerchant$lambda3(BaseRpcResult baseRpcResult) {
        Intrinsics.checkNotNullParameter(baseRpcResult, "");
        return baseRpcResult.success;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: unbindMerchant$lambda-4  reason: not valid java name */
    public static final Boolean m1505unbindMerchant$lambda4(BaseRpcResult baseRpcResult) {
        Intrinsics.checkNotNullParameter(baseRpcResult, "");
        return Boolean.valueOf(baseRpcResult.success);
    }

    @Override // id.dana.domain.merchantmanagement.MerchantManagementRepository
    public final Observable<String> checkUnbindEligibility(String clientId, String merchantId, String divisionId) {
        Intrinsics.checkNotNullParameter(clientId, "");
        Intrinsics.checkNotNullParameter(merchantId, "");
        ObservableSource map = createNetworkMerchantManagementEntityData().checkUnbindEligibility(clientId, merchantId, divisionId).map(new Function() { // from class: id.dana.data.merchantmanagement.repository.MerchantManagementEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String m1501checkUnbindEligibility$lambda5;
                m1501checkUnbindEligibility$lambda5 = MerchantManagementEntityRepository.m1501checkUnbindEligibility$lambda5((UnbindEligibilityCheckResult) obj);
                return m1501checkUnbindEligibility$lambda5;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return authenticatedRequest((Observable) map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkUnbindEligibility$lambda-5  reason: not valid java name */
    public static final String m1501checkUnbindEligibility$lambda5(UnbindEligibilityCheckResult unbindEligibilityCheckResult) {
        Intrinsics.checkNotNullParameter(unbindEligibilityCheckResult, "");
        return unbindEligibilityCheckResult.getUnbindEligibilityCheckId();
    }

    private final MerchantManagementEntityData createNetworkMerchantManagementEntityData() {
        return this.merchantManagementEntityDataFactory.createData2("network");
    }
}
