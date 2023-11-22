package id.dana.explore.data.globalsearch.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.explore.data.sku.repository.source.network.ExploreDanaApi;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkGlobalSearchEntityData_Factory implements Factory<NetworkGlobalSearchEntityData> {
    private final Provider<RpcConnector> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ThreadExecutor> MyBillsEntityDataFactory;
    private final Provider<ApSecurityFacade> PlaceComponentResult;
    private final Provider<ExploreDanaApi> getAuthRequestContext;

    private NetworkGlobalSearchEntityData_Factory(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4, Provider<ExploreDanaApi> provider5) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.PlaceComponentResult = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
        this.getAuthRequestContext = provider5;
    }

    public static NetworkGlobalSearchEntityData_Factory MyBillsEntityDataFactory(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4, Provider<ExploreDanaApi> provider5) {
        return new NetworkGlobalSearchEntityData_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NetworkGlobalSearchEntityData(this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get());
    }
}
