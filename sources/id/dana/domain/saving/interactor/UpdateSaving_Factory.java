package id.dana.domain.saving.interactor;

import dagger.internal.Factory;
import id.dana.domain.saving.SavingCategoryRepository;
import id.dana.domain.saving.SavingRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class UpdateSaving_Factory implements Factory<UpdateSaving> {
    private final Provider<SavingCategoryRepository> savingCategoryRepositoryProvider;
    private final Provider<SavingRepository> savingRepositoryProvider;

    public UpdateSaving_Factory(Provider<SavingRepository> provider, Provider<SavingCategoryRepository> provider2) {
        this.savingRepositoryProvider = provider;
        this.savingCategoryRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final UpdateSaving get() {
        return newInstance(this.savingRepositoryProvider.get(), this.savingCategoryRepositoryProvider.get());
    }

    public static UpdateSaving_Factory create(Provider<SavingRepository> provider, Provider<SavingCategoryRepository> provider2) {
        return new UpdateSaving_Factory(provider, provider2);
    }

    public static UpdateSaving newInstance(SavingRepository savingRepository, SavingCategoryRepository savingCategoryRepository) {
        return new UpdateSaving(savingRepository, savingCategoryRepository);
    }
}
