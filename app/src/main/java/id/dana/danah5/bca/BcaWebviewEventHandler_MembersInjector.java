package id.dana.danah5.bca;

import dagger.MembersInjector;
import id.dana.domain.webviewinterceptor.interactor.GetListWebviewInterceptorDataConfig;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class BcaWebviewEventHandler_MembersInjector implements MembersInjector<BcaWebviewEventHandler> {
    private final Provider<GetListWebviewInterceptorDataConfig> getListWebviewInterceptorDataConfigProvider;

    public BcaWebviewEventHandler_MembersInjector(Provider<GetListWebviewInterceptorDataConfig> provider) {
        this.getListWebviewInterceptorDataConfigProvider = provider;
    }

    public static MembersInjector<BcaWebviewEventHandler> create(Provider<GetListWebviewInterceptorDataConfig> provider) {
        return new BcaWebviewEventHandler_MembersInjector(provider);
    }

    public final void injectMembers(BcaWebviewEventHandler bcaWebviewEventHandler) {
        injectGetListWebviewInterceptorDataConfig(bcaWebviewEventHandler, this.getListWebviewInterceptorDataConfigProvider.get());
    }

    public static void injectGetListWebviewInterceptorDataConfig(BcaWebviewEventHandler bcaWebviewEventHandler, GetListWebviewInterceptorDataConfig getListWebviewInterceptorDataConfig) {
        bcaWebviewEventHandler.getListWebviewInterceptorDataConfig = getListWebviewInterceptorDataConfig;
    }
}
