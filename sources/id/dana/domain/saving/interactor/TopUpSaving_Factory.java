package id.dana.domain.saving.interactor;

import dagger.internal.Factory;
import id.dana.domain.saving.SavingRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class TopUpSaving_Factory implements Factory<TopUpSaving> {
    private final Provider<SavingRepository> savingRepositoryProvider;

    public TopUpSaving_Factory(Provider<SavingRepository> provider) {
        this.savingRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final TopUpSaving get() {
        return newInstance(this.savingRepositoryProvider.get());
    }

    public static TopUpSaving_Factory create(Provider<SavingRepository> provider) {
        return new TopUpSaving_Factory(provider);
    }

    public static TopUpSaving newInstance(SavingRepository savingRepository) {
        return new TopUpSaving(savingRepository);
    }
}
