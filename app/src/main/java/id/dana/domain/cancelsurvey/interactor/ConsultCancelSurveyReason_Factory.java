package id.dana.domain.cancelsurvey.interactor;

import dagger.internal.Factory;
import id.dana.domain.cancelsurvey.repository.CancelSurveyRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ConsultCancelSurveyReason_Factory implements Factory<ConsultCancelSurveyReason> {
    private final Provider<CancelSurveyRepository> repositoryProvider;

    public ConsultCancelSurveyReason_Factory(Provider<CancelSurveyRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ConsultCancelSurveyReason get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static ConsultCancelSurveyReason_Factory create(Provider<CancelSurveyRepository> provider) {
        return new ConsultCancelSurveyReason_Factory(provider);
    }

    public static ConsultCancelSurveyReason newInstance(CancelSurveyRepository cancelSurveyRepository) {
        return new ConsultCancelSurveyReason(cancelSurveyRepository);
    }
}
