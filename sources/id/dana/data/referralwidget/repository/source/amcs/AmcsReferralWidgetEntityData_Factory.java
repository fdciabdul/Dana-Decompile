package id.dana.data.referralwidget.repository.source.amcs;

import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class AmcsReferralWidgetEntityData_Factory implements Factory<AmcsReferralWidgetEntityData> {
    private final Provider<Serializer> serializerProvider;

    public AmcsReferralWidgetEntityData_Factory(Provider<Serializer> provider) {
        this.serializerProvider = provider;
    }

    @Override // javax.inject.Provider
    public final AmcsReferralWidgetEntityData get() {
        return newInstance(this.serializerProvider.get());
    }

    public static AmcsReferralWidgetEntityData_Factory create(Provider<Serializer> provider) {
        return new AmcsReferralWidgetEntityData_Factory(provider);
    }

    public static AmcsReferralWidgetEntityData newInstance(Serializer serializer) {
        return new AmcsReferralWidgetEntityData(serializer);
    }
}
