package id.dana.data.userconfig.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class UserConfigPreference_Factory implements Factory<UserConfigPreference> {
    private final Provider<Context> contextProvider;

    public UserConfigPreference_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public final UserConfigPreference get() {
        return newInstance(this.contextProvider.get());
    }

    public static UserConfigPreference_Factory create(Provider<Context> provider) {
        return new UserConfigPreference_Factory(provider);
    }

    public static UserConfigPreference newInstance(Context context) {
        return new UserConfigPreference(context);
    }
}
