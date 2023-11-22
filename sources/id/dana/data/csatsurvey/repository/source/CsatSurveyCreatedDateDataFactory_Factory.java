package id.dana.data.csatsurvey.repository.source;

import dagger.internal.Factory;
import id.dana.data.csatsurvey.repository.source.local.CsatSurveyCreatedDatePreference;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class CsatSurveyCreatedDateDataFactory_Factory implements Factory<CsatSurveyCreatedDateDataFactory> {
    private final Provider<CsatSurveyCreatedDatePreference> BuiltInFictitiousFunctionClassFactory;

    private CsatSurveyCreatedDateDataFactory_Factory(Provider<CsatSurveyCreatedDatePreference> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static CsatSurveyCreatedDateDataFactory_Factory getAuthRequestContext(Provider<CsatSurveyCreatedDatePreference> provider) {
        return new CsatSurveyCreatedDateDataFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CsatSurveyCreatedDateDataFactory(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
