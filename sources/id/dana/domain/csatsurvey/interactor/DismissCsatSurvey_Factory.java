package id.dana.domain.csatsurvey.interactor;

import dagger.internal.Factory;
import id.dana.domain.csatsurvey.CsatSurveyRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DismissCsatSurvey_Factory implements Factory<DismissCsatSurvey> {
    private final Provider<CsatSurveyRepository> csatSurveyRepositoryProvider;

    public DismissCsatSurvey_Factory(Provider<CsatSurveyRepository> provider) {
        this.csatSurveyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final DismissCsatSurvey get() {
        return newInstance(this.csatSurveyRepositoryProvider.get());
    }

    public static DismissCsatSurvey_Factory create(Provider<CsatSurveyRepository> provider) {
        return new DismissCsatSurvey_Factory(provider);
    }

    public static DismissCsatSurvey newInstance(CsatSurveyRepository csatSurveyRepository) {
        return new DismissCsatSurvey(csatSurveyRepository);
    }
}
