package id.dana.kyb.tracker;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MixpanelKybTracker_Factory implements Factory<MixpanelKybTracker> {
    private final Provider<Context> getAuthRequestContext;

    private MixpanelKybTracker_Factory(Provider<Context> provider) {
        this.getAuthRequestContext = provider;
    }

    public static MixpanelKybTracker_Factory MyBillsEntityDataFactory(Provider<Context> provider) {
        return new MixpanelKybTracker_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MixpanelKybTracker(this.getAuthRequestContext.get());
    }
}
