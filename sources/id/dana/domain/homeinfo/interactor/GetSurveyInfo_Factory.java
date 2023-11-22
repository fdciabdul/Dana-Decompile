package id.dana.domain.homeinfo.interactor;

import dagger.internal.Factory;
import id.dana.domain.homeinfo.repository.HomeOmniRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetSurveyInfo_Factory implements Factory<GetSurveyInfo> {
    private final Provider<HomeOmniRepository> homeOmniRepositoryProvider;

    public GetSurveyInfo_Factory(Provider<HomeOmniRepository> provider) {
        this.homeOmniRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetSurveyInfo get() {
        return newInstance(this.homeOmniRepositoryProvider.get());
    }

    public static GetSurveyInfo_Factory create(Provider<HomeOmniRepository> provider) {
        return new GetSurveyInfo_Factory(provider);
    }

    public static GetSurveyInfo newInstance(HomeOmniRepository homeOmniRepository) {
        return new GetSurveyInfo(homeOmniRepository);
    }
}
