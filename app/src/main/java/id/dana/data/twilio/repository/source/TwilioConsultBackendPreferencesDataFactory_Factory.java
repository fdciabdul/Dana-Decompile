package id.dana.data.twilio.repository.source;

import dagger.internal.Factory;
import id.dana.data.twilio.repository.source.local.PreferencesTwilioConsultBackendEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class TwilioConsultBackendPreferencesDataFactory_Factory implements Factory<TwilioConsultBackendPreferencesDataFactory> {
    private final Provider<PreferencesTwilioConsultBackendEntityData> KClassImpl$Data$declaredNonStaticMembers$2;

    private TwilioConsultBackendPreferencesDataFactory_Factory(Provider<PreferencesTwilioConsultBackendEntityData> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static TwilioConsultBackendPreferencesDataFactory_Factory BuiltInFictitiousFunctionClassFactory(Provider<PreferencesTwilioConsultBackendEntityData> provider) {
        return new TwilioConsultBackendPreferencesDataFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new TwilioConsultBackendPreferencesDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
