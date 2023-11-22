package id.dana.data.userprofileinfo.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.data.userprofileinfo.source.network.request.UserProfileInfoRequest;
import id.dana.data.userprofileinfo.source.network.result.UserProfileInfoResult;

/* loaded from: classes4.dex */
public interface UserProfileInfoFacade {
    @OperationType("alipayplus.home.user.profile.updateUserInfo")
    @SignCheck
    UserProfileInfoResult updateUserInfo(UserProfileInfoRequest userProfileInfoRequest);
}
