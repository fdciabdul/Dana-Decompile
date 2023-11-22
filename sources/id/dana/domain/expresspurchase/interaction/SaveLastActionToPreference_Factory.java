package id.dana.domain.expresspurchase.interaction;

import dagger.internal.Factory;
import id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveLastActionToPreference_Factory implements Factory<SaveLastActionToPreference> {
    private final Provider<ExpressPurchaseRepository> expressPurchaseRepositoryProvider;

    public SaveLastActionToPreference_Factory(Provider<ExpressPurchaseRepository> provider) {
        this.expressPurchaseRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveLastActionToPreference get() {
        return newInstance(this.expressPurchaseRepositoryProvider.get());
    }

    public static SaveLastActionToPreference_Factory create(Provider<ExpressPurchaseRepository> provider) {
        return new SaveLastActionToPreference_Factory(provider);
    }

    public static SaveLastActionToPreference newInstance(ExpressPurchaseRepository expressPurchaseRepository) {
        return new SaveLastActionToPreference(expressPurchaseRepository);
    }
}
