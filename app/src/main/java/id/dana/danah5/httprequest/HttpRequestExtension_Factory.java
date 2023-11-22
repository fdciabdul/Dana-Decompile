package id.dana.danah5.httprequest;

import dagger.internal.Factory;
import id.dana.data.network.RpcProxy;
import id.dana.data.toggle.SplitFacade;
import id.dana.utils.holdlogin.v2.HoldLoginConfig;
import id.dana.utils.holdlogin.v2.interceptor.HoldLoginV2Interceptor;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class HttpRequestExtension_Factory implements Factory<HttpRequestExtension> {
    private final Provider<HoldLoginConfig> holdLoginConfigProvider;
    private final Provider<HoldLoginV2Interceptor> holdLoginV2InterceptorProvider;
    private final Provider<RpcProxy> rpcProxyProvider;
    private final Provider<SplitFacade> splitFacadeProvider;

    public HttpRequestExtension_Factory(Provider<RpcProxy> provider, Provider<SplitFacade> provider2, Provider<HoldLoginConfig> provider3, Provider<HoldLoginV2Interceptor> provider4) {
        this.rpcProxyProvider = provider;
        this.splitFacadeProvider = provider2;
        this.holdLoginConfigProvider = provider3;
        this.holdLoginV2InterceptorProvider = provider4;
    }

    @Override // javax.inject.Provider
    public final HttpRequestExtension get() {
        return newInstance(this.rpcProxyProvider.get(), this.splitFacadeProvider.get(), this.holdLoginConfigProvider.get(), this.holdLoginV2InterceptorProvider.get());
    }

    public static HttpRequestExtension_Factory create(Provider<RpcProxy> provider, Provider<SplitFacade> provider2, Provider<HoldLoginConfig> provider3, Provider<HoldLoginV2Interceptor> provider4) {
        return new HttpRequestExtension_Factory(provider, provider2, provider3, provider4);
    }

    public static HttpRequestExtension newInstance(RpcProxy rpcProxy, SplitFacade splitFacade, HoldLoginConfig holdLoginConfig, HoldLoginV2Interceptor holdLoginV2Interceptor) {
        return new HttpRequestExtension(rpcProxy, splitFacade, holdLoginConfig, holdLoginV2Interceptor);
    }
}
