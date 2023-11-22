package id.dana.sendmoney_v2.x2l.contract;

import dagger.internal.Factory;
import id.dana.domain.sendmoney.x2l.interactor.GetSendToLinkBannerConfig;
import id.dana.sendmoney_v2.x2l.contract.SendToLinkBannerContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SendToLinkBannerPresenter_Factory implements Factory<SendToLinkBannerPresenter> {
    private final Provider<GetSendToLinkBannerConfig> MyBillsEntityDataFactory;
    private final Provider<SendToLinkBannerContract.View> getAuthRequestContext;

    private SendToLinkBannerPresenter_Factory(Provider<SendToLinkBannerContract.View> provider, Provider<GetSendToLinkBannerConfig> provider2) {
        this.getAuthRequestContext = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static SendToLinkBannerPresenter_Factory getAuthRequestContext(Provider<SendToLinkBannerContract.View> provider, Provider<GetSendToLinkBannerConfig> provider2) {
        return new SendToLinkBannerPresenter_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SendToLinkBannerPresenter(this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get());
    }
}
