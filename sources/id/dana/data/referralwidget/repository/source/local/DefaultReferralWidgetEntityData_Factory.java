package id.dana.data.referralwidget.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DefaultReferralWidgetEntityData_Factory implements Factory<DefaultReferralWidgetEntityData> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public DefaultReferralWidgetEntityData_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final DefaultReferralWidgetEntityData get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static DefaultReferralWidgetEntityData_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new DefaultReferralWidgetEntityData_Factory(provider, provider2);
    }

    public static DefaultReferralWidgetEntityData newInstance(Context context, Serializer serializer) {
        return new DefaultReferralWidgetEntityData(context, serializer);
    }
}
