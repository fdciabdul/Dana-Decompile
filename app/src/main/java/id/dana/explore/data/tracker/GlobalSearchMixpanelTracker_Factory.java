package id.dana.explore.data.tracker;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GlobalSearchMixpanelTracker_Factory implements Factory<GlobalSearchMixpanelTracker> {
    private final Provider<Context> getAuthRequestContext;

    private GlobalSearchMixpanelTracker_Factory(Provider<Context> provider) {
        this.getAuthRequestContext = provider;
    }

    public static GlobalSearchMixpanelTracker_Factory MyBillsEntityDataFactory(Provider<Context> provider) {
        return new GlobalSearchMixpanelTracker_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GlobalSearchMixpanelTracker(this.getAuthRequestContext.get());
    }
}
