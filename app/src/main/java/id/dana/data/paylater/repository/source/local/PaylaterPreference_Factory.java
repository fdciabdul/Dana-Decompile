package id.dana.data.paylater.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PaylaterPreference_Factory implements Factory<PaylaterPreference> {
    private final Provider<Context> contextProvider;

    public PaylaterPreference_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public final PaylaterPreference get() {
        return newInstance(this.contextProvider.get());
    }

    public static PaylaterPreference_Factory create(Provider<Context> provider) {
        return new PaylaterPreference_Factory(provider);
    }

    public static PaylaterPreference newInstance(Context context) {
        return new PaylaterPreference(context);
    }
}
