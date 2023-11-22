package id.dana.data.devicestats.di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.devicestats.DeviceStatsPreferenceEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DeviceStatsModule_ProvideDeviceStatsPreferenceFactory implements Factory<DeviceStatsPreferenceEntityData> {
    private final Provider<Context> PlaceComponentResult;

    private DeviceStatsModule_ProvideDeviceStatsPreferenceFactory(Provider<Context> provider) {
        this.PlaceComponentResult = provider;
    }

    public static DeviceStatsModule_ProvideDeviceStatsPreferenceFactory KClassImpl$Data$declaredNonStaticMembers$2(Provider<Context> provider) {
        return new DeviceStatsModule_ProvideDeviceStatsPreferenceFactory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (DeviceStatsPreferenceEntityData) Preconditions.BuiltInFictitiousFunctionClassFactory(DeviceStatsModule.INSTANCE.PlaceComponentResult(this.PlaceComponentResult.get()));
    }
}
