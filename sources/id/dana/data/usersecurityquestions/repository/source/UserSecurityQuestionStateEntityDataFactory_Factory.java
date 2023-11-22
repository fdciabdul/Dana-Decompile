package id.dana.data.usersecurityquestions.repository.source;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.foundation.facade.SecurityGuardFacade;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class UserSecurityQuestionStateEntityDataFactory_Factory implements Factory<UserSecurityQuestionStateEntityDataFactory> {
    private final Provider<ApSecurityFacade> apSecurityFacadeProvider;
    private final Provider<Context> contextProvider;
    private final Provider<RpcConnector> rpcConnectorProvider;
    private final Provider<SecurityGuardFacade> securityGuardFacadeProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public UserSecurityQuestionStateEntityDataFactory_Factory(Provider<Context> provider, Provider<RpcConnector> provider2, Provider<ThreadExecutor> provider3, Provider<ApSecurityFacade> provider4, Provider<SecurityGuardFacade> provider5) {
        this.contextProvider = provider;
        this.rpcConnectorProvider = provider2;
        this.threadExecutorProvider = provider3;
        this.apSecurityFacadeProvider = provider4;
        this.securityGuardFacadeProvider = provider5;
    }

    @Override // javax.inject.Provider
    public final UserSecurityQuestionStateEntityDataFactory get() {
        return newInstance(this.contextProvider.get(), this.rpcConnectorProvider.get(), this.threadExecutorProvider.get(), this.apSecurityFacadeProvider.get(), this.securityGuardFacadeProvider.get());
    }

    public static UserSecurityQuestionStateEntityDataFactory_Factory create(Provider<Context> provider, Provider<RpcConnector> provider2, Provider<ThreadExecutor> provider3, Provider<ApSecurityFacade> provider4, Provider<SecurityGuardFacade> provider5) {
        return new UserSecurityQuestionStateEntityDataFactory_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static UserSecurityQuestionStateEntityDataFactory newInstance(Context context, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, SecurityGuardFacade securityGuardFacade) {
        return new UserSecurityQuestionStateEntityDataFactory(context, rpcConnector, threadExecutor, apSecurityFacade, securityGuardFacade);
    }
}
