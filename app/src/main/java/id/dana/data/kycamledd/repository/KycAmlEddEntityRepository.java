package id.dana.data.kycamledd.repository;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.config.source.ConfigEntityData;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.errorconfig.ErrorConfigEntityData;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.data.kycamledd.mapper.EddConsultResponseToEddConsultMapperKt;
import id.dana.data.kycamledd.mapper.EddSubmitInfoToEddInfoRequestMapperKt;
import id.dana.data.kycamledd.repository.source.KycAmlEddEntityDataFactory;
import id.dana.data.kycamledd.repository.source.KycAmlEntityData;
import id.dana.data.kycamledd.repository.source.network.response.EddConsultResponse;
import id.dana.data.login.source.LoginEntityData;
import id.dana.domain.kycamledd.KycAmlEddRepository;
import id.dana.domain.kycamledd.model.EddConsult;
import id.dana.domain.kycamledd.model.EddSubmitInfo;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Singleton
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B!\b\u0007\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b1\u00102J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096\u0001¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096\u0001¢\u0006\u0004\b\u0006\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018H\u0096\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0004H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0004H\u0016¢\u0006\u0004\b\u001f\u0010\u001dJ\u000f\u0010 \u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00042\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100"}, d2 = {"Lid/dana/data/kycamledd/repository/KycAmlEddEntityRepository;", "Lid/dana/domain/kycamledd/KycAmlEddRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "T", "Lio/reactivex/Observable;", "observable", "authenticatedRequest", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", "Lkotlinx/coroutines/flow/Flow;", "flow", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/data/account/repository/source/AccountEntityData;", "createAccountData", "()Lid/dana/data/account/repository/source/AccountEntityData;", "Lid/dana/data/config/source/ConfigEntityData;", "createConfigSplitEntity", "()Lid/dana/data/config/source/ConfigEntityData;", "Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createLocalErrorConfigData", "()Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createNetworkErrorConfigData", "Lid/dana/data/kycamledd/repository/source/KycAmlEntityData;", "createNetworkKycAmlEddEntityData", "()Lid/dana/data/kycamledd/repository/source/KycAmlEntityData;", "Lid/dana/data/login/source/LoginEntityData;", "createNetworkLogin", "()Lid/dana/data/login/source/LoginEntityData;", "Lid/dana/domain/kycamledd/model/EddConsult;", "getEddAmlKycConsult", "()Lio/reactivex/Observable;", "", "getFeatureKycAmlEddEnabled", "getKycAmlEddMandatory", "()Z", "Lid/dana/domain/kycamledd/model/EddSubmitInfo;", "eddSubmitInfo", "submitEddAmlKyc", "(Lid/dana/domain/kycamledd/model/EddSubmitInfo;)Lio/reactivex/Observable;", "Lid/dana/data/config/source/ConfigEntityDataFactory;", "configEntityDataFactory", "Lid/dana/data/config/source/ConfigEntityDataFactory;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "holdLoginV1EntityRepository", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/kycamledd/repository/source/KycAmlEddEntityDataFactory;", "kycAmlEddEntityDataFactory", "Lid/dana/data/kycamledd/repository/source/KycAmlEddEntityDataFactory;", "networkKycAmlEddEntityData", "Lid/dana/data/kycamledd/repository/source/KycAmlEntityData;", "<init>", "(Lid/dana/data/kycamledd/repository/source/KycAmlEddEntityDataFactory;Lid/dana/data/config/source/ConfigEntityDataFactory;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class KycAmlEddEntityRepository implements KycAmlEddRepository, HoldLoginV1Repository {
    private final ConfigEntityDataFactory configEntityDataFactory;
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final KycAmlEddEntityDataFactory kycAmlEddEntityDataFactory;
    private final KycAmlEntityData networkKycAmlEddEntityData;

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
    public KycAmlEddEntityRepository(KycAmlEddEntityDataFactory kycAmlEddEntityDataFactory, ConfigEntityDataFactory configEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(kycAmlEddEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(configEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.kycAmlEddEntityDataFactory = kycAmlEddEntityDataFactory;
        this.configEntityDataFactory = configEntityDataFactory;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
        this.networkKycAmlEddEntityData = kycAmlEddEntityDataFactory.createData2("network");
    }

    @Override // id.dana.domain.kycamledd.KycAmlEddRepository
    public final Observable<EddConsult> getEddAmlKycConsult() {
        Observable map = createNetworkKycAmlEddEntityData().getAmlEddConsult().map(new Function() { // from class: id.dana.data.kycamledd.repository.KycAmlEddEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                EddConsult m1381getEddAmlKycConsult$lambda0;
                m1381getEddAmlKycConsult$lambda0 = KycAmlEddEntityRepository.m1381getEddAmlKycConsult$lambda0(KycAmlEddEntityRepository.this, (EddConsultResponse) obj);
                return m1381getEddAmlKycConsult$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getEddAmlKycConsult$lambda-0  reason: not valid java name */
    public static final EddConsult m1381getEddAmlKycConsult$lambda0(KycAmlEddEntityRepository kycAmlEddEntityRepository, EddConsultResponse eddConsultResponse) {
        Intrinsics.checkNotNullParameter(kycAmlEddEntityRepository, "");
        Intrinsics.checkNotNullParameter(eddConsultResponse, "");
        return EddConsultResponseToEddConsultMapperKt.toEddConsult(eddConsultResponse, kycAmlEddEntityRepository.getKycAmlEddMandatory());
    }

    @Override // id.dana.domain.kycamledd.KycAmlEddRepository
    public final Observable<Boolean> submitEddAmlKyc(EddSubmitInfo eddSubmitInfo) {
        Intrinsics.checkNotNullParameter(eddSubmitInfo, "");
        Observable map = createNetworkKycAmlEddEntityData().submitAmlEdd(EddSubmitInfoToEddInfoRequestMapperKt.toEddInfoRequest(eddSubmitInfo)).map(new Function() { // from class: id.dana.data.kycamledd.repository.KycAmlEddEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean m1382submitEddAmlKyc$lambda1;
                m1382submitEddAmlKyc$lambda1 = KycAmlEddEntityRepository.m1382submitEddAmlKyc$lambda1((BaseRpcResult) obj);
                return m1382submitEddAmlKyc$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: submitEddAmlKyc$lambda-1  reason: not valid java name */
    public static final Boolean m1382submitEddAmlKyc$lambda1(BaseRpcResult baseRpcResult) {
        Intrinsics.checkNotNullParameter(baseRpcResult, "");
        return Boolean.valueOf(baseRpcResult.success);
    }

    @Override // id.dana.domain.kycamledd.KycAmlEddRepository
    public final Observable<Boolean> getFeatureKycAmlEddEnabled() {
        Observable<Boolean> featureAmlEdd = createConfigSplitEntity().getFeatureAmlEdd();
        Intrinsics.checkNotNullExpressionValue(featureAmlEdd, "");
        return featureAmlEdd;
    }

    private final boolean getKycAmlEddMandatory() {
        Boolean blockingFirst = createConfigSplitEntity().getAmlEddMandatory().blockingFirst();
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
        return blockingFirst.booleanValue();
    }

    private final ConfigEntityData createConfigSplitEntity() {
        ConfigEntityData createData2 = this.configEntityDataFactory.createData2("split");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        return createData2;
    }

    private final KycAmlEntityData createNetworkKycAmlEddEntityData() {
        return this.kycAmlEddEntityDataFactory.createData2("network");
    }
}
