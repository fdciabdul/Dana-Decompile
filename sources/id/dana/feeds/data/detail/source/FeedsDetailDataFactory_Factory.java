package id.dana.feeds.data.detail.source;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FeedsDetailDataFactory_Factory implements Factory<FeedsDetailDataFactory> {
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ApSecurityFacade> MyBillsEntityDataFactory;
    private final Provider<ThreadExecutor> PlaceComponentResult;
    private final Provider<RpcConnector> getAuthRequestContext;

    private FeedsDetailDataFactory_Factory(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4) {
        this.getAuthRequestContext = provider;
        this.PlaceComponentResult = provider2;
        this.MyBillsEntityDataFactory = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
    }

    public static FeedsDetailDataFactory_Factory PlaceComponentResult(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4) {
        return new FeedsDetailDataFactory_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeedsDetailDataFactory(this.getAuthRequestContext.get(), this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
