package id.dana.feeds.data.username.source.network.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.feeds.domain.username.model.UserProfileResponse;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/feeds/data/username/source/network/response/UpdateUserInfoResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "Lid/dana/feeds/domain/username/model/UserProfileResponse;", "toUserProfileResponse", "()Lid/dana/feeds/domain/username/model/UserProfileResponse;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UpdateUserInfoResult extends BaseRpcResult {
    public final UserProfileResponse toUserProfileResponse() {
        boolean z = this.success;
        String str = this.errorCode;
        if (str == null) {
            str = "";
        }
        String str2 = this.errorMessage;
        return new UserProfileResponse(z, str, str2 != null ? str2 : "");
    }
}
