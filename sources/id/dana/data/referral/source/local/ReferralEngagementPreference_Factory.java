package id.dana.data.referral.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ReferralEngagementPreference_Factory implements Factory<ReferralEngagementPreference> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public ReferralEngagementPreference_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final ReferralEngagementPreference get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static ReferralEngagementPreference_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new ReferralEngagementPreference_Factory(provider, provider2);
    }

    public static ReferralEngagementPreference newInstance(Context context, Serializer serializer) {
        return new ReferralEngagementPreference(context, serializer);
    }
}
