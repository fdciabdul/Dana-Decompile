package id.dana.data.usercredential.repository.source;

import dagger.internal.Factory;
import id.dana.data.usercredential.repository.CredentialEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class CredentialEntityDataFactory_Factory implements Factory<CredentialEntityDataFactory> {
    private final Provider<CredentialEntityData> PlaceComponentResult;
    private final Provider<CredentialEntityData> getAuthRequestContext;

    private CredentialEntityDataFactory_Factory(Provider<CredentialEntityData> provider, Provider<CredentialEntityData> provider2) {
        this.getAuthRequestContext = provider;
        this.PlaceComponentResult = provider2;
    }

    public static CredentialEntityDataFactory_Factory BuiltInFictitiousFunctionClassFactory(Provider<CredentialEntityData> provider, Provider<CredentialEntityData> provider2) {
        return new CredentialEntityDataFactory_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CredentialEntityDataFactory(this.getAuthRequestContext.get(), this.PlaceComponentResult.get());
    }
}
