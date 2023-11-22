package id.dana.di.modules;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.electronicmoney.tracker.ElectronicMoneyAnalyticTracker;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class ElectronicMoneyAnalyticModule_ProvideElectronicMoneyAnalyticTrackerFactory implements Factory<ElectronicMoneyAnalyticTracker> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;
    private final ElectronicMoneyAnalyticModule KClassImpl$Data$declaredNonStaticMembers$2;

    private ElectronicMoneyAnalyticModule_ProvideElectronicMoneyAnalyticTrackerFactory(ElectronicMoneyAnalyticModule electronicMoneyAnalyticModule, Provider<Context> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = electronicMoneyAnalyticModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ElectronicMoneyAnalyticModule_ProvideElectronicMoneyAnalyticTrackerFactory PlaceComponentResult(ElectronicMoneyAnalyticModule electronicMoneyAnalyticModule, Provider<Context> provider) {
        return new ElectronicMoneyAnalyticModule_ProvideElectronicMoneyAnalyticTrackerFactory(electronicMoneyAnalyticModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ElectronicMoneyAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
