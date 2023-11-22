package id.dana.sendmoney.data.repository.core.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.foundation.facede.ApSecurity;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkSendMoneyCoreEntityData_Factory implements Factory<NetworkSendMoneyCoreEntityData> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ApSecurity> MyBillsEntityDataFactory;
    private final Provider<RpcConnector> getAuthRequestContext;

    private NetworkSendMoneyCoreEntityData_Factory(Provider<RpcConnector> provider, Provider<ApSecurity> provider2, Provider<Context> provider3) {
        this.getAuthRequestContext = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
    }

    public static NetworkSendMoneyCoreEntityData_Factory MyBillsEntityDataFactory(Provider<RpcConnector> provider, Provider<ApSecurity> provider2, Provider<Context> provider3) {
        return new NetworkSendMoneyCoreEntityData_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NetworkSendMoneyCoreEntityData(this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
