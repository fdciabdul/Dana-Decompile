package id.dana.domain.saving.interactor;

import dagger.internal.Factory;
import id.dana.domain.saving.SavingCategoryRepository;
import id.dana.domain.saving.SavingRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class InitSavingUpdate_Factory implements Factory<InitSavingUpdate> {
    private final Provider<SavingCategoryRepository> savingCategoryRepositoryProvider;
    private final Provider<SavingRepository> savingRepositoryProvider;

    public InitSavingUpdate_Factory(Provider<SavingRepository> provider, Provider<SavingCategoryRepository> provider2) {
        this.savingRepositoryProvider = provider;
        this.savingCategoryRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final InitSavingUpdate get() {
        return newInstance(this.savingRepositoryProvider.get(), this.savingCategoryRepositoryProvider.get());
    }

    public static InitSavingUpdate_Factory create(Provider<SavingRepository> provider, Provider<SavingCategoryRepository> provider2) {
        return new InitSavingUpdate_Factory(provider, provider2);
    }

    public static InitSavingUpdate newInstance(SavingRepository savingRepository, SavingCategoryRepository savingCategoryRepository) {
        return new InitSavingUpdate(savingRepository, savingCategoryRepository);
    }
}
