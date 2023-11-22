package id.dana.data.tracker;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class HereApiMixpanelTracker_Factory implements Factory<HereApiMixpanelTracker> {
    private final Provider<Context> contextProvider;

    public HereApiMixpanelTracker_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public final HereApiMixpanelTracker get() {
        return newInstance(this.contextProvider.get());
    }

    public static HereApiMixpanelTracker_Factory create(Provider<Context> provider) {
        return new HereApiMixpanelTracker_Factory(provider);
    }

    public static HereApiMixpanelTracker newInstance(Context context) {
        return new HereApiMixpanelTracker(context);
    }
}
