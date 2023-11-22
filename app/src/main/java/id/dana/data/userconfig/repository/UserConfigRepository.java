package id.dana.data.userconfig.repository;

import id.dana.domain.userconfig.model.QueryConfig;
import id.dana.domain.userconfig.model.StoreConfig;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface UserConfigRepository {
    <T> Observable<T> getUserSpecificConfig(QueryConfig<T> queryConfig);

    Observable<Boolean> saveUserSpecificConfig(StoreConfig storeConfig);

    Observable<Boolean> saveUserSpecificConfig(StoreConfig storeConfig, boolean z);

    Observable<Boolean> saveUserSpecificConfigBackendFirst(StoreConfig storeConfig);

    Observable<Boolean> saveUserSpecificConfigBackendFirst(StoreConfig storeConfig, boolean z);

    Observable<Boolean> syncInAllUserConfig();
}
