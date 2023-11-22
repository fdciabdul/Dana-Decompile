package id.dana.data.auth.face.repository;

import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.auth.face.mapper.FaceAuthenticationEntityMapper;
import id.dana.data.auth.face.repository.source.FaceAuthenticationEntityData;
import id.dana.data.auth.face.repository.source.network.FaceAuthenticationEntityDataFactory;
import id.dana.data.auth.face.repository.source.network.NetworkFaceAuthenticationEntityData;
import id.dana.data.errorconfig.ErrorConfigEntityData;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.data.login.source.LoginEntityData;
import id.dana.domain.auth.face.repository.FaceAuthenticationRepository;
import id.dana.domain.auth.face.result.FaceAuthenticationResult;
import id.dana.network.response.authface.FaceAuthenticationEntityResult;
import id.dana.riskChallenges.ui.missedCallOtp.PhoneStateReceiver;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Singleton
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B!\b\u0007\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b-\u0010.J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096\u0001¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096\u0001¢\u0006\u0004\b\u0006\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b\u0014\u0010\u0013J\u0010\u0010\u0016\u001a\u00020\u0015H\u0096\u0001¢\u0006\u0004\b\u0016\u0010\u0017J1\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00042\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ;\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00042\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010 \u001a\u0004\u0018\u00010\u001a2\b\u0010!\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,"}, d2 = {"Lid/dana/data/auth/face/repository/FaceAuthenticationEntityRepository;", "Lid/dana/domain/auth/face/repository/FaceAuthenticationRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "T", "Lio/reactivex/Observable;", "observable", "authenticatedRequest", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", "Lkotlinx/coroutines/flow/Flow;", "flow", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/data/account/repository/source/AccountEntityData;", "createAccountData", "()Lid/dana/data/account/repository/source/AccountEntityData;", "Lid/dana/data/auth/face/repository/source/FaceAuthenticationEntityData;", "createFaceAuthenticationData", "()Lid/dana/data/auth/face/repository/source/FaceAuthenticationEntityData;", "Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createLocalErrorConfigData", "()Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createNetworkErrorConfigData", "Lid/dana/data/login/source/LoginEntityData;", "createNetworkLogin", "()Lid/dana/data/login/source/LoginEntityData;", "", "faceAuthNew", "", BioUtilityBridge.SECURITY_ID, NetworkFaceAuthenticationEntityData.PAGE_SOURCE, "Lid/dana/domain/auth/face/result/FaceAuthenticationResult;", "switch", "(ZLjava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "pin", RecordError.KEY_PUB_KEY, PhoneStateReceiver.VERIFY, "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/auth/face/repository/source/network/FaceAuthenticationEntityDataFactory;", "faceAuthenticationEntityDataFactory", "Lid/dana/data/auth/face/repository/source/network/FaceAuthenticationEntityDataFactory;", "Lid/dana/data/auth/face/mapper/FaceAuthenticationEntityMapper;", "faceAuthenticationEntityMapper", "Lid/dana/data/auth/face/mapper/FaceAuthenticationEntityMapper;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "holdLoginV1EntityRepository", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "<init>", "(Lid/dana/data/auth/face/repository/source/network/FaceAuthenticationEntityDataFactory;Lid/dana/data/auth/face/mapper/FaceAuthenticationEntityMapper;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FaceAuthenticationEntityRepository implements FaceAuthenticationRepository, HoldLoginV1Repository {
    private final FaceAuthenticationEntityDataFactory faceAuthenticationEntityDataFactory;
    private final FaceAuthenticationEntityMapper faceAuthenticationEntityMapper;
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;

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
    public FaceAuthenticationEntityRepository(FaceAuthenticationEntityDataFactory faceAuthenticationEntityDataFactory, FaceAuthenticationEntityMapper faceAuthenticationEntityMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(faceAuthenticationEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(faceAuthenticationEntityMapper, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.faceAuthenticationEntityDataFactory = faceAuthenticationEntityDataFactory;
        this.faceAuthenticationEntityMapper = faceAuthenticationEntityMapper;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
    }

    @Override // id.dana.domain.auth.face.repository.FaceAuthenticationRepository
    /* renamed from: switch  reason: not valid java name */
    public final Observable<FaceAuthenticationResult> mo785switch(boolean faceAuthNew, String securityId, String pageSource) {
        ObservableSource map = createFaceAuthenticationData().mo786switch(faceAuthNew, securityId, pageSource).map(new Function() { // from class: id.dana.data.auth.face.repository.FaceAuthenticationEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                FaceAuthenticationResult m783switch$lambda0;
                m783switch$lambda0 = FaceAuthenticationEntityRepository.m783switch$lambda0(FaceAuthenticationEntityRepository.this, (FaceAuthenticationEntityResult) obj);
                return m783switch$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return authenticatedRequest((Observable) map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: switch$lambda-0  reason: not valid java name */
    public static final FaceAuthenticationResult m783switch$lambda0(FaceAuthenticationEntityRepository faceAuthenticationEntityRepository, FaceAuthenticationEntityResult faceAuthenticationEntityResult) {
        Intrinsics.checkNotNullParameter(faceAuthenticationEntityRepository, "");
        Intrinsics.checkNotNullParameter(faceAuthenticationEntityResult, "");
        return faceAuthenticationEntityRepository.faceAuthenticationEntityMapper.transform(faceAuthenticationEntityResult);
    }

    @Override // id.dana.domain.auth.face.repository.FaceAuthenticationRepository
    public final Observable<FaceAuthenticationResult> verify(boolean faceAuthNew, String securityId, String pin, String pubKey) {
        ObservableSource map = createFaceAuthenticationData().verify(faceAuthNew, securityId, pin, pubKey).map(new Function() { // from class: id.dana.data.auth.face.repository.FaceAuthenticationEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                FaceAuthenticationResult m784verify$lambda1;
                m784verify$lambda1 = FaceAuthenticationEntityRepository.m784verify$lambda1(FaceAuthenticationEntityRepository.this, (FaceAuthenticationEntityResult) obj);
                return m784verify$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return authenticatedRequest((Observable) map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: verify$lambda-1  reason: not valid java name */
    public static final FaceAuthenticationResult m784verify$lambda1(FaceAuthenticationEntityRepository faceAuthenticationEntityRepository, FaceAuthenticationEntityResult faceAuthenticationEntityResult) {
        Intrinsics.checkNotNullParameter(faceAuthenticationEntityRepository, "");
        Intrinsics.checkNotNullParameter(faceAuthenticationEntityResult, "");
        return faceAuthenticationEntityRepository.faceAuthenticationEntityMapper.transform(faceAuthenticationEntityResult);
    }

    private final FaceAuthenticationEntityData createFaceAuthenticationData() {
        return this.faceAuthenticationEntityDataFactory.createData2("network");
    }
}
