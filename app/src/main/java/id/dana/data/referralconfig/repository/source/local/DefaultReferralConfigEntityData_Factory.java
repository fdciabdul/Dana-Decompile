package id.dana.data.referralconfig.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DefaultReferralConfigEntityData_Factory implements Factory<DefaultReferralConfigEntityData> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public DefaultReferralConfigEntityData_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final DefaultReferralConfigEntityData get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static DefaultReferralConfigEntityData_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new DefaultReferralConfigEntityData_Factory(provider, provider2);
    }

    public static DefaultReferralConfigEntityData newInstance(Context context, Serializer serializer) {
        return new DefaultReferralConfigEntityData(context, serializer);
    }
}
