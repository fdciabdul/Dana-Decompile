package id.dana.data.user.source;

import id.dana.data.user.source.network.result.CheckUserInfoResponse;
import id.dana.data.user.source.network.result.MiniProgramUserInfoResult;
import id.dana.data.user.source.network.result.UserCohortResult;
import id.dana.data.user.source.network.result.UserInfoRpcResult;
import id.dana.domain.featureconfig.model.QueryUserDataConfig;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface UserEntityData {
    Observable<CheckUserInfoResponse> checkUserInfo(String str, String str2, String str3);

    void clearAll();

    Observable<UserInfoRpcResult> getBalance();

    Observable<UserInfoRpcResult> getFaceAuthInfo();

    Observable<UserInfoRpcResult> getInfoWithKyc();

    Observable<MiniProgramUserInfoResult> getMiniProgramUserInfo(String str, String str2);

    Observable<UserCohortResult> getUserCohort();

    Observable<UserInfoRpcResult> getUserInfo();

    Observable<UserInfoRpcResult> getUserInfoWithUserPan();

    Observable<UserInfoRpcResult> getUserStatusInfo();

    void setQueryUserDataConfig(QueryUserDataConfig queryUserDataConfig);

    Observable<Long> updateUserInfoCache(String str, UserInfoRpcResult userInfoRpcResult, String str2);
}
