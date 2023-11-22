package id.dana.data.bank.repository;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.userconfig.repository.UserConfigEntityRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class UserBankEntityRepository_Factory implements Factory<UserBankEntityRepository> {
    private final Provider<ConfigEntityDataFactory> BuiltInFictitiousFunctionClassFactory;
    private final Provider<HoldLoginV1EntityRepository> PlaceComponentResult;
    private final Provider<UserConfigEntityRepository> getAuthRequestContext;

    private UserBankEntityRepository_Factory(Provider<UserConfigEntityRepository> provider, Provider<HoldLoginV1EntityRepository> provider2, Provider<ConfigEntityDataFactory> provider3) {
        this.getAuthRequestContext = provider;
        this.PlaceComponentResult = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
    }

    public static UserBankEntityRepository_Factory BuiltInFictitiousFunctionClassFactory(Provider<UserConfigEntityRepository> provider, Provider<HoldLoginV1EntityRepository> provider2, Provider<ConfigEntityDataFactory> provider3) {
        return new UserBankEntityRepository_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new UserBankEntityRepository(this.getAuthRequestContext.get(), this.PlaceComponentResult.get(), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory));
    }
}
