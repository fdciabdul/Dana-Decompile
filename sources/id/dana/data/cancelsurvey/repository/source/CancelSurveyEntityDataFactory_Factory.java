package id.dana.data.cancelsurvey.repository.source;

import dagger.internal.Factory;
import id.dana.data.cancelsurvey.repository.source.config.SplitCancelSurveyEntityData;
import id.dana.data.cancelsurvey.repository.source.network.NetworkCancelSurveyEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class CancelSurveyEntityDataFactory_Factory implements Factory<CancelSurveyEntityDataFactory> {
    private final Provider<NetworkCancelSurveyEntityData> networkCancelSurveyEntityDataProvider;
    private final Provider<SplitCancelSurveyEntityData> splitCancelSurveyEntityDataProvider;

    public CancelSurveyEntityDataFactory_Factory(Provider<NetworkCancelSurveyEntityData> provider, Provider<SplitCancelSurveyEntityData> provider2) {
        this.networkCancelSurveyEntityDataProvider = provider;
        this.splitCancelSurveyEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final CancelSurveyEntityDataFactory get() {
        return newInstance(this.networkCancelSurveyEntityDataProvider.get(), this.splitCancelSurveyEntityDataProvider.get());
    }

    public static CancelSurveyEntityDataFactory_Factory create(Provider<NetworkCancelSurveyEntityData> provider, Provider<SplitCancelSurveyEntityData> provider2) {
        return new CancelSurveyEntityDataFactory_Factory(provider, provider2);
    }

    public static CancelSurveyEntityDataFactory newInstance(NetworkCancelSurveyEntityData networkCancelSurveyEntityData, SplitCancelSurveyEntityData splitCancelSurveyEntityData) {
        return new CancelSurveyEntityDataFactory(networkCancelSurveyEntityData, splitCancelSurveyEntityData);
    }
}
