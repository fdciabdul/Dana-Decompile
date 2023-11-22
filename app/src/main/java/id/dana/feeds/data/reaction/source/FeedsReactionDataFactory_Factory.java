package id.dana.feeds.data.reaction.source;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FeedsReactionDataFactory_Factory implements Factory<FeedsReactionDataFactory> {
    private final Provider<ThreadExecutor> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> MyBillsEntityDataFactory;
    private final Provider<ApSecurityFacade> PlaceComponentResult;
    private final Provider<RpcConnector> getAuthRequestContext;

    private FeedsReactionDataFactory_Factory(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4) {
        this.getAuthRequestContext = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.PlaceComponentResult = provider3;
        this.MyBillsEntityDataFactory = provider4;
    }

    public static FeedsReactionDataFactory_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4) {
        return new FeedsReactionDataFactory_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeedsReactionDataFactory(this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get());
    }
}
