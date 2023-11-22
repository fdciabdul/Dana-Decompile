package id.dana.domain.statement.interactor;

import dagger.internal.Factory;
import id.dana.domain.statement.UserStatementRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetTotalStatements_Factory implements Factory<GetTotalStatements> {
    private final Provider<UserStatementRepository> userStatementRepositoryProvider;

    public GetTotalStatements_Factory(Provider<UserStatementRepository> provider) {
        this.userStatementRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetTotalStatements get() {
        return newInstance(this.userStatementRepositoryProvider.get());
    }

    public static GetTotalStatements_Factory create(Provider<UserStatementRepository> provider) {
        return new GetTotalStatements_Factory(provider);
    }

    public static GetTotalStatements newInstance(UserStatementRepository userStatementRepository) {
        return new GetTotalStatements(userStatementRepository);
    }
}
