package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.news.LatestNewsContract;

/* loaded from: classes4.dex */
public final class LatestNewsModule_ProvideViewFactory implements Factory<LatestNewsContract.View> {
    private final LatestNewsModule getAuthRequestContext;

    private LatestNewsModule_ProvideViewFactory(LatestNewsModule latestNewsModule) {
        this.getAuthRequestContext = latestNewsModule;
    }

    public static LatestNewsModule_ProvideViewFactory getAuthRequestContext(LatestNewsModule latestNewsModule) {
        return new LatestNewsModule_ProvideViewFactory(latestNewsModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (LatestNewsContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
