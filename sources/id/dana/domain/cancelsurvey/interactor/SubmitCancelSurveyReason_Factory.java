package id.dana.domain.cancelsurvey.interactor;

import dagger.internal.Factory;
import id.dana.domain.cancelsurvey.repository.CancelSurveyRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SubmitCancelSurveyReason_Factory implements Factory<SubmitCancelSurveyReason> {
    private final Provider<CancelSurveyRepository> repositoryProvider;

    public SubmitCancelSurveyReason_Factory(Provider<CancelSurveyRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SubmitCancelSurveyReason get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static SubmitCancelSurveyReason_Factory create(Provider<CancelSurveyRepository> provider) {
        return new SubmitCancelSurveyReason_Factory(provider);
    }

    public static SubmitCancelSurveyReason newInstance(CancelSurveyRepository cancelSurveyRepository) {
        return new SubmitCancelSurveyReason(cancelSurveyRepository);
    }
}
