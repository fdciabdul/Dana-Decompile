package id.dana.data.globalnetwork.source.remote.tracker;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class MiniProgramMixpanelTracker_Factory implements Factory<MiniProgramMixpanelTracker> {
    private final Provider<Context> contextProvider;

    public MiniProgramMixpanelTracker_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public final MiniProgramMixpanelTracker get() {
        return newInstance(this.contextProvider.get());
    }

    public static MiniProgramMixpanelTracker_Factory create(Provider<Context> provider) {
        return new MiniProgramMixpanelTracker_Factory(provider);
    }

    public static MiniProgramMixpanelTracker newInstance(Context context) {
        return new MiniProgramMixpanelTracker(context);
    }
}
