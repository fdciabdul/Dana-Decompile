package id.dana.data.statement.repository;

import dagger.internal.Factory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.statement.repository.source.UserStatementDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class UserStatementEntityRepository_Factory implements Factory<UserStatementEntityRepository> {
    private final Provider<HoldLoginV1EntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<UserStatementDataFactory> PlaceComponentResult;

    private UserStatementEntityRepository_Factory(Provider<UserStatementDataFactory> provider, Provider<HoldLoginV1EntityRepository> provider2) {
        this.PlaceComponentResult = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
    }

    public static UserStatementEntityRepository_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<UserStatementDataFactory> provider, Provider<HoldLoginV1EntityRepository> provider2) {
        return new UserStatementEntityRepository_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new UserStatementEntityRepository(this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
