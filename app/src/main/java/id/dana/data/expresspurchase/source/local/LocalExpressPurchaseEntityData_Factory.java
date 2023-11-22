package id.dana.data.expresspurchase.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LocalExpressPurchaseEntityData_Factory implements Factory<LocalExpressPurchaseEntityData> {
    private final Provider<Context> contextProvider;
    private final Provider<ExpressPurchasePreference> expressPurchasePreferenceProvider;
    private final Provider<Serializer> serializerProvider;

    public LocalExpressPurchaseEntityData_Factory(Provider<Context> provider, Provider<Serializer> provider2, Provider<ExpressPurchasePreference> provider3) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
        this.expressPurchasePreferenceProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final LocalExpressPurchaseEntityData get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get(), this.expressPurchasePreferenceProvider.get());
    }

    public static LocalExpressPurchaseEntityData_Factory create(Provider<Context> provider, Provider<Serializer> provider2, Provider<ExpressPurchasePreference> provider3) {
        return new LocalExpressPurchaseEntityData_Factory(provider, provider2, provider3);
    }

    public static LocalExpressPurchaseEntityData newInstance(Context context, Serializer serializer, ExpressPurchasePreference expressPurchasePreference) {
        return new LocalExpressPurchaseEntityData(context, serializer, expressPurchasePreference);
    }
}
