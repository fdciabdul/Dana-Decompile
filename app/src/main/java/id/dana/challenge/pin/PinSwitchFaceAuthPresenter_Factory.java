package id.dana.challenge.pin;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.analytics.tracker.danaviz.DanaVizTrackerImpl;
import id.dana.challenge.pin.AbstractPinContract;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.auth.face.interactor.VerifyFaceAuthentication;
import id.dana.domain.resetpin.interactor.FinishForceDanaVizEnroll;
import id.dana.lib.bio.faceauth.FaceAuthentication;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PinSwitchFaceAuthPresenter_Factory implements Factory<PinSwitchFaceAuthPresenter> {
    private final Provider<DanaVizTrackerImpl> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<FaceAuthentication> MyBillsEntityDataFactory;
    private final Provider<FinishForceDanaVizEnroll> PlaceComponentResult;
    private final Provider<GetUserId> getAuthRequestContext;
    private final Provider<AbstractPinContract.View> moveToNextValue;
    private final Provider<VerifyFaceAuthentication> scheduleImpl;

    private PinSwitchFaceAuthPresenter_Factory(Provider<Context> provider, Provider<VerifyFaceAuthentication> provider2, Provider<GetUserId> provider3, Provider<FaceAuthentication> provider4, Provider<AbstractPinContract.View> provider5, Provider<DanaVizTrackerImpl> provider6, Provider<FinishForceDanaVizEnroll> provider7) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.scheduleImpl = provider2;
        this.getAuthRequestContext = provider3;
        this.MyBillsEntityDataFactory = provider4;
        this.moveToNextValue = provider5;
        this.BuiltInFictitiousFunctionClassFactory = provider6;
        this.PlaceComponentResult = provider7;
    }

    public static PinSwitchFaceAuthPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<Context> provider, Provider<VerifyFaceAuthentication> provider2, Provider<GetUserId> provider3, Provider<FaceAuthentication> provider4, Provider<AbstractPinContract.View> provider5, Provider<DanaVizTrackerImpl> provider6, Provider<FinishForceDanaVizEnroll> provider7) {
        return new PinSwitchFaceAuthPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PinSwitchFaceAuthPresenter(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.scheduleImpl.get(), this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get(), this.moveToNextValue.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get());
    }
}
