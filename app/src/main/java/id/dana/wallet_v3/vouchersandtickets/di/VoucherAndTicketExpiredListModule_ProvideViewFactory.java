package id.dana.wallet_v3.vouchersandtickets.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.wallet_v3.vouchersandtickets.presenter.VoucherAndTicketExpiredListContract;

/* loaded from: classes6.dex */
public final class VoucherAndTicketExpiredListModule_ProvideViewFactory implements Factory<VoucherAndTicketExpiredListContract.View> {
    private final VoucherAndTicketExpiredListModule module;

    public VoucherAndTicketExpiredListModule_ProvideViewFactory(VoucherAndTicketExpiredListModule voucherAndTicketExpiredListModule) {
        this.module = voucherAndTicketExpiredListModule;
    }

    @Override // javax.inject.Provider
    public final VoucherAndTicketExpiredListContract.View get() {
        return provideView(this.module);
    }

    public static VoucherAndTicketExpiredListModule_ProvideViewFactory create(VoucherAndTicketExpiredListModule voucherAndTicketExpiredListModule) {
        return new VoucherAndTicketExpiredListModule_ProvideViewFactory(voucherAndTicketExpiredListModule);
    }

    public static VoucherAndTicketExpiredListContract.View provideView(VoucherAndTicketExpiredListModule voucherAndTicketExpiredListModule) {
        return (VoucherAndTicketExpiredListContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(voucherAndTicketExpiredListModule.getView());
    }
}
