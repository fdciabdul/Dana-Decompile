package id.dana.data.usercredential.di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class CredentialModule_ProvideCredentialPreferenceFactory implements Factory<PreferenceFacade> {
    private final Provider<Serializer> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> MyBillsEntityDataFactory;

    private CredentialModule_ProvideCredentialPreferenceFactory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.MyBillsEntityDataFactory = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
    }

    public static CredentialModule_ProvideCredentialPreferenceFactory KClassImpl$Data$declaredNonStaticMembers$2(Provider<Context> provider, Provider<Serializer> provider2) {
        return new CredentialModule_ProvideCredentialPreferenceFactory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PreferenceFacade) Preconditions.BuiltInFictitiousFunctionClassFactory(CredentialModule.getAuthRequestContext(this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
