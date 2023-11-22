package id.dana.myprofile.settingconfig;

import dagger.internal.Factory;
import id.dana.domain.deeplink.repository.GenerateLinkRepository;
import id.dana.domain.referral.MyReferralConsultRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ReferralSettingConfigRunner_Factory implements Factory<ReferralSettingConfigRunner> {
    private final Provider<MyReferralConsultRepository> MyBillsEntityDataFactory;
    private final Provider<GenerateLinkRepository> PlaceComponentResult;

    private ReferralSettingConfigRunner_Factory(Provider<GenerateLinkRepository> provider, Provider<MyReferralConsultRepository> provider2) {
        this.PlaceComponentResult = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static ReferralSettingConfigRunner_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<GenerateLinkRepository> provider, Provider<MyReferralConsultRepository> provider2) {
        return new ReferralSettingConfigRunner_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ReferralSettingConfigRunner(this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get());
    }
}
