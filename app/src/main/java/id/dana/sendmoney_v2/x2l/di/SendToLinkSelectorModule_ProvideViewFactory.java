package id.dana.sendmoney_v2.x2l.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.sendmoney_v2.x2l.contract.SendToLinkSelectorContract;

/* loaded from: classes5.dex */
public final class SendToLinkSelectorModule_ProvideViewFactory implements Factory<SendToLinkSelectorContract.View> {
    private final SendToLinkSelectorModule KClassImpl$Data$declaredNonStaticMembers$2;

    private SendToLinkSelectorModule_ProvideViewFactory(SendToLinkSelectorModule sendToLinkSelectorModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = sendToLinkSelectorModule;
    }

    public static SendToLinkSelectorModule_ProvideViewFactory BuiltInFictitiousFunctionClassFactory(SendToLinkSelectorModule sendToLinkSelectorModule) {
        return new SendToLinkSelectorModule_ProvideViewFactory(sendToLinkSelectorModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SendToLinkSelectorContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getPlaceComponentResult());
    }
}
