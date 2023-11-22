package id.dana.biometric.presentation;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class RiskClient_Factory implements Factory<RiskClient> {
    private final Provider<Context> MyBillsEntityDataFactory;
    private final Provider<RiskTrackerPresenter> PlaceComponentResult;

    private RiskClient_Factory(Provider<Context> provider, Provider<RiskTrackerPresenter> provider2) {
        this.MyBillsEntityDataFactory = provider;
        this.PlaceComponentResult = provider2;
    }

    public static RiskClient_Factory MyBillsEntityDataFactory(Provider<Context> provider, Provider<RiskTrackerPresenter> provider2) {
        return new RiskClient_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        RiskClient riskClient = new RiskClient(this.MyBillsEntityDataFactory.get());
        riskClient.trackerPresenter = this.PlaceComponentResult.get();
        return riskClient;
    }
}
