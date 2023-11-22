package id.dana.data.cancelsurvey.repository.source.config;

import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitCancelSurveyEntityData_Factory implements Factory<SplitCancelSurveyEntityData> {
    private final Provider<SplitFacade> splitFacadeProvider;

    public SplitCancelSurveyEntityData_Factory(Provider<SplitFacade> provider) {
        this.splitFacadeProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SplitCancelSurveyEntityData get() {
        return newInstance(this.splitFacadeProvider.get());
    }

    public static SplitCancelSurveyEntityData_Factory create(Provider<SplitFacade> provider) {
        return new SplitCancelSurveyEntityData_Factory(provider);
    }

    public static SplitCancelSurveyEntityData newInstance(SplitFacade splitFacade) {
        return new SplitCancelSurveyEntityData(splitFacade);
    }
}
