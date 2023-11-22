package id.dana.challenge.pinwithface;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.analytics.tracker.danaviz.DanaVizTrackerImpl;
import id.dana.biometric.presentation.RiskTracker;
import id.dana.challenge.pinwithface.ChallengePinWithFaceContract;
import id.dana.domain.resetpin.interactor.ConsultForceDanaVizEnrollAfterLogin;
import id.dana.domain.resetpin.interactor.GetResetAndChangePinNativeEntryConfig;
import id.dana.domain.resetpin.interactor.SaveDanaVizPromptAfterResetPin;
import id.dana.lib.bio.faceauth.FaceAuthentication;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ChallengePinWithFacePresenter_Factory implements Factory<ChallengePinWithFacePresenter> {
    private final Provider<RiskTracker> BuiltInFictitiousFunctionClassFactory;
    private final Provider<FaceAuthentication> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetResetAndChangePinNativeEntryConfig> MyBillsEntityDataFactory;
    private final Provider<DanaVizTrackerImpl> PlaceComponentResult;
    private final Provider<ConsultForceDanaVizEnrollAfterLogin> getAuthRequestContext;
    private final Provider<ChallengePinWithFaceContract.View> lookAheadTest;
    private final Provider<SaveDanaVizPromptAfterResetPin> scheduleImpl;

    private ChallengePinWithFacePresenter_Factory(Provider<FaceAuthentication> provider, Provider<ChallengePinWithFaceContract.View> provider2, Provider<RiskTracker> provider3, Provider<DanaVizTrackerImpl> provider4, Provider<GetResetAndChangePinNativeEntryConfig> provider5, Provider<SaveDanaVizPromptAfterResetPin> provider6, Provider<ConsultForceDanaVizEnrollAfterLogin> provider7) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.lookAheadTest = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
        this.PlaceComponentResult = provider4;
        this.MyBillsEntityDataFactory = provider5;
        this.scheduleImpl = provider6;
        this.getAuthRequestContext = provider7;
    }

    public static ChallengePinWithFacePresenter_Factory MyBillsEntityDataFactory(Provider<FaceAuthentication> provider, Provider<ChallengePinWithFaceContract.View> provider2, Provider<RiskTracker> provider3, Provider<DanaVizTrackerImpl> provider4, Provider<GetResetAndChangePinNativeEntryConfig> provider5, Provider<SaveDanaVizPromptAfterResetPin> provider6, Provider<ConsultForceDanaVizEnrollAfterLogin> provider7) {
        return new ChallengePinWithFacePresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ChallengePinWithFacePresenter(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.lookAheadTest.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get(), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
    }
}
