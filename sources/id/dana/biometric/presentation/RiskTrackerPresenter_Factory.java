package id.dana.biometric.presentation;

import dagger.internal.Factory;
import id.dana.biometric.domain.interactor.DeleteScoringDeviceData;
import id.dana.biometric.domain.interactor.GetAccelerometerData;
import id.dana.biometric.domain.interactor.GetGyroscopeData;
import id.dana.biometric.domain.interactor.GetRiskTrackerConfig;
import id.dana.biometric.domain.interactor.PageEndAndZip;
import id.dana.biometric.domain.interactor.SaveAccelerometerData;
import id.dana.biometric.domain.interactor.SaveGyroscopeData;
import id.dana.biometric.domain.interactor.SaveKeystrokeData;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class RiskTrackerPresenter_Factory implements Factory<RiskTrackerPresenter> {
    private final Provider<GetAccelerometerData> BuiltInFictitiousFunctionClassFactory;
    private final Provider<DeleteScoringDeviceData> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetGyroscopeData> MyBillsEntityDataFactory;
    private final Provider<SaveGyroscopeData> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<GetRiskTrackerConfig> PlaceComponentResult;
    private final Provider<PageEndAndZip> getAuthRequestContext;
    private final Provider<SaveAccelerometerData> getErrorConfigVersion;
    private final Provider<SaveKeystrokeData> moveToNextValue;

    private RiskTrackerPresenter_Factory(Provider<SaveAccelerometerData> provider, Provider<SaveGyroscopeData> provider2, Provider<SaveKeystrokeData> provider3, Provider<GetAccelerometerData> provider4, Provider<GetGyroscopeData> provider5, Provider<DeleteScoringDeviceData> provider6, Provider<PageEndAndZip> provider7, Provider<GetRiskTrackerConfig> provider8) {
        this.getErrorConfigVersion = provider;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider2;
        this.moveToNextValue = provider3;
        this.BuiltInFictitiousFunctionClassFactory = provider4;
        this.MyBillsEntityDataFactory = provider5;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider6;
        this.getAuthRequestContext = provider7;
        this.PlaceComponentResult = provider8;
    }

    public static RiskTrackerPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<SaveAccelerometerData> provider, Provider<SaveGyroscopeData> provider2, Provider<SaveKeystrokeData> provider3, Provider<GetAccelerometerData> provider4, Provider<GetGyroscopeData> provider5, Provider<DeleteScoringDeviceData> provider6, Provider<PageEndAndZip> provider7, Provider<GetRiskTrackerConfig> provider8) {
        return new RiskTrackerPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new RiskTrackerPresenter(this.getErrorConfigVersion.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.moveToNextValue.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get(), this.PlaceComponentResult.get());
    }
}
