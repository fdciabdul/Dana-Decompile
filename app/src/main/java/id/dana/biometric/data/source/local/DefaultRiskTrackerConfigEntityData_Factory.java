package id.dana.biometric.data.source.local;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class DefaultRiskTrackerConfigEntityData_Factory implements Factory<DefaultRiskTrackerConfigEntityData> {
    private final Provider<Context> contextProvider;

    public DefaultRiskTrackerConfigEntityData_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public final DefaultRiskTrackerConfigEntityData get() {
        return newInstance(this.contextProvider.get());
    }

    public static DefaultRiskTrackerConfigEntityData_Factory create(Provider<Context> provider) {
        return new DefaultRiskTrackerConfigEntityData_Factory(provider);
    }

    public static DefaultRiskTrackerConfigEntityData newInstance(Context context) {
        return new DefaultRiskTrackerConfigEntityData(context);
    }
}
