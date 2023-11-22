package id.dana.data.electronicmoney;

import dagger.internal.Factory;
import id.dana.data.electronicmoney.mock.MockElectronicmoneyEntityData;
import id.dana.data.electronicmoney.network.NetworkElectronicMoneyEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ElectronicmoneyEntityDataFactory_Factory implements Factory<ElectronicmoneyEntityDataFactory> {
    private final Provider<MockElectronicmoneyEntityData> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<NetworkElectronicMoneyEntityData> MyBillsEntityDataFactory;

    private ElectronicmoneyEntityDataFactory_Factory(Provider<NetworkElectronicMoneyEntityData> provider, Provider<MockElectronicmoneyEntityData> provider2) {
        this.MyBillsEntityDataFactory = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
    }

    public static ElectronicmoneyEntityDataFactory_Factory BuiltInFictitiousFunctionClassFactory(Provider<NetworkElectronicMoneyEntityData> provider, Provider<MockElectronicmoneyEntityData> provider2) {
        return new ElectronicmoneyEntityDataFactory_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ElectronicmoneyEntityDataFactory(this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
