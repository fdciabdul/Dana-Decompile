package id.dana.data.user.source.network;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.user.source.UserEntityData;
import id.dana.data.user.source.network.request.CheckUserInfoRequest;
import id.dana.data.user.source.network.request.MiniProgramUserInfoRequest;
import id.dana.data.user.source.network.request.UserInfoRequest;
import id.dana.data.user.source.network.result.CheckUserInfoResponse;
import id.dana.data.user.source.network.result.MiniProgramUserInfoResult;
import id.dana.data.user.source.network.result.UserCohortResult;
import id.dana.data.user.source.network.result.UserInfoRpcResult;
import id.dana.domain.featureconfig.model.QueryUserDataConfig;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.NotImplementedError;

/* loaded from: classes2.dex */
public class NetworkUserEntityData extends SecureBaseNetwork<UserInfoRpcFacade> implements UserEntityData {
    private QueryUserDataConfig queryUserDataConfig;

    @Inject
    public NetworkUserEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        this.queryUserDataConfig = new QueryUserDataConfig();
    }

    @Override // id.dana.network.base.BaseNetwork
    public Class<UserInfoRpcFacade> getFacadeClass() {
        return UserInfoRpcFacade.class;
    }

    @Override // id.dana.data.user.source.UserEntityData
    public Observable<UserInfoRpcResult> getUserInfo() {
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.user.source.network.NetworkUserEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkUserEntityData.this.m2110x3543d8c5((UserInfoRpcFacade) obj);
            }
        }, UserInfoRpcResult.class);
    }

    /* renamed from: lambda$getUserInfo$0$id-dana-data-user-source-network-NetworkUserEntityData */
    public /* synthetic */ UserInfoRpcResult m2110x3543d8c5(UserInfoRpcFacade userInfoRpcFacade) {
        UserInfoRequest userInfoRequest = new UserInfoRequest();
        userInfoRequest.queryType = "FULL";
        userInfoRequest.envInfo = generateMobileEnvInfo();
        if (isEligibleToUseOmniprod(userInfoRequest.queryType)) {
            return userInfoRpcFacade.getUserInfoOmniProd(userInfoRequest);
        }
        return userInfoRpcFacade.getUserInfo(userInfoRequest);
    }

    @Override // id.dana.data.user.source.UserEntityData
    public Observable<CheckUserInfoResponse> checkUserInfo(final String str, final String str2, final String str3) {
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.user.source.network.NetworkUserEntityData$$ExternalSyntheticLambda8
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkUserEntityData.this.m2104x793c60f2(str, str2, str3, (UserInfoRpcFacade) obj);
            }
        }, CheckUserInfoResponse.class);
    }

    /* renamed from: lambda$checkUserInfo$1$id-dana-data-user-source-network-NetworkUserEntityData */
    public /* synthetic */ CheckUserInfoResponse m2104x793c60f2(String str, String str2, String str3, UserInfoRpcFacade userInfoRpcFacade) {
        CheckUserInfoRequest checkUserInfoRequest = new CheckUserInfoRequest(str, str2, str3);
        checkUserInfoRequest.envInfo = generateMobileEnvInfo();
        return userInfoRpcFacade.queryCheckUserInfo(checkUserInfoRequest);
    }

    @Override // id.dana.data.user.source.UserEntityData
    public Observable<MiniProgramUserInfoResult> getMiniProgramUserInfo(final String str, final String str2) {
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.user.source.network.NetworkUserEntityData$$ExternalSyntheticLambda4
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkUserEntityData.this.m2108x1720db68(str, str2, (UserInfoRpcFacade) obj);
            }
        }, MiniProgramUserInfoResult.class);
    }

    /* renamed from: lambda$getMiniProgramUserInfo$2$id-dana-data-user-source-network-NetworkUserEntityData */
    public /* synthetic */ MiniProgramUserInfoResult m2108x1720db68(String str, String str2, UserInfoRpcFacade userInfoRpcFacade) {
        MiniProgramUserInfoRequest miniProgramUserInfoRequest = new MiniProgramUserInfoRequest(str, str2);
        miniProgramUserInfoRequest.envInfo = generateMobileEnvInfo();
        return userInfoRpcFacade.getMiniProgramUserInfo(miniProgramUserInfoRequest);
    }

    @Override // id.dana.data.user.source.UserEntityData
    public Observable<UserInfoRpcResult> getFaceAuthInfo() {
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.user.source.network.NetworkUserEntityData$$ExternalSyntheticLambda6
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkUserEntityData.this.m2106x7a9dde48((UserInfoRpcFacade) obj);
            }
        }, UserInfoRpcResult.class);
    }

    /* renamed from: lambda$getFaceAuthInfo$3$id-dana-data-user-source-network-NetworkUserEntityData */
    public /* synthetic */ UserInfoRpcResult m2106x7a9dde48(UserInfoRpcFacade userInfoRpcFacade) {
        UserInfoRequest userInfoRequest = new UserInfoRequest();
        userInfoRequest.queryType = "FACE_AUTH";
        userInfoRequest.envInfo = generateMobileEnvInfo();
        if (isEligibleToUseOmniprod(userInfoRequest.queryType)) {
            return userInfoRpcFacade.getUserInfoOmniProd(userInfoRequest);
        }
        return userInfoRpcFacade.getUserInfo(userInfoRequest);
    }

    @Override // id.dana.data.user.source.UserEntityData
    public Observable<UserInfoRpcResult> getBalance() {
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.user.source.network.NetworkUserEntityData$$ExternalSyntheticLambda2
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkUserEntityData.this.m2105x805a78f0((UserInfoRpcFacade) obj);
            }
        }, UserInfoRpcResult.class);
    }

    /* renamed from: lambda$getBalance$4$id-dana-data-user-source-network-NetworkUserEntityData */
    public /* synthetic */ UserInfoRpcResult m2105x805a78f0(UserInfoRpcFacade userInfoRpcFacade) {
        UserInfoRequest userInfoRequest = new UserInfoRequest();
        userInfoRequest.queryType = "BALANCE";
        userInfoRequest.envInfo = generateMobileEnvInfo();
        return userInfoRpcFacade.getBalance(userInfoRequest);
    }

    @Override // id.dana.data.user.source.UserEntityData
    public Observable<UserInfoRpcResult> getInfoWithKyc() {
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.user.source.network.NetworkUserEntityData$$ExternalSyntheticLambda7
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkUserEntityData.this.m2107x9c5a004a((UserInfoRpcFacade) obj);
            }
        }, UserInfoRpcResult.class);
    }

    /* renamed from: lambda$getInfoWithKyc$5$id-dana-data-user-source-network-NetworkUserEntityData */
    public /* synthetic */ UserInfoRpcResult m2107x9c5a004a(UserInfoRpcFacade userInfoRpcFacade) {
        UserInfoRequest userInfoRequest = new UserInfoRequest();
        userInfoRequest.queryType = UserInfoRequest.KYC_INFO;
        userInfoRequest.envInfo = generateMobileEnvInfo();
        if (isEligibleToUseOmniprod(userInfoRequest.queryType)) {
            return userInfoRpcFacade.getUserInfoOmniProd(userInfoRequest);
        }
        return userInfoRpcFacade.getUserInfo(userInfoRequest);
    }

    @Override // id.dana.data.user.source.UserEntityData
    public Observable<UserInfoRpcResult> getUserInfoWithUserPan() {
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.user.source.network.NetworkUserEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkUserEntityData.this.m2111xff11b797((UserInfoRpcFacade) obj);
            }
        }, UserInfoRpcResult.class);
    }

    /* renamed from: lambda$getUserInfoWithUserPan$6$id-dana-data-user-source-network-NetworkUserEntityData */
    public /* synthetic */ UserInfoRpcResult m2111xff11b797(UserInfoRpcFacade userInfoRpcFacade) {
        UserInfoRequest userInfoRequest = new UserInfoRequest();
        userInfoRequest.queryType = UserInfoRequest.USER_PAN;
        userInfoRequest.envInfo = generateMobileEnvInfo();
        if (isEligibleToUseOmniprod(userInfoRequest.queryType)) {
            return userInfoRpcFacade.getUserInfoOmniProd(userInfoRequest);
        }
        return userInfoRpcFacade.getUserInfo(userInfoRequest);
    }

    @Override // id.dana.data.user.source.UserEntityData
    public Observable<UserInfoRpcResult> getUserStatusInfo() {
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.user.source.network.NetworkUserEntityData$$ExternalSyntheticLambda5
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkUserEntityData.this.m2112x36adb50c((UserInfoRpcFacade) obj);
            }
        }, UserInfoRpcResult.class);
    }

    /* renamed from: lambda$getUserStatusInfo$7$id-dana-data-user-source-network-NetworkUserEntityData */
    public /* synthetic */ UserInfoRpcResult m2112x36adb50c(UserInfoRpcFacade userInfoRpcFacade) {
        UserInfoRequest userInfoRequest = new UserInfoRequest();
        userInfoRequest.queryType = UserInfoRequest.STATUS_INFO;
        userInfoRequest.envInfo = generateMobileEnvInfo();
        if (isEligibleToUseOmniprod(userInfoRequest.queryType)) {
            return userInfoRpcFacade.getUserInfoOmniProd(userInfoRequest);
        }
        return userInfoRpcFacade.getUserInfo(userInfoRequest);
    }

    @Override // id.dana.data.user.source.UserEntityData
    public Observable<Long> updateUserInfoCache(String str, UserInfoRpcResult userInfoRpcResult, String str2) {
        throw new NotImplementedError();
    }

    @Override // id.dana.data.user.source.UserEntityData
    public Observable<UserCohortResult> getUserCohort() {
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.user.source.network.NetworkUserEntityData$$ExternalSyntheticLambda3
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkUserEntityData.this.m2109x73d3a356((UserInfoRpcFacade) obj);
            }
        }, UserCohortResult.class);
    }

    /* renamed from: lambda$getUserCohort$8$id-dana-data-user-source-network-NetworkUserEntityData */
    public /* synthetic */ UserCohortResult m2109x73d3a356(UserInfoRpcFacade userInfoRpcFacade) {
        BaseRpcRequest baseRpcRequest = new BaseRpcRequest();
        baseRpcRequest.envInfo = generateMobileEnvInfo();
        return userInfoRpcFacade.getUserCohort(baseRpcRequest);
    }

    @Override // id.dana.data.user.source.UserEntityData
    public void setQueryUserDataConfig(QueryUserDataConfig queryUserDataConfig) {
        if (this.queryUserDataConfig.getSeperateUserInfo() != queryUserDataConfig.getSeperateUserInfo()) {
            this.queryUserDataConfig = queryUserDataConfig;
        }
    }

    @Override // id.dana.data.user.source.UserEntityData
    public void clearAll() {
        throw new NotImplementedError();
    }

    private boolean isEligibleToUseOmniprod(String str) {
        return this.queryUserDataConfig.getSeperateUserInfo() && this.queryUserDataConfig.getQueryType().contains(str);
    }
}
