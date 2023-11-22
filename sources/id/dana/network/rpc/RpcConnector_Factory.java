package id.dana.network.rpc;

import android.content.Context;
import com.google.gson.Gson;
import dagger.internal.Factory;
import id.dana.utils.config.DeviceInformation;
import id.dana.utils.config.entity.NetworkLoggingConfiguration;
import id.dana.utils.foundation.facede.ApSecurity;
import id.dana.utils.holdlogin.v2.HoldLoginConfig;
import id.dana.utils.holdlogin.v2.interceptor.HoldLoginV2Interceptor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class RpcConnector_Factory implements Factory<RpcConnector> {
    private final Provider<ApSecurity> apSecurityProvider;
    private final Provider<Context> contextProvider;
    private final Provider<DeviceInformation> deviceInformationProvider;
    private final Provider<Gson> gsonProvider;
    private final Provider<HoldLoginConfig> holdLoginConfigProvider;
    private final Provider<HoldLoginV2Interceptor> holdLoginV2InterceptorProvider;
    private final Provider<NetworkLoggingConfiguration> networkLoggingConfigurationProvider;

    public RpcConnector_Factory(Provider<Context> provider, Provider<ApSecurity> provider2, Provider<DeviceInformation> provider3, Provider<Gson> provider4, Provider<HoldLoginV2Interceptor> provider5, Provider<HoldLoginConfig> provider6, Provider<NetworkLoggingConfiguration> provider7) {
        this.contextProvider = provider;
        this.apSecurityProvider = provider2;
        this.deviceInformationProvider = provider3;
        this.gsonProvider = provider4;
        this.holdLoginV2InterceptorProvider = provider5;
        this.holdLoginConfigProvider = provider6;
        this.networkLoggingConfigurationProvider = provider7;
    }

    @Override // javax.inject.Provider
    public final RpcConnector get() {
        RpcConnector newInstance = newInstance(this.contextProvider.get(), this.apSecurityProvider.get(), this.deviceInformationProvider.get(), this.gsonProvider.get(), this.holdLoginV2InterceptorProvider.get(), this.holdLoginConfigProvider.get());
        RpcConnector_MembersInjector.injectNetworkLoggingConfiguration(newInstance, this.networkLoggingConfigurationProvider.get());
        return newInstance;
    }

    public static RpcConnector_Factory create(Provider<Context> provider, Provider<ApSecurity> provider2, Provider<DeviceInformation> provider3, Provider<Gson> provider4, Provider<HoldLoginV2Interceptor> provider5, Provider<HoldLoginConfig> provider6, Provider<NetworkLoggingConfiguration> provider7) {
        return new RpcConnector_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static RpcConnector newInstance(Context context, ApSecurity apSecurity, DeviceInformation deviceInformation, Gson gson, HoldLoginV2Interceptor holdLoginV2Interceptor, HoldLoginConfig holdLoginConfig) {
        return new RpcConnector(context, apSecurity, deviceInformation, gson, holdLoginV2Interceptor, holdLoginConfig);
    }
}
