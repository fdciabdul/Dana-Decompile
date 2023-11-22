package id.dana.explore.domain.userpersonalization.interactor;

import dagger.internal.Factory;
import id.dana.explore.domain.userpersonalization.UserPersonalizationRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetPersonalizationOptions_Factory implements Factory<GetPersonalizationOptions> {
    private final Provider<UserPersonalizationRepository> MyBillsEntityDataFactory;

    private GetPersonalizationOptions_Factory(Provider<UserPersonalizationRepository> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static GetPersonalizationOptions_Factory BuiltInFictitiousFunctionClassFactory(Provider<UserPersonalizationRepository> provider) {
        return new GetPersonalizationOptions_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetPersonalizationOptions(this.MyBillsEntityDataFactory.get());
    }
}
