package id.dana.cashier.data.repository.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.foundation.facade.ApSecurityFacade;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class NetworkCashierEntityData_Factory implements Factory<NetworkCashierEntityData> {
    private final Provider<ApSecurityFacade> apSecurityFacadeProvider;
    private final Provider<CashierSecureApi> cashierApiProvider;
    private final Provider<Context> contextProvider;
    private final Provider<DeviceInformationProvider> deviceInformationProvider;
    private final Provider<CashierSecureApi> securedCashierApiProvider;

    public NetworkCashierEntityData_Factory(Provider<Context> provider, Provider<ApSecurityFacade> provider2, Provider<DeviceInformationProvider> provider3, Provider<CashierSecureApi> provider4, Provider<CashierSecureApi> provider5) {
        this.contextProvider = provider;
        this.apSecurityFacadeProvider = provider2;
        this.deviceInformationProvider = provider3;
        this.cashierApiProvider = provider4;
        this.securedCashierApiProvider = provider5;
    }

    @Override // javax.inject.Provider
    public final NetworkCashierEntityData get() {
        return newInstance(this.contextProvider.get(), this.apSecurityFacadeProvider.get(), this.deviceInformationProvider.get(), this.cashierApiProvider.get(), this.securedCashierApiProvider.get());
    }

    public static NetworkCashierEntityData_Factory create(Provider<Context> provider, Provider<ApSecurityFacade> provider2, Provider<DeviceInformationProvider> provider3, Provider<CashierSecureApi> provider4, Provider<CashierSecureApi> provider5) {
        return new NetworkCashierEntityData_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static NetworkCashierEntityData newInstance(Context context, ApSecurityFacade apSecurityFacade, DeviceInformationProvider deviceInformationProvider, CashierSecureApi cashierSecureApi, CashierSecureApi cashierSecureApi2) {
        return new NetworkCashierEntityData(context, apSecurityFacade, deviceInformationProvider, cashierSecureApi, cashierSecureApi2);
    }
}
