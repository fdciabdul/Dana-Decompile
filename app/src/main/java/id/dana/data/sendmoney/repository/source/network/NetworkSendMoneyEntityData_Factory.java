package id.dana.data.sendmoney.repository.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.sendmoney.mapper.NameCheckParamMapper;
import id.dana.data.sendmoney.mapper.TransferSubmitRequestMapper;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkSendMoneyEntityData_Factory implements Factory<NetworkSendMoneyEntityData> {
    private final Provider<Context> contextProvider;
    private final Provider<ThreadExecutor> executorProvider;
    private final Provider<NameCheckParamMapper> nameCheckParamMapperProvider;
    private final Provider<NameCheckSecureApi> nameCheckSecureApiProvider;
    private final Provider<RpcConnector> rpcConnectorProvider;
    private final Provider<ApSecurityFacade> securityFacadeProvider;
    private final Provider<TransferSubmitRequestMapper> transferSubmitRequestMapperProvider;

    public NetworkSendMoneyEntityData_Factory(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4, Provider<NameCheckSecureApi> provider5, Provider<NameCheckParamMapper> provider6, Provider<TransferSubmitRequestMapper> provider7) {
        this.rpcConnectorProvider = provider;
        this.executorProvider = provider2;
        this.securityFacadeProvider = provider3;
        this.contextProvider = provider4;
        this.nameCheckSecureApiProvider = provider5;
        this.nameCheckParamMapperProvider = provider6;
        this.transferSubmitRequestMapperProvider = provider7;
    }

    @Override // javax.inject.Provider
    public final NetworkSendMoneyEntityData get() {
        return newInstance(this.rpcConnectorProvider.get(), this.executorProvider.get(), this.securityFacadeProvider.get(), this.contextProvider.get(), this.nameCheckSecureApiProvider.get(), this.nameCheckParamMapperProvider.get(), this.transferSubmitRequestMapperProvider.get());
    }

    public static NetworkSendMoneyEntityData_Factory create(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4, Provider<NameCheckSecureApi> provider5, Provider<NameCheckParamMapper> provider6, Provider<TransferSubmitRequestMapper> provider7) {
        return new NetworkSendMoneyEntityData_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static NetworkSendMoneyEntityData newInstance(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context, NameCheckSecureApi nameCheckSecureApi, NameCheckParamMapper nameCheckParamMapper, TransferSubmitRequestMapper transferSubmitRequestMapper) {
        return new NetworkSendMoneyEntityData(rpcConnector, threadExecutor, apSecurityFacade, context, nameCheckSecureApi, nameCheckParamMapper, transferSubmitRequestMapper);
    }
}
