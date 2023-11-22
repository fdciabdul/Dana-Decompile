package id.dana.data.requestmoney.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DefaultRequestMoneyEntityData_Factory implements Factory<DefaultRequestMoneyEntityData> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public DefaultRequestMoneyEntityData_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final DefaultRequestMoneyEntityData get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static DefaultRequestMoneyEntityData_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new DefaultRequestMoneyEntityData_Factory(provider, provider2);
    }

    public static DefaultRequestMoneyEntityData newInstance(Context context, Serializer serializer) {
        return new DefaultRequestMoneyEntityData(context, serializer);
    }
}
