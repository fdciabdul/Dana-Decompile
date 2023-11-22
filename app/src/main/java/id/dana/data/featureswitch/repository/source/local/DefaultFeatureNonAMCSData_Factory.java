package id.dana.data.featureswitch.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DefaultFeatureNonAMCSData_Factory implements Factory<DefaultFeatureNonAMCSData> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public DefaultFeatureNonAMCSData_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final DefaultFeatureNonAMCSData get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static DefaultFeatureNonAMCSData_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new DefaultFeatureNonAMCSData_Factory(provider, provider2);
    }

    public static DefaultFeatureNonAMCSData newInstance(Context context, Serializer serializer) {
        return new DefaultFeatureNonAMCSData(context, serializer);
    }
}
