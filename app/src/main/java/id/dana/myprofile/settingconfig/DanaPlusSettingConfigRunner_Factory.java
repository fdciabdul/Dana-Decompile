package id.dana.myprofile.settingconfig;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.domain.investment.interactor.GetUserInvestmentSummary;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DanaPlusSettingConfigRunner_Factory implements Factory<DanaPlusSettingConfigRunner> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetUserInvestmentSummary> PlaceComponentResult;

    private DanaPlusSettingConfigRunner_Factory(Provider<Context> provider, Provider<GetUserInvestmentSummary> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.PlaceComponentResult = provider2;
    }

    public static DanaPlusSettingConfigRunner_Factory PlaceComponentResult(Provider<Context> provider, Provider<GetUserInvestmentSummary> provider2) {
        return new DanaPlusSettingConfigRunner_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanaPlusSettingConfigRunner(this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get());
    }
}
