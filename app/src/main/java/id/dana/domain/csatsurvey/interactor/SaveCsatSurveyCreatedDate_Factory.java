package id.dana.domain.csatsurvey.interactor;

import dagger.internal.Factory;
import id.dana.domain.csatsurvey.CsatSurveyRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveCsatSurveyCreatedDate_Factory implements Factory<SaveCsatSurveyCreatedDate> {
    private final Provider<CsatSurveyRepository> csatSurveyRepositoryProvider;

    public SaveCsatSurveyCreatedDate_Factory(Provider<CsatSurveyRepository> provider) {
        this.csatSurveyRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveCsatSurveyCreatedDate get() {
        return newInstance(this.csatSurveyRepositoryProvider.get());
    }

    public static SaveCsatSurveyCreatedDate_Factory create(Provider<CsatSurveyRepository> provider) {
        return new SaveCsatSurveyCreatedDate_Factory(provider);
    }

    public static SaveCsatSurveyCreatedDate newInstance(CsatSurveyRepository csatSurveyRepository) {
        return new SaveCsatSurveyCreatedDate(csatSurveyRepository);
    }
}
