package id.dana.di.modules;

import android.app.Application;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.globalnetwork.source.remote.RemoteGnPaymentEntityData;
import id.dana.data.miniprogram.source.network.NetworkMiniPrograms;
import id.dana.data.user.UserEntityRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideRemoteGnPaymentEntityDataFactory implements Factory<RemoteGnPaymentEntityData> {
    private final Provider<UserEntityRepository> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Application> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<NetworkMiniPrograms> MyBillsEntityDataFactory;
    private final ApplicationModule PlaceComponentResult;

    private ApplicationModule_ProvideRemoteGnPaymentEntityDataFactory(ApplicationModule applicationModule, Provider<Application> provider, Provider<UserEntityRepository> provider2, Provider<NetworkMiniPrograms> provider3) {
        this.PlaceComponentResult = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.MyBillsEntityDataFactory = provider3;
    }

    public static ApplicationModule_ProvideRemoteGnPaymentEntityDataFactory MyBillsEntityDataFactory(ApplicationModule applicationModule, Provider<Application> provider, Provider<UserEntityRepository> provider2, Provider<NetworkMiniPrograms> provider3) {
        return new ApplicationModule_ProvideRemoteGnPaymentEntityDataFactory(applicationModule, provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (RemoteGnPaymentEntityData) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get()));
    }
}
