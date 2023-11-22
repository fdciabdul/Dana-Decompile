package id.dana.data.errorconfig.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ErrorConfigPreferences_Factory implements Factory<ErrorConfigPreferences> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public ErrorConfigPreferences_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final ErrorConfigPreferences get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static ErrorConfigPreferences_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new ErrorConfigPreferences_Factory(provider, provider2);
    }

    public static ErrorConfigPreferences newInstance(Context context, Serializer serializer) {
        return new ErrorConfigPreferences(context, serializer);
    }
}
