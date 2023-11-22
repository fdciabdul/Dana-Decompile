package id.dana.utils.session;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.danapoly.domain.clear.interactor.ClearAllDanapolyData;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.domain.login.interactor.ForceLogout;
import id.dana.domain.login.interactor.Logout;
import id.dana.domain.services.interactor.ClearCacheFavoriteServices;
import id.dana.feeds.domain.activation.ClearAllFeedsUsecase;
import id.dana.kyb.domain.interactor.ClearKybData;
import id.dana.sync_engine.domain.interactor.ClearAllSyncEngineUseCase;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DanaSessionManager_Factory implements Factory<DanaSessionManager> {
    private final Provider<ClearAllSyncEngineUseCase> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ClearKybData> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ClearAllFeedsUsecase> MyBillsEntityDataFactory;
    private final Provider<DeviceInformationProvider> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<ClearAllDanapolyData> PlaceComponentResult;
    private final Provider<ClearCacheFavoriteServices> getAuthRequestContext;
    private final Provider<ForceLogout> getErrorConfigVersion;
    private final Provider<Context> moveToNextValue;
    private final Provider<Logout> scheduleImpl;

    private DanaSessionManager_Factory(Provider<Context> provider, Provider<DeviceInformationProvider> provider2, Provider<ForceLogout> provider3, Provider<Logout> provider4, Provider<ClearAllSyncEngineUseCase> provider5, Provider<ClearAllFeedsUsecase> provider6, Provider<ClearCacheFavoriteServices> provider7, Provider<ClearAllDanapolyData> provider8, Provider<ClearKybData> provider9) {
        this.moveToNextValue = provider;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider2;
        this.getErrorConfigVersion = provider3;
        this.scheduleImpl = provider4;
        this.BuiltInFictitiousFunctionClassFactory = provider5;
        this.MyBillsEntityDataFactory = provider6;
        this.getAuthRequestContext = provider7;
        this.PlaceComponentResult = provider8;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider9;
    }

    public static DanaSessionManager_Factory getAuthRequestContext(Provider<Context> provider, Provider<DeviceInformationProvider> provider2, Provider<ForceLogout> provider3, Provider<Logout> provider4, Provider<ClearAllSyncEngineUseCase> provider5, Provider<ClearAllFeedsUsecase> provider6, Provider<ClearCacheFavoriteServices> provider7, Provider<ClearAllDanapolyData> provider8, Provider<ClearKybData> provider9) {
        return new DanaSessionManager_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanaSessionManager(this.moveToNextValue.get(), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0), DoubleCheck.MyBillsEntityDataFactory(this.getErrorConfigVersion), this.scheduleImpl.get(), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
    }
}
