package id.dana.data.referralconfig.repository.source.split;

import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitReferralConfigEntityData_Factory implements Factory<SplitReferralConfigEntityData> {
    private final Provider<SplitFacade> splitFacadeProvider;

    public SplitReferralConfigEntityData_Factory(Provider<SplitFacade> provider) {
        this.splitFacadeProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SplitReferralConfigEntityData get() {
        return newInstance(this.splitFacadeProvider.get());
    }

    public static SplitReferralConfigEntityData_Factory create(Provider<SplitFacade> provider) {
        return new SplitReferralConfigEntityData_Factory(provider);
    }

    public static SplitReferralConfigEntityData newInstance(SplitFacade splitFacade) {
        return new SplitReferralConfigEntityData(splitFacade);
    }
}
