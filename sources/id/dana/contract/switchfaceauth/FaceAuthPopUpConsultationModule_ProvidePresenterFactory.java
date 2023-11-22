package id.dana.contract.switchfaceauth;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.switchfaceauth.FaceAuthPopUpConsultationContract;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class FaceAuthPopUpConsultationModule_ProvidePresenterFactory implements Factory<FaceAuthPopUpConsultationContract.Presenter> {
    private final Provider<FaceAuthPopUpConsultationPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final FaceAuthPopUpConsultationModule PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FaceAuthPopUpConsultationContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
