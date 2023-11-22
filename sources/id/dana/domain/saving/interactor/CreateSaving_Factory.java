package id.dana.domain.saving.interactor;

import dagger.internal.Factory;
import id.dana.domain.saving.SavingCategoryRepository;
import id.dana.domain.saving.SavingRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CreateSaving_Factory implements Factory<CreateSaving> {
    private final Provider<SavingCategoryRepository> savingCategoryRepositoryProvider;
    private final Provider<SavingRepository> savingRepositoryProvider;

    public CreateSaving_Factory(Provider<SavingRepository> provider, Provider<SavingCategoryRepository> provider2) {
        this.savingRepositoryProvider = provider;
        this.savingCategoryRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final CreateSaving get() {
        return newInstance(this.savingRepositoryProvider.get(), this.savingCategoryRepositoryProvider.get());
    }

    public static CreateSaving_Factory create(Provider<SavingRepository> provider, Provider<SavingCategoryRepository> provider2) {
        return new CreateSaving_Factory(provider, provider2);
    }

    public static CreateSaving newInstance(SavingRepository savingRepository, SavingCategoryRepository savingCategoryRepository) {
        return new CreateSaving(savingRepository, savingCategoryRepository);
    }
}
