package id.dana.data.homeinfo.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class MaintenanceBroadcastPreference_Factory implements Factory<MaintenanceBroadcastPreference> {
    private final Provider<Context> contextProvider;

    public MaintenanceBroadcastPreference_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public final MaintenanceBroadcastPreference get() {
        return newInstance(this.contextProvider.get());
    }

    public static MaintenanceBroadcastPreference_Factory create(Provider<Context> provider) {
        return new MaintenanceBroadcastPreference_Factory(provider);
    }

    public static MaintenanceBroadcastPreference newInstance(Context context) {
        return new MaintenanceBroadcastPreference(context);
    }
}
