package id.dana.wallet_v3.identity.view;

import dagger.Lazy;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.wallet_v3.presenter.KtpDetailContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class KtpDetailActivity_MembersInjector implements MembersInjector<KtpDetailActivity> {
    private final Provider<AppLifeCycleObserver> appLifeCycleObserverProvider;
    private final Provider<ConnectionStatusReceiver> connectionStatusReceiverProvider;
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;
    private final Provider<KtpDetailContract.Presenter> ktpDetailPresenterProvider;

    public KtpDetailActivity_MembersInjector(Provider<AppLifeCycleObserver> provider, Provider<ConnectionStatusReceiver> provider2, Provider<FeatureConfigRepository> provider3, Provider<KtpDetailContract.Presenter> provider4) {
        this.appLifeCycleObserverProvider = provider;
        this.connectionStatusReceiverProvider = provider2;
        this.featureConfigRepositoryProvider = provider3;
        this.ktpDetailPresenterProvider = provider4;
    }

    public static MembersInjector<KtpDetailActivity> create(Provider<AppLifeCycleObserver> provider, Provider<ConnectionStatusReceiver> provider2, Provider<FeatureConfigRepository> provider3, Provider<KtpDetailContract.Presenter> provider4) {
        return new KtpDetailActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    public final void injectMembers(KtpDetailActivity ktpDetailActivity) {
        ((BaseActivity) ktpDetailActivity).appLifeCycleObserver = this.appLifeCycleObserverProvider.get();
        BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(ktpDetailActivity, DoubleCheck.MyBillsEntityDataFactory(this.connectionStatusReceiverProvider));
        BaseActivity_MembersInjector.MyBillsEntityDataFactory(ktpDetailActivity, DoubleCheck.MyBillsEntityDataFactory(this.featureConfigRepositoryProvider));
        injectKtpDetailPresenter(ktpDetailActivity, DoubleCheck.MyBillsEntityDataFactory(this.ktpDetailPresenterProvider));
    }

    public static void injectKtpDetailPresenter(KtpDetailActivity ktpDetailActivity, Lazy<KtpDetailContract.Presenter> lazy) {
        ktpDetailActivity.ktpDetailPresenter = lazy;
    }
}
