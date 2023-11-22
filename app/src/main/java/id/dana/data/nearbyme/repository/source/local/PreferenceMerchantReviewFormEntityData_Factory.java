package id.dana.data.nearbyme.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PreferenceMerchantReviewFormEntityData_Factory implements Factory<PreferenceMerchantReviewFormEntityData> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public PreferenceMerchantReviewFormEntityData_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final PreferenceMerchantReviewFormEntityData get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static PreferenceMerchantReviewFormEntityData_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new PreferenceMerchantReviewFormEntityData_Factory(provider, provider2);
    }

    public static PreferenceMerchantReviewFormEntityData newInstance(Context context, Serializer serializer) {
        return new PreferenceMerchantReviewFormEntityData(context, serializer);
    }
}
