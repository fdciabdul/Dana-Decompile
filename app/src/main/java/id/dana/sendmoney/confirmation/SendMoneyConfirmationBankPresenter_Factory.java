package id.dana.sendmoney.confirmation;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.domain.h5event.interactor.GetCheckoutH5Event;
import id.dana.domain.promotion.interactor.DecrementFreeTransferCount;
import id.dana.domain.recentbank.interactor.SaveRecentBank;
import id.dana.domain.sendmoney.interactor.ConfirmSendMoneyBank;
import id.dana.sendmoney.confirmation.SendMoneyConfirmationBankContract;
import id.dana.sendmoney.mapper.ConfirmToBankMapper;
import id.dana.sendmoney.mapper.SendMoneyConfirmModelMapper;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SendMoneyConfirmationBankPresenter_Factory implements Factory<SendMoneyConfirmationBankPresenter> {
    private final Provider<GetCheckoutH5Event> BuiltInFictitiousFunctionClassFactory;
    private final Provider<DecrementFreeTransferCount> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> MyBillsEntityDataFactory;
    private final Provider<SendMoneyConfirmModelMapper> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<ConfirmSendMoneyBank> PlaceComponentResult;
    private final Provider<ConfirmToBankMapper> getAuthRequestContext;
    private final Provider<SendMoneyConfirmationBankContract.View> lookAheadTest;
    private final Provider<SaveRecentBank> moveToNextValue;

    private SendMoneyConfirmationBankPresenter_Factory(Provider<SendMoneyConfirmationBankContract.View> provider, Provider<ConfirmSendMoneyBank> provider2, Provider<SaveRecentBank> provider3, Provider<ConfirmToBankMapper> provider4, Provider<SendMoneyConfirmModelMapper> provider5, Provider<GetCheckoutH5Event> provider6, Provider<DecrementFreeTransferCount> provider7, Provider<Context> provider8) {
        this.lookAheadTest = provider;
        this.PlaceComponentResult = provider2;
        this.moveToNextValue = provider3;
        this.getAuthRequestContext = provider4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider5;
        this.BuiltInFictitiousFunctionClassFactory = provider6;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider7;
        this.MyBillsEntityDataFactory = provider8;
    }

    public static SendMoneyConfirmationBankPresenter_Factory MyBillsEntityDataFactory(Provider<SendMoneyConfirmationBankContract.View> provider, Provider<ConfirmSendMoneyBank> provider2, Provider<SaveRecentBank> provider3, Provider<ConfirmToBankMapper> provider4, Provider<SendMoneyConfirmModelMapper> provider5, Provider<GetCheckoutH5Event> provider6, Provider<DecrementFreeTransferCount> provider7, Provider<Context> provider8) {
        return new SendMoneyConfirmationBankPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SendMoneyConfirmationBankPresenter(this.lookAheadTest.get(), this.PlaceComponentResult.get(), this.moveToNextValue.get(), this.getAuthRequestContext.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get());
    }
}
