package id.dana.domain.wallet_v3.interactor;

import dagger.internal.Factory;
import id.dana.domain.wallet_v3.repository.WalletV3Repository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveVoucherAndTicketOrder_Factory implements Factory<SaveVoucherAndTicketOrder> {
    private final Provider<WalletV3Repository> repositoryProvider;

    public SaveVoucherAndTicketOrder_Factory(Provider<WalletV3Repository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveVoucherAndTicketOrder get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static SaveVoucherAndTicketOrder_Factory create(Provider<WalletV3Repository> provider) {
        return new SaveVoucherAndTicketOrder_Factory(provider);
    }

    public static SaveVoucherAndTicketOrder newInstance(WalletV3Repository walletV3Repository) {
        return new SaveVoucherAndTicketOrder(walletV3Repository);
    }
}
