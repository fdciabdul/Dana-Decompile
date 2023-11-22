package id.dana.data.tracker;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class UserConsentTracker_Factory implements Factory<UserConsentTracker> {
    private final Provider<Context> contextProvider;

    public UserConsentTracker_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public final UserConsentTracker get() {
        return newInstance(this.contextProvider.get());
    }

    public static UserConsentTracker_Factory create(Provider<Context> provider) {
        return new UserConsentTracker_Factory(provider);
    }

    public static UserConsentTracker newInstance(Context context) {
        return new UserConsentTracker(context);
    }
}
