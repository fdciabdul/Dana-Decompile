package id.dana.sendmoney_v2.x2l.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.sendmoney_v2.x2l.contract.SendToLinkBannerContract;
import id.dana.sendmoney_v2.x2l.contract.SendToLinkBannerPresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SendToLinkBannerModule_ProvidePresenterFactory implements Factory<SendToLinkBannerContract.Presenter> {
    private final Provider<SendToLinkBannerPresenter> BuiltInFictitiousFunctionClassFactory;
    private final SendToLinkBannerModule PlaceComponentResult;

    private SendToLinkBannerModule_ProvidePresenterFactory(SendToLinkBannerModule sendToLinkBannerModule, Provider<SendToLinkBannerPresenter> provider) {
        this.PlaceComponentResult = sendToLinkBannerModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static SendToLinkBannerModule_ProvidePresenterFactory getAuthRequestContext(SendToLinkBannerModule sendToLinkBannerModule, Provider<SendToLinkBannerPresenter> provider) {
        return new SendToLinkBannerModule_ProvidePresenterFactory(sendToLinkBannerModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SendToLinkBannerContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
