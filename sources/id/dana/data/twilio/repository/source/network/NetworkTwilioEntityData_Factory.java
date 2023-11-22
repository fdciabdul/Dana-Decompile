package id.dana.data.twilio.repository.source.network;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.storage.GeneralPreferencesDataFactory;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class NetworkTwilioEntityData_Factory implements Factory<NetworkTwilioEntityData> {
    private final Provider<ApSecurityFacade> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ThreadExecutor> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<RpcConnector> MyBillsEntityDataFactory;
    private final Provider<GeneralPreferencesDataFactory> PlaceComponentResult;
    private final Provider<Context> getAuthRequestContext;

    private NetworkTwilioEntityData_Factory(Provider<Context> provider, Provider<RpcConnector> provider2, Provider<ThreadExecutor> provider3, Provider<ApSecurityFacade> provider4, Provider<GeneralPreferencesDataFactory> provider5) {
        this.getAuthRequestContext = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.BuiltInFictitiousFunctionClassFactory = provider4;
        this.PlaceComponentResult = provider5;
    }

    public static NetworkTwilioEntityData_Factory BuiltInFictitiousFunctionClassFactory(Provider<Context> provider, Provider<RpcConnector> provider2, Provider<ThreadExecutor> provider3, Provider<ApSecurityFacade> provider4, Provider<GeneralPreferencesDataFactory> provider5) {
        return new NetworkTwilioEntityData_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NetworkTwilioEntityData(this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get(), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
    }
}
