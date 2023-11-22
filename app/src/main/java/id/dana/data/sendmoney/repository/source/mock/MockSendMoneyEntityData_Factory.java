package id.dana.data.sendmoney.repository.source.mock;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class MockSendMoneyEntityData_Factory implements Factory<MockSendMoneyEntityData> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public MockSendMoneyEntityData_Factory(Provider<Serializer> provider, Provider<Context> provider2) {
        this.serializerProvider = provider;
        this.contextProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final MockSendMoneyEntityData get() {
        return newInstance(this.serializerProvider.get(), this.contextProvider.get());
    }

    public static MockSendMoneyEntityData_Factory create(Provider<Serializer> provider, Provider<Context> provider2) {
        return new MockSendMoneyEntityData_Factory(provider, provider2);
    }

    public static MockSendMoneyEntityData newInstance(Serializer serializer, Context context) {
        return new MockSendMoneyEntityData(serializer, context);
    }
}
