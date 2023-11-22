package id.dana.domain.saving.interactor;

import dagger.internal.Factory;
import id.dana.domain.saving.SavingRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class InitSavingTopUp_Factory implements Factory<InitSavingTopUp> {
    private final Provider<SavingRepository> savingRepositoryProvider;

    public InitSavingTopUp_Factory(Provider<SavingRepository> provider) {
        this.savingRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final InitSavingTopUp get() {
        return newInstance(this.savingRepositoryProvider.get());
    }

    public static InitSavingTopUp_Factory create(Provider<SavingRepository> provider) {
        return new InitSavingTopUp_Factory(provider);
    }

    public static InitSavingTopUp newInstance(SavingRepository savingRepository) {
        return new InitSavingTopUp(savingRepository);
    }
}
