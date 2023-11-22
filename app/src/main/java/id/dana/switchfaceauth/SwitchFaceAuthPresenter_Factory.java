package id.dana.switchfaceauth;

import dagger.internal.Factory;
import id.dana.analytics.tracker.danaviz.DanaVizTrackerImpl;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.auth.face.interactor.SwitchFaceAuthentication;
import id.dana.domain.resetpin.interactor.FinishForceDanaVizEnroll;
import id.dana.lib.bio.faceauth.FaceAuthentication;
import id.dana.switchfaceauth.SwitchFaceAuthContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SwitchFaceAuthPresenter_Factory implements Factory<SwitchFaceAuthPresenter> {
    private final Provider<GetUserId> BuiltInFictitiousFunctionClassFactory;
    private final Provider<FinishForceDanaVizEnroll> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<FaceAuthentication> MyBillsEntityDataFactory;
    private final Provider<SwitchFaceAuthentication> PlaceComponentResult;
    private final Provider<DanaVizTrackerImpl> getAuthRequestContext;
    private final Provider<SwitchFaceAuthContract.View> lookAheadTest;

    private SwitchFaceAuthPresenter_Factory(Provider<SwitchFaceAuthContract.View> provider, Provider<SwitchFaceAuthentication> provider2, Provider<GetUserId> provider3, Provider<FaceAuthentication> provider4, Provider<DanaVizTrackerImpl> provider5, Provider<FinishForceDanaVizEnroll> provider6) {
        this.lookAheadTest = provider;
        this.PlaceComponentResult = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
        this.MyBillsEntityDataFactory = provider4;
        this.getAuthRequestContext = provider5;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider6;
    }

    public static SwitchFaceAuthPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<SwitchFaceAuthContract.View> provider, Provider<SwitchFaceAuthentication> provider2, Provider<GetUserId> provider3, Provider<FaceAuthentication> provider4, Provider<DanaVizTrackerImpl> provider5, Provider<FinishForceDanaVizEnroll> provider6) {
        return new SwitchFaceAuthPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SwitchFaceAuthPresenter(this.lookAheadTest.get(), this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
