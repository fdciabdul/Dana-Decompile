package id.dana.data.wallet_v3.repository.source.local;

import android.content.Context;
import com.google.gson.Gson;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class WalletConfigPreference_Factory implements Factory<WalletConfigPreference> {
    private final Provider<Context> contextProvider;
    private final Provider<Gson> gsonProvider;
    private final Provider<Serializer> serializerProvider;

    public WalletConfigPreference_Factory(Provider<Context> provider, Provider<Serializer> provider2, Provider<Gson> provider3) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
        this.gsonProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final WalletConfigPreference get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get(), this.gsonProvider.get());
    }

    public static WalletConfigPreference_Factory create(Provider<Context> provider, Provider<Serializer> provider2, Provider<Gson> provider3) {
        return new WalletConfigPreference_Factory(provider, provider2, provider3);
    }

    public static WalletConfigPreference newInstance(Context context, Serializer serializer, Gson gson) {
        return new WalletConfigPreference(context, serializer, gson);
    }
}
