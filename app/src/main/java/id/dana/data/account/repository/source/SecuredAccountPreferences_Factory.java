package id.dana.data.account.repository.source;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SecuredAccountPreferences_Factory implements Factory<SecuredAccountPreferences> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public SecuredAccountPreferences_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final SecuredAccountPreferences get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static SecuredAccountPreferences_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new SecuredAccountPreferences_Factory(provider, provider2);
    }

    public static SecuredAccountPreferences newInstance(Context context, Serializer serializer) {
        return new SecuredAccountPreferences(context, serializer);
    }
}
