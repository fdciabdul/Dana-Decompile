package id.dana.data.miniprogram.source.local;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class StoreMiniProgramPreference_Factory implements Factory<StoreMiniProgramPreference> {
    private final Provider<Context> getAuthRequestContext;

    private StoreMiniProgramPreference_Factory(Provider<Context> provider) {
        this.getAuthRequestContext = provider;
    }

    public static StoreMiniProgramPreference_Factory MyBillsEntityDataFactory(Provider<Context> provider) {
        return new StoreMiniProgramPreference_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new StoreMiniProgramPreference(this.getAuthRequestContext.get());
    }
}
