package id.dana.sendmoney.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SendMoneyConfirmModelMapper_Factory implements Factory<SendMoneyConfirmModelMapper> {
    private final Provider<AttributesModelMapper> MyBillsEntityDataFactory;
    private final Provider<PayMethodRiskMapper> getAuthRequestContext;

    private SendMoneyConfirmModelMapper_Factory(Provider<PayMethodRiskMapper> provider, Provider<AttributesModelMapper> provider2) {
        this.getAuthRequestContext = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static SendMoneyConfirmModelMapper_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<PayMethodRiskMapper> provider, Provider<AttributesModelMapper> provider2) {
        return new SendMoneyConfirmModelMapper_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SendMoneyConfirmModelMapper(this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get());
    }
}
