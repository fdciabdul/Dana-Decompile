package id.dana.data.nearbyme.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DefaultMerchantConfigEntityData_Factory implements Factory<DefaultMerchantConfigEntityData> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public DefaultMerchantConfigEntityData_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final DefaultMerchantConfigEntityData get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static DefaultMerchantConfigEntityData_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new DefaultMerchantConfigEntityData_Factory(provider, provider2);
    }

    public static DefaultMerchantConfigEntityData newInstance(Context context, Serializer serializer) {
        return new DefaultMerchantConfigEntityData(context, serializer);
    }
}
