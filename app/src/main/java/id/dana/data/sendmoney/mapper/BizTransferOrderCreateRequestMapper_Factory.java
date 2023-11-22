package id.dana.data.sendmoney.mapper;

import dagger.internal.Factory;
import id.dana.data.config.DeviceInformationProvider;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class BizTransferOrderCreateRequestMapper_Factory implements Factory<BizTransferOrderCreateRequestMapper> {
    private final Provider<DeviceInformationProvider> deviceInformationProvider;

    public BizTransferOrderCreateRequestMapper_Factory(Provider<DeviceInformationProvider> provider) {
        this.deviceInformationProvider = provider;
    }

    @Override // javax.inject.Provider
    public final BizTransferOrderCreateRequestMapper get() {
        return newInstance(this.deviceInformationProvider.get());
    }

    public static BizTransferOrderCreateRequestMapper_Factory create(Provider<DeviceInformationProvider> provider) {
        return new BizTransferOrderCreateRequestMapper_Factory(provider);
    }

    public static BizTransferOrderCreateRequestMapper newInstance(DeviceInformationProvider deviceInformationProvider) {
        return new BizTransferOrderCreateRequestMapper(deviceInformationProvider);
    }
}
