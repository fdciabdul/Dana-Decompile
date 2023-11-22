package id.dana.data.senddigitalmoney.repository;

import dagger.internal.Factory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.senddigitalmoney.repository.mapper.CardPrefixQueryResultMapper;
import id.dana.data.senddigitalmoney.repository.source.SendDigitalMoneyEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SendDigitalMoneyEntityRepository_Factory implements Factory<SendDigitalMoneyEntityRepository> {
    private final Provider<CardPrefixQueryResultMapper> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<HoldLoginV1EntityRepository> MyBillsEntityDataFactory;
    private final Provider<SendDigitalMoneyEntityDataFactory> PlaceComponentResult;

    private SendDigitalMoneyEntityRepository_Factory(Provider<SendDigitalMoneyEntityDataFactory> provider, Provider<CardPrefixQueryResultMapper> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        this.PlaceComponentResult = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.MyBillsEntityDataFactory = provider3;
    }

    public static SendDigitalMoneyEntityRepository_Factory BuiltInFictitiousFunctionClassFactory(Provider<SendDigitalMoneyEntityDataFactory> provider, Provider<CardPrefixQueryResultMapper> provider2, Provider<HoldLoginV1EntityRepository> provider3) {
        return new SendDigitalMoneyEntityRepository_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SendDigitalMoneyEntityRepository(this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get());
    }
}
