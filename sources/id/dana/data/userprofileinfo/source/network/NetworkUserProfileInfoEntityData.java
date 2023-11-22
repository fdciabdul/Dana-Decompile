package id.dana.data.userprofileinfo.source.network;

import android.content.Context;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.userprofileinfo.source.UserProfileInfoEntityData;
import id.dana.data.userprofileinfo.source.network.request.UserProfileInfoRequest;
import id.dana.data.userprofileinfo.source.network.result.UserProfileInfoResult;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;

/* loaded from: classes4.dex */
public class NetworkUserProfileInfoEntityData extends SecureBaseNetwork<UserProfileInfoFacade> implements UserProfileInfoEntityData {
    public NetworkUserProfileInfoEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
    }

    @Override // id.dana.network.base.BaseNetwork
    public Class<UserProfileInfoFacade> getFacadeClass() {
        return UserProfileInfoFacade.class;
    }

    @Override // id.dana.data.userprofileinfo.source.UserProfileInfoEntityData
    public Observable<UserProfileInfoResult> updateUserProfileInfo(String str, String str2) {
        final UserProfileInfoRequest userProfileInfoRequest = new UserProfileInfoRequest();
        userProfileInfoRequest.envInfo = generateMobileEnvInfo();
        userProfileInfoRequest.userInfoBizScene = str;
        userProfileInfoRequest.value = str2;
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.userprofileinfo.source.network.NetworkUserProfileInfoEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                UserProfileInfoResult updateUserInfo;
                updateUserInfo = ((UserProfileInfoFacade) obj).updateUserInfo(UserProfileInfoRequest.this);
                return updateUserInfo;
            }
        });
    }
}
