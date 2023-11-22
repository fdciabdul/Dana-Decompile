package id.dana.domain.statement.interactor;

import dagger.internal.Factory;
import id.dana.domain.statement.UserStatementRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetStatementDetail_Factory implements Factory<GetStatementDetail> {
    private final Provider<UserStatementRepository> userStatementRepositoryProvider;

    public GetStatementDetail_Factory(Provider<UserStatementRepository> provider) {
        this.userStatementRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetStatementDetail get() {
        return newInstance(this.userStatementRepositoryProvider.get());
    }

    public static GetStatementDetail_Factory create(Provider<UserStatementRepository> provider) {
        return new GetStatementDetail_Factory(provider);
    }

    public static GetStatementDetail newInstance(UserStatementRepository userStatementRepository) {
        return new GetStatementDetail(userStatementRepository);
    }
}
