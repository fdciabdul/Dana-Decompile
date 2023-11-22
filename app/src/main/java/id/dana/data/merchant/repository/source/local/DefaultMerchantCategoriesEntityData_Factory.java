package id.dana.data.merchant.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DefaultMerchantCategoriesEntityData_Factory implements Factory<DefaultMerchantCategoriesEntityData> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public DefaultMerchantCategoriesEntityData_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final DefaultMerchantCategoriesEntityData get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static DefaultMerchantCategoriesEntityData_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new DefaultMerchantCategoriesEntityData_Factory(provider, provider2);
    }

    public static DefaultMerchantCategoriesEntityData newInstance(Context context, Serializer serializer) {
        return new DefaultMerchantCategoriesEntityData(context, serializer);
    }
}
