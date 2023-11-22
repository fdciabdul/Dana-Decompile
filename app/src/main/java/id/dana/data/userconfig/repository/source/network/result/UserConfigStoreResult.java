package id.dana.data.userconfig.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;

/* loaded from: classes4.dex */
public class UserConfigStoreResult extends BaseRpcResult {
    public static UserConfigStoreResult success() {
        UserConfigStoreResult userConfigStoreResult = new UserConfigStoreResult();
        userConfigStoreResult.success = true;
        return userConfigStoreResult;
    }
}
