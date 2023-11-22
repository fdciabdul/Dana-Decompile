package id.dana.data.otp.repository.source;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.otp.repository.source.network.OtpApi;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class OtpEntityDataFactory_Factory implements Factory<OtpEntityDataFactory> {
    private final Provider<ApSecurityFacade> apSecurityFacadeProvider;
    private final Provider<Context> contextProvider;
    private final Provider<ThreadExecutor> executorProvider;
    private final Provider<OtpApi> otpApiProvider;
    private final Provider<RpcConnector> rpcConnectorProvider;

    public OtpEntityDataFactory_Factory(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<OtpApi> provider4, Provider<Context> provider5) {
        this.rpcConnectorProvider = provider;
        this.executorProvider = provider2;
        this.apSecurityFacadeProvider = provider3;
        this.otpApiProvider = provider4;
        this.contextProvider = provider5;
    }

    @Override // javax.inject.Provider
    public final OtpEntityDataFactory get() {
        return newInstance(this.rpcConnectorProvider.get(), this.executorProvider.get(), this.apSecurityFacadeProvider.get(), this.otpApiProvider.get(), this.contextProvider.get());
    }

    public static OtpEntityDataFactory_Factory create(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<OtpApi> provider4, Provider<Context> provider5) {
        return new OtpEntityDataFactory_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static OtpEntityDataFactory newInstance(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, OtpApi otpApi, Context context) {
        return new OtpEntityDataFactory(rpcConnector, threadExecutor, apSecurityFacade, otpApi, context);
    }
}
