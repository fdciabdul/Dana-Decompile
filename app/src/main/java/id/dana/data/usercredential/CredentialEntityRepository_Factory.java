package id.dana.data.usercredential;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.usercredential.repository.source.CredentialEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class CredentialEntityRepository_Factory implements Factory<CredentialEntityRepository> {
    private final Provider<ConfigEntityDataFactory> BuiltInFictitiousFunctionClassFactory;
    private final Provider<CredentialEntityDataFactory> PlaceComponentResult;

    private CredentialEntityRepository_Factory(Provider<CredentialEntityDataFactory> provider, Provider<ConfigEntityDataFactory> provider2) {
        this.PlaceComponentResult = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
    }

    public static CredentialEntityRepository_Factory MyBillsEntityDataFactory(Provider<CredentialEntityDataFactory> provider, Provider<ConfigEntityDataFactory> provider2) {
        return new CredentialEntityRepository_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CredentialEntityRepository(DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory));
    }
}
