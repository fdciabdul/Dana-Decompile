package id.dana.domain.version.interactor;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetUpdateAvailability_Factory implements Factory<GetUpdateAvailability> {
    private final Provider<Context> contextProvider;

    public GetUpdateAvailability_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetUpdateAvailability get() {
        return newInstance(this.contextProvider.get());
    }

    public static GetUpdateAvailability_Factory create(Provider<Context> provider) {
        return new GetUpdateAvailability_Factory(provider);
    }

    public static GetUpdateAvailability newInstance(Context context) {
        return new GetUpdateAvailability(context);
    }
}
