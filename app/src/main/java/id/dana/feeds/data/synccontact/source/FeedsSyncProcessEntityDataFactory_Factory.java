package id.dana.feeds.data.synccontact.source;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FeedsSyncProcessEntityDataFactory_Factory implements Factory<FeedsSyncProcessEntityDataFactory> {
    private final Provider<RpcConnector> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ApSecurityFacade> MyBillsEntityDataFactory;

    private FeedsSyncProcessEntityDataFactory_Factory(Provider<RpcConnector> provider, Provider<ApSecurityFacade> provider2, Provider<Context> provider3) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
    }

    public static FeedsSyncProcessEntityDataFactory_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<RpcConnector> provider, Provider<ApSecurityFacade> provider2, Provider<Context> provider3) {
        return new FeedsSyncProcessEntityDataFactory_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeedsSyncProcessEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
