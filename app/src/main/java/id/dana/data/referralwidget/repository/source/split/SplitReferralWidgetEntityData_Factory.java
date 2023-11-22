package id.dana.data.referralwidget.repository.source.split;

import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitReferralWidgetEntityData_Factory implements Factory<SplitReferralWidgetEntityData> {
    private final Provider<SplitFacade> splitFacadeProvider;

    public SplitReferralWidgetEntityData_Factory(Provider<SplitFacade> provider) {
        this.splitFacadeProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SplitReferralWidgetEntityData get() {
        return newInstance(this.splitFacadeProvider.get());
    }

    public static SplitReferralWidgetEntityData_Factory create(Provider<SplitFacade> provider) {
        return new SplitReferralWidgetEntityData_Factory(provider);
    }

    public static SplitReferralWidgetEntityData newInstance(SplitFacade splitFacade) {
        return new SplitReferralWidgetEntityData(splitFacade);
    }
}
