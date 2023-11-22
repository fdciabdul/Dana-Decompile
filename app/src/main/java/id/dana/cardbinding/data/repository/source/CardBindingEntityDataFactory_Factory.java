package id.dana.cardbinding.data.repository.source;

import dagger.internal.Factory;
import id.dana.cardbinding.data.repository.source.local.MLKitCardBindingEntityData;
import id.dana.cardbinding.data.repository.source.network.NetworkCardBindingEntityData;
import id.dana.cardbinding.data.repository.source.split.SplitCardBindingEntityData;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class CardBindingEntityDataFactory_Factory implements Factory<CardBindingEntityDataFactory> {
    private final Provider<MLKitCardBindingEntityData> BuiltInFictitiousFunctionClassFactory;
    private final Provider<NetworkCardBindingEntityData> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<SplitCardBindingEntityData> MyBillsEntityDataFactory;

    private CardBindingEntityDataFactory_Factory(Provider<MLKitCardBindingEntityData> provider, Provider<NetworkCardBindingEntityData> provider2, Provider<SplitCardBindingEntityData> provider3) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.MyBillsEntityDataFactory = provider3;
    }

    public static CardBindingEntityDataFactory_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<MLKitCardBindingEntityData> provider, Provider<NetworkCardBindingEntityData> provider2, Provider<SplitCardBindingEntityData> provider3) {
        return new CardBindingEntityDataFactory_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CardBindingEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get());
    }
}
