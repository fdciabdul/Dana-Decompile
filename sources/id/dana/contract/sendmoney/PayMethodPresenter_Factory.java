package id.dana.contract.sendmoney;

import dagger.internal.Factory;
import id.dana.contract.sendmoney.PayMethodContract;
import id.dana.domain.card.interactor.GetDefaultCard;
import id.dana.domain.sendmoney.interactor.CheckTransferX2PFeature;
import id.dana.domain.sendmoney.interactor.GetSendMoneyOption;
import id.dana.sendmoney.mapper.ContactPayMethodMapper;
import id.dana.sendmoney.mapper.TransferMethodMapper;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PayMethodPresenter_Factory implements Factory<PayMethodPresenter> {
    private final Provider<ContactPayMethodMapper> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetSendMoneyOption> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<CheckTransferX2PFeature> MyBillsEntityDataFactory;
    private final Provider<TransferMethodMapper> PlaceComponentResult;
    private final Provider<GetDefaultCard> getAuthRequestContext;
    private final Provider<PayMethodContract.View> scheduleImpl;

    private PayMethodPresenter_Factory(Provider<ContactPayMethodMapper> provider, Provider<GetDefaultCard> provider2, Provider<PayMethodContract.View> provider3, Provider<TransferMethodMapper> provider4, Provider<GetSendMoneyOption> provider5, Provider<CheckTransferX2PFeature> provider6) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.getAuthRequestContext = provider2;
        this.scheduleImpl = provider3;
        this.PlaceComponentResult = provider4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider5;
        this.MyBillsEntityDataFactory = provider6;
    }

    public static PayMethodPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<ContactPayMethodMapper> provider, Provider<GetDefaultCard> provider2, Provider<PayMethodContract.View> provider3, Provider<TransferMethodMapper> provider4, Provider<GetSendMoneyOption> provider5, Provider<CheckTransferX2PFeature> provider6) {
        return new PayMethodPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        PayMethodPresenter payMethodPresenter = new PayMethodPresenter(this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get(), this.scheduleImpl.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
        PayMethodPresenter_MembersInjector.getAuthRequestContext(payMethodPresenter, this.MyBillsEntityDataFactory.get());
        return payMethodPresenter;
    }
}
