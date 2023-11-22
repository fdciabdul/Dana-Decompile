package id.dana.data.carrieridentification.source.network;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.storage.GeneralPreferencesDataFactory;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkCarrierIdentificationEntityData_Factory implements Factory<NetworkCarrierIdentificationEntityData> {
    private final Provider<ThreadExecutor> BuiltInFictitiousFunctionClassFactory;
    private final Provider<RpcConnector> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> MyBillsEntityDataFactory;
    private final Provider<GeneralPreferencesDataFactory> PlaceComponentResult;
    private final Provider<ApSecurityFacade> getAuthRequestContext;

    private NetworkCarrierIdentificationEntityData_Factory(Provider<Context> provider, Provider<RpcConnector> provider2, Provider<ThreadExecutor> provider3, Provider<ApSecurityFacade> provider4, Provider<GeneralPreferencesDataFactory> provider5) {
        this.MyBillsEntityDataFactory = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
        this.getAuthRequestContext = provider4;
        this.PlaceComponentResult = provider5;
    }

    public static NetworkCarrierIdentificationEntityData_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<Context> provider, Provider<RpcConnector> provider2, Provider<ThreadExecutor> provider3, Provider<ApSecurityFacade> provider4, Provider<GeneralPreferencesDataFactory> provider5) {
        return new NetworkCarrierIdentificationEntityData_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NetworkCarrierIdentificationEntityData(this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get(), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
    }
}
