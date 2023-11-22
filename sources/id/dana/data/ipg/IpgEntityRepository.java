package id.dana.data.ipg;

import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.errorconfig.ErrorConfigEntityData;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.data.ipg.mapper.IpgRegistrationUrlMapper;
import id.dana.data.ipg.model.UserConfigContentIPG;
import id.dana.data.ipg.repository.source.IpgRegistrationUrlEntityData;
import id.dana.data.ipg.repository.source.IpgRegistrationUrlEntityDataFactory;
import id.dana.data.ipg.repository.source.network.response.IpgRegistrationUrlResult;
import id.dana.data.login.source.LoginEntityData;
import id.dana.data.userconfig.repository.UserConfigEntityRepository;
import id.dana.domain.ipg.IpgRegistrationUrl;
import id.dana.domain.ipg.IpgRepository;
import id.dana.domain.userconfig.model.QueryConfig;
import id.dana.domain.userconfig.model.StoreConfig;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Singleton
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B)\b\u0007\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b0\u00101J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096\u0001¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096\u0001¢\u0006\u0004\b\u0006\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b\u0014\u0010\u0013J\u0010\u0010\u0016\u001a\u00020\u0015H\u0096\u0001¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u00042\u0006\u0010\u001e\u001a\u00020\u0018H\u0016¢\u0006\u0004\b \u0010!J%\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00042\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0018H\u0016¢\u0006\u0004\b#\u0010\u001dR\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/"}, d2 = {"Lid/dana/data/ipg/IpgEntityRepository;", "Lid/dana/domain/ipg/IpgRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "T", "Lio/reactivex/Observable;", "observable", "authenticatedRequest", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", "Lkotlinx/coroutines/flow/Flow;", "flow", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/data/account/repository/source/AccountEntityData;", "createAccountData", "()Lid/dana/data/account/repository/source/AccountEntityData;", "Lid/dana/data/ipg/repository/source/IpgRegistrationUrlEntityData;", "createIpgEntityData", "()Lid/dana/data/ipg/repository/source/IpgRegistrationUrlEntityData;", "Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createLocalErrorConfigData", "()Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createNetworkErrorConfigData", "Lid/dana/data/login/source/LoginEntityData;", "createNetworkLogin", "()Lid/dana/data/login/source/LoginEntityData;", "", "deviceId", "bizType", "Lid/dana/domain/ipg/IpgRegistrationUrl;", "getIpgRegistrationUrl", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "userConsentConfigKey", "", "isClickedAgree", "(Ljava/lang/String;)Lio/reactivex/Observable;", "userConsentSyncKey", "saveClickedAgree", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "holdLoginV1EntityRepository", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/ipg/repository/source/IpgRegistrationUrlEntityDataFactory;", "ipgRegistrationUrlEntityDataFactory", "Lid/dana/data/ipg/repository/source/IpgRegistrationUrlEntityDataFactory;", "Lid/dana/data/ipg/mapper/IpgRegistrationUrlMapper;", "ipgRegistrationUrlMapper", "Lid/dana/data/ipg/mapper/IpgRegistrationUrlMapper;", "Lid/dana/data/userconfig/repository/UserConfigEntityRepository;", "userConfigEntityRepository", "Lid/dana/data/userconfig/repository/UserConfigEntityRepository;", "<init>", "(Lid/dana/data/userconfig/repository/UserConfigEntityRepository;Lid/dana/data/ipg/repository/source/IpgRegistrationUrlEntityDataFactory;Lid/dana/data/ipg/mapper/IpgRegistrationUrlMapper;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class IpgEntityRepository implements IpgRepository, HoldLoginV1Repository {
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final IpgRegistrationUrlEntityDataFactory ipgRegistrationUrlEntityDataFactory;
    private final IpgRegistrationUrlMapper ipgRegistrationUrlMapper;
    private final UserConfigEntityRepository userConfigEntityRepository;

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
    public IpgEntityRepository(UserConfigEntityRepository userConfigEntityRepository, IpgRegistrationUrlEntityDataFactory ipgRegistrationUrlEntityDataFactory, IpgRegistrationUrlMapper ipgRegistrationUrlMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(userConfigEntityRepository, "");
        Intrinsics.checkNotNullParameter(ipgRegistrationUrlEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(ipgRegistrationUrlMapper, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.userConfigEntityRepository = userConfigEntityRepository;
        this.ipgRegistrationUrlEntityDataFactory = ipgRegistrationUrlEntityDataFactory;
        this.ipgRegistrationUrlMapper = ipgRegistrationUrlMapper;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
    }

    @Override // id.dana.domain.ipg.IpgRepository
    public final Observable<Boolean> isClickedAgree(String userConsentConfigKey) {
        Intrinsics.checkNotNullParameter(userConsentConfigKey, "");
        Observable<Boolean> map = this.userConfigEntityRepository.getUserSpecificConfig(new QueryConfig(userConsentConfigKey, UserConfigContentIPG.class)).map(new Function() { // from class: id.dana.data.ipg.IpgEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean m1378isClickedAgree$lambda0;
                m1378isClickedAgree$lambda0 = IpgEntityRepository.m1378isClickedAgree$lambda0((UserConfigContentIPG) obj);
                return m1378isClickedAgree$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: isClickedAgree$lambda-0  reason: not valid java name */
    public static final Boolean m1378isClickedAgree$lambda0(UserConfigContentIPG userConfigContentIPG) {
        Intrinsics.checkNotNullParameter(userConfigContentIPG, "");
        return Boolean.valueOf(userConfigContentIPG.getUserConsent());
    }

    @Override // id.dana.domain.ipg.IpgRepository
    public final Observable<Boolean> saveClickedAgree(String userConsentConfigKey, String userConsentSyncKey) {
        Intrinsics.checkNotNullParameter(userConsentConfigKey, "");
        Intrinsics.checkNotNullParameter(userConsentSyncKey, "");
        UserConfigContentIPG userConfigContentIPG = new UserConfigContentIPG(false, 1, null);
        userConfigContentIPG.setUserConsent(true);
        Observable<Boolean> saveUserSpecificConfigBackendFirst = this.userConfigEntityRepository.saveUserSpecificConfigBackendFirst(new StoreConfig(userConsentConfigKey, userConsentSyncKey, userConfigContentIPG));
        Intrinsics.checkNotNullExpressionValue(saveUserSpecificConfigBackendFirst, "");
        return saveUserSpecificConfigBackendFirst;
    }

    @Override // id.dana.domain.ipg.IpgRepository
    public final Observable<IpgRegistrationUrl> getIpgRegistrationUrl(String deviceId, String bizType) {
        Intrinsics.checkNotNullParameter(deviceId, "");
        Intrinsics.checkNotNullParameter(bizType, "");
        Observable<IpgRegistrationUrl> map = authenticatedRequest(createIpgEntityData().getIpgRegistrationUrl(deviceId, bizType)).map(new Function() { // from class: id.dana.data.ipg.IpgEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                IpgRegistrationUrl m1377getIpgRegistrationUrl$lambda1;
                m1377getIpgRegistrationUrl$lambda1 = IpgEntityRepository.m1377getIpgRegistrationUrl$lambda1(IpgEntityRepository.this, (IpgRegistrationUrlResult) obj);
                return m1377getIpgRegistrationUrl$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getIpgRegistrationUrl$lambda-1  reason: not valid java name */
    public static final IpgRegistrationUrl m1377getIpgRegistrationUrl$lambda1(IpgEntityRepository ipgEntityRepository, IpgRegistrationUrlResult ipgRegistrationUrlResult) {
        Intrinsics.checkNotNullParameter(ipgEntityRepository, "");
        Intrinsics.checkNotNullParameter(ipgRegistrationUrlResult, "");
        return ipgEntityRepository.ipgRegistrationUrlMapper.transform(ipgRegistrationUrlResult);
    }

    private final IpgRegistrationUrlEntityData createIpgEntityData() {
        return this.ipgRegistrationUrlEntityDataFactory.createData2("network");
    }
}
