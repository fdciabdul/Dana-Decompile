package id.dana.wallet_v3.vouchersandtickets.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.wallet_v3.vouchersandtickets.presenter.VouchersAndTicketsDetailContract;
import id.dana.wallet_v3.vouchersandtickets.presenter.VouchersAndTicketsDetailPresenter;
import javax.inject.Provider;

/* loaded from: classes6.dex */
public final class VouchersAndTicketsDetailModule_ProvidePresenterFactory implements Factory<VouchersAndTicketsDetailContract.Presenter> {
    private final VouchersAndTicketsDetailModule module;
    private final Provider<VouchersAndTicketsDetailPresenter> vouchersAndTicketsDetailPresenterProvider;

    public VouchersAndTicketsDetailModule_ProvidePresenterFactory(VouchersAndTicketsDetailModule vouchersAndTicketsDetailModule, Provider<VouchersAndTicketsDetailPresenter> provider) {
        this.module = vouchersAndTicketsDetailModule;
        this.vouchersAndTicketsDetailPresenterProvider = provider;
    }

    @Override // javax.inject.Provider
    public final VouchersAndTicketsDetailContract.Presenter get() {
        return providePresenter(this.module, this.vouchersAndTicketsDetailPresenterProvider.get());
    }

    public static VouchersAndTicketsDetailModule_ProvidePresenterFactory create(VouchersAndTicketsDetailModule vouchersAndTicketsDetailModule, Provider<VouchersAndTicketsDetailPresenter> provider) {
        return new VouchersAndTicketsDetailModule_ProvidePresenterFactory(vouchersAndTicketsDetailModule, provider);
    }

    public static VouchersAndTicketsDetailContract.Presenter providePresenter(VouchersAndTicketsDetailModule vouchersAndTicketsDetailModule, VouchersAndTicketsDetailPresenter vouchersAndTicketsDetailPresenter) {
        return (VouchersAndTicketsDetailContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(vouchersAndTicketsDetailModule.providePresenter(vouchersAndTicketsDetailPresenter));
    }
}
