package id.dana.feeds.data.share.source;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FeedsShareDataFactory_Factory implements Factory<FeedsShareDataFactory> {
    private final Provider<ThreadExecutor> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<RpcConnector> MyBillsEntityDataFactory;
    private final Provider<ApSecurityFacade> PlaceComponentResult;
    private final Provider<Context> getAuthRequestContext;

    private FeedsShareDataFactory_Factory(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4) {
        this.MyBillsEntityDataFactory = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.PlaceComponentResult = provider3;
        this.getAuthRequestContext = provider4;
    }

    public static FeedsShareDataFactory_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4) {
        return new FeedsShareDataFactory_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeedsShareDataFactory(this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get(), this.getAuthRequestContext.get());
    }
}
