package id.dana.cashier.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class TopUpConsultModelMapper_Factory implements Factory<TopUpConsultModelMapper> {
    private final Provider<CashierPayChannelModelsMapper> KClassImpl$Data$declaredNonStaticMembers$2;

    private TopUpConsultModelMapper_Factory(Provider<CashierPayChannelModelsMapper> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static TopUpConsultModelMapper_Factory BuiltInFictitiousFunctionClassFactory(Provider<CashierPayChannelModelsMapper> provider) {
        return new TopUpConsultModelMapper_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new TopUpConsultModelMapper(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
