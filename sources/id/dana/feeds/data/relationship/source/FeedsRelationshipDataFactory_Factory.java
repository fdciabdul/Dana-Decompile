package id.dana.feeds.data.relationship.source;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FeedsRelationshipDataFactory_Factory implements Factory<FeedsRelationshipDataFactory> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ThreadExecutor> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<RpcConnector> MyBillsEntityDataFactory;
    private final Provider<ApSecurityFacade> PlaceComponentResult;

    private FeedsRelationshipDataFactory_Factory(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4) {
        this.MyBillsEntityDataFactory = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.PlaceComponentResult = provider3;
        this.BuiltInFictitiousFunctionClassFactory = provider4;
    }

    public static FeedsRelationshipDataFactory_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4) {
        return new FeedsRelationshipDataFactory_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeedsRelationshipDataFactory(this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
