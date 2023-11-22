package id.dana.data.devicestats.entity;

import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitDeviceStatsConfigEntityData_Factory implements Factory<SplitDeviceStatsConfigEntityData> {
    private final Provider<SplitFacade> PlaceComponentResult;

    private SplitDeviceStatsConfigEntityData_Factory(Provider<SplitFacade> provider) {
        this.PlaceComponentResult = provider;
    }

    public static SplitDeviceStatsConfigEntityData_Factory MyBillsEntityDataFactory(Provider<SplitFacade> provider) {
        return new SplitDeviceStatsConfigEntityData_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SplitDeviceStatsConfigEntityData(this.PlaceComponentResult.get());
    }
}
