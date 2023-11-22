package id.dana.contract.sendmoney;

import android.content.Context;
import android.text.TextUtils;
import id.dana.R;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.contract.sendmoney.SendMoneyContract;
import id.dana.core.ui.model.UiTextModel;
import id.dana.data.social.common.PhoneNumberUtilKt;
import id.dana.data.util.NumberUtils;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.account.interactor.GetPhoneNumber;
import id.dana.domain.recentcontact.interactor.SaveDanaUserContact;
import id.dana.domain.sendmoney.interactor.CheckTransferX2PFeature;
import id.dana.domain.sendmoney.interactor.InitSendMoneyContact;
import id.dana.domain.sendmoney.interactor.InitTransferMoney;
import id.dana.domain.sendmoney.model.SendMoneyInit;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.domain.sendmoney.model.TransferInitParam;
import id.dana.domain.sendmoney.model.TransferParticipant;
import id.dana.model.CurrencyAmountModel;
import id.dana.sendmoney.mapper.SendMoneyInitMapper;
import id.dana.sendmoney.mapper.TransferBankMapper;
import id.dana.sendmoney.mapper.TransferContactMapper;
import id.dana.sendmoney.mapper.WithdrawOTCMapper;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.model.SendMoneyInitModel;
import id.dana.sendmoney.model.TransferAmountConfig;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;

@PerActivity
/* loaded from: classes4.dex */
public class SendMoneyPresenter implements SendMoneyContract.Presenter {
    SendMoneyInitMapper BuiltInFictitiousFunctionClassFactory;
    private String DatabaseTableConfigUtil;
    private String GetContactSyncConfig = "";
    String KClassImpl$Data$declaredNonStaticMembers$2;
    RecipientModel MyBillsEntityDataFactory;
    private final CheckTransferX2PFeature NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final InitTransferMoney NetworkUserEntityData$$ExternalSyntheticLambda1;
    private String NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final TransferBankMapper NetworkUserEntityData$$ExternalSyntheticLambda7;
    SaveDanaUserContact PlaceComponentResult;
    InitSendMoneyContact getAuthRequestContext;
    private final Context getErrorConfigVersion;
    private final GetPhoneNumber initRecordTimeStamp;
    TransferContactMapper lookAheadTest;
    TransferAmountConfig moveToNextValue;
    private final SendMoneyContract.View newProxyInstance;
    WithdrawOTCMapper scheduleImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public SendMoneyPresenter(InitTransferMoney initTransferMoney, TransferBankMapper transferBankMapper, SendMoneyContract.View view, CheckTransferX2PFeature checkTransferX2PFeature, GetPhoneNumber getPhoneNumber, Context context) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = initTransferMoney;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = transferBankMapper;
        this.newProxyInstance = view;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = checkTransferX2PFeature;
        this.initRecordTimeStamp = getPhoneNumber;
        this.getErrorConfigVersion = context;
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.dispose();
        this.getAuthRequestContext.dispose();
        this.PlaceComponentResult.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
        this.initRecordTimeStamp.dispose();
    }

    @Override // id.dana.contract.sendmoney.SendMoneyContract.Presenter
    public final void PlaceComponentResult(final String str, final RecipientModel recipientModel, final String str2, String str3) {
        this.GetContactSyncConfig = str3;
        this.newProxyInstance.KClassImpl$Data$declaredNonStaticMembers$2(true);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        if (str.equals("BALANCE")) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.execute(new DefaultObserver<Boolean>() { // from class: id.dana.contract.sendmoney.SendMoneyPresenter.1
                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public /* synthetic */ void onNext(Object obj) {
                    SendMoneyPresenter.BuiltInFictitiousFunctionClassFactory(SendMoneyPresenter.this, ((Boolean) obj).booleanValue(), str, recipientModel, str2);
                }
            });
        } else {
            MyBillsEntityDataFactory(str, recipientModel, str2);
        }
    }

    @Override // id.dana.contract.sendmoney.SendMoneyContract.Presenter
    public final void MyBillsEntityDataFactory(String str, String str2) {
        this.PlaceComponentResult.execute(new DefaultObserver<Boolean>() { // from class: id.dana.contract.sendmoney.SendMoneyPresenter.2
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* bridge */ /* synthetic */ void onNext(Object obj) {
                Boolean bool = (Boolean) obj;
            }
        }, SaveDanaUserContact.Params.forSaveDanaUserContact(str, str2));
    }

    @Override // id.dana.contract.sendmoney.SendMoneyContract.Presenter
    public final void MyBillsEntityDataFactory(String str, boolean z) {
        if (this.moveToNextValue == null || TextUtils.isEmpty(str)) {
            return;
        }
        CurrencyAmountModel currencyAmountModel = new CurrencyAmountModel(str);
        CurrencyAmountModel currencyAmountModel2 = new CurrencyAmountModel("1000000");
        if (currencyAmountModel.KClassImpl$Data$declaredNonStaticMembers$2(this.moveToNextValue.PlaceComponentResult)) {
            this.newProxyInstance.BuiltInFictitiousFunctionClassFactory(this.moveToNextValue.PlaceComponentResult.MyBillsEntityDataFactory);
        } else if (currencyAmountModel.getAuthRequestContext(this.moveToNextValue.MyBillsEntityDataFactory)) {
            this.newProxyInstance.MyBillsEntityDataFactory(this.moveToNextValue.MyBillsEntityDataFactory.MyBillsEntityDataFactory);
        } else if (this.moveToNextValue.BuiltInFictitiousFunctionClassFactory != null && currencyAmountModel.KClassImpl$Data$declaredNonStaticMembers$2(this.moveToNextValue.BuiltInFictitiousFunctionClassFactory)) {
            this.newProxyInstance.PlaceComponentResult(this.MyBillsEntityDataFactory, this.moveToNextValue.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory);
        } else if (this.moveToNextValue.scheduleImpl != null && currencyAmountModel.getAuthRequestContext(this.moveToNextValue.scheduleImpl) && z) {
            this.newProxyInstance.getAuthRequestContext();
        } else {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.equals("OTC") && currencyAmountModel.getAuthRequestContext(currencyAmountModel2)) {
                this.newProxyInstance.MyBillsEntityDataFactory(NumberUtils.getCleanAll(currencyAmountModel.MyBillsEntityDataFactory), this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            } else if (this.KClassImpl$Data$declaredNonStaticMembers$2.equals("OTC") && currencyAmountModel.KClassImpl$Data$declaredNonStaticMembers$2(currencyAmountModel2)) {
                this.newProxyInstance.KClassImpl$Data$declaredNonStaticMembers$2(this.DatabaseTableConfigUtil);
            }
            this.newProxyInstance.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory);
        }
    }

    private void BuiltInFictitiousFunctionClassFactory(final String str, String str2, String str3) {
        this.newProxyInstance.showProgress();
        this.getAuthRequestContext.execute(new DefaultObserver<SendMoneyInit>() { // from class: id.dana.contract.sendmoney.SendMoneyPresenter.3
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                SendMoneyInit sendMoneyInit = (SendMoneyInit) obj;
                SendMoneyPresenter.this.newProxyInstance.dismissProgress();
                SendMoneyPresenter.this.newProxyInstance.KClassImpl$Data$declaredNonStaticMembers$2();
                SendMoneyInitModel apply = SendMoneyPresenter.this.BuiltInFictitiousFunctionClassFactory.apply(sendMoneyInit);
                if (apply.MyBillsEntityDataFactory()) {
                    if (!TextUtils.isEmpty(str)) {
                        SendMoneyPresenter.this.newProxyInstance.KClassImpl$Data$declaredNonStaticMembers$2(sendMoneyInit.getPayeeUserId(), str, sendMoneyInit.getPayeeMaskedNickname(), sendMoneyInit.getPayeeMaskedPhoneNumber(), sendMoneyInit.getAvatarUrl());
                    }
                    SendMoneyPresenter sendMoneyPresenter = SendMoneyPresenter.this;
                    RecipientModel.Builder builder = new RecipientModel.Builder(sendMoneyPresenter.MyBillsEntityDataFactory.readMicros);
                    builder.scheduleImpl = TextUtils.isEmpty(apply.moveToNextValue) ? "" : apply.moveToNextValue;
                    builder.PrepareContext = "userid";
                    builder.GetContactSyncConfig = SendMoneyPresenter.this.MyBillsEntityDataFactory.getErrorConfigVersion;
                    builder.getErrorConfigVersion = apply.MyBillsEntityDataFactory;
                    SendMoneyPresenter sendMoneyPresenter2 = SendMoneyPresenter.this;
                    builder.initRecordTimeStamp = SendMoneyPresenter.PlaceComponentResult(sendMoneyPresenter2, sendMoneyPresenter2.MyBillsEntityDataFactory.PlaceComponentResult(), sendMoneyInit.getPayeeMaskedNickname());
                    builder.FragmentBottomSheetPaymentSettingBinding = SendMoneyPresenter.this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = SendMoneyPresenter.this.MyBillsEntityDataFactory.B;
                    builder.moveToNextValue = SendMoneyPresenter.this.MyBillsEntityDataFactory.getErrorConfigVersion();
                    sendMoneyPresenter.MyBillsEntityDataFactory = builder.KClassImpl$Data$declaredNonStaticMembers$2();
                } else {
                    SendMoneyPresenter sendMoneyPresenter3 = SendMoneyPresenter.this;
                    RecipientModel.Builder builder2 = new RecipientModel.Builder(sendMoneyPresenter3.MyBillsEntityDataFactory.readMicros);
                    builder2.scheduleImpl = str;
                    builder2.PrepareContext = "phonenumber";
                    builder2.GetContactSyncConfig = SendMoneyPresenter.this.MyBillsEntityDataFactory.getErrorConfigVersion;
                    builder2.getErrorConfigVersion = apply.MyBillsEntityDataFactory;
                    builder2.initRecordTimeStamp = SendMoneyPresenter.this.MyBillsEntityDataFactory.PlaceComponentResult();
                    builder2.FragmentBottomSheetPaymentSettingBinding = SendMoneyPresenter.this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    builder2.NetworkUserEntityData$$ExternalSyntheticLambda4 = SendMoneyPresenter.this.MyBillsEntityDataFactory.B;
                    sendMoneyPresenter3.MyBillsEntityDataFactory = builder2.KClassImpl$Data$declaredNonStaticMembers$2();
                }
                SendMoneyPresenter sendMoneyPresenter4 = SendMoneyPresenter.this;
                sendMoneyPresenter4.moveToNextValue = sendMoneyPresenter4.lookAheadTest.apply(apply);
                SendMoneyPresenter.this.newProxyInstance.KClassImpl$Data$declaredNonStaticMembers$2(false);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                SendMoneyPresenter.this.newProxyInstance.dismissProgress();
                SendMoneyPresenter.this.newProxyInstance.KClassImpl$Data$declaredNonStaticMembers$2(false);
                SendMoneyPresenter.this.newProxyInstance.BuiltInFictitiousFunctionClassFactory(th);
                SendMoneyPresenter.this.newProxyInstance.PlaceComponentResult(th, TrackerDataKey.NetworkErrorOperationTypeProperty.BIZTRANSFER_INIT, SendMoneyPresenter.this.GetContactSyncConfig, TrackerDataKey.Source.SEND_MONEY_SUMMARY_OPEN);
                super.onError(th);
            }
        }, InitSendMoneyContact.Params.forSendMoneyInit(str, str2, str3));
    }

    private void MyBillsEntityDataFactory(final String str, final RecipientModel recipientModel, String str2) {
        this.MyBillsEntityDataFactory = recipientModel;
        this.newProxyInstance.showProgress();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.execute(new DefaultObserver<TransferInit>() { // from class: id.dana.contract.sendmoney.SendMoneyPresenter.4
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                TransferInit transferInit = (TransferInit) obj;
                SendMoneyPresenter.this.newProxyInstance.dismissProgress();
                if (transferInit.getTransferMethod() != null && !transferInit.getTransferMethod().isEmpty()) {
                    SendMoneyPresenter.this.MyBillsEntityDataFactory.A = (int) transferInit.getTransferMethod().get(0).getFreeRemainedTimes();
                }
                SendMoneyPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda7.BuiltInFictitiousFunctionClassFactory = str;
                SendMoneyPresenter sendMoneyPresenter = SendMoneyPresenter.this;
                sendMoneyPresenter.moveToNextValue = sendMoneyPresenter.NetworkUserEntityData$$ExternalSyntheticLambda7.apply(transferInit);
                if ("OTC".equals(str)) {
                    SendMoneyContract.View unused = SendMoneyPresenter.this.newProxyInstance;
                    SendMoneyPresenter.this.scheduleImpl.apply(transferInit);
                    if (SendMoneyPresenter.this.MyBillsEntityDataFactory.PrepareContext == null) {
                        SendMoneyPresenter.this.DatabaseTableConfigUtil = transferInit.getTransferMethod().get(0).getChargeAmount().getAmount();
                    } else {
                        SendMoneyPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda2 = transferInit.getTransferMethod().get(0).getChargeAmount().getAmount();
                    }
                }
                SendMoneyPresenter.this.newProxyInstance.getAuthRequestContext(transferInit);
                if ("BALANCE".equals(str)) {
                    SendMoneyPresenter.this.getAuthRequestContext(transferInit, recipientModel.KClassImpl$Data$declaredNonStaticMembers$2());
                }
                if (SendMoneyPresenter.this.moveToNextValue == null) {
                    SendMoneyPresenter.this.newProxyInstance.BuiltInFictitiousFunctionClassFactory();
                } else {
                    SendMoneyPresenter.this.newProxyInstance.KClassImpl$Data$declaredNonStaticMembers$2();
                    SendMoneyPresenter.this.newProxyInstance.PlaceComponentResult(transferInit);
                }
                SendMoneyPresenter.this.newProxyInstance.KClassImpl$Data$declaredNonStaticMembers$2(false);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                SendMoneyPresenter.this.newProxyInstance.BuiltInFictitiousFunctionClassFactory(th);
                SendMoneyPresenter.this.newProxyInstance.PlaceComponentResult(th, TrackerDataKey.NetworkErrorOperationTypeProperty.BIZTRANSFER_INIT, SendMoneyPresenter.this.GetContactSyncConfig, TrackerDataKey.Source.SEND_MONEY_SUMMARY_OPEN);
                SendMoneyPresenter.this.newProxyInstance.dismissProgress();
                SendMoneyPresenter.this.newProxyInstance.KClassImpl$Data$declaredNonStaticMembers$2(false);
            }
        }, InitTransferMoney.Params.forSendMoneyInit(getAuthRequestContext(this.MyBillsEntityDataFactory, str, str2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean PlaceComponentResult(String str, String str2) {
        if (str.isEmpty()) {
            return false;
        }
        return PhoneNumberUtilKt.replaceIndoPhonePrefixWithRegionDash(str).equals(PhoneNumberUtilKt.replaceIndoPhonePrefixWithRegionDash(str2));
    }

    @Override // id.dana.contract.sendmoney.SendMoneyContract.Presenter
    public final void getAuthRequestContext(TransferInit transferInit, String str) {
        if (transferInit.isDanaUser()) {
            if (!TextUtils.isEmpty(str)) {
                this.newProxyInstance.KClassImpl$Data$declaredNonStaticMembers$2(transferInit.getPayeeUserId(), str, transferInit.getPayeeMaskedNickname(), transferInit.getPayeeMaskedPhoneNumber(), transferInit.getPayeeAvatar());
            }
            RecipientModel.Builder builder = new RecipientModel.Builder(this.MyBillsEntityDataFactory.readMicros);
            builder.scheduleImpl = transferInit.getPayeeUserId();
            builder.PrepareContext = "userid";
            String str2 = this.MyBillsEntityDataFactory.getErrorConfigVersion;
            String payeeMaskedPhoneNumber = transferInit.getPayeeMaskedPhoneNumber();
            if (!NumberUtils.isValidIndoPhoneNumberPrefix(str2)) {
                str2 = payeeMaskedPhoneNumber;
            }
            builder.GetContactSyncConfig = str2;
            builder.getErrorConfigVersion = transferInit.getPayeeAvatar();
            String PlaceComponentResult = this.MyBillsEntityDataFactory.PlaceComponentResult();
            String payeeMaskedNickname = transferInit.getPayeeMaskedNickname();
            if ((!TextUtils.isEmpty(payeeMaskedNickname) && this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2()) || PlaceComponentResult.contains("*")) {
                PlaceComponentResult = payeeMaskedNickname;
            }
            builder.initRecordTimeStamp = PlaceComponentResult;
            builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = this.MyBillsEntityDataFactory.B;
            builder.FragmentBottomSheetPaymentSettingBinding = this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1;
            builder.moveToNextValue = this.MyBillsEntityDataFactory.getErrorConfigVersion();
            this.MyBillsEntityDataFactory = builder.KClassImpl$Data$declaredNonStaticMembers$2();
            return;
        }
        RecipientModel.Builder builder2 = new RecipientModel.Builder(this.MyBillsEntityDataFactory.readMicros);
        builder2.scheduleImpl = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
        builder2.PrepareContext = "phonenumber";
        builder2.GetContactSyncConfig = this.MyBillsEntityDataFactory.getErrorConfigVersion;
        builder2.getErrorConfigVersion = transferInit.getPayeeAvatar();
        builder2.initRecordTimeStamp = this.MyBillsEntityDataFactory.PlaceComponentResult();
        builder2.NetworkUserEntityData$$ExternalSyntheticLambda4 = this.MyBillsEntityDataFactory.B;
        builder2.FragmentBottomSheetPaymentSettingBinding = this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1;
        builder2.moveToNextValue = this.MyBillsEntityDataFactory.getErrorConfigVersion();
        this.MyBillsEntityDataFactory = builder2.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    private static TransferInitParam getAuthRequestContext(RecipientModel recipientModel, String str, String str2) {
        TransferInitParam transferInitParam = new TransferInitParam();
        transferInitParam.setTransferMethod(str);
        transferInitParam.setNeedTransferMethod(true);
        transferInitParam.setNeedPayMethod(!"3.0".equals(str2));
        transferInitParam.setAmount(recipientModel.PrepareContext);
        transferInitParam.setVersion(str2);
        if ("BALANCE".equals(str)) {
            TransferParticipant transferParticipant = new TransferParticipant();
            if ("phonenumber".equals(recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda6)) {
                transferParticipant.setLoginId(recipientModel.KClassImpl$Data$declaredNonStaticMembers$2());
            } else if ("userid".equals(recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda6)) {
                transferParticipant.setUserId(recipientModel.KClassImpl$Data$declaredNonStaticMembers$2());
            }
            transferInitParam.setPayeeInfo(transferParticipant);
        } else if ("OTC".equals(str)) {
            transferInitParam.setNeedWithdrawMethod(true);
        }
        return transferInitParam;
    }

    @Override // id.dana.contract.sendmoney.SendMoneyContract.Presenter
    public final void getAuthRequestContext(RecipientModel recipientModel, String str) {
        this.MyBillsEntityDataFactory = recipientModel;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
    }

    @Override // id.dana.contract.sendmoney.SendMoneyContract.Presenter
    public final void PlaceComponentResult(TransferAmountConfig transferAmountConfig) {
        this.moveToNextValue = transferAmountConfig;
    }

    static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(SendMoneyPresenter sendMoneyPresenter, final boolean z, final String str, final RecipientModel recipientModel, final String str2) {
        sendMoneyPresenter.initRecordTimeStamp.execute(new DefaultObserver<String>() { // from class: id.dana.contract.sendmoney.SendMoneyPresenter.5
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                if (SendMoneyPresenter.PlaceComponentResult((String) obj, recipientModel.KClassImpl$Data$declaredNonStaticMembers$2())) {
                    SendMoneyPresenter.this.newProxyInstance.BuiltInFictitiousFunctionClassFactory(new UiTextModel.StringResource(R.string.send_to_self_number_error, new Object[0]));
                    SendMoneyPresenter.this.newProxyInstance.KClassImpl$Data$declaredNonStaticMembers$2(false);
                    return;
                }
                SendMoneyPresenter.PlaceComponentResult(SendMoneyPresenter.this, z, str, recipientModel, str2);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                SendMoneyPresenter.PlaceComponentResult(SendMoneyPresenter.this, z, str, recipientModel, str2);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SEND_MONEY_TAG, th.getMessage(), th);
            }
        });
    }

    static /* synthetic */ void PlaceComponentResult(SendMoneyPresenter sendMoneyPresenter, boolean z, String str, RecipientModel recipientModel, String str2) {
        if (z) {
            sendMoneyPresenter.MyBillsEntityDataFactory(str, recipientModel, str2);
            return;
        }
        sendMoneyPresenter.MyBillsEntityDataFactory = recipientModel;
        if ("phonenumber".equals(recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda6)) {
            sendMoneyPresenter.BuiltInFictitiousFunctionClassFactory(recipientModel.KClassImpl$Data$declaredNonStaticMembers$2(), "", str2);
        } else if ("userid".equals(recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda6)) {
            sendMoneyPresenter.BuiltInFictitiousFunctionClassFactory("", recipientModel.KClassImpl$Data$declaredNonStaticMembers$2(), str2);
        }
    }

    static /* synthetic */ String PlaceComponentResult(SendMoneyPresenter sendMoneyPresenter, String str, String str2) {
        return ((TextUtils.isEmpty(str2) || !sendMoneyPresenter.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2()) && !str.contains("*")) ? str : str2;
    }
}
