package id.dana.sendmoney_v2.x2l.contract;

import dagger.internal.Factory;
import id.dana.domain.sendmoney.x2l.interactor.GetSocialLinks;
import id.dana.sendmoney_v2.x2l.contract.SendToLinkSelectorContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SendToLinkSelectorPresenter_Factory implements Factory<SendToLinkSelectorPresenter> {
    private final Provider<GetSocialLinks> BuiltInFictitiousFunctionClassFactory;
    private final Provider<SendToLinkSelectorContract.View> MyBillsEntityDataFactory;

    private SendToLinkSelectorPresenter_Factory(Provider<SendToLinkSelectorContract.View> provider, Provider<GetSocialLinks> provider2) {
        this.MyBillsEntityDataFactory = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
    }

    public static SendToLinkSelectorPresenter_Factory MyBillsEntityDataFactory(Provider<SendToLinkSelectorContract.View> provider, Provider<GetSocialLinks> provider2) {
        return new SendToLinkSelectorPresenter_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SendToLinkSelectorPresenter(this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
