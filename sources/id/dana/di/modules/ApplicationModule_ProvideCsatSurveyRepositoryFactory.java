package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.csatsurvey.repository.CsatSurveyEntityRepository;
import id.dana.domain.csatsurvey.CsatSurveyRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideCsatSurveyRepositoryFactory implements Factory<CsatSurveyRepository> {
    private final Provider<CsatSurveyEntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ApplicationModule PlaceComponentResult;

    private ApplicationModule_ProvideCsatSurveyRepositoryFactory(ApplicationModule applicationModule, Provider<CsatSurveyEntityRepository> provider) {
        this.PlaceComponentResult = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ApplicationModule_ProvideCsatSurveyRepositoryFactory PlaceComponentResult(ApplicationModule applicationModule, Provider<CsatSurveyEntityRepository> provider) {
        return new ApplicationModule_ProvideCsatSurveyRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CsatSurveyRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
