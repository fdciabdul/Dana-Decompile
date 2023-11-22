package id.dana.sendmoney_v2.x2l.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.sendmoney_v2.x2l.contract.SendToLinkBannerContract;

/* loaded from: classes5.dex */
public final class SendToLinkBannerModule_ProvideViewFactory implements Factory<SendToLinkBannerContract.View> {
    private final SendToLinkBannerModule MyBillsEntityDataFactory;

    private SendToLinkBannerModule_ProvideViewFactory(SendToLinkBannerModule sendToLinkBannerModule) {
        this.MyBillsEntityDataFactory = sendToLinkBannerModule;
    }

    public static SendToLinkBannerModule_ProvideViewFactory BuiltInFictitiousFunctionClassFactory(SendToLinkBannerModule sendToLinkBannerModule) {
        return new SendToLinkBannerModule_ProvideViewFactory(sendToLinkBannerModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SendToLinkBannerContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
