package id.dana.myprofile.settingconfig;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.domain.investment.interactor.GetUserInvestmentSummary;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GoldSettingConfigRunner_Factory implements Factory<GoldSettingConfigRunner> {
    private final Provider<GetUserInvestmentSummary> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> MyBillsEntityDataFactory;

    private GoldSettingConfigRunner_Factory(Provider<Context> provider, Provider<GetUserInvestmentSummary> provider2) {
        this.MyBillsEntityDataFactory = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
    }

    public static GoldSettingConfigRunner_Factory MyBillsEntityDataFactory(Provider<Context> provider, Provider<GetUserInvestmentSummary> provider2) {
        return new GoldSettingConfigRunner_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GoldSettingConfigRunner(this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
