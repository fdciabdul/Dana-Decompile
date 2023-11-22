package id.dana.data.holdlogin.v2.entity;

import dagger.internal.Factory;
import id.dana.data.holdlogin.v2.entity.source.NewHoldLoginEntityNetwork;
import id.dana.data.holdlogin.v2.entity.source.OldHoldLoginEntityNetwork;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class HoldLoginEntityDataFactory_Factory implements Factory<HoldLoginEntityDataFactory> {
    private final Provider<OldHoldLoginEntityNetwork> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<NewHoldLoginEntityNetwork> getAuthRequestContext;

    private HoldLoginEntityDataFactory_Factory(Provider<OldHoldLoginEntityNetwork> provider, Provider<NewHoldLoginEntityNetwork> provider2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.getAuthRequestContext = provider2;
    }

    public static HoldLoginEntityDataFactory_Factory BuiltInFictitiousFunctionClassFactory(Provider<OldHoldLoginEntityNetwork> provider, Provider<NewHoldLoginEntityNetwork> provider2) {
        return new HoldLoginEntityDataFactory_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new HoldLoginEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get());
    }
}
