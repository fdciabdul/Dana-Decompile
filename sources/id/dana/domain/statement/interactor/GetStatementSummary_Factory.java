package id.dana.domain.statement.interactor;

import dagger.internal.Factory;
import id.dana.domain.statement.UserStatementRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetStatementSummary_Factory implements Factory<GetStatementSummary> {
    private final Provider<UserStatementRepository> userStatementRepositoryProvider;

    public GetStatementSummary_Factory(Provider<UserStatementRepository> provider) {
        this.userStatementRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetStatementSummary get() {
        return newInstance(this.userStatementRepositoryProvider.get());
    }

    public static GetStatementSummary_Factory create(Provider<UserStatementRepository> provider) {
        return new GetStatementSummary_Factory(provider);
    }

    public static GetStatementSummary newInstance(UserStatementRepository userStatementRepository) {
        return new GetStatementSummary(userStatementRepository);
    }
}
