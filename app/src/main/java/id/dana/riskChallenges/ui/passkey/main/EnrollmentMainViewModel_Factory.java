package id.dana.riskChallenges.ui.passkey.main;

import dagger.internal.Factory;
import id.dana.analytics.tracker.passkey.PasskeyTrackerImpl;
import id.dana.riskChallenges.data.passkey.source.local.PasskeyPreferenceEntityData;
import id.dana.riskChallenges.domain.passkey.interactor.PasskeyCeremonyFinish;
import id.dana.riskChallenges.domain.passkey.interactor.PasskeyCeremonyStart;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class EnrollmentMainViewModel_Factory implements Factory<EnrollmentMainViewModel> {
    private final Provider<PasskeyTrackerImpl> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<PasskeyCeremonyStart> MyBillsEntityDataFactory;
    private final Provider<PasskeyPreferenceEntityData.Factory> PlaceComponentResult;
    private final Provider<PasskeyCeremonyFinish> getAuthRequestContext;

    private EnrollmentMainViewModel_Factory(Provider<PasskeyCeremonyStart> provider, Provider<PasskeyCeremonyFinish> provider2, Provider<PasskeyTrackerImpl> provider3, Provider<PasskeyPreferenceEntityData.Factory> provider4) {
        this.MyBillsEntityDataFactory = provider;
        this.getAuthRequestContext = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.PlaceComponentResult = provider4;
    }

    public static EnrollmentMainViewModel_Factory getAuthRequestContext(Provider<PasskeyCeremonyStart> provider, Provider<PasskeyCeremonyFinish> provider2, Provider<PasskeyTrackerImpl> provider3, Provider<PasskeyPreferenceEntityData.Factory> provider4) {
        return new EnrollmentMainViewModel_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new EnrollmentMainViewModel(this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get());
    }
}
