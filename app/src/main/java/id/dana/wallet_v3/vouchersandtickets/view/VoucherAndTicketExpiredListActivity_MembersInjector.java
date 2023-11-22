package id.dana.wallet_v3.vouchersandtickets.view;

import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.wallet_v3.vouchersandtickets.presenter.VoucherAndTicketExpiredListContract;
import javax.inject.Provider;

/* loaded from: classes6.dex */
public final class VoucherAndTicketExpiredListActivity_MembersInjector implements MembersInjector<VoucherAndTicketExpiredListActivity> {
    private final Provider<AppLifeCycleObserver> appLifeCycleObserverProvider;
    private final Provider<ConnectionStatusReceiver> connectionStatusReceiverProvider;
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;
    private final Provider<VoucherAndTicketExpiredListContract.Presenter> voucherAndTicketExpiredListPresenterProvider;

    public VoucherAndTicketExpiredListActivity_MembersInjector(Provider<AppLifeCycleObserver> provider, Provider<ConnectionStatusReceiver> provider2, Provider<FeatureConfigRepository> provider3, Provider<VoucherAndTicketExpiredListContract.Presenter> provider4) {
        this.appLifeCycleObserverProvider = provider;
        this.connectionStatusReceiverProvider = provider2;
        this.featureConfigRepositoryProvider = provider3;
        this.voucherAndTicketExpiredListPresenterProvider = provider4;
    }

    public static MembersInjector<VoucherAndTicketExpiredListActivity> create(Provider<AppLifeCycleObserver> provider, Provider<ConnectionStatusReceiver> provider2, Provider<FeatureConfigRepository> provider3, Provider<VoucherAndTicketExpiredListContract.Presenter> provider4) {
        return new VoucherAndTicketExpiredListActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    public final void injectMembers(VoucherAndTicketExpiredListActivity voucherAndTicketExpiredListActivity) {
        ((BaseActivity) voucherAndTicketExpiredListActivity).appLifeCycleObserver = this.appLifeCycleObserverProvider.get();
        BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(voucherAndTicketExpiredListActivity, DoubleCheck.MyBillsEntityDataFactory(this.connectionStatusReceiverProvider));
        BaseActivity_MembersInjector.MyBillsEntityDataFactory(voucherAndTicketExpiredListActivity, DoubleCheck.MyBillsEntityDataFactory(this.featureConfigRepositoryProvider));
        injectVoucherAndTicketExpiredListPresenter(voucherAndTicketExpiredListActivity, this.voucherAndTicketExpiredListPresenterProvider.get());
    }

    public static void injectVoucherAndTicketExpiredListPresenter(VoucherAndTicketExpiredListActivity voucherAndTicketExpiredListActivity, VoucherAndTicketExpiredListContract.Presenter presenter) {
        voucherAndTicketExpiredListActivity.voucherAndTicketExpiredListPresenter = presenter;
    }
}
