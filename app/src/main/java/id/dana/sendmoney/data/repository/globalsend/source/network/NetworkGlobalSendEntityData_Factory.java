package id.dana.sendmoney.data.repository.globalsend.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.foundation.facede.ApSecurity;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkGlobalSendEntityData_Factory implements Factory<NetworkGlobalSendEntityData> {
    private final Provider<ApSecurity> BuiltInFictitiousFunctionClassFactory;
    private final Provider<DynamicUrlWrapper> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<RpcConnector> MyBillsEntityDataFactory;
    private final Provider<GlobalSendSecureApi> PlaceComponentResult;
    private final Provider<Context> getAuthRequestContext;

    private NetworkGlobalSendEntityData_Factory(Provider<RpcConnector> provider, Provider<ApSecurity> provider2, Provider<Context> provider3, Provider<GlobalSendSecureApi> provider4, Provider<DynamicUrlWrapper> provider5) {
        this.MyBillsEntityDataFactory = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.getAuthRequestContext = provider3;
        this.PlaceComponentResult = provider4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider5;
    }

    public static NetworkGlobalSendEntityData_Factory PlaceComponentResult(Provider<RpcConnector> provider, Provider<ApSecurity> provider2, Provider<Context> provider3, Provider<GlobalSendSecureApi> provider4, Provider<DynamicUrlWrapper> provider5) {
        return new NetworkGlobalSendEntityData_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NetworkGlobalSendEntityData(this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
