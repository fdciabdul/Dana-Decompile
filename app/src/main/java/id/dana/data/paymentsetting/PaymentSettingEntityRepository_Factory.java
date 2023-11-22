package id.dana.data.paymentsetting;

import dagger.internal.Factory;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.config.source.split.SplitConfigEntityData;
import id.dana.data.paymentsetting.repository.source.PaymentSettingPreferenceEntityDataFactory;
import id.dana.data.userconfig.repository.UserConfigRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PaymentSettingEntityRepository_Factory implements Factory<PaymentSettingEntityRepository> {
    private final Provider<AccountEntityDataFactory> BuiltInFictitiousFunctionClassFactory;
    private final Provider<PaymentSettingPreferenceEntityDataFactory> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<UserConfigRepository> MyBillsEntityDataFactory;
    private final Provider<SplitConfigEntityData> getAuthRequestContext;

    private PaymentSettingEntityRepository_Factory(Provider<PaymentSettingPreferenceEntityDataFactory> provider, Provider<AccountEntityDataFactory> provider2, Provider<SplitConfigEntityData> provider3, Provider<UserConfigRepository> provider4) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.getAuthRequestContext = provider3;
        this.MyBillsEntityDataFactory = provider4;
    }

    public static PaymentSettingEntityRepository_Factory PlaceComponentResult(Provider<PaymentSettingPreferenceEntityDataFactory> provider, Provider<AccountEntityDataFactory> provider2, Provider<SplitConfigEntityData> provider3, Provider<UserConfigRepository> provider4) {
        return new PaymentSettingEntityRepository_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PaymentSettingEntityRepository(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get());
    }
}
