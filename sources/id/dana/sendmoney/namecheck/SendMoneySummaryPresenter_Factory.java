package id.dana.sendmoney.namecheck;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.domain.featureconfig.interactor.GetExpiryTimeConfig;
import id.dana.domain.featureconfig.interactor.GetSendMoneyFeedConfig;
import id.dana.domain.sendmoney.interactor.CheckX2PAndX2XVoucherFeature;
import id.dana.domain.sendmoney.interactor.CheckX2XVoucherFeature;
import id.dana.domain.sendmoney.interactor.GetFeatureSendMoneyCashierNative;
import id.dana.domain.sendmoney.interactor.GetSmartFrictionConfig;
import id.dana.domain.sendmoney.interactor.GetStateSendMoneyShareFeed;
import id.dana.domain.sendmoney.interactor.InitTransferOTC;
import id.dana.domain.sendmoney.interactor.SaveStateSendMoneyShareFeed;
import id.dana.domain.sendmoney.interactor.SendMoneyNameCheck;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.sendmoney.mapper.ConfirmationMapper;
import id.dana.sendmoney.mapper.SendMoneyBankMapper;
import id.dana.sendmoney.namecheck.SendMoneySummaryContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SendMoneySummaryPresenter_Factory implements Factory<SendMoneySummaryPresenter> {
    private final Provider<CheckX2PAndX2XVoucherFeature> BuiltInFictitiousFunctionClassFactory;
    private final Provider<InitTransferOTC> DatabaseTableConfigUtil;
    private final Provider<SendMoneySummaryContract.View> GetContactSyncConfig;
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetExpiryTimeConfig> MyBillsEntityDataFactory;
    private final Provider<GetSmartFrictionConfig> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<SaveStateSendMoneyShareFeed> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<SendMoneyNameCheck> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Provider<CheckX2XVoucherFeature> PlaceComponentResult;
    private final Provider<ConfirmationMapper> getAuthRequestContext;
    private final Provider<GetUserInfoWithKyc> getErrorConfigVersion;
    private final Provider<SendMoneyBankMapper> initRecordTimeStamp;
    private final Provider<GetSendMoneyFeedConfig> lookAheadTest;
    private final Provider<GetStateSendMoneyShareFeed> moveToNextValue;
    private final Provider<GetFeatureSendMoneyCashierNative> scheduleImpl;

    private SendMoneySummaryPresenter_Factory(Provider<Context> provider, Provider<SendMoneyNameCheck> provider2, Provider<SendMoneyBankMapper> provider3, Provider<ConfirmationMapper> provider4, Provider<SendMoneySummaryContract.View> provider5, Provider<CheckX2XVoucherFeature> provider6, Provider<CheckX2PAndX2XVoucherFeature> provider7, Provider<InitTransferOTC> provider8, Provider<GetSendMoneyFeedConfig> provider9, Provider<GetStateSendMoneyShareFeed> provider10, Provider<SaveStateSendMoneyShareFeed> provider11, Provider<GetFeatureSendMoneyCashierNative> provider12, Provider<GetSmartFrictionConfig> provider13, Provider<GetUserInfoWithKyc> provider14, Provider<GetExpiryTimeConfig> provider15) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = provider2;
        this.initRecordTimeStamp = provider3;
        this.getAuthRequestContext = provider4;
        this.GetContactSyncConfig = provider5;
        this.PlaceComponentResult = provider6;
        this.BuiltInFictitiousFunctionClassFactory = provider7;
        this.DatabaseTableConfigUtil = provider8;
        this.lookAheadTest = provider9;
        this.moveToNextValue = provider10;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = provider11;
        this.scheduleImpl = provider12;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider13;
        this.getErrorConfigVersion = provider14;
        this.MyBillsEntityDataFactory = provider15;
    }

    public static SendMoneySummaryPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<Context> provider, Provider<SendMoneyNameCheck> provider2, Provider<SendMoneyBankMapper> provider3, Provider<ConfirmationMapper> provider4, Provider<SendMoneySummaryContract.View> provider5, Provider<CheckX2XVoucherFeature> provider6, Provider<CheckX2PAndX2XVoucherFeature> provider7, Provider<InitTransferOTC> provider8, Provider<GetSendMoneyFeedConfig> provider9, Provider<GetStateSendMoneyShareFeed> provider10, Provider<SaveStateSendMoneyShareFeed> provider11, Provider<GetFeatureSendMoneyCashierNative> provider12, Provider<GetSmartFrictionConfig> provider13, Provider<GetUserInfoWithKyc> provider14, Provider<GetExpiryTimeConfig> provider15) {
        return new SendMoneySummaryPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SendMoneySummaryPresenter(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda2.get(), this.initRecordTimeStamp.get(), this.getAuthRequestContext.get(), this.GetContactSyncConfig.get(), this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.DatabaseTableConfigUtil.get(), this.lookAheadTest.get(), this.moveToNextValue.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda1.get(), this.scheduleImpl.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.getErrorConfigVersion.get(), this.MyBillsEntityDataFactory.get());
    }
}
