package id.dana.data.usercredential.repository.source.local;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LocalCredentialEntityData_Factory implements Factory<LocalCredentialEntityData> {
    private final Provider<CredentialPreference> PlaceComponentResult;

    private LocalCredentialEntityData_Factory(Provider<CredentialPreference> provider) {
        this.PlaceComponentResult = provider;
    }

    public static LocalCredentialEntityData_Factory MyBillsEntityDataFactory(Provider<CredentialPreference> provider) {
        return new LocalCredentialEntityData_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new LocalCredentialEntityData(this.PlaceComponentResult.get());
    }
}
