package id.dana.data.expresspurchase.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ExpressPurchasePreference_Factory implements Factory<ExpressPurchasePreference> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public ExpressPurchasePreference_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final ExpressPurchasePreference get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static ExpressPurchasePreference_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new ExpressPurchasePreference_Factory(provider, provider2);
    }

    public static ExpressPurchasePreference newInstance(Context context, Serializer serializer) {
        return new ExpressPurchasePreference(context, serializer);
    }
}
