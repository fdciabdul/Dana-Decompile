package id.dana.cancelsurvey.presenter;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.cancelsurvey.presenter.CancelSurveyContract;
import id.dana.domain.cancelsurvey.interactor.ConsultCancelSurveyReason;
import id.dana.domain.cancelsurvey.interactor.SubmitCancelSurveyReason;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CancelSurveyPresenter_Factory implements Factory<CancelSurveyPresenter> {
    private final Provider<SubmitCancelSurveyReason> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ConsultCancelSurveyReason> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<CancelSurveyContract.View> MyBillsEntityDataFactory;
    private final Provider<Context> getAuthRequestContext;

    private CancelSurveyPresenter_Factory(Provider<Context> provider, Provider<CancelSurveyContract.View> provider2, Provider<ConsultCancelSurveyReason> provider3, Provider<SubmitCancelSurveyReason> provider4) {
        this.getAuthRequestContext = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.BuiltInFictitiousFunctionClassFactory = provider4;
    }

    public static CancelSurveyPresenter_Factory getAuthRequestContext(Provider<Context> provider, Provider<CancelSurveyContract.View> provider2, Provider<ConsultCancelSurveyReason> provider3, Provider<SubmitCancelSurveyReason> provider4) {
        return new CancelSurveyPresenter_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CancelSurveyPresenter(this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
