package id.dana.domain.familyaccount.interactor;

import dagger.internal.Factory;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CreateOrderTopUpFamilyBalance_Factory implements Factory<CreateOrderTopUpFamilyBalance> {
    private final Provider<FamilyAccountRepository> familyAccountRepositoryProvider;

    public CreateOrderTopUpFamilyBalance_Factory(Provider<FamilyAccountRepository> provider) {
        this.familyAccountRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CreateOrderTopUpFamilyBalance get() {
        return newInstance(this.familyAccountRepositoryProvider.get());
    }

    public static CreateOrderTopUpFamilyBalance_Factory create(Provider<FamilyAccountRepository> provider) {
        return new CreateOrderTopUpFamilyBalance_Factory(provider);
    }

    public static CreateOrderTopUpFamilyBalance newInstance(FamilyAccountRepository familyAccountRepository) {
        return new CreateOrderTopUpFamilyBalance(familyAccountRepository);
    }
}
