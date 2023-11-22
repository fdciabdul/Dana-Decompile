package id.dana.contract.switchfaceauth;

import dagger.internal.Factory;
import id.dana.contract.switchfaceauth.FaceAuthPopUpConsultationContract;
import id.dana.domain.auth.face.interactor.ClearFaceAuthSuggestionState;
import id.dana.domain.auth.face.interactor.ConsultFaceAuthPopUp;
import id.dana.domain.auth.face.interactor.IsNeedToSuggestFaceAuth;
import id.dana.domain.auth.face.interactor.IsNeverShowFaceAuthSuggestion;
import id.dana.domain.auth.face.interactor.SaveFaceAuthSuggestionState;
import id.dana.domain.auth.face.interactor.SaveNeverShowFaceAuthSuggestion;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class FaceAuthPopUpConsultationPresenter_Factory implements Factory<FaceAuthPopUpConsultationPresenter> {
    private final Provider<ClearFaceAuthSuggestionState> BuiltInFictitiousFunctionClassFactory;
    private final Provider<SaveFaceAuthSuggestionState> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<IsNeedToSuggestFaceAuth> MyBillsEntityDataFactory;
    private final Provider<ConsultFaceAuthPopUp> PlaceComponentResult;
    private final Provider<SaveNeverShowFaceAuthSuggestion> getAuthRequestContext;
    private final Provider<IsNeverShowFaceAuthSuggestion> moveToNextValue;
    private final Provider<FaceAuthPopUpConsultationContract.View> scheduleImpl;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FaceAuthPopUpConsultationPresenter(this.scheduleImpl.get(), this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get(), this.moveToNextValue.get());
    }
}
