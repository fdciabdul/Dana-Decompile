package id.dana.data.userconfig.repository.source.network;

import android.content.Context;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.userconfig.repository.source.UserConfigEntityData;
import id.dana.data.userconfig.repository.source.network.request.UserConfigQueryRequest;
import id.dana.data.userconfig.repository.source.network.request.UserConfigStoreRequest;
import id.dana.data.userconfig.repository.source.network.result.UserConfigQueryResult;
import id.dana.data.userconfig.repository.source.network.result.UserConfigStoreResult;
import id.dana.data.userconfig.repository.source.network.result.UserGeneralConfig;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class NetworkUserConfigEntityData extends SecureBaseNetwork<UserConfigRpcFacade> implements UserConfigEntityData {
    @Inject
    public NetworkUserConfigEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
    }

    @Override // id.dana.network.base.BaseNetwork
    public Class<UserConfigRpcFacade> getFacadeClass() {
        return UserConfigRpcFacade.class;
    }

    @Override // id.dana.data.userconfig.repository.source.UserConfigEntityData
    public Observable<UserConfigQueryResult> getUserConfig(final UserConfigQueryRequest userConfigQueryRequest) {
        userConfigQueryRequest.envInfo = generateMobileEnvInfo();
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.userconfig.repository.source.network.NetworkUserConfigEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                UserConfigQueryResult userConfig;
                userConfig = ((UserConfigRpcFacade) obj).getUserConfig(UserConfigQueryRequest.this);
                return userConfig;
            }
        });
    }

    @Override // id.dana.data.userconfig.repository.source.UserConfigEntityData
    public Observable<UserConfigStoreResult> saveUserConfig(UserGeneralConfig userGeneralConfig) {
        final UserConfigStoreRequest userConfigStoreRequest = new UserConfigStoreRequest(userGeneralConfig.getBizType(), userGeneralConfig.getContent());
        userConfigStoreRequest.envInfo = generateMobileEnvInfo();
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.userconfig.repository.source.network.NetworkUserConfigEntityData$$ExternalSyntheticLambda2
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                UserConfigStoreResult storeUserConfig;
                storeUserConfig = ((UserConfigRpcFacade) obj).storeUserConfig(UserConfigStoreRequest.this);
                return storeUserConfig;
            }
        });
    }

    @Override // id.dana.data.userconfig.repository.source.UserConfigEntityData
    public Observable<UserConfigQueryResult> getAllUserConfig() {
        final UserConfigQueryRequest empty = UserConfigQueryRequest.empty();
        empty.envInfo = generateMobileEnvInfo();
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.userconfig.repository.source.network.NetworkUserConfigEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                UserConfigQueryResult userConfig;
                userConfig = ((UserConfigRpcFacade) obj).getUserConfig(UserConfigQueryRequest.this);
                return userConfig;
            }
        });
    }
}
