package id.dana.data.twilio.repository.source.local;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PreferencesTwilioConsultBackendEntityData_Factory implements Factory<PreferencesTwilioConsultBackendEntityData> {
    private final Provider<TwilioConsultBackendPreferences> MyBillsEntityDataFactory;

    private PreferencesTwilioConsultBackendEntityData_Factory(Provider<TwilioConsultBackendPreferences> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static PreferencesTwilioConsultBackendEntityData_Factory MyBillsEntityDataFactory(Provider<TwilioConsultBackendPreferences> provider) {
        return new PreferencesTwilioConsultBackendEntityData_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PreferencesTwilioConsultBackendEntityData(this.MyBillsEntityDataFactory.get());
    }
}
