package id.dana.domain.csatsurvey.interactor;

import dagger.internal.Factory;
import id.dana.domain.csatsurvey.CsatSurveyRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetCsatSurveyCreatedDate_Factory implements Factory<GetCsatSurveyCreatedDate> {
    private final Provider<CsatSurveyRepository> csatSurveyRepositoryProvider;

    public GetCsatSurveyCreatedDate_Factory(Provider<CsatSurveyRepository> provider) {
        this.csatSurveyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetCsatSurveyCreatedDate get() {
        return newInstance(this.csatSurveyRepositoryProvider.get());
    }

    public static GetCsatSurveyCreatedDate_Factory create(Provider<CsatSurveyRepository> provider) {
        return new GetCsatSurveyCreatedDate_Factory(provider);
    }

    public static GetCsatSurveyCreatedDate newInstance(CsatSurveyRepository csatSurveyRepository) {
        return new GetCsatSurveyCreatedDate(csatSurveyRepository);
    }
}
