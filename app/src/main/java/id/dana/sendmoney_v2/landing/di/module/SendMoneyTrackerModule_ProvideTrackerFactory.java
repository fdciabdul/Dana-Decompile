package id.dana.sendmoney_v2.landing.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyMixpanelTracker;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SendMoneyTrackerModule_ProvideTrackerFactory implements Factory<SendMoneyAnalyticTracker> {
    private final SendMoneyTrackerModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<SendMoneyMixpanelTracker> PlaceComponentResult;

    private SendMoneyTrackerModule_ProvideTrackerFactory(SendMoneyTrackerModule sendMoneyTrackerModule, Provider<SendMoneyMixpanelTracker> provider) {
        this.BuiltInFictitiousFunctionClassFactory = sendMoneyTrackerModule;
        this.PlaceComponentResult = provider;
    }

    public static SendMoneyTrackerModule_ProvideTrackerFactory MyBillsEntityDataFactory(SendMoneyTrackerModule sendMoneyTrackerModule, Provider<SendMoneyMixpanelTracker> provider) {
        return new SendMoneyTrackerModule_ProvideTrackerFactory(sendMoneyTrackerModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SendMoneyAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this.PlaceComponentResult.get()));
    }
}
