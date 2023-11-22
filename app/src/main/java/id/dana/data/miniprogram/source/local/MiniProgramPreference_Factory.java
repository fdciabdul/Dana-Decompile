package id.dana.data.miniprogram.source.local;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class MiniProgramPreference_Factory implements Factory<MiniProgramPreference> {
    private final Provider<Context> getAuthRequestContext;

    private MiniProgramPreference_Factory(Provider<Context> provider) {
        this.getAuthRequestContext = provider;
    }

    public static MiniProgramPreference_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<Context> provider) {
        return new MiniProgramPreference_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MiniProgramPreference(this.getAuthRequestContext.get());
    }
}
