package id.dana.data.referral.repository.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkMyReferralConsultEntityData_Factory implements Factory<NetworkMyReferralConsultEntityData> {
    private final Provider<Context> contextProvider;
    private final Provider<ThreadExecutor> executorProvider;
    private final Provider<RpcConnector> rpcConnectorProvider;
    private final Provider<ApSecurityFacade> securityFacadeProvider;

    public NetworkMyReferralConsultEntityData_Factory(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4) {
        this.rpcConnectorProvider = provider;
        this.executorProvider = provider2;
        this.securityFacadeProvider = provider3;
        this.contextProvider = provider4;
    }

    @Override // javax.inject.Provider
    public final NetworkMyReferralConsultEntityData get() {
        return newInstance(this.rpcConnectorProvider.get(), this.executorProvider.get(), this.securityFacadeProvider.get(), this.contextProvider.get());
    }

    public static NetworkMyReferralConsultEntityData_Factory create(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4) {
        return new NetworkMyReferralConsultEntityData_Factory(provider, provider2, provider3, provider4);
    }

    public static NetworkMyReferralConsultEntityData newInstance(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        return new NetworkMyReferralConsultEntityData(rpcConnector, threadExecutor, apSecurityFacade, context);
    }
}
