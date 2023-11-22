package id.dana.data.foundation.toolbox;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.StartupConfigEntityData;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* loaded from: classes8.dex */
public final class OkHttpUrlTransport_Factory implements Factory<OkHttpUrlTransport> {
    private final Provider<OkHttpClient> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<StartupConfigEntityData> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new OkHttpUrlTransport(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get());
    }
}
