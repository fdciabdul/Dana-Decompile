package id.dana.domain.statement.interactor;

import dagger.internal.Factory;
import id.dana.domain.statement.UserStatementRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetAllStatementSummarySynchronously_Factory implements Factory<GetAllStatementSummarySynchronously> {
    private final Provider<UserStatementRepository> userStatementRepositoryProvider;

    public GetAllStatementSummarySynchronously_Factory(Provider<UserStatementRepository> provider) {
        this.userStatementRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetAllStatementSummarySynchronously get() {
        return newInstance(this.userStatementRepositoryProvider.get());
    }

    public static GetAllStatementSummarySynchronously_Factory create(Provider<UserStatementRepository> provider) {
        return new GetAllStatementSummarySynchronously_Factory(provider);
    }

    public static GetAllStatementSummarySynchronously newInstance(UserStatementRepository userStatementRepository) {
        return new GetAllStatementSummarySynchronously(userStatementRepository);
    }
}
