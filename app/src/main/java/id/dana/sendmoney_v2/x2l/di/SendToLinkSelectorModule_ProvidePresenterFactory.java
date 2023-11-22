package id.dana.sendmoney_v2.x2l.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.sendmoney_v2.x2l.contract.SendToLinkSelectorContract;
import id.dana.sendmoney_v2.x2l.contract.SendToLinkSelectorPresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SendToLinkSelectorModule_ProvidePresenterFactory implements Factory<SendToLinkSelectorContract.Presenter> {
    private final SendToLinkSelectorModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<SendToLinkSelectorPresenter> MyBillsEntityDataFactory;

    private SendToLinkSelectorModule_ProvidePresenterFactory(SendToLinkSelectorModule sendToLinkSelectorModule, Provider<SendToLinkSelectorPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = sendToLinkSelectorModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static SendToLinkSelectorModule_ProvidePresenterFactory BuiltInFictitiousFunctionClassFactory(SendToLinkSelectorModule sendToLinkSelectorModule, Provider<SendToLinkSelectorPresenter> provider) {
        return new SendToLinkSelectorModule_ProvidePresenterFactory(sendToLinkSelectorModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SendToLinkSelectorContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this.MyBillsEntityDataFactory.get()));
    }
}
