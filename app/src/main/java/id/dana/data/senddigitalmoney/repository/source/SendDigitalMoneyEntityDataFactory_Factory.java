package id.dana.data.senddigitalmoney.repository.source;

import dagger.internal.Factory;
import id.dana.data.senddigitalmoney.repository.source.network.NetworkDigitalMoneyEntityData;
import id.dana.data.senddigitalmoney.repository.source.split.SplitSendDigitalMoneyEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SendDigitalMoneyEntityDataFactory_Factory implements Factory<SendDigitalMoneyEntityDataFactory> {
    private final Provider<SplitSendDigitalMoneyEntityData> BuiltInFictitiousFunctionClassFactory;
    private final Provider<NetworkDigitalMoneyEntityData> PlaceComponentResult;

    private SendDigitalMoneyEntityDataFactory_Factory(Provider<NetworkDigitalMoneyEntityData> provider, Provider<SplitSendDigitalMoneyEntityData> provider2) {
        this.PlaceComponentResult = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
    }

    public static SendDigitalMoneyEntityDataFactory_Factory MyBillsEntityDataFactory(Provider<NetworkDigitalMoneyEntityData> provider, Provider<SplitSendDigitalMoneyEntityData> provider2) {
        return new SendDigitalMoneyEntityDataFactory_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SendDigitalMoneyEntityDataFactory(this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
