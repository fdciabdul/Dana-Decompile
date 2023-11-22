package id.dana.data.resetpin;

import dagger.internal.Factory;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.registration.RegistrationProcessManager;
import id.dana.data.resetpin.source.local.ResetPinPreference;
import id.dana.data.resetpin.source.network.NetworkResetPinEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ResetPinRepositoryImpl_Factory implements Factory<ResetPinRepositoryImpl> {
    private final Provider<ResetPinPreference> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ConfigEntityDataFactory> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<AccountEntityDataFactory> MyBillsEntityDataFactory;
    private final Provider<RegistrationProcessManager> PlaceComponentResult;
    private final Provider<NetworkResetPinEntityData> getAuthRequestContext;

    private ResetPinRepositoryImpl_Factory(Provider<ResetPinPreference> provider, Provider<NetworkResetPinEntityData> provider2, Provider<ConfigEntityDataFactory> provider3, Provider<AccountEntityDataFactory> provider4, Provider<RegistrationProcessManager> provider5) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.getAuthRequestContext = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.MyBillsEntityDataFactory = provider4;
        this.PlaceComponentResult = provider5;
    }

    public static ResetPinRepositoryImpl_Factory getAuthRequestContext(Provider<ResetPinPreference> provider, Provider<NetworkResetPinEntityData> provider2, Provider<ConfigEntityDataFactory> provider3, Provider<AccountEntityDataFactory> provider4, Provider<RegistrationProcessManager> provider5) {
        return new ResetPinRepositoryImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ResetPinRepositoryImpl(this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get());
    }
}
