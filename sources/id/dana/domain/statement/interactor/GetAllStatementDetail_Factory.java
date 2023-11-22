package id.dana.domain.statement.interactor;

import dagger.internal.Factory;
import id.dana.domain.statement.UserStatementRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetAllStatementDetail_Factory implements Factory<GetAllStatementDetail> {
    private final Provider<UserStatementRepository> userStatementRepositoryProvider;

    public GetAllStatementDetail_Factory(Provider<UserStatementRepository> provider) {
        this.userStatementRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetAllStatementDetail get() {
        return newInstance(this.userStatementRepositoryProvider.get());
    }

    public static GetAllStatementDetail_Factory create(Provider<UserStatementRepository> provider) {
        return new GetAllStatementDetail_Factory(provider);
    }

    public static GetAllStatementDetail newInstance(UserStatementRepository userStatementRepository) {
        return new GetAllStatementDetail(userStatementRepository);
    }
}
