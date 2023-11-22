package id.dana.data.promocenter.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PromoAdsPreferences_Factory implements Factory<PromoAdsPreferences> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public PromoAdsPreferences_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final PromoAdsPreferences get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static PromoAdsPreferences_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new PromoAdsPreferences_Factory(provider, provider2);
    }

    public static PromoAdsPreferences newInstance(Context context, Serializer serializer) {
        return new PromoAdsPreferences(context, serializer);
    }
}
