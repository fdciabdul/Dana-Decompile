package id.dana.myprofile.settingconfig;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.domain.investment.interactor.GetUserInvestmentSummary;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DanaPlusStarAmSettingConfigRunner_Factory implements Factory<DanaPlusStarAmSettingConfigRunner> {
    private final Provider<Context> PlaceComponentResult;
    private final Provider<GetUserInvestmentSummary> getAuthRequestContext;

    private DanaPlusStarAmSettingConfigRunner_Factory(Provider<Context> provider, Provider<GetUserInvestmentSummary> provider2) {
        this.PlaceComponentResult = provider;
        this.getAuthRequestContext = provider2;
    }

    public static DanaPlusStarAmSettingConfigRunner_Factory BuiltInFictitiousFunctionClassFactory(Provider<Context> provider, Provider<GetUserInvestmentSummary> provider2) {
        return new DanaPlusStarAmSettingConfigRunner_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanaPlusStarAmSettingConfigRunner(this.PlaceComponentResult.get(), this.getAuthRequestContext.get());
    }
}
