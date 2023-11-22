package id.dana.data.saving.repository;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SavingCategoryEntityRepository_Factory implements Factory<SavingCategoryEntityRepository> {
    private final Provider<SavingCategoryEntityDataFactory> savingCategoryEntityDataFactoryProvider;

    public SavingCategoryEntityRepository_Factory(Provider<SavingCategoryEntityDataFactory> provider) {
        this.savingCategoryEntityDataFactoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SavingCategoryEntityRepository get() {
        return newInstance(this.savingCategoryEntityDataFactoryProvider.get());
    }

    public static SavingCategoryEntityRepository_Factory create(Provider<SavingCategoryEntityDataFactory> provider) {
        return new SavingCategoryEntityRepository_Factory(provider);
    }

    public static SavingCategoryEntityRepository newInstance(SavingCategoryEntityDataFactory savingCategoryEntityDataFactory) {
        return new SavingCategoryEntityRepository(savingCategoryEntityDataFactory);
    }
}
