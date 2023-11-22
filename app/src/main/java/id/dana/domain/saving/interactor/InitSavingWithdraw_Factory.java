package id.dana.domain.saving.interactor;

import dagger.internal.Factory;
import id.dana.domain.saving.SavingRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class InitSavingWithdraw_Factory implements Factory<InitSavingWithdraw> {
    private final Provider<SavingRepository> savingRepositoryProvider;

    public InitSavingWithdraw_Factory(Provider<SavingRepository> provider) {
        this.savingRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final InitSavingWithdraw get() {
        return newInstance(this.savingRepositoryProvider.get());
    }

    public static InitSavingWithdraw_Factory create(Provider<SavingRepository> provider) {
        return new InitSavingWithdraw_Factory(provider);
    }

    public static InitSavingWithdraw newInstance(SavingRepository savingRepository) {
        return new InitSavingWithdraw(savingRepository);
    }
}
