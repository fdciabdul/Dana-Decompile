package id.dana.data.registration.di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class RegistrationModule_ProvideSecureSharePreferenceFactory implements Factory<PreferenceFacade> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public RegistrationModule_ProvideSecureSharePreferenceFactory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final PreferenceFacade get() {
        return provideSecureSharePreference(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static RegistrationModule_ProvideSecureSharePreferenceFactory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new RegistrationModule_ProvideSecureSharePreferenceFactory(provider, provider2);
    }

    public static PreferenceFacade provideSecureSharePreference(Context context, Serializer serializer) {
        return (PreferenceFacade) Preconditions.BuiltInFictitiousFunctionClassFactory(RegistrationModule.provideSecureSharePreference(context, serializer));
    }
}
