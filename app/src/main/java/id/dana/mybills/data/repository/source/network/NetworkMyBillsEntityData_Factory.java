package id.dana.mybills.data.repository.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.foundation.facede.ApSecurity;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class NetworkMyBillsEntityData_Factory implements Factory<NetworkMyBillsEntityData> {
    private final Provider<MyBillsRestFacade> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ApSecurity> MyBillsEntityDataFactory;
    private final Provider<RpcConnector> PlaceComponentResult;
    private final Provider<Context> getAuthRequestContext;

    private NetworkMyBillsEntityData_Factory(Provider<RpcConnector> provider, Provider<ApSecurity> provider2, Provider<Context> provider3, Provider<MyBillsRestFacade> provider4) {
        this.PlaceComponentResult = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.getAuthRequestContext = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
    }

    public static NetworkMyBillsEntityData_Factory getAuthRequestContext(Provider<RpcConnector> provider, Provider<ApSecurity> provider2, Provider<Context> provider3, Provider<MyBillsRestFacade> provider4) {
        return new NetworkMyBillsEntityData_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NetworkMyBillsEntityData(this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
