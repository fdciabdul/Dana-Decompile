package id.dana.data.utdid;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.utils.storage.AppInfo;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class UtdidFacade_Factory implements Factory<UtdidFacade> {
    private final Provider<AppInfo> appInfoProvider;
    private final Provider<Context> contextProvider;

    public UtdidFacade_Factory(Provider<Context> provider, Provider<AppInfo> provider2) {
        this.contextProvider = provider;
        this.appInfoProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final UtdidFacade get() {
        return newInstance(this.contextProvider.get(), this.appInfoProvider.get());
    }

    public static UtdidFacade_Factory create(Provider<Context> provider, Provider<AppInfo> provider2) {
        return new UtdidFacade_Factory(provider, provider2);
    }

    public static UtdidFacade newInstance(Context context, AppInfo appInfo) {
        return new UtdidFacade(context, appInfo);
    }
}
