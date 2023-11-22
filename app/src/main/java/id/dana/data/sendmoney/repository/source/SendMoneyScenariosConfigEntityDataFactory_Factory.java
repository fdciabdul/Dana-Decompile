package id.dana.data.sendmoney.repository.source;

import dagger.internal.Factory;
import id.dana.data.sendmoney.repository.source.local.DefaultSendMoneyScenariosEntityData;
import id.dana.data.sendmoney.repository.source.split.SplitSendMoneyScenariosEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SendMoneyScenariosConfigEntityDataFactory_Factory implements Factory<SendMoneyScenariosConfigEntityDataFactory> {
    private final Provider<DefaultSendMoneyScenariosEntityData> defaultRecipientScenarioEntityDataProvider;
    private final Provider<SplitSendMoneyScenariosEntityData> splitSendMoneyScenarioEntityDataProvider;

    public SendMoneyScenariosConfigEntityDataFactory_Factory(Provider<SplitSendMoneyScenariosEntityData> provider, Provider<DefaultSendMoneyScenariosEntityData> provider2) {
        this.splitSendMoneyScenarioEntityDataProvider = provider;
        this.defaultRecipientScenarioEntityDataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final SendMoneyScenariosConfigEntityDataFactory get() {
        return newInstance(this.splitSendMoneyScenarioEntityDataProvider.get(), this.defaultRecipientScenarioEntityDataProvider.get());
    }

    public static SendMoneyScenariosConfigEntityDataFactory_Factory create(Provider<SplitSendMoneyScenariosEntityData> provider, Provider<DefaultSendMoneyScenariosEntityData> provider2) {
        return new SendMoneyScenariosConfigEntityDataFactory_Factory(provider, provider2);
    }

    public static SendMoneyScenariosConfigEntityDataFactory newInstance(SplitSendMoneyScenariosEntityData splitSendMoneyScenariosEntityData, DefaultSendMoneyScenariosEntityData defaultSendMoneyScenariosEntityData) {
        return new SendMoneyScenariosConfigEntityDataFactory(splitSendMoneyScenariosEntityData, defaultSendMoneyScenariosEntityData);
    }
}
