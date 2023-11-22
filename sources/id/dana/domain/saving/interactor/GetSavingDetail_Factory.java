package id.dana.domain.saving.interactor;

import dagger.internal.Factory;
import id.dana.domain.saving.SavingCategoryRepository;
import id.dana.domain.saving.SavingRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetSavingDetail_Factory implements Factory<GetSavingDetail> {
    private final Provider<SavingCategoryRepository> savingCategoryRepositoryProvider;
    private final Provider<SavingRepository> savingRepositoryProvider;

    public GetSavingDetail_Factory(Provider<SavingRepository> provider, Provider<SavingCategoryRepository> provider2) {
        this.savingRepositoryProvider = provider;
        this.savingCategoryRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final GetSavingDetail get() {
        return newInstance(this.savingRepositoryProvider.get(), this.savingCategoryRepositoryProvider.get());
    }

    public static GetSavingDetail_Factory create(Provider<SavingRepository> provider, Provider<SavingCategoryRepository> provider2) {
        return new GetSavingDetail_Factory(provider, provider2);
    }

    public static GetSavingDetail newInstance(SavingRepository savingRepository, SavingCategoryRepository savingCategoryRepository) {
        return new GetSavingDetail(savingRepository, savingCategoryRepository);
    }
}
