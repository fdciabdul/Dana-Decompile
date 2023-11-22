package id.dana.riskChallenges.data.forgetpassword.source.network;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class NetworkResetPasswordEntityData_Factory implements Factory<NetworkResetPasswordEntityData> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ApSecurityFacade> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ResetPasswordApi> PlaceComponentResult;

    private NetworkResetPasswordEntityData_Factory(Provider<Context> provider, Provider<ApSecurityFacade> provider2, Provider<ResetPasswordApi> provider3) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.PlaceComponentResult = provider3;
    }

    public static NetworkResetPasswordEntityData_Factory BuiltInFictitiousFunctionClassFactory(Provider<Context> provider, Provider<ApSecurityFacade> provider2, Provider<ResetPasswordApi> provider3) {
        return new NetworkResetPasswordEntityData_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NetworkResetPasswordEntityData(this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get());
    }
}
