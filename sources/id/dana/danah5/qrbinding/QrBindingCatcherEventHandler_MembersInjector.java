package id.dana.danah5.qrbinding;

import dagger.MembersInjector;
import id.dana.domain.oauth.interactor.GetQrBindingConfig;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class QrBindingCatcherEventHandler_MembersInjector implements MembersInjector<QrBindingCatcherEventHandler> {
    private final Provider<GetQrBindingConfig> getQrBindingConfigProvider;

    public QrBindingCatcherEventHandler_MembersInjector(Provider<GetQrBindingConfig> provider) {
        this.getQrBindingConfigProvider = provider;
    }

    public static MembersInjector<QrBindingCatcherEventHandler> create(Provider<GetQrBindingConfig> provider) {
        return new QrBindingCatcherEventHandler_MembersInjector(provider);
    }

    public final void injectMembers(QrBindingCatcherEventHandler qrBindingCatcherEventHandler) {
        injectGetQrBindingConfig(qrBindingCatcherEventHandler, this.getQrBindingConfigProvider.get());
    }

    public static void injectGetQrBindingConfig(QrBindingCatcherEventHandler qrBindingCatcherEventHandler, GetQrBindingConfig getQrBindingConfig) {
        qrBindingCatcherEventHandler.getQrBindingConfig = getQrBindingConfig;
    }
}
