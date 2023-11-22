package id.dana.feeds.data.username.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.feeds.data.username.source.network.request.CheckUsernameRequest;
import id.dana.feeds.data.username.source.network.request.UpdateUserInfoRequest;
import id.dana.feeds.data.username.source.network.response.CheckUsernameResult;
import id.dana.feeds.data.username.source.network.response.UpdateUserInfoResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/feeds/data/username/source/network/UserProfileService;", "", "Lid/dana/feeds/data/username/source/network/request/CheckUsernameRequest;", "request", "Lid/dana/feeds/data/username/source/network/response/CheckUsernameResult;", "checkUsername", "(Lid/dana/feeds/data/username/source/network/request/CheckUsernameRequest;)Lid/dana/feeds/data/username/source/network/response/CheckUsernameResult;", "Lid/dana/feeds/data/username/source/network/request/UpdateUserInfoRequest;", "Lid/dana/feeds/data/username/source/network/response/UpdateUserInfoResult;", "updateUserInfo", "(Lid/dana/feeds/data/username/source/network/request/UpdateUserInfoRequest;)Lid/dana/feeds/data/username/source/network/response/UpdateUserInfoResult;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface UserProfileService {
    @OperationType("alipayplus.mobilewallet.wallet.user.checkUsername")
    @SignCheck
    CheckUsernameResult checkUsername(CheckUsernameRequest request);

    @OperationType("alipayplus.home.user.profile.updateUserInfo")
    @SignCheck
    UpdateUserInfoResult updateUserInfo(UpdateUserInfoRequest request);
}
