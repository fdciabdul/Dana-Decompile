package id.dana.data.devicestats;

import dagger.internal.Factory;
import id.dana.data.devicestats.entity.FileSystemStorageEntity;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FileSystemStatsRepository_Factory implements Factory<FileSystemStatsRepository> {
    private final Provider<FileSystemStorageEntity> BuiltInFictitiousFunctionClassFactory;
    private final Provider<DeviceStatsAnalyticsEntityData> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<DeviceStatsConfigEntityData> MyBillsEntityDataFactory;
    private final Provider<DeviceStatsPreferenceEntityData> PlaceComponentResult;
    private final Provider<FileDirectoriesSizeMapper> getAuthRequestContext;

    private FileSystemStatsRepository_Factory(Provider<FileSystemStorageEntity> provider, Provider<DeviceStatsConfigEntityData> provider2, Provider<DeviceStatsPreferenceEntityData> provider3, Provider<DeviceStatsAnalyticsEntityData> provider4, Provider<FileDirectoriesSizeMapper> provider5) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.PlaceComponentResult = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
        this.getAuthRequestContext = provider5;
    }

    public static FileSystemStatsRepository_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<FileSystemStorageEntity> provider, Provider<DeviceStatsConfigEntityData> provider2, Provider<DeviceStatsPreferenceEntityData> provider3, Provider<DeviceStatsAnalyticsEntityData> provider4, Provider<FileDirectoriesSizeMapper> provider5) {
        return new FileSystemStatsRepository_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FileSystemStatsRepository(this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get());
    }
}
