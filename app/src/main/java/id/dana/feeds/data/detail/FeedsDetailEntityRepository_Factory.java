package id.dana.feeds.data.detail;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.feeds.data.detail.source.FeedsDetailDataFactory;
import id.dana.feeds.data.mapper.ContactDeviceNameMapper;
import id.dana.feeds.data.storage.preferences.SocialPreferencesDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FeedsDetailEntityRepository_Factory implements Factory<FeedsDetailEntityRepository> {
    private final Provider<FeedsDetailDataFactory> BuiltInFictitiousFunctionClassFactory;
    private final Provider<HoldLoginV1EntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<SocialPreferencesDataFactory> MyBillsEntityDataFactory;
    private final Provider<ContactDeviceNameMapper> PlaceComponentResult;
    private final Provider<AccountEntityDataFactory> getAuthRequestContext;

    private FeedsDetailEntityRepository_Factory(Provider<FeedsDetailDataFactory> provider, Provider<AccountEntityDataFactory> provider2, Provider<ContactDeviceNameMapper> provider3, Provider<SocialPreferencesDataFactory> provider4, Provider<HoldLoginV1EntityRepository> provider5) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.getAuthRequestContext = provider2;
        this.PlaceComponentResult = provider3;
        this.MyBillsEntityDataFactory = provider4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider5;
    }

    public static FeedsDetailEntityRepository_Factory getAuthRequestContext(Provider<FeedsDetailDataFactory> provider, Provider<AccountEntityDataFactory> provider2, Provider<ContactDeviceNameMapper> provider3, Provider<SocialPreferencesDataFactory> provider4, Provider<HoldLoginV1EntityRepository> provider5) {
        return new FeedsDetailEntityRepository_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeedsDetailEntityRepository(DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
