package id.dana.explore.domain.userpersonalization.interactor;

import dagger.internal.Factory;
import id.dana.domain.account.AccountRepository;
import id.dana.explore.domain.userpersonalization.UserPersonalizationRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class CreateUserPersonalization_Factory implements Factory<CreateUserPersonalization> {
    private final Provider<AccountRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<UserPersonalizationRepository> MyBillsEntityDataFactory;

    private CreateUserPersonalization_Factory(Provider<AccountRepository> provider, Provider<UserPersonalizationRepository> provider2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static CreateUserPersonalization_Factory getAuthRequestContext(Provider<AccountRepository> provider, Provider<UserPersonalizationRepository> provider2) {
        return new CreateUserPersonalization_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CreateUserPersonalization(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get());
    }
}
