package id.dana.data.twilio.repository.source;

import dagger.internal.Factory;
import id.dana.data.twilio.repository.source.network.NetworkTwilioEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class TwilioEnrollmentEntityDataFactory_Factory implements Factory<TwilioEnrollmentEntityDataFactory> {
    private final Provider<NetworkTwilioEntityData> MyBillsEntityDataFactory;

    private TwilioEnrollmentEntityDataFactory_Factory(Provider<NetworkTwilioEntityData> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static TwilioEnrollmentEntityDataFactory_Factory getAuthRequestContext(Provider<NetworkTwilioEntityData> provider) {
        return new TwilioEnrollmentEntityDataFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new TwilioEnrollmentEntityDataFactory(this.MyBillsEntityDataFactory.get());
    }
}
