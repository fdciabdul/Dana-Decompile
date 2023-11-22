package id.dana.electronicmoney.bank.bri;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.domain.electronicmoney.interactor.GetBrizziAccessToken;
import id.dana.electronicmoney.tracker.ElectronicMoneyAnalyticTracker;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class BriBrizziManager_Factory implements Factory<BriBrizziManager> {
    private final Provider<GetBrizziAccessToken> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> PlaceComponentResult;
    private final Provider<ElectronicMoneyAnalyticTracker> getAuthRequestContext;

    private BriBrizziManager_Factory(Provider<Context> provider, Provider<GetBrizziAccessToken> provider2, Provider<ElectronicMoneyAnalyticTracker> provider3) {
        this.PlaceComponentResult = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.getAuthRequestContext = provider3;
    }

    public static BriBrizziManager_Factory getAuthRequestContext(Provider<Context> provider, Provider<GetBrizziAccessToken> provider2, Provider<ElectronicMoneyAnalyticTracker> provider3) {
        return new BriBrizziManager_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        BriBrizziManager briBrizziManager = new BriBrizziManager(this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
        BriBrizziManager_MembersInjector.MyBillsEntityDataFactory(briBrizziManager, this.getAuthRequestContext.get());
        return briBrizziManager;
    }
}
