package id.dana.sendmoney.namecheck;

import android.content.Context;
import android.text.TextUtils;
import id.dana.R;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.data.risk.riskevent.NetworkSendRiskEventEntityData;
import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.NoParams;
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
import id.dana.domain.sendmoney.model.NameCheckParam;
import id.dana.domain.sendmoney.model.OTCTransferInit;
import id.dana.domain.sendmoney.model.SmartFrictionConfig;
import id.dana.domain.sendmoney.model.WithdrawNameCheck;
import id.dana.domain.user.CurrencyAmount;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.model.CurrencyAmountModel;
import id.dana.model.PayMethodModel;
import id.dana.sendmoney.confirmation.ConfirmationType;
import id.dana.sendmoney.contact.provider.ContactProvider;
import id.dana.sendmoney.mapper.ConfirmationMapper;
import id.dana.sendmoney.mapper.SendMoneyBankMapper;
import id.dana.sendmoney.model.CashierFeatureEnum;
import id.dana.sendmoney.model.ConfirmationModel;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.model.VoucherModel;
import id.dana.sendmoney.model.WithdrawNameCheckModel;
import id.dana.sendmoney.model.WithdrawOTCModel;
import id.dana.sendmoney.namecheck.SendMoneySummaryContract;
import id.dana.sendmoney.util.SendMoneyErrorHelper;
import id.dana.utils.ErrorUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.log.CrashlyticsLogUtil;
import id.dana.utils.permission.PermissionHelper;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
public class SendMoneySummaryPresenter implements SendMoneySummaryContract.Presenter {
    final SendMoneySummaryContract.View BuiltInFictitiousFunctionClassFactory;
    private DefaultObserver<Integer> DatabaseTableConfigUtil;
    private final SendMoneyBankMapper GetContactSyncConfig;
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;
    private final ConfirmationMapper MyBillsEntityDataFactory;
    private final GetExpiryTimeConfig NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final GetUserInfoWithKyc NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final InitTransferOTC NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final CheckX2XVoucherFeature PlaceComponentResult;
    private final CheckX2PAndX2XVoucherFeature getAuthRequestContext;
    private final GetStateSendMoneyShareFeed getErrorConfigVersion;
    private final SaveStateSendMoneyShareFeed initRecordTimeStamp;
    private final GetSendMoneyFeedConfig lookAheadTest;
    private final GetSmartFrictionConfig moveToNextValue;
    private final SendMoneyNameCheck newProxyInstance;
    private final GetFeatureSendMoneyCashierNative scheduleImpl;

    @Inject
    public SendMoneySummaryPresenter(Context context, SendMoneyNameCheck sendMoneyNameCheck, SendMoneyBankMapper sendMoneyBankMapper, ConfirmationMapper confirmationMapper, SendMoneySummaryContract.View view, CheckX2XVoucherFeature checkX2XVoucherFeature, CheckX2PAndX2XVoucherFeature checkX2PAndX2XVoucherFeature, InitTransferOTC initTransferOTC, GetSendMoneyFeedConfig getSendMoneyFeedConfig, GetStateSendMoneyShareFeed getStateSendMoneyShareFeed, SaveStateSendMoneyShareFeed saveStateSendMoneyShareFeed, GetFeatureSendMoneyCashierNative getFeatureSendMoneyCashierNative, GetSmartFrictionConfig getSmartFrictionConfig, GetUserInfoWithKyc getUserInfoWithKyc, GetExpiryTimeConfig getExpiryTimeConfig) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.newProxyInstance = sendMoneyNameCheck;
        this.GetContactSyncConfig = sendMoneyBankMapper;
        this.MyBillsEntityDataFactory = confirmationMapper;
        this.BuiltInFictitiousFunctionClassFactory = view;
        this.PlaceComponentResult = checkX2XVoucherFeature;
        this.getAuthRequestContext = checkX2PAndX2XVoucherFeature;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = initTransferOTC;
        this.lookAheadTest = getSendMoneyFeedConfig;
        this.getErrorConfigVersion = getStateSendMoneyShareFeed;
        this.initRecordTimeStamp = saveStateSendMoneyShareFeed;
        this.scheduleImpl = getFeatureSendMoneyCashierNative;
        this.moveToNextValue = getSmartFrictionConfig;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = getUserInfoWithKyc;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = getExpiryTimeConfig;
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.newProxyInstance.dispose();
        this.PlaceComponentResult.dispose();
        this.getAuthRequestContext.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.dispose();
        this.lookAheadTest.dispose();
        this.scheduleImpl.dispose();
        this.moveToNextValue.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
        DefaultObserver<Integer> defaultObserver = this.DatabaseTableConfigUtil;
        if (defaultObserver != null) {
            defaultObserver.dispose();
            this.DatabaseTableConfigUtil = null;
        }
    }

    @Override // id.dana.sendmoney.namecheck.SendMoneySummaryContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(boolean z) {
        if (z) {
            this.getAuthRequestContext.execute(new DefaultObserver<Boolean>() { // from class: id.dana.sendmoney.namecheck.SendMoneySummaryPresenter.1
                {
                    SendMoneySummaryPresenter.this = this;
                }

                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public /* synthetic */ void onNext(Object obj) {
                    SendMoneySummaryPresenter.this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(((Boolean) obj).booleanValue());
                }
            });
        } else {
            this.PlaceComponentResult.execute(new DefaultObserver<Boolean>() { // from class: id.dana.sendmoney.namecheck.SendMoneySummaryPresenter.2
                {
                    SendMoneySummaryPresenter.this = this;
                }

                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public /* synthetic */ void onNext(Object obj) {
                    SendMoneySummaryPresenter.this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(((Boolean) obj).booleanValue());
                }
            });
        }
    }

    @Override // id.dana.sendmoney.namecheck.SendMoneySummaryContract.Presenter
    public final void MyBillsEntityDataFactory(RecipientModel recipientModel, CurrencyAmountModel currencyAmountModel, PayMethodModel payMethodModel, String str, VoucherModel voucherModel) {
        ConfirmationModel KClassImpl$Data$declaredNonStaticMembers$2 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(recipientModel, recipientModel.BottomSheetCardBindingView$watcherCardNumberView$1, currencyAmountModel, payMethodModel, str, ConfirmationType.Destination.CONTACT);
        KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5(recipientModel.KClassImpl$Data$declaredNonStaticMembers$2());
        KClassImpl$Data$declaredNonStaticMembers$2.VerifyPinStateManager$executeRiskChallenge$2$2(recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda6);
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(recipientModel.PlaceComponentResult());
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(recipientModel.getErrorConfigVersion);
        KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl(recipientModel.BuiltInFictitiousFunctionClassFactory());
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(recipientModel.scheduleImpl());
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(payMethodModel.isLayoutRequested);
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda1);
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(recipientModel.getErrorConfigVersion());
        ConfirmationMapper.BuiltInFictitiousFunctionClassFactory(voucherModel, KClassImpl$Data$declaredNonStaticMembers$2);
        getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Override // id.dana.sendmoney.namecheck.SendMoneySummaryContract.Presenter
    public final void getAuthRequestContext(final RecipientModel recipientModel, final CurrencyAmountModel currencyAmountModel, final PayMethodModel payMethodModel, final String str, final VoucherModel voucherModel, final WithdrawOTCModel withdrawOTCModel) {
        this.BuiltInFictitiousFunctionClassFactory.showProgress();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.execute(new DefaultObserver<OTCTransferInit>() { // from class: id.dana.sendmoney.namecheck.SendMoneySummaryPresenter.3
            {
                SendMoneySummaryPresenter.this = this;
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                String str2;
                String str3;
                WithdrawOTCModel withdrawOTCModel2;
                OTCTransferInit oTCTransferInit = (OTCTransferInit) obj;
                ConfirmationMapper confirmationMapper = SendMoneySummaryPresenter.this.MyBillsEntityDataFactory;
                RecipientModel recipientModel2 = recipientModel;
                CurrencyAmountModel currencyAmountModel2 = currencyAmountModel;
                PayMethodModel payMethodModel2 = payMethodModel;
                String str4 = str;
                String str5 = recipientModel2.BottomSheetCardBindingView$watcherCardNumberView$1;
                VoucherModel voucherModel2 = voucherModel;
                ConfirmationMapper.OTCConfirmationModelData oTCConfirmationModelData = new ConfirmationMapper.OTCConfirmationModelData();
                oTCConfirmationModelData.BuiltInFictitiousFunctionClassFactory = oTCTransferInit.getAcceptExpiryTimeUnit();
                oTCConfirmationModelData.MyBillsEntityDataFactory = oTCTransferInit.getAcceptExpiryTimeValue();
                oTCConfirmationModelData.getAuthRequestContext = withdrawOTCModel;
                oTCConfirmationModelData.PlaceComponentResult = oTCTransferInit;
                ConfirmationModel KClassImpl$Data$declaredNonStaticMembers$2 = confirmationMapper.KClassImpl$Data$declaredNonStaticMembers$2(recipientModel2, str5, currencyAmountModel2, payMethodModel2, str4, ConfirmationType.Destination.OTC);
                KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(recipientModel2.PlaceComponentResult());
                KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(recipientModel2.getErrorConfigVersion);
                KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda2(recipientModel2.NetworkUserEntityData$$ExternalSyntheticLambda7);
                str2 = oTCConfirmationModelData.BuiltInFictitiousFunctionClassFactory;
                KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(str2);
                str3 = oTCConfirmationModelData.MyBillsEntityDataFactory;
                KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(str3);
                withdrawOTCModel2 = oTCConfirmationModelData.getAuthRequestContext;
                WithdrawOTCModel withdrawOTCModel3 = new WithdrawOTCModel();
                withdrawOTCModel3.MyBillsEntityDataFactory = withdrawOTCModel2.MyBillsEntityDataFactory;
                withdrawOTCModel3.PlaceComponentResult = withdrawOTCModel2.PlaceComponentResult;
                withdrawOTCModel3.lookAheadTest = withdrawOTCModel2.lookAheadTest;
                withdrawOTCModel3.getErrorConfigVersion = withdrawOTCModel2.getErrorConfigVersion;
                withdrawOTCModel3.scheduleImpl = withdrawOTCModel2.scheduleImpl;
                withdrawOTCModel3.getAuthRequestContext = payMethodModel2.lookAheadTest;
                withdrawOTCModel3.BuiltInFictitiousFunctionClassFactory = payMethodModel2.newProxyInstance;
                withdrawOTCModel3.KClassImpl$Data$declaredNonStaticMembers$2 = payMethodModel2.NetworkUserEntityData$$ExternalSyntheticLambda7;
                KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(withdrawOTCModel3);
                KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(payMethodModel2.isLayoutRequested);
                if (ConfirmationMapper.MyBillsEntityDataFactory(oTCConfirmationModelData)) {
                    KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0(oTCConfirmationModelData.PlaceComponentResult.getTransferMethod().get(0).getChargeAmount().getAmount());
                }
                ConfirmationMapper.BuiltInFictitiousFunctionClassFactory(voucherModel2, KClassImpl$Data$declaredNonStaticMembers$2);
                SendMoneySummaryPresenter.this.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                SendMoneySummaryPresenter.this.BuiltInFictitiousFunctionClassFactory.dismissProgress();
                SendMoneySummaryPresenter.this.BuiltInFictitiousFunctionClassFactory.onError(ErrorUtil.PlaceComponentResult(th, SendMoneySummaryPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2));
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.TRANSFER_MONEY, th.getMessage());
            }
        }, InitTransferOTC.Param.forTransferOTCInit(currencyAmountModel.MyBillsEntityDataFactory, payMethodModel.moveToNextValue));
    }

    @Override // id.dana.sendmoney.namecheck.SendMoneySummaryContract.Presenter
    public final void getAuthRequestContext(final RecipientModel recipientModel, final CurrencyAmountModel currencyAmountModel, final PayMethodModel payMethodModel, final String str, final VoucherModel voucherModel) {
        this.BuiltInFictitiousFunctionClassFactory.showProgress();
        SendMoneyNameCheck sendMoneyNameCheck = this.newProxyInstance;
        DefaultObserver<WithdrawNameCheck> defaultObserver = new DefaultObserver<WithdrawNameCheck>() { // from class: id.dana.sendmoney.namecheck.SendMoneySummaryPresenter.4
            {
                SendMoneySummaryPresenter.this = this;
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                WithdrawNameCheck withdrawNameCheck = (WithdrawNameCheck) obj;
                if (withdrawNameCheck != null) {
                    SendMoneyBankMapper unused = SendMoneySummaryPresenter.this.GetContactSyncConfig;
                    WithdrawNameCheckModel KClassImpl$Data$declaredNonStaticMembers$2 = SendMoneyBankMapper.KClassImpl$Data$declaredNonStaticMembers$2(withdrawNameCheck);
                    ConfirmationMapper confirmationMapper = SendMoneySummaryPresenter.this.MyBillsEntityDataFactory;
                    RecipientModel recipientModel2 = recipientModel;
                    CurrencyAmountModel currencyAmountModel2 = currencyAmountModel;
                    PayMethodModel payMethodModel2 = payMethodModel;
                    String str2 = str;
                    VoucherModel voucherModel2 = voucherModel;
                    ConfirmationModel authRequestContext = ConfirmationMapper.getAuthRequestContext(recipientModel2, payMethodModel2);
                    authRequestContext.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext);
                    authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(recipientModel2.getErrorConfigVersion);
                    authRequestContext.isLayoutRequested(KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory);
                    authRequestContext.scheduleImpl(recipientModel2.BuiltInFictitiousFunctionClassFactory());
                    authRequestContext.getErrorConfigVersion(currencyAmountModel2.MyBillsEntityDataFactory);
                    authRequestContext.DatabaseTableConfigUtil(currencyAmountModel2.BuiltInFictitiousFunctionClassFactory);
                    authRequestContext.newProxyInstance(ConfirmationType.Destination.BANK);
                    authRequestContext.GetContactSyncConfig(str2);
                    authRequestContext.SubSequence(payMethodModel2.NetworkUserEntityData$$ExternalSyntheticLambda1);
                    authRequestContext.C(ConfirmationMapper.MyBillsEntityDataFactory(payMethodModel2));
                    authRequestContext.VerifyPinStateManager$executeRiskChallenge$2$1(payMethodModel2.PlaceComponentResult());
                    authRequestContext.readMicros(payMethodModel2.getAuthRequestContext);
                    authRequestContext.getCallingPid(payMethodModel2.MyBillsEntityDataFactory(confirmationMapper.KClassImpl$Data$declaredNonStaticMembers$2));
                    authRequestContext.MyBillsEntityDataFactory(payMethodModel2.BuiltInFictitiousFunctionClassFactory());
                    authRequestContext.getSupportButtonTintMode(payMethodModel2.lookAheadTest);
                    ConfirmationMapper.BuiltInFictitiousFunctionClassFactory(recipientModel2, payMethodModel2, authRequestContext);
                    authRequestContext.initRecordTimeStamp(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2);
                    authRequestContext.B(recipientModel2.DatabaseTableConfigUtil);
                    authRequestContext.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory);
                    authRequestContext.D(recipientModel2.initRecordTimeStamp);
                    authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda7(payMethodModel2.moveToNextValue);
                    authRequestContext.PrepareContext(recipientModel2.NetworkUserEntityData$$ExternalSyntheticLambda3);
                    authRequestContext.moveToNextValue(recipientModel2.getAuthRequestContext);
                    authRequestContext.BuiltInFictitiousFunctionClassFactory(payMethodModel2.isLayoutRequested);
                    authRequestContext.PlaceComponentResult((int) payMethodModel2.scheduleImpl);
                    authRequestContext.BottomSheetCardBindingView$watcherCardNumberView$1(recipientModel2.FragmentBottomSheetPaymentSettingBinding);
                    authRequestContext.getAuthRequestContext(recipientModel2.NetworkUserEntityData$$ExternalSyntheticLambda1);
                    authRequestContext.MyBillsEntityDataFactory(recipientModel2.getErrorConfigVersion());
                    ConfirmationMapper.BuiltInFictitiousFunctionClassFactory(voucherModel2, authRequestContext);
                    SendMoneySummaryPresenter.this.getAuthRequestContext(authRequestContext);
                    return;
                }
                SendMoneySummaryPresenter.this.BuiltInFictitiousFunctionClassFactory.onError(ErrorUtil.BuiltInFictitiousFunctionClassFactory(SendMoneySummaryPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2));
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                SendMoneyErrorHelper sendMoneyErrorHelper = SendMoneyErrorHelper.INSTANCE;
                String asString = SendMoneyErrorHelper.BuiltInFictitiousFunctionClassFactory(th).BuiltInFictitiousFunctionClassFactory.asString(SendMoneySummaryPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2);
                SendMoneySummaryPresenter.this.BuiltInFictitiousFunctionClassFactory.dismissProgress();
                SendMoneySummaryPresenter.this.BuiltInFictitiousFunctionClassFactory.onError(asString);
                StringBuilder sb = new StringBuilder();
                sb.append("nameCheck error: ");
                sb.append(th.toString());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SENDMONEY_NAMECHECK_TAG, DanaLogConstants.Prefix.NAME_CHECK, sb.toString());
                CrashlyticsLogUtil.PlaceComponentResult(DanaLogConstants.TAG.SENDMONEY_NAMECHECK_TAG, th.getMessage(), th);
                SendMoneySummaryPresenter.this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(TrackerDataKey.NetworkErrorOperationTypeProperty.WITHDRAW_NAME_CHECK, asString, "Send Money Confirm", th);
            }
        };
        NameCheckParam nameCheckParam = new NameCheckParam();
        if (!TextUtils.isEmpty(recipientModel.lookAheadTest())) {
            nameCheckParam.setSavedAccount(true);
            nameCheckParam.setSavedAccountHolderName(recipientModel.PlaceComponentResult());
        }
        nameCheckParam.setInstId(recipientModel.KClassImpl$Data$declaredNonStaticMembers$2());
        nameCheckParam.setAmountToSent(currencyAmountModel.MyBillsEntityDataFactory);
        nameCheckParam.setSenderName(recipientModel.initRecordTimeStamp);
        nameCheckParam.setCardIndexNo(recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda8);
        nameCheckParam.setCardNo(recipientModel.getErrorConfigVersion);
        nameCheckParam.setWithdrawInstLocalName(recipientModel.BuiltInFictitiousFunctionClassFactory);
        nameCheckParam.setWithdrawPayMethod(recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda2);
        nameCheckParam.setWithdrawPayOption(recipientModel.DatabaseTableConfigUtil);
        nameCheckParam.setCardCredential("");
        nameCheckParam.setFundAmount(new CurrencyAmount(currencyAmountModel.MyBillsEntityDataFactory, currencyAmountModel.BuiltInFictitiousFunctionClassFactory));
        sendMoneyNameCheck.execute(defaultObserver, SendMoneyNameCheck.Params.forSendMoneyNameCheck(nameCheckParam));
    }

    @Override // id.dana.sendmoney.namecheck.SendMoneySummaryContract.Presenter
    public final void getAuthRequestContext(RecipientModel recipientModel, CurrencyAmountModel currencyAmountModel, PayMethodModel payMethodModel, String str, String str2, String str3, VoucherModel voucherModel) {
        ConfirmationMapper confirmationMapper = this.MyBillsEntityDataFactory;
        ConfirmationModel authRequestContext = ConfirmationMapper.getAuthRequestContext(recipientModel, payMethodModel);
        authRequestContext.PlaceComponentResult(confirmationMapper.KClassImpl$Data$declaredNonStaticMembers$2.getString(R.string.chat));
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(recipientModel.getErrorConfigVersion);
        authRequestContext.isLayoutRequested(recipientModel.getErrorConfigVersion);
        authRequestContext.getErrorConfigVersion(currencyAmountModel.MyBillsEntityDataFactory);
        authRequestContext.DatabaseTableConfigUtil(currencyAmountModel.BuiltInFictitiousFunctionClassFactory);
        authRequestContext.scheduleImpl(recipientModel.BuiltInFictitiousFunctionClassFactory());
        authRequestContext.newProxyInstance(ConfirmationType.Destination.LINK);
        authRequestContext.GetContactSyncConfig(str3);
        authRequestContext.SubSequence(payMethodModel.NetworkUserEntityData$$ExternalSyntheticLambda1);
        authRequestContext.C(ConfirmationMapper.MyBillsEntityDataFactory(payMethodModel));
        authRequestContext.VerifyPinStateManager$executeRiskChallenge$2$1(payMethodModel.PlaceComponentResult());
        authRequestContext.readMicros(payMethodModel.getAuthRequestContext);
        authRequestContext.getCallingPid(payMethodModel.MyBillsEntityDataFactory(confirmationMapper.KClassImpl$Data$declaredNonStaticMembers$2));
        authRequestContext.MyBillsEntityDataFactory(payMethodModel.BuiltInFictitiousFunctionClassFactory());
        authRequestContext.MyBillsEntityDataFactory(str2);
        authRequestContext.getAuthRequestContext(str);
        ConfirmationMapper.BuiltInFictitiousFunctionClassFactory(recipientModel, payMethodModel, authRequestContext);
        authRequestContext.B(recipientModel.DatabaseTableConfigUtil);
        authRequestContext.D(recipientModel.initRecordTimeStamp);
        authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda7(payMethodModel.moveToNextValue);
        authRequestContext.getSupportButtonTintMode(payMethodModel.lookAheadTest);
        authRequestContext.BuiltInFictitiousFunctionClassFactory(payMethodModel.isLayoutRequested);
        authRequestContext.PlaceComponentResult((int) payMethodModel.scheduleImpl);
        ConfirmationMapper.BuiltInFictitiousFunctionClassFactory(voucherModel, authRequestContext);
        getAuthRequestContext(authRequestContext);
    }

    @Override // id.dana.sendmoney.namecheck.SendMoneySummaryContract.Presenter
    public final void lookAheadTest() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.execute(new DefaultObserver<UserInfoResponse>() { // from class: id.dana.sendmoney.namecheck.SendMoneySummaryPresenter.5
            {
                SendMoneySummaryPresenter.this = this;
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                SendMoneySummaryPresenter.this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory((UserInfoResponse) obj);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.TAG.SEND_MONEY_TAG);
                sb.append(getClass().getName());
                sb.append(":onErrorUserInfoWithKyc");
                sb.append(th.toString());
                DanaLog.BuiltInFictitiousFunctionClassFactory(NetworkSendRiskEventEntityData.TAG, sb.toString());
            }
        }, GetUserInfoWithKyc.Params.forParams(false));
    }

    @Override // id.dana.sendmoney.namecheck.SendMoneySummaryContract.Presenter
    public final void getAuthRequestContext() {
        this.lookAheadTest.execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.sendmoney.namecheck.SendMoneySummaryPresenter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SendMoneySummaryPresenter.this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(((Boolean) obj).toString());
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.sendmoney.namecheck.SendMoneySummaryPresenter$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SendMoneySummaryPresenter sendMoneySummaryPresenter = SendMoneySummaryPresenter.this;
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.TAG.SEND_MONEY_TAG);
                sb.append(sendMoneySummaryPresenter.getClass().getName());
                sb.append(":onErrorGetSplitConfig");
                sb.append(((Throwable) obj).toString());
                DanaLog.BuiltInFictitiousFunctionClassFactory(NetworkSendRiskEventEntityData.TAG, sb.toString());
                return Unit.INSTANCE;
            }
        });
    }

    @Override // id.dana.sendmoney.namecheck.SendMoneySummaryContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.getErrorConfigVersion.execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.sendmoney.namecheck.SendMoneySummaryPresenter$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SendMoneySummaryPresenter.this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory((String) obj);
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.sendmoney.namecheck.SendMoneySummaryPresenter$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SendMoneySummaryPresenter sendMoneySummaryPresenter = SendMoneySummaryPresenter.this;
                Throwable th = (Throwable) obj;
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.TAG.SEND_MONEY_TAG);
                sb.append(sendMoneySummaryPresenter.getClass().getName());
                sb.append(":onError");
                DanaLog.BuiltInFictitiousFunctionClassFactory(NetworkSendRiskEventEntityData.TAG, sb.toString());
                return Unit.INSTANCE;
            }
        });
    }

    @Override // id.dana.sendmoney.namecheck.SendMoneySummaryContract.Presenter
    public final void MyBillsEntityDataFactory(String str) {
        this.initRecordTimeStamp.execute(SaveStateSendMoneyShareFeed.Param.create(str), new Function1() { // from class: id.dana.sendmoney.namecheck.SendMoneySummaryPresenter$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit unit;
                Boolean bool = (Boolean) obj;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, new Function1() { // from class: id.dana.sendmoney.namecheck.SendMoneySummaryPresenter$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SendMoneySummaryPresenter sendMoneySummaryPresenter = SendMoneySummaryPresenter.this;
                Throwable th = (Throwable) obj;
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.TAG.SEND_MONEY_TAG);
                sb.append(sendMoneySummaryPresenter.getClass().getName());
                sb.append(":onError");
                DanaLog.BuiltInFictitiousFunctionClassFactory(NetworkSendRiskEventEntityData.TAG, sb.toString());
                return Unit.INSTANCE;
            }
        });
    }

    @Override // id.dana.sendmoney.namecheck.SendMoneySummaryContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.scheduleImpl.execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.sendmoney.namecheck.SendMoneySummaryPresenter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SendMoneySummaryContract.View view = SendMoneySummaryPresenter.this.BuiltInFictitiousFunctionClassFactory;
                ArrayList arrayList = new ArrayList();
                for (String str : (List) obj) {
                    if (CashierFeatureEnum.PHONE.getCashierFeature().equals(str)) {
                        arrayList.add(CashierFeatureEnum.PHONE.getRecipientType());
                    } else if (CashierFeatureEnum.BANK.getCashierFeature().equals(str)) {
                        arrayList.add(CashierFeatureEnum.BANK.getRecipientType());
                    } else if (CashierFeatureEnum.CHAT.getCashierFeature().equals(str)) {
                        arrayList.add(CashierFeatureEnum.CHAT.getRecipientType());
                    } else if (CashierFeatureEnum.EXTERNAL.getCashierFeature().equals(str)) {
                        arrayList.add(CashierFeatureEnum.EXTERNAL.getRecipientType());
                    }
                }
                view.getAuthRequestContext(arrayList);
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.sendmoney.namecheck.SendMoneySummaryPresenter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SendMoneySummaryPresenter sendMoneySummaryPresenter = SendMoneySummaryPresenter.this;
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.TAG.SEND_MONEY_TAG);
                sb.append(sendMoneySummaryPresenter.getClass().getName());
                sb.append(":onErrorGetSplitConfig");
                sb.append(((Throwable) obj).toString());
                DanaLog.BuiltInFictitiousFunctionClassFactory(NetworkSendRiskEventEntityData.TAG, sb.toString());
                return Unit.INSTANCE;
            }
        });
    }

    public void getAuthRequestContext(final ConfirmationModel confirmationModel) {
        if (!PermissionHelper.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, "android.permission.READ_CONTACTS")) {
            this.BuiltInFictitiousFunctionClassFactory.dismissProgress();
            this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(confirmationModel);
            return;
        }
        final ContactProvider contactProvider = new ContactProvider(this.KClassImpl$Data$declaredNonStaticMembers$2.getContentResolver(), "");
        this.DatabaseTableConfigUtil = (DefaultObserver) Observable.fromCallable(new Callable() { // from class: id.dana.sendmoney.contact.provider.ContactProvider$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ContactProvider.this.PlaceComponentResult();
            }
        }).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribeWith(new DefaultObserver<Integer>() { // from class: id.dana.sendmoney.namecheck.SendMoneySummaryPresenter.6
            {
                SendMoneySummaryPresenter.this = this;
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                SendMoneySummaryPresenter.this.BuiltInFictitiousFunctionClassFactory.dismissProgress();
                confirmationModel.KClassImpl$Data$declaredNonStaticMembers$2(((Integer) obj).intValue());
                SendMoneySummaryPresenter.MyBillsEntityDataFactory(SendMoneySummaryPresenter.this, confirmationModel);
                SendMoneySummaryPresenter.KClassImpl$Data$declaredNonStaticMembers$2(SendMoneySummaryPresenter.this);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                SendMoneySummaryPresenter.this.BuiltInFictitiousFunctionClassFactory.dismissProgress();
                SendMoneySummaryPresenter.MyBillsEntityDataFactory(SendMoneySummaryPresenter.this, confirmationModel);
                SendMoneySummaryPresenter.KClassImpl$Data$declaredNonStaticMembers$2(SendMoneySummaryPresenter.this);
            }
        });
    }

    @Override // id.dana.sendmoney.namecheck.SendMoneySummaryContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.moveToNextValue.execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.sendmoney.namecheck.SendMoneySummaryPresenter$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SendMoneySummaryPresenter.this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext((SmartFrictionConfig) obj);
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.sendmoney.namecheck.SendMoneySummaryPresenter$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SendMoneySummaryPresenter sendMoneySummaryPresenter = SendMoneySummaryPresenter.this;
                StringBuilder sb = new StringBuilder();
                sb.append("Split");
                sb.append(sendMoneySummaryPresenter.getClass().getName());
                sb.append(":onErrorGetSplitConfig");
                sb.append(((Throwable) obj).toString());
                DanaLog.BuiltInFictitiousFunctionClassFactory(NetworkSendRiskEventEntityData.TAG, sb.toString());
                return Unit.INSTANCE;
            }
        });
    }

    @Override // id.dana.sendmoney.namecheck.SendMoneySummaryContract.Presenter
    public final void PlaceComponentResult() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.sendmoney.namecheck.SendMoneySummaryPresenter$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SendMoneySummaryPresenter.this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory((List) obj);
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.sendmoney.namecheck.SendMoneySummaryPresenter$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SendMoneySummaryPresenter sendMoneySummaryPresenter = SendMoneySummaryPresenter.this;
                StringBuilder sb = new StringBuilder();
                sb.append("Split");
                sb.append(sendMoneySummaryPresenter.getClass().getName());
                sb.append(":onErrorGetSplitConfig");
                sb.append(((Throwable) obj).toString());
                DanaLog.BuiltInFictitiousFunctionClassFactory(NetworkSendRiskEventEntityData.TAG, sb.toString());
                return Unit.INSTANCE;
            }
        });
    }

    static /* synthetic */ void MyBillsEntityDataFactory(SendMoneySummaryPresenter sendMoneySummaryPresenter, ConfirmationModel confirmationModel) {
        sendMoneySummaryPresenter.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(confirmationModel);
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(SendMoneySummaryPresenter sendMoneySummaryPresenter) {
        DefaultObserver<Integer> defaultObserver = sendMoneySummaryPresenter.DatabaseTableConfigUtil;
        if (defaultObserver != null) {
            defaultObserver.dispose();
            sendMoneySummaryPresenter.DatabaseTableConfigUtil = null;
        }
    }

    @Override // id.dana.sendmoney.namecheck.SendMoneySummaryContract.Presenter
    public final void PlaceComponentResult(CurrencyAmountModel currencyAmountModel, PayMethodModel payMethodModel) {
        if (payMethodModel != null) {
            if (currencyAmountModel.KClassImpl$Data$declaredNonStaticMembers$2(payMethodModel.DatabaseTableConfigUtil)) {
                this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(payMethodModel.DatabaseTableConfigUtil.MyBillsEntityDataFactory);
            } else if (currencyAmountModel.getAuthRequestContext(payMethodModel.GetContactSyncConfig)) {
                this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(payMethodModel.GetContactSyncConfig.MyBillsEntityDataFactory);
            } else {
                this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }
    }
}
