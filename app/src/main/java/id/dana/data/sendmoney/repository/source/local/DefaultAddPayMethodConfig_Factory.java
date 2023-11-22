package id.dana.data.sendmoney.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DefaultAddPayMethodConfig_Factory implements Factory<DefaultAddPayMethodConfig> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public DefaultAddPayMethodConfig_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final DefaultAddPayMethodConfig get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static DefaultAddPayMethodConfig_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new DefaultAddPayMethodConfig_Factory(provider, provider2);
    }

    public static DefaultAddPayMethodConfig newInstance(Context context, Serializer serializer) {
        return new DefaultAddPayMethodConfig(context, serializer);
    }
}
