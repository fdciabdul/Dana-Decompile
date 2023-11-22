package id.dana.contract.deeplink.path;

import dagger.internal.Factory;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.domain.familyaccount.interactor.CheckConsultFamilyAccount;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class FeatureFamilyAccount_Factory implements Factory<FeatureFamilyAccount> {
    private final Provider<DynamicUrlWrapper> MyBillsEntityDataFactory;
    private final Provider<CheckConsultFamilyAccount> getAuthRequestContext;

    private FeatureFamilyAccount_Factory(Provider<CheckConsultFamilyAccount> provider, Provider<DynamicUrlWrapper> provider2) {
        this.getAuthRequestContext = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static FeatureFamilyAccount_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<CheckConsultFamilyAccount> provider, Provider<DynamicUrlWrapper> provider2) {
        return new FeatureFamilyAccount_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeatureFamilyAccount(this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get());
    }
}
