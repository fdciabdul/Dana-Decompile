package id.dana.wallet_v3.vouchersandtickets.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.wallet_v3.vouchersandtickets.presenter.VoucherAndTicketExpiredListContract;
import id.dana.wallet_v3.vouchersandtickets.presenter.VoucherAndTicketExpiredListPresenter;
import javax.inject.Provider;

/* loaded from: classes6.dex */
public final class VoucherAndTicketExpiredListModule_ProvidePresenterFactory implements Factory<VoucherAndTicketExpiredListContract.Presenter> {
    private final VoucherAndTicketExpiredListModule module;
    private final Provider<VoucherAndTicketExpiredListPresenter> voucherAndTicketExpiredListPresenterProvider;

    public VoucherAndTicketExpiredListModule_ProvidePresenterFactory(VoucherAndTicketExpiredListModule voucherAndTicketExpiredListModule, Provider<VoucherAndTicketExpiredListPresenter> provider) {
        this.module = voucherAndTicketExpiredListModule;
        this.voucherAndTicketExpiredListPresenterProvider = provider;
    }

    @Override // javax.inject.Provider
    public final VoucherAndTicketExpiredListContract.Presenter get() {
        return providePresenter(this.module, this.voucherAndTicketExpiredListPresenterProvider.get());
    }

    public static VoucherAndTicketExpiredListModule_ProvidePresenterFactory create(VoucherAndTicketExpiredListModule voucherAndTicketExpiredListModule, Provider<VoucherAndTicketExpiredListPresenter> provider) {
        return new VoucherAndTicketExpiredListModule_ProvidePresenterFactory(voucherAndTicketExpiredListModule, provider);
    }

    public static VoucherAndTicketExpiredListContract.Presenter providePresenter(VoucherAndTicketExpiredListModule voucherAndTicketExpiredListModule, VoucherAndTicketExpiredListPresenter voucherAndTicketExpiredListPresenter) {
        return (VoucherAndTicketExpiredListContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(voucherAndTicketExpiredListModule.providePresenter(voucherAndTicketExpiredListPresenter));
    }
}
