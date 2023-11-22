package id.dana.data.devicestats.di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.devicestats.DeviceStatsAnalyticsEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DeviceStatsModule_ProvideDeviceStatsAnalyticsFactory implements Factory<DeviceStatsAnalyticsEntityData> {
    private final Provider<Context> MyBillsEntityDataFactory;

    private DeviceStatsModule_ProvideDeviceStatsAnalyticsFactory(Provider<Context> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static DeviceStatsModule_ProvideDeviceStatsAnalyticsFactory MyBillsEntityDataFactory(Provider<Context> provider) {
        return new DeviceStatsModule_ProvideDeviceStatsAnalyticsFactory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (DeviceStatsAnalyticsEntityData) Preconditions.BuiltInFictitiousFunctionClassFactory(DeviceStatsModule.INSTANCE.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.get()));
    }
}
