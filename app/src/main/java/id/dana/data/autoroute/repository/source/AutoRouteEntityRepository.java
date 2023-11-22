package id.dana.data.autoroute.repository.source;

import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.autoroute.mapper.AutoRouteMapperKt;
import id.dana.data.autoroute.model.AutoRouteInitResult;
import id.dana.data.autoroute.repository.AutoRouteEntityData;
import id.dana.data.autoroute.repository.source.local.LocalAutoRouteEntity;
import id.dana.data.errorconfig.ErrorConfigEntityData;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.data.login.source.LoginEntityData;
import id.dana.domain.autoroute.model.AutoRouteInit;
import id.dana.domain.autoroute.model.UserAutoRouteConfigStore;
import id.dana.domain.autoroute.model.UserAutoRouteConfigSwitch;
import id.dana.domain.autoroute.repository.AutoRouteRepository;
import id.dana.network.response.autoroute.UserAutoRouteConfigSwitchResult;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B!\b\u0007\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b/\u00100J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096\u0001¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096\u0001¢\u0006\u0004\b\u0006\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u000eH\u0096\u0001¢\u0006\u0004\b\u0014\u0010\u0010J\u0010\u0010\u0016\u001a\u00020\u0015H\u0096\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u0004H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00180\u00042\u0006\u0010\u001f\u001a\u00020\u0018H\u0016¢\u0006\u0004\b \u0010\u001cJ\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u00042\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010."}, d2 = {"Lid/dana/data/autoroute/repository/source/AutoRouteEntityRepository;", "Lid/dana/domain/autoroute/repository/AutoRouteRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "T", "Lio/reactivex/Observable;", "observable", "authenticatedRequest", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", "Lkotlinx/coroutines/flow/Flow;", "flow", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/data/account/repository/source/AccountEntityData;", "createAccountData", "()Lid/dana/data/account/repository/source/AccountEntityData;", "Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createLocalErrorConfigData", "()Lid/dana/data/errorconfig/ErrorConfigEntityData;", "Lid/dana/data/autoroute/repository/AutoRouteEntityData;", "createNetworkAutoRouteEntityData", "()Lid/dana/data/autoroute/repository/AutoRouteEntityData;", "createNetworkErrorConfigData", "Lid/dana/data/login/source/LoginEntityData;", "createNetworkLogin", "()Lid/dana/data/login/source/LoginEntityData;", "", "needAssetCheck", "Lid/dana/domain/autoroute/model/AutoRouteInit;", "getInitialSetting", "(Z)Lio/reactivex/Observable;", "isHavingAutoRouteAsset", "()Lio/reactivex/Observable;", "isAssetExist", "saveAutoRouteAssetState", "Lid/dana/domain/autoroute/model/UserAutoRouteConfigStore;", "userAutoRouteConfigStore", "Lid/dana/domain/autoroute/model/UserAutoRouteConfigSwitch;", "switchConfig", "(Lid/dana/domain/autoroute/model/UserAutoRouteConfigStore;)Lio/reactivex/Observable;", "Lid/dana/data/autoroute/repository/source/AutoRouteDataFactory;", "autoRouteDataFactory", "Lid/dana/data/autoroute/repository/source/AutoRouteDataFactory;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "holdLoginV1EntityRepository", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/autoroute/repository/source/local/LocalAutoRouteEntity;", "localAutoRouteEntity", "Lid/dana/data/autoroute/repository/source/local/LocalAutoRouteEntity;", "<init>", "(Lid/dana/data/autoroute/repository/source/AutoRouteDataFactory;Lid/dana/data/autoroute/repository/source/local/LocalAutoRouteEntity;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AutoRouteEntityRepository implements AutoRouteRepository, HoldLoginV1Repository {
    private final AutoRouteDataFactory autoRouteDataFactory;
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final LocalAutoRouteEntity localAutoRouteEntity;

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
    public AutoRouteEntityRepository(AutoRouteDataFactory autoRouteDataFactory, LocalAutoRouteEntity localAutoRouteEntity, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(autoRouteDataFactory, "");
        Intrinsics.checkNotNullParameter(localAutoRouteEntity, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.autoRouteDataFactory = autoRouteDataFactory;
        this.localAutoRouteEntity = localAutoRouteEntity;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
    }

    @Override // id.dana.domain.autoroute.repository.AutoRouteRepository
    public final Observable<AutoRouteInit> getInitialSetting(boolean needAssetCheck) {
        ObservableSource map = createNetworkAutoRouteEntityData().getInitialSetting(needAssetCheck).map(new Function() { // from class: id.dana.data.autoroute.repository.source.AutoRouteEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                AutoRouteInit m801getInitialSetting$lambda0;
                m801getInitialSetting$lambda0 = AutoRouteEntityRepository.m801getInitialSetting$lambda0((AutoRouteInitResult) obj);
                return m801getInitialSetting$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return authenticatedRequest((Observable) map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getInitialSetting$lambda-0  reason: not valid java name */
    public static final AutoRouteInit m801getInitialSetting$lambda0(AutoRouteInitResult autoRouteInitResult) {
        Intrinsics.checkNotNullParameter(autoRouteInitResult, "");
        return AutoRouteMapperKt.toAutoRouteInit(autoRouteInitResult);
    }

    @Override // id.dana.domain.autoroute.repository.AutoRouteRepository
    public final Observable<UserAutoRouteConfigSwitch> switchConfig(UserAutoRouteConfigStore userAutoRouteConfigStore) {
        Intrinsics.checkNotNullParameter(userAutoRouteConfigStore, "");
        ObservableSource map = createNetworkAutoRouteEntityData().switchConfig(AutoRouteMapperKt.toUserAutoRouteConfigRequest(userAutoRouteConfigStore), userAutoRouteConfigStore.isFromCashierFlow()).map(new Function() { // from class: id.dana.data.autoroute.repository.source.AutoRouteEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                UserAutoRouteConfigSwitch m802switchConfig$lambda1;
                m802switchConfig$lambda1 = AutoRouteEntityRepository.m802switchConfig$lambda1((UserAutoRouteConfigSwitchResult) obj);
                return m802switchConfig$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return authenticatedRequest((Observable) map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: switchConfig$lambda-1  reason: not valid java name */
    public static final UserAutoRouteConfigSwitch m802switchConfig$lambda1(UserAutoRouteConfigSwitchResult userAutoRouteConfigSwitchResult) {
        Intrinsics.checkNotNullParameter(userAutoRouteConfigSwitchResult, "");
        return AutoRouteMapperKt.toUserAutoRouteSwitch(userAutoRouteConfigSwitchResult);
    }

    @Override // id.dana.domain.autoroute.repository.AutoRouteRepository
    public final Observable<Boolean> saveAutoRouteAssetState(boolean isAssetExist) {
        return this.localAutoRouteEntity.saveAutoRouteAssetState(isAssetExist);
    }

    @Override // id.dana.domain.autoroute.repository.AutoRouteRepository
    public final Observable<Boolean> isHavingAutoRouteAsset() {
        return this.localAutoRouteEntity.isHavingAutoRouteAsset();
    }

    private final AutoRouteEntityData createNetworkAutoRouteEntityData() {
        return this.autoRouteDataFactory.createData2("network");
    }
}
