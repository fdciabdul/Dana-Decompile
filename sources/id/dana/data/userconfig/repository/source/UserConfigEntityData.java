package id.dana.data.userconfig.repository.source;

import id.dana.data.userconfig.repository.source.network.request.UserConfigQueryRequest;
import id.dana.data.userconfig.repository.source.network.result.UserConfigQueryResult;
import id.dana.data.userconfig.repository.source.network.result.UserConfigStoreResult;
import id.dana.data.userconfig.repository.source.network.result.UserGeneralConfig;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface UserConfigEntityData {
    Observable<UserConfigQueryResult> getAllUserConfig();

    Observable<UserConfigQueryResult> getUserConfig(UserConfigQueryRequest userConfigQueryRequest);

    Observable<UserConfigStoreResult> saveUserConfig(UserGeneralConfig userGeneralConfig);
}
