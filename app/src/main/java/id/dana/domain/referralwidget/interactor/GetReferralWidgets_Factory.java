package id.dana.domain.referralwidget.interactor;

import dagger.internal.Factory;
import id.dana.domain.referralwidget.ReferralWidgetRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetReferralWidgets_Factory implements Factory<GetReferralWidgets> {
    private final Provider<ReferralWidgetRepository> referralWidgetRepositoryProvider;

    public GetReferralWidgets_Factory(Provider<ReferralWidgetRepository> provider) {
        this.referralWidgetRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetReferralWidgets get() {
        return newInstance(this.referralWidgetRepositoryProvider.get());
    }

    public static GetReferralWidgets_Factory create(Provider<ReferralWidgetRepository> provider) {
        return new GetReferralWidgets_Factory(provider);
    }

    public static GetReferralWidgets newInstance(ReferralWidgetRepository referralWidgetRepository) {
        return new GetReferralWidgets(referralWidgetRepository);
    }
}
