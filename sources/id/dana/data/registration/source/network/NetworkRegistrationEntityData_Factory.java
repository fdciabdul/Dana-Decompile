package id.dana.data.registration.source.network;

import android.content.Context;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.foundation.logger.rds.RDSTracker;
import id.dana.data.storage.GeneralPreferencesDataFactory;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkRegistrationEntityData_Factory implements Factory<NetworkRegistrationEntityData> {
    private final Provider<Context> contextProvider;
    private final Provider<GeneralPreferencesDataFactory> generalPreferencesDataFactoryProvider;
    private final Provider<RDSTracker> rdsTrackerProvider;
    private final Provider<RpcConnector> rpcConnectorProvider;
    private final Provider<ApSecurityFacade> securityFacadeProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public NetworkRegistrationEntityData_Factory(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4, Provider<RDSTracker> provider5, Provider<GeneralPreferencesDataFactory> provider6) {
        this.rpcConnectorProvider = provider;
        this.threadExecutorProvider = provider2;
        this.securityFacadeProvider = provider3;
        this.contextProvider = provider4;
        this.rdsTrackerProvider = provider5;
        this.generalPreferencesDataFactoryProvider = provider6;
    }

    @Override // javax.inject.Provider
    public final NetworkRegistrationEntityData get() {
        return newInstance(this.rpcConnectorProvider.get(), this.threadExecutorProvider.get(), this.securityFacadeProvider.get(), this.contextProvider.get(), this.rdsTrackerProvider.get(), DoubleCheck.MyBillsEntityDataFactory(this.generalPreferencesDataFactoryProvider));
    }

    public static NetworkRegistrationEntityData_Factory create(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4, Provider<RDSTracker> provider5, Provider<GeneralPreferencesDataFactory> provider6) {
        return new NetworkRegistrationEntityData_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static NetworkRegistrationEntityData newInstance(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context, RDSTracker rDSTracker, Lazy<GeneralPreferencesDataFactory> lazy) {
        return new NetworkRegistrationEntityData(rpcConnector, threadExecutor, apSecurityFacade, context, rDSTracker, lazy);
    }
}
