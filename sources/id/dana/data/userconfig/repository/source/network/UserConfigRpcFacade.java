package id.dana.data.userconfig.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.data.userconfig.repository.source.network.request.UserConfigQueryRequest;
import id.dana.data.userconfig.repository.source.network.request.UserConfigStoreRequest;
import id.dana.data.userconfig.repository.source.network.result.UserConfigQueryResult;
import id.dana.data.userconfig.repository.source.network.result.UserConfigStoreResult;

/* loaded from: classes4.dex */
public interface UserConfigRpcFacade {
    @OperationType("alipayplus.mobilewallet.user.config.query")
    @SignCheck
    UserConfigQueryResult getUserConfig(UserConfigQueryRequest userConfigQueryRequest);

    @OperationType(TrackerDataKey.NetworkErrorOperationTypeProperty.SAVE_USER_CONFIG)
    @SignCheck
    UserConfigStoreResult storeUserConfig(UserConfigStoreRequest userConfigStoreRequest);
}
