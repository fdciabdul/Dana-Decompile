package id.dana.data.usereducation.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class UserEducationPreference_Factory implements Factory<UserEducationPreference> {
    private final Provider<Context> contextProvider;

    public UserEducationPreference_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public final UserEducationPreference get() {
        return newInstance(this.contextProvider.get());
    }

    public static UserEducationPreference_Factory create(Provider<Context> provider) {
        return new UserEducationPreference_Factory(provider);
    }

    public static UserEducationPreference newInstance(Context context) {
        return new UserEducationPreference(context);
    }
}
