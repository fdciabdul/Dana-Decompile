package id.dana.data.merchantmanagement.repository.source.mock;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class MockMerchantManagementEntityData_Factory implements Factory<MockMerchantManagementEntityData> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public MockMerchantManagementEntityData_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final MockMerchantManagementEntityData get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static MockMerchantManagementEntityData_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new MockMerchantManagementEntityData_Factory(provider, provider2);
    }

    public static MockMerchantManagementEntityData newInstance(Context context, Serializer serializer) {
        return new MockMerchantManagementEntityData(context, serializer);
    }
}
