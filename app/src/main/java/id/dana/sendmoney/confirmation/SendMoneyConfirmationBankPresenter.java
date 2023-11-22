package id.dana.sendmoney.confirmation;

import android.content.Context;
import id.dana.domain.DefaultObserver;
import id.dana.domain.h5event.interactor.GetCheckoutH5Event;
import id.dana.domain.promotion.interactor.DecrementFreeTransferCount;
import id.dana.domain.recentbank.interactor.SaveRecentBank;
import id.dana.domain.sendmoney.interactor.ConfirmSendMoneyBank;
import id.dana.domain.sendmoney.model.SendMoneyConfirm;
import id.dana.sendmoney.confirmation.SendMoneyConfirmationBankContract;
import id.dana.sendmoney.mapper.ConfirmToBankMapper;
import id.dana.sendmoney.mapper.SendMoneyConfirmModelMapper;
import id.dana.sendmoney.model.ConfirmToBankParamModel;
import id.dana.sendmoney.model.RecentBankModel;
import id.dana.utils.ErrorUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.observers.DisposableCompletableObserver;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class SendMoneyConfirmationBankPresenter implements SendMoneyConfirmationBankContract.Presenter {
    private final DecrementFreeTransferCount BuiltInFictitiousFunctionClassFactory;
    private final ConfirmSendMoneyBank KClassImpl$Data$declaredNonStaticMembers$2;
    private final ConfirmToBankMapper MyBillsEntityDataFactory;
    private final SendMoneyConfirmModelMapper NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Context PlaceComponentResult;
    private DisposableCompletableObserver getAuthRequestContext;
    private final GetCheckoutH5Event lookAheadTest;
    private final SaveRecentBank moveToNextValue;
    private final SendMoneyConfirmationBankContract.View scheduleImpl;

    @Inject
    public SendMoneyConfirmationBankPresenter(SendMoneyConfirmationBankContract.View view, ConfirmSendMoneyBank confirmSendMoneyBank, SaveRecentBank saveRecentBank, ConfirmToBankMapper confirmToBankMapper, SendMoneyConfirmModelMapper sendMoneyConfirmModelMapper, GetCheckoutH5Event getCheckoutH5Event, DecrementFreeTransferCount decrementFreeTransferCount, Context context) {
        this.scheduleImpl = view;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = confirmSendMoneyBank;
        this.moveToNextValue = saveRecentBank;
        this.MyBillsEntityDataFactory = confirmToBankMapper;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = sendMoneyConfirmModelMapper;
        this.lookAheadTest = getCheckoutH5Event;
        this.BuiltInFictitiousFunctionClassFactory = decrementFreeTransferCount;
        this.PlaceComponentResult = context;
    }

    @Override // id.dana.sendmoney.confirmation.SendMoneyConfirmationBankContract.Presenter
    public final void getAuthRequestContext(final ConfirmToBankParamModel confirmToBankParamModel, final String str, final String str2) {
        this.scheduleImpl.showProgress();
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(new DefaultObserver<SendMoneyConfirm>() { // from class: id.dana.sendmoney.confirmation.SendMoneyConfirmationBankPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                SendMoneyConfirm sendMoneyConfirm = (SendMoneyConfirm) obj;
                SendMoneyConfirmationBankPresenter.this.scheduleImpl.dismissProgress();
                if (confirmToBankParamModel.getAuthRequestContext()) {
                    SendMoneyConfirmationBankPresenter.this.scheduleImpl.BuiltInFictitiousFunctionClassFactory(sendMoneyConfirm);
                } else {
                    SendMoneyConfirmationBankPresenter.this.scheduleImpl.getAuthRequestContext(SendMoneyConfirmationBankPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0.apply(sendMoneyConfirm).getAuthRequestContext(str, confirmToBankParamModel.lookAheadTest, str2, confirmToBankParamModel.getAuthRequestContext));
                }
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                SendMoneyConfirmationBankPresenter.this.scheduleImpl.dismissProgress();
                SendMoneyConfirmationBankPresenter.this.scheduleImpl.onError(ErrorUtil.PlaceComponentResult(th, SendMoneyConfirmationBankPresenter.this.PlaceComponentResult));
            }
        }, ConfirmSendMoneyBank.Params.forConfirmSendMoneyBank(this.MyBillsEntityDataFactory.apply(confirmToBankParamModel)));
    }

    @Override // id.dana.sendmoney.confirmation.SendMoneyConfirmationBankContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(RecentBankModel recentBankModel) {
        this.moveToNextValue.execute(new DefaultObserver<Boolean>() { // from class: id.dana.sendmoney.confirmation.SendMoneyConfirmationBankPresenter.2
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.SAVE_RECENT_BANK, DanaLogConstants.ExceptionType.SAVE_RECENT_TRANSACTION_EXCEPTION, th.getMessage());
                SendMoneyConfirmationBankContract.View unused = SendMoneyConfirmationBankPresenter.this.scheduleImpl;
            }
        }, SaveRecentBank.Params.forSaveRecentBank(recentBankModel.NetworkUserEntityData$$ExternalSyntheticLambda7, recentBankModel.BuiltInFictitiousFunctionClassFactory, recentBankModel.getAuthRequestContext, recentBankModel.BuiltInFictitiousFunctionClassFactory, recentBankModel.KClassImpl$Data$declaredNonStaticMembers$2, recentBankModel.lookAheadTest, recentBankModel.NetworkUserEntityData$$ExternalSyntheticLambda0, recentBankModel.NetworkUserEntityData$$ExternalSyntheticLambda2, recentBankModel.initRecordTimeStamp, recentBankModel.newProxyInstance, recentBankModel.KClassImpl$Data$declaredNonStaticMembers$2, recentBankModel.PlaceComponentResult, recentBankModel.NetworkUserEntityData$$ExternalSyntheticLambda1, recentBankModel.PrepareContext, recentBankModel.getGetErrorConfigVersion()));
    }

    @Override // id.dana.sendmoney.confirmation.SendMoneyConfirmationBankContract.Presenter
    public final void getAuthRequestContext(final String str) {
        this.lookAheadTest.execute(new DefaultObserver<Boolean>() { // from class: id.dana.sendmoney.confirmation.SendMoneyConfirmationBankPresenter.3
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                SendMoneyConfirmationBankPresenter.getAuthRequestContext(SendMoneyConfirmationBankPresenter.this, str);
                SendMoneyConfirmationBankPresenter.this.scheduleImpl.BuiltInFictitiousFunctionClassFactory(((Boolean) obj).booleanValue());
            }
        });
    }

    static /* synthetic */ void getAuthRequestContext(SendMoneyConfirmationBankPresenter sendMoneyConfirmationBankPresenter, String str) {
        DecrementFreeTransferCount decrementFreeTransferCount = sendMoneyConfirmationBankPresenter.BuiltInFictitiousFunctionClassFactory;
        DisposableCompletableObserver disposableCompletableObserver = sendMoneyConfirmationBankPresenter.getAuthRequestContext;
        if (disposableCompletableObserver != null) {
            disposableCompletableObserver.dispose();
            sendMoneyConfirmationBankPresenter.getAuthRequestContext = null;
        }
        DisposableCompletableObserver disposableCompletableObserver2 = new DisposableCompletableObserver() { // from class: id.dana.sendmoney.confirmation.SendMoneyConfirmationBankPresenter.4
            @Override // io.reactivex.CompletableObserver
            public void onComplete() {
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SEND_MONEY_CONFIRMATION_TAG, th.getMessage(), th);
            }
        };
        sendMoneyConfirmationBankPresenter.getAuthRequestContext = disposableCompletableObserver2;
        decrementFreeTransferCount.execute(disposableCompletableObserver2, str);
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        DisposableCompletableObserver disposableCompletableObserver = this.getAuthRequestContext;
        if (disposableCompletableObserver != null) {
            disposableCompletableObserver.dispose();
            this.getAuthRequestContext = null;
        }
        ConfirmSendMoneyBank confirmSendMoneyBank = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (confirmSendMoneyBank != null) {
            confirmSendMoneyBank.dispose();
        }
        GetCheckoutH5Event getCheckoutH5Event = this.lookAheadTest;
        if (getCheckoutH5Event != null) {
            getCheckoutH5Event.dispose();
        }
        SaveRecentBank saveRecentBank = this.moveToNextValue;
        if (saveRecentBank != null) {
            saveRecentBank.dispose();
        }
    }
}
