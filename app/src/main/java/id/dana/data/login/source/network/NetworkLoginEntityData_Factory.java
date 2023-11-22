package id.dana.data.login.source.network;

import android.content.Context;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.foundation.logger.rds.RDSTracker;
import id.dana.data.login.source.HoldLoginEntityDataFactory;
import id.dana.data.storage.GeneralPreferencesDataFactory;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkLoginEntityData_Factory implements Factory<NetworkLoginEntityData> {
    private final Provider<Context> contextProvider;
    private final Provider<GeneralPreferencesDataFactory> generalPreferencesDataFactoryProvider;
    private final Provider<HoldLoginEntityDataFactory> holdLoginEntityDataFactoryProvider;
    private final Provider<RDSTracker> rdsTrackerProvider;
    private final Provider<RpcConnector> rpcConnectorProvider;
    private final Provider<ApSecurityFacade> securityFacadeProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public NetworkLoginEntityData_Factory(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4, Provider<RDSTracker> provider5, Provider<HoldLoginEntityDataFactory> provider6, Provider<GeneralPreferencesDataFactory> provider7) {
        this.rpcConnectorProvider = provider;
        this.threadExecutorProvider = provider2;
        this.securityFacadeProvider = provider3;
        this.contextProvider = provider4;
        this.rdsTrackerProvider = provider5;
        this.holdLoginEntityDataFactoryProvider = provider6;
        this.generalPreferencesDataFactoryProvider = provider7;
    }

    @Override // javax.inject.Provider
    public final NetworkLoginEntityData get() {
        return newInstance(this.rpcConnectorProvider.get(), this.threadExecutorProvider.get(), this.securityFacadeProvider.get(), this.contextProvider.get(), this.rdsTrackerProvider.get(), DoubleCheck.MyBillsEntityDataFactory(this.holdLoginEntityDataFactoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.generalPreferencesDataFactoryProvider));
    }

    public static NetworkLoginEntityData_Factory create(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4, Provider<RDSTracker> provider5, Provider<HoldLoginEntityDataFactory> provider6, Provider<GeneralPreferencesDataFactory> provider7) {
        return new NetworkLoginEntityData_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static NetworkLoginEntityData newInstance(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context, RDSTracker rDSTracker, Lazy<HoldLoginEntityDataFactory> lazy, Lazy<GeneralPreferencesDataFactory> lazy2) {
        return new NetworkLoginEntityData(rpcConnector, threadExecutor, apSecurityFacade, context, rDSTracker, lazy, lazy2);
    }
}
