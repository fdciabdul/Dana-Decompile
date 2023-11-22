package id.dana.data.sendmoney.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DefaultDigitalMoneyEntityData_Factory implements Factory<DefaultDigitalMoneyEntityData> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public DefaultDigitalMoneyEntityData_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final DefaultDigitalMoneyEntityData get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static DefaultDigitalMoneyEntityData_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new DefaultDigitalMoneyEntityData_Factory(provider, provider2);
    }

    public static DefaultDigitalMoneyEntityData newInstance(Context context, Serializer serializer) {
        return new DefaultDigitalMoneyEntityData(context, serializer);
    }
}
