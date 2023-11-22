package id.dana.cancelsurvey.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.cancelsurvey.presenter.CancelSurveyContract;
import id.dana.cancelsurvey.presenter.CancelSurveyPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CancelSurveyModule_ProvideCancelSurveyPresenterFactory implements Factory<CancelSurveyContract.Presenter> {
    private final CancelSurveyModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<CancelSurveyPresenter> getAuthRequestContext;

    private CancelSurveyModule_ProvideCancelSurveyPresenterFactory(CancelSurveyModule cancelSurveyModule, Provider<CancelSurveyPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = cancelSurveyModule;
        this.getAuthRequestContext = provider;
    }

    public static CancelSurveyModule_ProvideCancelSurveyPresenterFactory getAuthRequestContext(CancelSurveyModule cancelSurveyModule, Provider<CancelSurveyPresenter> provider) {
        return new CancelSurveyModule_ProvideCancelSurveyPresenterFactory(cancelSurveyModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CancelSurveyContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(this.getAuthRequestContext.get()));
    }
}
