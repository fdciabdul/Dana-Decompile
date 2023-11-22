package id.dana.domain.saving.interactor;

import dagger.internal.Factory;
import id.dana.domain.saving.SavingRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetWithdrawOption_Factory implements Factory<GetWithdrawOption> {
    private final Provider<SavingRepository> savingRepositoryProvider;

    public GetWithdrawOption_Factory(Provider<SavingRepository> provider) {
        this.savingRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetWithdrawOption get() {
        return newInstance(this.savingRepositoryProvider.get());
    }

    public static GetWithdrawOption_Factory create(Provider<SavingRepository> provider) {
        return new GetWithdrawOption_Factory(provider);
    }

    public static GetWithdrawOption newInstance(SavingRepository savingRepository) {
        return new GetWithdrawOption(savingRepository);
    }
}
