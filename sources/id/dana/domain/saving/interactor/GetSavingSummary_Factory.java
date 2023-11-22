package id.dana.domain.saving.interactor;

import dagger.internal.Factory;
import id.dana.domain.saving.SavingCategoryRepository;
import id.dana.domain.saving.SavingRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetSavingSummary_Factory implements Factory<GetSavingSummary> {
    private final Provider<SavingCategoryRepository> savingCategoryRepositoryProvider;
    private final Provider<SavingRepository> savingRepositoryProvider;

    public GetSavingSummary_Factory(Provider<SavingRepository> provider, Provider<SavingCategoryRepository> provider2) {
        this.savingRepositoryProvider = provider;
        this.savingCategoryRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final GetSavingSummary get() {
        return newInstance(this.savingRepositoryProvider.get(), this.savingCategoryRepositoryProvider.get());
    }

    public static GetSavingSummary_Factory create(Provider<SavingRepository> provider, Provider<SavingCategoryRepository> provider2) {
        return new GetSavingSummary_Factory(provider, provider2);
    }

    public static GetSavingSummary newInstance(SavingRepository savingRepository, SavingCategoryRepository savingCategoryRepository) {
        return new GetSavingSummary(savingRepository, savingCategoryRepository);
    }
}
