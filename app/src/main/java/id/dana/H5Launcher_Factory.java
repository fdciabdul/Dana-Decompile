package id.dana;

import dagger.internal.Factory;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class H5Launcher_Factory implements Factory<H5Launcher> {
    private final Provider<DynamicUrlWrapper> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new H5Launcher(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
