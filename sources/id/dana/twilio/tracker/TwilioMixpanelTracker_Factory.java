package id.dana.twilio.tracker;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class TwilioMixpanelTracker_Factory implements Factory<TwilioMixpanelTracker> {
    private final Provider<Context> getAuthRequestContext;

    private TwilioMixpanelTracker_Factory(Provider<Context> provider) {
        this.getAuthRequestContext = provider;
    }

    public static TwilioMixpanelTracker_Factory getAuthRequestContext(Provider<Context> provider) {
        return new TwilioMixpanelTracker_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new TwilioMixpanelTracker(this.getAuthRequestContext.get());
    }
}
