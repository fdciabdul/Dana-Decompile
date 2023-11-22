package id.dana.domain.saving.interactor;

import dagger.internal.Factory;
import id.dana.domain.saving.SavingRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetSavingEmptyState_Factory implements Factory<GetSavingEmptyState> {
    private final Provider<SavingRepository> savingRepositoryProvider;

    public GetSavingEmptyState_Factory(Provider<SavingRepository> provider) {
        this.savingRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetSavingEmptyState get() {
        return newInstance(this.savingRepositoryProvider.get());
    }

    public static GetSavingEmptyState_Factory create(Provider<SavingRepository> provider) {
        return new GetSavingEmptyState_Factory(provider);
    }

    public static GetSavingEmptyState newInstance(SavingRepository savingRepository) {
        return new GetSavingEmptyState(savingRepository);
    }
}
