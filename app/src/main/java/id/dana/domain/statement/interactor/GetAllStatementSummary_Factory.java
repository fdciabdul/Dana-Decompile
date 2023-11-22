package id.dana.domain.statement.interactor;

import dagger.internal.Factory;
import id.dana.domain.statement.UserStatementRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetAllStatementSummary_Factory implements Factory<GetAllStatementSummary> {
    private final Provider<UserStatementRepository> userStatementRepositoryProvider;

    public GetAllStatementSummary_Factory(Provider<UserStatementRepository> provider) {
        this.userStatementRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetAllStatementSummary get() {
        return newInstance(this.userStatementRepositoryProvider.get());
    }

    public static GetAllStatementSummary_Factory create(Provider<UserStatementRepository> provider) {
        return new GetAllStatementSummary_Factory(provider);
    }

    public static GetAllStatementSummary newInstance(UserStatementRepository userStatementRepository) {
        return new GetAllStatementSummary(userStatementRepository);
    }
}
