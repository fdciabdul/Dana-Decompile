package id.dana.sendmoney.data.repository.core;

import dagger.internal.Factory;
import id.dana.sendmoney.data.repository.core.source.SendMoneyCoreEntityData;
import id.dana.sendmoney.data.repository.core.source.split.SplitSendMoneyCoreEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SendMoneyCoreEntityRepository_Factory implements Factory<SendMoneyCoreEntityRepository> {
    private final Provider<SendMoneyCoreEntityData> MyBillsEntityDataFactory;
    private final Provider<SplitSendMoneyCoreEntityData> getAuthRequestContext;

    private SendMoneyCoreEntityRepository_Factory(Provider<SplitSendMoneyCoreEntityData> provider, Provider<SendMoneyCoreEntityData> provider2) {
        this.getAuthRequestContext = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static SendMoneyCoreEntityRepository_Factory BuiltInFictitiousFunctionClassFactory(Provider<SplitSendMoneyCoreEntityData> provider, Provider<SendMoneyCoreEntityData> provider2) {
        return new SendMoneyCoreEntityRepository_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SendMoneyCoreEntityRepository(this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get());
    }
}
