package id.dana.data.twilio.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class TwilioConsultBackendPreferences_Factory implements Factory<TwilioConsultBackendPreferences> {
    private final Provider<Context> MyBillsEntityDataFactory;

    private TwilioConsultBackendPreferences_Factory(Provider<Context> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static TwilioConsultBackendPreferences_Factory MyBillsEntityDataFactory(Provider<Context> provider) {
        return new TwilioConsultBackendPreferences_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new TwilioConsultBackendPreferences(this.MyBillsEntityDataFactory.get());
    }
}
