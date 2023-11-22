package id.dana.data.cancelsurvey.repository;

import dagger.internal.Factory;
import id.dana.data.cancelsurvey.repository.source.CancelSurveyEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class CancelSurveyEntityRepository_Factory implements Factory<CancelSurveyEntityRepository> {
    private final Provider<CancelSurveyEntityDataFactory> cancelSurveyEntityDataFactoryProvider;
    private final Provider<HoldLoginV1EntityRepository> holdLoginV1EntityRepositoryProvider;

    public CancelSurveyEntityRepository_Factory(Provider<CancelSurveyEntityDataFactory> provider, Provider<HoldLoginV1EntityRepository> provider2) {
        this.cancelSurveyEntityDataFactoryProvider = provider;
        this.holdLoginV1EntityRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final CancelSurveyEntityRepository get() {
        return newInstance(this.cancelSurveyEntityDataFactoryProvider.get(), this.holdLoginV1EntityRepositoryProvider.get());
    }

    public static CancelSurveyEntityRepository_Factory create(Provider<CancelSurveyEntityDataFactory> provider, Provider<HoldLoginV1EntityRepository> provider2) {
        return new CancelSurveyEntityRepository_Factory(provider, provider2);
    }

    public static CancelSurveyEntityRepository newInstance(CancelSurveyEntityDataFactory cancelSurveyEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        return new CancelSurveyEntityRepository(cancelSurveyEntityDataFactory, holdLoginV1EntityRepository);
    }
}
