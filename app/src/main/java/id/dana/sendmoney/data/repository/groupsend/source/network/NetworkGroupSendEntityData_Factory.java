package id.dana.sendmoney.data.repository.groupsend.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.foundation.facede.ApSecurity;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class NetworkGroupSendEntityData_Factory implements Factory<NetworkGroupSendEntityData> {
    private final Provider<ApSecurity> MyBillsEntityDataFactory;
    private final Provider<RpcConnector> PlaceComponentResult;
    private final Provider<Context> getAuthRequestContext;

    private NetworkGroupSendEntityData_Factory(Provider<RpcConnector> provider, Provider<ApSecurity> provider2, Provider<Context> provider3) {
        this.PlaceComponentResult = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.getAuthRequestContext = provider3;
    }

    public static NetworkGroupSendEntityData_Factory getAuthRequestContext(Provider<RpcConnector> provider, Provider<ApSecurity> provider2, Provider<Context> provider3) {
        return new NetworkGroupSendEntityData_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NetworkGroupSendEntityData(this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get());
    }
}
