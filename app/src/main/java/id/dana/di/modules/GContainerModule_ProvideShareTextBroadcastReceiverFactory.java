package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.risk.riskevent.SendRiskEventReceiver;
import id.dana.data.risk.riskevent.sharetextbroadcast.ShareTextBroadcastReceiver;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GContainerModule_ProvideShareTextBroadcastReceiverFactory implements Factory<ShareTextBroadcastReceiver> {
    private final GContainerModule PlaceComponentResult;
    private final Provider<SendRiskEventReceiver> getAuthRequestContext;

    private GContainerModule_ProvideShareTextBroadcastReceiverFactory(GContainerModule gContainerModule, Provider<SendRiskEventReceiver> provider) {
        this.PlaceComponentResult = gContainerModule;
        this.getAuthRequestContext = provider;
    }

    public static GContainerModule_ProvideShareTextBroadcastReceiverFactory getAuthRequestContext(GContainerModule gContainerModule, Provider<SendRiskEventReceiver> provider) {
        return new GContainerModule_ProvideShareTextBroadcastReceiverFactory(gContainerModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ShareTextBroadcastReceiver) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.get()));
    }
}
