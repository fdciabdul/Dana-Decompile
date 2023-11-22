package id.dana.danah5;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DanaCustomH5_Factory implements Factory<DanaCustomH5> {
    private final Provider<Context> contextProvider;

    public DanaCustomH5_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public final DanaCustomH5 get() {
        return newInstance(this.contextProvider.get());
    }

    public static DanaCustomH5_Factory create(Provider<Context> provider) {
        return new DanaCustomH5_Factory(provider);
    }

    public static DanaCustomH5 newInstance(Context context) {
        return new DanaCustomH5(context);
    }
}
