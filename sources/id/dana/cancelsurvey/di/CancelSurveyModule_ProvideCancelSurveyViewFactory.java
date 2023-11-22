package id.dana.cancelsurvey.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.cancelsurvey.presenter.CancelSurveyContract;

/* loaded from: classes4.dex */
public final class CancelSurveyModule_ProvideCancelSurveyViewFactory implements Factory<CancelSurveyContract.View> {
    private final CancelSurveyModule BuiltInFictitiousFunctionClassFactory;

    private CancelSurveyModule_ProvideCancelSurveyViewFactory(CancelSurveyModule cancelSurveyModule) {
        this.BuiltInFictitiousFunctionClassFactory = cancelSurveyModule;
    }

    public static CancelSurveyModule_ProvideCancelSurveyViewFactory BuiltInFictitiousFunctionClassFactory(CancelSurveyModule cancelSurveyModule) {
        return new CancelSurveyModule_ProvideCancelSurveyViewFactory(cancelSurveyModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CancelSurveyContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
