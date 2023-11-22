package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.analytics.tracker.danaviz.DanaVizTrackerImpl;
import id.dana.danah5.faceverificationenablement.FaceAuthenticationManager;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.auth.face.interactor.SwitchFaceAuthentication;
import id.dana.domain.resetpin.interactor.FinishForceDanaVizEnroll;
import id.dana.domain.transferaccount.interactor.DeletionChangeNumber;
import id.dana.domain.transferaccount.interactor.SaveTransferAccountToken;
import id.dana.lib.bio.faceauth.FaceAuthentication;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GContainerModule_ProvideFaceVerificationEnablementManagerFactory implements Factory<FaceAuthenticationManager> {
    private final Provider<DanaVizTrackerImpl> BuiltInFictitiousFunctionClassFactory;
    private final Provider<DeletionChangeNumber> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<FinishForceDanaVizEnroll> MyBillsEntityDataFactory;
    private final GContainerModule NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<FaceAuthentication> PlaceComponentResult;
    private final Provider<GetUserId> getAuthRequestContext;
    private final Provider<SaveTransferAccountToken> getErrorConfigVersion;
    private final Provider<SwitchFaceAuthentication> lookAheadTest;

    private GContainerModule_ProvideFaceVerificationEnablementManagerFactory(GContainerModule gContainerModule, Provider<SwitchFaceAuthentication> provider, Provider<GetUserId> provider2, Provider<FaceAuthentication> provider3, Provider<DanaVizTrackerImpl> provider4, Provider<SaveTransferAccountToken> provider5, Provider<DeletionChangeNumber> provider6, Provider<FinishForceDanaVizEnroll> provider7) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = gContainerModule;
        this.lookAheadTest = provider;
        this.getAuthRequestContext = provider2;
        this.PlaceComponentResult = provider3;
        this.BuiltInFictitiousFunctionClassFactory = provider4;
        this.getErrorConfigVersion = provider5;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider6;
        this.MyBillsEntityDataFactory = provider7;
    }

    public static GContainerModule_ProvideFaceVerificationEnablementManagerFactory PlaceComponentResult(GContainerModule gContainerModule, Provider<SwitchFaceAuthentication> provider, Provider<GetUserId> provider2, Provider<FaceAuthentication> provider3, Provider<DanaVizTrackerImpl> provider4, Provider<SaveTransferAccountToken> provider5, Provider<DeletionChangeNumber> provider6, Provider<FinishForceDanaVizEnroll> provider7) {
        return new GContainerModule_ProvideFaceVerificationEnablementManagerFactory(gContainerModule, provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FaceAuthenticationManager) Preconditions.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult(this.lookAheadTest.get(), this.getAuthRequestContext.get(), this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.getErrorConfigVersion.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get()));
    }
}
