package id.dana.bank.contract;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.bank.contract.BankSelectorContract;
import id.dana.domain.bank.interactor.CheckUserBankExist;
import id.dana.domain.recentrecipient.interactor.GetRecentRecipient;
import id.dana.domain.requestmoney.interactor.GetBankSelectorConfig;
import id.dana.domain.requestmoney.interactor.GetNameCheckCount;
import id.dana.domain.requestmoney.interactor.IsFreezeNameCheck;
import id.dana.domain.requestmoney.interactor.NameCheck;
import id.dana.sendmoney.mapper.BankModelMapper;
import id.dana.sendmoney.mapper.SendMoneyBankMapper;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class BankSelectorPresenter_Factory implements Factory<BankSelectorPresenter> {
    private final Provider<BankModelMapper> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetBankSelectorConfig> MyBillsEntityDataFactory;
    private final Provider<IsFreezeNameCheck> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<GetNameCheckCount> PlaceComponentResult;
    private final Provider<CheckUserBankExist> getAuthRequestContext;
    private final Provider<NameCheck> getErrorConfigVersion;
    private final Provider<GetRecentRecipient> lookAheadTest;
    private final Provider<SendMoneyBankMapper> moveToNextValue;
    private final Provider<BankSelectorContract.View> scheduleImpl;

    private BankSelectorPresenter_Factory(Provider<BankSelectorContract.View> provider, Provider<Context> provider2, Provider<SendMoneyBankMapper> provider3, Provider<NameCheck> provider4, Provider<IsFreezeNameCheck> provider5, Provider<GetBankSelectorConfig> provider6, Provider<GetNameCheckCount> provider7, Provider<CheckUserBankExist> provider8, Provider<GetRecentRecipient> provider9, Provider<BankModelMapper> provider10) {
        this.scheduleImpl = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.moveToNextValue = provider3;
        this.getErrorConfigVersion = provider4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider5;
        this.MyBillsEntityDataFactory = provider6;
        this.PlaceComponentResult = provider7;
        this.getAuthRequestContext = provider8;
        this.lookAheadTest = provider9;
        this.BuiltInFictitiousFunctionClassFactory = provider10;
    }

    public static BankSelectorPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<BankSelectorContract.View> provider, Provider<Context> provider2, Provider<SendMoneyBankMapper> provider3, Provider<NameCheck> provider4, Provider<IsFreezeNameCheck> provider5, Provider<GetBankSelectorConfig> provider6, Provider<GetNameCheckCount> provider7, Provider<CheckUserBankExist> provider8, Provider<GetRecentRecipient> provider9, Provider<BankModelMapper> provider10) {
        return new BankSelectorPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new BankSelectorPresenter(this.scheduleImpl.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.moveToNextValue.get(), this.getErrorConfigVersion.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get(), this.getAuthRequestContext.get(), this.lookAheadTest.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
