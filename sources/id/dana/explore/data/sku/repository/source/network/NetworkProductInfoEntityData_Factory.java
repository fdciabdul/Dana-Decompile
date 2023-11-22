package id.dana.explore.data.sku.repository.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkProductInfoEntityData_Factory implements Factory<NetworkProductInfoEntityData> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ProductInfoFacade> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ThreadExecutor> MyBillsEntityDataFactory;
    private final Provider<RpcConnector> PlaceComponentResult;
    private final Provider<ApSecurityFacade> getAuthRequestContext;

    private NetworkProductInfoEntityData_Factory(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4, Provider<ProductInfoFacade> provider5) {
        this.PlaceComponentResult = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.getAuthRequestContext = provider3;
        this.BuiltInFictitiousFunctionClassFactory = provider4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider5;
    }

    public static NetworkProductInfoEntityData_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<RpcConnector> provider, Provider<ThreadExecutor> provider2, Provider<ApSecurityFacade> provider3, Provider<Context> provider4, Provider<ProductInfoFacade> provider5) {
        return new NetworkProductInfoEntityData_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NetworkProductInfoEntityData(this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
