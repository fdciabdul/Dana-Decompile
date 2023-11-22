package id.dana.domain.saving.interactor;

import dagger.internal.Factory;
import id.dana.domain.saving.SavingRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class RevokeSaving_Factory implements Factory<RevokeSaving> {
    private final Provider<SavingRepository> savingRepositoryProvider;

    public RevokeSaving_Factory(Provider<SavingRepository> provider) {
        this.savingRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final RevokeSaving get() {
        return newInstance(this.savingRepositoryProvider.get());
    }

    public static RevokeSaving_Factory create(Provider<SavingRepository> provider) {
        return new RevokeSaving_Factory(provider);
    }

    public static RevokeSaving newInstance(SavingRepository savingRepository) {
        return new RevokeSaving(savingRepository);
    }
}
