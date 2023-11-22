package id.dana.data.userprofileinfo.mapper;

import id.dana.data.BaseMapper;
import id.dana.data.userprofileinfo.source.network.result.UserProfileInfoResult;
import id.dana.domain.userprofileinfo.response.UserProfileInfoResponse;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class UserProfileInfoMapper {
    @Inject
    public UserProfileInfoMapper() {
    }

    public UserProfileInfoResponse transform(UserProfileInfoResult userProfileInfoResult) {
        UserProfileInfoResponse userProfileInfoResponse;
        if (userProfileInfoResult != null) {
            userProfileInfoResponse = new UserProfileInfoResponse();
            userProfileInfoResponse.setErrorCode(userProfileInfoResult.errorCode);
            userProfileInfoResponse.setSuccess(userProfileInfoResult.success);
        } else {
            userProfileInfoResponse = null;
        }
        BaseMapper.transform(userProfileInfoResponse, userProfileInfoResult);
        return userProfileInfoResponse;
    }
}
