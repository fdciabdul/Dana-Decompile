package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.cancelsurvey.repository.CancelSurveyEntityRepository;
import id.dana.domain.cancelsurvey.repository.CancelSurveyRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideCancelSurveyEntityRepositoryFactory implements Factory<CancelSurveyRepository> {
    private final Provider<CancelSurveyEntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ApplicationModule getAuthRequestContext;

    private ApplicationModule_ProvideCancelSurveyEntityRepositoryFactory(ApplicationModule applicationModule, Provider<CancelSurveyEntityRepository> provider) {
        this.getAuthRequestContext = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ApplicationModule_ProvideCancelSurveyEntityRepositoryFactory KClassImpl$Data$declaredNonStaticMembers$2(ApplicationModule applicationModule, Provider<CancelSurveyEntityRepository> provider) {
        return new ApplicationModule_ProvideCancelSurveyEntityRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CancelSurveyRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
