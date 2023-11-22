package id.dana.data.errorconfig.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.errorconfig.local.ErrorConfigPreferences;
import id.dana.data.foundation.amcs.AMCSManager;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkErrorConfigEntityData_Factory implements Factory<NetworkErrorConfigEntityData> {
    private final Provider<AMCSManager> amcsManagerProvider;
    private final Provider<Context> contextProvider;
    private final Provider<ErrorConfigPreferences> errorConfigPreferencesProvider;
    private final Provider<Serializer> serializerProvider;

    public NetworkErrorConfigEntityData_Factory(Provider<Context> provider, Provider<Serializer> provider2, Provider<AMCSManager> provider3, Provider<ErrorConfigPreferences> provider4) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
        this.amcsManagerProvider = provider3;
        this.errorConfigPreferencesProvider = provider4;
    }

    @Override // javax.inject.Provider
    public final NetworkErrorConfigEntityData get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get(), this.amcsManagerProvider.get(), this.errorConfigPreferencesProvider.get());
    }

    public static NetworkErrorConfigEntityData_Factory create(Provider<Context> provider, Provider<Serializer> provider2, Provider<AMCSManager> provider3, Provider<ErrorConfigPreferences> provider4) {
        return new NetworkErrorConfigEntityData_Factory(provider, provider2, provider3, provider4);
    }

    public static NetworkErrorConfigEntityData newInstance(Context context, Serializer serializer, AMCSManager aMCSManager, ErrorConfigPreferences errorConfigPreferences) {
        return new NetworkErrorConfigEntityData(context, serializer, aMCSManager, errorConfigPreferences);
    }
}
