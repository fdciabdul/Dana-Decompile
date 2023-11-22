package id.dana.sendmoney.external;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.domain.sendmoney.interactor.GetWithdrawChannelInfoData;
import id.dana.domain.sendmoney.interactor.InitTransferMoney;
import id.dana.domain.sendmoney.interactor.InitWithdraw;
import id.dana.domain.sendmoney.interactor.IsNeedToShowExternalOnboardingDialog;
import id.dana.domain.sendmoney.interactor.SaveExternalOnboardingDialog;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.sendmoney.external.SendMoneyExternalContract;
import id.dana.sendmoney.mapper.TransferMethodMapper;
import id.dana.sendmoney.mapper.WithdrawInitMethodOptionModelMapper;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SendMoneyExternalPresenter_Factory implements Factory<SendMoneyExternalPresenter> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetUserInfoWithKyc> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetWithdrawChannelInfoData> MyBillsEntityDataFactory;
    private final Provider<IsNeedToShowExternalOnboardingDialog> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<InitWithdraw> PlaceComponentResult;
    private final Provider<InitTransferMoney> getAuthRequestContext;
    private final Provider<SendMoneyExternalContract.View> getErrorConfigVersion;
    private final Provider<TransferMethodMapper> lookAheadTest;
    private final Provider<WithdrawInitMethodOptionModelMapper> moveToNextValue;
    private final Provider<SaveExternalOnboardingDialog> scheduleImpl;

    private SendMoneyExternalPresenter_Factory(Provider<Context> provider, Provider<InitTransferMoney> provider2, Provider<InitWithdraw> provider3, Provider<TransferMethodMapper> provider4, Provider<IsNeedToShowExternalOnboardingDialog> provider5, Provider<SaveExternalOnboardingDialog> provider6, Provider<GetUserInfoWithKyc> provider7, Provider<WithdrawInitMethodOptionModelMapper> provider8, Provider<GetWithdrawChannelInfoData> provider9, Provider<SendMoneyExternalContract.View> provider10) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.getAuthRequestContext = provider2;
        this.PlaceComponentResult = provider3;
        this.lookAheadTest = provider4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider5;
        this.scheduleImpl = provider6;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider7;
        this.moveToNextValue = provider8;
        this.MyBillsEntityDataFactory = provider9;
        this.getErrorConfigVersion = provider10;
    }

    public static SendMoneyExternalPresenter_Factory MyBillsEntityDataFactory(Provider<Context> provider, Provider<InitTransferMoney> provider2, Provider<InitWithdraw> provider3, Provider<TransferMethodMapper> provider4, Provider<IsNeedToShowExternalOnboardingDialog> provider5, Provider<SaveExternalOnboardingDialog> provider6, Provider<GetUserInfoWithKyc> provider7, Provider<WithdrawInitMethodOptionModelMapper> provider8, Provider<GetWithdrawChannelInfoData> provider9, Provider<SendMoneyExternalContract.View> provider10) {
        return new SendMoneyExternalPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SendMoneyExternalPresenter(this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get(), this.PlaceComponentResult.get(), this.lookAheadTest.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.scheduleImpl.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.moveToNextValue.get(), this.MyBillsEntityDataFactory.get(), this.getErrorConfigVersion.get());
    }
}
