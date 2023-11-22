package id.dana.data.referral.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ReferralPreferences_Factory implements Factory<ReferralPreferences> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public ReferralPreferences_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final ReferralPreferences get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static ReferralPreferences_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new ReferralPreferences_Factory(provider, provider2);
    }

    public static ReferralPreferences newInstance(Context context, Serializer serializer) {
        return new ReferralPreferences(context, serializer);
    }
}
