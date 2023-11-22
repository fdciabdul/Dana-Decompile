package id.dana.sendmoney.confirmation;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.griver.beehive.lottie.player.TimeUtils;
import id.dana.R;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.constants.ErrorCode;
import id.dana.data.util.NumberUtils;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.card.interactor.SaveLastCardUsed;
import id.dana.domain.h5event.interactor.GetCheckoutH5Event;
import id.dana.domain.recentcontact.interactor.SaveRecentContact;
import id.dana.domain.recentrecipient.interactor.GetRecentTransaction;
import id.dana.domain.sendmoney.interactor.CheckTransferX2PFeature;
import id.dana.domain.sendmoney.interactor.ConfirmSendMoney;
import id.dana.domain.sendmoney.interactor.ConfirmSendMoneyContact;
import id.dana.domain.sendmoney.interactor.ConfirmSendMoneyOTC;
import id.dana.domain.sendmoney.interactor.GetRefundTimeout;
import id.dana.domain.sendmoney.model.SendMoneyConfirm;
import id.dana.domain.sendmoney.model.SendMoneyConfirmOTCParam;
import id.dana.domain.sendmoney.model.TransferParticipant;
import id.dana.domain.user.CurrencyAmount;
import id.dana.domain.user.interactor.GetSingleBalance;
import id.dana.sendmoney.TransferType;
import id.dana.sendmoney.confirmation.SendMoneyConfirmationContract;
import id.dana.sendmoney.mapper.ConfirmToContactMapper;
import id.dana.sendmoney.mapper.RecentRecipientModelMapper;
import id.dana.sendmoney.mapper.SendMoneyConfirmModelMapper;
import id.dana.sendmoney.model.ConfirmToPeerParamModel;
import id.dana.sendmoney.model.ConfirmationModel;
import id.dana.sendmoney.model.RecentRecipientModel;
import id.dana.sendmoney.model.WithdrawOTCModel;
import id.dana.sendmoney.util.SendMoneyErrorHelper;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.ErrorUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@PerActivity
/* loaded from: classes5.dex */
public class SendMoneyConfirmationPresenter implements SendMoneyConfirmationContract.Presenter {
    final RecentRecipientModelMapper BuiltInFictitiousFunctionClassFactory;
    private GetSingleBalance DatabaseTableConfigUtil;
    private final DateTimeUtil GetContactSyncConfig;
    CheckTransferX2PFeature KClassImpl$Data$declaredNonStaticMembers$2;
    ConfirmSendMoneyContact MyBillsEntityDataFactory;
    private final Context NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final GetRecentTransaction NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final GetRefundTimeout NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final SaveLastCardUsed NetworkUserEntityData$$ExternalSyntheticLambda8;
    ConfirmSendMoneyOTC PlaceComponentResult;
    ConfirmToContactMapper getAuthRequestContext;
    private final ConfirmSendMoney getErrorConfigVersion;
    private final GetCheckoutH5Event initRecordTimeStamp;
    SendMoneyConfirmModelMapper lookAheadTest;
    final SendMoneyConfirmationContract.View moveToNextValue;
    SaveRecentContact scheduleImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public SendMoneyConfirmationPresenter(ConfirmSendMoney confirmSendMoney, Context context, GetRefundTimeout getRefundTimeout, SendMoneyConfirmationContract.View view, SendMoneyConfirmationData sendMoneyConfirmationData, DateTimeUtil dateTimeUtil, GetRecentTransaction getRecentTransaction, RecentRecipientModelMapper recentRecipientModelMapper, GetSingleBalance getSingleBalance) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = context;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = getRefundTimeout;
        this.moveToNextValue = view;
        this.initRecordTimeStamp = sendMoneyConfirmationData.KClassImpl$Data$declaredNonStaticMembers$2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = sendMoneyConfirmationData.BuiltInFictitiousFunctionClassFactory;
        this.GetContactSyncConfig = dateTimeUtil;
        this.getErrorConfigVersion = confirmSendMoney;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = getRecentTransaction;
        this.BuiltInFictitiousFunctionClassFactory = recentRecipientModelMapper;
        this.DatabaseTableConfigUtil = getSingleBalance;
    }

    @Override // id.dana.sendmoney.confirmation.SendMoneyConfirmationContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final ConfirmToPeerParamModel confirmToPeerParamModel, final String str, final String str2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(new DefaultObserver<Boolean>() { // from class: id.dana.sendmoney.confirmation.SendMoneyConfirmationPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                if (((Boolean) obj).booleanValue()) {
                    SendMoneyConfirmationPresenter.MyBillsEntityDataFactory(SendMoneyConfirmationPresenter.this, confirmToPeerParamModel, str2);
                } else {
                    SendMoneyConfirmationPresenter.PlaceComponentResult(SendMoneyConfirmationPresenter.this, confirmToPeerParamModel, str, str2);
                }
            }
        });
    }

    @Override // id.dana.sendmoney.confirmation.SendMoneyConfirmationContract.Presenter
    public final void PlaceComponentResult(final ConfirmationModel confirmationModel, final String str) {
        this.moveToNextValue.showProgress();
        ConfirmSendMoneyOTC confirmSendMoneyOTC = this.PlaceComponentResult;
        DefaultObserver<SendMoneyConfirm> defaultObserver = new DefaultObserver<SendMoneyConfirm>() { // from class: id.dana.sendmoney.confirmation.SendMoneyConfirmationPresenter.2
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                SendMoneyConfirm sendMoneyConfirm = (SendMoneyConfirm) obj;
                SendMoneyConfirmationPresenter.this.moveToNextValue.dismissProgress();
                if (confirmationModel.J()) {
                    SendMoneyConfirmationPresenter.this.moveToNextValue.PlaceComponentResult(sendMoneyConfirm);
                } else {
                    SendMoneyConfirmationPresenter.this.moveToNextValue.BuiltInFictitiousFunctionClassFactory(SendMoneyConfirmationPresenter.this.lookAheadTest.apply(sendMoneyConfirm).getAuthRequestContext(confirmationModel.NetworkUserEntityData$$ExternalSyntheticLambda6(), confirmationModel.readMicros(), str, confirmationModel.NetworkUserEntityData$$ExternalSyntheticLambda0()));
                }
                SendMoneyConfirmationPresenter.this.MyBillsEntityDataFactory(null, null, null, null, confirmationModel.NetworkUserEntityData$$ExternalSyntheticLambda6(), 0, false, null);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                SendMoneyConfirmationPresenter.this.moveToNextValue.dismissProgress();
                SendMoneyConfirmationPresenter.PlaceComponentResult(SendMoneyConfirmationPresenter.this, th);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.TRANSFER_MONEY, th.getMessage());
            }
        };
        WithdrawOTCModel G = confirmationModel.G();
        TransferParticipant transferParticipant = new TransferParticipant();
        transferParticipant.setLoginId(confirmationModel.BuiltInFictitiousFunctionClassFactory());
        transferParticipant.setNickname(confirmationModel.KClassImpl$Data$declaredNonStaticMembers$2());
        transferParticipant.setDateOfBirth(confirmationModel.initRecordTimeStamp());
        SendMoneyConfirmOTCParam sendMoneyConfirmOTCParam = new SendMoneyConfirmOTCParam();
        sendMoneyConfirmOTCParam.setAcceptTimeoutUnit(confirmationModel.MyBillsEntityDataFactory());
        sendMoneyConfirmOTCParam.setAcceptTimeoutValue(confirmationModel.getAuthRequestContext());
        sendMoneyConfirmOTCParam.setAmount(confirmationModel.getErrorConfigVersion());
        sendMoneyConfirmOTCParam.setFundType(confirmationModel.NetworkUserEntityData$$ExternalSyntheticLambda8());
        sendMoneyConfirmOTCParam.setInstId(G.getAuthRequestContext);
        sendMoneyConfirmOTCParam.setPayeeInfo(transferParticipant);
        sendMoneyConfirmOTCParam.setPayMethod(G.BuiltInFictitiousFunctionClassFactory);
        sendMoneyConfirmOTCParam.setPayOption(G.KClassImpl$Data$declaredNonStaticMembers$2);
        sendMoneyConfirmOTCParam.setWithdrawInstId(G.MyBillsEntityDataFactory);
        sendMoneyConfirmOTCParam.setWithdrawInstLocalName(G.PlaceComponentResult);
        sendMoneyConfirmOTCParam.setWithdrawInstName(G.lookAheadTest);
        sendMoneyConfirmOTCParam.setWithdrawPayMethod(G.getErrorConfigVersion);
        sendMoneyConfirmOTCParam.setWithdrawPayOption(G.scheduleImpl);
        sendMoneyConfirmOTCParam.setTransferMethod(confirmationModel.getOnBoardingScenario());
        confirmSendMoneyOTC.execute(defaultObserver, ConfirmSendMoneyOTC.Params.forConfirmSendMoneyOTC(sendMoneyConfirmOTCParam));
    }

    @Override // id.dana.sendmoney.confirmation.SendMoneyConfirmationContract.Presenter
    public final void MyBillsEntityDataFactory(final String str, final String str2, final String str3, final String str4, final String str5, final int i, final boolean z, String str6) {
        if (str6 != null && str6.equals(TransferType.SINGLE_GENERAL_TRANSFER)) {
            if (TextUtils.isEmpty(str4)) {
                return;
            }
            if (!TextUtils.isEmpty(str3)) {
                PlaceComponentResult(str2, str3, str4, str, i, z);
            }
            PlaceComponentResult(str5);
            return;
        }
        this.initRecordTimeStamp.execute(new DefaultObserver<Boolean>() { // from class: id.dana.sendmoney.confirmation.SendMoneyConfirmationPresenter.3
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                Boolean bool = (Boolean) obj;
                SendMoneyConfirmationPresenter.this.moveToNextValue.MyBillsEntityDataFactory(bool.booleanValue());
                if (!bool.booleanValue() || TextUtils.isEmpty(str4)) {
                    return;
                }
                if (!TextUtils.isEmpty(str3)) {
                    SendMoneyConfirmationPresenter.this.PlaceComponentResult(str2, str3, str4, str, i, z);
                }
                SendMoneyConfirmationPresenter.this.PlaceComponentResult(str5);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                SendMoneyConfirmationPresenter.this.moveToNextValue.dismissProgress();
                SendMoneyConfirmationPresenter.this.moveToNextValue.onError(ErrorUtil.PlaceComponentResult(th, SendMoneyConfirmationPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0));
            }
        });
    }

    /* renamed from: id.dana.sendmoney.confirmation.SendMoneyConfirmationPresenter$4  reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass4 extends DefaultObserver<Long> {
        final /* synthetic */ SendMoneyConfirmationPresenter BuiltInFictitiousFunctionClassFactory;

        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
        public /* synthetic */ void onNext(Object obj) {
            String str;
            String str2;
            String str3;
            String str4;
            DateTimeUtil dateTimeUtil = this.BuiltInFictitiousFunctionClassFactory.GetContactSyncConfig;
            long longValue = ((Long) obj).longValue();
            int i = (int) (longValue / 604800);
            int i2 = (int) ((longValue % 604800) / TimeUtils.DAY_TO_SECOND);
            int i3 = (int) ((longValue % TimeUtils.DAY_TO_SECOND) / 3600);
            int i4 = (int) ((longValue % 3600) / 60);
            int i5 = (int) ((longValue % 60) / 1);
            StringBuilder sb = new StringBuilder();
            if (i > 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(dateTimeUtil.PlaceComponentResult.getResources().getQuantityString(R.plurals.f46802131820566, i, Integer.valueOf(i)));
                sb2.append(" ");
                str = sb2.toString();
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(" ");
            if (i2 > 0) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(dateTimeUtil.PlaceComponentResult.getResources().getQuantityString(R.plurals.f46622131820545, i2, Integer.valueOf(i2)));
                sb3.append(" ");
                str2 = sb3.toString();
            } else {
                str2 = "";
            }
            sb.append(str2);
            sb.append(" ");
            if (i3 > 0) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(dateTimeUtil.PlaceComponentResult.getResources().getQuantityString(R.plurals.f46662131820550, i3, Integer.valueOf(i3)));
                sb4.append(" ");
                str3 = sb4.toString();
            } else {
                str3 = "";
            }
            sb.append(str3);
            sb.append(" ");
            if (i4 > 0) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(dateTimeUtil.PlaceComponentResult.getResources().getQuantityString(R.plurals.f46672131820552, i4, Integer.valueOf(i4)));
                sb5.append(" ");
                str4 = sb5.toString();
            } else {
                str4 = "";
            }
            sb.append(str4);
            sb.append(" ");
            sb.append((i5 > 0 ? dateTimeUtil.PlaceComponentResult.getResources().getQuantityString(R.plurals.f46752131820561, i5, Integer.valueOf(i5)) : "").trim());
            this.BuiltInFictitiousFunctionClassFactory.moveToNextValue.PlaceComponentResult(sb.toString());
        }
    }

    @Override // id.dana.sendmoney.confirmation.SendMoneyConfirmationContract.Presenter
    public final void MyBillsEntityDataFactory(final String str, String str2) {
        int i;
        if (str2.equals("bank")) {
            i = 1;
        } else {
            i = str2.equals("contact") ? 0 : 99;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.execute(GetRecentTransaction.Params.forGetLastTransferDate(str, Integer.valueOf(i)), new Function1() { // from class: id.dana.sendmoney.confirmation.SendMoneyConfirmationPresenter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SendMoneyConfirmationPresenter sendMoneyConfirmationPresenter = SendMoneyConfirmationPresenter.this;
                String str3 = str;
                RecentRecipientModelMapper recentRecipientModelMapper = sendMoneyConfirmationPresenter.BuiltInFictitiousFunctionClassFactory;
                List<RecentRecipientModel> MyBillsEntityDataFactory = RecentRecipientModelMapper.MyBillsEntityDataFactory((List) obj, 0);
                if (!MyBillsEntityDataFactory.isEmpty() && !TextUtils.isEmpty(str3)) {
                    sendMoneyConfirmationPresenter.moveToNextValue.MyBillsEntityDataFactory(Long.valueOf(MyBillsEntityDataFactory.get(0).NetworkUserEntityData$$ExternalSyntheticLambda0));
                    return null;
                }
                sendMoneyConfirmationPresenter.moveToNextValue.BuiltInFictitiousFunctionClassFactory();
                return null;
            }
        }, new Function1() { // from class: id.dana.sendmoney.confirmation.SendMoneyConfirmationPresenter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Throwable th = (Throwable) obj;
                SendMoneyConfirmationPresenter.this.moveToNextValue.BuiltInFictitiousFunctionClassFactory();
                return null;
            }
        });
    }

    @Override // id.dana.sendmoney.confirmation.SendMoneyConfirmationContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.DatabaseTableConfigUtil.execute(new GetSingleBalance.Param(true), new Function1() { // from class: id.dana.sendmoney.confirmation.SendMoneyConfirmationPresenter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit unit;
                CurrencyAmount currencyAmount = (CurrencyAmount) obj;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, new Function1() { // from class: id.dana.sendmoney.confirmation.SendMoneyConfirmationPresenter$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit unit;
                Throwable th = (Throwable) obj;
                unit = Unit.INSTANCE;
                return unit;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PlaceComponentResult(String str, String str2, String str3, String str4, int i, boolean z) {
        this.scheduleImpl.execute(new DefaultObserver<Boolean>() { // from class: id.dana.sendmoney.confirmation.SendMoneyConfirmationPresenter.7
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.SAVE_RECENT_CONTACT, DanaLogConstants.ExceptionType.SAVE_RECENT_TRANSACTION_EXCEPTION, th.getMessage());
            }
        }, SaveRecentContact.Params.forSaveRecentContact(str, str2, str3, str4, i, z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PlaceComponentResult(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.execute(SaveLastCardUsed.Params.forDefaultCard(str), new Function1() { // from class: id.dana.sendmoney.confirmation.SendMoneyConfirmationPresenter$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit unit;
                Boolean bool = (Boolean) obj;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, new Function1() { // from class: id.dana.sendmoney.confirmation.SendMoneyConfirmationPresenter$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit unit;
                Throwable th = (Throwable) obj;
                unit = Unit.INSTANCE;
                return unit;
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.MyBillsEntityDataFactory.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.dispose();
        this.initRecordTimeStamp.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.dispose();
        this.getErrorConfigVersion.dispose();
        this.scheduleImpl.dispose();
        this.PlaceComponentResult.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.dispose();
        this.DatabaseTableConfigUtil.dispose();
    }

    static /* synthetic */ void MyBillsEntityDataFactory(SendMoneyConfirmationPresenter sendMoneyConfirmationPresenter, final ConfirmToPeerParamModel confirmToPeerParamModel, final String str) {
        sendMoneyConfirmationPresenter.moveToNextValue.showProgress();
        ConfirmSendMoneyContact confirmSendMoneyContact = sendMoneyConfirmationPresenter.MyBillsEntityDataFactory;
        DefaultObserver<SendMoneyConfirm> defaultObserver = new DefaultObserver<SendMoneyConfirm>() { // from class: id.dana.sendmoney.confirmation.SendMoneyConfirmationPresenter.5
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                SendMoneyConfirm sendMoneyConfirm = (SendMoneyConfirm) obj;
                SendMoneyConfirmationPresenter.this.moveToNextValue.dismissProgress();
                if (confirmToPeerParamModel.BuiltInFictitiousFunctionClassFactory()) {
                    SendMoneyConfirmationPresenter.this.moveToNextValue.PlaceComponentResult(sendMoneyConfirm);
                } else {
                    SendMoneyConfirmationPresenter.this.moveToNextValue.BuiltInFictitiousFunctionClassFactory(SendMoneyConfirmationPresenter.this.lookAheadTest.apply(sendMoneyConfirm).getAuthRequestContext(confirmToPeerParamModel.NetworkUserEntityData$$ExternalSyntheticLambda0, confirmToPeerParamModel.NetworkUserEntityData$$ExternalSyntheticLambda2, str, confirmToPeerParamModel.KClassImpl$Data$declaredNonStaticMembers$2));
                }
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                SendMoneyConfirmationPresenter.this.moveToNextValue.dismissProgress();
                SendMoneyConfirmationPresenter.PlaceComponentResult(SendMoneyConfirmationPresenter.this, th);
            }
        };
        ConfirmToContactMapper confirmToContactMapper = sendMoneyConfirmationPresenter.getAuthRequestContext;
        confirmSendMoneyContact.execute(defaultObserver, ConfirmSendMoneyContact.Params.forConfirmSendMoneyContact(ConfirmToContactMapper.PlaceComponentResult(confirmToPeerParamModel)));
    }

    static /* synthetic */ void PlaceComponentResult(SendMoneyConfirmationPresenter sendMoneyConfirmationPresenter, final ConfirmToPeerParamModel confirmToPeerParamModel, final String str, final String str2) {
        sendMoneyConfirmationPresenter.moveToNextValue.showProgress();
        sendMoneyConfirmationPresenter.getErrorConfigVersion.execute(new DefaultObserver<SendMoneyConfirm>() { // from class: id.dana.sendmoney.confirmation.SendMoneyConfirmationPresenter.6
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                SendMoneyConfirm sendMoneyConfirm = (SendMoneyConfirm) obj;
                SendMoneyConfirmationPresenter.this.moveToNextValue.dismissProgress();
                if (confirmToPeerParamModel.BuiltInFictitiousFunctionClassFactory()) {
                    SendMoneyConfirmationPresenter.this.moveToNextValue.PlaceComponentResult(sendMoneyConfirm);
                } else {
                    SendMoneyConfirmationPresenter.this.moveToNextValue.BuiltInFictitiousFunctionClassFactory(SendMoneyConfirmationPresenter.this.lookAheadTest.apply(sendMoneyConfirm).getAuthRequestContext(str, confirmToPeerParamModel.NetworkUserEntityData$$ExternalSyntheticLambda2, str2, ""));
                }
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                SendMoneyConfirmationPresenter.this.moveToNextValue.dismissProgress();
                SendMoneyConfirmationPresenter.PlaceComponentResult(SendMoneyConfirmationPresenter.this, th);
            }
        }, ConfirmSendMoney.Params.forSendMoney().currencyAmount(confirmToPeerParamModel.DatabaseTableConfigUtil, confirmToPeerParamModel.initRecordTimeStamp).payeeDetail(confirmToPeerParamModel.BuiltInFictitiousFunctionClassFactory, confirmToPeerParamModel.moveToNextValue, NumberUtils.getCleanPhoneNumberPrefixWithDash(confirmToPeerParamModel.MyBillsEntityDataFactory), confirmToPeerParamModel.lookAheadTest).additionalInfo(confirmToPeerParamModel.getAuthRequestContext, confirmToPeerParamModel.getAuthRequestContext(), confirmToPeerParamModel.NetworkUserEntityData$$ExternalSyntheticLambda2));
    }

    static /* synthetic */ void PlaceComponentResult(SendMoneyConfirmationPresenter sendMoneyConfirmationPresenter, Throwable th) {
        sendMoneyConfirmationPresenter.moveToNextValue.dismissProgress();
        SendMoneyErrorHelper sendMoneyErrorHelper = SendMoneyErrorHelper.INSTANCE;
        if (ErrorCode.KYC_ERROR.equals(SendMoneyErrorHelper.BuiltInFictitiousFunctionClassFactory(th).KClassImpl$Data$declaredNonStaticMembers$2)) {
            sendMoneyConfirmationPresenter.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2();
        } else {
            SendMoneyErrorHelper sendMoneyErrorHelper2 = SendMoneyErrorHelper.INSTANCE;
            String asString = SendMoneyErrorHelper.BuiltInFictitiousFunctionClassFactory(th).BuiltInFictitiousFunctionClassFactory.asString(sendMoneyConfirmationPresenter.NetworkUserEntityData$$ExternalSyntheticLambda0);
            sendMoneyConfirmationPresenter.moveToNextValue.onError(asString);
            sendMoneyConfirmationPresenter.moveToNextValue.BuiltInFictitiousFunctionClassFactory(TrackerDataKey.NetworkErrorOperationTypeProperty.BIZTRANSFER_SUBMIT, asString, "Send Money Confirm", th);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(DanaLogConstants.Prefix.SEND_MONEY_CONFIRMATION_PREFIX);
        sb.append(sendMoneyConfirmationPresenter.getClass().getName());
        sb.append("on Error");
        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SEND_MONEY_TAG, sb.toString(), th);
    }
}
