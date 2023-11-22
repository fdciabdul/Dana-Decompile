package id.dana.data.geocode.repository.config.local;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LocalGeocodeConfigEntityData_Factory implements Factory<LocalGeocodeConfigEntityData> {
    private final Provider<Context> contextProvider;

    public LocalGeocodeConfigEntityData_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public final LocalGeocodeConfigEntityData get() {
        return newInstance(this.contextProvider.get());
    }

    public static LocalGeocodeConfigEntityData_Factory create(Provider<Context> provider) {
        return new LocalGeocodeConfigEntityData_Factory(provider);
    }

    public static LocalGeocodeConfigEntityData newInstance(Context context) {
        return new LocalGeocodeConfigEntityData(context);
    }
}
