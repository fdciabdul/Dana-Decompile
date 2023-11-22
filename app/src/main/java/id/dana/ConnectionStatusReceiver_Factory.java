package id.dana;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ConnectionStatusReceiver_Factory implements Factory<ConnectionStatusReceiver> {
    private final Provider<ThreadExecutor> MyBillsEntityDataFactory;
    private final Provider<SSLPinningRepository> PlaceComponentResult;
    private final Provider<IsOfflineF2FPay> getAuthRequestContext;

    private ConnectionStatusReceiver_Factory(Provider<ThreadExecutor> provider, Provider<SSLPinningRepository> provider2, Provider<IsOfflineF2FPay> provider3) {
        this.MyBillsEntityDataFactory = provider;
        this.PlaceComponentResult = provider2;
        this.getAuthRequestContext = provider3;
    }

    public static ConnectionStatusReceiver_Factory PlaceComponentResult(Provider<ThreadExecutor> provider, Provider<SSLPinningRepository> provider2, Provider<IsOfflineF2FPay> provider3) {
        return new ConnectionStatusReceiver_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ConnectionStatusReceiver(this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get(), this.getAuthRequestContext.get());
    }
}
