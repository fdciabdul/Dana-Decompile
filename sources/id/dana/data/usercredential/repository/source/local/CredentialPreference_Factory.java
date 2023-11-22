package id.dana.data.usercredential.repository.source.local;

import com.google.gson.Gson;
import dagger.internal.Factory;
import id.dana.data.storage.PreferenceFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class CredentialPreference_Factory implements Factory<CredentialPreference> {
    private final Provider<PreferenceFacade> MyBillsEntityDataFactory;
    private final Provider<Gson> getAuthRequestContext;

    private CredentialPreference_Factory(Provider<PreferenceFacade> provider, Provider<Gson> provider2) {
        this.MyBillsEntityDataFactory = provider;
        this.getAuthRequestContext = provider2;
    }

    public static CredentialPreference_Factory getAuthRequestContext(Provider<PreferenceFacade> provider, Provider<Gson> provider2) {
        return new CredentialPreference_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CredentialPreference(this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get());
    }
}
