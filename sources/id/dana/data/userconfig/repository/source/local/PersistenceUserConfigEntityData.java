package id.dana.data.userconfig.repository.source.local;

import id.dana.data.userconfig.BiztypeEmptyException;
import id.dana.data.userconfig.mapper.UserConfigQueryResultMapper;
import id.dana.data.userconfig.repository.source.UserConfigEntityData;
import id.dana.data.userconfig.repository.source.network.request.UserConfigQueryRequest;
import id.dana.data.userconfig.repository.source.network.result.UserConfigQueryResult;
import id.dana.data.userconfig.repository.source.network.result.UserConfigStoreResult;
import id.dana.data.userconfig.repository.source.network.result.UserGeneralConfig;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class PersistenceUserConfigEntityData implements UserConfigEntityData {
    private final UserConfigPreference userConfigPreference;
    private final UserConfigQueryResultMapper userConfigQueryResultMapper;

    @Inject
    public PersistenceUserConfigEntityData(UserConfigPreference userConfigPreference, UserConfigQueryResultMapper userConfigQueryResultMapper) {
        this.userConfigPreference = userConfigPreference;
        this.userConfigQueryResultMapper = userConfigQueryResultMapper;
    }

    @Override // id.dana.data.userconfig.repository.source.UserConfigEntityData
    public Observable<UserConfigQueryResult> getUserConfig(UserConfigQueryRequest userConfigQueryRequest) {
        List<String> bizTypes = userConfigQueryRequest.getBizTypes();
        if (bizTypes == null || bizTypes.isEmpty()) {
            return Observable.error(new BiztypeEmptyException());
        }
        return Observable.just(this.userConfigQueryResultMapper.apply(this.userConfigPreference.getUserConfig(bizTypes.get(0))));
    }

    @Override // id.dana.data.userconfig.repository.source.UserConfigEntityData
    public Observable<UserConfigStoreResult> saveUserConfig(UserGeneralConfig userGeneralConfig) {
        this.userConfigPreference.saveUserConfig(userGeneralConfig);
        UserConfigStoreResult userConfigStoreResult = new UserConfigStoreResult();
        userConfigStoreResult.success = true;
        return Observable.just(userConfigStoreResult);
    }

    @Override // id.dana.data.userconfig.repository.source.UserConfigEntityData
    public Observable<UserConfigQueryResult> getAllUserConfig() {
        return Observable.error(new Exception("Not Implemented"));
    }
}
