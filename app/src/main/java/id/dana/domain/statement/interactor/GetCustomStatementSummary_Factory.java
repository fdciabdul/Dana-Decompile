package id.dana.domain.statement.interactor;

import dagger.internal.Factory;
import id.dana.domain.statement.UserStatementRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetCustomStatementSummary_Factory implements Factory<GetCustomStatementSummary> {
    private final Provider<UserStatementRepository> userStatementRepositoryProvider;

    public GetCustomStatementSummary_Factory(Provider<UserStatementRepository> provider) {
        this.userStatementRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetCustomStatementSummary get() {
        return newInstance(this.userStatementRepositoryProvider.get());
    }

    public static GetCustomStatementSummary_Factory create(Provider<UserStatementRepository> provider) {
        return new GetCustomStatementSummary_Factory(provider);
    }

    public static GetCustomStatementSummary newInstance(UserStatementRepository userStatementRepository) {
        return new GetCustomStatementSummary(userStatementRepository);
    }
}
