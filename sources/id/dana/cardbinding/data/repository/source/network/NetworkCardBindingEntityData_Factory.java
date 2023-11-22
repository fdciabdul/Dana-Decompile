package id.dana.cardbinding.data.repository.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class NetworkCardBindingEntityData_Factory implements Factory<NetworkCardBindingEntityData> {
    private final Provider<RpcConnector> BuiltInFictitiousFunctionClassFactory;
    private final Provider<CardBindingSecureApi> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> MyBillsEntityDataFactory;
    private final Provider<ApSecurityFacade> PlaceComponentResult;

    private NetworkCardBindingEntityData_Factory(Provider<RpcConnector> provider, Provider<ApSecurityFacade> provider2, Provider<Context> provider3, Provider<CardBindingSecureApi> provider4) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.PlaceComponentResult = provider2;
        this.MyBillsEntityDataFactory = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
    }

    public static NetworkCardBindingEntityData_Factory PlaceComponentResult(Provider<RpcConnector> provider, Provider<ApSecurityFacade> provider2, Provider<Context> provider3, Provider<CardBindingSecureApi> provider4) {
        return new NetworkCardBindingEntityData_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NetworkCardBindingEntityData(this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
