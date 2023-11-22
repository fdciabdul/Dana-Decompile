package id.dana.data.foundation.amcs;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class AMCSManager_Factory implements Factory<AMCSManager> {
    private final Provider<Context> PlaceComponentResult;

    private AMCSManager_Factory(Provider<Context> provider) {
        this.PlaceComponentResult = provider;
    }

    public static AMCSManager_Factory getAuthRequestContext(Provider<Context> provider) {
        return new AMCSManager_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new AMCSManager(this.PlaceComponentResult.get());
    }
}
