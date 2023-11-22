package id.dana.sendmoney.data.repository.globalsend;

import dagger.internal.Factory;
import id.dana.data.card.repository.CardCredentialEntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.sendmoney.data.repository.globalsend.source.GlobalSendEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GlobalSendEntityRepository_Factory implements Factory<GlobalSendEntityRepository> {
    private final Provider<GlobalSendEntityDataFactory> BuiltInFictitiousFunctionClassFactory;
    private final Provider<CardCredentialEntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<HoldLoginV1EntityRepository> MyBillsEntityDataFactory;

    private GlobalSendEntityRepository_Factory(Provider<GlobalSendEntityDataFactory> provider, Provider<HoldLoginV1EntityRepository> provider2, Provider<CardCredentialEntityRepository> provider3) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
    }

    public static GlobalSendEntityRepository_Factory PlaceComponentResult(Provider<GlobalSendEntityDataFactory> provider, Provider<HoldLoginV1EntityRepository> provider2, Provider<CardCredentialEntityRepository> provider3) {
        return new GlobalSendEntityRepository_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GlobalSendEntityRepository(this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
