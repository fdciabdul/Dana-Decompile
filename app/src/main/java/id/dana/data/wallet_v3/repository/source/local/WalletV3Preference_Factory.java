package id.dana.data.wallet_v3.repository.source.local;

import android.content.Context;
import com.google.gson.Gson;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class WalletV3Preference_Factory implements Factory<WalletV3Preference> {
    private final Provider<Context> contextProvider;
    private final Provider<Gson> gsonProvider;
    private final Provider<Serializer> serializerProvider;

    public WalletV3Preference_Factory(Provider<Context> provider, Provider<Serializer> provider2, Provider<Gson> provider3) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
        this.gsonProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final WalletV3Preference get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get(), this.gsonProvider.get());
    }

    public static WalletV3Preference_Factory create(Provider<Context> provider, Provider<Serializer> provider2, Provider<Gson> provider3) {
        return new WalletV3Preference_Factory(provider, provider2, provider3);
    }

    public static WalletV3Preference newInstance(Context context, Serializer serializer, Gson gson) {
        return new WalletV3Preference(context, serializer, gson);
    }
}
