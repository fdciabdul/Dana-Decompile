package id.dana.domain.wallet_v3.interactor;

import dagger.internal.Factory;
import id.dana.domain.wallet_v3.repository.WalletV3Repository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetVoucherAndTicketOrder_Factory implements Factory<GetVoucherAndTicketOrder> {
    private final Provider<WalletV3Repository> repositoryProvider;

    public GetVoucherAndTicketOrder_Factory(Provider<WalletV3Repository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetVoucherAndTicketOrder get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static GetVoucherAndTicketOrder_Factory create(Provider<WalletV3Repository> provider) {
        return new GetVoucherAndTicketOrder_Factory(provider);
    }

    public static GetVoucherAndTicketOrder newInstance(WalletV3Repository walletV3Repository) {
        return new GetVoucherAndTicketOrder(walletV3Repository);
    }
}
