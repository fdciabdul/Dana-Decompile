package id.dana.data.recentrecipient.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.recentrecipient.mapper.BankCardConversionMapper;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkBankCardConversionEntityData_Factory implements Factory<NetworkBankCardConversionEntityData> {
    private final Provider<ApSecurityFacade> apSecurityFacadeProvider;
    private final Provider<Context> appContextProvider;
    private final Provider<BankCardConversionMapper> bankCardConversionMapperProvider;
    private final Provider<ConvertCardIndexNoSecureApi> convertCardIndexNoSecureApiProvider;
    private final Provider<RpcConnector> rpcConnectorProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public NetworkBankCardConversionEntityData_Factory(Provider<Context> provider, Provider<RpcConnector> provider2, Provider<ThreadExecutor> provider3, Provider<ApSecurityFacade> provider4, Provider<BankCardConversionMapper> provider5, Provider<ConvertCardIndexNoSecureApi> provider6) {
        this.appContextProvider = provider;
        this.rpcConnectorProvider = provider2;
        this.threadExecutorProvider = provider3;
        this.apSecurityFacadeProvider = provider4;
        this.bankCardConversionMapperProvider = provider5;
        this.convertCardIndexNoSecureApiProvider = provider6;
    }

    @Override // javax.inject.Provider
    public final NetworkBankCardConversionEntityData get() {
        return newInstance(this.appContextProvider.get(), this.rpcConnectorProvider.get(), this.threadExecutorProvider.get(), this.apSecurityFacadeProvider.get(), this.bankCardConversionMapperProvider.get(), this.convertCardIndexNoSecureApiProvider.get());
    }

    public static NetworkBankCardConversionEntityData_Factory create(Provider<Context> provider, Provider<RpcConnector> provider2, Provider<ThreadExecutor> provider3, Provider<ApSecurityFacade> provider4, Provider<BankCardConversionMapper> provider5, Provider<ConvertCardIndexNoSecureApi> provider6) {
        return new NetworkBankCardConversionEntityData_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static NetworkBankCardConversionEntityData newInstance(Context context, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, BankCardConversionMapper bankCardConversionMapper, ConvertCardIndexNoSecureApi convertCardIndexNoSecureApi) {
        return new NetworkBankCardConversionEntityData(context, rpcConnector, threadExecutor, apSecurityFacade, bankCardConversionMapper, convertCardIndexNoSecureApi);
    }
}
