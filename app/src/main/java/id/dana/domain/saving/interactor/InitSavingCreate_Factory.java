package id.dana.domain.saving.interactor;

import dagger.internal.Factory;
import id.dana.domain.saving.SavingCategoryRepository;
import id.dana.domain.saving.SavingRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class InitSavingCreate_Factory implements Factory<InitSavingCreate> {
    private final Provider<SavingCategoryRepository> savingCategoryRepositoryProvider;
    private final Provider<SavingRepository> savingRepositoryProvider;

    public InitSavingCreate_Factory(Provider<SavingRepository> provider, Provider<SavingCategoryRepository> provider2) {
        this.savingRepositoryProvider = provider;
        this.savingCategoryRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final InitSavingCreate get() {
        return newInstance(this.savingRepositoryProvider.get(), this.savingCategoryRepositoryProvider.get());
    }

    public static InitSavingCreate_Factory create(Provider<SavingRepository> provider, Provider<SavingCategoryRepository> provider2) {
        return new InitSavingCreate_Factory(provider, provider2);
    }

    public static InitSavingCreate newInstance(SavingRepository savingRepository, SavingCategoryRepository savingCategoryRepository) {
        return new InitSavingCreate(savingRepository, savingCategoryRepository);
    }
}
