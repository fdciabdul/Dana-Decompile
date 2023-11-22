package id.dana.data.version;

import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.domain.version.Version;
import id.dana.domain.version.VersionRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class VersionEntityRepository implements VersionRepository {
    private final StorageVersionPreference BuiltInFictitiousFunctionClassFactory;
    private final ConfigEntityDataFactory MyBillsEntityDataFactory;

    @Inject
    public VersionEntityRepository(ConfigEntityDataFactory configEntityDataFactory, StorageVersionPreference storageVersionPreference) {
        this.MyBillsEntityDataFactory = configEntityDataFactory;
        this.BuiltInFictitiousFunctionClassFactory = storageVersionPreference;
    }

    @Override // id.dana.domain.version.VersionRepository
    public Observable<Integer> getAppVersionCode() {
        return Observable.just(Integer.valueOf(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2.getInteger("version_code").intValue()));
    }

    @Override // id.dana.domain.version.VersionRepository
    public Observable<Boolean> setAppVersionCode(int i) {
        return Observable.just(Boolean.valueOf(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(i)));
    }

    @Override // id.dana.domain.version.VersionRepository
    public Observable<Integer> getStorageVersion() {
        return Observable.just(Integer.valueOf(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2.getInteger("storage_version").intValue()));
    }

    @Override // id.dana.domain.version.VersionRepository
    public Observable<Boolean> setStorageVersion(int i) {
        return Observable.just(Boolean.valueOf(this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(i)));
    }

    @Override // id.dana.domain.version.VersionRepository
    public Observable<Version> getAppVersion() {
        return this.MyBillsEntityDataFactory.createData2("split").getAppVersion();
    }
}
