package id.dana.riskChallenges.data.passkey.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.foundation.facede.ApSecurity;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class NetworkPasskeyEntityData_Factory implements Factory<NetworkPasskeyEntityData> {
    private final Provider<Context> contextProvider;
    private final Provider<RpcConnector> rpcConnectorProvider;
    private final Provider<ApSecurity> securityFacadeProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public NetworkPasskeyEntityData_Factory(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurity> provider3, Provider<Context> provider4) {
        this.rpcConnectorProvider = provider;
        this.threadExecutorProvider = provider2;
        this.securityFacadeProvider = provider3;
        this.contextProvider = provider4;
    }

    @Override // javax.inject.Provider
    public final NetworkPasskeyEntityData get() {
        return newInstance(this.rpcConnectorProvider.get(), this.threadExecutorProvider.get(), this.securityFacadeProvider.get(), this.contextProvider.get());
    }

    public static NetworkPasskeyEntityData_Factory create(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurity> provider3, Provider<Context> provider4) {
        return new NetworkPasskeyEntityData_Factory(provider, provider2, provider3, provider4);
    }

    public static NetworkPasskeyEntityData newInstance(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurity apSecurity, Context context) {
        return new NetworkPasskeyEntityData(rpcConnector, threadExecutor, apSecurity, context);
    }
}
