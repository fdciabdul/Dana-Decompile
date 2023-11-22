package id.dana.domain.creditscore.interactor;

import dagger.internal.Factory;
import id.dana.domain.creditscore.CreditScoreRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class InsertInstalledAppsCreditScore_Factory implements Factory<InsertInstalledAppsCreditScore> {
    private final Provider<CreditScoreRepository> creditScoreRepositoryProvider;

    public InsertInstalledAppsCreditScore_Factory(Provider<CreditScoreRepository> provider) {
        this.creditScoreRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final InsertInstalledAppsCreditScore get() {
        return newInstance(this.creditScoreRepositoryProvider.get());
    }

    public static InsertInstalledAppsCreditScore_Factory create(Provider<CreditScoreRepository> provider) {
        return new InsertInstalledAppsCreditScore_Factory(provider);
    }

    public static InsertInstalledAppsCreditScore newInstance(CreditScoreRepository creditScoreRepository) {
        return new InsertInstalledAppsCreditScore(creditScoreRepository);
    }
}
