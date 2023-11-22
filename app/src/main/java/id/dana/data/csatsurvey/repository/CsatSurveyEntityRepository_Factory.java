package id.dana.data.csatsurvey.repository;

import dagger.internal.Factory;
import id.dana.data.csatsurvey.repository.source.CsatSurveyCreatedDateDataFactory;
import id.dana.data.csatsurvey.repository.source.DismissCsatSurveyDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class CsatSurveyEntityRepository_Factory implements Factory<CsatSurveyEntityRepository> {
    private final Provider<DismissCsatSurveyDataFactory> BuiltInFictitiousFunctionClassFactory;
    private final Provider<CsatSurveyCreatedDateDataFactory> KClassImpl$Data$declaredNonStaticMembers$2;

    private CsatSurveyEntityRepository_Factory(Provider<CsatSurveyCreatedDateDataFactory> provider, Provider<DismissCsatSurveyDataFactory> provider2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
    }

    public static CsatSurveyEntityRepository_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<CsatSurveyCreatedDateDataFactory> provider, Provider<DismissCsatSurveyDataFactory> provider2) {
        return new CsatSurveyEntityRepository_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CsatSurveyEntityRepository(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
