package id.dana.sendmoney_v2.landing.contract;

import android.content.Context;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.iap.ac.android.acs.plugin.utils.Constants;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.core.ui.model.UiTextModel;
import id.dana.data.risk.riskevent.NetworkSendRiskEventEntityData;
import id.dana.domain.DefaultObserver;
import id.dana.domain.authcode.AuthCodeResult;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.sendmoney.interactor.GetFeatureSendMoneyCashierNative;
import id.dana.domain.sendmoney.interactor.GetIsUserCertifiedGlobalSend;
import id.dana.domain.sendmoney.interactor.InitTransferMoney;
import id.dana.domain.sendmoney.interactor.SaveIsUserCertifiedGlobalSend;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.domain.sendmoney.model.TransferInitParam;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.interactor.GetUserInfo;
import id.dana.model.SendMoneyScenarioModel;
import id.dana.sendmoney.domain.globalsend.interactor.InitGlobalTransferVerifyUser;
import id.dana.sendmoney.util.SendMoneyErrorHelper;
import id.dana.sendmoney_v2.landing.contract.KycAndDebitPayOptionContract;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002BO\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\u0012\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u0002J\b\u00102\u001a\u00020/H\u0016J\u0012\u00103\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u0002J\b\u0010\u0007\u001a\u00020/H\u0016J\u0012\u0010\u0013\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u0002J\u0014\u00104\u001a\u00020/2\n\b\u0002\u00100\u001a\u0004\u0018\u000101H\u0002J\b\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u00020/H\u0016J\u0012\u00108\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u0002J\u0012\u00109\u001a\u00020\u00172\b\u00100\u001a\u0004\u0018\u000101H\u0002J\u0012\u0010:\u001a\u00020\u00172\b\u00100\u001a\u0004\u0018\u000101H\u0002J\b\u0010;\u001a\u00020\u0017H\u0002J\b\u0010<\u001a\u00020/H\u0016J\u0010\u0010=\u001a\u00020/2\u0006\u0010>\u001a\u00020?H\u0016J\u0012\u0010\u0011\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u0002J\u0010\u0010@\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0016R$\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u001fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010&\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b'\u0010\u0019\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lid/dana/sendmoney_v2/landing/contract/SendMoneyHomePresenter;", "Lid/dana/sendmoney_v2/landing/contract/KycAndDebitPayOptionContract$Presenter;", "Lkotlinx/coroutines/CoroutineScope;", HummerConstants.CONTEXT, "Landroid/content/Context;", "initTransferMoney", "Lid/dana/domain/sendmoney/interactor/InitTransferMoney;", "getFeatureSendMoneyCashierNative", "Lid/dana/domain/sendmoney/interactor/GetFeatureSendMoneyCashierNative;", Constants.JS_API_GET_AUTH_CODE, "Lid/dana/domain/authcode/interactor/GetAuthCode;", "view", "Lid/dana/sendmoney_v2/landing/contract/KycAndDebitPayOptionContract$View;", "getUserInfo", "Lid/dana/domain/user/interactor/GetUserInfo;", "initGlobalTransferVerifyUser", "Lid/dana/sendmoney/domain/globalsend/interactor/InitGlobalTransferVerifyUser;", "saveIsUserCertifiedGlobalSend", "Lid/dana/domain/sendmoney/interactor/SaveIsUserCertifiedGlobalSend;", "getIsUserCertifiedGlobalSend", "Lid/dana/domain/sendmoney/interactor/GetIsUserCertifiedGlobalSend;", "(Landroid/content/Context;Lid/dana/domain/sendmoney/interactor/InitTransferMoney;Lid/dana/domain/sendmoney/interactor/GetFeatureSendMoneyCashierNative;Lid/dana/domain/authcode/interactor/GetAuthCode;Lid/dana/sendmoney_v2/landing/contract/KycAndDebitPayOptionContract$View;Lid/dana/domain/user/interactor/GetUserInfo;Lid/dana/sendmoney/domain/globalsend/interactor/InitGlobalTransferVerifyUser;Lid/dana/domain/sendmoney/interactor/SaveIsUserCertifiedGlobalSend;Lid/dana/domain/sendmoney/interactor/GetIsUserCertifiedGlobalSend;)V", "cashierEnabled", "", "getCashierEnabled$annotations", "()V", "getCashierEnabled", "()Z", "setCashierEnabled", "(Z)V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "defaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDefaultDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "hasKyc", "getHasKyc$annotations", "getHasKyc", "setHasKyc", "job", "Lkotlinx/coroutines/CompletableJob;", "transferInit", "Lid/dana/domain/sendmoney/model/TransferInit;", "checkKycAndPaymentOptions", "", "param", "", "checkKycLevel", "checkKycOnly", "getPayMethodTransfer", "getTransferInitParam", "Lid/dana/domain/sendmoney/model/TransferInitParam;", IAPSyncCommand.COMMAND_INIT, "initGlobalTransfer", "isSendMoneyGlobal", "isSendMoneyGroup", "isValidFamilyAccountPaymentOption", "onDestroy", "postAuthCode", "sendMoneyScenarioModel", "Lid/dana/model/SendMoneyScenarioModel;", "validateKycAndPaymentOption", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendMoneyHomePresenter implements KycAndDebitPayOptionContract.Presenter, CoroutineScope {
    private final Context BuiltInFictitiousFunctionClassFactory;
    private final InitTransferMoney DatabaseTableConfigUtil;
    private final KycAndDebitPayOptionContract.View GetContactSyncConfig;
    boolean KClassImpl$Data$declaredNonStaticMembers$2;
    boolean MyBillsEntityDataFactory;
    private final GetFeatureSendMoneyCashierNative NetworkUserEntityData$$ExternalSyntheticLambda0;
    private TransferInit NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final SaveIsUserCertifiedGlobalSend NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final CoroutineContext PlaceComponentResult;
    public final CoroutineDispatcher getAuthRequestContext;
    private final GetAuthCode getErrorConfigVersion;
    private final CompletableJob initRecordTimeStamp;
    private final InitGlobalTransferVerifyUser lookAheadTest;
    private final GetUserInfo moveToNextValue;
    private final GetIsUserCertifiedGlobalSend scheduleImpl;

    @Inject
    public SendMoneyHomePresenter(Context context, InitTransferMoney initTransferMoney, GetFeatureSendMoneyCashierNative getFeatureSendMoneyCashierNative, GetAuthCode getAuthCode, KycAndDebitPayOptionContract.View view, GetUserInfo getUserInfo, InitGlobalTransferVerifyUser initGlobalTransferVerifyUser, SaveIsUserCertifiedGlobalSend saveIsUserCertifiedGlobalSend, GetIsUserCertifiedGlobalSend getIsUserCertifiedGlobalSend) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(initTransferMoney, "");
        Intrinsics.checkNotNullParameter(getFeatureSendMoneyCashierNative, "");
        Intrinsics.checkNotNullParameter(getAuthCode, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getUserInfo, "");
        Intrinsics.checkNotNullParameter(initGlobalTransferVerifyUser, "");
        Intrinsics.checkNotNullParameter(saveIsUserCertifiedGlobalSend, "");
        Intrinsics.checkNotNullParameter(getIsUserCertifiedGlobalSend, "");
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.DatabaseTableConfigUtil = initTransferMoney;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = getFeatureSendMoneyCashierNative;
        this.getErrorConfigVersion = getAuthCode;
        this.GetContactSyncConfig = view;
        this.moveToNextValue = getUserInfo;
        this.lookAheadTest = initGlobalTransferVerifyUser;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = saveIsUserCertifiedGlobalSend;
        this.scheduleImpl = getIsUserCertifiedGlobalSend;
        CoroutineDispatcher io2 = Dispatchers.getIO();
        this.getAuthRequestContext = io2;
        CompletableJob Job$default = JobKt.Job$default(null, 1, null);
        this.initRecordTimeStamp = Job$default;
        this.PlaceComponentResult = Job$default.plus(io2);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @JvmName(name = "getCoroutineContext")
    public final CoroutineContext getCoroutineContext() {
        return this.PlaceComponentResult;
    }

    @Override // id.dana.sendmoney_v2.landing.contract.KycAndDebitPayOptionContract.Presenter
    public final void getAuthRequestContext(final SendMoneyScenarioModel sendMoneyScenarioModel) {
        Intrinsics.checkNotNullParameter(sendMoneyScenarioModel, "");
        this.getErrorConfigVersion.execute(GetAuthCode.Params.INSTANCE.forGetAuthCode(sendMoneyScenarioModel.NetworkUserEntityData$$ExternalSyntheticLambda3, sendMoneyScenarioModel.PlaceComponentResult, sendMoneyScenarioModel.NetworkUserEntityData$$ExternalSyntheticLambda4, true), new Function1<AuthCodeResult, Unit>() { // from class: id.dana.sendmoney_v2.landing.contract.SendMoneyHomePresenter$postAuthCode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(AuthCodeResult authCodeResult) {
                invoke2(authCodeResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(AuthCodeResult authCodeResult) {
                KycAndDebitPayOptionContract.View view;
                Intrinsics.checkNotNullParameter(authCodeResult, "");
                view = SendMoneyHomePresenter.this.GetContactSyncConfig;
                view.getAuthRequestContext(sendMoneyScenarioModel.NetworkUserEntityData$$ExternalSyntheticLambda3, authCodeResult.getAuthCode());
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney_v2.landing.contract.SendMoneyHomePresenter$postAuthCode$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                KycAndDebitPayOptionContract.View view;
                Context context;
                KycAndDebitPayOptionContract.View view2;
                Context context2;
                Intrinsics.checkNotNullParameter(th, "");
                view = SendMoneyHomePresenter.this.GetContactSyncConfig;
                SendMoneyErrorHelper sendMoneyErrorHelper = SendMoneyErrorHelper.INSTANCE;
                UiTextModel uiTextModel = SendMoneyErrorHelper.BuiltInFictitiousFunctionClassFactory(th).BuiltInFictitiousFunctionClassFactory;
                context = SendMoneyHomePresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.BuiltInFictitiousFunctionClassFactory(th, TrackerDataKey.NetworkErrorOperationTypeProperty.GET_AUTH_CODE, uiTextModel.asString(context), TrackerDataKey.Source.SEND_MONEY_LANDING_PAGE);
                view2 = SendMoneyHomePresenter.this.GetContactSyncConfig;
                SendMoneyErrorHelper sendMoneyErrorHelper2 = SendMoneyErrorHelper.INSTANCE;
                UiTextModel uiTextModel2 = SendMoneyErrorHelper.BuiltInFictitiousFunctionClassFactory(th).BuiltInFictitiousFunctionClassFactory;
                context2 = SendMoneyHomePresenter.this.BuiltInFictitiousFunctionClassFactory;
                view2.KClassImpl$Data$declaredNonStaticMembers$2(uiTextModel2.asString(context2));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final Object obj) {
        InitTransferMoney initTransferMoney = this.DatabaseTableConfigUtil;
        DefaultObserver<TransferInit> defaultObserver = new DefaultObserver<TransferInit>() { // from class: id.dana.sendmoney_v2.landing.contract.SendMoneyHomePresenter$getPayMethodTransfer$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj2) {
                KycAndDebitPayOptionContract.View view;
                TransferInit transferInit = (TransferInit) obj2;
                Intrinsics.checkNotNullParameter(transferInit, "");
                SendMoneyHomePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1 = transferInit;
                Object obj3 = obj;
                if (obj3 != null) {
                    SendMoneyHomePresenter.this.MyBillsEntityDataFactory(obj3);
                }
                view = SendMoneyHomePresenter.this.GetContactSyncConfig;
                view.getAuthRequestContext(transferInit);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                KycAndDebitPayOptionContract.View view;
                Context context;
                KycAndDebitPayOptionContract.View view2;
                Context context2;
                Intrinsics.checkNotNullParameter(p0, "");
                if (obj != null) {
                    view2 = SendMoneyHomePresenter.this.GetContactSyncConfig;
                    SendMoneyErrorHelper sendMoneyErrorHelper = SendMoneyErrorHelper.INSTANCE;
                    UiTextModel uiTextModel = SendMoneyErrorHelper.BuiltInFictitiousFunctionClassFactory(p0).BuiltInFictitiousFunctionClassFactory;
                    context2 = SendMoneyHomePresenter.this.BuiltInFictitiousFunctionClassFactory;
                    view2.onError(uiTextModel.asString(context2));
                }
                view = SendMoneyHomePresenter.this.GetContactSyncConfig;
                SendMoneyErrorHelper sendMoneyErrorHelper2 = SendMoneyErrorHelper.INSTANCE;
                UiTextModel uiTextModel2 = SendMoneyErrorHelper.BuiltInFictitiousFunctionClassFactory(p0).BuiltInFictitiousFunctionClassFactory;
                context = SendMoneyHomePresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.BuiltInFictitiousFunctionClassFactory(p0, TrackerDataKey.NetworkErrorOperationTypeProperty.BIZTRANSFER_INIT, uiTextModel2.asString(context), TrackerDataKey.Source.SEND_MONEY_LANDING_PAGE);
            }
        };
        TransferInitParam transferInitParam = new TransferInitParam();
        transferInitParam.setTransferMethod("BANK_TRANSFER");
        transferInitParam.setNeedTransferMethod(true);
        transferInitParam.setNeedPayMethod(true ^ this.KClassImpl$Data$declaredNonStaticMembers$2);
        transferInitParam.setVersion("2.0");
        initTransferMoney.execute(defaultObserver, InitTransferMoney.Params.forSendMoneyInit(transferInitParam));
    }

    @Override // id.dana.sendmoney_v2.landing.contract.KycAndDebitPayOptionContract.Presenter
    public final void getAuthRequestContext(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "");
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1 != null) {
            MyBillsEntityDataFactory(obj);
        } else {
            KClassImpl$Data$declaredNonStaticMembers$2(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void MyBillsEntityDataFactory(Object obj) {
        if (scheduleImpl(obj)) {
            PlaceComponentResult(obj);
            return;
        }
        if (!MyBillsEntityDataFactory() || getErrorConfigVersion(obj)) {
            TransferInit transferInit = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            TransferInit transferInit2 = null;
            if (transferInit == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                transferInit = null;
            }
            if (!SendMoneyHomePresenterKt.MyBillsEntityDataFactory(transferInit)) {
                TransferInit transferInit3 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                if (transferInit3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    transferInit2 = transferInit3;
                }
                if (!SendMoneyHomePresenterKt.PlaceComponentResult(transferInit2)) {
                    this.GetContactSyncConfig.getAuthRequestContext();
                    return;
                }
            }
        }
        this.GetContactSyncConfig.PlaceComponentResult(obj);
    }

    private final void PlaceComponentResult(Object obj) {
        TransferInit transferInit = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (transferInit == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            transferInit = null;
        }
        if (SendMoneyHomePresenterKt.MyBillsEntityDataFactory(transferInit)) {
            BuiltInFictitiousFunctionClassFactory(obj);
        } else {
            this.GetContactSyncConfig.getAuthRequestContext();
        }
    }

    private static boolean getErrorConfigVersion(Object obj) {
        return (obj instanceof SendMoneyScenarioModel) && Intrinsics.areEqual(((SendMoneyScenarioModel) obj).KClassImpl$Data$declaredNonStaticMembers$2, "group");
    }

    private static boolean scheduleImpl(Object obj) {
        return (obj instanceof SendMoneyScenarioModel) && Intrinsics.areEqual(((SendMoneyScenarioModel) obj).KClassImpl$Data$declaredNonStaticMembers$2, "globalTransfer");
    }

    private final boolean MyBillsEntityDataFactory() {
        if (this.MyBillsEntityDataFactory) {
            TransferInit transferInit = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (transferInit == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                transferInit = null;
            }
            if (SendMoneyHomePresenterKt.KClassImpl$Data$declaredNonStaticMembers$2(transferInit)) {
                return true;
            }
        }
        return false;
    }

    private final void BuiltInFictitiousFunctionClassFactory(final Object obj) {
        BaseUseCase.execute$default(this.scheduleImpl, NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.sendmoney_v2.landing.contract.SendMoneyHomePresenter$getIsUserCertifiedGlobalSend$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                KycAndDebitPayOptionContract.View view;
                if (z) {
                    view = SendMoneyHomePresenter.this.GetContactSyncConfig;
                    view.PlaceComponentResult(obj);
                    return;
                }
                BuildersKt.launch$default(r2, null, null, new SendMoneyHomePresenter$initGlobalTransfer$1(SendMoneyHomePresenter.this, obj, null), 3, null);
            }
        }, null, 4, null);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.DatabaseTableConfigUtil.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
        this.moveToNextValue.dispose();
        this.getErrorConfigVersion.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.dispose();
        this.scheduleImpl.dispose();
        Job.DefaultImpls.cancel$default(this.initRecordTimeStamp, null, 1, null);
    }

    @Override // id.dana.sendmoney_v2.landing.contract.KycAndDebitPayOptionContract.Presenter
    public final void PlaceComponentResult() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.execute(NoParams.INSTANCE, new Function1<List<? extends String>, Unit>() { // from class: id.dana.sendmoney_v2.landing.contract.SendMoneyHomePresenter$getFeatureSendMoneyCashierNative$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
                invoke2((List<String>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<String> list) {
                Intrinsics.checkNotNullParameter(list, "");
                SendMoneyHomePresenter.this.MyBillsEntityDataFactory = !list.isEmpty();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney_v2.landing.contract.SendMoneyHomePresenter$getFeatureSendMoneyCashierNative$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.TAG.SEND_MONEY_TAG);
                sb.append(SendMoneyHomePresenter.this.getClass().getName());
                sb.append(":onErrorGetSplitConfig");
                sb.append(th);
                DanaLog.BuiltInFictitiousFunctionClassFactory(NetworkSendRiskEventEntityData.TAG, sb.toString());
            }
        });
        this.moveToNextValue.execute(new GetUserInfo.Param(false), new Function1<UserInfoResponse, Unit>() { // from class: id.dana.sendmoney_v2.landing.contract.SendMoneyHomePresenter$checkKycLevel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(UserInfoResponse userInfoResponse) {
                invoke2(userInfoResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UserInfoResponse userInfoResponse) {
                Intrinsics.checkNotNullParameter(userInfoResponse, "");
                if (StringsKt.equals$default(userInfoResponse.getKycInfo(), "KYC2", false, 2, null)) {
                    SendMoneyHomePresenter.this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                }
                SendMoneyHomePresenter.this.KClassImpl$Data$declaredNonStaticMembers$2((Object) null);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney_v2.landing.contract.SendMoneyHomePresenter$checkKycLevel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                SendMoneyHomePresenter.this.KClassImpl$Data$declaredNonStaticMembers$2((Object) null);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.GET_USER_INFO_EXCEPTION, th.toString());
            }
        });
    }
}
